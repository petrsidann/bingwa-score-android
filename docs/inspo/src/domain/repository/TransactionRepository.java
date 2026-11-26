package com.example.bingwahybrid.domain.repository;

import androidx.core.app.NotificationCompat;
import androidx.paging.PagingData;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.model.Transaction;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.UUID;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: TransactionRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0015\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0016H&JM\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001c0\u001b2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H&J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\u0006\u0010'\u001a\u00020\u001fH¦@¢\u0006\u0002\u0010(J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\u0006\u0010*\u001a\u00020+H¦@¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+H¦@¢\u0006\u0002\u0010,J$\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H¦@¢\u0006\u0002\u00101J\"\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001e0\u001b2\u0006\u00103\u001a\u00020\u0012H¦@¢\u0006\u0002\u00104J\u0018\u00105\u001a\u0004\u0018\u00010\u00062\u0006\u00103\u001a\u00020\u0012H¦@¢\u0006\u0002\u00104J\u001e\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001b2\u0006\u00103\u001a\u00020\u0012H¦@¢\u0006\u0002\u00104J\u0018\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u00108\u001a\u000209H¦@¢\u0006\u0002\u0010:JF\u0010;\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00122\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010=\u001a\u0004\u0018\u0001092\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?H¦@¢\u0006\u0002\u0010AJ\u001e\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020+H¦@¢\u0006\u0002\u0010EJ \u0010F\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u00122\b\b\u0002\u0010H\u001a\u00020IH¦@¢\u0006\u0002\u0010JJ\u0018\u0010K\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020+H¦@¢\u0006\u0002\u0010,J \u0010L\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00122\b\b\u0002\u0010M\u001a\u00020IH¦@¢\u0006\u0002\u0010JJ\u0016\u0010N\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u0012H¦@¢\u0006\u0002\u00104J\u0016\u0010O\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u0012H¦@¢\u0006\u0002\u00104J\u001c\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001e0\u001b2\u0006\u0010Q\u001a\u000209H&J\u0014\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001e0\u001bH&J&\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\u0006\u0010<\u001a\u00020\u001f2\b\b\u0002\u0010T\u001a\u00020?H¦@¢\u0006\u0002\u0010UJ\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020?0\u001bH&J\u000e\u0010W\u001a\b\u0012\u0004\u0012\u00020?0\u001bH&J\b\u0010X\u001a\u00020\u0016H&J$\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\u0006\u0010Z\u001a\u00020?2\u0006\u0010[\u001a\u00020?H¦@¢\u0006\u0002\u0010\\J\u0018\u0010]\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020+H¦@¢\u0006\u0002\u0010,R$\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u000e0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006^À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "", "transactions", "Lkotlinx/coroutines/flow/StateFlow;", "Ljava/util/SortedMap;", "", "Lcom/example/bingwahybrid/domain/model/Transaction;", "getTransactions", "()Lkotlinx/coroutines/flow/StateFlow;", "transactionQueue", "Ljava/util/concurrent/PriorityBlockingQueue;", "getTransactionQueue", "()Ljava/util/concurrent/PriorityBlockingQueue;", "liveTransactions", "", "getLiveTransactions", "ongoingTransactions", "", "Ljava/util/UUID;", "getOngoingTransactions", "()Ljava/util/Set;", "createTransaction", "", "transaction", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshTransactions", "getPagedTransactions", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "statuses", "", "Lcom/example/bingwahybrid/domain/enums/TransactionStatus;", "type", "Lcom/example/bingwahybrid/domain/enums/TransactionType;", "startDate", "endDate", "(Ljava/util/List;Lcom/example/bingwahybrid/domain/enums/TransactionType;Ljava/lang/Long;Ljava/lang/Long;)Lkotlinx/coroutines/flow/Flow;", "addLiveTransaction", "getTransactionsByStatus", "transactionStatus", "(Lcom/example/bingwahybrid/domain/enums/TransactionStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransactionsForCustomer", "customer", "Lcom/example/bingwahybrid/domain/model/Customer;", "(Lcom/example/bingwahybrid/domain/model/Customer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTransactionsForCustomer", "getTransactionsBetween", "startTime", "endTime", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScheduledTransactionsForTransactionId", "transactionId", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransactionById", "getTransactionByIdFlow", "getTransactionByMpesaCode", "mpesaCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTransactionFields", NotificationCompat.CATEGORY_STATUS, "responseMessage", "internalRetries", "", "externalRetries", "(Ljava/util/UUID;Lcom/example/bingwahybrid/domain/enums/TransactionStatus;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "swapCustomer", "originalTransaction", "newCustomer", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lcom/example/bingwahybrid/domain/model/Customer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTransaction", "id", "softDelete", "", "(Ljava/util/UUID;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastTransactionForCustomer", "incrementRetriesForTransaction", "external", "resetInternalRetriesForTransactionId", "resetExternalRetriesForTransactionId", "searchTransaction", "searchQuery", "getAutoRenewalParentTransactions", "getTransactionsByStatusWithinDays", "days", "(Lcom/example/bingwahybrid/domain/enums/TransactionStatus;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSuccessCount", "getFailedCount", "cleanupTransactions", "getTransactionsPaged", "offset", "limit", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastBingwaTransactionForCustomer", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface TransactionRepository {
    void addLiveTransaction(Transaction transaction);

    void cleanupTransactions();

    Object createTransaction(Transaction transaction, Continuation<? super Unit> continuation);

    Object deleteTransaction(UUID uuid, boolean z, Continuation<? super Unit> continuation);

    Object deleteTransactionsForCustomer(Customer customer, Continuation<? super Unit> continuation);

    Flow<List<Transaction>> getAutoRenewalParentTransactions();

    Flow<Integer> getFailedCount();

    Object getLastBingwaTransactionForCustomer(Customer customer, Continuation<? super Transaction> continuation);

    Object getLastTransactionForCustomer(Customer customer, Continuation<? super Transaction> continuation);

    StateFlow<Map<Long, Transaction>> getLiveTransactions();

    Set<UUID> getOngoingTransactions();

    Flow<PagingData<Transaction>> getPagedTransactions(List<? extends TransactionStatus> statuses, TransactionType type, Long startDate, Long endDate);

    Object getScheduledTransactionsForTransactionId(UUID uuid, Continuation<? super Flow<? extends List<Transaction>>> continuation);

    Flow<Integer> getSuccessCount();

    Object getTransactionById(UUID uuid, Continuation<? super Transaction> continuation);

    Object getTransactionByIdFlow(UUID uuid, Continuation<? super Flow<Transaction>> continuation);

    Object getTransactionByMpesaCode(String str, Continuation<? super Transaction> continuation);

    PriorityBlockingQueue<Transaction> getTransactionQueue();

    StateFlow<SortedMap<Long, Transaction>> getTransactions();

    Object getTransactionsBetween(long j, long j2, Continuation<? super List<Transaction>> continuation);

    Object getTransactionsByStatus(TransactionStatus transactionStatus, Continuation<? super List<Transaction>> continuation);

    Object getTransactionsByStatusWithinDays(TransactionStatus transactionStatus, int i, Continuation<? super List<Transaction>> continuation);

    Object getTransactionsForCustomer(Customer customer, Continuation<? super List<Transaction>> continuation);

    Object getTransactionsPaged(int i, int i2, Continuation<? super List<Transaction>> continuation);

    Object incrementRetriesForTransaction(UUID uuid, boolean z, Continuation<? super Unit> continuation);

    void refreshTransactions();

    Object resetExternalRetriesForTransactionId(UUID uuid, Continuation<? super Unit> continuation);

    Object resetInternalRetriesForTransactionId(UUID uuid, Continuation<? super Unit> continuation);

    Flow<List<Transaction>> searchTransaction(String searchQuery);

    Object swapCustomer(Transaction transaction, Customer customer, Continuation<? super Transaction> continuation);

    Object updateTransactionFields(UUID uuid, TransactionStatus transactionStatus, String str, Integer num, Integer num2, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: TransactionRepository.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Flow getPagedTransactions$default(TransactionRepository transactionRepository, List list, TransactionType transactionType, Long l, Long l2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPagedTransactions");
        }
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 2) != 0) {
            transactionType = null;
        }
        if ((i & 4) != 0) {
            l = null;
        }
        if ((i & 8) != 0) {
            l2 = null;
        }
        return transactionRepository.getPagedTransactions(list, transactionType, l, l2);
    }

    static /* synthetic */ Object updateTransactionFields$default(TransactionRepository transactionRepository, UUID uuid, TransactionStatus transactionStatus, String str, Integer num, Integer num2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTransactionFields");
        }
        if ((i & 2) != 0) {
            transactionStatus = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            num2 = null;
        }
        return transactionRepository.updateTransactionFields(uuid, transactionStatus, str, num, num2, continuation);
    }

    static /* synthetic */ Object deleteTransaction$default(TransactionRepository transactionRepository, UUID uuid, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteTransaction");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return transactionRepository.deleteTransaction(uuid, z, continuation);
    }

    static /* synthetic */ Object incrementRetriesForTransaction$default(TransactionRepository transactionRepository, UUID uuid, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementRetriesForTransaction");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return transactionRepository.incrementRetriesForTransaction(uuid, z, continuation);
    }

    static /* synthetic */ Object getTransactionsByStatusWithinDays$default(TransactionRepository transactionRepository, TransactionStatus transactionStatus, int i, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTransactionsByStatusWithinDays");
        }
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return transactionRepository.getTransactionsByStatusWithinDays(transactionStatus, i, continuation);
    }
}
