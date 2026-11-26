package com.example.bingwahybrid.presentation.viewmodel;

import android.util.Patterns;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.exception.InvalidEmailException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: ForgotPasswordViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/example/bingwahybrid/presentation/viewmodel/ForgotPasswordViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;)V", "_email", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "email", "Lkotlinx/coroutines/flow/StateFlow;", "getEmail", "()Lkotlinx/coroutines/flow/StateFlow;", "_isLoading", "", "isLoading", "_sendSuccess", "sendSuccess", "getSendSuccess", "_snackbarMessage", "snackbarMessage", "getSnackbarMessage", "_emailError", "emailError", "getEmailError", "onEmailChanged", "", "sendResetPin", "resetSnackbarMessage", "validateEmail", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ForgotPasswordViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _email;
    private final MutableStateFlow<String> _emailError;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<Boolean> _sendSuccess;
    private final MutableStateFlow<String> _snackbarMessage;
    private final AuthRepository authRepository;
    private final StateFlow<String> email;
    private final StateFlow<String> emailError;
    private final StateFlow<Boolean> isLoading;
    private final StateFlow<Boolean> sendSuccess;
    private final StateFlow<String> snackbarMessage;

    @Inject
    public ForgotPasswordViewModel(AuthRepository authRepository) {
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        this.authRepository = authRepository;
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow("");
        this._email = MutableStateFlow;
        this.email = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow2;
        this.isLoading = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._sendSuccess = MutableStateFlow3;
        this.sendSuccess = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<String> MutableStateFlow4 = StateFlowKt.MutableStateFlow(null);
        this._snackbarMessage = MutableStateFlow4;
        this.snackbarMessage = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<String> MutableStateFlow5 = StateFlowKt.MutableStateFlow(null);
        this._emailError = MutableStateFlow5;
        this.emailError = FlowKt.asStateFlow(MutableStateFlow5);
    }

    public final StateFlow<String> getEmail() {
        return this.email;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final StateFlow<Boolean> getSendSuccess() {
        return this.sendSuccess;
    }

    public final StateFlow<String> getSnackbarMessage() {
        return this.snackbarMessage;
    }

    public final StateFlow<String> getEmailError() {
        return this.emailError;
    }

    public final void onEmailChanged(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        String value = this._emailError.getValue();
        if (value != null && value.length() != 0) {
            this._emailError.setValue(null);
        }
        this._email.setValue(email);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.ForgotPasswordViewModel$sendResetPin$1, reason: invalid class name */
    /* JADX INFO: compiled from: ForgotPasswordViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.ForgotPasswordViewModel$sendResetPin$1", f = "ForgotPasswordViewModel.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ForgotPasswordViewModel.this.new AnonymousClass1(continuation);
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
                    ForgotPasswordViewModel forgotPasswordViewModel = ForgotPasswordViewModel.this;
                    forgotPasswordViewModel.validateEmail((String) forgotPasswordViewModel._email.getValue());
                    ForgotPasswordViewModel.this._isLoading.setValue(Boxing.boxBoolean(true));
                    this.label = 1;
                    if (ForgotPasswordViewModel.this.authRepository.sendOtp((String) ForgotPasswordViewModel.this._email.getValue(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ForgotPasswordViewModel.this._sendSuccess.setValue(Boxing.boxBoolean(true));
            } catch (InvalidEmailException e) {
                ForgotPasswordViewModel.this._emailError.setValue(String.valueOf(e.getMessage()));
            } catch (Exception e2) {
                ForgotPasswordViewModel.this._sendSuccess.setValue(Boxing.boxBoolean(false));
                ForgotPasswordViewModel.this._isLoading.setValue(Boxing.boxBoolean(false));
                ForgotPasswordViewModel.this._snackbarMessage.setValue(String.valueOf(e2.getMessage()));
            }
            return Unit.INSTANCE;
        }
    }

    public final void sendResetPin() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    public final void resetSnackbarMessage() {
        this._snackbarMessage.setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateEmail(String email) throws InvalidEmailException {
        String str = email;
        if (str.length() == 0) {
            throw new InvalidEmailException("You have not entered your email");
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
            throw new InvalidEmailException("Invalid email address");
        }
    }
}
