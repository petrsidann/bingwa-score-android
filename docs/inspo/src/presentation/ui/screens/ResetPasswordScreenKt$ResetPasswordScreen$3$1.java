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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ResetPasswordScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.screens.ResetPasswordScreenKt$ResetPasswordScreen$3$1", f = "ResetPasswordScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResetPasswordScreenKt$ResetPasswordScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<String> $email$delegate;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ State<Boolean> $sendSuccess$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ResetPasswordScreenKt$ResetPasswordScreen$3$1(NavHostController navHostController, State<Boolean> state, State<String> state2, Continuation<? super ResetPasswordScreenKt$ResetPasswordScreen$3$1> continuation) {
        super(2, continuation);
        this.$navController = navHostController;
        this.$sendSuccess$delegate = state;
        this.$email$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResetPasswordScreenKt$ResetPasswordScreen$3$1(this.$navController, this.$sendSuccess$delegate, this.$email$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ResetPasswordScreenKt$ResetPasswordScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (ResetPasswordScreenKt.ResetPasswordScreen$lambda$4(this.$sendSuccess$delegate)) {
                NavController.navigate$default((NavController) this.$navController, StringsKt.replace$default(Route.OtpVerification.INSTANCE.getName(), "{email}", ResetPasswordScreenKt.ResetPasswordScreen$lambda$0(this.$email$delegate), false, 4, (Object) null), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
