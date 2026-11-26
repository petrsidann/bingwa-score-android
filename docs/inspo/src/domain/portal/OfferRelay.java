package com.example.bingwahybrid.domain.portal;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.portal.events.OfferEvent;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.socket.SocketService;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
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
import okhttp3.internal.http.HttpStatusCodesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: OfferRelay.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u000e\u0010\u0014\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0082@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0082@¢\u0006\u0002\u0010\u001aJ\b\u0010\u001c\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/example/bingwahybrid/domain/portal/OfferRelay;", "Lcom/example/bingwahybrid/domain/portal/SocketRelay;", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;)V", "socketService", "Lcom/example/bingwahybrid/domain/socket/SocketService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isPortalActive", "", "send", "", NotificationCompat.CATEGORY_EVENT, "Lcom/example/bingwahybrid/domain/portal/events/OfferEvent;", "setup", "registerListeners", "handleSyncOffers", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUpdateOffer", "args", "", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleDeleteOffer", "unregisterListeners", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfferRelay implements SocketRelay {
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope;
    private final OfferRepository offerRepository;
    private final SettingsRepository settingsRepository;
    private SocketService socketService;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.OfferRelay$handleDeleteOffer$1, reason: invalid class name */
    /* JADX INFO: compiled from: OfferRelay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.OfferRelay", f = "OfferRelay.kt", i = {0, 0, 0, 1, 1, 1}, l = {128, 129}, m = "handleDeleteOffer", n = {"args", "offerIdString", "offerId", "args", "offerIdString", "offerId"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfferRelay.this.handleDeleteOffer(null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.OfferRelay$handleSyncOffers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfferRelay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.OfferRelay", f = "OfferRelay.kt", i = {1}, l = {70, 71}, m = "handleSyncOffers", n = {"offers"}, s = {"L$0"})
    static final class C06811 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06811(Continuation<? super C06811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfferRelay.this.handleSyncOffers(this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.OfferRelay$handleUpdateOffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfferRelay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.OfferRelay", f = "OfferRelay.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {HttpStatusCodesKt.HTTP_EARLY_HINTS, LocationRequestCompat.QUALITY_LOW_POWER}, m = "handleUpdateOffer", n = {"args", "payload", "offerJson", "offer", "args", "payload", "offerJson", "offer", "updatedOffer"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C06821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C06821(Continuation<? super C06821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfferRelay.this.handleUpdateOffer(null, this);
        }
    }

    public final void send(OfferEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Inject
    public OfferRelay(OfferRepository offerRepository, SettingsRepository settingsRepository) {
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        this.offerRepository = offerRepository;
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
            socketService.on("offers.sync", new Function1() { // from class: com.example.bingwahybrid.domain.portal.OfferRelay$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OfferRelay.registerListeners$lambda$0(this.f$0, (List) obj);
                }
            });
        }
        SocketService socketService2 = this.socketService;
        if (socketService2 != null) {
            socketService2.on("offer.update", new Function1() { // from class: com.example.bingwahybrid.domain.portal.OfferRelay$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OfferRelay.registerListeners$lambda$1(this.f$0, (List) obj);
                }
            });
        }
        SocketService socketService3 = this.socketService;
        if (socketService3 != null) {
            socketService3.on("offer.delete", new Function1() { // from class: com.example.bingwahybrid.domain.portal.OfferRelay$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OfferRelay.registerListeners$lambda$2(this.f$0, (List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListeners$lambda$0(OfferRelay offerRelay, List list) {
        Intrinsics.checkNotNullParameter(list, "<unused var>");
        BuildersKt__Builders_commonKt.launch$default(offerRelay.coroutineScope, null, null, new OfferRelay$registerListeners$1$1(offerRelay, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListeners$lambda$1(OfferRelay offerRelay, List args) {
        Intrinsics.checkNotNullParameter(args, "args");
        BuildersKt__Builders_commonKt.launch$default(offerRelay.coroutineScope, null, null, new OfferRelay$registerListeners$2$1(offerRelay, args, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListeners$lambda$2(OfferRelay offerRelay, List args) {
        Intrinsics.checkNotNullParameter(args, "args");
        BuildersKt__Builders_commonKt.launch$default(offerRelay.coroutineScope, null, null, new OfferRelay$registerListeners$3$1(offerRelay, args, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x007b A[LOOP:0: B:28:0x0075->B:30:0x007b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:33:0x009c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleSyncOffers(Continuation<? super Unit> continuation) throws JSONException {
        C06811 c06811;
        List list;
        JSONArray jSONArray;
        Iterator it;
        JSONObject jSONObject;
        SocketService socketService;
        if (continuation instanceof C06811) {
            c06811 = (C06811) continuation;
            if ((c06811.label & Integer.MIN_VALUE) != 0) {
                c06811.label -= Integer.MIN_VALUE;
            } else {
                c06811 = new C06811(continuation);
            }
        } else {
            c06811 = new C06811(continuation);
        }
        Object allOffers = c06811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06811.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(allOffers);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) c06811.L$0;
                ResultKt.throwOnFailure(allOffers);
            }
            String str = (String) allOffers;
            jSONArray = new JSONArray();
            it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Offer) it.next()).toJson());
            }
            jSONObject = new JSONObject();
            jSONObject.put("device", str);
            jSONObject.put("offers", jSONArray);
            socketService = this.socketService;
            if (socketService != null) {
                socketService.sendMessage("offers.sync.ack", jSONObject);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(allOffers);
        if (!isPortalActive()) {
            return Unit.INSTANCE;
        }
        OfferRepository offerRepository = this.offerRepository;
        c06811.label = 1;
        allOffers = offerRepository.getAllOffers(c06811);
        if (allOffers != coroutine_suspended) {
        }
        return coroutine_suspended;
        List list2 = (List) allOffers;
        SettingsRepository settingsRepository = this.settingsRepository;
        AppSetting appSetting = AppSetting.APP_CONNECT_ID;
        c06811.L$0 = list2;
        c06811.label = 2;
        Object setting = settingsRepository.getSetting(appSetting, c06811);
        if (setting != coroutine_suspended) {
            list = list2;
            allOffers = setting;
            String str2 = (String) allOffers;
            jSONArray = new JSONArray();
            it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Offer) it.next()).toJson());
            }
            jSONObject = new JSONObject();
            jSONObject.put("device", str2);
            jSONObject.put("offers", jSONArray);
            socketService = this.socketService;
            if (socketService != null) {
                socketService.sendMessage("offers.sync.ack", jSONObject);
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:53:0x011c A[Catch: Exception -> 0x0066, TRY_LEAVE, TryCatch #0 {Exception -> 0x0066, blocks: (B:13:0x0041, B:51:0x0105, B:53:0x011c, B:18:0x005e, B:47:0x00d9, B:43:0x00ad), top: B:58:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleUpdateOffer(List<? extends Object> list, Continuation<? super Unit> continuation) {
        C06821 c06821;
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        Offer offerFromJson;
        JSONObject jSONObject2;
        Offer offer;
        JSONObject jSONObject3;
        SocketService socketService;
        if (continuation instanceof C06821) {
            c06821 = (C06821) continuation;
            if ((c06821.label & Integer.MIN_VALUE) != 0) {
                c06821.label -= Integer.MIN_VALUE;
            } else {
                c06821 = new C06821(continuation);
            }
        } else {
            c06821 = new C06821(continuation);
        }
        Object obj = c06821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06821.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!isPortalActive()) {
                    return Unit.INSTANCE;
                }
                if (list.size() <= 0 || !(list.get(0) instanceof JSONObject)) {
                    jSONObject = null;
                } else {
                    Object obj2 = list.get(0);
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) obj2;
                }
                if (jSONObject == null) {
                    return Unit.INSTANCE;
                }
                jSONObjectOptJSONObject = jSONObject.optJSONObject("offer");
                if (jSONObjectOptJSONObject == null) {
                    Log.e("OfferSocketHandler", "Key 'offer' missing in JSONObject");
                    return Unit.INSTANCE;
                }
                offerFromJson = Offer.INSTANCE.fromJson(jSONObjectOptJSONObject);
                OfferRepository offerRepository = this.offerRepository;
                c06821.L$0 = SpillingKt.nullOutSpilledVariable(list);
                c06821.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject);
                c06821.L$2 = SpillingKt.nullOutSpilledVariable(jSONObjectOptJSONObject);
                c06821.L$3 = SpillingKt.nullOutSpilledVariable(offerFromJson);
                c06821.label = 1;
                Object objUpdateOffer = offerRepository.updateOffer(offerFromJson, c06821);
                if (objUpdateOffer != coroutine_suspended) {
                    jSONObject2 = jSONObject;
                    obj = objUpdateOffer;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                Offer offer2 = (Offer) c06821.L$3;
                jSONObjectOptJSONObject = (JSONObject) c06821.L$2;
                jSONObject2 = (JSONObject) c06821.L$1;
                List<? extends Object> list2 = (List) c06821.L$0;
                ResultKt.throwOnFailure(obj);
                offerFromJson = offer2;
                list = list2;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                offer = (Offer) c06821.L$4;
                ResultKt.throwOnFailure(obj);
            }
            jSONObject3 = new JSONObject();
            jSONObject3.put("device", (String) obj);
            jSONObject3.put("offer", offer.toJson());
            socketService = this.socketService;
            if (socketService != null) {
                socketService.sendMessage("offer.update.ack", jSONObject3);
            }
            return Unit.INSTANCE;
            Offer offer3 = (Offer) obj;
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting appSetting = AppSetting.APP_CONNECT_ID;
            c06821.L$0 = SpillingKt.nullOutSpilledVariable(list);
            c06821.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject2);
            c06821.L$2 = SpillingKt.nullOutSpilledVariable(jSONObjectOptJSONObject);
            c06821.L$3 = SpillingKt.nullOutSpilledVariable(offerFromJson);
            c06821.L$4 = offer3;
            c06821.label = 2;
            Object setting = settingsRepository.getSetting(appSetting, c06821);
            if (setting != coroutine_suspended) {
                obj = setting;
                offer = offer3;
                jSONObject3 = new JSONObject();
                jSONObject3.put("device", (String) obj);
                jSONObject3.put("offer", offer.toJson());
                socketService = this.socketService;
                if (socketService != null) {
                    socketService.sendMessage("offer.update.ack", jSONObject3);
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Exception e) {
            Log.e("OfferSocketHandler", "Error updating offer: " + e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:47:0x00e7 A[Catch: Exception -> 0x00ed, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ed, blocks: (B:13:0x0035, B:45:0x00c7, B:47:0x00e7, B:18:0x004e, B:41:0x00a9, B:38:0x0089), top: B:53:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleDeleteOffer(List<? extends Object> list, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        String str;
        String str2;
        UUID uuidFromString;
        UUID uuid;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!isPortalActive()) {
                    return Unit.INSTANCE;
                }
                if (list.size() <= 0 || !(list.get(0) instanceof String)) {
                    str = null;
                } else {
                    Object obj2 = list.get(0);
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    str = (String) obj2;
                }
                str2 = str;
                if (str2 == null) {
                    return Unit.INSTANCE;
                }
                uuidFromString = UUID.fromString(str2);
                OfferRepository offerRepository = this.offerRepository;
                Intrinsics.checkNotNull(uuidFromString);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.L$2 = uuidFromString;
                anonymousClass1.label = 1;
                if (offerRepository.deleteOfferById(uuidFromString, anonymousClass1) == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                UUID uuid2 = (UUID) anonymousClass1.L$2;
                str2 = (String) anonymousClass1.L$1;
                List<? extends Object> list2 = (List) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                uuidFromString = uuid2;
                list = list2;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                uuid = (UUID) anonymousClass1.L$2;
                ResultKt.throwOnFailure(obj);
            }
            jSONObject = new JSONObject();
            jSONObject.put("device", (String) obj);
            jSONObject.put("offerId", uuid.toString());
            jSONObject.put("success", "true");
            socketService = this.socketService;
            if (socketService != null) {
                socketService.sendMessage("offer.delete.ack", jSONObject);
            }
            return Unit.INSTANCE;
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting appSetting = AppSetting.APP_CONNECT_ID;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.L$2 = uuidFromString;
            anonymousClass1.label = 2;
            Object setting = settingsRepository.getSetting(appSetting, anonymousClass1);
            if (setting != coroutine_suspended) {
                UUID uuid3 = uuidFromString;
                obj = setting;
                uuid = uuid3;
                jSONObject = new JSONObject();
                jSONObject.put("device", (String) obj);
                jSONObject.put("offerId", uuid.toString());
                jSONObject.put("success", "true");
                socketService = this.socketService;
                if (socketService != null) {
                    socketService.sendMessage("offer.delete.ack", jSONObject);
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Exception e) {
            Log.e("OfferSocketHandler", "Error deleting offer: " + e.getMessage(), e);
        }
    }

    @Override // com.example.bingwahybrid.domain.portal.SocketRelay
    public void unregisterListeners() {
        SocketService socketService = this.socketService;
        if (socketService != null) {
            socketService.off("offers.sync");
        }
        SocketService socketService2 = this.socketService;
        if (socketService2 != null) {
            socketService2.off("offer.update");
        }
        SocketService socketService3 = this.socketService;
        if (socketService3 != null) {
            socketService3.off("offer.delete");
        }
    }
}
