package com.example.bingwahybrid.domain.enums;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransactionStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/enums/TransactionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "UNMATCHED", "SCHEDULED", "PROCESSING", "SUCCESS", "FAILED", "FAILED_ALREADY_RECOMMENDED", "FAILED_OFFER_DEACTIVATED", "RESCHEDULED", "PAUSED", "BLOCKED", "PENDING_AWAITING_COMMISSION", "ENGAGE_BOT_ACTIVE", "Companion", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum TransactionStatus {
    UNMATCHED,
    SCHEDULED,
    PROCESSING,
    SUCCESS,
    FAILED,
    FAILED_ALREADY_RECOMMENDED,
    FAILED_OFFER_DEACTIVATED,
    RESCHEDULED,
    PAUSED,
    BLOCKED,
    PENDING_AWAITING_COMMISSION,
    ENGAGE_BOT_ACTIVE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<TransactionStatus> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: compiled from: TransactionStatus.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/example/bingwahybrid/domain/enums/TransactionStatus$Companion;", "", "<init>", "()V", "fromString", "Lcom/example/bingwahybrid/domain/enums/TransactionStatus;", "value", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TransactionStatus fromString(String value) {
            if (value == null) {
                return null;
            }
            try {
                String upperCase = value.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                return TransactionStatus.valueOf(upperCase);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }
}
