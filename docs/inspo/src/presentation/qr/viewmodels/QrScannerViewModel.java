package com.example.bingwahybrid.presentation.qr.viewmodels;

import androidx.core.location.LocationRequestCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.devices.ConnectionManager;
import com.example.bingwahybrid.domain.hybridconnect.HybridConnectWebSocketClient;
import com.example.bingwahybrid.domain.hybridconnect.enums.ConnectionState;
import com.example.bingwahybrid.domain.qr.model.QrCodePayload;
import com.example.bingwahybrid.infrastructure.hybridconnect.utils.ConnectionUtils;
import com.example.bingwahybrid.infrastructure.security.QRCodeDecryption;
import com.google.gson.Gson;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: QrScannerViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000fJ\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\u0006\u0010 \u001a\u00020\u001bJ\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000fJ\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/example/bingwahybrid/presentation/qr/viewmodels/QrScannerViewModel;", "Landroidx/lifecycle/ViewModel;", "webSocketClient", "Lcom/example/bingwahybrid/domain/hybridconnect/HybridConnectWebSocketClient;", "connectionManager", "Lcom/example/bingwahybrid/domain/devices/ConnectionManager;", "<init>", "(Lcom/example/bingwahybrid/domain/hybridconnect/HybridConnectWebSocketClient;Lcom/example/bingwahybrid/domain/devices/ConnectionManager;)V", "_isConnecting", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isConnecting", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "_connectionError", "", "connectionError", "getConnectionError", "_isConnected", "isConnected", "_isProcessingQrCode", "isProcessingQrCode", "currentConnectJob", "Lkotlinx/coroutines/Job;", "currentServerId", "connectionStateJob", "resetConnectionState", "", "handleQrCodeScanned", "qrCodeData", "observeConnectionState", "serverId", "clearError", "setError", "error", "lockProcessing", "unlockProcessing", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class QrScannerViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _connectionError;
    private final MutableStateFlow<Boolean> _isConnected;
    private final MutableStateFlow<Boolean> _isConnecting;
    private final MutableStateFlow<Boolean> _isProcessingQrCode;
    private final StateFlow<String> connectionError;
    private final ConnectionManager connectionManager;
    private Job connectionStateJob;
    private Job currentConnectJob;
    private String currentServerId;
    private final StateFlow<Boolean> isConnected;
    private final StateFlow<Boolean> isConnecting;
    private final StateFlow<Boolean> isProcessingQrCode;
    private final HybridConnectWebSocketClient webSocketClient;

    @Inject
    public QrScannerViewModel(HybridConnectWebSocketClient webSocketClient, ConnectionManager connectionManager) {
        Intrinsics.checkNotNullParameter(webSocketClient, "webSocketClient");
        Intrinsics.checkNotNullParameter(connectionManager, "connectionManager");
        this.webSocketClient = webSocketClient;
        this.connectionManager = connectionManager;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isConnecting = MutableStateFlow;
        this.isConnecting = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._connectionError = MutableStateFlow2;
        this.connectionError = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._isConnected = MutableStateFlow3;
        this.isConnected = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(false);
        this._isProcessingQrCode = MutableStateFlow4;
        this.isProcessingQrCode = FlowKt.asStateFlow(MutableStateFlow4);
    }

    public final StateFlow<Boolean> isConnecting() {
        return this.isConnecting;
    }

    public final StateFlow<String> getConnectionError() {
        return this.connectionError;
    }

    public final StateFlow<Boolean> isConnected() {
        return this.isConnected;
    }

    public final StateFlow<Boolean> isProcessingQrCode() {
        return this.isProcessingQrCode;
    }

    public final void resetConnectionState() {
        Job job = this.connectionStateJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.currentServerId = null;
        this._isConnecting.setValue(false);
        this._isConnected.setValue(false);
        this._connectionError.setValue(null);
        unlockProcessing();
    }

    public final void handleQrCodeScanned(String qrCodeData) {
        Intrinsics.checkNotNullParameter(qrCodeData, "qrCodeData");
        if (this._isProcessingQrCode.getValue().booleanValue()) {
            return;
        }
        Job job = this.currentConnectJob;
        if (job == null || !job.isActive()) {
            lockProcessing();
            this._isConnecting.setValue(true);
            this._connectionError.setValue(null);
            this.currentConnectJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(qrCodeData, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.qr.viewmodels.QrScannerViewModel$handleQrCodeScanned$1, reason: invalid class name */
    /* JADX INFO: compiled from: QrScannerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.qr.viewmodels.QrScannerViewModel$handleQrCodeScanned$1", f = "QrScannerViewModel.kt", i = {0, 0, 0, 0}, l = {76}, m = "invokeSuspend", n = {"decryptedJson", "qrPayload", "wsUrl", "deviceId"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $qrCodeData;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$qrCodeData = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return QrScannerViewModel.this.new AnonymousClass1(this.$qrCodeData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:45:0x0131  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Job job = QrScannerViewModel.this.connectionStateJob;
                            if (job != null) {
                                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                            }
                            String strDecrypt = QRCodeDecryption.INSTANCE.decrypt(this.$qrCodeData);
                            QrCodePayload qrCodePayload = (QrCodePayload) new Gson().fromJson(strDecrypt, QrCodePayload.class);
                            String strNormalizeUrl = ConnectionUtils.INSTANCE.normalizeUrl(qrCodePayload.getUrl());
                            String deviceId = qrCodePayload.getDeviceId();
                            QrScannerViewModel.this.currentServerId = deviceId;
                            QrScannerViewModel qrScannerViewModel = QrScannerViewModel.this;
                            String str = qrScannerViewModel.currentServerId;
                            Intrinsics.checkNotNull(str);
                            qrScannerViewModel.observeConnectionState(str);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(strDecrypt);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(qrCodePayload);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(strNormalizeUrl);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(deviceId);
                            this.label = 1;
                            if (QrScannerViewModel.this.webSocketClient.connect(strNormalizeUrl, deviceId, false, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        if (!((Boolean) QrScannerViewModel.this._isConnected.getValue()).booleanValue()) {
                            QrScannerViewModel.this._isConnecting.setValue(Boxing.boxBoolean(false));
                            QrScannerViewModel.this.unlockProcessing();
                        }
                    } catch (TimeoutException e) {
                        MutableStateFlow mutableStateFlow = QrScannerViewModel.this._connectionError;
                        String message = e.getMessage();
                        if (message == null) {
                            message = "Connection timeout.";
                        }
                        mutableStateFlow.setValue(message);
                        if (!((Boolean) QrScannerViewModel.this._isConnected.getValue()).booleanValue()) {
                            QrScannerViewModel.this._isConnecting.setValue(Boxing.boxBoolean(false));
                            QrScannerViewModel.this.unlockProcessing();
                        }
                    }
                } catch (CancellationException unused) {
                    if (!((Boolean) QrScannerViewModel.this._isConnected.getValue()).booleanValue()) {
                        QrScannerViewModel.this._isConnecting.setValue(Boxing.boxBoolean(false));
                        QrScannerViewModel.this.unlockProcessing();
                    }
                } catch (Exception e2) {
                    MutableStateFlow mutableStateFlow2 = QrScannerViewModel.this._connectionError;
                    String message2 = e2.getMessage();
                    if (message2 == null) {
                        message2 = "Unknown error.";
                    }
                    mutableStateFlow2.setValue(message2);
                    if (!((Boolean) QrScannerViewModel.this._isConnected.getValue()).booleanValue()) {
                        QrScannerViewModel.this._isConnecting.setValue(Boxing.boxBoolean(false));
                        QrScannerViewModel.this.unlockProcessing();
                    }
                }
                QrScannerViewModel.this.currentConnectJob = null;
                return Unit.INSTANCE;
            } catch (Throwable th) {
                if (!((Boolean) QrScannerViewModel.this._isConnected.getValue()).booleanValue()) {
                    QrScannerViewModel.this._isConnecting.setValue(Boxing.boxBoolean(false));
                    QrScannerViewModel.this.unlockProcessing();
                }
                QrScannerViewModel.this.currentConnectJob = null;
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.qr.viewmodels.QrScannerViewModel$observeConnectionState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: QrScannerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.qr.viewmodels.QrScannerViewModel$observeConnectionState$1", f = "QrScannerViewModel.kt", i = {0}, l = {LocationRequestCompat.QUALITY_LOW_POWER}, m = "invokeSuspend", n = {"wasConnected"}, s = {"L$0"})
    static final class C07261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $serverId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07261(String str, Continuation<? super C07261> continuation) {
            super(2, continuation);
            this.$serverId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return QrScannerViewModel.this.new C07261(this.$serverId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07261) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                final StateFlow<Map<String, ConnectionState>> connectionStates = QrScannerViewModel.this.connectionManager.getConnectionStates();
                final String str = this.$serverId;
                Flow<ConnectionState> flow = new Flow<ConnectionState>() { // from class: com.example.bingwahybrid.presentation.qr.viewmodels.QrScannerViewModel$observeConnectionState$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.qr.viewmodels.QrScannerViewModel$observeConnectionState$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ String $serverId$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.qr.viewmodels.QrScannerViewModel$observeConnectionState$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.example.bingwahybrid.presentation.qr.viewmodels.QrScannerViewModel$observeConnectionState$1$invokeSuspend$$inlined$map$1$2", f = "QrScannerViewModel.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector, String str) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$serverId$inlined = str;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj, Continuation continuation) {
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
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = anonymousClass1.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                ConnectionState.Disconnected disconnected = (ConnectionState) ((Map) obj).get(this.$serverId$inlined);
                                if (disconnected == null) {
                                    disconnected = ConnectionState.Disconnected.INSTANCE;
                                }
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(disconnected, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                int i2 = anonymousClass1.I$0;
                                Object obj3 = anonymousClass1.L$2;
                                Object obj4 = anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super ConnectionState> flowCollector, Continuation continuation) {
                        Object objCollect = connectionStates.collect(new AnonymousClass2(flowCollector, str), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final QrScannerViewModel qrScannerViewModel = QrScannerViewModel.this;
                this.L$0 = SpillingKt.nullOutSpilledVariable(booleanRef);
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: com.example.bingwahybrid.presentation.qr.viewmodels.QrScannerViewModel.observeConnectionState.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((ConnectionState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(ConnectionState connectionState, Continuation<? super Unit> continuation) {
                        boolean z = connectionState instanceof ConnectionState.Connected;
                        qrScannerViewModel._isConnected.setValue(Boxing.boxBoolean(z));
                        if (z) {
                            qrScannerViewModel._isConnecting.setValue(Boxing.boxBoolean(false));
                            qrScannerViewModel._connectionError.setValue(null);
                            if (!booleanRef.element && ((Boolean) qrScannerViewModel._isProcessingQrCode.getValue()).booleanValue()) {
                                qrScannerViewModel.unlockProcessing();
                            }
                            booleanRef.element = true;
                        } else if ((connectionState instanceof ConnectionState.Connecting) || (connectionState instanceof ConnectionState.Reconnecting)) {
                            qrScannerViewModel._isConnecting.setValue(Boxing.boxBoolean(true));
                            booleanRef.element = false;
                        } else if (connectionState instanceof ConnectionState.FatalError) {
                            qrScannerViewModel._isConnecting.setValue(Boxing.boxBoolean(false));
                            qrScannerViewModel._connectionError.setValue(((ConnectionState.FatalError) connectionState).getMessage());
                            if (((Boolean) qrScannerViewModel._isProcessingQrCode.getValue()).booleanValue()) {
                                qrScannerViewModel.unlockProcessing();
                            }
                            booleanRef.element = false;
                        } else if (connectionState instanceof ConnectionState.Disconnected) {
                            qrScannerViewModel._isConnecting.setValue(Boxing.boxBoolean(false));
                            if (((Boolean) qrScannerViewModel._isProcessingQrCode.getValue()).booleanValue()) {
                                qrScannerViewModel.unlockProcessing();
                            }
                            booleanRef.element = false;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
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
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeConnectionState(String serverId) {
        Job job = this.connectionStateJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.connectionStateJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07261(serverId, null), 3, null);
    }

    public final void clearError() {
        this._connectionError.setValue(null);
        if (this._isConnected.getValue().booleanValue()) {
            return;
        }
        unlockProcessing();
    }

    public final void setError(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this._connectionError.setValue(error);
        if (this._isConnected.getValue().booleanValue()) {
            return;
        }
        unlockProcessing();
    }

    private final void lockProcessing() {
        this._isProcessingQrCode.setValue(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unlockProcessing() {
        this._isProcessingQrCode.setValue(false);
    }
}
