package com.example.bingwahybrid.domain.usecase;

import android.util.Log;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetTransactionUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/GetTransactionUseCase;", "", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;)V", "invoke", "Lcom/example/bingwahybrid/domain/model/Transaction;", "transactionId", "Ljava/util/UUID;", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetTransactionUseCase {
    public static final int $stable = 8;
    private final TransactionRepository transactionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.GetTransactionUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetTransactionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.GetTransactionUseCase", f = "GetTransactionUseCase.kt", i = {0}, l = {16}, m = "invoke", n = {"transactionId"}, s = {"L$0"})
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
            return GetTransactionUseCase.this.invoke(null, this);
        }
    }

    @Inject
    public GetTransactionUseCase(TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        this.transactionRepository = transactionRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(UUID uuid, Continuation<? super Transaction> continuation) {
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
        Object transactionById = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(transactionById);
                TransactionRepository transactionRepository = this.transactionRepository;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(uuid);
                anonymousClass1.label = 1;
                transactionById = transactionRepository.getTransactionById(uuid, anonymousClass1);
                if (transactionById == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(transactionById);
            }
            Transaction transaction = (Transaction) transactionById;
            if (transaction != null) {
                return transaction;
            }
            throw new Exception("No transaction with the given ID was found");
        } catch (Exception e) {
            Log.e("GetTransactionUseCase", e.getMessage(), e);
            throw e;
        }
    }
}
