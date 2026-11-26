package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import java.util.SortedMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: ObserveTransactionsUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/ObserveTransactionsUseCase;", "", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;)V", "invoke", "Lkotlinx/coroutines/flow/StateFlow;", "Ljava/util/SortedMap;", "", "Lcom/example/bingwahybrid/domain/model/Transaction;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ObserveTransactionsUseCase {
    public static final int $stable = 8;
    private final TransactionRepository transactionRepository;

    @Inject
    public ObserveTransactionsUseCase(TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        this.transactionRepository = transactionRepository;
    }

    public final StateFlow<SortedMap<Long, Transaction>> invoke() {
        this.transactionRepository.refreshTransactions();
        return this.transactionRepository.getTransactions();
    }
}
