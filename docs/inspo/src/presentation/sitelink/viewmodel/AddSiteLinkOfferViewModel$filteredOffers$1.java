package com.example.bingwahybrid.presentation.sitelink.viewmodel;

import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.example.bingwahybrid.domain.offers.model.Offer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddSiteLinkOfferViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "localOffers", "onlineOffers", "offerType", "Lcom/example/bingwahybrid/domain/offers/enums/OfferType;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.AddSiteLinkOfferViewModel$filteredOffers$1", f = "AddSiteLinkOfferViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AddSiteLinkOfferViewModel$filteredOffers$1 extends SuspendLambda implements Function4<List<? extends Offer>, List<? extends Offer>, OfferType, Continuation<? super List<? extends Offer>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;
    final /* synthetic */ AddSiteLinkOfferViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AddSiteLinkOfferViewModel$filteredOffers$1(AddSiteLinkOfferViewModel addSiteLinkOfferViewModel, Continuation<? super AddSiteLinkOfferViewModel$filteredOffers$1> continuation) {
        super(4, continuation);
        this.this$0 = addSiteLinkOfferViewModel;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(List<? extends Offer> list, List<? extends Offer> list2, OfferType offerType, Continuation<? super List<? extends Offer>> continuation) {
        return invoke2((List<Offer>) list, (List<Offer>) list2, offerType, (Continuation<? super List<Offer>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<Offer> list, List<Offer> list2, OfferType offerType, Continuation<? super List<Offer>> continuation) {
        AddSiteLinkOfferViewModel$filteredOffers$1 addSiteLinkOfferViewModel$filteredOffers$1 = new AddSiteLinkOfferViewModel$filteredOffers$1(this.this$0, continuation);
        addSiteLinkOfferViewModel$filteredOffers$1.L$0 = list;
        addSiteLinkOfferViewModel$filteredOffers$1.L$1 = list2;
        addSiteLinkOfferViewModel$filteredOffers$1.L$2 = offerType;
        return addSiteLinkOfferViewModel$filteredOffers$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list = (List) this.L$0;
        List list2 = (List) this.L$1;
        OfferType offerType = (OfferType) this.L$2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            Offer offer = (Offer) obj2;
            List list3 = list2;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator it = list3.iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (!Intrinsics.areEqual(((Offer) it.next()).getId(), offer.getId()));
            }
            arrayList.add(obj2);
        }
        return this.this$0.filterOffers(arrayList, offerType);
    }
}
