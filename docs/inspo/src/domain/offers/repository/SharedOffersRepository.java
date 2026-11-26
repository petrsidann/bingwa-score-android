package com.example.bingwahybrid.domain.offers.repository;

import com.example.bingwahybrid.domain.offers.enums.OfferType;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SharedOffersRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/offers/repository/SharedOffersRepository;", "", "<init>", "()V", "_offerTypeToAdd", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bingwahybrid/domain/offers/enums/OfferType;", "setOfferTypeToAdd", "", "offerType", "getOfferTypeToAdd", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedOffersRepository {
    public static final int $stable = 8;
    private final MutableStateFlow<OfferType> _offerTypeToAdd = StateFlowKt.MutableStateFlow(OfferType.DATA);

    @Inject
    public SharedOffersRepository() {
    }

    public final void setOfferTypeToAdd(OfferType offerType) {
        Intrinsics.checkNotNullParameter(offerType, "offerType");
        this._offerTypeToAdd.setValue(offerType);
    }

    public final OfferType getOfferTypeToAdd() {
        return this._offerTypeToAdd.getValue();
    }
}
