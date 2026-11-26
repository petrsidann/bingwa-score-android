package com.example.bingwahybrid.domain.engine.pipeline.chains;

import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.AlreadyRecommendedHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.AutoReplyHandler;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlreadyRecommendedChain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/chains/AlreadyRecommendedChain;", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "alreadyRecommendedHandler", "Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/AlreadyRecommendedHandler;", "autoReplyHandler", "Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/AutoReplyHandler;", "<init>", "(Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/AlreadyRecommendedHandler;Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/AutoReplyHandler;)V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AlreadyRecommendedChain extends HandlerChain {
    public static final int $stable = 8;
    private final AlreadyRecommendedHandler alreadyRecommendedHandler;
    private final AutoReplyHandler autoReplyHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public AlreadyRecommendedChain(AlreadyRecommendedHandler alreadyRecommendedHandler, AutoReplyHandler autoReplyHandler) {
        super(CollectionsKt.emptyList(), CollectionsKt.listOf((Object[]) new TransactionHandler[]{alreadyRecommendedHandler, autoReplyHandler}));
        Intrinsics.checkNotNullParameter(alreadyRecommendedHandler, "alreadyRecommendedHandler");
        Intrinsics.checkNotNullParameter(autoReplyHandler, "autoReplyHandler");
        this.alreadyRecommendedHandler = alreadyRecommendedHandler;
        this.autoReplyHandler = autoReplyHandler;
    }
}
