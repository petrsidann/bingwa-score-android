package com.example.bingwahybrid.presentation.transactions.screens;

import androidx.compose.runtime.MutableLongState;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RescheduleTransactionScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$RescheduleOfferScreenContent$2$1", f = "RescheduleTransactionScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RescheduleTransactionScreenKt$RescheduleOfferScreenContent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableLongState $selectedDateMillis$delegate;
    final /* synthetic */ MutableLongState $selectedDateTime$delegate;
    final /* synthetic */ MutableLongState $selectedTimeMillis$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RescheduleTransactionScreenKt$RescheduleOfferScreenContent$2$1(MutableLongState mutableLongState, MutableLongState mutableLongState2, MutableLongState mutableLongState3, Continuation<? super RescheduleTransactionScreenKt$RescheduleOfferScreenContent$2$1> continuation) {
        super(2, continuation);
        this.$selectedDateMillis$delegate = mutableLongState;
        this.$selectedTimeMillis$delegate = mutableLongState2;
        this.$selectedDateTime$delegate = mutableLongState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RescheduleTransactionScreenKt$RescheduleOfferScreenContent$2$1(this.$selectedDateMillis$delegate, this.$selectedTimeMillis$delegate, this.$selectedDateTime$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RescheduleTransactionScreenKt$RescheduleOfferScreenContent$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(RescheduleTransactionScreenKt.RescheduleOfferScreenContent$lambda$28(this.$selectedDateMillis$delegate));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(RescheduleTransactionScreenKt.RescheduleOfferScreenContent$lambda$31(this.$selectedTimeMillis$delegate));
        calendar.set(11, calendar2.get(11));
        calendar.set(12, calendar2.get(12));
        this.$selectedDateTime$delegate.setLongValue(calendar.getTimeInMillis());
        return Unit.INSTANCE;
    }
}
