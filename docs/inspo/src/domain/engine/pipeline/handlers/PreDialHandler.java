package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.engine.FormatUssdUseCase;
import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain;
import com.example.bingwahybrid.domain.enums.ProcessingMode;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.model.TransactionContext;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.model.OfferVerificationInfo;
import com.example.bingwahybrid.domain.offers.repository.OfferVerificationRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import com.example.bingwahybrid.domain.ussd.repository.OfferSession;
import com.example.bingwahybrid.domain.ussd.repository.UssdSessionManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PreDialHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/PreDialHandler;", "Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionHandler;", "updateTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;", "formatUssdUseCase", "Lcom/example/bingwahybrid/domain/engine/FormatUssdUseCase;", "ussdSessionManager", "Lcom/example/bingwahybrid/domain/ussd/repository/UssdSessionManager;", "offerVerificationRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferVerificationRepository;", "offerSession", "Lcom/example/bingwahybrid/domain/ussd/repository/OfferSession;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;Lcom/example/bingwahybrid/domain/engine/FormatUssdUseCase;Lcom/example/bingwahybrid/domain/ussd/repository/UssdSessionManager;Lcom/example/bingwahybrid/domain/offers/repository/OfferVerificationRepository;Lcom/example/bingwahybrid/domain/ussd/repository/OfferSession;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "handle", "Lcom/example/bingwahybrid/domain/model/TransactionContext;", "context", "chain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "(Lcom/example/bingwahybrid/domain/model/TransactionContext;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreDialHandler implements TransactionHandler {
    public static final int $stable = 8;
    private final FormatUssdUseCase formatUssdUseCase;
    private final OfferSession offerSession;
    private final OfferVerificationRepository offerVerificationRepository;
    private final CoroutineScope scope;
    private final SettingsRepository settingsRepository;
    private final UpdateTransactionUseCase updateTransactionUseCase;
    private final UssdSessionManager ussdSessionManager;

    @Inject
    public PreDialHandler(UpdateTransactionUseCase updateTransactionUseCase, FormatUssdUseCase formatUssdUseCase, UssdSessionManager ussdSessionManager, OfferVerificationRepository offerVerificationRepository, OfferSession offerSession, SettingsRepository settingsRepository) {
        Intrinsics.checkNotNullParameter(updateTransactionUseCase, "updateTransactionUseCase");
        Intrinsics.checkNotNullParameter(formatUssdUseCase, "formatUssdUseCase");
        Intrinsics.checkNotNullParameter(ussdSessionManager, "ussdSessionManager");
        Intrinsics.checkNotNullParameter(offerVerificationRepository, "offerVerificationRepository");
        Intrinsics.checkNotNullParameter(offerSession, "offerSession");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        this.updateTransactionUseCase = updateTransactionUseCase;
        this.formatUssdUseCase = formatUssdUseCase;
        this.ussdSessionManager = ussdSessionManager;
        this.offerVerificationRepository = offerVerificationRepository;
        this.offerSession = offerSession;
        this.settingsRepository = settingsRepository;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    @Override // com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler
    public Object handle(TransactionContext transactionContext, HandlerChain handlerChain, Continuation<? super TransactionContext> continuation) {
        String ussdCode;
        Transaction transaction = transactionContext.getTransaction();
        FormatUssdUseCase formatUssdUseCase = this.formatUssdUseCase;
        Offer offer = transaction.getOffer();
        if (offer == null || (ussdCode = offer.getUssdCode()) == null) {
            ussdCode = "";
        }
        String strInvoke = formatUssdUseCase.invoke(ussdCode, transaction.getCustomer().getPhone(), transaction.getAmount());
        Transaction transactionCopy$default = Transaction.copy$default(transactionContext.getTransaction(), null, null, 0, 0L, null, null, TransactionStatus.PROCESSING, null, null, null, null, 0, 0, 0L, null, null, null, 131007, null);
        this.ussdSessionManager.resetSession();
        this.ussdSessionManager.setCurrentTransaction(transactionContext.getTransaction());
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass2(transactionCopy$default, transactionContext, null), 3, null);
        return TransactionContext.copy$default(transactionContext, transactionCopy$default, strInvoke, false, null, false, null, 60, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.handlers.PreDialHandler$handle$2, reason: invalid class name */
    /* JADX INFO: compiled from: PreDialHandler.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.handlers.PreDialHandler$handle$2", f = "PreDialHandler.kt", i = {1, 1}, l = {50, 56}, m = "invokeSuspend", n = {"offer", "isAdvancedMode"}, s = {"L$0", "I$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TransactionContext $context;
        final /* synthetic */ Transaction $updatedTransaction;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Transaction transaction, TransactionContext transactionContext, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$updatedTransaction = transaction;
            this.$context = transactionContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PreDialHandler.this.new AnonymousClass2(this.$updatedTransaction, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x007c, code lost:
        
            if (r7 == r0) goto L23;
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
                this.label = 1;
                if (PreDialHandler.this.updateTransactionUseCase.invoke(this.$updatedTransaction, this) != coroutine_suspended) {
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
            OfferVerificationInfo offerVerificationInfo = (OfferVerificationInfo) obj;
            if (offerVerificationInfo != null) {
                PreDialHandler.this.offerSession.start(offerVerificationInfo.getSteps());
            }
            return Unit.INSTANCE;
            Offer offer = this.$context.getTransaction().getOffer();
            int i2 = PreDialHandler.this.settingsRepository.getProcessingMode().getValue() != ProcessingMode.ADVANCED ? 0 : 1;
            if (offer == null || !offer.isVerified() || i2 == 0) {
                PreDialHandler.this.offerSession.clear();
            } else {
                this.L$0 = SpillingKt.nullOutSpilledVariable(offer);
                this.I$0 = i2;
                this.label = 2;
                obj = PreDialHandler.this.offerVerificationRepository.findByOfferId(offer.getId(), this);
            }
            return Unit.INSTANCE;
        }
    }
}
