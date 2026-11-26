package com.example.bingwahybrid.presentation.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.usecase.GetCustomersUseCase;
import com.example.bingwahybrid.domain.usecase.ObserveTransactionsUseCase;
import com.example.bingwahybrid.domain.usecase.customer.DeleteCustomerUseCase;
import com.example.bingwahybrid.domain.usecase.customer.UpdateCustomerInfoUseCase;
import java.util.Iterator;
import java.util.List;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: CustomersViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010+\u001a\u00020,H\u0002J\u000e\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0019J\u000e\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020\u0019J\u000e\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u0019J\u0006\u00103\u001a\u00020,J\u0006\u00104\u001a\u00020,J\u0006\u00105\u001a\u00020,J\u0006\u00106\u001a\u00020,J\u0006\u00107\u001a\u00020,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0011R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0011R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\r¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0011¨\u00068"}, d2 = {"Lcom/example/bingwahybrid/presentation/viewmodel/CustomersViewModel;", "Landroidx/lifecycle/ViewModel;", "getCustomersUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetCustomersUseCase;", "updateCustomerInfoUseCase", "Lcom/example/bingwahybrid/domain/usecase/customer/UpdateCustomerInfoUseCase;", "deleteCustomerUseCase", "Lcom/example/bingwahybrid/domain/usecase/customer/DeleteCustomerUseCase;", "observeTransactionsUseCase", "Lcom/example/bingwahybrid/domain/usecase/ObserveTransactionsUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/usecase/GetCustomersUseCase;Lcom/example/bingwahybrid/domain/usecase/customer/UpdateCustomerInfoUseCase;Lcom/example/bingwahybrid/domain/usecase/customer/DeleteCustomerUseCase;Lcom/example/bingwahybrid/domain/usecase/ObserveTransactionsUseCase;)V", "customers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/bingwahybrid/domain/model/Customer;", "getCustomers", "()Lkotlinx/coroutines/flow/StateFlow;", "_selectedCustomer", "Lkotlinx/coroutines/flow/MutableStateFlow;", "selectedCustomer", "_isLoading", "", "isLoading", "_errorMessage", "", "errorMessage", "getErrorMessage", "_successMessage", "successMessage", "getSuccessMessage", "_customerName", "customerName", "getCustomerName", "_accountBalance", "accountBalance", "getAccountBalance", "_editSuccess", "editSuccess", "getEditSuccess", "_deleteSuccess", "deleteSuccess", "getDeleteSuccess", "fetchCustomers", "", "getCustomerByPhone", "customerPhone", "onCustomerNameChanged", "newName", "onAccountBalanceChanged", "newBalance", "updateCustomer", "deleteCustomer", "resetSnackbarMessage", "resetEditSuccess", "resetDeleteSuccess", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomersViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _accountBalance;
    private final MutableStateFlow<String> _customerName;
    private final MutableStateFlow<Boolean> _deleteSuccess;
    private final MutableStateFlow<Boolean> _editSuccess;
    private final MutableStateFlow<String> _errorMessage;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<Customer> _selectedCustomer;
    private final MutableStateFlow<String> _successMessage;
    private final StateFlow<String> accountBalance;
    private final StateFlow<String> customerName;
    private final StateFlow<List<Customer>> customers;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final StateFlow<Boolean> deleteSuccess;
    private final StateFlow<Boolean> editSuccess;
    private final StateFlow<String> errorMessage;
    private final GetCustomersUseCase getCustomersUseCase;
    private final StateFlow<Boolean> isLoading;
    private final ObserveTransactionsUseCase observeTransactionsUseCase;
    private final StateFlow<Customer> selectedCustomer;
    private final StateFlow<String> successMessage;
    private final UpdateCustomerInfoUseCase updateCustomerInfoUseCase;

    @Inject
    public CustomersViewModel(GetCustomersUseCase getCustomersUseCase, UpdateCustomerInfoUseCase updateCustomerInfoUseCase, DeleteCustomerUseCase deleteCustomerUseCase, ObserveTransactionsUseCase observeTransactionsUseCase) {
        Intrinsics.checkNotNullParameter(getCustomersUseCase, "getCustomersUseCase");
        Intrinsics.checkNotNullParameter(updateCustomerInfoUseCase, "updateCustomerInfoUseCase");
        Intrinsics.checkNotNullParameter(deleteCustomerUseCase, "deleteCustomerUseCase");
        Intrinsics.checkNotNullParameter(observeTransactionsUseCase, "observeTransactionsUseCase");
        this.getCustomersUseCase = getCustomersUseCase;
        this.updateCustomerInfoUseCase = updateCustomerInfoUseCase;
        this.deleteCustomerUseCase = deleteCustomerUseCase;
        this.observeTransactionsUseCase = observeTransactionsUseCase;
        this.customers = getCustomersUseCase.getCustomer();
        MutableStateFlow<Customer> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._selectedCustomer = MutableStateFlow;
        this.selectedCustomer = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow2;
        this.isLoading = MutableStateFlow2;
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._errorMessage = MutableStateFlow3;
        this.errorMessage = MutableStateFlow3;
        MutableStateFlow<String> MutableStateFlow4 = StateFlowKt.MutableStateFlow(null);
        this._successMessage = MutableStateFlow4;
        this.successMessage = MutableStateFlow4;
        MutableStateFlow<String> MutableStateFlow5 = StateFlowKt.MutableStateFlow("");
        this._customerName = MutableStateFlow5;
        this.customerName = MutableStateFlow5;
        MutableStateFlow<String> MutableStateFlow6 = StateFlowKt.MutableStateFlow("");
        this._accountBalance = MutableStateFlow6;
        this.accountBalance = MutableStateFlow6;
        MutableStateFlow<Boolean> MutableStateFlow7 = StateFlowKt.MutableStateFlow(false);
        this._editSuccess = MutableStateFlow7;
        this.editSuccess = MutableStateFlow7;
        MutableStateFlow<Boolean> MutableStateFlow8 = StateFlowKt.MutableStateFlow(false);
        this._deleteSuccess = MutableStateFlow8;
        this.deleteSuccess = MutableStateFlow8;
        fetchCustomers();
    }

    public final StateFlow<List<Customer>> getCustomers() {
        return this.customers;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final StateFlow<String> getErrorMessage() {
        return this.errorMessage;
    }

    public final StateFlow<String> getSuccessMessage() {
        return this.successMessage;
    }

    public final StateFlow<String> getCustomerName() {
        return this.customerName;
    }

    public final StateFlow<String> getAccountBalance() {
        return this.accountBalance;
    }

    public final StateFlow<Boolean> getEditSuccess() {
        return this.editSuccess;
    }

    public final StateFlow<Boolean> getDeleteSuccess() {
        return this.deleteSuccess;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.CustomersViewModel$fetchCustomers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomersViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.CustomersViewModel$fetchCustomers$1", f = "CustomersViewModel.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    static final class C07571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07571(Continuation<? super C07571> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CustomersViewModel.this.new C07571(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CustomersViewModel.this.getCustomersUseCase.invoke(this) == coroutine_suspended) {
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
    public final void fetchCustomers() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07571(null), 2, null);
    }

    public final void getCustomerByPhone(String customerPhone) {
        Object next;
        String name;
        String string;
        Intrinsics.checkNotNullParameter(customerPhone, "customerPhone");
        MutableStateFlow<Customer> mutableStateFlow = this._selectedCustomer;
        Iterator<T> it = this.customers.getValue().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((Customer) next).getPhone(), customerPhone));
        mutableStateFlow.setValue((Customer) next);
        MutableStateFlow<String> mutableStateFlow2 = this._customerName;
        Customer value = this.selectedCustomer.getValue();
        String str = "";
        if (value == null || (name = value.getName()) == null) {
            name = "";
        }
        mutableStateFlow2.setValue(name);
        MutableStateFlow<String> mutableStateFlow3 = this._accountBalance;
        Customer value2 = this.selectedCustomer.getValue();
        if (value2 != null && (string = Integer.valueOf(value2.getAccountBalance()).toString()) != null) {
            str = string;
        }
        mutableStateFlow3.setValue(str);
    }

    public final void onCustomerNameChanged(String newName) {
        Intrinsics.checkNotNullParameter(newName, "newName");
        this._customerName.setValue(newName);
    }

    public final void onAccountBalanceChanged(String newBalance) {
        Intrinsics.checkNotNullParameter(newBalance, "newBalance");
        this._accountBalance.setValue(newBalance);
    }

    public final void updateCustomer() {
        Customer value = this._selectedCustomer.getValue();
        if (value == null) {
            this._errorMessage.setValue("You have not selected any customer");
        } else if (this._customerName.getValue().length() >= 3) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07581(value, this, null), 2, null);
        } else {
            this._errorMessage.setValue("Customer name should be at least 3 characters");
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.CustomersViewModel$updateCustomer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomersViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.CustomersViewModel$updateCustomer$1", f = "CustomersViewModel.kt", i = {0}, l = {96}, m = "invokeSuspend", n = {"updatedCustomer"}, s = {"L$0"})
    static final class C07581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Customer $customer;
        Object L$0;
        int label;
        final /* synthetic */ CustomersViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07581(Customer customer, CustomersViewModel customersViewModel, Continuation<? super C07581> continuation) {
            super(2, continuation);
            this.$customer = customer;
            this.this$0 = customersViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07581(this.$customer, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Customer customer = this.$customer;
                    String str = (String) this.this$0._customerName.getValue();
                    Integer intOrNull = StringsKt.toIntOrNull((String) this.this$0._accountBalance.getValue());
                    Customer customerCopy$default = Customer.copy$default(customer, 0, null, str, null, intOrNull != null ? intOrNull.intValue() : 0, 0L, false, false, 235, null);
                    this.this$0._isLoading.setValue(Boxing.boxBoolean(true));
                    this.L$0 = SpillingKt.nullOutSpilledVariable(customerCopy$default);
                    this.label = 1;
                    if (this.this$0.updateCustomerInfoUseCase.invoke(customerCopy$default, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.fetchCustomers();
                this.this$0._selectedCustomer.setValue(null);
                this.this$0._editSuccess.setValue(Boxing.boxBoolean(true));
                this.this$0._successMessage.setValue("Customer updated successfully");
            } catch (Exception e) {
                this.this$0._errorMessage.setValue(e.getMessage());
            } finally {
                this.this$0._isLoading.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
    }

    public final void deleteCustomer() {
        Customer value = this._selectedCustomer.getValue();
        if (value != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(value, null), 2, null);
        } else {
            this._errorMessage.setValue("You need to select a customer first");
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.CustomersViewModel$deleteCustomer$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomersViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.CustomersViewModel$deleteCustomer$1", f = "CustomersViewModel.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Customer $customer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Customer customer, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$customer = customer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CustomersViewModel.this.new AnonymousClass1(this.$customer, continuation);
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
                    CustomersViewModel.this._isLoading.setValue(Boxing.boxBoolean(true));
                    this.label = 1;
                    if (CustomersViewModel.this.deleteCustomerUseCase.invoke(this.$customer, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                CustomersViewModel.this.fetchCustomers();
                CustomersViewModel.this.observeTransactionsUseCase.invoke();
                CustomersViewModel.this._selectedCustomer.setValue(null);
                CustomersViewModel.this._deleteSuccess.setValue(Boxing.boxBoolean(true));
                CustomersViewModel.this._successMessage.setValue("Customer deleted successfully");
            } catch (Exception e) {
                CustomersViewModel.this._errorMessage.setValue(e.getMessage());
            } finally {
                CustomersViewModel.this._isLoading.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
    }

    public final void resetSnackbarMessage() {
        this._successMessage.setValue(null);
    }

    public final void resetEditSuccess() {
        this._editSuccess.setValue(false);
    }

    public final void resetDeleteSuccess() {
        this._deleteSuccess.setValue(false);
    }
}
