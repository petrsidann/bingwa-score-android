package com.example.bingwahybrid.domain.usecase;

import android.content.Context;
import androidx.core.view.MotionEventCompat;
import androidx.work.WorkManager;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteTransactionUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0086B¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/DeleteTransactionUseCase;", "", "context", "Landroid/content/Context;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "transactionRelay", "Lcom/example/bingwahybrid/domain/portal/TransactionRelay;", "<init>", "(Landroid/content/Context;Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/portal/TransactionRelay;)V", "invoke", "", "transactionId", "Ljava/util/UUID;", "softDelete", "", "(Ljava/util/UUID;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelScheduledTransactionWork", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeleteTransactionUseCase {
    public static final int $stable = 8;
    private final Context context;
    private final TransactionRelay transactionRelay;
    private final TransactionRepository transactionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.DeleteTransactionUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeleteTransactionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.DeleteTransactionUseCase", f = "DeleteTransactionUseCase.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5}, l = {25, 31, 32, 35, MotionEventCompat.AXIS_GENERIC_11, 48}, m = "invoke", n = {"transactionId", "softDelete", "transactionId", "transaction", "softDelete", "transactionId", "transaction", "softDelete", "transactionId", "transaction", "childTransactions", "$this$forEach$iv", "element$iv", "trans", "softDelete", "$i$f$forEach", "$i$a$-forEach-DeleteTransactionUseCase$invoke$2", "transactionId", "transaction", "softDelete", "transactionId", "transaction", "deleteEvent", "softDelete"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "Z$0", "I$0", "I$1", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeleteTransactionUseCase.this.invoke(null, false, this);
        }
    }

    @Inject
    public DeleteTransactionUseCase(Context context, TransactionRepository transactionRepository, TransactionRelay transactionRelay) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(transactionRelay, "transactionRelay");
        this.context = context;
        this.transactionRepository = transactionRepository;
        this.transactionRelay = transactionRelay;
    }

    public static /* synthetic */ Object invoke$default(DeleteTransactionUseCase deleteTransactionUseCase, UUID uuid, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return deleteTransactionUseCase.invoke(uuid, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0114 A[Catch: Exception -> 0x01db, TryCatch #0 {Exception -> 0x01db, blocks: (B:13:0x0041, B:16:0x0050, B:57:0x018b, B:19:0x0075, B:51:0x0150, B:46:0x010e, B:48:0x0114, B:54:0x016a, B:22:0x0084, B:45:0x00fd, B:25:0x0093, B:42:0x00e6, B:28:0x009d, B:34:0x00bc, B:36:0x00c0, B:38:0x00c8, B:62:0x01d3, B:63:0x01da, B:31:0x00a9), top: B:67:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x014e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0150 A[Catch: Exception -> 0x01db, PHI: r1 r5 r7 r8 r9 r10 r11 r12
  0x0150: PHI (r1v17 int) = (r1v15 int), (r1v19 int) binds: [B:49:0x014c, B:19:0x0075] A[DONT_GENERATE, DONT_INLINE]
  0x0150: PHI (r5v18 boolean) = (r5v16 boolean), (r5v19 boolean) binds: [B:49:0x014c, B:19:0x0075] A[DONT_GENERATE, DONT_INLINE]
  0x0150: PHI (r7v17 com.example.bingwahybrid.domain.model.Transaction) = (r7v16 com.example.bingwahybrid.domain.model.Transaction), (r7v20 com.example.bingwahybrid.domain.model.Transaction) binds: [B:49:0x014c, B:19:0x0075] A[DONT_GENERATE, DONT_INLINE]
  0x0150: PHI (r8v8 java.util.Iterator) = (r8v7 java.util.Iterator), (r8v11 java.util.Iterator) binds: [B:49:0x014c, B:19:0x0075] A[DONT_GENERATE, DONT_INLINE]
  0x0150: PHI (r9v3 java.lang.Iterable) = (r9v2 java.lang.Iterable), (r9v5 java.lang.Iterable) binds: [B:49:0x014c, B:19:0x0075] A[DONT_GENERATE, DONT_INLINE]
  0x0150: PHI (r10v3 java.util.List) = (r10v2 java.util.List), (r10v5 java.util.List) binds: [B:49:0x014c, B:19:0x0075] A[DONT_GENERATE, DONT_INLINE]
  0x0150: PHI (r11v2 com.example.bingwahybrid.domain.model.Transaction) = (r11v1 com.example.bingwahybrid.domain.model.Transaction), (r11v4 com.example.bingwahybrid.domain.model.Transaction) binds: [B:49:0x014c, B:19:0x0075] A[DONT_GENERATE, DONT_INLINE]
  0x0150: PHI (r12v2 java.util.UUID) = (r12v1 java.util.UUID), (r12v4 java.util.UUID) binds: [B:49:0x014c, B:19:0x0075] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x01db, blocks: (B:13:0x0041, B:16:0x0050, B:57:0x018b, B:19:0x0075, B:51:0x0150, B:46:0x010e, B:48:0x0114, B:54:0x016a, B:22:0x0084, B:45:0x00fd, B:25:0x0093, B:42:0x00e6, B:28:0x009d, B:34:0x00bc, B:36:0x00c0, B:38:0x00c8, B:62:0x01d3, B:63:0x01da, B:31:0x00a9), top: B:67:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x014c -> B:51:0x0150). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object invoke(java.util.UUID r18, boolean r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instruction units count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.domain.usecase.DeleteTransactionUseCase.invoke(java.util.UUID, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$1(UUID uuid, Transaction transaction) {
        return Intrinsics.areEqual(transaction.getId(), uuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$2(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    private final void cancelScheduledTransactionWork(UUID transactionId) {
        WorkManager companion = WorkManager.INSTANCE.getInstance(this.context);
        String string = transactionId.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        companion.cancelAllWorkByTag(string);
    }
}
