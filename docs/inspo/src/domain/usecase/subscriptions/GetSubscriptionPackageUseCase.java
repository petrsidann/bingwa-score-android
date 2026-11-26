package com.example.bingwahybrid.domain.usecase.subscriptions;

import com.example.bingwahybrid.domain.model.SubscriptionPackage;
import com.example.bingwahybrid.domain.repository.SubscriptionPackageRepository;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetSubscriptionPackageUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/subscriptions/GetSubscriptionPackageUseCase;", "", "subscriptionPackageRepository", "Lcom/example/bingwahybrid/domain/repository/SubscriptionPackageRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/SubscriptionPackageRepository;)V", "invoke", "Lcom/example/bingwahybrid/domain/model/SubscriptionPackage;", "subscriptionId", "Ljava/util/UUID;", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetSubscriptionPackageUseCase {
    public static final int $stable = 8;
    private final SubscriptionPackageRepository subscriptionPackageRepository;

    @Inject
    public GetSubscriptionPackageUseCase(SubscriptionPackageRepository subscriptionPackageRepository) {
        Intrinsics.checkNotNullParameter(subscriptionPackageRepository, "subscriptionPackageRepository");
        this.subscriptionPackageRepository = subscriptionPackageRepository;
    }

    public final Object invoke(UUID uuid, Continuation<? super SubscriptionPackage> continuation) {
        return this.subscriptionPackageRepository.getSubscription(uuid, continuation);
    }
}
