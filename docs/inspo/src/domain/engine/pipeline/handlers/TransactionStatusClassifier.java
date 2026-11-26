package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.model.TransactionContext;
import com.example.bingwahybrid.domain.sms.utils.SmsUtilsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: TransactionStatusClassifier.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/TransactionStatusClassifier;", "Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionHandler;", "<init>", "()V", "handle", "Lcom/example/bingwahybrid/domain/model/TransactionContext;", "context", "chain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "(Lcom/example/bingwahybrid/domain/model/TransactionContext;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TransactionStatusClassifier implements TransactionHandler {
    public static final int $stable = 0;

    @Inject
    public TransactionStatusClassifier() {
    }

    @Override // com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler
    public Object handle(TransactionContext transactionContext, HandlerChain handlerChain, Continuation<? super TransactionContext> continuation) {
        Transaction transaction = transactionContext.getTransaction();
        return SmsUtilsKt.isAlreadyRecommendedResponse(transaction.getResponseMessage()) ? TransactionContext.copy$default(transactionContext, Transaction.copy$default(transaction, null, null, 0, 0L, null, null, TransactionStatus.FAILED_ALREADY_RECOMMENDED, null, null, null, null, 0, 0, 0L, null, null, null, 131007, null), null, false, null, false, null, 62, null) : transactionContext;
    }
}
