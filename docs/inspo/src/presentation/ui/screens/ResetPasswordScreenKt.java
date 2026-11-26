package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.unit.Dp;
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
import com.example.bingwahybrid.presentation.ui.components.ValidatedTextFieldKt;
import com.example.bingwahybrid.presentation.viewmodel.ForgotPasswordViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ResetPasswordScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001aO\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0016¨\u0006\u0017²\u0006\n\u0010\f\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\tX\u008a\u0084\u0002²\u0006\f\u0010\u0018\u001a\u0004\u0018\u00010\tX\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u000eX\u008a\u0084\u0002"}, d2 = {"ResetPasswordScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/ForgotPasswordViewModel;", "passedEmail", "", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/viewmodel/ForgotPasswordViewModel;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "ResetPasswordScreenContent", "email", "isLoading", "", "onEmailChanged", "Lkotlin/Function1;", "emailError", "onSubmit", "Lkotlin/Function0;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ResetPasswordScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "snackbarMessage", "sendSuccess"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ResetPasswordScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResetPasswordScreen$lambda$18(Modifier modifier, NavHostController navHostController, ForgotPasswordViewModel forgotPasswordViewModel, String str, int i, int i2, Composer composer, int i3) {
        ResetPasswordScreen(modifier, navHostController, forgotPasswordViewModel, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResetPasswordScreenContent$lambda$24(String str, boolean z, Function1 function1, String str2, Function0 function0, int i, int i2, Composer composer, int i3) {
        ResetPasswordScreenContent(str, z, function1, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResetPasswordScreenPreview$lambda$29(int i, Composer composer, int i2) {
        ResetPasswordScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x022a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0268  */
    /* JADX WARN: Code duplicated, block: B:119:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:121:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:124:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:45:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x008b  */
    /* JADX WARN: Code duplicated, block: B:49:0x0094  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00be  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:70:0x0125  */
    /* JADX WARN: Code duplicated, block: B:72:0x0131  */
    /* JADX WARN: Code duplicated, block: B:74:0x0135  */
    /* JADX WARN: Code duplicated, block: B:75:0x013b  */
    /* JADX WARN: Code duplicated, block: B:78:0x0148  */
    /* JADX WARN: Code duplicated, block: B:81:0x016a  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:93:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:98:0x01e0  */
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
    public static final void ResetPasswordScreen(Modifier modifier, final NavHostController navController, ForgotPasswordViewModel forgotPasswordViewModel, String str, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        String str2;
        boolean z;
        final Modifier modifier3;
        final String str3;
        final ForgotPasswordViewModel forgotPasswordViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i4;
        int i5;
        final Modifier modifier4;
        String str4;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Object objRememberedValue;
        final CoroutineScope coroutineScope;
        final State stateCollectAsState;
        State stateCollectAsState2;
        State stateCollectAsState3;
        boolean z2;
        boolean z3;
        ResetPasswordScreenKt$ResetPasswordScreen$1$1 resetPasswordScreenKt$ResetPasswordScreen$1$1RememberedValue;
        boolean zChanged;
        ResetPasswordScreenKt$ResetPasswordScreen$2$1 resetPasswordScreenKt$ResetPasswordScreen$2$1RememberedValue;
        boolean zChanged2;
        ResetPasswordScreenKt$ResetPasswordScreen$3$1 resetPasswordScreenKt$ResetPasswordScreen$3$1RememberedValue;
        int i6;
        ForgotPasswordViewModel forgotPasswordViewModel3 = forgotPasswordViewModel;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(1133744865);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ResetPasswordScreen)N(modifier,navController,viewModel,passedEmail)47@2120L24,48@2178L16,49@2236L16,50@2296L16,51@2366L16,52@2428L16,54@2478L101,54@2450L129,60@2617L144,60@2585L176,67@2795L133,67@2767L161,74@2961L863,98@3831L454,73@2934L1351:ResetPasswordScreen.kt#oif8tm");
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
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(navController) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i6 = 128;
            } else {
                if ((i & 512) == 0 ? composerStartRestartGroup.changed(forgotPasswordViewModel3) : composerStartRestartGroup.changedInstance(forgotPasswordViewModel3)) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
            }
            i3 |= i6;
        }
        int i8 = i2 & 8;
        if (i8 == 0) {
            if ((i & 3072) == 0) {
                str2 = str;
                i3 |= composerStartRestartGroup.changed(str2) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "44@2053L15");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
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
                        int i9 = i3;
                        i5 = 1;
                        i4 = 0;
                        ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(ForgotPasswordViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, creationExtras, composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ForgotPasswordViewModel forgotPasswordViewModel4 = (ForgotPasswordViewModel) viewModel;
                        i3 = i9 & (-897);
                        forgotPasswordViewModel3 = forgotPasswordViewModel4;
                    } else {
                        i4 = 0;
                        i5 = 1;
                    }
                    if (i8 != 0) {
                        modifier4 = companion;
                        str4 = "";
                    } else {
                        modifier4 = companion;
                        str4 = str;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    modifier4 = modifier2;
                    str4 = str2;
                    i4 = 0;
                    i5 = 1;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1133744865, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreen (ResetPasswordScreen.kt:46)");
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
                stateCollectAsState = SnapshotStateKt.collectAsState(forgotPasswordViewModel3.getEmail(), null, composerStartRestartGroup, i4, i5);
                final State stateCollectAsState4 = SnapshotStateKt.collectAsState(forgotPasswordViewModel3.isLoading(), null, composerStartRestartGroup, i4, i5);
                final State stateCollectAsState5 = SnapshotStateKt.collectAsState(forgotPasswordViewModel3.getEmailError(), null, composerStartRestartGroup, i4, i5);
                stateCollectAsState2 = SnapshotStateKt.collectAsState(forgotPasswordViewModel3.getSnackbarMessage(), null, composerStartRestartGroup, i4, i5);
                stateCollectAsState3 = SnapshotStateKt.collectAsState(forgotPasswordViewModel3.getSendSuccess(), null, composerStartRestartGroup, i4, i5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1392858106, "CC(remember):ResetPasswordScreen.kt#9igjgp");
                int i10 = (i3 & 896) ^ 384;
                boolean zChanged3 = ((i10 <= 256 && composerStartRestartGroup.changedInstance(forgotPasswordViewModel3)) || (i3 & 384) == 256) | composerStartRestartGroup.changed(stateCollectAsState);
                if ((i3 & 7168) == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = zChanged3 | z2;
                resetPasswordScreenKt$ResetPasswordScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3 || resetPasswordScreenKt$ResetPasswordScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    resetPasswordScreenKt$ResetPasswordScreen$1$1RememberedValue = new ResetPasswordScreenKt$ResetPasswordScreen$1$1(forgotPasswordViewModel3, str4, stateCollectAsState, null);
                    composerStartRestartGroup.updateRememberedValue(resetPasswordScreenKt$ResetPasswordScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(str4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) resetPasswordScreenKt$ResetPasswordScreen$1$1RememberedValue, composerStartRestartGroup, (i3 >> 9) & 14);
                String strResetPasswordScreen$lambda$3 = ResetPasswordScreen$lambda$3(stateCollectAsState2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1392853615, "CC(remember):ResetPasswordScreen.kt#9igjgp");
                zChanged = ((i10 <= 256 && composerStartRestartGroup.changedInstance(forgotPasswordViewModel3)) || (i3 & 384) == 256) | composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope);
                resetPasswordScreenKt$ResetPasswordScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || resetPasswordScreenKt$ResetPasswordScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    resetPasswordScreenKt$ResetPasswordScreen$2$1RememberedValue = new ResetPasswordScreenKt$ResetPasswordScreen$2$1(stateCollectAsState2, coroutineScope, forgotPasswordViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(resetPasswordScreenKt$ResetPasswordScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strResetPasswordScreen$lambda$3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) resetPasswordScreenKt$ResetPasswordScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                Boolean boolValueOf = Boolean.valueOf(ResetPasswordScreen$lambda$4(stateCollectAsState3));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1392847930, "CC(remember):ResetPasswordScreen.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(stateCollectAsState3) | composerStartRestartGroup.changedInstance(navController) | composerStartRestartGroup.changed(stateCollectAsState);
                resetPasswordScreenKt$ResetPasswordScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged2 || resetPasswordScreenKt$ResetPasswordScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    resetPasswordScreenKt$ResetPasswordScreen$3$1RememberedValue = new ResetPasswordScreenKt$ResetPasswordScreen$3$1(navController, stateCollectAsState3, stateCollectAsState, null);
                    composerStartRestartGroup.updateRememberedValue(resetPasswordScreenKt$ResetPasswordScreen$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) resetPasswordScreenKt$ResetPasswordScreen$3$1RememberedValue, composerStartRestartGroup, 0);
                final ForgotPasswordViewModel forgotPasswordViewModel5 = forgotPasswordViewModel3;
                Modifier modifier5 = modifier4;
                ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-920898395, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ResetPasswordScreenKt.ResetPasswordScreen$lambda$11(coroutineScope, navController, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1347724080, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ResetPasswordScreenKt.ResetPasswordScreen$lambda$17(modifier4, forgotPasswordViewModel5, stateCollectAsState, stateCollectAsState5, stateCollectAsState4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                str3 = str4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                str3 = str;
            }
            forgotPasswordViewModel2 = forgotPasswordViewModel3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ResetPasswordScreenKt.ResetPasswordScreen$lambda$18(modifier3, navController, forgotPasswordViewModel2, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        str2 = str;
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "44@2053L15");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
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
                    int i11 = i3;
                    i5 = 1;
                    i4 = 0;
                    ViewModel viewModel2 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(ForgotPasswordViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory2, creationExtras2, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ForgotPasswordViewModel forgotPasswordViewModel6 = (ForgotPasswordViewModel) viewModel2;
                    i3 = i11 & (-897);
                    forgotPasswordViewModel3 = forgotPasswordViewModel6;
                } else {
                    i4 = 0;
                    i5 = 1;
                }
                if (i8 != 0) {
                    modifier4 = companion;
                    str4 = "";
                } else {
                    modifier4 = companion;
                    str4 = str;
                }
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
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
                    int i12 = i3;
                    i5 = 1;
                    i4 = 0;
                    ViewModel viewModel3 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(ForgotPasswordViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory3, creationExtras3, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ForgotPasswordViewModel forgotPasswordViewModel7 = (ForgotPasswordViewModel) viewModel3;
                    i3 = i12 & (-897);
                    forgotPasswordViewModel3 = forgotPasswordViewModel7;
                } else {
                    i4 = 0;
                    i5 = 1;
                }
                if (i8 != 0) {
                    modifier4 = companion;
                    str4 = "";
                } else {
                    modifier4 = companion;
                    str4 = str;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133744865, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreen (ResetPasswordScreen.kt:46)");
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
            stateCollectAsState = SnapshotStateKt.collectAsState(forgotPasswordViewModel3.getEmail(), null, composerStartRestartGroup, i4, i5);
            final State stateCollectAsState6 = SnapshotStateKt.collectAsState(forgotPasswordViewModel3.isLoading(), null, composerStartRestartGroup, i4, i5);
            final State stateCollectAsState7 = SnapshotStateKt.collectAsState(forgotPasswordViewModel3.getEmailError(), null, composerStartRestartGroup, i4, i5);
            stateCollectAsState2 = SnapshotStateKt.collectAsState(forgotPasswordViewModel3.getSnackbarMessage(), null, composerStartRestartGroup, i4, i5);
            stateCollectAsState3 = SnapshotStateKt.collectAsState(forgotPasswordViewModel3.getSendSuccess(), null, composerStartRestartGroup, i4, i5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1392858106, "CC(remember):ResetPasswordScreen.kt#9igjgp");
            int i13 = (i3 & 896) ^ 384;
            boolean zChanged4 = ((i13 <= 256 && composerStartRestartGroup.changedInstance(forgotPasswordViewModel3)) || (i3 & 384) == 256) | composerStartRestartGroup.changed(stateCollectAsState);
            if ((i3 & 7168) == 2048) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = zChanged4 | z2;
            resetPasswordScreenKt$ResetPasswordScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                resetPasswordScreenKt$ResetPasswordScreen$1$1RememberedValue = new ResetPasswordScreenKt$ResetPasswordScreen$1$1(forgotPasswordViewModel3, str4, stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(resetPasswordScreenKt$ResetPasswordScreen$1$1RememberedValue);
            } else {
                resetPasswordScreenKt$ResetPasswordScreen$1$1RememberedValue = new ResetPasswordScreenKt$ResetPasswordScreen$1$1(forgotPasswordViewModel3, str4, stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(resetPasswordScreenKt$ResetPasswordScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(str4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) resetPasswordScreenKt$ResetPasswordScreen$1$1RememberedValue, composerStartRestartGroup, (i3 >> 9) & 14);
            String strResetPasswordScreen$lambda$4 = ResetPasswordScreen$lambda$3(stateCollectAsState2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1392853615, "CC(remember):ResetPasswordScreen.kt#9igjgp");
            zChanged = ((i13 <= 256 && composerStartRestartGroup.changedInstance(forgotPasswordViewModel3)) || (i3 & 384) == 256) | composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope);
            resetPasswordScreenKt$ResetPasswordScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                resetPasswordScreenKt$ResetPasswordScreen$2$1RememberedValue = new ResetPasswordScreenKt$ResetPasswordScreen$2$1(stateCollectAsState2, coroutineScope, forgotPasswordViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(resetPasswordScreenKt$ResetPasswordScreen$2$1RememberedValue);
            } else {
                resetPasswordScreenKt$ResetPasswordScreen$2$1RememberedValue = new ResetPasswordScreenKt$ResetPasswordScreen$2$1(stateCollectAsState2, coroutineScope, forgotPasswordViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(resetPasswordScreenKt$ResetPasswordScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strResetPasswordScreen$lambda$4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) resetPasswordScreenKt$ResetPasswordScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            Boolean boolValueOf2 = Boolean.valueOf(ResetPasswordScreen$lambda$4(stateCollectAsState3));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1392847930, "CC(remember):ResetPasswordScreen.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(stateCollectAsState3) | composerStartRestartGroup.changedInstance(navController) | composerStartRestartGroup.changed(stateCollectAsState);
            resetPasswordScreenKt$ResetPasswordScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                resetPasswordScreenKt$ResetPasswordScreen$3$1RememberedValue = new ResetPasswordScreenKt$ResetPasswordScreen$3$1(navController, stateCollectAsState3, stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(resetPasswordScreenKt$ResetPasswordScreen$3$1RememberedValue);
            } else {
                resetPasswordScreenKt$ResetPasswordScreen$3$1RememberedValue = new ResetPasswordScreenKt$ResetPasswordScreen$3$1(navController, stateCollectAsState3, stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(resetPasswordScreenKt$ResetPasswordScreen$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) resetPasswordScreenKt$ResetPasswordScreen$3$1RememberedValue, composerStartRestartGroup, 0);
            final ForgotPasswordViewModel forgotPasswordViewModel8 = forgotPasswordViewModel3;
            Modifier modifier6 = modifier4;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-920898395, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ResetPasswordScreenKt.ResetPasswordScreen$lambda$11(coroutineScope, navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1347724080, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ResetPasswordScreenKt.ResetPasswordScreen$lambda$17(modifier4, forgotPasswordViewModel8, stateCollectAsState, stateCollectAsState7, stateCollectAsState6, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
            str3 = str4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            str3 = str;
        }
        forgotPasswordViewModel2 = forgotPasswordViewModel3;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ResetPasswordScreenKt.ResetPasswordScreen$lambda$18(modifier3, navController, forgotPasswordViewModel2, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResetPasswordScreen$lambda$11(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C85@3379L420,75@2975L839:ResetPasswordScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-920898395, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreen.<anonymous> (ResetPasswordScreen.kt:75)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$ResetPasswordScreenKt.INSTANCE.m9857getLambda$63589023$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(827485599, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ResetPasswordScreenKt.ResetPasswordScreen$lambda$11$lambda$10(coroutineScope, navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResetPasswordScreen$lambda$11$lambda$10(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C86@3422L239,86@3401L380:ResetPasswordScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(827485599, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreen.<anonymous>.<anonymous> (ResetPasswordScreen.kt:86)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 644712494, "CC(remember):ResetPasswordScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ResetPasswordScreenKt.ResetPasswordScreen$lambda$11$lambda$10$lambda$9$lambda$8(coroutineScope, navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$ResetPasswordScreenKt.INSTANCE.getLambda$1357396161$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResetPasswordScreen$lambda$11$lambda$10$lambda$9$lambda$8(CoroutineScope coroutineScope, NavHostController navHostController) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ResetPasswordScreenKt$ResetPasswordScreen$4$1$1$1$1(navHostController, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResetPasswordScreen$lambda$17(Modifier modifier, final ForgotPasswordViewModel forgotPasswordViewModel, State state, State state2, State state3, PaddingValues paddingValues, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)99@3858L421:ResetPasswordScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i |= composer.changed(paddingValues) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1347724080, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreen.<anonymous> (ResetPasswordScreen.kt:99)");
            }
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(PaddingKt.padding(modifier, paddingValues), Dp.m8684constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1118padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1240663594, "C108@4166L32,109@4227L28,104@3994L275:ResetPasswordScreen.kt#oif8tm");
            String strResetPasswordScreen$lambda$0 = ResetPasswordScreen$lambda$0(state);
            String strResetPasswordScreen$lambda$2 = ResetPasswordScreen$lambda$2(state2);
            boolean zResetPasswordScreen$lambda$1 = ResetPasswordScreen$lambda$1(state3);
            ComposerKt.sourceInformationMarkerStart(composer, -732752806, "CC(remember):ResetPasswordScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(forgotPasswordViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ResetPasswordScreenKt.ResetPasswordScreen$lambda$17$lambda$16$lambda$13$lambda$12(forgotPasswordViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -732750858, "CC(remember):ResetPasswordScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(forgotPasswordViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ResetPasswordScreenKt.ResetPasswordScreen$lambda$17$lambda$16$lambda$15$lambda$14(forgotPasswordViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ResetPasswordScreenContent(strResetPasswordScreen$lambda$0, zResetPasswordScreen$lambda$1, function1, strResetPasswordScreen$lambda$2, (Function0) objRememberedValue2, composer, 0, 0);
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
    public static final Unit ResetPasswordScreen$lambda$17$lambda$16$lambda$13$lambda$12(ForgotPasswordViewModel forgotPasswordViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        forgotPasswordViewModel.onEmailChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResetPasswordScreen$lambda$17$lambda$16$lambda$15$lambda$14(ForgotPasswordViewModel forgotPasswordViewModel) {
        forgotPasswordViewModel.sendResetPin();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:104:0x031b  */
    /* JADX WARN: Code duplicated, block: B:106:0x0320  */
    /* JADX WARN: Code duplicated, block: B:109:0x032c  */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x005d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0063  */
    /* JADX WARN: Code duplicated, block: B:29:0x0066  */
    /* JADX WARN: Code duplicated, block: B:33:0x006d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0070  */
    /* JADX WARN: Code duplicated, block: B:36:0x0074  */
    /* JADX WARN: Code duplicated, block: B:38:0x007c  */
    /* JADX WARN: Code duplicated, block: B:39:0x007f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x008f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x009f  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:67:0x010f  */
    /* JADX WARN: Code duplicated, block: B:70:0x011b  */
    /* JADX WARN: Code duplicated, block: B:71:0x011f  */
    /* JADX WARN: Code duplicated, block: B:74:0x0144  */
    /* JADX WARN: Code duplicated, block: B:76:0x0152  */
    /* JADX WARN: Code duplicated, block: B:79:0x019c  */
    /* JADX WARN: Code duplicated, block: B:80:0x019e  */
    /* JADX WARN: Code duplicated, block: B:83:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:88:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:89:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:92:0x025d  */
    /* JADX WARN: Code duplicated, block: B:95:0x0269  */
    /* JADX WARN: Code duplicated, block: B:96:0x026d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0292  */
    public static final void ResetPasswordScreenContent(String str, boolean z, final Function1<? super String, Unit> onEmailChanged, String str2, final Function0<Unit> onSubmit, Composer composer, final int i, final int i2) {
        String str3;
        int i3;
        boolean z2;
        int i4;
        String str4;
        int i5;
        boolean z3;
        final String str5;
        final boolean z4;
        final String str6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z5;
        Object objRememberedValue;
        boolean z6;
        int iHashCode2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM5259constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(onEmailChanged, "onEmailChanged");
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
        Composer composerStartRestartGroup = composer.startRestartGroup(435658728);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ResetPasswordScreenContent)N(email,isLoading,onEmailChanged,emailError,onSubmit)123@4493L1267:ResetPasswordScreen.kt#oif8tm");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            str3 = str;
        } else if ((i & 6) == 0) {
            str3 = str;
            i3 = (composerStartRestartGroup.changed(str3) ? 4 : 2) | i;
        } else {
            str3 = str;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(onEmailChanged)) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
                i3 |= i7;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    str4 = str2;
                    if (composerStartRestartGroup.changed(str4)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(onSubmit)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i3 |= i6;
                }
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str5 = str3;
                    z4 = z2;
                } else {
                    if (i8 != 0) {
                        str3 = "";
                    }
                    if (i9 != 0) {
                        z4 = false;
                    } else {
                        z4 = z2;
                    }
                    if (i4 != 0) {
                        str4 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(435658728, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenContent (ResetPasswordScreen.kt:122)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 392378357, "C124@4510L41,127@4635L22,125@4560L324,134@4893L41,135@4943L811:ResetPasswordScreen.kt#oif8tm");
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -264434520, "CC(remember):ResetPasswordScreen.kt#9igjgp");
                    if ((i3 & 896) == 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$23$lambda$20$lambda$19(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function1 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (str4 != null) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    int i10 = i3;
                    String str7 = str4;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(str3, function1, "Enter your Email", z6, str7, KeyboardType.INSTANCE.m8356getEmailPjHm6EE(), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, composerStartRestartGroup, (i3 & 14) | 1769856 | ((i3 << 3) & 57344), 128);
                    String str8 = str3;
                    str4 = str7;
                    composerStartRestartGroup = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), composerStartRestartGroup, 6);
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM5259constructorimpl2 = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 44999393, "C142@5156L588,138@5020L724:ResetPasswordScreen.kt#oif8tm");
                    CustomButtonKt.CustomButton(onSubmit, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(200955962, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$23$lambda$22$lambda$21(z4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i10 >> 12) & 14) | 24624, 12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str5 = str8;
                }
                str6 = str4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$24(str5, z4, onEmailChanged, str6, onSubmit, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            str4 = str2;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onSubmit)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str5 = str3;
                z4 = z2;
            } else {
                if (i8 != 0) {
                    str3 = "";
                }
                if (i9 != 0) {
                    z4 = false;
                } else {
                    z4 = z2;
                }
                if (i4 != 0) {
                    str4 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(435658728, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenContent (ResetPasswordScreen.kt:122)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 392378357, "C124@4510L41,127@4635L22,125@4560L324,134@4893L41,135@4943L811:ResetPasswordScreen.kt#oif8tm");
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -264434520, "CC(remember):ResetPasswordScreen.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$23$lambda$20$lambda$19(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$23$lambda$20$lambda$19(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function1 function2 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (str4 != null) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int i11 = i3;
                String str9 = str4;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(str3, function2, "Enter your Email", z6, str9, KeyboardType.INSTANCE.m8356getEmailPjHm6EE(), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, composerStartRestartGroup, (i3 & 14) | 1769856 | ((i3 << 3) & 57344), 128);
                String str10 = str3;
                str4 = str9;
                composerStartRestartGroup = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM5259constructorimpl2 = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 44999393, "C142@5156L588,138@5020L724:ResetPasswordScreen.kt#oif8tm");
                CustomButtonKt.CustomButton(onSubmit, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(200955962, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$23$lambda$22$lambda$21(z4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i11 >> 12) & 14) | 24624, 12);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str5 = str10;
            }
            str6 = str4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$24(str5, z4, onEmailChanged, str6, onSubmit, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z2 = z;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(onEmailChanged)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i3 |= i7;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                str4 = str2;
                if (composerStartRestartGroup.changed(str4)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onSubmit)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str5 = str3;
                z4 = z2;
            } else {
                if (i8 != 0) {
                    str3 = "";
                }
                if (i9 != 0) {
                    z4 = false;
                } else {
                    z4 = z2;
                }
                if (i4 != 0) {
                    str4 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(435658728, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenContent (ResetPasswordScreen.kt:122)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier.Companion companion3 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 392378357, "C124@4510L41,127@4635L22,125@4560L324,134@4893L41,135@4943L811:ResetPasswordScreen.kt#oif8tm");
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -264434520, "CC(remember):ResetPasswordScreen.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$23$lambda$20$lambda$19(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$23$lambda$20$lambda$19(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function1 function3 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (str4 != null) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                int i12 = i3;
                String str11 = str4;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(str3, function3, "Enter your Email", z6, str11, KeyboardType.INSTANCE.m8356getEmailPjHm6EE(), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, composerStartRestartGroup, (i3 & 14) | 1769856 | ((i3 << 3) & 57344), 128);
                String str12 = str3;
                str4 = str11;
                composerStartRestartGroup = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default3);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM5259constructorimpl2 = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 44999393, "C142@5156L588,138@5020L724:ResetPasswordScreen.kt#oif8tm");
                CustomButtonKt.CustomButton(onSubmit, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(200955962, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$23$lambda$22$lambda$21(z4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i12 >> 12) & 14) | 24624, 12);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str5 = str12;
            }
            str6 = str4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$24(str5, z4, onEmailChanged, str6, onSubmit, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        str4 = str2;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(onSubmit)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i3 |= i6;
        }
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            str5 = str3;
            z4 = z2;
        } else {
            if (i8 != 0) {
                str3 = "";
            }
            if (i9 != 0) {
                z4 = false;
            } else {
                z4 = z2;
            }
            if (i4 != 0) {
                str4 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(435658728, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenContent (ResetPasswordScreen.kt:122)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion4 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl.getInserting()) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            } else {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 392378357, "C124@4510L41,127@4635L22,125@4560L324,134@4893L41,135@4943L811:ResetPasswordScreen.kt#oif8tm");
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -264434520, "CC(remember):ResetPasswordScreen.kt#9igjgp");
            if ((i3 & 896) == 256) {
                z5 = true;
            } else {
                z5 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$23$lambda$20$lambda$19(onEmailChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$23$lambda$20$lambda$19(onEmailChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function4 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (str4 != null) {
                z6 = true;
            } else {
                z6 = false;
            }
            int i13 = i3;
            String str13 = str4;
            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(str3, function4, "Enter your Email", z6, str13, KeyboardType.INSTANCE.m8356getEmailPjHm6EE(), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, composerStartRestartGroup, (i3 & 14) | 1769856 | ((i3 << 3) & 57344), 128);
            String str14 = str3;
            str4 = str13;
            composerStartRestartGroup = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), composerStartRestartGroup, 6);
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default4);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM5259constructorimpl2 = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl2.getInserting()) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            } else {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 44999393, "C142@5156L588,138@5020L724:ResetPasswordScreen.kt#oif8tm");
            CustomButtonKt.CustomButton(onSubmit, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(200955962, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$23$lambda$22$lambda$21(z4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 12) & 14) | 24624, 12);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str5 = str14;
        }
        str6 = str4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ResetPasswordScreenKt.ResetPasswordScreenContent$lambda$24(str5, z4, onEmailChanged, str6, onSubmit, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResetPasswordScreenContent$lambda$23$lambda$20$lambda$19(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResetPasswordScreenContent$lambda$23$lambda$22$lambda$21(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ResetPasswordScreen.kt#oif8tm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(200955962, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenContent.<anonymous>.<anonymous>.<anonymous> (ResetPasswordScreen.kt:143)");
            }
            if (z) {
                composer.startReplaceGroup(-505311867);
                ComposerKt.sourceInformation(composer, "144@5211L27");
                ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(null, 0L, 0.0f, 0L, 0, 0.0f, composer, 0, 63);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-505227020);
                ComposerKt.sourceInformation(composer, "148@5375L10,150@5515L11,146@5284L428");
                TextKt.m3864TextNvy7gAk("Send", PaddingKt.m1119paddingVpY3zN4(Modifier.INSTANCE, Dp.m8684constructorimpl(32), Dp.m8684constructorimpl(6)), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer, 54, 0, 131068);
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

    private static final void ResetPasswordScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1823373640);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ResetPasswordScreenPreview)166@5923L2,168@5973L2,164@5832L149:ResetPasswordScreen.kt#oif8tm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1823373640, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenPreview (ResetPasswordScreen.kt:163)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 84593818, "CC(remember):ResetPasswordScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ResetPasswordScreenKt.ResetPasswordScreenPreview$lambda$26$lambda$25((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 84595418, "CC(remember):ResetPasswordScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ResetPasswordScreenContent("john.doe@gmail.com", false, function1, null, (Function0) objRememberedValue2, composerStartRestartGroup, 28038, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ResetPasswordScreenKt.ResetPasswordScreenPreview$lambda$29(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResetPasswordScreenPreview$lambda$26$lambda$25(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ResetPasswordScreen$lambda$0(State<String> state) {
        return state.getValue();
    }

    private static final boolean ResetPasswordScreen$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String ResetPasswordScreen$lambda$2(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ResetPasswordScreen$lambda$3(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ResetPasswordScreen$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
