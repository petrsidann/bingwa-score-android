package com.example.bingwahybrid.domain.ussd.enums;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UssdSessionState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/example/bingwahybrid/domain/ussd/enums/UssdSessionState;", "", "<init>", "()V", "Processing", "Success", "Failure", "Lcom/example/bingwahybrid/domain/ussd/enums/UssdSessionState$Failure;", "Lcom/example/bingwahybrid/domain/ussd/enums/UssdSessionState$Processing;", "Lcom/example/bingwahybrid/domain/ussd/enums/UssdSessionState$Success;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class UssdSessionState {
    public static final int $stable = 0;

    public /* synthetic */ UssdSessionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: UssdSessionState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/ussd/enums/UssdSessionState$Processing;", "Lcom/example/bingwahybrid/domain/ussd/enums/UssdSessionState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Processing extends UssdSessionState {
        public static final int $stable = 0;
        public static final Processing INSTANCE = new Processing();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Processing)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 858011727;
        }

        public String toString() {
            return "Processing";
        }

        private Processing() {
            super(null);
        }
    }

    private UssdSessionState() {
    }

    /* JADX INFO: compiled from: UssdSessionState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/ussd/enums/UssdSessionState$Success;", "Lcom/example/bingwahybrid/domain/ussd/enums/UssdSessionState;", "response", "", "<init>", "(Ljava/lang/String;)V", "getResponse", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Success extends UssdSessionState {
        public static final int $stable = 0;
        private final String response;

        public static /* synthetic */ Success copy$default(Success success, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.response;
            }
            return success.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getResponse() {
            return this.response;
        }

        public final Success copy(String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            return new Success(response);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.response, ((Success) other).response);
        }

        public int hashCode() {
            return this.response.hashCode();
        }

        public String toString() {
            return "Success(response=" + this.response + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String response) {
            super(null);
            Intrinsics.checkNotNullParameter(response, "response");
            this.response = response;
        }

        public final String getResponse() {
            return this.response;
        }
    }

    /* JADX INFO: compiled from: UssdSessionState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/ussd/enums/UssdSessionState$Failure;", "Lcom/example/bingwahybrid/domain/ussd/enums/UssdSessionState;", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Failure extends UssdSessionState {
        public static final int $stable = 0;
        private final String reason;

        public static /* synthetic */ Failure copy$default(Failure failure, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failure.reason;
            }
            return failure.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final Failure copy(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Failure(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failure) && Intrinsics.areEqual(this.reason, ((Failure) other).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Failure(reason=" + this.reason + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(String reason) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final String getReason() {
            return this.reason;
        }
    }
}
