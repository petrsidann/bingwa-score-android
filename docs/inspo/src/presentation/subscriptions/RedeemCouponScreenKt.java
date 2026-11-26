package com.example.bingwahybrid.presentation.subscriptions;

import androidx.camera.video.AudioStats;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ErrorKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.lifecycle.viewmodel.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import com.example.bingwahybrid.data.remote.api.response.RedeemCouponResult;
import com.example.bingwahybrid.domain.features.enums.FeatureCodes;
import com.example.bingwahybrid.domain.utils.TimeUtilsKt;
import com.example.bingwahybrid.presentation.navigation.Route;
import com.example.bingwahybrid.presentation.subscriptions.components.PaymentSuccessDialogKt;
import com.example.bingwahybrid.presentation.ui.components.CustomButtonKt;
import com.example.bingwahybrid.presentation.ui.components.ValidatedTextFieldKt;
import com.example.bingwahybrid.presentation.viewmodel.RedeemCouponViewModel;
import io.ktor.sse.ServerSentEventKt;
import java.util.Locale;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RedeemCouponScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\rX\u008a\u0084\u0002²\u0006\f\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u008a\u0084\u0002²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"RedeemCouponScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/RedeemCouponViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/viewmodel/RedeemCouponViewModel;Landroidx/compose/runtime/Composer;II)V", "app_debug", "couponCode", "", "isError", "", "loading", "redeemCouponResult", "Lcom/example/bingwahybrid/data/remote/api/response/RedeemCouponResult;", "error", "showSuccessDialog"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RedeemCouponScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RedeemCouponScreen$lambda$30(Modifier modifier, NavHostController navHostController, RedeemCouponViewModel redeemCouponViewModel, int i, int i2, Composer composer, int i3) {
        RedeemCouponScreen(modifier, navHostController, redeemCouponViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x024c  */
    /* JADX WARN: Code duplicated, block: B:103:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:105:0x02be  */
    /* JADX WARN: Code duplicated, block: B:106:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:111:0x02df  */
    /* JADX WARN: Code duplicated, block: B:114:0x030c  */
    /* JADX WARN: Code duplicated, block: B:119:0x0331  */
    /* JADX WARN: Code duplicated, block: B:121:0x0344  */
    /* JADX WARN: Code duplicated, block: B:124:0x0353  */
    /* JADX WARN: Code duplicated, block: B:126:0x035c  */
    /* JADX WARN: Code duplicated, block: B:129:0x0368  */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0064  */
    /* JADX WARN: Code duplicated, block: B:34:0x0067  */
    /* JADX WARN: Code duplicated, block: B:38:0x0073  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:66:0x0111  */
    /* JADX WARN: Code duplicated, block: B:68:0x011d  */
    /* JADX WARN: Code duplicated, block: B:72:0x012d  */
    /* JADX WARN: Code duplicated, block: B:75:0x0149  */
    /* JADX WARN: Code duplicated, block: B:78:0x0169  */
    /* JADX WARN: Code duplicated, block: B:84:0x0190  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:90:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:95:0x0218  */
    /* JADX WARN: Type inference failed for: r5v17, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object, kotlin.coroutines.Continuation, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v42 */
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
    public static final void RedeemCouponScreen(Modifier modifier, NavHostController navHostController, RedeemCouponViewModel redeemCouponViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        NavHostController navHostController2;
        int i4;
        boolean z;
        final RedeemCouponViewModel redeemCouponViewModel2;
        final Modifier modifier3;
        final NavHostController navHostController3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Modifier.Companion companion;
        NavHostController navHostController4;
        Object obj;
        final RedeemCouponViewModel redeemCouponViewModel3;
        final NavHostController navHostController5;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        ?? r5;
        Object objRememberedValue;
        final MutableState mutableState;
        Object objRememberedValue2;
        final boolean z2;
        Object objRememberedValue3;
        CoroutineScope coroutineScope;
        State stateCollectAsState;
        final State stateCollectAsState2;
        Object objRememberedValue4;
        final MutableState mutableState2;
        boolean zChanged;
        RedeemCouponScreenKt$RedeemCouponScreen$1$1 redeemCouponScreenKt$RedeemCouponScreen$1$1RememberedValue;
        boolean zChanged2;
        RedeemCouponScreenKt$RedeemCouponScreen$2$1 redeemCouponScreenKt$RedeemCouponScreen$2$1RememberedValue;
        RedeemCouponResult redeemCouponResultRedeemCouponScreen$lambda$7;
        double durationHours;
        RedeemCouponResult redeemCouponResultRedeemCouponScreen$lambda$8;
        String name;
        Object objRememberedValue5;
        boolean zChangedInstance;
        Object objRememberedValue6;
        int i5;
        boolean zChangedInstance2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-273337115);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RedeemCouponScreen)N(modifier,navController,viewModel)35@1624L31,36@1675L34,38@1788L24,39@1850L16,40@1926L16,41@1976L16,42@2022L34,45@2140L68,45@2105L103,49@2271L89,49@2249L111,56@2393L347,66@2747L2135,55@2366L2516:RedeemCouponScreen.kt#6tb7vd");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                navHostController2 = navHostController;
                i3 |= composerStartRestartGroup.changedInstance(navHostController2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) != 0) {
                    i5 = 128;
                } else {
                    if ((i & 512) == 0) {
                        zChangedInstance2 = composerStartRestartGroup.changed(redeemCouponViewModel);
                    } else {
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(redeemCouponViewModel);
                    }
                    if (zChangedInstance2) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                }
                i3 |= i5;
            }
            i4 = i3;
            if ((i4 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "33@1581L15");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
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
                        ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(RedeemCouponViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i4 &= -897;
                        redeemCouponViewModel3 = (RedeemCouponViewModel) viewModel;
                        obj = null;
                    } else {
                        obj = null;
                        redeemCouponViewModel3 = redeemCouponViewModel;
                    }
                    navHostController5 = navHostController4;
                    r5 = obj;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i4 &= -897;
                    }
                    redeemCouponViewModel3 = redeemCouponViewModel;
                    companion = modifier2;
                    navHostController5 = navHostController2;
                    r5 = 0;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-273337115, i4, -1, "com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreen (RedeemCouponScreen.kt:34)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683954780, "CC(remember):RedeemCouponScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", r5, 2, r5);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683953145, "CC(remember):RedeemCouponScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, r5, 2, r5);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (!StringsKt.isBlank(RedeemCouponScreen$lambda$1(mutableState)) || RedeemCouponScreen$lambda$4(mutableState3)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                coroutineScope = (CoroutineScope) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final State stateCollectAsState3 = SnapshotStateKt.collectAsState(redeemCouponViewModel3.getLoading(), r5, composerStartRestartGroup, 0, 1);
                stateCollectAsState = SnapshotStateKt.collectAsState(redeemCouponViewModel3.getRedeemCouponResult(), r5, composerStartRestartGroup, 0, 1);
                stateCollectAsState2 = SnapshotStateKt.collectAsState(redeemCouponViewModel3.getError(), r5, composerStartRestartGroup, 0, 1);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683942041, "CC(remember):RedeemCouponScreen.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, r5, 2, r5);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState2 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                RedeemCouponResult redeemCouponResultRedeemCouponScreen$lambda$9 = RedeemCouponScreen$lambda$7(stateCollectAsState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683938231, "CC(remember):RedeemCouponScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCollectAsState);
                redeemCouponScreenKt$RedeemCouponScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || redeemCouponScreenKt$RedeemCouponScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    redeemCouponScreenKt$RedeemCouponScreen$1$1RememberedValue = new RedeemCouponScreenKt$RedeemCouponScreen$1$1(stateCollectAsState, mutableState2, r5);
                    composerStartRestartGroup.updateRememberedValue(redeemCouponScreenKt$RedeemCouponScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(redeemCouponResultRedeemCouponScreen$lambda$9, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) redeemCouponScreenKt$RedeemCouponScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                String strRedeemCouponScreen$lambda$8 = RedeemCouponScreen$lambda$8(stateCollectAsState2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683934018, "CC(remember):RedeemCouponScreen.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope);
                redeemCouponScreenKt$RedeemCouponScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged2 || redeemCouponScreenKt$RedeemCouponScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    redeemCouponScreenKt$RedeemCouponScreen$2$1RememberedValue = new RedeemCouponScreenKt$RedeemCouponScreen$2$1(stateCollectAsState2, coroutineScope, r5);
                    composerStartRestartGroup.updateRememberedValue(redeemCouponScreenKt$RedeemCouponScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strRedeemCouponScreen$lambda$8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) redeemCouponScreenKt$RedeemCouponScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-313664855, true, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return RedeemCouponScreenKt.RedeemCouponScreen$lambda$17(navHostController5, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                Function3 function3 = new Function3() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return RedeemCouponScreenKt.RedeemCouponScreen$lambda$25(companion, z2, redeemCouponViewModel3, mutableState, mutableState3, stateCollectAsState2, stateCollectAsState3, (PaddingValues) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                };
                Modifier modifier4 = companion;
                ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1452737588, true, function3, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
                composerStartRestartGroup = composerStartRestartGroup;
                if (RedeemCouponScreen$lambda$10(mutableState2)) {
                    composerStartRestartGroup.startReplaceGroup(270625341);
                } else {
                    composerStartRestartGroup.startReplaceGroup(275515405);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "127@5271L29,128@5330L125,125@5080L385");
                    redeemCouponResultRedeemCouponScreen$lambda$7 = RedeemCouponScreen$lambda$7(stateCollectAsState);
                    if (redeemCouponResultRedeemCouponScreen$lambda$7 != null) {
                        durationHours = redeemCouponResultRedeemCouponScreen$lambda$7.getDurationHours();
                    } else {
                        durationHours = AudioStats.AUDIO_AMPLITUDE_NONE;
                    }
                    double d = 60;
                    String durationMillis = TimeUtilsKt.formatDurationMillis((long) (durationHours * d * d * ((double) 1000)));
                    redeemCouponResultRedeemCouponScreen$lambda$8 = RedeemCouponScreen$lambda$7(stateCollectAsState);
                    if (redeemCouponResultRedeemCouponScreen$lambda$8 != null || (name = redeemCouponResultRedeemCouponScreen$lambda$8.getName()) == null) {
                        name = "";
                    }
                    String str = "You have successfully redeemed " + name + ". Your subscription has been extended by " + durationMillis;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683838078, "CC(remember):RedeemCouponScreen.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return RedeemCouponScreenKt.RedeemCouponScreen$lambda$27$lambda$26(mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function0 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683836094, "CC(remember):RedeemCouponScreen.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(navHostController5);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return RedeemCouponScreenKt.RedeemCouponScreen$lambda$29$lambda$28(navHostController5, mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PaymentSuccessDialogKt.PaymentSuccessDialog(str, function0, (Function0) objRememberedValue6, composerStartRestartGroup, 48);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navHostController3 = navHostController5;
                redeemCouponViewModel2 = redeemCouponViewModel3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                redeemCouponViewModel2 = redeemCouponViewModel;
                modifier3 = modifier2;
                navHostController3 = navHostController2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return RedeemCouponScreenKt.RedeemCouponScreen$lambda$30(modifier3, navHostController3, redeemCouponViewModel2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        navHostController2 = navHostController;
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i5 = 128;
            } else {
                if ((i & 512) == 0) {
                    zChangedInstance2 = composerStartRestartGroup.changed(redeemCouponViewModel);
                } else {
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(redeemCouponViewModel);
                }
                if (zChangedInstance2) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
            }
            i3 |= i5;
        }
        i4 = i3;
        if ((i4 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "33@1581L15");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
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
                    ViewModel viewModel2 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(RedeemCouponViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory2, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i4 &= -897;
                    redeemCouponViewModel3 = (RedeemCouponViewModel) viewModel2;
                    obj = null;
                } else {
                    obj = null;
                    redeemCouponViewModel3 = redeemCouponViewModel;
                }
                navHostController5 = navHostController4;
                r5 = obj;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
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
                    ViewModel viewModel3 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(RedeemCouponViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory3, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i4 &= -897;
                    redeemCouponViewModel3 = (RedeemCouponViewModel) viewModel3;
                    obj = null;
                } else {
                    obj = null;
                    redeemCouponViewModel3 = redeemCouponViewModel;
                }
                navHostController5 = navHostController4;
                r5 = obj;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-273337115, i4, -1, "com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreen (RedeemCouponScreen.kt:34)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683954780, "CC(remember):RedeemCouponScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", r5, 2, r5);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683953145, "CC(remember):RedeemCouponScreen.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, r5, 2, r5);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (StringsKt.isBlank(RedeemCouponScreen$lambda$1(mutableState))) {
                z2 = false;
            } else {
                z2 = false;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            coroutineScope = (CoroutineScope) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State stateCollectAsState4 = SnapshotStateKt.collectAsState(redeemCouponViewModel3.getLoading(), r5, composerStartRestartGroup, 0, 1);
            stateCollectAsState = SnapshotStateKt.collectAsState(redeemCouponViewModel3.getRedeemCouponResult(), r5, composerStartRestartGroup, 0, 1);
            stateCollectAsState2 = SnapshotStateKt.collectAsState(redeemCouponViewModel3.getError(), r5, composerStartRestartGroup, 0, 1);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683942041, "CC(remember):RedeemCouponScreen.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, r5, 2, r5);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            mutableState2 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            RedeemCouponResult redeemCouponResultRedeemCouponScreen$lambda$10 = RedeemCouponScreen$lambda$7(stateCollectAsState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683938231, "CC(remember):RedeemCouponScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCollectAsState);
            redeemCouponScreenKt$RedeemCouponScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                redeemCouponScreenKt$RedeemCouponScreen$1$1RememberedValue = new RedeemCouponScreenKt$RedeemCouponScreen$1$1(stateCollectAsState, mutableState2, r5);
                composerStartRestartGroup.updateRememberedValue(redeemCouponScreenKt$RedeemCouponScreen$1$1RememberedValue);
            } else {
                redeemCouponScreenKt$RedeemCouponScreen$1$1RememberedValue = new RedeemCouponScreenKt$RedeemCouponScreen$1$1(stateCollectAsState, mutableState2, r5);
                composerStartRestartGroup.updateRememberedValue(redeemCouponScreenKt$RedeemCouponScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(redeemCouponResultRedeemCouponScreen$lambda$10, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) redeemCouponScreenKt$RedeemCouponScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            String strRedeemCouponScreen$lambda$9 = RedeemCouponScreen$lambda$8(stateCollectAsState2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683934018, "CC(remember):RedeemCouponScreen.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope);
            redeemCouponScreenKt$RedeemCouponScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                redeemCouponScreenKt$RedeemCouponScreen$2$1RememberedValue = new RedeemCouponScreenKt$RedeemCouponScreen$2$1(stateCollectAsState2, coroutineScope, r5);
                composerStartRestartGroup.updateRememberedValue(redeemCouponScreenKt$RedeemCouponScreen$2$1RememberedValue);
            } else {
                redeemCouponScreenKt$RedeemCouponScreen$2$1RememberedValue = new RedeemCouponScreenKt$RedeemCouponScreen$2$1(stateCollectAsState2, coroutineScope, r5);
                composerStartRestartGroup.updateRememberedValue(redeemCouponScreenKt$RedeemCouponScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strRedeemCouponScreen$lambda$9, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) redeemCouponScreenKt$RedeemCouponScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-313664855, true, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return RedeemCouponScreenKt.RedeemCouponScreen$lambda$17(navHostController5, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            Function3 function4 = new Function3() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return RedeemCouponScreenKt.RedeemCouponScreen$lambda$25(companion, z2, redeemCouponViewModel3, mutableState, mutableState4, stateCollectAsState2, stateCollectAsState4, (PaddingValues) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            };
            Modifier modifier5 = companion;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda2, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1452737588, true, function4, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            composerStartRestartGroup = composerStartRestartGroup;
            if (RedeemCouponScreen$lambda$10(mutableState2)) {
                composerStartRestartGroup.startReplaceGroup(270625341);
            } else {
                composerStartRestartGroup.startReplaceGroup(275515405);
                ComposerKt.sourceInformation(composerStartRestartGroup, "127@5271L29,128@5330L125,125@5080L385");
                redeemCouponResultRedeemCouponScreen$lambda$7 = RedeemCouponScreen$lambda$7(stateCollectAsState);
                if (redeemCouponResultRedeemCouponScreen$lambda$7 != null) {
                    durationHours = redeemCouponResultRedeemCouponScreen$lambda$7.getDurationHours();
                } else {
                    durationHours = AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                double d2 = 60;
                String durationMillis2 = TimeUtilsKt.formatDurationMillis((long) (durationHours * d2 * d2 * ((double) 1000)));
                redeemCouponResultRedeemCouponScreen$lambda$8 = RedeemCouponScreen$lambda$7(stateCollectAsState);
                if (redeemCouponResultRedeemCouponScreen$lambda$8 != null) {
                    name = "";
                } else {
                    name = "";
                }
                String str2 = "You have successfully redeemed " + name + ". Your subscription has been extended by " + durationMillis2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683838078, "CC(remember):RedeemCouponScreen.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RedeemCouponScreenKt.RedeemCouponScreen$lambda$27$lambda$26(mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Function0 function1 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -683836094, "CC(remember):RedeemCouponScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(navHostController5);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RedeemCouponScreenKt.RedeemCouponScreen$lambda$29$lambda$28(navHostController5, mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RedeemCouponScreenKt.RedeemCouponScreen$lambda$29$lambda$28(navHostController5, mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PaymentSuccessDialogKt.PaymentSuccessDialog(str2, function1, (Function0) objRememberedValue6, composerStartRestartGroup, 48);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            navHostController3 = navHostController5;
            redeemCouponViewModel2 = redeemCouponViewModel3;
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            redeemCouponViewModel2 = redeemCouponViewModel;
            modifier3 = modifier2;
            navHostController3 = navHostController2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return RedeemCouponScreenKt.RedeemCouponScreen$lambda$30(modifier3, navHostController3, redeemCouponViewModel2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final String RedeemCouponScreen$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean RedeemCouponScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void RedeemCouponScreen$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean RedeemCouponScreen$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RedeemCouponScreen$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RedeemCouponScreen$lambda$17(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C59@2502L214,57@2407L323:RedeemCouponScreen.kt#6tb7vd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-313664855, i, -1, "com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreen.<anonymous> (RedeemCouponScreen.kt:57)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$RedeemCouponScreenKt.INSTANCE.getLambda$602003301$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(1788980643, true, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RedeemCouponScreenKt.RedeemCouponScreen$lambda$17$lambda$16(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RedeemCouponScreen$lambda$17$lambda$16(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C60@2545L33,60@2524L174:RedeemCouponScreen.kt#6tb7vd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1788980643, i, -1, "com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreen.<anonymous>.<anonymous> (RedeemCouponScreen.kt:60)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1223480932, "CC(remember):RedeemCouponScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RedeemCouponScreenKt.RedeemCouponScreen$lambda$17$lambda$16$lambda$15$lambda$14(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$RedeemCouponScreenKt.INSTANCE.m9645getLambda$75646267$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RedeemCouponScreen$lambda$17$lambda$16$lambda$15$lambda$14(NavHostController navHostController) {
        if (navHostController != null) {
            navHostController.popBackStack();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RedeemCouponScreen$lambda$25(Modifier modifier, boolean z, final RedeemCouponViewModel redeemCouponViewModel, final MutableState mutableState, final MutableState mutableState2, State state, final State state2, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        int i3;
        String str;
        boolean z2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)67@2774L2102:RedeemCouponScreen.kt#6tb7vd");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1452737588, i2, -1, "com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreen.<anonymous> (RedeemCouponScreen.kt:67)");
            }
            float f = 16;
            Modifier modifierM1119paddingVpY3zN4 = PaddingKt.m1119paddingVpY3zN4(PaddingKt.padding(modifier, paddingValues), Dp.m8684constructorimpl(f), Dp.m8684constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, 793995327, "C74@3028L212,72@2940L521,104@4278L41,106@4372L103,111@4597L269,105@4332L534:RedeemCouponScreen.kt#6tb7vd");
            String strRedeemCouponScreen$lambda$1 = RedeemCouponScreen$lambda$1(mutableState);
            boolean zRedeemCouponScreen$lambda$4 = RedeemCouponScreen$lambda$4(mutableState2);
            String strRedeemCouponScreen$lambda$8 = RedeemCouponScreen$lambda$8(state);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -390028142, "CC(remember):RedeemCouponScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RedeemCouponScreenKt.RedeemCouponScreen$lambda$25$lambda$24$lambda$19$lambda$18(mutableState, mutableState2, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(strRedeemCouponScreen$lambda$1, (Function1) objRememberedValue, "Promo code / coupon", zRedeemCouponScreen$lambda$4, strRedeemCouponScreen$lambda$8, 0, modifierFillMaxWidth$default, true, composer, 14156208, 32);
            Composer composer2 = composer;
            if (!RedeemCouponScreen$lambda$4(mutableState2)) {
                i3 = 6;
                str = "CC(remember):RedeemCouponScreen.kt#9igjgp";
                z2 = false;
                composer2.startReplaceGroup(791018148);
            } else {
                composer2.startReplaceGroup(794502362);
                ComposerKt.sourceInformation(composer2, "86@3505L746");
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                float f2 = 4;
                Modifier modifierM1122paddingqDBjuR0$default = PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8684constructorimpl(f2), Dp.m8684constructorimpl(f2), 0.0f, 0.0f, 12, null);
                ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1122paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM5259constructorimpl2 = Updater.m5259constructorimpl(composer2);
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 572235847, "C93@3853L11,90@3692L257,96@3970L39,99@4126L11,100@4191L10,97@4030L203:RedeemCouponScreen.kt#6tb7vd");
                IconKt.m3158Iconww6aTOc(ErrorKt.getError(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getError(), composer2, 432, 0);
                SpacerKt.Spacer(SizeKt.m1175width3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composer2, 6);
                String strRedeemCouponScreen$lambda$9 = RedeemCouponScreen$lambda$8(state);
                if (strRedeemCouponScreen$lambda$9 == null) {
                    strRedeemCouponScreen$lambda$9 = "";
                }
                z2 = false;
                i3 = 6;
                str = "CC(remember):RedeemCouponScreen.kt#9igjgp";
                TextKt.m3864TextNvy7gAk(strRedeemCouponScreen$lambda$9, null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getError(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, 131066);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
            }
            composer2.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24)), composer2, i3);
            boolean z3 = (!z || RedeemCouponScreen$lambda$6(state2)) ? z2 : true;
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer2, -389985243, str);
            boolean zChangedInstance = composer2.changedInstance(redeemCouponViewModel);
            Object objRememberedValue2 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RedeemCouponScreenKt.RedeemCouponScreen$lambda$25$lambda$24$lambda$22$lambda$21(redeemCouponViewModel, mutableState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            CustomButtonKt.CustomButton((Function0) objRememberedValue2, modifierFillMaxWidth$default2, z3, false, ComposableLambdaKt.rememberComposableLambda(304299882, true, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RedeemCouponScreenKt.RedeemCouponScreen$lambda$25$lambda$24$lambda$23(state2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, 24624, 8);
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
    public static final Unit RedeemCouponScreen$lambda$25$lambda$24$lambda$19$lambda$18(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String upperCase = StringsKt.replace$default(it, ServerSentEventKt.SPACE, "", false, 4, (Object) null).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        mutableState.setValue(upperCase);
        RedeemCouponScreen$lambda$5(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RedeemCouponScreen$lambda$25$lambda$24$lambda$22$lambda$21(RedeemCouponViewModel redeemCouponViewModel, MutableState mutableState) {
        redeemCouponViewModel.redeemCoupon(RedeemCouponScreen$lambda$1(mutableState), FeatureCodes.SUBSCRIPTION_BINGWAHYBRID);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RedeemCouponScreen$lambda$25$lambda$24$lambda$23(State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C114@4732L10,112@4615L237:RedeemCouponScreen.kt#6tb7vd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(304299882, i, -1, "com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreen.<anonymous>.<anonymous>.<anonymous> (RedeemCouponScreen.kt:112)");
            }
            TextKt.m3864TextNvy7gAk(RedeemCouponScreen$lambda$6(state) ? "Redeeming..." : "Apply", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RedeemCouponScreen$lambda$27$lambda$26(MutableState mutableState) {
        RedeemCouponScreen$lambda$11(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RedeemCouponScreen$lambda$29$lambda$28(NavHostController navHostController, MutableState mutableState) {
        RedeemCouponScreen$lambda$11(mutableState, false);
        if (navHostController != null) {
            NavController.popBackStack$default((NavController) navHostController, Route.Home.INSTANCE.getName(), false, false, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private static final boolean RedeemCouponScreen$lambda$6(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RedeemCouponResult RedeemCouponScreen$lambda$7(State<RedeemCouponResult> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String RedeemCouponScreen$lambda$8(State<String> state) {
        return state.getValue();
    }
}
