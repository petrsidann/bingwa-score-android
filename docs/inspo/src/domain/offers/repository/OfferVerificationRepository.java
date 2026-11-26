package com.example.bingwahybrid.domain.offers.repository;

import com.example.bingwahybrid.domain.offers.model.OfferVerificationInfo;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: OfferVerificationRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0011\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u0012R\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/offers/repository/OfferVerificationRepository;", "", "verifications", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/bingwahybrid/domain/offers/model/OfferVerificationInfo;", "getVerifications", "()Lkotlinx/coroutines/flow/Flow;", "save", "", "verification", "(Lcom/example/bingwahybrid/domain/offers/model/OfferVerificationInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findByOfferId", "offerId", "Ljava/util/UUID;", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByOfferId", "clear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OfferVerificationRepository {
    Object clear(Continuation<? super Unit> continuation);

    Object deleteByOfferId(UUID uuid, Continuation<? super Unit> continuation);

    Object findByOfferId(UUID uuid, Continuation<? super OfferVerificationInfo> continuation);

    Flow<List<OfferVerificationInfo>> getVerifications();

    Object save(OfferVerificationInfo offerVerificationInfo, Continuation<? super Unit> continuation);
}
