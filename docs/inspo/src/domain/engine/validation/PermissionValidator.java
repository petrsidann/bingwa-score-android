package com.example.bingwahybrid.domain.engine.validation;

import android.app.Activity;
import android.content.Context;
import com.example.bingwahybrid.domain.engine.validation.enums.ValidationResult;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.usecase.PermissionHandlerUseCase;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionValidator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/validation/PermissionValidator;", "Lcom/example/bingwahybrid/domain/engine/validation/TransactionValidator;", "permissionHandler", "Lcom/example/bingwahybrid/domain/usecase/PermissionHandlerUseCase;", "context", "Landroid/content/Context;", "<init>", "(Lcom/example/bingwahybrid/domain/usecase/PermissionHandlerUseCase;Landroid/content/Context;)V", "validate", "Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult;", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PermissionValidator implements TransactionValidator {
    public static final int $stable = 8;
    private final Context context;
    private final PermissionHandlerUseCase permissionHandler;

    @Inject
    public PermissionValidator(PermissionHandlerUseCase permissionHandler, @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(permissionHandler, "permissionHandler");
        Intrinsics.checkNotNullParameter(context, "context");
        this.permissionHandler = permissionHandler;
        this.context = context;
    }

    @Override // com.example.bingwahybrid.domain.engine.validation.TransactionValidator
    public Object validate(Transaction transaction, Continuation<? super ValidationResult> continuation) {
        if (!this.permissionHandler.hasNecessaryPermissions()) {
            PermissionHandlerUseCase permissionHandlerUseCase = this.permissionHandler;
            Context context = this.context;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            permissionHandlerUseCase.requestNecessaryPermissions((Activity) context);
            return new ValidationResult.Failure(TransactionStatus.FAILED, "Missing necessary permissions");
        }
        return ValidationResult.Success.INSTANCE;
    }
}
