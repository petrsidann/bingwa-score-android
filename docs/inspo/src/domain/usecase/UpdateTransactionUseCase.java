package com.example.bingwahybrid.domain.usecase;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.portal.events.TransactionEvent;
import com.example.bingwahybrid.domain.repository.StatisticsRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateTransactionUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086B¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;", "", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "statisticsRepository", "Lcom/example/bingwahybrid/domain/repository/StatisticsRepository;", "transactionRelay", "Lcom/example/bingwahybrid/domain/portal/TransactionRelay;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/repository/StatisticsRepository;Lcom/example/bingwahybrid/domain/portal/TransactionRelay;)V", "invoke", "", "updatedTransaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdateTransactionUseCase {
    public static final int $stable = 8;
    private final StatisticsRepository statisticsRepository;
    private final TransactionRelay transactionRelay;
    private final TransactionRepository transactionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: UpdateTransactionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase", f = "UpdateTransactionUseCase.kt", i = {0, 1, 1, 1, 1, 2, 2}, l = {24, 39, 50}, m = "invoke", n = {"updatedTransaction", "updatedTransaction", "shouldNotIncrementAirtimeUsageList", "offer", "$i$a$-let-UpdateTransactionUseCase$invoke$2", "updatedTransaction", NotificationCompat.CATEGORY_EVENT}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdateTransactionUseCase.this.invoke(null, this);
        }
    }

    @Inject
    public UpdateTransactionUseCase(TransactionRepository transactionRepository, StatisticsRepository statisticsRepository, TransactionRelay transactionRelay) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(statisticsRepository, "statisticsRepository");
        Intrinsics.checkNotNullParameter(transactionRelay, "transactionRelay");
        this.transactionRepository = transactionRepository;
        this.statisticsRepository = statisticsRepository;
        this.transactionRelay = transactionRelay;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00c9 A[Catch: Exception -> 0x00f7, PHI: r11
  0x00c9: PHI (r11v3 com.example.bingwahybrid.domain.model.Transaction) = 
  (r11v2 com.example.bingwahybrid.domain.model.Transaction)
  (r11v2 com.example.bingwahybrid.domain.model.Transaction)
  (r11v2 com.example.bingwahybrid.domain.model.Transaction)
  (r11v2 com.example.bingwahybrid.domain.model.Transaction)
  (r11v15 com.example.bingwahybrid.domain.model.Transaction)
 binds: [B:29:0x0090, B:31:0x00a0, B:33:0x00a6, B:35:0x00c6, B:19:0x0050] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {Exception -> 0x00f7, blocks: (B:14:0x0035, B:19:0x0050, B:37:0x00c9, B:22:0x0059, B:28:0x008a, B:30:0x0092, B:32:0x00a2, B:34:0x00a8, B:25:0x0060), top: B:44:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f4, code lost:
    
        if (r10.transactionRelay.send(r12, r7) == r0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Transaction transaction, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Offer offer;
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
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TransactionRepository transactionRepository = this.transactionRepository;
                UUID id = transaction.getId();
                TransactionStatus status = transaction.getStatus();
                String responseMessage = transaction.getResponseMessage();
                Integer numBoxInt = Boxing.boxInt(transaction.getInternalRetries());
                Integer numBoxInt2 = Boxing.boxInt(transaction.getExternalRetries());
                anonymousClass2.L$0 = transaction;
                anonymousClass2.label = 1;
                if (transactionRepository.updateTransactionFields(id, status, responseMessage, numBoxInt, numBoxInt2, anonymousClass2) == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                transaction = (Transaction) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                int i2 = anonymousClass2.I$0;
                transaction = (Transaction) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
                TransactionEvent.StatusChanged statusChanged = new TransactionEvent.StatusChanged(transaction.getId(), transaction.getStatus(), transaction.getResponseMessage());
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(transaction);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(statusChanged);
                anonymousClass2.L$2 = null;
                anonymousClass2.label = 3;
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            if (transaction.getStatus() == TransactionStatus.SUCCESS) {
                List listListOf = CollectionsKt.listOf(TransactionType.AIRTIME_BALANCE_CHECK);
                if (!listListOf.contains(transaction.getType()) && (offer = transaction.getOffer()) != null) {
                    StatisticsRepository statisticsRepository = this.statisticsRepository;
                    double price = offer.getPrice();
                    anonymousClass2.L$0 = transaction;
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(listListOf);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(offer);
                    anonymousClass2.I$0 = 0;
                    anonymousClass2.label = 2;
                    if (statisticsRepository.addAirtimeUsedToday(price, anonymousClass2) != coroutine_suspended) {
                        TransactionEvent.StatusChanged statusChanged2 = new TransactionEvent.StatusChanged(transaction.getId(), transaction.getStatus(), transaction.getResponseMessage());
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(transaction);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(statusChanged2);
                        anonymousClass2.L$2 = null;
                        anonymousClass2.label = 3;
                    }
                } else {
                    TransactionEvent.StatusChanged statusChanged3 = new TransactionEvent.StatusChanged(transaction.getId(), transaction.getStatus(), transaction.getResponseMessage());
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(transaction);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(statusChanged3);
                    anonymousClass2.L$2 = null;
                    anonymousClass2.label = 3;
                }
            } else {
                TransactionEvent.StatusChanged statusChanged4 = new TransactionEvent.StatusChanged(transaction.getId(), transaction.getStatus(), transaction.getResponseMessage());
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(transaction);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(statusChanged4);
                anonymousClass2.L$2 = null;
                anonymousClass2.label = 3;
            }
            return coroutine_suspended;
        } catch (Exception e) {
            Log.e("UpdateTransactionUC", e.getMessage(), e);
        }
    }
}
