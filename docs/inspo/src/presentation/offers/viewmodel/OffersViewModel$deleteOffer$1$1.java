package com.example.bingwahybrid.presentation.offers.viewmodel;

import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.utils.NavigationManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OffersViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$deleteOffer$1$1", f = "OffersViewModel.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
final class OffersViewModel$deleteOffer$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Offer $offer;
    int label;
    final /* synthetic */ OffersViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OffersViewModel$deleteOffer$1$1(OffersViewModel offersViewModel, Offer offer, Continuation<? super OffersViewModel$deleteOffer$1$1> continuation) {
        super(2, continuation);
        this.this$0 = offersViewModel;
        this.$offer = offer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OffersViewModel$deleteOffer$1$1(this.this$0, this.$offer, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OffersViewModel$deleteOffer$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0._deleteSuccess.setValue(Boxing.boxBoolean(false));
                this.this$0._isDeleting.setValue(Boxing.boxBoolean(true));
                this.label = 1;
                if (this.this$0.deleteOfferUseCase.invoke(this.$offer, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0._deleteSuccess.setValue(Boxing.boxBoolean(true));
            this.this$0._snackBarMessage.setValue("Offer deleted successfully");
            NavigationManager.INSTANCE.back();
        } catch (Exception e) {
            this.this$0._deleteSuccess.setValue(Boxing.boxBoolean(false));
            this.this$0._snackBarMessage.setValue(String.valueOf(e.getMessage()));
        } finally {
            this.this$0._isDeleting.setValue(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }
}
