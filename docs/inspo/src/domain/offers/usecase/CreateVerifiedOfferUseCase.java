package com.example.bingwahybrid.domain.offers.usecase;

import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.model.OfferVerificationInfo;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.offers.repository.OfferVerificationRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateVerifiedOfferUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086B¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/example/bingwahybrid/domain/offers/usecase/CreateVerifiedOfferUseCase;", "", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "offerVerificationRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferVerificationRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;Lcom/example/bingwahybrid/domain/offers/repository/OfferVerificationRepository;)V", "invoke", "", "offer", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "verificationInfo", "Lcom/example/bingwahybrid/domain/offers/model/OfferVerificationInfo;", "(Lcom/example/bingwahybrid/domain/offers/model/Offer;Lcom/example/bingwahybrid/domain/offers/model/OfferVerificationInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateVerifiedOfferUseCase {
    public static final int $stable = 0;
    private final OfferRepository offerRepository;
    private final OfferVerificationRepository offerVerificationRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.offers.usecase.CreateVerifiedOfferUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateVerifiedOfferUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.offers.usecase.CreateVerifiedOfferUseCase", f = "CreateVerifiedOfferUseCase.kt", i = {0, 0, 0, 1, 1, 1}, l = {15, 16}, m = "invoke", n = {"offer", "verificationInfo", "verifiedOffer", "offer", "verificationInfo", "verifiedOffer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateVerifiedOfferUseCase.this.invoke(null, null, this);
        }
    }

    @Inject
    public CreateVerifiedOfferUseCase(OfferRepository offerRepository, OfferVerificationRepository offerVerificationRepository) {
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        Intrinsics.checkNotNullParameter(offerVerificationRepository, "offerVerificationRepository");
        this.offerRepository = offerRepository;
        this.offerVerificationRepository = offerVerificationRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b9, code lost:
    
        if (r0.save(r6, r2) == r3) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Offer offer, OfferVerificationInfo offerVerificationInfo, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Offer offerCopy$default;
        OfferVerificationInfo offerVerificationInfo2;
        Offer offer2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            offerCopy$default = Offer.copy$default(offer, null, null, null, 0, null, null, false, null, false, true, false, false, false, 0, 0, 0L, null, false, 261631, null);
            OfferRepository offerRepository = this.offerRepository;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(offer);
            anonymousClass1.L$1 = offerVerificationInfo;
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(offerCopy$default);
            anonymousClass1.label = 1;
            if (offerRepository.addOffer(offerCopy$default, anonymousClass1) != coroutine_suspended) {
                offerVerificationInfo2 = offerVerificationInfo;
                offer2 = offer;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            offerCopy$default = (Offer) anonymousClass1.L$2;
            offerVerificationInfo2 = (OfferVerificationInfo) anonymousClass1.L$1;
            offer2 = (Offer) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        OfferVerificationRepository offerVerificationRepository = this.offerVerificationRepository;
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(offer2);
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(offerVerificationInfo2);
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(offerCopy$default);
        anonymousClass1.label = 2;
    }
}
