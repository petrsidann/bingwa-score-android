package com.example.bingwahybrid.presentation.viewmodel;

import androidx.autofill.HintConstants;
import androidx.compose.material.MenuKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.enums.RenewInterval;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.model.RescheduleInfo;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.usecase.CreateTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.GetOrCreateCustomerUseCase;
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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: AddAutoRenewTransactionViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0014J\u0016\u0010&\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020!J\u0018\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010\u000f2\u0006\u0010*\u001a\u00020+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/example/bingwahybrid/presentation/viewmodel/AddAutoRenewTransactionViewModel;", "Landroidx/lifecycle/ViewModel;", "dialUssdUseCase", "Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;", "createTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/CreateTransactionUseCase;", "getOrCreateCustomerUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetOrCreateCustomerUseCase;", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;Lcom/example/bingwahybrid/domain/usecase/CreateTransactionUseCase;Lcom/example/bingwahybrid/domain/usecase/GetOrCreateCustomerUseCase;Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;)V", "offers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "getOffers", "()Lkotlinx/coroutines/flow/StateFlow;", "_snackBarMessage", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "snackBarMessage", "getSnackBarMessage", "_customerPhone", "customerPhone", "getCustomerPhone", "_rescheduleSuccess", "", "rescheduleSuccess", "getRescheduleSuccess", "renewCount", "", "renewInterval", "Lcom/example/bingwahybrid/domain/enums/RenewInterval;", "resetSnackBarMessage", "", "onCustomerPhoneChanged", HintConstants.AUTOFILL_HINT_PHONE, "onAutoRenew", "interval", "scheduleTransaction", "offer", "time", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AddAutoRenewTransactionViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _customerPhone;
    private final MutableStateFlow<Boolean> _rescheduleSuccess;
    private final MutableStateFlow<String> _snackBarMessage;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final StateFlow<String> customerPhone;
    private final DialUssdUseCase dialUssdUseCase;
    private final GetOrCreateCustomerUseCase getOrCreateCustomerUseCase;
    private final OfferRepository offerRepository;
    private final StateFlow<List<Offer>> offers;
    private int renewCount;
    private RenewInterval renewInterval;
    private final StateFlow<Boolean> rescheduleSuccess;
    private final StateFlow<String> snackBarMessage;

    @Inject
    public AddAutoRenewTransactionViewModel(DialUssdUseCase dialUssdUseCase, CreateTransactionUseCase createTransactionUseCase, GetOrCreateCustomerUseCase getOrCreateCustomerUseCase, OfferRepository offerRepository) {
        Intrinsics.checkNotNullParameter(dialUssdUseCase, "dialUssdUseCase");
        Intrinsics.checkNotNullParameter(createTransactionUseCase, "createTransactionUseCase");
        Intrinsics.checkNotNullParameter(getOrCreateCustomerUseCase, "getOrCreateCustomerUseCase");
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        this.dialUssdUseCase = dialUssdUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.getOrCreateCustomerUseCase = getOrCreateCustomerUseCase;
        this.offerRepository = offerRepository;
        this.offers = FlowKt.stateIn(offerRepository.getOffers(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 500L, 0L, 2, null), CollectionsKt.emptyList());
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._snackBarMessage = MutableStateFlow;
        this.snackBarMessage = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow("");
        this._customerPhone = MutableStateFlow2;
        this.customerPhone = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._rescheduleSuccess = MutableStateFlow3;
        this.rescheduleSuccess = FlowKt.asStateFlow(MutableStateFlow3);
        this.renewInterval = RenewInterval.DAY;
    }

    public final StateFlow<List<Offer>> getOffers() {
        return this.offers;
    }

    public final StateFlow<String> getSnackBarMessage() {
        return this.snackBarMessage;
    }

    public final StateFlow<String> getCustomerPhone() {
        return this.customerPhone;
    }

    public final StateFlow<Boolean> getRescheduleSuccess() {
        return this.rescheduleSuccess;
    }

    public final void resetSnackBarMessage() {
        this._snackBarMessage.setValue(null);
    }

    public final void onCustomerPhoneChanged(String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        this._customerPhone.setValue(phone);
    }

    public final void onAutoRenew(int renewCount, RenewInterval interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        this.renewCount = renewCount;
        this.renewInterval = interval;
    }

    public final void scheduleTransaction(Offer offer, long time) {
        long jCurrentTimeMillis = time - System.currentTimeMillis();
        if (!StringsKt.isBlank(this.customerPhone.getValue())) {
            if (new Regex("^[0-9]{10,15}$").matches(this.customerPhone.getValue())) {
                if (offer == null) {
                    this._snackBarMessage.setValue("Please select an offer first");
                    return;
                }
                if (jCurrentTimeMillis < 0) {
                    this._snackBarMessage.setValue("You can only schedule to a future date");
                    return;
                } else {
                    if (this.renewCount == 0) {
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(offer, time, null), 3, null);
                        return;
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(time);
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(offer, calendar, null), 3, null);
                    return;
                }
            }
        }
        this._snackBarMessage.setValue("Please enter a valid phone number");
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.AddAutoRenewTransactionViewModel$scheduleTransaction$1, reason: invalid class name */
    /* JADX INFO: compiled from: AddAutoRenewTransactionViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.AddAutoRenewTransactionViewModel$scheduleTransaction$1", f = "AddAutoRenewTransactionViewModel.kt", i = {1, 1, 2, 2}, l = {85, 94, 95}, m = "invokeSuspend", n = {"customer", "transaction", "customer", "transaction"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Offer $offer;
        final /* synthetic */ long $time;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Offer offer, long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$offer = offer;
            this.$time = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AddAutoRenewTransactionViewModel.this.new AnonymousClass1(this.$offer, this.$time, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x00e6, code lost:
        
            if (r28.this$0.dialUssdUseCase.invoke(r2, r28.$time, r28) == r0) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objInvoke;
            Transaction transaction;
            Customer customer;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        objInvoke = obj;
                    } else if (i == 2) {
                        transaction = (Transaction) this.L$1;
                        customer = (Customer) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(customer);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(transaction);
                        this.label = 3;
                    } else {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    AddAutoRenewTransactionViewModel.this._rescheduleSuccess.setValue(Boxing.boxBoolean(true));
                    AddAutoRenewTransactionViewModel.this._snackBarMessage.setValue("Offer scheduled successfully");
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objInvoke = AddAutoRenewTransactionViewModel.this.getOrCreateCustomerUseCase.invoke(AddAutoRenewTransactionViewModel.this.getCustomerPhone().getValue(), AddAutoRenewTransactionViewModel.this.getCustomerPhone().getValue(), this);
                if (objInvoke == coroutine_suspended) {
                }
                return coroutine_suspended;
                Customer customer2 = (Customer) objInvoke;
                UUID uuid = null;
                String str = null;
                long j = 0;
                String str2 = null;
                Integer num = null;
                TransactionType transactionType = null;
                int i2 = 0;
                int i3 = 0;
                long j2 = 0;
                Long l = null;
                Long l2 = null;
                Transaction transaction2 = new Transaction(uuid, str, this.$offer.getPrice(), j, "Unavailable: Reason= Scheduled transaction", str2, TransactionStatus.RESCHEDULED, customer2, this.$offer, num, transactionType, i2, i3, j2, l, new RescheduleInfo(null, this.$time, null, 5, null), l2, 97835, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(customer2);
                this.L$1 = transaction2;
                this.label = 2;
                if (AddAutoRenewTransactionViewModel.this.createTransactionUseCase.invoke(transaction2, this) != coroutine_suspended) {
                    transaction = transaction2;
                    customer = customer2;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(customer);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(transaction);
                    this.label = 3;
                }
                return coroutine_suspended;
            } catch (Exception e) {
                AddAutoRenewTransactionViewModel.this._rescheduleSuccess.setValue(Boxing.boxBoolean(false));
                AddAutoRenewTransactionViewModel.this._snackBarMessage.setValue(e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.AddAutoRenewTransactionViewModel$scheduleTransaction$2, reason: invalid class name */
    /* JADX INFO: compiled from: AddAutoRenewTransactionViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.AddAutoRenewTransactionViewModel$scheduleTransaction$2", f = "AddAutoRenewTransactionViewModel.kt", i = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {110, MenuKt.InTransitionDuration, 139, 140}, m = "invokeSuspend", n = {"customer", "parentTransaction", "customer", "parentTransaction", "scheduledTransaction", "i", "customer", "parentTransaction", "scheduledTransaction", "i"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Calendar $calendar;
        final /* synthetic */ Offer $offer;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.AddAutoRenewTransactionViewModel$scheduleTransaction$2$WhenMappings */
        /* JADX INFO: compiled from: AddAutoRenewTransactionViewModel.kt */
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
        AnonymousClass2(Offer offer, Calendar calendar, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$offer = offer;
            this.$calendar = calendar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AddAutoRenewTransactionViewModel.this.new AnonymousClass2(this.$offer, this.$calendar, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:32:0x00f2 A[Catch: Exception -> 0x0065, TRY_LEAVE, TryCatch #1 {Exception -> 0x0065, blocks: (B:9:0x0026, B:32:0x00f2, B:14:0x004a, B:17:0x005a, B:30:0x00e6, B:18:0x005f, B:26:0x0098, B:23:0x006d), top: B:62:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:36:0x016d  */
        /* JADX WARN: Code duplicated, block: B:37:0x016e  */
        /* JADX WARN: Code duplicated, block: B:41:0x0199  */
        /* JADX WARN: Code duplicated, block: B:44:0x01ae  */
        /* JADX WARN: Code duplicated, block: B:46:0x01b1  */
        /* JADX WARN: Code duplicated, block: B:48:0x01b4 A[Catch: Exception -> 0x01dc, TryCatch #0 {Exception -> 0x01dc, blocks: (B:42:0x019d, B:48:0x01b4, B:52:0x01d3, B:34:0x0118, B:38:0x0172, B:55:0x01de, B:49:0x01ba, B:50:0x01c1, B:51:0x01ca), top: B:60:0x019d }] */
        /* JADX WARN: Code duplicated, block: B:49:0x01ba A[Catch: Exception -> 0x01dc, TryCatch #0 {Exception -> 0x01dc, blocks: (B:42:0x019d, B:48:0x01b4, B:52:0x01d3, B:34:0x0118, B:38:0x0172, B:55:0x01de, B:49:0x01ba, B:50:0x01c1, B:51:0x01ca), top: B:60:0x019d }] */
        /* JADX WARN: Code duplicated, block: B:50:0x01c1 A[Catch: Exception -> 0x01dc, TryCatch #0 {Exception -> 0x01dc, blocks: (B:42:0x019d, B:48:0x01b4, B:52:0x01d3, B:34:0x0118, B:38:0x0172, B:55:0x01de, B:49:0x01ba, B:50:0x01c1, B:51:0x01ca), top: B:60:0x019d }] */
        /* JADX WARN: Code duplicated, block: B:51:0x01ca A[Catch: Exception -> 0x01dc, TryCatch #0 {Exception -> 0x01dc, blocks: (B:42:0x019d, B:48:0x01b4, B:52:0x01d3, B:34:0x0118, B:38:0x0172, B:55:0x01de, B:49:0x01ba, B:50:0x01c1, B:51:0x01ca), top: B:60:0x019d }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0199 -> B:60:0x019d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r34) {
            /*
                Method dump skipped, instruction units count: 536
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.presentation.viewmodel.AddAutoRenewTransactionViewModel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
