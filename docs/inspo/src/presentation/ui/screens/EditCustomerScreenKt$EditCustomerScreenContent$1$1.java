package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: EditCustomerScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$EditCustomerScreenContent$1$1", f = "EditCustomerScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EditCustomerScreenKt$EditCustomerScreenContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $deleteSuccess;
    final /* synthetic */ MutableState<Boolean> $showDeleteCustomerDialog$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditCustomerScreenKt$EditCustomerScreenContent$1$1(boolean z, MutableState<Boolean> mutableState, Continuation<? super EditCustomerScreenKt$EditCustomerScreenContent$1$1> continuation) {
        super(2, continuation);
        this.$deleteSuccess = z;
        this.$showDeleteCustomerDialog$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditCustomerScreenKt$EditCustomerScreenContent$1$1(this.$deleteSuccess, this.$showDeleteCustomerDialog$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EditCustomerScreenKt$EditCustomerScreenContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$deleteSuccess) {
            EditCustomerScreenKt.EditCustomerScreenContent$lambda$29(this.$showDeleteCustomerDialog$delegate, false);
        }
        return Unit.INSTANCE;
    }
}
