package com.example.bingwahybrid.domain.offers.repository;

import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.model.OfferVerificationInfo;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: OfferRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H¦@¢\u0006\u0002\u0010\u000fJ \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H¦@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H¦@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH¦@¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bH¦@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001bH¦@¢\u0006\u0002\u0010\u001cJ\u0016\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001bH¦@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0016H&J\u001e\u0010&\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010'J \u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020+0*0\u0004H¦@¢\u0006\u0002\u0010\u000fR\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006,À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "", "offers", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "getOffers", "()Lkotlinx/coroutines/flow/Flow;", "addOffer", "", "offer", "(Lcom/example/bingwahybrid/domain/offers/model/Offer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addOfferRemote", "remoteSync", "getAllOffers", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemoteOffers", "channel", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfferByPrice", FirebaseAnalytics.Param.PRICE, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDirtyOffers", "markOfferAsClean", "id", "Ljava/util/UUID;", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfferById", "deleteOffer", "deleteOfferRemote", "offerId", "deleteOfferById", "updateOffer", "updatedOffer", "createSubscriptionOffer", "amount", "addChannelToOffer", "(Ljava/util/UUID;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeChannelFromOffer", "getVerifiedOffers", "Lkotlin/Pair;", "Lcom/example/bingwahybrid/domain/offers/model/OfferVerificationInfo;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OfferRepository {
    Object addChannelToOffer(UUID uuid, String str, Continuation<? super Unit> continuation);

    Object addOffer(Offer offer, Continuation<? super Unit> continuation);

    Object addOfferRemote(Offer offer, Continuation<? super Unit> continuation);

    Offer createSubscriptionOffer(int amount);

    Object deleteOffer(Offer offer, Continuation<? super Unit> continuation);

    Object deleteOfferById(UUID uuid, Continuation<? super Unit> continuation);

    Object deleteOfferRemote(UUID uuid, Continuation<? super Unit> continuation);

    Object getAllOffers(Continuation<? super List<Offer>> continuation);

    Object getDirtyOffers(Continuation<? super List<Offer>> continuation);

    Object getOfferById(UUID uuid, Continuation<? super Offer> continuation);

    Object getOfferByPrice(int i, Continuation<? super Offer> continuation);

    Flow<List<Offer>> getOffers();

    Object getRemoteOffers(String str, Continuation<? super List<Offer>> continuation);

    Object getVerifiedOffers(Continuation<? super List<Pair<Offer, OfferVerificationInfo>>> continuation);

    Object markOfferAsClean(UUID uuid, Continuation<? super Unit> continuation);

    Object remoteSync(Offer offer, Continuation<? super Unit> continuation);

    Object removeChannelFromOffer(UUID uuid, String str, Continuation<? super Unit> continuation);

    Object updateOffer(Offer offer, Continuation<? super Offer> continuation);

    /* JADX INFO: compiled from: OfferRepository.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getRemoteOffers$default(OfferRepository offerRepository, String str, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRemoteOffers");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return offerRepository.getRemoteOffers(str, continuation);
    }
}
