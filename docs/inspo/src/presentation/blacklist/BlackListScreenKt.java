package com.example.bingwahybrid.presentation.blacklist;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.ContentCopyKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.FloatingActionButtonKt;
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
import androidx.compose.runtime.ProvidableCompositionLocal;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
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
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.presentation.blacklist.viewmodel.BlackListViewModel;
import com.example.bingwahybrid.presentation.ui.components.SearchBoxKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: BlackListScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\u001a)\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a=\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¢\u0006\u0002\u0010\u0010\u001a1\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0015\u001a/\u0010\u0016\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0018\u001a)\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b²\u0006\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u008a\u0084\u0002²\u0006\u0010\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020\u0014X\u008a\u008e\u0002"}, d2 = {"BlackListScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/blacklist/viewmodel/BlackListViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/blacklist/viewmodel/BlackListViewModel;Landroidx/compose/runtime/Composer;II)V", "CustomerList", "customers", "", "Lcom/example/bingwahybrid/domain/model/Customer;", "onBlacklist", "Lkotlin/Function1;", "blackListedCustomers", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "CustomerItem", "customer", "isBlacklisted", "", "(Lcom/example/bingwahybrid/domain/model/Customer;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "BlackListedCustomers", "onRemoveFromBlacklist", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "BlackListedCustomerItem", "(Lcom/example/bingwahybrid/domain/model/Customer;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_debug", "searchedCustomers", "isSearching", "searchQuery", "", "isCopied"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BlackListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListScreen$lambda$25(Modifier modifier, NavHostController navHostController, BlackListViewModel blackListViewModel, int i, int i2, Composer composer, int i3) {
        BlackListScreen(modifier, navHostController, blackListViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListedCustomerItem$lambda$52(Customer customer, Function1 function1, int i, Composer composer, int i2) {
        BlackListedCustomerItem(customer, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListedCustomers$lambda$40(List list, Function1 function1, int i, Composer composer, int i2) {
        BlackListedCustomers(list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomerItem$lambda$35(Customer customer, boolean z, Function1 function1, int i, Composer composer, int i2) {
        CustomerItem(customer, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomerList$lambda$30(List list, Function1 function1, List list2, int i, Composer composer, int i2) {
        CustomerList(list, function1, list2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BlackListScreen(Modifier modifier, final NavHostController navController, BlackListViewModel blackListViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final BlackListViewModel blackListViewModel2;
        final Modifier modifier3;
        final BlackListViewModel blackListViewModel3;
        final Modifier modifier4;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-801371335);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BlackListScreen)N(modifier,navController,viewModel)57@2598L16,58@2672L16,59@2734L16,60@2796L16,63@2845L1010,89@3888L534,105@4429L709,62@2818L2320:BlackListScreen.kt#m0htc0");
        int i4 = i2 & 1;
        if (i4 != 0) {
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
            if ((i2 & 4) == 0) {
                blackListViewModel2 = blackListViewModel;
                int i5 = composerStartRestartGroup.changedInstance(blackListViewModel2) ? 256 : 128;
                i3 |= i5;
            } else {
                blackListViewModel2 = blackListViewModel;
            }
            i3 |= i5;
        } else {
            blackListViewModel2 = blackListViewModel;
        }
        int i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i6 & 147) != 146, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "55@2525L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i6 &= -897;
                }
                modifier4 = modifier2;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 4) != 0) {
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
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(BlackListViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i6 &= -897;
                    modifier4 = companion;
                    blackListViewModel2 = (BlackListViewModel) viewModel;
                } else {
                    modifier4 = companion;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-801371335, i6, -1, "com.example.bingwahybrid.presentation.blacklist.BlackListScreen (BlackListScreen.kt:56)");
            }
            final State stateCollectAsState = SnapshotStateKt.collectAsState(blackListViewModel2.getBlackList(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState2 = SnapshotStateKt.collectAsState(blackListViewModel2.getSearchedCustomers(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState3 = SnapshotStateKt.collectAsState(blackListViewModel2.isSearching(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState4 = SnapshotStateKt.collectAsState(blackListViewModel2.getSearchQuery(), null, composerStartRestartGroup, 0, 1);
            final BlackListViewModel blackListViewModel4 = blackListViewModel2;
            Modifier modifier5 = modifier4;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(674584309, true, new Function2() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlackListScreenKt.BlackListScreen$lambda$14(blackListViewModel2, stateCollectAsState3, stateCollectAsState4, navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, ComposableLambdaKt.rememberComposableLambda(1529992018, true, new Function2() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlackListScreenKt.BlackListScreen$lambda$18(stateCollectAsState3, blackListViewModel2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-357529718, true, new Function3() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlackListScreenKt.BlackListScreen$lambda$24(modifier4, blackListViewModel4, stateCollectAsState3, stateCollectAsState2, stateCollectAsState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805330992, 493);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
            blackListViewModel3 = blackListViewModel4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            blackListViewModel3 = blackListViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlackListScreenKt.BlackListScreen$lambda$25(modifier3, navController, blackListViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListScreen$lambda$14(final BlackListViewModel blackListViewModel, final State state, final State state2, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C65@2894L614,79@3543L287,64@2859L985:BlackListScreen.kt#m0htc0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(674584309, i, -1, "com.example.bingwahybrid.presentation.blacklist.BlackListScreen.<anonymous> (BlackListScreen.kt:64)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(-1816569671, true, new Function2() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlackListScreenKt.BlackListScreen$lambda$14$lambda$10(blackListViewModel, state, state2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, ComposableLambdaKt.rememberComposableLambda(1342453179, true, new Function2() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlackListScreenKt.BlackListScreen$lambda$14$lambda$13(navHostController, state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListScreen$lambda$14$lambda$10(final BlackListViewModel blackListViewModel, State state, State state2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:BlackListScreen.kt#m0htc0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1816569671, i, -1, "com.example.bingwahybrid.presentation.blacklist.BlackListScreen.<anonymous>.<anonymous> (BlackListScreen.kt:66)");
            }
            if (BlackListScreen$lambda$2(state)) {
                composer.startReplaceGroup(-839057970);
                ComposerKt.sourceInformation(composer, "69@3076L35,71@3228L26,70@3157L27,67@2962L443");
                String strBlackListScreen$lambda$3 = BlackListScreen$lambda$3(state2);
                ComposerKt.sourceInformationMarkerStart(composer, -1966725796, "CC(remember):BlackListScreen.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(blackListViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BlackListScreenKt.BlackListScreen$lambda$14$lambda$10$lambda$5$lambda$4(blackListViewModel, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1966720941, "CC(remember):BlackListScreen.kt#9igjgp");
                boolean zChangedInstance2 = composer.changedInstance(blackListViewModel);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlackListScreenKt.BlackListScreen$lambda$14$lambda$10$lambda$7$lambda$6(blackListViewModel);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Function0 function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1966723212, "CC(remember):BlackListScreen.kt#9igjgp");
                boolean zChangedInstance3 = composer.changedInstance(blackListViewModel);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlackListScreenKt.BlackListScreen$lambda$14$lambda$10$lambda$9$lambda$8(blackListViewModel);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SearchBoxKt.SearchBox(strBlackListScreen$lambda$3, function1, function0, (Function0) objRememberedValue3, null, "Search by phone number or name", true, composer, 1769472, 16);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1966714186);
                ComposerKt.sourceInformation(composer, "76@3439L29");
                TextKt.m3864TextNvy7gAk("Blacklisted Customers", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListScreen$lambda$14$lambda$10$lambda$5$lambda$4(BlackListViewModel blackListViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        blackListViewModel.updateSearchQuery(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListScreen$lambda$14$lambda$10$lambda$9$lambda$8(BlackListViewModel blackListViewModel) {
        blackListViewModel.clearSearch();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListScreen$lambda$14$lambda$10$lambda$7$lambda$6(BlackListViewModel blackListViewModel) {
        blackListViewModel.stopSearch();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListScreen$lambda$14$lambda$13(final NavHostController navHostController, State state, Composer composer, int i) {
        Composer composer2;
        ComposerKt.sourceInformation(composer, "C:BlackListScreen.kt#m0htc0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1342453179, i, -1, "com.example.bingwahybrid.presentation.blacklist.BlackListScreen.<anonymous>.<anonymous> (BlackListScreen.kt:80)");
            }
            if (BlackListScreen$lambda$2(state)) {
                composer2 = composer;
                composer2.startReplaceGroup(-1716320409);
            } else {
                composer.startReplaceGroup(-1712757982);
                ComposerKt.sourceInformation(composer, "81@3630L32,81@3609L181");
                ComposerKt.sourceInformationMarkerStart(composer, 1607319035, "CC(remember):BlackListScreen.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(navHostController);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlackListScreenKt.BlackListScreen$lambda$14$lambda$13$lambda$12$lambda$11(navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer2 = composer;
                IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$BlackListScreenKt.INSTANCE.m9403getLambda$155457676$app_debug(), composer2, 1572864, 62);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListScreen$lambda$14$lambda$13$lambda$12$lambda$11(NavHostController navHostController) {
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListScreen$lambda$18(final State state, final BlackListViewModel blackListViewModel, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C91@3950L204,98@4169L243,90@3902L510:BlackListScreen.kt#m0htc0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1529992018, i, -1, "com.example.bingwahybrid.presentation.blacklist.BlackListScreen.<anonymous> (BlackListScreen.kt:90)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1443516254, "CC(remember):BlackListScreen.kt#9igjgp");
            boolean zChanged = composer.changed(state) | composer.changedInstance(blackListViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlackListScreenKt.BlackListScreen$lambda$18$lambda$16$lambda$15(blackListViewModel, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FloatingActionButtonKt.m3100FloatingActionButtonXz6DiA((Function0) objRememberedValue, null, null, 0L, 0L, null, null, ComposableLambdaKt.rememberComposableLambda(-1429293168, true, new Function2() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlackListScreenKt.BlackListScreen$lambda$18$lambda$17(state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12582912, WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListScreen$lambda$18$lambda$16$lambda$15(BlackListViewModel blackListViewModel, State state) {
        if (BlackListScreen$lambda$2(state)) {
            blackListViewModel.stopSearch();
        } else {
            blackListViewModel.startSearch();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListScreen$lambda$18$lambda$17(State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C99@4187L211:BlackListScreen.kt#m0htc0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1429293168, i, -1, "com.example.bingwahybrid.presentation.blacklist.BlackListScreen.<anonymous>.<anonymous> (BlackListScreen.kt:99)");
            }
            IconKt.m3158Iconww6aTOc(BlackListScreen$lambda$2(state) ? CloseKt.getClose(Icons.INSTANCE.getDefault()) : AddKt.getAdd(Icons.INSTANCE.getDefault()), BlackListScreen$lambda$2(state) ? "Close Search" : "Start Search", (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListScreen$lambda$24(Modifier modifier, final BlackListViewModel blackListViewModel, State state, State state2, State state3, PaddingValues paddingValues, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)106@4456L676:BlackListScreen.kt#m0htc0");
        if ((i & 6) == 0) {
            i |= composer.changed(paddingValues) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-357529718, i, -1, "com.example.bingwahybrid.presentation.blacklist.BlackListScreen.<anonymous> (BlackListScreen.kt:106)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 662238640, "C:BlackListScreen.kt#m0htc0");
            if (BlackListScreen$lambda$2(state)) {
                composer.startReplaceGroup(662247846);
                ComposerKt.sourceInformation(composer, "114@4757L38,112@4658L220");
                List<Customer> listBlackListScreen$lambda$1 = BlackListScreen$lambda$1(state2);
                ComposerKt.sourceInformationMarkerStart(composer, -1779748954, "CC(remember):BlackListScreen.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(blackListViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BlackListScreenKt.BlackListScreen$lambda$24$lambda$23$lambda$20$lambda$19(blackListViewModel, (Customer) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CustomerList(listBlackListScreen$lambda$1, (Function1) objRememberedValue, BlackListScreen$lambda$0(state3), composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(662502914);
                ComposerKt.sourceInformation(composer, "120@5047L43,118@4916L192");
                List<Customer> listBlackListScreen$lambda$0 = BlackListScreen$lambda$0(state3);
                ComposerKt.sourceInformationMarkerStart(composer, -1779739669, "CC(remember):BlackListScreen.kt#9igjgp");
                boolean zChangedInstance2 = composer.changedInstance(blackListViewModel);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BlackListScreenKt.BlackListScreen$lambda$24$lambda$23$lambda$22$lambda$21(blackListViewModel, (Customer) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BlackListedCustomers(listBlackListScreen$lambda$0, (Function1) objRememberedValue2, composer, 0);
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
    public static final Unit BlackListScreen$lambda$24$lambda$23$lambda$20$lambda$19(BlackListViewModel blackListViewModel, Customer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        blackListViewModel.addToBlackList(it.getPhone());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListScreen$lambda$24$lambda$23$lambda$22$lambda$21(BlackListViewModel blackListViewModel, Customer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        blackListViewModel.removeFromBlackList(it.getPhone());
        return Unit.INSTANCE;
    }

    public static final void CustomerList(final List<Customer> customers, final Function1<? super Customer, Unit> onBlacklist, final List<Customer> blackListedCustomers, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(customers, "customers");
        Intrinsics.checkNotNullParameter(onBlacklist, "onBlacklist");
        Intrinsics.checkNotNullParameter(blackListedCustomers, "blackListedCustomers");
        Composer composerStartRestartGroup = composer.startRestartGroup(549036012);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomerList)N(customers,onBlacklist,blackListedCustomers)133@5301L397,133@5290L408:BlackListScreen.kt#m0htc0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(customers) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onBlacklist) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(blackListedCustomers) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(549036012, i2, -1, "com.example.bingwahybrid.presentation.blacklist.CustomerList (BlackListScreen.kt:132)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -657364391, "CC(remember):BlackListScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(customers) | composerStartRestartGroup.changedInstance(blackListedCustomers) | ((i2 & 112) == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlackListScreenKt.CustomerList$lambda$29$lambda$28(customers, blackListedCustomers, onBlacklist, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 511);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlackListScreenKt.CustomerList$lambda$30(customers, onBlacklist, blackListedCustomers, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void CustomerItem(final Customer customer, final boolean z, final Function1<? super Customer, Unit> onBlacklist, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(customer, "customer");
        Intrinsics.checkNotNullParameter(onBlacklist, "onBlacklist");
        Composer composerStartRestartGroup = composer.startRestartGroup(-948843139);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomerItem)N(customer,isBlacklisted,onBlacklist)155@5829L894:BlackListScreen.kt#m0htc0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(customer) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onBlacklist) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-948843139, i2, -1, "com.example.bingwahybrid.presentation.blacklist.CustomerItem (BlackListScreen.kt:154)");
            }
            float f = 8;
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1118padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1280115122, "C161@5989L219:BlackListScreen.kt#m0htc0");
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1078873700, "C162@6091L10,162@6042L72,163@6177L10,163@6127L71:BlackListScreen.kt#m0htc0");
            int i3 = i2;
            TextKt.m3864TextNvy7gAk(customer.getName(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composerStartRestartGroup, 0, 0, 131070);
            TextKt.m3864TextNvy7gAk(customer.getPhone(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), composerStartRestartGroup, 0, 0, 131070);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (!z) {
                composerStartRestartGroup.startReplaceGroup(1280345296);
                ComposerKt.sourceInformation(composerStartRestartGroup, "167@6296L25,166@6251L193");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1011134482, "CC(remember):BlackListScreen.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(customer) | ((i3 & 896) == 256);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlackListScreenKt.CustomerItem$lambda$34$lambda$33$lambda$32(onBlacklist, customer);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ButtonKt.FilledTonalButton((Function0) objRememberedValue, PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8684constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, null), false, null, null, null, null, null, null, ComposableSingletons$BlackListScreenKt.INSTANCE.getLambda$162813068$app_debug(), composerStartRestartGroup, 805306416, 508);
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceGroup(1280567752);
                ComposerKt.sourceInformation(composerStartRestartGroup, "175@6556L11,176@6613L10,173@6474L233");
                composer2 = composerStartRestartGroup;
                TextKt.m3864TextNvy7gAk("Blacklisted", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8684constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getError(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composer2, 54, 0, 131064);
                composer2.endReplaceGroup();
            }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlackListScreenKt.CustomerItem$lambda$35(customer, z, onBlacklist, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomerItem$lambda$34$lambda$33$lambda$32(Function1 function1, Customer customer) {
        function1.invoke(customer);
        return Unit.INSTANCE;
    }

    public static final void BlackListedCustomers(final List<Customer> blackListedCustomers, final Function1<? super Customer, Unit> onRemoveFromBlacklist, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(blackListedCustomers, "blackListedCustomers");
        Intrinsics.checkNotNullParameter(onRemoveFromBlacklist, "onRemoveFromBlacklist");
        Composer composerStartRestartGroup = composer.startRestartGroup(-212741087);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BlackListedCustomers)N(blackListedCustomers,onRemoveFromBlacklist):BlackListScreen.kt#m0htc0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(blackListedCustomers) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onRemoveFromBlacklist) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-212741087, i2, -1, "com.example.bingwahybrid.presentation.blacklist.BlackListedCustomers (BlackListScreen.kt:187)");
            }
            if (blackListedCustomers.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(1602189818);
                ComposerKt.sourceInformation(composerStartRestartGroup, "189@6908L439");
                Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(16));
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1118padding3ABfNKs);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -596361821, "C197@7189L10,198@7249L11,195@7081L256:BlackListScreen.kt#m0htc0");
                TextKt.m3864TextNvy7gAk("You have not blacklisted any customer", null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, TextAlign.m8533boximpl(TextAlign.INSTANCE.m8540getCentere0LSkKk()), 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, 6, 0, 130042);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1602646045);
                ComposerKt.sourceInformation(composerStartRestartGroup, "203@7380L393,203@7369L404");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1714266890, "CC(remember):BlackListScreen.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(blackListedCustomers) | ((i2 & 112) == 32);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BlackListScreenKt.BlackListedCustomers$lambda$39$lambda$38(blackListedCustomers, onRemoveFromBlacklist, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 511);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlackListScreenKt.BlackListedCustomers$lambda$40(blackListedCustomers, onRemoveFromBlacklist, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void BlackListedCustomerItem(final Customer customer, Function1<? super Customer, Unit> onRemoveFromBlacklist, Composer composer, final int i) {
        int i2;
        final Customer customer2;
        final Function1<? super Customer, Unit> function1;
        final MutableState mutableState;
        Intrinsics.checkNotNullParameter(customer, "customer");
        Intrinsics.checkNotNullParameter(onRemoveFromBlacklist, "onRemoveFromBlacklist");
        Composer composerStartRestartGroup = composer.startRestartGroup(74061561);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BlackListedCustomerItem)N(customer,onRemoveFromBlacklist)223@7948L7,224@7976L34,225@8027L24,227@8057L1318:BlackListScreen.kt#m0htc0");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changedInstance(customer) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onRemoveFromBlacklist) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            customer2 = customer;
            function1 = onRemoveFromBlacklist;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(74061561, i2, -1, "com.example.bingwahybrid.presentation.blacklist.BlackListedCustomerItem (BlackListScreen.kt:222)");
            }
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final ClipboardManager clipboardManager = (ClipboardManager) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1841277701, "CC(remember):BlackListScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(8));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1118padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -790641466, "C233@8217L1046,257@9294L35,257@9273L96:BlackListScreen.kt#m0htc0");
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 210543001, "C234@8319L10,234@8270L72,235@8355L898:BlackListScreen.kt#m0htc0");
            int i3 = i2;
            TextKt.m3864TextNvy7gAk(customer.getName(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composerStartRestartGroup, 0, 0, 131070);
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl3.rememberedValue(), Integer.valueOf(iHashCode3))) {
                composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
            }
            Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1638634050, "C236@8475L10,236@8425L71,238@8555L295,247@8932L307,237@8513L726:BlackListScreen.kt#m0htc0");
            TextKt.m3864TextNvy7gAk(customer.getPhone(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), composerStartRestartGroup, 0, 0, 131070);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -52855522, "CC(remember):BlackListScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(clipboardManager) | composerStartRestartGroup.changedInstance(customer) | composerStartRestartGroup.changedInstance(coroutineScope);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState2;
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlackListScreenKt.BlackListedCustomerItem$lambda$51$lambda$48$lambda$47$lambda$45$lambda$44(clipboardManager, customer, coroutineScope, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                mutableState = mutableState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconButtonKt.IconButton((Function0) objRememberedValue3, PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8684constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), false, null, null, null, ComposableLambdaKt.rememberComposableLambda(1594501333, true, new Function2() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlackListScreenKt.BlackListedCustomerItem$lambda$51$lambda$48$lambda$47$lambda$46(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572912, 60);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 528718112, "CC(remember):BlackListScreen.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(customer) | ((i3 & 112) == 32);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                function1 = onRemoveFromBlacklist;
                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlackListScreenKt.BlackListedCustomerItem$lambda$51$lambda$50$lambda$49(function1, customer);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                function1 = onRemoveFromBlacklist;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            customer2 = customer;
            ButtonKt.TextButton((Function0) objRememberedValue4, null, false, null, null, null, null, null, null, ComposableSingletons$BlackListScreenKt.INSTANCE.getLambda$1962504858$app_debug(), composerStartRestartGroup, 805306368, 510);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlackListScreenKt.BlackListedCustomerItem$lambda$52(customer2, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean BlackListedCustomerItem$lambda$42(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BlackListedCustomerItem$lambda$43(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListedCustomerItem$lambda$51$lambda$48$lambda$47$lambda$45$lambda$44(ClipboardManager clipboardManager, Customer customer, CoroutineScope coroutineScope, MutableState mutableState) {
        clipboardManager.setText(new AnnotatedString(customer.getPhone(), null, 2, null));
        BlackListedCustomerItem$lambda$43(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BlackListScreenKt$BlackListedCustomerItem$1$1$1$1$1$1(mutableState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListedCustomerItem$lambda$51$lambda$48$lambda$47$lambda$46(MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C248@8954L267:BlackListScreen.kt#m0htc0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1594501333, i, -1, "com.example.bingwahybrid.presentation.blacklist.BlackListedCustomerItem.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BlackListScreen.kt:248)");
            }
            IconKt.m3158Iconww6aTOc(BlackListedCustomerItem$lambda$42(mutableState) ? CheckKt.getCheck(Icons.Filled.INSTANCE) : ContentCopyKt.getContentCopy(Icons.INSTANCE.getDefault()), BlackListedCustomerItem$lambda$42(mutableState) ? "Copied" : "Copy", SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), 0L, composer, 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListedCustomerItem$lambda$51$lambda$50$lambda$49(Function1 function1, Customer customer) {
        function1.invoke(customer);
        return Unit.INSTANCE;
    }

    private static final List<Customer> BlackListScreen$lambda$0(State<? extends List<Customer>> state) {
        return state.getValue();
    }

    private static final List<Customer> BlackListScreen$lambda$1(State<? extends List<Customer>> state) {
        return state.getValue();
    }

    private static final boolean BlackListScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String BlackListScreen$lambda$3(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomerList$lambda$29$lambda$28(final List list, final List list2, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final BlackListScreenKt$CustomerList$lambda$29$lambda$28$$inlined$items$default$1 blackListScreenKt$CustomerList$lambda$29$lambda$28$$inlined$items$default$1 = new Function1() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$CustomerList$lambda$29$lambda$28$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Customer customer) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Customer) obj);
            }
        };
        LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$CustomerList$lambda$29$lambda$28$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return blackListScreenKt$CustomerList$lambda$29$lambda$28$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$CustomerList$lambda$29$lambda$28$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                boolean z = true;
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                Customer customer = (Customer) list.get(i);
                composer.startReplaceGroup(-2091447430);
                ComposerKt.sourceInformation(composer, "CN(customer)*135@5354L195,140@5562L40:BlackListScreen.kt#m0htc0");
                List list3 = list2;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    Iterator it = list3.iterator();
                    do {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                    } while (!Intrinsics.areEqual(((Customer) it.next()).getPhone(), customer.getPhone()));
                } else {
                    z = false;
                    break;
                }
                BlackListScreenKt.CustomerItem(customer, z, function1, composer, 0);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(8)), composer, 6);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$BlackListScreenKt.INSTANCE.m9404getLambda$2006946367$app_debug(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListedCustomers$lambda$39$lambda$38(final List list, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final BlackListScreenKt$BlackListedCustomers$lambda$39$lambda$38$$inlined$items$default$1 blackListScreenKt$BlackListedCustomers$lambda$39$lambda$38$$inlined$items$default$1 = new Function1() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$BlackListedCustomers$lambda$39$lambda$38$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Customer customer) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Customer) obj);
            }
        };
        LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$BlackListedCustomers$lambda$39$lambda$38$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return blackListScreenKt$BlackListedCustomers$lambda$39$lambda$38$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.bingwahybrid.presentation.blacklist.BlackListScreenKt$BlackListedCustomers$lambda$39$lambda$38$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
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
                Customer customer = (Customer) list.get(i);
                composer.startReplaceGroup(1401377821);
                ComposerKt.sourceInformation(composer, "CN(customer)*205@7452L149,209@7618L40:BlackListScreen.kt#m0htc0");
                BlackListScreenKt.BlackListedCustomerItem(customer, function1, composer, 0);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(8)), composer, 6);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$BlackListScreenKt.INSTANCE.m9402getLambda$1272866808$app_debug(), 3, null);
        return Unit.INSTANCE;
    }
}
