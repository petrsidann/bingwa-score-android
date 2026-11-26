package com.example.bingwahybrid.domain.portal;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.enums.SubscriptionType;
import com.example.bingwahybrid.domain.portal.events.KpiEvent;
import com.example.bingwahybrid.domain.repository.AgentCommissionRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.socket.SocketService;
import com.example.bingwahybrid.domain.subscriptions.model.Subscription;
import com.example.bingwahybrid.domain.subscriptions.model.SubscriptionKt;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: KpiRelay.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0016\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u000e\u0010\u001b\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/example/bingwahybrid/domain/portal/KpiRelay;", "Lcom/example/bingwahybrid/domain/portal/SocketRelay;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "subscriptionRepository", "Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;", "agentCommissionRepository", "Lcom/example/bingwahybrid/domain/repository/AgentCommissionRepository;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;Lcom/example/bingwahybrid/domain/repository/AgentCommissionRepository;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;)V", "socketService", "Lcom/example/bingwahybrid/domain/socket/SocketService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isPortalActive", "", "setup", "", "registerListeners", "unregisterListeners", "send", NotificationCompat.CATEGORY_EVENT, "Lcom/example/bingwahybrid/domain/portal/events/KpiEvent;", "(Lcom/example/bingwahybrid/domain/portal/events/KpiEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startSyncOnChange", "handleKpiSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KpiRelay implements SocketRelay {
    public static final int $stable = 8;
    private final AgentCommissionRepository agentCommissionRepository;
    private final CoroutineScope coroutineScope;
    private final SettingsRepository settingsRepository;
    private SocketService socketService;
    private final SubscriptionRepository subscriptionRepository;
    private final TransactionRepository transactionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.KpiRelay$handleKpiSync$1, reason: invalid class name */
    /* JADX INFO: compiled from: KpiRelay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.KpiRelay", f = "KpiRelay.kt", i = {1, 2, 2, 3, 3, 3}, l = {84, 85, 86, 89}, m = "handleKpiSync", n = {"successCount", "successCount", "failedCount", "currentConnectId", "successCount", "failedCount"}, s = {"I$0", "I$0", "I$1", "L$0", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KpiRelay.this.handleKpiSync(this);
        }
    }

    @Inject
    public KpiRelay(TransactionRepository transactionRepository, SubscriptionRepository subscriptionRepository, AgentCommissionRepository agentCommissionRepository, SettingsRepository settingsRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        Intrinsics.checkNotNullParameter(agentCommissionRepository, "agentCommissionRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        this.transactionRepository = transactionRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.agentCommissionRepository = agentCommissionRepository;
        this.settingsRepository = settingsRepository;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPortalActive() {
        return this.settingsRepository.getHybridPortalActive().getValue().booleanValue();
    }

    @Override // com.example.bingwahybrid.domain.portal.SocketRelay
    public void setup(SocketService socketService) {
        Intrinsics.checkNotNullParameter(socketService, "socketService");
        this.socketService = socketService;
        startSyncOnChange();
    }

    @Override // com.example.bingwahybrid.domain.portal.SocketRelay
    public void registerListeners() {
        SocketService socketService = this.socketService;
        if (socketService != null) {
            socketService.on("kpis.sync", new Function1() { // from class: com.example.bingwahybrid.domain.portal.KpiRelay$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return KpiRelay.registerListeners$lambda$0(this.f$0, (List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListeners$lambda$0(KpiRelay kpiRelay, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(kpiRelay.coroutineScope, null, null, new KpiRelay$registerListeners$1$1(kpiRelay, null), 3, null);
        return Unit.INSTANCE;
    }

    @Override // com.example.bingwahybrid.domain.portal.SocketRelay
    public void unregisterListeners() {
        SocketService socketService = this.socketService;
        if (socketService != null) {
            socketService.off("kpis.sync");
        }
    }

    public final Object send(KpiEvent kpiEvent, Continuation<? super Unit> continuation) throws JSONException {
        if (!(kpiEvent instanceof KpiEvent.Sync)) {
            throw new NoWhenBranchMatchedException();
        }
        Object objHandleKpiSync = handleKpiSync(continuation);
        return objHandleKpiSync == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objHandleKpiSync : Unit.INSTANCE;
    }

    private final void startSyncOnChange() {
        FlowKt.launchIn(FlowKt.onEach(FlowKt.distinctUntilChanged(FlowKt.combine(this.transactionRepository.getSuccessCount(), this.transactionRepository.getFailedCount(), new C06801(null))), new AnonymousClass2(null)), this.coroutineScope);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.KpiRelay$startSyncOnChange$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: KpiRelay.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "success", "failed"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.KpiRelay$startSyncOnChange$1", f = "KpiRelay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06801 extends SuspendLambda implements Function3<Integer, Integer, Continuation<? super Pair<? extends Integer, ? extends Integer>>, Object> {
        /* synthetic */ int I$0;
        /* synthetic */ int I$1;
        int label;

        C06801(Continuation<? super C06801> continuation) {
            super(3, continuation);
        }

        public final Object invoke(int i, int i2, Continuation<? super Pair<Integer, Integer>> continuation) {
            C06801 c06801 = new C06801(continuation);
            c06801.I$0 = i;
            c06801.I$1 = i2;
            return c06801.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Integer num2, Continuation<? super Pair<? extends Integer, ? extends Integer>> continuation) {
            return invoke(num.intValue(), num2.intValue(), (Continuation<? super Pair<Integer, Integer>>) continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.I$0;
            int i2 = this.I$1;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return TuplesKt.to(Boxing.boxInt(i), Boxing.boxInt(i2));
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.KpiRelay$startSyncOnChange$2, reason: invalid class name */
    /* JADX INFO: compiled from: KpiRelay.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.KpiRelay$startSyncOnChange$2", f = "KpiRelay.kt", i = {0}, l = {73}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends Integer>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = KpiRelay.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Pair<? extends Integer, ? extends Integer> pair, Continuation<? super Unit> continuation) {
            return invoke2((Pair<Integer, Integer>) pair, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Pair<Integer, Integer> pair, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Pair pair = (Pair) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (KpiRelay.this.isPortalActive()) {
                    Log.d("KpiRelay", "KPI change detected: success=" + pair.getFirst() + ", failed=" + pair.getSecond());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(pair);
                    this.label = 1;
                    if (KpiRelay.this.handleKpiSync(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x009f  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:49:0x0118 A[LOOP:1: B:47:0x0112->B:49:0x0118, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x0135  */
    /* JADX WARN: Code duplicated, block: B:60:0x015c  */
    /* JADX WARN: Code duplicated, block: B:61:0x015e  */
    /* JADX WARN: Code duplicated, block: B:64:0x0174  */
    /* JADX WARN: Code duplicated, block: B:70:0x0191  */
    /* JADX WARN: Code duplicated, block: B:73:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:91:0x018a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x016e A[SYNTHETIC] */
    public final Object handleKpiSync(Continuation<? super Unit> continuation) throws JSONException {
        AnonymousClass1 anonymousClass1;
        int iIntValue;
        int iIntValue2;
        Object setting;
        int i;
        int i2;
        String str;
        Object activeSubscriptions;
        String str2;
        int i3;
        int i4;
        Iterator it;
        long limit;
        Iterator it2;
        Long lBoxLong;
        Long l;
        Long lBoxLong2;
        JSONObject jSONObject;
        SocketService socketService;
        Subscription subscription;
        Subscription subscription2;
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
        Object objFirst = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = anonymousClass1.label;
        if (i5 != 0) {
            if (i5 == 1) {
                ResultKt.throwOnFailure(objFirst);
            } else {
                if (i5 == 2) {
                    iIntValue = anonymousClass1.I$0;
                    ResultKt.throwOnFailure(objFirst);
                    iIntValue2 = ((Number) objFirst).intValue();
                    SettingsRepository settingsRepository = this.settingsRepository;
                    AppSetting appSetting = AppSetting.APP_CONNECT_ID;
                    anonymousClass1.I$0 = iIntValue;
                    anonymousClass1.I$1 = iIntValue2;
                    anonymousClass1.label = 3;
                    setting = settingsRepository.getSetting(appSetting, anonymousClass1);
                    if (setting != coroutine_suspended) {
                        int i6 = iIntValue;
                        i = iIntValue2;
                        objFirst = setting;
                        i2 = i6;
                        str = (String) objFirst;
                        Log.d("KpiRelay", "Syncing KPIS: successCount=" + i2 + ", failedCount=" + i);
                        SubscriptionRepository subscriptionRepository = this.subscriptionRepository;
                        anonymousClass1.L$0 = str;
                        anonymousClass1.I$0 = i2;
                        anonymousClass1.I$1 = i;
                        anonymousClass1.label = 4;
                        activeSubscriptions = subscriptionRepository.getActiveSubscriptions(anonymousClass1);
                        if (activeSubscriptions != coroutine_suspended) {
                            str2 = str;
                            objFirst = activeSubscriptions;
                            i3 = i;
                            i4 = i2;
                        }
                    }
                    return coroutine_suspended;
                }
                if (i5 == 3) {
                    i = anonymousClass1.I$1;
                    i2 = anonymousClass1.I$0;
                    ResultKt.throwOnFailure(objFirst);
                    str = (String) objFirst;
                    Log.d("KpiRelay", "Syncing KPIS: successCount=" + i2 + ", failedCount=" + i);
                    SubscriptionRepository subscriptionRepository2 = this.subscriptionRepository;
                    anonymousClass1.L$0 = str;
                    anonymousClass1.I$0 = i2;
                    anonymousClass1.I$1 = i;
                    anonymousClass1.label = 4;
                    activeSubscriptions = subscriptionRepository2.getActiveSubscriptions(anonymousClass1);
                    if (activeSubscriptions != coroutine_suspended) {
                        str2 = str;
                        objFirst = activeSubscriptions;
                        i3 = i;
                        i4 = i2;
                    }
                    return coroutine_suspended;
                }
                if (i5 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i3 = anonymousClass1.I$1;
                i4 = anonymousClass1.I$0;
                str2 = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objFirst);
            }
            List list = (List) objFirst;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                subscription2 = (Subscription) obj;
                if (subscription2.getType() != SubscriptionType.LIMITED && !SubscriptionKt.isExpired(subscription2)) {
                    arrayList.add(obj);
                }
            }
            it = arrayList.iterator();
            limit = 0;
            while (it.hasNext()) {
                limit += ((Subscription) it.next()).getLimit();
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list) {
                subscription = (Subscription) obj2;
                if (subscription.getType() != SubscriptionType.UNLIMITED && !SubscriptionKt.isExpired(subscription)) {
                    arrayList2.add(obj2);
                }
            }
            it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                lBoxLong = Boxing.boxLong(((Subscription) it2.next()).getLimit());
                while (it2.hasNext()) {
                    lBoxLong2 = Boxing.boxLong(((Subscription) it2.next()).getLimit());
                    if (lBoxLong.compareTo(lBoxLong2) < 0) {
                        lBoxLong = lBoxLong2;
                    }
                }
                l = lBoxLong;
            } else {
                l = null;
            }
            Long l2 = l;
            long jLongValue = l2 != null ? l2.longValue() : 0L;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", str2);
            jSONObject2.put("successCount", i4);
            jSONObject2.put("failedCount", i3);
            jSONObject2.put("limitedTokens", limit);
            jSONObject2.put("unlimitedTokensExpiry", jLongValue);
            jSONObject = new JSONObject();
            jSONObject.put("kpis", jSONObject2);
            socketService = this.socketService;
            if (socketService != null) {
                socketService.sendMessage("kpis.sync.ack", jSONObject);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(objFirst);
        if (!isPortalActive()) {
            return Unit.INSTANCE;
        }
        Flow<Integer> successCount = this.transactionRepository.getSuccessCount();
        anonymousClass1.label = 1;
        objFirst = FlowKt.first(successCount, anonymousClass1);
        if (objFirst != coroutine_suspended) {
        }
        return coroutine_suspended;
        iIntValue = ((Number) objFirst).intValue();
        Flow<Integer> failedCount = this.transactionRepository.getFailedCount();
        anonymousClass1.I$0 = iIntValue;
        anonymousClass1.label = 2;
        objFirst = FlowKt.first(failedCount, anonymousClass1);
        if (objFirst != coroutine_suspended) {
            iIntValue2 = ((Number) objFirst).intValue();
            SettingsRepository settingsRepository2 = this.settingsRepository;
            AppSetting appSetting2 = AppSetting.APP_CONNECT_ID;
            anonymousClass1.I$0 = iIntValue;
            anonymousClass1.I$1 = iIntValue2;
            anonymousClass1.label = 3;
            setting = settingsRepository2.getSetting(appSetting2, anonymousClass1);
            if (setting != coroutine_suspended) {
                int i7 = iIntValue;
                i = iIntValue2;
                objFirst = setting;
                i2 = i7;
                str = (String) objFirst;
                Log.d("KpiRelay", "Syncing KPIS: successCount=" + i2 + ", failedCount=" + i);
                SubscriptionRepository subscriptionRepository3 = this.subscriptionRepository;
                anonymousClass1.L$0 = str;
                anonymousClass1.I$0 = i2;
                anonymousClass1.I$1 = i;
                anonymousClass1.label = 4;
                activeSubscriptions = subscriptionRepository3.getActiveSubscriptions(anonymousClass1);
                if (activeSubscriptions != coroutine_suspended) {
                    str2 = str;
                    objFirst = activeSubscriptions;
                    i3 = i;
                    i4 = i2;
                    List list2 = (List) objFirst;
                    ArrayList arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        subscription2 = (Subscription) obj;
                        if (subscription2.getType() != SubscriptionType.LIMITED) {
                        }
                    }
                    it = arrayList3.iterator();
                    limit = 0;
                    while (it.hasNext()) {
                        limit += ((Subscription) it.next()).getLimit();
                    }
                    ArrayList arrayList4 = new ArrayList();
                    while (r14.hasNext()) {
                        subscription = (Subscription) obj2;
                        if (subscription.getType() != SubscriptionType.UNLIMITED) {
                        }
                    }
                    it2 = arrayList4.iterator();
                    if (it2.hasNext()) {
                        l = null;
                    } else {
                        lBoxLong = Boxing.boxLong(((Subscription) it2.next()).getLimit());
                        while (it2.hasNext()) {
                            lBoxLong2 = Boxing.boxLong(((Subscription) it2.next()).getLimit());
                            if (lBoxLong.compareTo(lBoxLong2) < 0) {
                                lBoxLong = lBoxLong2;
                            }
                        }
                        l = lBoxLong;
                    }
                    Long l3 = l;
                    if (l3 != null) {
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("device", str2);
                    jSONObject3.put("successCount", i4);
                    jSONObject3.put("failedCount", i3);
                    jSONObject3.put("limitedTokens", limit);
                    jSONObject3.put("unlimitedTokensExpiry", jLongValue);
                    jSONObject = new JSONObject();
                    jSONObject.put("kpis", jSONObject3);
                    socketService = this.socketService;
                    if (socketService != null) {
                        socketService.sendMessage("kpis.sync.ack", jSONObject);
                    }
                    return Unit.INSTANCE;
                }
            }
        }
        return coroutine_suspended;
    }
}
