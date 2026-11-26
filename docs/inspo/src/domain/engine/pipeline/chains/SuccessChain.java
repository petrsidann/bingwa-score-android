package com.example.bingwahybrid.domain.engine.pipeline.chains;

import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.AgentCommissionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.AutoReplyHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.UpdateTransactionHandler;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SuccessChain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/chains/SuccessChain;", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "updateTransactionHandler", "Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/UpdateTransactionHandler;", "autoReplyHandler", "Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/AutoReplyHandler;", "agentCommissionHandler", "Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/AgentCommissionHandler;", "<init>", "(Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/UpdateTransactionHandler;Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/AutoReplyHandler;Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/AgentCommissionHandler;)V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SuccessChain extends HandlerChain {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public SuccessChain(UpdateTransactionHandler updateTransactionHandler, AutoReplyHandler autoReplyHandler, AgentCommissionHandler agentCommissionHandler) {
        super(CollectionsKt.emptyList(), CollectionsKt.listOf((Object[]) new TransactionHandler[]{updateTransactionHandler, autoReplyHandler, agentCommissionHandler}));
        Intrinsics.checkNotNullParameter(updateTransactionHandler, "updateTransactionHandler");
        Intrinsics.checkNotNullParameter(autoReplyHandler, "autoReplyHandler");
        Intrinsics.checkNotNullParameter(agentCommissionHandler, "agentCommissionHandler");
    }
}
