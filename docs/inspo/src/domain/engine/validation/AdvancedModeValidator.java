package com.example.bingwahybrid.domain.engine.validation;

import com.example.bingwahybrid.domain.engine.validation.enums.ValidationResult;
import com.example.bingwahybrid.domain.enums.ProcessingMode;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.AccessibilityRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdvancedModeValidator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/validation/AdvancedModeValidator;", "Lcom/example/bingwahybrid/domain/engine/validation/TransactionValidator;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "accessibilityRepository", "Lcom/example/bingwahybrid/domain/repository/AccessibilityRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/repository/AccessibilityRepository;)V", "validate", "Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult;", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdvancedModeValidator implements TransactionValidator {
    public static final int $stable = 0;
    private final AccessibilityRepository accessibilityRepository;
    private final SettingsRepository settingsRepository;

    @Inject
    public AdvancedModeValidator(SettingsRepository settingsRepository, AccessibilityRepository accessibilityRepository) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(accessibilityRepository, "accessibilityRepository");
        this.settingsRepository = settingsRepository;
        this.accessibilityRepository = accessibilityRepository;
    }

    @Override // com.example.bingwahybrid.domain.engine.validation.TransactionValidator
    public Object validate(Transaction transaction, Continuation<? super ValidationResult> continuation) {
        boolean z = this.settingsRepository.getProcessingMode().getValue() == ProcessingMode.ADVANCED;
        boolean zBooleanValue = this.accessibilityRepository.isAccessibilityServiceEnabled().getValue().booleanValue();
        if (z && !zBooleanValue) {
            return new ValidationResult.Failure(TransactionStatus.FAILED, "Failed. Advanced Mode requires Accessibility service to be enabled. Please enable it in phone's settings then retry");
        }
        return ValidationResult.Success.INSTANCE;
    }
}
