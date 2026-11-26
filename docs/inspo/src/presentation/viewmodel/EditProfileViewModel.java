package com.example.bingwahybrid.presentation.viewmodel;

import android.util.Log;
import android.util.Patterns;
import androidx.autofill.HintConstants;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.auth.models.Agent;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.UpdateAgentUseCase;
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

/* JADX INFO: compiled from: EditProfileViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010,\u001a\u00020-2\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010.\u001a\u00020-2\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010/\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u0011J\u000e\u00100\u001a\u00020-2\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u00101\u001a\u00020-J\b\u00102\u001a\u00020-H\u0002J\b\u00103\u001a\u00020\rH\u0002J\b\u00104\u001a\u00020-H\u0002J\u0006\u00105\u001a\u00020-R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000fR\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000fR\u0016\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000fR\u0016\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR\u0016\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000f¨\u00066"}, d2 = {"Lcom/example/bingwahybrid/presentation/viewmodel/EditProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "updateAgentUseCase", "Lcom/example/bingwahybrid/domain/auth/usecase/UpdateAgentUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;Lcom/example/bingwahybrid/domain/auth/usecase/UpdateAgentUseCase;)V", "agent", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/bingwahybrid/domain/auth/models/Agent;", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "_snackBarMessage", "", "snackBarMessage", "getSnackBarMessage", "_firstName", "firstName", "getFirstName", "_lastName", "lastName", "getLastName", "_phoneNumber", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "getPhoneNumber", "_email", "email", "getEmail", "_firstNameError", "firstNameError", "getFirstNameError", "_lastNameError", "lastNameError", "getLastNameError", "_phoneNumberError", "phoneNumberError", "getPhoneNumberError", "_emailError", "emailError", "getEmailError", "onFirstNameChanged", "", "onLastNameChanged", "onPhoneNumberChanged", "onEmailChanged", "updateProfile", "loadProfileInfo", "validateInputs", "clearErrors", "resetSnackBarMessage", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EditProfileViewModel extends ViewModel {
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
    private final MutableStateFlow<String> _snackBarMessage;
    private final StateFlow<Agent> agent;
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
    private final StateFlow<String> snackBarMessage;
    private final UpdateAgentUseCase updateAgentUseCase;

    @Inject
    public EditProfileViewModel(AuthRepository authRepository, UpdateAgentUseCase updateAgentUseCase) {
        String email;
        String phoneNumber;
        String lastName;
        String firstName;
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(updateAgentUseCase, "updateAgentUseCase");
        this.authRepository = authRepository;
        this.updateAgentUseCase = updateAgentUseCase;
        StateFlow<Agent> agent = authRepository.getAgent();
        this.agent = agent;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow;
        this.isLoading = MutableStateFlow;
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._snackBarMessage = MutableStateFlow2;
        this.snackBarMessage = MutableStateFlow2;
        Agent value = agent.getValue();
        String str = "";
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow((value == null || (firstName = value.getFirstName()) == null) ? "" : firstName);
        this._firstName = MutableStateFlow3;
        this.firstName = MutableStateFlow3;
        Agent value2 = agent.getValue();
        MutableStateFlow<String> MutableStateFlow4 = StateFlowKt.MutableStateFlow((value2 == null || (lastName = value2.getLastName()) == null) ? "" : lastName);
        this._lastName = MutableStateFlow4;
        this.lastName = MutableStateFlow4;
        Agent value3 = agent.getValue();
        MutableStateFlow<String> MutableStateFlow5 = StateFlowKt.MutableStateFlow((value3 == null || (phoneNumber = value3.getPhoneNumber()) == null) ? "" : phoneNumber);
        this._phoneNumber = MutableStateFlow5;
        this.phoneNumber = MutableStateFlow5;
        Agent value4 = agent.getValue();
        if (value4 != null && (email = value4.getEmail()) != null) {
            str = email;
        }
        MutableStateFlow<String> MutableStateFlow6 = StateFlowKt.MutableStateFlow(str);
        this._email = MutableStateFlow6;
        this.email = MutableStateFlow6;
        MutableStateFlow<String> MutableStateFlow7 = StateFlowKt.MutableStateFlow(null);
        this._firstNameError = MutableStateFlow7;
        this.firstNameError = MutableStateFlow7;
        MutableStateFlow<String> MutableStateFlow8 = StateFlowKt.MutableStateFlow(null);
        this._lastNameError = MutableStateFlow8;
        this.lastNameError = MutableStateFlow8;
        MutableStateFlow<String> MutableStateFlow9 = StateFlowKt.MutableStateFlow(null);
        this._phoneNumberError = MutableStateFlow9;
        this.phoneNumberError = MutableStateFlow9;
        MutableStateFlow<String> MutableStateFlow10 = StateFlowKt.MutableStateFlow(null);
        this._emailError = MutableStateFlow10;
        this.emailError = MutableStateFlow10;
        loadProfileInfo();
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final StateFlow<String> getSnackBarMessage() {
        return this.snackBarMessage;
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

    public final void updateProfile() {
        UUID id;
        if (validateInputs()) {
            Agent value = this.agent.getValue();
            Log.d("EditProfileViewModel", "AgentId " + (value != null ? value.getId() : null));
            Agent value2 = this.agent.getValue();
            if (value2 == null || (id = value2.getId()) == null) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07591(id, this, null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.EditProfileViewModel$updateProfile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EditProfileViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.EditProfileViewModel$updateProfile$1", f = "EditProfileViewModel.kt", i = {0}, l = {94}, m = "invokeSuspend", n = {"updatedAgent"}, s = {"L$0"})
    static final class C07591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UUID $agentId;
        Object L$0;
        int label;
        final /* synthetic */ EditProfileViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07591(UUID uuid, EditProfileViewModel editProfileViewModel, Continuation<? super C07591> continuation) {
            super(2, continuation);
            this.$agentId = uuid;
            this.this$0 = editProfileViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07591(this.$agentId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Agent agent = new Agent(this.$agentId, this.this$0.getFirstName().getValue(), this.this$0.getLastName().getValue(), this.this$0.getPhoneNumber().getValue(), this.this$0.getEmail().getValue(), null, false, false, 224, null);
                    this.this$0._isLoading.setValue(Boxing.boxBoolean(true));
                    this.L$0 = SpillingKt.nullOutSpilledVariable(agent);
                    this.label = 1;
                    if (this.this$0.updateAgentUseCase.invoke(agent, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0._snackBarMessage.setValue("Profile updated successfully");
            } catch (Exception e) {
                this.this$0._snackBarMessage.setValue(e.getMessage());
            } finally {
                this.this$0._isLoading.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.EditProfileViewModel$loadProfileInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: EditProfileViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.EditProfileViewModel$loadProfileInfo$1", f = "EditProfileViewModel.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EditProfileViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object loggedInAgent = EditProfileViewModel.this.authRepository.getLoggedInAgent(this);
                    this = loggedInAgent;
                    if (loggedInAgent == coroutine_suspended) {
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
                EditProfileViewModel.this._snackBarMessage.setValue(e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    private final void loadProfileInfo() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0041  */
    /* JADX WARN: Code duplicated, block: B:14:0x004a  */
    /* JADX WARN: Code duplicated, block: B:16:0x005f  */
    /* JADX WARN: Code duplicated, block: B:19:0x0075  */
    /* JADX WARN: Code duplicated, block: B:21:0x007d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0091  */
    /* JADX WARN: Code duplicated, block: B:25:0x0099 A[RETURN] */
    private final boolean validateInputs() {
        boolean z;
        clearErrors();
        if (this.firstName.getValue().length() == 0) {
            this._firstNameError.setValue("Full name is required");
        } else {
            if (this.firstName.getValue().length() < 3) {
                this._firstNameError.setValue("Full name must be at least 3 characters");
            } else {
                z = true;
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

    public final void resetSnackBarMessage() {
        this._snackBarMessage.setValue(null);
    }
}
