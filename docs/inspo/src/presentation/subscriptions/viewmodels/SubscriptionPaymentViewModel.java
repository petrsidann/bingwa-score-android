package com.example.bingwahybrid.presentation.subscriptions.viewmodels;

import android.util.Log;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.auth.models.Agent;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.enums.LoadingState;
import com.example.bingwahybrid.domain.enums.SubscriptionType;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.features.model.Feature;
import com.example.bingwahybrid.domain.features.model.FeaturePass;
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.repository.PaymentRepository;
import com.example.bingwahybrid.domain.sms.utils.SmsUtilsKt;
import com.example.bingwahybrid.domain.subscriptions.model.Subscription;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import com.example.bingwahybrid.domain.usecase.GetOrCreateCustomerUseCase;
import com.example.bingwahybrid.domain.usecase.ObserveTransactionStatusUseCase;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SubscriptionPaymentViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020,J\u0018\u0010*\u001a\u00020!2\u0006\u0010&\u001a\u00020%2\u0006\u0010.\u001a\u00020/H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0015¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0015¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020!0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020!0\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001b¨\u00060"}, d2 = {"Lcom/example/bingwahybrid/presentation/subscriptions/viewmodels/SubscriptionPaymentViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "paymentRepository", "Lcom/example/bingwahybrid/domain/repository/PaymentRepository;", "dialUssdUseCase", "Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;", "getOrCreateCustomerUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetOrCreateCustomerUseCase;", "subscriptionRepository", "Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "observeTransactionStatusUseCase", "Lcom/example/bingwahybrid/domain/usecase/ObserveTransactionStatusUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;Lcom/example/bingwahybrid/domain/repository/PaymentRepository;Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;Lcom/example/bingwahybrid/domain/usecase/GetOrCreateCustomerUseCase;Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;Lcom/example/bingwahybrid/domain/usecase/ObserveTransactionStatusUseCase;)V", "observeTransactionJob", "Lkotlinx/coroutines/Job;", "agent", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/bingwahybrid/domain/auth/models/Agent;", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "_loadingState", "Lcom/example/bingwahybrid/domain/enums/LoadingState;", "loadingState", "getLoadingState", "_errorMessage", "", "errorMessage", "getErrorMessage", "_featurePass", "Lcom/example/bingwahybrid/domain/features/model/FeaturePass;", "featurePass", "getFeaturePass", "_subscriptionMessage", "subscriptionMessage", "getSubscriptionMessage", "payWithAirtime", "", "resetSnackBarMessage", "updatedLimit", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SubscriptionPaymentViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _errorMessage;
    private final MutableStateFlow<FeaturePass> _featurePass;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<LoadingState> _loadingState;
    private final MutableStateFlow<String> _subscriptionMessage;
    private final StateFlow<Agent> agent;
    private final AuthRepository authRepository;
    private final DialUssdUseCase dialUssdUseCase;
    private final StateFlow<String> errorMessage;
    private final StateFlow<FeaturePass> featurePass;
    private final GetOrCreateCustomerUseCase getOrCreateCustomerUseCase;
    private final StateFlow<Boolean> isLoading;
    private final StateFlow<LoadingState> loadingState;
    private Job observeTransactionJob;
    private final ObserveTransactionStatusUseCase observeTransactionStatusUseCase;
    private final OfferRepository offerRepository;
    private final PaymentRepository paymentRepository;
    private final StateFlow<String> subscriptionMessage;
    private final SubscriptionRepository subscriptionRepository;

    /* JADX INFO: compiled from: SubscriptionPaymentViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SubscriptionType.values().length];
            try {
                iArr[SubscriptionType.LIMITED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public SubscriptionPaymentViewModel(AuthRepository authRepository, PaymentRepository paymentRepository, DialUssdUseCase dialUssdUseCase, GetOrCreateCustomerUseCase getOrCreateCustomerUseCase, SubscriptionRepository subscriptionRepository, OfferRepository offerRepository, ObserveTransactionStatusUseCase observeTransactionStatusUseCase) {
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(paymentRepository, "paymentRepository");
        Intrinsics.checkNotNullParameter(dialUssdUseCase, "dialUssdUseCase");
        Intrinsics.checkNotNullParameter(getOrCreateCustomerUseCase, "getOrCreateCustomerUseCase");
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        Intrinsics.checkNotNullParameter(observeTransactionStatusUseCase, "observeTransactionStatusUseCase");
        this.authRepository = authRepository;
        this.paymentRepository = paymentRepository;
        this.dialUssdUseCase = dialUssdUseCase;
        this.getOrCreateCustomerUseCase = getOrCreateCustomerUseCase;
        this.subscriptionRepository = subscriptionRepository;
        this.offerRepository = offerRepository;
        this.observeTransactionStatusUseCase = observeTransactionStatusUseCase;
        this.agent = authRepository.getAgent();
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow;
        this.isLoading = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<LoadingState> MutableStateFlow2 = StateFlowKt.MutableStateFlow(LoadingState.Idle.INSTANCE);
        this._loadingState = MutableStateFlow2;
        this.loadingState = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._errorMessage = MutableStateFlow3;
        this.errorMessage = MutableStateFlow3;
        MutableStateFlow<FeaturePass> MutableStateFlow4 = StateFlowKt.MutableStateFlow(paymentRepository.getSelectedFeaturePass());
        this._featurePass = MutableStateFlow4;
        this.featurePass = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<String> MutableStateFlow5 = StateFlowKt.MutableStateFlow("");
        this._subscriptionMessage = MutableStateFlow5;
        this.subscriptionMessage = MutableStateFlow5;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final StateFlow<LoadingState> getLoadingState() {
        return this.loadingState;
    }

    public final StateFlow<String> getErrorMessage() {
        return this.errorMessage;
    }

    public final StateFlow<FeaturePass> getFeaturePass() {
        return this.featurePass;
    }

    public final StateFlow<String> getSubscriptionMessage() {
        return this.subscriptionMessage;
    }

    public final void payWithAirtime() {
        FeaturePass value = this.featurePass.getValue();
        Feature selectedFeature = this.paymentRepository.getSelectedFeature();
        Agent value2 = this.agent.getValue();
        if (selectedFeature == null) {
            this._errorMessage.setValue("Please select a feature first");
            return;
        }
        if (value == null) {
            this._errorMessage.setValue("Please select a feature pass first");
        } else if (value2 != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(value, selectedFeature, null), 2, null);
        } else {
            this._errorMessage.setValue("You need to be logged in to renew subscription");
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionPaymentViewModel$payWithAirtime$1, reason: invalid class name */
    /* JADX INFO: compiled from: SubscriptionPaymentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionPaymentViewModel$payWithAirtime$1", f = "SubscriptionPaymentViewModel.kt", i = {1, 2, 2, 2, 2}, l = {89, 90, 99}, m = "invokeSuspend", n = {"adminPhone", "adminPhone", "customer", "subscriptionOffer", "subscriptionTransaction"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Feature $feature;
        final /* synthetic */ FeaturePass $featurePass;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FeaturePass featurePass, Feature feature, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$featurePass = featurePass;
            this.$feature = feature;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SubscriptionPaymentViewModel.this.new AnonymousClass1(this.$featurePass, this.$feature, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00ed  */
        /* JADX WARN: Code duplicated, block: B:31:0x00f6 A[Catch: Exception -> 0x0041, UnknownHostException -> 0x0155, TryCatch #2 {UnknownHostException -> 0x0155, Exception -> 0x0041, blocks: (B:8:0x0024, B:29:0x00ee, B:31:0x00f6, B:32:0x00f9, B:13:0x0035, B:25:0x0081, B:14:0x003b, B:22:0x0065, B:19:0x0047), top: B:41:0x000c }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object adminSubscriptionNumber;
            String str;
            Object objInvoke;
            Transaction transaction;
            Transaction transaction2;
            Job job;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        adminSubscriptionNumber = obj;
                    } else {
                        if (i == 2) {
                            str = (String) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            objInvoke = obj;
                            Customer customer = (Customer) objInvoke;
                            Offer offerCreateSubscriptionOffer = SubscriptionPaymentViewModel.this.offerRepository.createSubscriptionOffer(this.$featurePass.getPrice());
                            transaction = new Transaction(null, null, this.$featurePass.getPrice(), 0L, null, null, null, customer, offerCreateSubscriptionOffer, null, TransactionType.SUBSCRIPTION_RENEWAL, 0, 0, 0L, null, null, null, 129659, null);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(customer);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(offerCreateSubscriptionOffer);
                            this.L$3 = transaction;
                            this.label = 3;
                            if (DialUssdUseCase.invoke$default(SubscriptionPaymentViewModel.this.dialUssdUseCase, transaction, 0L, this, 2, null) != coroutine_suspended) {
                                transaction2 = transaction;
                            }
                            return coroutine_suspended;
                        }
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        transaction2 = (Transaction) this.L$3;
                        ResultKt.throwOnFailure(obj);
                    }
                    job = SubscriptionPaymentViewModel.this.observeTransactionJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    SubscriptionPaymentViewModel subscriptionPaymentViewModel = SubscriptionPaymentViewModel.this;
                    subscriptionPaymentViewModel.observeTransactionJob = FlowKt.launchIn(FlowKt.onEach(subscriptionPaymentViewModel.observeTransactionStatusUseCase.invoke(transaction2.getId()), new C01401(SubscriptionPaymentViewModel.this, this.$feature, this.$featurePass, null)), ViewModelKt.getViewModelScope(SubscriptionPaymentViewModel.this));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                SubscriptionPaymentViewModel.this._loadingState.setValue(LoadingState.Loading.INSTANCE);
                this.label = 1;
                adminSubscriptionNumber = SubscriptionPaymentViewModel.this.paymentRepository.getAdminSubscriptionNumber(this);
                if (adminSubscriptionNumber == coroutine_suspended) {
                }
                return coroutine_suspended;
                str = (String) adminSubscriptionNumber;
                this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                this.label = 2;
                objInvoke = SubscriptionPaymentViewModel.this.getOrCreateCustomerUseCase.invoke(str, "Admin", this);
                if (objInvoke != coroutine_suspended) {
                    Customer customer2 = (Customer) objInvoke;
                    Offer offerCreateSubscriptionOffer2 = SubscriptionPaymentViewModel.this.offerRepository.createSubscriptionOffer(this.$featurePass.getPrice());
                    transaction = new Transaction(null, null, this.$featurePass.getPrice(), 0L, null, null, null, customer2, offerCreateSubscriptionOffer2, null, TransactionType.SUBSCRIPTION_RENEWAL, 0, 0, 0L, null, null, null, 129659, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(customer2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(offerCreateSubscriptionOffer2);
                    this.L$3 = transaction;
                    this.label = 3;
                    if (DialUssdUseCase.invoke$default(SubscriptionPaymentViewModel.this.dialUssdUseCase, transaction, 0L, this, 2, null) != coroutine_suspended) {
                        transaction2 = transaction;
                        job = SubscriptionPaymentViewModel.this.observeTransactionJob;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        SubscriptionPaymentViewModel subscriptionPaymentViewModel2 = SubscriptionPaymentViewModel.this;
                        subscriptionPaymentViewModel2.observeTransactionJob = FlowKt.launchIn(FlowKt.onEach(subscriptionPaymentViewModel2.observeTransactionStatusUseCase.invoke(transaction2.getId()), new C01401(SubscriptionPaymentViewModel.this, this.$feature, this.$featurePass, null)), ViewModelKt.getViewModelScope(SubscriptionPaymentViewModel.this));
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            } catch (UnknownHostException unused) {
                Job job2 = SubscriptionPaymentViewModel.this.observeTransactionJob;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                SubscriptionPaymentViewModel.this._loadingState.setValue(new LoadingState.Failure("No internet connection. Please connect to the internet to complete your subscription."));
                SubscriptionPaymentViewModel.this._errorMessage.setValue("No internet connection. Please connect to the internet to complete your subscription.");
            } catch (Exception e) {
                Log.e("MakePaymentViewModel", e.toString());
                SubscriptionPaymentViewModel.this._loadingState.setValue(new LoadingState.Failure(String.valueOf(e.getMessage())));
                SubscriptionPaymentViewModel.this._errorMessage.setValue(e.getMessage());
            }
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionPaymentViewModel$payWithAirtime$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SubscriptionPaymentViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionPaymentViewModel$payWithAirtime$1$1", f = "SubscriptionPaymentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01401 extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends String>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Feature $feature;
            final /* synthetic */ FeaturePass $featurePass;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SubscriptionPaymentViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01401(SubscriptionPaymentViewModel subscriptionPaymentViewModel, Feature feature, FeaturePass featurePass, Continuation<? super C01401> continuation) {
                super(2, continuation);
                this.this$0 = subscriptionPaymentViewModel;
                this.$feature = feature;
                this.$featurePass = featurePass;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01401 c01401 = new C01401(this.this$0, this.$feature, this.$featurePass, continuation);
                c01401.L$0 = obj;
                return c01401;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Pair<? extends Boolean, ? extends String> pair, Continuation<? super Unit> continuation) {
                return invoke2((Pair<Boolean, String>) pair, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Pair<Boolean, String> pair, Continuation<? super Unit> continuation) {
                return ((C01401) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Pair pair = (Pair) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean zBooleanValue = ((Boolean) pair.component1()).booleanValue();
                    String str = (String) pair.component2();
                    if (zBooleanValue) {
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), Dispatchers.getIO(), null, new C01411(this.this$0, this.$feature, this.$featurePass, str, null), 2, null);
                    } else {
                        if (SmsUtilsKt.isInsufficientBalanceResponse(str)) {
                            str = "Insufficient airtime balance to complete your subscription";
                        }
                        this.this$0._errorMessage.setValue(str);
                        this.this$0._loadingState.setValue(new LoadingState.Failure(str));
                    }
                    Job job = this.this$0.observeTransactionJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionPaymentViewModel$payWithAirtime$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SubscriptionPaymentViewModel.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionPaymentViewModel$payWithAirtime$1$1$1", f = "SubscriptionPaymentViewModel.kt", i = {}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "invokeSuspend", n = {}, s = {})
            static final class C01411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Feature $feature;
                final /* synthetic */ FeaturePass $featurePass;
                final /* synthetic */ String $message;
                int label;
                final /* synthetic */ SubscriptionPaymentViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01411(SubscriptionPaymentViewModel subscriptionPaymentViewModel, Feature feature, FeaturePass featurePass, String str, Continuation<? super C01411> continuation) {
                    super(2, continuation);
                    this.this$0 = subscriptionPaymentViewModel;
                    this.$feature = feature;
                    this.$featurePass = featurePass;
                    this.$message = str;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01411(this.this$0, this.$feature, this.$featurePass, this.$message, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            obj = this.this$0.subscriptionRepository.subscribe(this.$feature, this.$featurePass, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        this.this$0._subscriptionMessage.setValue(this.this$0.getSubscriptionMessage(this.$featurePass, ((Subscription) obj).getLimit()));
                        this.this$0._loadingState.setValue(new LoadingState.Success(this.$message));
                    } catch (Exception e) {
                        Log.e("MakePaymentViewModel", String.valueOf(e.getMessage()));
                        this.this$0._errorMessage.setValue(e.getMessage());
                        this.this$0._loadingState.setValue(new LoadingState.Failure(String.valueOf(e.getMessage())));
                    }
                    return Unit.INSTANCE;
                }
            }
        }
    }

    public final void resetSnackBarMessage() {
        this._errorMessage.setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getSubscriptionMessage(FeaturePass featurePass, long updatedLimit) {
        if (WhenMappings.$EnumSwitchMapping$0[featurePass.getType().ordinal()] != 1) {
            return "Thank you for subscribing to " + featurePass.getName() + ". This plan will be active till " + new SimpleDateFormat("MMMM dd yyyy 'at' HH:mm:ss", Locale.getDefault()).format(new Date(updatedLimit));
        }
        return "Thank you for purchasing " + ((int) featurePass.getLimit()) + " token" + (((int) featurePass.getLimit()) > 1 ? "s" : "") + ". Your new token balance is " + updatedLimit + ".";
    }
}
