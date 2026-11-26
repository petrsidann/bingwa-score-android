package com.example.bingwahybrid.domain.utils;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SnackbarManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/utils/SnackbarManager;", "", "<init>", "()V", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "init", "", "showMessage", "scope", "Lkotlinx/coroutines/CoroutineScope;", "message", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SnackbarManager {
    private static SnackbarHostState snackbarHostState;
    public static final SnackbarManager INSTANCE = new SnackbarManager();
    public static final int $stable = 8;

    private SnackbarManager() {
    }

    public final void init(SnackbarHostState snackbarHostState2) {
        Intrinsics.checkNotNullParameter(snackbarHostState2, "snackbarHostState");
        snackbarHostState = snackbarHostState2;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.utils.SnackbarManager$showMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: SnackbarManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.utils.SnackbarManager$showMessage$1", f = "SnackbarManager.kt", i = {}, l = {17}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $message;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$message = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SnackbarHostState snackbarHostState = SnackbarManager.snackbarHostState;
                if (snackbarHostState != null) {
                    this.label = 1;
                    obj = SnackbarHostState.showSnackbar$default(snackbarHostState, this.$message, null, false, SnackbarDuration.Short, this, 6, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    public final void showMessage(CoroutineScope scope, String message) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(message, "message");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(message, null), 3, null);
    }
}
