package com.example.bingwahybrid.presentation.offers.viewmodel;

import com.example.bingwahybrid.domain.enums.LoadingState;
import com.example.bingwahybrid.domain.offers.model.Offer;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: OffersViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$allOffers$1", f = "OffersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OffersViewModel$allOffers$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends Offer>>, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OffersViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OffersViewModel$allOffers$1(OffersViewModel offersViewModel, Continuation<? super OffersViewModel$allOffers$1> continuation) {
        super(2, continuation);
        this.this$0 = offersViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OffersViewModel$allOffers$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends Offer>> flowCollector, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super List<Offer>>) flowCollector, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super List<Offer>> flowCollector, Continuation<? super Unit> continuation) {
        return ((OffersViewModel$allOffers$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0._offersLoadingState.setValue(LoadingState.Loading.INSTANCE);
        return Unit.INSTANCE;
    }
}
