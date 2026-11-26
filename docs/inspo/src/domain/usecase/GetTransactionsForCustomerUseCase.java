package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetTransactionsForCustomerUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0086B¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/GetTransactionsForCustomerUseCase;", "", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;)V", "invoke", "", "Lcom/example/bingwahybrid/domain/model/Transaction;", "customer", "Lcom/example/bingwahybrid/domain/model/Customer;", "(Lcom/example/bingwahybrid/domain/model/Customer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetTransactionsForCustomerUseCase {
    public static final int $stable = 8;
    private final TransactionRepository transactionRepository;

    @Inject
    public GetTransactionsForCustomerUseCase(TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        this.transactionRepository = transactionRepository;
    }

    public final Object invoke(Customer customer, Continuation<? super List<Transaction>> continuation) {
        return this.transactionRepository.getTransactionsForCustomer(customer, continuation);
    }
}
