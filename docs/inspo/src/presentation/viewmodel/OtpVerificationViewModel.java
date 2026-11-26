package com.example.bingwahybrid.presentation.viewmodel;

import androidx.compose.material.MenuKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.VerifyOtpUseCase;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: OtpVerificationViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010#\u001a\u00020\u001fH\u0002J\u0006\u0010$\u001a\u00020\u001fJ\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010&\u001a\u00020\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00110\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\rR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\r¨\u0006'"}, d2 = {"Lcom/example/bingwahybrid/presentation/viewmodel/OtpVerificationViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "verifyOtpUseCase", "Lcom/example/bingwahybrid/domain/auth/usecase/VerifyOtpUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;Lcom/example/bingwahybrid/domain/auth/usecase/VerifyOtpUseCase;)V", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isLoading", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "email", "", "_otp", "", "otp", "getOtp", "_timerSeconds", "", "timerSeconds", "getTimerSeconds", "_otpVerificationSuccess", "otpVerificationSuccess", "getOtpVerificationSuccess", "_snackbarMessage", "snackbarMessage", "getSnackbarMessage", "onOtpChanged", "", FirebaseAnalytics.Param.INDEX, "digit", "setEmail", "updateTimer", "verifyOtp", "resendOtp", "resetSnackbarMessage", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OtpVerificationViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<List<String>> _otp;
    private final MutableStateFlow<Boolean> _otpVerificationSuccess;
    private final MutableStateFlow<String> _snackbarMessage;
    private final MutableStateFlow<Integer> _timerSeconds;
    private final AuthRepository authRepository;
    private String email;
    private final StateFlow<Boolean> isLoading;
    private final StateFlow<List<String>> otp;
    private final StateFlow<Boolean> otpVerificationSuccess;
    private final StateFlow<String> snackbarMessage;
    private final StateFlow<Integer> timerSeconds;
    private final VerifyOtpUseCase verifyOtpUseCase;

    @Inject
    public OtpVerificationViewModel(AuthRepository authRepository, VerifyOtpUseCase verifyOtpUseCase) {
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(verifyOtpUseCase, "verifyOtpUseCase");
        this.authRepository = authRepository;
        this.verifyOtpUseCase = verifyOtpUseCase;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow;
        this.isLoading = MutableStateFlow;
        this.email = "";
        MutableStateFlow<List<String>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.mutableListOf("", "", "", "", "", ""));
        this._otp = MutableStateFlow2;
        this.otp = MutableStateFlow2;
        MutableStateFlow<Integer> MutableStateFlow3 = StateFlowKt.MutableStateFlow(Integer.valueOf(MenuKt.InTransitionDuration));
        this._timerSeconds = MutableStateFlow3;
        this.timerSeconds = MutableStateFlow3;
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(false);
        this._otpVerificationSuccess = MutableStateFlow4;
        this.otpVerificationSuccess = MutableStateFlow4;
        MutableStateFlow<String> MutableStateFlow5 = StateFlowKt.MutableStateFlow(null);
        this._snackbarMessage = MutableStateFlow5;
        this.snackbarMessage = MutableStateFlow5;
        updateTimer();
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final StateFlow<List<String>> getOtp() {
        return this.otp;
    }

    public final StateFlow<Integer> getTimerSeconds() {
        return this.timerSeconds;
    }

    public final StateFlow<Boolean> getOtpVerificationSuccess() {
        return this.otpVerificationSuccess;
    }

    public final StateFlow<String> getSnackbarMessage() {
        return this.snackbarMessage;
    }

    public final void onOtpChanged(int index, String digit) {
        Intrinsics.checkNotNullParameter(digit, "digit");
        MutableStateFlow<List<String>> mutableStateFlow = this._otp;
        List<String> mutableList = CollectionsKt.toMutableList((Collection) mutableStateFlow.getValue());
        if (digit.length() == 0) {
            mutableList.set(index, "");
        } else {
            mutableList.set(index, digit);
        }
        mutableStateFlow.setValue(mutableList);
    }

    public final void setEmail(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        this.email = email;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel$updateTimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OtpVerificationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel$updateTimer$1", f = "OtpVerificationViewModel.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
    static final class C07751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07751(Continuation<? super C07751> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OtpVerificationViewModel.this.new C07751(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x002c  */
        /* JADX WARN: Code duplicated, block: B:13:0x0039 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0037 -> B:14:0x003a). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r6)
                goto L3a
            Lf:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L17:
                kotlin.ResultKt.throwOnFailure(r6)
            L1a:
                com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel r6 = com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r6 = com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel.access$get_timerSeconds$p(r6)
                java.lang.Object r6 = r6.getValue()
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                if (r6 <= 0) goto L53
                r6 = r5
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r5.label = r2
                r3 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
                if (r6 != r0) goto L3a
                return r0
            L3a:
                com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel r6 = com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel.this
                kotlinx.coroutines.flow.MutableStateFlow r6 = com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel.access$get_timerSeconds$p(r6)
                java.lang.Object r1 = r6.getValue()
                java.lang.Number r1 = (java.lang.Number) r1
                int r1 = r1.intValue()
                int r1 = r1 - r2
                java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
                r6.setValue(r1)
                goto L1a
            L53:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel.C07751.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTimer() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07751(null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel$verifyOtp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OtpVerificationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel$verifyOtp$1", f = "OtpVerificationViewModel.kt", i = {0}, l = {73}, m = "invokeSuspend", n = {"otp"}, s = {"L$0"})
    static final class C07761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C07761(Continuation<? super C07761> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OtpVerificationViewModel.this.new C07761(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    String strJoinToString$default = CollectionsKt.joinToString$default((Iterable) OtpVerificationViewModel.this._otp.getValue(), "", null, null, 0, null, null, 62, null);
                    OtpVerificationViewModel.this._isLoading.setValue(Boxing.boxBoolean(true));
                    this.L$0 = SpillingKt.nullOutSpilledVariable(strJoinToString$default);
                    this.label = 1;
                    if (OtpVerificationViewModel.this.verifyOtpUseCase.invoke(strJoinToString$default, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                OtpVerificationViewModel.this._otpVerificationSuccess.setValue(Boxing.boxBoolean(true));
            } catch (Exception e) {
                OtpVerificationViewModel.this._snackbarMessage.setValue(e.getMessage());
                e.printStackTrace();
            } finally {
                OtpVerificationViewModel.this._isLoading.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
    }

    public final void verifyOtp() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07761(null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel$resendOtp$1, reason: invalid class name */
    /* JADX INFO: compiled from: OtpVerificationViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.OtpVerificationViewModel$resendOtp$1", f = "OtpVerificationViewModel.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OtpVerificationViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    OtpVerificationViewModel.this._isLoading.setValue(Boxing.boxBoolean(true));
                    this.label = 1;
                    if (OtpVerificationViewModel.this.authRepository.sendOtp(OtpVerificationViewModel.this.email, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                OtpVerificationViewModel.this._isLoading.setValue(Boxing.boxBoolean(false));
                OtpVerificationViewModel.this._timerSeconds.setValue(Boxing.boxInt(MenuKt.InTransitionDuration));
                OtpVerificationViewModel.this.updateTimer();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }
    }

    public final void resendOtp() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    public final void resetSnackbarMessage() {
        this._snackbarMessage.setValue(null);
    }
}
