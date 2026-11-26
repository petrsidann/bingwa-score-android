package com.example.bingwahybrid.presentation.offers.dto;

import com.example.bingwahybrid.domain.sms.model.SmsSender;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FilterChipState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;", "", "<init>", "()V", "Live", "All", "Successful", "AwaitingCommission", "Failed", "Pending", "Unmatched", "Scheduled", "EngageBot", SmsSender.SITELINK, "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$All;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$AwaitingCommission;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$EngageBot;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$Failed;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$Live;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$Pending;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$Scheduled;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$SiteLink;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$Successful;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$Unmatched;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FilterChipState {
    public static final int $stable = 0;

    public /* synthetic */ FilterChipState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: FilterChipState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$Live;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Live extends FilterChipState {
        public static final int $stable = 0;
        public static final Live INSTANCE = new Live();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Live)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 207929462;
        }

        public String toString() {
            return "Live";
        }

        private Live() {
            super(null);
        }
    }

    private FilterChipState() {
    }

    /* JADX INFO: compiled from: FilterChipState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$All;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class All extends FilterChipState {
        public static final int $stable = 0;
        public static final All INSTANCE = new All();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof All)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 283791575;
        }

        public String toString() {
            return "All";
        }

        private All() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FilterChipState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$Successful;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Successful extends FilterChipState {
        public static final int $stable = 0;
        public static final Successful INSTANCE = new Successful();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Successful)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1955359396;
        }

        public String toString() {
            return "Successful";
        }

        private Successful() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FilterChipState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$AwaitingCommission;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AwaitingCommission extends FilterChipState {
        public static final int $stable = 0;
        public static final AwaitingCommission INSTANCE = new AwaitingCommission();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AwaitingCommission)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 2077030113;
        }

        public String toString() {
            return "AwaitingCommission";
        }

        private AwaitingCommission() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FilterChipState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$Failed;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Failed extends FilterChipState {
        public static final int $stable = 0;
        public static final Failed INSTANCE = new Failed();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 2072176967;
        }

        public String toString() {
            return "Failed";
        }

        private Failed() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FilterChipState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$Pending;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Pending extends FilterChipState {
        public static final int $stable = 0;
        public static final Pending INSTANCE = new Pending();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Pending)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 216978893;
        }

        public String toString() {
            return "Pending";
        }

        private Pending() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FilterChipState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$Unmatched;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Unmatched extends FilterChipState {
        public static final int $stable = 0;
        public static final Unmatched INSTANCE = new Unmatched();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unmatched)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -547183839;
        }

        public String toString() {
            return "Unmatched";
        }

        private Unmatched() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FilterChipState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$Scheduled;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Scheduled extends FilterChipState {
        public static final int $stable = 0;
        public static final Scheduled INSTANCE = new Scheduled();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Scheduled)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1034409827;
        }

        public String toString() {
            return "Scheduled";
        }

        private Scheduled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FilterChipState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$EngageBot;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EngageBot extends FilterChipState {
        public static final int $stable = 0;
        public static final EngageBot INSTANCE = new EngageBot();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EngageBot)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1560246620;
        }

        public String toString() {
            return "EngageBot";
        }

        private EngageBot() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FilterChipState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState$SiteLink;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SiteLink extends FilterChipState {
        public static final int $stable = 0;
        public static final SiteLink INSTANCE = new SiteLink();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SiteLink)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1503247765;
        }

        public String toString() {
            return SmsSender.SITELINK;
        }

        private SiteLink() {
            super(null);
        }
    }
}
