package com.example.bingwahybrid.domain.portal;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.enums.AppState;
import com.example.bingwahybrid.domain.portal.events.AppEvent;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.security.TokenRefreshService;
import com.example.bingwahybrid.domain.security.exceptions.TokenExpiredException;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import com.example.bingwahybrid.domain.socket.SocketService;
import java.util.List;
import javax.inject.Inject;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppRelay.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\u000e\u0010\u001a\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u00020\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0082@¢\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/example/bingwahybrid/domain/portal/AppRelay;", "Lcom/example/bingwahybrid/domain/portal/SocketRelay;", "appControl", "Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "tokenRepository", "Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;", "tokenRefreshService", "Lcom/example/bingwahybrid/domain/security/TokenRefreshService;", "<init>", "(Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;Lcom/example/bingwahybrid/domain/security/TokenRefreshService;)V", "socketService", "Lcom/example/bingwahybrid/domain/socket/SocketService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isPortalActive", "", "setup", "", "registerListeners", "unregisterListeners", "send", NotificationCompat.CATEGORY_EVENT, "Lcom/example/bingwahybrid/domain/portal/events/AppEvent;", "handleAppStateSync", "handleAppStatusQuery", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleAppStateSet", "args", "", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateAndRefreshAccessToken", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppRelay implements SocketRelay {
    public static final int $stable = 8;
    private final AppControl appControl;
    private final CoroutineScope coroutineScope;
    private final SettingsRepository settingsRepository;
    private SocketService socketService;
    private final TokenRefreshService tokenRefreshService;
    private final TokenRepository tokenRepository;

    /* JADX INFO: compiled from: AppRelay.kt */
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

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.AppRelay$handleAppStateSet$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppRelay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.AppRelay", f = "AppRelay.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {117, 127, 133, 137, 141}, m = "handleAppStateSet", n = {"args", "payload", "stateString", "args", "payload", "stateString", "currentConnectId", "state", "currentState", "args", "payload", "stateString", "currentConnectId", "state", "currentState", "args", "payload", "stateString", "currentConnectId", "state", "args", "payload", "stateString", "currentConnectId", "state"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C06761 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C06761(Continuation<? super C06761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppRelay.this.handleAppStateSet(null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.AppRelay$handleAppStatusQuery$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppRelay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.AppRelay", f = "AppRelay.kt", i = {}, l = {99}, m = "handleAppStatusQuery", n = {}, s = {})
    static final class C06771 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06771(Continuation<? super C06771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppRelay.this.handleAppStatusQuery(this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.AppRelay$validateAndRefreshAccessToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppRelay.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.AppRelay", f = "AppRelay.kt", i = {1, 2, 2}, l = {157, 160, 167}, m = "validateAndRefreshAccessToken", n = {"e", "e", "refreshToken"}, s = {"L$0", "L$0", "L$1"})
    static final class C06791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C06791(Continuation<? super C06791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppRelay.this.validateAndRefreshAccessToken(this);
        }
    }

    @Inject
    public AppRelay(AppControl appControl, SettingsRepository settingsRepository, TokenRepository tokenRepository, TokenRefreshService tokenRefreshService) {
        Intrinsics.checkNotNullParameter(appControl, "appControl");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(tokenRepository, "tokenRepository");
        Intrinsics.checkNotNullParameter(tokenRefreshService, "tokenRefreshService");
        this.appControl = appControl;
        this.settingsRepository = settingsRepository;
        this.tokenRepository = tokenRepository;
        this.tokenRefreshService = tokenRefreshService;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.coroutineScope = CoroutineScope;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
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
            socketService.on("app.status", new Function1() { // from class: com.example.bingwahybrid.domain.portal.AppRelay$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AppRelay.registerListeners$lambda$0(this.f$0, (List) obj);
                }
            });
        }
        SocketService socketService2 = this.socketService;
        if (socketService2 != null) {
            socketService2.on("app_state.sync", new Function1() { // from class: com.example.bingwahybrid.domain.portal.AppRelay$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AppRelay.registerListeners$lambda$1(this.f$0, (List) obj);
                }
            });
        }
        SocketService socketService3 = this.socketService;
        if (socketService3 != null) {
            socketService3.on("app_state.set", new Function1() { // from class: com.example.bingwahybrid.domain.portal.AppRelay$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AppRelay.registerListeners$lambda$2(this.f$0, (List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListeners$lambda$0(AppRelay appRelay, List args) {
        Intrinsics.checkNotNullParameter(args, "args");
        BuildersKt__Builders_commonKt.launch$default(appRelay.coroutineScope, null, null, new AppRelay$registerListeners$1$1(appRelay, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListeners$lambda$1(AppRelay appRelay, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(appRelay.coroutineScope, null, null, new AppRelay$registerListeners$2$1(appRelay, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListeners$lambda$2(AppRelay appRelay, List args) {
        Intrinsics.checkNotNullParameter(args, "args");
        BuildersKt__Builders_commonKt.launch$default(appRelay.coroutineScope, null, null, new AppRelay$registerListeners$3$1(appRelay, args, null), 3, null);
        return Unit.INSTANCE;
    }

    @Override // com.example.bingwahybrid.domain.portal.SocketRelay
    public void unregisterListeners() {
        SocketService socketService = this.socketService;
        if (socketService != null) {
            socketService.off("app.status");
        }
        SocketService socketService2 = this.socketService;
        if (socketService2 != null) {
            socketService2.off("app_state.sync");
        }
        SocketService socketService3 = this.socketService;
        if (socketService3 != null) {
            socketService3.off("app_state.set");
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.AppRelay$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppRelay.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.AppRelay$1", f = "AppRelay.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AppRelay.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<AppState> appState = AppRelay.this.appControl.getAppState();
                final AppRelay appRelay = AppRelay.this;
                this.label = 1;
                if (appState.collect(new FlowCollector() { // from class: com.example.bingwahybrid.domain.portal.AppRelay.1.1
                    public final Object emit(AppState appState2, Continuation<? super Unit> continuation) {
                        appRelay.handleAppStateSync();
                        return Unit.INSTANCE;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((AppState) obj2, (Continuation<? super Unit>) continuation);
                    }
                }, this) == coroutine_suspended) {
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

    public final void send(AppEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (isPortalActive()) {
            if (event instanceof AppEvent.Sync) {
                BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C06781(event, null), 3, null);
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.portal.AppRelay$send$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppRelay.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.portal.AppRelay$send$1", f = "AppRelay.kt", i = {0}, l = {78}, m = "invokeSuspend", n = {"currentState"}, s = {"L$0"})
    static final class C06781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppEvent $event;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06781(AppEvent appEvent, Continuation<? super C06781> continuation) {
            super(2, continuation);
            this.$event = appEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AppRelay.this.new C06781(this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JSONException {
            AppState appState;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AppState value = AppRelay.this.appControl.getAppState().getValue();
                this.L$0 = value;
                this.label = 1;
                Object setting = AppRelay.this.settingsRepository.getSetting(AppSetting.APP_CONNECT_ID, this);
                if (setting == coroutine_suspended) {
                    return coroutine_suspended;
                }
                appState = value;
                obj = setting;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                appState = (AppState) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("device", (String) obj);
            jSONObject.put("state", appState);
            SocketService socketService = AppRelay.this.socketService;
            if (socketService != null) {
                socketService.sendMessage(this.$event.getEventName(), jSONObject);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAppStateSync() {
        send(AppEvent.Sync.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object handleAppStatusQuery(Continuation<? super Unit> continuation) throws JSONException {
        C06771 c06771;
        StateFlow<Boolean> stateFlowIsConnected;
        if (continuation instanceof C06771) {
            c06771 = (C06771) continuation;
            if ((c06771.label & Integer.MIN_VALUE) != 0) {
                c06771.label -= Integer.MIN_VALUE;
            } else {
                c06771 = new C06771(continuation);
            }
        } else {
            c06771 = new C06771(continuation);
        }
        Object setting = c06771.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06771.label;
        if (i == 0) {
            ResultKt.throwOnFailure(setting);
            if (!isPortalActive()) {
                return Unit.INSTANCE;
            }
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting appSetting = AppSetting.APP_CONNECT_ID;
            c06771.label = 1;
            setting = settingsRepository.getSetting(appSetting, c06771);
            if (setting == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(setting);
        }
        AppState value = this.appControl.getAppState().getValue();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("device", (String) setting);
        jSONObject.put("appState", value.name());
        SocketService socketService = this.socketService;
        jSONObject.put("isConnected", (socketService == null || (stateFlowIsConnected = socketService.isConnected()) == null) ? false : stateFlowIsConnected.getValue().booleanValue());
        SocketService socketService2 = this.socketService;
        if (socketService2 != null) {
            socketService2.sendMessage("app.status.ack", jSONObject);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:76:0x01c8 A[Catch: IllegalArgumentException -> 0x01d1, TryCatch #2 {IllegalArgumentException -> 0x01d1, blocks: (B:16:0x004e, B:74:0x01b3, B:76:0x01c8, B:71:0x0190, B:77:0x01ce, B:49:0x00f2, B:53:0x0109, B:57:0x012b, B:58:0x0130, B:59:0x0131, B:62:0x014f, B:64:0x015f, B:66:0x0163), top: B:86:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01b0, code lost:
    
        if (r8.startApp(r3) == r4) goto L73;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleAppStateSet(List<? extends Object> list, Continuation<? super Unit> continuation) throws JSONException {
        C06761 c06761;
        JSONObject jSONObject;
        String strOptString;
        JSONObject jSONObject2;
        String str;
        AppState appStateFromString;
        AppState value;
        List<? extends Object> list2;
        String str2;
        AppState appState;
        JSONObject jSONObject3;
        AppState appState2;
        String str3;
        String str4;
        AppState appState3;
        JSONObject jSONObject4;
        SocketService socketService;
        List<? extends Object> list3 = list;
        if (continuation instanceof C06761) {
            c06761 = (C06761) continuation;
            if ((c06761.label & Integer.MIN_VALUE) != 0) {
                c06761.label -= Integer.MIN_VALUE;
            } else {
                c06761 = new C06761(continuation);
            }
        } else {
            c06761 = new C06761(continuation);
        }
        Object obj = c06761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str5 = c06761.label;
        try {
            if (str5 == 0) {
                ResultKt.throwOnFailure(obj);
                if (!isPortalActive()) {
                    return Unit.INSTANCE;
                }
                if (list3.size() <= 0 || !(list3.get(0) instanceof JSONObject)) {
                    jSONObject = null;
                } else {
                    Object obj2 = list3.get(0);
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) obj2;
                }
                if (jSONObject == null) {
                    return Unit.INSTANCE;
                }
                strOptString = jSONObject.optString("state");
                SettingsRepository settingsRepository = this.settingsRepository;
                AppSetting appSetting = AppSetting.APP_CONNECT_ID;
                c06761.L$0 = SpillingKt.nullOutSpilledVariable(list3);
                c06761.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject);
                c06761.L$2 = strOptString;
                c06761.label = 1;
                Object setting = settingsRepository.getSetting(appSetting, c06761);
                if (setting != coroutine_suspended) {
                    jSONObject2 = jSONObject;
                    obj = setting;
                }
                return coroutine_suspended;
            }
            if (str5 != 1) {
                if (str5 != 2) {
                    if (str5 == 3) {
                    } else if (str5 != 4 && str5 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    appState3 = (AppState) c06761.L$4;
                    str4 = (String) c06761.L$3;
                    ResultKt.throwOnFailure(obj);
                } else {
                    appState = (AppState) c06761.L$5;
                    appState2 = (AppState) c06761.L$4;
                    str3 = (String) c06761.L$3;
                    str2 = (String) c06761.L$2;
                    jSONObject3 = (JSONObject) c06761.L$1;
                    list2 = (List) c06761.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        appStateFromString = appState2;
                        str = str3;
                        strOptString = str2;
                        jSONObject2 = jSONObject3;
                        value = appState;
                        list3 = list2;
                        AppControl appControl = this.appControl;
                        c06761.L$0 = SpillingKt.nullOutSpilledVariable(list3);
                        c06761.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject2);
                        c06761.L$2 = strOptString;
                        c06761.L$3 = str;
                        c06761.L$4 = appStateFromString;
                        c06761.L$5 = SpillingKt.nullOutSpilledVariable(value);
                        c06761.label = 3;
                    } catch (IllegalArgumentException unused) {
                        str5 = str2;
                        Log.e("AppRelay", "Invalid app state: " + str5);
                    } catch (Exception unused2) {
                        return Unit.INSTANCE;
                    }
                }
                jSONObject4 = new JSONObject();
                jSONObject4.put("state", appState3.name());
                jSONObject4.put("device", str4);
                socketService = this.socketService;
                if (socketService != null) {
                    socketService.sendMessage("app_state.set.ack", jSONObject4);
                }
                return Unit.INSTANCE;
            }
            String str6 = (String) c06761.L$2;
            JSONObject jSONObject5 = (JSONObject) c06761.L$1;
            List<? extends Object> list4 = (List) c06761.L$0;
            ResultKt.throwOnFailure(obj);
            strOptString = str6;
            list3 = list4;
            jSONObject2 = jSONObject5;
            str = (String) obj;
            AppState.Companion companion = AppState.INSTANCE;
            Intrinsics.checkNotNull(strOptString);
            appStateFromString = companion.fromString(strOptString);
            int i = WhenMappings.$EnumSwitchMapping$0[appStateFromString.ordinal()];
            if (i == 1) {
                value = this.appControl.getAppState().getValue();
                if (value == AppState.STATE_PAUSED || value == AppState.STATE_STOPPED) {
                    try {
                        c06761.L$0 = SpillingKt.nullOutSpilledVariable(list3);
                        c06761.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject2);
                        c06761.L$2 = strOptString;
                        c06761.L$3 = str;
                        c06761.L$4 = appStateFromString;
                        c06761.L$5 = SpillingKt.nullOutSpilledVariable(value);
                        c06761.label = 2;
                        if (validateAndRefreshAccessToken(c06761) != coroutine_suspended) {
                            list2 = list3;
                            str2 = strOptString;
                            appState = value;
                            jSONObject3 = jSONObject2;
                            appState2 = appStateFromString;
                            str3 = str;
                            appStateFromString = appState2;
                            str = str3;
                            strOptString = str2;
                            jSONObject2 = jSONObject3;
                            value = appState;
                            list3 = list2;
                            AppControl appControl2 = this.appControl;
                            c06761.L$0 = SpillingKt.nullOutSpilledVariable(list3);
                            c06761.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject2);
                            c06761.L$2 = strOptString;
                            c06761.L$3 = str;
                            c06761.L$4 = appStateFromString;
                            c06761.L$5 = SpillingKt.nullOutSpilledVariable(value);
                            c06761.label = 3;
                        }
                    } catch (Exception unused3) {
                        return Unit.INSTANCE;
                    }
                } else {
                    AppControl appControl3 = this.appControl;
                    c06761.L$0 = SpillingKt.nullOutSpilledVariable(list3);
                    c06761.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject2);
                    c06761.L$2 = strOptString;
                    c06761.L$3 = str;
                    c06761.L$4 = appStateFromString;
                    c06761.L$5 = SpillingKt.nullOutSpilledVariable(value);
                    c06761.label = 3;
                }
            } else {
                if (i == 2) {
                    AppControl appControl4 = this.appControl;
                    c06761.L$0 = SpillingKt.nullOutSpilledVariable(list3);
                    c06761.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject2);
                    c06761.L$2 = strOptString;
                    c06761.L$3 = str;
                    c06761.L$4 = appStateFromString;
                    c06761.label = 4;
                    if (appControl4.pauseApp(c06761) == coroutine_suspended) {
                    }
                    str4 = str;
                    appState3 = appStateFromString;
                } else {
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    AppControl appControl5 = this.appControl;
                    c06761.L$0 = SpillingKt.nullOutSpilledVariable(list3);
                    c06761.L$1 = SpillingKt.nullOutSpilledVariable(jSONObject2);
                    c06761.L$2 = strOptString;
                    c06761.L$3 = str;
                    c06761.L$4 = appStateFromString;
                    c06761.label = 5;
                    if (appControl5.stopApp(c06761) == coroutine_suspended) {
                    }
                    str4 = str;
                    appState3 = appStateFromString;
                }
                jSONObject4 = new JSONObject();
                jSONObject4.put("state", appState3.name());
                jSONObject4.put("device", str4);
                socketService = this.socketService;
                if (socketService != null) {
                    socketService.sendMessage("app_state.set.ack", jSONObject4);
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (IllegalArgumentException unused4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        if (r6 == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0091, code lost:
    
        if (r7 == r1) goto L36;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object validateAndRefreshAccessToken(Continuation<? super Unit> continuation) throws Exception {
        C06791 c06791;
        TokenExpiredException tokenExpiredException;
        ?? r6;
        if (continuation instanceof C06791) {
            c06791 = (C06791) continuation;
            if ((c06791.label & Integer.MIN_VALUE) != 0) {
                c06791.label -= Integer.MIN_VALUE;
            } else {
                c06791 = new C06791(continuation);
            }
        } else {
            c06791 = new C06791(continuation);
        }
        Object refreshToken = c06791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06791.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(refreshToken);
                TokenRepository tokenRepository = this.tokenRepository;
                c06791.label = 1;
                Object objValidateAccessToken = tokenRepository.validateAccessToken(c06791);
                this = objValidateAccessToken;
            } else {
                if (i != 1) {
                    if (i == 2) {
                        tokenExpiredException = (TokenExpiredException) c06791.L$0;
                        ResultKt.throwOnFailure(refreshToken);
                        this = this;
                        String str = (String) refreshToken;
                        if (str == null) {
                            throw new Exception("Refresh token not available");
                        }
                        if (StringsKt.isBlank(str)) {
                            throw new Exception("Refresh token is blank");
                        }
                        TokenRefreshService tokenRefreshService = r6.tokenRefreshService;
                        c06791.L$0 = SpillingKt.nullOutSpilledVariable(tokenExpiredException);
                        c06791.L$1 = SpillingKt.nullOutSpilledVariable(str);
                        c06791.label = 3;
                        refreshToken = tokenRefreshService.refreshAccessToken(c06791);
                    } else {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(refreshToken);
                    }
                    if (!((Boolean) refreshToken).booleanValue()) {
                        throw new Exception("Token refresh failed");
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(refreshToken);
                this = this;
            }
        } catch (TokenExpiredException e) {
            tokenExpiredException = e;
            TokenRepository tokenRepository2 = this.tokenRepository;
            c06791.L$0 = SpillingKt.nullOutSpilledVariable(tokenExpiredException);
            c06791.label = 2;
            refreshToken = tokenRepository2.getRefreshToken(c06791);
            r6 = this;
            if (refreshToken != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Exception e2) {
            throw e2;
        }
        return Unit.INSTANCE;
    }
}
