package com.example.bingwahybrid.domain.sms.usecases;

import android.util.Log;
import com.example.bingwahybrid.domain.enums.SmsType;
import com.example.bingwahybrid.domain.sms.messageextractor.MessageExtractor;
import com.example.bingwahybrid.domain.sms.model.SmsMessage;
import com.example.bingwahybrid.domain.sms.utils.SmsUtilsKt;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtractMessageDetailsUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/usecases/ExtractMessageDetailsUseCase;", "", "mpesaMessageExtractor", "Lcom/example/bingwahybrid/domain/sms/messageextractor/MessageExtractor;", "tillMessageExtractor", "payBillMessageExtractor", "siteLinkMessageExtractor", "<init>", "(Lcom/example/bingwahybrid/domain/sms/messageextractor/MessageExtractor;Lcom/example/bingwahybrid/domain/sms/messageextractor/MessageExtractor;Lcom/example/bingwahybrid/domain/sms/messageextractor/MessageExtractor;Lcom/example/bingwahybrid/domain/sms/messageextractor/MessageExtractor;)V", "invoke", "Lcom/example/bingwahybrid/domain/sms/model/SmsMessage;", "message", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExtractMessageDetailsUseCase {
    public static final int $stable = 0;
    private final MessageExtractor mpesaMessageExtractor;
    private final MessageExtractor payBillMessageExtractor;
    private final MessageExtractor siteLinkMessageExtractor;
    private final MessageExtractor tillMessageExtractor;

    /* JADX INFO: compiled from: ExtractMessageDetailsUseCase.kt */
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
            try {
                iArr[SmsType.RECOMMENDATION_TIMEOUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SmsType.RECOMMENDATION_EXPIRED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SmsType.AIRTIME_BALANCE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SmsType.BINGWA_SOKONI_COMMISSION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public ExtractMessageDetailsUseCase(@Named("mpesaMessageExtractor") MessageExtractor mpesaMessageExtractor, @Named("tillMessageExtractor") MessageExtractor tillMessageExtractor, @Named("payBillMessageExtractor") MessageExtractor payBillMessageExtractor, @Named("siteLinkMessageExtractor") MessageExtractor siteLinkMessageExtractor) {
        Intrinsics.checkNotNullParameter(mpesaMessageExtractor, "mpesaMessageExtractor");
        Intrinsics.checkNotNullParameter(tillMessageExtractor, "tillMessageExtractor");
        Intrinsics.checkNotNullParameter(payBillMessageExtractor, "payBillMessageExtractor");
        Intrinsics.checkNotNullParameter(siteLinkMessageExtractor, "siteLinkMessageExtractor");
        this.mpesaMessageExtractor = mpesaMessageExtractor;
        this.tillMessageExtractor = tillMessageExtractor;
        this.payBillMessageExtractor = payBillMessageExtractor;
        this.siteLinkMessageExtractor = siteLinkMessageExtractor;
    }

    public final SmsMessage invoke(String message) throws Exception {
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            switch (WhenMappings.$EnumSwitchMapping$0[SmsUtilsKt.getSmsType(message).ordinal()]) {
                case 1:
                    return this.mpesaMessageExtractor.extractDetails(message);
                case 2:
                    return this.tillMessageExtractor.extractDetails(message);
                case 3:
                    return this.payBillMessageExtractor.extractDetails(message);
                case 4:
                    return this.siteLinkMessageExtractor.extractDetails(message);
                case 5:
                    return this.tillMessageExtractor.extractDetails(message);
                case 6:
                    return this.tillMessageExtractor.extractDetails(message);
                case 7:
                    return this.tillMessageExtractor.extractDetails(message);
                case 8:
                    return this.tillMessageExtractor.extractDetails(message);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } catch (Exception e) {
            Log.e("ExtractMessageUseCase", "ExtractMessageDetails", e);
            throw e;
        }
    }
}
