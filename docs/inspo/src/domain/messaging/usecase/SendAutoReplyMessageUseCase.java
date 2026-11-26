package com.example.bingwahybrid.domain.messaging.usecase;

import android.util.Log;
import com.example.bingwahybrid.domain.enums.AutoReplyType;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.model.AutoReply;
import com.example.bingwahybrid.domain.model.AutoReplyPlaceHolder;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.AutoReplyRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SendAutoReplyMessageUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086B¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/example/bingwahybrid/domain/messaging/usecase/SendAutoReplyMessageUseCase;", "", "autoReplyRepository", "Lcom/example/bingwahybrid/domain/repository/AutoReplyRepository;", "sendSmsUseCase", "Lcom/example/bingwahybrid/domain/messaging/usecase/SendSmsUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/AutoReplyRepository;Lcom/example/bingwahybrid/domain/messaging/usecase/SendSmsUseCase;)V", "invoke", "", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "autoReplyType", "Lcom/example/bingwahybrid/domain/enums/AutoReplyType;", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lcom/example/bingwahybrid/domain/enums/AutoReplyType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SendAutoReplyMessageUseCase {
    public static final int $stable = 8;
    private final AutoReplyRepository autoReplyRepository;
    private final SendSmsUseCase sendSmsUseCase;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.messaging.usecase.SendAutoReplyMessageUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: SendAutoReplyMessageUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.messaging.usecase.SendAutoReplyMessageUseCase", f = "SendAutoReplyMessageUseCase.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {27, 48}, m = "invoke", n = {"transaction", "autoReplyType", "excludedTypes", "transaction", "autoReplyType", "excludedTypes", "autoReplies", "matchingAmountReply", "selectedReply", "message"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
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
            return SendAutoReplyMessageUseCase.this.invoke(null, null, this);
        }
    }

    @Inject
    public SendAutoReplyMessageUseCase(AutoReplyRepository autoReplyRepository, SendSmsUseCase sendSmsUseCase) {
        Intrinsics.checkNotNullParameter(autoReplyRepository, "autoReplyRepository");
        Intrinsics.checkNotNullParameter(sendSmsUseCase, "sendSmsUseCase");
        this.autoReplyRepository = autoReplyRepository;
        this.sendSmsUseCase = sendSmsUseCase;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0182, code lost:
    
        if (r11.invoke(r8, r2, r0) == r1) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Transaction transaction, AutoReplyType autoReplyType, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Set of;
        Object autoReplies;
        Object obj;
        Object next;
        AutoReply autoReply;
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
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj2);
                of = SetsKt.setOf((Object[]) new TransactionType[]{TransactionType.SUBSCRIPTION_RENEWAL, TransactionType.AIRTIME_BALANCE_CHECK});
                if (of.contains(transaction.getType())) {
                    return Unit.INSTANCE;
                }
                AutoReplyRepository autoReplyRepository = this.autoReplyRepository;
                anonymousClass1.L$0 = transaction;
                anonymousClass1.L$1 = autoReplyType;
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(of);
                anonymousClass1.label = 1;
                autoReplies = autoReplyRepository.getAutoReplies(anonymousClass1);
                if (autoReplies == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                Set set = (Set) anonymousClass1.L$2;
                autoReplyType = (AutoReplyType) anonymousClass1.L$1;
                Transaction transaction2 = (Transaction) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj2);
                of = set;
                transaction = transaction2;
                autoReplies = obj2;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj2);
            }
            return Unit.INSTANCE;
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : (Iterable) autoReplies) {
                AutoReply autoReply2 = (AutoReply) obj3;
                if (autoReply2.getType() == autoReplyType && autoReply2.isActive()) {
                    arrayList.add(obj3);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (arrayList2.isEmpty()) {
                return Unit.INSTANCE;
            }
            Iterator it = arrayList2.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                AutoReply autoReply3 = (AutoReply) next;
                if (autoReply3.getAmount() != null) {
                    Integer amount = autoReply3.getAmount();
                    int amount2 = transaction.getAmount();
                    if (amount != null && amount.intValue() == amount2) {
                        break;
                    }
                }
            }
            AutoReply autoReply4 = (AutoReply) next;
            if (autoReply4 == null) {
                for (Object obj4 : arrayList2) {
                    if (((AutoReply) obj4).getAmount() == null) {
                        obj = obj4;
                        break;
                    }
                }
                autoReply = (AutoReply) obj;
            } else {
                autoReply = autoReply4;
            }
            if (autoReply == null) {
                return Unit.INSTANCE;
            }
            String strReplacePlaceholders = AutoReplyPlaceHolder.INSTANCE.replacePlaceholders(autoReply.getMessage(), transaction);
            Log.d("SendAutoReplyMessageUseCase", "Sending auto-reply: " + strReplacePlaceholders);
            SendSmsUseCase sendSmsUseCase = this.sendSmsUseCase;
            String phone = transaction.getCustomer().getPhone();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transaction);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(autoReplyType);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(of);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(arrayList2);
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(autoReply4);
            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(autoReply);
            anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(strReplacePlaceholders);
            anonymousClass1.label = 2;
        } catch (Exception e) {
            Log.e("SendAutoReplyMessageUseCase", "Error sending auto-reply: " + e.getMessage());
        }
    }
}
