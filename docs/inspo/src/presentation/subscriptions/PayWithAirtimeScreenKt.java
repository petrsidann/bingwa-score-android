package com.example.bingwahybrid.presentation.subscriptions;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextFieldColors;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
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
import com.example.bingwahybrid.domain.enums.LoadingState;
import com.example.bingwahybrid.domain.enums.SubscriptionType;
import com.example.bingwahybrid.domain.features.model.FeaturePass;
import com.example.bingwahybrid.presentation.navigation.Route;
import com.example.bingwahybrid.presentation.subscriptions.components.PaymentSuccessDialogKt;
import com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionPaymentViewModel;
import com.example.bingwahybrid.presentation.ui.components.CustomButtonKt;
import java.util.UUID;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PayWithAirtimeScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a/\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0013²\u0006\f\u0010\n\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\f\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u008e\u0002"}, d2 = {"PayWithAirtimeScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/subscriptions/viewmodels/SubscriptionPaymentViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/subscriptions/viewmodels/SubscriptionPaymentViewModel;Landroidx/compose/runtime/Composer;II)V", "PayWithAirtimeScreenContent", "featurePass", "Lcom/example/bingwahybrid/domain/features/model/FeaturePass;", "onPay", "Lkotlin/Function0;", "loadingState", "Lcom/example/bingwahybrid/domain/enums/LoadingState;", "(Lcom/example/bingwahybrid/domain/features/model/FeaturePass;Lkotlin/jvm/functions/Function0;Lcom/example/bingwahybrid/domain/enums/LoadingState;Landroidx/compose/runtime/Composer;II)V", "PayWithAirtimeScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "errorMessage", "", "subscriptionMessage", "showSubscriptionSuccessDialog", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PayWithAirtimeScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PayWithAirtimeScreen$lambda$21(Modifier modifier, NavHostController navHostController, SubscriptionPaymentViewModel subscriptionPaymentViewModel, int i, int i2, Composer composer, int i3) {
        PayWithAirtimeScreen(modifier, navHostController, subscriptionPaymentViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PayWithAirtimeScreenContent$lambda$26(FeaturePass featurePass, Function0 function0, LoadingState loadingState, int i, int i2, Composer composer, int i3) {
        PayWithAirtimeScreenContent(featurePass, function0, loadingState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PayWithAirtimeScreenPreview$lambda$29(int i, Composer composer, int i2) {
        PayWithAirtimeScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0291  */
    /* JADX WARN: Code duplicated, block: B:106:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:108:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:111:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:113:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:116:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0053  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:30:0x005b  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0066  */
    /* JADX WARN: Code duplicated, block: B:34:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x007f  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:66:0x0113  */
    /* JADX WARN: Code duplicated, block: B:68:0x011f  */
    /* JADX WARN: Code duplicated, block: B:72:0x012d  */
    /* JADX WARN: Code duplicated, block: B:75:0x014f  */
    /* JADX WARN: Code duplicated, block: B:78:0x0198  */
    /* JADX WARN: Code duplicated, block: B:91:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:96:0x0212  */
    /* JADX WARN: Code duplicated, block: B:99:0x0270  */
    /* JADX WARN: Type inference failed for: r5v17, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v46 */
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
    public static final void PayWithAirtimeScreen(Modifier modifier, NavHostController navHostController, SubscriptionPaymentViewModel subscriptionPaymentViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        NavHostController navHostController2;
        int i4;
        boolean z;
        final SubscriptionPaymentViewModel subscriptionPaymentViewModel2;
        final Modifier modifier3;
        final NavHostController navHostController3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Modifier.Companion companion;
        NavHostController navHostController4;
        Object obj;
        int i5;
        final SubscriptionPaymentViewModel subscriptionPaymentViewModel3;
        final NavHostController navHostController5;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        ?? r5;
        Object objRememberedValue;
        CoroutineScope coroutineScope;
        State stateCollectAsState;
        State stateCollectAsState2;
        final State stateCollectAsState3;
        Object objRememberedValue2;
        final MutableState mutableState;
        boolean zChanged;
        PayWithAirtimeScreenKt$PayWithAirtimeScreen$1$1 payWithAirtimeScreenKt$PayWithAirtimeScreen$1$1RememberedValue;
        boolean zChanged2;
        PayWithAirtimeScreenKt$PayWithAirtimeScreen$2$1 payWithAirtimeScreenKt$PayWithAirtimeScreen$2$1RememberedValue;
        Object objRememberedValue3;
        boolean zChangedInstance;
        Object objRememberedValue4;
        int i6;
        boolean zChangedInstance2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1064051910);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PayWithAirtimeScreen)N(modifier,navController,viewModel)48@2263L24,49@2333L16,50@2397L16,51@2475L16,52@2539L16,53@2597L34,55@2666L141,55@2637L170,62@2842L179,62@2813L208,73@3054L350,83@3411L394,72@3027L778:PayWithAirtimeScreen.kt#6tb7vd");
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
                if ((i2 & 4) != 0) {
                    i6 = 128;
                } else {
                    if ((i & 512) == 0) {
                        zChangedInstance2 = composerStartRestartGroup.changed(subscriptionPaymentViewModel);
                    } else {
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(subscriptionPaymentViewModel);
                    }
                    if (zChangedInstance2) {
                        i6 = 256;
                    } else {
                        i6 = 128;
                    }
                }
                i3 |= i6;
            }
            i4 = i3;
            if ((i4 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "46@2226L15");
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
                        ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(SubscriptionPaymentViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i4 &= -897;
                        subscriptionPaymentViewModel3 = (SubscriptionPaymentViewModel) viewModel;
                        i5 = 1;
                        obj = null;
                    } else {
                        obj = null;
                        i5 = 1;
                        subscriptionPaymentViewModel3 = subscriptionPaymentViewModel;
                    }
                    navHostController5 = navHostController4;
                    r5 = obj;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i4 &= -897;
                    }
                    subscriptionPaymentViewModel3 = subscriptionPaymentViewModel;
                    companion = modifier2;
                    navHostController5 = navHostController2;
                    r5 = 0;
                    i5 = 1;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1064051910, i4, -1, "com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreen (PayWithAirtimeScreen.kt:47)");
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
                final State stateCollectAsState4 = SnapshotStateKt.collectAsState(subscriptionPaymentViewModel3.getFeaturePass(), r5, composerStartRestartGroup, 0, i5);
                stateCollectAsState = SnapshotStateKt.collectAsState(subscriptionPaymentViewModel3.getErrorMessage(), r5, composerStartRestartGroup, 0, i5);
                stateCollectAsState2 = SnapshotStateKt.collectAsState(subscriptionPaymentViewModel3.getSubscriptionMessage(), r5, composerStartRestartGroup, 0, i5);
                stateCollectAsState3 = SnapshotStateKt.collectAsState(subscriptionPaymentViewModel3.getLoadingState(), r5, composerStartRestartGroup, 0, i5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -351650596, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, r5, 2, r5);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String strPayWithAirtimeScreen$lambda$1 = PayWithAirtimeScreen$lambda$1(stateCollectAsState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -351648281, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
                zChanged = ((((i4 & 896) ^ 384) <= 256 && composerStartRestartGroup.changedInstance(subscriptionPaymentViewModel3)) || (i4 & 384) == 256) | composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(coroutineScope);
                payWithAirtimeScreenKt$PayWithAirtimeScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || payWithAirtimeScreenKt$PayWithAirtimeScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    payWithAirtimeScreenKt$PayWithAirtimeScreen$1$1RememberedValue = new PayWithAirtimeScreenKt$PayWithAirtimeScreen$1$1(stateCollectAsState, coroutineScope, subscriptionPaymentViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(payWithAirtimeScreenKt$PayWithAirtimeScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strPayWithAirtimeScreen$lambda$1, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) payWithAirtimeScreenKt$PayWithAirtimeScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                LoadingState loadingStatePayWithAirtimeScreen$lambda$3 = PayWithAirtimeScreen$lambda$3(stateCollectAsState3);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -351642611, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(stateCollectAsState3);
                payWithAirtimeScreenKt$PayWithAirtimeScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged2 || payWithAirtimeScreenKt$PayWithAirtimeScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    payWithAirtimeScreenKt$PayWithAirtimeScreen$2$1RememberedValue = new PayWithAirtimeScreenKt$PayWithAirtimeScreen$2$1(stateCollectAsState3, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(payWithAirtimeScreenKt$PayWithAirtimeScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(loadingStatePayWithAirtimeScreen$lambda$3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) payWithAirtimeScreenKt$PayWithAirtimeScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                SubscriptionPaymentViewModel subscriptionPaymentViewModel4 = subscriptionPaymentViewModel3;
                ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(932492022, true, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$12(navHostController5, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-140725109, true, new Function3() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$16(companion, subscriptionPaymentViewModel3, stateCollectAsState4, stateCollectAsState3, (PaddingValues) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
                composerStartRestartGroup = composerStartRestartGroup;
                if (PayWithAirtimeScreen$lambda$5(mutableState)) {
                    composerStartRestartGroup.startReplaceGroup(1981155144);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1984979893);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "100@3945L2,101@3977L137,98@3856L259");
                    String strPayWithAirtimeScreen$lambda$2 = PayWithAirtimeScreen$lambda$2(stateCollectAsState2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -351607492, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function0 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -351606333, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(navHostController5);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$20$lambda$19(navHostController5, mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PaymentSuccessDialogKt.PaymentSuccessDialog(strPayWithAirtimeScreen$lambda$2, function0, (Function0) objRememberedValue4, composerStartRestartGroup, 48);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                subscriptionPaymentViewModel2 = subscriptionPaymentViewModel4;
                modifier3 = companion;
                navHostController3 = navHostController5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                subscriptionPaymentViewModel2 = subscriptionPaymentViewModel;
                modifier3 = modifier2;
                navHostController3 = navHostController2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$21(modifier3, navHostController3, subscriptionPaymentViewModel2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        navHostController2 = navHostController;
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i6 = 128;
            } else {
                if ((i & 512) == 0) {
                    zChangedInstance2 = composerStartRestartGroup.changed(subscriptionPaymentViewModel);
                } else {
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(subscriptionPaymentViewModel);
                }
                if (zChangedInstance2) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
            }
            i3 |= i6;
        }
        i4 = i3;
        if ((i4 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "46@2226L15");
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
                    ViewModel viewModel2 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(SubscriptionPaymentViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory2, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i4 &= -897;
                    subscriptionPaymentViewModel3 = (SubscriptionPaymentViewModel) viewModel2;
                    i5 = 1;
                    obj = null;
                } else {
                    obj = null;
                    i5 = 1;
                    subscriptionPaymentViewModel3 = subscriptionPaymentViewModel;
                }
                navHostController5 = navHostController4;
                r5 = obj;
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
                    ViewModel viewModel3 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(SubscriptionPaymentViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory3, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i4 &= -897;
                    subscriptionPaymentViewModel3 = (SubscriptionPaymentViewModel) viewModel3;
                    i5 = 1;
                    obj = null;
                } else {
                    obj = null;
                    i5 = 1;
                    subscriptionPaymentViewModel3 = subscriptionPaymentViewModel;
                }
                navHostController5 = navHostController4;
                r5 = obj;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1064051910, i4, -1, "com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreen (PayWithAirtimeScreen.kt:47)");
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
            final State stateCollectAsState5 = SnapshotStateKt.collectAsState(subscriptionPaymentViewModel3.getFeaturePass(), r5, composerStartRestartGroup, 0, i5);
            stateCollectAsState = SnapshotStateKt.collectAsState(subscriptionPaymentViewModel3.getErrorMessage(), r5, composerStartRestartGroup, 0, i5);
            stateCollectAsState2 = SnapshotStateKt.collectAsState(subscriptionPaymentViewModel3.getSubscriptionMessage(), r5, composerStartRestartGroup, 0, i5);
            stateCollectAsState3 = SnapshotStateKt.collectAsState(subscriptionPaymentViewModel3.getLoadingState(), r5, composerStartRestartGroup, 0, i5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -351650596, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, r5, 2, r5);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String strPayWithAirtimeScreen$lambda$3 = PayWithAirtimeScreen$lambda$1(stateCollectAsState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -351648281, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
            zChanged = ((((i4 & 896) ^ 384) <= 256 && composerStartRestartGroup.changedInstance(subscriptionPaymentViewModel3)) || (i4 & 384) == 256) | composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(coroutineScope);
            payWithAirtimeScreenKt$PayWithAirtimeScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                payWithAirtimeScreenKt$PayWithAirtimeScreen$1$1RememberedValue = new PayWithAirtimeScreenKt$PayWithAirtimeScreen$1$1(stateCollectAsState, coroutineScope, subscriptionPaymentViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(payWithAirtimeScreenKt$PayWithAirtimeScreen$1$1RememberedValue);
            } else {
                payWithAirtimeScreenKt$PayWithAirtimeScreen$1$1RememberedValue = new PayWithAirtimeScreenKt$PayWithAirtimeScreen$1$1(stateCollectAsState, coroutineScope, subscriptionPaymentViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(payWithAirtimeScreenKt$PayWithAirtimeScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strPayWithAirtimeScreen$lambda$3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) payWithAirtimeScreenKt$PayWithAirtimeScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            LoadingState loadingStatePayWithAirtimeScreen$lambda$4 = PayWithAirtimeScreen$lambda$3(stateCollectAsState3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -351642611, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(stateCollectAsState3);
            payWithAirtimeScreenKt$PayWithAirtimeScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                payWithAirtimeScreenKt$PayWithAirtimeScreen$2$1RememberedValue = new PayWithAirtimeScreenKt$PayWithAirtimeScreen$2$1(stateCollectAsState3, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(payWithAirtimeScreenKt$PayWithAirtimeScreen$2$1RememberedValue);
            } else {
                payWithAirtimeScreenKt$PayWithAirtimeScreen$2$1RememberedValue = new PayWithAirtimeScreenKt$PayWithAirtimeScreen$2$1(stateCollectAsState3, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(payWithAirtimeScreenKt$PayWithAirtimeScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(loadingStatePayWithAirtimeScreen$lambda$4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) payWithAirtimeScreenKt$PayWithAirtimeScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            SubscriptionPaymentViewModel subscriptionPaymentViewModel5 = subscriptionPaymentViewModel3;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(932492022, true, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$12(navHostController5, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-140725109, true, new Function3() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$16(companion, subscriptionPaymentViewModel3, stateCollectAsState5, stateCollectAsState3, (PaddingValues) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            composerStartRestartGroup = composerStartRestartGroup;
            if (PayWithAirtimeScreen$lambda$5(mutableState)) {
                composerStartRestartGroup.startReplaceGroup(1981155144);
            } else {
                composerStartRestartGroup.startReplaceGroup(1984979893);
                ComposerKt.sourceInformation(composerStartRestartGroup, "100@3945L2,101@3977L137,98@3856L259");
                String strPayWithAirtimeScreen$lambda$4 = PayWithAirtimeScreen$lambda$2(stateCollectAsState2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -351607492, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function1 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -351606333, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(navHostController5);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$20$lambda$19(navHostController5, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$20$lambda$19(navHostController5, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PaymentSuccessDialogKt.PaymentSuccessDialog(strPayWithAirtimeScreen$lambda$4, function1, (Function0) objRememberedValue4, composerStartRestartGroup, 48);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            subscriptionPaymentViewModel2 = subscriptionPaymentViewModel5;
            modifier3 = companion;
            navHostController3 = navHostController5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            subscriptionPaymentViewModel2 = subscriptionPaymentViewModel;
            modifier3 = modifier2;
            navHostController3 = navHostController2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$21(modifier3, navHostController3, subscriptionPaymentViewModel2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final boolean PayWithAirtimeScreen$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PayWithAirtimeScreen$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PayWithAirtimeScreen$lambda$12(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C76@3166L214,74@3068L326:PayWithAirtimeScreen.kt#6tb7vd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(932492022, i, -1, "com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreen.<anonymous> (PayWithAirtimeScreen.kt:74)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$PayWithAirtimeScreenKt.INSTANCE.m9644getLambda$1134516038$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(1971658684, true, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$12$lambda$11(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PayWithAirtimeScreen$lambda$12$lambda$11(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C77@3209L33,77@3188L174:PayWithAirtimeScreen.kt#6tb7vd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1971658684, i, -1, "com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreen.<anonymous>.<anonymous> (PayWithAirtimeScreen.kt:77)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 683419197, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$12$lambda$11$lambda$10$lambda$9(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$PayWithAirtimeScreenKt.INSTANCE.getLambda$237431130$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PayWithAirtimeScreen$lambda$12$lambda$11$lambda$10$lambda$9(NavHostController navHostController) {
        if (navHostController != null) {
            navHostController.popBackStack();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PayWithAirtimeScreen$lambda$16(Modifier modifier, final SubscriptionPaymentViewModel subscriptionPaymentViewModel, State state, State state2, PaddingValues paddingValues, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)84@3438L361:PayWithAirtimeScreen.kt#6tb7vd");
        if ((i & 6) == 0) {
            i |= composer.changed(paddingValues) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-140725109, i, -1, "com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreen.<anonymous> (PayWithAirtimeScreen.kt:84)");
            }
            Modifier modifierM1119paddingVpY3zN4 = PaddingKt.m1119paddingVpY3zN4(PaddingKt.padding(modifier, paddingValues), Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8));
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
            ComposerKt.sourceInformationMarkerStart(composer, -386615031, "C91@3700L30,89@3604L185:PayWithAirtimeScreen.kt#6tb7vd");
            FeaturePass featurePassPayWithAirtimeScreen$lambda$0 = PayWithAirtimeScreen$lambda$0(state);
            ComposerKt.sourceInformationMarkerStart(composer, -1397941857, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(subscriptionPaymentViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$16$lambda$15$lambda$14$lambda$13(subscriptionPaymentViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PayWithAirtimeScreenContent(featurePassPayWithAirtimeScreen$lambda$0, (Function0) objRememberedValue, PayWithAirtimeScreen$lambda$3(state2), composer, 0, 0);
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
    public static final Unit PayWithAirtimeScreen$lambda$16$lambda$15$lambda$14$lambda$13(SubscriptionPaymentViewModel subscriptionPaymentViewModel) {
        subscriptionPaymentViewModel.payWithAirtime();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PayWithAirtimeScreen$lambda$20$lambda$19(NavHostController navHostController, MutableState mutableState) {
        PayWithAirtimeScreen$lambda$6(mutableState, false);
        if (navHostController != null) {
            NavController.popBackStack$default((NavController) navHostController, Route.Home.INSTANCE.getName(), false, false, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0068 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x006a  */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:51:0x0109  */
    /* JADX WARN: Code duplicated, block: B:54:0x0137  */
    /* JADX WARN: Code duplicated, block: B:55:0x0140  */
    /* JADX WARN: Code duplicated, block: B:58:0x0162  */
    /* JADX WARN: Code duplicated, block: B:61:0x024d  */
    /* JADX WARN: Code duplicated, block: B:62:0x024f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0297  */
    /* JADX WARN: Code duplicated, block: B:67:0x029d  */
    /* JADX WARN: Code duplicated, block: B:70:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    public static final void PayWithAirtimeScreenContent(final FeaturePass featurePass, final Function0<Unit> onPay, LoadingState loadingState, Composer composer, final int i, final int i2) {
        int i3;
        LoadingState loadingState2;
        boolean z;
        Composer composer2;
        final LoadingState loadingState3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        LoadingState.Idle idle;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Integer numValueOf;
        Object objRememberedValue;
        final LoadingState loadingState4;
        boolean z2;
        Intrinsics.checkNotNullParameter(onPay, "onPay");
        Composer composerStartRestartGroup = composer.startRestartGroup(1106941898);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PayWithAirtimeScreenContent)N(featurePass,onPay,loadingState)115@4285L981:PayWithAirtimeScreen.kt#6tb7vd");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(featurePass) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onPay) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                loadingState2 = loadingState;
                i3 |= composerStartRestartGroup.changed(loadingState2) ? 256 : 128;
            }
            if ((i3 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                loadingState3 = loadingState2;
            } else {
                if (i4 != 0) {
                    idle = LoadingState.Idle.INSTANCE;
                } else {
                    idle = loadingState2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1106941898, i3, -1, "com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenContent (PayWithAirtimeScreen.kt:113)");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -620372047, "C119@4429L3,116@4302L228,123@4539L41,124@4589L87,125@4685L41,130@4896L364,126@4735L525:PayWithAirtimeScreen.kt#6tb7vd");
                if (featurePass != null) {
                    numValueOf = Integer.valueOf(featurePass.getPrice());
                } else {
                    numValueOf = null;
                }
                String strValueOf = String.valueOf(numValueOf);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -435650889, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PayWithAirtimeScreenKt.PayWithAirtimeScreenContent$lambda$25$lambda$23$lambda$22((String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i5 = i3;
                loadingState4 = idle;
                OutlinedTextFieldKt.OutlinedTextField(strValueOf, (Function1<? super String, Unit>) objRememberedValue, modifierFillMaxWidth$default, false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PayWithAirtimeScreenKt.INSTANCE.getLambda$144016186$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, 1597872, 0, 0, 8388520);
                float f = 24;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                TextKt.m3864TextNvy7gAk("NOTE: Your default Bingwa USSD Sim will be used to complete this request", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                if (loadingState4 != LoadingState.Loading.INSTANCE) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                CustomButtonKt.CustomButton(onPay, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z2, false, ComposableLambdaKt.rememberComposableLambda(-722484608, true, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PayWithAirtimeScreenKt.PayWithAirtimeScreenContent$lambda$25$lambda$24(loadingState4, featurePass, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i5 >> 3) & 14) | 24624, 8);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                loadingState3 = loadingState4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PayWithAirtimeScreenKt.PayWithAirtimeScreenContent$lambda$26(featurePass, onPay, loadingState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        loadingState2 = loadingState;
        if ((i3 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            loadingState3 = loadingState2;
        } else {
            if (i4 != 0) {
                idle = LoadingState.Idle.INSTANCE;
            } else {
                idle = loadingState2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1106941898, i3, -1, "com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenContent (PayWithAirtimeScreen.kt:113)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl.getInserting()) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            } else {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -620372047, "C119@4429L3,116@4302L228,123@4539L41,124@4589L87,125@4685L41,130@4896L364,126@4735L525:PayWithAirtimeScreen.kt#6tb7vd");
            if (featurePass != null) {
                numValueOf = Integer.valueOf(featurePass.getPrice());
            } else {
                numValueOf = null;
            }
            String strValueOf2 = String.valueOf(numValueOf);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -435650889, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PayWithAirtimeScreenKt.PayWithAirtimeScreenContent$lambda$25$lambda$23$lambda$22((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i6 = i3;
            loadingState4 = idle;
            OutlinedTextFieldKt.OutlinedTextField(strValueOf2, (Function1<? super String, Unit>) objRememberedValue, modifierFillMaxWidth$default2, false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PayWithAirtimeScreenKt.INSTANCE.getLambda$144016186$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, 1597872, 0, 0, 8388520);
            float f2 = 24;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
            TextKt.m3864TextNvy7gAk("NOTE: Your default Bingwa USSD Sim will be used to complete this request", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
            if (loadingState4 != LoadingState.Loading.INSTANCE) {
                z2 = true;
            } else {
                z2 = false;
            }
            CustomButtonKt.CustomButton(onPay, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z2, false, ComposableLambdaKt.rememberComposableLambda(-722484608, true, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PayWithAirtimeScreenKt.PayWithAirtimeScreenContent$lambda$25$lambda$24(loadingState4, featurePass, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 >> 3) & 14) | 24624, 8);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            loadingState3 = loadingState4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PayWithAirtimeScreenKt.PayWithAirtimeScreenContent$lambda$26(featurePass, onPay, loadingState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PayWithAirtimeScreenContent$lambda$25$lambda$23$lambda$22(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PayWithAirtimeScreenContent$lambda$25$lambda$24(LoadingState loadingState, FeaturePass featurePass, Composer composer, int i) {
        String str;
        ComposerKt.sourceInformation(composer, "C136@5142L10,131@4910L340:PayWithAirtimeScreen.kt#6tb7vd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-722484608, i, -1, "com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenContent.<anonymous>.<anonymous> (PayWithAirtimeScreen.kt:131)");
            }
            if (loadingState instanceof LoadingState.Loading) {
                str = "Paying...";
            } else {
                str = "Pay KES " + (featurePass != null ? featurePass.getPrice() : 0);
            }
            TextKt.m3864TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void PayWithAirtimeScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1189108979);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PayWithAirtimeScreenPreview)159@5754L2,157@5674L130:PayWithAirtimeScreen.kt#6tb7vd");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1189108979, i, -1, "com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenPreview (PayWithAirtimeScreen.kt:146)");
            }
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            FeaturePass featurePass = new FeaturePass(string, "Daily Plan", "Enjoy exclusive features and benefits.", 60000.0d, 1000, SubscriptionType.UNLIMITED, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -272412593, "CC(remember):PayWithAirtimeScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            PayWithAirtimeScreenContent(featurePass, (Function0) objRememberedValue, LoadingState.Idle.INSTANCE, composerStartRestartGroup, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PayWithAirtimeScreenKt.PayWithAirtimeScreenPreview$lambda$29(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final FeaturePass PayWithAirtimeScreen$lambda$0(State<FeaturePass> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PayWithAirtimeScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    private static final String PayWithAirtimeScreen$lambda$2(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoadingState PayWithAirtimeScreen$lambda$3(State<? extends LoadingState> state) {
        return state.getValue();
    }
}
