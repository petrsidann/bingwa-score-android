package com.example.bingwahybrid.domain.subscriptions.repository;

import com.example.bingwahybrid.data.remote.api.response.RedeemCouponResult;
import com.example.bingwahybrid.domain.enums.SubscriptionType;
import com.example.bingwahybrid.domain.features.model.Feature;
import com.example.bingwahybrid.domain.features.model.FeaturePass;
import com.example.bingwahybrid.domain.subscriptions.model.Subscription;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: SubscriptionRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H¦@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u0017H¦@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H¦@¢\u0006\u0002\u0010\"R\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006#À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;", "", "activePlansFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/bingwahybrid/domain/subscriptions/model/Subscription;", "getActivePlansFlow", "()Lkotlinx/coroutines/flow/Flow;", "subscribe", "feature", "Lcom/example/bingwahybrid/domain/features/model/Feature;", "pass", "Lcom/example/bingwahybrid/domain/features/model/FeaturePass;", "(Lcom/example/bingwahybrid/domain/features/model/Feature;Lcom/example/bingwahybrid/domain/features/model/FeaturePass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveSubscriptions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "redeemCoupon", "Lcom/example/bingwahybrid/data/remote/api/response/RedeemCouponResult;", "couponCode", "", "featureCode", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decrementTokens", "", "count", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasSubscriptionForFeature", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSubscriptions", "migrateExistingSubscription", "type", "Lcom/example/bingwahybrid/domain/enums/SubscriptionType;", "(Lcom/example/bingwahybrid/domain/enums/SubscriptionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SubscriptionRepository {
    Object clearSubscriptions(Continuation<? super Unit> continuation);

    Object decrementTokens(String str, int i, Continuation<? super Unit> continuation);

    Flow<List<Subscription>> getActivePlansFlow();

    Object getActiveSubscriptions(Continuation<? super List<Subscription>> continuation);

    Object hasSubscriptionForFeature(String str, Continuation<? super Boolean> continuation);

    Object migrateExistingSubscription(SubscriptionType subscriptionType, Continuation<? super Unit> continuation);

    Object redeemCoupon(String str, String str2, Continuation<? super RedeemCouponResult> continuation);

    Object subscribe(Feature feature, FeaturePass featurePass, Continuation<? super Subscription> continuation);
}
