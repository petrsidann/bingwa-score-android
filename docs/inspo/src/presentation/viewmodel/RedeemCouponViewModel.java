package com.example.bingwahybrid.presentation.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.data.remote.api.response.RedeemCouponResult;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: RedeemCouponViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/example/bingwahybrid/presentation/viewmodel/RedeemCouponViewModel;", "Landroidx/lifecycle/ViewModel;", "subscriptionRepository", "Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;)V", "_loading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "loading", "Lkotlinx/coroutines/flow/StateFlow;", "getLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "_error", "", "error", "getError", "_redeemCouponResult", "Lcom/example/bingwahybrid/data/remote/api/response/RedeemCouponResult;", "redeemCouponResult", "getRedeemCouponResult", "redeemCoupon", "", "couponCode", "featureCode", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RedeemCouponViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _error;
    private final MutableStateFlow<Boolean> _loading;
    private final MutableStateFlow<RedeemCouponResult> _redeemCouponResult;
    private final StateFlow<String> error;
    private final StateFlow<Boolean> loading;
    private final StateFlow<RedeemCouponResult> redeemCouponResult;
    private final SubscriptionRepository subscriptionRepository;

    @Inject
    public RedeemCouponViewModel(SubscriptionRepository subscriptionRepository) {
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        this.subscriptionRepository = subscriptionRepository;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._loading = MutableStateFlow;
        this.loading = MutableStateFlow;
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._error = MutableStateFlow2;
        this.error = MutableStateFlow2;
        MutableStateFlow<RedeemCouponResult> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._redeemCouponResult = MutableStateFlow3;
        this.redeemCouponResult = MutableStateFlow3;
    }

    public final StateFlow<Boolean> getLoading() {
        return this.loading;
    }

    public final StateFlow<String> getError() {
        return this.error;
    }

    public final StateFlow<RedeemCouponResult> getRedeemCouponResult() {
        return this.redeemCouponResult;
    }

    public final void redeemCoupon(String couponCode, String featureCode) {
        Intrinsics.checkNotNullParameter(couponCode, "couponCode");
        Intrinsics.checkNotNullParameter(featureCode, "featureCode");
        this._loading.setValue(true);
        this._error.setValue(null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(couponCode, featureCode, null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.RedeemCouponViewModel$redeemCoupon$1, reason: invalid class name */
    /* JADX INFO: compiled from: RedeemCouponViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.RedeemCouponViewModel$redeemCoupon$1", f = "RedeemCouponViewModel.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $couponCode;
        final /* synthetic */ String $featureCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$couponCode = str;
            this.$featureCode = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RedeemCouponViewModel.this.new AnonymousClass1(this.$couponCode, this.$featureCode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = RedeemCouponViewModel.this.subscriptionRepository.redeemCoupon(this.$couponCode, this.$featureCode, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                RedeemCouponViewModel.this._redeemCouponResult.setValue((RedeemCouponResult) obj);
            } catch (Exception e) {
                RedeemCouponViewModel.this._error.setValue(e.getMessage());
            } finally {
                RedeemCouponViewModel.this._loading.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
    }
}
