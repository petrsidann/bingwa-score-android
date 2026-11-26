package com.example.bingwahybrid.domain.offers.usecase;

import androidx.autofill.HintConstants;
import com.example.bingwahybrid.domain.offers.enums.InputMode;
import com.example.bingwahybrid.domain.offers.enums.StepType;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.model.OfferVerificationInfo;
import com.example.bingwahybrid.domain.offers.model.VerifiedOfferStep;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.offers.repository.OfferVerificationRepository;
import com.google.common.net.HttpHeaders;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SetupVerifiedOfferTestUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/offers/usecase/SetupVerifiedOfferTestUseCase;", "", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "offerVerificationRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferVerificationRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;Lcom/example/bingwahybrid/domain/offers/repository/OfferVerificationRepository;)V", "execute", "Lkotlin/Result;", "", "offerId", "Ljava/util/UUID;", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "", "execute-0E7RQCE", "(Ljava/util/UUID;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetupVerifiedOfferTestUseCase {
    public static final int $stable = 0;
    private final OfferRepository offerRepository;
    private final OfferVerificationRepository offerVerificationRepository;

    @Inject
    public SetupVerifiedOfferTestUseCase(OfferRepository offerRepository, OfferVerificationRepository offerVerificationRepository) {
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        Intrinsics.checkNotNullParameter(offerVerificationRepository, "offerVerificationRepository");
        this.offerRepository = offerRepository;
        this.offerVerificationRepository = offerVerificationRepository;
    }

    /* JADX INFO: renamed from: execute-0E7RQCE$default, reason: not valid java name */
    public static /* synthetic */ Object m9341execute0E7RQCE$default(SetupVerifiedOfferTestUseCase setupVerifiedOfferTestUseCase, UUID uuid, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            uuid = null;
        }
        if ((i & 2) != 0) {
            str = "0797014200";
        }
        return setupVerifiedOfferTestUseCase.m9342execute0E7RQCE(uuid, str, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00b0 A[Catch: Exception -> 0x021f, TryCatch #0 {Exception -> 0x021f, blocks: (B:15:0x0051, B:52:0x0216, B:20:0x006e, B:49:0x0154, B:23:0x007d, B:41:0x00ed, B:45:0x010b, B:43:0x00f7, B:26:0x008e, B:33:0x00ac, B:35:0x00b0, B:30:0x009c, B:38:0x00d9), top: B:57:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00f7 A[Catch: Exception -> 0x021f, TryCatch #0 {Exception -> 0x021f, blocks: (B:15:0x0051, B:52:0x0216, B:20:0x006e, B:49:0x0154, B:23:0x007d, B:41:0x00ed, B:45:0x010b, B:43:0x00f7, B:26:0x008e, B:33:0x00ac, B:35:0x00b0, B:30:0x009c, B:38:0x00d9), top: B:57:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0213, code lost:
    
        if (r0.save(r9, r5) == r6) goto L51;
     */
    /* JADX INFO: renamed from: execute-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9342execute0E7RQCE(UUID uuid, String str, Continuation<? super Result<Unit>> continuation) {
        SetupVerifiedOfferTestUseCase$execute$1 setupVerifiedOfferTestUseCase$execute$1;
        Offer offer;
        UUID uuid2;
        String str2;
        Offer offerCopy$default;
        Offer offer2;
        UUID uuid3 = uuid;
        String str3 = str;
        if (continuation instanceof SetupVerifiedOfferTestUseCase$execute$1) {
            setupVerifiedOfferTestUseCase$execute$1 = (SetupVerifiedOfferTestUseCase$execute$1) continuation;
            if ((setupVerifiedOfferTestUseCase$execute$1.label & Integer.MIN_VALUE) != 0) {
                setupVerifiedOfferTestUseCase$execute$1.label -= Integer.MIN_VALUE;
            } else {
                setupVerifiedOfferTestUseCase$execute$1 = new SetupVerifiedOfferTestUseCase$execute$1(this, continuation);
            }
        } else {
            setupVerifiedOfferTestUseCase$execute$1 = new SetupVerifiedOfferTestUseCase$execute$1(this, continuation);
        }
        Object allOffers = setupVerifiedOfferTestUseCase$execute$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = setupVerifiedOfferTestUseCase$execute$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(allOffers);
                if (uuid3 != null) {
                    OfferRepository offerRepository = this.offerRepository;
                    setupVerifiedOfferTestUseCase$execute$1.L$0 = uuid3;
                    setupVerifiedOfferTestUseCase$execute$1.L$1 = str3;
                    setupVerifiedOfferTestUseCase$execute$1.label = 1;
                    allOffers = offerRepository.getOfferById(uuid3, setupVerifiedOfferTestUseCase$execute$1);
                    if (allOffers != coroutine_suspended) {
                        offer = (Offer) allOffers;
                        if (offer == null) {
                            Result.Companion companion = Result.INSTANCE;
                            return Result.m10476constructorimpl(ResultKt.createFailure(new Exception("Offer with ID " + uuid3 + " not found")));
                        }
                    }
                } else {
                    OfferRepository offerRepository2 = this.offerRepository;
                    setupVerifiedOfferTestUseCase$execute$1.L$0 = SpillingKt.nullOutSpilledVariable(uuid3);
                    setupVerifiedOfferTestUseCase$execute$1.L$1 = str3;
                    setupVerifiedOfferTestUseCase$execute$1.label = 2;
                    allOffers = offerRepository2.getAllOffers(setupVerifiedOfferTestUseCase$execute$1);
                    if (allOffers != coroutine_suspended) {
                        offer = (Offer) CollectionsKt.firstOrNull((List) allOffers);
                        if (offer == null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            return Result.m10476constructorimpl(ResultKt.createFailure(new Exception("No offers found in repository")));
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                String str4 = (String) setupVerifiedOfferTestUseCase$execute$1.L$1;
                UUID uuid4 = (UUID) setupVerifiedOfferTestUseCase$execute$1.L$0;
                ResultKt.throwOnFailure(allOffers);
                str3 = str4;
                uuid3 = uuid4;
                offer = (Offer) allOffers;
                if (offer == null) {
                    Result.Companion companion3 = Result.INSTANCE;
                    return Result.m10476constructorimpl(ResultKt.createFailure(new Exception("Offer with ID " + uuid3 + " not found")));
                }
            } else if (i == 2) {
                String str5 = (String) setupVerifiedOfferTestUseCase$execute$1.L$1;
                UUID uuid5 = (UUID) setupVerifiedOfferTestUseCase$execute$1.L$0;
                ResultKt.throwOnFailure(allOffers);
                str3 = str5;
                uuid3 = uuid5;
                offer = (Offer) CollectionsKt.firstOrNull((List) allOffers);
                if (offer == null) {
                    Result.Companion companion4 = Result.INSTANCE;
                    return Result.m10476constructorimpl(ResultKt.createFailure(new Exception("No offers found in repository")));
                }
            } else if (i == 3) {
                offerCopy$default = (Offer) setupVerifiedOfferTestUseCase$execute$1.L$3;
                offer2 = (Offer) setupVerifiedOfferTestUseCase$execute$1.L$2;
                str2 = (String) setupVerifiedOfferTestUseCase$execute$1.L$1;
                uuid2 = (UUID) setupVerifiedOfferTestUseCase$execute$1.L$0;
                ResultKt.throwOnFailure(allOffers);
                String str6 = str2;
                List listListOf = CollectionsKt.listOf((Object[]) new VerifiedOfferStep[]{new VerifiedOfferStep(StepType.SELECT, "Gift SMS", null, null, null, 28, null), new VerifiedOfferStep(StepType.SELECT, "Buy Daily SMS", null, null, null, 28, null), new VerifiedOfferStep(StepType.SELECT, "200 SMS", null, null, null, 28, null), new VerifiedOfferStep(StepType.INPUT, null, InputMode.STATIC, str6, null, 18, null), new VerifiedOfferStep(StepType.SELECT, HttpHeaders.ACCEPT, null, null, null, 28, null), new VerifiedOfferStep(StepType.SELECT, "Airtime", null, null, null, 28, null)});
                OfferVerificationInfo offerVerificationInfo = new OfferVerificationInfo(offer2.getId(), offer2.getUssdCode(), 1, 5, listListOf);
                OfferVerificationRepository offerVerificationRepository = this.offerVerificationRepository;
                setupVerifiedOfferTestUseCase$execute$1.L$0 = SpillingKt.nullOutSpilledVariable(uuid2);
                setupVerifiedOfferTestUseCase$execute$1.L$1 = SpillingKt.nullOutSpilledVariable(str6);
                setupVerifiedOfferTestUseCase$execute$1.L$2 = SpillingKt.nullOutSpilledVariable(offer2);
                setupVerifiedOfferTestUseCase$execute$1.L$3 = SpillingKt.nullOutSpilledVariable(offerCopy$default);
                setupVerifiedOfferTestUseCase$execute$1.L$4 = SpillingKt.nullOutSpilledVariable(listListOf);
                setupVerifiedOfferTestUseCase$execute$1.L$5 = SpillingKt.nullOutSpilledVariable(offerVerificationInfo);
                setupVerifiedOfferTestUseCase$execute$1.label = 4;
            } else {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(allOffers);
            }
            Result.Companion companion5 = Result.INSTANCE;
            return Result.m10476constructorimpl(Unit.INSTANCE);
            uuid2 = uuid3;
            str2 = str3;
            Offer offer3 = offer;
            offerCopy$default = Offer.copy$default(offer3, null, null, null, 0, null, null, false, null, false, true, false, false, false, 0, 0, 0L, null, false, 261631, null);
            OfferRepository offerRepository3 = this.offerRepository;
            setupVerifiedOfferTestUseCase$execute$1.L$0 = SpillingKt.nullOutSpilledVariable(uuid2);
            setupVerifiedOfferTestUseCase$execute$1.L$1 = str2;
            setupVerifiedOfferTestUseCase$execute$1.L$2 = offer3;
            setupVerifiedOfferTestUseCase$execute$1.L$3 = SpillingKt.nullOutSpilledVariable(offerCopy$default);
            setupVerifiedOfferTestUseCase$execute$1.label = 3;
            if (offerRepository3.updateOffer(offerCopy$default, setupVerifiedOfferTestUseCase$execute$1) != coroutine_suspended) {
                offer2 = offer3;
                String str7 = str2;
                List listListOf2 = CollectionsKt.listOf((Object[]) new VerifiedOfferStep[]{new VerifiedOfferStep(StepType.SELECT, "Gift SMS", null, null, null, 28, null), new VerifiedOfferStep(StepType.SELECT, "Buy Daily SMS", null, null, null, 28, null), new VerifiedOfferStep(StepType.SELECT, "200 SMS", null, null, null, 28, null), new VerifiedOfferStep(StepType.INPUT, null, InputMode.STATIC, str7, null, 18, null), new VerifiedOfferStep(StepType.SELECT, HttpHeaders.ACCEPT, null, null, null, 28, null), new VerifiedOfferStep(StepType.SELECT, "Airtime", null, null, null, 28, null)});
                OfferVerificationInfo offerVerificationInfo2 = new OfferVerificationInfo(offer2.getId(), offer2.getUssdCode(), 1, 5, listListOf2);
                OfferVerificationRepository offerVerificationRepository2 = this.offerVerificationRepository;
                setupVerifiedOfferTestUseCase$execute$1.L$0 = SpillingKt.nullOutSpilledVariable(uuid2);
                setupVerifiedOfferTestUseCase$execute$1.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                setupVerifiedOfferTestUseCase$execute$1.L$2 = SpillingKt.nullOutSpilledVariable(offer2);
                setupVerifiedOfferTestUseCase$execute$1.L$3 = SpillingKt.nullOutSpilledVariable(offerCopy$default);
                setupVerifiedOfferTestUseCase$execute$1.L$4 = SpillingKt.nullOutSpilledVariable(listListOf2);
                setupVerifiedOfferTestUseCase$execute$1.L$5 = SpillingKt.nullOutSpilledVariable(offerVerificationInfo2);
                setupVerifiedOfferTestUseCase$execute$1.label = 4;
            }
            return coroutine_suspended;
        } catch (Exception e) {
            Result.Companion companion6 = Result.INSTANCE;
            return Result.m10476constructorimpl(ResultKt.createFailure(e));
        }
    }
}
