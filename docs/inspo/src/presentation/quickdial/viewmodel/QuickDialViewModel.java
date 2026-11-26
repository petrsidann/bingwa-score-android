package com.example.bingwahybrid.presentation.quickdial.viewmodel;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.autofill.HintConstants;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.usecase.CreateTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.GetCustomersUseCase;
import com.example.bingwahybrid.domain.usecase.GetOrCreateCustomerUseCase;
import com.example.bingwahybrid.domain.usecase.ObserveTransactionStatusUseCase;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: QuickDialViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u001aJ\u000e\u00103\u001a\u0002012\u0006\u00104\u001a\u00020\u001eJ\u0006\u00105\u001a\u000201J\b\u00106\u001a\u000201H\u0002J\u0006\u00107\u001a\u000201J\u0006\u00108\u001a\u000201R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00140\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0013¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0013¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0\u0013¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0016\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0017R\u0016\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0013¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0017¨\u00069"}, d2 = {"Lcom/example/bingwahybrid/presentation/quickdial/viewmodel/QuickDialViewModel;", "Landroidx/lifecycle/ViewModel;", "dialUssdUseCase", "Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;", "getCustomersUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetCustomersUseCase;", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "getOrCreateCustomerUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetOrCreateCustomerUseCase;", "createTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/CreateTransactionUseCase;", "observeTransactionStatusUseCase", "Lcom/example/bingwahybrid/domain/usecase/ObserveTransactionStatusUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;Lcom/example/bingwahybrid/domain/usecase/GetCustomersUseCase;Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;Lcom/example/bingwahybrid/domain/usecase/GetOrCreateCustomerUseCase;Lcom/example/bingwahybrid/domain/usecase/CreateTransactionUseCase;Lcom/example/bingwahybrid/domain/usecase/ObserveTransactionStatusUseCase;)V", "observeTransactionJob", "Lkotlinx/coroutines/Job;", "customers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/bingwahybrid/domain/model/Customer;", "getCustomers", "()Lkotlinx/coroutines/flow/StateFlow;", "_offers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "offers", "getOffers", "_customerPhone", "", "customerPhone", "getCustomerPhone", "_isDialing", "", "isDialing", "_errorMessage", "errorMessage", "getErrorMessage", "_ussdDialSuccess", "ussdDialSuccess", "getUssdDialSuccess", "_selectedOffer", "selectedOffer", "getSelectedOffer", "_ussdResponse", "ussdResponse", "getUssdResponse", "onSelectOffer", "", "offer", "onCustomerPhoneChanged", HintConstants.AUTOFILL_HINT_PHONE, "dial", "loadOffers", "resetSnackBarMessage", "resetUssdResponse", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class QuickDialViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _customerPhone;
    private final MutableStateFlow<String> _errorMessage;
    private final MutableStateFlow<Boolean> _isDialing;
    private final MutableStateFlow<List<Offer>> _offers;
    private final MutableStateFlow<Offer> _selectedOffer;
    private final MutableStateFlow<Boolean> _ussdDialSuccess;
    private final MutableStateFlow<String> _ussdResponse;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final StateFlow<String> customerPhone;
    private final StateFlow<List<Customer>> customers;
    private final DialUssdUseCase dialUssdUseCase;
    private final StateFlow<String> errorMessage;
    private final GetCustomersUseCase getCustomersUseCase;
    private final GetOrCreateCustomerUseCase getOrCreateCustomerUseCase;
    private final StateFlow<Boolean> isDialing;
    private Job observeTransactionJob;
    private final ObserveTransactionStatusUseCase observeTransactionStatusUseCase;
    private final OfferRepository offerRepository;
    private final StateFlow<List<Offer>> offers;
    private final StateFlow<Offer> selectedOffer;
    private final StateFlow<Boolean> ussdDialSuccess;
    private final StateFlow<String> ussdResponse;

    @Inject
    public QuickDialViewModel(DialUssdUseCase dialUssdUseCase, GetCustomersUseCase getCustomersUseCase, OfferRepository offerRepository, GetOrCreateCustomerUseCase getOrCreateCustomerUseCase, CreateTransactionUseCase createTransactionUseCase, ObserveTransactionStatusUseCase observeTransactionStatusUseCase) {
        Intrinsics.checkNotNullParameter(dialUssdUseCase, "dialUssdUseCase");
        Intrinsics.checkNotNullParameter(getCustomersUseCase, "getCustomersUseCase");
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        Intrinsics.checkNotNullParameter(getOrCreateCustomerUseCase, "getOrCreateCustomerUseCase");
        Intrinsics.checkNotNullParameter(createTransactionUseCase, "createTransactionUseCase");
        Intrinsics.checkNotNullParameter(observeTransactionStatusUseCase, "observeTransactionStatusUseCase");
        this.dialUssdUseCase = dialUssdUseCase;
        this.getCustomersUseCase = getCustomersUseCase;
        this.offerRepository = offerRepository;
        this.getOrCreateCustomerUseCase = getOrCreateCustomerUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.observeTransactionStatusUseCase = observeTransactionStatusUseCase;
        this.customers = getCustomersUseCase.getCustomer();
        MutableStateFlow<List<Offer>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._offers = MutableStateFlow;
        this.offers = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow("");
        this._customerPhone = MutableStateFlow2;
        this.customerPhone = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._isDialing = MutableStateFlow3;
        this.isDialing = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<String> MutableStateFlow4 = StateFlowKt.MutableStateFlow(null);
        this._errorMessage = MutableStateFlow4;
        this.errorMessage = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<Boolean> MutableStateFlow5 = StateFlowKt.MutableStateFlow(false);
        this._ussdDialSuccess = MutableStateFlow5;
        this.ussdDialSuccess = FlowKt.asStateFlow(MutableStateFlow5);
        MutableStateFlow<Offer> MutableStateFlow6 = StateFlowKt.MutableStateFlow(null);
        this._selectedOffer = MutableStateFlow6;
        this.selectedOffer = MutableStateFlow6;
        MutableStateFlow<String> MutableStateFlow7 = StateFlowKt.MutableStateFlow(null);
        this._ussdResponse = MutableStateFlow7;
        this.ussdResponse = MutableStateFlow7;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    public final StateFlow<List<Customer>> getCustomers() {
        return this.customers;
    }

    public final StateFlow<List<Offer>> getOffers() {
        return this.offers;
    }

    public final StateFlow<String> getCustomerPhone() {
        return this.customerPhone;
    }

    public final StateFlow<Boolean> isDialing() {
        return this.isDialing;
    }

    public final StateFlow<String> getErrorMessage() {
        return this.errorMessage;
    }

    public final StateFlow<Boolean> getUssdDialSuccess() {
        return this.ussdDialSuccess;
    }

    public final StateFlow<Offer> getSelectedOffer() {
        return this.selectedOffer;
    }

    public final StateFlow<String> getUssdResponse() {
        return this.ussdResponse;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.quickdial.viewmodel.QuickDialViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: QuickDialViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.quickdial.viewmodel.QuickDialViewModel$1", f = "QuickDialViewModel.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return QuickDialViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (QuickDialViewModel.this.getCustomersUseCase.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            QuickDialViewModel.this.loadOffers();
            return Unit.INSTANCE;
        }
    }

    public final void onSelectOffer(Offer offer) {
        this._selectedOffer.setValue(offer);
    }

    public final void onCustomerPhoneChanged(String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        this._customerPhone.setValue(phone);
    }

    public final void dial() {
        if (this._isDialing.getValue().booleanValue()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07271(null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.quickdial.viewmodel.QuickDialViewModel$dial$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: QuickDialViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.quickdial.viewmodel.QuickDialViewModel$dial$1", f = "QuickDialViewModel.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {98, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 129}, m = "invokeSuspend", n = {"customerPhone", "selectedOffer", "customerPhone", "selectedOffer", "customer", "transaction", "customerPhone", "selectedOffer", "customer", "transaction"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    static final class C07271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        C07271(Continuation<? super C07271> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return QuickDialViewModel.this.new C07271(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:34:0x0145 A[Catch: Exception -> 0x01ba, TryCatch #0 {Exception -> 0x01ba, blocks: (B:8:0x0027, B:13:0x0044, B:32:0x011a, B:34:0x0145, B:35:0x0148, B:16:0x0052, B:28:0x00b9, B:19:0x005e, B:21:0x0092, B:24:0x009c, B:38:0x01a2, B:39:0x01a9, B:40:0x01aa, B:41:0x01b1, B:42:0x01b2, B:43:0x01b9), top: B:51:0x000f }] */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x019f, code lost:
        
            if (com.example.bingwahybrid.domain.engine.DialUssdUseCase.invoke$default(r32.this$0.dialUssdUseCase, r12, 0, r32, 2, null) == r2) goto L37;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            String str;
            Object objInvoke;
            Offer offer;
            String str2;
            Transaction transaction;
            Customer customer;
            Offer offer2;
            Job job;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    str = "0" + StringsKt.takeLast((String) QuickDialViewModel.this._customerPhone.getValue(), 9);
                    Offer offer3 = (Offer) QuickDialViewModel.this._selectedOffer.getValue();
                    if (str.length() == 0) {
                        throw new Exception("Customer phone cannot be empty");
                    }
                    if (str.length() < 10) {
                        throw new Exception("Phone number too short");
                    }
                    if (offer3 != null) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        this.L$1 = offer3;
                        this.label = 1;
                        objInvoke = QuickDialViewModel.this.getOrCreateCustomerUseCase.invoke(str, str, this);
                        if (objInvoke != coroutine_suspended) {
                            offer = offer3;
                        }
                        return coroutine_suspended;
                    }
                    throw new Exception("You have not selected any offer");
                }
                if (i == 1) {
                    Offer offer4 = (Offer) this.L$1;
                    String str3 = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objInvoke = obj;
                    offer = offer4;
                    str = str3;
                } else if (i == 2) {
                    Transaction transaction2 = (Transaction) this.L$3;
                    customer = (Customer) this.L$2;
                    offer2 = (Offer) this.L$1;
                    str2 = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    transaction = transaction2;
                    QuickDialViewModel.this._ussdDialSuccess.setValue(Boxing.boxBoolean(false));
                    QuickDialViewModel.this._isDialing.setValue(Boxing.boxBoolean(true));
                    QuickDialViewModel.this._ussdResponse.setValue(null);
                    job = QuickDialViewModel.this.observeTransactionJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    QuickDialViewModel quickDialViewModel = QuickDialViewModel.this;
                    quickDialViewModel.observeTransactionJob = FlowKt.launchIn(FlowKt.onEach(quickDialViewModel.observeTransactionStatusUseCase.invoke(transaction.getId()), new C01361(QuickDialViewModel.this, null)), ViewModelKt.getViewModelScope(QuickDialViewModel.this));
                    this.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(offer2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(customer);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(transaction);
                    this.label = 3;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
                Customer customer2 = (Customer) objInvoke;
                UUID uuidRandomUUID = UUID.randomUUID();
                Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID(...)");
                Transaction transaction3 = new Transaction(uuidRandomUUID, null, offer.getPrice(), 0L, "Unavailable: Reason - QuickDial", null, null, customer2, offer, null, TransactionType.QUICK_DIAL, 0, 0, 0L, null, null, null, 129642, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                this.L$1 = SpillingKt.nullOutSpilledVariable(offer);
                this.L$2 = SpillingKt.nullOutSpilledVariable(customer2);
                this.L$3 = transaction3;
                this.label = 2;
                if (QuickDialViewModel.this.createTransactionUseCase.invoke(transaction3, this) != coroutine_suspended) {
                    str2 = str;
                    transaction = transaction3;
                    customer = customer2;
                    offer2 = offer;
                    QuickDialViewModel.this._ussdDialSuccess.setValue(Boxing.boxBoolean(false));
                    QuickDialViewModel.this._isDialing.setValue(Boxing.boxBoolean(true));
                    QuickDialViewModel.this._ussdResponse.setValue(null);
                    job = QuickDialViewModel.this.observeTransactionJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    QuickDialViewModel quickDialViewModel2 = QuickDialViewModel.this;
                    quickDialViewModel2.observeTransactionJob = FlowKt.launchIn(FlowKt.onEach(quickDialViewModel2.observeTransactionStatusUseCase.invoke(transaction.getId()), new C01361(QuickDialViewModel.this, null)), ViewModelKt.getViewModelScope(QuickDialViewModel.this));
                    this.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(offer2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(customer);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(transaction);
                    this.label = 3;
                }
                return coroutine_suspended;
            } catch (Exception e) {
                Job job2 = QuickDialViewModel.this.observeTransactionJob;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                QuickDialViewModel.this._ussdDialSuccess.setValue(Boxing.boxBoolean(false));
                QuickDialViewModel.this._isDialing.setValue(Boxing.boxBoolean(false));
                QuickDialViewModel.this._errorMessage.setValue(e.getMessage());
            }
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.quickdial.viewmodel.QuickDialViewModel$dial$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: QuickDialViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.quickdial.viewmodel.QuickDialViewModel$dial$1$1", f = "QuickDialViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01361 extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends String>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ QuickDialViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01361(QuickDialViewModel quickDialViewModel, Continuation<? super C01361> continuation) {
                super(2, continuation);
                this.this$0 = quickDialViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01361 c01361 = new C01361(this.this$0, continuation);
                c01361.L$0 = obj;
                return c01361;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Pair<? extends Boolean, ? extends String> pair, Continuation<? super Unit> continuation) {
                return invoke2((Pair<Boolean, String>) pair, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Pair<Boolean, String> pair, Continuation<? super Unit> continuation) {
                return ((C01361) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Pair pair = (Pair) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean zBooleanValue = ((Boolean) pair.component1()).booleanValue();
                    String str = (String) pair.component2();
                    this.this$0._isDialing.setValue(Boxing.boxBoolean(false));
                    this.this$0._ussdDialSuccess.setValue(Boxing.boxBoolean(zBooleanValue));
                    this.this$0._ussdResponse.setValue(str);
                    if (zBooleanValue) {
                        this.this$0._customerPhone.setValue("");
                        this.this$0._selectedOffer.setValue(null);
                    }
                    Job job = this.this$0.observeTransactionJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.quickdial.viewmodel.QuickDialViewModel$loadOffers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: QuickDialViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.quickdial.viewmodel.QuickDialViewModel$loadOffers$1", f = "QuickDialViewModel.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    static final class C07281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07281(Continuation<? super C07281> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return QuickDialViewModel.this.new C07281(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = QuickDialViewModel.this.offerRepository.getAllOffers(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                QuickDialViewModel.this._offers.setValue((List) obj);
            } catch (Exception e) {
                QuickDialViewModel.this._errorMessage.setValue(e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadOffers() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07281(null), 2, null);
    }

    public final void resetSnackBarMessage() {
        this._errorMessage.setValue(null);
    }

    public final void resetUssdResponse() {
        this._ussdResponse.setValue(null);
    }
}
