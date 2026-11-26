package com.example.bingwahybrid.presentation.viewmodel;

import androidx.autofill.HintConstants;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.repository.AuthorizedSenderRepository;
import com.example.bingwahybrid.domain.sms.model.AuthorizedSender;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: AuthorizedSendersViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000b¨\u0006 "}, d2 = {"Lcom/example/bingwahybrid/presentation/viewmodel/AuthorizedSendersViewModel;", "Landroidx/lifecycle/ViewModel;", "authorizedSenderRepository", "Lcom/example/bingwahybrid/domain/repository/AuthorizedSenderRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/AuthorizedSenderRepository;)V", "authorizedSenders", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/bingwahybrid/domain/sms/model/AuthorizedSender;", "getAuthorizedSenders", "()Lkotlinx/coroutines/flow/StateFlow;", "_isAddDialogVisible", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isAddDialogVisible", "_phoneNumber", "", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "getPhoneNumber", "_snackbarMessage", "snackbarMessage", "getSnackbarMessage", "showAddDialog", "", "hideAddDialog", "updatePhoneNumber", "number", "addAuthorizedSender", "deleteAuthorizedSender", "sender", "resetSnackbarMessage", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AuthorizedSendersViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> _isAddDialogVisible;
    private final MutableStateFlow<String> _phoneNumber;
    private final MutableStateFlow<String> _snackbarMessage;
    private final AuthorizedSenderRepository authorizedSenderRepository;
    private final StateFlow<List<AuthorizedSender>> authorizedSenders;
    private final StateFlow<Boolean> isAddDialogVisible;
    private final StateFlow<String> phoneNumber;
    private final StateFlow<String> snackbarMessage;

    @Inject
    public AuthorizedSendersViewModel(AuthorizedSenderRepository authorizedSenderRepository) {
        Intrinsics.checkNotNullParameter(authorizedSenderRepository, "authorizedSenderRepository");
        this.authorizedSenderRepository = authorizedSenderRepository;
        this.authorizedSenders = FlowKt.stateIn(authorizedSenderRepository.getAuthorizedSenders(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), CollectionsKt.emptyList());
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isAddDialogVisible = MutableStateFlow;
        this.isAddDialogVisible = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow("");
        this._phoneNumber = MutableStateFlow2;
        this.phoneNumber = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._snackbarMessage = MutableStateFlow3;
        this.snackbarMessage = FlowKt.asStateFlow(MutableStateFlow3);
    }

    public final StateFlow<List<AuthorizedSender>> getAuthorizedSenders() {
        return this.authorizedSenders;
    }

    public final StateFlow<Boolean> isAddDialogVisible() {
        return this.isAddDialogVisible;
    }

    public final StateFlow<String> getPhoneNumber() {
        return this.phoneNumber;
    }

    public final StateFlow<String> getSnackbarMessage() {
        return this.snackbarMessage;
    }

    public final void showAddDialog() {
        this._isAddDialogVisible.setValue(true);
    }

    public final void hideAddDialog() {
        this._isAddDialogVisible.setValue(false);
        this._phoneNumber.setValue("");
    }

    public final void updatePhoneNumber(String number) {
        Intrinsics.checkNotNullParameter(number, "number");
        this._phoneNumber.setValue(number);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.AuthorizedSendersViewModel$addAuthorizedSender$1, reason: invalid class name */
    /* JADX INFO: compiled from: AuthorizedSendersViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.AuthorizedSendersViewModel$addAuthorizedSender$1", f = "AuthorizedSendersViewModel.kt", i = {0, 1, 1}, l = {LockFreeTaskQueueCore.FROZEN_SHIFT, 69}, m = "invokeSuspend", n = {"number", "number", "newSender"}, s = {"L$0", "L$0", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AuthorizedSendersViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x00a7, code lost:
        
            if (r5.this$0.authorizedSenderRepository.addAuthorizedSender(r6, r5) == r0) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            String string;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i == 1) {
                        string = (String) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    AuthorizedSendersViewModel.this._snackbarMessage.setValue("Sender added successfully");
                    AuthorizedSendersViewModel.this.hideAddDialog();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                string = StringsKt.trim((CharSequence) AuthorizedSendersViewModel.this._phoneNumber.getValue()).toString();
                if (string.length() == 0) {
                    AuthorizedSendersViewModel.this._snackbarMessage.setValue("Phone number cannot be empty");
                    return Unit.INSTANCE;
                }
                this.L$0 = string;
                this.label = 1;
                obj = AuthorizedSendersViewModel.this.authorizedSenderRepository.isSenderAuthorized(string, this);
                if (obj == coroutine_suspended) {
                }
                return coroutine_suspended;
                if (((Boolean) obj).booleanValue()) {
                    AuthorizedSendersViewModel.this._snackbarMessage.setValue("This sender is already authorized");
                    return Unit.INSTANCE;
                }
                AuthorizedSender authorizedSender = new AuthorizedSender(0L, string);
                this.L$0 = SpillingKt.nullOutSpilledVariable(string);
                this.L$1 = SpillingKt.nullOutSpilledVariable(authorizedSender);
                this.label = 2;
            } catch (Exception e) {
                AuthorizedSendersViewModel.this._snackbarMessage.setValue("Error adding sender: " + e.getMessage());
            }
        }
    }

    public final void addAuthorizedSender() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.AuthorizedSendersViewModel$deleteAuthorizedSender$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthorizedSendersViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.AuthorizedSendersViewModel$deleteAuthorizedSender$1", f = "AuthorizedSendersViewModel.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
    static final class C07531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AuthorizedSender $sender;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07531(AuthorizedSender authorizedSender, Continuation<? super C07531> continuation) {
            super(2, continuation);
            this.$sender = authorizedSender;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AuthorizedSendersViewModel.this.new C07531(this.$sender, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (AuthorizedSendersViewModel.this.authorizedSenderRepository.deleteSender(this.$sender, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                AuthorizedSendersViewModel.this._snackbarMessage.setValue("Sender removed successfully");
            } catch (Exception e) {
                AuthorizedSendersViewModel.this._snackbarMessage.setValue("Error removing sender: " + e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    public final void deleteAuthorizedSender(AuthorizedSender sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07531(sender, null), 3, null);
    }

    public final void resetSnackbarMessage() {
        this._snackbarMessage.setValue(null);
    }
}
