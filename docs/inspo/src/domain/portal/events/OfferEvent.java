package com.example.bingwahybrid.domain.portal.events;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OfferEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0006B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0001\u0007¨\u0006\b"}, d2 = {"Lcom/example/bingwahybrid/domain/portal/events/OfferEvent;", "", "eventName", "", "<init>", "(Ljava/lang/String;)V", "Sync", "Lcom/example/bingwahybrid/domain/portal/events/OfferEvent$Sync;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class OfferEvent {
    public static final int $stable = 0;

    public /* synthetic */ OfferEvent(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* JADX INFO: compiled from: OfferEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/portal/events/OfferEvent$Sync;", "Lcom/example/bingwahybrid/domain/portal/events/OfferEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Sync extends OfferEvent {
        public static final int $stable = 0;
        public static final Sync INSTANCE = new Sync();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Sync)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1503519771;
        }

        public String toString() {
            return "Sync";
        }

        private Sync() {
            super("offers.sync", null);
        }
    }

    private OfferEvent(String str) {
    }
}
