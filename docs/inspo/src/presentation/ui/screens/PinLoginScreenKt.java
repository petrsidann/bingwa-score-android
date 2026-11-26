package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.foundation.ImageKt;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
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
import com.example.bingwahybrid.R;
import com.example.bingwahybrid.domain.auth.models.Agent;
import com.example.bingwahybrid.presentation.ui.components.KeypadKt;
import com.example.bingwahybrid.presentation.ui.components.PinRowKt;
import com.example.bingwahybrid.presentation.viewmodel.PinLoginViewModel;
import io.ktor.sse.ServerSentEventKt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PinLoginScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001ap\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001b¨\u0006\u001c²\u0006\f\u0010\f\u001a\u0004\u0018\u00010\rX\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\tX\u008a\u0084\u0002"}, d2 = {"PinLoginScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/PinLoginViewModel;", "email", "", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/viewmodel/PinLoginViewModel;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "PinLoginScreenContent", "agent", "Lcom/example/bingwahybrid/domain/auth/models/Agent;", "pin", "isLoading", "", "errorMessage", "onNumberClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "number", "onDeletePin", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lcom/example/bingwahybrid/domain/auth/models/Agent;Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PinLoginPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "loginSuccess"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PinLoginScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinLoginPreview$lambda$25(int i, Composer composer, int i2) {
        PinLoginPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinLoginScreen$lambda$11(Modifier modifier, NavHostController navHostController, PinLoginViewModel pinLoginViewModel, String str, int i, int i2, Composer composer, int i3) {
        PinLoginScreen(modifier, navHostController, pinLoginViewModel, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinLoginScreenContent$lambda$20(Modifier modifier, Agent agent, String str, boolean z, String str2, Function1 function1, Function0 function0, int i, int i2, Composer composer, int i3) {
        PinLoginScreenContent(modifier, agent, str, z, str2, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01df  */
    /* JADX WARN: Code duplicated, block: B:102:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:105:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:110:0x0223  */
    /* JADX WARN: Code duplicated, block: B:112:0x0229  */
    /* JADX WARN: Code duplicated, block: B:118:0x0236  */
    /* JADX WARN: Code duplicated, block: B:120:0x023e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0255  */
    /* JADX WARN: Code duplicated, block: B:125:0x025b  */
    /* JADX WARN: Code duplicated, block: B:131:0x0268  */
    /* JADX WARN: Code duplicated, block: B:133:0x0270  */
    /* JADX WARN: Code duplicated, block: B:136:0x0298  */
    /* JADX WARN: Code duplicated, block: B:138:0x029e  */
    /* JADX WARN: Code duplicated, block: B:141:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x008e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:67:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:75:0x0103  */
    /* JADX WARN: Code duplicated, block: B:77:0x012e  */
    /* JADX WARN: Code duplicated, block: B:79:0x013a  */
    /* JADX WARN: Code duplicated, block: B:81:0x013f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0147  */
    /* JADX WARN: Code duplicated, block: B:85:0x0153  */
    /* JADX WARN: Code duplicated, block: B:88:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:93:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:95:0x01d2  */
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
    public static final void PinLoginScreen(Modifier modifier, NavHostController navHostController, PinLoginViewModel pinLoginViewModel, String str, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        NavHostController navHostController2;
        int i4;
        String str2;
        int i5;
        boolean z;
        final String str3;
        final Modifier modifier3;
        final NavHostController navHostController3;
        final PinLoginViewModel pinLoginViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        NavHostController navHostController4;
        CoroutineContext coroutineContext;
        int i6;
        int i7;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        State stateCollectAsState;
        boolean zChanged;
        PinLoginScreenKt$PinLoginScreen$1$1 pinLoginScreenKt$PinLoginScreen$1$1RememberedValue;
        boolean z2;
        boolean z3;
        PinLoginScreenKt$PinLoginScreen$2$1 pinLoginScreenKt$PinLoginScreen$2$1RememberedValue;
        boolean z4;
        Object objRememberedValue;
        boolean z5;
        Object objRememberedValue2;
        int i8;
        boolean zChangedInstance;
        final PinLoginViewModel pinLoginViewModel3 = pinLoginViewModel;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1206697925);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PinLoginScreen)N(modifier,navController,viewModel,email)48@2074L16,49@2120L16,50@2178L16,51@2242L16,52@2306L16,54@2357L231,54@2328L260,63@2615L47,63@2593L69,73@2854L45,74@2923L27,67@2668L289:PinLoginScreen.kt#oif8tm");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                navHostController2 = navHostController;
                i3 |= composerStartRestartGroup.changedInstance(navHostController2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) != 0) {
                    i8 = 128;
                } else {
                    if ((i & 512) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(pinLoginViewModel3);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(pinLoginViewModel3);
                    }
                    if (zChangedInstance) {
                        i8 = 256;
                    } else {
                        i8 = 128;
                    }
                }
                i3 |= i8;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
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
                    ComposerKt.sourceInformation(composerStartRestartGroup, "45@1996L15");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i10 != 0) {
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
                            ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(PinLoginViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                            coroutineContext = null;
                            pinLoginViewModel3 = (PinLoginViewModel) viewModel;
                            i6 = 0;
                        } else {
                            coroutineContext = null;
                            i6 = 0;
                        }
                        if (i4 != 0) {
                            i7 = i3;
                            str3 = "";
                        } else {
                            i7 = i3;
                            str3 = str;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        String str4 = str2;
                        i7 = i3;
                        str3 = str4;
                        companion = modifier2;
                        navHostController4 = navHostController2;
                        coroutineContext = null;
                        i6 = 0;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1206697925, i7, -1, "com.example.bingwahybrid.presentation.ui.screens.PinLoginScreen (PinLoginScreen.kt:47)");
                    }
                    State stateCollectAsState2 = SnapshotStateKt.collectAsState(pinLoginViewModel3.getAgent(), coroutineContext, composerStartRestartGroup, i6, 1);
                    State stateCollectAsState3 = SnapshotStateKt.collectAsState(pinLoginViewModel3.getPin(), coroutineContext, composerStartRestartGroup, i6, 1);
                    State stateCollectAsState4 = SnapshotStateKt.collectAsState(pinLoginViewModel3.isLoading(), coroutineContext, composerStartRestartGroup, i6, 1);
                    stateCollectAsState = SnapshotStateKt.collectAsState(pinLoginViewModel3.getLoginSuccess(), coroutineContext, composerStartRestartGroup, i6, 1);
                    State stateCollectAsState5 = SnapshotStateKt.collectAsState(pinLoginViewModel3.getErrorMessage(), coroutineContext, composerStartRestartGroup, i6, 1);
                    Boolean boolValueOf = Boolean.valueOf(PinLoginScreen$lambda$3(stateCollectAsState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4480514, "CC(remember):PinLoginScreen.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(navHostController4);
                    pinLoginScreenKt$PinLoginScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || pinLoginScreenKt$PinLoginScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        pinLoginScreenKt$PinLoginScreen$1$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$1$1(stateCollectAsState, navHostController4, null);
                        composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinLoginScreenKt$PinLoginScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4488586, "CC(remember):PinLoginScreen.kt#9igjgp");
                    int i11 = (i7 & 896) ^ 384;
                    boolean z6 = (i11 <= 256 && composerStartRestartGroup.changedInstance(pinLoginViewModel3)) || (i7 & 384) == 256;
                    if ((i7 & 7168) == 2048) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z2 | z6;
                    pinLoginScreenKt$PinLoginScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3 || pinLoginScreenKt$PinLoginScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        pinLoginScreenKt$PinLoginScreen$2$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$2$1(pinLoginViewModel3, str3, null);
                        composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(str3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinLoginScreenKt$PinLoginScreen$2$1RememberedValue, composerStartRestartGroup, (i7 >> 9) & 14);
                    Agent agentPinLoginScreen$lambda$0 = PinLoginScreen$lambda$0(stateCollectAsState2);
                    boolean zPinLoginScreen$lambda$2 = PinLoginScreen$lambda$2(stateCollectAsState4);
                    String strPinLoginScreen$lambda$4 = PinLoginScreen$lambda$4(stateCollectAsState5);
                    String strPinLoginScreen$lambda$1 = PinLoginScreen$lambda$1(stateCollectAsState3);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4496232, "CC(remember):PinLoginScreen.kt#9igjgp");
                    z4 = (i11 <= 256 && composerStartRestartGroup.changedInstance(pinLoginViewModel3)) || (i7 & 384) == 256;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return PinLoginScreenKt.PinLoginScreen$lambda$8$lambda$7(pinLoginViewModel3, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function1 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4498422, "CC(remember):PinLoginScreen.kt#9igjgp");
                    z5 = (i11 <= 256 && composerStartRestartGroup.changedInstance(pinLoginViewModel3)) || (i7 & 384) == 256;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z5 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PinLoginScreenKt.PinLoginScreen$lambda$10$lambda$9(pinLoginViewModel3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier4 = companion;
                    PinLoginScreenContent(modifier4, agentPinLoginScreen$lambda$0, strPinLoginScreen$lambda$1, zPinLoginScreen$lambda$2, strPinLoginScreen$lambda$4, function1, (Function0) objRememberedValue2, composerStartRestartGroup, (i7 & 14) | (Agent.$stable << 3), 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navHostController3 = navHostController4;
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    str3 = str;
                    modifier3 = modifier2;
                    navHostController3 = navHostController2;
                }
                pinLoginViewModel2 = pinLoginViewModel3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PinLoginScreenKt.PinLoginScreen$lambda$11(modifier3, navHostController3, pinLoginViewModel2, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                ComposerKt.sourceInformation(composerStartRestartGroup, "45@1996L15");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i10 != 0) {
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
                        ViewModel viewModel2 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(PinLoginViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory2, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                        coroutineContext = null;
                        pinLoginViewModel3 = (PinLoginViewModel) viewModel2;
                        i6 = 0;
                    } else {
                        coroutineContext = null;
                        i6 = 0;
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        str3 = "";
                    } else {
                        i7 = i3;
                        str3 = str;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i10 != 0) {
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
                        ViewModel viewModel3 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(PinLoginViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory3, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                        coroutineContext = null;
                        pinLoginViewModel3 = (PinLoginViewModel) viewModel3;
                        i6 = 0;
                    } else {
                        coroutineContext = null;
                        i6 = 0;
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        str3 = "";
                    } else {
                        i7 = i3;
                        str3 = str;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1206697925, i7, -1, "com.example.bingwahybrid.presentation.ui.screens.PinLoginScreen (PinLoginScreen.kt:47)");
                }
                State stateCollectAsState6 = SnapshotStateKt.collectAsState(pinLoginViewModel3.getAgent(), coroutineContext, composerStartRestartGroup, i6, 1);
                State stateCollectAsState7 = SnapshotStateKt.collectAsState(pinLoginViewModel3.getPin(), coroutineContext, composerStartRestartGroup, i6, 1);
                State stateCollectAsState8 = SnapshotStateKt.collectAsState(pinLoginViewModel3.isLoading(), coroutineContext, composerStartRestartGroup, i6, 1);
                stateCollectAsState = SnapshotStateKt.collectAsState(pinLoginViewModel3.getLoginSuccess(), coroutineContext, composerStartRestartGroup, i6, 1);
                State stateCollectAsState9 = SnapshotStateKt.collectAsState(pinLoginViewModel3.getErrorMessage(), coroutineContext, composerStartRestartGroup, i6, 1);
                Boolean boolValueOf2 = Boolean.valueOf(PinLoginScreen$lambda$3(stateCollectAsState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4480514, "CC(remember):PinLoginScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(navHostController4);
                pinLoginScreenKt$PinLoginScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    pinLoginScreenKt$PinLoginScreen$1$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$1$1(stateCollectAsState, navHostController4, null);
                    composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$1$1RememberedValue);
                } else {
                    pinLoginScreenKt$PinLoginScreen$1$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$1$1(stateCollectAsState, navHostController4, null);
                    composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinLoginScreenKt$PinLoginScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4488586, "CC(remember):PinLoginScreen.kt#9igjgp");
                int i12 = (i7 & 896) ^ 384;
                if (i12 <= 256) {
                }
                if ((i7 & 7168) == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2 | z6;
                pinLoginScreenKt$PinLoginScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    pinLoginScreenKt$PinLoginScreen$2$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$2$1(pinLoginViewModel3, str3, null);
                    composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$2$1RememberedValue);
                } else {
                    pinLoginScreenKt$PinLoginScreen$2$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$2$1(pinLoginViewModel3, str3, null);
                    composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(str3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinLoginScreenKt$PinLoginScreen$2$1RememberedValue, composerStartRestartGroup, (i7 >> 9) & 14);
                Agent agentPinLoginScreen$lambda$1 = PinLoginScreen$lambda$0(stateCollectAsState6);
                boolean zPinLoginScreen$lambda$3 = PinLoginScreen$lambda$2(stateCollectAsState8);
                String strPinLoginScreen$lambda$5 = PinLoginScreen$lambda$4(stateCollectAsState9);
                String strPinLoginScreen$lambda$2 = PinLoginScreen$lambda$1(stateCollectAsState7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4496232, "CC(remember):PinLoginScreen.kt#9igjgp");
                if (i12 <= 256) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z4) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PinLoginScreenKt.PinLoginScreen$lambda$8$lambda$7(pinLoginViewModel3, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PinLoginScreenKt.PinLoginScreen$lambda$8$lambda$7(pinLoginViewModel3, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function1 function2 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4498422, "CC(remember):PinLoginScreen.kt#9igjgp");
                if (i12 <= 256) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PinLoginScreenKt.PinLoginScreen$lambda$10$lambda$9(pinLoginViewModel3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PinLoginScreenKt.PinLoginScreen$lambda$10$lambda$9(pinLoginViewModel3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier5 = companion;
                PinLoginScreenContent(modifier5, agentPinLoginScreen$lambda$1, strPinLoginScreen$lambda$2, zPinLoginScreen$lambda$3, strPinLoginScreen$lambda$5, function2, (Function0) objRememberedValue2, composerStartRestartGroup, (i7 & 14) | (Agent.$stable << 3), 0);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navHostController3 = navHostController4;
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                str3 = str;
                modifier3 = modifier2;
                navHostController3 = navHostController2;
            }
            pinLoginViewModel2 = pinLoginViewModel3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PinLoginScreenKt.PinLoginScreen$lambda$11(modifier3, navHostController3, pinLoginViewModel2, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        navHostController2 = navHostController;
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i8 = 128;
            } else {
                if ((i & 512) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(pinLoginViewModel3);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(pinLoginViewModel3);
                }
                if (zChangedInstance) {
                    i8 = 256;
                } else {
                    i8 = 128;
                }
            }
            i3 |= i8;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
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
                ComposerKt.sourceInformation(composerStartRestartGroup, "45@1996L15");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i10 != 0) {
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
                        ViewModelProvider.Factory factoryCreateHiltViewModelFactory4 = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel4 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(PinLoginViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory4, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                        coroutineContext = null;
                        pinLoginViewModel3 = (PinLoginViewModel) viewModel4;
                        i6 = 0;
                    } else {
                        coroutineContext = null;
                        i6 = 0;
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        str3 = "";
                    } else {
                        i7 = i3;
                        str3 = str;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i10 != 0) {
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
                        ViewModelProvider.Factory factoryCreateHiltViewModelFactory5 = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel5 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(PinLoginViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory5, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                        coroutineContext = null;
                        pinLoginViewModel3 = (PinLoginViewModel) viewModel5;
                        i6 = 0;
                    } else {
                        coroutineContext = null;
                        i6 = 0;
                    }
                    if (i4 != 0) {
                        i7 = i3;
                        str3 = "";
                    } else {
                        i7 = i3;
                        str3 = str;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1206697925, i7, -1, "com.example.bingwahybrid.presentation.ui.screens.PinLoginScreen (PinLoginScreen.kt:47)");
                }
                State stateCollectAsState10 = SnapshotStateKt.collectAsState(pinLoginViewModel3.getAgent(), coroutineContext, composerStartRestartGroup, i6, 1);
                State stateCollectAsState11 = SnapshotStateKt.collectAsState(pinLoginViewModel3.getPin(), coroutineContext, composerStartRestartGroup, i6, 1);
                State stateCollectAsState12 = SnapshotStateKt.collectAsState(pinLoginViewModel3.isLoading(), coroutineContext, composerStartRestartGroup, i6, 1);
                stateCollectAsState = SnapshotStateKt.collectAsState(pinLoginViewModel3.getLoginSuccess(), coroutineContext, composerStartRestartGroup, i6, 1);
                State stateCollectAsState13 = SnapshotStateKt.collectAsState(pinLoginViewModel3.getErrorMessage(), coroutineContext, composerStartRestartGroup, i6, 1);
                Boolean boolValueOf3 = Boolean.valueOf(PinLoginScreen$lambda$3(stateCollectAsState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4480514, "CC(remember):PinLoginScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(navHostController4);
                pinLoginScreenKt$PinLoginScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    pinLoginScreenKt$PinLoginScreen$1$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$1$1(stateCollectAsState, navHostController4, null);
                    composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$1$1RememberedValue);
                } else {
                    pinLoginScreenKt$PinLoginScreen$1$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$1$1(stateCollectAsState, navHostController4, null);
                    composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinLoginScreenKt$PinLoginScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4488586, "CC(remember):PinLoginScreen.kt#9igjgp");
                int i13 = (i7 & 896) ^ 384;
                if (i13 <= 256) {
                }
                if ((i7 & 7168) == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2 | z6;
                pinLoginScreenKt$PinLoginScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    pinLoginScreenKt$PinLoginScreen$2$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$2$1(pinLoginViewModel3, str3, null);
                    composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$2$1RememberedValue);
                } else {
                    pinLoginScreenKt$PinLoginScreen$2$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$2$1(pinLoginViewModel3, str3, null);
                    composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(str3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinLoginScreenKt$PinLoginScreen$2$1RememberedValue, composerStartRestartGroup, (i7 >> 9) & 14);
                Agent agentPinLoginScreen$lambda$2 = PinLoginScreen$lambda$0(stateCollectAsState10);
                boolean zPinLoginScreen$lambda$4 = PinLoginScreen$lambda$2(stateCollectAsState12);
                String strPinLoginScreen$lambda$6 = PinLoginScreen$lambda$4(stateCollectAsState13);
                String strPinLoginScreen$lambda$3 = PinLoginScreen$lambda$1(stateCollectAsState11);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4496232, "CC(remember):PinLoginScreen.kt#9igjgp");
                if (i13 <= 256) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z4) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PinLoginScreenKt.PinLoginScreen$lambda$8$lambda$7(pinLoginViewModel3, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PinLoginScreenKt.PinLoginScreen$lambda$8$lambda$7(pinLoginViewModel3, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function1 function3 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4498422, "CC(remember):PinLoginScreen.kt#9igjgp");
                if (i13 <= 256) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PinLoginScreenKt.PinLoginScreen$lambda$10$lambda$9(pinLoginViewModel3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PinLoginScreenKt.PinLoginScreen$lambda$10$lambda$9(pinLoginViewModel3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier6 = companion;
                PinLoginScreenContent(modifier6, agentPinLoginScreen$lambda$2, strPinLoginScreen$lambda$3, zPinLoginScreen$lambda$4, strPinLoginScreen$lambda$6, function3, (Function0) objRememberedValue2, composerStartRestartGroup, (i7 & 14) | (Agent.$stable << 3), 0);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navHostController3 = navHostController4;
                modifier3 = modifier6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                str3 = str;
                modifier3 = modifier2;
                navHostController3 = navHostController2;
            }
            pinLoginViewModel2 = pinLoginViewModel3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PinLoginScreenKt.PinLoginScreen$lambda$11(modifier3, navHostController3, pinLoginViewModel2, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            ComposerKt.sourceInformation(composerStartRestartGroup, "45@1996L15");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i10 != 0) {
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
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory6 = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel6 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(PinLoginViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory6, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -897;
                    coroutineContext = null;
                    pinLoginViewModel3 = (PinLoginViewModel) viewModel6;
                    i6 = 0;
                } else {
                    coroutineContext = null;
                    i6 = 0;
                }
                if (i4 != 0) {
                    i7 = i3;
                    str3 = "";
                } else {
                    i7 = i3;
                    str3 = str;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i10 != 0) {
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
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory7 = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel7 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(PinLoginViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory7, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -897;
                    coroutineContext = null;
                    pinLoginViewModel3 = (PinLoginViewModel) viewModel7;
                    i6 = 0;
                } else {
                    coroutineContext = null;
                    i6 = 0;
                }
                if (i4 != 0) {
                    i7 = i3;
                    str3 = "";
                } else {
                    i7 = i3;
                    str3 = str;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1206697925, i7, -1, "com.example.bingwahybrid.presentation.ui.screens.PinLoginScreen (PinLoginScreen.kt:47)");
            }
            State stateCollectAsState14 = SnapshotStateKt.collectAsState(pinLoginViewModel3.getAgent(), coroutineContext, composerStartRestartGroup, i6, 1);
            State stateCollectAsState15 = SnapshotStateKt.collectAsState(pinLoginViewModel3.getPin(), coroutineContext, composerStartRestartGroup, i6, 1);
            State stateCollectAsState16 = SnapshotStateKt.collectAsState(pinLoginViewModel3.isLoading(), coroutineContext, composerStartRestartGroup, i6, 1);
            stateCollectAsState = SnapshotStateKt.collectAsState(pinLoginViewModel3.getLoginSuccess(), coroutineContext, composerStartRestartGroup, i6, 1);
            State stateCollectAsState17 = SnapshotStateKt.collectAsState(pinLoginViewModel3.getErrorMessage(), coroutineContext, composerStartRestartGroup, i6, 1);
            Boolean boolValueOf4 = Boolean.valueOf(PinLoginScreen$lambda$3(stateCollectAsState));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4480514, "CC(remember):PinLoginScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(navHostController4);
            pinLoginScreenKt$PinLoginScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                pinLoginScreenKt$PinLoginScreen$1$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$1$1(stateCollectAsState, navHostController4, null);
                composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$1$1RememberedValue);
            } else {
                pinLoginScreenKt$PinLoginScreen$1$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$1$1(stateCollectAsState, navHostController4, null);
                composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinLoginScreenKt$PinLoginScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4488586, "CC(remember):PinLoginScreen.kt#9igjgp");
            int i14 = (i7 & 896) ^ 384;
            if (i14 <= 256) {
            }
            if ((i7 & 7168) == 2048) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = z2 | z6;
            pinLoginScreenKt$PinLoginScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                pinLoginScreenKt$PinLoginScreen$2$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$2$1(pinLoginViewModel3, str3, null);
                composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$2$1RememberedValue);
            } else {
                pinLoginScreenKt$PinLoginScreen$2$1RememberedValue = new PinLoginScreenKt$PinLoginScreen$2$1(pinLoginViewModel3, str3, null);
                composerStartRestartGroup.updateRememberedValue(pinLoginScreenKt$PinLoginScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(str3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinLoginScreenKt$PinLoginScreen$2$1RememberedValue, composerStartRestartGroup, (i7 >> 9) & 14);
            Agent agentPinLoginScreen$lambda$3 = PinLoginScreen$lambda$0(stateCollectAsState14);
            boolean zPinLoginScreen$lambda$5 = PinLoginScreen$lambda$2(stateCollectAsState16);
            String strPinLoginScreen$lambda$7 = PinLoginScreen$lambda$4(stateCollectAsState17);
            String strPinLoginScreen$lambda$8 = PinLoginScreen$lambda$1(stateCollectAsState15);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4496232, "CC(remember):PinLoginScreen.kt#9igjgp");
            if (i14 <= 256) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z4) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PinLoginScreenKt.PinLoginScreen$lambda$8$lambda$7(pinLoginViewModel3, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PinLoginScreenKt.PinLoginScreen$lambda$8$lambda$7(pinLoginViewModel3, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function4 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 4498422, "CC(remember):PinLoginScreen.kt#9igjgp");
            if (i14 <= 256) {
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PinLoginScreenKt.PinLoginScreen$lambda$10$lambda$9(pinLoginViewModel3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PinLoginScreenKt.PinLoginScreen$lambda$10$lambda$9(pinLoginViewModel3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier7 = companion;
            PinLoginScreenContent(modifier7, agentPinLoginScreen$lambda$3, strPinLoginScreen$lambda$8, zPinLoginScreen$lambda$5, strPinLoginScreen$lambda$7, function4, (Function0) objRememberedValue2, composerStartRestartGroup, (i7 & 14) | (Agent.$stable << 3), 0);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            navHostController3 = navHostController4;
            modifier3 = modifier7;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            str3 = str;
            modifier3 = modifier2;
            navHostController3 = navHostController2;
        }
        pinLoginViewModel2 = pinLoginViewModel3;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PinLoginScreenKt.PinLoginScreen$lambda$11(modifier3, navHostController3, pinLoginViewModel2, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinLoginScreen$lambda$8$lambda$7(PinLoginViewModel pinLoginViewModel, String number) {
        Intrinsics.checkNotNullParameter(number, "number");
        pinLoginViewModel.onNumberClick(number);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinLoginScreen$lambda$10$lambda$9(PinLoginViewModel pinLoginViewModel) {
        pinLoginViewModel.onDeletePin();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x008e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0091  */
    /* JADX WARN: Code duplicated, block: B:46:0x0095  */
    /* JADX WARN: Code duplicated, block: B:48:0x009d  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:86:0x013d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0143  */
    /* JADX WARN: Code duplicated, block: B:91:0x0151  */
    /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
    public static final void PinLoginScreenContent(Modifier modifier, final Agent agent, final String pin, boolean z, String str, final Function1<? super String, Unit> onNumberClick, final Function0<Unit> onDeletePin, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z2;
        int i4;
        String str2;
        int i5;
        boolean z3;
        Composer composer2;
        final Modifier.Companion companion;
        final boolean z4;
        final String str3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final String str4;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(pin, "pin");
        Intrinsics.checkNotNullParameter(onNumberClick, "onNumberClick");
        Intrinsics.checkNotNullParameter(onDeletePin, "onDeletePin");
        Composer composerStartRestartGroup = composer.startRestartGroup(-984848514);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PinLoginScreenContent)N(modifier,agent,pin,isLoading,errorMessage,onNumberClick,onDeletePin)91@3291L2739,89@3220L2816:PinLoginScreen.kt#oif8tm");
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
        if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(agent) : composerStartRestartGroup.changedInstance(agent) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(pin) ? 256 : 128;
        }
        int i9 = i2 & 8;
        if (i9 == 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                    i3 |= i6;
                }
                if ((599187 & i3) != 599186) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    companion = modifier2;
                    z4 = z2;
                    str3 = str2;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z2 = false;
                    }
                    if (i4 != 0) {
                        str4 = null;
                    } else {
                        str4 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-984848514, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenContent (PinLoginScreen.kt:88)");
                    }
                    final boolean z5 = z2;
                    composer2 = composerStartRestartGroup;
                    ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1023932237, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PinLoginScreenKt.PinLoginScreenContent$lambda$19(companion, agent, str4, pin, z5, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                    str3 = str4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PinLoginScreenKt.PinLoginScreenContent$lambda$20(companion, agent, pin, z4, str3, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            str2 = str;
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i3 |= i6;
            }
            if ((599187 & i3) != 599186) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                companion = modifier2;
                z4 = z2;
                str3 = str2;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    str4 = null;
                } else {
                    str4 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-984848514, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenContent (PinLoginScreen.kt:88)");
                }
                final boolean z6 = z2;
                composer2 = composerStartRestartGroup;
                ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1023932237, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PinLoginScreenKt.PinLoginScreenContent$lambda$19(companion, agent, str4, pin, z6, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z6;
                str3 = str4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PinLoginScreenKt.PinLoginScreenContent$lambda$20(companion, agent, pin, z4, str3, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i3 |= i6;
            }
            if ((599187 & i3) != 599186) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                companion = modifier2;
                z4 = z2;
                str3 = str2;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    str4 = null;
                } else {
                    str4 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-984848514, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenContent (PinLoginScreen.kt:88)");
                }
                final boolean z7 = z2;
                composer2 = composerStartRestartGroup;
                ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1023932237, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PinLoginScreenKt.PinLoginScreenContent$lambda$19(companion, agent, str4, pin, z7, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 805306374, 510);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z7;
                str3 = str4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PinLoginScreenKt.PinLoginScreenContent$lambda$20(companion, agent, pin, z4, str3, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        str2 = str;
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(onNumberClick)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        }
        if ((1572864 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(onDeletePin)) {
                i6 = 1048576;
            } else {
                i6 = 524288;
            }
            i3 |= i6;
        }
        if ((599187 & i3) != 599186) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            companion = modifier2;
            z4 = z2;
            str3 = str2;
        } else {
            if (i8 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i9 != 0) {
                z2 = false;
            }
            if (i4 != 0) {
                str4 = null;
            } else {
                str4 = str2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-984848514, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenContent (PinLoginScreen.kt:88)");
            }
            final boolean z8 = z2;
            composer2 = composerStartRestartGroup;
            ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1023932237, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PinLoginScreenKt.PinLoginScreenContent$lambda$19(companion, agent, str4, pin, z8, onNumberClick, onDeletePin, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z8;
            str3 = str4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PinLoginScreenKt.PinLoginScreenContent$lambda$20(companion, agent, pin, z4, str3, onNumberClick, onDeletePin, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit PinLoginScreenContent$lambda$19(Modifier modifier, Agent agent, String str, String str2, boolean z, final Function1 function1, final Function0 function0, PaddingValues innerPadding, Composer composer, int i) {
        int i2;
        float f;
        boolean z2;
        int i3;
        float f2;
        Composer composer2;
        long onSurface;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation(composer, "CN(innerPadding)92@3321L2699:PinLoginScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(innerPadding) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1023932237, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenContent.<anonymous> (PinLoginScreen.kt:92)");
            }
            float f3 = 16;
            float f4 = 8;
            Modifier modifierM1119paddingVpY3zN4 = PaddingKt.m1119paddingVpY3zN4(PaddingKt.padding(SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null), innerPadding), Dp.m8684constructorimpl(f3), Dp.m8684constructorimpl(f4));
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
            ComposerKt.sourceInformationMarkerStart(composer, 453723192, "C98@3538L2468:PinLoginScreen.kt#oif8tm");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1940990647, "C104@3812L40,110@4177L11,103@3771L451,130@4940L38,134@5117L10,132@5000L452,140@5473L236,146@5730L38,149@5872L35,150@5949L17,147@5789L199:PinLoginScreen.kt#oif8tm");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.profile, composer, 0), "Profile Picture", ClipKt.clip(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(60)), RoundedCornerShapeKt.getCircleShape()), (Alignment) null, ContentScale.INSTANCE.getFit(), 0.0f, ColorFilter.Companion.m5981tintxETnrds$default(ColorFilter.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface(), 0, 2, null), composer, 24624, 40);
            if (agent == null) {
                composer.startReplaceGroup(-1940563469);
                composer.endReplaceGroup();
                composer2 = composer;
                z2 = true;
                i3 = 0;
                f = f3;
                f2 = f4;
            } else {
                composer.startReplaceGroup(-1940563468);
                ComposerKt.sourceInformation(composer, "*114@4280L40,118@4477L10,116@4346L276,125@4752L10,123@4648L249");
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(5)), composer, 6);
                f = f3;
                z2 = true;
                i3 = 0;
                f2 = f4;
                TextKt.m3864TextNvy7gAk(agent.getFirstName() + ServerSentEventKt.SPACE + agent.getLastName(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), 0L, 0L, new FontWeight(500), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 131070);
                TextKt.m3864TextNvy7gAk(agent.getEmail(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), 0L, 0L, new FontWeight(400), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 131070);
                composer2 = composer;
                Unit unit = Unit.INSTANCE;
                composer2.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer2, i3);
            String str3 = str == null ? "Enter your PIN" : str;
            TextStyle bodyLarge = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyLarge();
            int iM8540getCentere0LSkKk = TextAlign.INSTANCE.m8540getCentere0LSkKk();
            if (str != null) {
                composer2.startReplaceGroup(-478208202);
                ComposerKt.sourceInformation(composer2, "136@5278L11");
                onSurface = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getError();
            } else {
                composer2.startReplaceGroup(-478207014);
                ComposerKt.sourceInformation(composer2, "136@5315L11");
                onSurface = MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface();
            }
            composer2.endReplaceGroup();
            TextKt.m3864TextNvy7gAk(str3, PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f2), 7, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(bodyLarge, onSurface, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, iM8540getCentere0LSkKk, 0, 0L, null, null, null, 0, 0, null, 16744446, null), composer, 48, 0, 131068);
            PinRowKt.PinRow(PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f), 7, null), str2, z, str != null ? z2 : i3, composer, 6, 0);
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, i3);
            ComposerKt.sourceInformationMarkerStart(composer, -478189548, "CC(remember):PinLoginScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PinLoginScreenKt.PinLoginScreenContent$lambda$19$lambda$18$lambda$17$lambda$14$lambda$13(function1, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function2 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -478187102, "CC(remember):PinLoginScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(function0);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PinLoginScreenKt.PinLoginScreenContent$lambda$19$lambda$18$lambda$17$lambda$16$lambda$15(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            KeypadKt.Keypad(function2, (Function0) objRememberedValue2, null, str2, composer, 0, 4);
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
    public static final Unit PinLoginScreenContent$lambda$19$lambda$18$lambda$17$lambda$14$lambda$13(Function1 function1, String number) {
        Intrinsics.checkNotNullParameter(number, "number");
        function1.invoke(number);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinLoginScreenContent$lambda$19$lambda$18$lambda$17$lambda$16$lambda$15(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final void PinLoginPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1456427194);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PinLoginPreview)174@6446L2,175@6472L2,170@6328L153:PinLoginScreen.kt#oif8tm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1456427194, i, -1, "com.example.bingwahybrid.presentation.ui.screens.PinLoginPreview (PinLoginScreen.kt:160)");
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID(...)");
            Agent agent = new Agent(uuidRandomUUID, "John", "Doe", "07588256553", "john.doe@gmail.com", "", false, false, 192, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 532818056, "CC(remember):PinLoginScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PinLoginScreenKt.PinLoginPreview$lambda$22$lambda$21((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 532818888, "CC(remember):PinLoginScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            PinLoginScreenContent(null, agent, "123", false, null, function1, (Function0) objRememberedValue2, composerStartRestartGroup, (Agent.$stable << 3) | 1772928, 17);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.PinLoginScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PinLoginScreenKt.PinLoginPreview$lambda$25(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinLoginPreview$lambda$22$lambda$21(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private static final Agent PinLoginScreen$lambda$0(State<Agent> state) {
        return state.getValue();
    }

    private static final String PinLoginScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    private static final boolean PinLoginScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PinLoginScreen$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String PinLoginScreen$lambda$4(State<String> state) {
        return state.getValue();
    }
}
