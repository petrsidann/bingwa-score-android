package com.example.bingwahybrid.presentation.viewmodel;

import android.util.Patterns;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.auth.models.Agent;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.LoginCoordinator;
import java.net.UnknownHostException;
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
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: PinLoginViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010!\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0015J\u000e\u0010$\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\f¨\u0006'"}, d2 = {"Lcom/example/bingwahybrid/presentation/viewmodel/PinLoginViewModel;", "Landroidx/lifecycle/ViewModel;", "loginCoordinator", "Lcom/example/bingwahybrid/domain/auth/usecase/LoginCoordinator;", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/auth/usecase/LoginCoordinator;Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;)V", "agent", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/bingwahybrid/domain/auth/models/Agent;", "getAgent", "()Lkotlinx/coroutines/flow/StateFlow;", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isLoading", "_loginSuccess", "loginSuccess", "getLoginSuccess", "_email", "", "email", "getEmail", "_pin", "pin", "getPin", "_errorMessage", "errorMessage", "getErrorMessage", "onDeletePin", "", "onEmailChanged", "validateEmail", "onNumberClick", "number", "attemptLogin", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetErrorMessage", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PinLoginViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _email;
    private final MutableStateFlow<String> _errorMessage;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<Boolean> _loginSuccess;
    private final MutableStateFlow<String> _pin;
    private final StateFlow<Agent> agent;
    private final AuthRepository authRepository;
    private final StateFlow<String> email;
    private final StateFlow<String> errorMessage;
    private final StateFlow<Boolean> isLoading;
    private final LoginCoordinator loginCoordinator;
    private final StateFlow<Boolean> loginSuccess;
    private final StateFlow<String> pin;

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.PinLoginViewModel$attemptLogin$1, reason: invalid class name */
    /* JADX INFO: compiled from: PinLoginViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.PinLoginViewModel", f = "PinLoginViewModel.kt", i = {0}, l = {80}, m = "attemptLogin", n = {"pin"}, s = {"L$0"})
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
            return PinLoginViewModel.this.attemptLogin(this);
        }
    }

    @Inject
    public PinLoginViewModel(LoginCoordinator loginCoordinator, AuthRepository authRepository) {
        Intrinsics.checkNotNullParameter(loginCoordinator, "loginCoordinator");
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        this.loginCoordinator = loginCoordinator;
        this.authRepository = authRepository;
        this.agent = authRepository.getAgent();
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow;
        this.isLoading = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._loginSuccess = MutableStateFlow2;
        this.loginSuccess = MutableStateFlow2;
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow("");
        this._email = MutableStateFlow3;
        this.email = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<String> MutableStateFlow4 = StateFlowKt.MutableStateFlow("");
        this._pin = MutableStateFlow4;
        this.pin = MutableStateFlow4;
        MutableStateFlow<String> MutableStateFlow5 = StateFlowKt.MutableStateFlow(null);
        this._errorMessage = MutableStateFlow5;
        this.errorMessage = MutableStateFlow5;
    }

    public final StateFlow<Agent> getAgent() {
        return this.agent;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final StateFlow<Boolean> getLoginSuccess() {
        return this.loginSuccess;
    }

    public final StateFlow<String> getEmail() {
        return this.email;
    }

    public final StateFlow<String> getPin() {
        return this.pin;
    }

    public final StateFlow<String> getErrorMessage() {
        return this.errorMessage;
    }

    public final void onDeletePin() {
        MutableStateFlow<String> mutableStateFlow = this._pin;
        mutableStateFlow.setValue(StringsKt.dropLast(mutableStateFlow.getValue(), 1));
    }

    public final void onEmailChanged(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        if (this._errorMessage.getValue() != null) {
            this._errorMessage.setValue(null);
        }
        this._email.setValue(email);
    }

    public final boolean validateEmail() {
        if (this._email.getValue().length() == 0) {
            this._errorMessage.setValue("You have not entered your email");
            return false;
        }
        if (Patterns.EMAIL_ADDRESS.matcher(this._email.getValue()).matches()) {
            return true;
        }
        this._errorMessage.setValue("Invalid email address");
        return false;
    }

    public final void onNumberClick(String number) {
        Intrinsics.checkNotNullParameter(number, "number");
        if (this.errorMessage.getValue() != null) {
            return;
        }
        if (this._pin.getValue().length() < 4) {
            MutableStateFlow<String> mutableStateFlow = this._pin;
            mutableStateFlow.setValue(((Object) mutableStateFlow.getValue()) + number);
        }
        if (this._pin.getValue().length() == 4) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07771(null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.PinLoginViewModel$onNumberClick$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PinLoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.PinLoginViewModel$onNumberClick$1", f = "PinLoginViewModel.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    static final class C07771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07771(Continuation<? super C07771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PinLoginViewModel.this.new C07771(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PinLoginViewModel.this.attemptLogin(this) == coroutine_suspended) {
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
    public final Object attemptLogin(Continuation<? super Unit> continuation) {
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
                LoginCoordinator loginCoordinator = this.loginCoordinator;
                String value2 = this._email.getValue();
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(value);
                anonymousClass1.label = 1;
                if (loginCoordinator.invoke(value2, value, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this._loginSuccess.setValue(Boxing.boxBoolean(true));
        } catch (UnknownHostException unused) {
            this._errorMessage.setValue("Please check your internet connection");
            this._loginSuccess.setValue(Boxing.boxBoolean(false));
            resetErrorMessage();
        } catch (Exception e) {
            this._errorMessage.setValue(e.getMessage());
            this._loginSuccess.setValue(Boxing.boxBoolean(false));
            resetErrorMessage();
        } finally {
            this._isLoading.setValue(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.PinLoginViewModel$resetErrorMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PinLoginViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.PinLoginViewModel$resetErrorMessage$1", f = "PinLoginViewModel.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    static final class C07781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07781(Continuation<? super C07781> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PinLoginViewModel.this.new C07781(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(2000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PinLoginViewModel.this._pin.setValue("");
            PinLoginViewModel.this._errorMessage.setValue(null);
            return Unit.INSTANCE;
        }
    }

    private final void resetErrorMessage() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07781(null), 3, null);
    }
}
