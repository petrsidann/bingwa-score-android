package com.example.bingwahybrid.domain.usecase;

import android.content.Context;
import android.util.Log;
import androidx.work.WorkManager;
import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import java.util.UUID;
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

/* JADX INFO: compiled from: RetryTransactionUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086B¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/RetryTransactionUseCase;", "", "updateTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;", "dialUssdUseCase", "Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "context", "Landroid/content/Context;", "<init>", "(Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Landroid/content/Context;)V", "invoke", "", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelScheduledTransactionWork", "transactionId", "Ljava/util/UUID;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RetryTransactionUseCase {
    public static final int $stable = 8;
    private final Context context;
    private final DialUssdUseCase dialUssdUseCase;
    private final TransactionRepository transactionRepository;
    private final UpdateTransactionUseCase updateTransactionUseCase;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.RetryTransactionUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: RetryTransactionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.RetryTransactionUseCase", f = "RetryTransactionUseCase.kt", i = {0, 0, 1, 1}, l = {35, 37}, m = "invoke", n = {"transaction", "updatedTransaction", "transaction", "updatedTransaction"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetryTransactionUseCase.this.invoke(null, this);
        }
    }

    @Inject
    public RetryTransactionUseCase(UpdateTransactionUseCase updateTransactionUseCase, DialUssdUseCase dialUssdUseCase, TransactionRepository transactionRepository, Context context) {
        Intrinsics.checkNotNullParameter(updateTransactionUseCase, "updateTransactionUseCase");
        Intrinsics.checkNotNullParameter(dialUssdUseCase, "dialUssdUseCase");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(context, "context");
        this.updateTransactionUseCase = updateTransactionUseCase;
        this.dialUssdUseCase = dialUssdUseCase;
        this.transactionRepository = transactionRepository;
        this.context = context;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e6, code lost:
    
        if (com.example.bingwahybrid.domain.engine.DialUssdUseCase.invoke$default(r4, r5, 0, r1, 2, null) == r15) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Transaction transaction, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object obj;
        Transaction transaction2;
        Transaction transaction3 = transaction;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj2 = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj2);
                if (transaction3.getOffer() == null) {
                    throw new Exception("Offer is empty. Could not retry transaction");
                }
                this.transactionRepository.getOngoingTransactions().remove(transaction3.getId());
                this.transactionRepository.getTransactionQueue().remove(transaction3);
                Transaction transactionCopy$default = Transaction.copy$default(transaction3, null, null, 0, 0L, null, null, TransactionStatus.SCHEDULED, null, null, null, null, 0, 0, 0L, null, null, null, 124863, null);
                UpdateTransactionUseCase updateTransactionUseCase = this.updateTransactionUseCase;
                anonymousClass2.L$0 = transaction3;
                anonymousClass2.L$1 = transactionCopy$default;
                anonymousClass2.label = 1;
                obj = coroutine_suspended;
                if (updateTransactionUseCase.invoke(transactionCopy$default, anonymousClass2) != obj) {
                    transaction2 = transactionCopy$default;
                }
                return obj;
            }
            if (i == 1) {
                Transaction transaction4 = (Transaction) anonymousClass2.L$1;
                Transaction transaction5 = (Transaction) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj2);
                transaction2 = transaction4;
                transaction3 = transaction5;
                obj = coroutine_suspended;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj2);
            }
            return Unit.INSTANCE;
            cancelScheduledTransactionWork(transaction3.getId());
            DialUssdUseCase dialUssdUseCase = this.dialUssdUseCase;
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(transaction3);
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(transaction2);
            anonymousClass2.label = 2;
        } catch (Exception e) {
            Log.e("RetryTransactionUseCase", String.valueOf(e.getMessage()));
            throw e;
        }
    }

    private final void cancelScheduledTransactionWork(UUID transactionId) {
        WorkManager companion = WorkManager.INSTANCE.getInstance(this.context);
        String string = transactionId.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        companion.cancelAllWorkByTag(string);
    }
}
