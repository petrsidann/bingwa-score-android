package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetCustomerBalanceUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/GetCustomerBalanceUseCase;", "", "customerRepository", "Lcom/example/bingwahybrid/domain/repository/CustomerRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/CustomerRepository;)V", "invoke", "", "customer", "Lcom/example/bingwahybrid/domain/model/Customer;", "(Lcom/example/bingwahybrid/domain/model/Customer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetCustomerBalanceUseCase {
    public static final int $stable = 8;
    private final CustomerRepository customerRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.GetCustomerBalanceUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetCustomerBalanceUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.GetCustomerBalanceUseCase", f = "GetCustomerBalanceUseCase.kt", i = {0}, l = {11}, m = "invoke", n = {"customer"}, s = {"L$0"})
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
            return GetCustomerBalanceUseCase.this.invoke(null, this);
        }
    }

    @Inject
    public GetCustomerBalanceUseCase(CustomerRepository customerRepository) {
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        this.customerRepository = customerRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(Customer customer, Continuation<? super Integer> continuation) {
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
        Object customerById = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(customerById);
            CustomerRepository customerRepository = this.customerRepository;
            int id = customer.getId();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(customer);
            anonymousClass1.label = 1;
            customerById = customerRepository.getCustomerById(id, anonymousClass1);
            if (customerById == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(customerById);
        }
        return Boxing.boxInt(((Customer) customerById).getAccountBalance());
    }
}
