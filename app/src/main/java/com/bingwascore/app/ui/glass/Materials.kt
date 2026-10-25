package com.bingwascore.app.ui.glass

import android.graphics.Paint
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.composed
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Matrix
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.IosMaterialFill
import com.bingwascore.app.ui.theme.isPorcelain

/**
 * Paint.setRenderEffect exists only on API31+ jars/devices; resolved reflectively
 * once so the engine compiles against older stubs and never touches it below 31.
 */
private val paintSetRenderEffect: java.lang.reflect.Method? by lazy {
    runCatching {
        Paint::class.java.getMethod("setRenderEffect", android.graphics.RenderEffect::class.java)
    }.getOrNull()
}

/**
 * Stage 18 — iOS 27 material engine.
 *
 * True backdrop blur: [glassSource] wraps the BACKDROP content (the screens)
 * and replays it once per registered chrome region inside a saveLayer whose
 * Paint carries a RenderEffect chain — transactions scrolling under the pill
 * really appear blurred and moving behind it.
 *
 * Layer order back→front (Apple's in-blur recipe):
 *   L1 blur(24dp) of the content behind — saveLayer + RenderEffect blur, API31+.
 *   L2 vibrancy tint — accent at 8–12% alpha, drawn INSIDE the blur layer.
 *   L3 ColorMatrix saturation 1.2 + contrast 1.1 on the blurred layer.
 *   L4 content — the chrome surface ([iosMaterial] consumer) draws on top.
 *
 * Perf guard: chrome surfaces only (pill, drawer, sheets, top bars); never in
 * list items; never nested (region passes suspend while a modal owns the
 * backdrop); radius ≤28dp; regions skip their pass when offscreen.
 * API <31: layered scrim tint, no blur.
 */

/** Compose-only vibrancy tint (kept out of MaterialSpec so JVM tests stay pure). */
@Composable
internal fun materialVibrancyTint(): Color = AccentBlue.copy(alpha = MaterialSpec.VIBRANCY_ALPHA)

/** True when the running device can render the real backdrop-blur chain. */
val canMaterialBlur: Boolean get() = MaterialSpec.canBlur(Build.VERSION.SDK_INT)

/** A chrome region that wants backdrop blur, in ROOT coordinates. */
internal data class GlassRegion(val rootBounds: Rect, val shape: Shape, val size: IntSize)

/**
 * Shared backdrop registry: chrome surfaces register their bounds; the
 * [glassSource] recorder draws one blur pass per live region. [modalDepth]
 * suspends region passes while a modal owns the backdrop, so blurs never nest.
 */
@Stable
class GlassBackdropState {
    internal val regions = mutableStateMapOf<String, GlassRegion>()
    internal var recorderRoot by mutableStateOf(Offset.Zero)
    var modalDepth by mutableIntStateOf(0)
        internal set

    internal fun setRegion(id: String, rootBounds: Rect, shape: Shape, size: IntSize) {
        regions[id] = GlassRegion(rootBounds, shape, size)
    }

    internal fun removeRegion(id: String) {
        regions.remove(id)
    }

    /** A modal owns the backdrop: region passes stand down (no nested blurs). */
    fun pushModal() {
        modalDepth++
    }

    fun popModal() {
        modalDepth = (modalDepth - 1).coerceAtLeast(0)
    }
}

@Composable
fun rememberGlassBackdrop(): GlassBackdropState = remember { GlassBackdropState() }

/** Root-level backdrop state for the app shell (null outside the shell = no-op). */
val LocalGlassBackdrop = staticCompositionLocalOf<GlassBackdropState?> { null }

/**
 * The recorder: wrap the BACKDROP content (screens). Chrome (pill, drawer)
 * sits OUTSIDE this node so the replay stays sharp outside the regions.
 */
