package com.example.bingwahybrid.presentation.ui.components;

import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SearchBox.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.SearchBoxKt$SearchBox$1$1", f = "SearchBox.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SearchBoxKt$SearchBox$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ SoftwareKeyboardController $keyboardController;
    final /* synthetic */ boolean $requestFocus;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchBoxKt$SearchBox$1$1(boolean z, FocusRequester focusRequester, SoftwareKeyboardController softwareKeyboardController, Continuation<? super SearchBoxKt$SearchBox$1$1> continuation) {
        super(2, continuation);
        this.$requestFocus = z;
        this.$focusRequester = focusRequester;
        this.$keyboardController = softwareKeyboardController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchBoxKt$SearchBox$1$1(this.$requestFocus, this.$focusRequester, this.$keyboardController, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchBoxKt$SearchBox$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$requestFocus) {
            FocusRequester.m5603requestFocus3ESFkO8$default(this.$focusRequester, 0, 1, null);
            SoftwareKeyboardController softwareKeyboardController = this.$keyboardController;
            if (softwareKeyboardController != null) {
                softwareKeyboardController.show();
            }
        }
        return Unit.INSTANCE;
    }
}
