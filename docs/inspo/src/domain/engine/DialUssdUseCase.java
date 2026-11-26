package com.example.bingwahybrid.domain.engine;

import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.example.bingwahybrid.domain.engine.validation.TransactionValidator;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import com.example.bingwahybrid.domain.workers.ScheduleTransactionWorker;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialUssdUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B6\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0011\u0010\u0004\u001a\r\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0086B¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\r\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;", "", "context", "Landroid/content/Context;", "validators", "", "Lcom/example/bingwahybrid/domain/engine/validation/TransactionValidator;", "Lkotlin/jvm/JvmSuppressWildcards;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "updateTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;", "<init>", "(Landroid/content/Context;Ljava/util/Set;Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;)V", "invoke", "", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "time", "", "(Lcom/example/bingwahybrid/domain/model/Transaction;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runValidators", "", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DialUssdUseCase {
    public static final int $stable = 8;
    private final Context context;
    private final TransactionRepository transactionRepository;
    private final UpdateTransactionUseCase updateTransactionUseCase;
    private final Set<TransactionValidator> validators;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.DialUssdUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: DialUssdUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.DialUssdUseCase", f = "DialUssdUseCase.kt", i = {0, 0}, l = {33}, m = "invoke", n = {"transaction", "time"}, s = {"L$0", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
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
            return DialUssdUseCase.this.invoke(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.DialUssdUseCase$runValidators$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DialUssdUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.DialUssdUseCase", f = "DialUssdUseCase.kt", i = {0, 0, 1, 1, 1}, l = {67, 69}, m = "runValidators", n = {"transaction", "validator", "transaction", "validator", "result"}, s = {"L$0", "L$2", "L$0", "L$1", "L$2"})
    static final class C06721 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C06721(Continuation<? super C06721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DialUssdUseCase.this.runValidators(null, this);
        }
    }

    @Inject
    public DialUssdUseCase(@ApplicationContext Context context, Set<TransactionValidator> validators, TransactionRepository transactionRepository, UpdateTransactionUseCase updateTransactionUseCase) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(validators, "validators");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(updateTransactionUseCase, "updateTransactionUseCase");
        this.context = context;
        this.validators = validators;
        this.transactionRepository = transactionRepository;
        this.updateTransactionUseCase = updateTransactionUseCase;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object invoke(Transaction transaction, long j, Continuation<? super Unit> continuation) {
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
        Object objRunValidators = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objRunValidators);
                anonymousClass1.L$0 = transaction;
                anonymousClass1.J$0 = j;
                anonymousClass1.label = 1;
                objRunValidators = runValidators(transaction, anonymousClass1);
                if (objRunValidators == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = anonymousClass1.J$0;
                transaction = (Transaction) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objRunValidators);
            }
            if (!((Boolean) objRunValidators).booleanValue()) {
                return Unit.INSTANCE;
            }
            long jMax = Math.max(0L, j - System.currentTimeMillis());
            long millis = TimeUnit.SECONDS.toMillis(30L);
            if (0 <= jMax && jMax <= millis) {
                this.transactionRepository.addLiveTransaction(transaction);
                if (!this.transactionRepository.getOngoingTransactions().add(transaction.getId())) {
                    return Unit.INSTANCE;
                }
                this.transactionRepository.getTransactionQueue().add(transaction);
                if (!UssdDialerService.INSTANCE.isRunning()) {
                    ContextCompat.startForegroundService(this.context, new Intent(this.context, (Class<?>) UssdDialerService.class));
                }
            } else {
                OneTimeWorkRequest.Builder initialDelay = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) ScheduleTransactionWorker.class).setInputData(new Data.Builder().putString("transactionId", transaction.getId().toString()).build()).setInitialDelay(jMax, TimeUnit.MILLISECONDS);
                String string = transaction.getId().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                OneTimeWorkRequest oneTimeWorkRequestBuild = initialDelay.addTag(string).build();
                WorkManager companion = WorkManager.INSTANCE.getInstance(this.context);
                String string2 = transaction.getId().toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                companion.enqueueUniqueWork(string2, ExistingWorkPolicy.REPLACE, oneTimeWorkRequestBuild);
            }
            return Unit.INSTANCE;
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ Object invoke$default(DialUssdUseCase dialUssdUseCase, Transaction transaction, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = System.currentTimeMillis();
        }
        return dialUssdUseCase.invoke(transaction, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0069  */
    /* JADX WARN: Code duplicated, block: B:22:0x0082  */
    /* JADX WARN: Code duplicated, block: B:30:0x00db  */
    /* JADX WARN: Code duplicated, block: B:32:0x00df  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0082 -> B:23:0x0084). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object runValidators(com.example.bingwahybrid.domain.model.Transaction r32, kotlin.coroutines.Continuation<? super java.lang.Boolean> r33) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.domain.engine.DialUssdUseCase.runValidators(com.example.bingwahybrid.domain.model.Transaction, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
