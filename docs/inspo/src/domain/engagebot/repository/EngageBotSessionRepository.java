package com.example.bingwahybrid.domain.engagebot.repository;

import com.example.bingwahybrid.domain.engagebot.enums.SessionTerminationReason;
import com.example.bingwahybrid.domain.engagebot.model.EngageBotSession;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: EngageBotSessionRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/engagebot/repository/EngageBotSessionRepository;", "", "startSession", "", "customerId", "Ljava/util/UUID;", "transactionId", "(Ljava/util/UUID;Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSession", "reason", "Lcom/example/bingwahybrid/domain/engagebot/enums/SessionTerminationReason;", "(Ljava/util/UUID;Lcom/example/bingwahybrid/domain/engagebot/enums/SessionTerminationReason;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasActiveSession", "", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveSession", "Lcom/example/bingwahybrid/domain/engagebot/model/EngageBotSession;", "registerInvalidInput", "onValidAlternativeNumber", "alternativeNumber", "", "(Ljava/util/UUID;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface EngageBotSessionRepository {
    Object endSession(UUID uuid, SessionTerminationReason sessionTerminationReason, Continuation<? super Unit> continuation);

    Object getActiveSession(UUID uuid, Continuation<? super EngageBotSession> continuation);

    Object hasActiveSession(UUID uuid, Continuation<? super Boolean> continuation);

    Object onValidAlternativeNumber(UUID uuid, String str, Continuation<? super Unit> continuation);

    Object registerInvalidInput(UUID uuid, Continuation<? super Unit> continuation);

    Object startSession(UUID uuid, UUID uuid2, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: EngageBotSessionRepository.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object endSession$default(EngageBotSessionRepository engageBotSessionRepository, UUID uuid, SessionTerminationReason sessionTerminationReason, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: endSession");
        }
        if ((i & 2) != 0) {
            sessionTerminationReason = null;
        }
        return engageBotSessionRepository.endSession(uuid, sessionTerminationReason, continuation);
    }
}
