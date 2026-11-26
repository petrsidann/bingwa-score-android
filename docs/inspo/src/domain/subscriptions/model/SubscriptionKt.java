package com.example.bingwahybrid.domain.subscriptions.model;

import com.example.bingwahybrid.domain.enums.SubscriptionType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Subscription.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isExpired", "", "Lcom/example/bingwahybrid/domain/subscriptions/model/Subscription;", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SubscriptionKt {

    /* JADX INFO: compiled from: Subscription.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SubscriptionType.values().length];
            try {
                iArr[SubscriptionType.LIMITED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SubscriptionType.UNLIMITED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isExpired(Subscription subscription) {
        Intrinsics.checkNotNullParameter(subscription, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[subscription.getType().ordinal()];
        if (i == 1) {
            return subscription.getLimit() <= 0;
        }
        if (i == 2) {
            return subscription.getLimit() <= System.currentTimeMillis();
        }
        throw new NoWhenBranchMatchedException();
    }
}
