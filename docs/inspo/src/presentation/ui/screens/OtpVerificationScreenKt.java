package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.text.ClickableTextKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.MenuKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import androidx.hilt.lifecycle.viewmodel.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavHostController;
import com.example.bingwahybrid.presentation.ui.components.CustomButtonKt;
import com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OtpVerificationScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0000\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001as\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a\u0015\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001a\u001a5\u0010\u001b\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0016H\u0007¢\u0006\u0002\u0010\u001c\u001a\u001b\u0010\u001d\u001a\u00020\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0007¢\u0006\u0002\u0010\u001f\u001a\r\u0010 \u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010!¨\u0006\"²\u0006\f\u0010#\u001a\u0004\u0018\u00010\u0007X\u008a\u0084\u0002²\u0006\u0010\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070$X\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010%\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"OtpVerificationScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "email", "", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/OtpVerificationViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Ljava/lang/String;Lcom/example/bingwahybrid/presentation/viewmodel/OtpVerificationViewModel;Landroidx/compose/runtime/Composer;II)V", "OtpVerificationScreenContent", "otpCode", "", "timerSeconds", "", "isLoading", "", "onOtpSubmit", "Lkotlin/Function0;", "onOtpResend", "onOtpCodeChange", "Lkotlin/Function2;", "(Landroidx/compose/ui/Modifier;Ljava/util/List;ILjava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "formatTime", "seconds", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "OTPInputBoxes", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OtpResendText", "onResendClick", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "OtpVerificationScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "snackbarMessage", "", "otpVerificationSuccess"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OtpVerificationScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OTPInputBoxes$lambda$38(List list, Function2 function2, int i, Composer composer, int i2) {
        OTPInputBoxes(list, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpResendText$lambda$45(Function0 function0, int i, Composer composer, int i2) {
        OtpResendText(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpVerificationScreen$lambda$20(Modifier modifier, NavHostController navHostController, String str, OtpVerificationViewModel otpVerificationViewModel, int i, int i2, Composer composer, int i3) {
        OtpVerificationScreen(modifier, navHostController, str, otpVerificationViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpVerificationScreenContent$lambda$29(Modifier modifier, List list, int i, String str, boolean z, Function0 function0, Function0 function1, Function2 function2, int i2, int i3, Composer composer, int i4) {
        OtpVerificationScreenContent(modifier, list, i, str, z, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpVerificationScreenPreview$lambda$53(int i, Composer composer, int i2) {
        OtpVerificationScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x021a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0265  */
    /* JADX WARN: Code duplicated, block: B:119:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:121:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:124:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0059  */
    /* JADX WARN: Code duplicated, block: B:28:0x005f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0061  */
    /* JADX WARN: Code duplicated, block: B:33:0x006a  */
    /* JADX WARN: Code duplicated, block: B:35:0x006e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:38:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x007d  */
    /* JADX WARN: Code duplicated, block: B:41:0x007f  */
    /* JADX WARN: Code duplicated, block: B:45:0x008a  */
    /* JADX WARN: Code duplicated, block: B:46:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0095  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00be  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:68:0x00df  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:71:0x0100  */
    /* JADX WARN: Code duplicated, block: B:73:0x012f  */
    /* JADX WARN: Code duplicated, block: B:75:0x013b  */
    /* JADX WARN: Code duplicated, block: B:78:0x014b  */
    /* JADX WARN: Code duplicated, block: B:81:0x016d  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:89:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:90:0x01f5  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void OtpVerificationScreen(Modifier modifier, NavHostController navHostController, final String email, OtpVerificationViewModel otpVerificationViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        NavHostController navHostController2;
        boolean z;
        final Modifier modifier3;
        final NavHostController navHostController3;
        final OtpVerificationViewModel otpVerificationViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        NavHostController navHostController4;
        int i4;
        final NavHostController navHostController5;
        OtpVerificationViewModel otpVerificationViewModel3;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Object objRememberedValue;
        final CoroutineScope coroutineScope;
        State stateCollectAsState;
        State stateCollectAsState2;
        boolean zChanged;
        OtpVerificationScreenKt$OtpVerificationScreen$1$1 otpVerificationScreenKt$OtpVerificationScreen$1$1RememberedValue;
        boolean z2;
        boolean z3;
        OtpVerificationScreenKt$OtpVerificationScreen$2$1 otpVerificationScreenKt$OtpVerificationScreen$2$1RememberedValue;
        boolean zChanged2;
        OtpVerificationScreenKt$OtpVerificationScreen$3$1 otpVerificationScreenKt$OtpVerificationScreen$3$1RememberedValue;
        int i5;
        boolean zChangedInstance;
        int i6;
        Intrinsics.checkNotNullParameter(email, "email");
        Composer composerStartRestartGroup = composer.startRestartGroup(353360567);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OtpVerificationScreen)N(modifier,navController,email,viewModel)68@3131L24,69@3209L16,70@3259L16,71@3355L16,72@3413L16,73@3497L16,75@3558L112,75@3519L151,81@3698L89,81@3676L111,87@3825L144,87@3793L176,94@4001L864,118@4872L898,93@3974L1796:OtpVerificationScreen.kt#oif8tm");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                navHostController2 = navHostController;
                i3 |= composerStartRestartGroup.changedInstance(navHostController2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changed(email)) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
                i3 |= i6;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) != 0) {
                    i5 = 1024;
                } else {
                    if ((i & 4096) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(otpVerificationViewModel);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(otpVerificationViewModel);
                    }
                    if (zChangedInstance) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                }
                i3 |= i5;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "66@3094L15");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i8 != 0) {
                        navHostController4 = null;
                    } else {
                        navHostController4 = navHostController2;
                    }
                    if ((i2 & 8) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1890788296, "CC(hiltViewModel)P(1)51@2126L7,55@2260L46:HiltViewModel.kt#9mcars");
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1192010736, "CC(hiltViewModel)P(1)38@1622L7,43@1774L47,44@1833L54:HiltViewModel.kt#gplxbw");
                        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        CreationExtras creationExtras = defaultViewModelCreationExtras;
                        i4 = 0;
                        ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(OtpVerificationViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, creationExtras, composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -7169;
                        navHostController5 = navHostController4;
                        otpVerificationViewModel3 = (OtpVerificationViewModel) viewModel;
                    } else {
                        i4 = 0;
                        navHostController5 = navHostController4;
                        otpVerificationViewModel3 = otpVerificationViewModel;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    navHostController5 = navHostController2;
                    companion = modifier2;
                    i4 = 0;
                    otpVerificationViewModel3 = otpVerificationViewModel;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(353360567, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreen (OtpVerificationScreen.kt:67)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                stateCollectAsState = SnapshotStateKt.collectAsState(otpVerificationViewModel3.getSnackbarMessage(), r12, composerStartRestartGroup, i4, 1);
                final State stateCollectAsState3 = SnapshotStateKt.collectAsState(otpVerificationViewModel3.getOtp(), r12, composerStartRestartGroup, i4, 1);
                final State stateCollectAsState4 = SnapshotStateKt.collectAsState(otpVerificationViewModel3.getTimerSeconds(), r12, composerStartRestartGroup, i4, 1);
                final State stateCollectAsState5 = SnapshotStateKt.collectAsState(otpVerificationViewModel3.isLoading(), r12, composerStartRestartGroup, i4, 1);
                stateCollectAsState2 = SnapshotStateKt.collectAsState(otpVerificationViewModel3.getOtpVerificationSuccess(), 0, composerStartRestartGroup, i4, 1);
                Boolean boolValueOf = Boolean.valueOf(OtpVerificationScreen$lambda$4(stateCollectAsState2));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 277110535, "CC(remember):OtpVerificationScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(navHostController5);
                Modifier modifier4 = companion;
                otpVerificationScreenKt$OtpVerificationScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || otpVerificationScreenKt$OtpVerificationScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    otpVerificationScreenKt$OtpVerificationScreen$1$1RememberedValue = new OtpVerificationScreenKt$OtpVerificationScreen$1$1(navHostController5, stateCollectAsState2, null);
                    composerStartRestartGroup.updateRememberedValue(otpVerificationScreenKt$OtpVerificationScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) otpVerificationScreenKt$OtpVerificationScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 277114992, "CC(remember):OtpVerificationScreen.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int i9 = (i3 & 7168) ^ 3072;
                z3 = z2 | ((i9 <= 2048 && composerStartRestartGroup.changedInstance(otpVerificationViewModel3)) || (i3 & 3072) == 2048);
                otpVerificationScreenKt$OtpVerificationScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3 || otpVerificationScreenKt$OtpVerificationScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    otpVerificationScreenKt$OtpVerificationScreen$2$1RememberedValue = new OtpVerificationScreenKt$OtpVerificationScreen$2$1(email, otpVerificationViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(otpVerificationScreenKt$OtpVerificationScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(email, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) otpVerificationScreenKt$OtpVerificationScreen$2$1RememberedValue, composerStartRestartGroup, (i3 >> 6) & 14);
                String strOtpVerificationScreen$lambda$0 = OtpVerificationScreen$lambda$0(stateCollectAsState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 277119111, "CC(remember):OtpVerificationScreen.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(coroutineScope) | ((i9 <= 2048 && composerStartRestartGroup.changedInstance(otpVerificationViewModel3)) || (i3 & 3072) == 2048);
                otpVerificationScreenKt$OtpVerificationScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged2 || otpVerificationScreenKt$OtpVerificationScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    otpVerificationScreenKt$OtpVerificationScreen$3$1RememberedValue = new OtpVerificationScreenKt$OtpVerificationScreen$3$1(stateCollectAsState, coroutineScope, otpVerificationViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(otpVerificationScreenKt$OtpVerificationScreen$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strOtpVerificationScreen$lambda$0, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) otpVerificationScreenKt$OtpVerificationScreen$3$1RememberedValue, composerStartRestartGroup, 0);
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-818302093, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OtpVerificationScreenKt.OtpVerificationScreen$lambda$11(coroutineScope, navHostController5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                modifier3 = modifier4;
                final OtpVerificationViewModel otpVerificationViewModel4 = otpVerificationViewModel3;
                NavHostController navHostController6 = navHostController5;
                ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1387813944, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OtpVerificationScreenKt.OtpVerificationScreen$lambda$19(modifier3, email, otpVerificationViewModel4, stateCollectAsState3, stateCollectAsState4, stateCollectAsState5, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navHostController3 = navHostController6;
                otpVerificationViewModel2 = otpVerificationViewModel4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                navHostController3 = navHostController2;
                otpVerificationViewModel2 = otpVerificationViewModel;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OtpVerificationScreenKt.OtpVerificationScreen$lambda$20(modifier3, navHostController3, email, otpVerificationViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        navHostController2 = navHostController;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changed(email)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) != 0) {
                i5 = 1024;
            } else {
                if ((i & 4096) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(otpVerificationViewModel);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(otpVerificationViewModel);
                }
                if (zChangedInstance) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
            }
            i3 |= i5;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "66@3094L15");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i8 != 0) {
                    navHostController4 = null;
                } else {
                    navHostController4 = navHostController2;
                }
                if ((i2 & 8) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1890788296, "CC(hiltViewModel)P(1)51@2126L7,55@2260L46:HiltViewModel.kt#9mcars");
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1192010736, "CC(hiltViewModel)P(1)38@1622L7,43@1774L47,44@1833L54:HiltViewModel.kt#gplxbw");
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory2 = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    CreationExtras creationExtras2 = defaultViewModelCreationExtras;
                    i4 = 0;
                    ViewModel viewModel2 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(OtpVerificationViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory2, creationExtras2, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -7169;
                    navHostController5 = navHostController4;
                    otpVerificationViewModel3 = (OtpVerificationViewModel) viewModel2;
                } else {
                    i4 = 0;
                    navHostController5 = navHostController4;
                    otpVerificationViewModel3 = otpVerificationViewModel;
                }
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i8 != 0) {
                    navHostController4 = null;
                } else {
                    navHostController4 = navHostController2;
                }
                if ((i2 & 8) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1890788296, "CC(hiltViewModel)P(1)51@2126L7,55@2260L46:HiltViewModel.kt#9mcars");
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1192010736, "CC(hiltViewModel)P(1)38@1622L7,43@1774L47,44@1833L54:HiltViewModel.kt#gplxbw");
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory3 = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    CreationExtras creationExtras3 = defaultViewModelCreationExtras;
                    i4 = 0;
                    ViewModel viewModel3 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(OtpVerificationViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory3, creationExtras3, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -7169;
                    navHostController5 = navHostController4;
                    otpVerificationViewModel3 = (OtpVerificationViewModel) viewModel3;
                } else {
                    i4 = 0;
                    navHostController5 = navHostController4;
                    otpVerificationViewModel3 = otpVerificationViewModel;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(353360567, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreen (OtpVerificationScreen.kt:67)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            stateCollectAsState = SnapshotStateKt.collectAsState(otpVerificationViewModel3.getSnackbarMessage(), r12, composerStartRestartGroup, i4, 1);
            final State stateCollectAsState6 = SnapshotStateKt.collectAsState(otpVerificationViewModel3.getOtp(), r12, composerStartRestartGroup, i4, 1);
            final State stateCollectAsState7 = SnapshotStateKt.collectAsState(otpVerificationViewModel3.getTimerSeconds(), r12, composerStartRestartGroup, i4, 1);
            final State stateCollectAsState8 = SnapshotStateKt.collectAsState(otpVerificationViewModel3.isLoading(), r12, composerStartRestartGroup, i4, 1);
            stateCollectAsState2 = SnapshotStateKt.collectAsState(otpVerificationViewModel3.getOtpVerificationSuccess(), 0, composerStartRestartGroup, i4, 1);
            Boolean boolValueOf2 = Boolean.valueOf(OtpVerificationScreen$lambda$4(stateCollectAsState2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 277110535, "CC(remember):OtpVerificationScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(navHostController5);
            Modifier modifier5 = companion;
            otpVerificationScreenKt$OtpVerificationScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                otpVerificationScreenKt$OtpVerificationScreen$1$1RememberedValue = new OtpVerificationScreenKt$OtpVerificationScreen$1$1(navHostController5, stateCollectAsState2, null);
                composerStartRestartGroup.updateRememberedValue(otpVerificationScreenKt$OtpVerificationScreen$1$1RememberedValue);
            } else {
                otpVerificationScreenKt$OtpVerificationScreen$1$1RememberedValue = new OtpVerificationScreenKt$OtpVerificationScreen$1$1(navHostController5, stateCollectAsState2, null);
                composerStartRestartGroup.updateRememberedValue(otpVerificationScreenKt$OtpVerificationScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) otpVerificationScreenKt$OtpVerificationScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 277114992, "CC(remember):OtpVerificationScreen.kt#9igjgp");
            if ((i3 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i10 = (i3 & 7168) ^ 3072;
            z3 = z2 | ((i10 <= 2048 && composerStartRestartGroup.changedInstance(otpVerificationViewModel3)) || (i3 & 3072) == 2048);
            otpVerificationScreenKt$OtpVerificationScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                otpVerificationScreenKt$OtpVerificationScreen$2$1RememberedValue = new OtpVerificationScreenKt$OtpVerificationScreen$2$1(email, otpVerificationViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(otpVerificationScreenKt$OtpVerificationScreen$2$1RememberedValue);
            } else {
                otpVerificationScreenKt$OtpVerificationScreen$2$1RememberedValue = new OtpVerificationScreenKt$OtpVerificationScreen$2$1(email, otpVerificationViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(otpVerificationScreenKt$OtpVerificationScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(email, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) otpVerificationScreenKt$OtpVerificationScreen$2$1RememberedValue, composerStartRestartGroup, (i3 >> 6) & 14);
            String strOtpVerificationScreen$lambda$1 = OtpVerificationScreen$lambda$0(stateCollectAsState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 277119111, "CC(remember):OtpVerificationScreen.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(coroutineScope) | ((i10 <= 2048 && composerStartRestartGroup.changedInstance(otpVerificationViewModel3)) || (i3 & 3072) == 2048);
            otpVerificationScreenKt$OtpVerificationScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                otpVerificationScreenKt$OtpVerificationScreen$3$1RememberedValue = new OtpVerificationScreenKt$OtpVerificationScreen$3$1(stateCollectAsState, coroutineScope, otpVerificationViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(otpVerificationScreenKt$OtpVerificationScreen$3$1RememberedValue);
            } else {
                otpVerificationScreenKt$OtpVerificationScreen$3$1RememberedValue = new OtpVerificationScreenKt$OtpVerificationScreen$3$1(stateCollectAsState, coroutineScope, otpVerificationViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(otpVerificationScreenKt$OtpVerificationScreen$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strOtpVerificationScreen$lambda$1, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) otpVerificationScreenKt$OtpVerificationScreen$3$1RememberedValue, composerStartRestartGroup, 0);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-818302093, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OtpVerificationScreenKt.OtpVerificationScreen$lambda$11(coroutineScope, navHostController5, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            modifier3 = modifier5;
            final OtpVerificationViewModel otpVerificationViewModel5 = otpVerificationViewModel3;
            NavHostController navHostController7 = navHostController5;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda2, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1387813944, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OtpVerificationScreenKt.OtpVerificationScreen$lambda$19(modifier3, email, otpVerificationViewModel5, stateCollectAsState6, stateCollectAsState7, stateCollectAsState8, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            navHostController3 = navHostController7;
            otpVerificationViewModel2 = otpVerificationViewModel5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            navHostController3 = navHostController2;
            otpVerificationViewModel2 = otpVerificationViewModel;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OtpVerificationScreenKt.OtpVerificationScreen$lambda$20(modifier3, navHostController3, email, otpVerificationViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpVerificationScreen$lambda$11(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C105@4420L421,95@4015L840:OtpVerificationScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-818302093, i, -1, "com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreen.<anonymous> (OtpVerificationScreen.kt:95)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$OtpVerificationScreenKt.INSTANCE.getLambda$1356810295$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(1388447417, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OtpVerificationScreenKt.OtpVerificationScreen$lambda$11$lambda$10(coroutineScope, navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpVerificationScreen$lambda$11$lambda$10(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C106@4463L240,106@4442L381:OtpVerificationScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1388447417, i, -1, "com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreen.<anonymous>.<anonymous> (OtpVerificationScreen.kt:106)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1436859703, "CC(remember):OtpVerificationScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OtpVerificationScreenKt.OtpVerificationScreen$lambda$11$lambda$10$lambda$9$lambda$8(coroutineScope, navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$OtpVerificationScreenKt.INSTANCE.getLambda$1243078871$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpVerificationScreen$lambda$11$lambda$10$lambda$9$lambda$8(CoroutineScope coroutineScope, NavHostController navHostController) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OtpVerificationScreenKt$OtpVerificationScreen$4$1$1$1$1(navHostController, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpVerificationScreen$lambda$19(Modifier modifier, String str, final OtpVerificationViewModel otpVerificationViewModel, State state, State state2, State state3, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)124@5087L21,119@4899L865:OtpVerificationScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1387813944, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreen.<anonymous> (OtpVerificationScreen.kt:119)");
            }
            Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(ScrollKt.verticalScroll$default(PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxSize$default(PaddingKt.padding(modifier, paddingValues), 0.0f, 1, null), Dp.m8684constructorimpl(24), 0.0f, 2, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null));
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, Alignment.INSTANCE.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierImePadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1041087315, "C133@5428L25,134@5485L25,135@5546L162,128@5218L536:OtpVerificationScreen.kt#oif8tm");
            List<String> listOtpVerificationScreen$lambda$1 = OtpVerificationScreen$lambda$1(state);
            int iOtpVerificationScreen$lambda$2 = OtpVerificationScreen$lambda$2(state2);
            boolean zOtpVerificationScreen$lambda$3 = OtpVerificationScreen$lambda$3(state3);
            ComposerKt.sourceInformationMarkerStart(composer, -172124585, "CC(remember):OtpVerificationScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(otpVerificationViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OtpVerificationScreenKt.OtpVerificationScreen$lambda$19$lambda$18$lambda$13$lambda$12(otpVerificationViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -172122761, "CC(remember):OtpVerificationScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(otpVerificationViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OtpVerificationScreenKt.OtpVerificationScreen$lambda$19$lambda$18$lambda$15$lambda$14(otpVerificationViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function1 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -172120672, "CC(remember):OtpVerificationScreen.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(otpVerificationViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OtpVerificationScreenKt.OtpVerificationScreen$lambda$19$lambda$18$lambda$17$lambda$16(otpVerificationViewModel, ((Integer) obj).intValue(), (String) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OtpVerificationScreenContent(null, listOtpVerificationScreen$lambda$1, iOtpVerificationScreen$lambda$2, str, zOtpVerificationScreen$lambda$3, function0, function1, (Function2) objRememberedValue3, composer, 0, 1);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpVerificationScreen$lambda$19$lambda$18$lambda$13$lambda$12(OtpVerificationViewModel otpVerificationViewModel) {
        otpVerificationViewModel.verifyOtp();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpVerificationScreen$lambda$19$lambda$18$lambda$15$lambda$14(OtpVerificationViewModel otpVerificationViewModel) {
        otpVerificationViewModel.resendOtp();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpVerificationScreen$lambda$19$lambda$18$lambda$17$lambda$16(OtpVerificationViewModel otpVerificationViewModel, int i, String digit) {
        Intrinsics.checkNotNullParameter(digit, "digit");
        otpVerificationViewModel.onOtpChanged(i, digit);
        return Unit.INSTANCE;
    }

    public static final void OtpVerificationScreenContent(Modifier modifier, final List<String> otpCode, final int i, final String email, final boolean z, final Function0<Unit> onOtpSubmit, final Function0<Unit> onOtpResend, final Function2<? super Integer, ? super String, Unit> onOtpCodeChange, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(otpCode, "otpCode");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(onOtpSubmit, "onOtpSubmit");
        Intrinsics.checkNotNullParameter(onOtpResend, "onOtpResend");
        Intrinsics.checkNotNullParameter(onOtpCodeChange, "onOtpCodeChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-671499376);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OtpVerificationScreenContent)N(modifier,otpCode,timerSeconds,email,isLoading,onOtpSubmit,onOtpResend,onOtpCodeChange)161@6253L11,158@6152L2040:OtpVerificationScreen.kt#oif8tm");
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(otpCode) ? 32 : 16;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(email) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onOtpSubmit) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onOtpResend) ? 1048576 : 524288;
        }
        if ((12582912 & i2) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onOtpCodeChange) ? 8388608 : 4194304;
        }
        if (!composerStartRestartGroup.shouldExecute((4793363 & i4) != 4793362, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-671499376, i4, -1, "com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenContent (OtpVerificationScreen.kt:157)");
            }
            Modifier modifierM543backgroundbw27NRU$default = BackgroundKt.m543backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), null, 2, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM543backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i6 = i4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1625785958, "C177@6886L10,165@6403L640,183@7053L41,191@7332L41,193@7383L39,195@7432L41,197@7483L201,206@7694L41,211@7851L335,208@7745L441:OtpVerificationScreen.kt#oif8tm");
            composerStartRestartGroup.startReplaceGroup(883728140);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*167@6491L10,171@6670L10");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            int iPushStyle = builder.pushStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge().toSpanStyle());
            try {
                builder.append("Enter the 6-digit code sent to ");
                Unit unit = Unit.INSTANCE;
                builder.pop(iPushStyle);
                int iPushStyle2 = builder.pushStyle(TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null).toSpanStyle());
                try {
                    builder.append(email);
                    Unit unit2 = Unit.INSTANCE;
                    builder.pop(iPushStyle2);
                    Modifier modifier3 = companion;
                    AnnotatedString annotatedString = builder.toAnnotatedString();
                    composerStartRestartGroup.endReplaceGroup();
                    float f = 24;
                    modifier2 = modifier3;
                    TextKt.m3865TextZ58ophY(annotatedString, PaddingKt.m1120paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8684constructorimpl(f), 0.0f, 2, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8540getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composerStartRestartGroup, 48, 0, 262140);
                    composerStartRestartGroup = composerStartRestartGroup;
                    float f2 = 16;
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                    OTPInputBoxes(otpCode, onOtpCodeChange, composerStartRestartGroup, ((i6 >> 3) & 14) | ((i6 >> 18) & 112));
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center2, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM5259constructorimpl2 = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1528765634, "C201@7629L45,201@7615L59:OtpVerificationScreen.kt#oif8tm");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613253399, "CC(remember):OtpVerificationScreen.kt#9igjgp");
                    boolean z2 = (i6 & 3670016) == 1048576;
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OtpVerificationScreenKt.OtpVerificationScreenContent$lambda$28$lambda$26$lambda$25$lambda$24(onOtpResend);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    OtpResendText((Function0) objRememberedValue, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), composerStartRestartGroup, 6);
                    CustomButtonKt.CustomButton(onOtpSubmit, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-1816817894, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OtpVerificationScreenKt.OtpVerificationScreenContent$lambda$28$lambda$27(z, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 >> 15) & 14) | 24624, 12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } catch (Throwable th) {
                    builder.pop(iPushStyle2);
                    throw th;
                }
            } catch (Throwable th2) {
                builder.pop(iPushStyle);
                throw th2;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OtpVerificationScreenKt.OtpVerificationScreenContent$lambda$29(modifier4, otpCode, i, email, z, onOtpSubmit, onOtpResend, onOtpCodeChange, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpVerificationScreenContent$lambda$28$lambda$26$lambda$25$lambda$24(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpVerificationScreenContent$lambda$28$lambda$27(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:OtpVerificationScreen.kt#oif8tm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1816817894, i, -1, "com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenContent.<anonymous>.<anonymous> (OtpVerificationScreen.kt:212)");
            }
            if (z) {
                composer.startReplaceGroup(356014637);
                ComposerKt.sourceInformation(composer, "213@7898L27");
                ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(null, 0L, 0.0f, 0L, 0, 0.0f, composer, 0, 63);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(356084449);
                ComposerKt.sourceInformation(composer, "217@8041L10,215@7963L199");
                TextKt.m3864TextNvy7gAk("Verify", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 6, 0, 131070);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final String formatTime(int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1609644576, "C(formatTime)N(seconds):OtpVerificationScreen.kt#oif8tm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1609644576, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.formatTime (OtpVerificationScreen.kt:228)");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.ENGLISH, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void OTPInputBoxes(final List<String> otpCode, final Function2<? super Integer, ? super String, Unit> onOtpCodeChange, Composer composer, final int i) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(otpCode, "otpCode");
        Intrinsics.checkNotNullParameter(onOtpCodeChange, "onOtpCodeChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-951048388);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OTPInputBoxes)N(otpCode,onOtpCodeChange)236@8585L7,239@8656L2064:OtpVerificationScreen.kt#oif8tm");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(otpCode) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onOtpCodeChange) ? 32 : 16;
        }
        int i3 = 0;
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-951048388, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.OTPInputBoxes (OtpVerificationScreen.kt:235)");
            }
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localSoftwareKeyboardController);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume;
            ArrayList arrayList = new ArrayList(6);
            for (int i4 = 0; i4 < 6; i4++) {
                arrayList.add(new FocusRequester());
            }
            final ArrayList arrayList2 = arrayList;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1678358834, "C:OtpVerificationScreen.kt#oif8tm");
            composerStartRestartGroup.startReplaceGroup(1716708593);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*268@10092L105,276@10427L10,282@10676L6,247@8974L863,245@8866L1838");
            final int i5 = 0;
            for (int i6 = 6; i5 < i6; i6 = 6) {
                String str = (i5 < 0 || i5 >= otpCode.size()) ? "" : otpCode.get(i5);
                KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), ImeAction.INSTANCE.m8303getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 379541809, "CC(remember):OtpVerificationScreen.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OtpVerificationScreenKt.OTPInputBoxes$lambda$37$lambda$36$lambda$33$lambda$32(softwareKeyboardController, (KeyboardActionScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                KeyboardActions keyboardActions = new KeyboardActions((Function1) objRememberedValue, null, null, null, null, null, 62, null);
                Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(PaddingKt.m1118padding3ABfNKs(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(48)), Dp.m8684constructorimpl(i3)), (FocusRequester) arrayList2.get(i5));
                TextStyle textStyleM8131copyp1EtxEg$default = TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleSmall(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8540getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744443, null);
                CornerBasedShape medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getMedium();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 379506791, "CC(remember):OtpVerificationScreen.kt#9igjgp");
                boolean z = ((((i2 & 112) == 32 ? 1 : i3) | (composerStartRestartGroup.changed(i5) ? 1 : 0)) == true ? 1 : 0) | (composerStartRestartGroup.changedInstance(arrayList2) ? 1 : 0);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z != 0 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OtpVerificationScreenKt.OTPInputBoxes$lambda$37$lambda$36$lambda$35$lambda$34(onOtpCodeChange, i5, arrayList2, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Composer composer3 = composerStartRestartGroup;
                OutlinedTextFieldKt.OutlinedTextField(str, (Function1<? super String, Unit>) objRememberedValue2, modifierFocusRequester, false, false, textStyleM8131copyp1EtxEg$default, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, keyboardActions, true, 1, 0, (MutableInteractionSource) null, (Shape) medium, (TextFieldColors) null, composer3, 0, 113442816, 0, 5799896);
                i5++;
                composerStartRestartGroup = composer3;
                i2 = i2;
                i3 = i3;
                arrayList2 = arrayList2;
            }
            composer2 = composerStartRestartGroup;
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OtpVerificationScreenKt.OTPInputBoxes$lambda$38(otpCode, onOtpCodeChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0040 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0042  */
    /* JADX WARN: Code duplicated, block: B:9:0x0038  */
    public static final Unit OTPInputBoxes$lambda$37$lambda$36$lambda$35$lambda$34(Function2 function2, int i, List list, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.length() == 1) {
            String str = value;
            if (Character.isDigit(StringsKt.first(str))) {
                function2.invoke(Integer.valueOf(i), String.valueOf(StringsKt.first(str)));
                if (i < 5) {
                    FocusRequester.m5603requestFocus3ESFkO8$default((FocusRequester) list.get(i + 1), 0, 1, null);
                }
            } else if (value.length() == 0) {
                if (i > 0) {
                    FocusRequester.m5603requestFocus3ESFkO8$default((FocusRequester) list.get(i - 1), 0, 1, null);
                }
                function2.invoke(Integer.valueOf(i), "");
            }
        } else if (value.length() == 0) {
            if (i > 0) {
                FocusRequester.m5603requestFocus3ESFkO8$default((FocusRequester) list.get(i - 1), 0, 1, null);
            }
            function2.invoke(Integer.valueOf(i), "");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OTPInputBoxes$lambda$37$lambda$36$lambda$33$lambda$32(SoftwareKeyboardController softwareKeyboardController, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        return Unit.INSTANCE;
    }

    public static final void OtpResendText(final Function0<Unit> onResendClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onResendClick, "onResendClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(860569321);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OtpResendText)N(onResendClick)317@11646L10,318@11686L206,315@11571L327:OtpVerificationScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onResendClick) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(860569321, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.OtpResendText (OtpVerificationScreen.kt:289)");
            }
            composerStartRestartGroup.startReplaceGroup(-1921567233);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*293@10918L11,304@11218L11,305@11280L10,306@11354L10");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            int iPushStyle = builder.pushStyle(new SpanStyle(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnBackground(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
            try {
                builder.append("Didn't receive the code? ");
                Unit unit = Unit.INSTANCE;
                builder.pop(iPushStyle);
                builder.pushStringAnnotation("RESEND", "resend");
                int iPushStyle2 = builder.pushStyle(new SpanStyle(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge().m8149getFontSizeXSAIIZE(), MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge().getFontWeight(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.INSTANCE.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61432, (DefaultConstructorMarker) null));
                try {
                    builder.append("Resend");
                    Unit unit2 = Unit.INSTANCE;
                    builder.pop(iPushStyle2);
                    builder.pop();
                    int i3 = i2;
                    final AnnotatedString annotatedString = builder.toAnnotatedString();
                    composerStartRestartGroup.endReplaceGroup();
                    TextStyle bodyLarge = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1921539657, "CC(remember):OtpVerificationScreen.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(annotatedString) | ((i3 & 14) == 4);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OtpVerificationScreenKt.OtpResendText$lambda$44$lambda$43(annotatedString, onResendClick, ((Integer) obj).intValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ClickableTextKt.m1527ClickableText4YKlhWE(annotatedString, null, bodyLarge, false, 0, 0, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 122);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } catch (Throwable th) {
                    builder.pop(iPushStyle2);
                    throw th;
                }
            } catch (Throwable th2) {
                builder.pop(iPushStyle);
                throw th2;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OtpVerificationScreenKt.OtpResendText$lambda$45(onResendClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpResendText$lambda$44$lambda$43(AnnotatedString annotatedString, Function0 function0, int i) {
        if (((AnnotatedString.Range) CollectionsKt.firstOrNull((List) annotatedString.getStringAnnotations("RESEND", i, i))) != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private static final void OtpVerificationScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-990487816);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OtpVerificationScreenPreview)335@12180L2,336@12206L2,337@12236L11,330@11995L259:OtpVerificationScreen.kt#oif8tm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-990487816, i, -1, "com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenPreview (OtpVerificationScreen.kt:329)");
            }
            ArrayList arrayList = new ArrayList(6);
            for (int i2 = 0; i2 < 6; i2++) {
                arrayList.add(ExifInterface.GPS_MEASUREMENT_2D);
            }
            ArrayList arrayList2 = arrayList;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1623957434, "CC(remember):OtpVerificationScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1623958266, "CC(remember):OtpVerificationScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function0 function1 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1623959235, "CC(remember):OtpVerificationScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OtpVerificationScreenKt.OtpVerificationScreenPreview$lambda$52$lambda$51(((Integer) obj).intValue(), (String) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OtpVerificationScreenContent(null, arrayList2, MenuKt.InTransitionDuration, "example@mail.com", false, function0, function1, (Function2) objRememberedValue3, composerStartRestartGroup, 14380416, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.OtpVerificationScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OtpVerificationScreenKt.OtpVerificationScreenPreview$lambda$53(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OtpVerificationScreenPreview$lambda$52$lambda$51(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String OtpVerificationScreen$lambda$0(State<String> state) {
        return state.getValue();
    }

    private static final List<String> OtpVerificationScreen$lambda$1(State<? extends List<String>> state) {
        return state.getValue();
    }

    private static final int OtpVerificationScreen$lambda$2(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final boolean OtpVerificationScreen$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean OtpVerificationScreen$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
