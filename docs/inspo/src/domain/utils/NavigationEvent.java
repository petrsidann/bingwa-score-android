package com.example.bingwahybrid.domain.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/example/bingwahybrid/domain/utils/NavigationEvent;", "", "<init>", "()V", "Back", "To", "Lcom/example/bingwahybrid/domain/utils/NavigationEvent$Back;", "Lcom/example/bingwahybrid/domain/utils/NavigationEvent$To;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class NavigationEvent {
    public static final int $stable = 0;

    public /* synthetic */ NavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: NavigationManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/utils/NavigationEvent$Back;", "Lcom/example/bingwahybrid/domain/utils/NavigationEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Back extends NavigationEvent {
        public static final int $stable = 0;
        public static final Back INSTANCE = new Back();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Back)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1968184481;
        }

        public String toString() {
            return "Back";
        }

        private Back() {
            super(null);
        }
    }

    private NavigationEvent() {
    }

    /* JADX INFO: compiled from: NavigationManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/utils/NavigationEvent$To;", "Lcom/example/bingwahybrid/domain/utils/NavigationEvent;", "route", "", "<init>", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class To extends NavigationEvent {
        public static final int $stable = 0;
        private final String route;

        public static /* synthetic */ To copy$default(To to, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = to.route;
            }
            return to.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getRoute() {
            return this.route;
        }

        public final To copy(String route) {
            Intrinsics.checkNotNullParameter(route, "route");
            return new To(route);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof To) && Intrinsics.areEqual(this.route, ((To) other).route);
        }

        public int hashCode() {
            return this.route.hashCode();
        }

        public String toString() {
            return "To(route=" + this.route + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public To(String route) {
            super(null);
            Intrinsics.checkNotNullParameter(route, "route");
            this.route = route;
        }

        public final String getRoute() {
            return this.route;
        }
    }
}
