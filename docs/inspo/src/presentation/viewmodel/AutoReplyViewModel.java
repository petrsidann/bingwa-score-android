package com.example.bingwahybrid.presentation.viewmodel;

import android.util.Log;
import androidx.compose.material.TextFieldImplKt;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.enums.AutoReplyType;
import com.example.bingwahybrid.domain.model.AutoReply;
import com.example.bingwahybrid.domain.repository.AutoReplyRepository;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.ktor.http.LinkHeader;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: AutoReplyViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u000eJ\u000e\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020\u0019J\u000e\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\u000eJ\u000e\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020 J\u0006\u00105\u001a\u00020)J\u0016\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020 J\u0006\u00109\u001a\u00020)J\u0006\u0010:\u001a\u00020)J\u0017\u0010;\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+¢\u0006\u0002\u0010<R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000bR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000bR\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000bR\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000b¨\u0006="}, d2 = {"Lcom/example/bingwahybrid/presentation/viewmodel/AutoReplyViewModel;", "Landroidx/lifecycle/ViewModel;", "autoReplyRepository", "Lcom/example/bingwahybrid/domain/repository/AutoReplyRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/AutoReplyRepository;)V", "autoRepliesFlow", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/bingwahybrid/domain/model/AutoReply;", "getAutoRepliesFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_message", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "message", "getMessage", "selectedAutoReply", "_autoReplyMessage", "autoReplyMessage", "getAutoReplyMessage", "_autoReplyTitle", "autoReplyTitle", "getAutoReplyTitle", "_autoReplyType", "Lcom/example/bingwahybrid/domain/enums/AutoReplyType;", "autoReplyType", "getAutoReplyType", "_transactionAmount", "transactionAmount", "getTransactionAmount", "_isActive", "", "isActive", "_showAmountInput", "showAmountInput", "getShowAmountInput", "_updateSuccess", "updateSuccess", "getUpdateSuccess", "getAutoReplyById", "", "id", "", "onAutoReplyMessageChanged", "onAutoReplyTitleChanged", LinkHeader.Parameters.Title, "onAutoReplyTypeChanged", "type", "onTransactionAmountChanged", "amount", "onIsActiveChanged", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "updateAutoReply", "onAutoReplyStatusChanged", "autoReply", NotificationCompat.CATEGORY_STATUS, "resetSuccessStatus", "toggleAmountInputVisibility", "deleteAutoReply", "(Ljava/lang/Long;)V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AutoReplyViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _autoReplyMessage;
    private final MutableStateFlow<String> _autoReplyTitle;
    private final MutableStateFlow<AutoReplyType> _autoReplyType;
    private final MutableStateFlow<Boolean> _isActive;
    private final MutableStateFlow<String> _message;
    private final MutableStateFlow<Boolean> _showAmountInput;
    private final MutableStateFlow<String> _transactionAmount;
    private final MutableStateFlow<Boolean> _updateSuccess;
    private final StateFlow<List<AutoReply>> autoRepliesFlow;
    private final StateFlow<String> autoReplyMessage;
    private final AutoReplyRepository autoReplyRepository;
    private final StateFlow<String> autoReplyTitle;
    private final StateFlow<AutoReplyType> autoReplyType;
    private final StateFlow<Boolean> isActive;
    private final StateFlow<String> message;
    private AutoReply selectedAutoReply;
    private final StateFlow<Boolean> showAmountInput;
    private final StateFlow<String> transactionAmount;
    private final StateFlow<Boolean> updateSuccess;

    @Inject
    public AutoReplyViewModel(AutoReplyRepository autoReplyRepository) {
        Intrinsics.checkNotNullParameter(autoReplyRepository, "autoReplyRepository");
        this.autoReplyRepository = autoReplyRepository;
        this.autoRepliesFlow = FlowKt.stateIn(autoReplyRepository.getAllAutoRepliesFlow(), ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getLazily(), CollectionsKt.emptyList());
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._message = MutableStateFlow;
        this.message = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow("");
        this._autoReplyMessage = MutableStateFlow2;
        this.autoReplyMessage = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow("");
        this._autoReplyTitle = MutableStateFlow3;
        this.autoReplyTitle = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<AutoReplyType> MutableStateFlow4 = StateFlowKt.MutableStateFlow(AutoReplyType.FAILED);
        this._autoReplyType = MutableStateFlow4;
        this.autoReplyType = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<String> MutableStateFlow5 = StateFlowKt.MutableStateFlow("");
        this._transactionAmount = MutableStateFlow5;
        this.transactionAmount = FlowKt.asStateFlow(MutableStateFlow5);
        MutableStateFlow<Boolean> MutableStateFlow6 = StateFlowKt.MutableStateFlow(false);
        this._isActive = MutableStateFlow6;
        this.isActive = FlowKt.asStateFlow(MutableStateFlow6);
        MutableStateFlow<Boolean> MutableStateFlow7 = StateFlowKt.MutableStateFlow(false);
        this._showAmountInput = MutableStateFlow7;
        this.showAmountInput = FlowKt.asStateFlow(MutableStateFlow7);
        MutableStateFlow<Boolean> MutableStateFlow8 = StateFlowKt.MutableStateFlow(false);
        this._updateSuccess = MutableStateFlow8;
        this.updateSuccess = FlowKt.asStateFlow(MutableStateFlow8);
    }

    public final StateFlow<List<AutoReply>> getAutoRepliesFlow() {
        return this.autoRepliesFlow;
    }

    public final StateFlow<String> getMessage() {
        return this.message;
    }

    public final StateFlow<String> getAutoReplyMessage() {
        return this.autoReplyMessage;
    }

    public final StateFlow<String> getAutoReplyTitle() {
        return this.autoReplyTitle;
    }

    public final StateFlow<AutoReplyType> getAutoReplyType() {
        return this.autoReplyType;
    }

    public final StateFlow<String> getTransactionAmount() {
        return this.transactionAmount;
    }

    public final StateFlow<Boolean> isActive() {
        return this.isActive;
    }

    public final StateFlow<Boolean> getShowAmountInput() {
        return this.showAmountInput;
    }

    public final StateFlow<Boolean> getUpdateSuccess() {
        return this.updateSuccess;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.AutoReplyViewModel$getAutoReplyById$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoReplyViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.AutoReplyViewModel$getAutoReplyById$1", f = "AutoReplyViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    static final class C07541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $id;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07541(long j, Continuation<? super C07541> continuation) {
            super(2, continuation);
            this.$id = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoReplyViewModel.this.new C07541(this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AutoReplyViewModel autoReplyViewModel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AutoReplyViewModel autoReplyViewModel2 = AutoReplyViewModel.this;
                    this.L$0 = autoReplyViewModel2;
                    this.label = 1;
                    Object autoReplyById = autoReplyViewModel2.autoReplyRepository.getAutoReplyById(this.$id, this);
                    if (autoReplyById == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    autoReplyViewModel = autoReplyViewModel2;
                    obj = autoReplyById;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    autoReplyViewModel = (AutoReplyViewModel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                autoReplyViewModel.selectedAutoReply = (AutoReply) obj;
                AutoReply autoReply = AutoReplyViewModel.this.selectedAutoReply;
                if (autoReply != null) {
                    AutoReplyViewModel autoReplyViewModel3 = AutoReplyViewModel.this;
                    autoReplyViewModel3._autoReplyMessage.setValue(autoReply.getMessage());
                    autoReplyViewModel3._autoReplyTitle.setValue(autoReply.getTitle());
                    autoReplyViewModel3._autoReplyType.setValue(autoReply.getType());
                    autoReplyViewModel3._isActive.setValue(Boxing.boxBoolean(autoReply.isActive()));
                    Integer amount = autoReply.getAmount();
                    if (amount != null) {
                        autoReplyViewModel3._transactionAmount.setValue(String.valueOf(amount.intValue()));
                        autoReplyViewModel3._showAmountInput.setValue(Boxing.boxBoolean(true));
                    }
                }
            } catch (Exception e) {
                AutoReplyViewModel.this._message.setValue(e.toString());
            }
            return Unit.INSTANCE;
        }
    }

    public final void getAutoReplyById(long id) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07541(id, null), 3, null);
    }

    public final void onAutoReplyMessageChanged(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this._autoReplyMessage.setValue(message);
    }

    public final void onAutoReplyTitleChanged(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this._autoReplyTitle.setValue(title);
    }

    public final void onAutoReplyTypeChanged(AutoReplyType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this._autoReplyType.setValue(type);
    }

    public final void onTransactionAmountChanged(String amount) {
        Intrinsics.checkNotNullParameter(amount, "amount");
        String str = amount;
        if (str.length() != 0) {
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return;
                }
            }
        }
        this._transactionAmount.setValue(amount);
    }

    public final void onIsActiveChanged(boolean active) {
        this._isActive.setValue(Boolean.valueOf(active));
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.AutoReplyViewModel$updateAutoReply$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoReplyViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.AutoReplyViewModel$updateAutoReply$1", f = "AutoReplyViewModel.kt", i = {0, 1}, l = {122, 137}, m = "invokeSuspend", n = {"updatedAutoReply", "newAutoReply"}, s = {"L$0", "L$0"})
    static final class C07561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C07561(Continuation<? super C07561> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoReplyViewModel.this.new C07561(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0163, code lost:
        
            if (r19.this$0.autoReplyRepository.addAutoReply(r9, r19) == r3) goto L26;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AutoReplyViewModel.this._updateSuccess.setValue(Boxing.boxBoolean(false));
                    if (AutoReplyViewModel.this.selectedAutoReply != null) {
                        AutoReply autoReply = AutoReplyViewModel.this.selectedAutoReply;
                        Intrinsics.checkNotNull(autoReply);
                        AutoReply autoReplyCopy$default = AutoReply.copy$default(autoReply, 0L, (String) AutoReplyViewModel.this._autoReplyTitle.getValue(), (String) AutoReplyViewModel.this._autoReplyMessage.getValue(), ((Boolean) AutoReplyViewModel.this._isActive.getValue()).booleanValue(), (AutoReplyType) AutoReplyViewModel.this._autoReplyType.getValue(), ((Boolean) AutoReplyViewModel.this._showAmountInput.getValue()).booleanValue() ? StringsKt.toIntOrNull((String) AutoReplyViewModel.this._transactionAmount.getValue()) : null, 1, null);
                        Log.d("AutoRep", "Updating auto reply: " + autoReplyCopy$default);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(autoReplyCopy$default);
                        this.label = 1;
                        if (AutoReplyViewModel.this.autoReplyRepository.updateAutoReply(autoReplyCopy$default, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        AutoReply autoReply2 = new AutoReply(0L, (String) AutoReplyViewModel.this._autoReplyTitle.getValue(), (String) AutoReplyViewModel.this._autoReplyMessage.getValue(), ((Boolean) AutoReplyViewModel.this._isActive.getValue()).booleanValue(), (AutoReplyType) AutoReplyViewModel.this._autoReplyType.getValue(), ((Boolean) AutoReplyViewModel.this._showAmountInput.getValue()).booleanValue() ? StringsKt.toIntOrNull((String) AutoReplyViewModel.this._transactionAmount.getValue()) : null, 1, null);
                        Log.d("AutoRep", "Creating new auto reply: " + autoReply2);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(autoReply2);
                        this.label = 2;
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                AutoReplyViewModel.this._updateSuccess.setValue(Boxing.boxBoolean(true));
            } catch (Exception e) {
                AutoReplyViewModel.this._message.setValue(String.valueOf(e.getMessage()));
            }
            return Unit.INSTANCE;
        }
    }

    public final void updateAutoReply() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07561(null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.AutoReplyViewModel$onAutoReplyStatusChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoReplyViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.AutoReplyViewModel$onAutoReplyStatusChanged$1", f = "AutoReplyViewModel.kt", i = {}, l = {TextFieldImplKt.AnimationDuration}, m = "invokeSuspend", n = {}, s = {})
    static final class C07551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AutoReply $autoReply;
        final /* synthetic */ boolean $status;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07551(AutoReply autoReply, boolean z, Continuation<? super C07551> continuation) {
            super(2, continuation);
            this.$autoReply = autoReply;
            this.$status = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoReplyViewModel.this.new C07551(this.$autoReply, this.$status, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objUpdateAutoReply = AutoReplyViewModel.this.autoReplyRepository.updateAutoReply(AutoReply.copy$default(this.$autoReply, 0L, null, null, this.$status, null, null, 55, null), this);
                    this = objUpdateAutoReply;
                    if (objUpdateAutoReply == coroutine_suspended) {
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
                AutoReplyViewModel.this._message.setValue(String.valueOf(e.getMessage()));
            }
            return Unit.INSTANCE;
        }
    }

    public final void onAutoReplyStatusChanged(AutoReply autoReply, boolean status) {
        Intrinsics.checkNotNullParameter(autoReply, "autoReply");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07551(autoReply, status, null), 2, null);
    }

    public final void resetSuccessStatus() {
        this._updateSuccess.setValue(false);
    }

    public final void toggleAmountInputVisibility() {
        MutableStateFlow<Boolean> mutableStateFlow = this._showAmountInput;
        mutableStateFlow.setValue(Boolean.valueOf(!mutableStateFlow.getValue().booleanValue()));
        if (this._showAmountInput.getValue().booleanValue()) {
            return;
        }
        this._transactionAmount.setValue("");
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.AutoReplyViewModel$deleteAutoReply$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoReplyViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.AutoReplyViewModel$deleteAutoReply$1", f = "AutoReplyViewModel.kt", i = {0, 0, 0, 0}, l = {176}, m = "invokeSuspend", n = {"$this$launch", "autoReplyId", "replyId", "$i$a$-let-AutoReplyViewModel$deleteAutoReply$1$1"}, s = {"L$0", "L$1", "J$0", "I$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Long $id;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ AutoReplyViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Long l, AutoReplyViewModel autoReplyViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$id = l;
            this.this$0 = autoReplyViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$id, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AutoReplyViewModel autoReplyViewModel;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Long lBoxLong = this.$id;
                    if (lBoxLong == null) {
                        AutoReply autoReply = this.this$0.selectedAutoReply;
                        lBoxLong = autoReply != null ? Boxing.boxLong(autoReply.getId()) : null;
                    }
                    if (lBoxLong == null) {
                        this.this$0._message.setValue("No auto-reply selected for deletion");
                    } else {
                        AutoReplyViewModel autoReplyViewModel2 = this.this$0;
                        long jLongValue = lBoxLong.longValue();
                        AutoReplyRepository autoReplyRepository = autoReplyViewModel2.autoReplyRepository;
                        this.L$0 = coroutineScope;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(lBoxLong);
                        this.L$2 = autoReplyViewModel2;
                        this.J$0 = jLongValue;
                        this.I$0 = 0;
                        this.label = 1;
                        obj = autoReplyRepository.deleteAutoReply(jLongValue, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        autoReplyViewModel = autoReplyViewModel2;
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                autoReplyViewModel = (AutoReplyViewModel) this.L$2;
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    autoReplyViewModel._updateSuccess.setValue(Boxing.boxBoolean(true));
                } else {
                    autoReplyViewModel._message.setValue("Failed to delete auto-reply");
                }
            } catch (Exception e) {
                this.this$0._message.setValue("Error deleting auto-reply: " + e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void deleteAutoReply$default(AutoReplyViewModel autoReplyViewModel, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        autoReplyViewModel.deleteAutoReply(l);
    }

    public final void deleteAutoReply(Long id) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(id, this, null), 2, null);
    }
}
