package com.example.bingwahybrid.domain.engagebot.eventhandler;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: OnInvalidInput.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/engagebot/eventhandler/OnInvalidInput;", "", "onInvalidInput", "", "transactionId", "Ljava/util/UUID;", "currentAttempt", "", "maxAttempts", "(Ljava/util/UUID;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OnInvalidInput {
    Object onInvalidInput(UUID uuid, int i, int i2, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: OnInvalidInput.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object onInvalidInput$default(OnInvalidInput onInvalidInput, UUID uuid, int i, int i2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onInvalidInput");
        }
        if ((i3 & 4) != 0) {
            i2 = 3;
        }
        return onInvalidInput.onInvalidInput(uuid, i, i2, continuation);
    }
}
