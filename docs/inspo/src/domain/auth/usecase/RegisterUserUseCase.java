package com.example.bingwahybrid.domain.auth.usecase;

import com.example.bingwahybrid.domain.auth.models.Agent;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RegisterUserUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/auth/usecase/RegisterUserUseCase;", "", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;)V", "invoke", "", "agent", "Lcom/example/bingwahybrid/domain/auth/models/Agent;", "(Lcom/example/bingwahybrid/domain/auth/models/Agent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RegisterUserUseCase {
    public static final int $stable = 8;
    private final AuthRepository authRepository;

    @Inject
    public RegisterUserUseCase(AuthRepository authRepository) {
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        this.authRepository = authRepository;
    }

    public final Object invoke(Agent agent, Continuation<? super Unit> continuation) {
        Object objRegisterAgent = this.authRepository.registerAgent(agent, continuation);
        return objRegisterAgent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRegisterAgent : Unit.INSTANCE;
    }
}
