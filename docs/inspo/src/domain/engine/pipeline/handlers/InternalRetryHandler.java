package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import android.util.Log;
import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain;
import com.example.bingwahybrid.domain.engine.utils.TransactionUtilsKt;
import com.example.bingwahybrid.domain.enums.ProcessingMode;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.model.TransactionContext;
import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.sms.utils.SmsUtilsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InternalRetryHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/InternalRetryHandler;", "Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionHandler;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;)V", "handle", "Lcom/example/bingwahybrid/domain/model/TransactionContext;", "context", "chain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "(Lcom/example/bingwahybrid/domain/model/TransactionContext;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InternalRetryHandler implements TransactionHandler {
    public static final int $stable = 0;
    private final SettingsRepository settingsRepository;
    private final TransactionRepository transactionRepository;

    /* JADX INFO: compiled from: InternalRetryHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[OfferType.values().length];
            try {
                iArr[OfferType.DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OfferType.SMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OfferType.VOICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ProcessingMode.values().length];
            try {
                iArr2[ProcessingMode.EXPRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ProcessingMode.ADVANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ProcessingMode.HYBRID.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Inject
    public InternalRetryHandler(TransactionRepository transactionRepository, SettingsRepository settingsRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        this.transactionRepository = transactionRepository;
        this.settingsRepository = settingsRepository;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0087  */
    @Override // com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler
    public Object handle(TransactionContext transactionContext, HandlerChain handlerChain, Continuation<? super TransactionContext> continuation) {
        int i;
        Transaction transaction = transactionContext.getTransaction();
        Offer offer = transaction.getOffer();
        if (offer != null && !TransactionUtilsKt.isNonRetriableResponse(transaction.getResponseMessage()) && !SmsUtilsKt.isInsufficientBalanceResponse(transaction.getResponseMessage())) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[this.settingsRepository.getProcessingMode().getValue().ordinal()];
            int i3 = 0;
            if (i2 == 1) {
                int i4 = WhenMappings.$EnumSwitchMapping$0[offer.getType().ordinal()];
                if (i4 == 1) {
                    i3 = 10;
                } else if (i4 == 2) {
                    i = 2;
                } else if (i4 == 3) {
                    i = 1;
                }
                i = i3;
            } else if (i2 == 2) {
                int i5 = WhenMappings.$EnumSwitchMapping$0[offer.getType().ordinal()];
                if (i5 == 1) {
                    i = 3;
                } else if (i5 == 2 || i5 == 3) {
                    i = 1;
                } else {
                    i = i3;
                }
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                int i6 = WhenMappings.$EnumSwitchMapping$0[offer.getType().ordinal()];
                if (i6 == 1) {
                    i3 = 5;
                } else if (i6 == 2 || i6 == 3) {
                    i = 1;
                }
                i = i3;
            }
            if (transaction.getInternalRetries() < i) {
                int i7 = i;
                Transaction transactionCopy$default = Transaction.copy$default(transaction, null, null, 0, 0L, null, null, TransactionStatus.SCHEDULED, null, null, null, null, transaction.getInternalRetries() + 1, 0, 0L, null, null, null, 128959, null);
                this.transactionRepository.getTransactionQueue().add(transactionCopy$default);
                Log.d("InternalRetryHandler", "Retrying transaction " + transaction.getId() + ", attempt " + transactionCopy$default.getInternalRetries() + "/" + i7);
                return null;
            }
        }
        return transactionContext;
    }
}
