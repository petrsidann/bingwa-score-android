package com.example.bingwahybrid.domain.repository;

import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.statistics.model.AgentCommission;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: AgentCommissionRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H¦@¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H¦@¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&R\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/repository/AgentCommissionRepository;", "", "agentCommissions", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/bingwahybrid/domain/statistics/model/AgentCommission;", "getAgentCommissions", "()Lkotlinx/coroutines/flow/StateFlow;", "addCommission", "", "commission", "(Lcom/example/bingwahybrid/domain/statistics/model/AgentCommission;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchCommissionForDates", "dates", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCommissions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCommissionForOffer", "", "offer", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AgentCommissionRepository {
    Object addCommission(AgentCommission agentCommission, Continuation<? super Unit> continuation);

    Object fetchCommissionForDates(List<String> list, Continuation<? super List<AgentCommission>> continuation);

    StateFlow<List<AgentCommission>> getAgentCommissions();

    double getCommissionForOffer(Offer offer);

    Object getCommissions(Continuation<? super List<AgentCommission>> continuation);
}
