package com.example.bingwahybrid.presentation.viewmodel;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import androidx.camera.video.AudioStats;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl;
import com.example.bingwahybrid.domain.auth.models.Agent;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.LogoutUserUseCase;
import com.example.bingwahybrid.domain.enums.AccountHealthStatus;
import com.example.bingwahybrid.domain.enums.AppState;
import com.example.bingwahybrid.domain.enums.LoadingState;
import com.example.bingwahybrid.domain.enums.ProcessingMode;
import com.example.bingwahybrid.domain.enums.StartupState;
import com.example.bingwahybrid.domain.enums.SubscriptionType;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.AccessibilityRepository;
import com.example.bingwahybrid.domain.repository.AccountHealthRepository;
import com.example.bingwahybrid.domain.repository.AppUpdateRepository;
import com.example.bingwahybrid.domain.repository.BalanceRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.repository.StatisticsRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.security.TokenRefreshService;
import com.example.bingwahybrid.domain.security.exceptions.TokenExpiredException;
import com.example.bingwahybrid.domain.security.exceptions.TokenNotFoundException;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import com.example.bingwahybrid.domain.socket.SocketService;
import com.example.bingwahybrid.domain.statistics.model.AgentCommission;
import com.example.bingwahybrid.domain.statistics.usecase.GetCommissionForDatesUseCase;
import com.example.bingwahybrid.domain.subscriptions.model.Subscription;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import com.example.bingwahybrid.domain.updates.enums.UpdateState;
import com.example.bingwahybrid.domain.usecase.RetryTransactionUseCase;
import com.example.bingwahybrid.infrastructure.subscriptions.workers.managers.SubscriptionMigrationWorkManager;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: HomeViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0007\u0018\u00002\u00020\u0001B\u0093\u0001\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#¢\u0006\u0004\b$\u0010%J\b\u0010o\u001a\u00020pH\u0002J\b\u0010q\u001a\u00020pH\u0002J\u0010\u0010r\u001a\u00020p2\u0006\u0010s\u001a\u000208H\u0002J\b\u0010t\u001a\u00020pH\u0002J\b\u0010u\u001a\u00020pH\u0002J\u0006\u0010v\u001a\u00020pJ\u0006\u0010w\u001a\u00020pJ\b\u0010x\u001a\u00020pH\u0002J\u0010\u0010y\u001a\u00020p2\u0006\u0010z\u001a\u000208H\u0002J\u0006\u0010{\u001a\u00020pJ\b\u0010|\u001a\u00020pH\u0002J\b\u0010O\u001a\u00020pH\u0002J\u000e\u0010}\u001a\b\u0012\u0004\u0012\u00020?0EH\u0002J\b\u0010~\u001a\u00020pH\u0002J\b\u0010\u007f\u001a\u00020pH\u0002J\u0010\u0010\u0080\u0001\u001a\u00020p2\u0007\u0010\u0081\u0001\u001a\u00020FJ\u0007\u0010\u0082\u0001\u001a\u00020pJ\u0007\u0010\u0083\u0001\u001a\u00020pJ\u0007\u0010\u0084\u0001\u001a\u00020pJ\u0007\u0010\u0085\u0001\u001a\u00020pJ\u0010\u0010\u0086\u0001\u001a\u00020/H\u0082@¢\u0006\u0003\u0010\u0087\u0001J\u0007\u0010\u0088\u0001\u001a\u00020pJ\u0007\u0010\u0089\u0001\u001a\u00020pJ\u0007\u0010\u008a\u0001\u001a\u00020pJ\u0007\u0010\u008b\u0001\u001a\u00020pR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020,0'¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020/0'¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0016\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010403X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040'¢\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020803X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00109\u001a\b\u0012\u0004\u0012\u0002080'¢\u0006\b\n\u0000\u001a\u0004\b:\u0010*R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010?0'¢\u0006\b\n\u0000\u001a\u0004\b@\u0010*R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020?03X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020?0'¢\u0006\b\n\u0000\u001a\u0004\bC\u0010*R\u001d\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0E0'¢\u0006\b\n\u0000\u001a\u0004\bG\u0010*R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020I0'¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010*R\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020I0'¢\u0006\b\n\u0000\u001a\u0004\bL\u0010*R\u001d\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0E0'¢\u0006\b\n\u0000\u001a\u0004\bO\u0010*R\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020/03X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020/0'¢\u0006\b\n\u0000\u001a\u0004\bR\u0010*R\u0016\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010?03X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010?0'¢\u0006\b\n\u0000\u001a\u0004\bU\u0010*R\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020W0'¢\u0006\b\n\u0000\u001a\u0004\bX\u0010*R\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0'¢\u0006\b\n\u0000\u001a\u0004\b[\u0010*R\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020?0'¢\u0006\b\n\u0000\u001a\u0004\b]\u0010*R\u0014\u0010^\u001a\b\u0012\u0004\u0012\u00020/03X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020/0'¢\u0006\b\n\u0000\u001a\u0004\b_\u0010*R\u0014\u0010`\u001a\b\u0012\u0004\u0012\u00020/03X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010a\u001a\b\u0012\u0004\u0012\u00020/0'¢\u0006\b\n\u0000\u001a\u0004\ba\u0010*R\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020c0'¢\u0006\b\n\u0000\u001a\u0004\bd\u0010*R\u0017\u0010e\u001a\b\u0012\u0004\u0012\u00020f0'¢\u0006\b\n\u0000\u001a\u0004\bg\u0010*R\u0014\u0010h\u001a\b\u0012\u0004\u0012\u00020i03X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010j\u001a\b\u0012\u0004\u0012\u00020i0'¢\u0006\b\n\u0000\u001a\u0004\bk\u0010*R\u000e\u0010l\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020iX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008c\u0001"}, d2 = {"Lcom/example/bingwahybrid/presentation/viewmodel/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "authRepository", "Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "subscriptionRepository", "Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;", "getCommissionForDatesUseCase", "Lcom/example/bingwahybrid/domain/statistics/usecase/GetCommissionForDatesUseCase;", "logoutUserUseCase", "Lcom/example/bingwahybrid/domain/auth/usecase/LogoutUserUseCase;", "retryTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/RetryTransactionUseCase;", "appControl", "Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;", "appUpdateRepository", "Lcom/example/bingwahybrid/domain/repository/AppUpdateRepository;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "balanceRepository", "Lcom/example/bingwahybrid/domain/repository/BalanceRepository;", "statisticsRepository", "Lcom/example/bingwahybrid/domain/repository/StatisticsRepository;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "socketService", "Lcom/example/bingwahybrid/domain/socket/SocketService;", "accessibilityRepository", "Lcom/example/bingwahybrid/domain/repository/AccessibilityRepository;", "accountHealthRepository", "Lcom/example/bingwahybrid/domain/repository/AccountHealthRepository;", "tokenRepository", "Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;", "tokenRefreshService", "Lcom/example/bingwahybrid/domain/security/TokenRefreshService;", "<init>", "(Landroid/content/Context;Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;Lcom/example/bingwahybrid/domain/statistics/usecase/GetCommissionForDatesUseCase;Lcom/example/bingwahybrid/domain/auth/usecase/LogoutUserUseCase;Lcom/example/bingwahybrid/domain/usecase/RetryTransactionUseCase;Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;Lcom/example/bingwahybrid/domain/repository/AppUpdateRepository;Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/repository/BalanceRepository;Lcom/example/bingwahybrid/domain/repository/StatisticsRepository;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/socket/SocketService;Lcom/example/bingwahybrid/domain/repository/AccessibilityRepository;Lcom/example/bingwahybrid/domain/repository/AccountHealthRepository;Lcom/example/bingwahybrid/domain/security/repository/TokenRepository;Lcom/example/bingwahybrid/domain/security/TokenRefreshService;)V", "appState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/bingwahybrid/domain/enums/AppState;", "getAppState", "()Lkotlinx/coroutines/flow/StateFlow;", "processingMode", "Lcom/example/bingwahybrid/domain/enums/ProcessingMode;", "getProcessingMode", "isConnected", "", "agent", "Lcom/example/bingwahybrid/domain/auth/models/Agent;", "_activeSubscriptionType", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bingwahybrid/domain/enums/SubscriptionType;", "activeSubscriptionType", "getActiveSubscriptionType", "_subscriptionLimit", "", "subscriptionLimit", "getSubscriptionLimit", "countdownJob", "Lkotlinx/coroutines/Job;", "tokenValidationJob", "agentFirstName", "", "getAgentFirstName", "_greetings", "greetings", "getGreetings", "liveTransactions", "", "Lcom/example/bingwahybrid/domain/model/Transaction;", "getLiveTransactions", "successCount", "", "getSuccessCount", "failedCount", "getFailedCount", "agentCommissions", "Lcom/example/bingwahybrid/domain/statistics/model/AgentCommission;", "getAgentCommissions", "_logoutSuccess", "logoutSuccess", "getLogoutSuccess", "_snackBarMessage", "snackBarMessage", "getSnackBarMessage", "balanceLoadingState", "Lcom/example/bingwahybrid/domain/enums/LoadingState;", "getBalanceLoadingState", "airtimeUsedToday", "", "getAirtimeUsedToday", "airtimeBalance", "getAirtimeBalance", "_isTransactionsHidden", "isTransactionsHidden", "_isAirtimeHidden", "isAirtimeHidden", "updateState", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState;", "getUpdateState", "accountHealthStatus", "Lcom/example/bingwahybrid/domain/enums/AccountHealthStatus;", "getAccountHealthStatus", "_startupState", "Lcom/example/bingwahybrid/domain/enums/StartupState;", "startupState", "getStartupState", "previousAppState", "previousStartupState", "userInitiatedTransition", "checkForUpdates", "", "observeActivePlans", "startCountdownTimer", "limit", "stopCountdownTimer", "loadAgent", "startTokenValidation", "toggleAppState", "observeStateTransitions", "vibrateDevice", "durationMs", "stopApp", "syncAccessibilityStatus", "getCurrentWeekDates", "createGreetings", "startGreetingTimer", "retryTransaction", "transaction", "logoutUser", "resetSnackBarMessage", "updateApp", "onLongPressStart", "validateAndRefreshAccessToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hideShowUpdateDialog", "onToggleTransactionsVisibility", "onToggleAirtimeVisibility", "refreshBalance", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HomeViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<SubscriptionType> _activeSubscriptionType;
    private final MutableStateFlow<String> _greetings;
    private final MutableStateFlow<Boolean> _isAirtimeHidden;
    private final MutableStateFlow<Boolean> _isTransactionsHidden;
    private final MutableStateFlow<Boolean> _logoutSuccess;
    private final MutableStateFlow<String> _snackBarMessage;
    private final MutableStateFlow<StartupState> _startupState;
    private final MutableStateFlow<Long> _subscriptionLimit;
    private final AccessibilityRepository accessibilityRepository;
    private final AccountHealthRepository accountHealthRepository;
    private final StateFlow<AccountHealthStatus> accountHealthStatus;
    private final StateFlow<SubscriptionType> activeSubscriptionType;
    private final StateFlow<Agent> agent;
    private final StateFlow<List<AgentCommission>> agentCommissions;
    private final StateFlow<String> agentFirstName;
    private final StateFlow<String> airtimeBalance;
    private final StateFlow<Double> airtimeUsedToday;
    private final AppControl appControl;
    private final StateFlow<AppState> appState;
    private final AppUpdateRepository appUpdateRepository;
    private final AuthRepository authRepository;
    private final StateFlow<LoadingState> balanceLoadingState;
    private final BalanceRepository balanceRepository;
    private final Context context;
    private Job countdownJob;
    private final StateFlow<Integer> failedCount;
    private final GetCommissionForDatesUseCase getCommissionForDatesUseCase;
    private final StateFlow<String> greetings;
    private final StateFlow<Boolean> isAirtimeHidden;
    private final StateFlow<Boolean> isConnected;
    private final StateFlow<Boolean> isTransactionsHidden;
    private final StateFlow<List<Transaction>> liveTransactions;
    private final StateFlow<Boolean> logoutSuccess;
    private final LogoutUserUseCase logoutUserUseCase;
    private AppState previousAppState;
    private StartupState previousStartupState;
    private final StateFlow<ProcessingMode> processingMode;
    private final RetryTransactionUseCase retryTransactionUseCase;
    private final SettingsRepository settingsRepository;
    private final StateFlow<String> snackBarMessage;
    private final SocketService socketService;
    private final StateFlow<StartupState> startupState;
    private final StatisticsRepository statisticsRepository;
    private final StateFlow<Long> subscriptionLimit;
    private final SubscriptionRepository subscriptionRepository;
    private final StateFlow<Integer> successCount;
    private final TokenRefreshService tokenRefreshService;
    private final TokenRepository tokenRepository;
    private Job tokenValidationJob;
    private final TransactionRepository transactionRepository;
    private final StateFlow<UpdateState> updateState;
    private boolean userInitiatedTransition;

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$validateAndRefreshAccessToken$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel", f = "HomeViewModel.kt", i = {}, l = {508}, m = "validateAndRefreshAccessToken", n = {}, s = {})
    static final class C07741 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07741(Continuation<? super C07741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomeViewModel.this.validateAndRefreshAccessToken(this);
        }
    }

    @Inject
    public HomeViewModel(@ApplicationContext Context context, AuthRepository authRepository, SubscriptionRepository subscriptionRepository, GetCommissionForDatesUseCase getCommissionForDatesUseCase, LogoutUserUseCase logoutUserUseCase, RetryTransactionUseCase retryTransactionUseCase, AppControl appControl, AppUpdateRepository appUpdateRepository, TransactionRepository transactionRepository, BalanceRepository balanceRepository, StatisticsRepository statisticsRepository, SettingsRepository settingsRepository, SocketService socketService, AccessibilityRepository accessibilityRepository, AccountHealthRepository accountHealthRepository, TokenRepository tokenRepository, TokenRefreshService tokenRefreshService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(authRepository, "authRepository");
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        Intrinsics.checkNotNullParameter(getCommissionForDatesUseCase, "getCommissionForDatesUseCase");
        Intrinsics.checkNotNullParameter(logoutUserUseCase, "logoutUserUseCase");
        Intrinsics.checkNotNullParameter(retryTransactionUseCase, "retryTransactionUseCase");
        Intrinsics.checkNotNullParameter(appControl, "appControl");
        Intrinsics.checkNotNullParameter(appUpdateRepository, "appUpdateRepository");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(balanceRepository, "balanceRepository");
        Intrinsics.checkNotNullParameter(statisticsRepository, "statisticsRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(socketService, "socketService");
        Intrinsics.checkNotNullParameter(accessibilityRepository, "accessibilityRepository");
        Intrinsics.checkNotNullParameter(accountHealthRepository, "accountHealthRepository");
        Intrinsics.checkNotNullParameter(tokenRepository, "tokenRepository");
        Intrinsics.checkNotNullParameter(tokenRefreshService, "tokenRefreshService");
        this.context = context;
        this.authRepository = authRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.getCommissionForDatesUseCase = getCommissionForDatesUseCase;
        this.logoutUserUseCase = logoutUserUseCase;
        this.retryTransactionUseCase = retryTransactionUseCase;
        this.appControl = appControl;
        this.appUpdateRepository = appUpdateRepository;
        this.transactionRepository = transactionRepository;
        this.balanceRepository = balanceRepository;
        this.statisticsRepository = statisticsRepository;
        this.settingsRepository = settingsRepository;
        this.socketService = socketService;
        this.accessibilityRepository = accessibilityRepository;
        this.accountHealthRepository = accountHealthRepository;
        this.tokenRepository = tokenRepository;
        this.tokenRefreshService = tokenRefreshService;
        this.appState = appControl.getAppState();
        HomeViewModel homeViewModel = this;
        this.processingMode = FlowKt.stateIn(settingsRepository.getProcessingMode(), ViewModelKt.getViewModelScope(homeViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), ProcessingMode.EXPRESS);
        this.isConnected = FlowKt.stateIn(socketService.isConnected(), ViewModelKt.getViewModelScope(homeViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), false);
        StateFlow<Agent> agent = authRepository.getAgent();
        this.agent = agent;
        MutableStateFlow<SubscriptionType> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._activeSubscriptionType = MutableStateFlow;
        this.activeSubscriptionType = MutableStateFlow;
        MutableStateFlow<Long> MutableStateFlow2 = StateFlowKt.MutableStateFlow(0L);
        this._subscriptionLimit = MutableStateFlow2;
        this.subscriptionLimit = FlowKt.asStateFlow(MutableStateFlow2);
        final StateFlow<Agent> stateFlow = agent;
        this.agentFirstName = FlowKt.stateIn(new Flow<String>() { // from class: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$1

            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$1$2", f = "HomeViewModel.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Agent agent = (Agent) obj;
                        String firstName = agent != null ? agent.getFirstName() : null;
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(firstName, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super String> flowCollector, Continuation continuation) {
                Object objCollect = stateFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, ViewModelKt.getViewModelScope(homeViewModel), SharingStarted.INSTANCE.getEagerly(), null);
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow("Hello");
        this._greetings = MutableStateFlow3;
        this.greetings = FlowKt.asStateFlow(MutableStateFlow3);
        final StateFlow<Map<Long, Transaction>> liveTransactions = transactionRepository.getLiveTransactions();
        this.liveTransactions = FlowKt.stateIn(new Flow<List<? extends Transaction>>() { // from class: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$2
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends Transaction>> flowCollector, Continuation continuation) {
                Object objCollect = liveTransactions.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$2$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$2$2", f = "HomeViewModel.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        List list = SequencesKt.toList(SequencesKt.sortedWith(SequencesKt.filterNot(SequencesKt.filterNot(SequencesKt.filterNot(SequencesKt.filterNot(SequencesKt.filterNot(SequencesKt.filterNot(CollectionsKt.asSequence(((Map) obj).values()), HomeViewModel$liveTransactions$1$1.INSTANCE), HomeViewModel$liveTransactions$1$2.INSTANCE), HomeViewModel$liveTransactions$1$3.INSTANCE), HomeViewModel$liveTransactions$1$4.INSTANCE), HomeViewModel$liveTransactions$1$5.INSTANCE), HomeViewModel$liveTransactions$1$6.INSTANCE), 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0091: INVOKE (r6v16 'list' java.util.List) = 
                              (wrap kotlin.sequences.Sequence:0x008d: INVOKE 
                              (wrap kotlin.sequences.Sequence:0x0082: INVOKE 
                              (wrap kotlin.sequences.Sequence:0x007a: INVOKE 
                              (wrap kotlin.sequences.Sequence:0x0072: INVOKE 
                              (wrap kotlin.sequences.Sequence:0x006a: INVOKE 
                              (wrap kotlin.sequences.Sequence:0x0062: INVOKE 
                              (wrap kotlin.sequences.Sequence:0x005a: INVOKE 
                              (wrap kotlin.sequences.Sequence:0x0052: INVOKE 
                              (wrap java.util.Collection:0x004c: INVOKE (wrap java.util.Map:0x004a: CHECK_CAST (java.util.Map) (r5v0 'obj' java.lang.Object)) INTERFACE call: java.util.Map.values():java.util.Collection A[MD:():java.util.Collection<V> (c), WRAPPED] (LINE:51))
                             STATIC call: kotlin.collections.CollectionsKt.asSequence(java.lang.Iterable):kotlin.sequences.Sequence A[MD:<T>:(java.lang.Iterable<? extends T>):kotlin.sequences.Sequence<T> (m), WRAPPED] (LINE:51))
                              (wrap com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$1:0x0056: SGET  A[WRAPPED] (LINE:52) com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$1.INSTANCE com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$1)
                             STATIC call: kotlin.sequences.SequencesKt.filterNot(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):kotlin.sequences.Sequence A[MD:<T>:(kotlin.sequences.Sequence<? extends T>, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean>):kotlin.sequences.Sequence<T> (m), WRAPPED] (LINE:52))
                              (wrap com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$2:0x005e: SGET  A[WRAPPED] (LINE:53) com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$2.INSTANCE com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$2)
                             STATIC call: kotlin.sequences.SequencesKt.filterNot(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):kotlin.sequences.Sequence A[MD:<T>:(kotlin.sequences.Sequence<? extends T>, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean>):kotlin.sequences.Sequence<T> (m), WRAPPED] (LINE:53))
                              (wrap com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$3:0x0066: SGET  A[WRAPPED] (LINE:54) com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$3.INSTANCE com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$3)
                             STATIC call: kotlin.sequences.SequencesKt.filterNot(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):kotlin.sequences.Sequence A[MD:<T>:(kotlin.sequences.Sequence<? extends T>, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean>):kotlin.sequences.Sequence<T> (m), WRAPPED] (LINE:54))
                              (wrap com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$4:0x006e: SGET  A[WRAPPED] (LINE:55) com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$4.INSTANCE com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$4)
                             STATIC call: kotlin.sequences.SequencesKt.filterNot(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):kotlin.sequences.Sequence A[MD:<T>:(kotlin.sequences.Sequence<? extends T>, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean>):kotlin.sequences.Sequence<T> (m), WRAPPED] (LINE:55))
                              (wrap com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$5:0x0076: SGET  A[WRAPPED] (LINE:56) com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$5.INSTANCE com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$5)
                             STATIC call: kotlin.sequences.SequencesKt.filterNot(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):kotlin.sequences.Sequence A[MD:<T>:(kotlin.sequences.Sequence<? extends T>, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean>):kotlin.sequences.Sequence<T> (m), WRAPPED] (LINE:56))
                              (wrap com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$6:0x007e: SGET  A[WRAPPED] (LINE:57) com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$6.INSTANCE com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$6)
                             STATIC call: kotlin.sequences.SequencesKt.filterNot(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):kotlin.sequences.Sequence A[MD:<T>:(kotlin.sequences.Sequence<? extends T>, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean>):kotlin.sequences.Sequence<T> (m), WRAPPED] (LINE:57))
                              (wrap java.util.Comparator:0x0088: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:59) call: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$lambda$2$$inlined$sortedByDescending$1.<init>():void type: CONSTRUCTOR)
                             STATIC call: kotlin.sequences.SequencesKt.sortedWith(kotlin.sequences.Sequence, java.util.Comparator):kotlin.sequences.Sequence A[MD:<T>:(kotlin.sequences.Sequence<? extends T>, java.util.Comparator<? super T>):kotlin.sequences.Sequence<T> (m), WRAPPED] (LINE:59))
                             STATIC call: kotlin.sequences.SequencesKt.toList(kotlin.sequences.Sequence):java.util.List A[DECLARE_VAR, MD:<T>:(kotlin.sequences.Sequence<? extends T>):java.util.List<T> (m)] (LINE:58) in method: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$2.2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$lambda$2$$inlined$sortedByDescending$1, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:315)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 21 more
                            */
                        /*
                            this = this;
                            boolean r0 = r6 instanceof com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$2.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L14
                            r0 = r6
                            com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$2$2$1 r0 = (com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r1 = r1 & r2
                            if (r1 == 0) goto L14
                            int r6 = r0.label
                            int r6 = r6 - r2
                            r0.label = r6
                            goto L19
                        L14:
                            com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$2$2$1 r0 = new com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$2$2$1
                            r0.<init>(r6)
                        L19:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L41
                            if (r2 != r3) goto L39
                            int r4 = r0.I$0
                            java.lang.Object r4 = r0.L$3
                            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                            java.lang.Object r4 = r0.L$2
                            java.lang.Object r4 = r0.L$1
                            com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$2$2$1 r4 = (com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$2.AnonymousClass2.AnonymousClass1) r4
                            java.lang.Object r4 = r0.L$0
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto Lb9
                        L39:
                            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                            r4.<init>(r5)
                            throw r4
                        L41:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                            r6 = r0
                            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                            r6 = r5
                            java.util.Map r6 = (java.util.Map) r6
                            java.util.Collection r6 = r6.values()
                            java.lang.Iterable r6 = (java.lang.Iterable) r6
                            kotlin.sequences.Sequence r6 = kotlin.collections.CollectionsKt.asSequence(r6)
                            com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$1 r2 = com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$1.INSTANCE
                            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                            kotlin.sequences.Sequence r6 = kotlin.sequences.SequencesKt.filterNot(r6, r2)
                            com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$2 r2 = com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$2.INSTANCE
                            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                            kotlin.sequences.Sequence r6 = kotlin.sequences.SequencesKt.filterNot(r6, r2)
                            com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$3 r2 = com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$3.INSTANCE
                            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                            kotlin.sequences.Sequence r6 = kotlin.sequences.SequencesKt.filterNot(r6, r2)
                            com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$4 r2 = com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$4.INSTANCE
                            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                            kotlin.sequences.Sequence r6 = kotlin.sequences.SequencesKt.filterNot(r6, r2)
                            com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$5 r2 = com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$5.INSTANCE
                            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                            kotlin.sequences.Sequence r6 = kotlin.sequences.SequencesKt.filterNot(r6, r2)
                            com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$6 r2 = com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$1$6.INSTANCE
                            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                            kotlin.sequences.Sequence r6 = kotlin.sequences.SequencesKt.filterNot(r6, r2)
                            com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$lambda$2$$inlined$sortedByDescending$1 r2 = new com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$liveTransactions$lambda$2$$inlined$sortedByDescending$1
                            r2.<init>()
                            java.util.Comparator r2 = (java.util.Comparator) r2
                            kotlin.sequences.Sequence r6 = kotlin.sequences.SequencesKt.sortedWith(r6, r2)
                            java.util.List r6 = kotlin.sequences.SequencesKt.toList(r6)
                            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                            r0.L$0 = r2
                            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                            r0.L$1 = r2
                            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                            r0.L$2 = r5
                            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
                            r0.L$3 = r5
                            r5 = 0
                            r0.I$0 = r5
                            r0.label = r3
                            java.lang.Object r4 = r4.emit(r6, r0)
                            if (r4 != r1) goto Lb9
                            return r1
                        Lb9:
                            kotlin.Unit r4 = kotlin.Unit.INSTANCE
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            }, ViewModelKt.getViewModelScope(homeViewModel), SharingStarted.INSTANCE.getEagerly(), CollectionsKt.emptyList());
            this.successCount = FlowKt.stateIn(transactionRepository.getSuccessCount(), ViewModelKt.getViewModelScope(homeViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), 0);
            this.failedCount = FlowKt.stateIn(transactionRepository.getFailedCount(), ViewModelKt.getViewModelScope(homeViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), 0);
            this.agentCommissions = getCommissionForDatesUseCase.getAgentCommissions();
            MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(false);
            this._logoutSuccess = MutableStateFlow4;
            this.logoutSuccess = MutableStateFlow4;
            MutableStateFlow<String> MutableStateFlow5 = StateFlowKt.MutableStateFlow(null);
            this._snackBarMessage = MutableStateFlow5;
            this.snackBarMessage = MutableStateFlow5;
            this.balanceLoadingState = FlowKt.stateIn(balanceRepository.getLoadingState(), ViewModelKt.getViewModelScope(homeViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), LoadingState.Idle.INSTANCE);
            final Flow<Double> airtimeUsedToday = statisticsRepository.getAirtimeUsedToday();
            this.airtimeUsedToday = FlowKt.stateIn(new Flow<Double>() { // from class: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$3
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Double> flowCollector, Continuation continuation) {
                    Object objCollect = airtimeUsedToday.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$3$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$3$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$special$$inlined$map$3$2", f = "HomeViewModel.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            Double d = (Double) obj;
                            Double dBoxDouble = Boxing.boxDouble(d != null ? d.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE);
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(dBoxDouble, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, ViewModelKt.getViewModelScope(homeViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
            this.airtimeBalance = balanceRepository.getAirtimeBalance();
            MutableStateFlow<Boolean> MutableStateFlow6 = StateFlowKt.MutableStateFlow(false);
            this._isTransactionsHidden = MutableStateFlow6;
            this.isTransactionsHidden = FlowKt.asStateFlow(MutableStateFlow6);
            MutableStateFlow<Boolean> MutableStateFlow7 = StateFlowKt.MutableStateFlow(false);
            this._isAirtimeHidden = MutableStateFlow7;
            this.isAirtimeHidden = FlowKt.asStateFlow(MutableStateFlow7);
            this.updateState = appUpdateRepository.getUpdateState();
            this.accountHealthStatus = FlowKt.stateIn(accountHealthRepository.getAccountHealthStatus(), ViewModelKt.getViewModelScope(homeViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), AccountHealthStatus.HEALTHY);
            MutableStateFlow<StartupState> MutableStateFlow8 = StateFlowKt.MutableStateFlow(StartupState.Idle.INSTANCE);
            this._startupState = MutableStateFlow8;
            this.startupState = FlowKt.asStateFlow(MutableStateFlow8);
            this.previousAppState = AppState.STATE_STOPPED;
            this.previousStartupState = StartupState.Idle.INSTANCE;
            checkForUpdates();
            loadAgent();
            createGreetings();
            startGreetingTimer();
            getAgentCommissions();
            observeActivePlans();
            syncAccessibilityStatus();
            observeStateTransitions();
        }

        public final StateFlow<AppState> getAppState() {
            return this.appState;
        }

        public final StateFlow<ProcessingMode> getProcessingMode() {
            return this.processingMode;
        }

        public final StateFlow<Boolean> isConnected() {
            return this.isConnected;
        }

        public final StateFlow<SubscriptionType> getActiveSubscriptionType() {
            return this.activeSubscriptionType;
        }

        public final StateFlow<Long> getSubscriptionLimit() {
            return this.subscriptionLimit;
        }

        public final StateFlow<String> getAgentFirstName() {
            return this.agentFirstName;
        }

        public final StateFlow<String> getGreetings() {
            return this.greetings;
        }

        public final StateFlow<List<Transaction>> getLiveTransactions() {
            return this.liveTransactions;
        }

        public final StateFlow<Integer> getSuccessCount() {
            return this.successCount;
        }

        public final StateFlow<Integer> getFailedCount() {
            return this.failedCount;
        }

        /* JADX INFO: renamed from: getAgentCommissions, reason: collision with other method in class */
        public final StateFlow<List<AgentCommission>> m9982getAgentCommissions() {
            return this.agentCommissions;
        }

        public final StateFlow<Boolean> getLogoutSuccess() {
            return this.logoutSuccess;
        }

        public final StateFlow<String> getSnackBarMessage() {
            return this.snackBarMessage;
        }

        public final StateFlow<LoadingState> getBalanceLoadingState() {
            return this.balanceLoadingState;
        }

        public final StateFlow<Double> getAirtimeUsedToday() {
            return this.airtimeUsedToday;
        }

        public final StateFlow<String> getAirtimeBalance() {
            return this.airtimeBalance;
        }

        public final StateFlow<Boolean> isTransactionsHidden() {
            return this.isTransactionsHidden;
        }

        public final StateFlow<Boolean> isAirtimeHidden() {
            return this.isAirtimeHidden;
        }

        public final StateFlow<UpdateState> getUpdateState() {
            return this.updateState;
        }

        public final StateFlow<AccountHealthStatus> getAccountHealthStatus() {
            return this.accountHealthStatus;
        }

        public final StateFlow<StartupState> getStartupState() {
            return this.startupState;
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$checkForUpdates$1, reason: invalid class name */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$checkForUpdates$1", f = "HomeViewModel.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (HomeViewModel.this.appUpdateRepository.checkForUpdates(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        private final void checkForUpdates() {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$observeActivePlans$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$observeActivePlans$1", f = "HomeViewModel.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
        static final class C07631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C07631(Continuation<? super C07631> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07631(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow<List<Subscription>> activePlansFlow = HomeViewModel.this.subscriptionRepository.getActivePlansFlow();
                    final HomeViewModel homeViewModel = HomeViewModel.this;
                    this.label = 1;
                    if (activePlansFlow.collect(new FlowCollector() { // from class: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel.observeActivePlans.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<Subscription>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<Subscription> list, Continuation<? super Unit> continuation) {
                            T next;
                            T next2;
                            List<Subscription> list2 = list;
                            Iterator<T> it = list2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    next = (T) null;
                                    break;
                                }
                                next = it.next();
                                Subscription subscription = (Subscription) next;
                                if (subscription.getType() == SubscriptionType.UNLIMITED && subscription.getLimit() > System.currentTimeMillis()) {
                                    break;
                                }
                            }
                            Subscription subscription2 = next;
                            if (subscription2 != null) {
                                homeViewModel._activeSubscriptionType.setValue(SubscriptionType.UNLIMITED);
                                homeViewModel.startCountdownTimer(subscription2.getLimit());
                            } else {
                                homeViewModel.stopCountdownTimer();
                                Iterator<T> it2 = list2.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        next2 = (T) null;
                                        break;
                                    }
                                    next2 = it2.next();
                                    Subscription subscription3 = (Subscription) next2;
                                    if (subscription3.getType() == SubscriptionType.LIMITED && subscription3.getLimit() > 0) {
                                        break;
                                    }
                                }
                                Subscription subscription4 = next2;
                                if (subscription4 != null) {
                                    homeViewModel._activeSubscriptionType.setValue(SubscriptionType.LIMITED);
                                    homeViewModel._subscriptionLimit.setValue(Boxing.boxLong(subscription4.getLimit()));
                                } else {
                                    homeViewModel._activeSubscriptionType.setValue(null);
                                    homeViewModel._subscriptionLimit.setValue(Boxing.boxLong(0L));
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        private final void observeActivePlans() {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07631(null), 3, null);
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$startCountdownTimer$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$startCountdownTimer$1", f = "HomeViewModel.kt", i = {1, 1, 1}, l = {223, 234}, m = "invokeSuspend", n = {"serverTime", "referenceTime", "remainingTime"}, s = {"J$0", "J$1", "J$2"})
        static final class C07681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $limit;
            long J$0;
            long J$1;
            long J$2;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C07681(long j, Continuation<? super C07681> continuation) {
                super(2, continuation);
                this.$limit = j;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07681(this.$limit, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:21:0x0068  */
            /* JADX WARN: Code duplicated, block: B:24:0x0053 A[SYNTHETIC] */
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
            
                if (r12 == r0) goto L23;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                long jLongValue;
                long jMax;
                long j;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = HomeViewModel.this.accountHealthRepository.getLastKnownServerTime(this);
                } else {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        jLongValue = this.J$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    do {
                        jMax = Math.max(System.currentTimeMillis(), jLongValue);
                        j = this.$limit - jMax;
                        if (j <= 0) {
                            HomeViewModel.this._subscriptionLimit.setValue(Boxing.boxLong(0L));
                            HomeViewModel.this.stopCountdownTimer();
                            return Unit.INSTANCE;
                        }
                        HomeViewModel.this._subscriptionLimit.setValue(Boxing.boxLong(j));
                        this.J$0 = jLongValue;
                        this.J$1 = jMax;
                        this.J$2 = j;
                        this.label = 2;
                    } while (DelayKt.delay(1000L, this) != coroutine_suspended);
                    return coroutine_suspended;
                }
                Long l = (Long) obj;
                jLongValue = l != null ? l.longValue() : System.currentTimeMillis();
                do {
                    jMax = Math.max(System.currentTimeMillis(), jLongValue);
                    j = this.$limit - jMax;
                    if (j <= 0) {
                        HomeViewModel.this._subscriptionLimit.setValue(Boxing.boxLong(0L));
                        HomeViewModel.this.stopCountdownTimer();
                        return Unit.INSTANCE;
                    }
                    HomeViewModel.this._subscriptionLimit.setValue(Boxing.boxLong(j));
                    this.J$0 = jLongValue;
                    this.J$1 = jMax;
                    this.J$2 = j;
                    this.label = 2;
                } while (DelayKt.delay(1000L, this) != coroutine_suspended);
                return coroutine_suspended;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void startCountdownTimer(long limit) {
            stopCountdownTimer();
            this.countdownJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07681(limit, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void stopCountdownTimer() {
            Job job = this.countdownJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.countdownJob = null;
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$loadAgent$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$loadAgent$1", f = "HomeViewModel.kt", i = {}, l = {247}, m = "invokeSuspend", n = {}, s = {})
        static final class C07611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C07611(Continuation<? super C07611> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07611(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v9 */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        Object loggedInAgent = HomeViewModel.this.authRepository.getLoggedInAgent(this);
                        this = loggedInAgent;
                        if (loggedInAgent == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this = this;
                    }
                } catch (Exception e) {
                    HomeViewModel.this._snackBarMessage.setValue(String.valueOf(e.getMessage()));
                }
                return Unit.INSTANCE;
            }
        }

        private final void loadAgent() {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07611(null), 2, null);
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$startTokenValidation$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$startTokenValidation$1", f = "HomeViewModel.kt", i = {}, l = {InputDeviceCompat.SOURCE_KEYBOARD}, m = "invokeSuspend", n = {}, s = {})
        static final class C07701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C07701(Continuation<? super C07701> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07701(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (HomeViewModel.this.validateAndRefreshAccessToken(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        public final void startTokenValidation() {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07701(null), 3, null);
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$toggleAppState$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$toggleAppState$1", f = "HomeViewModel.kt", i = {}, l = {267, 273, 277, 284, 288}, m = "invokeSuspend", n = {}, s = {})
        static final class C07731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$toggleAppState$1$WhenMappings */
            /* JADX INFO: compiled from: HomeViewModel.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[AppState.values().length];
                    try {
                        iArr[AppState.STATE_RUNNING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[AppState.STATE_PAUSED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[AppState.STATE_STOPPED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            C07731(Continuation<? super C07731> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07731(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:30:0x007a A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:9:0x0018, B:35:0x0095, B:13:0x0025, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:14:0x0029, B:48:0x00ee, B:15:0x002e, B:41:0x00cc, B:43:0x00d4, B:45:0x00dc, B:16:0x0033, B:52:0x0117, B:21:0x003e, B:25:0x0058, B:36:0x00ad, B:37:0x00b2, B:38:0x00b3, B:49:0x0105), top: B:57:0x000c }] */
            /* JADX WARN: Code duplicated, block: B:32:0x0082 A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:9:0x0018, B:35:0x0095, B:13:0x0025, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:14:0x0029, B:48:0x00ee, B:15:0x002e, B:41:0x00cc, B:43:0x00d4, B:45:0x00dc, B:16:0x0033, B:52:0x0117, B:21:0x003e, B:25:0x0058, B:36:0x00ad, B:37:0x00b2, B:38:0x00b3, B:49:0x0105), top: B:57:0x000c }] */
            /* JADX WARN: Code duplicated, block: B:34:0x0093  */
            /* JADX WARN: Code duplicated, block: B:43:0x00d4 A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:9:0x0018, B:35:0x0095, B:13:0x0025, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:14:0x0029, B:48:0x00ee, B:15:0x002e, B:41:0x00cc, B:43:0x00d4, B:45:0x00dc, B:16:0x0033, B:52:0x0117, B:21:0x003e, B:25:0x0058, B:36:0x00ad, B:37:0x00b2, B:38:0x00b3, B:49:0x0105), top: B:57:0x000c }] */
            /* JADX WARN: Code duplicated, block: B:45:0x00dc A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:9:0x0018, B:35:0x0095, B:13:0x0025, B:28:0x0072, B:30:0x007a, B:32:0x0082, B:14:0x0029, B:48:0x00ee, B:15:0x002e, B:41:0x00cc, B:43:0x00d4, B:45:0x00dc, B:16:0x0033, B:52:0x0117, B:21:0x003e, B:25:0x0058, B:36:0x00ad, B:37:0x00b2, B:38:0x00b3, B:49:0x0105), top: B:57:0x000c }] */
            /* JADX WARN: Code duplicated, block: B:47:0x00ed  */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x0114, code lost:
            
                if (r8.this$0.appControl.pauseApp(r8) == r0) goto L51;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        int i2 = WhenMappings.$EnumSwitchMapping$0[HomeViewModel.this.getAppState().getValue().ordinal()];
                        if (i2 == 1) {
                            this.label = 1;
                        } else if (i2 == 2) {
                            HomeViewModel.this._startupState.setValue(StartupState.Loading.INSTANCE);
                            this.label = 2;
                            obj = HomeViewModel.this.validateAndRefreshAccessToken(this);
                            if (obj != coroutine_suspended) {
                                if (!((Boolean) obj).booleanValue()) {
                                    HomeViewModel.this.userInitiatedTransition = false;
                                    return Unit.INSTANCE;
                                }
                                this.label = 3;
                                if (HomeViewModel.this.appControl.resumeApp(this) == coroutine_suspended) {
                                }
                                HomeViewModel.this._startupState.setValue(StartupState.Success.INSTANCE);
                                HomeViewModel.this._snackBarMessage.setValue("Processing resumed");
                            }
                        } else if (i2 == 3) {
                            HomeViewModel.this._startupState.setValue(StartupState.Loading.INSTANCE);
                            this.label = 4;
                            obj = HomeViewModel.this.validateAndRefreshAccessToken(this);
                            if (obj != coroutine_suspended) {
                                if (!((Boolean) obj).booleanValue()) {
                                    HomeViewModel.this.userInitiatedTransition = false;
                                    return Unit.INSTANCE;
                                }
                                this.label = 5;
                                if (HomeViewModel.this.appControl.startApp(this) == coroutine_suspended) {
                                }
                                HomeViewModel.this._startupState.setValue(StartupState.Success.INSTANCE);
                                HomeViewModel.this._snackBarMessage.setValue("Processing started successfully");
                            }
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            if (!((Boolean) obj).booleanValue()) {
                                HomeViewModel.this.userInitiatedTransition = false;
                                return Unit.INSTANCE;
                            }
                            this.label = 3;
                            if (HomeViewModel.this.appControl.resumeApp(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i != 3) {
                            if (i == 4) {
                                ResultKt.throwOnFailure(obj);
                                if (!((Boolean) obj).booleanValue()) {
                                    HomeViewModel.this.userInitiatedTransition = false;
                                    return Unit.INSTANCE;
                                }
                                this.label = 5;
                                if (HomeViewModel.this.appControl.startApp(this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 5) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            HomeViewModel.this._startupState.setValue(StartupState.Success.INSTANCE);
                            HomeViewModel.this._snackBarMessage.setValue("Processing started successfully");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        HomeViewModel.this._startupState.setValue(StartupState.Success.INSTANCE);
                        HomeViewModel.this._snackBarMessage.setValue("Processing resumed");
                    } else {
                        ResultKt.throwOnFailure(obj);
                        HomeViewModel.this._snackBarMessage.setValue("Processing paused");
                    }
                } catch (Exception e) {
                    HomeViewModel.this._snackBarMessage.setValue(e.getMessage());
                    HomeViewModel.this._startupState.setValue(new StartupState.Error(String.valueOf(e.getMessage())));
                    HomeViewModel.this.userInitiatedTransition = false;
                }
                return Unit.INSTANCE;
            }
        }

        public final void toggleAppState() {
            this.userInitiatedTransition = true;
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07731(null), 3, null);
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$observeStateTransitions$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$observeStateTransitions$1", f = "HomeViewModel.kt", i = {}, l = {305}, m = "invokeSuspend", n = {}, s = {})
        static final class C07641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C07641(Continuation<? super C07641> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07641(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$observeStateTransitions$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: HomeViewModel.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/example/bingwahybrid/domain/enums/AppState;", "Lcom/example/bingwahybrid/domain/enums/StartupState;", "currentAppState", "currentStartupState"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$observeStateTransitions$1$1", f = "HomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C01481 extends SuspendLambda implements Function3<AppState, StartupState, Continuation<? super Pair<? extends AppState, ? extends StartupState>>, Object> {
                /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                C01481(Continuation<? super C01481> continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(AppState appState, StartupState startupState, Continuation<? super Pair<? extends AppState, ? extends StartupState>> continuation) {
                    C01481 c01481 = new C01481(continuation);
                    c01481.L$0 = appState;
                    c01481.L$1 = startupState;
                    return c01481.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    AppState appState = (AppState) this.L$0;
                    StartupState startupState = (StartupState) this.L$1;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return new Pair(appState, startupState);
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow flowCombine = FlowKt.combine(HomeViewModel.this.getAppState(), HomeViewModel.this.getStartupState(), new C01481(null));
                    final HomeViewModel homeViewModel = HomeViewModel.this;
                    this.label = 1;
                    if (flowCombine.collect(new FlowCollector() { // from class: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel.observeStateTransitions.1.2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((Pair<? extends AppState, ? extends StartupState>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(Pair<? extends AppState, ? extends StartupState> pair, Continuation<? super Unit> continuation) {
                            AppState appStateComponent1 = pair.component1();
                            StartupState startupStateComponent2 = pair.component2();
                            if (homeViewModel.userInitiatedTransition && appStateComponent1 != homeViewModel.previousAppState && appStateComponent1 == AppState.STATE_RUNNING) {
                                homeViewModel.vibrateDevice(250L);
                            }
                            if (homeViewModel.userInitiatedTransition && appStateComponent1 != homeViewModel.previousAppState) {
                                homeViewModel.userInitiatedTransition = false;
                            }
                            homeViewModel.previousAppState = appStateComponent1;
                            homeViewModel.previousStartupState = startupStateComponent2;
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        private final void observeStateTransitions() {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07641(null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void vibrateDevice(long durationMs) {
            Vibrator defaultVibrator;
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    Object systemService = this.context.getSystemService("vibrator_manager");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.VibratorManager");
                    defaultVibrator = ((VibratorManager) systemService).getDefaultVibrator();
                } else {
                    Object systemService2 = this.context.getSystemService("vibrator");
                    Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
                    defaultVibrator = (Vibrator) systemService2;
                }
                Intrinsics.checkNotNull(defaultVibrator);
                defaultVibrator.vibrate(VibrationEffect.createOneShot(durationMs, -1));
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$stopApp$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$stopApp$1", f = "HomeViewModel.kt", i = {}, l = {347}, m = "invokeSuspend", n = {}, s = {})
        static final class C07711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C07711(Continuation<? super C07711> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07711(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (HomeViewModel.this.appControl.stopApp(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    HomeViewModel.this._snackBarMessage.setValue("Processing stopped successfully");
                } catch (Exception e) {
                    HomeViewModel.this._snackBarMessage.setValue(e.getMessage());
                }
                return Unit.INSTANCE;
            }
        }

        public final void stopApp() {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07711(null), 3, null);
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$syncAccessibilityStatus$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$syncAccessibilityStatus$1", f = "HomeViewModel.kt", i = {}, l = {359, 363}, m = "invokeSuspend", n = {}, s = {})
        static final class C07721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$syncAccessibilityStatus$1$WhenMappings */
            /* JADX INFO: compiled from: HomeViewModel.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ProcessingMode.values().length];
                    try {
                        iArr[ProcessingMode.ADVANCED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ProcessingMode.HYBRID.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ProcessingMode.EXPRESS.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            C07721(Continuation<? super C07721> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07721(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
            
                if (r4.this$0.accessibilityRepository.requestAccessibilityStatus(r4) == r0) goto L22;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
            
                if (r4.this$0.accessibilityRepository.requestAccessibilityStatus(r4) == r0) goto L22;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
            
                return r0;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    int i2 = WhenMappings.$EnumSwitchMapping$0[HomeViewModel.this.settingsRepository.getProcessingMode().getValue().ordinal()];
                    if (i2 == 1) {
                        this.label = 1;
                    } else if (i2 == 2) {
                        this.label = 2;
                    } else if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    if (i != 1 && i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        private final void syncAccessibilityStatus() {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07721(null), 3, null);
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$getAgentCommissions$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$getAgentCommissions$1", f = "HomeViewModel.kt", i = {}, l = {373}, m = "invokeSuspend", n = {}, s = {})
        static final class C07601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C07601(Continuation<? super C07601> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07601(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (HomeViewModel.this.getCommissionForDatesUseCase.invoke(HomeViewModel.this.getCurrentWeekDates(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        private final void getAgentCommissions() {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07601(null), 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<String> getCurrentWeekDates() {
            DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDateNow = LocalDate.now();
            LocalDate localDateWith = localDateNow.with((TemporalAdjuster) DayOfWeek.SUNDAY);
            if (localDateNow.getDayOfWeek() != DayOfWeek.SUNDAY) {
                localDateWith = localDateWith.minusWeeks(1L);
            }
            IntRange intRange = new IntRange(0, 6);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                arrayList.add(localDateWith.plusDays(((IntIterator) it).nextInt()).format(dateTimeFormatterOfPattern));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void createGreetings() {
            String str;
            int i = Calendar.getInstance().get(11);
            if (i >= 0 && i < 12) {
                str = "Good Morning";
            } else if (12 <= i && i < 15) {
                str = "Good Afternoon";
            } else {
                str = "Good Evening";
            }
            this._greetings.setValue(str);
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$startGreetingTimer$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$startGreetingTimer$1", f = "HomeViewModel.kt", i = {}, l = {400}, m = "invokeSuspend", n = {}, s = {})
        static final class C07691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C07691(Continuation<? super C07691> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07691(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:11:0x002d A[RETURN] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:12:0x002e). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:11:0x002d
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
                    goto L2e
                Lf:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L17:
                    kotlin.ResultKt.throwOnFailure(r6)
                L1a:
                    kotlin.time.Duration$Companion r6 = kotlin.time.Duration.INSTANCE
                    kotlin.time.DurationUnit r6 = kotlin.time.DurationUnit.MINUTES
                    long r3 = kotlin.time.DurationKt.toDuration(r2, r6)
                    r6 = r5
                    kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                    r5.label = r2
                    java.lang.Object r6 = kotlinx.coroutines.DelayKt.m11971delayVtjQ1oo(r3, r6)
                    if (r6 != r0) goto L2e
                    return r0
                L2e:
                    com.example.bingwahybrid.presentation.viewmodel.HomeViewModel r6 = com.example.bingwahybrid.presentation.viewmodel.HomeViewModel.this
                    com.example.bingwahybrid.presentation.viewmodel.HomeViewModel.access$createGreetings(r6)
                    goto L1a
                */
                throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel.C07691.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        private final void startGreetingTimer() {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07691(null), 3, null);
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$retryTransaction$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$retryTransaction$1", f = "HomeViewModel.kt", i = {}, l = {410}, m = "invokeSuspend", n = {}, s = {})
        static final class C07671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Transaction $transaction;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C07671(Transaction transaction, Continuation<? super C07671> continuation) {
                super(2, continuation);
                this.$transaction = transaction;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07671(this.$transaction, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v9 */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        Object objInvoke = HomeViewModel.this.retryTransactionUseCase.invoke(this.$transaction, this);
                        this = objInvoke;
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this = this;
                    }
                } catch (Exception e) {
                    HomeViewModel.this._snackBarMessage.setValue(String.valueOf(e.getMessage()));
                }
                return Unit.INSTANCE;
            }
        }

        public final void retryTransaction(Transaction transaction) {
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            if (transaction.getOffer() == null) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07671(transaction, null), 2, null);
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$logoutUser$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$logoutUser$1", f = "HomeViewModel.kt", i = {}, l = {420}, m = "invokeSuspend", n = {}, s = {})
        static final class C07621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C07621(Continuation<? super C07621> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07621(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (HomeViewModel.this.logoutUserUseCase.invoke(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    HomeViewModel.this._logoutSuccess.setValue(Boxing.boxBoolean(true));
                } catch (Exception e) {
                    HomeViewModel.this._logoutSuccess.setValue(Boxing.boxBoolean(false));
                    HomeViewModel.this._snackBarMessage.setValue(String.valueOf(e.getMessage()));
                }
                return Unit.INSTANCE;
            }
        }

        public final void logoutUser() {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07621(null), 3, null);
        }

        public final void resetSnackBarMessage() {
            this._snackBarMessage.setValue(null);
        }

        public final void updateApp() {
            String str;
            if (this.updateState.getValue() instanceof UpdateState.UpdateRequired) {
                UpdateState value = this.updateState.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.example.bingwahybrid.domain.updates.enums.UpdateState.UpdateRequired");
                UpdateState.UpdateRequired updateRequired = (UpdateState.UpdateRequired) value;
                String apkUrl = updateRequired.getApkUrl();
                if (StringsKt.isBlank(apkUrl)) {
                    if (Intrinsics.areEqual(updateRequired.getVersionCode(), "Latest")) {
                        str = "a new version";
                    } else {
                        str = "version " + updateRequired.getVersionCode();
                    }
                    this._snackBarMessage.setValue("Please connect to the internet to download the update. " + str + " is available.");
                    return;
                }
                this.appUpdateRepository.downloadAndInstall(apkUrl);
            }
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$onLongPressStart$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$onLongPressStart$1", f = "HomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C07651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C07651(Continuation<? super C07651> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07651(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (HomeViewModel.this.getAppState().getValue() == AppState.STATE_PAUSED || HomeViewModel.this.getAppState().getValue() == AppState.STATE_STOPPED) {
                    HomeViewModel.this.startTokenValidation();
                    SubscriptionMigrationWorkManager.INSTANCE.scheduleSubscriptionMigrationWorker(HomeViewModel.this.context);
                }
                return Unit.INSTANCE;
            }
        }

        public final void onLongPressStart() {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07651(null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:18:0x0042  */
        /* JADX WARN: Code duplicated, block: B:20:0x0047  */
        /* JADX WARN: Code duplicated, block: B:23:0x0054  */
        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        public final Object validateAndRefreshAccessToken(Continuation<? super Boolean> continuation) {
            C07741 c07741;
            Job job;
            if (continuation instanceof C07741) {
                c07741 = (C07741) continuation;
                if ((c07741.label & Integer.MIN_VALUE) != 0) {
                    c07741.label -= Integer.MIN_VALUE;
                } else {
                    c07741 = new C07741(continuation);
                }
            } else {
                c07741 = new C07741(continuation);
            }
            Object obj = c07741.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = c07741.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Job job2 = this.tokenValidationJob;
                if (job2 != null) {
                    Intrinsics.checkNotNull(job2);
                    if (!job2.isActive()) {
                        job = this.tokenValidationJob;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        if (this._startupState.getValue() instanceof StartupState.Error) {
                            this._startupState.setValue(StartupState.Idle.INSTANCE);
                        }
                        this.tokenValidationJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(null), 2, null);
                    }
                } else {
                    job = this.tokenValidationJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    if (this._startupState.getValue() instanceof StartupState.Error) {
                        this._startupState.setValue(StartupState.Idle.INSTANCE);
                    }
                    this.tokenValidationJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(null), 2, null);
                }
                Job job3 = this.tokenValidationJob;
                if (job3 != null) {
                    c07741.label = 1;
                    if (job3.join(c07741) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Boxing.boxBoolean(!(this._startupState.getValue() instanceof StartupState.Error));
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$validateAndRefreshAccessToken$2, reason: invalid class name */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$validateAndRefreshAccessToken$2", f = "HomeViewModel.kt", i = {1, 2, 2}, l = {475, 477, 486}, m = "invokeSuspend", n = {"e", "e", "refreshToken"}, s = {"L$0", "L$0", "L$1"})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            Object L$0;
            Object L$1;
            int label;

            AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new AnonymousClass2(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:66:0x0152  */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
            
                if (r7 == r0) goto L46;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v22 */
            /* JADX WARN: Type inference failed for: r7v25 */
            /* JADX WARN: Type inference failed for: r7v27 */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                TokenExpiredException tokenExpiredException;
                ?? r7;
                String str;
                TokenExpiredException tokenExpiredException2;
                ?? r8;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                String str2 = "Token expired";
                try {
                    if (i != 0) {
                        try {
                            if (i != 1) {
                                if (i == 2) {
                                    tokenExpiredException = (TokenExpiredException) this.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    this = this;
                                    str = (String) obj;
                                    if (str != null || StringsKt.isBlank(str)) {
                                        HomeViewModel.this._snackBarMessage.setValue(tokenExpiredException.getMessage());
                                        MutableStateFlow mutableStateFlow = HomeViewModel.this._startupState;
                                        String message = tokenExpiredException.getMessage();
                                        mutableStateFlow.setValue(new StartupState.Error(message != null ? message : "Token expired"));
                                        return Unit.INSTANCE;
                                    }
                                    r7.L$0 = tokenExpiredException;
                                    r7.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                    r7.label = 3;
                                    obj = HomeViewModel.this.tokenRefreshService.refreshAccessToken(r7);
                                    if (obj != coroutine_suspended) {
                                        tokenExpiredException2 = tokenExpiredException;
                                        r8 = r7;
                                    }
                                    return coroutine_suspended;
                                }
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                tokenExpiredException2 = (TokenExpiredException) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                this = this;
                                if (!((Boolean) obj).booleanValue()) {
                                    HomeViewModel.this._snackBarMessage.setValue(tokenExpiredException2.getMessage());
                                    MutableStateFlow mutableStateFlow2 = HomeViewModel.this._startupState;
                                    String message2 = tokenExpiredException2.getMessage();
                                    if (message2 != null) {
                                        str2 = message2;
                                    }
                                    mutableStateFlow2.setValue(new StartupState.Error(str2));
                                    return Unit.INSTANCE;
                                }
                                return Unit.INSTANCE;
                            }
                            ResultKt.throwOnFailure(obj);
                            this = this;
                        } catch (Exception e) {
                            HomeViewModel.this._snackBarMessage.setValue(e.getMessage());
                            MutableStateFlow mutableStateFlow3 = HomeViewModel.this._startupState;
                            String message3 = e.getMessage();
                            if (message3 == null) {
                                message3 = "Token refresh failed";
                            }
                            mutableStateFlow3.setValue(new StartupState.Error(message3));
                            return Unit.INSTANCE;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        Object objValidateAccessToken = HomeViewModel.this.tokenRepository.validateAccessToken(this);
                        this = objValidateAccessToken;
                    }
                } catch (TokenExpiredException e2) {
                    this.L$0 = e2;
                    this.label = 2;
                    Object refreshToken = HomeViewModel.this.tokenRepository.getRefreshToken(this);
                    if (refreshToken != coroutine_suspended) {
                        tokenExpiredException = e2;
                        obj = refreshToken;
                        r7 = this;
                        str = (String) obj;
                        if (str != null) {
                        }
                        HomeViewModel.this._snackBarMessage.setValue(tokenExpiredException.getMessage());
                        MutableStateFlow mutableStateFlow4 = HomeViewModel.this._startupState;
                        String message4 = tokenExpiredException.getMessage();
                        mutableStateFlow4.setValue(new StartupState.Error(message4 != null ? message4 : "Token expired"));
                        return Unit.INSTANCE;
                    }
                } catch (TokenNotFoundException e3) {
                    HomeViewModel.this._snackBarMessage.setValue(e3.getMessage());
                    MutableStateFlow mutableStateFlow5 = HomeViewModel.this._startupState;
                    String message5 = e3.getMessage();
                    if (message5 == null) {
                        message5 = "Token not found";
                    }
                    mutableStateFlow5.setValue(new StartupState.Error(message5));
                } catch (Exception e4) {
                    HomeViewModel.this._snackBarMessage.setValue(e4.getMessage());
                    MutableStateFlow mutableStateFlow6 = HomeViewModel.this._startupState;
                    String message6 = e4.getMessage();
                    if (message6 == null) {
                        message6 = "Token validation failed";
                    }
                    mutableStateFlow6.setValue(new StartupState.Error(message6));
                }
                return Unit.INSTANCE;
            }
        }

        public final void hideShowUpdateDialog() {
            this.appUpdateRepository.hideInstallDialog(36000000L);
        }

        public final void onToggleTransactionsVisibility() {
            MutableStateFlow<Boolean> mutableStateFlow = this._isTransactionsHidden;
            mutableStateFlow.setValue(Boolean.valueOf(!mutableStateFlow.getValue().booleanValue()));
        }

        public final void onToggleAirtimeVisibility() {
            MutableStateFlow<Boolean> mutableStateFlow = this._isAirtimeHidden;
            mutableStateFlow.setValue(Boolean.valueOf(!mutableStateFlow.getValue().booleanValue()));
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$refreshBalance$1, reason: invalid class name and case insensitive filesystem */
        /* JADX INFO: compiled from: HomeViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.viewmodel.HomeViewModel$refreshBalance$1", f = "HomeViewModel.kt", i = {}, l = {529}, m = "invokeSuspend", n = {}, s = {})
        static final class C07661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            C07661(Continuation<? super C07661> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return HomeViewModel.this.new C07661(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C07661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (HomeViewModel.this.balanceRepository.refreshAirtimeBalance(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                } catch (Exception unused) {
                }
                return Unit.INSTANCE;
            }
        }

        public final void refreshBalance() {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07661(null), 3, null);
        }
    }
