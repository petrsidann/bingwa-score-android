package com.example.bingwahybrid.domain.validation.usecase;

import com.example.bingwahybrid.domain.repository.DeviceSettingsRepository;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import com.example.bingwahybrid.domain.utils.Responses;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ValidateStartupUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\tH\u0002J\u000e\u0010\f\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/validation/usecase/ValidateStartupUseCase;", "", "deviceSettingsRepository", "Lcom/example/bingwahybrid/domain/repository/DeviceSettingsRepository;", "tokenRepository", "Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/DeviceSettingsRepository;Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateDeviceTime", "validateAccessToken", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ValidateStartupUseCase {
    public static final int $stable = 0;
    private final DeviceSettingsRepository deviceSettingsRepository;
    private final TokenRepository tokenRepository;

    @Inject
    public ValidateStartupUseCase(DeviceSettingsRepository deviceSettingsRepository, TokenRepository tokenRepository) {
        Intrinsics.checkNotNullParameter(deviceSettingsRepository, "deviceSettingsRepository");
        Intrinsics.checkNotNullParameter(tokenRepository, "tokenRepository");
        this.deviceSettingsRepository = deviceSettingsRepository;
        this.tokenRepository = tokenRepository;
    }

    public final Object invoke(Continuation<? super Unit> continuation) throws Exception {
        validateDeviceTime();
        Object objValidateAccessToken = validateAccessToken(continuation);
        return objValidateAccessToken == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objValidateAccessToken : Unit.INSTANCE;
    }

    private final void validateDeviceTime() throws Exception {
        if (!this.deviceSettingsRepository.isAutoTimeEnabled()) {
            throw new Exception(Responses.AUTOMATIC_TIME_DISABLED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object validateAccessToken(Continuation<? super Unit> continuation) {
        Object objValidateAccessToken = this.tokenRepository.validateAccessToken(continuation);
        return objValidateAccessToken == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objValidateAccessToken : Unit.INSTANCE;
    }
}
