package com.example.bingwahybrid.presentation.community.screens;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.InboxKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TabKt;
import androidx.compose.material3.TabRowKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
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
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.example.bingwahybrid.domain.enums.LoadingState;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.model.OfferVerificationInfo;
import com.example.bingwahybrid.presentation.community.components.CommunityOfferItemKt;
import com.example.bingwahybrid.presentation.community.components.OverwriteOfferDialogKt;
import com.example.bingwahybrid.presentation.community.viewmodel.CommunityOffersViewModel;
import com.example.bingwahybrid.presentation.community.viewmodel.HakikishaOfferWithStatus;
import com.example.bingwahybrid.presentation.navigation.Route;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CommunityOffersScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a_\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0017\u001a\r\u0010\u0018\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001a²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u0084\u0002²\u0006\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u008a\u0084\u0002²\u0006\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u008a\u0084\u0002²\u0006\f\u0010\u001c\u001a\u0004\u0018\u00010\u0016X\u008a\u0084\u0002²\u0006\u0018\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001eX\u008a\u0084\u0002²\u0006\n\u0010\u001f\u001a\u00020 X\u008a\u008e\u0002"}, d2 = {"CommunityOffersScreen", "", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/community/viewmodel/CommunityOffersViewModel;", "(Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/community/viewmodel/CommunityOffersViewModel;Landroidx/compose/runtime/Composer;II)V", "HakikishaOffersContent", "loadingState", "Lcom/example/bingwahybrid/domain/enums/LoadingState;", "offers", "", "Lcom/example/bingwahybrid/presentation/community/viewmodel/HakikishaOfferWithStatus;", "downloadingOfferIds", "", "Ljava/util/UUID;", "onDownloadClick", "Lkotlin/Function2;", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "Lcom/example/bingwahybrid/domain/offers/model/OfferVerificationInfo;", "onOfferClick", "Lkotlin/Function1;", "", "(Lcom/example/bingwahybrid/domain/enums/LoadingState;Ljava/util/List;Ljava/util/Set;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "CommunityOffersContent", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "hakikishaOffers", "snackBarMessage", "overwriteDialogData", "Lkotlin/Pair;", "selectedTabIndex", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CommunityOffersScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommunityOffersContent$lambda$41(int i, Composer composer, int i2) {
        CommunityOffersContent(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommunityOffersScreen$lambda$28(NavHostController navHostController, CommunityOffersViewModel communityOffersViewModel, int i, int i2, Composer composer, int i3) {
        CommunityOffersScreen(navHostController, communityOffersViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HakikishaOffersContent$lambda$38(LoadingState loadingState, List list, Set set, Function2 function2, Function1 function1, int i, Composer composer, int i2) {
        HakikishaOffersContent(loadingState, list, set, function2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x027e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0046  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:53:0x010f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0161  */
    /* JADX WARN: Code duplicated, block: B:69:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:72:0x0212  */
    /* JADX WARN: Code duplicated, block: B:73:0x0214  */
    /* JADX WARN: Code duplicated, block: B:86:0x0238  */
    /* JADX WARN: Code duplicated, block: B:99:0x0268  */
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
    public static final void CommunityOffersScreen(final NavHostController navController, CommunityOffersViewModel communityOffersViewModel, Composer composer, final int i, final int i2) {
        int i3;
        CreationExtras.Empty defaultViewModelCreationExtras;
        int i4;
        int i5;
        Object objRememberedValue;
        CoroutineScope coroutineScope;
        State stateCollectAsState;
        State stateCollectAsState2;
        Object objRememberedValue2;
        boolean zChanged;
        CommunityOffersScreenKt$CommunityOffersScreen$1$1 communityOffersScreenKt$CommunityOffersScreen$1$1RememberedValue;
        final CommunityOffersViewModel communityOffersViewModel2;
        boolean z;
        boolean z2;
        Object objRememberedValue3;
        boolean z3;
        Object objRememberedValue4;
        int i6;
        final CommunityOffersViewModel communityOffersViewModel3 = communityOffersViewModel;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(613399644);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CommunityOffersScreen)N(navController,viewModel)53@2533L24,54@2605L16,55@2675L16,56@2753L16,57@2823L16,58@2901L16,60@2947L33,62@3018L144,62@2986L176,70@3195L349,80@3551L1420,69@3168L1803,122@5069L32,123@5123L31,120@4977L183:CommunityOffersScreen.kt#ryol0b");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(navController) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) != 0) {
                i6 = 16;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(communityOffersViewModel3) : composerStartRestartGroup.changedInstance(communityOffersViewModel3)) {
                    i6 = 32;
                } else {
                    i6 = 16;
                }
            }
            i3 |= i6;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "51@2496L15");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 2) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1890788296, "CC(hiltViewModel)P(1)51@2126L7,55@2260L46:HiltViewModel.kt#9mcars");
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
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
                    i4 = 1;
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(CommunityOffersViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, creationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    communityOffersViewModel3 = (CommunityOffersViewModel) viewModel;
                    i3 &= -113;
                }
                i5 = i3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(613399644, i5, -1, "com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreen (CommunityOffersScreen.kt:52)");
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
                final State stateCollectAsState3 = SnapshotStateKt.collectAsState(communityOffersViewModel3.getLoadingState(), null, composerStartRestartGroup, r10, i4);
                final State stateCollectAsState4 = SnapshotStateKt.collectAsState(communityOffersViewModel3.getHakikishaOffers(), null, composerStartRestartGroup, r10, i4);
                final State stateCollectAsState5 = SnapshotStateKt.collectAsState(communityOffersViewModel3.getDownloadingOfferIds(), null, composerStartRestartGroup, r10, i4);
                stateCollectAsState = SnapshotStateKt.collectAsState(communityOffersViewModel3.getSnackBarMessage(), null, composerStartRestartGroup, r10, i4);
                stateCollectAsState2 = SnapshotStateKt.collectAsState(communityOffersViewModel3.getShowOverwriteDialog(), null, composerStartRestartGroup, r10, i4);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1066557885, "CC(remember):CommunityOffersScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableIntState mutableIntState = (MutableIntState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String strCommunityOffersScreen$lambda$3 = CommunityOffersScreen$lambda$3(stateCollectAsState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1066560268, "CC(remember):CommunityOffersScreen.kt#9igjgp");
                int i7 = (i5 & 112) ^ 48;
                zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(coroutineScope) | ((i7 <= 32 && composerStartRestartGroup.changedInstance(communityOffersViewModel3)) || (i5 & 48) == 32);
                communityOffersScreenKt$CommunityOffersScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || communityOffersScreenKt$CommunityOffersScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    communityOffersScreenKt$CommunityOffersScreen$1$1RememberedValue = new CommunityOffersScreenKt$CommunityOffersScreen$1$1(stateCollectAsState, coroutineScope, communityOffersViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(communityOffersScreenKt$CommunityOffersScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strCommunityOffersScreen$lambda$3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) communityOffersScreenKt$CommunityOffersScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                communityOffersViewModel2 = communityOffersViewModel3;
                ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-1239949280, true, new Function2() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CommunityOffersScreenKt.CommunityOffersScreen$lambda$12(navController, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1672786901, true, new Function3() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CommunityOffersScreenKt.CommunityOffersScreen$lambda$23(communityOffersViewModel2, navController, mutableIntState, stateCollectAsState3, stateCollectAsState4, stateCollectAsState5, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
                composerStartRestartGroup = composerStartRestartGroup;
                if (CommunityOffersScreen$lambda$4(stateCollectAsState2) != null) {
                    z = true;
                } else {
                    z = false;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1066625788, "CC(remember):CommunityOffersScreen.kt#9igjgp");
                z2 = (i7 <= 32 && composerStartRestartGroup.changedInstance(communityOffersViewModel2)) || (i5 & 48) == 32;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommunityOffersScreenKt.CommunityOffersScreen$lambda$25$lambda$24(communityOffersViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function0 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1066627515, "CC(remember):CommunityOffersScreen.kt#9igjgp");
                z3 = (i7 <= 32 && composerStartRestartGroup.changedInstance(communityOffersViewModel2)) || (i5 & 48) == 32;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommunityOffersScreenKt.CommunityOffersScreen$lambda$27$lambda$26(communityOffersViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                OverwriteOfferDialogKt.OverwriteOfferDialog(z, function0, (Function0) objRememberedValue4, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                communityOffersViewModel3 = communityOffersViewModel2;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
            }
            i4 = 1;
            i5 = i3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(613399644, i5, -1, "com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreen (CommunityOffersScreen.kt:52)");
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
            final State stateCollectAsState6 = SnapshotStateKt.collectAsState(communityOffersViewModel3.getLoadingState(), null, composerStartRestartGroup, r10, i4);
            final State stateCollectAsState7 = SnapshotStateKt.collectAsState(communityOffersViewModel3.getHakikishaOffers(), null, composerStartRestartGroup, r10, i4);
            final State stateCollectAsState8 = SnapshotStateKt.collectAsState(communityOffersViewModel3.getDownloadingOfferIds(), null, composerStartRestartGroup, r10, i4);
            stateCollectAsState = SnapshotStateKt.collectAsState(communityOffersViewModel3.getSnackBarMessage(), null, composerStartRestartGroup, r10, i4);
            stateCollectAsState2 = SnapshotStateKt.collectAsState(communityOffersViewModel3.getShowOverwriteDialog(), null, composerStartRestartGroup, r10, i4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1066557885, "CC(remember):CommunityOffersScreen.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String strCommunityOffersScreen$lambda$4 = CommunityOffersScreen$lambda$3(stateCollectAsState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1066560268, "CC(remember):CommunityOffersScreen.kt#9igjgp");
            int i8 = (i5 & 112) ^ 48;
            zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(coroutineScope) | ((i8 <= 32 && composerStartRestartGroup.changedInstance(communityOffersViewModel3)) || (i5 & 48) == 32);
            communityOffersScreenKt$CommunityOffersScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                communityOffersScreenKt$CommunityOffersScreen$1$1RememberedValue = new CommunityOffersScreenKt$CommunityOffersScreen$1$1(stateCollectAsState, coroutineScope, communityOffersViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(communityOffersScreenKt$CommunityOffersScreen$1$1RememberedValue);
            } else {
                communityOffersScreenKt$CommunityOffersScreen$1$1RememberedValue = new CommunityOffersScreenKt$CommunityOffersScreen$1$1(stateCollectAsState, coroutineScope, communityOffersViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(communityOffersScreenKt$CommunityOffersScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strCommunityOffersScreen$lambda$4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) communityOffersScreenKt$CommunityOffersScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            communityOffersViewModel2 = communityOffersViewModel3;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-1239949280, true, new Function2() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommunityOffersScreenKt.CommunityOffersScreen$lambda$12(navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1672786901, true, new Function3() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CommunityOffersScreenKt.CommunityOffersScreen$lambda$23(communityOffersViewModel2, navController, mutableIntState2, stateCollectAsState6, stateCollectAsState7, stateCollectAsState8, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            composerStartRestartGroup = composerStartRestartGroup;
            if (CommunityOffersScreen$lambda$4(stateCollectAsState2) != null) {
                z = true;
            } else {
                z = false;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1066625788, "CC(remember):CommunityOffersScreen.kt#9igjgp");
            if (i8 <= 32) {
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CommunityOffersScreenKt.CommunityOffersScreen$lambda$25$lambda$24(communityOffersViewModel2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CommunityOffersScreenKt.CommunityOffersScreen$lambda$25$lambda$24(communityOffersViewModel2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function0 function1 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1066627515, "CC(remember):CommunityOffersScreen.kt#9igjgp");
            if (i8 <= 32) {
            }
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CommunityOffersScreenKt.CommunityOffersScreen$lambda$27$lambda$26(communityOffersViewModel2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CommunityOffersScreenKt.CommunityOffersScreen$lambda$27$lambda$26(communityOffersViewModel2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OverwriteOfferDialogKt.OverwriteOfferDialog(z, function1, (Function0) objRememberedValue4, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            communityOffersViewModel3 = communityOffersViewModel2;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommunityOffersScreenKt.CommunityOffersScreen$lambda$28(navController, communityOffersViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int CommunityOffersScreen$lambda$6(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommunityOffersScreen$lambda$12(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C73@3307L213,71@3209L325:CommunityOffersScreen.kt#ryol0b");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1239949280, i, -1, "com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreen.<anonymous> (CommunityOffersScreen.kt:71)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$CommunityOffersScreenKt.INSTANCE.getLambda$1420238556$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(-285891046, true, new Function2() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommunityOffersScreenKt.CommunityOffersScreen$lambda$12$lambda$11(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommunityOffersScreen$lambda$12$lambda$11(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C74@3350L32,74@3329L173:CommunityOffersScreen.kt#ryol0b");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-285891046, i, -1, "com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreen.<anonymous>.<anonymous> (CommunityOffersScreen.kt:74)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 136613146, "CC(remember):CommunityOffersScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CommunityOffersScreenKt.CommunityOffersScreen$lambda$12$lambda$11$lambda$10$lambda$9(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$CommunityOffersScreenKt.INSTANCE.getLambda$1793217084$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommunityOffersScreen$lambda$12$lambda$11$lambda$10$lambda$9(NavHostController navHostController) {
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommunityOffersScreen$lambda$23(final CommunityOffersViewModel communityOffersViewModel, final NavHostController navHostController, final MutableIntState mutableIntState, State state, State state2, State state3, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)81@3578L1387:CommunityOffersScreen.kt#ryol0b");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1672786901, i2, -1, "com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreen.<anonymous> (CommunityOffersScreen.kt:81)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1444416276, "C86@3757L425,86@3713L469:CommunityOffersScreen.kt#ryol0b");
            TabRowKt.m3760TabRowpAZo6Ak(CommunityOffersScreen$lambda$6(mutableIntState), null, 0L, 0L, null, null, ComposableLambdaKt.rememberComposableLambda(-1227589923, true, new Function2() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommunityOffersScreenKt.CommunityOffersScreen$lambda$23$lambda$22$lambda$17(mutableIntState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 62);
            int iCommunityOffersScreen$lambda$6 = CommunityOffersScreen$lambda$6(mutableIntState);
            if (iCommunityOffersScreen$lambda$6 == 0) {
                composer.startReplaceGroup(1444926349);
                ComposerKt.sourceInformation(composer, "105@4505L131,108@4677L138,101@4269L568");
                LoadingState loadingStateCommunityOffersScreen$lambda$0 = CommunityOffersScreen$lambda$0(state);
                List<HakikishaOfferWithStatus> listCommunityOffersScreen$lambda$1 = CommunityOffersScreen$lambda$1(state2);
                Set<UUID> setCommunityOffersScreen$lambda$2 = CommunityOffersScreen$lambda$2(state3);
                ComposerKt.sourceInformationMarkerStart(composer, 1847733624, "CC(remember):CommunityOffersScreen.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(communityOffersViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function2() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CommunityOffersScreenKt.CommunityOffersScreen$lambda$23$lambda$22$lambda$19$lambda$18(communityOffersViewModel, (Offer) obj, (OfferVerificationInfo) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function2 function2 = (Function2) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1847739135, "CC(remember):CommunityOffersScreen.kt#9igjgp");
                boolean zChangedInstance2 = composer.changedInstance(navHostController);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CommunityOffersScreenKt.CommunityOffersScreen$lambda$23$lambda$22$lambda$21$lambda$20(navHostController, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                HakikishaOffersContent(loadingStateCommunityOffersScreen$lambda$0, listCommunityOffersScreen$lambda$1, setCommunityOffersScreen$lambda$2, function2, (Function1) objRememberedValue2, composer, 0);
                composer.endReplaceGroup();
            } else {
                if (iCommunityOffersScreen$lambda$6 != 1) {
                    composer.startReplaceGroup(1440693485);
                } else {
                    composer.startReplaceGroup(1445534445);
                    ComposerKt.sourceInformation(composer, "114@4899L24");
                    CommunityOffersContent(composer, 0);
                }
                composer.endReplaceGroup();
            }
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
    public static final Unit CommunityOffersScreen$lambda$23$lambda$22$lambda$17(final MutableIntState mutableIntState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C89@3864L24,87@3775L188,94@4069L24,92@3980L188:CommunityOffersScreen.kt#ryol0b");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1227589923, i, -1, "com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreen.<anonymous>.<anonymous>.<anonymous> (CommunityOffersScreen.kt:87)");
            }
            boolean z = CommunityOffersScreen$lambda$6(mutableIntState) == 0;
            ComposerKt.sourceInformationMarkerStart(composer, 1402093845, "CC(remember):CommunityOffersScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CommunityOffersScreenKt.CommunityOffersScreen$lambda$23$lambda$22$lambda$17$lambda$14$lambda$13(mutableIntState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean z2 = true;
            TabKt.m3733TabwqdebIU(z, (Function0) objRememberedValue, null, false, ComposableSingletons$CommunityOffersScreenKt.INSTANCE.getLambda$726104375$app_debug(), null, 0L, 0L, null, composer, 24624, 492);
            if (CommunityOffersScreen$lambda$6(mutableIntState) != 1) {
                z2 = false;
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1402100405, "CC(remember):CommunityOffersScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CommunityOffersScreenKt.CommunityOffersScreen$lambda$23$lambda$22$lambda$17$lambda$16$lambda$15(mutableIntState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TabKt.m3733TabwqdebIU(z2, (Function0) objRememberedValue2, null, false, ComposableSingletons$CommunityOffersScreenKt.INSTANCE.getLambda$1009193312$app_debug(), null, 0L, 0L, null, composer, 24624, 492);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommunityOffersScreen$lambda$23$lambda$22$lambda$17$lambda$14$lambda$13(MutableIntState mutableIntState) {
        mutableIntState.setIntValue(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommunityOffersScreen$lambda$23$lambda$22$lambda$17$lambda$16$lambda$15(MutableIntState mutableIntState) {
        mutableIntState.setIntValue(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommunityOffersScreen$lambda$23$lambda$22$lambda$19$lambda$18(CommunityOffersViewModel communityOffersViewModel, Offer offer, OfferVerificationInfo verificationInfo) {
        Intrinsics.checkNotNullParameter(offer, "offer");
        Intrinsics.checkNotNullParameter(verificationInfo, "verificationInfo");
        communityOffersViewModel.downloadOffer(offer, verificationInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommunityOffersScreen$lambda$23$lambda$22$lambda$21$lambda$20(NavHostController navHostController, String featureCode) {
        Intrinsics.checkNotNullParameter(featureCode, "featureCode");
        NavController.navigate$default((NavController) navHostController, Route.MySubscription.INSTANCE.getName() + "/" + featureCode, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommunityOffersScreen$lambda$25$lambda$24(CommunityOffersViewModel communityOffersViewModel) {
        communityOffersViewModel.confirmOverwrite();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommunityOffersScreen$lambda$27$lambda$26(CommunityOffersViewModel communityOffersViewModel) {
        communityOffersViewModel.cancelOverwrite();
        return Unit.INSTANCE;
    }

    public static final void HakikishaOffersContent(final LoadingState loadingState, final List<HakikishaOfferWithStatus> offers, final Set<UUID> downloadingOfferIds, final Function2<? super Offer, ? super OfferVerificationInfo, Unit> onDownloadClick, final Function1<? super String, Unit> onOfferClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        Intrinsics.checkNotNullParameter(offers, "offers");
        Intrinsics.checkNotNullParameter(downloadingOfferIds, "downloadingOfferIds");
        Intrinsics.checkNotNullParameter(onDownloadClick, "onDownloadClick");
        Intrinsics.checkNotNullParameter(onOfferClick, "onOfferClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1273127240);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HakikishaOffersContent)N(loadingState,offers,downloadingOfferIds,onDownloadClick,onOfferClick):CommunityOffersScreen.kt#ryol0b");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(loadingState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(offers) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(downloadingOfferIds) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDownloadClick) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onOfferClick) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1273127240, i2, -1, "com.example.bingwahybrid.presentation.community.screens.HakikishaOffersContent (CommunityOffersScreen.kt:134)");
            }
            if (Intrinsics.areEqual(loadingState, LoadingState.Loading.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(1122999197);
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@5590L181");
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1784654702, "C141@5730L27:CommunityOffersScreen.kt#ryol0b");
                ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(null, 0L, 0.0f, 0L, 0, 0.0f, composerStartRestartGroup, 0, 63);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else if (offers.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(1123256869);
                ComposerKt.sourceInformation(composerStartRestartGroup, "145@5824L1005");
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment center2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
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
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -343739887, "C149@5964L851:CommunityOffersScreen.kt#ryol0b");
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                float f = 16;
                Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1118padding3ABfNKs);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5259constructorimpl3 = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl3.rememberedValue(), Integer.valueOf(iHashCode3))) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -182778500, "C157@6379L11,153@6139L300,161@6576L10,162@6655L11,159@6460L337:CommunityOffersScreen.kt#ryol0b");
                IconKt.m3158Iconww6aTOc(InboxKt.getInbox(Icons.INSTANCE.getDefault()), "Empty Offers", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f), 7, null), Color.m5939copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), composerStartRestartGroup, 432, 0);
                TextKt.m3864TextNvy7gAk("No Hakikisha offers available", null, 0L, null, 0L, null, null, null, 0L, null, TextAlign.m8533boximpl(TextAlign.INSTANCE.m8540getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), Color.m5939copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composerStartRestartGroup, 6, 0, 130046);
                composerStartRestartGroup = composerStartRestartGroup;
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
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1124308823);
                ComposerKt.sourceInformation(composerStartRestartGroup, "174@7016L1321,170@6870L1467");
                Modifier modifierM1120paddingVpY3zN4$default = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(12), 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 590462305, "CC(remember):CommunityOffersScreen.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(offers) | composerStartRestartGroup.changedInstance(downloadingOfferIds) | ((i2 & 7168) == 2048) | ((i2 & 57344) == 16384);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CommunityOffersScreenKt.HakikishaOffersContent$lambda$37$lambda$36(offers, downloadingOfferIds, onDownloadClick, onOfferClick, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LazyDslKt.LazyColumn(modifierM1120paddingVpY3zN4$default, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 6, 510);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommunityOffersScreenKt.HakikishaOffersContent$lambda$38(loadingState, offers, downloadingOfferIds, onDownloadClick, onOfferClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void CommunityOffersContent(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2015270030);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CommunityOffersContent)207@8404L843:CommunityOffersScreen.kt#ryol0b");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2015270030, i, -1, "com.example.bingwahybrid.presentation.community.screens.CommunityOffersContent (CommunityOffersScreen.kt:206)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1379723714, "C211@8512L729:CommunityOffersScreen.kt#ryol0b");
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            float f = 16;
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1118padding3ABfNKs);
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
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 713592497, "C219@8873L11,215@8655L270,223@9042L10,224@9113L11,221@8938L293:CommunityOffersScreen.kt#ryol0b");
            IconKt.m3158Iconww6aTOc(InboxKt.getInbox(Icons.INSTANCE.getDefault()), "Empty Community Offers", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f), 7, null), Color.m5939copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), composerStartRestartGroup, 432, 0);
            TextKt.m3864TextNvy7gAk("No Community Offers at the moment", null, 0L, null, 0L, null, null, null, 0L, null, TextAlign.m8533boximpl(TextAlign.INSTANCE.m8540getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), Color.m5939copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composerStartRestartGroup, 6, 0, 130046);
            composerStartRestartGroup = composerStartRestartGroup;
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommunityOffersScreenKt.CommunityOffersContent$lambda$41(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final LoadingState CommunityOffersScreen$lambda$0(State<? extends LoadingState> state) {
        return state.getValue();
    }

    private static final List<HakikishaOfferWithStatus> CommunityOffersScreen$lambda$1(State<? extends List<HakikishaOfferWithStatus>> state) {
        return state.getValue();
    }

    private static final Set<UUID> CommunityOffersScreen$lambda$2(State<? extends Set<UUID>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CommunityOffersScreen$lambda$3(State<String> state) {
        return state.getValue();
    }

    private static final Pair<Offer, OfferVerificationInfo> CommunityOffersScreen$lambda$4(State<Pair<Offer, OfferVerificationInfo>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HakikishaOffersContent$lambda$37$lambda$36(final List list, final Set set, final Function2 function2, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final CommunityOffersScreenKt$HakikishaOffersContent$lambda$37$lambda$36$$inlined$items$default$1 communityOffersScreenKt$HakikishaOffersContent$lambda$37$lambda$36$$inlined$items$default$1 = new Function1() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$HakikishaOffersContent$lambda$37$lambda$36$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(HakikishaOfferWithStatus hakikishaOfferWithStatus) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((HakikishaOfferWithStatus) obj);
            }
        };
        LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$HakikishaOffersContent$lambda$37$lambda$36$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return communityOffersScreenKt$HakikishaOffersContent$lambda$37$lambda$36$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$HakikishaOffersContent$lambda$37$lambda$36$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                Function0 function0;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final HakikishaOfferWithStatus hakikishaOfferWithStatus = (HakikishaOfferWithStatus) list.get(i);
                composer.startReplaceGroup(-606475923);
                ComposerKt.sourceInformation(composer, "CN(offerWithStatus)*181@7440L128,176@7089L1052,195@8162L40:CommunityOffersScreen.kt#ryol0b");
                Offer offer = hakikishaOfferWithStatus.getOffer();
                boolean zContains = set.contains(hakikishaOfferWithStatus.getOffer().getId());
                boolean zIsLocked = hakikishaOfferWithStatus.isLocked();
                boolean requiresPurchase = hakikishaOfferWithStatus.getRequiresPurchase();
                ComposerKt.sourceInformationMarkerStart(composer, 1643014493, "CC(remember):CommunityOffersScreen.kt#9igjgp");
                boolean zChanged = composer.changed(function2) | composer.changedInstance(hakikishaOfferWithStatus);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function2 function3 = function2;
                    objRememberedValue = (Function1) new Function1<Offer, Unit>() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$HakikishaOffersContent$3$1$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Offer offer2) {
                            invoke2(offer2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Offer it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function3.invoke(hakikishaOfferWithStatus.getOffer(), hakikishaOfferWithStatus.getVerificationInfo());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function4 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                Function0 function5 = null;
                if (hakikishaOfferWithStatus.getRequiresPurchase()) {
                    composer.startReplaceGroup(-605954442);
                    ComposerKt.sourceInformation(composer, "185@7676L55");
                    ComposerKt.sourceInformationMarkerStart(composer, 1643021972, "CC(remember):CommunityOffersScreen.kt#9igjgp");
                    boolean zChanged2 = composer.changed(function1) | composer.changedInstance(hakikishaOfferWithStatus);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        final Function1 function6 = function1;
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$HakikishaOffersContent$3$1$1$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function6.invoke(hakikishaOfferWithStatus.getVerificationInfo().getCode());
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    function0 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-605839959);
                    composer.endReplaceGroup();
                    function0 = null;
                }
                if (hakikishaOfferWithStatus.getRequiresPurchase() && hakikishaOfferWithStatus.isLocked()) {
                    composer.startReplaceGroup(-605660810);
                    ComposerKt.sourceInformation(composer, "190@7972L55");
                    ComposerKt.sourceInformationMarkerStart(composer, 1643031444, "CC(remember):CommunityOffersScreen.kt#9igjgp");
                    boolean zChanged3 = composer.changed(function1) | composer.changedInstance(hakikishaOfferWithStatus);
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        final Function1 function7 = function1;
                        objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$HakikishaOffersContent$3$1$1$3$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function7.invoke(hakikishaOfferWithStatus.getVerificationInfo().getCode());
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    function5 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-605546327);
                    composer.endReplaceGroup();
                }
                CommunityOfferItemKt.CommunityOfferItem(offer, zContains, zIsLocked, requiresPurchase, function4, function0, function5, composer, Offer.$stable, 0);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(8)), composer, 6);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$CommunityOffersScreenKt.INSTANCE.m9426getLambda$1846864562$app_debug(), 3, null);
        return Unit.INSTANCE;
    }
}
