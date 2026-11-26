package com.example.bingwahybrid.presentation.navigation;

import androidx.compose.runtime.MutableState;
import com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NavGraph.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.navigation.NavGraphKt$NavGraph$1$1", f = "NavGraph.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NavGraphKt$NavGraph$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isNavigated;
    final /* synthetic */ SettingsViewModel $settingsViewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavGraphKt$NavGraph$1$1(SettingsViewModel settingsViewModel, MutableState<Boolean> mutableState, Continuation<? super NavGraphKt$NavGraph$1$1> continuation) {
        super(2, continuation);
        this.$settingsViewModel = settingsViewModel;
        this.$isNavigated = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NavGraphKt$NavGraph$1$1(this.$settingsViewModel, this.$isNavigated, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NavGraphKt$NavGraph$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$settingsViewModel.initializeApp();
        this.$isNavigated.setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
