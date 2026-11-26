package com.example.bingwahybrid.presentation.viewmodel;

import android.util.Patterns;
import androidx.autofill.HintConstants;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.auth.models.Agent;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.RegisterUserUseCase;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: RegisterViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010.\u001a\u00020/2\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u00100\u001a\u00020/2\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u00101\u001a\u00020/2\u0006\u0010\u001c\u001a\u00020\u0012J\u000e\u00102\u001a\u00020/2\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u00103\u001a\u00020/J\b\u00104\u001a\u00020\nH\u0002J\b\u00105\u001a\u00020/H\u0002J\u0006\u00106\u001a\u00020/J\u0006\u00107\u001a\u00020/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\rR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\rR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\rR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\rR\u0016\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\rR\u0016\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\rR\u0016\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\r¨\u00068"}, d2 = {"Lcom/example/bingwahybrid/presentation/viewmodel/RegisterViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "registerUserUseCase", "Lcom/example/bingwahybrid/domain/auth/usecase/RegisterUserUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;Lcom/example/bingwahybrid/domain/auth/usecase/RegisterUserUseCase;)V", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isLoading", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "_registerSuccess", "registerSuccess", "getRegisterSuccess", "_snackbarMessage", "", "snackbarMessage", "getSnackbarMessage", "_firstName", "firstName", "getFirstName", "_lastName", "lastName", "getLastName", "_phoneNumber", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "getPhoneNumber", "_email", "email", "getEmail", "_pin", "_firstNameError", "firstNameError", "getFirstNameError", "_lastNameError", "lastNameError", "getLastNameError", "_phoneNumberError", "phoneNumberError", "getPhoneNumberError", "_emailError", "emailError", "getEmailError", "onFirstNameChanged", "", "onLastNameChanged", "onPhoneNumberChanged", "onEmailChanged", "register", "validateInputs", "clearErrors", "resetSnackbarMessage", "registerWithGoogle", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RegisterViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _email;
    private final MutableStateFlow<String> _emailError;
    private final MutableStateFlow<String> _firstName;
    private final MutableStateFlow<String> _firstNameError;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<String> _lastName;
    private final MutableStateFlow<String> _lastNameError;
    private final MutableStateFlow<String> _phoneNumber;
    private final MutableStateFlow<String> _phoneNumberError;
    private final MutableStateFlow<String> _pin;
    private final MutableStateFlow<Boolean> _registerSuccess;
    private final MutableStateFlow<String> _snackbarMessage;
    private final AuthRepository authRepository;
    private final StateFlow<String> email;
    private final StateFlow<String> emailError;
    private final StateFlow<String> firstName;
    private final StateFlow<String> firstNameError;
    private final StateFlow<Boolean> isLoading;
    private final StateFlow<String> lastName;
    private final StateFlow<String> lastNameError;
    private final StateFlow<String> phoneNumber;
    private final StateFlow<String> phoneNumberError;
    private final StateFlow<Boolean> registerSuccess;
    private final RegisterUserUseCase registerUserUseCase;
    private final StateFlow<String> snackbarMessage;

    public final void registerWithGoogle() {
    }

    @Inject
    public RegisterViewModel(AuthRepository authRepository, RegisterUserUseCase registerUserUseCase) {
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(registerUserUseCase, "registerUserUseCase");
        this.authRepository = authRepository;
        this.registerUserUseCase = registerUserUseCase;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow;
        this.isLoading = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._registerSuccess = MutableStateFlow2;
        this.registerSuccess = MutableStateFlow2;
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._snackbarMessage = MutableStateFlow3;
        this.snackbarMessage = MutableStateFlow3;
        MutableStateFlow<String> MutableStateFlow4 = StateFlowKt.MutableStateFlow("");
        this._firstName = MutableStateFlow4;
        this.firstName = MutableStateFlow4;
        MutableStateFlow<String> MutableStateFlow5 = StateFlowKt.MutableStateFlow("");
        this._lastName = MutableStateFlow5;
        this.lastName = MutableStateFlow5;
        MutableStateFlow<String> MutableStateFlow6 = StateFlowKt.MutableStateFlow("");
        this._phoneNumber = MutableStateFlow6;
        this.phoneNumber = MutableStateFlow6;
        MutableStateFlow<String> MutableStateFlow7 = StateFlowKt.MutableStateFlow("");
        this._email = MutableStateFlow7;
        this.email = MutableStateFlow7;
        this._pin = StateFlowKt.MutableStateFlow("1234");
        MutableStateFlow<String> MutableStateFlow8 = StateFlowKt.MutableStateFlow(null);
        this._firstNameError = MutableStateFlow8;
        this.firstNameError = MutableStateFlow8;
        MutableStateFlow<String> MutableStateFlow9 = StateFlowKt.MutableStateFlow(null);
        this._lastNameError = MutableStateFlow9;
        this.lastNameError = MutableStateFlow9;
        MutableStateFlow<String> MutableStateFlow10 = StateFlowKt.MutableStateFlow(null);
        this._phoneNumberError = MutableStateFlow10;
        this.phoneNumberError = MutableStateFlow10;
        MutableStateFlow<String> MutableStateFlow11 = StateFlowKt.MutableStateFlow(null);
        this._emailError = MutableStateFlow11;
        this.emailError = MutableStateFlow11;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final StateFlow<Boolean> getRegisterSuccess() {
        return this.registerSuccess;
    }

    public final StateFlow<String> getSnackbarMessage() {
        return this.snackbarMessage;
    }

    public final StateFlow<String> getFirstName() {
        return this.firstName;
    }

    public final StateFlow<String> getLastName() {
        return this.lastName;
    }

    public final StateFlow<String> getPhoneNumber() {
        return this.phoneNumber;
    }

    public final StateFlow<String> getEmail() {
        return this.email;
    }

    public final StateFlow<String> getFirstNameError() {
        return this.firstNameError;
    }

    public final StateFlow<String> getLastNameError() {
        return this.lastNameError;
    }

    public final StateFlow<String> getPhoneNumberError() {
        return this.phoneNumberError;
    }

    public final StateFlow<String> getEmailError() {
        return this.emailError;
    }

    public final void onFirstNameChanged(String firstName) {
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        if (this._firstNameError.getValue() != null) {
            this._firstNameError.setValue(null);
        }
        this._firstName.setValue(firstName);
    }

    public final void onLastNameChanged(String lastName) {
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        if (this._lastNameError.getValue() != null) {
            this._lastNameError.setValue(null);
        }
        this._lastName.setValue(lastName);
    }

    public final void onPhoneNumberChanged(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        if (this._phoneNumberError.getValue() != null) {
            this._phoneNumberError.setValue(null);
        }
        this._phoneNumber.setValue(phoneNumber);
    }

    public final void onEmailChanged(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        if (this._emailError.getValue() != null) {
            this._emailError.setValue(null);
        }
        this._email.setValue(email);
    }

    public final void register() {
        if (validateInputs()) {
            clearErrors();
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this.firstName.getValue(), this.lastName.getValue(), this.phoneNumber.getValue(), this.email.getValue(), this._pin.getValue(), this, null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.RegisterViewModel$register$1, reason: invalid class name */
    /* JADX INFO: compiled from: RegisterViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.RegisterViewModel$register$1", f = "RegisterViewModel.kt", i = {0}, l = {99}, m = "invokeSuspend", n = {"agent"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $email;
        final /* synthetic */ String $firstName;
        final /* synthetic */ String $lastName;
        final /* synthetic */ String $phone;
        final /* synthetic */ String $pin;
        Object L$0;
        int label;
        final /* synthetic */ RegisterViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, String str4, String str5, RegisterViewModel registerViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$firstName = str;
            this.$lastName = str2;
            this.$phone = str3;
            this.$email = str4;
            this.$pin = str5;
            this.this$0 = registerViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$firstName, this.$lastName, this.$phone, this.$email, this.$pin, this.this$0, continuation);
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
                    UUID uuidRandomUUID = UUID.randomUUID();
                    Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID(...)");
                    Agent agent = new Agent(uuidRandomUUID, this.$firstName, this.$lastName, this.$phone, this.$email, this.$pin, false, false, 192, null);
                    this.this$0._isLoading.setValue(Boxing.boxBoolean(true));
                    this.L$0 = SpillingKt.nullOutSpilledVariable(agent);
                    this.label = 1;
                    if (this.this$0.registerUserUseCase.invoke(agent, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0._isLoading.setValue(Boxing.boxBoolean(false));
                this.this$0._registerSuccess.setValue(Boxing.boxBoolean(true));
            } catch (Exception e) {
                this.this$0._isLoading.setValue(Boxing.boxBoolean(false));
                this.this$0._snackbarMessage.setValue(e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003e  */
    /* JADX WARN: Code duplicated, block: B:14:0x0047  */
    /* JADX WARN: Code duplicated, block: B:16:0x0055  */
    /* JADX WARN: Code duplicated, block: B:19:0x006b  */
    /* JADX WARN: Code duplicated, block: B:21:0x0074  */
    /* JADX WARN: Code duplicated, block: B:23:0x0089  */
    /* JADX WARN: Code duplicated, block: B:26:0x009f  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:30:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:32:0x00c3 A[RETURN] */
    private final boolean validateInputs() {
        boolean z;
        if (this.firstName.getValue().length() == 0) {
            this._firstNameError.setValue("First name is required");
        } else {
            if (this.firstName.getValue().length() < 3) {
                this._firstNameError.setValue("First name must be at least 2 characters");
            } else {
                z = true;
            }
            if (this.lastName.getValue().length() == 0) {
                this._lastNameError.setValue("Last name is required");
            } else {
                if (this.lastName.getValue().length() < 3) {
                    this._lastNameError.setValue("Last name must be at least 2 characters");
                }
                if (this.phoneNumber.getValue().length() == 0) {
                    this._phoneNumberError.setValue("Phone number is required");
                } else {
                    if (!new Regex("^[0-9]{10}$").matches(this.phoneNumber.getValue())) {
                        this._phoneNumberError.setValue("Phone number must be 10 digits");
                    }
                    if (this.email.getValue().length() == 0) {
                        this._emailError.setValue("Email is required");
                        return false;
                    }
                    if (!Patterns.EMAIL_ADDRESS.matcher(this.email.getValue()).matches()) {
                        return z;
                    }
                    this._emailError.setValue("Invalid email format");
                    return false;
                }
                z = false;
                if (this.email.getValue().length() == 0) {
                    this._emailError.setValue("Email is required");
                    return false;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(this.email.getValue()).matches()) {
                    return z;
                }
                this._emailError.setValue("Invalid email format");
                return false;
            }
            z = false;
            if (this.phoneNumber.getValue().length() == 0) {
                this._phoneNumberError.setValue("Phone number is required");
            } else {
                if (!new Regex("^[0-9]{10}$").matches(this.phoneNumber.getValue())) {
                    this._phoneNumberError.setValue("Phone number must be 10 digits");
                }
                if (this.email.getValue().length() == 0) {
                    this._emailError.setValue("Email is required");
                    return false;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(this.email.getValue()).matches()) {
                    return z;
                }
                this._emailError.setValue("Invalid email format");
                return false;
            }
            z = false;
            if (this.email.getValue().length() == 0) {
                this._emailError.setValue("Email is required");
                return false;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(this.email.getValue()).matches()) {
                return z;
            }
            this._emailError.setValue("Invalid email format");
            return false;
        }
        z = false;
        if (this.lastName.getValue().length() == 0) {
            this._lastNameError.setValue("Last name is required");
        } else {
            if (this.lastName.getValue().length() < 3) {
                this._lastNameError.setValue("Last name must be at least 2 characters");
            }
            if (this.phoneNumber.getValue().length() == 0) {
                this._phoneNumberError.setValue("Phone number is required");
            } else {
                if (!new Regex("^[0-9]{10}$").matches(this.phoneNumber.getValue())) {
                    this._phoneNumberError.setValue("Phone number must be 10 digits");
                }
                if (this.email.getValue().length() == 0) {
                    this._emailError.setValue("Email is required");
                    return false;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(this.email.getValue()).matches()) {
                    return z;
                }
                this._emailError.setValue("Invalid email format");
                return false;
            }
            z = false;
            if (this.email.getValue().length() == 0) {
                this._emailError.setValue("Email is required");
                return false;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(this.email.getValue()).matches()) {
                return z;
            }
            this._emailError.setValue("Invalid email format");
            return false;
        }
        z = false;
        if (this.phoneNumber.getValue().length() == 0) {
            this._phoneNumberError.setValue("Phone number is required");
        } else {
            if (!new Regex("^[0-9]{10}$").matches(this.phoneNumber.getValue())) {
                this._phoneNumberError.setValue("Phone number must be 10 digits");
            }
            if (this.email.getValue().length() == 0) {
                this._emailError.setValue("Email is required");
                return false;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(this.email.getValue()).matches()) {
                return z;
            }
            this._emailError.setValue("Invalid email format");
            return false;
        }
        z = false;
        if (this.email.getValue().length() == 0) {
            this._emailError.setValue("Email is required");
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(this.email.getValue()).matches()) {
            return z;
        }
        this._emailError.setValue("Invalid email format");
        return false;
    }

    private final void clearErrors() {
        this._firstNameError.setValue(null);
        this._phoneNumberError.setValue(null);
        this._emailError.setValue(null);
    }

    public final void resetSnackbarMessage() {
        this._snackbarMessage.setValue(null);
    }
}
