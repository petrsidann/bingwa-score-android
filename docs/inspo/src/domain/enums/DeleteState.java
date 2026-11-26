package com.example.bingwahybrid.domain.enums;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/enums/DeleteState;", "", "<init>", "()V", "Idle", "Deleting", "Deleted", "Failed", "Lcom/example/bingwahybrid/domain/enums/DeleteState$Deleted;", "Lcom/example/bingwahybrid/domain/enums/DeleteState$Deleting;", "Lcom/example/bingwahybrid/domain/enums/DeleteState$Failed;", "Lcom/example/bingwahybrid/domain/enums/DeleteState$Idle;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DeleteState {
    public static final int $stable = 0;

    public /* synthetic */ DeleteState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: DeleteState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/enums/DeleteState$Idle;", "Lcom/example/bingwahybrid/domain/enums/DeleteState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Idle extends DeleteState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Idle)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 107300043;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
            super(null);
        }
    }

    private DeleteState() {
    }

    /* JADX INFO: compiled from: DeleteState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/enums/DeleteState$Deleting;", "Lcom/example/bingwahybrid/domain/enums/DeleteState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Deleting extends DeleteState {
        public static final int $stable = 0;
        public static final Deleting INSTANCE = new Deleting();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Deleting)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1124504863;
        }

        public String toString() {
            return "Deleting";
        }

        private Deleting() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DeleteState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/enums/DeleteState$Deleted;", "Lcom/example/bingwahybrid/domain/enums/DeleteState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Deleted extends DeleteState {
        public static final int $stable = 0;
        public static final Deleted INSTANCE = new Deleted();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Deleted)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1006105538;
        }

        public String toString() {
            return "Deleted";
        }

        private Deleted() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DeleteState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/enums/DeleteState$Failed;", "Lcom/example/bingwahybrid/domain/enums/DeleteState;", "error", "", "<init>", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Failed extends DeleteState {
        public static final int $stable = 0;
        private final String error;

        public static /* synthetic */ Failed copy$default(Failed failed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failed.error;
            }
            return failed.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getError() {
            return this.error;
        }

        public final Failed copy(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Failed(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failed) && Intrinsics.areEqual(this.error, ((Failed) other).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Failed(error=" + this.error + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failed(String error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final String getError() {
            return this.error;
        }
    }
}
