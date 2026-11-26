package com.example.bingwahybrid.domain.usecase.subscriptions;

import com.example.bingwahybrid.domain.model.SubscriptionPackage;
import com.example.bingwahybrid.domain.repository.SubscriptionPackageRepository;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: GetSubscriptionPackagesUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000bH\u0086B¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/subscriptions/GetSubscriptionPackagesUseCase;", "", "subscriptionPackageRepository", "Lcom/example/bingwahybrid/domain/repository/SubscriptionPackageRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/SubscriptionPackageRepository;)V", "_subscriptions", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/bingwahybrid/domain/model/SubscriptionPackage;", "subscriptions", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptions", "()Lkotlinx/coroutines/flow/StateFlow;", "invoke", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetSubscriptionPackagesUseCase {
    public static final int $stable = 8;
    private final MutableStateFlow<List<SubscriptionPackage>> _subscriptions;
    private final SubscriptionPackageRepository subscriptionPackageRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.subscriptions.GetSubscriptionPackagesUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetSubscriptionPackagesUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.subscriptions.GetSubscriptionPackagesUseCase", f = "GetSubscriptionPackagesUseCase.kt", i = {}, l = {16}, m = "invoke", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetSubscriptionPackagesUseCase.this.invoke(this);
        }
    }

    @Inject
    public GetSubscriptionPackagesUseCase(SubscriptionPackageRepository subscriptionPackageRepository) {
        Intrinsics.checkNotNullParameter(subscriptionPackageRepository, "subscriptionPackageRepository");
        this.subscriptionPackageRepository = subscriptionPackageRepository;
        this._subscriptions = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    }

    public final StateFlow<List<SubscriptionPackage>> getSubscriptions() {
        return this._subscriptions;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(Continuation<? super StateFlow<? extends List<SubscriptionPackage>>> continuation) {
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
        Object subscriptions = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(subscriptions);
            SubscriptionPackageRepository subscriptionPackageRepository = this.subscriptionPackageRepository;
            anonymousClass1.label = 1;
            subscriptions = subscriptionPackageRepository.getSubscriptions(anonymousClass1);
            if (subscriptions == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(subscriptions);
        }
        this._subscriptions.setValue((List) subscriptions);
        return getSubscriptions();
    }
}
