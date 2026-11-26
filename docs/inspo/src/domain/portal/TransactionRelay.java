package com.example.bingwahybrid.domain.portal;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.portal.events.TransactionEvent;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.socket.SocketService;
import com.example.bingwahybrid.domain.usecase.DeleteTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.RetryTransactionUseCase;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.UUID;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TransactionRelay.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\u001c\u0010\u001f\u001a\u00020\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0082@¢\u0006\u0002\u0010#J\u001c\u0010$\u001a\u00020\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0082@¢\u0006\u0002\u0010#J\u001c\u0010%\u001a\u00020\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0082@¢\u0006\u0002\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\n \u0012*\u0004\u0018\u00010\n0\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Lcom/example/bingwahybrid/domain/portal/TransactionRelay;", "Lcom/example/bingwahybrid/domain/portal/SocketRelay;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "retryTransactionUseCaseProvider", "Ljavax/inject/Provider;", "Lcom/example/bingwahybrid/domain/usecase/RetryTransactionUseCase;", "deleteTransactionUseCaseProvider", "Lcom/example/bingwahybrid/domain/usecase/DeleteTransactionUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "socketService", "Lcom/example/bingwahybrid/domain/socket/SocketService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "deleteTransactionUseCase", "kotlin.jvm.PlatformType", "getDeleteTransactionUseCase", "()Lcom/example/bingwahybrid/domain/usecase/DeleteTransactionUseCase;", "isPortalActive", "", "send", "", NotificationCompat.CATEGORY_EVENT, "Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent;", "(Lcom/example/bingwahybrid/domain/portal/events/TransactionEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setup", "registerListeners", "unregisterListeners", "handleRetryTransaction", "args", "", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleTransactionsSync", "handleTransactionDelete", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TransactionRelay implements SocketRelay {
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope;
    private final Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider;
    private final Provider<RetryTransactionUseCase> retryTransactionUseCaseProvider;
    private final SettingsRepository settingsRepository;
    private SocketService socketService;
    private final TransactionRepository transactionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.TransactionRelay$handleRetryTransaction$1, reason: invalid class name */
    /* JADX INFO: compiled from: TransactionRelay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.TransactionRelay", f = "TransactionRelay.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {116, 118}, m = "handleRetryTransaction", n = {"args", "params", "transactionIdStr", "transactionId", "args", "params", "transactionIdStr", "transactionId", "transaction"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransactionRelay.this.handleRetryTransaction(null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.TransactionRelay$handleTransactionDelete$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransactionRelay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.TransactionRelay", f = "TransactionRelay.kt", i = {0, 0, 0, 0}, l = {178}, m = "handleTransactionDelete", n = {"args", "params", "transactionIdStr", "transactionId"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C06831 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C06831(Continuation<? super C06831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransactionRelay.this.handleTransactionDelete(null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.TransactionRelay$handleTransactionsSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransactionRelay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.TransactionRelay", f = "TransactionRelay.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {133, 136, 163}, m = "handleTransactionsSync", n = {"args", "params", "offset", "limit", "args", "params", "currentConnectId", "offset", "limit", "args", "params", "currentConnectId", "batch", "transaction", "payload", "offset", "limit", "total", FirebaseAnalytics.Param.INDEX, "current"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2", "I$4", "I$5"})
    static final class C06841 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C06841(Continuation<? super C06841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransactionRelay.this.handleTransactionsSync(null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.TransactionRelay$send$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransactionRelay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.TransactionRelay", f = "TransactionRelay.kt", i = {0}, l = {41}, m = "send", n = {NotificationCompat.CATEGORY_EVENT}, s = {"L$0"})
    static final class C06851 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06851(Continuation<? super C06851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransactionRelay.this.send(null, this);
        }
    }

    public TransactionRelay(SettingsRepository settingsRepository, TransactionRepository transactionRepository, Provider<RetryTransactionUseCase> retryTransactionUseCaseProvider, Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(retryTransactionUseCaseProvider, "retryTransactionUseCaseProvider");
        Intrinsics.checkNotNullParameter(deleteTransactionUseCaseProvider, "deleteTransactionUseCaseProvider");
        this.settingsRepository = settingsRepository;
        this.transactionRepository = transactionRepository;
        this.retryTransactionUseCaseProvider = retryTransactionUseCaseProvider;
        this.deleteTransactionUseCaseProvider = deleteTransactionUseCaseProvider;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    private final DeleteTransactionUseCase getDeleteTransactionUseCase() {
        return this.deleteTransactionUseCaseProvider.get();
    }

    private final boolean isPortalActive() {
        return this.settingsRepository.getHybridPortalActive().getValue().booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object send(TransactionEvent transactionEvent, Continuation<? super Unit> continuation) throws JSONException {
        C06851 c06851;
        if (continuation instanceof C06851) {
            c06851 = (C06851) continuation;
            if ((c06851.label & Integer.MIN_VALUE) != 0) {
                c06851.label -= Integer.MIN_VALUE;
            } else {
                c06851 = new C06851(continuation);
            }
        } else {
            c06851 = new C06851(continuation);
        }
        Object setting = c06851.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06851.label;
        if (i == 0) {
            ResultKt.throwOnFailure(setting);
            if (!isPortalActive()) {
                return Unit.INSTANCE;
            }
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting appSetting = AppSetting.APP_CONNECT_ID;
            c06851.L$0 = transactionEvent;
            c06851.label = 1;
            setting = settingsRepository.getSetting(appSetting, c06851);
            if (setting == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            transactionEvent = (TransactionEvent) c06851.L$0;
            ResultKt.throwOnFailure(setting);
        }
        String str = (String) setting;
        if (transactionEvent instanceof TransactionEvent.New) {
            JSONObject json = ((TransactionEvent.New) transactionEvent).getTransaction().toJson();
            json.put("device", str);
            SocketService socketService = this.socketService;
            if (socketService != null) {
                socketService.sendMessage(transactionEvent.getEventName(), json);
            }
        } else if (transactionEvent instanceof TransactionEvent.Deleted) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("device", str);
            jSONObject.put("id", ((TransactionEvent.Deleted) transactionEvent).getTransactionId());
            SocketService socketService2 = this.socketService;
            if (socketService2 != null) {
                socketService2.sendMessage(transactionEvent.getEventName(), jSONObject);
            }
        } else if (transactionEvent instanceof TransactionEvent.Rescheduled) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", str);
            TransactionEvent.Rescheduled rescheduled = (TransactionEvent.Rescheduled) transactionEvent;
            jSONObject2.put("id", rescheduled.getTransactionId());
            jSONObject2.put("time", rescheduled.getNewTime());
            jSONObject2.put("offerId", rescheduled.getOfferId());
            SocketService socketService3 = this.socketService;
            if (socketService3 != null) {
                socketService3.sendMessage(transactionEvent.getEventName(), jSONObject2);
            }
        } else {
            if (!(transactionEvent instanceof TransactionEvent.StatusChanged)) {
                throw new NoWhenBranchMatchedException();
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("device", str);
            TransactionEvent.StatusChanged statusChanged = (TransactionEvent.StatusChanged) transactionEvent;
            jSONObject3.put("id", statusChanged.getTransactionId());
            jSONObject3.put(NotificationCompat.CATEGORY_STATUS, statusChanged.getStatus().name());
            jSONObject3.put("message", statusChanged.getMessage());
            SocketService socketService4 = this.socketService;
            if (socketService4 != null) {
                socketService4.sendMessage(transactionEvent.getEventName(), jSONObject3);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.example.bingwahybrid.domain.portal.SocketRelay
    public void setup(SocketService socketService) {
        Intrinsics.checkNotNullParameter(socketService, "socketService");
        this.socketService = socketService;
    }

    @Override // com.example.bingwahybrid.domain.portal.SocketRelay
    public void registerListeners() {
        SocketService socketService = this.socketService;
        if (socketService != null) {
            socketService.on("transaction.retry", new Function1() { // from class: com.example.bingwahybrid.domain.portal.TransactionRelay$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TransactionRelay.registerListeners$lambda$3(this.f$0, (List) obj);
                }
            });
        }
        SocketService socketService2 = this.socketService;
        if (socketService2 != null) {
            socketService2.on("transactions.sync", new Function1() { // from class: com.example.bingwahybrid.domain.portal.TransactionRelay$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TransactionRelay.registerListeners$lambda$4(this.f$0, (List) obj);
                }
            });
        }
        SocketService socketService3 = this.socketService;
        if (socketService3 != null) {
            socketService3.on("transaction.delete", new Function1() { // from class: com.example.bingwahybrid.domain.portal.TransactionRelay$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TransactionRelay.registerListeners$lambda$5(this.f$0, (List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListeners$lambda$3(TransactionRelay transactionRelay, List args) {
        Intrinsics.checkNotNullParameter(args, "args");
        BuildersKt__Builders_commonKt.launch$default(transactionRelay.coroutineScope, null, null, new TransactionRelay$registerListeners$1$1(transactionRelay, args, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListeners$lambda$4(TransactionRelay transactionRelay, List args) {
        Intrinsics.checkNotNullParameter(args, "args");
        BuildersKt__Builders_commonKt.launch$default(transactionRelay.coroutineScope, null, null, new TransactionRelay$registerListeners$2$1(transactionRelay, args, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListeners$lambda$5(TransactionRelay transactionRelay, List args) {
        Intrinsics.checkNotNullParameter(args, "args");
        BuildersKt__Builders_commonKt.launch$default(transactionRelay.coroutineScope, null, null, new TransactionRelay$registerListeners$3$1(transactionRelay, args, null), 3, null);
        return Unit.INSTANCE;
    }

    @Override // com.example.bingwahybrid.domain.portal.SocketRelay
    public void unregisterListeners() {
        SocketService socketService = this.socketService;
        if (socketService != null) {
            socketService.off("transaction.retry");
        }
        SocketService socketService2 = this.socketService;
        if (socketService2 != null) {
            socketService2.off("transactions.sync");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fa, code lost:
    
        if (r10.invoke(r12, r0) == r1) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleRetryTransaction(List<? extends Object> list, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        JSONObject jSONObject;
        String strOptString;
        UUID uuidFromString;
        JSONObject jSONObject2;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    UUID uuid = (UUID) anonymousClass1.L$3;
                    strOptString = (String) anonymousClass1.L$2;
                    jSONObject2 = (JSONObject) anonymousClass1.L$1;
                    List<? extends Object> list2 = (List) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    uuidFromString = uuid;
                    list = list2;
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            if (list.size() <= 0 || !(list.get(0) instanceof JSONObject)) {
                jSONObject = null;
            } else {
                Object obj2 = list.get(0);
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject = (JSONObject) obj2;
            }
            strOptString = jSONObject != null ? jSONObject.optString("transactionId") : null;
            if (strOptString == null) {
                Log.d("TransactionRelay", "Could not get transaction ID");
                return Unit.INSTANCE;
            }
            uuidFromString = UUID.fromString(strOptString);
            TransactionRepository transactionRepository = this.transactionRepository;
            Intrinsics.checkNotNull(uuidFromString);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(strOptString);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(uuidFromString);
            anonymousClass1.label = 1;
            Object transactionById = transactionRepository.getTransactionById(uuidFromString, anonymousClass1);
            if (transactionById != coroutine_suspended) {
                jSONObject2 = jSONObject;
                obj = transactionById;
            }
            return coroutine_suspended;
            Transaction transaction = (Transaction) obj;
            if (transaction != null) {
                RetryTransactionUseCase retryTransactionUseCase = this.retryTransactionUseCaseProvider.get();
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(strOptString);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(uuidFromString);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(transaction);
                anonymousClass1.label = 2;
            }
        } catch (Exception e) {
            Log.e("TransactionRelay", "Error retrying transaction: " + e);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:55:0x0169  */
    /* JADX WARN: Code duplicated, block: B:57:0x0190  */
    /* JADX WARN: Code duplicated, block: B:61:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x01ce -> B:62:0x01d4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object handleTransactionsSync(java.util.List<? extends java.lang.Object> r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instruction units count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.domain.portal.TransactionRelay.handleTransactionsSync(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object handleTransactionDelete(List<? extends Object> list, Continuation<? super Unit> continuation) {
        C06831 c06831;
        JSONObject jSONObject;
        UUID uuid;
        if (continuation instanceof C06831) {
            c06831 = (C06831) continuation;
            if ((c06831.label & Integer.MIN_VALUE) != 0) {
                c06831.label -= Integer.MIN_VALUE;
            } else {
                c06831 = new C06831(continuation);
            }
        } else {
            c06831 = new C06831(continuation);
        }
        Object obj = c06831.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06831.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (list.size() <= 0 || !(list.get(0) instanceof JSONObject)) {
                    jSONObject = null;
                } else {
                    Object obj2 = list.get(0);
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) obj2;
                }
                String strOptString = jSONObject != null ? jSONObject.optString("transactionId") : null;
                if (strOptString == null) {
                    Log.d("TransactionRelay", "Could not get transaction ID from server delete request");
                    return Unit.INSTANCE;
                }
                UUID uuidFromString = UUID.fromString(strOptString);
                DeleteTransactionUseCase deleteTransactionUseCase = getDeleteTransactionUseCase();
                Intrinsics.checkNotNull(uuidFromString);
                c06831.L$0 = SpillingKt.nullOutSpilledVariable(list);
                c06831.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject);
                c06831.L$2 = SpillingKt.nullOutSpilledVariable(strOptString);
                c06831.L$3 = uuidFromString;
                c06831.label = 1;
                if (deleteTransactionUseCase.invoke(uuidFromString, false, c06831) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                uuid = uuidFromString;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                uuid = (UUID) c06831.L$3;
                ResultKt.throwOnFailure(obj);
            }
            Log.d("TransactionRelay", "Transaction " + uuid + " deleted via server command.");
        } catch (Exception e) {
            Log.e("TransactionRelay", "Error handling server-initiated delete: " + e);
        }
        return Unit.INSTANCE;
    }
}
