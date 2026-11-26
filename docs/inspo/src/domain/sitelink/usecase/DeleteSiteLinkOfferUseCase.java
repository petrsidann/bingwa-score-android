package com.example.bingwahybrid.domain.sitelink.usecase;

import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteSiteLinkOfferUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/sitelink/usecase/DeleteSiteLinkOfferUseCase;", "", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;)V", "invoke", "", "offer", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "(Lcom/example/bingwahybrid/domain/offers/model/Offer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeleteSiteLinkOfferUseCase {
    public static final int $stable = 8;
    private final OfferRepository offerRepository;

    @Inject
    public DeleteSiteLinkOfferUseCase(OfferRepository offerRepository) {
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        this.offerRepository = offerRepository;
    }

    public final Object invoke(Offer offer, Continuation<? super Unit> continuation) {
        Object objRemoveChannelFromOffer = this.offerRepository.removeChannelFromOffer(offer.getId(), "sitelink", continuation);
        return objRemoveChannelFromOffer == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRemoveChannelFromOffer : Unit.INSTANCE;
    }
}
