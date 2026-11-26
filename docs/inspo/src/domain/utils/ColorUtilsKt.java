package com.example.bingwahybrid.domain.utils;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"getColorForTransactionStatus", "Landroidx/compose/ui/graphics/Color;", "transactionStatus", "Lcom/example/bingwahybrid/domain/enums/TransactionStatus;", "(Lcom/example/bingwahybrid/domain/enums/TransactionStatus;Landroidx/compose/runtime/Composer;I)J", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ColorUtilsKt {

    /* JADX INFO: compiled from: ColorUtils.kt */
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
                iArr[TransactionStatus.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TransactionStatus.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TransactionStatus.FAILED_OFFER_DEACTIVATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TransactionStatus.FAILED_ALREADY_RECOMMENDED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TransactionStatus.UNMATCHED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TransactionStatus.RESCHEDULED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TransactionStatus.PAUSED.ordinal()] = 9;
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

    public static final long getColorForTransactionStatus(TransactionStatus transactionStatus, Composer composer, int i) {
        long tertiary;
        Intrinsics.checkNotNullParameter(transactionStatus, "transactionStatus");
        ComposerKt.sourceInformationMarkerStart(composer, 1926556981, "C(getColorForTransactionStatus)N(transactionStatus):ColorUtils.kt#bccvgi");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1926556981, i, -1, "com.example.bingwahybrid.domain.utils.getColorForTransactionStatus (ColorUtils.kt:8)");
        }
        switch (WhenMappings.$EnumSwitchMapping$0[transactionStatus.ordinal()]) {
            case 1:
                composer.startReplaceGroup(290360413);
                ComposerKt.sourceInformation(composer, "10@427L11");
                tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary();
                composer.endReplaceGroup();
                break;
            case 2:
                composer.startReplaceGroup(290362812);
                ComposerKt.sourceInformation(composer, "11@502L11");
                tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary();
                composer.endReplaceGroup();
                break;
            case 3:
                composer.startReplaceGroup(290365084);
                ComposerKt.sourceInformation(composer, "12@573L11");
                tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary();
                composer.endReplaceGroup();
                break;
            case 4:
                composer.startReplaceGroup(290367322);
                ComposerKt.sourceInformation(composer, "13@643L11");
                tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getError();
                composer.endReplaceGroup();
                break;
            case 5:
                composer.startReplaceGroup(290370074);
                ComposerKt.sourceInformation(composer, "14@729L11");
                tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getError();
                composer.endReplaceGroup();
                break;
            case 6:
                composer.startReplaceGroup(290372890);
                ComposerKt.sourceInformation(composer, "15@817L11");
                tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getError();
                composer.endReplaceGroup();
                break;
            case 7:
                composer.startReplaceGroup(290375166);
                ComposerKt.sourceInformation(composer, "16@888L11");
                tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondary();
                composer.endReplaceGroup();
                break;
            case 8:
                composer.startReplaceGroup(290377629);
                ComposerKt.sourceInformation(composer, "17@965L11");
                tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary();
                composer.endReplaceGroup();
                break;
            case 9:
                composer.startReplaceGroup(290379901);
                ComposerKt.sourceInformation(composer, "18@1036L11");
                tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary();
                composer.endReplaceGroup();
                break;
            case 10:
                composer.startReplaceGroup(290382202);
                ComposerKt.sourceInformation(composer, "19@1108L11");
                tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getError();
                composer.endReplaceGroup();
                break;
            case 11:
                composer.startReplaceGroup(290384733);
                ComposerKt.sourceInformation(composer, "20@1187L11");
                tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary();
                composer.endReplaceGroup();
                break;
            case 12:
                composer.startReplaceGroup(290387677);
                ComposerKt.sourceInformation(composer, "21@1279L11");
                tertiary = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getTertiary();
                composer.endReplaceGroup();
                break;
            default:
                composer.startReplaceGroup(290358419);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return tertiary;
    }
}
