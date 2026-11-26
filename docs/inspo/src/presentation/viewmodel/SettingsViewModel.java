package com.example.bingwahybrid.presentation.viewmodel;

import android.content.Context;
import androidx.core.location.LocationRequestCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.data.local.database.DatabaseInitializer;
import com.example.bingwahybrid.domain.auth.models.Agent;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.engagebot.model.EngageBot;
import com.example.bingwahybrid.domain.engagebot.repository.EngageBotRepository;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.enums.ProcessingMode;
import com.example.bingwahybrid.domain.enums.SimCard;
import com.example.bingwahybrid.domain.repository.AccessibilityRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.presentation.navigation.Route;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SettingsViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B;\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010%\u001a\u000207H\u0002J\b\u0010+\u001a\u000207H\u0002J\u0016\u00108\u001a\u0002072\u0006\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020)J\u000e\u0010;\u001a\u00020)H\u0082@¢\u0006\u0002\u0010<J\u000e\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020\u0012J\u000e\u0010?\u001a\u0002072\u0006\u0010>\u001a\u00020\u0012J\u0006\u0010@\u001a\u000207J\u0006\u0010A\u001a\u000207J\u0006\u0010B\u001a\u000207J\u000e\u0010C\u001a\u0002072\u0006\u0010.\u001a\u00020-J\u0006\u0010D\u001a\u000207J\b\u00102\u001a\u000207H\u0002J\u000e\u0010E\u001a\u0002072\u0006\u0010F\u001a\u00020)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00180\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00180\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0019\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R \u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'0\u0014¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0016R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u0014¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0016R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020)0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020)0\u0014¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0016R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020)04¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006G"}, d2 = {"Lcom/example/bingwahybrid/presentation/viewmodel/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "databaseInitializer", "Lcom/example/bingwahybrid/data/local/database/DatabaseInitializer;", "accessibilityRepository", "Lcom/example/bingwahybrid/domain/repository/AccessibilityRepository;", "engageBotRepository", "Lcom/example/bingwahybrid/domain/engagebot/repository/EngageBotRepository;", "<init>", "(Landroid/content/Context;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;Lcom/example/bingwahybrid/data/local/database/DatabaseInitializer;Lcom/example/bingwahybrid/domain/repository/AccessibilityRepository;Lcom/example/bingwahybrid/domain/engagebot/repository/EngageBotRepository;)V", "_ussdSimCard", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bingwahybrid/domain/enums/SimCard;", "ussdSimCard", "Lkotlinx/coroutines/flow/StateFlow;", "getUssdSimCard", "()Lkotlinx/coroutines/flow/StateFlow;", "_paymentSimCards", "", "paymentSimCards", "getPaymentSimCards", "_snackBarMessage", "", "snackBarMessage", "getSnackBarMessage", "_initialRoute", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "initialRoute", "getInitialRoute", "agent", "Lcom/example/bingwahybrid/domain/auth/models/Agent;", "getAgent", "_settings", "", "Lcom/example/bingwahybrid/domain/enums/AppSetting;", "", "settings", "getSettings", "_processingMode", "Lcom/example/bingwahybrid/domain/enums/ProcessingMode;", "processingMode", "getProcessingMode", "_engageBotActive", "engageBotActive", "getEngageBotActive", "accessibilityStatusFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getAccessibilityStatusFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "", "updateSetting", "setting", "isChecked", "attemptEnableHybridPortal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUssdSimCard", "simCard", "onPaymentSimChanged", "initializeApp", "setOnboardingCompleted", "resetSnackbarMessage", "setProcessingMode", "checkAccessibilityActiveStatus", "toggleEngageBotActive", "isActive", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SettingsViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> _engageBotActive;
    private final MutableStateFlow<Route> _initialRoute;
    private final MutableStateFlow<List<SimCard>> _paymentSimCards;
    private final MutableStateFlow<ProcessingMode> _processingMode;
    private final MutableStateFlow<Map<AppSetting, Boolean>> _settings;
    private final MutableStateFlow<String> _snackBarMessage;
    private final MutableStateFlow<SimCard> _ussdSimCard;
    private final AccessibilityRepository accessibilityRepository;
    private final SharedFlow<Boolean> accessibilityStatusFlow;
    private final StateFlow<Agent> agent;
    private final AuthRepository authRepository;
    private final Context context;
    private final DatabaseInitializer databaseInitializer;
    private final StateFlow<Boolean> engageBotActive;
    private final EngageBotRepository engageBotRepository;
    private final StateFlow<Route> initialRoute;
    private final StateFlow<List<SimCard>> paymentSimCards;
    private final StateFlow<ProcessingMode> processingMode;
    private final StateFlow<Map<AppSetting, Boolean>> settings;
    private final SettingsRepository settingsRepository;
    private final StateFlow<String> snackBarMessage;
    private final StateFlow<SimCard> ussdSimCard;

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$attemptEnableHybridPortal$1, reason: invalid class name */
    /* JADX INFO: compiled from: SettingsViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel", f = "SettingsViewModel.kt", i = {}, l = {128}, m = "attemptEnableHybridPortal", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SettingsViewModel.this.attemptEnableHybridPortal(this);
        }
    }

    @Inject
    public SettingsViewModel(@ApplicationContext Context context, SettingsRepository settingsRepository, AuthRepository authRepository, DatabaseInitializer databaseInitializer, AccessibilityRepository accessibilityRepository, EngageBotRepository engageBotRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(databaseInitializer, "databaseInitializer");
        Intrinsics.checkNotNullParameter(accessibilityRepository, "accessibilityRepository");
        Intrinsics.checkNotNullParameter(engageBotRepository, "engageBotRepository");
        this.context = context;
        this.settingsRepository = settingsRepository;
        this.authRepository = authRepository;
        this.databaseInitializer = databaseInitializer;
        this.accessibilityRepository = accessibilityRepository;
        this.engageBotRepository = engageBotRepository;
        MutableStateFlow<SimCard> MutableStateFlow = StateFlowKt.MutableStateFlow(SimCard.SIM_ONE);
        this._ussdSimCard = MutableStateFlow;
        this.ussdSimCard = MutableStateFlow;
        MutableStateFlow<List<SimCard>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._paymentSimCards = MutableStateFlow2;
        this.paymentSimCards = MutableStateFlow2;
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._snackBarMessage = MutableStateFlow3;
        this.snackBarMessage = MutableStateFlow3;
        MutableStateFlow<Route> MutableStateFlow4 = StateFlowKt.MutableStateFlow(Route.SplashScreen.INSTANCE);
        this._initialRoute = MutableStateFlow4;
        this.initialRoute = MutableStateFlow4;
        this.agent = authRepository.getAgent();
        MutableStateFlow<Map<AppSetting, Boolean>> MutableStateFlow5 = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this._settings = MutableStateFlow5;
        this.settings = MutableStateFlow5;
        MutableStateFlow<ProcessingMode> MutableStateFlow6 = StateFlowKt.MutableStateFlow(settingsRepository.getProcessingMode().getValue());
        this._processingMode = MutableStateFlow6;
        this.processingMode = FlowKt.asStateFlow(MutableStateFlow6);
        MutableStateFlow<Boolean> MutableStateFlow7 = StateFlowKt.MutableStateFlow(false);
        this._engageBotActive = MutableStateFlow7;
        this.engageBotActive = FlowKt.asStateFlow(MutableStateFlow7);
        this.accessibilityStatusFlow = accessibilityRepository.getAccessibilityStatusFlow();
        getAgent();
        getSettings();
        getEngageBotActive();
    }

    public final StateFlow<SimCard> getUssdSimCard() {
        return this.ussdSimCard;
    }

    public final StateFlow<List<SimCard>> getPaymentSimCards() {
        return this.paymentSimCards;
    }

    public final StateFlow<String> getSnackBarMessage() {
        return this.snackBarMessage;
    }

    public final StateFlow<Route> getInitialRoute() {
        return this.initialRoute;
    }

    /* JADX INFO: renamed from: getAgent, reason: collision with other method in class */
    public final StateFlow<Agent> m9983getAgent() {
        return this.agent;
    }

    /* JADX INFO: renamed from: getSettings, reason: collision with other method in class */
    public final StateFlow<Map<AppSetting, Boolean>> m9985getSettings() {
        return this.settings;
    }

    public final StateFlow<ProcessingMode> getProcessingMode() {
        return this.processingMode;
    }

    /* JADX INFO: renamed from: getEngageBotActive, reason: collision with other method in class */
    public final StateFlow<Boolean> m9984getEngageBotActive() {
        return this.engageBotActive;
    }

    public final SharedFlow<Boolean> getAccessibilityStatusFlow() {
        return this.accessibilityStatusFlow;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$getAgent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$getAgent$1", f = "SettingsViewModel.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    static final class C07811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07811(Continuation<? super C07811> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsViewModel.this.new C07811(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object loggedInAgent = SettingsViewModel.this.authRepository.getLoggedInAgent(this);
                    this = loggedInAgent;
                    if (loggedInAgent == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this = this;
                }
            } catch (Exception e) {
                SettingsViewModel.this._snackBarMessage.setValue(String.valueOf(e.getMessage()));
            }
            return Unit.INSTANCE;
        }
    }

    private final void getAgent() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07811(null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$getSettings$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$getSettings$1", f = "SettingsViewModel.kt", i = {0, 0, 0, 0, 0, 0}, l = {81}, m = "invokeSuspend", n = {"settingsMap", "$this$forEach$iv", "element$iv", "setting", "$i$f$forEach", "$i$a$-forEach-SettingsViewModel$getSettings$1$1"}, s = {"L$0", "L$1", "L$4", "L$5", "I$0", "I$1"})
    static final class C07831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        C07831(Continuation<? super C07831> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsViewModel.this.new C07831(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x004e  */
        /* JADX WARN: Code duplicated, block: B:13:0x0079 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0077 -> B:14:0x007a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L2e
                if (r1 != r3) goto L26
                int r1 = r11.I$0
                java.lang.Object r4 = r11.L$5
                com.example.bingwahybrid.domain.enums.AppSetting r4 = (com.example.bingwahybrid.domain.enums.AppSetting) r4
                java.lang.Object r5 = r11.L$3
                java.util.Iterator r5 = (java.util.Iterator) r5
                java.lang.Object r6 = r11.L$2
                com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel r6 = (com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel) r6
                java.lang.Object r7 = r11.L$1
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                java.lang.Object r8 = r11.L$0
                java.util.Map r8 = (java.util.Map) r8
                kotlin.ResultKt.throwOnFailure(r12)
                goto L7a
            L26:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L2e:
                kotlin.ResultKt.throwOnFailure(r12)
                java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
                r12.<init>()
                java.util.Map r12 = (java.util.Map) r12
                kotlin.enums.EnumEntries r1 = com.example.bingwahybrid.domain.enums.AppSetting.getEntries()
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel r4 = com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel.this
                java.util.Iterator r5 = r1.iterator()
                r8 = r12
                r7 = r1
                r1 = r2
                r6 = r4
            L48:
                boolean r12 = r5.hasNext()
                if (r12 == 0) goto L88
                java.lang.Object r12 = r5.next()
                r4 = r12
                com.example.bingwahybrid.domain.enums.AppSetting r4 = (com.example.bingwahybrid.domain.enums.AppSetting) r4
                com.example.bingwahybrid.domain.repository.SettingsRepository r9 = com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel.access$getSettingsRepository$p(r6)
                r11.L$0 = r8
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r11.L$1 = r10
                r11.L$2 = r6
                r11.L$3 = r5
                java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
                r11.L$4 = r12
                r11.L$5 = r4
                r11.I$0 = r1
                r11.I$1 = r2
                r11.label = r3
                java.lang.Object r12 = r9.getSetting(r4, r11)
                if (r12 != r0) goto L7a
                return r0
            L7a:
                java.lang.String r12 = (java.lang.String) r12
                boolean r12 = java.lang.Boolean.parseBoolean(r12)
                java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
                r8.put(r4, r12)
                goto L48
            L88:
                com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel r11 = com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r11 = com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel.access$get_settings$p(r11)
                r11.setValue(r8)
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel.C07831.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void getSettings() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07831(null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$updateSetting$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$updateSetting$1", f = "SettingsViewModel.kt", i = {0, 1, 2, 3, 4, 5}, l = {95, 98, LocationRequestCompat.QUALITY_LOW_POWER, 107, 112, 119}, m = "invokeSuspend", n = {"updatedSettings", "updatedSettings", "updatedSettings", "updatedSettings", "updatedSettings", "updatedSettings"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0"})
    static final class C07881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        final /* synthetic */ AppSetting $setting;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07881(AppSetting appSetting, boolean z, Continuation<? super C07881> continuation) {
            super(2, continuation);
            this.$setting = appSetting;
            this.$isChecked = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsViewModel.this.new C07881(this.$setting, this.$isChecked, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00b8 A[Catch: Exception -> 0x0161, TryCatch #0 {Exception -> 0x0161, blocks: (B:7:0x0018, B:72:0x0157, B:10:0x0021, B:64:0x0123, B:66:0x012b, B:68:0x012e, B:13:0x002a, B:56:0x00ff, B:57:0x0108, B:59:0x010e, B:61:0x0112, B:16:0x0033, B:48:0x00d4, B:19:0x003c, B:40:0x00a9, B:41:0x00b2, B:43:0x00b8, B:45:0x00bc, B:49:0x00de, B:51:0x00e4, B:53:0x00e8, B:22:0x0044, B:32:0x007d, B:25:0x004b, B:27:0x0061, B:29:0x0065, B:33:0x0087, B:35:0x008d, B:37:0x0091), top: B:78:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:49:0x00de A[Catch: Exception -> 0x0161, TryCatch #0 {Exception -> 0x0161, blocks: (B:7:0x0018, B:72:0x0157, B:10:0x0021, B:64:0x0123, B:66:0x012b, B:68:0x012e, B:13:0x002a, B:56:0x00ff, B:57:0x0108, B:59:0x010e, B:61:0x0112, B:16:0x0033, B:48:0x00d4, B:19:0x003c, B:40:0x00a9, B:41:0x00b2, B:43:0x00b8, B:45:0x00bc, B:49:0x00de, B:51:0x00e4, B:53:0x00e8, B:22:0x0044, B:32:0x007d, B:25:0x004b, B:27:0x0061, B:29:0x0065, B:33:0x0087, B:35:0x008d, B:37:0x0091), top: B:78:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:51:0x00e4 A[Catch: Exception -> 0x0161, TryCatch #0 {Exception -> 0x0161, blocks: (B:7:0x0018, B:72:0x0157, B:10:0x0021, B:64:0x0123, B:66:0x012b, B:68:0x012e, B:13:0x002a, B:56:0x00ff, B:57:0x0108, B:59:0x010e, B:61:0x0112, B:16:0x0033, B:48:0x00d4, B:19:0x003c, B:40:0x00a9, B:41:0x00b2, B:43:0x00b8, B:45:0x00bc, B:49:0x00de, B:51:0x00e4, B:53:0x00e8, B:22:0x0044, B:32:0x007d, B:25:0x004b, B:27:0x0061, B:29:0x0065, B:33:0x0087, B:35:0x008d, B:37:0x0091), top: B:78:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x0108 A[Catch: Exception -> 0x0161, PHI: r1
  0x0108: PHI (r1v12 java.util.Map) = (r1v5 java.util.Map), (r1v5 java.util.Map), (r1v9 java.util.Map), (r1v13 java.util.Map) binds: [B:50:0x00e2, B:52:0x00e6, B:48:0x00d4, B:56:0x00ff] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0161, blocks: (B:7:0x0018, B:72:0x0157, B:10:0x0021, B:64:0x0123, B:66:0x012b, B:68:0x012e, B:13:0x002a, B:56:0x00ff, B:57:0x0108, B:59:0x010e, B:61:0x0112, B:16:0x0033, B:48:0x00d4, B:19:0x003c, B:40:0x00a9, B:41:0x00b2, B:43:0x00b8, B:45:0x00bc, B:49:0x00de, B:51:0x00e4, B:53:0x00e8, B:22:0x0044, B:32:0x007d, B:25:0x004b, B:27:0x0061, B:29:0x0065, B:33:0x0087, B:35:0x008d, B:37:0x0091), top: B:78:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:59:0x010e A[Catch: Exception -> 0x0161, TryCatch #0 {Exception -> 0x0161, blocks: (B:7:0x0018, B:72:0x0157, B:10:0x0021, B:64:0x0123, B:66:0x012b, B:68:0x012e, B:13:0x002a, B:56:0x00ff, B:57:0x0108, B:59:0x010e, B:61:0x0112, B:16:0x0033, B:48:0x00d4, B:19:0x003c, B:40:0x00a9, B:41:0x00b2, B:43:0x00b8, B:45:0x00bc, B:49:0x00de, B:51:0x00e4, B:53:0x00e8, B:22:0x0044, B:32:0x007d, B:25:0x004b, B:27:0x0061, B:29:0x0065, B:33:0x0087, B:35:0x008d, B:37:0x0091), top: B:78:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:66:0x012b A[Catch: Exception -> 0x0161, TryCatch #0 {Exception -> 0x0161, blocks: (B:7:0x0018, B:72:0x0157, B:10:0x0021, B:64:0x0123, B:66:0x012b, B:68:0x012e, B:13:0x002a, B:56:0x00ff, B:57:0x0108, B:59:0x010e, B:61:0x0112, B:16:0x0033, B:48:0x00d4, B:19:0x003c, B:40:0x00a9, B:41:0x00b2, B:43:0x00b8, B:45:0x00bc, B:49:0x00de, B:51:0x00e4, B:53:0x00e8, B:22:0x0044, B:32:0x007d, B:25:0x004b, B:27:0x0061, B:29:0x0065, B:33:0x0087, B:35:0x008d, B:37:0x0091), top: B:78:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:68:0x012e A[Catch: Exception -> 0x0161, PHI: r1
  0x012e: PHI (r1v16 java.util.Map) = (r1v12 java.util.Map), (r1v12 java.util.Map), (r1v17 java.util.Map) binds: [B:58:0x010c, B:60:0x0110, B:65:0x0129] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0161, blocks: (B:7:0x0018, B:72:0x0157, B:10:0x0021, B:64:0x0123, B:66:0x012b, B:68:0x012e, B:13:0x002a, B:56:0x00ff, B:57:0x0108, B:59:0x010e, B:61:0x0112, B:16:0x0033, B:48:0x00d4, B:19:0x003c, B:40:0x00a9, B:41:0x00b2, B:43:0x00b8, B:45:0x00bc, B:49:0x00de, B:51:0x00e4, B:53:0x00e8, B:22:0x0044, B:32:0x007d, B:25:0x004b, B:27:0x0061, B:29:0x0065, B:33:0x0087, B:35:0x008d, B:37:0x0091), top: B:78:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:71:0x0156  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Map mutableMap;
            Map map;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        mutableMap = MapsKt.toMutableMap((Map) SettingsViewModel.this._settings.getValue());
                        if (this.$setting == AppSetting.DIAL_USSD_VIA_SIM_1 && this.$isChecked) {
                            this.L$0 = mutableMap;
                            this.label = 1;
                            if (SettingsViewModel.this.settingsRepository.saveSetting(AppSetting.DIAL_USSD_VIA_SIM_2, "false", this) != coroutine_suspended) {
                                mutableMap.put(AppSetting.DIAL_USSD_VIA_SIM_2, Boxing.boxBoolean(false));
                                if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_1) {
                                    if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_2) {
                                        if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                            mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                            this.L$0 = mutableMap;
                                            this.label = 6;
                                            if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                                map = mutableMap;
                                                SettingsViewModel.this._settings.setValue(map);
                                                return Unit.INSTANCE;
                                            }
                                        } else {
                                            mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                            this.L$0 = mutableMap;
                                            this.label = 6;
                                            if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                                map = mutableMap;
                                                SettingsViewModel.this._settings.setValue(map);
                                                return Unit.INSTANCE;
                                            }
                                        }
                                    } else if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                        mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                        this.L$0 = mutableMap;
                                        this.label = 6;
                                        if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                            map = mutableMap;
                                            SettingsViewModel.this._settings.setValue(map);
                                            return Unit.INSTANCE;
                                        }
                                    } else {
                                        mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                        this.L$0 = mutableMap;
                                        this.label = 6;
                                        if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                            map = mutableMap;
                                            SettingsViewModel.this._settings.setValue(map);
                                            return Unit.INSTANCE;
                                        }
                                    }
                                } else if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_2) {
                                    if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                        mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                        this.L$0 = mutableMap;
                                        this.label = 6;
                                        if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                            map = mutableMap;
                                            SettingsViewModel.this._settings.setValue(map);
                                            return Unit.INSTANCE;
                                        }
                                    } else {
                                        mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                        this.L$0 = mutableMap;
                                        this.label = 6;
                                        if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                            map = mutableMap;
                                            SettingsViewModel.this._settings.setValue(map);
                                            return Unit.INSTANCE;
                                        }
                                    }
                                } else if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                    mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                    this.L$0 = mutableMap;
                                    this.label = 6;
                                    if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                        map = mutableMap;
                                        SettingsViewModel.this._settings.setValue(map);
                                        return Unit.INSTANCE;
                                    }
                                } else {
                                    mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                    this.L$0 = mutableMap;
                                    this.label = 6;
                                    if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                        map = mutableMap;
                                        SettingsViewModel.this._settings.setValue(map);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                        } else if (this.$setting == AppSetting.DIAL_USSD_VIA_SIM_2 && this.$isChecked) {
                            this.L$0 = mutableMap;
                            this.label = 2;
                            if (SettingsViewModel.this.settingsRepository.saveSetting(AppSetting.DIAL_USSD_VIA_SIM_1, "false", this) != coroutine_suspended) {
                                mutableMap.put(AppSetting.DIAL_USSD_VIA_SIM_1, Boxing.boxBoolean(false));
                                if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_1) {
                                    if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_2) {
                                        if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                            mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                            this.L$0 = mutableMap;
                                            this.label = 6;
                                            if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                                map = mutableMap;
                                                SettingsViewModel.this._settings.setValue(map);
                                                return Unit.INSTANCE;
                                            }
                                        } else {
                                            mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                            this.L$0 = mutableMap;
                                            this.label = 6;
                                            if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                                map = mutableMap;
                                                SettingsViewModel.this._settings.setValue(map);
                                                return Unit.INSTANCE;
                                            }
                                        }
                                    } else if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                        mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                        this.L$0 = mutableMap;
                                        this.label = 6;
                                        if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                            map = mutableMap;
                                            SettingsViewModel.this._settings.setValue(map);
                                            return Unit.INSTANCE;
                                        }
                                    } else {
                                        mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                        this.L$0 = mutableMap;
                                        this.label = 6;
                                        if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                            map = mutableMap;
                                            SettingsViewModel.this._settings.setValue(map);
                                            return Unit.INSTANCE;
                                        }
                                    }
                                } else if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_2) {
                                    if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                        mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                        this.L$0 = mutableMap;
                                        this.label = 6;
                                        if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                            map = mutableMap;
                                            SettingsViewModel.this._settings.setValue(map);
                                            return Unit.INSTANCE;
                                        }
                                    } else {
                                        mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                        this.L$0 = mutableMap;
                                        this.label = 6;
                                        if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                            map = mutableMap;
                                            SettingsViewModel.this._settings.setValue(map);
                                            return Unit.INSTANCE;
                                        }
                                    }
                                } else if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                    mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                    this.L$0 = mutableMap;
                                    this.label = 6;
                                    if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                        map = mutableMap;
                                        SettingsViewModel.this._settings.setValue(map);
                                        return Unit.INSTANCE;
                                    }
                                } else {
                                    mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                    this.L$0 = mutableMap;
                                    this.label = 6;
                                    if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                        map = mutableMap;
                                        SettingsViewModel.this._settings.setValue(map);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                        } else if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_1 && this.$isChecked) {
                            this.L$0 = mutableMap;
                            this.label = 3;
                            if (SettingsViewModel.this.settingsRepository.saveSetting(AppSetting.SEND_SMS_VIA_SIM_2, "false", this) != coroutine_suspended) {
                                mutableMap.put(AppSetting.SEND_SMS_VIA_SIM_2, Boxing.boxBoolean(false));
                                if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                    mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                    this.L$0 = mutableMap;
                                    this.label = 6;
                                    if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                        map = mutableMap;
                                        SettingsViewModel.this._settings.setValue(map);
                                        return Unit.INSTANCE;
                                    }
                                } else {
                                    mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                    this.L$0 = mutableMap;
                                    this.label = 6;
                                    if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                        map = mutableMap;
                                        SettingsViewModel.this._settings.setValue(map);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                        } else if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_2 && this.$isChecked) {
                            this.L$0 = mutableMap;
                            this.label = 4;
                            if (SettingsViewModel.this.settingsRepository.saveSetting(AppSetting.SEND_SMS_VIA_SIM_1, "false", this) != coroutine_suspended) {
                                mutableMap.put(AppSetting.SEND_SMS_VIA_SIM_1, Boxing.boxBoolean(false));
                                if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                    mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                    this.L$0 = mutableMap;
                                    this.label = 6;
                                    if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                        map = mutableMap;
                                        SettingsViewModel.this._settings.setValue(map);
                                        return Unit.INSTANCE;
                                    }
                                } else {
                                    mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                    this.L$0 = mutableMap;
                                    this.label = 6;
                                    if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                        map = mutableMap;
                                        SettingsViewModel.this._settings.setValue(map);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                        } else if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE && this.$isChecked) {
                            this.L$0 = mutableMap;
                            this.label = 5;
                            obj = SettingsViewModel.this.attemptEnableHybridPortal(this);
                            if (obj != coroutine_suspended) {
                                if (!((Boolean) obj).booleanValue()) {
                                    return Unit.INSTANCE;
                                }
                                mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                this.L$0 = mutableMap;
                                this.label = 6;
                                if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                    map = mutableMap;
                                    SettingsViewModel.this._settings.setValue(map);
                                    return Unit.INSTANCE;
                                }
                            }
                        } else {
                            mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                            this.L$0 = mutableMap;
                            this.label = 6;
                            if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                map = mutableMap;
                                SettingsViewModel.this._settings.setValue(map);
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        mutableMap = (Map) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutableMap.put(AppSetting.DIAL_USSD_VIA_SIM_2, Boxing.boxBoolean(false));
                        if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_1) {
                            if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_2) {
                                if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                    mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                    this.L$0 = mutableMap;
                                    this.label = 6;
                                    if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                        map = mutableMap;
                                        SettingsViewModel.this._settings.setValue(map);
                                        return Unit.INSTANCE;
                                    }
                                } else {
                                    mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                    this.L$0 = mutableMap;
                                    this.label = 6;
                                    if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                        map = mutableMap;
                                        SettingsViewModel.this._settings.setValue(map);
                                        return Unit.INSTANCE;
                                    }
                                }
                            } else if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                this.L$0 = mutableMap;
                                this.label = 6;
                                if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                    map = mutableMap;
                                    SettingsViewModel.this._settings.setValue(map);
                                    return Unit.INSTANCE;
                                }
                            } else {
                                mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                this.L$0 = mutableMap;
                                this.label = 6;
                                if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                    map = mutableMap;
                                    SettingsViewModel.this._settings.setValue(map);
                                    return Unit.INSTANCE;
                                }
                            }
                        } else if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_2) {
                            if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                this.L$0 = mutableMap;
                                this.label = 6;
                                if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                    map = mutableMap;
                                    SettingsViewModel.this._settings.setValue(map);
                                    return Unit.INSTANCE;
                                }
                            } else {
                                mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                this.L$0 = mutableMap;
                                this.label = 6;
                                if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                    map = mutableMap;
                                    SettingsViewModel.this._settings.setValue(map);
                                    return Unit.INSTANCE;
                                }
                            }
                        } else if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                            mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                            this.L$0 = mutableMap;
                            this.label = 6;
                            if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                map = mutableMap;
                                SettingsViewModel.this._settings.setValue(map);
                                return Unit.INSTANCE;
                            }
                        } else {
                            mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                            this.L$0 = mutableMap;
                            this.label = 6;
                            if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                map = mutableMap;
                                SettingsViewModel.this._settings.setValue(map);
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    case 2:
                        mutableMap = (Map) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutableMap.put(AppSetting.DIAL_USSD_VIA_SIM_1, Boxing.boxBoolean(false));
                        if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_1) {
                            if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_2) {
                                if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                    mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                    this.L$0 = mutableMap;
                                    this.label = 6;
                                    if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                        map = mutableMap;
                                        SettingsViewModel.this._settings.setValue(map);
                                        return Unit.INSTANCE;
                                    }
                                } else {
                                    mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                    this.L$0 = mutableMap;
                                    this.label = 6;
                                    if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                        map = mutableMap;
                                        SettingsViewModel.this._settings.setValue(map);
                                        return Unit.INSTANCE;
                                    }
                                }
                            } else if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                this.L$0 = mutableMap;
                                this.label = 6;
                                if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                    map = mutableMap;
                                    SettingsViewModel.this._settings.setValue(map);
                                    return Unit.INSTANCE;
                                }
                            } else {
                                mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                this.L$0 = mutableMap;
                                this.label = 6;
                                if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                    map = mutableMap;
                                    SettingsViewModel.this._settings.setValue(map);
                                    return Unit.INSTANCE;
                                }
                            }
                        } else if (this.$setting != AppSetting.SEND_SMS_VIA_SIM_2) {
                            if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                                mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                this.L$0 = mutableMap;
                                this.label = 6;
                                if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                    map = mutableMap;
                                    SettingsViewModel.this._settings.setValue(map);
                                    return Unit.INSTANCE;
                                }
                            } else {
                                mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                                this.L$0 = mutableMap;
                                this.label = 6;
                                if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                    map = mutableMap;
                                    SettingsViewModel.this._settings.setValue(map);
                                    return Unit.INSTANCE;
                                }
                            }
                        } else if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                            mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                            this.L$0 = mutableMap;
                            this.label = 6;
                            if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                map = mutableMap;
                                SettingsViewModel.this._settings.setValue(map);
                                return Unit.INSTANCE;
                            }
                        } else {
                            mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                            this.L$0 = mutableMap;
                            this.label = 6;
                            if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                map = mutableMap;
                                SettingsViewModel.this._settings.setValue(map);
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    case 3:
                        mutableMap = (Map) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutableMap.put(AppSetting.SEND_SMS_VIA_SIM_2, Boxing.boxBoolean(false));
                        if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                            mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                            this.L$0 = mutableMap;
                            this.label = 6;
                            if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                map = mutableMap;
                                SettingsViewModel.this._settings.setValue(map);
                                return Unit.INSTANCE;
                            }
                        } else {
                            mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                            this.L$0 = mutableMap;
                            this.label = 6;
                            if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                map = mutableMap;
                                SettingsViewModel.this._settings.setValue(map);
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    case 4:
                        mutableMap = (Map) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutableMap.put(AppSetting.SEND_SMS_VIA_SIM_1, Boxing.boxBoolean(false));
                        if (this.$setting != AppSetting.HYBRID_PORTAL_ACTIVE) {
                            mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                            this.L$0 = mutableMap;
                            this.label = 6;
                            if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                map = mutableMap;
                                SettingsViewModel.this._settings.setValue(map);
                                return Unit.INSTANCE;
                            }
                        } else {
                            mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                            this.L$0 = mutableMap;
                            this.label = 6;
                            if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                                map = mutableMap;
                                SettingsViewModel.this._settings.setValue(map);
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    case 5:
                        mutableMap = (Map) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            return Unit.INSTANCE;
                        }
                        mutableMap.put(this.$setting, Boxing.boxBoolean(this.$isChecked));
                        this.L$0 = mutableMap;
                        this.label = 6;
                        if (SettingsViewModel.this.settingsRepository.saveSetting(this.$setting, String.valueOf(this.$isChecked), this) != coroutine_suspended) {
                            map = mutableMap;
                            SettingsViewModel.this._settings.setValue(map);
                            return Unit.INSTANCE;
                        }
                        return coroutine_suspended;
                    case 6:
                        map = (Map) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        SettingsViewModel.this._settings.setValue(map);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e) {
                SettingsViewModel.this._snackBarMessage.setValue(e.getMessage());
            }
        }
    }

    public final void updateSetting(AppSetting setting, boolean isChecked) {
        Intrinsics.checkNotNullParameter(setting, "setting");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07881(setting, isChecked, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object attemptEnableHybridPortal(Continuation<? super Boolean> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object setting = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(setting);
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting appSetting = AppSetting.APP_CONNECT_ID;
            anonymousClass1.label = 1;
            setting = settingsRepository.getSetting(appSetting, anonymousClass1);
            if (setting == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(setting);
        }
        if (((String) setting).length() == 0) {
            throw new Exception("Please generate a Connect ID before using this feature");
        }
        return Boxing.boxBoolean(true);
    }

    public final void setUssdSimCard(SimCard simCard) {
        Intrinsics.checkNotNullParameter(simCard, "simCard");
        this._ussdSimCard.setValue(simCard);
    }

    public final void onPaymentSimChanged(SimCard simCard) {
        Intrinsics.checkNotNullParameter(simCard, "simCard");
        List<SimCard> mutableList = CollectionsKt.toMutableList((Collection) this._paymentSimCards.getValue());
        if (mutableList.contains(simCard)) {
            mutableList.remove(simCard);
        } else {
            mutableList.add(simCard);
        }
        this._paymentSimCards.setValue(mutableList);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$initializeApp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$initializeApp$1", f = "SettingsViewModel.kt", i = {1, 2, 2, 3, 3, 4, 4, 5, 5, 6}, l = {ModuleDescriptor.MODULE_VERSION, 156, 164, 173, 178, 179, 182}, m = "invokeSuspend", n = {"hasFinishedOnboardingScreens", "hasFinishedOnboardingScreens", "isLoggedIn", "hasFinishedOnboardingScreens", "isLoggedIn", "hasFinishedOnboardingScreens", "isLoggedIn", "hasFinishedOnboardingScreens", "isLoggedIn", "e"}, s = {"Z$0", "Z$0", "I$0", "Z$0", "I$0", "Z$0", "I$0", "Z$0", "I$0", "L$0"})
    static final class C07841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        boolean Z$0;
        int label;

        C07841(Continuation<? super C07841> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsViewModel.this.new C07841(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x007a  */
        /* JADX WARN: Code duplicated, block: B:31:0x007c  */
        /* JADX WARN: Code duplicated, block: B:34:0x0087  */
        /* JADX WARN: Code duplicated, block: B:35:0x0088  */
        /* JADX WARN: Code duplicated, block: B:37:0x008b A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:39:0x0099 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:40:0x009b A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:46:0x00c0 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:47:0x00c2 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:52:0x00e5  */
        /* JADX WARN: Code duplicated, block: B:53:0x00e6  */
        /* JADX WARN: Code duplicated, block: B:57:0x010a  */
        /* JADX WARN: Code duplicated, block: B:58:0x010b A[Catch: Exception -> 0x0045, PHI: r1 r2
  0x010b: PHI (r1v21 int) = (r1v18 int), (r1v23 int) binds: [B:56:0x0108, B:10:0x0024] A[DONT_GENERATE, DONT_INLINE]
  0x010b: PHI (r2v14 boolean) = (r2v11 boolean), (r2v15 boolean) binds: [B:56:0x0108, B:10:0x0024] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0045, blocks: (B:7:0x001b, B:61:0x0124, B:10:0x0024, B:58:0x010b, B:13:0x002d, B:54:0x00e9, B:55:0x00f4, B:16:0x0036, B:45:0x00b4, B:19:0x003d, B:32:0x007f, B:38:0x008d, B:41:0x009d, B:48:0x00c4, B:50:0x00d3, B:20:0x0041, B:28:0x005e, B:25:0x004b), top: B:68:0x0007 }] */
        /* JADX WARN: Code duplicated, block: B:60:0x0123  */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x014b, code lost:
        
            if (r7.this$0.databaseInitializer.initialize(r7) == r0) goto L65;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            boolean zBooleanValue;
            Object setting;
            boolean z;
            boolean z2;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = 1;
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = SettingsViewModel.this.settingsRepository.isOnBoardingCompleted(this);
                        if (obj != coroutine_suspended) {
                            zBooleanValue = ((Boolean) obj).booleanValue();
                            this.Z$0 = zBooleanValue;
                            this.label = 2;
                            setting = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AGENT_ID, this);
                            if (setting == coroutine_suspended) {
                                z = zBooleanValue;
                                obj = setting;
                                if (((CharSequence) obj).length() <= 0) {
                                    i2 = 0;
                                }
                                if (!z && i2 != 0) {
                                    SettingsViewModel.this._initialRoute.setValue(Route.Home.INSTANCE);
                                } else if (!z && i2 == 0) {
                                    this.Z$0 = z;
                                    this.I$0 = i2;
                                    this.label = 3;
                                    if (DelayKt.delay(1500L, this) != coroutine_suspended) {
                                        int i3 = i2;
                                        z2 = z;
                                        i = i3;
                                        SettingsViewModel.this._initialRoute.setValue(Route.Login.INSTANCE);
                                        this.Z$0 = z2;
                                        this.I$0 = i;
                                        this.label = 5;
                                        if (SettingsViewModel.this.databaseInitializer.initialize(this) != coroutine_suspended) {
                                            this.Z$0 = z2;
                                            this.I$0 = i;
                                            this.label = 6;
                                            obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                                            if (obj == coroutine_suspended) {
                                            }
                                            Boolean.parseBoolean((String) obj);
                                            return Unit.INSTANCE;
                                        }
                                    }
                                } else if (z && i2 != 0) {
                                    SettingsViewModel.this._initialRoute.setValue(Route.Home.INSTANCE);
                                } else {
                                    this.Z$0 = z;
                                    this.I$0 = i2;
                                    this.label = 4;
                                    if (DelayKt.delay(200L, this) != coroutine_suspended) {
                                        int i4 = i2;
                                        z2 = z;
                                        i = i4;
                                        SettingsViewModel.this._initialRoute.setValue(Route.OnboardingScreen1.INSTANCE);
                                        this.Z$0 = z2;
                                        this.I$0 = i;
                                        this.label = 5;
                                        if (SettingsViewModel.this.databaseInitializer.initialize(this) != coroutine_suspended) {
                                            this.Z$0 = z2;
                                            this.I$0 = i;
                                            this.label = 6;
                                            obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                                            if (obj == coroutine_suspended) {
                                            }
                                            Boolean.parseBoolean((String) obj);
                                            return Unit.INSTANCE;
                                        }
                                    }
                                }
                                int i5 = i2;
                                z2 = z;
                                i = i5;
                                this.Z$0 = z2;
                                this.I$0 = i;
                                this.label = 5;
                                if (SettingsViewModel.this.databaseInitializer.initialize(this) != coroutine_suspended) {
                                    this.Z$0 = z2;
                                    this.I$0 = i;
                                    this.label = 6;
                                    obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                                    if (obj == coroutine_suspended) {
                                    }
                                    Boolean.parseBoolean((String) obj);
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        zBooleanValue = ((Boolean) obj).booleanValue();
                        this.Z$0 = zBooleanValue;
                        this.label = 2;
                        setting = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AGENT_ID, this);
                        if (setting == coroutine_suspended) {
                            z = zBooleanValue;
                            obj = setting;
                            if (((CharSequence) obj).length() <= 0) {
                                i2 = 0;
                            }
                            if (!z) {
                                if (!z) {
                                    if (z) {
                                    }
                                    this.Z$0 = z;
                                    this.I$0 = i2;
                                    this.label = 4;
                                    if (DelayKt.delay(200L, this) != coroutine_suspended) {
                                        int i6 = i2;
                                        z2 = z;
                                        i = i6;
                                        SettingsViewModel.this._initialRoute.setValue(Route.OnboardingScreen1.INSTANCE);
                                        this.Z$0 = z2;
                                        this.I$0 = i;
                                        this.label = 5;
                                        if (SettingsViewModel.this.databaseInitializer.initialize(this) != coroutine_suspended) {
                                            this.Z$0 = z2;
                                            this.I$0 = i;
                                            this.label = 6;
                                            obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                                            if (obj == coroutine_suspended) {
                                            }
                                            Boolean.parseBoolean((String) obj);
                                            return Unit.INSTANCE;
                                        }
                                    }
                                } else {
                                    if (z) {
                                    }
                                    this.Z$0 = z;
                                    this.I$0 = i2;
                                    this.label = 4;
                                    if (DelayKt.delay(200L, this) != coroutine_suspended) {
                                        int i7 = i2;
                                        z2 = z;
                                        i = i7;
                                        SettingsViewModel.this._initialRoute.setValue(Route.OnboardingScreen1.INSTANCE);
                                        this.Z$0 = z2;
                                        this.I$0 = i;
                                        this.label = 5;
                                        if (SettingsViewModel.this.databaseInitializer.initialize(this) != coroutine_suspended) {
                                            this.Z$0 = z2;
                                            this.I$0 = i;
                                            this.label = 6;
                                            obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                                            if (obj == coroutine_suspended) {
                                            }
                                            Boolean.parseBoolean((String) obj);
                                            return Unit.INSTANCE;
                                        }
                                    }
                                }
                            } else if (!z) {
                                if (z) {
                                }
                                this.Z$0 = z;
                                this.I$0 = i2;
                                this.label = 4;
                                if (DelayKt.delay(200L, this) != coroutine_suspended) {
                                    int i8 = i2;
                                    z2 = z;
                                    i = i8;
                                    SettingsViewModel.this._initialRoute.setValue(Route.OnboardingScreen1.INSTANCE);
                                    this.Z$0 = z2;
                                    this.I$0 = i;
                                    this.label = 5;
                                    if (SettingsViewModel.this.databaseInitializer.initialize(this) != coroutine_suspended) {
                                        this.Z$0 = z2;
                                        this.I$0 = i;
                                        this.label = 6;
                                        obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                                        if (obj == coroutine_suspended) {
                                        }
                                        Boolean.parseBoolean((String) obj);
                                        return Unit.INSTANCE;
                                    }
                                }
                            } else {
                                if (z) {
                                }
                                this.Z$0 = z;
                                this.I$0 = i2;
                                this.label = 4;
                                if (DelayKt.delay(200L, this) != coroutine_suspended) {
                                    int i9 = i2;
                                    z2 = z;
                                    i = i9;
                                    SettingsViewModel.this._initialRoute.setValue(Route.OnboardingScreen1.INSTANCE);
                                    this.Z$0 = z2;
                                    this.I$0 = i;
                                    this.label = 5;
                                    if (SettingsViewModel.this.databaseInitializer.initialize(this) != coroutine_suspended) {
                                        this.Z$0 = z2;
                                        this.I$0 = i;
                                        this.label = 6;
                                        obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                                        if (obj == coroutine_suspended) {
                                        }
                                        Boolean.parseBoolean((String) obj);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 2:
                        z = this.Z$0;
                        ResultKt.throwOnFailure(obj);
                        if (((CharSequence) obj).length() <= 0) {
                            i2 = 0;
                        }
                        if (!z) {
                            if (!z) {
                                if (z) {
                                }
                                this.Z$0 = z;
                                this.I$0 = i2;
                                this.label = 4;
                                if (DelayKt.delay(200L, this) != coroutine_suspended) {
                                    int i10 = i2;
                                    z2 = z;
                                    i = i10;
                                    SettingsViewModel.this._initialRoute.setValue(Route.OnboardingScreen1.INSTANCE);
                                    this.Z$0 = z2;
                                    this.I$0 = i;
                                    this.label = 5;
                                    if (SettingsViewModel.this.databaseInitializer.initialize(this) != coroutine_suspended) {
                                        this.Z$0 = z2;
                                        this.I$0 = i;
                                        this.label = 6;
                                        obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                                        if (obj == coroutine_suspended) {
                                        }
                                        Boolean.parseBoolean((String) obj);
                                        return Unit.INSTANCE;
                                    }
                                }
                            } else {
                                if (z) {
                                }
                                this.Z$0 = z;
                                this.I$0 = i2;
                                this.label = 4;
                                if (DelayKt.delay(200L, this) != coroutine_suspended) {
                                    int i11 = i2;
                                    z2 = z;
                                    i = i11;
                                    SettingsViewModel.this._initialRoute.setValue(Route.OnboardingScreen1.INSTANCE);
                                    this.Z$0 = z2;
                                    this.I$0 = i;
                                    this.label = 5;
                                    if (SettingsViewModel.this.databaseInitializer.initialize(this) != coroutine_suspended) {
                                        this.Z$0 = z2;
                                        this.I$0 = i;
                                        this.label = 6;
                                        obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                                        if (obj == coroutine_suspended) {
                                        }
                                        Boolean.parseBoolean((String) obj);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                        } else if (!z) {
                            if (z) {
                            }
                            this.Z$0 = z;
                            this.I$0 = i2;
                            this.label = 4;
                            if (DelayKt.delay(200L, this) != coroutine_suspended) {
                                int i12 = i2;
                                z2 = z;
                                i = i12;
                                SettingsViewModel.this._initialRoute.setValue(Route.OnboardingScreen1.INSTANCE);
                                this.Z$0 = z2;
                                this.I$0 = i;
                                this.label = 5;
                                if (SettingsViewModel.this.databaseInitializer.initialize(this) != coroutine_suspended) {
                                    this.Z$0 = z2;
                                    this.I$0 = i;
                                    this.label = 6;
                                    obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                                    if (obj == coroutine_suspended) {
                                    }
                                    Boolean.parseBoolean((String) obj);
                                    return Unit.INSTANCE;
                                }
                            }
                        } else {
                            if (z) {
                            }
                            this.Z$0 = z;
                            this.I$0 = i2;
                            this.label = 4;
                            if (DelayKt.delay(200L, this) != coroutine_suspended) {
                                int i13 = i2;
                                z2 = z;
                                i = i13;
                                SettingsViewModel.this._initialRoute.setValue(Route.OnboardingScreen1.INSTANCE);
                                this.Z$0 = z2;
                                this.I$0 = i;
                                this.label = 5;
                                if (SettingsViewModel.this.databaseInitializer.initialize(this) != coroutine_suspended) {
                                    this.Z$0 = z2;
                                    this.I$0 = i;
                                    this.label = 6;
                                    obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                                    if (obj == coroutine_suspended) {
                                    }
                                    Boolean.parseBoolean((String) obj);
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 3:
                        i = this.I$0;
                        z2 = this.Z$0;
                        ResultKt.throwOnFailure(obj);
                        SettingsViewModel.this._initialRoute.setValue(Route.Login.INSTANCE);
                        this.Z$0 = z2;
                        this.I$0 = i;
                        this.label = 5;
                        if (SettingsViewModel.this.databaseInitializer.initialize(this) != coroutine_suspended) {
                            this.Z$0 = z2;
                            this.I$0 = i;
                            this.label = 6;
                            obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                            if (obj == coroutine_suspended) {
                            }
                            Boolean.parseBoolean((String) obj);
                            return Unit.INSTANCE;
                        }
                        return coroutine_suspended;
                    case 4:
                        i = this.I$0;
                        z2 = this.Z$0;
                        ResultKt.throwOnFailure(obj);
                        SettingsViewModel.this._initialRoute.setValue(Route.OnboardingScreen1.INSTANCE);
                        this.Z$0 = z2;
                        this.I$0 = i;
                        this.label = 5;
                        if (SettingsViewModel.this.databaseInitializer.initialize(this) != coroutine_suspended) {
                            this.Z$0 = z2;
                            this.I$0 = i;
                            this.label = 6;
                            obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                            if (obj == coroutine_suspended) {
                            }
                            Boolean.parseBoolean((String) obj);
                            return Unit.INSTANCE;
                        }
                        return coroutine_suspended;
                    case 5:
                        i = this.I$0;
                        z2 = this.Z$0;
                        ResultKt.throwOnFailure(obj);
                        this.Z$0 = z2;
                        this.I$0 = i;
                        this.label = 6;
                        obj = SettingsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Boolean.parseBoolean((String) obj);
                        return Unit.INSTANCE;
                    case 6:
                        ResultKt.throwOnFailure(obj);
                        Boolean.parseBoolean((String) obj);
                        return Unit.INSTANCE;
                    case 7:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e) {
                SettingsViewModel.this._initialRoute.setValue(Route.OnboardingScreen1.INSTANCE);
                this.L$0 = SpillingKt.nullOutSpilledVariable(e);
                this.label = 7;
            }
        }
    }

    public final void initializeApp() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07841(null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$setOnboardingCompleted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$setOnboardingCompleted$1", f = "SettingsViewModel.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
    static final class C07851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07851(Continuation<? super C07851> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsViewModel.this.new C07851(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SettingsViewModel.this.settingsRepository.setOnBoardingCompleted(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void setOnboardingCompleted() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07851(null), 2, null);
    }

    public final void resetSnackbarMessage() {
        this._snackBarMessage.setValue(null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$setProcessingMode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$setProcessingMode$1", f = "SettingsViewModel.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
    static final class C07861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProcessingMode $processingMode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07861(ProcessingMode processingMode, Continuation<? super C07861> continuation) {
            super(2, continuation);
            this.$processingMode = processingMode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsViewModel.this.new C07861(this.$processingMode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (SettingsViewModel.this.settingsRepository.setProcessingMode(this.$processingMode, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                SettingsViewModel.this._processingMode.setValue(this.$processingMode);
            } catch (Exception e) {
                SettingsViewModel.this._snackBarMessage.setValue(e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    public final void setProcessingMode(ProcessingMode processingMode) {
        Intrinsics.checkNotNullParameter(processingMode, "processingMode");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07861(processingMode, null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$checkAccessibilityActiveStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$checkAccessibilityActiveStatus$1", f = "SettingsViewModel.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
    static final class C07801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07801(Continuation<? super C07801> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsViewModel.this.new C07801(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SettingsViewModel.this.accessibilityRepository.requestAccessibilityStatus(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void checkAccessibilityActiveStatus() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07801(null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$getEngageBotActive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$getEngageBotActive$1", f = "SettingsViewModel.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
    static final class C07821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07821(Continuation<? super C07821> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsViewModel.this.new C07821(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = SettingsViewModel.this.engageBotRepository.getEngageBot(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                SettingsViewModel.this._engageBotActive.setValue(Boxing.boxBoolean(((EngageBot) obj).isActive()));
            } catch (Exception e) {
                SettingsViewModel.this._snackBarMessage.setValue(e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    private final void getEngageBotActive() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07821(null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$toggleEngageBotActive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel$toggleEngageBotActive$1", f = "SettingsViewModel.kt", i = {1, 1}, l = {228, 230}, m = "invokeSuspend", n = {"engageBot", "updatedEngageBot"}, s = {"L$0", "L$1"})
    static final class C07871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isActive;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07871(boolean z, Continuation<? super C07871> continuation) {
            super(2, continuation);
            this.$isActive = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsViewModel.this.new C07871(this.$isActive, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
        
            if (r12.this$0.engageBotRepository.saveEngageBot(r13, r12) == r0) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    SettingsViewModel.this._engageBotActive.setValue(Boxing.boxBoolean(this.$isActive));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = SettingsViewModel.this.engageBotRepository.getEngageBot(this);
                if (obj == coroutine_suspended) {
                }
                return coroutine_suspended;
                EngageBot engageBot = (EngageBot) obj;
                EngageBot engageBotCopy$default = EngageBot.copy$default(engageBot, this.$isActive, null, null, null, null, 0, 62, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(engageBot);
                this.L$1 = SpillingKt.nullOutSpilledVariable(engageBotCopy$default);
                this.label = 2;
            } catch (Exception e) {
                SettingsViewModel.this._snackBarMessage.setValue(e.getMessage());
            }
        }
    }

    public final void toggleEngageBotActive(boolean isActive) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07871(isActive, null), 2, null);
    }
}
