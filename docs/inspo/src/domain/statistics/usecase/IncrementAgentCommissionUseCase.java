package com.example.bingwahybrid.domain.statistics.usecase;

import android.util.Log;
import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.repository.AgentCommissionRepository;
import com.example.bingwahybrid.domain.statistics.model.AgentCommission;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

/* JADX INFO: compiled from: IncrementAgentCommissionUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0086B¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/statistics/usecase/IncrementAgentCommissionUseCase;", "", "agentCommissionRepository", "Lcom/example/bingwahybrid/domain/repository/AgentCommissionRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/AgentCommissionRepository;)V", "invoke", "", "offer", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "(Lcom/example/bingwahybrid/domain/offers/model/Offer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IncrementAgentCommissionUseCase {
    public static final int $stable = 8;
    private final AgentCommissionRepository agentCommissionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.statistics.usecase.IncrementAgentCommissionUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: IncrementAgentCommissionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.statistics.usecase.IncrementAgentCommissionUseCase", f = "IncrementAgentCommissionUseCase.kt", i = {0, 0, 0, 0, 0, 0}, l = {29}, m = "invoke", n = {"offer", "it", "currentDate", "commission", "$i$a$-let-IncrementAgentCommissionUseCase$invoke$2", "commissionAmount"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "D$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        double D$0;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IncrementAgentCommissionUseCase.this.invoke(null, this);
        }
    }

    @Inject
    public IncrementAgentCommissionUseCase(AgentCommissionRepository agentCommissionRepository) {
        Intrinsics.checkNotNullParameter(agentCommissionRepository, "agentCommissionRepository");
        this.agentCommissionRepository = agentCommissionRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(Offer offer, Continuation<? super Unit> continuation) throws Exception {
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
                if (offer != null) {
                    if (offer.getTag() != null && offer.getType() == OfferType.DATA) {
                        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        double commissionForOffer = this.agentCommissionRepository.getCommissionForOffer(offer);
                        Intrinsics.checkNotNull(str);
                        AgentCommission agentCommission = new AgentCommission(str, commissionForOffer);
                        AgentCommissionRepository agentCommissionRepository = this.agentCommissionRepository;
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(offer);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(offer);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(agentCommission);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.D$0 = commissionForOffer;
                        anonymousClass1.label = 1;
                        if (agentCommissionRepository.addCommission(agentCommission, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            double d = anonymousClass1.D$0;
            int i2 = anonymousClass1.I$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } catch (Exception e) {
            Log.e("IncrementAgentCommissionUseCase", String.valueOf(e.getMessage()));
            throw e;
        }
    }
}
