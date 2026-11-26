package com.example.bingwahybrid.presentation.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import javax.inject.Inject;
import kotlin.Metadata;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: PinSetupViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0018J\u000e\u0010%\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020\"J\b\u0010(\u001a\u00020\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000fR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000f¨\u0006)"}, d2 = {"Lcom/example/bingwahybrid/presentation/viewmodel/PinSetupViewModel;", "Landroidx/lifecycle/ViewModel;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;)V", "pinDelay", "", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isLoading", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "_isConfirming", "isConfirming", "_isPinError", "isPinError", "_pinSetupSuccess", "pinSetupSuccess", "getPinSetupSuccess", "_snackbarMessage", "", "snackbarMessage", "getSnackbarMessage", "_pin", "pin", "getPin", "_confirmPin", "confirmPin", "getConfirmPin", "onDeletePin", "", "onNumberClick", "number", "attemptPinSetup", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetSnackbarMessage", "clearPin", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PinSetupViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _confirmPin;
    private final MutableStateFlow<Boolean> _isConfirming;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<Boolean> _isPinError;
    private final MutableStateFlow<String> _pin;
    private final MutableStateFlow<Boolean> _pinSetupSuccess;
    private final MutableStateFlow<String> _snackbarMessage;
    private final AuthRepository authRepository;
    private final StateFlow<String> confirmPin;
    private final StateFlow<Boolean> isConfirming;
    private final StateFlow<Boolean> isLoading;
    private final StateFlow<Boolean> isPinError;
    private final StateFlow<String> pin;
    private final long pinDelay;
    private final StateFlow<Boolean> pinSetupSuccess;
    private final SettingsRepository settingsRepository;
    private final StateFlow<String> snackbarMessage;

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.PinSetupViewModel$attemptPinSetup$1, reason: invalid class name */
    /* JADX INFO: compiled from: PinSetupViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.PinSetupViewModel", f = "PinSetupViewModel.kt", i = {0}, l = {95}, m = "attemptPinSetup", n = {"pin"}, s = {"L$0"})
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
            return PinSetupViewModel.this.attemptPinSetup(this);
        }
    }

    @Inject
    public PinSetupViewModel(SettingsRepository settingsRepository, AuthRepository authRepository) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        this.settingsRepository = settingsRepository;
        this.authRepository = authRepository;
        this.pinDelay = 500L;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow;
        this.isLoading = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._isConfirming = MutableStateFlow2;
        this.isConfirming = MutableStateFlow2;
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._isPinError = MutableStateFlow3;
        this.isPinError = MutableStateFlow3;
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(false);
        this._pinSetupSuccess = MutableStateFlow4;
        this.pinSetupSuccess = MutableStateFlow4;
        MutableStateFlow<String> MutableStateFlow5 = StateFlowKt.MutableStateFlow(null);
        this._snackbarMessage = MutableStateFlow5;
        this.snackbarMessage = MutableStateFlow5;
        MutableStateFlow<String> MutableStateFlow6 = StateFlowKt.MutableStateFlow("");
        this._pin = MutableStateFlow6;
        this.pin = MutableStateFlow6;
        MutableStateFlow<String> MutableStateFlow7 = StateFlowKt.MutableStateFlow("");
        this._confirmPin = MutableStateFlow7;
        this.confirmPin = MutableStateFlow7;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final StateFlow<Boolean> isConfirming() {
        return this.isConfirming;
    }

    public final StateFlow<Boolean> isPinError() {
        return this.isPinError;
    }

    public final StateFlow<Boolean> getPinSetupSuccess() {
        return this.pinSetupSuccess;
    }

    public final StateFlow<String> getSnackbarMessage() {
        return this.snackbarMessage;
    }

    public final StateFlow<String> getPin() {
        return this.pin;
    }

    public final StateFlow<String> getConfirmPin() {
        return this.confirmPin;
    }

    public final void onDeletePin() {
        if (!this.isConfirming.getValue().booleanValue()) {
            MutableStateFlow<String> mutableStateFlow = this._pin;
            mutableStateFlow.setValue(StringsKt.dropLast(mutableStateFlow.getValue(), 1));
        } else {
            MutableStateFlow<String> mutableStateFlow2 = this._confirmPin;
            mutableStateFlow2.setValue(StringsKt.dropLast(mutableStateFlow2.getValue(), 1));
        }
    }

    public final void onNumberClick(String number) {
        Intrinsics.checkNotNullParameter(number, "number");
        if (!this.isConfirming.getValue().booleanValue()) {
            if (this._pin.getValue().length() < 4) {
                MutableStateFlow<String> mutableStateFlow = this._pin;
                mutableStateFlow.setValue(((Object) mutableStateFlow.getValue()) + number);
            }
            if (this._pin.getValue().length() == 4) {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07791(null), 3, null);
                return;
            }
            return;
        }
        if (this._confirmPin.getValue().length() < 4) {
            MutableStateFlow<String> mutableStateFlow2 = this._confirmPin;
            mutableStateFlow2.setValue(((Object) mutableStateFlow2.getValue()) + number);
        }
        if (this._confirmPin.getValue().length() == 4) {
            if (Intrinsics.areEqual(this._pin.getValue(), this._confirmPin.getValue())) {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass3(null), 2, null);
            } else {
                this._isPinError.setValue(true);
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.PinSetupViewModel$onNumberClick$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PinSetupViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.PinSetupViewModel$onNumberClick$1", f = "PinSetupViewModel.kt", i = {}, l = {LockFreeTaskQueueCore.FROZEN_SHIFT}, m = "invokeSuspend", n = {}, s = {})
    static final class C07791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07791(Continuation<? super C07791> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PinSetupViewModel.this.new C07791(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(PinSetupViewModel.this.pinDelay, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PinSetupViewModel.this._isConfirming.setValue(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.PinSetupViewModel$onNumberClick$2, reason: invalid class name */
    /* JADX INFO: compiled from: PinSetupViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.PinSetupViewModel$onNumberClick$2", f = "PinSetupViewModel.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PinSetupViewModel.this.new AnonymousClass2(continuation);
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
                this.label = 1;
                if (DelayKt.delay(PinSetupViewModel.this.pinDelay + ((long) 2000), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PinSetupViewModel.this.clearPin();
            PinSetupViewModel.this._isConfirming.setValue(Boxing.boxBoolean(false));
            PinSetupViewModel.this._isPinError.setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.PinSetupViewModel$onNumberClick$3, reason: invalid class name */
    /* JADX INFO: compiled from: PinSetupViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.PinSetupViewModel$onNumberClick$3", f = "PinSetupViewModel.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PinSetupViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PinSetupViewModel.this.attemptPinSetup(this) == coroutine_suspended) {
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
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object attemptPinSetup(Continuation<? super Unit> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String value = this._pin.getValue();
                this._isLoading.setValue(Boxing.boxBoolean(true));
                AuthRepository authRepository = this.authRepository;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(value);
                anonymousClass1.label = 1;
                if (authRepository.updateAgentPin(value, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this._snackbarMessage.setValue("PIN setup successful");
            this._pinSetupSuccess.setValue(Boxing.boxBoolean(true));
        } catch (Exception e) {
            clearPin();
            this._snackbarMessage.setValue(e.getMessage());
            this._pinSetupSuccess.setValue(Boxing.boxBoolean(false));
        } finally {
            this._isLoading.setValue(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }

    public final void resetSnackbarMessage() {
        this._snackbarMessage.setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearPin() {
        this._pin.setValue("");
        this._confirmPin.setValue("");
    }
}
