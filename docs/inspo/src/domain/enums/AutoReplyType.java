package com.example.bingwahybrid.domain.enums;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: AutoReplyType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000e"}, d2 = {"Lcom/example/bingwahybrid/domain/enums/AutoReplyType;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "OFFER_UNAVAILABLE", "ALREADY_RECOMMENDED", "APP_PAUSED", "CUSTOMER_BLOCKED", "displayName", "", "getDisplayName", "()Ljava/lang/String;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum AutoReplyType {
    SUCCESS,
    FAILED,
    OFFER_UNAVAILABLE,
    ALREADY_RECOMMENDED,
    APP_PAUSED,
    CUSTOMER_BLOCKED;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: compiled from: AutoReplyType.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AutoReplyType.values().length];
            try {
                iArr[AutoReplyType.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AutoReplyType.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AutoReplyType.OFFER_UNAVAILABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AutoReplyType.ALREADY_RECOMMENDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AutoReplyType.APP_PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AutoReplyType.CUSTOMER_BLOCKED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<AutoReplyType> getEntries() {
        return $ENTRIES;
    }

    public final String getDisplayName() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "Successful Transaction";
            case 2:
                return "Failed Transaction";
            case 3:
                return "Offer Unavailable";
            case 4:
                return "Already Recommended";
            case 5:
                return "App Paused";
            case 6:
                return "Blacklisted Customer";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
