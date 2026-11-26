package com.example.bingwahybrid.domain.transactions.usecase;

import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetLastBingwaTransactionForCustomerUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/transactions/usecase/GetLastBingwaTransactionForCustomerUseCase;", "", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;)V", "invoke", "Lcom/example/bingwahybrid/domain/model/Transaction;", "customer", "Lcom/example/bingwahybrid/domain/model/Customer;", "(Lcom/example/bingwahybrid/domain/model/Customer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetLastBingwaTransactionForCustomerUseCase {
    public static final int $stable = 8;
    private final TransactionRepository transactionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.transactions.usecase.GetLastBingwaTransactionForCustomerUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetLastBingwaTransactionForCustomerUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.transactions.usecase.GetLastBingwaTransactionForCustomerUseCase", f = "GetLastBingwaTransactionForCustomerUseCase.kt", i = {0}, l = {13}, m = "invoke", n = {"customer"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetLastBingwaTransactionForCustomerUseCase.this.invoke(null, this);
        }
    }

    @Inject
    public GetLastBingwaTransactionForCustomerUseCase(TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        this.transactionRepository = transactionRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(Customer customer, Continuation<? super Transaction> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        TransactionRepository transactionRepository = this.transactionRepository;
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(customer);
        anonymousClass1.label = 1;
        Object lastBingwaTransactionForCustomer = transactionRepository.getLastBingwaTransactionForCustomer(customer, anonymousClass1);
        return lastBingwaTransactionForCustomer == coroutine_suspended ? coroutine_suspended : lastBingwaTransactionForCustomer;
    }
}
