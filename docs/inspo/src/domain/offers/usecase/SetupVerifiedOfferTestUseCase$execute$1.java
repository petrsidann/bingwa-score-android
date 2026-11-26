package com.example.bingwahybrid.domain.offers.usecase;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SetupVerifiedOfferTestUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.domain.offers.usecase.SetupVerifiedOfferTestUseCase", f = "SetupVerifiedOfferTestUseCase.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {30, 33, 40, 86}, m = "execute-0E7RQCE", n = {"offerId", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "offerId", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "offerId", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "offer", "verifiedOffer", "offerId", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "offer", "verifiedOffer", "steps", "verificationInfo"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
final class SetupVerifiedOfferTestUseCase$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SetupVerifiedOfferTestUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SetupVerifiedOfferTestUseCase$execute$1(SetupVerifiedOfferTestUseCase setupVerifiedOfferTestUseCase, Continuation<? super SetupVerifiedOfferTestUseCase$execute$1> continuation) {
        super(continuation);
        this.this$0 = setupVerifiedOfferTestUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM9342execute0E7RQCE = this.this$0.m9342execute0E7RQCE(null, null, this);
        return objM9342execute0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM9342execute0E7RQCE : Result.m10475boximpl(objM9342execute0E7RQCE);
    }
}
