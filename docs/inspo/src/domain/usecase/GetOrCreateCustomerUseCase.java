package com.example.bingwahybrid.domain.usecase;

import androidx.autofill.HintConstants;
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.utils.FormatUtilsKt;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetOrCreateCustomerUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/GetOrCreateCustomerUseCase;", "", "customerRepository", "Lcom/example/bingwahybrid/domain/repository/CustomerRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/CustomerRepository;)V", "invoke", "Lcom/example/bingwahybrid/domain/model/Customer;", HintConstants.AUTOFILL_HINT_PHONE, "", "name", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetOrCreateCustomerUseCase {
    public static final int $stable = 8;
    private final CustomerRepository customerRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.GetOrCreateCustomerUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetOrCreateCustomerUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.GetOrCreateCustomerUseCase", f = "GetOrCreateCustomerUseCase.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {15, 16, 20, 26, 39}, m = "invoke", n = {HintConstants.AUTOFILL_HINT_PHONE, "name", "formattedPhone", HintConstants.AUTOFILL_HINT_PHONE, "name", "formattedPhone", HintConstants.AUTOFILL_HINT_PHONE, "name", "formattedPhone", "existingCustomer", "updatedWithStableId", HintConstants.AUTOFILL_HINT_PHONE, "name", "formattedPhone", "existingCustomer", "updatedCustomer", HintConstants.AUTOFILL_HINT_PHONE, "name", "formattedPhone", "newCustomer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetOrCreateCustomerUseCase.this.invoke(null, null, this);
        }
    }

    @Inject
    public GetOrCreateCustomerUseCase(CustomerRepository customerRepository) {
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        this.customerRepository = customerRepository;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:38:0x010b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x010c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object invoke(String str, String str2, Continuation<? super Customer> continuation) {
        AnonymousClass1 anonymousClass1;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Customer customer;
        Customer customerCopy$default;
        CustomerRepository customerRepository;
        Customer customer2;
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
        Object customerByPhone = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i == 1) {
                String str9 = (String) anonymousClass1.L$2;
                String str10 = (String) anonymousClass1.L$1;
                str5 = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure(customerByPhone);
                str3 = str9;
                str4 = str10;
            } else {
                if (i != 2) {
                    if (i == 3 || i == 4) {
                        customer2 = (Customer) anonymousClass1.L$4;
                    } else {
                        if (i != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        customer2 = (Customer) anonymousClass1.L$3;
                    }
                    ResultKt.throwOnFailure(customerByPhone);
                    return customer2;
                }
                str8 = (String) anonymousClass1.L$2;
                String str11 = (String) anonymousClass1.L$1;
                String str12 = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure(customerByPhone);
                str7 = str11;
                str6 = str12;
            }
            customer = (Customer) customerByPhone;
            if (customer.getStableId() == null) {
                customerCopy$default = Customer.copy$default(customer, 0, UUID.randomUUID(), null, null, 0, 0L, false, false, 253, null);
                customerRepository = this.customerRepository;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str6);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str8);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(customer);
                anonymousClass1.L$4 = customerCopy$default;
                anonymousClass1.label = 3;
                if (customerRepository.updateCustomerInfo(customerCopy$default, anonymousClass1) == coroutine_suspended) {
                    return customerCopy$default;
                }
            } else {
                if (Intrinsics.areEqual(customer.getName(), customer.getPhone()) || Intrinsics.areEqual(str7, str8)) {
                    return customer;
                }
                Customer customerCopy$default2 = Customer.copy$default(customer, 0, null, str7, null, 0, 0L, false, false, 251, null);
                CustomerRepository customerRepository2 = this.customerRepository;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str6);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str8);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(customer);
                anonymousClass1.L$4 = customerCopy$default2;
                anonymousClass1.label = 4;
                if (customerRepository2.updateCustomerInfo(customerCopy$default2, anonymousClass1) != coroutine_suspended) {
                    return customerCopy$default2;
                }
            }
            return coroutine_suspended;
        }
        ResultKt.throwOnFailure(customerByPhone);
        String phoneToTenDigits = FormatUtilsKt.formatPhoneToTenDigits(str);
        CustomerRepository customerRepository3 = this.customerRepository;
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
        anonymousClass1.L$1 = str2;
        anonymousClass1.L$2 = phoneToTenDigits;
        anonymousClass1.label = 1;
        Object objIsCustomerRegistered = customerRepository3.isCustomerRegistered(phoneToTenDigits, anonymousClass1);
        if (objIsCustomerRegistered != coroutine_suspended) {
            str3 = phoneToTenDigits;
            customerByPhone = objIsCustomerRegistered;
            str4 = str2;
            str5 = str;
        }
        return coroutine_suspended;
        if (((Boolean) customerByPhone).booleanValue()) {
            CustomerRepository customerRepository4 = this.customerRepository;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
            anonymousClass1.L$1 = str4;
            anonymousClass1.L$2 = str3;
            anonymousClass1.label = 2;
            customerByPhone = customerRepository4.getCustomerByPhone(str3, anonymousClass1);
            if (customerByPhone != coroutine_suspended) {
                str6 = str5;
                str7 = str4;
                str8 = str3;
                customer = (Customer) customerByPhone;
                if (customer.getStableId() == null) {
                    customerCopy$default = Customer.copy$default(customer, 0, UUID.randomUUID(), null, null, 0, 0L, false, false, 253, null);
                    customerRepository = this.customerRepository;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str6);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str8);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(customer);
                    anonymousClass1.L$4 = customerCopy$default;
                    anonymousClass1.label = 3;
                    if (customerRepository.updateCustomerInfo(customerCopy$default, anonymousClass1) == coroutine_suspended) {
                        return customerCopy$default;
                    }
                } else {
                    if (Intrinsics.areEqual(customer.getName(), customer.getPhone())) {
                    }
                    return customer;
                }
            }
        } else {
            Customer customer3 = new Customer(str3.hashCode(), UUID.randomUUID(), str4, str3, 0, 0L, false, false, 240, null);
            CustomerRepository customerRepository5 = this.customerRepository;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str5);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str4);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str3);
            anonymousClass1.L$3 = customer3;
            anonymousClass1.label = 5;
            if (customerRepository5.insertCustomer(customer3, anonymousClass1) != coroutine_suspended) {
                return customer3;
            }
        }
        return coroutine_suspended;
    }
}
