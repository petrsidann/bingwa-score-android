package com.example.bingwahybrid.domain.usecase;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.portal.events.TransactionEvent;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
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

/* JADX INFO: compiled from: CreateTransactionUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086B¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/CreateTransactionUseCase;", "", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "customerRepository", "Lcom/example/bingwahybrid/domain/repository/CustomerRepository;", "transactionRelay", "Lcom/example/bingwahybrid/domain/portal/TransactionRelay;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/repository/CustomerRepository;Lcom/example/bingwahybrid/domain/portal/TransactionRelay;)V", "invoke", "Lcom/example/bingwahybrid/domain/model/Transaction;", "transaction", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastPurchaseTime", "", "customer", "Lcom/example/bingwahybrid/domain/model/Customer;", "(Lcom/example/bingwahybrid/domain/model/Customer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateTransactionUseCase {
    public static final int $stable = 8;
    private final CustomerRepository customerRepository;
    private final TransactionRelay transactionRelay;
    private final TransactionRepository transactionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.CreateTransactionUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateTransactionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.CreateTransactionUseCase", f = "CreateTransactionUseCase.kt", i = {0, 1, 2, 2}, l = {21, 22, 25}, m = "invoke", n = {"transaction", "transaction", "transaction", NotificationCompat.CATEGORY_EVENT}, s = {"L$0", "L$0", "L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateTransactionUseCase.this.invoke(null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.CreateTransactionUseCase$updateLastPurchaseTime$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CreateTransactionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.CreateTransactionUseCase", f = "CreateTransactionUseCase.kt", i = {0}, l = {35}, m = "updateLastPurchaseTime", n = {"customer"}, s = {"L$0"})
    static final class C06891 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06891(Continuation<? super C06891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateTransactionUseCase.this.updateLastPurchaseTime(null, this);
        }
    }

    @Inject
    public CreateTransactionUseCase(TransactionRepository transactionRepository, CustomerRepository customerRepository, TransactionRelay transactionRelay) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        Intrinsics.checkNotNullParameter(transactionRelay, "transactionRelay");
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
        this.transactionRelay = transactionRelay;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(Transaction transaction, Continuation<? super Transaction> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        TransactionRelay transactionRelay;
        TransactionEvent.New r2;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TransactionRepository transactionRepository = this.transactionRepository;
                anonymousClass1.L$0 = transaction;
                anonymousClass1.label = 1;
                if (transactionRepository.createTransaction(transaction, anonymousClass1) == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                transaction = (Transaction) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Transaction transaction2 = (Transaction) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return transaction2;
                }
                transaction = (Transaction) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            TransactionEvent.New r8 = new TransactionEvent.New(transaction);
            transactionRelay = this.transactionRelay;
            r2 = r8;
            anonymousClass1.L$0 = transaction;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(r8);
            anonymousClass1.label = 3;
            if (transactionRelay.send(r2, anonymousClass1) != coroutine_suspended) {
                return coroutine_suspended;
            }
            return transaction;
            Customer customer = transaction.getCustomer();
            anonymousClass1.L$0 = transaction;
            anonymousClass1.label = 2;
            if (updateLastPurchaseTime(customer, anonymousClass1) != coroutine_suspended) {
                TransactionEvent.New r9 = new TransactionEvent.New(transaction);
                transactionRelay = this.transactionRelay;
                r2 = r9;
                anonymousClass1.L$0 = transaction;
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(r9);
                anonymousClass1.label = 3;
                if (transactionRelay.send(r2, anonymousClass1) != coroutine_suspended) {
                    return transaction;
                }
            }
            return coroutine_suspended;
        } catch (Exception e) {
            Log.e("CreateTransactionUseCase", e.getMessage(), e);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateLastPurchaseTime(Customer customer, Continuation<? super Unit> continuation) throws Exception {
        C06891 c06891;
        if (continuation instanceof C06891) {
            c06891 = (C06891) continuation;
            if ((c06891.label & Integer.MIN_VALUE) != 0) {
                c06891.label -= Integer.MIN_VALUE;
            } else {
                c06891 = new C06891(continuation);
            }
        } else {
            c06891 = new C06891(continuation);
        }
        Object obj = c06891.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06891.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CustomerRepository customerRepository = this.customerRepository;
                long jCurrentTimeMillis = System.currentTimeMillis();
                c06891.L$0 = SpillingKt.nullOutSpilledVariable(customer);
                c06891.label = 1;
                if (customerRepository.updateLastPurchaseTime(customer, jCurrentTimeMillis, c06891) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        } catch (Exception e) {
            Log.e("CreateTransactionUseCase", e.getMessage(), e);
            throw e;
        }
    }
}
