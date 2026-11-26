package com.example.bingwahybrid.presentation.transactions.screens;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
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
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
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
import androidx.profileinstaller.ProfileVerifier;
import com.example.bingwahybrid.domain.enums.DeleteState;
import com.example.bingwahybrid.domain.enums.LoadingState;
import com.example.bingwahybrid.domain.enums.RescheduleMode;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.model.RescheduleInfo;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.utils.TimeUtilsKt;
import com.example.bingwahybrid.presentation.navigation.Route;
import com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel;
import com.example.bingwahybrid.presentation.ui.components.InfoCardKt;
import com.example.bingwahybrid.presentation.ui.components.ScheduledTransactionItemKt;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TransactionDetailsScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001aK\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a\u0095\u0001\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00182\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00182\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u0018H\u0007¢\u0006\u0002\u0010\u001e\u001a\u0015\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!H\u0003¢\u0006\u0002\u0010\"\u001aK\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00152\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00182\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0018H\u0003¢\u0006\u0002\u0010%\u001a\r\u0010&\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010'¨\u0006(²\u0006\n\u0010)\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020+X\u008a\u0084\u0002²\u0006\f\u0010,\u001a\u0004\u0018\u00010-X\u008a\u0084\u0002²\u0006\f\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u008a\u0084\u0002²\u0006\u0010\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010.\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"TransactionDetailsScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/transactions/viewmodel/TransactionDetailsViewModel;", "onBackClick", "Lkotlin/Function0;", "transactionId", "Ljava/util/UUID;", "hasScheduledTransactions", "", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/transactions/viewmodel/TransactionDetailsViewModel;Lkotlin/jvm/functions/Function0;Ljava/util/UUID;ZLandroidx/compose/runtime/Composer;II)V", "TransactionDetailsScreenContent", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "scheduledTransactions", "", "scheduledTransactionsLoadingState", "Lcom/example/bingwahybrid/domain/enums/LoadingState;", "isRetrying", "onRetry", "Lkotlin/Function1;", "onDelete", "onReschedule", "onViewTransaction", "onTapOffer", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "(Lcom/example/bingwahybrid/domain/model/Transaction;Ljava/util/List;Lcom/example/bingwahybrid/domain/enums/LoadingState;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "RescheduleText", "time", "", "(JLandroidx/compose/runtime/Composer;I)V", "ScheduledTransactionsSection", "loadingState", "(Lcom/example/bingwahybrid/domain/enums/LoadingState;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "TransactionDetailsScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "showDeleteDialog", "deleteState", "Lcom/example/bingwahybrid/domain/enums/DeleteState;", "snackBarMessage", "", "transactionLoadingState"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TransactionDetailsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleText$lambda$53(long j, int i, Composer composer, int i2) {
        RescheduleText(j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScheduledTransactionsSection$lambda$60(LoadingState loadingState, List list, Function1 function1, Function1 function2, int i, Composer composer, int i2) {
        ScheduledTransactionsSection(loadingState, list, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$39(Modifier modifier, NavHostController navHostController, TransactionDetailsViewModel transactionDetailsViewModel, Function0 function0, UUID uuid, boolean z, int i, int i2, Composer composer, int i3) {
        TransactionDetailsScreen(modifier, navHostController, transactionDetailsViewModel, function0, uuid, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreenContent$lambda$49(Transaction transaction, List list, LoadingState loadingState, boolean z, Function1 function1, Function0 function0, Function1 function2, Function1 function3, Function1 function4, int i, int i2, Composer composer, int i3) {
        TransactionDetailsScreenContent(transaction, list, loadingState, z, function1, function0, function2, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreenPreview$lambda$69(int i, Composer composer, int i2) {
        TransactionDetailsScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$1$lambda$0(NavHostController navHostController) {
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x018d  */
    /* JADX WARN: Code duplicated, block: B:104:0x019f  */
    /* JADX WARN: Code duplicated, block: B:105:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:108:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:111:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:114:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:117:0x0267  */
    /* JADX WARN: Code duplicated, block: B:121:0x0277  */
    /* JADX WARN: Code duplicated, block: B:124:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:128:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:130:0x02c7 A[PHI: r38
  0x02c7: PHI (r38v4 androidx.compose.runtime.MutableState) = (r38v2 androidx.compose.runtime.MutableState), (r38v5 androidx.compose.runtime.MutableState) binds: [B:129:0x02c5, B:127:0x02be] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:131:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:134:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:138:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:141:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:143:0x0302  */
    /* JADX WARN: Code duplicated, block: B:149:0x0315  */
    /* JADX WARN: Code duplicated, block: B:150:0x0317  */
    /* JADX WARN: Code duplicated, block: B:153:0x031f  */
    /* JADX WARN: Code duplicated, block: B:155:0x0327  */
    /* JADX WARN: Code duplicated, block: B:158:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:160:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:162:0x0426  */
    /* JADX WARN: Code duplicated, block: B:165:0x0435  */
    /* JADX WARN: Code duplicated, block: B:167:0x043a  */
    /* JADX WARN: Code duplicated, block: B:170:0x0449  */
    /* JADX WARN: Code duplicated, block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0068  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:64:0x00be  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:85:0x0100  */
    /* JADX WARN: Code duplicated, block: B:87:0x0112  */
    /* JADX WARN: Code duplicated, block: B:89:0x012b  */
    /* JADX WARN: Code duplicated, block: B:90:0x0133  */
    /* JADX WARN: Code duplicated, block: B:92:0x0161  */
    /* JADX WARN: Code duplicated, block: B:94:0x016d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0175  */
    /* JADX WARN: Code duplicated, block: B:99:0x0185  */
    public static final void TransactionDetailsScreen(Modifier modifier, final NavHostController navController, TransactionDetailsViewModel transactionDetailsViewModel, Function0<Unit> function0, final UUID transactionId, boolean z, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Function0<Unit> function1;
        boolean z2;
        boolean z3;
        Composer composer2;
        final boolean z4;
        final TransactionDetailsViewModel transactionDetailsViewModel2;
        final Modifier modifier3;
        final Function0<Unit> function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composer3;
        boolean z5;
        final Function0<Unit> function3;
        boolean zChangedInstance;
        Object objRememberedValue;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        String str;
        int i4;
        final TransactionDetailsViewModel transactionDetailsViewModel3;
        Object objRememberedValue2;
        CoroutineScope coroutineScope;
        Object objRememberedValue3;
        MutableState mutableState;
        State stateCollectAsState;
        State stateCollectAsState2;
        DeleteState deleteStateTransactionDetailsScreen$lambda$5;
        boolean zChanged;
        TransactionDetailsScreenKt$TransactionDetailsScreen$2$1 transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue;
        DeleteState deleteState;
        State state;
        MutableState mutableState2;
        String str2;
        int i5;
        final State state2;
        MutableState mutableState3;
        boolean z6;
        boolean z7;
        Continuation continuation;
        TransactionDetailsScreenKt$TransactionDetailsScreen$3$1 transactionDetailsScreenKt$TransactionDetailsScreen$3$1;
        boolean z8;
        boolean z9;
        TransactionDetailsScreenKt$TransactionDetailsScreen$4$1 transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue;
        final MutableState mutableState4;
        Object objRememberedValue4;
        int i6;
        final TransactionDetailsViewModel transactionDetailsViewModel4 = transactionDetailsViewModel;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1624354640);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TransactionDetailsScreen)N(modifier,navController,viewModel,onBackClick,transactionId,hasScheduledTransactions)69@3251L24,70@3304L34,71@3384L16,72@3454L16,73@3516L16,74@3598L16,75@3658L16,76@3733L16,77@3839L16,79@3889L294,79@3861L322,91@4221L144,91@4189L176,98@4401L183,98@4371L213,105@4608L245,111@4855L2329,105@4590L2594:TransactionDetailsScreen.kt#jgxt63");
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
                if ((i & 512) == 0 ? composerStartRestartGroup.changed(transactionDetailsViewModel4) : composerStartRestartGroup.changedInstance(transactionDetailsViewModel4)) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
            }
            i3 |= i6;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                function1 = function0;
                int i8 = composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
                i3 |= i8;
            } else {
                function1 = function0;
            }
            i3 |= i8;
        } else {
            function1 = function0;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(transactionId) ? 16384 : 8192;
        }
        int i9 = i2 & 32;
        if (i9 == 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 131072 : 65536;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "64@3078L15,65@3125L32");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
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
                        ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(TransactionDetailsViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        composer3 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        transactionDetailsViewModel4 = (TransactionDetailsViewModel) viewModel;
                        i3 &= -897;
                    } else {
                        composer3 = composerStartRestartGroup;
                    }
                    if ((i2 & 8) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composer3, -1931672624, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                        zChangedInstance = composer3.changedInstance(navController);
                        objRememberedValue = composer3.rememberedValue();
                        if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda25
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$1$lambda$0(navController);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        function1 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        i3 &= -7169;
                    }
                    if (i9 != 0) {
                        function3 = function1;
                        z5 = false;
                    } else {
                        z5 = z;
                    }
                    i4 = i3;
                    transactionDetailsViewModel3 = transactionDetailsViewModel4;
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1624354640, i4, -1, "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreen (TransactionDetailsScreen.kt:68)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composer3, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3);
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1931666894, str);
                    objRememberedValue3 = composer3.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    stateCollectAsState = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getDeleteState(), null, composer3, 0, 1);
                    stateCollectAsState2 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getSnackbarMessage(), null, composer3, 0, 1);
                    final State stateCollectAsState3 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getTransaction(), null, composer3, 0, 1);
                    final State stateCollectAsState4 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getScheduledTransactions(), null, composer3, 0, 1);
                    final State stateCollectAsState5 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.isRetrying(), null, composer3, 0, 1);
                    final State stateCollectAsState6 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getLoadingState(), null, composer3, 0, 1);
                    final State stateCollectAsState7 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getScheduledTransactionsLoadingState(), null, composer3, 0, 1);
                    deleteStateTransactionDetailsScreen$lambda$5 = TransactionDetailsScreen$lambda$5(stateCollectAsState);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1931647914, str);
                    zChanged = composer3.changed(stateCollectAsState) | composer3.changedInstance(navController) | composer3.changedInstance(coroutineScope);
                    transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue = composer3.rememberedValue();
                    if (!zChanged || transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        deleteState = deleteStateTransactionDetailsScreen$lambda$5;
                        state = stateCollectAsState;
                        mutableState2 = mutableState;
                        transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue = new TransactionDetailsScreenKt$TransactionDetailsScreen$2$1(navController, coroutineScope, state, mutableState2, null);
                        composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue);
                    } else {
                        state = stateCollectAsState;
                        mutableState2 = mutableState;
                        deleteState = deleteStateTransactionDetailsScreen$lambda$5;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    EffectsKt.LaunchedEffect(deleteState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue, composer3, 0);
                    String strTransactionDetailsScreen$lambda$6 = TransactionDetailsScreen$lambda$6(stateCollectAsState2);
                    str2 = str;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1931637440, str2);
                    boolean zChanged2 = composer3.changed(stateCollectAsState2) | composer3.changedInstance(coroutineScope);
                    i5 = (i4 & 896) ^ 384;
                    state2 = state;
                    if (i5 > 256 || !composer3.changedInstance(transactionDetailsViewModel3)) {
                        mutableState3 = mutableState2;
                        if ((i4 & 384) != 256) {
                            z6 = false;
                        }
                        z7 = z6 | zChanged2;
                        Object objRememberedValue5 = composer3.rememberedValue();
                        if (!z7 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            continuation = null;
                            transactionDetailsScreenKt$TransactionDetailsScreen$3$1 = new TransactionDetailsScreenKt$TransactionDetailsScreen$3$1(stateCollectAsState2, coroutineScope, transactionDetailsViewModel3, null);
                            composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$3$1);
                        } else {
                            transactionDetailsScreenKt$TransactionDetailsScreen$3$1 = objRememberedValue5;
                            continuation = null;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        EffectsKt.LaunchedEffect(strTransactionDetailsScreen$lambda$6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionDetailsScreenKt$TransactionDetailsScreen$3$1, composer3, 0);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1931631641, str2);
                        boolean zChangedInstance2 = composer3.changedInstance(transactionId) | ((i5 <= 256 && composer3.changedInstance(transactionDetailsViewModel3)) || (i4 & 384) == 256);
                        if ((458752 & i4) == 131072) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = zChangedInstance2 | z8;
                        transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue = composer3.rememberedValue();
                        if (!z9 || transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue = new TransactionDetailsScreenKt$TransactionDetailsScreen$4$1(transactionDetailsViewModel3, transactionId, z5, continuation);
                            composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        EffectsKt.LaunchedEffect(transactionId, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue, composer3, (i4 >> 12) & 14);
                        mutableState4 = mutableState3;
                        final Modifier modifier4 = modifier2;
                        boolean z10 = z5;
                        modifier2 = modifier4;
                        transactionDetailsViewModel4 = transactionDetailsViewModel3;
                        Composer composer4 = composer3;
                        function1 = function3;
                        ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(1650646644, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda26
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$16(function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(2131535359, true, new Function3() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda27
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$29(modifier4, stateCollectAsState6, stateCollectAsState3, transactionDetailsViewModel3, navController, transactionId, stateCollectAsState4, stateCollectAsState7, stateCollectAsState5, mutableState4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer3, 54), composer4, 805306416, 509);
                        composer2 = composer4;
                        if (TransactionDetailsScreen$lambda$3(mutableState4)) {
                            composer2.startReplaceGroup(244588818);
                        } else {
                            composer2.startReplaceGroup(251773905);
                            ComposerKt.sourceInformation(composer2, "167@7266L28,175@7658L332,185@8020L137,169@7367L261,166@7222L945");
                            ComposerKt.sourceInformationMarkerStart(composer2, -1931540116, str2);
                            objRememberedValue4 = composer2.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$31$lambda$30(mutableState4);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0((Function0) objRememberedValue4, ComposableLambdaKt.rememberComposableLambda(586940931, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$34(transactionDetailsViewModel4, state2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(351667393, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$37(mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer2, 54), null, ComposableSingletons$TransactionDetailsScreenKt.INSTANCE.getLambda$116393855$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1242914, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$38(state2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, 1772598, 0, 16276);
                            composer2 = composer2;
                        }
                        composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z10;
                    } else {
                        mutableState3 = mutableState2;
                    }
                    z6 = true;
                    z7 = z6 | zChanged2;
                    Object objRememberedValue6 = composer3.rememberedValue();
                    if (z7) {
                        continuation = null;
                        transactionDetailsScreenKt$TransactionDetailsScreen$3$1 = new TransactionDetailsScreenKt$TransactionDetailsScreen$3$1(stateCollectAsState2, coroutineScope, transactionDetailsViewModel3, null);
                        composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$3$1);
                    } else {
                        continuation = null;
                        transactionDetailsScreenKt$TransactionDetailsScreen$3$1 = new TransactionDetailsScreenKt$TransactionDetailsScreen$3$1(stateCollectAsState2, coroutineScope, transactionDetailsViewModel3, null);
                        composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$3$1);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    EffectsKt.LaunchedEffect(strTransactionDetailsScreen$lambda$6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionDetailsScreenKt$TransactionDetailsScreen$3$1, composer3, 0);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1931631641, str2);
                    boolean zChangedInstance3 = composer3.changedInstance(transactionId) | ((i5 <= 256 && composer3.changedInstance(transactionDetailsViewModel3)) || (i4 & 384) == 256);
                    if ((458752 & i4) == 131072) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = zChangedInstance3 | z8;
                    transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue = composer3.rememberedValue();
                    if (!z9) {
                        transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue = new TransactionDetailsScreenKt$TransactionDetailsScreen$4$1(transactionDetailsViewModel3, transactionId, z5, continuation);
                        composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue);
                    } else {
                        transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue = new TransactionDetailsScreenKt$TransactionDetailsScreen$4$1(transactionDetailsViewModel3, transactionId, z5, continuation);
                        composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    EffectsKt.LaunchedEffect(transactionId, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue, composer3, (i4 >> 12) & 14);
                    mutableState4 = mutableState3;
                    final Modifier modifier5 = modifier2;
                    boolean z11 = z5;
                    modifier2 = modifier5;
                    transactionDetailsViewModel4 = transactionDetailsViewModel3;
                    Composer composer5 = composer3;
                    function1 = function3;
                    ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(1650646644, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$16(function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(2131535359, true, new Function3() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$29(modifier5, stateCollectAsState6, stateCollectAsState3, transactionDetailsViewModel3, navController, transactionId, stateCollectAsState4, stateCollectAsState7, stateCollectAsState5, mutableState4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer3, 54), composer5, 805306416, 509);
                    composer2 = composer5;
                    if (TransactionDetailsScreen$lambda$3(mutableState4)) {
                        composer2.startReplaceGroup(244588818);
                    } else {
                        composer2.startReplaceGroup(251773905);
                        ComposerKt.sourceInformation(composer2, "167@7266L28,175@7658L332,185@8020L137,169@7367L261,166@7222L945");
                        ComposerKt.sourceInformationMarkerStart(composer2, -1931540116, str2);
                        objRememberedValue4 = composer2.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$31$lambda$30(mutableState4);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0((Function0) objRememberedValue4, ComposableLambdaKt.rememberComposableLambda(586940931, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$34(transactionDetailsViewModel4, state2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(351667393, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$37(mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer2, 54), null, ComposableSingletons$TransactionDetailsScreenKt.INSTANCE.getLambda$116393855$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1242914, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$38(state2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, 1772598, 0, 16276);
                        composer2 = composer2;
                    }
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z11;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    composer3 = composerStartRestartGroup;
                    z5 = z2;
                    str = "CC(remember):TransactionDetailsScreen.kt#9igjgp";
                }
                function3 = function1;
                i4 = i3;
                transactionDetailsViewModel3 = transactionDetailsViewModel4;
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1624354640, i4, -1, "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreen (TransactionDetailsScreen.kt:68)");
                }
                ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composer3, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3);
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                coroutineScope = (CoroutineScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1931666894, str);
                objRememberedValue3 = composer3.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                mutableState = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                stateCollectAsState = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getDeleteState(), null, composer3, 0, 1);
                stateCollectAsState2 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getSnackbarMessage(), null, composer3, 0, 1);
                final State stateCollectAsState8 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getTransaction(), null, composer3, 0, 1);
                final State stateCollectAsState9 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getScheduledTransactions(), null, composer3, 0, 1);
                final State stateCollectAsState10 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.isRetrying(), null, composer3, 0, 1);
                final State stateCollectAsState11 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getLoadingState(), null, composer3, 0, 1);
                final State stateCollectAsState12 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getScheduledTransactionsLoadingState(), null, composer3, 0, 1);
                deleteStateTransactionDetailsScreen$lambda$5 = TransactionDetailsScreen$lambda$5(stateCollectAsState);
                ComposerKt.sourceInformationMarkerStart(composer3, -1931647914, str);
                zChanged = composer3.changed(stateCollectAsState) | composer3.changedInstance(navController) | composer3.changedInstance(coroutineScope);
                transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue = composer3.rememberedValue();
                if (zChanged) {
                    deleteState = deleteStateTransactionDetailsScreen$lambda$5;
                    state = stateCollectAsState;
                    mutableState2 = mutableState;
                    transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue = new TransactionDetailsScreenKt$TransactionDetailsScreen$2$1(navController, coroutineScope, state, mutableState2, null);
                    composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue);
                } else {
                    deleteState = deleteStateTransactionDetailsScreen$lambda$5;
                    state = stateCollectAsState;
                    mutableState2 = mutableState;
                    transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue = new TransactionDetailsScreenKt$TransactionDetailsScreen$2$1(navController, coroutineScope, state, mutableState2, null);
                    composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                EffectsKt.LaunchedEffect(deleteState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue, composer3, 0);
                String strTransactionDetailsScreen$lambda$7 = TransactionDetailsScreen$lambda$6(stateCollectAsState2);
                str2 = str;
                ComposerKt.sourceInformationMarkerStart(composer3, -1931637440, str2);
                boolean zChanged3 = composer3.changed(stateCollectAsState2) | composer3.changedInstance(coroutineScope);
                i5 = (i4 & 896) ^ 384;
                state2 = state;
                if (i5 > 256) {
                    mutableState3 = mutableState2;
                    if ((i4 & 384) != 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                } else {
                    mutableState3 = mutableState2;
                    if ((i4 & 384) != 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                }
                z7 = z6 | zChanged3;
                Object objRememberedValue7 = composer3.rememberedValue();
                if (z7) {
                    continuation = null;
                    transactionDetailsScreenKt$TransactionDetailsScreen$3$1 = new TransactionDetailsScreenKt$TransactionDetailsScreen$3$1(stateCollectAsState2, coroutineScope, transactionDetailsViewModel3, null);
                    composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$3$1);
                } else {
                    continuation = null;
                    transactionDetailsScreenKt$TransactionDetailsScreen$3$1 = new TransactionDetailsScreenKt$TransactionDetailsScreen$3$1(stateCollectAsState2, coroutineScope, transactionDetailsViewModel3, null);
                    composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$3$1);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                EffectsKt.LaunchedEffect(strTransactionDetailsScreen$lambda$7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionDetailsScreenKt$TransactionDetailsScreen$3$1, composer3, 0);
                ComposerKt.sourceInformationMarkerStart(composer3, -1931631641, str2);
                boolean zChangedInstance4 = composer3.changedInstance(transactionId) | ((i5 <= 256 && composer3.changedInstance(transactionDetailsViewModel3)) || (i4 & 384) == 256);
                if ((458752 & i4) == 131072) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = zChangedInstance4 | z8;
                transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue = composer3.rememberedValue();
                if (!z9) {
                    transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue = new TransactionDetailsScreenKt$TransactionDetailsScreen$4$1(transactionDetailsViewModel3, transactionId, z5, continuation);
                    composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue);
                } else {
                    transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue = new TransactionDetailsScreenKt$TransactionDetailsScreen$4$1(transactionDetailsViewModel3, transactionId, z5, continuation);
                    composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                EffectsKt.LaunchedEffect(transactionId, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue, composer3, (i4 >> 12) & 14);
                mutableState4 = mutableState3;
                final Modifier modifier6 = modifier2;
                boolean z12 = z5;
                modifier2 = modifier6;
                transactionDetailsViewModel4 = transactionDetailsViewModel3;
                Composer composer6 = composer3;
                function1 = function3;
                ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(1650646644, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$16(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(2131535359, true, new Function3() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$29(modifier6, stateCollectAsState11, stateCollectAsState8, transactionDetailsViewModel3, navController, transactionId, stateCollectAsState9, stateCollectAsState12, stateCollectAsState10, mutableState4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer3, 54), composer6, 805306416, 509);
                composer2 = composer6;
                if (TransactionDetailsScreen$lambda$3(mutableState4)) {
                    composer2.startReplaceGroup(244588818);
                } else {
                    composer2.startReplaceGroup(251773905);
                    ComposerKt.sourceInformation(composer2, "167@7266L28,175@7658L332,185@8020L137,169@7367L261,166@7222L945");
                    ComposerKt.sourceInformationMarkerStart(composer2, -1931540116, str2);
                    objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$31$lambda$30(mutableState4);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0((Function0) objRememberedValue4, ComposableLambdaKt.rememberComposableLambda(586940931, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$34(transactionDetailsViewModel4, state2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(351667393, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$37(mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), null, ComposableSingletons$TransactionDetailsScreenKt.INSTANCE.getLambda$116393855$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1242914, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$38(state2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, 1772598, 0, 16276);
                    composer2 = composer2;
                }
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z12;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z4 = z;
            }
            transactionDetailsViewModel2 = transactionDetailsViewModel4;
            modifier3 = modifier2;
            function2 = function1;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$39(modifier3, navController, transactionDetailsViewModel2, function2, transactionId, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        if ((74899 & i3) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "64@3078L15,65@3125L32");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
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
                    ViewModel viewModel2 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(TransactionDetailsViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory2, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    composer3 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    transactionDetailsViewModel4 = (TransactionDetailsViewModel) viewModel2;
                    i3 &= -897;
                } else {
                    composer3 = composerStartRestartGroup;
                }
                if ((i2 & 8) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composer3, -1931672624, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                    zChangedInstance = composer3.changedInstance(navController);
                    objRememberedValue = composer3.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda25
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$1$lambda$0(navController);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda25
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$1$lambda$0(navController);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    function1 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    i3 &= -7169;
                }
                if (i9 != 0) {
                    function3 = function1;
                    z5 = false;
                } else {
                    z5 = z;
                    function3 = function1;
                }
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
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
                    ViewModel viewModel3 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(TransactionDetailsViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory3, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    composer3 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    transactionDetailsViewModel4 = (TransactionDetailsViewModel) viewModel3;
                    i3 &= -897;
                } else {
                    composer3 = composerStartRestartGroup;
                }
                if ((i2 & 8) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composer3, -1931672624, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                    zChangedInstance = composer3.changedInstance(navController);
                    objRememberedValue = composer3.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda25
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$1$lambda$0(navController);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda25
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$1$lambda$0(navController);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    function1 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    i3 &= -7169;
                }
                if (i9 != 0) {
                    function3 = function1;
                    z5 = false;
                } else {
                    z5 = z;
                    function3 = function1;
                }
            }
            i4 = i3;
            transactionDetailsViewModel3 = transactionDetailsViewModel4;
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1624354640, i4, -1, "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreen (TransactionDetailsScreen.kt:68)");
            }
            ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer3, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue2 = composer3.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3);
                composer3.updateRememberedValue(objRememberedValue2);
            }
            coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -1931666894, str);
            objRememberedValue3 = composer3.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer3.updateRememberedValue(objRememberedValue3);
            }
            mutableState = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            stateCollectAsState = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getDeleteState(), null, composer3, 0, 1);
            stateCollectAsState2 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getSnackbarMessage(), null, composer3, 0, 1);
            final State stateCollectAsState13 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getTransaction(), null, composer3, 0, 1);
            final State stateCollectAsState14 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getScheduledTransactions(), null, composer3, 0, 1);
            final State stateCollectAsState15 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.isRetrying(), null, composer3, 0, 1);
            final State stateCollectAsState16 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getLoadingState(), null, composer3, 0, 1);
            final State stateCollectAsState17 = SnapshotStateKt.collectAsState(transactionDetailsViewModel3.getScheduledTransactionsLoadingState(), null, composer3, 0, 1);
            deleteStateTransactionDetailsScreen$lambda$5 = TransactionDetailsScreen$lambda$5(stateCollectAsState);
            ComposerKt.sourceInformationMarkerStart(composer3, -1931647914, str);
            zChanged = composer3.changed(stateCollectAsState) | composer3.changedInstance(navController) | composer3.changedInstance(coroutineScope);
            transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue = composer3.rememberedValue();
            if (zChanged) {
                deleteState = deleteStateTransactionDetailsScreen$lambda$5;
                state = stateCollectAsState;
                mutableState2 = mutableState;
                transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue = new TransactionDetailsScreenKt$TransactionDetailsScreen$2$1(navController, coroutineScope, state, mutableState2, null);
                composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue);
            } else {
                deleteState = deleteStateTransactionDetailsScreen$lambda$5;
                state = stateCollectAsState;
                mutableState2 = mutableState;
                transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue = new TransactionDetailsScreenKt$TransactionDetailsScreen$2$1(navController, coroutineScope, state, mutableState2, null);
                composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(deleteState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionDetailsScreenKt$TransactionDetailsScreen$2$1RememberedValue, composer3, 0);
            String strTransactionDetailsScreen$lambda$8 = TransactionDetailsScreen$lambda$6(stateCollectAsState2);
            str2 = str;
            ComposerKt.sourceInformationMarkerStart(composer3, -1931637440, str2);
            boolean zChanged4 = composer3.changed(stateCollectAsState2) | composer3.changedInstance(coroutineScope);
            i5 = (i4 & 896) ^ 384;
            state2 = state;
            if (i5 > 256) {
                mutableState3 = mutableState2;
                if ((i4 & 384) != 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
            } else {
                mutableState3 = mutableState2;
                if ((i4 & 384) != 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
            }
            z7 = z6 | zChanged4;
            Object objRememberedValue8 = composer3.rememberedValue();
            if (z7) {
                continuation = null;
                transactionDetailsScreenKt$TransactionDetailsScreen$3$1 = new TransactionDetailsScreenKt$TransactionDetailsScreen$3$1(stateCollectAsState2, coroutineScope, transactionDetailsViewModel3, null);
                composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$3$1);
            } else {
                continuation = null;
                transactionDetailsScreenKt$TransactionDetailsScreen$3$1 = new TransactionDetailsScreenKt$TransactionDetailsScreen$3$1(stateCollectAsState2, coroutineScope, transactionDetailsViewModel3, null);
                composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$3$1);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(strTransactionDetailsScreen$lambda$8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionDetailsScreenKt$TransactionDetailsScreen$3$1, composer3, 0);
            ComposerKt.sourceInformationMarkerStart(composer3, -1931631641, str2);
            boolean zChangedInstance5 = composer3.changedInstance(transactionId) | ((i5 <= 256 && composer3.changedInstance(transactionDetailsViewModel3)) || (i4 & 384) == 256);
            if ((458752 & i4) == 131072) {
                z8 = true;
            } else {
                z8 = false;
            }
            z9 = zChangedInstance5 | z8;
            transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue = composer3.rememberedValue();
            if (!z9) {
                transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue = new TransactionDetailsScreenKt$TransactionDetailsScreen$4$1(transactionDetailsViewModel3, transactionId, z5, continuation);
                composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue);
            } else {
                transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue = new TransactionDetailsScreenKt$TransactionDetailsScreen$4$1(transactionDetailsViewModel3, transactionId, z5, continuation);
                composer3.updateRememberedValue(transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(transactionId, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionDetailsScreenKt$TransactionDetailsScreen$4$1RememberedValue, composer3, (i4 >> 12) & 14);
            mutableState4 = mutableState3;
            final Modifier modifier7 = modifier2;
            boolean z13 = z5;
            modifier2 = modifier7;
            transactionDetailsViewModel4 = transactionDetailsViewModel3;
            Composer composer7 = composer3;
            function1 = function3;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(1650646644, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$16(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(2131535359, true, new Function3() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$29(modifier7, stateCollectAsState16, stateCollectAsState13, transactionDetailsViewModel3, navController, transactionId, stateCollectAsState14, stateCollectAsState17, stateCollectAsState15, mutableState4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), composer7, 805306416, 509);
            composer2 = composer7;
            if (TransactionDetailsScreen$lambda$3(mutableState4)) {
                composer2.startReplaceGroup(244588818);
            } else {
                composer2.startReplaceGroup(251773905);
                ComposerKt.sourceInformation(composer2, "167@7266L28,175@7658L332,185@8020L137,169@7367L261,166@7222L945");
                ComposerKt.sourceInformationMarkerStart(composer2, -1931540116, str2);
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$31$lambda$30(mutableState4);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0((Function0) objRememberedValue4, ComposableLambdaKt.rememberComposableLambda(586940931, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$34(transactionDetailsViewModel4, state2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(351667393, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$37(mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), null, ComposableSingletons$TransactionDetailsScreenKt.INSTANCE.getLambda$116393855$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1242914, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$38(state2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, 1772598, 0, 16276);
                composer2 = composer2;
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z13;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z4 = z;
        }
        transactionDetailsViewModel2 = transactionDetailsViewModel4;
        modifier3 = modifier2;
        function2 = function1;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$39(modifier3, navController, transactionDetailsViewModel2, function2, transactionId, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean TransactionDetailsScreen$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TransactionDetailsScreen$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$16(final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C106@4686L160,106@4618L229:TransactionDetailsScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1650646644, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreen.<anonymous> (TransactionDetailsScreen.kt:106)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$TransactionDetailsScreenKt.INSTANCE.getLambda$597422896$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(980096366, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$16$lambda$15(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$16$lambda$15(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C107@4700L136:TransactionDetailsScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(980096366, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreen.<anonymous>.<anonymous> (TransactionDetailsScreen.kt:107)");
            }
            IconButtonKt.IconButton(function0, null, false, null, null, null, ComposableSingletons$TransactionDetailsScreenKt.INSTANCE.getLambda$274699920$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$29(Modifier modifier, State state, State state2, final TransactionDetailsViewModel transactionDetailsViewModel, final NavHostController navHostController, final UUID uuid, State state3, State state4, State state5, final MutableState mutableState, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)112@4882L2296:TransactionDetailsScreen.kt#jgxt63");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2131535359, i2, -1, "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreen.<anonymous> (TransactionDetailsScreen.kt:112)");
            }
            float f = 16;
            float f2 = 8;
            Modifier modifierM1119paddingVpY3zN4 = PaddingKt.m1119paddingVpY3zN4(PaddingKt.padding(modifier, paddingValues), Dp.m8684constructorimpl(f), Dp.m8684constructorimpl(f2));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
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
            ComposerKt.sourceInformationMarkerStart(composer, 325155410, "C:TransactionDetailsScreen.kt#jgxt63");
            LoadingState loadingStateTransactionDetailsScreen$lambda$10 = TransactionDetailsScreen$lambda$10(state);
            if (loadingStateTransactionDetailsScreen$lambda$10 instanceof LoadingState.Loading) {
                composer.startReplaceGroup(325171622);
                ComposerKt.sourceInformation(composer, "120@5210L107");
                ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(PaddingKt.m1118padding3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), 0L, 0.0f, 0L, 0, 0.0f, composer, 6, 62);
                composer.endReplaceGroup();
            } else if (loadingStateTransactionDetailsScreen$lambda$10 instanceof LoadingState.Failure) {
                composer.startReplaceGroup(325367170);
                ComposerKt.sourceInformation(composer, "128@5575L11,126@5402L271");
                LoadingState loadingStateTransactionDetailsScreen$lambda$11 = TransactionDetailsScreen$lambda$10(state);
                Intrinsics.checkNotNull(loadingStateTransactionDetailsScreen$lambda$11, "null cannot be cast to non-null type com.example.bingwahybrid.domain.enums.LoadingState.Failure");
                TextKt.m3864TextNvy7gAk("Failed to load transaction: " + ((LoadingState.Failure) loadingStateTransactionDetailsScreen$lambda$11).getError(), PaddingKt.m1118padding3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getError(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 48, 0, 262136);
                composer.endReplaceGroup();
            } else {
                if (!(loadingStateTransactionDetailsScreen$lambda$10 instanceof LoadingState.Success) && !Intrinsics.areEqual(loadingStateTransactionDetailsScreen$lambda$10, LoadingState.Idle.INSTANCE)) {
                    composer.startReplaceGroup(980320209);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(325772898);
                ComposerKt.sourceInformation(composer, "");
                Transaction transactionTransactionDetailsScreen$lambda$7 = TransactionDetailsScreen$lambda$7(state2);
                if (transactionTransactionDetailsScreen$lambda$7 == null) {
                    composer.startReplaceGroup(325805974);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(325805975);
                    ComposerKt.sourceInformation(composer, "*140@6188L37,141@6266L27,142@6338L361,150@6749L111,153@6903L185,135@5835L1279");
                    List<Transaction> listTransactionDetailsScreen$lambda$8 = TransactionDetailsScreen$lambda$8(state3);
                    LoadingState loadingStateTransactionDetailsScreen$lambda$12 = TransactionDetailsScreen$lambda$11(state4);
                    boolean zTransactionDetailsScreen$lambda$9 = TransactionDetailsScreen$lambda$9(state5);
                    ComposerKt.sourceInformationMarkerStart(composer, 1195813397, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                    boolean zChangedInstance = composer.changedInstance(transactionDetailsViewModel);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$29$lambda$28$lambda$27$lambda$18$lambda$17(transactionDetailsViewModel, (Transaction) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function1 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 1195815883, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$29$lambda$28$lambda$27$lambda$20$lambda$19(mutableState);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    Function0 function0 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 1195818521, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                    boolean zChangedInstance2 = composer.changedInstance(navHostController) | composer.changedInstance(uuid);
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$29$lambda$28$lambda$27$lambda$22$lambda$21(navHostController, uuid, (Transaction) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    Function1 function2 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 1195831423, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                    boolean zChangedInstance3 = composer.changedInstance(navHostController);
                    Object objRememberedValue4 = composer.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$29$lambda$28$lambda$27$lambda$24$lambda$23(navHostController, (Transaction) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function3 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 1195836425, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                    boolean zChangedInstance4 = composer.changedInstance(navHostController);
                    Object objRememberedValue5 = composer.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda24
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$29$lambda$28$lambda$27$lambda$26$lambda$25(navHostController, (Offer) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TransactionDetailsScreenContent(transactionTransactionDetailsScreen$lambda$7, listTransactionDetailsScreen$lambda$8, loadingStateTransactionDetailsScreen$lambda$12, zTransactionDetailsScreen$lambda$9, function1, function0, function2, function3, (Function1) objRememberedValue5, composer, 196608 | Transaction.$stable, 0);
                    composer.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
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
    public static final Unit TransactionDetailsScreen$lambda$29$lambda$28$lambda$27$lambda$18$lambda$17(TransactionDetailsViewModel transactionDetailsViewModel, Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        transactionDetailsViewModel.retryTransaction(it.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$29$lambda$28$lambda$27$lambda$20$lambda$19(MutableState mutableState) {
        TransactionDetailsScreen$lambda$4(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$29$lambda$28$lambda$27$lambda$22$lambda$21(NavHostController navHostController, UUID uuid, Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String name = Route.RescheduleTransaction.INSTANCE.getName();
        String string = uuid.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        NavController.navigate$default((NavController) navHostController, StringsKt.replace$default(name, "{transactionId}", string, false, 4, (Object) null), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$29$lambda$28$lambda$27$lambda$24$lambda$23(NavHostController navHostController, Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        NavController.navigate$default((NavController) navHostController, "transactions/" + it.getId(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$29$lambda$28$lambda$27$lambda$26$lambda$25(NavHostController navHostController, Offer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        NavController.navigate$default((NavController) navHostController, Route.Offers.INSTANCE.details(it.getId()), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$31$lambda$30(MutableState mutableState) {
        TransactionDetailsScreen$lambda$4(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$38(State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:TransactionDetailsScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1242914, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreen.<anonymous> (TransactionDetailsScreen.kt:170)");
            }
            if (TransactionDetailsScreen$lambda$5(state) instanceof DeleteState.Failed) {
                composer.startReplaceGroup(-1194437607);
                ComposerKt.sourceInformation(composer, "171@7451L59");
                DeleteState deleteStateTransactionDetailsScreen$lambda$5 = TransactionDetailsScreen$lambda$5(state);
                Intrinsics.checkNotNull(deleteStateTransactionDetailsScreen$lambda$5, "null cannot be cast to non-null type com.example.bingwahybrid.domain.enums.DeleteState.Failed");
                TextKt.m3864TextNvy7gAk("Error: " + ((DeleteState.Failed) deleteStateTransactionDetailsScreen$lambda$5).getError(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1194434793);
                ComposerKt.sourceInformation(composer, "172@7539L57");
                TextKt.m3864TextNvy7gAk("Are you sure you want to delete this transaction?", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$34(final TransactionDetailsViewModel transactionDetailsViewModel, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C181@7887L33,176@7676L300:TransactionDetailsScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586940931, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreen.<anonymous> (TransactionDetailsScreen.kt:176)");
            }
            boolean z = !Intrinsics.areEqual(TransactionDetailsScreen$lambda$5(state), DeleteState.Deleting.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer, 1409526276, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(transactionDetailsViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$34$lambda$33$lambda$32(transactionDetailsViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.OutlinedButton((Function0) objRememberedValue, null, z, null, null, null, null, null, null, ComposableSingletons$TransactionDetailsScreenKt.INSTANCE.m9702getLambda$1315963951$app_debug(), composer, 805306368, 506);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$34$lambda$33$lambda$32(TransactionDetailsViewModel transactionDetailsViewModel) {
        transactionDetailsViewModel.deleteTransaction();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$37(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C186@8059L28,186@8038L105:TransactionDetailsScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(351667393, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreen.<anonymous> (TransactionDetailsScreen.kt:186)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1350050435, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$37$lambda$36$lambda$35(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$TransactionDetailsScreenKt.INSTANCE.getLambda$1151417636$app_debug(), composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreen$lambda$37$lambda$36$lambda$35(MutableState mutableState) {
        TransactionDetailsScreen$lambda$4(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreenContent$lambda$41$lambda$40(Offer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:102:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:107:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:110:0x021c  */
    /* JADX WARN: Code duplicated, block: B:111:0x021f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0232  */
    /* JADX WARN: Code duplicated, block: B:125:0x0243  */
    /* JADX WARN: Code duplicated, block: B:128:0x025d  */
    /* JADX WARN: Code duplicated, block: B:129:0x0260  */
    /* JADX WARN: Code duplicated, block: B:134:0x026f  */
    /* JADX WARN: Code duplicated, block: B:137:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:142:0x02be  */
    /* JADX WARN: Code duplicated, block: B:145:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:147:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:148:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:151:0x0311  */
    /* JADX WARN: Code duplicated, block: B:153:0x0317  */
    /* JADX WARN: Code duplicated, block: B:156:0x0322  */
    /* JADX WARN: Code duplicated, block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0085  */
    /* JADX WARN: Code duplicated, block: B:35:0x008d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0090  */
    /* JADX WARN: Code duplicated, block: B:38:0x0094  */
    /* JADX WARN: Code duplicated, block: B:41:0x009a  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00df  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:79:0x0106  */
    /* JADX WARN: Code duplicated, block: B:80:0x0109  */
    /* JADX WARN: Code duplicated, block: B:83:0x0112 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x0114  */
    /* JADX WARN: Code duplicated, block: B:85:0x011b  */
    /* JADX WARN: Code duplicated, block: B:88:0x0121  */
    /* JADX WARN: Code duplicated, block: B:90:0x0133  */
    /* JADX WARN: Code duplicated, block: B:92:0x0142  */
    /* JADX WARN: Code duplicated, block: B:95:0x0149  */
    /* JADX WARN: Code duplicated, block: B:98:0x01a0  */
    public static final void TransactionDetailsScreenContent(final Transaction transaction, final List<Transaction> scheduledTransactions, LoadingState loadingState, final boolean z, final Function1<? super Transaction, Unit> onRetry, final Function0<Unit> onDelete, final Function1<? super Transaction, Unit> onReschedule, final Function1<? super Transaction, Unit> onViewTransaction, Function1<? super Offer, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        LoadingState loadingState2;
        int i4;
        Function1<? super Offer, Unit> function2;
        int i5;
        boolean z2;
        final Function1<? super Offer, Unit> function3;
        final LoadingState loadingState3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        LoadingState loadingState4;
        Function1<? super Offer, Unit> function4;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z3;
        boolean z4;
        boolean z5;
        Object objRememberedValue;
        boolean z6;
        Object objRememberedValue2;
        RescheduleInfo rescheduleInfo;
        Object objRememberedValue3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        Intrinsics.checkNotNullParameter(scheduledTransactions, "scheduledTransactions");
        Intrinsics.checkNotNullParameter(onRetry, "onRetry");
        Intrinsics.checkNotNullParameter(onDelete, "onDelete");
        Intrinsics.checkNotNullParameter(onReschedule, "onReschedule");
        Intrinsics.checkNotNullParameter(onViewTransaction, "onViewTransaction");
        Composer composerStartRestartGroup = composer.startRestartGroup(1020219795);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TransactionDetailsScreenContent)N(transaction,scheduledTransactions,scheduledTransactionsLoadingState,isRetrying,onRetry,onDelete,onReschedule,onViewTransaction,onTapOffer)205@8584L2,207@8596L750:TransactionDetailsScreen.kt#jgxt63");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(transaction) : composerStartRestartGroup.changedInstance(transaction) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(scheduledTransactions) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 == 0) {
            if ((i & 384) == 0) {
                loadingState2 = loadingState;
                i3 |= composerStartRestartGroup.changed(loadingState2) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i10 = 2048;
                } else {
                    i10 = 1024;
                }
                i3 |= i10;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onRetry)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(onDelete)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(onReschedule)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            if ((12582912 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(onViewTransaction)) {
                    i6 = 8388608;
                } else {
                    i6 = 4194304;
                }
                i3 |= i6;
            }
            i4 = i2 & 256;
            if (i4 != 0) {
                i3 |= 100663296;
                function2 = function1;
            } else {
                function2 = function1;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    } else {
                        i5 = 33554432;
                    }
                    i3 |= i5;
                }
            }
            if ((i3 & 38347923) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function3 = function2;
                loadingState3 = loadingState2;
            } else {
                if (i11 != 0) {
                    loadingState4 = LoadingState.Idle.INSTANCE;
                } else {
                    loadingState4 = loadingState2;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1178692501, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionDetailsScreenKt.TransactionDetailsScreenContent$lambda$41$lambda$40((Offer) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function1) objRememberedValue3;
                } else {
                    function4 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020219795, i3, -1, "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenContent (TransactionDetailsScreen.kt:206)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                Function1<? super Offer, Unit> function5 = function4;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1420710321, "C213@8796L29,212@8753L14,208@8613L259,223@9099L241:TransactionDetailsScreen.kt#jgxt63");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1339649114, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                if ((i3 & 3670016) == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((i3 & 14) != 4 || ((i3 & 8) != 0 && composerStartRestartGroup.changedInstance(transaction))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                z5 = z3 | z4;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionDetailsScreenKt.TransactionDetailsScreenContent$lambda$48$lambda$43$lambda$42(onReschedule, transaction, (Transaction) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function1 function6 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1339647723, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                if ((458752 & i3) == 131072) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionDetailsScreenKt.TransactionDetailsScreenContent$lambda$48$lambda$45$lambda$44(onDelete, (Transaction) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i12 = i3 >> 6;
                int i13 = i12 & 896;
                int i14 = i3;
                InfoCardKt.InfoCard(null, transaction, onRetry, z, function6, (Function1) objRememberedValue2, function5, composerStartRestartGroup, (Transaction.$stable << 3) | ((i3 << 3) & 112) | i13 | (i3 & 7168) | (3670016 & i12), 1);
                composerStartRestartGroup = composerStartRestartGroup;
                rescheduleInfo = transaction.getRescheduleInfo();
                if (rescheduleInfo == null) {
                    rescheduleInfo = null;
                } else {
                    if (!(transaction.getStatus() != TransactionStatus.RESCHEDULED && rescheduleInfo.getRescheduleMode() == RescheduleMode.ONCE)) {
                        rescheduleInfo = null;
                    }
                }
                if (rescheduleInfo == null) {
                    composerStartRestartGroup.startReplaceGroup(-1420309679);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1420309678);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*220@9056L23");
                    RescheduleText(rescheduleInfo.getTime(), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                LoadingState loadingState5 = loadingState4;
                ScheduledTransactionsSection(loadingState5, scheduledTransactions, onRetry, onViewTransaction, composerStartRestartGroup, (i12 & 14) | (i14 & 112) | i13 | ((i14 >> 12) & 7168));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                loadingState3 = loadingState5;
                function3 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreenContent$lambda$49(transaction, scheduledTransactions, loadingState3, z, onRetry, onDelete, onReschedule, onViewTransaction, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        loadingState2 = loadingState;
        if ((i & 3072) != 0) {
            if (composerStartRestartGroup.changed(z)) {
                i10 = 2048;
            } else {
                i10 = 1024;
            }
            i3 |= i10;
        }
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(onRetry)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i3 |= i9;
        }
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(onDelete)) {
                i8 = 131072;
            } else {
                i8 = 65536;
            }
            i3 |= i8;
        }
        if ((1572864 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(onReschedule)) {
                i7 = 1048576;
            } else {
                i7 = 524288;
            }
            i3 |= i7;
        }
        if ((12582912 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(onViewTransaction)) {
                i6 = 8388608;
            } else {
                i6 = 4194304;
            }
            i3 |= i6;
        }
        i4 = i2 & 256;
        if (i4 != 0) {
            i3 |= 100663296;
            function2 = function1;
        } else {
            function2 = function1;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i5 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                } else {
                    i5 = 33554432;
                }
                i3 |= i5;
            }
        }
        if ((i3 & 38347923) != 38347922) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            function3 = function2;
            loadingState3 = loadingState2;
        } else {
            if (i11 != 0) {
                loadingState4 = LoadingState.Idle.INSTANCE;
            } else {
                loadingState4 = loadingState2;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1178692501, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionDetailsScreenKt.TransactionDetailsScreenContent$lambda$41$lambda$40((Offer) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function4 = (Function1) objRememberedValue3;
            } else {
                function4 = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1020219795, i3, -1, "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenContent (TransactionDetailsScreen.kt:206)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            Function1<? super Offer, Unit> function7 = function4;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1420710321, "C213@8796L29,212@8753L14,208@8613L259,223@9099L241:TransactionDetailsScreen.kt#jgxt63");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1339649114, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
            if ((i3 & 3670016) == 1048576) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((i3 & 14) != 4) {
                z4 = true;
            } else {
                z4 = true;
            }
            z5 = z3 | z4;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreenContent$lambda$48$lambda$43$lambda$42(onReschedule, transaction, (Transaction) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreenContent$lambda$48$lambda$43$lambda$42(onReschedule, transaction, (Transaction) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function8 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1339647723, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
            if ((458752 & i3) == 131072) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreenContent$lambda$48$lambda$45$lambda$44(onDelete, (Transaction) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreenContent$lambda$48$lambda$45$lambda$44(onDelete, (Transaction) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i15 = i3 >> 6;
            int i16 = i15 & 896;
            int i17 = i3;
            InfoCardKt.InfoCard(null, transaction, onRetry, z, function8, (Function1) objRememberedValue2, function7, composerStartRestartGroup, (Transaction.$stable << 3) | ((i3 << 3) & 112) | i16 | (i3 & 7168) | (3670016 & i15), 1);
            composerStartRestartGroup = composerStartRestartGroup;
            rescheduleInfo = transaction.getRescheduleInfo();
            if (rescheduleInfo == null) {
                rescheduleInfo = null;
            } else {
                if (!(transaction.getStatus() != TransactionStatus.RESCHEDULED && rescheduleInfo.getRescheduleMode() == RescheduleMode.ONCE)) {
                    rescheduleInfo = null;
                }
            }
            if (rescheduleInfo == null) {
                composerStartRestartGroup.startReplaceGroup(-1420309679);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1420309678);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*220@9056L23");
                RescheduleText(rescheduleInfo.getTime(), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            LoadingState loadingState6 = loadingState4;
            ScheduledTransactionsSection(loadingState6, scheduledTransactions, onRetry, onViewTransaction, composerStartRestartGroup, (i15 & 14) | (i17 & 112) | i16 | ((i17 >> 12) & 7168));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            loadingState3 = loadingState6;
            function3 = function7;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TransactionDetailsScreenKt.TransactionDetailsScreenContent$lambda$49(transaction, scheduledTransactions, loadingState3, z, onRetry, onDelete, onReschedule, onViewTransaction, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreenContent$lambda$48$lambda$45$lambda$44(Function0 function0, Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreenContent$lambda$48$lambda$43$lambda$42(Function1 function1, Transaction transaction, Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(transaction);
        return Unit.INSTANCE;
    }

    private static final void RescheduleText(final long j, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1293284408);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RescheduleText)N(time)234@9407L41,235@9453L474:TransactionDetailsScreen.kt#jgxt63");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1293284408, i2, -1, "com.example.bingwahybrid.presentation.transactions.screens.RescheduleText (TransactionDetailsScreen.kt:233)");
            }
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceGroup(1600771468);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*239@9603L11,248@9822L11");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            int iPushStyle = builder.pushStyle(new SpanStyle(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65532, (DefaultConstructorMarker) null));
            try {
                builder.append("Rescheduled to ");
                Unit unit = Unit.INSTANCE;
                builder.pop(iPushStyle);
                int iPushStyle2 = builder.pushStyle(new SpanStyle(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSecondary(), TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65532, (DefaultConstructorMarker) null));
                try {
                    builder.append(TimeUtilsKt.formatDateTime(j));
                    Unit unit2 = Unit.INSTANCE;
                    builder.pop(iPushStyle2);
                    composer2 = composerStartRestartGroup;
                    AnnotatedString annotatedString = builder.toAnnotatedString();
                    composer2.endReplaceGroup();
                    TextKt.m3865TextZ58ophY(annotatedString, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, null, composer2, 0, 0, 524286);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TransactionDetailsScreenKt.RescheduleText$lambda$53(j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ScheduledTransactionsSection(final LoadingState loadingState, final List<Transaction> list, final Function1<? super Transaction, Unit> function1, final Function1<? super Transaction, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1674982975);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScheduledTransactionsSection)N(loadingState,scheduledTransactions,onRetry,onViewTransaction)263@10153L1461:TransactionDetailsScreen.kt#jgxt63");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(loadingState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1674982975, i2, -1, "com.example.bingwahybrid.presentation.transactions.screens.ScheduledTransactionsSection (TransactionDetailsScreen.kt:262)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1455273854, "C266@10220L41:TransactionDetailsScreen.kt#jgxt63");
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
            if (loadingState instanceof LoadingState.Loading) {
                composerStartRestartGroup.startReplaceGroup(-1455202245);
                ComposerKt.sourceInformation(composerStartRestartGroup, "270@10350L82");
                ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally()), 0L, 0.0f, 0L, 0, 0.0f, composerStartRestartGroup, 0, 62);
                composerStartRestartGroup.endReplaceGroup();
            } else if (loadingState instanceof LoadingState.Failure) {
                composerStartRestartGroup.startReplaceGroup(-1455043928);
                ComposerKt.sourceInformation(composerStartRestartGroup, "276@10644L11,274@10505L229");
                TextKt.m3864TextNvy7gAk("Failed to load scheduled transactions: " + ((LoadingState.Failure) loadingState).getError(), PaddingKt.m1118padding3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(8)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getError(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 48, 0, 262136);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (!(loadingState instanceof LoadingState.Success) && !Intrinsics.areEqual(loadingState, LoadingState.Idle.INSTANCE)) {
                    composerStartRestartGroup.startReplaceGroup(-1155321394);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(-1454709097);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (list.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1465456115);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1454653793);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "283@10888L22,284@10931L40,288@11159L407,285@10992L574");
                    int i3 = i2;
                    TextKt.m3864TextNvy7gAk("Rescheduled To", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                    float f = 8;
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_4 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1155293908, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(list) | ((i3 & 7168) == 2048) | ((i3 & 896) == 256);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionDetailsScreenKt.ScheduledTransactionsSection$lambda$59$lambda$58$lambda$57(list, function2, function1, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LazyDslKt.LazyColumn(modifierFillMaxWidth$default2, null, null, false, horizontalOrVerticalM977spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 24582, 494);
                    composerStartRestartGroup = composerStartRestartGroup;
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endReplaceGroup();
            }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TransactionDetailsScreenKt.ScheduledTransactionsSection$lambda$60(loadingState, list, function1, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void TransactionDetailsScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1245607431);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TransactionDetailsScreenPreview)339@12780L2,340@12803L2,341@12830L2,342@12862L2,334@12548L323:TransactionDetailsScreen.kt#jgxt63");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1245607431, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenPreview (TransactionDetailsScreen.kt:305)");
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID(...)");
            Offer offer = new Offer(uuidRandomUUID, "2GB for 2 Hours", "*188*2*1*BH*1#", 30, OfferType.DATA, null, false, null, false, false, false, false, false, 0, 0, 0L, null, false, 262112, null);
            UUID uuidRandomUUID2 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID2, "randomUUID(...)");
            Transaction transaction = new Transaction(uuidRandomUUID2, "TAJKSU7S7BT", 20, System.currentTimeMillis(), "Confirmed You have received", "Request Submitted Successfully", TransactionStatus.SCHEDULED, new Customer(1, UUID.randomUUID(), "John Doe", "012345678", 200, 0L, false, false, 224, null), offer, null, null, 0, 0, 0L, null, new RescheduleInfo(null, System.currentTimeMillis(), null, 5, null), null, 97792, null);
            List listListOf = CollectionsKt.listOf(transaction);
            LoadingState.Loading loading = LoadingState.Loading.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1267171579, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreenPreview$lambda$62$lambda$61((Transaction) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1267172315, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1267173179, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreenPreview$lambda$66$lambda$65((Transaction) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function2 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1267174203, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TransactionDetailsScreenKt.TransactionDetailsScreenPreview$lambda$68$lambda$67((Transaction) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TransactionDetailsScreenContent(transaction, listListOf, loading, true, function1, function0, function2, (Function1) objRememberedValue4, null, composerStartRestartGroup, 14380416 | Transaction.$stable | (Transaction.$stable << 3), 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TransactionDetailsScreenKt.TransactionDetailsScreenPreview$lambda$69(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreenPreview$lambda$62$lambda$61(Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreenPreview$lambda$66$lambda$65(Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionDetailsScreenPreview$lambda$68$lambda$67(Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeleteState TransactionDetailsScreen$lambda$5(State<? extends DeleteState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String TransactionDetailsScreen$lambda$6(State<String> state) {
        return state.getValue();
    }

    private static final Transaction TransactionDetailsScreen$lambda$7(State<Transaction> state) {
        return state.getValue();
    }

    private static final List<Transaction> TransactionDetailsScreen$lambda$8(State<? extends List<Transaction>> state) {
        return state.getValue();
    }

    private static final boolean TransactionDetailsScreen$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final LoadingState TransactionDetailsScreen$lambda$10(State<? extends LoadingState> state) {
        return state.getValue();
    }

    private static final LoadingState TransactionDetailsScreen$lambda$11(State<? extends LoadingState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScheduledTransactionsSection$lambda$59$lambda$58$lambda$57(final List list, final Function1 function1, final Function1 function2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final TransactionDetailsScreenKt$ScheduledTransactionsSection$lambda$59$lambda$58$lambda$57$$inlined$items$default$1 transactionDetailsScreenKt$ScheduledTransactionsSection$lambda$59$lambda$58$lambda$57$$inlined$items$default$1 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$ScheduledTransactionsSection$lambda$59$lambda$58$lambda$57$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Transaction transaction) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Transaction) obj);
            }
        };
        LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$ScheduledTransactionsSection$lambda$59$lambda$58$lambda$57$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return transactionDetailsScreenKt$ScheduledTransactionsSection$lambda$59$lambda$58$lambda$57$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$ScheduledTransactionsSection$lambda$59$lambda$58$lambda$57$$inlined$items$default$4
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
                final Transaction transaction = (Transaction) list.get(i);
                composer.startReplaceGroup(-131303229);
                ComposerKt.sourceInformation(composer, "CN(transaction)*292@11386L34,293@11464L24,290@11259L259:TransactionDetailsScreen.kt#jgxt63");
                ComposerKt.sourceInformationMarkerStart(composer, 134315583, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changedInstance(transaction);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function3 = function1;
                    objRememberedValue = (Function1) new Function1<Transaction, Unit>() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$ScheduledTransactionsSection$1$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Transaction transaction2) {
                            invoke2(transaction2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Transaction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function3.invoke(transaction);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function4 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 134318069, "CC(remember):TransactionDetailsScreen.kt#9igjgp");
                boolean zChanged2 = composer.changed(function2) | composer.changedInstance(transaction);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    final Function1 function5 = function2;
                    objRememberedValue2 = (Function1) new Function1<Transaction, Unit>() { // from class: com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$ScheduledTransactionsSection$1$1$1$1$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Transaction transaction2) {
                            invoke2(transaction2);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Transaction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function5.invoke(transaction);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ScheduledTransactionItemKt.ScheduledTransactionItem(null, transaction, function4, (Function1) objRememberedValue2, composer, Transaction.$stable << 3, 1);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }
}
