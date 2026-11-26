package com.example.bingwahybrid.domain.app_lifecycle;

import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl;
import com.example.bingwahybrid.domain.engine.UssdDialerService;
import com.example.bingwahybrid.domain.enums.AppState;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.DialPausedTransactionsUseCase;
import com.example.bingwahybrid.domain.usecase.DialSkippedTransactionsUseCase;
import com.example.bingwahybrid.infrastructure.messaging.FcmTokenRegistrationHelper;
import com.example.bingwahybrid.infrastructure.sms.services.SmsProcessingService;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AppLifecycleManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B;\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/example/bingwahybrid/domain/app_lifecycle/AppLifecycleManager;", "", "context", "Landroid/content/Context;", "appControl", "Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "dialSkippedTransactionsUseCase", "Lcom/example/bingwahybrid/domain/usecase/DialSkippedTransactionsUseCase;", "dialPausedTransactionsUseCase", "Lcom/example/bingwahybrid/domain/usecase/DialPausedTransactionsUseCase;", "fcmTokenRegistrationHelper", "Lcom/example/bingwahybrid/infrastructure/messaging/FcmTokenRegistrationHelper;", "<init>", "(Landroid/content/Context;Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/usecase/DialSkippedTransactionsUseCase;Lcom/example/bingwahybrid/domain/usecase/DialPausedTransactionsUseCase;Lcom/example/bingwahybrid/infrastructure/messaging/FcmTokenRegistrationHelper;)V", "previousAppState", "Lcom/example/bingwahybrid/domain/enums/AppState;", "start", "", "startUssdDialerService", "stopUssdDialerService", "startSmsProcessingService", "stopSmsProcessingService", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppLifecycleManager {
    public static final int $stable = 8;
    private final AppControl appControl;
    private final Context context;
    private final DialPausedTransactionsUseCase dialPausedTransactionsUseCase;
    private final DialSkippedTransactionsUseCase dialSkippedTransactionsUseCase;
    private final FcmTokenRegistrationHelper fcmTokenRegistrationHelper;
    private AppState previousAppState;
    private final TransactionRepository transactionRepository;

    @Inject
    public AppLifecycleManager(@ApplicationContext Context context, AppControl appControl, TransactionRepository transactionRepository, DialSkippedTransactionsUseCase dialSkippedTransactionsUseCase, DialPausedTransactionsUseCase dialPausedTransactionsUseCase, FcmTokenRegistrationHelper fcmTokenRegistrationHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appControl, "appControl");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(dialSkippedTransactionsUseCase, "dialSkippedTransactionsUseCase");
        Intrinsics.checkNotNullParameter(dialPausedTransactionsUseCase, "dialPausedTransactionsUseCase");
        Intrinsics.checkNotNullParameter(fcmTokenRegistrationHelper, "fcmTokenRegistrationHelper");
        this.context = context;
        this.appControl = appControl;
        this.transactionRepository = transactionRepository;
        this.dialSkippedTransactionsUseCase = dialSkippedTransactionsUseCase;
        this.dialPausedTransactionsUseCase = dialPausedTransactionsUseCase;
        this.fcmTokenRegistrationHelper = fcmTokenRegistrationHelper;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.app_lifecycle.AppLifecycleManager$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppLifecycleManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.app_lifecycle.AppLifecycleManager$start$1", f = "AppLifecycleManager.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AppLifecycleManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.domain.app_lifecycle.AppLifecycleManager$start$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AppLifecycleManager.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        static final class C01261<T> implements FlowCollector {
            final /* synthetic */ AppLifecycleManager this$0;

            /* JADX INFO: renamed from: com.example.bingwahybrid.domain.app_lifecycle.AppLifecycleManager$start$1$1$WhenMappings */
            /* JADX INFO: compiled from: AppLifecycleManager.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[AppState.values().length];
                    try {
                        iArr[AppState.STATE_RUNNING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[AppState.STATE_PAUSED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[AppState.STATE_STOPPED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            C01261(AppLifecycleManager appLifecycleManager) {
                this.this$0 = appLifecycleManager;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00b1, code lost:
            
                if (r7.invoke(r0) == r1) goto L34;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(AppState appState, Continuation<? super Unit> continuation) {
                AppLifecycleManager$start$1$1$emit$1 appLifecycleManager$start$1$1$emit$1;
                if (continuation instanceof AppLifecycleManager$start$1$1$emit$1) {
                    appLifecycleManager$start$1$1$emit$1 = (AppLifecycleManager$start$1$1$emit$1) continuation;
                    if ((appLifecycleManager$start$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                        appLifecycleManager$start$1$1$emit$1.label -= Integer.MIN_VALUE;
                    } else {
                        appLifecycleManager$start$1$1$emit$1 = new AppLifecycleManager$start$1$1$emit$1(this, continuation);
                    }
                } else {
                    appLifecycleManager$start$1$1$emit$1 = new AppLifecycleManager$start$1$1$emit$1(this, continuation);
                }
                Object obj = appLifecycleManager$start$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = appLifecycleManager$start$1$1$emit$1.label;
                if (i != 0) {
                    if (i == 1) {
                        appState = (AppState) appLifecycleManager$start$1$1$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        appState = (AppState) appLifecycleManager$start$1$1$emit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    this.this$0.fcmTokenRegistrationHelper.registerFcmToken();
                    this.this$0.previousAppState = appState;
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                int i2 = WhenMappings.$EnumSwitchMapping$0[appState.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            this.this$0.transactionRepository.cleanupTransactions();
                            this.this$0.stopSmsProcessingService();
                            this.this$0.stopUssdDialerService();
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else if (this.this$0.previousAppState != AppState.STATE_PAUSED) {
                        this.this$0.stopUssdDialerService();
                    }
                } else if (this.this$0.previousAppState != AppState.STATE_RUNNING) {
                    this.this$0.startSmsProcessingService();
                    this.this$0.startUssdDialerService();
                    DialSkippedTransactionsUseCase dialSkippedTransactionsUseCase = this.this$0.dialSkippedTransactionsUseCase;
                    appLifecycleManager$start$1$1$emit$1.L$0 = appState;
                    appLifecycleManager$start$1$1$emit$1.label = 1;
                    if (dialSkippedTransactionsUseCase.invoke(appLifecycleManager$start$1$1$emit$1) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                this.this$0.previousAppState = appState;
                return Unit.INSTANCE;
                DialPausedTransactionsUseCase dialPausedTransactionsUseCase = this.this$0.dialPausedTransactionsUseCase;
                appLifecycleManager$start$1$1$emit$1.L$0 = appState;
                appLifecycleManager$start$1$1$emit$1.label = 2;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((AppState) obj, (Continuation<? super Unit>) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AppLifecycleManager.this.appControl.getAppState().collect(new C01261(AppLifecycleManager.this), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public final void start() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startUssdDialerService() {
        if (UssdDialerService.INSTANCE.isRunning()) {
            return;
        }
        ContextCompat.startForegroundService(this.context, new Intent(this.context, (Class<?>) UssdDialerService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopUssdDialerService() {
        this.context.stopService(new Intent(this.context, (Class<?>) UssdDialerService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startSmsProcessingService() {
        if (SmsProcessingService.INSTANCE.isRunning()) {
            return;
        }
        ContextCompat.startForegroundService(this.context, new Intent(this.context, (Class<?>) SmsProcessingService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopSmsProcessingService() {
        this.context.stopService(new Intent(this.context, (Class<?>) SmsProcessingService.class));
    }
}
