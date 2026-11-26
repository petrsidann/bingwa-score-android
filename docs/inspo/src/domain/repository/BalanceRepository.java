package com.example.bingwahybrid.domain.repository;

import com.example.bingwahybrid.domain.enums.LoadingState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: BalanceRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH¦@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u000e\u0010\u000f\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/repository/BalanceRepository;", "", "loadingState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/bingwahybrid/domain/enums/LoadingState;", "getLoadingState", "()Lkotlinx/coroutines/flow/Flow;", "getAirtimeBalance", "Lkotlinx/coroutines/flow/StateFlow;", "", "parseAndUpdateAirtimeBalance", "", "balanceText", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalTransactedToday", "refreshAirtimeBalance", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementTransactedToday", "amount", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface BalanceRepository {
    StateFlow<String> getAirtimeBalance();

    Flow<LoadingState> getLoadingState();

    StateFlow<String> getTotalTransactedToday();

    Object incrementTransactedToday(double d, Continuation<? super Unit> continuation);

    Object parseAndUpdateAirtimeBalance(String str, Continuation<? super Unit> continuation);

    Object refreshAirtimeBalance(Continuation<? super String> continuation);
}
