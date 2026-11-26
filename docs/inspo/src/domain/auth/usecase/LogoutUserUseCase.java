package com.example.bingwahybrid.domain.auth.usecase;

import android.util.Log;
import com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import com.example.bingwahybrid.domain.socket.SocketService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogoutUserUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000fH\u0086B¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/auth/usecase/LogoutUserUseCase;", "", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "tokenRepository", "Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "socketService", "Lcom/example/bingwahybrid/domain/socket/SocketService;", "appControl", "Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;Lcom/example/bingwahybrid/domain/socket/SocketService;Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LogoutUserUseCase {
    public static final int $stable = 0;
    private final AppControl appControl;
    private final AuthRepository authRepository;
    private final SettingsRepository settingsRepository;
    private final SocketService socketService;
    private final TokenRepository tokenRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.auth.usecase.LogoutUserUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: LogoutUserUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.auth.usecase.LogoutUserUseCase", f = "LogoutUserUseCase.kt", i = {}, l = {23, 24, 25, 27}, m = "invoke", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LogoutUserUseCase.this.invoke(this);
        }
    }

    @Inject
    public LogoutUserUseCase(SettingsRepository settingsRepository, TokenRepository tokenRepository, AuthRepository authRepository, SocketService socketService, AppControl appControl) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(tokenRepository, "tokenRepository");
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(socketService, "socketService");
        Intrinsics.checkNotNullParameter(appControl, "appControl");
        this.settingsRepository = settingsRepository;
        this.tokenRepository = tokenRepository;
        this.authRepository = authRepository;
        this.socketService = socketService;
        this.appControl = appControl;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006e  */
    /* JADX WARN: Code duplicated, block: B:32:0x006f A[Catch: Exception -> 0x0082, TRY_LEAVE, TryCatch #0 {Exception -> 0x0082, blocks: (B:14:0x002f, B:18:0x003b, B:32:0x006f, B:19:0x003f, B:29:0x0064, B:20:0x0043, B:26:0x0055, B:23:0x004a), top: B:40:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        if (r7.stopApp(r0) == r1) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Continuation<? super Unit> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        TokenRepository tokenRepository;
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
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AuthRepository authRepository = this.authRepository;
                anonymousClass1.label = 1;
                if (authRepository.logoutUser(anonymousClass1) == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    tokenRepository = this.tokenRepository;
                    anonymousClass1.label = 3;
                    if (tokenRepository.clearAll(anonymousClass1) == coroutine_suspended) {
                        this.socketService.cleanup();
                        AppControl appControl = this.appControl;
                        anonymousClass1.label = 4;
                    }
                    return coroutine_suspended;
                }
                if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    this.socketService.cleanup();
                    AppControl appControl2 = this.appControl;
                    anonymousClass1.label = 4;
                } else {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            }
            return Unit.INSTANCE;
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting appSetting = AppSetting.AGENT_ID;
            anonymousClass1.label = 2;
            if (settingsRepository.saveSetting(appSetting, "", anonymousClass1) != coroutine_suspended) {
                tokenRepository = this.tokenRepository;
                anonymousClass1.label = 3;
                if (tokenRepository.clearAll(anonymousClass1) == coroutine_suspended) {
                    this.socketService.cleanup();
                    AppControl appControl3 = this.appControl;
                    anonymousClass1.label = 4;
                }
            }
            return coroutine_suspended;
        } catch (Exception e) {
            Log.e("LogoutUserUseCase", "logoutUser", e);
            throw e;
        }
    }
}
