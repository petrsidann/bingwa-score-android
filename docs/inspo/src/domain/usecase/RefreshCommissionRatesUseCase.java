package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.CommissionRateRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RefreshCommissionRatesUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0086B¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/RefreshCommissionRatesUseCase;", "", "commissionRateRepository", "Lcom/example/bingwahybrid/domain/repository/CommissionRateRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/CommissionRateRepository;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RefreshCommissionRatesUseCase {
    public static final int $stable = 8;
    private final CommissionRateRepository commissionRateRepository;

    @Inject
    public RefreshCommissionRatesUseCase(CommissionRateRepository commissionRateRepository) {
        Intrinsics.checkNotNullParameter(commissionRateRepository, "commissionRateRepository");
        this.commissionRateRepository = commissionRateRepository;
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        Object objRefreshCommissionRates = this.commissionRateRepository.refreshCommissionRates(continuation);
        return objRefreshCommissionRates == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRefreshCommissionRates : Unit.INSTANCE;
    }
}
