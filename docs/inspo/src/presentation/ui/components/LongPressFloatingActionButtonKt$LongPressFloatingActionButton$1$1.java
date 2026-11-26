package com.example.bingwahybrid.presentation.ui.components;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.MutableState;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1", f = "LongPressFloatingActionButton.kt", i = {}, l = {LockFreeTaskQueueCore.FROZEN_SHIFT, 81, 82}, m = "invokeSuspend", n = {}, s = {})
final class LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Job> $animationJob$delegate;
    final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
    final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
    final /* synthetic */ long $longPressDurationMs;
    final /* synthetic */ MutableState<Job> $longPressJob$delegate;
    final /* synthetic */ Function0<Unit> $onLongPress;
    final /* synthetic */ Function0<Unit> $onLongPressStart;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $progressAnimatable;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(Animatable<Float, AnimationVector1D> animatable, Function0<Unit> function0, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, long j, Function0<Unit> function1, MutableState<Job> mutableState3, MutableState<Job> mutableState4, Continuation<? super LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1> continuation) {
        super(2, continuation);
        this.$progressAnimatable = animatable;
        this.$onLongPressStart = function0;
        this.$scope = coroutineScope;
        this.$isPressed$delegate = mutableState;
        this.$hasLongPressed$delegate = mutableState2;
        this.$longPressDurationMs = j;
        this.$onLongPress = function1;
        this.$animationJob$delegate = mutableState3;
        this.$longPressJob$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(this.$progressAnimatable, this.$onLongPressStart, this.$scope, this.$isPressed$delegate, this.$hasLongPressed$delegate, this.$longPressDurationMs, this.$onLongPress, this.$animationJob$delegate, this.$longPressJob$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        if (r9.$progressAnimatable.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(0.0f), r9) == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:
    
        if (r9.$progressAnimatable.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(0.0f), r9) == r0) goto L32;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$1(this.$isPressed$delegate)) {
                LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$11(this.$hasLongPressed$delegate, false);
                this.label = 1;
            } else {
                Job jobLongPressFloatingActionButton_8r3B23s$lambda$7 = LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$7(this.$animationJob$delegate);
                if (jobLongPressFloatingActionButton_8r3B23s$lambda$7 != null) {
                    Job.DefaultImpls.cancel$default(jobLongPressFloatingActionButton_8r3B23s$lambda$7, (CancellationException) null, 1, (Object) null);
                }
                Job jobLongPressFloatingActionButton_8r3B23s$lambda$4 = LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$4(this.$longPressJob$delegate);
                if (jobLongPressFloatingActionButton_8r3B23s$lambda$4 != null) {
                    Job.DefaultImpls.cancel$default(jobLongPressFloatingActionButton_8r3B23s$lambda$4, (CancellationException) null, 1, (Object) null);
                }
                this.label = 2;
                if (this.$progressAnimatable.stop(this) != coroutine_suspended) {
                    this.label = 3;
                }
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
            Function0<Unit> function0 = this.$onLongPressStart;
            if (function0 != null) {
                function0.invoke();
            }
            this.$longPressJob$delegate.setValue(BuildersKt__Builders_commonKt.launch$default(this.$scope, null, null, new AnonymousClass1(this.$longPressDurationMs, this.$onLongPress, this.$progressAnimatable, this.$animationJob$delegate, this.$hasLongPressed$delegate, null), 3, null));
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.label = 3;
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {73}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<Job> $animationJob$delegate;
        final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
        final /* synthetic */ long $longPressDurationMs;
        final /* synthetic */ Function0<Unit> $onLongPress;
        final /* synthetic */ Animatable<Float, AnimationVector1D> $progressAnimatable;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, Function0<Unit> function0, Animatable<Float, AnimationVector1D> animatable, MutableState<Job> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$longPressDurationMs = j;
            this.$onLongPress = function0;
            this.$progressAnimatable = animatable;
            this.$animationJob$delegate = mutableState;
            this.$hasLongPressed$delegate = mutableState2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$longPressDurationMs, this.$onLongPress, this.$progressAnimatable, this.$animationJob$delegate, this.$hasLongPressed$delegate, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1$1$1", f = "LongPressFloatingActionButton.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
        static final class C01461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $longPressDurationMs;
            final /* synthetic */ Animatable<Float, AnimationVector1D> $progressAnimatable;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01461(Animatable<Float, AnimationVector1D> animatable, long j, Continuation<? super C01461> continuation) {
                super(2, continuation);
                this.$progressAnimatable = animatable;
                this.$longPressDurationMs = j;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01461(this.$progressAnimatable, this.$longPressDurationMs, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (Animatable.animateTo$default(this.$progressAnimatable, Boxing.boxFloat(1.0f), AnimationSpecKt.tween$default((int) this.$longPressDurationMs, 0, EasingKt.getLinearEasing(), 2, null), null, null, this, 12, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.$animationJob$delegate.setValue(BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01461(this.$progressAnimatable, this.$longPressDurationMs, null), 3, null));
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.label = 1;
                if (DelayKt.delay(this.$longPressDurationMs, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$11(this.$hasLongPressed$delegate, true);
            this.$onLongPress.invoke();
            return Unit.INSTANCE;
        }
    }
}
