package com.example.bingwahybrid.presentation.subscriptions.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.enums.LoadingState;
import com.example.bingwahybrid.domain.enums.SubscriptionType;
import com.example.bingwahybrid.domain.features.model.Feature;
import com.example.bingwahybrid.domain.features.model.FeaturePass;
import com.example.bingwahybrid.domain.features.repository.FeaturePassRepository;
import com.example.bingwahybrid.domain.features.repository.FeatureRepository;
import com.example.bingwahybrid.domain.repository.PaymentRepository;
import com.example.bingwahybrid.domain.subscriptions.model.Subscription;
import com.example.bingwahybrid.domain.subscriptions.model.SubscriptionKt;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SubscriptionsViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020%J\u0010\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u000201H\u0002J\u000e\u00107\u001a\u0002012\u0006\u00108\u001a\u00020\u001eJ\u0006\u00109\u001a\u000201J\b\u0010:\u001a\u000201H\u0002J\u0010\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020\u000eH\u0002J\u001e\u0010=\u001a\u0002012\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u001d2\u0006\u0010<\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0016\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u0012¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0014R\u0016\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0014¨\u0006@"}, d2 = {"Lcom/example/bingwahybrid/presentation/subscriptions/viewmodels/SubscriptionsViewModel;", "Landroidx/lifecycle/ViewModel;", "featureRepository", "Lcom/example/bingwahybrid/domain/features/repository/FeatureRepository;", "featurePassRepository", "Lcom/example/bingwahybrid/domain/features/repository/FeaturePassRepository;", "subscriptionRepository", "Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;", "paymentRepository", "Lcom/example/bingwahybrid/domain/repository/PaymentRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/features/repository/FeatureRepository;Lcom/example/bingwahybrid/domain/features/repository/FeaturePassRepository;Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;Lcom/example/bingwahybrid/domain/repository/PaymentRepository;)V", "_currentFeatureCode", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_currentFeature", "Lcom/example/bingwahybrid/domain/features/model/Feature;", "currentFeatureCode", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentFeatureCode", "()Lkotlinx/coroutines/flow/StateFlow;", "_unlimitedLimit", "", "unlimitedLimit", "getUnlimitedLimit", "_limitedLimit", "limitedLimit", "getLimitedLimit", "_availablePasses", "", "Lcom/example/bingwahybrid/domain/features/model/FeaturePass;", "availablePasses", "getAvailablePasses", "_selectedFeaturePass", "selectedFeaturePass", "getSelectedFeaturePass", "_isLoadingPasses", "", "isLoadingPasses", "countdownJob", "Lkotlinx/coroutines/Job;", "_loadingState", "Lcom/example/bingwahybrid/domain/enums/LoadingState;", "loadingState", "getLoadingState", "_errorMessage", "errorMessage", "getErrorMessage", "setFeatureCode", "", "code", "fetchPasses", "startCountdownTimer", "limit", "stopCountdownTimer", "setChosenPass", "pass", "retryFetchPasses", "observeActivePlans", "fetchPassesAndLimits", "featureCode", "updateFeatureLimits", "plans", "Lcom/example/bingwahybrid/domain/subscriptions/model/Subscription;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SubscriptionsViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<List<FeaturePass>> _availablePasses;
    private final MutableStateFlow<Feature> _currentFeature;
    private final MutableStateFlow<String> _currentFeatureCode;
    private final MutableStateFlow<String> _errorMessage;
    private final MutableStateFlow<Boolean> _isLoadingPasses;
    private final MutableStateFlow<Long> _limitedLimit;
    private final MutableStateFlow<LoadingState> _loadingState;
    private final MutableStateFlow<FeaturePass> _selectedFeaturePass;
    private final MutableStateFlow<Long> _unlimitedLimit;
    private final StateFlow<List<FeaturePass>> availablePasses;
    private Job countdownJob;
    private final StateFlow<Feature> currentFeatureCode;
    private final StateFlow<String> errorMessage;
    private final FeaturePassRepository featurePassRepository;
    private final FeatureRepository featureRepository;
    private final StateFlow<Boolean> isLoadingPasses;
    private final StateFlow<Long> limitedLimit;
    private final StateFlow<LoadingState> loadingState;
    private final PaymentRepository paymentRepository;
    private final StateFlow<FeaturePass> selectedFeaturePass;
    private final SubscriptionRepository subscriptionRepository;
    private final StateFlow<Long> unlimitedLimit;

    @Inject
    public SubscriptionsViewModel(FeatureRepository featureRepository, FeaturePassRepository featurePassRepository, SubscriptionRepository subscriptionRepository, PaymentRepository paymentRepository) {
        Intrinsics.checkNotNullParameter(featureRepository, "featureRepository");
        Intrinsics.checkNotNullParameter(featurePassRepository, "featurePassRepository");
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        Intrinsics.checkNotNullParameter(paymentRepository, "paymentRepository");
        this.featureRepository = featureRepository;
        this.featurePassRepository = featurePassRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.paymentRepository = paymentRepository;
        this._currentFeatureCode = StateFlowKt.MutableStateFlow(null);
        MutableStateFlow<Feature> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._currentFeature = MutableStateFlow;
        this.currentFeatureCode = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Long> MutableStateFlow2 = StateFlowKt.MutableStateFlow(0L);
        this._unlimitedLimit = MutableStateFlow2;
        this.unlimitedLimit = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<Long> MutableStateFlow3 = StateFlowKt.MutableStateFlow(0L);
        this._limitedLimit = MutableStateFlow3;
        this.limitedLimit = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<List<FeaturePass>> MutableStateFlow4 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._availablePasses = MutableStateFlow4;
        this.availablePasses = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<FeaturePass> MutableStateFlow5 = StateFlowKt.MutableStateFlow(paymentRepository.getSelectedFeaturePass());
        this._selectedFeaturePass = MutableStateFlow5;
        this.selectedFeaturePass = FlowKt.asStateFlow(MutableStateFlow5);
        MutableStateFlow<Boolean> MutableStateFlow6 = StateFlowKt.MutableStateFlow(false);
        this._isLoadingPasses = MutableStateFlow6;
        this.isLoadingPasses = FlowKt.asStateFlow(MutableStateFlow6);
        MutableStateFlow<LoadingState> MutableStateFlow7 = StateFlowKt.MutableStateFlow(LoadingState.Idle.INSTANCE);
        this._loadingState = MutableStateFlow7;
        this.loadingState = FlowKt.asStateFlow(MutableStateFlow7);
        MutableStateFlow<String> MutableStateFlow8 = StateFlowKt.MutableStateFlow(null);
        this._errorMessage = MutableStateFlow8;
        this.errorMessage = MutableStateFlow8;
        observeActivePlans();
    }

    public final StateFlow<Feature> getCurrentFeatureCode() {
        return this.currentFeatureCode;
    }

    public final StateFlow<Long> getUnlimitedLimit() {
        return this.unlimitedLimit;
    }

    public final StateFlow<Long> getLimitedLimit() {
        return this.limitedLimit;
    }

    public final StateFlow<List<FeaturePass>> getAvailablePasses() {
        return this.availablePasses;
    }

    public final StateFlow<FeaturePass> getSelectedFeaturePass() {
        return this.selectedFeaturePass;
    }

    public final StateFlow<Boolean> isLoadingPasses() {
        return this.isLoadingPasses;
    }

    public final StateFlow<LoadingState> getLoadingState() {
        return this.loadingState;
    }

    public final StateFlow<String> getErrorMessage() {
        return this.errorMessage;
    }

    public static /* synthetic */ void setFeatureCode$default(SubscriptionsViewModel subscriptionsViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        subscriptionsViewModel.setFeatureCode(str, z);
    }

    public final void setFeatureCode(String code, boolean fetchPasses) {
        Intrinsics.checkNotNullParameter(code, "code");
        if (Intrinsics.areEqual(this._currentFeatureCode.getValue(), code)) {
            return;
        }
        this._currentFeatureCode.setValue(code);
        this._selectedFeaturePass.setValue(null);
        this.paymentRepository.setSelectedFeaturePass(null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07441(code, null), 3, null);
        if (fetchPasses) {
            fetchPassesAndLimits(code);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionsViewModel$setFeatureCode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SubscriptionsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionsViewModel$setFeatureCode$1", f = "SubscriptionsViewModel.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    static final class C07441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07441(String str, Continuation<? super C07441> continuation) {
            super(2, continuation);
            this.$code = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SubscriptionsViewModel.this.new C07441(this.$code, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = FlowKt.first(SubscriptionsViewModel.this.subscriptionRepository.getActivePlansFlow(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            SubscriptionsViewModel.this.updateFeatureLimits((List) obj, this.$code);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionsViewModel$startCountdownTimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SubscriptionsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionsViewModel$startCountdownTimer$1", f = "SubscriptionsViewModel.kt", i = {0}, l = {91}, m = "invokeSuspend", n = {"remainingTime"}, s = {"J$0"})
    static final class C07451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $limit;
        long J$0;
        int label;
        final /* synthetic */ SubscriptionsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07451(long j, SubscriptionsViewModel subscriptionsViewModel, Continuation<? super C07451> continuation) {
            super(2, continuation);
            this.$limit = j;
            this.this$0 = subscriptionsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07451(this.$limit, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            do {
                long jCurrentTimeMillis = this.$limit - System.currentTimeMillis();
                if (jCurrentTimeMillis <= 0) {
                    this.this$0._unlimitedLimit.setValue(Boxing.boxLong(0L));
                    return Unit.INSTANCE;
                }
                this.this$0._unlimitedLimit.setValue(Boxing.boxLong(jCurrentTimeMillis));
                this.J$0 = jCurrentTimeMillis;
                this.label = 1;
            } while (DelayKt.delay(1000L, this) != coroutine_suspended);
            return coroutine_suspended;
        }
    }

    private final void startCountdownTimer(long limit) {
        stopCountdownTimer();
        this.countdownJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07451(limit, this, null), 3, null);
    }

    private final void stopCountdownTimer() {
        Job job = this.countdownJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.countdownJob = null;
    }

    public final void setChosenPass(FeaturePass pass) {
        Intrinsics.checkNotNullParameter(pass, "pass");
        this.paymentRepository.setSelectedFeaturePass(pass);
        MutableStateFlow<FeaturePass> mutableStateFlow = this._selectedFeaturePass;
        if (Intrinsics.areEqual(mutableStateFlow.getValue(), pass)) {
            pass = null;
        }
        mutableStateFlow.setValue(pass);
    }

    public final void retryFetchPasses() {
        String value = this._currentFeatureCode.getValue();
        if (value != null) {
            fetchPassesAndLimits(value);
        } else {
            this._errorMessage.setValue("No feature selected. Please select a feature first.");
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionsViewModel$observeActivePlans$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SubscriptionsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionsViewModel$observeActivePlans$1", f = "SubscriptionsViewModel.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
    static final class C07431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07431(Continuation<? super C07431> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SubscriptionsViewModel.this.new C07431(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<List<Subscription>> activePlansFlow = SubscriptionsViewModel.this.subscriptionRepository.getActivePlansFlow();
                final SubscriptionsViewModel subscriptionsViewModel = SubscriptionsViewModel.this;
                this.label = 1;
                if (activePlansFlow.collect(new FlowCollector() { // from class: com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionsViewModel.observeActivePlans.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((List<Subscription>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(List<Subscription> list, Continuation<? super Unit> continuation) {
                        String str = (String) subscriptionsViewModel._currentFeatureCode.getValue();
                        if (str != null) {
                            subscriptionsViewModel.updateFeatureLimits(list, str);
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void observeActivePlans() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07431(null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionsViewModel$fetchPassesAndLimits$1, reason: invalid class name */
    /* JADX INFO: compiled from: SubscriptionsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionsViewModel$fetchPassesAndLimits$1", f = "SubscriptionsViewModel.kt", i = {1, 2}, l = {129, 135, 137}, m = "invokeSuspend", n = {"feature", "feature"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $featureCode;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$featureCode = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SubscriptionsViewModel.this.new AnonymousClass1(this.$featureCode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00b9, code lost:
        
            if (r11 == r0) goto L32;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            Feature feature;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            SubscriptionsViewModel.this._isLoadingPasses.setValue(Boxing.boxBoolean(true));
                            this.label = 1;
                            obj = SubscriptionsViewModel.this.featureRepository.fetchFeatureByCode(this.$featureCode, this);
                            if (obj == coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        if (i == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else if (i == 2) {
                            mutableStateFlow = (MutableStateFlow) this.L$1;
                            feature = (Feature) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            mutableStateFlow.setValue(obj);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(feature);
                            this.L$1 = null;
                            this.label = 3;
                            obj = FlowKt.first(SubscriptionsViewModel.this.subscriptionRepository.getActivePlansFlow(), this);
                        } else {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        SubscriptionsViewModel.this.updateFeatureLimits((List) obj, this.$featureCode);
                        SubscriptionsViewModel.this._isLoadingPasses.setValue(Boxing.boxBoolean(false));
                        return Unit.INSTANCE;
                        Feature feature2 = (Feature) obj;
                        if (feature2 != null) {
                            SubscriptionsViewModel.this._currentFeature.setValue(feature2);
                            SubscriptionsViewModel.this.paymentRepository.setSelectedFeature(feature2);
                            mutableStateFlow = SubscriptionsViewModel.this._availablePasses;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(feature2);
                            this.L$1 = mutableStateFlow;
                            this.label = 2;
                            Object passesForFeatureId = SubscriptionsViewModel.this.featurePassRepository.getPassesForFeatureId(feature2.getId(), this);
                            if (passesForFeatureId != coroutine_suspended) {
                                feature = feature2;
                                obj = passesForFeatureId;
                                mutableStateFlow.setValue(obj);
                                this.L$0 = SpillingKt.nullOutSpilledVariable(feature);
                                this.L$1 = null;
                                this.label = 3;
                                obj = FlowKt.first(SubscriptionsViewModel.this.subscriptionRepository.getActivePlansFlow(), this);
                            }
                            return coroutine_suspended;
                        }
                        throw new Exception("Feature not found.");
                    } catch (Exception e) {
                        MutableStateFlow mutableStateFlow2 = SubscriptionsViewModel.this._errorMessage;
                        String message = e.getMessage();
                        if (message == null) {
                            message = "An error occurred while loading passes.";
                        }
                        mutableStateFlow2.setValue(message);
                    }
                } catch (UnknownHostException unused) {
                    SubscriptionsViewModel.this._errorMessage.setValue("No internet connection. Please make sure your phone has active internet connection.");
                }
            } catch (Throwable th) {
                SubscriptionsViewModel.this._isLoadingPasses.setValue(Boxing.boxBoolean(false));
                throw th;
            }
        }
    }

    private final void fetchPassesAndLimits(String featureCode) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(featureCode, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFeatureLimits(List<Subscription> plans, String featureCode) {
        Object obj;
        Object next;
        List<Subscription> list = plans;
        Iterator<T> it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Subscription subscription = (Subscription) next;
            if (Intrinsics.areEqual(subscription.getFeatureCode(), featureCode) && subscription.getType() == SubscriptionType.UNLIMITED && !SubscriptionKt.isExpired(subscription)) {
                break;
            }
        }
        Subscription subscription2 = (Subscription) next;
        if (subscription2 != null) {
            startCountdownTimer(subscription2.getLimit());
        } else {
            stopCountdownTimer();
            this._unlimitedLimit.setValue(0L);
        }
        for (Object obj2 : list) {
            Subscription subscription3 = (Subscription) obj2;
            if (Intrinsics.areEqual(subscription3.getFeatureCode(), featureCode) && subscription3.getType() == SubscriptionType.LIMITED && subscription3.getLimit() > 0) {
                obj = obj2;
                break;
            }
        }
        Subscription subscription4 = (Subscription) obj;
        this._limitedLimit.setValue(Long.valueOf(subscription4 != null ? subscription4.getLimit() : 0L));
    }
}
