package com.example.bingwahybrid.presentation.offers.viewmodel;

import com.example.bingwahybrid.domain.enums.LoadingState;
import com.example.bingwahybrid.domain.offers.model.Offer;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: compiled from: OffersViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "e", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$allOffers$3", f = "OffersViewModel.kt", i = {0, 0}, l = {48}, m = "invokeSuspend", n = {"$this$catch", "e"}, s = {"L$0", "L$1"})
final class OffersViewModel$allOffers$3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends Offer>>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ OffersViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OffersViewModel$allOffers$3(OffersViewModel offersViewModel, Continuation<? super OffersViewModel$allOffers$3> continuation) {
        super(3, continuation);
        this.this$0 = offersViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends Offer>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super List<Offer>>) flowCollector, th, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super List<Offer>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        OffersViewModel$allOffers$3 offersViewModel$allOffers$3 = new OffersViewModel$allOffers$3(this.this$0, continuation);
        offersViewModel$allOffers$3.L$0 = flowCollector;
        offersViewModel$allOffers$3.L$1 = th;
        return offersViewModel$allOffers$3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Throwable th = (Throwable) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow mutableStateFlow = this.this$0._offersLoadingState;
            String message = th.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            mutableStateFlow.setValue(new LoadingState.Failure(message));
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(th);
            this.label = 1;
            if (flowCollector.emit(CollectionsKt.emptyList(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
