package com.example.bingwahybrid.presentation.transactions.viewmodel;

import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.presentation.offers.dto.FilterChipState;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: TransactionsViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lcom/example/bingwahybrid/domain/model/Transaction;", "liveTransactionList", "selectedChip", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$liveTransactions$1", f = "TransactionsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TransactionsViewModel$liveTransactions$1 extends SuspendLambda implements Function3<List<? extends Transaction>, FilterChipState, Continuation<? super List<? extends Transaction>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    TransactionsViewModel$liveTransactions$1(Continuation<? super TransactionsViewModel$liveTransactions$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends Transaction> list, FilterChipState filterChipState, Continuation<? super List<? extends Transaction>> continuation) {
        return invoke2((List<Transaction>) list, filterChipState, (Continuation<? super List<Transaction>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<Transaction> list, FilterChipState filterChipState, Continuation<? super List<Transaction>> continuation) {
        TransactionsViewModel$liveTransactions$1 transactionsViewModel$liveTransactions$1 = new TransactionsViewModel$liveTransactions$1(continuation);
        transactionsViewModel$liveTransactions$1.L$0 = list;
        transactionsViewModel$liveTransactions$1.L$1 = filterChipState;
        return transactionsViewModel$liveTransactions$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List listEmptyList = (List) this.L$0;
        FilterChipState filterChipState = (FilterChipState) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (!(filterChipState instanceof FilterChipState.Live)) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return SequencesKt.toList(SequencesKt.sortedWith(SequencesKt.filterNot(SequencesKt.filterNot(SequencesKt.filterNot(SequencesKt.filterNot(CollectionsKt.asSequence(listEmptyList), new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$liveTransactions$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(TransactionsViewModel$liveTransactions$1.invokeSuspend$lambda$0((Transaction) obj2));
            }
        }), new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$liveTransactions$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(TransactionsViewModel$liveTransactions$1.invokeSuspend$lambda$1((Transaction) obj2));
            }
        }), new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$liveTransactions$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(TransactionsViewModel$liveTransactions$1.invokeSuspend$lambda$2((Transaction) obj2));
            }
        }), new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$liveTransactions$1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(TransactionsViewModel$liveTransactions$1.invokeSuspend$lambda$3((Transaction) obj2));
            }
        }), new Comparator() { // from class: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$liveTransactions$1$invokeSuspend$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((Transaction) t2).getCreatedAt()), Long.valueOf(((Transaction) t).getCreatedAt()));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(Transaction transaction) {
        return Transaction.INSTANCE.isAutoRenewalParentTransaction(transaction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$1(Transaction transaction) {
        return Transaction.INSTANCE.isAutoRenewalTransaction(transaction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$2(Transaction transaction) {
        return Transaction.INSTANCE.isSubscriptionRenewal(transaction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$3(Transaction transaction) {
        return Transaction.INSTANCE.isBalanceCheck(transaction);
    }
}
