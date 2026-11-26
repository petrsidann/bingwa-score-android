package com.example.bingwahybrid.domain.workers;

import android.content.Context;
import android.util.Log;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.example.bingwahybrid.data.di.WorkerEntryPoint;
import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.hilt.android.EntryPointAccessors;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ScheduleTransactionWorker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/example/bingwahybrid/domain/workers/ScheduleTransactionWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "dialUssdUseCase", "Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScheduleTransactionWorker extends CoroutineWorker {
    public static final String TRANSACTION_ID = "transactionId";
    private final DialUssdUseCase dialUssdUseCase;
    private final TransactionRepository transactionRepository;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.workers.ScheduleTransactionWorker$doWork$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScheduleTransactionWorker.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.workers.ScheduleTransactionWorker", f = "ScheduleTransactionWorker.kt", i = {0}, l = {36}, m = "doWork", n = {"transactionId"}, s = {"L$0"})
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
            return ScheduleTransactionWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScheduleTransactionWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        WorkerEntryPoint workerEntryPoint = (WorkerEntryPoint) EntryPointAccessors.fromApplication(context, WorkerEntryPoint.class);
        this.transactionRepository = workerEntryPoint.transactionRepository();
        this.dialUssdUseCase = workerEntryPoint.dialUssdUseCase();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
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
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            String string = getInputData().getString("transactionId");
            if (string != null) {
                CoroutineDispatcher io2 = Dispatchers.getIO();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(string, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(string);
                anonymousClass1.label = 1;
                objWithContext = BuildersKt.withContext(io2, anonymousClass2, anonymousClass1);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
                Intrinsics.checkNotNull(resultFailure);
                return resultFailure;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        Intrinsics.checkNotNull(objWithContext);
        return (ListenableWorker.Result) objWithContext;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.workers.ScheduleTransactionWorker$doWork$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScheduleTransactionWorker.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f0\u0001¢\u0006\u0002\b\u0002¢\u0006\u0002\b\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "Lorg/jspecify/annotations/NonNull;", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.workers.ScheduleTransactionWorker$doWork$2", f = "ScheduleTransactionWorker.kt", i = {1}, l = {37, 39}, m = "invokeSuspend", n = {"transaction"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
        final /* synthetic */ String $transactionId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$transactionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScheduleTransactionWorker.this.new AnonymousClass2(this.$transactionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0060, code lost:
        
            if (com.example.bingwahybrid.domain.engine.DialUssdUseCase.invoke$default(r10.this$0.dialUssdUseCase, r4, 0, r10, 2, null) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TransactionRepository transactionRepository = ScheduleTransactionWorker.this.transactionRepository;
                UUID uuidFromString = UUID.fromString(this.$transactionId);
                Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
                this.label = 1;
                obj = transactionRepository.getTransactionById(uuidFromString, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ListenableWorker.Result.success();
            Transaction transaction = (Transaction) obj;
            if (transaction == null) {
                Log.d("ScheduleTransactionWorker", "Transaction seems to have been deleted");
                return ListenableWorker.Result.failure();
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(transaction);
            this.label = 2;
        }
    }
}
