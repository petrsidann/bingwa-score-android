package com.example.bingwahybrid.domain.statistics.usecase;

import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IncrementCustomerBalanceUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086B¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/statistics/usecase/IncrementCustomerBalanceUseCase;", "", "customerRepository", "Lcom/example/bingwahybrid/domain/repository/CustomerRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/CustomerRepository;)V", "invoke", "", "customer", "Lcom/example/bingwahybrid/domain/model/Customer;", "amount", "", "(Lcom/example/bingwahybrid/domain/model/Customer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IncrementCustomerBalanceUseCase {
    public static final int $stable = 8;
    private final CustomerRepository customerRepository;

    @Inject
    public IncrementCustomerBalanceUseCase(CustomerRepository customerRepository) {
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        this.customerRepository = customerRepository;
    }

    public final Object invoke(Customer customer, int i, Continuation<? super Unit> continuation) {
        Object objIncrementAccountBalance = this.customerRepository.incrementAccountBalance(customer, i, continuation);
        return objIncrementAccountBalance == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objIncrementAccountBalance : Unit.INSTANCE;
    }
}
