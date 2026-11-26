package com.example.bingwahybrid.domain.messaging.usecase;

import android.content.Context;
import android.telephony.SmsManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SendSmsUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086B¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/example/bingwahybrid/domain/messaging/usecase/SendSmsUseCase;", "", "context", "Landroid/content/Context;", "subscriptionIdFetcherUseCase", "Lcom/example/bingwahybrid/domain/usecase/SubscriptionIdFetcherUseCase;", "<init>", "(Landroid/content/Context;Lcom/example/bingwahybrid/domain/usecase/SubscriptionIdFetcherUseCase;)V", "invoke", "", "receiverPhone", "", "message", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSmsManager", "Landroid/telephony/SmsManager;", "subscriptionId", "", "hasSmsPermissions", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SendSmsUseCase {
    public static final int $stable = 8;
    private final Context context;
    private final SubscriptionIdFetcherUseCase subscriptionIdFetcherUseCase;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.messaging.usecase.SendSmsUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: SendSmsUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.messaging.usecase.SendSmsUseCase", f = "SendSmsUseCase.kt", i = {0, 0}, l = {25}, m = "invoke", n = {"receiverPhone", "message"}, s = {"L$0", "L$1"})
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
            return SendSmsUseCase.this.invoke(null, null, this);
        }
    }

    @Inject
    public SendSmsUseCase(@ApplicationContext Context context, SubscriptionIdFetcherUseCase subscriptionIdFetcherUseCase) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subscriptionIdFetcherUseCase, "subscriptionIdFetcherUseCase");
        this.context = context;
        this.subscriptionIdFetcherUseCase = subscriptionIdFetcherUseCase;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(String str, String str2, Continuation<? super Unit> continuation) {
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
        Object smsSimSubscriptionId = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(smsSimSubscriptionId);
                if (!hasSmsPermissions()) {
                    return Unit.INSTANCE;
                }
                SubscriptionIdFetcherUseCase subscriptionIdFetcherUseCase = this.subscriptionIdFetcherUseCase;
                anonymousClass1.L$0 = str;
                anonymousClass1.L$1 = str2;
                anonymousClass1.label = 1;
                smsSimSubscriptionId = subscriptionIdFetcherUseCase.getSmsSimSubscriptionId(anonymousClass1);
                if (smsSimSubscriptionId == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str2 = (String) anonymousClass1.L$1;
                str = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure(smsSimSubscriptionId);
            }
            String str3 = str;
            String str4 = str2;
            SmsManager smsManager = getSmsManager(((Number) smsSimSubscriptionId).intValue());
            if (smsManager == null) {
                throw new Exception("Could not get SMS Manger instance");
            }
            if (str4.length() > 160) {
                smsManager.sendMultipartTextMessage(str3, null, smsManager.divideMessage(str4), null, null);
            } else {
                smsManager.sendTextMessage(str3, null, str4, null, null);
            }
            return Unit.INSTANCE;
        } catch (Exception e) {
            Log.e("SendSmsUseCase", "Failed to send SMS: " + e.getMessage());
        }
    }

    private final SmsManager getSmsManager(int subscriptionId) {
        try {
            SmsManager smsManager = (SmsManager) this.context.getSystemService(SmsManager.class);
            return subscriptionId != -1 ? smsManager.createForSubscriptionId(subscriptionId) : smsManager;
        } catch (Exception unused) {
            return null;
        }
    }

    private final boolean hasSmsPermissions() {
        return ContextCompat.checkSelfPermission(this.context, "android.permission.SEND_SMS") == 0 && ContextCompat.checkSelfPermission(this.context, "android.permission.READ_PHONE_STATE") == 0;
    }
}
