package com.example.bingwahybrid.domain.engine.pipeline.chains;

import com.example.bingwahybrid.domain.engine.pipeline.handlers.AutoReplyHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.ExternalRetryHandler;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExternalRetryChain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/chains/ExternalRetryChain;", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "externalRetryHandler", "Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/ExternalRetryHandler;", "autoReplyHandler", "Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/AutoReplyHandler;", "<init>", "(Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/ExternalRetryHandler;Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/AutoReplyHandler;)V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExternalRetryChain extends HandlerChain {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ExternalRetryChain(ExternalRetryHandler externalRetryHandler, AutoReplyHandler autoReplyHandler) {
        super(CollectionsKt.listOf(externalRetryHandler), CollectionsKt.listOf(autoReplyHandler));
        Intrinsics.checkNotNullParameter(externalRetryHandler, "externalRetryHandler");
        Intrinsics.checkNotNullParameter(autoReplyHandler, "autoReplyHandler");
    }
}
