package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.telecom.PhoneAccountHandle;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain;
import com.example.bingwahybrid.domain.engine.utils.CustomUssdResponseCallback;
import com.example.bingwahybrid.domain.engine.utils.UssdUtils;
import com.example.bingwahybrid.domain.enums.ProcessingMode;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.model.TransactionContext;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.model.OfferKt;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase;
import com.example.bingwahybrid.domain.ussd.enums.UssdSessionState;
import com.example.bingwahybrid.domain.ussd.repository.OfferSession;
import com.example.bingwahybrid.domain.ussd.repository.UssdSessionManager;
import com.example.bingwahybrid.domain.ussd.repository.UssdStepsRepository;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: UssdDialingHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B;\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0011H\u0083@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/UssdDialingHandler;", "Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionHandler;", "context", "Landroid/content/Context;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "subscriptionIdFetcher", "Lcom/example/bingwahybrid/domain/usecase/SubscriptionIdFetcherUseCase;", "ussdSessionManager", "Lcom/example/bingwahybrid/domain/ussd/repository/UssdSessionManager;", "ussdStepsRepository", "Lcom/example/bingwahybrid/domain/ussd/repository/UssdStepsRepository;", "offerSession", "Lcom/example/bingwahybrid/domain/ussd/repository/OfferSession;", "<init>", "(Landroid/content/Context;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/usecase/SubscriptionIdFetcherUseCase;Lcom/example/bingwahybrid/domain/ussd/repository/UssdSessionManager;Lcom/example/bingwahybrid/domain/ussd/repository/UssdStepsRepository;Lcom/example/bingwahybrid/domain/ussd/repository/OfferSession;)V", "handle", "Lcom/example/bingwahybrid/domain/model/TransactionContext;", "chain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "(Lcom/example/bingwahybrid/domain/model/TransactionContext;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleExpressMode", "(Lcom/example/bingwahybrid/domain/model/TransactionContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleAdvancedMode", "multiStepUssd", "Lkotlinx/coroutines/Deferred;", "Lcom/example/bingwahybrid/domain/ussd/enums/UssdSessionState;", "ussdCode", "", "phoneAccountHandle", "Landroid/telecom/PhoneAccountHandle;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UssdDialingHandler implements TransactionHandler {
    public static final int $stable = 8;
    private final Context context;
    private final OfferSession offerSession;
    private final SettingsRepository settingsRepository;
    private final SubscriptionIdFetcherUseCase subscriptionIdFetcher;
    private final UssdSessionManager ussdSessionManager;
    private final UssdStepsRepository ussdStepsRepository;

    /* JADX INFO: compiled from: UssdDialingHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessingMode.values().length];
            try {
                iArr[ProcessingMode.EXPRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessingMode.ADVANCED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.handlers.UssdDialingHandler$handleAdvancedMode$1, reason: invalid class name */
    /* JADX INFO: compiled from: UssdDialingHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.handlers.UssdDialingHandler", f = "UssdDialingHandler.kt", i = {0, 0, 1, 1, 1}, l = {130, 131}, m = "handleAdvancedMode", n = {"context", "ussdCode", "context", "ussdCode", "phoneAccountHandle"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
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
            return UssdDialingHandler.this.handleAdvancedMode(null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.handlers.UssdDialingHandler$handleExpressMode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UssdDialingHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.handlers.UssdDialingHandler", f = "UssdDialingHandler.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {81, 188}, m = "handleExpressMode", n = {"context", "ussdCode", "context", "ussdCode", "tm", "simManager", "subscriptionId", "$i$f$suspendCancellableCoroutine"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"})
    static final class C06741 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C06741(Continuation<? super C06741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UssdDialingHandler.this.handleExpressMode(null, this);
        }
    }

    @Inject
    public UssdDialingHandler(@ApplicationContext Context context, SettingsRepository settingsRepository, SubscriptionIdFetcherUseCase subscriptionIdFetcher, UssdSessionManager ussdSessionManager, UssdStepsRepository ussdStepsRepository, OfferSession offerSession) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(subscriptionIdFetcher, "subscriptionIdFetcher");
        Intrinsics.checkNotNullParameter(ussdSessionManager, "ussdSessionManager");
        Intrinsics.checkNotNullParameter(ussdStepsRepository, "ussdStepsRepository");
        Intrinsics.checkNotNullParameter(offerSession, "offerSession");
        this.context = context;
        this.settingsRepository = settingsRepository;
        this.subscriptionIdFetcher = subscriptionIdFetcher;
        this.ussdSessionManager = ussdSessionManager;
        this.ussdStepsRepository = ussdStepsRepository;
        this.offerSession = offerSession;
    }

    @Override // com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler
    public Object handle(TransactionContext transactionContext, HandlerChain handlerChain, Continuation<? super TransactionContext> continuation) throws Exception {
        Transaction transaction = transactionContext.getTransaction();
        if (transaction.getStatus() != TransactionStatus.PROCESSING) {
            return transactionContext;
        }
        if (SetsKt.setOf((Object[]) new TransactionType[]{TransactionType.AIRTIME_BALANCE_CHECK, TransactionType.SUBSCRIPTION_RENEWAL}).contains(transaction.getType())) {
            Object objHandleExpressMode = handleExpressMode(transactionContext, continuation);
            return objHandleExpressMode == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objHandleExpressMode : (TransactionContext) objHandleExpressMode;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.settingsRepository.getProcessingMode().getValue().ordinal()];
        if (i == 1) {
            Object objHandleExpressMode2 = handleExpressMode(transactionContext, continuation);
            return objHandleExpressMode2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objHandleExpressMode2 : (TransactionContext) objHandleExpressMode2;
        }
        if (i == 2) {
            Object objHandleAdvancedMode = handleAdvancedMode(transactionContext, continuation);
            return objHandleAdvancedMode == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objHandleAdvancedMode : (TransactionContext) objHandleAdvancedMode;
        }
        Object objHandleAdvancedMode2 = handleAdvancedMode(transactionContext, continuation);
        return objHandleAdvancedMode2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objHandleAdvancedMode2 : (TransactionContext) objHandleAdvancedMode2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object handleExpressMode(TransactionContext transactionContext, Continuation<? super TransactionContext> continuation) throws Exception {
        C06741 c06741;
        String ussdCode;
        final TransactionContext transactionContext2;
        if (continuation instanceof C06741) {
            c06741 = (C06741) continuation;
            if ((c06741.label & Integer.MIN_VALUE) != 0) {
                c06741.label -= Integer.MIN_VALUE;
            } else {
                c06741 = new C06741(continuation);
            }
        } else {
            c06741 = new C06741(continuation);
        }
        Object ussdSubscriptionId = c06741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06741.label;
        if (i == 0) {
            ResultKt.throwOnFailure(ussdSubscriptionId);
            ussdCode = transactionContext.getUssdCode();
            if (ussdCode == null) {
                return TransactionContext.copy$default(transactionContext, Transaction.copy$default(transactionContext.getTransaction(), null, null, 0, 0L, null, "USSD code is missing", TransactionStatus.FAILED, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null), null, false, null, false, null, 62, null);
            }
            SubscriptionIdFetcherUseCase subscriptionIdFetcherUseCase = this.subscriptionIdFetcher;
            transactionContext2 = transactionContext;
            c06741.L$0 = transactionContext2;
            c06741.L$1 = ussdCode;
            c06741.label = 1;
            ussdSubscriptionId = subscriptionIdFetcherUseCase.getUssdSubscriptionId(c06741);
            if (ussdSubscriptionId != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c06741.I$1;
            int i3 = c06741.I$0;
            ResultKt.throwOnFailure(ussdSubscriptionId);
            return ussdSubscriptionId;
        }
        ussdCode = (String) c06741.L$1;
        transactionContext2 = (TransactionContext) c06741.L$0;
        ResultKt.throwOnFailure(ussdSubscriptionId);
        int iIntValue = ((Number) ussdSubscriptionId).intValue();
        Object systemService = this.context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        TelephonyManager telephonyManagerCreateForSubscriptionId = telephonyManager.createForSubscriptionId(iIntValue);
        Intrinsics.checkNotNullExpressionValue(telephonyManagerCreateForSubscriptionId, "createForSubscriptionId(...)");
        c06741.L$0 = transactionContext2;
        c06741.L$1 = ussdCode;
        c06741.L$2 = SpillingKt.nullOutSpilledVariable(telephonyManager);
        c06741.L$3 = telephonyManagerCreateForSubscriptionId;
        c06741.I$0 = iIntValue;
        c06741.I$1 = 0;
        c06741.label = 2;
        C06741 c06742 = c06741;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c06742), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        telephonyManagerCreateForSubscriptionId.sendUssdRequest(ussdCode, new CustomUssdResponseCallback(transactionContext2.getTransaction(), new Function2<Transaction, String, Unit>() { // from class: com.example.bingwahybrid.domain.engine.pipeline.handlers.UssdDialingHandler$handleExpressMode$2$callback$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Transaction transaction, String str) {
                invoke2(transaction, str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Transaction trans, String response) {
                Transaction transactionCopy$default;
                Intrinsics.checkNotNullParameter(trans, "trans");
                Intrinsics.checkNotNullParameter(response, "response");
                Offer offer = trans.getOffer();
                if (offer != null && OfferKt.supportsStrictMode(offer) && offer.getStrictMode()) {
                    transactionCopy$default = Transaction.copy$default(trans, null, null, 0, 0L, null, response + "\nAwaiting commission message from safaricom", TransactionStatus.PENDING_AWAITING_COMMISSION, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null);
                } else {
                    transactionCopy$default = Transaction.copy$default(trans, null, null, 0, 0L, null, response, TransactionStatus.SUCCESS, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null);
                }
                Transaction transaction = transactionCopy$default;
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<TransactionContext> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m10476constructorimpl(TransactionContext.copy$default(transactionContext2, transaction, null, false, null, false, null, 62, null)));
                }
            }
        }, new Function3<Transaction, Integer, String, Unit>() { // from class: com.example.bingwahybrid.domain.engine.pipeline.handlers.UssdDialingHandler$handleExpressMode$2$callback$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Transaction transaction, Integer num, String str) {
                invoke(transaction, num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(Transaction trans, int i4, String response) {
                Intrinsics.checkNotNullParameter(trans, "trans");
                Intrinsics.checkNotNullParameter(response, "response");
                Transaction transactionCopy$default = Transaction.copy$default(trans, null, null, 0, 0L, null, response, TransactionStatus.FAILED, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null);
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<TransactionContext> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m10476constructorimpl(TransactionContext.copy$default(transactionContext2, transactionCopy$default, null, false, null, false, null, 62, null)));
                }
            }
        }), new Handler(Looper.getMainLooper()));
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.example.bingwahybrid.domain.engine.pipeline.handlers.UssdDialingHandler$handleExpressMode$2$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(c06742);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:37:0x0127  */
    /* JADX WARN: Code duplicated, block: B:38:0x0153  */
    /* JADX WARN: Code duplicated, block: B:40:0x0157  */
    /* JADX WARN: Code duplicated, block: B:41:0x0184  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object handleAdvancedMode(TransactionContext transactionContext, Continuation<? super TransactionContext> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        String ussdCode;
        TransactionContext transactionContext2;
        TransactionContext transactionContext3;
        UssdSessionState ussdSessionState;
        Transaction transaction;
        Offer offer;
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
        Object ussdPhoneAccountHandle = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i == 1) {
                ussdCode = (String) anonymousClass1.L$1;
                transactionContext2 = (TransactionContext) anonymousClass1.L$0;
                ResultKt.throwOnFailure(ussdPhoneAccountHandle);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                transactionContext3 = (TransactionContext) anonymousClass1.L$0;
                ResultKt.throwOnFailure(ussdPhoneAccountHandle);
            }
            ussdSessionState = (UssdSessionState) ussdPhoneAccountHandle;
            if (ussdSessionState instanceof UssdSessionState.Success) {
                offer = transactionContext3.getTransaction().getOffer();
                if (offer == null && OfferKt.supportsStrictMode(offer) && offer.getStrictMode()) {
                    transaction = Transaction.copy$default(transactionContext3.getTransaction(), null, null, 0, 0L, null, ((UssdSessionState.Success) ussdSessionState).getResponse() + "\nAwaiting commission message from Safaricom", TransactionStatus.PENDING_AWAITING_COMMISSION, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null);
                } else {
                    transaction = Transaction.copy$default(transactionContext3.getTransaction(), null, null, 0, 0L, null, ((UssdSessionState.Success) ussdSessionState).getResponse(), TransactionStatus.SUCCESS, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null);
                }
            } else if (ussdSessionState instanceof UssdSessionState.Failure) {
                transaction = Transaction.copy$default(transactionContext3.getTransaction(), null, null, 0, 0L, null, ((UssdSessionState.Failure) ussdSessionState).getReason(), TransactionStatus.FAILED, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null);
            } else {
                transaction = transactionContext3.getTransaction();
            }
            Transaction transaction2 = transaction;
            this.ussdStepsRepository.clearSteps();
            this.ussdSessionManager.resetSession();
            this.offerSession.clear();
            return TransactionContext.copy$default(transactionContext3, transaction2, null, false, null, false, null, 62, null);
        }
        ResultKt.throwOnFailure(ussdPhoneAccountHandle);
        ussdCode = transactionContext.getUssdCode();
        if (ussdCode == null) {
            return TransactionContext.copy$default(transactionContext, Transaction.copy$default(transactionContext.getTransaction(), null, null, 0, 0L, null, "USSD code is missing", TransactionStatus.FAILED, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null), null, false, null, false, null, 62, null);
        }
        SubscriptionIdFetcherUseCase subscriptionIdFetcherUseCase = this.subscriptionIdFetcher;
        anonymousClass1.L$0 = transactionContext;
        anonymousClass1.L$1 = ussdCode;
        anonymousClass1.label = 1;
        ussdPhoneAccountHandle = subscriptionIdFetcherUseCase.getUssdPhoneAccountHandle(anonymousClass1);
        if (ussdPhoneAccountHandle != coroutine_suspended) {
            transactionContext2 = transactionContext;
        }
        return coroutine_suspended;
        PhoneAccountHandle phoneAccountHandle = (PhoneAccountHandle) ussdPhoneAccountHandle;
        Deferred<UssdSessionState> deferredMultiStepUssd = multiStepUssd(ussdCode, phoneAccountHandle);
        anonymousClass1.L$0 = transactionContext2;
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(ussdCode);
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(phoneAccountHandle);
        anonymousClass1.label = 2;
        ussdPhoneAccountHandle = deferredMultiStepUssd.await(anonymousClass1);
        if (ussdPhoneAccountHandle != coroutine_suspended) {
            transactionContext3 = transactionContext2;
            ussdSessionState = (UssdSessionState) ussdPhoneAccountHandle;
            if (ussdSessionState instanceof UssdSessionState.Success) {
                offer = transactionContext3.getTransaction().getOffer();
                if (offer == null) {
                    transaction = Transaction.copy$default(transactionContext3.getTransaction(), null, null, 0, 0L, null, ((UssdSessionState.Success) ussdSessionState).getResponse(), TransactionStatus.SUCCESS, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null);
                } else {
                    transaction = Transaction.copy$default(transactionContext3.getTransaction(), null, null, 0, 0L, null, ((UssdSessionState.Success) ussdSessionState).getResponse(), TransactionStatus.SUCCESS, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null);
                }
            } else if (ussdSessionState instanceof UssdSessionState.Failure) {
                transaction = Transaction.copy$default(transactionContext3.getTransaction(), null, null, 0, 0L, null, ((UssdSessionState.Failure) ussdSessionState).getReason(), TransactionStatus.FAILED, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null);
            } else {
                transaction = transactionContext3.getTransaction();
            }
            Transaction transaction3 = transaction;
            this.ussdStepsRepository.clearSteps();
            this.ussdSessionManager.resetSession();
            this.offerSession.clear();
            return TransactionContext.copy$default(transactionContext3, transaction3, null, false, null, false, null, 62, null);
        }
        return coroutine_suspended;
    }

    private final Deferred<UssdSessionState> multiStepUssd(String ussdCode, PhoneAccountHandle phoneAccountHandle) {
        List<String> listExtractSteps = UssdUtils.INSTANCE.extractSteps(ussdCode);
        this.ussdStepsRepository.addSteps(CollectionsKt.drop(listExtractSteps, 1));
        String strEncode = Uri.encode(UssdUtils.INSTANCE.formatFirstStep((String) CollectionsKt.first((List) listExtractSteps)));
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + strEncode));
        intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
        intent.setFlags(268435456);
        this.context.startActivity(intent);
        return this.ussdSessionManager.waitForCompletion();
    }
}
