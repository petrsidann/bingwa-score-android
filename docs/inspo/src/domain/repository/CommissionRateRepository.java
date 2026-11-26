package com.example.bingwahybrid.domain.repository;

import com.example.bingwahybrid.domain.model.CommissionRate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: CommissionRateRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H¦@¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/repository/CommissionRateRepository;", "", "refreshCommissionRates", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCommissionRates", "", "Lcom/example/bingwahybrid/domain/model/CommissionRate;", "getCommissionRateForAmount", "", "amount", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CommissionRateRepository {
    Object getCommissionRateForAmount(int i, Continuation<? super Double> continuation);

    Object getCommissionRates(Continuation<? super List<CommissionRate>> continuation);

    Object refreshCommissionRates(Continuation<? super Unit> continuation);
}
