package com.example.bingwahybrid.presentation.transactions.viewmodel;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.enums.RenewInterval;
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.usecase.CreateTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.GetTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.RescheduleTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: RescheduleTransactionViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010'\u001a\u00020(J\u0016\u0010)\u001a\u00020(2\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020&J\u000e\u0010\u001a\u001a\u00020(2\u0006\u0010+\u001a\u00020\u001cJ\"\u0010,\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010\u00182\b\u0010.\u001a\u0004\u0018\u00010\u00132\u0006\u0010/\u001a\u000200R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/example/bingwahybrid/presentation/transactions/viewmodel/RescheduleTransactionViewModel;", "Landroidx/lifecycle/ViewModel;", "dialUssdUseCase", "Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;", "getTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetTransactionUseCase;", "createTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/CreateTransactionUseCase;", "updateTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;", "rescheduleTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/RescheduleTransactionUseCase;", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;Lcom/example/bingwahybrid/domain/usecase/GetTransactionUseCase;Lcom/example/bingwahybrid/domain/usecase/CreateTransactionUseCase;Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;Lcom/example/bingwahybrid/domain/usecase/RescheduleTransactionUseCase;Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;)V", "offers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "getOffers", "()Lkotlinx/coroutines/flow/StateFlow;", "_transaction", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bingwahybrid/domain/model/Transaction;", "transaction", "getTransaction", "_snackBarMessage", "", "snackBarMessage", "getSnackBarMessage", "_rescheduleSuccess", "", "rescheduleSuccess", "getRescheduleSuccess", "renewCount", "", "renewInterval", "Lcom/example/bingwahybrid/domain/enums/RenewInterval;", "resetSnackBarMessage", "", "onAutoRenew", "interval", "transactionId", "rescheduleTransaction", "originalTransaction", "newOffer", "time", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RescheduleTransactionViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> _rescheduleSuccess;
    private final MutableStateFlow<String> _snackBarMessage;
    private final MutableStateFlow<Transaction> _transaction;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final DialUssdUseCase dialUssdUseCase;
    private final GetTransactionUseCase getTransactionUseCase;
    private final OfferRepository offerRepository;
    private final StateFlow<List<Offer>> offers;
    private int renewCount;
    private RenewInterval renewInterval;
    private final StateFlow<Boolean> rescheduleSuccess;
    private final RescheduleTransactionUseCase rescheduleTransactionUseCase;
    private final StateFlow<String> snackBarMessage;
    private final StateFlow<Transaction> transaction;
    private final UpdateTransactionUseCase updateTransactionUseCase;

    @Inject
    public RescheduleTransactionViewModel(DialUssdUseCase dialUssdUseCase, GetTransactionUseCase getTransactionUseCase, CreateTransactionUseCase createTransactionUseCase, UpdateTransactionUseCase updateTransactionUseCase, RescheduleTransactionUseCase rescheduleTransactionUseCase, OfferRepository offerRepository) {
        Intrinsics.checkNotNullParameter(dialUssdUseCase, "dialUssdUseCase");
        Intrinsics.checkNotNullParameter(getTransactionUseCase, "getTransactionUseCase");
        Intrinsics.checkNotNullParameter(createTransactionUseCase, "createTransactionUseCase");
        Intrinsics.checkNotNullParameter(updateTransactionUseCase, "updateTransactionUseCase");
        Intrinsics.checkNotNullParameter(rescheduleTransactionUseCase, "rescheduleTransactionUseCase");
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        this.dialUssdUseCase = dialUssdUseCase;
        this.getTransactionUseCase = getTransactionUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.updateTransactionUseCase = updateTransactionUseCase;
        this.rescheduleTransactionUseCase = rescheduleTransactionUseCase;
        this.offerRepository = offerRepository;
        this.offers = FlowKt.stateIn(offerRepository.getOffers(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), CollectionsKt.emptyList());
        MutableStateFlow<Transaction> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._transaction = MutableStateFlow;
        this.transaction = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._snackBarMessage = MutableStateFlow2;
        this.snackBarMessage = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._rescheduleSuccess = MutableStateFlow3;
        this.rescheduleSuccess = FlowKt.asStateFlow(MutableStateFlow3);
        this.renewInterval = RenewInterval.DAY;
    }

    public final StateFlow<List<Offer>> getOffers() {
        return this.offers;
    }

    public final StateFlow<Transaction> getTransaction() {
        return this.transaction;
    }

    public final StateFlow<String> getSnackBarMessage() {
        return this.snackBarMessage;
    }

    public final StateFlow<Boolean> getRescheduleSuccess() {
        return this.rescheduleSuccess;
    }

    public final void resetSnackBarMessage() {
        this._snackBarMessage.setValue(null);
    }

    public final void onAutoRenew(int renewCount, RenewInterval interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        this.renewCount = renewCount;
        this.renewInterval = interval;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.RescheduleTransactionViewModel$getTransaction$1, reason: invalid class name */
    /* JADX INFO: compiled from: RescheduleTransactionViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.RescheduleTransactionViewModel$getTransaction$1", f = "RescheduleTransactionViewModel.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $transactionId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$transactionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RescheduleTransactionViewModel.this.new AnonymousClass1(this.$transactionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow mutableStateFlow2 = RescheduleTransactionViewModel.this._transaction;
                    GetTransactionUseCase getTransactionUseCase = RescheduleTransactionViewModel.this.getTransactionUseCase;
                    UUID uuidFromString = UUID.fromString(this.$transactionId);
                    Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
                    this.L$0 = mutableStateFlow2;
                    this.label = 1;
                    Object objInvoke = getTransactionUseCase.invoke(uuidFromString, this);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableStateFlow = mutableStateFlow2;
                    obj = objInvoke;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutableStateFlow = (MutableStateFlow) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                mutableStateFlow.setValue(obj);
            } catch (Exception e) {
                RescheduleTransactionViewModel.this._snackBarMessage.setValue(e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    public final void getTransaction(String transactionId) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(transactionId, null), 3, null);
    }

    public final void rescheduleTransaction(Transaction originalTransaction, Offer newOffer, long time) {
        long jCurrentTimeMillis = time - System.currentTimeMillis();
        if (originalTransaction == null) {
            this._snackBarMessage.setValue("Original transaction not found. Please go back and try again");
            return;
        }
        if (newOffer == null) {
            this._snackBarMessage.setValue("Please select an offer first");
            return;
        }
        if (jCurrentTimeMillis < 0) {
            this._snackBarMessage.setValue("You can only reschedule to a future date");
            return;
        }
        Customer customer = originalTransaction.getCustomer();
        if (this.renewCount == 0) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07461(originalTransaction, time, newOffer, null), 3, null);
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(newOffer, originalTransaction, customer, calendar, null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.RescheduleTransactionViewModel$rescheduleTransaction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RescheduleTransactionViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.RescheduleTransactionViewModel$rescheduleTransaction$1", f = "RescheduleTransactionViewModel.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    static final class C07461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Offer $newOffer;
        final /* synthetic */ Transaction $originalTransaction;
        final /* synthetic */ long $time;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07461(Transaction transaction, long j, Offer offer, Continuation<? super C07461> continuation) {
            super(2, continuation);
            this.$originalTransaction = transaction;
            this.$time = j;
            this.$newOffer = offer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RescheduleTransactionViewModel.this.new C07461(this.$originalTransaction, this.$time, this.$newOffer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (RescheduleTransactionUseCase.invoke$default(RescheduleTransactionViewModel.this.rescheduleTransactionUseCase, this.$originalTransaction, this.$time, this.$newOffer, null, false, this, 24, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                RescheduleTransactionViewModel.this._rescheduleSuccess.setValue(Boxing.boxBoolean(true));
                RescheduleTransactionViewModel.this._snackBarMessage.setValue("Offer rescheduled successfully");
            } catch (Exception e) {
                RescheduleTransactionViewModel.this._rescheduleSuccess.setValue(Boxing.boxBoolean(false));
                RescheduleTransactionViewModel.this._snackBarMessage.setValue(e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.RescheduleTransactionViewModel$rescheduleTransaction$2, reason: invalid class name */
    /* JADX INFO: compiled from: RescheduleTransactionViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.RescheduleTransactionViewModel$rescheduleTransaction$2", f = "RescheduleTransactionViewModel.kt", i = {0, 0, 1, 1}, l = {132, 133, 145}, m = "invokeSuspend", n = {"scheduledTransaction", "i", "scheduledTransaction", "i"}, s = {"L$0", "I$0", "L$0", "I$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Calendar $calendar;
        final /* synthetic */ Customer $customer;
        final /* synthetic */ Offer $newOffer;
        final /* synthetic */ Transaction $originalTransaction;
        int I$0;
        int I$1;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.RescheduleTransactionViewModel$rescheduleTransaction$2$WhenMappings */
        /* JADX INFO: compiled from: RescheduleTransactionViewModel.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RenewInterval.values().length];
                try {
                    iArr[RenewInterval.MINUTE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RenewInterval.HOUR.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RenewInterval.DAY.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Offer offer, Transaction transaction, Customer customer, Calendar calendar, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$newOffer = offer;
            this.$originalTransaction = transaction;
            this.$customer = customer;
            this.$calendar = calendar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RescheduleTransactionViewModel.this.new AnonymousClass2(this.$newOffer, this.$originalTransaction, this.$customer, this.$calendar, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0051 A[Catch: Exception -> 0x001a, TRY_LEAVE, TryCatch #1 {Exception -> 0x001a, blocks: (B:7:0x0013, B:14:0x002f, B:22:0x0051, B:17:0x003e, B:20:0x0048), top: B:52:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:26:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:27:0x00ca A[Catch: Exception -> 0x017f, PHI: r2 r7 r8 r30
  0x00ca: PHI (r2v5 int) = (r2v6 int), (r2v13 int) binds: [B:25:0x00c6, B:18:0x0041] A[DONT_GENERATE, DONT_INLINE]
  0x00ca: PHI (r7v1 int) = (r7v2 int), (r7v6 int) binds: [B:25:0x00c6, B:18:0x0041] A[DONT_GENERATE, DONT_INLINE]
  0x00ca: PHI (r8v0 com.example.bingwahybrid.domain.model.Transaction) = (r8v3 com.example.bingwahybrid.domain.model.Transaction), (r8v5 com.example.bingwahybrid.domain.model.Transaction) binds: [B:25:0x00c6, B:18:0x0041] A[DONT_GENERATE, DONT_INLINE]
  0x00ca: PHI (r30v2 boolean) = (r30v4 boolean), (r30v8 boolean) binds: [B:25:0x00c6, B:18:0x0041] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x017f, blocks: (B:44:0x0164, B:30:0x00ee, B:36:0x0105, B:40:0x0122, B:24:0x0076, B:27:0x00ca, B:41:0x0128, B:37:0x010b, B:38:0x0112, B:39:0x011a), top: B:50:0x00ee }] */
        /* JADX WARN: Code duplicated, block: B:29:0x00ec  */
        /* JADX WARN: Code duplicated, block: B:32:0x00ff  */
        /* JADX WARN: Code duplicated, block: B:34:0x0102  */
        /* JADX WARN: Code duplicated, block: B:36:0x0105 A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:44:0x0164, B:30:0x00ee, B:36:0x0105, B:40:0x0122, B:24:0x0076, B:27:0x00ca, B:41:0x0128, B:37:0x010b, B:38:0x0112, B:39:0x011a), top: B:50:0x00ee }] */
        /* JADX WARN: Code duplicated, block: B:37:0x010b A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:44:0x0164, B:30:0x00ee, B:36:0x0105, B:40:0x0122, B:24:0x0076, B:27:0x00ca, B:41:0x0128, B:37:0x010b, B:38:0x0112, B:39:0x011a), top: B:50:0x00ee }] */
        /* JADX WARN: Code duplicated, block: B:38:0x0112 A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:44:0x0164, B:30:0x00ee, B:36:0x0105, B:40:0x0122, B:24:0x0076, B:27:0x00ca, B:41:0x0128, B:37:0x010b, B:38:0x0112, B:39:0x011a), top: B:50:0x00ee }] */
        /* JADX WARN: Code duplicated, block: B:39:0x011a A[Catch: Exception -> 0x017f, TryCatch #0 {Exception -> 0x017f, blocks: (B:44:0x0164, B:30:0x00ee, B:36:0x0105, B:40:0x0122, B:24:0x0076, B:27:0x00ca, B:41:0x0128, B:37:0x010b, B:38:0x0112, B:39:0x011a), top: B:50:0x00ee }] */
        /* JADX WARN: Code duplicated, block: B:50:0x00ee A[EXC_TOP_SPLITTER, PHI: r2 r7 r30
  0x00ee: PHI (r2v10 int) = (r2v5 int), (r2v14 int) binds: [B:28:0x00ea, B:15:0x0032] A[DONT_GENERATE, DONT_INLINE]
  0x00ee: PHI (r7v4 int) = (r7v1 int), (r7v7 int) binds: [B:28:0x00ea, B:15:0x0032] A[DONT_GENERATE, DONT_INLINE]
  0x00ee: PHI (r30v5 boolean) = (r30v2 boolean), (r30v9 boolean) binds: [B:28:0x00ea, B:15:0x0032] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00ea -> B:50:0x00ee). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r33) {
            /*
                Method dump skipped, instruction units count: 413
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.presentation.transactions.viewmodel.RescheduleTransactionViewModel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
