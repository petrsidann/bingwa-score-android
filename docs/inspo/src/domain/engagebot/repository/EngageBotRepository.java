package com.example.bingwahybrid.domain.engagebot.repository;

import com.example.bingwahybrid.domain.engagebot.model.EngageBot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: EngageBotRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/engagebot/repository/EngageBotRepository;", "", "getEngageBot", "Lcom/example/bingwahybrid/domain/engagebot/model/EngageBot;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveEngageBot", "", "engageBot", "(Lcom/example/bingwahybrid/domain/engagebot/model/EngageBot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface EngageBotRepository {
    Object getEngageBot(Continuation<? super EngageBot> continuation);

    Object saveEngageBot(EngageBot engageBot, Continuation<? super Unit> continuation);
}
