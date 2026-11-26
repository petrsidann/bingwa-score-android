package com.example.bingwahybrid.domain.utils;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.MessageKt;
import androidx.compose.material.icons.filled.BlockKt;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material.icons.filled.HourglassEmptyKt;
import androidx.compose.material.icons.filled.InfoKt;
import androidx.compose.material.icons.filled.PauseKt;
import androidx.compose.material.icons.filled.RefreshKt;
import androidx.compose.material.icons.filled.ScheduleKt;
import androidx.compose.material.icons.outlined.AutoFixHighKt;
import androidx.compose.material.icons.outlined.CancelKt;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material.icons.outlined.ErrorKt;
import androidx.compose.material.icons.outlined.LanguageKt;
import androidx.compose.material.icons.outlined.ModeStandbyKt;
import androidx.compose.material.icons.outlined.PhoneKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.core.app.NotificationCompat;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.example.bingwahybrid.domain.sms.utils.SmsUtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IconUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"getIconForTransactionStatus", "Landroidx/compose/ui/graphics/vector/ImageVector;", NotificationCompat.CATEGORY_STATUS, "Lcom/example/bingwahybrid/domain/enums/TransactionStatus;", "responseMessage", "", "getIconForOfferType", "offerType", "Lcom/example/bingwahybrid/domain/offers/enums/OfferType;", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IconUtilsKt {

    /* JADX INFO: compiled from: IconUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
                iArr[TransactionStatus.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TransactionStatus.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TransactionStatus.FAILED_ALREADY_RECOMMENDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TransactionStatus.UNMATCHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TransactionStatus.RESCHEDULED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TransactionStatus.PAUSED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TransactionStatus.BLOCKED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[TransactionStatus.FAILED_OFFER_DEACTIVATED.ordinal()] = 10;
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
            int[] iArr2 = new int[OfferType.values().length];
            try {
                iArr2[OfferType.DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[OfferType.VOICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[OfferType.SMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[OfferType.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final ImageVector getIconForTransactionStatus(TransactionStatus status, String responseMessage) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
        switch (WhenMappings.$EnumSwitchMapping$0[status.ordinal()]) {
            case 1:
                return HourglassEmptyKt.getHourglassEmpty(Icons.Filled.INSTANCE);
            case 2:
                return HourglassEmptyKt.getHourglassEmpty(Icons.Filled.INSTANCE);
            case 3:
                return CheckKt.getCheck(Icons.Filled.INSTANCE);
            case 4:
                return SmsUtilsKt.isAlreadyRecommendedResponse(responseMessage) ? CloseKt.getClose(Icons.Outlined.INSTANCE) : RefreshKt.getRefresh(Icons.Filled.INSTANCE);
            case 5:
                return CloseKt.getClose(Icons.Outlined.INSTANCE);
            case 6:
                return InfoKt.getInfo(Icons.Filled.INSTANCE);
            case 7:
                return ScheduleKt.getSchedule(Icons.Filled.INSTANCE);
            case 8:
                return PauseKt.getPause(Icons.Filled.INSTANCE);
            case 9:
                return BlockKt.getBlock(Icons.Filled.INSTANCE);
            case 10:
                return CancelKt.getCancel(Icons.Outlined.INSTANCE);
            case 11:
                return AutoFixHighKt.getAutoFixHigh(Icons.Outlined.INSTANCE);
            case 12:
                return ModeStandbyKt.getModeStandby(Icons.Outlined.INSTANCE);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ImageVector getIconForOfferType(OfferType offerType) {
        Intrinsics.checkNotNullParameter(offerType, "offerType");
        int i = WhenMappings.$EnumSwitchMapping$1[offerType.ordinal()];
        if (i == 1) {
            return LanguageKt.getLanguage(Icons.Outlined.INSTANCE);
        }
        if (i == 2) {
            return PhoneKt.getPhone(Icons.Outlined.INSTANCE);
        }
        if (i == 3) {
            return MessageKt.getMessage(Icons.AutoMirrored.Outlined.INSTANCE);
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return ErrorKt.getError(Icons.Outlined.INSTANCE);
    }
}
