package com.example.bingwahybrid.domain.engine.validation;

import com.example.bingwahybrid.domain.engine.validation.enums.ValidationResult;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.features.enums.FeatureCodes;
import com.example.bingwahybrid.domain.features.model.Feature;
import com.example.bingwahybrid.domain.features.repository.FeatureRepository;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.model.OfferVerificationInfo;
import com.example.bingwahybrid.domain.offers.repository.OfferVerificationRepository;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubscriptionValidator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/validation/SubscriptionValidator;", "Lcom/example/bingwahybrid/domain/engine/validation/TransactionValidator;", "subscriptionRepository", "Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;", "offerVerificationRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferVerificationRepository;", "featureRepository", "Lcom/example/bingwahybrid/domain/features/repository/FeatureRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;Lcom/example/bingwahybrid/domain/offers/repository/OfferVerificationRepository;Lcom/example/bingwahybrid/domain/features/repository/FeatureRepository;)V", "excludedTypes", "", "Lcom/example/bingwahybrid/domain/enums/TransactionType;", "featureCode", "", "validate", "Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult;", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SubscriptionValidator implements TransactionValidator {
    public static final int $stable = 8;
    private final Set<TransactionType> excludedTypes;
    private final String featureCode;
    private final FeatureRepository featureRepository;
    private final OfferVerificationRepository offerVerificationRepository;
    private final SubscriptionRepository subscriptionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.validation.SubscriptionValidator$validate$1, reason: invalid class name */
    /* JADX INFO: compiled from: SubscriptionValidator.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.validation.SubscriptionValidator", f = "SubscriptionValidator.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {27, 35, 37}, m = "validate", n = {"transaction", "transaction", "offer", "$i$a$-let-SubscriptionValidator$validate$3", "transaction", "offer", "verificationInfo", "feature", "$i$a$-let-SubscriptionValidator$validate$3", "$i$a$-let-SubscriptionValidator$validate$3$1", "$i$a$-let-SubscriptionValidator$validate$3$1$1"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionValidator.this.validate(null, this);
        }
    }

    @Inject
    public SubscriptionValidator(SubscriptionRepository subscriptionRepository, OfferVerificationRepository offerVerificationRepository, FeatureRepository featureRepository) {
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        Intrinsics.checkNotNullParameter(offerVerificationRepository, "offerVerificationRepository");
        Intrinsics.checkNotNullParameter(featureRepository, "featureRepository");
        this.subscriptionRepository = subscriptionRepository;
        this.offerVerificationRepository = offerVerificationRepository;
        this.featureRepository = featureRepository;
        this.excludedTypes = SetsKt.setOf((Object[]) new TransactionType[]{TransactionType.SUBSCRIPTION_RENEWAL, TransactionType.AIRTIME_BALANCE_CHECK});
        this.featureCode = FeatureCodes.SUBSCRIPTION_BINGWAHYBRID;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x010b, code lost:
    
        if (r10 == r1) goto L49;
     */
    @Override // com.example.bingwahybrid.domain.engine.validation.TransactionValidator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object validate(Transaction transaction, Continuation<? super ValidationResult> continuation) {
        AnonymousClass1 anonymousClass1;
        Offer offer;
        Transaction transaction2;
        int i;
        OfferVerificationInfo offerVerificationInfo;
        Feature featureByCode;
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
        Object objHasSubscriptionForFeature = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objHasSubscriptionForFeature);
            if (this.excludedTypes.contains(transaction.getType())) {
                return ValidationResult.Success.INSTANCE;
            }
            SubscriptionRepository subscriptionRepository = this.subscriptionRepository;
            String str = this.featureCode;
            anonymousClass1.L$0 = transaction;
            anonymousClass1.label = 1;
            objHasSubscriptionForFeature = subscriptionRepository.hasSubscriptionForFeature(str, anonymousClass1);
            if (objHasSubscriptionForFeature != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            transaction = (Transaction) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objHasSubscriptionForFeature);
        } else {
            if (i2 == 2) {
                i = anonymousClass1.I$0;
                offer = (Offer) anonymousClass1.L$1;
                transaction2 = (Transaction) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objHasSubscriptionForFeature);
                offerVerificationInfo = (OfferVerificationInfo) objHasSubscriptionForFeature;
                if (offerVerificationInfo != null && (featureByCode = this.featureRepository.getFeatureByCode(offerVerificationInfo.getCode())) != null && featureByCode.getRequiresPurchase()) {
                    SubscriptionRepository subscriptionRepository2 = this.subscriptionRepository;
                    String code = offerVerificationInfo.getCode();
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transaction2);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(offer);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(offerVerificationInfo);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(featureByCode);
                    anonymousClass1.I$0 = i;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.label = 3;
                    objHasSubscriptionForFeature = subscriptionRepository2.hasSubscriptionForFeature(code, anonymousClass1);
                }
                return ValidationResult.Success.INSTANCE;
            }
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = anonymousClass1.I$2;
            int i4 = anonymousClass1.I$1;
            int i5 = anonymousClass1.I$0;
            ResultKt.throwOnFailure(objHasSubscriptionForFeature);
        }
        if (!((Boolean) objHasSubscriptionForFeature).booleanValue()) {
            return new ValidationResult.Failure(TransactionStatus.FAILED, "Failed. You have no active subscription for this offer. Please subscribe to continue");
        }
        return ValidationResult.Success.INSTANCE;
        if (!((Boolean) objHasSubscriptionForFeature).booleanValue()) {
            return new ValidationResult.Failure(TransactionStatus.FAILED, "Failed. You have no active subscription. Please subscribe then retry.");
        }
        Offer offer2 = transaction.getOffer();
        if (offer2 != null) {
            if (!offer2.isVerified()) {
                offer2 = null;
            }
            offer = offer2;
            if (offer != null) {
                OfferVerificationRepository offerVerificationRepository = this.offerVerificationRepository;
                UUID id = offer.getId();
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transaction);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(offer);
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 2;
                objHasSubscriptionForFeature = offerVerificationRepository.findByOfferId(id, anonymousClass1);
                if (objHasSubscriptionForFeature != coroutine_suspended) {
                    transaction2 = transaction;
                    i = 0;
                    offerVerificationInfo = (OfferVerificationInfo) objHasSubscriptionForFeature;
                    if (offerVerificationInfo != null) {
                        SubscriptionRepository subscriptionRepository3 = this.subscriptionRepository;
                        String code2 = offerVerificationInfo.getCode();
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transaction2);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(offer);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(offerVerificationInfo);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(featureByCode);
                        anonymousClass1.I$0 = i;
                        anonymousClass1.I$1 = 0;
                        anonymousClass1.I$2 = 0;
                        anonymousClass1.label = 3;
                        objHasSubscriptionForFeature = subscriptionRepository3.hasSubscriptionForFeature(code2, anonymousClass1);
                    }
                }
                return coroutine_suspended;
            }
        }
        return ValidationResult.Success.INSTANCE;
    }
}
