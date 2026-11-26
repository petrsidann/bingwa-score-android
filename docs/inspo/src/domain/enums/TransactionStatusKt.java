package com.example.bingwahybrid.domain.enums;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransactionStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"isTerminal", "", "Lcom/example/bingwahybrid/domain/enums/TransactionStatus;", "isFailed", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TransactionStatusKt {

    /* JADX INFO: compiled from: TransactionStatus.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TransactionStatus.values().length];
            try {
                iArr[TransactionStatus.SCHEDULED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TransactionStatus.PROCESSING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TransactionStatus.UNMATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TransactionStatus.RESCHEDULED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TransactionStatus.PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TransactionStatus.SUCCESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TransactionStatus.FAILED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TransactionStatus.FAILED_ALREADY_RECOMMENDED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TransactionStatus.FAILED_OFFER_DEACTIVATED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[TransactionStatus.BLOCKED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[TransactionStatus.ENGAGE_BOT_ACTIVE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[TransactionStatus.PENDING_AWAITING_COMMISSION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isTerminal(TransactionStatus transactionStatus) {
        Intrinsics.checkNotNullParameter(transactionStatus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[transactionStatus.ordinal()]) {
            case 1:
            case 2:
                return false;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean isFailed(TransactionStatus transactionStatus) {
        Intrinsics.checkNotNullParameter(transactionStatus, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[transactionStatus.ordinal()];
        return i == 7 || i == 8;
    }
}
