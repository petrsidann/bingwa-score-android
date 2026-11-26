package com.example.bingwahybrid.presentation.ui.components;

import android.util.Log;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1", f = "LongPressFloatingActionButton.kt", i = {}, l = {92, 93}, m = "invokeSuspend", n = {}, s = {})
final class LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Job> $animationJob$delegate;
    final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
    final /* synthetic */ MutableState<Job> $longPressJob$delegate;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $progressAnimatable;
    final /* synthetic */ boolean $shouldCancel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(boolean z, Animatable<Float, AnimationVector1D> animatable, MutableState<Boolean> mutableState, MutableState<Job> mutableState2, MutableState<Job> mutableState3, Continuation<? super LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1> continuation) {
        super(2, continuation);
        this.$shouldCancel = z;
        this.$progressAnimatable = animatable;
        this.$isPressed$delegate = mutableState;
        this.$animationJob$delegate = mutableState2;
        this.$longPressJob$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(this.$shouldCancel, this.$progressAnimatable, this.$isPressed$delegate, this.$animationJob$delegate, this.$longPressJob$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:
    
        if (r4.$progressAnimatable.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(0.0f), r4) == r0) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (this.$shouldCancel && LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$1(this.$isPressed$delegate)) {
            Log.d("LongPressFAB", "Cancellation triggered");
            Job jobLongPressFloatingActionButton_8r3B23s$lambda$7 = LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$7(this.$animationJob$delegate);
            if (jobLongPressFloatingActionButton_8r3B23s$lambda$7 != null) {
                Job.DefaultImpls.cancel$default(jobLongPressFloatingActionButton_8r3B23s$lambda$7, (CancellationException) null, 1, (Object) null);
            }
            Job jobLongPressFloatingActionButton_8r3B23s$lambda$4 = LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$4(this.$longPressJob$delegate);
            if (jobLongPressFloatingActionButton_8r3B23s$lambda$4 != null) {
                Job.DefaultImpls.cancel$default(jobLongPressFloatingActionButton_8r3B23s$lambda$4, (CancellationException) null, 1, (Object) null);
            }
            this.label = 1;
            if (this.$progressAnimatable.stop(this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
        this.label = 2;
    }
}
