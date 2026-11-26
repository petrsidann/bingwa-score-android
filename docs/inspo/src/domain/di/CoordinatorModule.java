package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.auth.usecase.LoginCoordinator;
import com.example.bingwahybrid.domain.auth.usecase.LoginUserUseCase;
import com.example.bingwahybrid.domain.repository.PaymentRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoordinatorModule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/example/bingwahybrid/domain/di/CoordinatorModule;", "", "<init>", "()V", "provideLoginCoordinator", "Lcom/example/bingwahybrid/domain/auth/usecase/LoginCoordinator;", "loginUserUseCase", "Lcom/example/bingwahybrid/domain/auth/usecase/LoginUserUseCase;", "paymentRepository", "Lcom/example/bingwahybrid/domain/repository/PaymentRepository;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class CoordinatorModule {
    public static final int $stable = 0;
    public static final CoordinatorModule INSTANCE = new CoordinatorModule();

    private CoordinatorModule() {
    }

    @Provides
    @Singleton
    public final LoginCoordinator provideLoginCoordinator(LoginUserUseCase loginUserUseCase, PaymentRepository paymentRepository) {
        Intrinsics.checkNotNullParameter(loginUserUseCase, "loginUserUseCase");
        Intrinsics.checkNotNullParameter(paymentRepository, "paymentRepository");
        return new LoginCoordinator(loginUserUseCase, paymentRepository);
    }
}
