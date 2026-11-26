package com.example.bingwahybrid.domain.di;

import android.content.Context;
import com.example.bingwahybrid.data.remote.api.ApiService;
import com.example.bingwahybrid.data.repository.PaymentRepositoryImpl;
import com.example.bingwahybrid.domain.app_lifecycle.AppLifecycleManager;
import com.example.bingwahybrid.domain.app_lifecycle.DefaultAppControl;
import com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.LoginUserUseCase;
import com.example.bingwahybrid.domain.auth.usecase.LogoutUserUseCase;
import com.example.bingwahybrid.domain.auth.usecase.RegisterUserUseCase;
import com.example.bingwahybrid.domain.auth.usecase.ResendEmailVerificationOtpUseCase;
import com.example.bingwahybrid.domain.auth.usecase.UpdateAgentUseCase;
import com.example.bingwahybrid.domain.auth.usecase.VerifyOtpUseCase;
import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.engine.FormatUssdUseCase;
import com.example.bingwahybrid.domain.engine.advanced.UssdAccessibilityService;
import com.example.bingwahybrid.domain.engine.validation.TransactionValidator;
import com.example.bingwahybrid.domain.messaging.usecase.SendAutoReplyMessageUseCase;
import com.example.bingwahybrid.domain.messaging.usecase.SendSmsUseCase;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.repository.AgentCommissionRepository;
import com.example.bingwahybrid.domain.repository.AuthorizedSenderRepository;
import com.example.bingwahybrid.domain.repository.AutoReplyRepository;
import com.example.bingwahybrid.domain.repository.CommissionRateRepository;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.repository.DeviceSettingsRepository;
import com.example.bingwahybrid.domain.repository.PaymentRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.repository.StatisticsRepository;
import com.example.bingwahybrid.domain.repository.SubscriptionPackageRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import com.example.bingwahybrid.domain.services.ConnectIdScheduler;
import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import com.example.bingwahybrid.domain.sitelink.usecase.DeleteSiteLinkOfferUseCase;
import com.example.bingwahybrid.domain.sitelink.usecase.DeleteSiteLinkUseCase;
import com.example.bingwahybrid.domain.sitelink.usecase.GetSiteLinkUseCase;
import com.example.bingwahybrid.domain.sitelink.usecase.RequestSiteLinkUseCase;
import com.example.bingwahybrid.domain.sitelink.usecase.UpdateSiteLinkUseCase;
import com.example.bingwahybrid.domain.sms.usecases.CreateSmsTransactionUseCase;
import com.example.bingwahybrid.domain.sms.usecases.ReadMpesaMessagesUseCase;
import com.example.bingwahybrid.domain.sms.usecases.ValidateMessageUseCase;
import com.example.bingwahybrid.domain.socket.SocketService;
import com.example.bingwahybrid.domain.statistics.usecase.GetCommissionForDatesUseCase;
import com.example.bingwahybrid.domain.statistics.usecase.IncrementAgentCommissionUseCase;
import com.example.bingwahybrid.domain.statistics.usecase.IncrementCustomerBalanceUseCase;
import com.example.bingwahybrid.domain.usecase.ActivateSiteLinkUseCase;
import com.example.bingwahybrid.domain.usecase.CreateTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.DecrementCustomerBalanceUseCase;
import com.example.bingwahybrid.domain.usecase.DeleteTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.DialPausedTransactionsUseCase;
import com.example.bingwahybrid.domain.usecase.DialSkippedTransactionsUseCase;
import com.example.bingwahybrid.domain.usecase.GetAutoRepliesUseCase;
import com.example.bingwahybrid.domain.usecase.GetCommissionUseCase;
import com.example.bingwahybrid.domain.usecase.GetCustomerBalanceUseCase;
import com.example.bingwahybrid.domain.usecase.GetCustomersUseCase;
import com.example.bingwahybrid.domain.usecase.GetLastTransactionForCustomerUseCase;
import com.example.bingwahybrid.domain.usecase.GetOrCreateCustomerUseCase;
import com.example.bingwahybrid.domain.usecase.GetTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.GetTransactionsForCustomerUseCase;
import com.example.bingwahybrid.domain.usecase.GetTransactionsForPeriodUseCase;
import com.example.bingwahybrid.domain.usecase.ObserveTransactionStatusUseCase;
import com.example.bingwahybrid.domain.usecase.ObserveTransactionsUseCase;
import com.example.bingwahybrid.domain.usecase.PermissionHandlerUseCase;
import com.example.bingwahybrid.domain.usecase.RefreshCommissionRatesUseCase;
import com.example.bingwahybrid.domain.usecase.RescheduleTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.RetryTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.customer.DeleteCustomerUseCase;
import com.example.bingwahybrid.domain.usecase.customer.SaveContactToPhoneBookUseCase;
import com.example.bingwahybrid.domain.usecase.customer.UpdateCustomerInfoUseCase;
import com.example.bingwahybrid.domain.usecase.subscriptions.GetSubscriptionPackageUseCase;
import com.example.bingwahybrid.domain.usecase.subscriptions.GetSubscriptionPackagesUseCase;
import com.example.bingwahybrid.domain.validation.usecase.ValidateStartupUseCase;
import com.example.bingwahybrid.infrastructure.messaging.FcmTokenRegistrationHelper;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.Set;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomainModule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000è\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J8\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rH\u0007J0\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0007J\u0018\u0010$\u001a\u00020%2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010&\u001a\u00020'H\u0007J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0007J \u0010,\u001a\u00020-2\u0006\u0010\"\u001a\u00020#2\u0006\u0010*\u001a\u00020+2\u0006\u0010.\u001a\u00020/H\u0007J5\u00100\u001a\u0002012\b\b\u0001\u00102\u001a\u0002032\u0011\u00104\u001a\r\u0012\t\u0012\u000706¢\u0006\u0002\b7052\u0006\u0010\"\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0007J\b\u0010:\u001a\u00020;H\u0007J\u0012\u0010<\u001a\u00020=2\b\b\u0001\u00102\u001a\u000203H\u0007J\u001a\u0010>\u001a\u00020?2\b\b\u0001\u00102\u001a\u0002032\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010@\u001a\u00020AH\u0007J \u0010B\u001a\u00020C2\u0006\u0010\"\u001a\u00020#2\u0006\u0010*\u001a\u00020+2\u0006\u0010.\u001a\u00020/H\u0007J\u0010\u0010D\u001a\u00020E2\u0006\u0010*\u001a\u00020+H\u0007J\u0010\u0010F\u001a\u00020G2\u0006\u0010*\u001a\u00020+H\u0007J\u0010\u0010H\u001a\u00020I2\u0006\u0010*\u001a\u00020+H\u0007J\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0007J\u0010\u0010N\u001a\u00020O2\u0006\u0010L\u001a\u00020MH\u0007J\u0010\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0007J\u0010\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0007J\u0010\u0010X\u001a\u00020Y2\u0006\u0010V\u001a\u00020WH\u0007J\u0010\u0010Z\u001a\u00020[2\u0006\u0010V\u001a\u00020WH\u0007J\u0010\u0010\\\u001a\u00020]2\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010^\u001a\u00020_2\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010`\u001a\u00020a2\u0006\u0010*\u001a\u00020+H\u0007J\"\u0010b\u001a\u00020c2\b\b\u0001\u00102\u001a\u0002032\u0006\u0010\"\u001a\u00020#2\u0006\u0010.\u001a\u00020/H\u0007J\u0010\u0010d\u001a\u00020e2\u0006\u0010\"\u001a\u00020#H\u0007J \u0010f\u001a\u0002092\u0006\u0010\"\u001a\u00020#2\u0006\u0010g\u001a\u00020h2\u0006\u0010.\u001a\u00020/H\u0007J\u0010\u0010i\u001a\u00020j2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020nH\u0007J\u0010\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020rH\u0007J\u0010\u0010s\u001a\u00020t2\u0006\u0010q\u001a\u00020rH\u0007J\u0010\u0010u\u001a\u00020v2\u0006\u0010*\u001a\u00020+H\u0007J\u0018\u0010w\u001a\u00020x2\u0006\u0010*\u001a\u00020+2\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010y\u001a\u00020z2\u0006\u0010V\u001a\u00020WH\u0007J\u0010\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020SH\u0007J\u001b\u0010~\u001a\u00020\u007f2\b\b\u0001\u00102\u001a\u0002032\u0007\u0010\u0080\u0001\u001a\u00020?H\u0007J\u001d\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u007fH\u0007J\u0014\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0007J\u0012\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0006\u0010\"\u001a\u00020#H\u0007J-\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0006\u00108\u001a\u0002092\u0007\u0010\u008c\u0001\u001a\u0002012\u0006\u0010\"\u001a\u00020#2\b\b\u0001\u00102\u001a\u000203H\u0007J5\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020C2\u0007\u0010\u0090\u0001\u001a\u00020c2\u0007\u0010\u008c\u0001\u001a\u0002012\u0006\u0010\"\u001a\u00020#2\u0006\u0010.\u001a\u00020/H\u0007J\u0012\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0006\u0010V\u001a\u00020WH\u0007J\u001b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0006\u0010\"\u001a\u00020#2\u0007\u0010\u008c\u0001\u001a\u000201H\u0007J\u001b\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0006\u0010\"\u001a\u00020#2\u0007\u0010\u008c\u0001\u001a\u000201H\u0007J\u001b\u0010\u0097\u0001\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0007J\u0012\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0006\u0010\"\u001a\u00020#H\u0007J\u001d\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\b\u0001\u00102\u001a\u0002032\u0007\u0010\u0080\u0001\u001a\u00020?H\u0007J\u001c\u0010\u009e\u0001\u001a\u00030\u0099\u00012\b\u0010\u009f\u0001\u001a\u00030 \u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J$\u0010¡\u0001\u001a\u00030¢\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u00102\u001a\u000203H\u0007J@\u0010£\u0001\u001a\u00030¤\u00012\b\b\u0001\u00102\u001a\u0002032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\b\u0010¥\u0001\u001a\u00030\u0096\u00012\b\u0010¦\u0001\u001a\u00030\u0094\u00012\u0006\u0010\u0016\u001a\u00020\u0017H\u0007¨\u0006§\u0001"}, d2 = {"Lcom/example/bingwahybrid/domain/di/DomainModule;", "", "<init>", "()V", "providePaymentRepository", "Lcom/example/bingwahybrid/domain/repository/PaymentRepository;", "apiService", "Lcom/example/bingwahybrid/data/remote/api/ApiService;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "provideRegisterUserUseCase", "Lcom/example/bingwahybrid/domain/auth/usecase/RegisterUserUseCase;", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "provideLoginUserUseCase", "Lcom/example/bingwahybrid/domain/auth/usecase/LoginUserUseCase;", "tokenRepository", "Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;", "socketService", "Lcom/example/bingwahybrid/domain/socket/SocketService;", "connectIdScheduler", "Lcom/example/bingwahybrid/domain/services/ConnectIdScheduler;", "fcmTokenRegistrationHelper", "Lcom/example/bingwahybrid/infrastructure/messaging/FcmTokenRegistrationHelper;", "provideVerifyOtpUseCase", "Lcom/example/bingwahybrid/domain/auth/usecase/VerifyOtpUseCase;", "provideResendEmailVerificationOtpUseCase", "Lcom/example/bingwahybrid/domain/auth/usecase/ResendEmailVerificationOtpUseCase;", "provideLogoutUserUseCase", "Lcom/example/bingwahybrid/domain/auth/usecase/LogoutUserUseCase;", "appControl", "Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;", "provideObserveTransactionsUseCase", "Lcom/example/bingwahybrid/domain/usecase/ObserveTransactionsUseCase;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "provideValidateMessageUseCase", "Lcom/example/bingwahybrid/domain/sms/usecases/ValidateMessageUseCase;", "authorizedSenderRepository", "Lcom/example/bingwahybrid/domain/repository/AuthorizedSenderRepository;", "provideGetOrCreateCustomerUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetOrCreateCustomerUseCase;", "customerRepository", "Lcom/example/bingwahybrid/domain/repository/CustomerRepository;", "provideCreateSmsTransactionUseCase", "Lcom/example/bingwahybrid/domain/sms/usecases/CreateSmsTransactionUseCase;", "transactionRelay", "Lcom/example/bingwahybrid/domain/portal/TransactionRelay;", "provideDialUssdUseCase", "Lcom/example/bingwahybrid/domain/engine/DialUssdUseCase;", "context", "Landroid/content/Context;", "validators", "", "Lcom/example/bingwahybrid/domain/engine/validation/TransactionValidator;", "Lkotlin/jvm/JvmSuppressWildcards;", "updateTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;", "provideUssdAccessibilityService", "Lcom/example/bingwahybrid/domain/engine/advanced/UssdAccessibilityService;", "providePermissionHandlerUseCase", "Lcom/example/bingwahybrid/domain/usecase/PermissionHandlerUseCase;", "provideSubscriptionIdFetcherUseCase", "Lcom/example/bingwahybrid/domain/usecase/SubscriptionIdFetcherUseCase;", "provideFormatUssdUseCase", "Lcom/example/bingwahybrid/domain/engine/FormatUssdUseCase;", "provideCreateTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/CreateTransactionUseCase;", "provideDecrementCustomerBalanceUseCase", "Lcom/example/bingwahybrid/domain/usecase/DecrementCustomerBalanceUseCase;", "provideIncrementCustomerBalanceUseCase", "Lcom/example/bingwahybrid/domain/statistics/usecase/IncrementCustomerBalanceUseCase;", "provideGetCustomerBalanceUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetCustomerBalanceUseCase;", "provideGetCommissionUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetCommissionUseCase;", "commissionRateRepository", "Lcom/example/bingwahybrid/domain/repository/CommissionRateRepository;", "provideRefreshCommissionRatesUseCase", "Lcom/example/bingwahybrid/domain/usecase/RefreshCommissionRatesUseCase;", "provideGetCommissionTodayUseCase", "Lcom/example/bingwahybrid/domain/statistics/usecase/GetCommissionForDatesUseCase;", "agentCommissionRateRepository", "Lcom/example/bingwahybrid/domain/repository/AgentCommissionRepository;", "provideRequestSiteLinkUseCase", "Lcom/example/bingwahybrid/domain/sitelink/usecase/RequestSiteLinkUseCase;", "siteLinkRepository", "Lcom/example/bingwahybrid/domain/sitelink/repository/SiteLinkRepository;", "provideUpdateSiteLinkUseCase", "Lcom/example/bingwahybrid/domain/sitelink/usecase/UpdateSiteLinkUseCase;", "provideGetSiteLinkUseCase", "Lcom/example/bingwahybrid/domain/sitelink/usecase/GetSiteLinkUseCase;", "provideGetTransactionsForPeriodUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetTransactionsForPeriodUseCase;", "provideGetTransactionsForCustomerUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetTransactionsForCustomerUseCase;", "provideGetCustomersUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetCustomersUseCase;", "provideDeleteTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/DeleteTransactionUseCase;", "provideGetTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetTransactionUseCase;", "provideUpdateTransactionUseCase", "statisticsRepository", "Lcom/example/bingwahybrid/domain/repository/StatisticsRepository;", "provideUpdateAgentUseCase", "Lcom/example/bingwahybrid/domain/auth/usecase/UpdateAgentUseCase;", "provideDeleteSiteLinkOfferUseCase", "Lcom/example/bingwahybrid/domain/sitelink/usecase/DeleteSiteLinkOfferUseCase;", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "provideGetSubscriptionPackagesUseCase", "Lcom/example/bingwahybrid/domain/usecase/subscriptions/GetSubscriptionPackagesUseCase;", "subscriptionPackageRepository", "Lcom/example/bingwahybrid/domain/repository/SubscriptionPackageRepository;", "provideGetSubscriptionUseCase", "Lcom/example/bingwahybrid/domain/usecase/subscriptions/GetSubscriptionPackageUseCase;", "provideUpdateCustomerInfoUseCase", "Lcom/example/bingwahybrid/domain/usecase/customer/UpdateCustomerInfoUseCase;", "provideDeleteCustomerUseCase", "Lcom/example/bingwahybrid/domain/usecase/customer/DeleteCustomerUseCase;", "provideActivateSiteLinkUseCase", "Lcom/example/bingwahybrid/domain/usecase/ActivateSiteLinkUseCase;", "provideIncrementAgentCommissionUseCase", "Lcom/example/bingwahybrid/domain/statistics/usecase/IncrementAgentCommissionUseCase;", "agentCommissionRepository", "provideSendSmsUseCase", "Lcom/example/bingwahybrid/domain/messaging/usecase/SendSmsUseCase;", "subscriptionIdFetcherUseCase", "provideSendAutoReplyMessageUseCase", "Lcom/example/bingwahybrid/domain/messaging/usecase/SendAutoReplyMessageUseCase;", "autoReplyRepository", "Lcom/example/bingwahybrid/domain/repository/AutoReplyRepository;", "sendSmsUseCase", "provideGetAutoRepliesUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetAutoRepliesUseCase;", "provideGetLastTransactionForCustomerUseCase", "Lcom/example/bingwahybrid/domain/usecase/GetLastTransactionForCustomerUseCase;", "provideRetryTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/RetryTransactionUseCase;", "dialUssdUseCase", "provideRescheduleTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/RescheduleTransactionUseCase;", "createTransactionUseCase", "deleteTransactionUseCase", "provideDeleteSiteLinkUseCase", "Lcom/example/bingwahybrid/domain/sitelink/usecase/DeleteSiteLinkUseCase;", "provideDialPausedTransactionsUseCase", "Lcom/example/bingwahybrid/domain/usecase/DialPausedTransactionsUseCase;", "provideDialSkippedTransactionsUseCase", "Lcom/example/bingwahybrid/domain/usecase/DialSkippedTransactionsUseCase;", "provideAppControl", "validateStartupUseCase", "Lcom/example/bingwahybrid/domain/validation/usecase/ValidateStartupUseCase;", "provideObserveTransactionStatusUseCase", "Lcom/example/bingwahybrid/domain/usecase/ObserveTransactionStatusUseCase;", "provideReadMpesaMessagesUseCase", "Lcom/example/bingwahybrid/domain/sms/usecases/ReadMpesaMessagesUseCase;", "provideValidateStartupUseCase", "deviceSettingsRepository", "Lcom/example/bingwahybrid/domain/repository/DeviceSettingsRepository;", "provideSaveContactToPhoneBookUseCase", "Lcom/example/bingwahybrid/domain/usecase/customer/SaveContactToPhoneBookUseCase;", "provideAppLifecycleManager", "Lcom/example/bingwahybrid/domain/app_lifecycle/AppLifecycleManager;", "dialSkippedTransactionsUseCase", "dialPausedTransactionsUseCase", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class DomainModule {
    public static final int $stable = 0;
    public static final DomainModule INSTANCE = new DomainModule();

    private DomainModule() {
    }

    @Provides
    @Singleton
    public final PaymentRepository providePaymentRepository(ApiService apiService, SettingsRepository settingsRepository) {
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        return new PaymentRepositoryImpl(apiService, settingsRepository);
    }

    @Provides
    @Singleton
    public final RegisterUserUseCase provideRegisterUserUseCase(AuthRepository authRepository) {
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        return new RegisterUserUseCase(authRepository);
    }

    @Provides
    @Singleton
    public final LoginUserUseCase provideLoginUserUseCase(AuthRepository authRepository, SettingsRepository settingsRepository, TokenRepository tokenRepository, SocketService socketService, ConnectIdScheduler connectIdScheduler, FcmTokenRegistrationHelper fcmTokenRegistrationHelper) {
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(tokenRepository, "tokenRepository");
        Intrinsics.checkNotNullParameter(socketService, "socketService");
        Intrinsics.checkNotNullParameter(connectIdScheduler, "connectIdScheduler");
        Intrinsics.checkNotNullParameter(fcmTokenRegistrationHelper, "fcmTokenRegistrationHelper");
        return new LoginUserUseCase(authRepository, settingsRepository, tokenRepository, socketService, connectIdScheduler, fcmTokenRegistrationHelper);
    }

    @Provides
    @Singleton
    public final VerifyOtpUseCase provideVerifyOtpUseCase(SettingsRepository settingsRepository, AuthRepository authRepository, ConnectIdScheduler connectIdScheduler, TokenRepository tokenRepository) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(connectIdScheduler, "connectIdScheduler");
        Intrinsics.checkNotNullParameter(tokenRepository, "tokenRepository");
        return new VerifyOtpUseCase(settingsRepository, authRepository, connectIdScheduler, tokenRepository);
    }

    @Provides
    @Singleton
    public final ResendEmailVerificationOtpUseCase provideResendEmailVerificationOtpUseCase(AuthRepository authRepository) {
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        return new ResendEmailVerificationOtpUseCase(authRepository);
    }

    @Provides
    @Singleton
    public final LogoutUserUseCase provideLogoutUserUseCase(SettingsRepository settingsRepository, TokenRepository tokenRepository, AuthRepository authRepository, SocketService socketService, AppControl appControl) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(tokenRepository, "tokenRepository");
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(socketService, "socketService");
        Intrinsics.checkNotNullParameter(appControl, "appControl");
        return new LogoutUserUseCase(settingsRepository, tokenRepository, authRepository, socketService, appControl);
    }

    @Provides
    @Singleton
    public final ObserveTransactionsUseCase provideObserveTransactionsUseCase(TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        return new ObserveTransactionsUseCase(transactionRepository);
    }

    @Provides
    @Singleton
    public final ValidateMessageUseCase provideValidateMessageUseCase(SettingsRepository settingsRepository, AuthorizedSenderRepository authorizedSenderRepository) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(authorizedSenderRepository, "authorizedSenderRepository");
        return new ValidateMessageUseCase(settingsRepository, authorizedSenderRepository);
    }

    @Provides
    @Singleton
    public final GetOrCreateCustomerUseCase provideGetOrCreateCustomerUseCase(CustomerRepository customerRepository) {
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        return new GetOrCreateCustomerUseCase(customerRepository);
    }

    @Provides
    @Singleton
    public final CreateSmsTransactionUseCase provideCreateSmsTransactionUseCase(TransactionRepository transactionRepository, CustomerRepository customerRepository, TransactionRelay transactionRelay) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        Intrinsics.checkNotNullParameter(transactionRelay, "transactionRelay");
        return new CreateSmsTransactionUseCase(transactionRepository, customerRepository, transactionRelay);
    }

    @Provides
    @Singleton
    public final DialUssdUseCase provideDialUssdUseCase(@ApplicationContext Context context, Set<TransactionValidator> validators, TransactionRepository transactionRepository, UpdateTransactionUseCase updateTransactionUseCase) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(validators, "validators");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(updateTransactionUseCase, "updateTransactionUseCase");
        return new DialUssdUseCase(context, validators, transactionRepository, updateTransactionUseCase);
    }

    @Provides
    @Singleton
    public final UssdAccessibilityService provideUssdAccessibilityService() {
        return new UssdAccessibilityService();
    }

    @Provides
    @Singleton
    public final PermissionHandlerUseCase providePermissionHandlerUseCase(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PermissionHandlerUseCase(context);
    }

    @Provides
    @Singleton
    public final SubscriptionIdFetcherUseCase provideSubscriptionIdFetcherUseCase(@ApplicationContext Context context, SettingsRepository settingsRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        return new SubscriptionIdFetcherUseCase(context, settingsRepository);
    }

    @Provides
    @Singleton
    public final FormatUssdUseCase provideFormatUssdUseCase() {
        return new FormatUssdUseCase();
    }

    @Provides
    @Singleton
    public final CreateTransactionUseCase provideCreateTransactionUseCase(TransactionRepository transactionRepository, CustomerRepository customerRepository, TransactionRelay transactionRelay) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        Intrinsics.checkNotNullParameter(transactionRelay, "transactionRelay");
        return new CreateTransactionUseCase(transactionRepository, customerRepository, transactionRelay);
    }

    @Provides
    @Singleton
    public final DecrementCustomerBalanceUseCase provideDecrementCustomerBalanceUseCase(CustomerRepository customerRepository) {
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        return new DecrementCustomerBalanceUseCase(customerRepository);
    }

    @Provides
    @Singleton
    public final IncrementCustomerBalanceUseCase provideIncrementCustomerBalanceUseCase(CustomerRepository customerRepository) {
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        return new IncrementCustomerBalanceUseCase(customerRepository);
    }

    @Provides
    @Singleton
    public final GetCustomerBalanceUseCase provideGetCustomerBalanceUseCase(CustomerRepository customerRepository) {
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        return new GetCustomerBalanceUseCase(customerRepository);
    }

    @Provides
    @Singleton
    public final GetCommissionUseCase provideGetCommissionUseCase(CommissionRateRepository commissionRateRepository) {
        Intrinsics.checkNotNullParameter(commissionRateRepository, "commissionRateRepository");
        return new GetCommissionUseCase(commissionRateRepository);
    }

    @Provides
    @Singleton
    public final RefreshCommissionRatesUseCase provideRefreshCommissionRatesUseCase(CommissionRateRepository commissionRateRepository) {
        Intrinsics.checkNotNullParameter(commissionRateRepository, "commissionRateRepository");
        return new RefreshCommissionRatesUseCase(commissionRateRepository);
    }

    @Provides
    @Singleton
    public final GetCommissionForDatesUseCase provideGetCommissionTodayUseCase(AgentCommissionRepository agentCommissionRateRepository) {
        Intrinsics.checkNotNullParameter(agentCommissionRateRepository, "agentCommissionRateRepository");
        return new GetCommissionForDatesUseCase(agentCommissionRateRepository);
    }

    @Provides
    @Singleton
    public final RequestSiteLinkUseCase provideRequestSiteLinkUseCase(SiteLinkRepository siteLinkRepository) {
        Intrinsics.checkNotNullParameter(siteLinkRepository, "siteLinkRepository");
        return new RequestSiteLinkUseCase(siteLinkRepository);
    }

    @Provides
    @Singleton
    public final UpdateSiteLinkUseCase provideUpdateSiteLinkUseCase(SiteLinkRepository siteLinkRepository) {
        Intrinsics.checkNotNullParameter(siteLinkRepository, "siteLinkRepository");
        return new UpdateSiteLinkUseCase(siteLinkRepository);
    }

    @Provides
    @Singleton
    public final GetSiteLinkUseCase provideGetSiteLinkUseCase(SiteLinkRepository siteLinkRepository) {
        Intrinsics.checkNotNullParameter(siteLinkRepository, "siteLinkRepository");
        return new GetSiteLinkUseCase(siteLinkRepository);
    }

    @Provides
    @Singleton
    public final GetTransactionsForPeriodUseCase provideGetTransactionsForPeriodUseCase(TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        return new GetTransactionsForPeriodUseCase(transactionRepository);
    }

    @Provides
    @Singleton
    public final GetTransactionsForCustomerUseCase provideGetTransactionsForCustomerUseCase(TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        return new GetTransactionsForCustomerUseCase(transactionRepository);
    }

    @Provides
    @Singleton
    public final GetCustomersUseCase provideGetCustomersUseCase(CustomerRepository customerRepository) {
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        return new GetCustomersUseCase(customerRepository);
    }

    @Provides
    @Singleton
    public final DeleteTransactionUseCase provideDeleteTransactionUseCase(@ApplicationContext Context context, TransactionRepository transactionRepository, TransactionRelay transactionRelay) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(transactionRelay, "transactionRelay");
        return new DeleteTransactionUseCase(context, transactionRepository, transactionRelay);
    }

    @Provides
    @Singleton
    public final GetTransactionUseCase provideGetTransactionUseCase(TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        return new GetTransactionUseCase(transactionRepository);
    }

    @Provides
    @Singleton
    public final UpdateTransactionUseCase provideUpdateTransactionUseCase(TransactionRepository transactionRepository, StatisticsRepository statisticsRepository, TransactionRelay transactionRelay) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(statisticsRepository, "statisticsRepository");
        Intrinsics.checkNotNullParameter(transactionRelay, "transactionRelay");
        return new UpdateTransactionUseCase(transactionRepository, statisticsRepository, transactionRelay);
    }

    @Provides
    @Singleton
    public final UpdateAgentUseCase provideUpdateAgentUseCase(AuthRepository authRepository) {
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        return new UpdateAgentUseCase(authRepository);
    }

    @Provides
    @Singleton
    public final DeleteSiteLinkOfferUseCase provideDeleteSiteLinkOfferUseCase(OfferRepository offerRepository) {
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        return new DeleteSiteLinkOfferUseCase(offerRepository);
    }

    @Provides
    @Singleton
    public final GetSubscriptionPackagesUseCase provideGetSubscriptionPackagesUseCase(SubscriptionPackageRepository subscriptionPackageRepository) {
        Intrinsics.checkNotNullParameter(subscriptionPackageRepository, "subscriptionPackageRepository");
        return new GetSubscriptionPackagesUseCase(subscriptionPackageRepository);
    }

    @Provides
    @Singleton
    public final GetSubscriptionPackageUseCase provideGetSubscriptionUseCase(SubscriptionPackageRepository subscriptionPackageRepository) {
        Intrinsics.checkNotNullParameter(subscriptionPackageRepository, "subscriptionPackageRepository");
        return new GetSubscriptionPackageUseCase(subscriptionPackageRepository);
    }

    @Provides
    @Singleton
    public final UpdateCustomerInfoUseCase provideUpdateCustomerInfoUseCase(CustomerRepository customerRepository) {
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        return new UpdateCustomerInfoUseCase(customerRepository);
    }

    @Provides
    @Singleton
    public final DeleteCustomerUseCase provideDeleteCustomerUseCase(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        return new DeleteCustomerUseCase(customerRepository, transactionRepository);
    }

    @Provides
    @Singleton
    public final ActivateSiteLinkUseCase provideActivateSiteLinkUseCase(SiteLinkRepository siteLinkRepository) {
        Intrinsics.checkNotNullParameter(siteLinkRepository, "siteLinkRepository");
        return new ActivateSiteLinkUseCase(siteLinkRepository);
    }

    @Provides
    @Singleton
    public final IncrementAgentCommissionUseCase provideIncrementAgentCommissionUseCase(AgentCommissionRepository agentCommissionRepository) {
        Intrinsics.checkNotNullParameter(agentCommissionRepository, "agentCommissionRepository");
        return new IncrementAgentCommissionUseCase(agentCommissionRepository);
    }

    @Provides
    @Singleton
    public final SendSmsUseCase provideSendSmsUseCase(@ApplicationContext Context context, SubscriptionIdFetcherUseCase subscriptionIdFetcherUseCase) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subscriptionIdFetcherUseCase, "subscriptionIdFetcherUseCase");
        return new SendSmsUseCase(context, subscriptionIdFetcherUseCase);
    }

    @Provides
    @Singleton
    public final SendAutoReplyMessageUseCase provideSendAutoReplyMessageUseCase(AutoReplyRepository autoReplyRepository, SendSmsUseCase sendSmsUseCase) {
        Intrinsics.checkNotNullParameter(autoReplyRepository, "autoReplyRepository");
        Intrinsics.checkNotNullParameter(sendSmsUseCase, "sendSmsUseCase");
        return new SendAutoReplyMessageUseCase(autoReplyRepository, sendSmsUseCase);
    }

    @Provides
    @Singleton
    public final GetAutoRepliesUseCase provideGetAutoRepliesUseCase(AutoReplyRepository autoReplyRepository) {
        Intrinsics.checkNotNullParameter(autoReplyRepository, "autoReplyRepository");
        return new GetAutoRepliesUseCase(autoReplyRepository);
    }

    @Provides
    @Singleton
    public final GetLastTransactionForCustomerUseCase provideGetLastTransactionForCustomerUseCase(TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        return new GetLastTransactionForCustomerUseCase(transactionRepository);
    }

    @Provides
    @Singleton
    public final RetryTransactionUseCase provideRetryTransactionUseCase(UpdateTransactionUseCase updateTransactionUseCase, DialUssdUseCase dialUssdUseCase, TransactionRepository transactionRepository, @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(updateTransactionUseCase, "updateTransactionUseCase");
        Intrinsics.checkNotNullParameter(dialUssdUseCase, "dialUssdUseCase");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(context, "context");
        return new RetryTransactionUseCase(updateTransactionUseCase, dialUssdUseCase, transactionRepository, context);
    }

    @Provides
    @Singleton
    public final RescheduleTransactionUseCase provideRescheduleTransactionUseCase(CreateTransactionUseCase createTransactionUseCase, DeleteTransactionUseCase deleteTransactionUseCase, DialUssdUseCase dialUssdUseCase, TransactionRepository transactionRepository, TransactionRelay transactionRelay) {
        Intrinsics.checkNotNullParameter(createTransactionUseCase, "createTransactionUseCase");
        Intrinsics.checkNotNullParameter(deleteTransactionUseCase, "deleteTransactionUseCase");
        Intrinsics.checkNotNullParameter(dialUssdUseCase, "dialUssdUseCase");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(transactionRelay, "transactionRelay");
        return new RescheduleTransactionUseCase(createTransactionUseCase, deleteTransactionUseCase, dialUssdUseCase, transactionRepository, transactionRelay);
    }

    @Provides
    @Singleton
    public final DeleteSiteLinkUseCase provideDeleteSiteLinkUseCase(SiteLinkRepository siteLinkRepository) {
        Intrinsics.checkNotNullParameter(siteLinkRepository, "siteLinkRepository");
        return new DeleteSiteLinkUseCase(siteLinkRepository);
    }

    @Provides
    @Singleton
    public final DialPausedTransactionsUseCase provideDialPausedTransactionsUseCase(TransactionRepository transactionRepository, DialUssdUseCase dialUssdUseCase) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(dialUssdUseCase, "dialUssdUseCase");
        return new DialPausedTransactionsUseCase(transactionRepository, dialUssdUseCase);
    }

    @Provides
    @Singleton
    public final DialSkippedTransactionsUseCase provideDialSkippedTransactionsUseCase(TransactionRepository transactionRepository, DialUssdUseCase dialUssdUseCase) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(dialUssdUseCase, "dialUssdUseCase");
        return new DialSkippedTransactionsUseCase(transactionRepository, dialUssdUseCase);
    }

    @Provides
    @Singleton
    public final AppControl provideAppControl(SettingsRepository settingsRepository, ValidateStartupUseCase validateStartupUseCase) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(validateStartupUseCase, "validateStartupUseCase");
        return new DefaultAppControl(settingsRepository, validateStartupUseCase);
    }

    @Provides
    @Singleton
    public final ObserveTransactionStatusUseCase provideObserveTransactionStatusUseCase(TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        return new ObserveTransactionStatusUseCase(transactionRepository);
    }

    @Provides
    public final ReadMpesaMessagesUseCase provideReadMpesaMessagesUseCase(@ApplicationContext Context context, SubscriptionIdFetcherUseCase subscriptionIdFetcherUseCase) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subscriptionIdFetcherUseCase, "subscriptionIdFetcherUseCase");
        return new ReadMpesaMessagesUseCase(context, subscriptionIdFetcherUseCase);
    }

    @Provides
    public final ValidateStartupUseCase provideValidateStartupUseCase(DeviceSettingsRepository deviceSettingsRepository, TokenRepository tokenRepository) {
        Intrinsics.checkNotNullParameter(deviceSettingsRepository, "deviceSettingsRepository");
        Intrinsics.checkNotNullParameter(tokenRepository, "tokenRepository");
        return new ValidateStartupUseCase(deviceSettingsRepository, tokenRepository);
    }

    @Provides
    @Singleton
    public final SaveContactToPhoneBookUseCase provideSaveContactToPhoneBookUseCase(CustomerRepository customerRepository, SettingsRepository settingsRepository, @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(context, "context");
        return new SaveContactToPhoneBookUseCase(customerRepository, settingsRepository, context);
    }

    @Provides
    @Singleton
    public final AppLifecycleManager provideAppLifecycleManager(@ApplicationContext Context context, AppControl appControl, TransactionRepository transactionRepository, DialSkippedTransactionsUseCase dialSkippedTransactionsUseCase, DialPausedTransactionsUseCase dialPausedTransactionsUseCase, FcmTokenRegistrationHelper fcmTokenRegistrationHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appControl, "appControl");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(dialSkippedTransactionsUseCase, "dialSkippedTransactionsUseCase");
        Intrinsics.checkNotNullParameter(dialPausedTransactionsUseCase, "dialPausedTransactionsUseCase");
        Intrinsics.checkNotNullParameter(fcmTokenRegistrationHelper, "fcmTokenRegistrationHelper");
        return new AppLifecycleManager(context, appControl, transactionRepository, dialSkippedTransactionsUseCase, dialPausedTransactionsUseCase, fcmTokenRegistrationHelper);
    }
}
