package com.example.bingwahybrid.domain.usecase;

import android.util.Log;
import androidx.core.view.MotionEventCompat;
import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialSkippedTransactionsUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/DialSkippedTransactionsUseCase;", "", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "dialUssdUseCase", "Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DialSkippedTransactionsUseCase {
    public static final int $stable = 8;
    private final DialUssdUseCase dialUssdUseCase;
    private final TransactionRepository transactionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.DialSkippedTransactionsUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: DialSkippedTransactionsUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.DialSkippedTransactionsUseCase", f = "DialSkippedTransactionsUseCase.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {20, 26, 37, MotionEventCompat.AXIS_GENERIC_11}, m = "invoke", n = {"ongoingTransactions", "ongoingTransactions", "pendingTransactions", "ongoingTransactions", "pendingTransactions", "pendingProcessedTransactions", "transactionsToDial", "transaction", "ongoingTransactions", "pendingTransactions", "pendingProcessedTransactions", "transactionsToDial", "transaction"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$5", "L$0", "L$1", "L$2", "L$3", "L$5"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DialSkippedTransactionsUseCase.this.invoke(this);
        }
    }

    @Inject
    public DialSkippedTransactionsUseCase(TransactionRepository transactionRepository, DialUssdUseCase dialUssdUseCase) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(dialUssdUseCase, "dialUssdUseCase");
        this.transactionRepository = transactionRepository;
        this.dialUssdUseCase = dialUssdUseCase;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00d3 A[Catch: Exception -> 0x01aa, TryCatch #0 {Exception -> 0x01aa, blocks: (B:15:0x004b, B:55:0x0167, B:57:0x016d, B:59:0x017e, B:20:0x0071, B:49:0x0129, B:51:0x012f, B:54:0x015e, B:23:0x0080, B:36:0x00bd, B:37:0x00cd, B:39:0x00d3, B:41:0x00e4, B:42:0x00e8, B:43:0x00f7, B:45:0x00fd, B:47:0x010a, B:48:0x010e, B:26:0x0088, B:33:0x00a8, B:29:0x0090), top: B:66:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00fd A[Catch: Exception -> 0x01aa, TryCatch #0 {Exception -> 0x01aa, blocks: (B:15:0x004b, B:55:0x0167, B:57:0x016d, B:59:0x017e, B:20:0x0071, B:49:0x0129, B:51:0x012f, B:54:0x015e, B:23:0x0080, B:36:0x00bd, B:37:0x00cd, B:39:0x00d3, B:41:0x00e4, B:42:0x00e8, B:43:0x00f7, B:45:0x00fd, B:47:0x010a, B:48:0x010e, B:26:0x0088, B:33:0x00a8, B:29:0x0090), top: B:66:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x012f A[Catch: Exception -> 0x01aa, TryCatch #0 {Exception -> 0x01aa, blocks: (B:15:0x004b, B:55:0x0167, B:57:0x016d, B:59:0x017e, B:20:0x0071, B:49:0x0129, B:51:0x012f, B:54:0x015e, B:23:0x0080, B:36:0x00bd, B:37:0x00cd, B:39:0x00d3, B:41:0x00e4, B:42:0x00e8, B:43:0x00f7, B:45:0x00fd, B:47:0x010a, B:48:0x010e, B:26:0x0088, B:33:0x00a8, B:29:0x0090), top: B:66:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x016d A[Catch: Exception -> 0x01aa, TryCatch #0 {Exception -> 0x01aa, blocks: (B:15:0x004b, B:55:0x0167, B:57:0x016d, B:59:0x017e, B:20:0x0071, B:49:0x0129, B:51:0x012f, B:54:0x015e, B:23:0x0080, B:36:0x00bd, B:37:0x00cd, B:39:0x00d3, B:41:0x00e4, B:42:0x00e8, B:43:0x00f7, B:45:0x00fd, B:47:0x010a, B:48:0x010e, B:26:0x0088, B:33:0x00a8, B:29:0x0090), top: B:66:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x017e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0167 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0167 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x015d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:? A[LOOP:1: B:49:0x0129->B:78:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x010a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x00f7 A[SYNTHETIC] */
    public final Object invoke(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Set<UUID> set;
        List list;
        ArrayList arrayList;
        ArrayList arrayList2;
        List list2;
        Set<UUID> set2;
        List list3;
        List list4;
        Iterator it;
        Iterator it2;
        List list5;
        List list6;
        List list7;
        Set<UUID> set3;
        Transaction transaction;
        DialUssdUseCase dialUssdUseCase;
        Transaction transaction2;
        DialUssdUseCase dialUssdUseCase2;
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
        Object transactionsByStatusWithinDays = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(transactionsByStatusWithinDays);
                Set<UUID> ongoingTransactions = this.transactionRepository.getOngoingTransactions();
                TransactionRepository transactionRepository = this.transactionRepository;
                TransactionStatus transactionStatus = TransactionStatus.SCHEDULED;
                anonymousClass1.L$0 = ongoingTransactions;
                anonymousClass1.label = 1;
                Object transactionsByStatusWithinDays2 = transactionRepository.getTransactionsByStatusWithinDays(transactionStatus, 2, anonymousClass1);
                if (transactionsByStatusWithinDays2 != coroutine_suspended) {
                    set = ongoingTransactions;
                    transactionsByStatusWithinDays = transactionsByStatusWithinDays2;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                Set<UUID> set4 = (Set) anonymousClass1.L$0;
                ResultKt.throwOnFailure(transactionsByStatusWithinDays);
                set = set4;
            } else if (i == 2) {
                list = (List) anonymousClass1.L$1;
                set = (Set) anonymousClass1.L$0;
                ResultKt.throwOnFailure(transactionsByStatusWithinDays);
                List list8 = (List) transactionsByStatusWithinDays;
                arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!set.contains(((Transaction) obj).getId())) {
                        arrayList.add(obj);
                    }
                }
                arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if (((Transaction) obj2).getRescheduleInfo() == null) {
                        arrayList2.add(obj2);
                    }
                }
                List listSortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.example.bingwahybrid.domain.usecase.DialSkippedTransactionsUseCase$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((Transaction) t).getTime()), Long.valueOf(((Transaction) t2).getTime()));
                    }
                });
                Iterator it3 = listSortedWith.iterator();
                list2 = list8;
                set2 = set;
                list3 = listSortedWith;
                list4 = list;
                it = it3;
                while (it.hasNext()) {
                    transaction = (Transaction) it.next();
                    dialUssdUseCase = this.dialUssdUseCase;
                    anonymousClass1.L$0 = set2;
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(list4);
                    anonymousClass1.L$2 = list2;
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                    anonymousClass1.L$4 = it;
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(transaction);
                    anonymousClass1.label = 3;
                    if (DialUssdUseCase.invoke$default(dialUssdUseCase, transaction, 0L, anonymousClass1, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                it2 = list2.iterator();
                list5 = list3;
                list6 = list2;
                list7 = list4;
                set3 = set2;
            } else if (i == 3) {
                it = (Iterator) anonymousClass1.L$4;
                list3 = (List) anonymousClass1.L$3;
                list2 = (List) anonymousClass1.L$2;
                list4 = (List) anonymousClass1.L$1;
                Set<UUID> set5 = (Set) anonymousClass1.L$0;
                ResultKt.throwOnFailure(transactionsByStatusWithinDays);
                set2 = set5;
                while (it.hasNext()) {
                    transaction = (Transaction) it.next();
                    dialUssdUseCase = this.dialUssdUseCase;
                    anonymousClass1.L$0 = set2;
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(list4);
                    anonymousClass1.L$2 = list2;
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                    anonymousClass1.L$4 = it;
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(transaction);
                    anonymousClass1.label = 3;
                    if (DialUssdUseCase.invoke$default(dialUssdUseCase, transaction, 0L, anonymousClass1, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                it2 = list2.iterator();
                list5 = list3;
                list6 = list2;
                list7 = list4;
                set3 = set2;
            } else {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it2 = (Iterator) anonymousClass1.L$4;
                list5 = (List) anonymousClass1.L$3;
                list6 = (List) anonymousClass1.L$2;
                list7 = (List) anonymousClass1.L$1;
                set3 = (Set) anonymousClass1.L$0;
                ResultKt.throwOnFailure(transactionsByStatusWithinDays);
                anonymousClass1 = anonymousClass1;
            }
            while (it2.hasNext()) {
                transaction2 = (Transaction) it2.next();
                if (!set3.contains(transaction2.getId())) {
                    dialUssdUseCase2 = this.dialUssdUseCase;
                    anonymousClass1.L$0 = set3;
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(list7);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                    anonymousClass1.L$4 = it2;
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(transaction2);
                    anonymousClass1.label = 4;
                    if (DialUssdUseCase.invoke$default(dialUssdUseCase2, transaction2, 0L, anonymousClass1, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
            list = (List) transactionsByStatusWithinDays;
            TransactionRepository transactionRepository2 = this.transactionRepository;
            TransactionStatus transactionStatus2 = TransactionStatus.PROCESSING;
            anonymousClass1.L$0 = set;
            anonymousClass1.L$1 = list;
            anonymousClass1.label = 2;
            transactionsByStatusWithinDays = transactionRepository2.getTransactionsByStatusWithinDays(transactionStatus2, 2, anonymousClass1);
            if (transactionsByStatusWithinDays != coroutine_suspended) {
                List list9 = (List) transactionsByStatusWithinDays;
                arrayList = new ArrayList();
                while (r8.hasNext()) {
                    if (!set.contains(((Transaction) obj).getId())) {
                        arrayList.add(obj);
                    }
                }
                arrayList2 = new ArrayList();
                while (r9.hasNext()) {
                    if (((Transaction) obj2).getRescheduleInfo() == null) {
                        arrayList2.add(obj2);
                    }
                }
                List listSortedWith2 = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.example.bingwahybrid.domain.usecase.DialSkippedTransactionsUseCase$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((Transaction) t).getTime()), Long.valueOf(((Transaction) t2).getTime()));
                    }
                });
                Iterator it4 = listSortedWith2.iterator();
                list2 = list9;
                set2 = set;
                list3 = listSortedWith2;
                list4 = list;
                it = it4;
                while (it.hasNext()) {
                    transaction = (Transaction) it.next();
                    dialUssdUseCase = this.dialUssdUseCase;
                    anonymousClass1.L$0 = set2;
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(list4);
                    anonymousClass1.L$2 = list2;
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                    anonymousClass1.L$4 = it;
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(transaction);
                    anonymousClass1.label = 3;
                    if (DialUssdUseCase.invoke$default(dialUssdUseCase, transaction, 0L, anonymousClass1, 2, null) == coroutine_suspended) {
                    }
                }
                it2 = list2.iterator();
                list5 = list3;
                list6 = list2;
                list7 = list4;
                set3 = set2;
                while (it2.hasNext()) {
                    transaction2 = (Transaction) it2.next();
                    if (!set3.contains(transaction2.getId())) {
                        dialUssdUseCase2 = this.dialUssdUseCase;
                        anonymousClass1.L$0 = set3;
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(list7);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                        anonymousClass1.L$4 = it2;
                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(transaction2);
                        anonymousClass1.label = 4;
                        if (DialUssdUseCase.invoke$default(dialUssdUseCase2, transaction2, 0L, anonymousClass1, 2, null) == coroutine_suspended) {
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Exception e) {
            Log.e("DialSkippedTransactionsUseCase", "DialSkippedTransactionsUseCase", e);
        }
    }
}
