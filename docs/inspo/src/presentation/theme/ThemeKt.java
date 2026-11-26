package com.example.bingwahybrid.presentation.theme;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.DynamicTonalPaletteKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Theme.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"lightScheme", "Landroidx/compose/material3/ColorScheme;", "darkScheme", "mediumContrastLightColorScheme", "highContrastLightColorScheme", "mediumContrastDarkColorScheme", "highContrastDarkColorScheme", "unspecified_scheme", "Lcom/example/bingwahybrid/presentation/theme/ColorFamily;", "getUnspecified_scheme", "()Lcom/example/bingwahybrid/presentation/theme/ColorFamily;", "BingwaHybridTheme", "", "darkTheme", "", "dynamicColor", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ThemeKt {
    private static final ColorScheme darkScheme;
    private static final ColorScheme highContrastDarkColorScheme;
    private static final ColorScheme highContrastLightColorScheme;
    private static final ColorScheme lightScheme;
    private static final ColorScheme mediumContrastDarkColorScheme;
    private static final ColorScheme mediumContrastLightColorScheme;
    private static final ColorFamily unspecified_scheme;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BingwaHybridTheme$lambda$2(boolean z, boolean z2, Function2 function2, int i, int i2, Composer composer, int i3) {
        BingwaHybridTheme(z, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static {
        long primaryLight = ColorKt.getPrimaryLight();
        long onPrimaryLight = ColorKt.getOnPrimaryLight();
        long primaryContainerLight = ColorKt.getPrimaryContainerLight();
        long onPrimaryContainerLight = ColorKt.getOnPrimaryContainerLight();
        long secondaryLight = ColorKt.getSecondaryLight();
        long onSecondaryLight = ColorKt.getOnSecondaryLight();
        long secondaryContainerLight = ColorKt.getSecondaryContainerLight();
        long onSecondaryContainerLight = ColorKt.getOnSecondaryContainerLight();
        long tertiaryLight = ColorKt.getTertiaryLight();
        long onTertiaryLight = ColorKt.getOnTertiaryLight();
        long tertiaryContainerLight = ColorKt.getTertiaryContainerLight();
        long onTertiaryContainerLight = ColorKt.getOnTertiaryContainerLight();
        long errorLight = ColorKt.getErrorLight();
        long onErrorLight = ColorKt.getOnErrorLight();
        long errorContainerLight = ColorKt.getErrorContainerLight();
        long onErrorContainerLight = ColorKt.getOnErrorContainerLight();
        long backgroundLight = ColorKt.getBackgroundLight();
        long onBackgroundLight = ColorKt.getOnBackgroundLight();
        long surfaceLight = ColorKt.getSurfaceLight();
        long onSurfaceLight = ColorKt.getOnSurfaceLight();
        long surfaceVariantLight = ColorKt.getSurfaceVariantLight();
        long onSurfaceVariantLight = ColorKt.getOnSurfaceVariantLight();
        long outlineLight = ColorKt.getOutlineLight();
        long outlineVariantLight = ColorKt.getOutlineVariantLight();
        long scrimLight = ColorKt.getScrimLight();
        long inverseSurfaceLight = ColorKt.getInverseSurfaceLight();
        long inverseOnSurfaceLight = ColorKt.getInverseOnSurfaceLight();
        long inversePrimaryLight = ColorKt.getInversePrimaryLight();
        long surfaceDimLight = ColorKt.getSurfaceDimLight();
        long surfaceBrightLight = ColorKt.getSurfaceBrightLight();
        long surfaceContainerLowestLight = ColorKt.getSurfaceContainerLowestLight();
        lightScheme = ColorSchemeKt.m2838lightColorScheme_VG5OTI$default(primaryLight, onPrimaryLight, primaryContainerLight, onPrimaryContainerLight, inversePrimaryLight, secondaryLight, onSecondaryLight, secondaryContainerLight, onSecondaryContainerLight, tertiaryLight, onTertiaryLight, tertiaryContainerLight, onTertiaryContainerLight, backgroundLight, onBackgroundLight, surfaceLight, onSurfaceLight, surfaceVariantLight, onSurfaceVariantLight, 0L, inverseSurfaceLight, inverseOnSurfaceLight, errorLight, onErrorLight, errorContainerLight, onErrorContainerLight, outlineLight, outlineVariantLight, scrimLight, surfaceBrightLight, ColorKt.getSurfaceContainerLight(), ColorKt.getSurfaceContainerHighLight(), ColorKt.getSurfaceContainerHighestLight(), ColorKt.getSurfaceContainerLowLight(), surfaceContainerLowestLight, surfaceDimLight, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 524288, 65520, null);
        long primaryDark = ColorKt.getPrimaryDark();
        long onPrimaryDark = ColorKt.getOnPrimaryDark();
        long primaryContainerDark = ColorKt.getPrimaryContainerDark();
        long onPrimaryContainerDark = ColorKt.getOnPrimaryContainerDark();
        long secondaryDark = ColorKt.getSecondaryDark();
        long onSecondaryDark = ColorKt.getOnSecondaryDark();
        long secondaryContainerDark = ColorKt.getSecondaryContainerDark();
        long onSecondaryContainerDark = ColorKt.getOnSecondaryContainerDark();
        long tertiaryDark = ColorKt.getTertiaryDark();
        long onTertiaryDark = ColorKt.getOnTertiaryDark();
        long tertiaryContainerDark = ColorKt.getTertiaryContainerDark();
        long onTertiaryContainerDark = ColorKt.getOnTertiaryContainerDark();
        long errorDark = ColorKt.getErrorDark();
        long onErrorDark = ColorKt.getOnErrorDark();
        long errorContainerDark = ColorKt.getErrorContainerDark();
        long onErrorContainerDark = ColorKt.getOnErrorContainerDark();
        long backgroundDark = ColorKt.getBackgroundDark();
        long onBackgroundDark = ColorKt.getOnBackgroundDark();
        long surfaceDark = ColorKt.getSurfaceDark();
        long onSurfaceDark = ColorKt.getOnSurfaceDark();
        long surfaceVariantDark = ColorKt.getSurfaceVariantDark();
        long onSurfaceVariantDark = ColorKt.getOnSurfaceVariantDark();
        long outlineDark = ColorKt.getOutlineDark();
        long outlineVariantDark = ColorKt.getOutlineVariantDark();
        long scrimDark = ColorKt.getScrimDark();
        long inverseSurfaceDark = ColorKt.getInverseSurfaceDark();
        long inverseOnSurfaceDark = ColorKt.getInverseOnSurfaceDark();
        long inversePrimaryDark = ColorKt.getInversePrimaryDark();
        long surfaceDimDark = ColorKt.getSurfaceDimDark();
        long surfaceBrightDark = ColorKt.getSurfaceBrightDark();
        long surfaceContainerLowestDark = ColorKt.getSurfaceContainerLowestDark();
        darkScheme = ColorSchemeKt.m2832darkColorScheme_VG5OTI$default(primaryDark, onPrimaryDark, primaryContainerDark, onPrimaryContainerDark, inversePrimaryDark, secondaryDark, onSecondaryDark, secondaryContainerDark, onSecondaryContainerDark, tertiaryDark, onTertiaryDark, tertiaryContainerDark, onTertiaryContainerDark, backgroundDark, onBackgroundDark, surfaceDark, onSurfaceDark, surfaceVariantDark, onSurfaceVariantDark, 0L, inverseSurfaceDark, inverseOnSurfaceDark, errorDark, onErrorDark, errorContainerDark, onErrorContainerDark, outlineDark, outlineVariantDark, scrimDark, surfaceBrightDark, ColorKt.getSurfaceContainerDark(), ColorKt.getSurfaceContainerHighDark(), ColorKt.getSurfaceContainerHighestDark(), ColorKt.getSurfaceContainerLowDark(), surfaceContainerLowestDark, surfaceDimDark, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 524288, 65520, null);
        long primaryLightMediumContrast = ColorKt.getPrimaryLightMediumContrast();
        long onPrimaryLightMediumContrast = ColorKt.getOnPrimaryLightMediumContrast();
        long primaryContainerLightMediumContrast = ColorKt.getPrimaryContainerLightMediumContrast();
        long onPrimaryContainerLightMediumContrast = ColorKt.getOnPrimaryContainerLightMediumContrast();
        long secondaryLightMediumContrast = ColorKt.getSecondaryLightMediumContrast();
        long onSecondaryLightMediumContrast = ColorKt.getOnSecondaryLightMediumContrast();
        long secondaryContainerLightMediumContrast = ColorKt.getSecondaryContainerLightMediumContrast();
        long onSecondaryContainerLightMediumContrast = ColorKt.getOnSecondaryContainerLightMediumContrast();
        long tertiaryLightMediumContrast = ColorKt.getTertiaryLightMediumContrast();
        long onTertiaryLightMediumContrast = ColorKt.getOnTertiaryLightMediumContrast();
        long tertiaryContainerLightMediumContrast = ColorKt.getTertiaryContainerLightMediumContrast();
        long onTertiaryContainerLightMediumContrast = ColorKt.getOnTertiaryContainerLightMediumContrast();
        long errorLightMediumContrast = ColorKt.getErrorLightMediumContrast();
        long onErrorLightMediumContrast = ColorKt.getOnErrorLightMediumContrast();
        long errorContainerLightMediumContrast = ColorKt.getErrorContainerLightMediumContrast();
        long onErrorContainerLightMediumContrast = ColorKt.getOnErrorContainerLightMediumContrast();
        long backgroundLightMediumContrast = ColorKt.getBackgroundLightMediumContrast();
        long onBackgroundLightMediumContrast = ColorKt.getOnBackgroundLightMediumContrast();
        long surfaceLightMediumContrast = ColorKt.getSurfaceLightMediumContrast();
        long onSurfaceLightMediumContrast = ColorKt.getOnSurfaceLightMediumContrast();
        long surfaceVariantLightMediumContrast = ColorKt.getSurfaceVariantLightMediumContrast();
        long onSurfaceVariantLightMediumContrast = ColorKt.getOnSurfaceVariantLightMediumContrast();
        long outlineLightMediumContrast = ColorKt.getOutlineLightMediumContrast();
        long outlineVariantLightMediumContrast = ColorKt.getOutlineVariantLightMediumContrast();
        long scrimLightMediumContrast = ColorKt.getScrimLightMediumContrast();
        long inverseSurfaceLightMediumContrast = ColorKt.getInverseSurfaceLightMediumContrast();
        long inverseOnSurfaceLightMediumContrast = ColorKt.getInverseOnSurfaceLightMediumContrast();
        long inversePrimaryLightMediumContrast = ColorKt.getInversePrimaryLightMediumContrast();
        long surfaceDimLightMediumContrast = ColorKt.getSurfaceDimLightMediumContrast();
        long surfaceBrightLightMediumContrast = ColorKt.getSurfaceBrightLightMediumContrast();
        long surfaceContainerLowestLightMediumContrast = ColorKt.getSurfaceContainerLowestLightMediumContrast();
        mediumContrastLightColorScheme = ColorSchemeKt.m2838lightColorScheme_VG5OTI$default(primaryLightMediumContrast, onPrimaryLightMediumContrast, primaryContainerLightMediumContrast, onPrimaryContainerLightMediumContrast, inversePrimaryLightMediumContrast, secondaryLightMediumContrast, onSecondaryLightMediumContrast, secondaryContainerLightMediumContrast, onSecondaryContainerLightMediumContrast, tertiaryLightMediumContrast, onTertiaryLightMediumContrast, tertiaryContainerLightMediumContrast, onTertiaryContainerLightMediumContrast, backgroundLightMediumContrast, onBackgroundLightMediumContrast, surfaceLightMediumContrast, onSurfaceLightMediumContrast, surfaceVariantLightMediumContrast, onSurfaceVariantLightMediumContrast, 0L, inverseSurfaceLightMediumContrast, inverseOnSurfaceLightMediumContrast, errorLightMediumContrast, onErrorLightMediumContrast, errorContainerLightMediumContrast, onErrorContainerLightMediumContrast, outlineLightMediumContrast, outlineVariantLightMediumContrast, scrimLightMediumContrast, surfaceBrightLightMediumContrast, ColorKt.getSurfaceContainerLightMediumContrast(), ColorKt.getSurfaceContainerHighLightMediumContrast(), ColorKt.getSurfaceContainerHighestLightMediumContrast(), ColorKt.getSurfaceContainerLowLightMediumContrast(), surfaceContainerLowestLightMediumContrast, surfaceDimLightMediumContrast, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 524288, 65520, null);
        long primaryLightHighContrast = ColorKt.getPrimaryLightHighContrast();
        long onPrimaryLightHighContrast = ColorKt.getOnPrimaryLightHighContrast();
        long primaryContainerLightHighContrast = ColorKt.getPrimaryContainerLightHighContrast();
        long onPrimaryContainerLightHighContrast = ColorKt.getOnPrimaryContainerLightHighContrast();
        long secondaryLightHighContrast = ColorKt.getSecondaryLightHighContrast();
        long onSecondaryLightHighContrast = ColorKt.getOnSecondaryLightHighContrast();
        long secondaryContainerLightHighContrast = ColorKt.getSecondaryContainerLightHighContrast();
        long onSecondaryContainerLightHighContrast = ColorKt.getOnSecondaryContainerLightHighContrast();
        long tertiaryLightHighContrast = ColorKt.getTertiaryLightHighContrast();
        long onTertiaryLightHighContrast = ColorKt.getOnTertiaryLightHighContrast();
        long tertiaryContainerLightHighContrast = ColorKt.getTertiaryContainerLightHighContrast();
        long onTertiaryContainerLightHighContrast = ColorKt.getOnTertiaryContainerLightHighContrast();
        long errorLightHighContrast = ColorKt.getErrorLightHighContrast();
        long onErrorLightHighContrast = ColorKt.getOnErrorLightHighContrast();
        long errorContainerLightHighContrast = ColorKt.getErrorContainerLightHighContrast();
        long onErrorContainerLightHighContrast = ColorKt.getOnErrorContainerLightHighContrast();
        long backgroundLightHighContrast = ColorKt.getBackgroundLightHighContrast();
        long onBackgroundLightHighContrast = ColorKt.getOnBackgroundLightHighContrast();
        long surfaceLightHighContrast = ColorKt.getSurfaceLightHighContrast();
        long onSurfaceLightHighContrast = ColorKt.getOnSurfaceLightHighContrast();
        long surfaceVariantLightHighContrast = ColorKt.getSurfaceVariantLightHighContrast();
        long onSurfaceVariantLightHighContrast = ColorKt.getOnSurfaceVariantLightHighContrast();
        long outlineLightHighContrast = ColorKt.getOutlineLightHighContrast();
        long outlineVariantLightHighContrast = ColorKt.getOutlineVariantLightHighContrast();
        long scrimLightHighContrast = ColorKt.getScrimLightHighContrast();
        long inverseSurfaceLightHighContrast = ColorKt.getInverseSurfaceLightHighContrast();
        long inverseOnSurfaceLightHighContrast = ColorKt.getInverseOnSurfaceLightHighContrast();
        long inversePrimaryLightHighContrast = ColorKt.getInversePrimaryLightHighContrast();
        long surfaceDimLightHighContrast = ColorKt.getSurfaceDimLightHighContrast();
        long surfaceBrightLightHighContrast = ColorKt.getSurfaceBrightLightHighContrast();
        long surfaceContainerLowestLightHighContrast = ColorKt.getSurfaceContainerLowestLightHighContrast();
        highContrastLightColorScheme = ColorSchemeKt.m2838lightColorScheme_VG5OTI$default(primaryLightHighContrast, onPrimaryLightHighContrast, primaryContainerLightHighContrast, onPrimaryContainerLightHighContrast, inversePrimaryLightHighContrast, secondaryLightHighContrast, onSecondaryLightHighContrast, secondaryContainerLightHighContrast, onSecondaryContainerLightHighContrast, tertiaryLightHighContrast, onTertiaryLightHighContrast, tertiaryContainerLightHighContrast, onTertiaryContainerLightHighContrast, backgroundLightHighContrast, onBackgroundLightHighContrast, surfaceLightHighContrast, onSurfaceLightHighContrast, surfaceVariantLightHighContrast, onSurfaceVariantLightHighContrast, 0L, inverseSurfaceLightHighContrast, inverseOnSurfaceLightHighContrast, errorLightHighContrast, onErrorLightHighContrast, errorContainerLightHighContrast, onErrorContainerLightHighContrast, outlineLightHighContrast, outlineVariantLightHighContrast, scrimLightHighContrast, surfaceBrightLightHighContrast, ColorKt.getSurfaceContainerLightHighContrast(), ColorKt.getSurfaceContainerHighLightHighContrast(), ColorKt.getSurfaceContainerHighestLightHighContrast(), ColorKt.getSurfaceContainerLowLightHighContrast(), surfaceContainerLowestLightHighContrast, surfaceDimLightHighContrast, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 524288, 65520, null);
        long primaryDarkMediumContrast = ColorKt.getPrimaryDarkMediumContrast();
        long onPrimaryDarkMediumContrast = ColorKt.getOnPrimaryDarkMediumContrast();
        long primaryContainerDarkMediumContrast = ColorKt.getPrimaryContainerDarkMediumContrast();
        long onPrimaryContainerDarkMediumContrast = ColorKt.getOnPrimaryContainerDarkMediumContrast();
        long secondaryDarkMediumContrast = ColorKt.getSecondaryDarkMediumContrast();
        long onSecondaryDarkMediumContrast = ColorKt.getOnSecondaryDarkMediumContrast();
        long secondaryContainerDarkMediumContrast = ColorKt.getSecondaryContainerDarkMediumContrast();
        long onSecondaryContainerDarkMediumContrast = ColorKt.getOnSecondaryContainerDarkMediumContrast();
        long tertiaryDarkMediumContrast = ColorKt.getTertiaryDarkMediumContrast();
        long onTertiaryDarkMediumContrast = ColorKt.getOnTertiaryDarkMediumContrast();
        long tertiaryContainerDarkMediumContrast = ColorKt.getTertiaryContainerDarkMediumContrast();
        long onTertiaryContainerDarkMediumContrast = ColorKt.getOnTertiaryContainerDarkMediumContrast();
        long errorDarkMediumContrast = ColorKt.getErrorDarkMediumContrast();
        long onErrorDarkMediumContrast = ColorKt.getOnErrorDarkMediumContrast();
        long errorContainerDarkMediumContrast = ColorKt.getErrorContainerDarkMediumContrast();
        long onErrorContainerDarkMediumContrast = ColorKt.getOnErrorContainerDarkMediumContrast();
        long backgroundDarkMediumContrast = ColorKt.getBackgroundDarkMediumContrast();
        long onBackgroundDarkMediumContrast = ColorKt.getOnBackgroundDarkMediumContrast();
        long surfaceDarkMediumContrast = ColorKt.getSurfaceDarkMediumContrast();
        long onSurfaceDarkMediumContrast = ColorKt.getOnSurfaceDarkMediumContrast();
        long surfaceVariantDarkMediumContrast = ColorKt.getSurfaceVariantDarkMediumContrast();
        long onSurfaceVariantDarkMediumContrast = ColorKt.getOnSurfaceVariantDarkMediumContrast();
        long outlineDarkMediumContrast = ColorKt.getOutlineDarkMediumContrast();
        long outlineVariantDarkMediumContrast = ColorKt.getOutlineVariantDarkMediumContrast();
        long scrimDarkMediumContrast = ColorKt.getScrimDarkMediumContrast();
        long inverseSurfaceDarkMediumContrast = ColorKt.getInverseSurfaceDarkMediumContrast();
        long inverseOnSurfaceDarkMediumContrast = ColorKt.getInverseOnSurfaceDarkMediumContrast();
        long inversePrimaryDarkMediumContrast = ColorKt.getInversePrimaryDarkMediumContrast();
        long surfaceDimDarkMediumContrast = ColorKt.getSurfaceDimDarkMediumContrast();
        long surfaceBrightDarkMediumContrast = ColorKt.getSurfaceBrightDarkMediumContrast();
        long surfaceContainerLowestDarkMediumContrast = ColorKt.getSurfaceContainerLowestDarkMediumContrast();
        mediumContrastDarkColorScheme = ColorSchemeKt.m2832darkColorScheme_VG5OTI$default(primaryDarkMediumContrast, onPrimaryDarkMediumContrast, primaryContainerDarkMediumContrast, onPrimaryContainerDarkMediumContrast, inversePrimaryDarkMediumContrast, secondaryDarkMediumContrast, onSecondaryDarkMediumContrast, secondaryContainerDarkMediumContrast, onSecondaryContainerDarkMediumContrast, tertiaryDarkMediumContrast, onTertiaryDarkMediumContrast, tertiaryContainerDarkMediumContrast, onTertiaryContainerDarkMediumContrast, backgroundDarkMediumContrast, onBackgroundDarkMediumContrast, surfaceDarkMediumContrast, onSurfaceDarkMediumContrast, surfaceVariantDarkMediumContrast, onSurfaceVariantDarkMediumContrast, 0L, inverseSurfaceDarkMediumContrast, inverseOnSurfaceDarkMediumContrast, errorDarkMediumContrast, onErrorDarkMediumContrast, errorContainerDarkMediumContrast, onErrorContainerDarkMediumContrast, outlineDarkMediumContrast, outlineVariantDarkMediumContrast, scrimDarkMediumContrast, surfaceBrightDarkMediumContrast, ColorKt.getSurfaceContainerDarkMediumContrast(), ColorKt.getSurfaceContainerHighDarkMediumContrast(), ColorKt.getSurfaceContainerHighestDarkMediumContrast(), ColorKt.getSurfaceContainerLowDarkMediumContrast(), surfaceContainerLowestDarkMediumContrast, surfaceDimDarkMediumContrast, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 524288, 65520, null);
        long primaryDarkHighContrast = ColorKt.getPrimaryDarkHighContrast();
        long onPrimaryDarkHighContrast = ColorKt.getOnPrimaryDarkHighContrast();
        long primaryContainerDarkHighContrast = ColorKt.getPrimaryContainerDarkHighContrast();
        long onPrimaryContainerDarkHighContrast = ColorKt.getOnPrimaryContainerDarkHighContrast();
        long secondaryDarkHighContrast = ColorKt.getSecondaryDarkHighContrast();
        long onSecondaryDarkHighContrast = ColorKt.getOnSecondaryDarkHighContrast();
        long secondaryContainerDarkHighContrast = ColorKt.getSecondaryContainerDarkHighContrast();
        long onSecondaryContainerDarkHighContrast = ColorKt.getOnSecondaryContainerDarkHighContrast();
        long tertiaryDarkHighContrast = ColorKt.getTertiaryDarkHighContrast();
        long onTertiaryDarkHighContrast = ColorKt.getOnTertiaryDarkHighContrast();
        long tertiaryContainerDarkHighContrast = ColorKt.getTertiaryContainerDarkHighContrast();
        long onTertiaryContainerDarkHighContrast = ColorKt.getOnTertiaryContainerDarkHighContrast();
        long errorDarkHighContrast = ColorKt.getErrorDarkHighContrast();
        long onErrorDarkHighContrast = ColorKt.getOnErrorDarkHighContrast();
        long errorContainerDarkHighContrast = ColorKt.getErrorContainerDarkHighContrast();
        long onErrorContainerDarkHighContrast = ColorKt.getOnErrorContainerDarkHighContrast();
        long backgroundDarkHighContrast = ColorKt.getBackgroundDarkHighContrast();
        long onBackgroundDarkHighContrast = ColorKt.getOnBackgroundDarkHighContrast();
        long surfaceDarkHighContrast = ColorKt.getSurfaceDarkHighContrast();
        long onSurfaceDarkHighContrast = ColorKt.getOnSurfaceDarkHighContrast();
        long surfaceVariantDarkHighContrast = ColorKt.getSurfaceVariantDarkHighContrast();
        long onSurfaceVariantDarkHighContrast = ColorKt.getOnSurfaceVariantDarkHighContrast();
        long outlineDarkHighContrast = ColorKt.getOutlineDarkHighContrast();
        long outlineVariantDarkHighContrast = ColorKt.getOutlineVariantDarkHighContrast();
        long scrimDarkHighContrast = ColorKt.getScrimDarkHighContrast();
        long inverseSurfaceDarkHighContrast = ColorKt.getInverseSurfaceDarkHighContrast();
        long inverseOnSurfaceDarkHighContrast = ColorKt.getInverseOnSurfaceDarkHighContrast();
        long inversePrimaryDarkHighContrast = ColorKt.getInversePrimaryDarkHighContrast();
        long surfaceDimDarkHighContrast = ColorKt.getSurfaceDimDarkHighContrast();
        long surfaceBrightDarkHighContrast = ColorKt.getSurfaceBrightDarkHighContrast();
        long surfaceContainerLowestDarkHighContrast = ColorKt.getSurfaceContainerLowestDarkHighContrast();
        highContrastDarkColorScheme = ColorSchemeKt.m2832darkColorScheme_VG5OTI$default(primaryDarkHighContrast, onPrimaryDarkHighContrast, primaryContainerDarkHighContrast, onPrimaryContainerDarkHighContrast, inversePrimaryDarkHighContrast, secondaryDarkHighContrast, onSecondaryDarkHighContrast, secondaryContainerDarkHighContrast, onSecondaryContainerDarkHighContrast, tertiaryDarkHighContrast, onTertiaryDarkHighContrast, tertiaryContainerDarkHighContrast, onTertiaryContainerDarkHighContrast, backgroundDarkHighContrast, onBackgroundDarkHighContrast, surfaceDarkHighContrast, onSurfaceDarkHighContrast, surfaceVariantDarkHighContrast, onSurfaceVariantDarkHighContrast, 0L, inverseSurfaceDarkHighContrast, inverseOnSurfaceDarkHighContrast, errorDarkHighContrast, onErrorDarkHighContrast, errorContainerDarkHighContrast, onErrorContainerDarkHighContrast, outlineDarkHighContrast, outlineVariantDarkHighContrast, scrimDarkHighContrast, surfaceBrightDarkHighContrast, ColorKt.getSurfaceContainerDarkHighContrast(), ColorKt.getSurfaceContainerHighDarkHighContrast(), ColorKt.getSurfaceContainerHighestDarkHighContrast(), ColorKt.getSurfaceContainerLowDarkHighContrast(), surfaceContainerLowestDarkHighContrast, surfaceDimDarkHighContrast, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 524288, 65520, null);
        unspecified_scheme = new ColorFamily(Color.INSTANCE.m5976getUnspecified0d7_KjU(), Color.INSTANCE.m5976getUnspecified0d7_KjU(), Color.INSTANCE.m5976getUnspecified0d7_KjU(), Color.INSTANCE.m5976getUnspecified0d7_KjU(), null);
    }

    public static final ColorFamily getUnspecified_scheme() {
        return unspecified_scheme;
    }

    public static final void BingwaHybridTheme(final boolean z, boolean z2, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        ColorScheme colorSchemeDynamicDarkColorScheme;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(271927049);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BingwaHybridTheme)N(darkTheme,dynamicColor,content)276@12237L7,286@12529L117:Theme.kt#wj0ot0");
        if ((i & 6) == 0) {
            i3 = (((i2 & 1) == 0 && composerStartRestartGroup.changed(z)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(content) ? 256 : 128;
        }
        boolean z3 = true;
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "262@11737L21");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    z = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                    i3 &= -15;
                }
                if (i4 != 0) {
                    z2 = false;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(271927049, i3, -1, "com.example.bingwahybrid.presentation.theme.BingwaHybridTheme (Theme.kt:266)");
            }
            if (z2 && Build.VERSION.SDK_INT >= 31) {
                composerStartRestartGroup.startReplaceGroup(670710814);
                ComposerKt.sourceInformation(composerStartRestartGroup, "269@12030L7");
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Context context = (Context) objConsume;
                colorSchemeDynamicDarkColorScheme = z ? DynamicTonalPaletteKt.dynamicDarkColorScheme(context) : DynamicTonalPaletteKt.dynamicLightColorScheme(context);
                composerStartRestartGroup.endReplaceGroup();
            } else if (z) {
                composerStartRestartGroup.startReplaceGroup(-671095277);
                composerStartRestartGroup.endReplaceGroup();
                colorSchemeDynamicDarkColorScheme = darkScheme;
            } else {
                composerStartRestartGroup.startReplaceGroup(-671094412);
                composerStartRestartGroup.endReplaceGroup();
                colorSchemeDynamicDarkColorScheme = lightScheme;
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final View view = (View) objConsume2;
            if (view.isInEditMode()) {
                composerStartRestartGroup.startReplaceGroup(658811929);
            } else {
                composerStartRestartGroup.startReplaceGroup(670995487);
                ComposerKt.sourceInformation(composerStartRestartGroup, "278@12294L223,278@12283L234");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -671091000, "CC(remember):Theme.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(view);
                if ((((i3 & 14) ^ 6) <= 4 || !composerStartRestartGroup.changed(z)) && (i3 & 6) != 4) {
                    z3 = false;
                }
                boolean z4 = zChangedInstance | z3;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.theme.ThemeKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ThemeKt.BingwaHybridTheme$lambda$1$lambda$0(view, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            MaterialThemeKt.MaterialTheme(colorSchemeDynamicDarkColorScheme, null, TypeKt.getAppTypography(), content, composerStartRestartGroup, ((i3 << 3) & 7168) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final boolean z5 = z;
        final boolean z6 = z2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.theme.ThemeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeKt.BingwaHybridTheme$lambda$2(z5, z6, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BingwaHybridTheme$lambda$1$lambda$0(View view, boolean z) {
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(((Activity) context).getWindow(), view);
        Intrinsics.checkNotNullExpressionValue(insetsController, "getInsetsController(...)");
        insetsController.setAppearanceLightStatusBars(!z);
        return Unit.INSTANCE;
    }
}
