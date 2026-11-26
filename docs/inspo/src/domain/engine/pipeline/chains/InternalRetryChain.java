package com.example.bingwahybrid.domain.engine.pipeline.chains;

import com.example.bingwahybrid.domain.engine.pipeline.handlers.InternalRetryHandler;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InternalRetryChain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/chains/InternalRetryChain;", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "internalRetryHandler", "Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/InternalRetryHandler;", "<init>", "(Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/InternalRetryHandler;)V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InternalRetryChain extends HandlerChain {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public InternalRetryChain(InternalRetryHandler internalRetryHandler) {
        super(CollectionsKt.listOf(internalRetryHandler), CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(internalRetryHandler, "internalRetryHandler");
    }
}
