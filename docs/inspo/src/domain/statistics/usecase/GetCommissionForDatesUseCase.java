package com.example.bingwahybrid.domain.statistics.usecase;

import com.example.bingwahybrid.domain.repository.AgentCommissionRepository;
import com.example.bingwahybrid.domain.statistics.model.AgentCommission;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: GetCommissionForDatesUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH\u0086B¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/example/bingwahybrid/domain/statistics/usecase/GetCommissionForDatesUseCase;", "", "agentCommissionRepository", "Lcom/example/bingwahybrid/domain/repository/AgentCommissionRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/AgentCommissionRepository;)V", "agentCommissions", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/bingwahybrid/domain/statistics/model/AgentCommission;", "getAgentCommissions", "()Lkotlinx/coroutines/flow/StateFlow;", "invoke", "dates", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetCommissionForDatesUseCase {
    public static final int $stable = 8;
    private final AgentCommissionRepository agentCommissionRepository;
    private final StateFlow<List<AgentCommission>> agentCommissions;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.statistics.usecase.GetCommissionForDatesUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetCommissionForDatesUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.statistics.usecase.GetCommissionForDatesUseCase", f = "GetCommissionForDatesUseCase.kt", i = {0}, l = {15}, m = "invoke", n = {"dates"}, s = {"L$0"})
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
            return GetCommissionForDatesUseCase.this.invoke(null, this);
        }
    }

    @Inject
    public GetCommissionForDatesUseCase(AgentCommissionRepository agentCommissionRepository) {
        Intrinsics.checkNotNullParameter(agentCommissionRepository, "agentCommissionRepository");
        this.agentCommissionRepository = agentCommissionRepository;
        this.agentCommissions = agentCommissionRepository.getAgentCommissions();
    }

    public final StateFlow<List<AgentCommission>> getAgentCommissions() {
        return this.agentCommissions;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(List<String> list, Continuation<? super StateFlow<? extends List<AgentCommission>>> continuation) {
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
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AgentCommissionRepository agentCommissionRepository = this.agentCommissionRepository;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list);
            anonymousClass1.label = 1;
            if (agentCommissionRepository.fetchCommissionForDates(list, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return this.agentCommissions;
    }
}
