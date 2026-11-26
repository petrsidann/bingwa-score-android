package com.example.bingwahybrid.domain.engine;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.IBinder;
import androidx.compose.material.MenuKt;
import androidx.core.app.NotificationCompat;
import com.example.bingwahybrid.R;
import com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl;
import com.example.bingwahybrid.domain.engine.pipeline.TransactionPipeline;
import com.example.bingwahybrid.domain.engine.pipeline.chains.FailureChain;
import com.example.bingwahybrid.domain.engine.pipeline.chains.TimeoutChain;
import com.example.bingwahybrid.domain.enums.AppState;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.google.firebase.analytics.FirebaseAnalytics;
import dagger.hilt.android.AndroidEntryPoint;
import io.ktor.http.LinkHeader;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: UssdDialerService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020-H\u0002J)\u0010/\u001a\u00020-2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\n\b\u0002\u00103\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u00104J\b\u00105\u001a\u00020-H\u0002J\b\u00109\u001a\u00020-H\u0016J\u0014\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\"\u0010>\u001a\u00020?2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020?H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/UssdDialerService;", "Landroid/app/Service;", "<init>", "()V", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "getTransactionRepository", "()Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "setTransactionRepository", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;)V", "appControl", "Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;", "getAppControl", "()Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;", "setAppControl", "(Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;)V", "transactionPipeline", "Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionPipeline;", "getTransactionPipeline", "()Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionPipeline;", "setTransactionPipeline", "(Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionPipeline;)V", "failureChain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/FailureChain;", "getFailureChain", "()Lcom/example/bingwahybrid/domain/engine/pipeline/chains/FailureChain;", "setFailureChain", "(Lcom/example/bingwahybrid/domain/engine/pipeline/chains/FailureChain;)V", "timeoutChain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/TimeoutChain;", "getTimeoutChain", "()Lcom/example/bingwahybrid/domain/engine/pipeline/chains/TimeoutChain;", "setTimeoutChain", "(Lcom/example/bingwahybrid/domain/engine/pipeline/chains/TimeoutChain;)V", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "isProcessingQueue", "", "hasShownStandByMode", "lastProcessedTransactionTime", "", "Ljava/lang/Long;", "onCreate", "", "createNotificationChannel", "showNotification", LinkHeader.Parameters.Title, "", FirebaseAnalytics.Param.CONTENT, "time", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "processQueue", "allowedWhenNotRunning", "", "Lcom/example/bingwahybrid/domain/enums/TransactionType;", "onDestroy", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "Companion", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class UssdDialerService extends Hilt_UssdDialerService {
    private static volatile boolean isRunning;

    @Inject
    public AppControl appControl;

    @Inject
    public FailureChain failureChain;
    private boolean hasShownStandByMode;
    private boolean isProcessingQueue;
    private Long lastProcessedTransactionTime;

    @Inject
    public TimeoutChain timeoutChain;

    @Inject
    public TransactionPipeline transactionPipeline;

    @Inject
    public TransactionRepository transactionRepository;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final CoroutineScope serviceScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);
    private final Set<TransactionType> allowedWhenNotRunning = SetsKt.setOf((Object[]) new TransactionType[]{TransactionType.QUICK_DIAL, TransactionType.SUBSCRIPTION_RENEWAL, TransactionType.AIRTIME_BALANCE_CHECK});

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: compiled from: UssdDialerService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/UssdDialerService$Companion;", "", "<init>", "()V", "isRunning", "", "()Z", "setRunning", "(Z)V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isRunning() {
            return UssdDialerService.isRunning;
        }

        public final void setRunning(boolean z) {
            UssdDialerService.isRunning = z;
        }
    }

    public final TransactionRepository getTransactionRepository() {
        TransactionRepository transactionRepository = this.transactionRepository;
        if (transactionRepository != null) {
            return transactionRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transactionRepository");
        return null;
    }

    public final void setTransactionRepository(TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "<set-?>");
        this.transactionRepository = transactionRepository;
    }

    public final AppControl getAppControl() {
        AppControl appControl = this.appControl;
        if (appControl != null) {
            return appControl;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appControl");
        return null;
    }

    public final void setAppControl(AppControl appControl) {
        Intrinsics.checkNotNullParameter(appControl, "<set-?>");
        this.appControl = appControl;
    }

    public final TransactionPipeline getTransactionPipeline() {
        TransactionPipeline transactionPipeline = this.transactionPipeline;
        if (transactionPipeline != null) {
            return transactionPipeline;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transactionPipeline");
        return null;
    }

    public final void setTransactionPipeline(TransactionPipeline transactionPipeline) {
        Intrinsics.checkNotNullParameter(transactionPipeline, "<set-?>");
        this.transactionPipeline = transactionPipeline;
    }

    public final FailureChain getFailureChain() {
        FailureChain failureChain = this.failureChain;
        if (failureChain != null) {
            return failureChain;
        }
        Intrinsics.throwUninitializedPropertyAccessException("failureChain");
        return null;
    }

    public final void setFailureChain(FailureChain failureChain) {
        Intrinsics.checkNotNullParameter(failureChain, "<set-?>");
        this.failureChain = failureChain;
    }

    public final TimeoutChain getTimeoutChain() {
        TimeoutChain timeoutChain = this.timeoutChain;
        if (timeoutChain != null) {
            return timeoutChain;
        }
        Intrinsics.throwUninitializedPropertyAccessException("timeoutChain");
        return null;
    }

    public final void setTimeoutChain(TimeoutChain timeoutChain) {
        Intrinsics.checkNotNullParameter(timeoutChain, "<set-?>");
        this.timeoutChain = timeoutChain;
    }

    @Override // com.example.bingwahybrid.domain.engine.Hilt_UssdDialerService, android.app.Service
    public void onCreate() {
        super.onCreate();
        isRunning = true;
        createNotificationChannel();
        processQueue();
    }

    private final void createNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel("BINGWA_HYBRID_DIALER_SERVICE", "Bingwa Hybrid Dialer Service", 3);
        notificationChannel.enableVibration(false);
        notificationChannel.setSound(null, null);
        notificationChannel.enableLights(false);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    static /* synthetic */ void showNotification$default(UssdDialerService ussdDialerService, String str, String str2, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        ussdDialerService.showNotification(str, str2, l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNotification(String title, String content, Long time) {
        Notification notificationBuild = new NotificationCompat.Builder(this, "BINGWA_HYBRID_DIALER_SERVICE").setContentTitle(title).setContentText(content).setWhen(time != null ? time.longValue() : System.currentTimeMillis()).setShowWhen(true).setSmallIcon(R.drawable.logo).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        startForeground(2, notificationBuild);
    }

    private final void processQueue() {
        if (this.isProcessingQueue) {
            return;
        }
        this.isProcessingQueue = true;
        BuildersKt__Builders_commonKt.launch$default(this.serviceScope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.UssdDialerService$processQueue$1, reason: invalid class name */
    /* JADX INFO: compiled from: UssdDialerService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.UssdDialerService$processQueue$1", f = "UssdDialerService.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {115, MenuKt.InTransitionDuration, WebSocketProtocol.PAYLOAD_SHORT}, m = "invokeSuspend", n = {"$this$launch", "transactionQueue", "nextTransaction", "$this$launch", "transactionQueue", "nextTransaction", "$this$launch", "transactionQueue", "nextTransaction", "transaction"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = UssdDialerService.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PriorityBlockingQueue<Transaction> transactionQueue;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1 && i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                transactionQueue = (PriorityBlockingQueue) this.L$1;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                transactionQueue = UssdDialerService.this.getTransactionRepository().getTransactionQueue();
            }
            while (CoroutineScopeKt.isActive(coroutineScope)) {
                Transaction transactionPeek = transactionQueue.peek();
                if (transactionPeek == null) {
                    if (!UssdDialerService.this.hasShownStandByMode) {
                        UssdDialerService ussdDialerService = UssdDialerService.this;
                        ussdDialerService.showNotification("StandBy Mode", "All transactions have been processed", ussdDialerService.lastProcessedTransactionTime);
                        UssdDialerService.this.hasShownStandByMode = true;
                    }
                    this.L$0 = coroutineScope;
                    this.L$1 = transactionQueue;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(transactionPeek);
                    this.L$3 = null;
                    this.label = 1;
                    if (DelayKt.delay(900L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (UssdDialerService.this.getAppControl().getAppState().getValue() != AppState.STATE_RUNNING && !UssdDialerService.this.allowedWhenNotRunning.contains(transactionPeek.getType())) {
                    this.L$0 = coroutineScope;
                    this.L$1 = transactionQueue;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(transactionPeek);
                    this.L$3 = null;
                    this.label = 2;
                    if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    Transaction transactionPoll = transactionQueue.poll();
                    if (transactionPoll == null) {
                        continue;
                    } else {
                        UssdDialerService.this.hasShownStandByMode = false;
                        this.L$0 = coroutineScope;
                        this.L$1 = transactionQueue;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(transactionPeek);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(transactionPoll);
                        this.label = 3;
                        if (BuildersKt.withContext(Dispatchers.getIO(), new C01271(UssdDialerService.this, transactionPoll, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.UssdDialerService$processQueue$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: UssdDialerService.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/example/bingwahybrid/domain/model/Transaction;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.UssdDialerService$processQueue$1$1", f = "UssdDialerService.kt", i = {2, 3}, l = {128, 130, 134, 136}, m = "invokeSuspend", n = {"<unused var>", "e"}, s = {"L$0", "L$0"})
        static final class C01271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Transaction>, Object> {
            final /* synthetic */ Transaction $transaction;
            Object L$0;
            int label;
            final /* synthetic */ UssdDialerService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01271(UssdDialerService ussdDialerService, Transaction transaction, Continuation<? super C01271> continuation) {
                super(2, continuation);
                this.this$0 = ussdDialerService;
                this.$transaction = transaction;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01271(this.this$0, this.$transaction, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Transaction> continuation) {
                return ((C01271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:39:0x00a1  */
            /* JADX WARN: Code duplicated, block: B:55:0x013f A[PHI: r0
  0x013f: PHI (r0v10 com.example.bingwahybrid.domain.model.Transaction) = (r0v9 com.example.bingwahybrid.domain.model.Transaction), (r0v13 com.example.bingwahybrid.domain.model.Transaction) binds: [B:54:0x013d, B:47:0x0114] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x012e, code lost:
            
                if (r0 == r3) goto L51;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object objProceed;
                Object objProceed2;
                Transaction transaction;
                Object objWithTimeout;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    try {
                        try {
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (Mutex.DefaultImpls.lock$default(this.this$0.mutex, null, this, 1, null) == coroutine_suspended) {
                                }
                                return coroutine_suspended;
                            }
                            if (i == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                if (i != 2) {
                                    if (i == 3) {
                                        ResultKt.throwOnFailure(obj);
                                        objProceed2 = obj;
                                        transaction = (Transaction) objProceed2;
                                        if (this.this$0.mutex.isLocked()) {
                                            Mutex.DefaultImpls.unlock$default(this.this$0.mutex, null, 1, null);
                                        }
                                        this.this$0.lastProcessedTransactionTime = Boxing.boxLong(System.currentTimeMillis());
                                        return transaction;
                                    }
                                    if (i != 4) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                    objProceed = obj;
                                    transaction = (Transaction) objProceed;
                                    if (this.this$0.mutex.isLocked()) {
                                        Mutex.DefaultImpls.unlock$default(this.this$0.mutex, null, 1, null);
                                    }
                                    this.this$0.lastProcessedTransactionTime = Boxing.boxLong(System.currentTimeMillis());
                                    return transaction;
                                }
                                ResultKt.throwOnFailure(obj);
                                objWithTimeout = obj;
                            }
                            Transaction transaction2 = (Transaction) objWithTimeout;
                            if (this.this$0.mutex.isLocked()) {
                                Mutex.DefaultImpls.unlock$default(this.this$0.mutex, null, 1, null);
                            }
                            this.this$0.lastProcessedTransactionTime = Boxing.boxLong(System.currentTimeMillis());
                            return transaction2;
                            UssdDialerService.showNotification$default(this.this$0, "Processing", "Processing transaction", null, 4, null);
                            Offer offer = this.$transaction.getOffer();
                            long ussdTimeoutMillis = offer != null ? offer.getUssdTimeoutMillis() : 40000L;
                            this.label = 2;
                            objWithTimeout = TimeoutKt.withTimeout(ussdTimeoutMillis, new C01281(this.this$0, this.$transaction, null), this);
                            if (objWithTimeout == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Transaction transaction3 = (Transaction) objWithTimeout;
                            if (this.this$0.mutex.isLocked()) {
                                Mutex.DefaultImpls.unlock$default(this.this$0.mutex, null, 1, null);
                            }
                            this.this$0.lastProcessedTransactionTime = Boxing.boxLong(System.currentTimeMillis());
                            return transaction3;
                        } catch (TimeoutCancellationException e) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(e);
                            this.label = 3;
                            objProceed2 = this.this$0.getTimeoutChain().proceed(this.$transaction, this);
                        }
                    } catch (Exception e2) {
                        FailureChain failureChain = this.this$0.getFailureChain();
                        TransactionStatus transactionStatus = TransactionStatus.FAILED;
                        String str = "Unexpected error: " + e2.getMessage();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(e2);
                        this.label = 4;
                        objProceed = failureChain.proceed(Transaction.copy$default(this.$transaction, null, null, 0, 0L, null, str, transactionStatus, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null), this);
                        if (objProceed == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } catch (Throwable th) {
                    if (this.this$0.mutex.isLocked()) {
                        Mutex.DefaultImpls.unlock$default(this.this$0.mutex, null, 1, null);
                    }
                    this.this$0.lastProcessedTransactionTime = Boxing.boxLong(System.currentTimeMillis());
                    throw th;
                }
            }

            /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.UssdDialerService$processQueue$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: UssdDialerService.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/example/bingwahybrid/domain/model/Transaction;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.UssdDialerService$processQueue$1$1$1", f = "UssdDialerService.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
            static final class C01281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Transaction>, Object> {
                final /* synthetic */ Transaction $transaction;
                int label;
                final /* synthetic */ UssdDialerService this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01281(UssdDialerService ussdDialerService, Transaction transaction, Continuation<? super C01281> continuation) {
                    super(2, continuation);
                    this.this$0 = ussdDialerService;
                    this.$transaction = transaction;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01281(this.this$0, this.$transaction, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Transaction> continuation) {
                    return ((C01281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i != 0) {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objExecute = this.this$0.getTransactionPipeline().execute(this.$transaction, this);
                    return objExecute == coroutine_suspended ? coroutine_suspended : objExecute;
                }
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        CoroutineScopeKt.cancel$default(this.serviceScope, null, 1, null);
        isRunning = false;
        this.isProcessingQueue = false;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        showNotification$default(this, "Processing", "Processing transaction", null, 4, null);
        return 1;
    }
}
