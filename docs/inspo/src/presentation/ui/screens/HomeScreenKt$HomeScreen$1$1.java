package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.runtime.State;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.PopUpToBuilder;
import com.example.bingwahybrid.domain.enums.AccountHealthStatus;
import com.example.bingwahybrid.presentation.navigation.Route;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HomeScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$HomeScreen$1$1", f = "HomeScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HomeScreenKt$HomeScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<AccountHealthStatus> $accountHealthStatus$delegate;
    final /* synthetic */ NavHostController $navController;
    int label;

    /* JADX INFO: compiled from: HomeScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AccountHealthStatus.values().length];
            try {
                iArr[AccountHealthStatus.HEALTHY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HomeScreenKt$HomeScreen$1$1(NavHostController navHostController, State<? extends AccountHealthStatus> state, Continuation<? super HomeScreenKt$HomeScreen$1$1> continuation) {
        super(2, continuation);
        this.$navController = navHostController;
        this.$accountHealthStatus$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeScreenKt$HomeScreen$1$1(this.$navController, this.$accountHealthStatus$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeScreenKt$HomeScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (WhenMappings.$EnumSwitchMapping$0[HomeScreenKt.HomeScreen$lambda$11(this.$accountHealthStatus$delegate).ordinal()] != 1) {
                this.$navController.navigate(Route.Login.INSTANCE.getName(), new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$HomeScreen$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return HomeScreenKt$HomeScreen$1$1.invokeSuspend$lambda$1((NavOptionsBuilder) obj2);
                    }
                });
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(NavOptionsBuilder navOptionsBuilder) {
        navOptionsBuilder.popUpTo(Route.Login.INSTANCE.getName(), new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$HomeScreen$1$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeScreenKt$HomeScreen$1$1.invokeSuspend$lambda$1$lambda$0((PopUpToBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$lambda$0(PopUpToBuilder popUpToBuilder) {
        popUpToBuilder.setInclusive(true);
        return Unit.INSTANCE;
    }
}
