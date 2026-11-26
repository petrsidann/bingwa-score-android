package com.example.bingwahybrid.presentation.offers.screens;

import androidx.compose.runtime.State;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AddOrEditOfferScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1", f = "AddOrEditOfferScreen.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
final class AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $addOfferSuccess$delegate;
    final /* synthetic */ State<Boolean> $editOfferSuccess$delegate;
    final /* synthetic */ NavHostController $navController;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1(State<Boolean> state, State<Boolean> state2, NavHostController navHostController, Continuation<? super AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1> continuation) {
        super(2, continuation);
        this.$editOfferSuccess$delegate = state;
        this.$addOfferSuccess$delegate = state2;
        this.$navController = navHostController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1(this.$editOfferSuccess$delegate, this.$addOfferSuccess$delegate, this.$navController, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$3(this.$editOfferSuccess$delegate) || AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$4(this.$addOfferSuccess$delegate)) {
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

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: AddOrEditOfferScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1$1", f = "AddOrEditOfferScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            NavHostController navHostController = this.$navController;
            if (navHostController != null) {
                Boxing.boxBoolean(navHostController.popBackStack());
            }
            return Unit.INSTANCE;
        }
    }
}
