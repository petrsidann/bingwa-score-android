package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.CommissionRateRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: GetCommissionUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0086B¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/GetCommissionUseCase;", "", "commissionRateRepository", "Lcom/example/bingwahybrid/domain/repository/CommissionRateRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/CommissionRateRepository;)V", "invoke", "", "amount", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetCommissionUseCase {
    public static final int $stable = 8;
    private final CommissionRateRepository commissionRateRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.GetCommissionUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetCommissionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.GetCommissionUseCase", f = "GetCommissionUseCase.kt", i = {0}, l = {11}, m = "invoke", n = {"amount"}, s = {"I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetCommissionUseCase.this.invoke(0, this);
        }
    }

    @Inject
    public GetCommissionUseCase(CommissionRateRepository commissionRateRepository) {
        Intrinsics.checkNotNullParameter(commissionRateRepository, "commissionRateRepository");
        this.commissionRateRepository = commissionRateRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(int i, Continuation<? super Integer> continuation) {
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
        Object commissionRateForAmount = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(commissionRateForAmount);
            CommissionRateRepository commissionRateRepository = this.commissionRateRepository;
            anonymousClass1.I$0 = i;
            anonymousClass1.label = 1;
            commissionRateForAmount = commissionRateRepository.getCommissionRateForAmount(i, anonymousClass1);
            if (commissionRateForAmount == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = anonymousClass1.I$0;
            ResultKt.throwOnFailure(commissionRateForAmount);
        }
        return Boxing.boxInt(MathKt.roundToInt(((Number) commissionRateForAmount).doubleValue() * ((double) i)));
    }
}
