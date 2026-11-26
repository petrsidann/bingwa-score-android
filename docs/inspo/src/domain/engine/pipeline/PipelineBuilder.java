package com.example.bingwahybrid.domain.engine.pipeline;

import com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PipelineBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/PipelineBuilder;", "", "<init>", "()V", "sequentialHandlers", "", "Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionHandler;", "parallelHandlers", "addSequential", "handler", "addParallel", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PipelineBuilder {
    public static final int $stable = 8;
    private final List<TransactionHandler> sequentialHandlers = new ArrayList();
    private final List<TransactionHandler> parallelHandlers = new ArrayList();

    public final PipelineBuilder addSequential(TransactionHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.sequentialHandlers.add(handler);
        return this;
    }

    public final PipelineBuilder addParallel(TransactionHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.parallelHandlers.add(handler);
        return this;
    }

    public final HandlerChain build() {
        return new HandlerChain(this.sequentialHandlers, this.parallelHandlers);
    }
}
