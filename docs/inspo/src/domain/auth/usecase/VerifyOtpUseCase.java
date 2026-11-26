package com.example.bingwahybrid.domain.auth.usecase;

import android.util.Log;
import com.example.bingwahybrid.domain.auth.models.Agent;
import com.example.bingwahybrid.domain.auth.models.AuthToken;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import com.example.bingwahybrid.domain.services.ConnectIdScheduler;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VerifyOtpUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086B¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/auth/usecase/VerifyOtpUseCase;", "", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "connectIdScheduler", "Lcom/example/bingwahybrid/domain/services/ConnectIdScheduler;", "tokenRepository", "Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;Lcom/example/bingwahybrid/domain/services/ConnectIdScheduler;Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;)V", "invoke", "", "otp", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VerifyOtpUseCase {
    public static final int $stable = 0;
    private final AuthRepository authRepository;
    private final ConnectIdScheduler connectIdScheduler;
    private final SettingsRepository settingsRepository;
    private final TokenRepository tokenRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.auth.usecase.VerifyOtpUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: VerifyOtpUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.auth.usecase.VerifyOtpUseCase", f = "VerifyOtpUseCase.kt", i = {0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5}, l = {21, 22, 23, 24, 25, 26}, m = "invoke", n = {"otp", "otp", "authToken", "otp", "authToken", "otp", "authToken", "otp", "authToken", "agent", "otp", "authToken", "agent"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
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
            return VerifyOtpUseCase.this.invoke(null, this);
        }
    }

    @Inject
    public VerifyOtpUseCase(SettingsRepository settingsRepository, AuthRepository authRepository, ConnectIdScheduler connectIdScheduler, TokenRepository tokenRepository) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(connectIdScheduler, "connectIdScheduler");
        Intrinsics.checkNotNullParameter(tokenRepository, "tokenRepository");
        this.settingsRepository = settingsRepository;
        this.authRepository = authRepository;
        this.connectIdScheduler = connectIdScheduler;
        this.tokenRepository = tokenRepository;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0059 A[PHI: r2 r8 r9
  0x0059: PHI (r2v12 java.lang.String) = (r2v9 java.lang.String), (r2v15 java.lang.String) binds: [B:42:0x00e1, B:19:0x0056] A[DONT_GENERATE, DONT_INLINE]
  0x0059: PHI (r8v12 com.example.bingwahybrid.domain.auth.models.AuthToken) = 
  (r8v9 com.example.bingwahybrid.domain.auth.models.AuthToken)
  (r8v16 com.example.bingwahybrid.domain.auth.models.AuthToken)
 binds: [B:42:0x00e1, B:19:0x0056] A[DONT_GENERATE, DONT_INLINE]
  0x0059: PHI (r9v12 java.lang.Object) = (r9v11 java.lang.Object), (r9v1 java.lang.Object) binds: [B:42:0x00e1, B:19:0x0056] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cc A[Catch: Exception -> 0x0136, PHI: r2 r8
  0x00cc: PHI (r2v9 java.lang.String) = (r2v6 java.lang.String), (r2v11 java.lang.String) binds: [B:39:0x00c9, B:22:0x0065] A[DONT_GENERATE, DONT_INLINE]
  0x00cc: PHI (r8v9 com.example.bingwahybrid.domain.auth.models.AuthToken) = 
  (r8v6 com.example.bingwahybrid.domain.auth.models.AuthToken)
  (r8v11 com.example.bingwahybrid.domain.auth.models.AuthToken)
 binds: [B:39:0x00c9, B:22:0x0065] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0136, blocks: (B:13:0x0038, B:50:0x012e, B:16:0x0049, B:47:0x0101, B:19:0x0056, B:44:0x00e4, B:22:0x0065, B:41:0x00cc, B:25:0x0071, B:38:0x00b0, B:28:0x0079, B:34:0x0093, B:31:0x0080), top: B:56:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:46:0x0100  */
    /* JADX WARN: Code duplicated, block: B:47:0x0101 A[Catch: Exception -> 0x0136, PHI: r2 r3 r8
  0x0101: PHI (r2v16 com.example.bingwahybrid.domain.auth.models.AuthToken) = 
  (r2v13 com.example.bingwahybrid.domain.auth.models.AuthToken)
  (r2v19 com.example.bingwahybrid.domain.auth.models.AuthToken)
 binds: [B:45:0x00fe, B:16:0x0049] A[DONT_GENERATE, DONT_INLINE]
  0x0101: PHI (r3v6 java.lang.String) = (r3v5 java.lang.String), (r3v9 java.lang.String) binds: [B:45:0x00fe, B:16:0x0049] A[DONT_GENERATE, DONT_INLINE]
  0x0101: PHI (r8v17 com.example.bingwahybrid.domain.auth.models.Agent) = (r8v14 com.example.bingwahybrid.domain.auth.models.Agent), (r8v22 com.example.bingwahybrid.domain.auth.models.Agent) binds: [B:45:0x00fe, B:16:0x0049] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0136, blocks: (B:13:0x0038, B:50:0x012e, B:16:0x0049, B:47:0x0101, B:19:0x0056, B:44:0x00e4, B:22:0x0065, B:41:0x00cc, B:25:0x0071, B:38:0x00b0, B:28:0x0079, B:34:0x0093, B:31:0x0080), top: B:56:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012b, code lost:
    
        if (r9.saveSetting(r4, r5, r0) == r1) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(String str, Continuation<? super Unit> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        AuthToken authToken;
        TokenRepository tokenRepository;
        String accessToken;
        String str2;
        AuthToken authToken2;
        TokenRepository tokenRepository2;
        String refreshToken;
        String str3;
        AuthToken authToken3;
        Agent agent;
        AuthRepository authRepository;
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
        Object objVerifyOtp = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (anonymousClass1.label) {
                case 0:
                    ResultKt.throwOnFailure(objVerifyOtp);
                    AuthRepository authRepository2 = this.authRepository;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass1.label = 1;
                    objVerifyOtp = authRepository2.verifyOtp(str, anonymousClass1);
                    if (objVerifyOtp != coroutine_suspended) {
                        authToken = (AuthToken) objVerifyOtp;
                        tokenRepository = this.tokenRepository;
                        accessToken = authToken.getAccessToken();
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        anonymousClass1.L$1 = authToken;
                        anonymousClass1.label = 2;
                        if (tokenRepository.saveAccessToken(accessToken, anonymousClass1) == coroutine_suspended) {
                            str2 = str;
                            authToken2 = authToken;
                            tokenRepository2 = this.tokenRepository;
                            refreshToken = authToken2.getRefreshToken();
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken2);
                            anonymousClass1.label = 3;
                            if (tokenRepository2.saveRefreshToken(refreshToken, anonymousClass1) != coroutine_suspended) {
                                AuthRepository authRepository3 = this.authRepository;
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken2);
                                anonymousClass1.label = 4;
                                objVerifyOtp = authRepository3.getMyProfile(anonymousClass1);
                                if (objVerifyOtp == coroutine_suspended) {
                                    str3 = str2;
                                    authToken3 = authToken2;
                                    agent = (Agent) objVerifyOtp;
                                    authRepository = this.authRepository;
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken3);
                                    anonymousClass1.L$2 = agent;
                                    anonymousClass1.label = 5;
                                    if (authRepository.saveAgent(agent, anonymousClass1) != coroutine_suspended) {
                                        SettingsRepository settingsRepository = this.settingsRepository;
                                        AppSetting appSetting = AppSetting.AGENT_ID;
                                        String string = agent.getId().toString();
                                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken3);
                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(agent);
                                        anonymousClass1.label = 6;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                case 1:
                    str = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objVerifyOtp);
                    authToken = (AuthToken) objVerifyOtp;
                    tokenRepository = this.tokenRepository;
                    accessToken = authToken.getAccessToken();
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass1.L$1 = authToken;
                    anonymousClass1.label = 2;
                    if (tokenRepository.saveAccessToken(accessToken, anonymousClass1) == coroutine_suspended) {
                        str2 = str;
                        authToken2 = authToken;
                        tokenRepository2 = this.tokenRepository;
                        refreshToken = authToken2.getRefreshToken();
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken2);
                        anonymousClass1.label = 3;
                        if (tokenRepository2.saveRefreshToken(refreshToken, anonymousClass1) != coroutine_suspended) {
                            AuthRepository authRepository4 = this.authRepository;
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken2);
                            anonymousClass1.label = 4;
                            objVerifyOtp = authRepository4.getMyProfile(anonymousClass1);
                            if (objVerifyOtp == coroutine_suspended) {
                                str3 = str2;
                                authToken3 = authToken2;
                                agent = (Agent) objVerifyOtp;
                                authRepository = this.authRepository;
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken3);
                                anonymousClass1.L$2 = agent;
                                anonymousClass1.label = 5;
                                if (authRepository.saveAgent(agent, anonymousClass1) != coroutine_suspended) {
                                    SettingsRepository settingsRepository2 = this.settingsRepository;
                                    AppSetting appSetting2 = AppSetting.AGENT_ID;
                                    String string2 = agent.getId().toString();
                                    Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken3);
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(agent);
                                    anonymousClass1.label = 6;
                                    break;
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                case 2:
                    authToken2 = (AuthToken) anonymousClass1.L$1;
                    str2 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objVerifyOtp);
                    tokenRepository2 = this.tokenRepository;
                    refreshToken = authToken2.getRefreshToken();
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken2);
                    anonymousClass1.label = 3;
                    if (tokenRepository2.saveRefreshToken(refreshToken, anonymousClass1) != coroutine_suspended) {
                        AuthRepository authRepository5 = this.authRepository;
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken2);
                        anonymousClass1.label = 4;
                        objVerifyOtp = authRepository5.getMyProfile(anonymousClass1);
                        if (objVerifyOtp == coroutine_suspended) {
                            str3 = str2;
                            authToken3 = authToken2;
                            agent = (Agent) objVerifyOtp;
                            authRepository = this.authRepository;
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken3);
                            anonymousClass1.L$2 = agent;
                            anonymousClass1.label = 5;
                            if (authRepository.saveAgent(agent, anonymousClass1) != coroutine_suspended) {
                                SettingsRepository settingsRepository3 = this.settingsRepository;
                                AppSetting appSetting3 = AppSetting.AGENT_ID;
                                String string3 = agent.getId().toString();
                                Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken3);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(agent);
                                anonymousClass1.label = 6;
                                break;
                            }
                        }
                    }
                    return coroutine_suspended;
                case 3:
                    authToken2 = (AuthToken) anonymousClass1.L$1;
                    str2 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objVerifyOtp);
                    AuthRepository authRepository6 = this.authRepository;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken2);
                    anonymousClass1.label = 4;
                    objVerifyOtp = authRepository6.getMyProfile(anonymousClass1);
                    if (objVerifyOtp == coroutine_suspended) {
                        str3 = str2;
                        authToken3 = authToken2;
                        agent = (Agent) objVerifyOtp;
                        authRepository = this.authRepository;
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken3);
                        anonymousClass1.L$2 = agent;
                        anonymousClass1.label = 5;
                        if (authRepository.saveAgent(agent, anonymousClass1) != coroutine_suspended) {
                            SettingsRepository settingsRepository4 = this.settingsRepository;
                            AppSetting appSetting4 = AppSetting.AGENT_ID;
                            String string4 = agent.getId().toString();
                            Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken3);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(agent);
                            anonymousClass1.label = 6;
                            break;
                        }
                    }
                    return coroutine_suspended;
                case 4:
                    authToken2 = (AuthToken) anonymousClass1.L$1;
                    str2 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objVerifyOtp);
                    str3 = str2;
                    authToken3 = authToken2;
                    agent = (Agent) objVerifyOtp;
                    authRepository = this.authRepository;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken3);
                    anonymousClass1.L$2 = agent;
                    anonymousClass1.label = 5;
                    if (authRepository.saveAgent(agent, anonymousClass1) != coroutine_suspended) {
                        SettingsRepository settingsRepository5 = this.settingsRepository;
                        AppSetting appSetting5 = AppSetting.AGENT_ID;
                        String string5 = agent.getId().toString();
                        Intrinsics.checkNotNullExpressionValue(string5, "toString(...)");
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken3);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(agent);
                        anonymousClass1.label = 6;
                        break;
                    }
                    return coroutine_suspended;
                case 5:
                    agent = (Agent) anonymousClass1.L$2;
                    authToken3 = (AuthToken) anonymousClass1.L$1;
                    str3 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objVerifyOtp);
                    SettingsRepository settingsRepository6 = this.settingsRepository;
                    AppSetting appSetting6 = AppSetting.AGENT_ID;
                    String string6 = agent.getId().toString();
                    Intrinsics.checkNotNullExpressionValue(string6, "toString(...)");
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(authToken3);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(agent);
                    anonymousClass1.label = 6;
                    break;
                case 6:
                    ResultKt.throwOnFailure(objVerifyOtp);
                    this.connectIdScheduler.scheduleConnectIdGeneration();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            Log.e("VerifyOtpUseCase", "verifyOtpUseCase", e);
            throw e;
        }
    }
}
