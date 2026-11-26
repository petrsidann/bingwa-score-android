package com.example.bingwahybrid.presentation.hybridconnect.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.devices.ConnectionManager;
import com.example.bingwahybrid.domain.devices.model.LinkedDevice;
import com.example.bingwahybrid.domain.devices.repository.LinkedDevicesRepository;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.hybridconnect.HybridConnectWebSocketClient;
import com.example.bingwahybrid.domain.hybridconnect.enums.ConnectionState;
import com.example.bingwahybrid.domain.repository.HybridConnectRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.socket.SocketService;
import com.example.bingwahybrid.infrastructure.socket.services.SocketForegroundService;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: HybridConnectViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BC\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u000201H\u0002J\u0006\u00103\u001a\u000201J\u000e\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u0014J\u0006\u00106\u001a\u000201J\u0006\u00107\u001a\u000201J\u000e\u00108\u001a\u0002012\u0006\u00109\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0016¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0016\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0016¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u0016¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R#\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020.0-0\u0016¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0017¨\u0006:"}, d2 = {"Lcom/example/bingwahybrid/presentation/hybridconnect/viewmodel/HybridConnectViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "socketService", "Lcom/example/bingwahybrid/domain/socket/SocketService;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "hybridConnectRepository", "Lcom/example/bingwahybrid/domain/repository/HybridConnectRepository;", "linkedDevicesRepository", "Lcom/example/bingwahybrid/domain/devices/repository/LinkedDevicesRepository;", "connectionManager", "Lcom/example/bingwahybrid/domain/devices/ConnectionManager;", "hybridConnectWebSocketClient", "Lcom/example/bingwahybrid/domain/hybridconnect/HybridConnectWebSocketClient;", "<init>", "(Landroid/content/Context;Lcom/example/bingwahybrid/domain/socket/SocketService;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/repository/HybridConnectRepository;Lcom/example/bingwahybrid/domain/devices/repository/LinkedDevicesRepository;Lcom/example/bingwahybrid/domain/devices/ConnectionManager;Lcom/example/bingwahybrid/domain/hybridconnect/HybridConnectWebSocketClient;)V", "_isGenerating", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isGenerating", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "_isLoading", "isLoading", "_connectId", "", "connectId", "getConnectId", "isOnline", "_errorMessage", "errorMessage", "getErrorMessage", "_successMessage", "successMessage", "getSuccessMessage", "_connectionStatusProgress", "connectionStatusProgress", "getConnectionStatusProgress", "linkedDevices", "", "Lcom/example/bingwahybrid/domain/devices/model/LinkedDevice;", "getLinkedDevices", "deviceConnectionStates", "", "Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState;", "getDeviceConnectionStates", "socketConnectionStatusListeners", "", "fetchConnectId", "generateConnectId", "toggleConnectionStatus", "isConnected", "resetErrorMessage", "resetSuccessMessage", "deleteLinkedDevice", "deviceId", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HybridConnectViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _connectId;
    private final MutableStateFlow<Boolean> _connectionStatusProgress;
    private final MutableStateFlow<String> _errorMessage;
    private final MutableStateFlow<Boolean> _isGenerating;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<String> _successMessage;
    private final StateFlow<String> connectId;
    private final ConnectionManager connectionManager;
    private final StateFlow<Boolean> connectionStatusProgress;
    private final Context context;
    private final StateFlow<Map<String, ConnectionState>> deviceConnectionStates;
    private final StateFlow<String> errorMessage;
    private final HybridConnectRepository hybridConnectRepository;
    private final HybridConnectWebSocketClient hybridConnectWebSocketClient;
    private final StateFlow<Boolean> isGenerating;
    private final StateFlow<Boolean> isLoading;
    private final StateFlow<Boolean> isOnline;
    private final StateFlow<List<LinkedDevice>> linkedDevices;
    private final LinkedDevicesRepository linkedDevicesRepository;
    private final SettingsRepository settingsRepository;
    private final SocketService socketService;
    private final StateFlow<String> successMessage;

    @Inject
    public HybridConnectViewModel(@ApplicationContext Context context, SocketService socketService, SettingsRepository settingsRepository, HybridConnectRepository hybridConnectRepository, LinkedDevicesRepository linkedDevicesRepository, ConnectionManager connectionManager, HybridConnectWebSocketClient hybridConnectWebSocketClient) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(socketService, "socketService");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(hybridConnectRepository, "hybridConnectRepository");
        Intrinsics.checkNotNullParameter(linkedDevicesRepository, "linkedDevicesRepository");
        Intrinsics.checkNotNullParameter(connectionManager, "connectionManager");
        Intrinsics.checkNotNullParameter(hybridConnectWebSocketClient, "hybridConnectWebSocketClient");
        this.context = context;
        this.socketService = socketService;
        this.settingsRepository = settingsRepository;
        this.hybridConnectRepository = hybridConnectRepository;
        this.linkedDevicesRepository = linkedDevicesRepository;
        this.connectionManager = connectionManager;
        this.hybridConnectWebSocketClient = hybridConnectWebSocketClient;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isGenerating = MutableStateFlow;
        this.isGenerating = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow2;
        this.isLoading = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._connectId = MutableStateFlow3;
        this.connectId = FlowKt.asStateFlow(MutableStateFlow3);
        this.isOnline = socketService.isConnected();
        MutableStateFlow<String> MutableStateFlow4 = StateFlowKt.MutableStateFlow(null);
        this._errorMessage = MutableStateFlow4;
        this.errorMessage = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<String> MutableStateFlow5 = StateFlowKt.MutableStateFlow(null);
        this._successMessage = MutableStateFlow5;
        this.successMessage = FlowKt.asStateFlow(MutableStateFlow5);
        MutableStateFlow<Boolean> MutableStateFlow6 = StateFlowKt.MutableStateFlow(false);
        this._connectionStatusProgress = MutableStateFlow6;
        this.connectionStatusProgress = FlowKt.asStateFlow(MutableStateFlow6);
        this.linkedDevices = FlowKt.stateIn(linkedDevicesRepository.getAllLinkedDevices(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), CollectionsKt.emptyList());
        this.deviceConnectionStates = connectionManager.getConnectionStates();
        socketConnectionStatusListeners();
        fetchConnectId();
    }

    public final StateFlow<Boolean> isGenerating() {
        return this.isGenerating;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final StateFlow<String> getConnectId() {
        return this.connectId;
    }

    public final StateFlow<Boolean> isOnline() {
        return this.isOnline;
    }

    public final StateFlow<String> getErrorMessage() {
        return this.errorMessage;
    }

    public final StateFlow<String> getSuccessMessage() {
        return this.successMessage;
    }

    public final StateFlow<Boolean> getConnectionStatusProgress() {
        return this.connectionStatusProgress;
    }

    public final StateFlow<List<LinkedDevice>> getLinkedDevices() {
        return this.linkedDevices;
    }

    public final StateFlow<Map<String, ConnectionState>> getDeviceConnectionStates() {
        return this.deviceConnectionStates;
    }

    private final void socketConnectionStatusListeners() {
        this.socketService.on("EVENT_CONNECT_ERROR", new Function1() { // from class: com.example.bingwahybrid.presentation.hybridconnect.viewmodel.HybridConnectViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HybridConnectViewModel.socketConnectionStatusListeners$lambda$0(this.f$0, (List) obj);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit socketConnectionStatusListeners$lambda$0(HybridConnectViewModel hybridConnectViewModel, List message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Log.d("HybridConnectViewModel", "Error connecting to socket: " + message.get(0));
        hybridConnectViewModel._connectionStatusProgress.setValue(false);
        hybridConnectViewModel._errorMessage.setValue(message.get(0).toString());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.hybridconnect.viewmodel.HybridConnectViewModel$socketConnectionStatusListeners$2, reason: invalid class name */
    /* JADX INFO: compiled from: HybridConnectViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.hybridconnect.viewmodel.HybridConnectViewModel$socketConnectionStatusListeners$2", f = "HybridConnectViewModel.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HybridConnectViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<Boolean> stateFlowIsConnected = HybridConnectViewModel.this.socketService.isConnected();
                final HybridConnectViewModel hybridConnectViewModel = HybridConnectViewModel.this;
                this.label = 1;
                if (stateFlowIsConnected.collect(new FlowCollector() { // from class: com.example.bingwahybrid.presentation.hybridconnect.viewmodel.HybridConnectViewModel.socketConnectionStatusListeners.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        hybridConnectViewModel._connectionStatusProgress.setValue(Boxing.boxBoolean(false));
                        return Unit.INSTANCE;
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

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.hybridconnect.viewmodel.HybridConnectViewModel$fetchConnectId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HybridConnectViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.hybridconnect.viewmodel.HybridConnectViewModel$fetchConnectId$1", f = "HybridConnectViewModel.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    static final class C07181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07181(Continuation<? super C07181> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HybridConnectViewModel.this.new C07181(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    HybridConnectViewModel.this._isLoading.setValue(Boxing.boxBoolean(true));
                    this.label = 1;
                    obj = HybridConnectViewModel.this.settingsRepository.getSetting(AppSetting.APP_CONNECT_ID, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                String str = (String) obj;
                if (str.length() > 0) {
                    HybridConnectViewModel.this._connectId.setValue(str);
                }
            } catch (Exception e) {
                HybridConnectViewModel.this._errorMessage.setValue(e.getMessage());
            } finally {
                HybridConnectViewModel.this._isLoading.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
    }

    private final void fetchConnectId() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07181(null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.hybridconnect.viewmodel.HybridConnectViewModel$generateConnectId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HybridConnectViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.hybridconnect.viewmodel.HybridConnectViewModel$generateConnectId$1", f = "HybridConnectViewModel.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
    static final class C07191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07191(Continuation<? super C07191> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HybridConnectViewModel.this.new C07191(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    HybridConnectViewModel.this._isGenerating.setValue(Boxing.boxBoolean(true));
                    this.label = 1;
                    obj = HybridConnectViewModel.this.hybridConnectRepository.generateConnectId(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                HybridConnectViewModel.this._connectId.setValue((String) obj);
            } catch (Exception e) {
                HybridConnectViewModel.this._errorMessage.setValue(e.getMessage());
            } finally {
                HybridConnectViewModel.this._isGenerating.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
    }

    public final void generateConnectId() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07191(null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.hybridconnect.viewmodel.HybridConnectViewModel$toggleConnectionStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HybridConnectViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.hybridconnect.viewmodel.HybridConnectViewModel$toggleConnectionStatus$1", f = "HybridConnectViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isConnected;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07201(boolean z, Continuation<? super C07201> continuation) {
            super(2, continuation);
            this.$isConnected = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HybridConnectViewModel.this.new C07201(this.$isConnected, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    HybridConnectViewModel.this._connectionStatusProgress.setValue(Boxing.boxBoolean(true));
                    if (this.$isConnected) {
                        str = SocketForegroundService.ACTION_DISCONNECT;
                    } else {
                        str = SocketForegroundService.ACTION_CONNECT;
                    }
                    Intent intent = new Intent(HybridConnectViewModel.this.context, (Class<?>) SocketForegroundService.class);
                    intent.setAction(str);
                    ContextCompat.startForegroundService(HybridConnectViewModel.this.context, intent);
                } catch (Exception e) {
                    HybridConnectViewModel.this._errorMessage.setValue(e.getMessage());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void toggleConnectionStatus(boolean isConnected) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07201(isConnected, null), 3, null);
    }

    public final void resetErrorMessage() {
        this._errorMessage.setValue(null);
    }

    public final void resetSuccessMessage() {
        this._successMessage.setValue(null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.hybridconnect.viewmodel.HybridConnectViewModel$deleteLinkedDevice$1, reason: invalid class name */
    /* JADX INFO: compiled from: HybridConnectViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.hybridconnect.viewmodel.HybridConnectViewModel$deleteLinkedDevice$1", f = "HybridConnectViewModel.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$deviceId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HybridConnectViewModel.this.new AnonymousClass1(this.$deviceId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (HybridConnectViewModel.this.hybridConnectWebSocketClient.unlinkServer(this.$deviceId, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                HybridConnectViewModel.this.linkedDevicesRepository.deleteLinkedDevice(this.$deviceId);
                HybridConnectViewModel.this._successMessage.setValue("Linked device removed successfully");
            } catch (Exception e) {
                HybridConnectViewModel.this._errorMessage.setValue("Failed to remove linked device: " + e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    public final void deleteLinkedDevice(String deviceId) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(deviceId, null), 3, null);
    }
}
