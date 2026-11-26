package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.text.style.TextAlign;
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
import androidx.profileinstaller.ProfileVerifier;
import com.example.bingwahybrid.presentation.ui.components.KeypadKt;
import com.example.bingwahybrid.presentation.ui.components.PinRowKt;
import com.example.bingwahybrid.presentation.viewmodel.PinSetupViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PinSetupScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001az\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010\u0010\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\f\u0010\u001d\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002"}, d2 = {"PinSetupScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/PinSetupViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/viewmodel/PinSetupViewModel;Landroidx/compose/runtime/Composer;II)V", "PinSetupScreenContent", "pin", "", "confirmPin", "isLoading", "", "isConfirming", "isPinError", "onNumberClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "number", "onDeletePin", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;ZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PreviewSetupPinScreen", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "pinSetupSuccess", "snackbarMessage"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PinSetupScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinSetupScreen$lambda$13(Modifier modifier, NavHostController navHostController, PinSetupViewModel pinSetupViewModel, int i, int i2, Composer composer, int i3) {
        PinSetupScreen(modifier, navHostController, pinSetupViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinSetupScreenContent$lambda$23(Modifier modifier, String str, String str2, boolean z, boolean z2, boolean z3, Function1 function1, Function0 function0, int i, int i2, Composer composer, int i3) {
        PinSetupScreenContent(modifier, str, str2, z, z2, z3, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewSetupPinScreen$lambda$28(int i, Composer composer, int i2) {
        PreviewSetupPinScreen(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x024f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0257  */
    /* JADX WARN: Code duplicated, block: B:110:0x026f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0275  */
    /* JADX WARN: Code duplicated, block: B:118:0x0282  */
    /* JADX WARN: Code duplicated, block: B:120:0x028a  */
    /* JADX WARN: Code duplicated, block: B:123:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:125:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:128:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072  */
    /* JADX WARN: Code duplicated, block: B:39:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:51:0x009c A[PHI: r2 r3 r14
  0x009c: PHI (r2v14 androidx.compose.ui.Modifier) = (r2v6 androidx.compose.ui.Modifier), (r2v16 androidx.compose.ui.Modifier) binds: [B:59:0x00af, B:50:0x009a] A[DONT_GENERATE, DONT_INLINE]
  0x009c: PHI (r3v30 androidx.navigation.NavHostController) = (r3v6 androidx.navigation.NavHostController), (r3v31 androidx.navigation.NavHostController) binds: [B:59:0x00af, B:50:0x009a] A[DONT_GENERATE, DONT_INLINE]
  0x009c: PHI (r14v4 int) = (r14v0 int), (r14v5 int) binds: [B:59:0x00af, B:50:0x009a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:67:0x010c  */
    /* JADX WARN: Code duplicated, block: B:71:0x0121  */
    /* JADX WARN: Code duplicated, block: B:74:0x0143  */
    /* JADX WARN: Code duplicated, block: B:77:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:79:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f7 A[PHI: r17
  0x01f7: PHI (r17v3 androidx.navigation.NavHostController) = (r17v1 androidx.navigation.NavHostController), (r17v5 androidx.navigation.NavHostController) binds: [B:87:0x01f5, B:85:0x01ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:89:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:92:0x0201  */
    /* JADX WARN: Code duplicated, block: B:94:0x0209  */
    /* JADX WARN: Code duplicated, block: B:97:0x023c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0242  */
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
    public static final void PinSetupScreen(Modifier modifier, NavHostController navHostController, PinSetupViewModel pinSetupViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        NavHostController navHostController2;
        int i4;
        boolean z;
        final Modifier modifier3;
        final NavHostController navHostController3;
        final PinSetupViewModel pinSetupViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        NavHostController navHostController4;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        CoroutineContext coroutineContext;
        int i5;
        Object objRememberedValue;
        CoroutineScope coroutineScope;
        State stateCollectAsState;
        State stateCollectAsState2;
        boolean zChanged;
        PinSetupScreenKt$PinSetupScreen$1$1 pinSetupScreenKt$PinSetupScreen$1$1RememberedValue;
        int i6;
        NavHostController navHostController5;
        boolean z2;
        boolean z3;
        PinSetupScreenKt$PinSetupScreen$2$1 pinSetupScreenKt$PinSetupScreen$2$1RememberedValue;
        boolean z4;
        Object objRememberedValue2;
        boolean z5;
        Object objRememberedValue3;
        int i7;
        boolean zChangedInstance;
        final PinSetupViewModel pinSetupViewModel3 = pinSetupViewModel;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1649958228);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PinSetupScreen)N(modifier,navController,viewModel)36@1591L24,37@1645L16,38@1705L16,39@1769L16,40@1829L16,41@1887L16,42@1957L16,43@2027L16,45@2081L101,45@2049L133,51@2220L144,51@2188L176,65@2599L45,66@2668L27,58@2370L331:PinSetupScreen.kt#oif8tm");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                navHostController2 = navHostController;
                i3 |= composerStartRestartGroup.changedInstance(navHostController2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) != 0) {
                    i7 = 128;
                } else {
                    if ((i & 512) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(pinSetupViewModel3);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(pinSetupViewModel3);
                    }
                    if (zChangedInstance) {
                        i7 = 256;
                    } else {
                        i7 = 128;
                    }
                }
                i3 |= i7;
            }
            i4 = i3;
            if ((i4 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "34@1554L15");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        navHostController4 = null;
                    } else {
                        navHostController4 = navHostController2;
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
                        ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(PinSetupViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        PinSetupViewModel pinSetupViewModel4 = (PinSetupViewModel) viewModel;
                        i4 &= -897;
                        coroutineContext = null;
                        pinSetupViewModel3 = pinSetupViewModel4;
                        i5 = 1;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1649958228, i4, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreen (PinSetupScreen.kt:35)");
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
                    State stateCollectAsState3 = SnapshotStateKt.collectAsState(pinSetupViewModel3.getPin(), coroutineContext, composerStartRestartGroup, 0, i5);
                    State stateCollectAsState4 = SnapshotStateKt.collectAsState(pinSetupViewModel3.getConfirmPin(), coroutineContext, composerStartRestartGroup, 0, i5);
                    State stateCollectAsState5 = SnapshotStateKt.collectAsState(pinSetupViewModel3.isConfirming(), coroutineContext, composerStartRestartGroup, 0, i5);
                    State stateCollectAsState6 = SnapshotStateKt.collectAsState(pinSetupViewModel3.isPinError(), coroutineContext, composerStartRestartGroup, 0, i5);
                    State stateCollectAsState7 = SnapshotStateKt.collectAsState(pinSetupViewModel3.isLoading(), coroutineContext, composerStartRestartGroup, 0, i5);
                    stateCollectAsState = SnapshotStateKt.collectAsState(pinSetupViewModel3.getPinSetupSuccess(), coroutineContext, composerStartRestartGroup, 0, i5);
                    Modifier modifier4 = companion;
                    stateCollectAsState2 = SnapshotStateKt.collectAsState(pinSetupViewModel3.getSnackbarMessage(), coroutineContext, composerStartRestartGroup, 0, i5);
                    Boolean boolValueOf = Boolean.valueOf(PinSetupScreen$lambda$5(stateCollectAsState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766903183, "CC(remember):PinSetupScreen.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(navHostController4);
                    pinSetupScreenKt$PinSetupScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || pinSetupScreenKt$PinSetupScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        pinSetupScreenKt$PinSetupScreen$1$1RememberedValue = new PinSetupScreenKt$PinSetupScreen$1$1(navHostController4, stateCollectAsState, null);
                        composerStartRestartGroup.updateRememberedValue(pinSetupScreenKt$PinSetupScreen$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinSetupScreenKt$PinSetupScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                    String strPinSetupScreen$lambda$6 = PinSetupScreen$lambda$6(stateCollectAsState2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766898692, "CC(remember):PinSetupScreen.kt#9igjgp");
                    boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope);
                    i6 = (i4 & 896) ^ 384;
                    if (i6 > 256 || !composerStartRestartGroup.changedInstance(pinSetupViewModel3)) {
                        navHostController5 = navHostController4;
                        if ((i4 & 384) != 256) {
                            z2 = false;
                        }
                        z3 = z2 | zChanged2;
                        pinSetupScreenKt$PinSetupScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3 || pinSetupScreenKt$PinSetupScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            pinSetupScreenKt$PinSetupScreen$2$1RememberedValue = new PinSetupScreenKt$PinSetupScreen$2$1(stateCollectAsState2, coroutineScope, pinSetupViewModel3, null);
                            composerStartRestartGroup.updateRememberedValue(pinSetupScreenKt$PinSetupScreen$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(strPinSetupScreen$lambda$6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinSetupScreenKt$PinSetupScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                        String strPinSetupScreen$lambda$0 = PinSetupScreen$lambda$0(stateCollectAsState3);
                        String strPinSetupScreen$lambda$1 = PinSetupScreen$lambda$1(stateCollectAsState4);
                        boolean zPinSetupScreen$lambda$4 = PinSetupScreen$lambda$4(stateCollectAsState7);
                        boolean zPinSetupScreen$lambda$2 = PinSetupScreen$lambda$2(stateCollectAsState5);
                        boolean zPinSetupScreen$lambda$3 = PinSetupScreen$lambda$3(stateCollectAsState6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766886663, "CC(remember):PinSetupScreen.kt#9igjgp");
                        z4 = (i6 <= 256 && composerStartRestartGroup.changedInstance(pinSetupViewModel3)) || (i4 & 384) == 256;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return PinSetupScreenKt.PinSetupScreen$lambda$10$lambda$9(pinSetupViewModel3, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function1 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766884473, "CC(remember):PinSetupScreen.kt#9igjgp");
                        z5 = (i6 <= 256 && composerStartRestartGroup.changedInstance(pinSetupViewModel3)) || (i4 & 384) == 256;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return PinSetupScreenKt.PinSetupScreen$lambda$12$lambda$11(pinSetupViewModel3);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        PinSetupScreenContent(modifier4, strPinSetupScreen$lambda$0, strPinSetupScreen$lambda$1, zPinSetupScreen$lambda$4, zPinSetupScreen$lambda$2, zPinSetupScreen$lambda$3, function1, (Function0) objRememberedValue3, composerStartRestartGroup, i4 & 14, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        navHostController3 = navHostController5;
                    } else {
                        navHostController5 = navHostController4;
                    }
                    z2 = true;
                    z3 = z2 | zChanged2;
                    pinSetupScreenKt$PinSetupScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        pinSetupScreenKt$PinSetupScreen$2$1RememberedValue = new PinSetupScreenKt$PinSetupScreen$2$1(stateCollectAsState2, coroutineScope, pinSetupViewModel3, null);
                        composerStartRestartGroup.updateRememberedValue(pinSetupScreenKt$PinSetupScreen$2$1RememberedValue);
                    } else {
                        pinSetupScreenKt$PinSetupScreen$2$1RememberedValue = new PinSetupScreenKt$PinSetupScreen$2$1(stateCollectAsState2, coroutineScope, pinSetupViewModel3, null);
                        composerStartRestartGroup.updateRememberedValue(pinSetupScreenKt$PinSetupScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(strPinSetupScreen$lambda$6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinSetupScreenKt$PinSetupScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                    String strPinSetupScreen$lambda$2 = PinSetupScreen$lambda$0(stateCollectAsState3);
                    String strPinSetupScreen$lambda$3 = PinSetupScreen$lambda$1(stateCollectAsState4);
                    boolean zPinSetupScreen$lambda$5 = PinSetupScreen$lambda$4(stateCollectAsState7);
                    boolean zPinSetupScreen$lambda$6 = PinSetupScreen$lambda$2(stateCollectAsState5);
                    boolean zPinSetupScreen$lambda$7 = PinSetupScreen$lambda$3(stateCollectAsState6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766886663, "CC(remember):PinSetupScreen.kt#9igjgp");
                    if (i6 <= 256) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z4) {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return PinSetupScreenKt.PinSetupScreen$lambda$10$lambda$9(pinSetupViewModel3, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return PinSetupScreenKt.PinSetupScreen$lambda$10$lambda$9(pinSetupViewModel3, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function2 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766884473, "CC(remember):PinSetupScreen.kt#9igjgp");
                    if (i6 <= 256) {
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PinSetupScreenKt.PinSetupScreen$lambda$12$lambda$11(pinSetupViewModel3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PinSetupScreenKt.PinSetupScreen$lambda$12$lambda$11(pinSetupViewModel3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PinSetupScreenContent(modifier4, strPinSetupScreen$lambda$2, strPinSetupScreen$lambda$3, zPinSetupScreen$lambda$5, zPinSetupScreen$lambda$6, zPinSetupScreen$lambda$7, function2, (Function0) objRememberedValue3, composerStartRestartGroup, i4 & 14, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    navHostController3 = navHostController5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i4 &= -897;
                    }
                    companion = modifier2;
                    navHostController4 = navHostController2;
                }
                coroutineContext = null;
                i5 = 1;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1649958228, i4, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreen (PinSetupScreen.kt:35)");
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
                State stateCollectAsState8 = SnapshotStateKt.collectAsState(pinSetupViewModel3.getPin(), coroutineContext, composerStartRestartGroup, 0, i5);
                State stateCollectAsState9 = SnapshotStateKt.collectAsState(pinSetupViewModel3.getConfirmPin(), coroutineContext, composerStartRestartGroup, 0, i5);
                State stateCollectAsState10 = SnapshotStateKt.collectAsState(pinSetupViewModel3.isConfirming(), coroutineContext, composerStartRestartGroup, 0, i5);
                State stateCollectAsState11 = SnapshotStateKt.collectAsState(pinSetupViewModel3.isPinError(), coroutineContext, composerStartRestartGroup, 0, i5);
                State stateCollectAsState12 = SnapshotStateKt.collectAsState(pinSetupViewModel3.isLoading(), coroutineContext, composerStartRestartGroup, 0, i5);
                stateCollectAsState = SnapshotStateKt.collectAsState(pinSetupViewModel3.getPinSetupSuccess(), coroutineContext, composerStartRestartGroup, 0, i5);
                Modifier modifier5 = companion;
                stateCollectAsState2 = SnapshotStateKt.collectAsState(pinSetupViewModel3.getSnackbarMessage(), coroutineContext, composerStartRestartGroup, 0, i5);
                Boolean boolValueOf2 = Boolean.valueOf(PinSetupScreen$lambda$5(stateCollectAsState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766903183, "CC(remember):PinSetupScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(navHostController4);
                pinSetupScreenKt$PinSetupScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    pinSetupScreenKt$PinSetupScreen$1$1RememberedValue = new PinSetupScreenKt$PinSetupScreen$1$1(navHostController4, stateCollectAsState, null);
                    composerStartRestartGroup.updateRememberedValue(pinSetupScreenKt$PinSetupScreen$1$1RememberedValue);
                } else {
                    pinSetupScreenKt$PinSetupScreen$1$1RememberedValue = new PinSetupScreenKt$PinSetupScreen$1$1(navHostController4, stateCollectAsState, null);
                    composerStartRestartGroup.updateRememberedValue(pinSetupScreenKt$PinSetupScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinSetupScreenKt$PinSetupScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                String strPinSetupScreen$lambda$7 = PinSetupScreen$lambda$6(stateCollectAsState2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766898692, "CC(remember):PinSetupScreen.kt#9igjgp");
                boolean zChanged3 = composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope);
                i6 = (i4 & 896) ^ 384;
                if (i6 > 256) {
                    navHostController5 = navHostController4;
                    if ((i4 & 384) != 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    navHostController5 = navHostController4;
                    if ((i4 & 384) != 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                z3 = z2 | zChanged3;
                pinSetupScreenKt$PinSetupScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    pinSetupScreenKt$PinSetupScreen$2$1RememberedValue = new PinSetupScreenKt$PinSetupScreen$2$1(stateCollectAsState2, coroutineScope, pinSetupViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(pinSetupScreenKt$PinSetupScreen$2$1RememberedValue);
                } else {
                    pinSetupScreenKt$PinSetupScreen$2$1RememberedValue = new PinSetupScreenKt$PinSetupScreen$2$1(stateCollectAsState2, coroutineScope, pinSetupViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(pinSetupScreenKt$PinSetupScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strPinSetupScreen$lambda$7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinSetupScreenKt$PinSetupScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                String strPinSetupScreen$lambda$4 = PinSetupScreen$lambda$0(stateCollectAsState8);
                String strPinSetupScreen$lambda$5 = PinSetupScreen$lambda$1(stateCollectAsState9);
                boolean zPinSetupScreen$lambda$8 = PinSetupScreen$lambda$4(stateCollectAsState12);
                boolean zPinSetupScreen$lambda$9 = PinSetupScreen$lambda$2(stateCollectAsState10);
                boolean zPinSetupScreen$lambda$10 = PinSetupScreen$lambda$3(stateCollectAsState11);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766886663, "CC(remember):PinSetupScreen.kt#9igjgp");
                if (i6 <= 256) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z4) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PinSetupScreenKt.PinSetupScreen$lambda$10$lambda$9(pinSetupViewModel3, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PinSetupScreenKt.PinSetupScreen$lambda$10$lambda$9(pinSetupViewModel3, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function3 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766884473, "CC(remember):PinSetupScreen.kt#9igjgp");
                if (i6 <= 256) {
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PinSetupScreenKt.PinSetupScreen$lambda$12$lambda$11(pinSetupViewModel3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PinSetupScreenKt.PinSetupScreen$lambda$12$lambda$11(pinSetupViewModel3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PinSetupScreenContent(modifier5, strPinSetupScreen$lambda$4, strPinSetupScreen$lambda$5, zPinSetupScreen$lambda$8, zPinSetupScreen$lambda$9, zPinSetupScreen$lambda$10, function3, (Function0) objRememberedValue3, composerStartRestartGroup, i4 & 14, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                navHostController3 = navHostController5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                navHostController3 = navHostController2;
            }
            pinSetupViewModel2 = pinSetupViewModel3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PinSetupScreenKt.PinSetupScreen$lambda$13(modifier3, navHostController3, pinSetupViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        navHostController2 = navHostController;
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i7 = 128;
            } else {
                if ((i & 512) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(pinSetupViewModel3);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(pinSetupViewModel3);
                }
                if (zChangedInstance) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
            }
            i3 |= i7;
        }
        i4 = i3;
        if ((i4 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "34@1554L15");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    navHostController4 = null;
                } else {
                    navHostController4 = navHostController2;
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
                    ViewModel viewModel2 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(PinSetupViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory2, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PinSetupViewModel pinSetupViewModel5 = (PinSetupViewModel) viewModel2;
                    i4 &= -897;
                    coroutineContext = null;
                    pinSetupViewModel3 = pinSetupViewModel5;
                    i5 = 1;
                } else {
                    coroutineContext = null;
                    i5 = 1;
                }
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    navHostController4 = null;
                } else {
                    navHostController4 = navHostController2;
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
                    ViewModel viewModel3 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(PinSetupViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory3, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PinSetupViewModel pinSetupViewModel6 = (PinSetupViewModel) viewModel3;
                    i4 &= -897;
                    coroutineContext = null;
                    pinSetupViewModel3 = pinSetupViewModel6;
                    i5 = 1;
                } else {
                    coroutineContext = null;
                    i5 = 1;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1649958228, i4, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreen (PinSetupScreen.kt:35)");
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
            State stateCollectAsState13 = SnapshotStateKt.collectAsState(pinSetupViewModel3.getPin(), coroutineContext, composerStartRestartGroup, 0, i5);
            State stateCollectAsState14 = SnapshotStateKt.collectAsState(pinSetupViewModel3.getConfirmPin(), coroutineContext, composerStartRestartGroup, 0, i5);
            State stateCollectAsState15 = SnapshotStateKt.collectAsState(pinSetupViewModel3.isConfirming(), coroutineContext, composerStartRestartGroup, 0, i5);
            State stateCollectAsState16 = SnapshotStateKt.collectAsState(pinSetupViewModel3.isPinError(), coroutineContext, composerStartRestartGroup, 0, i5);
            State stateCollectAsState17 = SnapshotStateKt.collectAsState(pinSetupViewModel3.isLoading(), coroutineContext, composerStartRestartGroup, 0, i5);
            stateCollectAsState = SnapshotStateKt.collectAsState(pinSetupViewModel3.getPinSetupSuccess(), coroutineContext, composerStartRestartGroup, 0, i5);
            Modifier modifier6 = companion;
            stateCollectAsState2 = SnapshotStateKt.collectAsState(pinSetupViewModel3.getSnackbarMessage(), coroutineContext, composerStartRestartGroup, 0, i5);
            Boolean boolValueOf3 = Boolean.valueOf(PinSetupScreen$lambda$5(stateCollectAsState));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766903183, "CC(remember):PinSetupScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(navHostController4);
            pinSetupScreenKt$PinSetupScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                pinSetupScreenKt$PinSetupScreen$1$1RememberedValue = new PinSetupScreenKt$PinSetupScreen$1$1(navHostController4, stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(pinSetupScreenKt$PinSetupScreen$1$1RememberedValue);
            } else {
                pinSetupScreenKt$PinSetupScreen$1$1RememberedValue = new PinSetupScreenKt$PinSetupScreen$1$1(navHostController4, stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(pinSetupScreenKt$PinSetupScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinSetupScreenKt$PinSetupScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            String strPinSetupScreen$lambda$8 = PinSetupScreen$lambda$6(stateCollectAsState2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766898692, "CC(remember):PinSetupScreen.kt#9igjgp");
            boolean zChanged4 = composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope);
            i6 = (i4 & 896) ^ 384;
            if (i6 > 256) {
                navHostController5 = navHostController4;
                if ((i4 & 384) != 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                navHostController5 = navHostController4;
                if ((i4 & 384) != 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            z3 = z2 | zChanged4;
            pinSetupScreenKt$PinSetupScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                pinSetupScreenKt$PinSetupScreen$2$1RememberedValue = new PinSetupScreenKt$PinSetupScreen$2$1(stateCollectAsState2, coroutineScope, pinSetupViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(pinSetupScreenKt$PinSetupScreen$2$1RememberedValue);
            } else {
                pinSetupScreenKt$PinSetupScreen$2$1RememberedValue = new PinSetupScreenKt$PinSetupScreen$2$1(stateCollectAsState2, coroutineScope, pinSetupViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(pinSetupScreenKt$PinSetupScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strPinSetupScreen$lambda$8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinSetupScreenKt$PinSetupScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            String strPinSetupScreen$lambda$9 = PinSetupScreen$lambda$0(stateCollectAsState13);
            String strPinSetupScreen$lambda$10 = PinSetupScreen$lambda$1(stateCollectAsState14);
            boolean zPinSetupScreen$lambda$11 = PinSetupScreen$lambda$4(stateCollectAsState17);
            boolean zPinSetupScreen$lambda$12 = PinSetupScreen$lambda$2(stateCollectAsState15);
            boolean zPinSetupScreen$lambda$13 = PinSetupScreen$lambda$3(stateCollectAsState16);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766886663, "CC(remember):PinSetupScreen.kt#9igjgp");
            if (i6 <= 256) {
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z4) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PinSetupScreenKt.PinSetupScreen$lambda$10$lambda$9(pinSetupViewModel3, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PinSetupScreenKt.PinSetupScreen$lambda$10$lambda$9(pinSetupViewModel3, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function4 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -766884473, "CC(remember):PinSetupScreen.kt#9igjgp");
            if (i6 <= 256) {
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PinSetupScreenKt.PinSetupScreen$lambda$12$lambda$11(pinSetupViewModel3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PinSetupScreenKt.PinSetupScreen$lambda$12$lambda$11(pinSetupViewModel3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            PinSetupScreenContent(modifier6, strPinSetupScreen$lambda$9, strPinSetupScreen$lambda$10, zPinSetupScreen$lambda$11, zPinSetupScreen$lambda$12, zPinSetupScreen$lambda$13, function4, (Function0) objRememberedValue3, composerStartRestartGroup, i4 & 14, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
            navHostController3 = navHostController5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            navHostController3 = navHostController2;
        }
        pinSetupViewModel2 = pinSetupViewModel3;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PinSetupScreenKt.PinSetupScreen$lambda$13(modifier3, navHostController3, pinSetupViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinSetupScreen$lambda$10$lambda$9(PinSetupViewModel pinSetupViewModel, String number) {
        Intrinsics.checkNotNullParameter(number, "number");
        pinSetupViewModel.onNumberClick(number);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinSetupScreen$lambda$12$lambda$11(PinSetupViewModel pinSetupViewModel) {
        pinSetupViewModel.onDeletePin();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0127  */
    /* JADX WARN: Code duplicated, block: B:102:0x012b  */
    /* JADX WARN: Code duplicated, block: B:103:0x012e  */
    /* JADX WARN: Code duplicated, block: B:106:0x0136  */
    /* JADX WARN: Code duplicated, block: B:109:0x0178  */
    /* JADX WARN: Code duplicated, block: B:111:0x0184  */
    /* JADX WARN: Code duplicated, block: B:114:0x0196  */
    /* JADX WARN: Code duplicated, block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:27:0x005f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0063  */
    /* JADX WARN: Code duplicated, block: B:31:0x006b  */
    /* JADX WARN: Code duplicated, block: B:32:0x006e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0078  */
    /* JADX WARN: Code duplicated, block: B:38:0x007b  */
    /* JADX WARN: Code duplicated, block: B:40:0x007f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0087  */
    /* JADX WARN: Code duplicated, block: B:43:0x008a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0094  */
    /* JADX WARN: Code duplicated, block: B:49:0x0097  */
    /* JADX WARN: Code duplicated, block: B:51:0x009b  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00be  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00da  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:83:0x0100  */
    /* JADX WARN: Code duplicated, block: B:84:0x0102  */
    /* JADX WARN: Code duplicated, block: B:87:0x010c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x010e  */
    /* JADX WARN: Code duplicated, block: B:89:0x0114  */
    /* JADX WARN: Code duplicated, block: B:92:0x0119  */
    /* JADX WARN: Code duplicated, block: B:94:0x011c  */
    /* JADX WARN: Code duplicated, block: B:95:0x011e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0121  */
    /* JADX WARN: Code duplicated, block: B:98:0x0124  */
    public static final void PinSetupScreenContent(Modifier modifier, String str, String str2, boolean z, boolean z2, boolean z3, final Function1<? super String, Unit> onNumberClick, final Function0<Unit> onDeletePin, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final String str3;
        int i4;
        String str4;
        int i5;
        int i6;
        boolean z4;
        int i7;
        int i8;
        boolean z5;
        int i9;
        int i10;
        int i11;
        boolean z6;
        Composer composer2;
        final boolean z7;
        final Modifier modifier3;
        final String str5;
        final String str6;
        final boolean z8;
        final boolean z9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final String str7;
        final boolean z10;
        final boolean z11;
        int i12;
        int i13;
        Intrinsics.checkNotNullParameter(onNumberClick, "onNumberClick");
        Intrinsics.checkNotNullParameter(onDeletePin, "onDeletePin");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1438234817);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PinSetupScreenContent)N(modifier,pin,confirmPin,isLoading,isConfirming,isPinError,onNumberClick,onDeletePin)84@3084L1930,82@3013L2007:PinSetupScreen.kt#oif8tm");
        int i14 = i2 & 1;
        if (i14 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i15 = i2 & 2;
        if (i15 == 0) {
            if ((i & 48) == 0) {
                str3 = str;
                i3 |= composerStartRestartGroup.changed(str3) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    str4 = str2;
                    if (composerStartRestartGroup.changed(str4)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        z4 = z;
                        if (composerStartRestartGroup.changed(z4)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            z5 = z2;
                            if (composerStartRestartGroup.changed(z5)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 32;
                        if (i10 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(z3)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                                i13 = 1048576;
                            } else {
                                i13 = 524288;
                            }
                            i3 |= i13;
                        }
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                                i12 = 8388608;
                            } else {
                                i12 = 4194304;
                            }
                            i3 |= i12;
                        }
                        if ((i3 & 4793491) != 4793490) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            z7 = z3;
                            modifier3 = modifier2;
                            str5 = str3;
                            str6 = str4;
                            z8 = z4;
                            z9 = z5;
                        } else {
                            if (i14 != 0) {
                                modifier3 = Modifier.INSTANCE;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i15 != 0) {
                                str3 = "";
                            }
                            if (i4 != 0) {
                                str7 = "";
                            } else {
                                str7 = str4;
                            }
                            if (i6 != 0) {
                                z10 = false;
                            } else {
                                z10 = z4;
                            }
                            if (i8 != 0) {
                                z5 = false;
                            }
                            if (i10 != 0) {
                                z11 = false;
                            } else {
                                z11 = z3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                            }
                            final boolean z12 = z5;
                            composer2 = composerStartRestartGroup;
                            ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z12, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            boolean z13 = z10;
                            z7 = z11;
                            str5 = str3;
                            z9 = z12;
                            str6 = str7;
                            z8 = z13;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    z5 = z2;
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z7 = z3;
                        modifier3 = modifier2;
                        str5 = str3;
                        str6 = str4;
                        z8 = z4;
                        z9 = z5;
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i15 != 0) {
                            str3 = "";
                        }
                        if (i4 != 0) {
                            str7 = "";
                        } else {
                            str7 = str4;
                        }
                        if (i6 != 0) {
                            z10 = false;
                        } else {
                            z10 = z4;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        }
                        if (i10 != 0) {
                            z11 = false;
                        } else {
                            z11 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                        }
                        final boolean z14 = z5;
                        composer2 = composerStartRestartGroup;
                        ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z14, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        boolean z15 = z10;
                        z7 = z11;
                        str5 = str3;
                        z9 = z14;
                        str6 = str7;
                        z8 = z15;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                z4 = z;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        z5 = z2;
                        if (composerStartRestartGroup.changed(z5)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z7 = z3;
                        modifier3 = modifier2;
                        str5 = str3;
                        str6 = str4;
                        z8 = z4;
                        z9 = z5;
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i15 != 0) {
                            str3 = "";
                        }
                        if (i4 != 0) {
                            str7 = "";
                        } else {
                            str7 = str4;
                        }
                        if (i6 != 0) {
                            z10 = false;
                        } else {
                            z10 = z4;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        }
                        if (i10 != 0) {
                            z11 = false;
                        } else {
                            z11 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                        }
                        final boolean z16 = z5;
                        composer2 = composerStartRestartGroup;
                        ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z16, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        boolean z17 = z10;
                        z7 = z11;
                        str5 = str3;
                        z9 = z16;
                        str6 = str7;
                        z8 = z17;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                z5 = z2;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z7 = z3;
                    modifier3 = modifier2;
                    str5 = str3;
                    str6 = str4;
                    z8 = z4;
                    z9 = z5;
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        str3 = "";
                    }
                    if (i4 != 0) {
                        str7 = "";
                    } else {
                        str7 = str4;
                    }
                    if (i6 != 0) {
                        z10 = false;
                    } else {
                        z10 = z4;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    }
                    if (i10 != 0) {
                        z11 = false;
                    } else {
                        z11 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                    }
                    final boolean z18 = z5;
                    composer2 = composerStartRestartGroup;
                    ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z18, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    boolean z19 = z10;
                    z7 = z11;
                    str5 = str3;
                    z9 = z18;
                    str6 = str7;
                    z8 = z19;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            str4 = str2;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        z5 = z2;
                        if (composerStartRestartGroup.changed(z5)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z7 = z3;
                        modifier3 = modifier2;
                        str5 = str3;
                        str6 = str4;
                        z8 = z4;
                        z9 = z5;
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i15 != 0) {
                            str3 = "";
                        }
                        if (i4 != 0) {
                            str7 = "";
                        } else {
                            str7 = str4;
                        }
                        if (i6 != 0) {
                            z10 = false;
                        } else {
                            z10 = z4;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        }
                        if (i10 != 0) {
                            z11 = false;
                        } else {
                            z11 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                        }
                        final boolean z110 = z5;
                        composer2 = composerStartRestartGroup;
                        ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z110, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        boolean z111 = z10;
                        z7 = z11;
                        str5 = str3;
                        z9 = z110;
                        str6 = str7;
                        z8 = z111;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                z5 = z2;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z7 = z3;
                    modifier3 = modifier2;
                    str5 = str3;
                    str6 = str4;
                    z8 = z4;
                    z9 = z5;
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        str3 = "";
                    }
                    if (i4 != 0) {
                        str7 = "";
                    } else {
                        str7 = str4;
                    }
                    if (i6 != 0) {
                        z10 = false;
                    } else {
                        z10 = z4;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    }
                    if (i10 != 0) {
                        z11 = false;
                    } else {
                        z11 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                    }
                    final boolean z112 = z5;
                    composer2 = composerStartRestartGroup;
                    ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z112, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    boolean z113 = z10;
                    z7 = z11;
                    str5 = str3;
                    z9 = z112;
                    str6 = str7;
                    z8 = z113;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    z5 = z2;
                    if (composerStartRestartGroup.changed(z5)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z7 = z3;
                    modifier3 = modifier2;
                    str5 = str3;
                    str6 = str4;
                    z8 = z4;
                    z9 = z5;
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        str3 = "";
                    }
                    if (i4 != 0) {
                        str7 = "";
                    } else {
                        str7 = str4;
                    }
                    if (i6 != 0) {
                        z10 = false;
                    } else {
                        z10 = z4;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    }
                    if (i10 != 0) {
                        z11 = false;
                    } else {
                        z11 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                    }
                    final boolean z114 = z5;
                    composer2 = composerStartRestartGroup;
                    ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z114, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    boolean z115 = z10;
                    z7 = z11;
                    str5 = str3;
                    z9 = z114;
                    str6 = str7;
                    z8 = z115;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z5 = z2;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((i3 & 4793491) != 4793490) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z7 = z3;
                modifier3 = modifier2;
                str5 = str3;
                str6 = str4;
                z8 = z4;
                z9 = z5;
            } else {
                if (i14 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i15 != 0) {
                    str3 = "";
                }
                if (i4 != 0) {
                    str7 = "";
                } else {
                    str7 = str4;
                }
                if (i6 != 0) {
                    z10 = false;
                } else {
                    z10 = z4;
                }
                if (i8 != 0) {
                    z5 = false;
                }
                if (i10 != 0) {
                    z11 = false;
                } else {
                    z11 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                }
                final boolean z116 = z5;
                composer2 = composerStartRestartGroup;
                ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z116, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                boolean z117 = z10;
                z7 = z11;
                str5 = str3;
                z9 = z116;
                str6 = str7;
                z8 = z117;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        str3 = str;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                str4 = str2;
                if (composerStartRestartGroup.changed(str4)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        z5 = z2;
                        if (composerStartRestartGroup.changed(z5)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z7 = z3;
                        modifier3 = modifier2;
                        str5 = str3;
                        str6 = str4;
                        z8 = z4;
                        z9 = z5;
                    } else {
                        if (i14 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i15 != 0) {
                            str3 = "";
                        }
                        if (i4 != 0) {
                            str7 = "";
                        } else {
                            str7 = str4;
                        }
                        if (i6 != 0) {
                            z10 = false;
                        } else {
                            z10 = z4;
                        }
                        if (i8 != 0) {
                            z5 = false;
                        }
                        if (i10 != 0) {
                            z11 = false;
                        } else {
                            z11 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                        }
                        final boolean z118 = z5;
                        composer2 = composerStartRestartGroup;
                        ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z118, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        boolean z119 = z10;
                        z7 = z11;
                        str5 = str3;
                        z9 = z118;
                        str6 = str7;
                        z8 = z119;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                z5 = z2;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z7 = z3;
                    modifier3 = modifier2;
                    str5 = str3;
                    str6 = str4;
                    z8 = z4;
                    z9 = z5;
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        str3 = "";
                    }
                    if (i4 != 0) {
                        str7 = "";
                    } else {
                        str7 = str4;
                    }
                    if (i6 != 0) {
                        z10 = false;
                    } else {
                        z10 = z4;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    }
                    if (i10 != 0) {
                        z11 = false;
                    } else {
                        z11 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                    }
                    final boolean z1110 = z5;
                    composer2 = composerStartRestartGroup;
                    ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z1110, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    boolean z1111 = z10;
                    z7 = z11;
                    str5 = str3;
                    z9 = z1110;
                    str6 = str7;
                    z8 = z1111;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    z5 = z2;
                    if (composerStartRestartGroup.changed(z5)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z7 = z3;
                    modifier3 = modifier2;
                    str5 = str3;
                    str6 = str4;
                    z8 = z4;
                    z9 = z5;
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        str3 = "";
                    }
                    if (i4 != 0) {
                        str7 = "";
                    } else {
                        str7 = str4;
                    }
                    if (i6 != 0) {
                        z10 = false;
                    } else {
                        z10 = z4;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    }
                    if (i10 != 0) {
                        z11 = false;
                    } else {
                        z11 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                    }
                    final boolean z1112 = z5;
                    composer2 = composerStartRestartGroup;
                    ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z1112, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    boolean z1113 = z10;
                    z7 = z11;
                    str5 = str3;
                    z9 = z1112;
                    str6 = str7;
                    z8 = z1113;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z5 = z2;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((i3 & 4793491) != 4793490) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z7 = z3;
                modifier3 = modifier2;
                str5 = str3;
                str6 = str4;
                z8 = z4;
                z9 = z5;
            } else {
                if (i14 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i15 != 0) {
                    str3 = "";
                }
                if (i4 != 0) {
                    str7 = "";
                } else {
                    str7 = str4;
                }
                if (i6 != 0) {
                    z10 = false;
                } else {
                    z10 = z4;
                }
                if (i8 != 0) {
                    z5 = false;
                }
                if (i10 != 0) {
                    z11 = false;
                } else {
                    z11 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                }
                final boolean z1114 = z5;
                composer2 = composerStartRestartGroup;
                ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z1114, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                boolean z1115 = z10;
                z7 = z11;
                str5 = str3;
                z9 = z1114;
                str6 = str7;
                z8 = z1115;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        str4 = str2;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                z4 = z;
                if (composerStartRestartGroup.changed(z4)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    z5 = z2;
                    if (composerStartRestartGroup.changed(z5)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z7 = z3;
                    modifier3 = modifier2;
                    str5 = str3;
                    str6 = str4;
                    z8 = z4;
                    z9 = z5;
                } else {
                    if (i14 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        str3 = "";
                    }
                    if (i4 != 0) {
                        str7 = "";
                    } else {
                        str7 = str4;
                    }
                    if (i6 != 0) {
                        z10 = false;
                    } else {
                        z10 = z4;
                    }
                    if (i8 != 0) {
                        z5 = false;
                    }
                    if (i10 != 0) {
                        z11 = false;
                    } else {
                        z11 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                    }
                    final boolean z1116 = z5;
                    composer2 = composerStartRestartGroup;
                    ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z1116, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    boolean z1117 = z10;
                    z7 = z11;
                    str5 = str3;
                    z9 = z1116;
                    str6 = str7;
                    z8 = z1117;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z5 = z2;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((i3 & 4793491) != 4793490) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z7 = z3;
                modifier3 = modifier2;
                str5 = str3;
                str6 = str4;
                z8 = z4;
                z9 = z5;
            } else {
                if (i14 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i15 != 0) {
                    str3 = "";
                }
                if (i4 != 0) {
                    str7 = "";
                } else {
                    str7 = str4;
                }
                if (i6 != 0) {
                    z10 = false;
                } else {
                    z10 = z4;
                }
                if (i8 != 0) {
                    z5 = false;
                }
                if (i10 != 0) {
                    z11 = false;
                } else {
                    z11 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                }
                final boolean z1118 = z5;
                composer2 = composerStartRestartGroup;
                ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z1118, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                boolean z1119 = z10;
                z7 = z11;
                str5 = str3;
                z9 = z1118;
                str6 = str7;
                z8 = z1119;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z4 = z;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                z5 = z2;
                if (composerStartRestartGroup.changed(z5)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((i3 & 4793491) != 4793490) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z7 = z3;
                modifier3 = modifier2;
                str5 = str3;
                str6 = str4;
                z8 = z4;
                z9 = z5;
            } else {
                if (i14 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i15 != 0) {
                    str3 = "";
                }
                if (i4 != 0) {
                    str7 = "";
                } else {
                    str7 = str4;
                }
                if (i6 != 0) {
                    z10 = false;
                } else {
                    z10 = z4;
                }
                if (i8 != 0) {
                    z5 = false;
                }
                if (i10 != 0) {
                    z11 = false;
                } else {
                    z11 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
                }
                final boolean z11110 = z5;
                composer2 = composerStartRestartGroup;
                ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z11110, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                boolean z11111 = z10;
                z7 = z11;
                str5 = str3;
                z9 = z11110;
                str6 = str7;
                z8 = z11111;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z5 = z2;
        i10 = i2 & 32;
        if (i10 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i11 = 131072;
            } else {
                i11 = 65536;
            }
            i3 |= i11;
        }
        if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                i13 = 1048576;
            } else {
                i13 = 524288;
            }
            i3 |= i13;
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                i12 = 8388608;
            } else {
                i12 = 4194304;
            }
            i3 |= i12;
        }
        if ((i3 & 4793491) != 4793490) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z7 = z3;
            modifier3 = modifier2;
            str5 = str3;
            str6 = str4;
            z8 = z4;
            z9 = z5;
        } else {
            if (i14 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i15 != 0) {
                str3 = "";
            }
            if (i4 != 0) {
                str7 = "";
            } else {
                str7 = str4;
            }
            if (i6 != 0) {
                z10 = false;
            } else {
                z10 = z4;
            }
            if (i8 != 0) {
                z5 = false;
            }
            if (i10 != 0) {
                z11 = false;
            } else {
                z11 = z3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1438234817, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent (PinSetupScreen.kt:81)");
            }
            final boolean z11112 = z5;
            composer2 = composerStartRestartGroup;
            ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(419930190, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PinSetupScreenKt.PinSetupScreenContent$lambda$22(modifier3, z11, z11112, str7, str3, z10, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            boolean z11113 = z10;
            z7 = z11;
            str5 = str3;
            z9 = z11112;
            str6 = str7;
            z8 = z11113;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PinSetupScreenKt.PinSetupScreenContent$lambda$23(modifier3, str5, str6, z8, z9, z7, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinSetupScreenContent$lambda$22(Modifier modifier, boolean z, boolean z2, String str, String str2, boolean z3, final Function1 function1, final Function0 function0, PaddingValues innerPadding, Composer composer, int i) {
        int i2;
        String str3;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation(composer, "CN(innerPadding)85@3114L1890:PinSetupScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(innerPadding) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(419930190, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenContent.<anonymous> (PinSetupScreen.kt:85)");
            }
            float f = 16;
            float f2 = 8;
            Modifier modifierM1119paddingVpY3zN4 = PaddingKt.m1119paddingVpY3zN4(PaddingKt.padding(SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null), innerPadding), Dp.m8684constructorimpl(f), Dp.m8684constructorimpl(f2));
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1119paddingVpY3zN4);
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
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1968259552, "C91@3331L1659:PinSetupScreen.kt#oif8tm");
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, centerHorizontally, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl2 = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1560587343, "C102@3855L10,96@3564L497,107@4082L38,110@4251L10,108@4141L255,113@4417L192,118@4630L38,120@4737L35,121@4814L17,122@4878L2,119@4689L283:PinSetupScreen.kt#oif8tm");
            if (z) {
                str3 = "PIN Mismatch!";
            } else if (z2) {
                str3 = "Confirm your PIN";
            } else {
                str3 = "Setup your PIN";
            }
            TextKt.m3864TextNvy7gAk(str3, PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f), 7, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), 0L, 0L, FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 48, 0, 131068);
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
            TextKt.m3864TextNvy7gAk("Enter your desired 4-digit PIN", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f2), 7, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8540getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 54, 0, 131068);
            PinRowKt.PinRow(null, z2 ? str : str2, z3, z, composer, 0, 1);
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 1335167957, "CC(remember):PinSetupScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PinSetupScreenKt.PinSetupScreenContent$lambda$22$lambda$21$lambda$20$lambda$15$lambda$14(function1, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function2 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1335170403, "CC(remember):PinSetupScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(function0);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PinSetupScreenKt.PinSetupScreenContent$lambda$22$lambda$21$lambda$20$lambda$17$lambda$16(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function3 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1335172436, "CC(remember):PinSetupScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function0 function4 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            KeypadKt.Keypad(function2, function3, function4, z2 ? str : str2, composer, 384, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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
    public static final Unit PinSetupScreenContent$lambda$22$lambda$21$lambda$20$lambda$15$lambda$14(Function1 function1, String number) {
        Intrinsics.checkNotNullParameter(number, "number");
        function1.invoke(number);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinSetupScreenContent$lambda$22$lambda$21$lambda$20$lambda$17$lambda$16(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final void PreviewSetupPinScreen(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1794327338);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewSetupPinScreen)139@5255L2,140@5281L2,134@5102L187:PinSetupScreen.kt#oif8tm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1794327338, i, -1, "com.example.bingwahybrid.presentation.ui.screens.PreviewSetupPinScreen (PinSetupScreen.kt:133)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2066693516, "CC(remember):PinSetupScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PinSetupScreenKt.PreviewSetupPinScreen$lambda$25$lambda$24((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2066694348, "CC(remember):PinSetupScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            PinSetupScreenContent(null, "123", null, false, false, false, function1, (Function0) objRememberedValue2, composerStartRestartGroup, 14380080, 5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PinSetupScreenKt.PreviewSetupPinScreen$lambda$28(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewSetupPinScreen$lambda$25$lambda$24(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private static final String PinSetupScreen$lambda$0(State<String> state) {
        return state.getValue();
    }

    private static final String PinSetupScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    private static final boolean PinSetupScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean PinSetupScreen$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean PinSetupScreen$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PinSetupScreen$lambda$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PinSetupScreen$lambda$6(State<String> state) {
        return state.getValue();
    }
}
