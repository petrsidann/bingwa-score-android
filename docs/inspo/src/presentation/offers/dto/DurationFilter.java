package com.example.bingwahybrid.presentation.offers.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DurationFilter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter;", "", "<init>", "()V", "Today", "Yesterday", "Last7Days", "Last30Days", "Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter$Last30Days;", "Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter$Last7Days;", "Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter$Today;", "Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter$Yesterday;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DurationFilter {
    public static final int $stable = 0;

    public /* synthetic */ DurationFilter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: DurationFilter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter$Today;", "Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Today extends DurationFilter {
        public static final int $stable = 0;
        public static final Today INSTANCE = new Today();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Today)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1919279608;
        }

        public String toString() {
            return "Today";
        }

        private Today() {
            super(null);
        }
    }

    private DurationFilter() {
    }

    /* JADX INFO: compiled from: DurationFilter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter$Yesterday;", "Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Yesterday extends DurationFilter {
        public static final int $stable = 0;
        public static final Yesterday INSTANCE = new Yesterday();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Yesterday)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -413445943;
        }

        public String toString() {
            return "Yesterday";
        }

        private Yesterday() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DurationFilter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter$Last7Days;", "Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Last7Days extends DurationFilter {
        public static final int $stable = 0;
        public static final Last7Days INSTANCE = new Last7Days();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Last7Days)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1111502945;
        }

        public String toString() {
            return "Last7Days";
        }

        private Last7Days() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DurationFilter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter$Last30Days;", "Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Last30Days extends DurationFilter {
        public static final int $stable = 0;
        public static final Last30Days INSTANCE = new Last30Days();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Last30Days)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -230726653;
        }

        public String toString() {
            return "Last30Days";
        }

        private Last30Days() {
            super(null);
        }
    }
}
