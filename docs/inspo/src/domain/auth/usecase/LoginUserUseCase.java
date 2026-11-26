package com.example.bingwahybrid.domain.auth.usecase;

import android.util.Log;
import com.example.bingwahybrid.domain.auth.models.Agent;
import com.example.bingwahybrid.domain.auth.models.AuthDetails;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import com.example.bingwahybrid.domain.services.ConnectIdScheduler;
import com.example.bingwahybrid.domain.socket.SocketService;
import com.example.bingwahybrid.infrastructure.messaging.FcmTokenRegistrationHelper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginUserUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0086B¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/example/bingwahybrid/domain/auth/usecase/LoginUserUseCase;", "", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "tokenRepository", "Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;", "socketService", "Lcom/example/bingwahybrid/domain/socket/SocketService;", "connectIdScheduler", "Lcom/example/bingwahybrid/domain/services/ConnectIdScheduler;", "fcmTokenRegistrationHelper", "Lcom/example/bingwahybrid/infrastructure/messaging/FcmTokenRegistrationHelper;", "<init>", "(Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;Lcom/example/bingwahybrid/domain/socket/SocketService;Lcom/example/bingwahybrid/domain/services/ConnectIdScheduler;Lcom/example/bingwahybrid/infrastructure/messaging/FcmTokenRegistrationHelper;)V", "invoke", "Lcom/example/bingwahybrid/domain/auth/models/AuthDetails;", "email", "", "pin", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LoginUserUseCase {
    public static final int $stable = 8;
    private final AuthRepository authRepository;
    private final ConnectIdScheduler connectIdScheduler;
    private final FcmTokenRegistrationHelper fcmTokenRegistrationHelper;
    private final SettingsRepository settingsRepository;
    private final SocketService socketService;
    private final TokenRepository tokenRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.auth.usecase.LoginUserUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoginUserUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.auth.usecase.LoginUserUseCase", f = "LoginUserUseCase.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {26, 27, 28, 29, 30}, m = "invoke", n = {"email", "pin", "email", "pin", "authDetails", "email", "pin", "authDetails", "email", "pin", "authDetails", "email", "pin", "authDetails"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginUserUseCase.this.invoke(null, null, this);
        }
    }

    @Inject
    public LoginUserUseCase(AuthRepository authRepository, SettingsRepository settingsRepository, TokenRepository tokenRepository, SocketService socketService, ConnectIdScheduler connectIdScheduler, FcmTokenRegistrationHelper fcmTokenRegistrationHelper) {
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(tokenRepository, "tokenRepository");
        Intrinsics.checkNotNullParameter(socketService, "socketService");
        Intrinsics.checkNotNullParameter(connectIdScheduler, "connectIdScheduler");
        Intrinsics.checkNotNullParameter(fcmTokenRegistrationHelper, "fcmTokenRegistrationHelper");
        this.authRepository = authRepository;
        this.settingsRepository = settingsRepository;
        this.tokenRepository = tokenRepository;
        this.socketService = socketService;
        this.connectIdScheduler = connectIdScheduler;
        this.fcmTokenRegistrationHelper = fcmTokenRegistrationHelper;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e3 A[Catch: Exception -> 0x013c, PHI: r2 r10 r11
  0x00e3: PHI (r2v7 java.lang.String) = (r2v6 java.lang.String), (r2v13 java.lang.String) binds: [B:41:0x00e0, B:24:0x0068] A[DONT_GENERATE, DONT_INLINE]
  0x00e3: PHI (r10v5 com.example.bingwahybrid.domain.auth.models.AuthDetails) = 
  (r10v4 com.example.bingwahybrid.domain.auth.models.AuthDetails)
  (r10v14 com.example.bingwahybrid.domain.auth.models.AuthDetails)
 binds: [B:41:0x00e0, B:24:0x0068] A[DONT_GENERATE, DONT_INLINE]
  0x00e3: PHI (r11v4 java.lang.String) = (r11v3 java.lang.String), (r11v15 java.lang.String) binds: [B:41:0x00e0, B:24:0x0068] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x013c, blocks: (B:16:0x003e, B:49:0x012c, B:21:0x0057, B:46:0x0100, B:24:0x0068, B:43:0x00e3, B:27:0x0079, B:40:0x00c6, B:30:0x0086, B:36:0x00a5, B:33:0x008d), top: B:54:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:46:0x0100 A[Catch: Exception -> 0x013c, PHI: r2 r10 r11
  0x0100: PHI (r2v8 java.lang.String) = (r2v7 java.lang.String), (r2v15 java.lang.String) binds: [B:44:0x00fd, B:21:0x0057] A[DONT_GENERATE, DONT_INLINE]
  0x0100: PHI (r10v6 com.example.bingwahybrid.domain.auth.models.AuthDetails) = 
  (r10v5 com.example.bingwahybrid.domain.auth.models.AuthDetails)
  (r10v16 com.example.bingwahybrid.domain.auth.models.AuthDetails)
 binds: [B:44:0x00fd, B:21:0x0057] A[DONT_GENERATE, DONT_INLINE]
  0x0100: PHI (r11v5 java.lang.String) = (r11v4 java.lang.String), (r11v17 java.lang.String) binds: [B:44:0x00fd, B:21:0x0057] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x013c, blocks: (B:16:0x003e, B:49:0x012c, B:21:0x0057, B:46:0x0100, B:24:0x0068, B:43:0x00e3, B:27:0x0079, B:40:0x00c6, B:30:0x0086, B:36:0x00a5, B:33:0x008d), top: B:54:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0129, code lost:
    
        if (r12.saveSetting(r4, r5, r0) == r1) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(String str, String str2, Continuation<? super AuthDetails> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        String str3;
        AuthDetails authDetails;
        TokenRepository tokenRepository;
        String token;
        TokenRepository tokenRepository2;
        String refreshToken;
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
        Object objLoginUser = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objLoginUser);
                AuthRepository authRepository = this.authRepository;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.label = 1;
                objLoginUser = authRepository.loginUser(str, str2, anonymousClass1);
                if (objLoginUser == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                str2 = (String) anonymousClass1.L$1;
                str = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objLoginUser);
            } else {
                if (i == 2) {
                    authDetails = (AuthDetails) anonymousClass1.L$2;
                    str2 = (String) anonymousClass1.L$1;
                    str3 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objLoginUser);
                    tokenRepository = this.tokenRepository;
                    token = authDetails.getToken();
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass1.L$2 = authDetails;
                    anonymousClass1.label = 3;
                    if (tokenRepository.saveAccessToken(token, anonymousClass1) == coroutine_suspended) {
                        tokenRepository2 = this.tokenRepository;
                        refreshToken = authDetails.getRefreshToken();
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                        anonymousClass1.L$2 = authDetails;
                        anonymousClass1.label = 4;
                        if (tokenRepository2.saveRefreshToken(refreshToken, anonymousClass1) != coroutine_suspended) {
                            SettingsRepository settingsRepository = this.settingsRepository;
                            AppSetting appSetting = AppSetting.AGENT_ID;
                            String string = authDetails.getAgent().getId().toString();
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                            anonymousClass1.L$2 = authDetails;
                            anonymousClass1.label = 5;
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 3) {
                    authDetails = (AuthDetails) anonymousClass1.L$2;
                    str2 = (String) anonymousClass1.L$1;
                    str3 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objLoginUser);
                    tokenRepository2 = this.tokenRepository;
                    refreshToken = authDetails.getRefreshToken();
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass1.L$2 = authDetails;
                    anonymousClass1.label = 4;
                    if (tokenRepository2.saveRefreshToken(refreshToken, anonymousClass1) != coroutine_suspended) {
                        SettingsRepository settingsRepository2 = this.settingsRepository;
                        AppSetting appSetting2 = AppSetting.AGENT_ID;
                        String string2 = authDetails.getAgent().getId().toString();
                        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                        anonymousClass1.L$2 = authDetails;
                        anonymousClass1.label = 5;
                    }
                    return coroutine_suspended;
                }
                if (i == 4) {
                    authDetails = (AuthDetails) anonymousClass1.L$2;
                    str2 = (String) anonymousClass1.L$1;
                    str3 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objLoginUser);
                    SettingsRepository settingsRepository3 = this.settingsRepository;
                    AppSetting appSetting3 = AppSetting.AGENT_ID;
                    String string3 = authDetails.getAgent().getId().toString();
                    Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass1.L$2 = authDetails;
                    anonymousClass1.label = 5;
                } else {
                    if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    authDetails = (AuthDetails) anonymousClass1.L$2;
                    ResultKt.throwOnFailure(objLoginUser);
                }
            }
            this.socketService.connect();
            this.connectIdScheduler.scheduleConnectIdGeneration();
            this.fcmTokenRegistrationHelper.registerFcmToken();
            return authDetails;
            AuthDetails authDetails2 = (AuthDetails) objLoginUser;
            AuthRepository authRepository2 = this.authRepository;
            Agent agent = authDetails2.getAgent();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.L$2 = authDetails2;
            anonymousClass1.label = 2;
            if (authRepository2.saveAgent(agent, anonymousClass1) != coroutine_suspended) {
                str3 = str;
                authDetails = authDetails2;
                tokenRepository = this.tokenRepository;
                token = authDetails.getToken();
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.L$2 = authDetails;
                anonymousClass1.label = 3;
                if (tokenRepository.saveAccessToken(token, anonymousClass1) == coroutine_suspended) {
                    tokenRepository2 = this.tokenRepository;
                    refreshToken = authDetails.getRefreshToken();
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass1.L$2 = authDetails;
                    anonymousClass1.label = 4;
                    if (tokenRepository2.saveRefreshToken(refreshToken, anonymousClass1) != coroutine_suspended) {
                        SettingsRepository settingsRepository4 = this.settingsRepository;
                        AppSetting appSetting4 = AppSetting.AGENT_ID;
                        String string4 = authDetails.getAgent().getId().toString();
                        Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                        anonymousClass1.L$2 = authDetails;
                        anonymousClass1.label = 5;
                    }
                }
            }
            return coroutine_suspended;
        } catch (Exception e) {
            Log.e("LoginUserUseCase", e.toString());
            e.printStackTrace();
            throw e;
        }
    }
}
