package com.bingwascore.app.ui.components

import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.vector.PathParser

/**
 * REBRAND R1 — the Bingwa Score monogram.
 *
 * One continuous extra-bold script stroke: a cursive "B" that flows straight
 * into an "S" loop and finishes on an upward checkmark flick. It is the same
 * geometry as `res/drawable/ic_launcher_foreground.xml`, kept as [DATA] so the
 * splash and the launcher icon can never drift apart.
 */
object Monogram {

    /** SVG path data, drawn on a 108x108 grid inside the 72dp adaptive safe zone. */
    const val DATA: String =
        "M42,74 C45,62 43,48 41,34 C40,26 51,24 56,29 C61,35 55,43 46,45 " +
            "C57,44 66,48 67,58 C68,67 59,75 49,74 C58,72 64,66 65,57 " +
            "C66,50 61,45 65,42 C69,38 73,42 73,47 C73,50 72,52 74,53 " +
            "C77,52 78,47 80,40 C82,35 83,32 84,30"

    /** Stroke weight on the 108-unit grid — extra bold. */
    const val STROKE_WIDTH: Float = 11f

    /** Parsed once; the splash trims a copy of it every frame. */
    val path: Path by lazy { PathParser().parsePathString(DATA).toPath() }
}