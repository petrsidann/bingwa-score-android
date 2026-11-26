package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.runtime.State;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.example.bingwahybrid.presentation.navigation.Route;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PinSetupScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.screens.PinSetupScreenKt$PinSetupScreen$1$1", f = "PinSetupScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PinSetupScreenKt$PinSetupScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ State<Boolean> $pinSetupSuccess$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PinSetupScreenKt$PinSetupScreen$1$1(NavHostController navHostController, State<Boolean> state, Continuation<? super PinSetupScreenKt$PinSetupScreen$1$1> continuation) {
        super(2, continuation);
        this.$navController = navHostController;
        this.$pinSetupSuccess$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PinSetupScreenKt$PinSetupScreen$1$1(this.$navController, this.$pinSetupSuccess$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PinSetupScreenKt$PinSetupScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        NavHostController navHostController;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (PinSetupScreenKt.PinSetupScreen$lambda$5(this.$pinSetupSuccess$delegate) && (navHostController = this.$navController) != null) {
                NavController.navigate$default((NavController) navHostController, Route.Home.INSTANCE.getName(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
