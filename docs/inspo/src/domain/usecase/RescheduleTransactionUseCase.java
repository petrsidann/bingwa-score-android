package com.example.bingwahybrid.domain.usecase;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.view.MotionEventCompat;
import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.RescheduleInfo;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.portal.events.TransactionEvent;
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

/* JADX INFO: compiled from: RescheduleTransactionUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ@\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0086B¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/RescheduleTransactionUseCase;", "", "createTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/CreateTransactionUseCase;", "deleteTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/DeleteTransactionUseCase;", "dialUssdUseCase", "Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "transactionRelay", "Lcom/example/bingwahybrid/domain/portal/TransactionRelay;", "<init>", "(Lcom/example/bingwahybrid/domain/usecase/CreateTransactionUseCase;Lcom/example/bingwahybrid/domain/usecase/DeleteTransactionUseCase;Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/portal/TransactionRelay;)V", "invoke", "Lcom/example/bingwahybrid/domain/model/Transaction;", "originalTransaction", "time", "", "newOffer", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "reason", "", "incrementExternalRetries", "", "(Lcom/example/bingwahybrid/domain/model/Transaction;JLcom/example/bingwahybrid/domain/offers/model/Offer;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RescheduleTransactionUseCase {
    public static final int $stable = 8;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final DeleteTransactionUseCase deleteTransactionUseCase;
    private final DialUssdUseCase dialUssdUseCase;
    private final TransactionRelay transactionRelay;
    private final TransactionRepository transactionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.RescheduleTransactionUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: RescheduleTransactionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.RescheduleTransactionUseCase", f = "RescheduleTransactionUseCase.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4}, l = {MotionEventCompat.AXIS_GENERIC_16, 48, 50, 56, 64}, m = "invoke", n = {"originalTransaction", "newOffer", "reason", "rescheduleMessage", "scheduledTransaction", "time", "incrementExternalRetries", "originalTransaction", "newOffer", "reason", "rescheduleMessage", "scheduledTransaction", "time", "incrementExternalRetries", "originalTransaction", "newOffer", "reason", "rescheduleMessage", "scheduledTransaction", "time", "incrementExternalRetries", "originalTransaction", "newOffer", "reason", "rescheduleMessage", "scheduledTransaction", "time", "incrementExternalRetries", "originalTransaction", "newOffer", "reason", "rescheduleMessage", "scheduledTransaction", NotificationCompat.CATEGORY_EVENT, "time", "incrementExternalRetries"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "Z$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
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
            return RescheduleTransactionUseCase.this.invoke(null, 0L, null, null, false, this);
        }
    }

    @Inject
    public RescheduleTransactionUseCase(CreateTransactionUseCase createTransactionUseCase, DeleteTransactionUseCase deleteTransactionUseCase, DialUssdUseCase dialUssdUseCase, TransactionRepository transactionRepository, TransactionRelay transactionRelay) {
        Intrinsics.checkNotNullParameter(createTransactionUseCase, "createTransactionUseCase");
        Intrinsics.checkNotNullParameter(deleteTransactionUseCase, "deleteTransactionUseCase");
        Intrinsics.checkNotNullParameter(dialUssdUseCase, "dialUssdUseCase");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(transactionRelay, "transactionRelay");
        this.createTransactionUseCase = createTransactionUseCase;
        this.deleteTransactionUseCase = deleteTransactionUseCase;
        this.dialUssdUseCase = dialUssdUseCase;
        this.transactionRepository = transactionRepository;
        this.transactionRelay = transactionRelay;
    }

    public static /* synthetic */ Object invoke$default(RescheduleTransactionUseCase rescheduleTransactionUseCase, Transaction transaction, long j, Offer offer, String str, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            offer = null;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        if ((i & 16) != 0) {
            z = true;
        }
        return rescheduleTransactionUseCase.invoke(transaction, j, offer, str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:55:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:56:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:59:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:62:0x0202 A[Catch: Exception -> 0x023f, TryCatch #0 {Exception -> 0x023f, blocks: (B:16:0x0057, B:21:0x007b, B:60:0x01fa, B:62:0x0202, B:64:0x0208, B:24:0x0098, B:57:0x01d8, B:27:0x00b5, B:53:0x019c, B:31:0x00d7, B:49:0x0176, B:35:0x00e5, B:37:0x00ee, B:39:0x00f2, B:41:0x00fb, B:43:0x010c, B:45:0x0116, B:44:0x0112), top: B:71:0x002f }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0207  */
    /* JADX WARN: Code duplicated, block: B:67:0x023e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    public final Object invoke(Transaction transaction, long j, Offer offer, String str, boolean z, Continuation<? super Transaction> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        int externalRetries;
        Transaction transactionCopy$default;
        String str2;
        Transaction transaction2;
        String str3;
        long j2;
        long j3;
        String str4;
        Offer offer2;
        boolean z2;
        Transaction transaction3;
        String str5;
        Transaction transaction4;
        TransactionRepository transactionRepository;
        UUID id;
        TransactionStatus transactionStatus;
        Offer offer3;
        String str6;
        long j4;
        Transaction transaction5;
        Offer offer4;
        String str7;
        DialUssdUseCase dialUssdUseCase;
        UUID id2;
        TransactionRelay transactionRelay;
        TransactionEvent.Rescheduled rescheduled;
        Offer offer5 = offer;
        boolean z3 = z;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String responseMessage = str == null ? transaction.getResponseMessage() : str;
                TransactionStatus transactionStatus2 = TransactionStatus.RESCHEDULED;
                Offer offer6 = offer5 == null ? transaction.getOffer() : offer5;
                RescheduleInfo rescheduleInfo = new RescheduleInfo(null, j, null, 5, null);
                if (z3) {
                    externalRetries = transaction.getExternalRetries() + 1;
                } else {
                    externalRetries = transaction.getExternalRetries();
                }
                transactionCopy$default = Transaction.copy$default(transaction, null, null, 0, 0L, null, responseMessage, transactionStatus2, null, offer6, null, null, 0, externalRetries, 0L, null, rescheduleInfo, null, 91807, null);
                str2 = responseMessage;
                this.transactionRepository.getOngoingTransactions().remove(transactionCopy$default.getId());
                DeleteTransactionUseCase deleteTransactionUseCase = this.deleteTransactionUseCase;
                UUID id3 = transaction.getId();
                transaction2 = transaction;
                anonymousClass2.L$0 = transaction2;
                anonymousClass2.L$1 = offer5;
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass2.L$3 = str2;
                anonymousClass2.L$4 = transactionCopy$default;
                anonymousClass2.J$0 = j;
                anonymousClass2.Z$0 = z3;
                anonymousClass2.label = 1;
                if (deleteTransactionUseCase.invoke(id3, false, anonymousClass2) != coroutine_suspended) {
                    str3 = str;
                    j2 = j;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                boolean z4 = anonymousClass2.Z$0;
                j2 = anonymousClass2.J$0;
                Transaction transaction6 = (Transaction) anonymousClass2.L$4;
                str2 = (String) anonymousClass2.L$3;
                str3 = (String) anonymousClass2.L$2;
                Offer offer7 = (Offer) anonymousClass2.L$1;
                Transaction transaction7 = (Transaction) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
                transactionCopy$default = transaction6;
                z3 = z4;
                offer5 = offer7;
                transaction2 = transaction7;
            } else {
                if (i == 2) {
                    z2 = anonymousClass2.Z$0;
                    long j5 = anonymousClass2.J$0;
                    transaction3 = (Transaction) anonymousClass2.L$4;
                    String str8 = (String) anonymousClass2.L$3;
                    String str9 = (String) anonymousClass2.L$2;
                    Offer offer8 = (Offer) anonymousClass2.L$1;
                    transaction2 = (Transaction) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj);
                    j3 = j5;
                    str5 = str9;
                    str4 = str8;
                    offer2 = offer8;
                    transaction4 = transaction2;
                    transactionRepository = this.transactionRepository;
                    id = transaction4.getId();
                    transactionStatus = TransactionStatus.RESCHEDULED;
                    anonymousClass2.L$0 = transaction4;
                    anonymousClass2.L$1 = offer2;
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str5);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str4);
                    anonymousClass2.L$4 = transaction3;
                    anonymousClass2.J$0 = j3;
                    anonymousClass2.Z$0 = z2;
                    anonymousClass2.label = 3;
                    offer3 = offer2;
                    if (TransactionRepository.updateTransactionFields$default(transactionRepository, id, transactionStatus, str4, null, null, anonymousClass2, 24, null) == coroutine_suspended) {
                        str6 = str4;
                        j4 = j3;
                        transaction5 = transaction4;
                        offer4 = offer3;
                        str7 = str5;
                        dialUssdUseCase = this.dialUssdUseCase;
                        anonymousClass2.L$0 = transaction5;
                        anonymousClass2.L$1 = offer4;
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str7);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str6);
                        anonymousClass2.L$4 = transaction3;
                        anonymousClass2.J$0 = j4;
                        anonymousClass2.Z$0 = z2;
                        anonymousClass2.label = 4;
                        if (dialUssdUseCase.invoke(transaction3, j4, anonymousClass2) != coroutine_suspended) {
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 3) {
                    z2 = anonymousClass2.Z$0;
                    j4 = anonymousClass2.J$0;
                    transaction3 = (Transaction) anonymousClass2.L$4;
                    str6 = (String) anonymousClass2.L$3;
                    str7 = (String) anonymousClass2.L$2;
                    offer4 = (Offer) anonymousClass2.L$1;
                    transaction5 = (Transaction) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj);
                    dialUssdUseCase = this.dialUssdUseCase;
                    anonymousClass2.L$0 = transaction5;
                    anonymousClass2.L$1 = offer4;
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str7);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str6);
                    anonymousClass2.L$4 = transaction3;
                    anonymousClass2.J$0 = j4;
                    anonymousClass2.Z$0 = z2;
                    anonymousClass2.label = 4;
                    if (dialUssdUseCase.invoke(transaction3, j4, anonymousClass2) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 4) {
                    if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z5 = anonymousClass2.Z$0;
                    long j6 = anonymousClass2.J$0;
                    Transaction transaction8 = (Transaction) anonymousClass2.L$4;
                    ResultKt.throwOnFailure(obj);
                    return transaction8;
                }
                z2 = anonymousClass2.Z$0;
                j4 = anonymousClass2.J$0;
                transaction3 = (Transaction) anonymousClass2.L$4;
                str6 = (String) anonymousClass2.L$3;
                str7 = (String) anonymousClass2.L$2;
                offer4 = (Offer) anonymousClass2.L$1;
                transaction5 = (Transaction) anonymousClass2.L$0;
                ResultKt.throwOnFailure(obj);
            }
            UUID id4 = transaction5.getId();
            if (offer4 != null) {
                id2 = offer4.getId();
            } else {
                id2 = null;
            }
            TransactionEvent.Rescheduled rescheduled2 = new TransactionEvent.Rescheduled(id4, j4, id2);
            transactionRelay = this.transactionRelay;
            rescheduled = rescheduled2;
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(transaction5);
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(offer4);
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str7);
            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str6);
            anonymousClass2.L$4 = transaction3;
            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(rescheduled2);
            anonymousClass2.J$0 = j4;
            anonymousClass2.Z$0 = z2;
            anonymousClass2.label = 5;
            if (transactionRelay.send(rescheduled, anonymousClass2) != coroutine_suspended) {
                return coroutine_suspended;
            }
            return transaction3;
            CreateTransactionUseCase createTransactionUseCase = this.createTransactionUseCase;
            anonymousClass2.L$0 = transaction2;
            anonymousClass2.L$1 = offer5;
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str3);
            anonymousClass2.L$3 = str2;
            anonymousClass2.L$4 = transactionCopy$default;
            anonymousClass2.J$0 = j2;
            anonymousClass2.Z$0 = z3;
            anonymousClass2.label = 2;
            if (createTransactionUseCase.invoke(transactionCopy$default, anonymousClass2) != coroutine_suspended) {
                j3 = j2;
                str4 = str2;
                offer2 = offer5;
                z2 = z3;
                transaction3 = transactionCopy$default;
                str5 = str3;
                transaction4 = transaction2;
                transactionRepository = this.transactionRepository;
                id = transaction4.getId();
                transactionStatus = TransactionStatus.RESCHEDULED;
                anonymousClass2.L$0 = transaction4;
                anonymousClass2.L$1 = offer2;
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str5);
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str4);
                anonymousClass2.L$4 = transaction3;
                anonymousClass2.J$0 = j3;
                anonymousClass2.Z$0 = z2;
                anonymousClass2.label = 3;
                offer3 = offer2;
                if (TransactionRepository.updateTransactionFields$default(transactionRepository, id, transactionStatus, str4, null, null, anonymousClass2, 24, null) == coroutine_suspended) {
                    str6 = str4;
                    j4 = j3;
                    transaction5 = transaction4;
                    offer4 = offer3;
                    str7 = str5;
                    dialUssdUseCase = this.dialUssdUseCase;
                    anonymousClass2.L$0 = transaction5;
                    anonymousClass2.L$1 = offer4;
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str7);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str6);
                    anonymousClass2.L$4 = transaction3;
                    anonymousClass2.J$0 = j4;
                    anonymousClass2.Z$0 = z2;
                    anonymousClass2.label = 4;
                    if (dialUssdUseCase.invoke(transaction3, j4, anonymousClass2) != coroutine_suspended) {
                        UUID id5 = transaction5.getId();
                        if (offer4 != null) {
                            id2 = offer4.getId();
                        } else {
                            id2 = null;
                        }
                        TransactionEvent.Rescheduled rescheduled3 = new TransactionEvent.Rescheduled(id5, j4, id2);
                        transactionRelay = this.transactionRelay;
                        rescheduled = rescheduled3;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(transaction5);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(offer4);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str7);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str6);
                        anonymousClass2.L$4 = transaction3;
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(rescheduled3);
                        anonymousClass2.J$0 = j4;
                        anonymousClass2.Z$0 = z2;
                        anonymousClass2.label = 5;
                        if (transactionRelay.send(rescheduled, anonymousClass2) != coroutine_suspended) {
                            return transaction3;
                        }
                    }
                }
            }
            return coroutine_suspended;
        } catch (Exception e) {
            Log.d("RescheduleTransactionUseCase", e.getMessage(), e);
            throw e;
        }
    }
}
