package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.runtime.State;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.PopUpToBuilder;
import com.example.bingwahybrid.domain.utils.SnackbarManager;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: HomeScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$HomeScreen$2$1", f = "HomeScreen.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
final class HomeScreenKt$HomeScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $logoutSuccess$delegate;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeScreenKt$HomeScreen$2$1(CoroutineScope coroutineScope, State<Boolean> state, NavHostController navHostController, Continuation<? super HomeScreenKt$HomeScreen$2$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$logoutSuccess$delegate = state;
        this.$navController = navHostController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeScreenKt$HomeScreen$2$1(this.$scope, this.$logoutSuccess$delegate, this.$navController, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeScreenKt$HomeScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (HomeScreenKt.HomeScreen$lambda$22(this.$logoutSuccess$delegate)) {
                SnackbarManager.INSTANCE.showMessage(this.$scope, "Logout Success");
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$navController, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$HomeScreen$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$HomeScreen$2$1$1", f = "HomeScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NavHostController $navController;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NavHostController navHostController, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$navController = navHostController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$navController, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$navController.navigate(Route.Login.INSTANCE.getName(), new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$HomeScreen$2$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return HomeScreenKt$HomeScreen$2$1.AnonymousClass1.invokeSuspend$lambda$1((NavOptionsBuilder) obj2);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(NavOptionsBuilder navOptionsBuilder) {
            navOptionsBuilder.popUpTo(0, new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.HomeScreenKt$HomeScreen$2$1$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HomeScreenKt$HomeScreen$2$1.AnonymousClass1.invokeSuspend$lambda$1$lambda$0((PopUpToBuilder) obj);
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
}
