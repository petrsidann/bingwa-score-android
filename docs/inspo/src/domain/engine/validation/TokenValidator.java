package com.example.bingwahybrid.domain.engine.validation;

import com.example.bingwahybrid.domain.engine.validation.enums.ValidationResult;
import com.example.bingwahybrid.domain.enums.SubscriptionType;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.features.enums.FeatureCodes;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.subscriptions.model.Subscription;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
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

/* JADX INFO: compiled from: TokenValidator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/validation/TokenValidator;", "Lcom/example/bingwahybrid/domain/engine/validation/TransactionValidator;", "subscriptionRepository", "Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;)V", "excludedTypes", "", "Lcom/example/bingwahybrid/domain/enums/TransactionType;", "featureCode", "", "validate", "Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult;", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TokenValidator implements TransactionValidator {
    public static final int $stable = 8;
    private final Set<TransactionType> excludedTypes;
    private final String featureCode;
    private final SubscriptionRepository subscriptionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.validation.TokenValidator$validate$1, reason: invalid class name */
    /* JADX INFO: compiled from: TokenValidator.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.validation.TokenValidator", f = "TokenValidator.kt", i = {0, 1, 1, 1}, l = {23, 29}, m = "validate", n = {"transaction", "transaction", "activeSubscriptions", "hasUnlimited"}, s = {"L$0", "L$0", "L$1", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TokenValidator.this.validate(null, this);
        }
    }

    @Inject
    public TokenValidator(SubscriptionRepository subscriptionRepository) {
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        this.subscriptionRepository = subscriptionRepository;
        this.excludedTypes = SetsKt.setOf((Object[]) new TransactionType[]{TransactionType.SUBSCRIPTION_RENEWAL, TransactionType.AIRTIME_BALANCE_CHECK});
        this.featureCode = FeatureCodes.SUBSCRIPTION_BINGWAHYBRID;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
    
        if (r10.decrementTokens(r8, 1, r0) == r1) goto L43;
     */
    @Override // com.example.bingwahybrid.domain.engine.validation.TransactionValidator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object validate(Transaction transaction, Continuation<? super ValidationResult> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object activeSubscriptions = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(activeSubscriptions);
            if (this.excludedTypes.contains(transaction.getType())) {
                return ValidationResult.Success.INSTANCE;
            }
            SubscriptionRepository subscriptionRepository = this.subscriptionRepository;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transaction);
            anonymousClass1.label = 1;
            activeSubscriptions = subscriptionRepository.getActiveSubscriptions(anonymousClass1);
            if (activeSubscriptions != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            transaction = (Transaction) anonymousClass1.L$0;
            ResultKt.throwOnFailure(activeSubscriptions);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$0;
            ResultKt.throwOnFailure(activeSubscriptions);
        }
        return ValidationResult.Success.INSTANCE;
        ArrayList arrayList = new ArrayList();
        for (Object obj : (Iterable) activeSubscriptions) {
            if (Intrinsics.areEqual(((Subscription) obj).getFeatureCode(), this.featureCode)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = arrayList2;
        int i3 = 0;
        if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                if (((Subscription) it.next()).getType() == SubscriptionType.UNLIMITED) {
                    i3 = 1;
                    break;
                }
            }
        }
        if (i3 == 0) {
            SubscriptionRepository subscriptionRepository2 = this.subscriptionRepository;
            String str = this.featureCode;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transaction);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(arrayList2);
            anonymousClass1.I$0 = i3;
            anonymousClass1.label = 2;
        }
        return ValidationResult.Success.INSTANCE;
    }
}
