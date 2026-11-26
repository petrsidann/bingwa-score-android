package com.example.bingwahybrid.domain.hybridconnect.enums;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConnectionState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState;", "", "<init>", "()V", "Disconnected", "Connecting", "Connected", "Reconnecting", "FatalError", "Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState$Connected;", "Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState$Connecting;", "Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState$Disconnected;", "Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState$FatalError;", "Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState$Reconnecting;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ConnectionState {
    public static final int $stable = 0;

    public /* synthetic */ ConnectionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: ConnectionState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState$Disconnected;", "Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState;", "<init>", "()V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Disconnected extends ConnectionState {
        public static final int $stable = 0;
        public static final Disconnected INSTANCE = new Disconnected();

        private Disconnected() {
            super(null);
        }
    }

    private ConnectionState() {
    }

    /* JADX INFO: compiled from: ConnectionState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState$Connecting;", "Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState;", "<init>", "()V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Connecting extends ConnectionState {
        public static final int $stable = 0;
        public static final Connecting INSTANCE = new Connecting();

        private Connecting() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ConnectionState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState$Connected;", "Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState;", "<init>", "()V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Connected extends ConnectionState {
        public static final int $stable = 0;
        public static final Connected INSTANCE = new Connected();

        private Connected() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ConnectionState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState$Reconnecting;", "Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState;", "<init>", "()V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Reconnecting extends ConnectionState {
        public static final int $stable = 0;
        public static final Reconnecting INSTANCE = new Reconnecting();

        private Reconnecting() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ConnectionState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState$FatalError;", "Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FatalError extends ConnectionState {
        public static final int $stable = 0;
        private final String message;

        public static /* synthetic */ FatalError copy$default(FatalError fatalError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fatalError.message;
            }
            return fatalError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final FatalError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new FatalError(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FatalError) && Intrinsics.areEqual(this.message, ((FatalError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "FatalError(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FatalError(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}
