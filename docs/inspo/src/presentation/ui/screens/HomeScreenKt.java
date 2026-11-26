package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextFieldImplKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.PauseKt;
import androidx.compose.material.icons.filled.PlayArrowKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
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
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.example.bingwahybrid.domain.enums.AccountHealthStatus;
import com.example.bingwahybrid.domain.enums.AppState;
import com.example.bingwahybrid.domain.enums.LoadingState;
import com.example.bingwahybrid.domain.enums.ProcessingMode;
import com.example.bingwahybrid.domain.enums.StartupState;
import com.example.bingwahybrid.domain.enums.SubscriptionType;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.statistics.model.AgentCommission;
import com.example.bingwahybrid.domain.updates.enums.UpdateState;
import com.example.bingwahybrid.presentation.enums.StatisticsBoxType;
import com.example.bingwahybrid.presentation.navigation.Route;
import com.example.bingwahybrid.presentation.transactions.components.TransactionListKt;
import com.example.bingwahybrid.presentation.transactions.dto.TransactionSource;
import com.example.bingwahybrid.presentation.ui.components.BalanceStatisticsBoxKt;
import com.example.bingwahybrid.presentation.ui.components.DotKt;
import com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt;
import com.example.bingwahybrid.presentation.ui.components.StatisticsBoxKt;
import com.example.bingwahybrid.presentation.ui.components.StatisticsGraphKt;
import com.example.bingwahybrid.presentation.viewmodel.HomeViewModel;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HomeScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0017\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\n\u001a1\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\u0010\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u008a\u0084\u0002²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0017X\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020#X\u008a\u0084\u0002²\u0006\f\u0010$\u001a\u0004\u0018\u00010%X\u008a\u0084\u0002²\u0006\u0010\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0014X\u008a\u0084\u0002²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020+X\u008a\u0084\u0002²\u0006\n\u0010,\u001a\u00020-X\u008a\u0084\u0002²\u0006\n\u0010.\u001a\u00020\u0017X\u008a\u0084\u0002²\u0006\n\u0010/\u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u00100\u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u00101\u001a\u000202X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020!X\u008a\u0084\u0002²\u0006\f\u00105\u001a\u0004\u0018\u00010\u0017X\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u00106\u001a\u00020!X\u008a\u008e\u0002"}, d2 = {"HomeScreen", "", "navController", "Landroidx/navigation/NavHostController;", "modifier", "Landroidx/compose/ui/Modifier;", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/HomeViewModel;", "(Landroidx/navigation/NavHostController;Landroidx/compose/ui/Modifier;Lcom/example/bingwahybrid/presentation/viewmodel/HomeViewModel;Landroidx/compose/runtime/Composer;II)V", "EmptyTransactionsState", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ShowUpdateDialog", "updateState", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState;", "onUpdate", "Lkotlin/Function0;", "onDismiss", "(Lcom/example/bingwahybrid/domain/updates/enums/UpdateState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug", "transactions", "", "Lcom/example/bingwahybrid/domain/model/Transaction;", "agentFirstName", "", "greetings", "successCount", "", "failedCount", "appState", "Lcom/example/bingwahybrid/domain/enums/AppState;", "processingMode", "Lcom/example/bingwahybrid/domain/enums/ProcessingMode;", "isConnected", "", "subscriptionLimit", "", "activeSubscriptionType", "Lcom/example/bingwahybrid/domain/enums/SubscriptionType;", "agentCommissions", "Lcom/example/bingwahybrid/domain/statistics/model/AgentCommission;", "accountHealthStatus", "Lcom/example/bingwahybrid/domain/enums/AccountHealthStatus;", "startupState", "Lcom/example/bingwahybrid/domain/enums/StartupState;", "transactionsAmount", "", "airtimeBalance", "isTransactionsHidden", "isAirtimeHidden", "balanceLoadingState", "Lcom/example/bingwahybrid/domain/enums/LoadingState;", "showStopAppWarningDialog", "logoutSuccess", "snackBarMessage", "showUpdateAppDialog"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenKt {

    /* JADX INFO: compiled from: HomeScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SubscriptionType.values().length];
            try {
                iArr[SubscriptionType.UNLIMITED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SubscriptionType.LIMITED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ProcessingMode.values().length];
            try {
                iArr2[ProcessingMode.EXPRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ProcessingMode.HYBRID.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ProcessingMode.ADVANCED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyTransactionsState$lambda$86(Modifier modifier, int i, int i2, Composer composer, int i3) {
        EmptyTransactionsState(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$84(NavHostController navHostController, Modifier modifier, HomeViewModel homeViewModel, int i, int i2, Composer composer, int i3) {
        HomeScreen(navHostController, modifier, homeViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowUpdateDialog$lambda$93(UpdateState updateState, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        ShowUpdateDialog(updateState, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0301  */
    /* JADX WARN: Code duplicated, block: B:102:0x030f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0348  */
    /* JADX WARN: Code duplicated, block: B:108:0x0362  */
    /* JADX WARN: Code duplicated, block: B:110:0x0373  */
    /* JADX WARN: Code duplicated, block: B:111:0x0378  */
    /* JADX WARN: Code duplicated, block: B:113:0x0380  */
    /* JADX WARN: Code duplicated, block: B:118:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:123:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:138:0x0434  */
    /* JADX WARN: Code duplicated, block: B:141:0x0491  */
    /* JADX WARN: Code duplicated, block: B:144:0x049d  */
    /* JADX WARN: Code duplicated, block: B:145:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:150:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:163:0x0543  */
    /* JADX WARN: Code duplicated, block: B:166:0x0616  */
    /* JADX WARN: Code duplicated, block: B:169:0x0622  */
    /* JADX WARN: Code duplicated, block: B:170:0x0626  */
    /* JADX WARN: Code duplicated, block: B:175:0x0659  */
    /* JADX WARN: Code duplicated, block: B:178:0x068c  */
    /* JADX WARN: Code duplicated, block: B:180:0x06ab  */
    /* JADX WARN: Code duplicated, block: B:183:0x06cb  */
    /* JADX WARN: Code duplicated, block: B:184:0x06d6  */
    /* JADX WARN: Code duplicated, block: B:186:0x072a  */
    /* JADX WARN: Code duplicated, block: B:189:0x074c  */
    /* JADX WARN: Code duplicated, block: B:202:0x0780  */
    /* JADX WARN: Code duplicated, block: B:215:0x07c4  */
    /* JADX WARN: Code duplicated, block: B:218:0x0833  */
    /* JADX WARN: Code duplicated, block: B:220:0x0850  */
    /* JADX WARN: Code duplicated, block: B:221:0x085b  */
    /* JADX WARN: Code duplicated, block: B:223:0x08ac  */
    /* JADX WARN: Code duplicated, block: B:226:0x08bb  */
    /* JADX WARN: Code duplicated, block: B:232:0x08e0  */
    /* JADX WARN: Code duplicated, block: B:234:0x08e6 A[PHI: r4
  0x08e6: PHI (r4v34 int) = (r4v32 int), (r4v36 int) binds: [B:233:0x08e4, B:231:0x08dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:235:0x08e8  */
    /* JADX WARN: Code duplicated, block: B:238:0x08ef  */
    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:240:0x08f7  */
    /* JADX WARN: Code duplicated, block: B:243:0x090c  */
    /* JADX WARN: Code duplicated, block: B:245:0x0912  */
    /* JADX WARN: Code duplicated, block: B:251:0x091f  */
    /* JADX WARN: Code duplicated, block: B:253:0x0927  */
    /* JADX WARN: Code duplicated, block: B:255:0x0939  */
    /* JADX WARN: Code duplicated, block: B:258:0x0948  */
    /* JADX WARN: Code duplicated, block: B:25:0x004f  */
    /* JADX WARN: Code duplicated, block: B:260:0x094e  */
    /* JADX WARN: Code duplicated, block: B:263:0x0959  */
    /* JADX WARN: Code duplicated, block: B:265:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:30:0x005e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x006b  */
    /* JADX WARN: Code duplicated, block: B:36:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076  */
    /* JADX WARN: Code duplicated, block: B:48:0x009a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x009c  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00db  */
    /* JADX WARN: Code duplicated, block: B:60:0x010a  */
    /* JADX WARN: Code duplicated, block: B:62:0x0116  */
    /* JADX WARN: Code duplicated, block: B:66:0x0128  */
    /* JADX WARN: Code duplicated, block: B:69:0x0149  */
    /* JADX WARN: Code duplicated, block: B:72:0x021d  */
    /* JADX WARN: Code duplicated, block: B:73:0x021f  */
    /* JADX WARN: Code duplicated, block: B:80:0x023f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0245  */
    /* JADX WARN: Code duplicated, block: B:83:0x0247  */
    /* JADX WARN: Code duplicated, block: B:86:0x0254  */
    /* JADX WARN: Code duplicated, block: B:89:0x025a  */
    /* JADX WARN: Code duplicated, block: B:91:0x0269  */
    /* JADX WARN: Code duplicated, block: B:93:0x0273  */
    /* JADX WARN: Code duplicated, block: B:95:0x029b  */
    /* JADX WARN: Code duplicated, block: B:96:0x02c4  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r9v72 */
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
    public static final void HomeScreen(final NavHostController navController, Modifier modifier, HomeViewModel homeViewModel, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final HomeViewModel homeViewModel2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int i4;
        Composer composer2;
        int i5;
        final HomeViewModel homeViewModel3;
        int i6;
        Modifier modifier5;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Object objRememberedValue;
        CoroutineScope coroutineScope;
        State stateCollectAsState;
        final State stateCollectAsState2;
        State stateCollectAsState3;
        State stateCollectAsState4;
        State stateCollectAsState5;
        State stateCollectAsState6;
        boolean z2;
        SubscriptionType subscriptionTypeHomeScreen$lambda$9;
        int iOrdinal;
        boolean zChanged;
        Object objRememberedValue2;
        SubscriptionType subscriptionTypeHomeScreen$lambda$10;
        int i7;
        long jHomeScreen$lambda$8;
        long jHomeScreen$lambda$9;
        Object obj;
        Object objRememberedValue3;
        ?? r9;
        MutableState mutableState;
        State stateCollectAsState7;
        State stateCollectAsState8;
        State stateCollectAsState9;
        Object objRememberedValue4;
        MutableState mutableState2;
        UpdateState updateStateHomeScreen$lambda$24;
        boolean zChanged2;
        Object objRememberedValue5;
        boolean zChanged3;
        Object objRememberedValue6;
        int i8;
        boolean zChanged4;
        Object obj2;
        Object obj3;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z3;
        Object objRememberedValue7;
        int i9;
        HomeViewModel homeViewModel4;
        int iHashCode2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM5259constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        ColumnScopeInstance columnScopeInstance;
        MutableState mutableState3;
        String str;
        Object objRememberedValue8;
        boolean z4;
        Object objRememberedValue9;
        boolean z5;
        Object objRememberedValue10;
        int i10;
        boolean z6;
        Object objRememberedValue11;
        boolean z7;
        Object objRememberedValue12;
        Object objRememberedValue13;
        final MutableState mutableState4;
        Object objRememberedValue14;
        Object objRememberedValue15;
        final MutableState mutableState5;
        UpdateState updateStateHomeScreen$lambda$25;
        int i11;
        boolean zChangedInstance;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(195554073);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HomeScreen)N(navController,modifier,viewModel)77@3853L24,78@3929L16,79@3997L16,80@4055L16,81@4119L16,82@4181L16,83@4237L16,84@4305L16,85@4367L16,86@4441L16,87@4525L16,88@4597L16,89@4675L16,90@4739L16,92@4814L16,93@4882L16,94@4962L16,95@5032L16,96@5110L16,98@5152L913,122@6103L34,123@6187L16,124@6257L16,125@6319L16,126@6367L34,142@6765L324,142@6729L360,154@7124L298,154@7094L328,165@7460L144,165@7428L176,172@7610L9106:HomeScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(navController) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) != 0) {
                    i11 = 128;
                } else {
                    if ((i & 512) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(homeViewModel);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(homeViewModel);
                    }
                    if (zChangedInstance) {
                        i11 = 256;
                    } else {
                        i11 = 128;
                    }
                }
                i3 |= i11;
            }
            if ((i3 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@3816L15");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
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
                        int i13 = i3;
                        i4 = 0;
                        ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(HomeViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        i6 = i13 & (-897);
                        homeViewModel3 = (HomeViewModel) viewModel;
                        i5 = 1;
                    } else {
                        i4 = 0;
                        composer2 = composerStartRestartGroup;
                        int i14 = i3;
                        i5 = 1;
                        homeViewModel3 = homeViewModel;
                        i6 = i14;
                    }
                    modifier5 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    homeViewModel3 = homeViewModel;
                    modifier5 = modifier2;
                    i4 = 0;
                    composer2 = composerStartRestartGroup;
                    i6 = i3;
                    i5 = 1;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(195554073, i6, -1, "com.example.bingwahybrid.presentation.ui.screens.HomeScreen (HomeScreen.kt:76)");
                }
                ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composer2, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composer2.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                    composer2.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                final State stateCollectAsState10 = SnapshotStateKt.collectAsState(homeViewModel3.getLiveTransactions(), null, composer2, i4, i5);
                stateCollectAsState = SnapshotStateKt.collectAsState(homeViewModel3.getAgentFirstName(), null, composer2, i4, i5);
                State stateCollectAsState11 = SnapshotStateKt.collectAsState(homeViewModel3.getGreetings(), null, composer2, i4, i5);
                final State stateCollectAsState12 = SnapshotStateKt.collectAsState(homeViewModel3.getSuccessCount(), null, composer2, i4, i5);
                final State stateCollectAsState13 = SnapshotStateKt.collectAsState(homeViewModel3.getFailedCount(), null, composer2, i4, i5);
                stateCollectAsState2 = SnapshotStateKt.collectAsState(homeViewModel3.getAppState(), null, composer2, i4, i5);
                final State stateCollectAsState14 = SnapshotStateKt.collectAsState(homeViewModel3.getProcessingMode(), null, composer2, i4, i5);
                final State stateCollectAsState15 = SnapshotStateKt.collectAsState(homeViewModel3.isConnected(), null, composer2, i4, i5);
                stateCollectAsState3 = SnapshotStateKt.collectAsState(homeViewModel3.getSubscriptionLimit(), null, composer2, i4, i5);
                stateCollectAsState4 = SnapshotStateKt.collectAsState(homeViewModel3.getActiveSubscriptionType(), null, composer2, i4, i5);
                final State stateCollectAsState16 = SnapshotStateKt.collectAsState(homeViewModel3.m9982getAgentCommissions(), null, composer2, i4, i5);
                stateCollectAsState5 = SnapshotStateKt.collectAsState(homeViewModel3.getAccountHealthStatus(), null, composer2, i4, i5);
                final State stateCollectAsState17 = SnapshotStateKt.collectAsState(homeViewModel3.getStartupState(), null, composer2, i4, i5);
                final State stateCollectAsState18 = SnapshotStateKt.collectAsState(homeViewModel3.getAirtimeUsedToday(), null, composer2, i4, i5);
                final State stateCollectAsState19 = SnapshotStateKt.collectAsState(homeViewModel3.getAirtimeBalance(), null, composer2, i4, i5);
                final State stateCollectAsState20 = SnapshotStateKt.collectAsState(homeViewModel3.isTransactionsHidden(), null, composer2, i4, i5);
                final State stateCollectAsState21 = SnapshotStateKt.collectAsState(homeViewModel3.isAirtimeHidden(), null, composer2, i4, i5);
                stateCollectAsState6 = SnapshotStateKt.collectAsState(homeViewModel3.getBalanceLoadingState(), null, composer2, i4, i5);
                z2 = i4;
                long jHomeScreen$lambda$10 = HomeScreen$lambda$8(stateCollectAsState3);
                subscriptionTypeHomeScreen$lambda$9 = HomeScreen$lambda$9(stateCollectAsState4);
                ComposerKt.sourceInformationMarkerStart(composer2, -1051048982, "CC(remember):HomeScreen.kt#9igjgp");
                boolean zChanged5 = composer2.changed(jHomeScreen$lambda$10);
                if (subscriptionTypeHomeScreen$lambda$9 == null) {
                    iOrdinal = -1;
                } else {
                    iOrdinal = subscriptionTypeHomeScreen$lambda$9.ordinal();
                }
                zChanged = zChanged5 | composer2.changed(iOrdinal);
                objRememberedValue2 = composer2.rememberedValue();
                if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    subscriptionTypeHomeScreen$lambda$10 = HomeScreen$lambda$9(stateCollectAsState4);
                    if (subscriptionTypeHomeScreen$lambda$10 == null) {
                        i7 = -1;
                    } else {
                        i7 = WhenMappings.$EnumSwitchMapping$0[subscriptionTypeHomeScreen$lambda$10.ordinal()];
                    }
                    objRememberedValue2 = "Expired";
                    if (i7 != 1) {
                        if (i7 == 2) {
                            objRememberedValue2 = String.valueOf(HomeScreen$lambda$8(stateCollectAsState3));
                        }
                        stateCollectAsState = stateCollectAsState;
                        composer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        if (HomeScreen$lambda$8(stateCollectAsState3) > 0) {
                            stateCollectAsState6 = stateCollectAsState6;
                            jHomeScreen$lambda$8 = HomeScreen$lambda$8(stateCollectAsState3) / ((long) 3600000);
                            jHomeScreen$lambda$9 = (HomeScreen$lambda$8(stateCollectAsState3) / ((long) 60000)) % ((long) 60);
                            if (jHomeScreen$lambda$8 >= 24) {
                                long j = 24;
                                long j2 = jHomeScreen$lambda$8 / j;
                                long j3 = jHomeScreen$lambda$8 % j;
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                obj = String.format(Locale.getDefault(), "%dd %02dh", Arrays.copyOf(new Object[]{Long.valueOf(j2), Long.valueOf(j3)}, 2));
                                Intrinsics.checkNotNullExpressionValue(obj, "format(...)");
                            } else {
                                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                                obj = String.format(Locale.getDefault(), "%02dh %02dmin", Arrays.copyOf(new Object[]{Long.valueOf(jHomeScreen$lambda$8), Long.valueOf(jHomeScreen$lambda$9)}, 2));
                                Intrinsics.checkNotNullExpressionValue(obj, "format(...)");
                            }
                            objRememberedValue2 = obj;
                        }
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    stateCollectAsState = stateCollectAsState;
                    composer2.updateRememberedValue(objRememberedValue2);
                } else {
                    stateCollectAsState6 = stateCollectAsState6;
                    stateCollectAsState = stateCollectAsState;
                }
                final String str2 = (String) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1051019429, "CC(remember):HomeScreen.kt#9igjgp");
                objRememberedValue3 = composer2.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    r9 = 0;
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    r9 = 0;
                }
                mutableState = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                stateCollectAsState7 = SnapshotStateKt.collectAsState(homeViewModel3.getLogoutSuccess(), r9, composer2, z2 ? 1 : 0, 1);
                stateCollectAsState8 = SnapshotStateKt.collectAsState(homeViewModel3.getSnackBarMessage(), r9, composer2, z2 ? 1 : 0, 1);
                stateCollectAsState9 = SnapshotStateKt.collectAsState(homeViewModel3.getUpdateState(), r9, composer2, z2 ? 1 : 0, 1);
                ComposerKt.sourceInformationMarkerStart(composer2, -1051010981, "CC(remember):HomeScreen.kt#9igjgp");
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), r9, 2, r9);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                mutableState2 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                updateStateHomeScreen$lambda$24 = HomeScreen$lambda$24(stateCollectAsState9);
                if (updateStateHomeScreen$lambda$24 instanceof UpdateState.UpdateRequired) {
                    updateStateHomeScreen$lambda$25 = HomeScreen$lambda$24(stateCollectAsState9);
                    Intrinsics.checkNotNull(updateStateHomeScreen$lambda$25, "null cannot be cast to non-null type com.example.bingwahybrid.domain.updates.enums.UpdateState.UpdateRequired");
                    if (((UpdateState.UpdateRequired) updateStateHomeScreen$lambda$25).isMandatory()) {
                        HomeScreen$lambda$27(mutableState2, true);
                    }
                } else if (Intrinsics.areEqual(updateStateHomeScreen$lambda$24, UpdateState.UpToDate.INSTANCE)) {
                    HomeScreen$lambda$27(mutableState2, false);
                }
                AccountHealthStatus accountHealthStatusHomeScreen$lambda$11 = HomeScreen$lambda$11(stateCollectAsState5);
                ComposerKt.sourceInformationMarkerStart(composer2, -1050997955, "CC(remember):HomeScreen.kt#9igjgp");
                zChanged2 = composer2.changed(stateCollectAsState5) | composer2.changedInstance(navController);
                objRememberedValue5 = composer2.rememberedValue();
                if (!zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function2) new HomeScreenKt$HomeScreen$1$1(navController, stateCollectAsState5, null);
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(accountHealthStatusHomeScreen$lambda$11, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue5, composer2, 0);
                Boolean boolValueOf = Boolean.valueOf(HomeScreen$lambda$22(stateCollectAsState7));
                ComposerKt.sourceInformationMarkerStart(composer2, -1050986493, "CC(remember):HomeScreen.kt#9igjgp");
                zChanged3 = composer2.changed(stateCollectAsState7) | composer2.changedInstance(coroutineScope) | composer2.changedInstance(navController);
                objRememberedValue6 = composer2.rememberedValue();
                if (!zChanged3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = (Function2) new HomeScreenKt$HomeScreen$2$1(coroutineScope, stateCollectAsState7, navController, null);
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composer2, 0);
                String strHomeScreen$lambda$23 = HomeScreen$lambda$23(stateCollectAsState8);
                ComposerKt.sourceInformationMarkerStart(composer2, -1050975895, "CC(remember):HomeScreen.kt#9igjgp");
                i8 = (i6 & 896) ^ 384;
                zChanged4 = composer2.changed(stateCollectAsState8) | composer2.changedInstance(coroutineScope) | ((i8 <= 256 && composer2.changedInstance(homeViewModel3)) || (i6 & 384) == 256);
                Object objRememberedValue16 = composer2.rememberedValue();
                if (!zChanged4 || objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    obj2 = null;
                    obj3 = (Function2) new HomeScreenKt$HomeScreen$3$1(stateCollectAsState8, coroutineScope, homeViewModel3, null);
                    composer2.updateRememberedValue(obj3);
                } else {
                    obj3 = objRememberedValue16;
                    obj2 = null;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(strHomeScreen$lambda$23, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) obj3, composer2, 0);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier5, 0.0f, 1, obj2);
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                final Modifier modifier6 = modifier5;
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM5259constructorimpl = Updater.m5259constructorimpl(composer2);
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 759472208, "C180@7856L26,181@7893L6789,176@7686L6996,341@14692L2018:HomeScreen.kt#oif8tm");
                String str3 = HomeScreen$lambda$2(stateCollectAsState11) + ",";
                String strValueOf = String.valueOf(HomeScreen$lambda$1(stateCollectAsState));
                ComposerKt.sourceInformationMarkerStart(composer2, -391146451, "CC(remember):HomeScreen.kt#9igjgp");
                z3 = (i8 <= 256 && composer2.changedInstance(homeViewModel3)) || (i6 & 384) == 256;
                objRememberedValue7 = composer2.rememberedValue();
                if (!z3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenKt.HomeScreen$lambda$71$lambda$32$lambda$31(homeViewModel3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                final State state = stateCollectAsState6;
                i9 = i6;
                Function2 function2 = new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj4, Object obj5) {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$58(modifier6, homeViewModel3, navController, stateCollectAsState14, stateCollectAsState15, str2, stateCollectAsState12, stateCollectAsState13, stateCollectAsState18, stateCollectAsState19, stateCollectAsState20, stateCollectAsState21, state, stateCollectAsState16, stateCollectAsState10, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                };
                homeViewModel4 = homeViewModel3;
                composerStartRestartGroup = composer2;
                DrawerScaffoldScreenKt.DrawerScaffoldScreen(navController, str3, strValueOf, (Function0) objRememberedValue7, ComposableLambdaKt.rememberComposableLambda(1421228015, true, function2, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 14) | 24576, 0);
                Modifier modifierM1122paddingqDBjuR0$default = PaddingKt.m1122paddingqDBjuR0$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd()), 0.0f, 0.0f, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(32), 3, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1122paddingqDBjuR0$default);
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
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1473513743, "C365@15580L2,366@15614L66,371@15842L32,373@15956L743,364@15523L1176:HomeScreen.kt#oif8tm");
                if (HomeScreen$lambda$5(stateCollectAsState2) == AppState.STATE_PAUSED) {
                    homeViewModel2 = homeViewModel4;
                    mutableState3 = mutableState;
                    str = "CC(remember):HomeScreen.kt#9igjgp";
                    composerStartRestartGroup.startReplaceGroup(-1488307099);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1473513155);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "348@14972L2,349@15010L79,347@14911L525,361@15454L41");
                    str = "CC(remember):HomeScreen.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -601720097, str);
                    objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue14 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                    }
                    Function0 function0 = (Function0) objRememberedValue14;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -601718804, str);
                    objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue15 == Composer.INSTANCE.getEmpty()) {
                        mutableState5 = mutableState;
                        objRememberedValue15 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HomeScreenKt.HomeScreen$lambda$71$lambda$70$lambda$62$lambda$61(mutableState5);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                    } else {
                        mutableState5 = mutableState;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableState3 = mutableState5;
                    homeViewModel2 = homeViewModel4;
                    LongPressFloatingActionButtonKt.m9774LongPressFloatingActionButton8r3B23s(function0, (Function0) objRememberedValue15, columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally()), Color.INSTANCE.m5975getTransparent0d7_KjU(), 0L, null, false, ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$213007007$app_debug(), composerStartRestartGroup, 12586038, 112);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(12)), composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -601700641, str);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                Function0 function1 = (Function0) objRememberedValue8;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -601699489, str);
                z4 = (i8 <= 256 && composerStartRestartGroup.changedInstance(homeViewModel2)) || (i9 & 384) == 256;
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (!z4 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue9 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenKt.HomeScreen$lambda$71$lambda$70$lambda$66$lambda$65(homeViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                Function0 function3 = (Function0) objRememberedValue9;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierAlign = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
                long jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -601692227, str);
                z5 = (i8 <= 256 && composerStartRestartGroup.changedInstance(homeViewModel2)) || (i9 & 384) == 256;
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (!z5 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue10 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenKt.HomeScreen$lambda$71$lambda$70$lambda$68$lambda$67(homeViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LongPressFloatingActionButtonKt.m9774LongPressFloatingActionButton8r3B23s(function1, function3, modifierAlign, jM5975getTransparent0d7_KjU, 0L, (Function0) objRememberedValue10, HomeScreen$lambda$12(stateCollectAsState17) instanceof StartupState.Error, ComposableLambdaKt.rememberComposableLambda(1352195546, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj4, Object obj5) {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$70$lambda$69(stateCollectAsState17, stateCollectAsState2, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12585990, 16);
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
                if (HomeScreen$lambda$20(mutableState3)) {
                    composerStartRestartGroup.startReplaceGroup(1772079849);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1788721145);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "395@16806L36,398@17048L226,406@17304L152,394@16762L704");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1050676931, str);
                    objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                        mutableState4 = mutableState3;
                        objRememberedValue13 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HomeScreenKt.HomeScreen$lambda$73$lambda$72(mutableState4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                    } else {
                        mutableState4 = mutableState3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0((Function0) objRememberedValue13, ComposableLambdaKt.rememberComposableLambda(-1878607962, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj4, Object obj5) {
                            return HomeScreenKt.HomeScreen$lambda$76(homeViewModel2, mutableState4, (Composer) obj4, ((Integer) obj5).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-474738776, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj4, Object obj5) {
                            return HomeScreenKt.HomeScreen$lambda$79(mutableState4, (Composer) obj4, ((Integer) obj5).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$929130410$app_debug(), ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$1631065003$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, 1772598, 0, 16276);
                    composerStartRestartGroup = composerStartRestartGroup;
                }
                composerStartRestartGroup.endReplaceGroup();
                if (HomeScreen$lambda$26(mutableState2)) {
                    composerStartRestartGroup.startReplaceGroup(1772079849);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1789449800);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "418@17655L25,417@17594L36,415@17513L177");
                    UpdateState updateStateHomeScreen$lambda$26 = HomeScreen$lambda$24(stateCollectAsState9);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1050649774, str);
                    if (i8 > 256 || !composerStartRestartGroup.changedInstance(homeViewModel2)) {
                        i10 = i9;
                        if ((i10 & 384) != 256) {
                            z6 = false;
                        }
                        objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                        if (!z6 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue11 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HomeScreenKt.HomeScreen$lambda$81$lambda$80(homeViewModel2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                        }
                        Function0 function4 = (Function0) objRememberedValue11;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1050651715, str);
                        z7 = (i8 <= 256 && composerStartRestartGroup.changedInstance(homeViewModel2)) || (i10 & 384) == 256;
                        objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                        if (!z7 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue12 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HomeScreenKt.HomeScreen$lambda$83$lambda$82(homeViewModel2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ShowUpdateDialog(updateStateHomeScreen$lambda$26, function4, (Function0) objRememberedValue12, composerStartRestartGroup, 0);
                    } else {
                        i10 = i9;
                    }
                    z6 = true;
                    objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue11 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HomeScreenKt.HomeScreen$lambda$81$lambda$80(homeViewModel2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HomeScreenKt.HomeScreen$lambda$81$lambda$80(homeViewModel2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    Function0 function5 = (Function0) objRememberedValue11;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1050651715, str);
                    if (i8 <= 256) {
                    }
                    objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue12 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HomeScreenKt.HomeScreen$lambda$83$lambda$82(homeViewModel2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                    } else {
                        objRememberedValue12 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HomeScreenKt.HomeScreen$lambda$83$lambda$82(homeViewModel2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ShowUpdateDialog(updateStateHomeScreen$lambda$26, function5, (Function0) objRememberedValue12, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                homeViewModel2 = homeViewModel;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj4, Object obj5) {
                        return HomeScreenKt.HomeScreen$lambda$84(navController, modifier3, homeViewModel2, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i11 = 128;
            } else {
                if ((i & 512) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(homeViewModel);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(homeViewModel);
                }
                if (zChangedInstance) {
                    i11 = 256;
                } else {
                    i11 = 128;
                }
            }
            i3 |= i11;
        }
        if ((i3 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "75@3816L15");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
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
                    int i15 = i3;
                    i4 = 0;
                    ViewModel viewModel2 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(HomeViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory2, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    i6 = i15 & (-897);
                    homeViewModel3 = (HomeViewModel) viewModel2;
                    i5 = 1;
                } else {
                    i4 = 0;
                    composer2 = composerStartRestartGroup;
                    int i16 = i3;
                    i5 = 1;
                    homeViewModel3 = homeViewModel;
                    i6 = i16;
                }
                modifier5 = modifier4;
            } else {
                if (i12 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
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
                    int i17 = i3;
                    i4 = 0;
                    ViewModel viewModel3 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(HomeViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory3, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    i6 = i17 & (-897);
                    homeViewModel3 = (HomeViewModel) viewModel3;
                    i5 = 1;
                } else {
                    i4 = 0;
                    composer2 = composerStartRestartGroup;
                    int i18 = i3;
                    i5 = 1;
                    homeViewModel3 = homeViewModel;
                    i6 = i18;
                }
                modifier5 = modifier4;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(195554073, i6, -1, "com.example.bingwahybrid.presentation.ui.screens.HomeScreen (HomeScreen.kt:76)");
            }
            ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer2, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                composer2.updateRememberedValue(objRememberedValue);
            }
            coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            final State stateCollectAsState110 = SnapshotStateKt.collectAsState(homeViewModel3.getLiveTransactions(), null, composer2, i4, i5);
            stateCollectAsState = SnapshotStateKt.collectAsState(homeViewModel3.getAgentFirstName(), null, composer2, i4, i5);
            State stateCollectAsState111 = SnapshotStateKt.collectAsState(homeViewModel3.getGreetings(), null, composer2, i4, i5);
            final State stateCollectAsState112 = SnapshotStateKt.collectAsState(homeViewModel3.getSuccessCount(), null, composer2, i4, i5);
            final State stateCollectAsState113 = SnapshotStateKt.collectAsState(homeViewModel3.getFailedCount(), null, composer2, i4, i5);
            stateCollectAsState2 = SnapshotStateKt.collectAsState(homeViewModel3.getAppState(), null, composer2, i4, i5);
            final State stateCollectAsState114 = SnapshotStateKt.collectAsState(homeViewModel3.getProcessingMode(), null, composer2, i4, i5);
            final State stateCollectAsState115 = SnapshotStateKt.collectAsState(homeViewModel3.isConnected(), null, composer2, i4, i5);
            stateCollectAsState3 = SnapshotStateKt.collectAsState(homeViewModel3.getSubscriptionLimit(), null, composer2, i4, i5);
            stateCollectAsState4 = SnapshotStateKt.collectAsState(homeViewModel3.getActiveSubscriptionType(), null, composer2, i4, i5);
            final State stateCollectAsState116 = SnapshotStateKt.collectAsState(homeViewModel3.m9982getAgentCommissions(), null, composer2, i4, i5);
            stateCollectAsState5 = SnapshotStateKt.collectAsState(homeViewModel3.getAccountHealthStatus(), null, composer2, i4, i5);
            final State stateCollectAsState117 = SnapshotStateKt.collectAsState(homeViewModel3.getStartupState(), null, composer2, i4, i5);
            final State stateCollectAsState118 = SnapshotStateKt.collectAsState(homeViewModel3.getAirtimeUsedToday(), null, composer2, i4, i5);
            final State stateCollectAsState119 = SnapshotStateKt.collectAsState(homeViewModel3.getAirtimeBalance(), null, composer2, i4, i5);
            final State stateCollectAsState22 = SnapshotStateKt.collectAsState(homeViewModel3.isTransactionsHidden(), null, composer2, i4, i5);
            final State stateCollectAsState23 = SnapshotStateKt.collectAsState(homeViewModel3.isAirtimeHidden(), null, composer2, i4, i5);
            stateCollectAsState6 = SnapshotStateKt.collectAsState(homeViewModel3.getBalanceLoadingState(), null, composer2, i4, i5);
            z2 = i4;
            long jHomeScreen$lambda$11 = HomeScreen$lambda$8(stateCollectAsState3);
            subscriptionTypeHomeScreen$lambda$9 = HomeScreen$lambda$9(stateCollectAsState4);
            ComposerKt.sourceInformationMarkerStart(composer2, -1051048982, "CC(remember):HomeScreen.kt#9igjgp");
            boolean zChanged6 = composer2.changed(jHomeScreen$lambda$11);
            if (subscriptionTypeHomeScreen$lambda$9 == null) {
                iOrdinal = -1;
            } else {
                iOrdinal = subscriptionTypeHomeScreen$lambda$9.ordinal();
            }
            zChanged = zChanged6 | composer2.changed(iOrdinal);
            objRememberedValue2 = composer2.rememberedValue();
            if (zChanged) {
                subscriptionTypeHomeScreen$lambda$10 = HomeScreen$lambda$9(stateCollectAsState4);
                if (subscriptionTypeHomeScreen$lambda$10 == null) {
                    i7 = -1;
                } else {
                    i7 = WhenMappings.$EnumSwitchMapping$0[subscriptionTypeHomeScreen$lambda$10.ordinal()];
                }
                objRememberedValue2 = "Expired";
                if (i7 != 1) {
                    if (i7 == 2) {
                        objRememberedValue2 = String.valueOf(HomeScreen$lambda$8(stateCollectAsState3));
                    }
                    stateCollectAsState = stateCollectAsState;
                    composer2.updateRememberedValue(objRememberedValue2);
                } else {
                    if (HomeScreen$lambda$8(stateCollectAsState3) > 0) {
                        stateCollectAsState6 = stateCollectAsState6;
                        jHomeScreen$lambda$8 = HomeScreen$lambda$8(stateCollectAsState3) / ((long) 3600000);
                        jHomeScreen$lambda$9 = (HomeScreen$lambda$8(stateCollectAsState3) / ((long) 60000)) % ((long) 60);
                        if (jHomeScreen$lambda$8 >= 24) {
                            long j4 = 24;
                            long j5 = jHomeScreen$lambda$8 / j4;
                            long j6 = jHomeScreen$lambda$8 % j4;
                            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                            obj = String.format(Locale.getDefault(), "%dd %02dh", Arrays.copyOf(new Object[]{Long.valueOf(j5), Long.valueOf(j6)}, 2));
                            Intrinsics.checkNotNullExpressionValue(obj, "format(...)");
                        } else {
                            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                            obj = String.format(Locale.getDefault(), "%02dh %02dmin", Arrays.copyOf(new Object[]{Long.valueOf(jHomeScreen$lambda$8), Long.valueOf(jHomeScreen$lambda$9)}, 2));
                            Intrinsics.checkNotNullExpressionValue(obj, "format(...)");
                        }
                        objRememberedValue2 = obj;
                    }
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                stateCollectAsState = stateCollectAsState;
                composer2.updateRememberedValue(objRememberedValue2);
            } else {
                subscriptionTypeHomeScreen$lambda$10 = HomeScreen$lambda$9(stateCollectAsState4);
                if (subscriptionTypeHomeScreen$lambda$10 == null) {
                    i7 = -1;
                } else {
                    i7 = WhenMappings.$EnumSwitchMapping$0[subscriptionTypeHomeScreen$lambda$10.ordinal()];
                }
                objRememberedValue2 = "Expired";
                if (i7 != 1) {
                    if (i7 == 2) {
                        objRememberedValue2 = String.valueOf(HomeScreen$lambda$8(stateCollectAsState3));
                    }
                    stateCollectAsState = stateCollectAsState;
                    composer2.updateRememberedValue(objRememberedValue2);
                } else {
                    if (HomeScreen$lambda$8(stateCollectAsState3) > 0) {
                        stateCollectAsState6 = stateCollectAsState6;
                        jHomeScreen$lambda$8 = HomeScreen$lambda$8(stateCollectAsState3) / ((long) 3600000);
                        jHomeScreen$lambda$9 = (HomeScreen$lambda$8(stateCollectAsState3) / ((long) 60000)) % ((long) 60);
                        if (jHomeScreen$lambda$8 >= 24) {
                            long j7 = 24;
                            long j8 = jHomeScreen$lambda$8 / j7;
                            long j9 = jHomeScreen$lambda$8 % j7;
                            StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                            obj = String.format(Locale.getDefault(), "%dd %02dh", Arrays.copyOf(new Object[]{Long.valueOf(j8), Long.valueOf(j9)}, 2));
                            Intrinsics.checkNotNullExpressionValue(obj, "format(...)");
                        } else {
                            StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
                            obj = String.format(Locale.getDefault(), "%02dh %02dmin", Arrays.copyOf(new Object[]{Long.valueOf(jHomeScreen$lambda$8), Long.valueOf(jHomeScreen$lambda$9)}, 2));
                            Intrinsics.checkNotNullExpressionValue(obj, "format(...)");
                        }
                        objRememberedValue2 = obj;
                    }
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                stateCollectAsState = stateCollectAsState;
                composer2.updateRememberedValue(objRememberedValue2);
            }
            final String str4 = (String) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -1051019429, "CC(remember):HomeScreen.kt#9igjgp");
            objRememberedValue3 = composer2.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                r9 = 0;
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                r9 = 0;
            }
            mutableState = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            stateCollectAsState7 = SnapshotStateKt.collectAsState(homeViewModel3.getLogoutSuccess(), r9, composer2, z2 ? 1 : 0, 1);
            stateCollectAsState8 = SnapshotStateKt.collectAsState(homeViewModel3.getSnackBarMessage(), r9, composer2, z2 ? 1 : 0, 1);
            stateCollectAsState9 = SnapshotStateKt.collectAsState(homeViewModel3.getUpdateState(), r9, composer2, z2 ? 1 : 0, 1);
            ComposerKt.sourceInformationMarkerStart(composer2, -1051010981, "CC(remember):HomeScreen.kt#9igjgp");
            objRememberedValue4 = composer2.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), r9, 2, r9);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            mutableState2 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            updateStateHomeScreen$lambda$24 = HomeScreen$lambda$24(stateCollectAsState9);
            if (updateStateHomeScreen$lambda$24 instanceof UpdateState.UpdateRequired) {
                updateStateHomeScreen$lambda$25 = HomeScreen$lambda$24(stateCollectAsState9);
                Intrinsics.checkNotNull(updateStateHomeScreen$lambda$25, "null cannot be cast to non-null type com.example.bingwahybrid.domain.updates.enums.UpdateState.UpdateRequired");
                if (((UpdateState.UpdateRequired) updateStateHomeScreen$lambda$25).isMandatory()) {
                    HomeScreen$lambda$27(mutableState2, true);
                }
            } else if (Intrinsics.areEqual(updateStateHomeScreen$lambda$24, UpdateState.UpToDate.INSTANCE)) {
                HomeScreen$lambda$27(mutableState2, false);
            }
            AccountHealthStatus accountHealthStatusHomeScreen$lambda$12 = HomeScreen$lambda$11(stateCollectAsState5);
            ComposerKt.sourceInformationMarkerStart(composer2, -1050997955, "CC(remember):HomeScreen.kt#9igjgp");
            zChanged2 = composer2.changed(stateCollectAsState5) | composer2.changedInstance(navController);
            objRememberedValue5 = composer2.rememberedValue();
            if (!zChanged2) {
                objRememberedValue5 = (Function2) new HomeScreenKt$HomeScreen$1$1(navController, stateCollectAsState5, null);
                composer2.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = (Function2) new HomeScreenKt$HomeScreen$1$1(navController, stateCollectAsState5, null);
                composer2.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(accountHealthStatusHomeScreen$lambda$12, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue5, composer2, 0);
            Boolean boolValueOf2 = Boolean.valueOf(HomeScreen$lambda$22(stateCollectAsState7));
            ComposerKt.sourceInformationMarkerStart(composer2, -1050986493, "CC(remember):HomeScreen.kt#9igjgp");
            zChanged3 = composer2.changed(stateCollectAsState7) | composer2.changedInstance(coroutineScope) | composer2.changedInstance(navController);
            objRememberedValue6 = composer2.rememberedValue();
            if (!zChanged3) {
                objRememberedValue6 = (Function2) new HomeScreenKt$HomeScreen$2$1(coroutineScope, stateCollectAsState7, navController, null);
                composer2.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = (Function2) new HomeScreenKt$HomeScreen$2$1(coroutineScope, stateCollectAsState7, navController, null);
                composer2.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composer2, 0);
            String strHomeScreen$lambda$24 = HomeScreen$lambda$23(stateCollectAsState8);
            ComposerKt.sourceInformationMarkerStart(composer2, -1050975895, "CC(remember):HomeScreen.kt#9igjgp");
            i8 = (i6 & 896) ^ 384;
            zChanged4 = composer2.changed(stateCollectAsState8) | composer2.changedInstance(coroutineScope) | ((i8 <= 256 && composer2.changedInstance(homeViewModel3)) || (i6 & 384) == 256);
            Object objRememberedValue17 = composer2.rememberedValue();
            if (zChanged4) {
                obj2 = null;
                obj3 = (Function2) new HomeScreenKt$HomeScreen$3$1(stateCollectAsState8, coroutineScope, homeViewModel3, null);
                composer2.updateRememberedValue(obj3);
            } else {
                obj2 = null;
                obj3 = (Function2) new HomeScreenKt$HomeScreen$3$1(stateCollectAsState8, coroutineScope, homeViewModel3, null);
                composer2.updateRememberedValue(obj3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(strHomeScreen$lambda$24, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) obj3, composer2, 0);
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier5, 0.0f, 1, obj2);
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            final Modifier modifier7 = modifier5;
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composerM5259constructorimpl = Updater.m5259constructorimpl(composer2);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 759472208, "C180@7856L26,181@7893L6789,176@7686L6996,341@14692L2018:HomeScreen.kt#oif8tm");
            String str5 = HomeScreen$lambda$2(stateCollectAsState111) + ",";
            String strValueOf2 = String.valueOf(HomeScreen$lambda$1(stateCollectAsState));
            ComposerKt.sourceInformationMarkerStart(composer2, -391146451, "CC(remember):HomeScreen.kt#9igjgp");
            if (i8 <= 256) {
            }
            objRememberedValue7 = composer2.rememberedValue();
            if (!z3) {
                objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$32$lambda$31(homeViewModel3);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$32$lambda$31(homeViewModel3);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            final State state2 = stateCollectAsState6;
            i9 = i6;
            Function2 function6 = new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return HomeScreenKt.HomeScreen$lambda$71$lambda$58(modifier7, homeViewModel3, navController, stateCollectAsState114, stateCollectAsState115, str4, stateCollectAsState112, stateCollectAsState113, stateCollectAsState118, stateCollectAsState119, stateCollectAsState22, stateCollectAsState23, state2, stateCollectAsState116, stateCollectAsState110, (Composer) obj4, ((Integer) obj5).intValue());
                }
            };
            homeViewModel4 = homeViewModel3;
            composerStartRestartGroup = composer2;
            DrawerScaffoldScreenKt.DrawerScaffoldScreen(navController, str5, strValueOf2, (Function0) objRememberedValue7, ComposableLambdaKt.rememberComposableLambda(1421228015, true, function6, composerStartRestartGroup, 54), composerStartRestartGroup, (i9 & 14) | 24576, 0);
            Modifier modifierM1122paddingqDBjuR0$default2 = PaddingKt.m1122paddingqDBjuR0$default(boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd()), 0.0f, 0.0f, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(32), 3, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1122paddingqDBjuR0$default2);
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
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1473513743, "C365@15580L2,366@15614L66,371@15842L32,373@15956L743,364@15523L1176:HomeScreen.kt#oif8tm");
            if (HomeScreen$lambda$5(stateCollectAsState2) == AppState.STATE_PAUSED) {
                homeViewModel2 = homeViewModel4;
                mutableState3 = mutableState;
                str = "CC(remember):HomeScreen.kt#9igjgp";
                composerStartRestartGroup.startReplaceGroup(-1488307099);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1473513155);
                ComposerKt.sourceInformation(composerStartRestartGroup, "348@14972L2,349@15010L79,347@14911L525,361@15454L41");
                str = "CC(remember):HomeScreen.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -601720097, str);
                objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue14 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                }
                Function0 function7 = (Function0) objRememberedValue14;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -601718804, str);
                objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue15 == Composer.INSTANCE.getEmpty()) {
                    mutableState5 = mutableState;
                    objRememberedValue15 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenKt.HomeScreen$lambda$71$lambda$70$lambda$62$lambda$61(mutableState5);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                } else {
                    mutableState5 = mutableState;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableState3 = mutableState5;
                homeViewModel2 = homeViewModel4;
                LongPressFloatingActionButtonKt.m9774LongPressFloatingActionButton8r3B23s(function7, (Function0) objRememberedValue15, columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally()), Color.INSTANCE.m5975getTransparent0d7_KjU(), 0L, null, false, ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$213007007$app_debug(), composerStartRestartGroup, 12586038, 112);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(12)), composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -601700641, str);
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            Function0 function8 = (Function0) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -601699489, str);
            if (i8 <= 256) {
            }
            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (!z4) {
                objRememberedValue9 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$70$lambda$66$lambda$65(homeViewModel2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$70$lambda$66$lambda$65(homeViewModel2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            Function0 function9 = (Function0) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierAlign2 = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
            long jM5975getTransparent0d7_KjU2 = Color.INSTANCE.m5975getTransparent0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -601692227, str);
            if (i8 <= 256) {
            }
            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue10 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$70$lambda$68$lambda$67(homeViewModel2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            } else {
                objRememberedValue10 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$70$lambda$68$lambda$67(homeViewModel2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LongPressFloatingActionButtonKt.m9774LongPressFloatingActionButton8r3B23s(function8, function9, modifierAlign2, jM5975getTransparent0d7_KjU2, 0L, (Function0) objRememberedValue10, HomeScreen$lambda$12(stateCollectAsState117) instanceof StartupState.Error, ComposableLambdaKt.rememberComposableLambda(1352195546, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return HomeScreenKt.HomeScreen$lambda$71$lambda$70$lambda$69(stateCollectAsState117, stateCollectAsState2, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12585990, 16);
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
            if (HomeScreen$lambda$20(mutableState3)) {
                composerStartRestartGroup.startReplaceGroup(1772079849);
            } else {
                composerStartRestartGroup.startReplaceGroup(1788721145);
                ComposerKt.sourceInformation(composerStartRestartGroup, "395@16806L36,398@17048L226,406@17304L152,394@16762L704");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1050676931, str);
                objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    mutableState4 = mutableState3;
                    objRememberedValue13 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenKt.HomeScreen$lambda$73$lambda$72(mutableState4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                } else {
                    mutableState4 = mutableState3;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0((Function0) objRememberedValue13, ComposableLambdaKt.rememberComposableLambda(-1878607962, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj4, Object obj5) {
                        return HomeScreenKt.HomeScreen$lambda$76(homeViewModel2, mutableState4, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-474738776, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj4, Object obj5) {
                        return HomeScreenKt.HomeScreen$lambda$79(mutableState4, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$929130410$app_debug(), ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$1631065003$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, 1772598, 0, 16276);
                composerStartRestartGroup = composerStartRestartGroup;
            }
            composerStartRestartGroup.endReplaceGroup();
            if (HomeScreen$lambda$26(mutableState2)) {
                composerStartRestartGroup.startReplaceGroup(1772079849);
            } else {
                composerStartRestartGroup.startReplaceGroup(1789449800);
                ComposerKt.sourceInformation(composerStartRestartGroup, "418@17655L25,417@17594L36,415@17513L177");
                UpdateState updateStateHomeScreen$lambda$27 = HomeScreen$lambda$24(stateCollectAsState9);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1050649774, str);
                if (i8 > 256) {
                    i10 = i9;
                    if ((i10 & 384) != 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                } else {
                    i10 = i9;
                    if ((i10 & 384) != 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                }
                objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue11 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenKt.HomeScreen$lambda$81$lambda$80(homeViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenKt.HomeScreen$lambda$81$lambda$80(homeViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                Function0 function10 = (Function0) objRememberedValue11;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1050651715, str);
                if (i8 <= 256) {
                }
                objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue12 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenKt.HomeScreen$lambda$83$lambda$82(homeViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                } else {
                    objRememberedValue12 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenKt.HomeScreen$lambda$83$lambda$82(homeViewModel2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ShowUpdateDialog(updateStateHomeScreen$lambda$27, function10, (Function0) objRememberedValue12, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier7;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            homeViewModel2 = homeViewModel;
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return HomeScreenKt.HomeScreen$lambda$84(navController, modifier3, homeViewModel2, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
                }
            });
        }
    }

    private static final boolean HomeScreen$lambda$20(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void HomeScreen$lambda$21(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean HomeScreen$lambda$26(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void HomeScreen$lambda$27(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$32$lambda$31(HomeViewModel homeViewModel) {
        homeViewModel.logoutUser();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0592  */
    /* JADX WARN: Code duplicated, block: B:103:0x059e  */
    /* JADX WARN: Code duplicated, block: B:104:0x05a2  */
    /* JADX WARN: Code duplicated, block: B:109:0x05d5  */
    /* JADX WARN: Code duplicated, block: B:112:0x066a  */
    /* JADX WARN: Code duplicated, block: B:115:0x0676  */
    /* JADX WARN: Code duplicated, block: B:116:0x067a  */
    /* JADX WARN: Code duplicated, block: B:121:0x06ad  */
    /* JADX WARN: Code duplicated, block: B:126:0x07d4  */
    /* JADX WARN: Code duplicated, block: B:129:0x0823  */
    /* JADX WARN: Code duplicated, block: B:130:0x0837  */
    /* JADX WARN: Code duplicated, block: B:134:0x0865  */
    /* JADX WARN: Code duplicated, block: B:139:0x088c  */
    /* JADX WARN: Code duplicated, block: B:143:0x08d8  */
    public static final Unit HomeScreen$lambda$71$lambda$58(Modifier modifier, final HomeViewModel homeViewModel, final NavHostController navHostController, State state, State state2, String str, State state3, State state4, State state5, State state6, State state7, State state8, State state9, State state10, State state11, Composer composer, int i) {
        String str2;
        long error;
        Function0 function0;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int iHashCode2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM5259constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean zChangedInstance;
        Object objRememberedValue;
        boolean zChangedInstance2;
        Object objRememberedValue2;
        boolean zChangedInstance3;
        Object objRememberedValue3;
        ComposerKt.sourceInformation(composer, "C183@7908L6764:HomeScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1421228015, i, -1, "com.example.bingwahybrid.presentation.ui.screens.HomeScreen.<anonymous>.<anonymous> (HomeScreen.kt:183)");
            }
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(modifier, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxHeight$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl3 = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl3.rememberedValue(), Integer.valueOf(iHashCode3))) {
                composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
            }
            Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1635029219, "C187@8021L1269,214@9307L1717,264@11461L46,265@11557L85,268@11683L74,257@11042L733,273@11793L306,282@12117L1531:HomeScreen.kt#oif8tm");
            float f = 16;
            Modifier modifierM1120paddingVpY3zN4$default = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(f), 0.0f, 2, null);
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1120paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl4 = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl4, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl4, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl4.rememberedValue(), Integer.valueOf(iHashCode4))) {
                composerM5259constructorimpl4.updateRememberedValue(Integer.valueOf(iHashCode4));
                composerM5259constructorimpl4.apply(Integer.valueOf(iHashCode4), setCompositeKeyHash4);
            }
            Updater.m5266setimpl(composerM5259constructorimpl4, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1171561118, "C200@8669L10,203@8835L47,194@8328L649,206@8998L39,207@9058L214:HomeScreen.kt#oif8tm");
            int i2 = WhenMappings.$EnumSwitchMapping$1[HomeScreen$lambda$6(state).ordinal()];
            if (i2 == 1) {
                str2 = "Express Mode";
            } else if (i2 == 2) {
                str2 = "Hybrid Mode";
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                str2 = "Advanced Mode";
            }
            TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall();
            Modifier modifierClip = ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(12)));
            ComposerKt.sourceInformationMarkerStart(composer, -1070571036, "CC(remember):HomeScreen.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(navHostController);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$35$lambda$34$lambda$33(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            float f2 = 8;
            TextKt.m3864TextNvy7gAk(str2, PaddingKt.m1119paddingVpY3zN4(ClickableKt.m584clickableoSLSa3U$default(modifierClip, false, null, null, null, (Function0) objRememberedValue4, 15, null), Dp.m8684constructorimpl(f2), Dp.m8684constructorimpl(4)), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, bodySmall, composer, 0, 0, 131068);
            SpacerKt.Spacer(SizeKt.m1175width3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composer, 6);
            if (HomeScreen$lambda$7(state2)) {
                composer.startReplaceGroup(-1070560966);
                composer.endReplaceGroup();
                error = Color.INSTANCE.m5971getGreen0d7_KjU();
            } else {
                composer.startReplaceGroup(-1070558790);
                ComposerKt.sourceInformation(composer, "210@9207L11");
                error = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getError();
                composer.endReplaceGroup();
            }
            DotKt.m9759DotiJQMabo(null, error, composer, 0, 1);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM1122paddingqDBjuR0$default = PaddingKt.m1122paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f2), 0.0f, 0.0f, 13, null);
            Arrangement.HorizontalOrVertical spaceAround = Arrangement.INSTANCE.getSpaceAround();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceAround, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM1122paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor5);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl5 = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl5, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl5, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl5.rememberedValue(), Integer.valueOf(iHashCode5))) {
                composerM5259constructorimpl5.updateRememberedValue(Integer.valueOf(iHashCode5));
                composerM5259constructorimpl5.apply(Integer.valueOf(iHashCode5), setCompositeKeyHash5);
            }
            Updater.m5266setimpl(composerM5259constructorimpl5, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 566121361, "C224@9762L313,220@9546L551,237@10325L312,233@10118L541,251@10879L105,247@10681L325:HomeScreen.kt#oif8tm");
            String strValueOf = String.valueOf(HomeScreen$lambda$3(state3));
            StatisticsBoxType statisticsBoxType = StatisticsBoxType.SUCCESSFUL;
            ComposerKt.sourceInformationMarkerStart(composer, -1367205577, "CC(remember):HomeScreen.kt#9igjgp");
            boolean zChangedInstance5 = composer.changedInstance(navHostController);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$42$lambda$37$lambda$36(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            StatisticsBoxKt.StatisticsBox("Successful", strValueOf, statisticsBoxType, (Function0) objRememberedValue5, composer, 390, 0);
            String strValueOf2 = String.valueOf(HomeScreen$lambda$4(state4));
            StatisticsBoxType statisticsBoxType2 = StatisticsBoxType.FAILED;
            ComposerKt.sourceInformationMarkerStart(composer, -1367187562, "CC(remember):HomeScreen.kt#9igjgp");
            boolean zChangedInstance6 = composer.changedInstance(navHostController);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$42$lambda$39$lambda$38(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            StatisticsBoxKt.StatisticsBox("Failed", strValueOf2, statisticsBoxType2, (Function0) objRememberedValue6, composer, 390, 0);
            StatisticsBoxType statisticsBoxType3 = StatisticsBoxType.TOKENS;
            ComposerKt.sourceInformationMarkerStart(composer, -1367170041, "CC(remember):HomeScreen.kt#9igjgp");
            boolean zChangedInstance7 = composer.changedInstance(navHostController);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$42$lambda$41$lambda$40(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            StatisticsBoxKt.StatisticsBox("Tokens", str, statisticsBoxType3, (Function0) objRememberedValue7, composer, 390, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            double dHomeScreen$lambda$13 = HomeScreen$lambda$13(state5);
            String strHomeScreen$lambda$14 = HomeScreen$lambda$14(state6);
            boolean zHomeScreen$lambda$15 = HomeScreen$lambda$15(state7);
            boolean zHomeScreen$lambda$16 = HomeScreen$lambda$16(state8);
            LoadingState loadingStateHomeScreen$lambda$17 = HomeScreen$lambda$17(state9);
            ComposerKt.sourceInformationMarkerStart(composer, 85907943, "CC(remember):HomeScreen.kt#9igjgp");
            boolean zChangedInstance8 = composer.changedInstance(homeViewModel);
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChangedInstance8 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$44$lambda$43(homeViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            Function0 function1 = (Function0) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 85911054, "CC(remember):HomeScreen.kt#9igjgp");
            boolean zChangedInstance9 = composer.changedInstance(homeViewModel);
            Object objRememberedValue9 = composer.rememberedValue();
            if (zChangedInstance9 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$46$lambda$45(homeViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            Function0 function2 = (Function0) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 85915075, "CC(remember):HomeScreen.kt#9igjgp");
            boolean zChangedInstance10 = composer.changedInstance(homeViewModel);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChangedInstance10) {
                function0 = function2;
            } else {
                function0 = function2;
                if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BalanceStatisticsBoxKt.BalanceStatisticsBox(dHomeScreen$lambda$13, strHomeScreen$lambda$14, zHomeScreen$lambda$15, zHomeScreen$lambda$16, loadingStateHomeScreen$lambda$17, function1, function0, (Function0) objRememberedValue10, modifierFillMaxWidth$default, composer, 100663296, 0);
                Modifier modifierM1156height3ABfNKs = SizeKt.m1156height3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.m1119paddingVpY3zN4(Modifier.INSTANCE, Dp.m8684constructorimpl(f), Dp.m8684constructorimpl(2)), 0.0f, 1, null), Dp.m8684constructorimpl(TextFieldImplKt.AnimationDuration));
                ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierM1156height3ABfNKs);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM5259constructorimpl = Updater.m5259constructorimpl(composer);
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 412304658, "C279@12029L52:HomeScreen.kt#oif8tm");
                StatisticsGraphKt.StatisticsGraph(null, HomeScreen$lambda$10(state10), composer, 0, 1);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierM1120paddingVpY3zN4$default2 = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(f2), 0.0f, 2, null);
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer, 48);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer, modifierM1120paddingVpY3zN4$default2);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM5259constructorimpl2 = Updater.m5259constructorimpl(composer);
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 258569268, "C288@12363L38,291@12528L10,292@12606L11,289@12422L253,295@12696L38,298@12845L10,299@12922L11,296@12755L237,303@13059L107,302@13013L617:HomeScreen.kt#oif8tm");
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
                TextKt.m3864TextNvy7gAk("Recent Transactions", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondary(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 6, 0, 131070);
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
                TextKt.m3864TextNvy7gAk("All", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondary(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 6, 0, 131070);
                ComposerKt.sourceInformationMarkerStart(composer, -1100016601, "CC(remember):HomeScreen.kt#9igjgp");
                zChangedInstance = composer.changedInstance(navHostController);
                objRememberedValue = composer.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$52$lambda$51$lambda$50(navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$577912862$app_debug(), composer, 1572864, 62);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (HomeScreen$lambda$0(state11).isEmpty()) {
                    composer.startReplaceGroup(-1629606359);
                    ComposerKt.sourceInformation(composer, "318@13715L24");
                    EmptyTransactionsState(null, composer, 0, 1);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-1629511158);
                    ComposerKt.sourceInformation(composer, "323@13967L557,335@14560L58,320@13785L855");
                    TransactionSource.ListSource listSource = new TransactionSource.ListSource(HomeScreen$lambda$0(state11));
                    ComposerKt.sourceInformationMarkerStart(composer, 85988646, "CC(remember):HomeScreen.kt#9igjgp");
                    zChangedInstance2 = composer.changedInstance(navHostController);
                    objRememberedValue2 = composer.rememberedValue();
                    if (!zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda32
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$54$lambda$53(navHostController, (Transaction) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function3 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 86007123, "CC(remember):HomeScreen.kt#9igjgp");
                    zChangedInstance3 = composer.changedInstance(homeViewModel);
                    objRememberedValue3 = composer.rememberedValue();
                    if (!zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$56$lambda$55(homeViewModel, (Transaction) obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TransactionListKt.TransactionList(listSource, true, false, null, function3, (Function1) objRememberedValue3, null, null, composer, TransactionSource.ListSource.$stable | 48, 204);
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
            objRememberedValue10 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$48$lambda$47(homeViewModel);
                }
            };
            composer.updateRememberedValue(objRememberedValue10);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BalanceStatisticsBoxKt.BalanceStatisticsBox(dHomeScreen$lambda$13, strHomeScreen$lambda$14, zHomeScreen$lambda$15, zHomeScreen$lambda$16, loadingStateHomeScreen$lambda$17, function1, function0, (Function0) objRememberedValue10, modifierFillMaxWidth$default, composer, 100663296, 0);
            Modifier modifierM1156height3ABfNKs2 = SizeKt.m1156height3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.m1119paddingVpY3zN4(Modifier.INSTANCE, Dp.m8684constructorimpl(f), Dp.m8684constructorimpl(2)), 0.0f, 1, null), Dp.m8684constructorimpl(TextFieldImplKt.AnimationDuration));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer, modifierM1156height3ABfNKs2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM5259constructorimpl = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl.getInserting()) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            } else {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 412304658, "C279@12029L52:HomeScreen.kt#oif8tm");
            StatisticsGraphKt.StatisticsGraph(null, HomeScreen$lambda$10(state10), composer, 0, 1);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM1120paddingVpY3zN4$default3 = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(f2), 0.0f, 2, null);
            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap7 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer, modifierM1120paddingVpY3zN4$default3);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM5259constructorimpl2 = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl2.getInserting()) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            } else {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 258569268, "C288@12363L38,291@12528L10,292@12606L11,289@12422L253,295@12696L38,298@12845L10,299@12922L11,296@12755L237,303@13059L107,302@13013L617:HomeScreen.kt#oif8tm");
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance6, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
            TextKt.m3864TextNvy7gAk("Recent Transactions", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondary(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 6, 0, 131070);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance6, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
            TextKt.m3864TextNvy7gAk("All", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondary(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 6, 0, 131070);
            ComposerKt.sourceInformationMarkerStart(composer, -1100016601, "CC(remember):HomeScreen.kt#9igjgp");
            zChangedInstance = composer.changedInstance(navHostController);
            objRememberedValue = composer.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$52$lambda$51$lambda$50(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$52$lambda$51$lambda$50(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$577912862$app_debug(), composer, 1572864, 62);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (HomeScreen$lambda$0(state11).isEmpty()) {
                composer.startReplaceGroup(-1629606359);
                ComposerKt.sourceInformation(composer, "318@13715L24");
                EmptyTransactionsState(null, composer, 0, 1);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1629511158);
                ComposerKt.sourceInformation(composer, "323@13967L557,335@14560L58,320@13785L855");
                TransactionSource.ListSource listSource2 = new TransactionSource.ListSource(HomeScreen$lambda$0(state11));
                ComposerKt.sourceInformationMarkerStart(composer, 85988646, "CC(remember):HomeScreen.kt#9igjgp");
                zChangedInstance2 = composer.changedInstance(navHostController);
                objRememberedValue2 = composer.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$54$lambda$53(navHostController, (Transaction) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$54$lambda$53(navHostController, (Transaction) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Function1 function4 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 86007123, "CC(remember):HomeScreen.kt#9igjgp");
                zChangedInstance3 = composer.changedInstance(homeViewModel);
                objRememberedValue3 = composer.rememberedValue();
                if (!zChangedInstance3) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$56$lambda$55(homeViewModel, (Transaction) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return HomeScreenKt.HomeScreen$lambda$71$lambda$58$lambda$57$lambda$56$lambda$55(homeViewModel, (Transaction) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TransactionListKt.TransactionList(listSource2, true, false, null, function4, (Function1) objRememberedValue3, null, null, composer, TransactionSource.ListSource.$stable | 48, 204);
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
    public static final Unit HomeScreen$lambda$71$lambda$58$lambda$57$lambda$35$lambda$34$lambda$33(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, Route.Settings.INSTANCE.getName(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$58$lambda$57$lambda$42$lambda$37$lambda$36(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, Route.Transactions.INSTANCE.withStatus(TransactionStatus.SUCCESS, "today"), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$58$lambda$57$lambda$42$lambda$39$lambda$38(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, Route.Transactions.INSTANCE.withStatus(TransactionStatus.FAILED, "today"), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$58$lambda$57$lambda$42$lambda$41$lambda$40(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, Route.MySubscription.INSTANCE.getName(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$58$lambda$57$lambda$44$lambda$43(HomeViewModel homeViewModel) {
        homeViewModel.onToggleTransactionsVisibility();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$58$lambda$57$lambda$46$lambda$45(HomeViewModel homeViewModel) {
        homeViewModel.onToggleAirtimeVisibility();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$58$lambda$57$lambda$48$lambda$47(HomeViewModel homeViewModel) {
        homeViewModel.refreshBalance();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$58$lambda$57$lambda$52$lambda$51$lambda$50(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, Route.Transactions.INSTANCE.simple(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$58$lambda$57$lambda$54$lambda$53(NavHostController navHostController, Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String name = Route.TransactionDetails.INSTANCE.getName();
        String string = it.getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        NavController.navigate$default((NavController) navHostController, StringsKt.replace$default(StringsKt.replace$default(name, "{transactionId}", string, false, 4, (Object) null), "{hasScheduledTransactions}", String.valueOf(Transaction.INSTANCE.isAutoRenewalTransaction(it)), false, 4, (Object) null), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$58$lambda$57$lambda$56$lambda$55(HomeViewModel homeViewModel, Transaction transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        homeViewModel.retryTransaction(transaction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$70$lambda$62$lambda$61(MutableState mutableState) {
        HomeScreen$lambda$21(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$70$lambda$66$lambda$65(HomeViewModel homeViewModel) {
        homeViewModel.toggleAppState();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$70$lambda$68$lambda$67(HomeViewModel homeViewModel) {
        homeViewModel.onLongPressStart();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$71$lambda$70$lambda$69(State state, State state2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:HomeScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1352195546, i, -1, "com.example.bingwahybrid.presentation.ui.screens.HomeScreen.<anonymous>.<anonymous>.<anonymous> (HomeScreen.kt:374)");
            }
            if (Intrinsics.areEqual(HomeScreen$lambda$12(state), StartupState.Loading.INSTANCE)) {
                composer.startReplaceGroup(759328318);
                ComposerKt.sourceInformation(composer, "376@16066L58");
                ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24)), 0L, 0.0f, 0L, 0, 0.0f, composer, 6, 62);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(759475165);
                ComposerKt.sourceInformation(composer, "384@16598L11,380@16202L443");
                IconKt.m3158Iconww6aTOc(HomeScreen$lambda$5(state2) == AppState.STATE_RUNNING ? PauseKt.getPause(Icons.INSTANCE.getDefault()) : PlayArrowKt.getPlayArrow(Icons.INSTANCE.getDefault()), HomeScreen$lambda$5(state2) == AppState.STATE_RUNNING ? "Long press to Pause App" : "Long press to Resume App", SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(28)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface(), composer, 384, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$73$lambda$72(MutableState mutableState) {
        HomeScreen$lambda$21(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$76(final HomeViewModel homeViewModel, final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C399@17087L112,399@17066L194:HomeScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1878607962, i, -1, "com.example.bingwahybrid.presentation.ui.screens.HomeScreen.<anonymous> (HomeScreen.kt:399)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1455985802, "CC(remember):HomeScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(homeViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$76$lambda$75$lambda$74(homeViewModel, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$1967474467$app_debug(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$76$lambda$75$lambda$74(HomeViewModel homeViewModel, MutableState mutableState) {
        homeViewModel.stopApp();
        HomeScreen$lambda$21(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$79(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C407@17343L36,407@17322L120:HomeScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-474738776, i, -1, "com.example.bingwahybrid.presentation.ui.screens.HomeScreen.<anonymous> (HomeScreen.kt:407)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -957429076, "CC(remember):HomeScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.HomeScreen$lambda$79$lambda$78$lambda$77(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$HomeScreenKt.INSTANCE.m9846getLambda$923623643$app_debug(), composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$79$lambda$78$lambda$77(MutableState mutableState) {
        HomeScreen$lambda$21(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$83$lambda$82(HomeViewModel homeViewModel) {
        homeViewModel.hideShowUpdateDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$81$lambda$80(HomeViewModel homeViewModel) {
        homeViewModel.updateApp();
        return Unit.INSTANCE;
    }

    private static final void EmptyTransactionsState(Modifier modifier, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1098450683);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EmptyTransactionsState)N(modifier)426@17785L405:HomeScreen.kt#oif8tm");
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
        if (!composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1098450683, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.EmptyTransactionsState (HomeScreen.kt:425)");
            }
            float f = 16;
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m8684constructorimpl(f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 957716439, "C432@17953L41,435@18112L10,433@18003L181:HomeScreen.kt#oif8tm");
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
            composer2 = composerStartRestartGroup;
            modifier3 = companion;
            TextKt.m3864TextNvy7gAk("Your most recent transactions will appear here", null, 0L, null, 0L, null, null, null, 0L, null, TextAlign.m8533boximpl(TextAlign.INSTANCE.m8540getCentere0LSkKk()), 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composer2, 6, 0, 130046);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.EmptyTransactionsState$lambda$86(modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ShowUpdateDialog(final UpdateState updateState, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(647815561);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShowUpdateDialog)N(updateState,onUpdate,onDismiss)448@18367L2,467@19283L414,479@19723L357,450@18426L831,447@18327L1759:HomeScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(updateState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(647815561, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.ShowUpdateDialog (HomeScreen.kt:446)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -219498261, "CC(remember):HomeScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0((Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(150322753, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.ShowUpdateDialog$lambda$90(function0, updateState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-114324737, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.ShowUpdateDialog$lambda$91(function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableSingletons$HomeScreenKt.INSTANCE.m9845getLambda$378972227$app_debug(), ComposableLambdaKt.rememberComposableLambda(-511295972, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.ShowUpdateDialog$lambda$92(updateState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, 1772598, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.ShowUpdateDialog$lambda$93(updateState, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowUpdateDialog$lambda$92(UpdateState updateState, Composer composer, int i) {
        String str;
        ComposerKt.sourceInformation(composer, "C451@18440L807:HomeScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-511295972, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ShowUpdateDialog.<anonymous> (HomeScreen.kt:451)");
            }
            if (updateState instanceof UpdateState.UpdateRequired) {
                UpdateState.UpdateRequired updateRequired = (UpdateState.UpdateRequired) updateState;
                if (StringsKt.isBlank(updateRequired.getApkUrl())) {
                    str = "A new version (" + updateRequired.getVersionCode() + ") is available. Please connect to the internet to download the update.";
                } else {
                    str = "A new version is available. We advise you deactivate/remove the SIM card receiving messages to avoid missed transactions";
                }
            } else {
                str = updateState instanceof UpdateState.Downloading ? "Downloading Update. Please wait." : "A new version is available. Please update for better experience.";
            }
            TextKt.m3864TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowUpdateDialog$lambda$90(Function0 function0, final UpdateState updateState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C468@19324L363,468@19297L390:HomeScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(150322753, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ShowUpdateDialog.<anonymous> (HomeScreen.kt:468)");
            }
            ButtonKt.Button(function0, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1334178735, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return HomeScreenKt.ShowUpdateDialog$lambda$90$lambda$89(updateState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowUpdateDialog$lambda$90$lambda$89(UpdateState updateState, RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C473@19553L10,469@19342L331:HomeScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1334178735, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ShowUpdateDialog.<anonymous>.<anonymous> (HomeScreen.kt:469)");
            }
            TextKt.m3864TextNvy7gAk(updateState instanceof UpdateState.Downloading ? "Downloading..." : "Update", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowUpdateDialog$lambda$91(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C480@19737L333:HomeScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-114324737, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ShowUpdateDialog.<anonymous> (HomeScreen.kt:480)");
            }
            ButtonKt.OutlinedButton(function0, SizeKt.wrapContentHeight$default(Modifier.INSTANCE, null, false, 3, null), false, null, null, null, null, null, null, ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$1644429005$app_debug(), composer, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final List<Transaction> HomeScreen$lambda$0(State<? extends List<Transaction>> state) {
        return state.getValue();
    }

    private static final String HomeScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    private static final String HomeScreen$lambda$2(State<String> state) {
        return state.getValue();
    }

    private static final int HomeScreen$lambda$3(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final int HomeScreen$lambda$4(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final AppState HomeScreen$lambda$5(State<? extends AppState> state) {
        return state.getValue();
    }

    private static final ProcessingMode HomeScreen$lambda$6(State<? extends ProcessingMode> state) {
        return state.getValue();
    }

    private static final boolean HomeScreen$lambda$7(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final long HomeScreen$lambda$8(State<Long> state) {
        return state.getValue().longValue();
    }

    private static final SubscriptionType HomeScreen$lambda$9(State<? extends SubscriptionType> state) {
        return state.getValue();
    }

    private static final List<AgentCommission> HomeScreen$lambda$10(State<? extends List<AgentCommission>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountHealthStatus HomeScreen$lambda$11(State<? extends AccountHealthStatus> state) {
        return state.getValue();
    }

    private static final StartupState HomeScreen$lambda$12(State<? extends StartupState> state) {
        return state.getValue();
    }

    private static final double HomeScreen$lambda$13(State<Double> state) {
        return state.getValue().doubleValue();
    }

    private static final String HomeScreen$lambda$14(State<String> state) {
        return state.getValue();
    }

    private static final boolean HomeScreen$lambda$15(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean HomeScreen$lambda$16(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final LoadingState HomeScreen$lambda$17(State<? extends LoadingState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HomeScreen$lambda$22(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String HomeScreen$lambda$23(State<String> state) {
        return state.getValue();
    }

    private static final UpdateState HomeScreen$lambda$24(State<? extends UpdateState> state) {
        return state.getValue();
    }
}
