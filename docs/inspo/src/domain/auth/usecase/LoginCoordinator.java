package com.example.bingwahybrid.domain.auth.usecase;

import android.util.Log;
import com.example.bingwahybrid.domain.repository.PaymentRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086B¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/example/bingwahybrid/domain/auth/usecase/LoginCoordinator;", "", "loginUserUseCase", "Lcom/example/bingwahybrid/domain/auth/usecase/LoginUserUseCase;", "paymentRepository", "Lcom/example/bingwahybrid/domain/repository/PaymentRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/auth/usecase/LoginUserUseCase;Lcom/example/bingwahybrid/domain/repository/PaymentRepository;)V", "invoke", "", "email", "", "pin", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncPaymentInformation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LoginCoordinator {
    public static final int $stable = 8;
    private final LoginUserUseCase loginUserUseCase;
    private final PaymentRepository paymentRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.auth.usecase.LoginCoordinator$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoginCoordinator.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.auth.usecase.LoginCoordinator", f = "LoginCoordinator.kt", i = {0, 0, 1, 1}, l = {17, 18}, m = "invoke", n = {"email", "pin", "email", "pin"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginCoordinator.this.invoke(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.auth.usecase.LoginCoordinator$syncPaymentInformation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoginCoordinator.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.auth.usecase.LoginCoordinator", f = "LoginCoordinator.kt", i = {}, l = {26, 27}, m = "syncPaymentInformation", n = {}, s = {})
    static final class C06711 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06711(Continuation<? super C06711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginCoordinator.this.syncPaymentInformation(this);
        }
    }

    @Inject
    public LoginCoordinator(LoginUserUseCase loginUserUseCase, PaymentRepository paymentRepository) {
        Intrinsics.checkNotNullParameter(loginUserUseCase, "loginUserUseCase");
        Intrinsics.checkNotNullParameter(paymentRepository, "paymentRepository");
        this.loginUserUseCase = loginUserUseCase;
        this.paymentRepository = paymentRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0076, code lost:
    
        if (syncPaymentInformation(r0) == r1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(String str, String str2, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LoginUserUseCase loginUserUseCase = this.loginUserUseCase;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.label = 1;
            if (loginUserUseCase.invoke(str, str2, anonymousClass1) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            str2 = (String) anonymousClass1.L$1;
            str = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
        anonymousClass1.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
    
        if (r5.getAdminSubscriptionNumber(r0) == r1) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object syncPaymentInformation(Continuation<? super Unit> continuation) {
        C06711 c06711;
        if (continuation instanceof C06711) {
            c06711 = (C06711) continuation;
            if ((c06711.label & Integer.MIN_VALUE) != 0) {
                c06711.label -= Integer.MIN_VALUE;
            } else {
                c06711 = new C06711(continuation);
            }
        } else {
            c06711 = new C06711(continuation);
        }
        Object obj = c06711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06711.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PaymentRepository paymentRepository = this.paymentRepository;
                c06711.label = 1;
                if (paymentRepository.getAdminSiteLinkNumber(c06711) == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            PaymentRepository paymentRepository2 = this.paymentRepository;
            c06711.label = 2;
        } catch (Exception e) {
            Log.d("LoginCoordinator", e.getMessage(), e);
        }
    }
}
