package com.example.bingwahybrid.domain.sms.usecases;

import androidx.core.app.NotificationCompat;
import com.example.bingwahybrid.domain.enums.SmsType;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.portal.events.TransactionEvent;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.sms.model.SmsMessage;
import com.example.bingwahybrid.domain.sms.utils.SmsUtilsKt;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateSmsTransactionUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086B¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/usecases/CreateSmsTransactionUseCase;", "", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "customerRepository", "Lcom/example/bingwahybrid/domain/repository/CustomerRepository;", "transactionRelay", "Lcom/example/bingwahybrid/domain/portal/TransactionRelay;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/repository/CustomerRepository;Lcom/example/bingwahybrid/domain/portal/TransactionRelay;)V", "invoke", "Lcom/example/bingwahybrid/domain/model/Transaction;", "customer", "Lcom/example/bingwahybrid/domain/model/Customer;", "offer", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "sms", "Lcom/example/bingwahybrid/domain/sms/model/SmsMessage;", "(Lcom/example/bingwahybrid/domain/model/Customer;Lcom/example/bingwahybrid/domain/offers/model/Offer;Lcom/example/bingwahybrid/domain/sms/model/SmsMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastPurchaseTime", "", "(Lcom/example/bingwahybrid/domain/model/Customer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateSmsTransactionUseCase {
    public static final int $stable = 8;
    private final CustomerRepository customerRepository;
    private final TransactionRelay transactionRelay;
    private final TransactionRepository transactionRepository;

    /* JADX INFO: compiled from: CreateSmsTransactionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SmsType.values().length];
            try {
                iArr[SmsType.MPESA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SmsType.TILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SmsType.PAY_BILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SmsType.SITE_LINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.sms.usecases.CreateSmsTransactionUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateSmsTransactionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.sms.usecases.CreateSmsTransactionUseCase", f = "CreateSmsTransactionUseCase.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {26, 51, 52, 55}, m = "invoke", n = {"customer", "offer", "sms", "customer", "offer", "sms", "existingMpesaTransaction", "transactionType", "transaction", "customer", "offer", "sms", "existingMpesaTransaction", "transactionType", "transaction", "customer", "offer", "sms", "existingMpesaTransaction", "transactionType", "transaction", NotificationCompat.CATEGORY_EVENT}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateSmsTransactionUseCase.this.invoke(null, null, null, this);
        }
    }

    @Inject
    public CreateSmsTransactionUseCase(TransactionRepository transactionRepository, CustomerRepository customerRepository, TransactionRelay transactionRelay) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        Intrinsics.checkNotNullParameter(transactionRelay, "transactionRelay");
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
        this.transactionRelay = transactionRelay;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:58:0x01eb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object invoke(Customer customer, Offer offer, SmsMessage smsMessage, Continuation<? super Transaction> continuation) {
        AnonymousClass1 anonymousClass1;
        Customer customer2;
        Offer offer2;
        SmsMessage smsMessage2;
        Transaction transaction;
        TransactionType transactionType;
        Customer customer3;
        SmsMessage smsMessage3;
        Transaction transaction2;
        Offer offer3;
        TransactionType transactionType2;
        Customer customer4;
        Transaction transaction3;
        TransactionRelay transactionRelay;
        TransactionEvent.New r11;
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
        Object transactionByMpesaCode = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(transactionByMpesaCode);
            TransactionRepository transactionRepository = this.transactionRepository;
            String mpesaCode = smsMessage.getMpesaCode();
            anonymousClass1.L$0 = customer;
            anonymousClass1.L$1 = offer;
            anonymousClass1.L$2 = smsMessage;
            anonymousClass1.label = 1;
            transactionByMpesaCode = transactionRepository.getTransactionByMpesaCode(mpesaCode, anonymousClass1);
            if (transactionByMpesaCode != coroutine_suspended) {
                customer2 = customer;
                offer2 = offer;
                smsMessage2 = smsMessage;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            smsMessage2 = (SmsMessage) anonymousClass1.L$2;
            Offer offer4 = (Offer) anonymousClass1.L$1;
            Customer customer5 = (Customer) anonymousClass1.L$0;
            ResultKt.throwOnFailure(transactionByMpesaCode);
            offer2 = offer4;
            customer2 = customer5;
        } else {
            if (i == 2) {
                transaction2 = (Transaction) anonymousClass1.L$5;
                transactionType2 = (TransactionType) anonymousClass1.L$4;
                Transaction transaction4 = (Transaction) anonymousClass1.L$3;
                SmsMessage smsMessage4 = (SmsMessage) anonymousClass1.L$2;
                Offer offer5 = (Offer) anonymousClass1.L$1;
                customer3 = (Customer) anonymousClass1.L$0;
                ResultKt.throwOnFailure(transactionByMpesaCode);
                transaction = transaction4;
                smsMessage3 = smsMessage4;
                offer3 = offer5;
                customer4 = customer3;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(customer4);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(offer3);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(smsMessage3);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(transaction);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(transactionType2);
                anonymousClass1.L$5 = transaction2;
                anonymousClass1.label = 3;
                if (updateLastPurchaseTime(customer4, anonymousClass1) != coroutine_suspended) {
                    transaction3 = transaction;
                }
                return coroutine_suspended;
            }
            if (i != 3) {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Transaction transaction5 = (Transaction) anonymousClass1.L$5;
                ResultKt.throwOnFailure(transactionByMpesaCode);
                return transaction5;
            }
            transaction2 = (Transaction) anonymousClass1.L$5;
            transactionType2 = (TransactionType) anonymousClass1.L$4;
            transaction3 = (Transaction) anonymousClass1.L$3;
            smsMessage3 = (SmsMessage) anonymousClass1.L$2;
            offer3 = (Offer) anonymousClass1.L$1;
            customer4 = (Customer) anonymousClass1.L$0;
            ResultKt.throwOnFailure(transactionByMpesaCode);
        }
        TransactionEvent.New r1 = new TransactionEvent.New(transaction2);
        transactionRelay = this.transactionRelay;
        r11 = r1;
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(customer4);
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(offer3);
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(smsMessage3);
        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(transaction3);
        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(transactionType2);
        anonymousClass1.L$5 = transaction2;
        anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(r1);
        anonymousClass1.label = 4;
        if (transactionRelay.send(r11, anonymousClass1) != coroutine_suspended) {
            return coroutine_suspended;
        }
        return transaction2;
        transaction = (Transaction) transactionByMpesaCode;
        if (transaction != null) {
            throw new Exception("Cannot process transaction. Existing transaction with same M-Pesa code exists");
        }
        SmsType smsType = SmsUtilsKt.getSmsType(smsMessage2.getMessage());
        int i2 = WhenMappings.$EnumSwitchMapping$0[smsType.ordinal()];
        if (i2 == 1) {
            transactionType = TransactionType.MPESA;
        } else if (i2 == 2) {
            transactionType = TransactionType.TILL;
        } else if (i2 == 3) {
            transactionType = TransactionType.PAY_BILL;
        } else if (i2 == 4) {
            transactionType = TransactionType.SITE_LINK;
        } else {
            throw new Exception("Cannot create transaction from sms type: " + smsType.name());
        }
        TransactionType transactionType3 = transactionType;
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID(...)");
        Transaction transaction6 = new Transaction(uuidRandomUUID, smsMessage2.getMpesaCode(), offer2 != null ? offer2.getPrice() : smsMessage2.getAmount(), smsMessage2.getTime(), smsMessage2.getMessage(), "", offer2 == null ? TransactionStatus.UNMATCHED : TransactionStatus.SCHEDULED, customer2, offer2, null, transactionType3, 0, 0, 0L, null, null, null, 129536, null);
        customer3 = customer2;
        TransactionRepository transactionRepository2 = this.transactionRepository;
        anonymousClass1.L$0 = customer3;
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(offer2);
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(smsMessage2);
        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(transaction);
        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(transactionType3);
        anonymousClass1.L$5 = transaction6;
        anonymousClass1.label = 2;
        if (transactionRepository2.createTransaction(transaction6, anonymousClass1) != coroutine_suspended) {
            smsMessage3 = smsMessage2;
            transaction2 = transaction6;
            offer3 = offer2;
            transactionType2 = transactionType3;
            customer4 = customer3;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(customer4);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(offer3);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(smsMessage3);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(transaction);
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(transactionType2);
            anonymousClass1.L$5 = transaction2;
            anonymousClass1.label = 3;
            if (updateLastPurchaseTime(customer4, anonymousClass1) != coroutine_suspended) {
                transaction3 = transaction;
                TransactionEvent.New r2 = new TransactionEvent.New(transaction2);
                transactionRelay = this.transactionRelay;
                r11 = r2;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(customer4);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(offer3);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(smsMessage3);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(transaction3);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(transactionType2);
                anonymousClass1.L$5 = transaction2;
                anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(r2);
                anonymousClass1.label = 4;
                if (transactionRelay.send(r11, anonymousClass1) != coroutine_suspended) {
                    return transaction2;
                }
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateLastPurchaseTime(Customer customer, Continuation<? super Unit> continuation) {
        Object objUpdateLastPurchaseTime = this.customerRepository.updateLastPurchaseTime(customer, System.currentTimeMillis(), continuation);
        return objUpdateLastPurchaseTime == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateLastPurchaseTime : Unit.INSTANCE;
    }
}
