package com.example.bingwahybrid.domain.engine.validation.enums;

import androidx.core.app.NotificationCompat;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ValidationResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult;", "", "<init>", "()V", "Success", "Failure", "Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult$Failure;", "Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult$Success;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ValidationResult {
    public static final int $stable = 0;

    public /* synthetic */ ValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: ValidationResult.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult$Success;", "Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult;", "<init>", "()V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Success extends ValidationResult {
        public static final int $stable = 0;
        public static final Success INSTANCE = new Success();

        private Success() {
            super(null);
        }
    }

    private ValidationResult() {
    }

    /* JADX INFO: compiled from: ValidationResult.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult$Failure;", "Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult;", NotificationCompat.CATEGORY_STATUS, "Lcom/example/bingwahybrid/domain/enums/TransactionStatus;", "message", "", "<init>", "(Lcom/example/bingwahybrid/domain/enums/TransactionStatus;Ljava/lang/String;)V", "getStatus", "()Lcom/example/bingwahybrid/domain/enums/TransactionStatus;", "getMessage", "()Ljava/lang/String;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Failure extends ValidationResult {
        public static final int $stable = 0;
        private final String message;
        private final TransactionStatus status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(TransactionStatus status, String message) {
            super(null);
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(message, "message");
            this.status = status;
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }

        public final TransactionStatus getStatus() {
            return this.status;
        }
    }
}
