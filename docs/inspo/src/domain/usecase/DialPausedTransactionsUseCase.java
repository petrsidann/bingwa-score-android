package com.example.bingwahybrid.domain.usecase;

import android.util.Log;
import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialPausedTransactionsUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/DialPausedTransactionsUseCase;", "", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "dialUssdUseCase", "Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DialPausedTransactionsUseCase {
    public static final int $stable = 8;
    private final DialUssdUseCase dialUssdUseCase;
    private final TransactionRepository transactionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.DialPausedTransactionsUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: DialPausedTransactionsUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.DialPausedTransactionsUseCase", f = "DialPausedTransactionsUseCase.kt", i = {1, 1, 1, 1, 1}, l = {17, 18}, m = "invoke", n = {"$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-DialPausedTransactionsUseCase$invoke$2"}, s = {"L$0", "L$2", "L$3", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DialPausedTransactionsUseCase.this.invoke(this);
        }
    }

    @Inject
    public DialPausedTransactionsUseCase(TransactionRepository transactionRepository, DialUssdUseCase dialUssdUseCase) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(dialUssdUseCase, "dialUssdUseCase");
        this.transactionRepository = transactionRepository;
        this.dialUssdUseCase = dialUssdUseCase;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f A[Catch: Exception -> 0x00a1, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a1, blocks: (B:13:0x003c, B:24:0x0069, B:26:0x006f, B:17:0x004b, B:23:0x005f, B:20:0x0052), top: B:34:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x009d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:? A[LOOP:0: B:24:0x0069->B:39:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(Continuation<? super Unit> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        Iterable iterable;
        Iterator it;
        int i;
        Transaction transaction;
        DialUssdUseCase dialUssdUseCase;
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
        Object transactionsByStatus = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(transactionsByStatus);
                TransactionRepository transactionRepository = this.transactionRepository;
                TransactionStatus transactionStatus = TransactionStatus.PAUSED;
                anonymousClass1.label = 1;
                transactionsByStatus = transactionRepository.getTransactionsByStatus(transactionStatus, anonymousClass1);
                if (transactionsByStatus == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(transactionsByStatus);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = anonymousClass1.I$1;
                i = anonymousClass1.I$0;
                Object obj = anonymousClass1.L$2;
                Iterator it2 = (Iterator) anonymousClass1.L$1;
                Iterable iterable2 = (Iterable) anonymousClass1.L$0;
                ResultKt.throwOnFailure(transactionsByStatus);
                it = it2;
                iterable = iterable2;
            }
            while (it.hasNext()) {
                Object next = it.next();
                transaction = (Transaction) next;
                dialUssdUseCase = this.dialUssdUseCase;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                anonymousClass1.L$1 = it;
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(next);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(transaction);
                anonymousClass1.I$0 = i;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 2;
                if (DialUssdUseCase.invoke$default(dialUssdUseCase, transaction, 0L, anonymousClass1, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
            Iterable iterable3 = (Iterable) transactionsByStatus;
            iterable = iterable3;
            it = iterable3.iterator();
            i = 0;
            while (it.hasNext()) {
                Object next2 = it.next();
                transaction = (Transaction) next2;
                dialUssdUseCase = this.dialUssdUseCase;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                anonymousClass1.L$1 = it;
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(next2);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(transaction);
                anonymousClass1.I$0 = i;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 2;
                if (DialUssdUseCase.invoke$default(dialUssdUseCase, transaction, 0L, anonymousClass1, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } catch (Exception e) {
            Log.e("DialPausedTransactionsUseCase", "dialPausedTransactionUseCase", e);
            throw e;
        }
    }
}
