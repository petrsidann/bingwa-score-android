package com.example.bingwahybrid.domain.repository;

import com.example.bingwahybrid.domain.model.SubscriptionPackage;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: SubscriptionPackageRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/repository/SubscriptionPackageRepository;", "", "getSubscriptions", "", "Lcom/example/bingwahybrid/domain/model/SubscriptionPackage;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubscription", "subscriptionId", "Ljava/util/UUID;", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SubscriptionPackageRepository {
    Object getSubscription(UUID uuid, Continuation<? super SubscriptionPackage> continuation);

    Object getSubscriptions(Continuation<? super List<SubscriptionPackage>> continuation);
}