fun Modifier.glassSource(state: GlassBackdropState): Modifier = this.composed {
    // Modal blur: the whole backdrop blurs behind sheets (iOS-style) and the
    // region passes stand down — one blur surface, never nested.
    val modalBlurActive = state.modalDepth > 0 && canMaterialBlur
    val vibrancyTint = materialVibrancyTint()
    var m: Modifier = this
        .onGloballyPositioned { state.recorderRoot = it.positionInRoot() }
        .drawWithContent {
            // Sharp backdrop everywhere outside chrome regions.
            drawContent()
            if (!canMaterialBlur) return@drawWithContent
            if (state.modalDepth > 0) return@drawWithContent
            if (state.regions.isEmpty()) return@drawWithContent
            val radiusPx = MaterialSpec.BLUR_DP.dp.toPx()
            val androidPaint = Paint(Paint.ANTI_ALIAS_FLAG)
            // L1 — blur of the content behind (Apple's in-blur recipe base).
            val blurFx = android.graphics.RenderEffect.createBlurEffect(
                radiusPx, radiusPx, android.graphics.Shader.TileMode.CLAMP
            )
            val canvas = drawContext.canvas.nativeCanvas
            val recorder = state.recorderRoot
            val viewport = size
            for (region in state.regions.values.toList()) {
                val local = Rect(
                    region.rootBounds.left - recorder.x,
                    region.rootBounds.top - recorder.y,
                    region.rootBounds.right - recorder.x,
                    region.rootBounds.bottom - recorder.y
                )
                // Perf guard — offscreen/closed regions cost nothing.
                if (local.right < 0f || local.bottom < 0f ||
                    local.left > viewport.width || local.top > viewport.height
                ) continue
                val outline = region.shape.createOutline(
                    Size(region.size.width.toFloat(), region.size.height.toFloat()),
                    layoutDirection, this@drawWithContent
                )
                val path = Path()
                when (outline) {
                    is Outline.Rounded -> path.addRoundRect(outline.roundRect)
                    is Outline.Rectangle -> path.addRect(outline.rect)
                    is Outline.Generic -> path.addPath(outline.path)
                }
                path.transform(Matrix().apply { translate(local.left, local.top) })
                val stack = canvas.save()
                canvas.clipPath(path.asAndroidPath())
                canvas.saveLayer(
                    local.left - radiusPx, local.top - radiusPx,
                    local.right + radiusPx, local.bottom + radiusPx,
                    androidPaint
                )
                drawContent()
                // L2 — vibrancy: accent at 8–12% alpha over the blurred region.
                drawRect(
                    vibrancyTint,
                    topLeft = Offset(local.left - radiusPx, local.top - radiusPx),
                    size = Size(local.width + 2 * radiusPx, local.height + 2 * radiusPx)
                )
                // L3 — saturation 1.2 + contrast 1.1 on the blurred layer.
                val matrixFx = android.graphics.RenderEffect.createColorFilterEffect(
                    android.graphics.ColorMatrixColorFilter(
                        android.graphics.ColorMatrix(MaterialSpec.colorMatrix())
                    )
                )
                paintSetRenderEffect?.invoke(
                    androidPaint,
                    android.graphics.RenderEffect.createChainEffect(matrixFx, blurFx)
                )
                canvas.restoreToCount(stack)
            }
        }
    if (modalBlurActive) m = m.blur(MaterialSpec.BLUR_DP.dp)
    m
}

/**
 * Register a chrome surface as a backdrop region (id-keyed; drops out of the
 * recorder's pass list the moment it is disabled or leaves the tree).
 */
fun Modifier.glassBackdropRegion(
    state: GlassBackdropState?,
    id: String,
    shape: Shape,
    enabled: Boolean = true
): Modifier {
    if (state == null) return this
    return this.onGloballyPositioned { coords ->
        if (!enabled) {
            state.removeRegion(id)
        } else {
            val origin = coords.positionInRoot()
            state.setRegion(
                id,
                Rect(
                    origin.x, origin.y,
                    origin.x + coords.size.width, origin.y + coords.size.height
                ),
                shape,
                coords.size
            )
        }
    }
}

/**
 * L4 — chrome glass fill: translucent scrim tint + vibrancy fallback (API<31,
 * or surfaces with no backdrop region) + hairline border. Content drawn by the
 * caller sits on top; backdrop blur comes from [glassSource] below.
 */
/**
 * Stage 26 — Frosted Glass modifier applying [GlassSpec] tokens:
 * - Scrim fill (alpha 0.62 for Obsidian, 0.55 white frost for Porcelain Dim)
 * - Outer shadow (elevation 12dp, radius 24dp, alpha 0.35)
 * - 1dp inner top border highlight (white 10%)
 */
@Composable
fun Modifier.frostedGlass(
    shape: Shape = RoundedCornerShape(16.dp)
): Modifier {
    val isPorcelainTheme = isPorcelain
    val scrim = GlassSpec.scrimColor(isPorcelainTheme)
    val highlight = GlassSpec.innerTopHighlightColor()

    return this
        .shadow(
            elevation = GlassSpec.OUTER_SHADOW_ELEVATION,
            shape = shape,
            spotColor = Color.Black.copy(alpha = GlassSpec.OUTER_SHADOW_ALPHA),
            ambientColor = Color.Black.copy(alpha = GlassSpec.OUTER_SHADOW_ALPHA)
        )
        .clip(shape)
        .background(scrim)
        .border(
            width = GlassSpec.INNER_TOP_HIGHLIGHT_WIDTH,
            brush = Brush.verticalGradient(
                colors = listOf(highlight, Color.Transparent)
            ),
            shape = shape
        )
}

/**
 * L4 — chrome glass fill: translucent scrim tint + vibrancy fallback (API<31,
 * or surfaces with no backdrop region) + 1dp top highlight + outer shadow.
 */
@Composable
fun Modifier.iosMaterial(
    shape: Shape,
    tint: Color = GlassSpec.scrimColor(isPorcelain),
    vibrancy: Boolean = true
): Modifier {
    var m = this
        .shadow(
            elevation = GlassSpec.OUTER_SHADOW_ELEVATION,
            shape = shape,
            spotColor = Color.Black.copy(alpha = GlassSpec.OUTER_SHADOW_ALPHA),
            ambientColor = Color.Black.copy(alpha = GlassSpec.OUTER_SHADOW_ALPHA)
        )
        .clip(shape)
        .background(tint)
    if (vibrancy) m = m.background(materialVibrancyTint(), shape)
    return m.border(
        width = GlassSpec.INNER_TOP_HIGHLIGHT_WIDTH,
        brush = Brush.verticalGradient(
            colors = listOf(GlassSpec.innerTopHighlightColor(), Color.Transparent)
        ),
        shape = shape
    )
}


