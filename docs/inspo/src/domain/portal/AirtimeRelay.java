package com.example.bingwahybrid.domain.portal;

import android.util.Log;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.repository.BalanceRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.repository.StatisticsRepository;
import com.example.bingwahybrid.domain.socket.SocketService;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AirtimeRelay.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u000e\u0010\u0014\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/example/bingwahybrid/domain/portal/AirtimeRelay;", "Lcom/example/bingwahybrid/domain/portal/SocketRelay;", "balanceRepository", "Lcom/example/bingwahybrid/domain/repository/BalanceRepository;", "statisticsRepository", "Lcom/example/bingwahybrid/domain/repository/StatisticsRepository;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/BalanceRepository;Lcom/example/bingwahybrid/domain/repository/StatisticsRepository;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;)V", "socketService", "Lcom/example/bingwahybrid/domain/socket/SocketService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isPortalActive", "", "setup", "", "registerListeners", "unregisterListeners", "handleAirtimeBalanceSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleAirtimeUsedSync", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AirtimeRelay implements SocketRelay {
    public static final int $stable = 8;
    private final BalanceRepository balanceRepository;
    private final CoroutineScope coroutineScope;
    private final SettingsRepository settingsRepository;
    private SocketService socketService;
    private final StatisticsRepository statisticsRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.AirtimeRelay$handleAirtimeBalanceSync$1, reason: invalid class name */
    /* JADX INFO: compiled from: AirtimeRelay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.AirtimeRelay", f = "AirtimeRelay.kt", i = {1, 2}, l = {59, LockFreeTaskQueueCore.FROZEN_SHIFT, 70}, m = "handleAirtimeBalanceSync", n = {"balance", "e"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return AirtimeRelay.this.handleAirtimeBalanceSync(this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.AirtimeRelay$handleAirtimeUsedSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AirtimeRelay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.AirtimeRelay", f = "AirtimeRelay.kt", i = {1}, l = {86, 87}, m = "handleAirtimeUsedSync", n = {"used"}, s = {"L$0"})
    static final class C06751 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06751(Continuation<? super C06751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AirtimeRelay.this.handleAirtimeUsedSync(this);
        }
    }

    @Inject
    public AirtimeRelay(BalanceRepository balanceRepository, StatisticsRepository statisticsRepository, SettingsRepository settingsRepository) {
        Intrinsics.checkNotNullParameter(balanceRepository, "balanceRepository");
        Intrinsics.checkNotNullParameter(statisticsRepository, "statisticsRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        this.balanceRepository = balanceRepository;
        this.statisticsRepository = statisticsRepository;
        this.settingsRepository = settingsRepository;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    private final boolean isPortalActive() {
        return this.settingsRepository.getHybridPortalActive().getValue().booleanValue();
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
            socketService.on("airtime_balance.sync", new Function1() { // from class: com.example.bingwahybrid.domain.portal.AirtimeRelay$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AirtimeRelay.registerListeners$lambda$0(this.f$0, (List) obj);
                }
            });
        }
        SocketService socketService2 = this.socketService;
        if (socketService2 != null) {
            socketService2.on("airtime_used.sync", new Function1() { // from class: com.example.bingwahybrid.domain.portal.AirtimeRelay$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AirtimeRelay.registerListeners$lambda$1(this.f$0, (List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListeners$lambda$0(AirtimeRelay airtimeRelay, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(airtimeRelay.coroutineScope, null, null, new AirtimeRelay$registerListeners$1$1(airtimeRelay, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListeners$lambda$1(AirtimeRelay airtimeRelay, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(airtimeRelay.coroutineScope, null, null, new AirtimeRelay$registerListeners$2$1(airtimeRelay, null), 3, null);
        return Unit.INSTANCE;
    }

    @Override // com.example.bingwahybrid.domain.portal.SocketRelay
    public void unregisterListeners() {
        SocketService socketService = this.socketService;
        if (socketService != null) {
            socketService.off("airtime_balance.sync");
        }
        SocketService socketService2 = this.socketService;
        if (socketService2 != null) {
            socketService2.off("airtime_used.sync");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x008a A[Catch: Exception -> 0x004e, TRY_LEAVE, TryCatch #0 {Exception -> 0x004e, blocks: (B:17:0x0046, B:32:0x0079, B:34:0x008a, B:18:0x004a, B:29:0x0067, B:26:0x005c), top: B:44:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009e, code lost:
    
        if (r10 == r1) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleAirtimeBalanceSync(Continuation<? super Unit> continuation) throws JSONException {
        AnonymousClass1 anonymousClass1;
        String str;
        JSONObject jSONObject;
        SocketService socketService;
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
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(setting);
                if (!isPortalActive()) {
                    return Unit.INSTANCE;
                }
                BalanceRepository balanceRepository = this.balanceRepository;
                anonymousClass1.label = 1;
                setting = balanceRepository.refreshAirtimeBalance(anonymousClass1);
                if (setting == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(setting);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(setting);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("device", (String) setting);
                    jSONObject2.put("balance", this.balanceRepository.getAirtimeBalance().getValue());
                    SocketService socketService2 = this.socketService;
                    if (socketService2 != null) {
                        socketService2.sendMessage("airtime_balance.sync.ack", jSONObject2);
                    }
                    return Unit.INSTANCE;
                }
                str = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure(setting);
            }
            jSONObject = new JSONObject();
            jSONObject.put("device", (String) setting);
            jSONObject.put("balance", str);
            socketService = this.socketService;
            if (socketService != null) {
                socketService.sendMessage("airtime_balance.sync.ack", jSONObject);
            }
            return Unit.INSTANCE;
            str = (String) setting;
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting appSetting = AppSetting.APP_CONNECT_ID;
            anonymousClass1.L$0 = str;
            anonymousClass1.label = 2;
            setting = settingsRepository.getSetting(appSetting, anonymousClass1);
            if (setting == coroutine_suspended) {
                return coroutine_suspended;
            }
            jSONObject = new JSONObject();
            jSONObject.put("device", (String) setting);
            jSONObject.put("balance", str);
            socketService = this.socketService;
            if (socketService != null) {
                socketService.sendMessage("airtime_balance.sync.ack", jSONObject);
            }
        } catch (Exception e) {
            SettingsRepository settingsRepository2 = this.settingsRepository;
            AppSetting appSetting2 = AppSetting.APP_CONNECT_ID;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(e);
            anonymousClass1.label = 3;
            setting = settingsRepository2.getSetting(appSetting2, anonymousClass1);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x0081 A[Catch: Exception -> 0x0087, TRY_LEAVE, TryCatch #0 {Exception -> 0x0087, blocks: (B:13:0x002d, B:30:0x006c, B:32:0x0081, B:17:0x0039, B:26:0x0058, B:23:0x0049), top: B:38:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleAirtimeUsedSync(Continuation<? super Unit> continuation) {
        C06751 c06751;
        Double d;
        JSONObject jSONObject;
        SocketService socketService;
        if (continuation instanceof C06751) {
            c06751 = (C06751) continuation;
            if ((c06751.label & Integer.MIN_VALUE) != 0) {
                c06751.label -= Integer.MIN_VALUE;
            } else {
                c06751 = new C06751(continuation);
            }
        } else {
            c06751 = new C06751(continuation);
        }
        Object objFirst = c06751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06751.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objFirst);
                if (!isPortalActive()) {
                    return Unit.INSTANCE;
                }
                Flow<Double> airtimeUsedToday = this.statisticsRepository.getAirtimeUsedToday();
                c06751.label = 1;
                objFirst = FlowKt.first(airtimeUsedToday, c06751);
                if (objFirst == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(objFirst);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d = (Double) c06751.L$0;
                ResultKt.throwOnFailure(objFirst);
            }
            jSONObject = new JSONObject();
            jSONObject.put("device", (String) objFirst);
            jSONObject.put("used", d);
            socketService = this.socketService;
            if (socketService != null) {
                socketService.sendMessage("airtime_used.sync.ack", jSONObject);
            }
            return Unit.INSTANCE;
            Double d2 = (Double) objFirst;
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting appSetting = AppSetting.APP_CONNECT_ID;
            c06751.L$0 = d2;
            c06751.label = 2;
            Object setting = settingsRepository.getSetting(appSetting, c06751);
            if (setting != coroutine_suspended) {
                d = d2;
                objFirst = setting;
                jSONObject = new JSONObject();
                jSONObject.put("device", (String) objFirst);
                jSONObject.put("used", d);
                socketService = this.socketService;
                if (socketService != null) {
                    socketService.sendMessage("airtime_used.sync.ack", jSONObject);
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Exception e) {
            Log.e("AirtimeRelay", "Error syncing airtime used: " + e.getMessage(), e);
        }
    }
}
