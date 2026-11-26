package com.example.bingwahybrid.domain.repository;

import com.example.bingwahybrid.domain.features.model.Feature;
import com.example.bingwahybrid.domain.features.model.FeaturePass;
import com.example.bingwahybrid.domain.model.SubscriptionPackage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: PaymentRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u000e\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0002\u0010\tJ\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/repository/PaymentRepository;", "", "setSubscription", "", "subscriptionPackage", "Lcom/example/bingwahybrid/domain/model/SubscriptionPackage;", "getSubscription", "getAdminSubscriptionNumber", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdminSiteLinkNumber", "setSelectedFeaturePass", "featurePass", "Lcom/example/bingwahybrid/domain/features/model/FeaturePass;", "getSelectedFeaturePass", "setSelectedFeature", "feature", "Lcom/example/bingwahybrid/domain/features/model/Feature;", "getSelectedFeature", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PaymentRepository {
    Object getAdminSiteLinkNumber(Continuation<? super String> continuation);

    Object getAdminSubscriptionNumber(Continuation<? super String> continuation);

    Feature getSelectedFeature();

    FeaturePass getSelectedFeaturePass();

    SubscriptionPackage getSubscription();

    void setSelectedFeature(Feature feature);

    void setSelectedFeaturePass(FeaturePass featurePass);

    void setSubscription(SubscriptionPackage subscriptionPackage);
}
