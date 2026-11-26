package com.example.bingwahybrid.domain.auth.usecase;

import android.util.Log;
import com.example.bingwahybrid.domain.auth.models.Agent;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateAgentUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/auth/usecase/UpdateAgentUseCase;", "", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;)V", "invoke", "", "agent", "Lcom/example/bingwahybrid/domain/auth/models/Agent;", "(Lcom/example/bingwahybrid/domain/auth/models/Agent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdateAgentUseCase {
    public static final int $stable = 8;
    private final AuthRepository authRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.auth.usecase.UpdateAgentUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: UpdateAgentUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.auth.usecase.UpdateAgentUseCase", f = "UpdateAgentUseCase.kt", i = {0, 1}, l = {15, 16}, m = "invoke", n = {"agent", "agent"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdateAgentUseCase.this.invoke(null, this);
        }
    }

    @Inject
    public UpdateAgentUseCase(AuthRepository authRepository) {
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        this.authRepository = authRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        if (r5.saveAgent(r6, r0) == r1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Agent agent, Continuation<? super Unit> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AuthRepository authRepository = this.authRepository;
                anonymousClass1.L$0 = agent;
                anonymousClass1.label = 1;
                if (authRepository.updateAgentRemote(agent, anonymousClass1) == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                agent = (Agent) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            AuthRepository authRepository2 = this.authRepository;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(agent);
            anonymousClass1.label = 2;
        } catch (Exception e) {
            Log.e("UpdateAgentUseCase", String.valueOf(e.getMessage()));
            e.printStackTrace();
            throw e;
        }
    }
}
