package com.example.bingwahybrid.presentation.transactions.viewmodel;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.enums.DeleteState;
import com.example.bingwahybrid.domain.enums.LoadingState;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.DeleteTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.ObserveTransactionStatusUseCase;
import com.example.bingwahybrid.domain.usecase.RetryTransactionUseCase;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: TransactionDetailsViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0013\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u000e\u0010/\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u0006\u00100\u001a\u00020+J\u0006\u00101\u001a\u00020+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00160\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00160\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0014R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020%0\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0014¨\u00062"}, d2 = {"Lcom/example/bingwahybrid/presentation/transactions/viewmodel/TransactionDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "deleteTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/DeleteTransactionUseCase;", "retryTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/RetryTransactionUseCase;", "observeTransactionStatusUseCase", "Lcom/example/bingwahybrid/domain/usecase/ObserveTransactionStatusUseCase;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/usecase/DeleteTransactionUseCase;Lcom/example/bingwahybrid/domain/usecase/RetryTransactionUseCase;Lcom/example/bingwahybrid/domain/usecase/ObserveTransactionStatusUseCase;Lcom/example/bingwahybrid/domain/repository/TransactionRepository;)V", "observeTransactionJob", "Lkotlinx/coroutines/Job;", "_transaction", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bingwahybrid/domain/model/Transaction;", "transaction", "Lkotlinx/coroutines/flow/StateFlow;", "getTransaction", "()Lkotlinx/coroutines/flow/StateFlow;", "_scheduledTransactions", "", "scheduledTransactions", "getScheduledTransactions", "_snackbarMessage", "", "snackbarMessage", "getSnackbarMessage", "_deleteState", "Lcom/example/bingwahybrid/domain/enums/DeleteState;", "deleteState", "getDeleteState", "_isRetrying", "", "isRetrying", "_transactionLoadingState", "Lcom/example/bingwahybrid/domain/enums/LoadingState;", "loadingState", "getLoadingState", "_scheduledTransactionsLoadingState", "scheduledTransactionsLoadingState", "getScheduledTransactionsLoadingState", "", "transactionId", "Ljava/util/UUID;", "getScheduledTransactionsForTransactionId", "retryTransaction", "deleteTransaction", "resetSnackbarMessage", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TransactionDetailsViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<DeleteState> _deleteState;
    private final MutableStateFlow<Boolean> _isRetrying;
    private final MutableStateFlow<List<Transaction>> _scheduledTransactions;
    private final MutableStateFlow<LoadingState> _scheduledTransactionsLoadingState;
    private final MutableStateFlow<String> _snackbarMessage;
    private final MutableStateFlow<Transaction> _transaction;
    private final MutableStateFlow<LoadingState> _transactionLoadingState;
    private final StateFlow<DeleteState> deleteState;
    private final DeleteTransactionUseCase deleteTransactionUseCase;
    private final StateFlow<Boolean> isRetrying;
    private final StateFlow<LoadingState> loadingState;
    private Job observeTransactionJob;
    private final ObserveTransactionStatusUseCase observeTransactionStatusUseCase;
    private final RetryTransactionUseCase retryTransactionUseCase;
    private final StateFlow<List<Transaction>> scheduledTransactions;
    private final StateFlow<LoadingState> scheduledTransactionsLoadingState;
    private final StateFlow<String> snackbarMessage;
    private final StateFlow<Transaction> transaction;
    private final TransactionRepository transactionRepository;

    @Inject
    public TransactionDetailsViewModel(DeleteTransactionUseCase deleteTransactionUseCase, RetryTransactionUseCase retryTransactionUseCase, ObserveTransactionStatusUseCase observeTransactionStatusUseCase, TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(deleteTransactionUseCase, "deleteTransactionUseCase");
        Intrinsics.checkNotNullParameter(retryTransactionUseCase, "retryTransactionUseCase");
        Intrinsics.checkNotNullParameter(observeTransactionStatusUseCase, "observeTransactionStatusUseCase");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        this.deleteTransactionUseCase = deleteTransactionUseCase;
        this.retryTransactionUseCase = retryTransactionUseCase;
        this.observeTransactionStatusUseCase = observeTransactionStatusUseCase;
        this.transactionRepository = transactionRepository;
        MutableStateFlow<Transaction> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._transaction = MutableStateFlow;
        this.transaction = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<List<Transaction>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._scheduledTransactions = MutableStateFlow2;
        this.scheduledTransactions = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._snackbarMessage = MutableStateFlow3;
        this.snackbarMessage = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<DeleteState> MutableStateFlow4 = StateFlowKt.MutableStateFlow(DeleteState.Idle.INSTANCE);
        this._deleteState = MutableStateFlow4;
        this.deleteState = MutableStateFlow4;
        MutableStateFlow<Boolean> MutableStateFlow5 = StateFlowKt.MutableStateFlow(false);
        this._isRetrying = MutableStateFlow5;
        this.isRetrying = FlowKt.asStateFlow(MutableStateFlow5);
        MutableStateFlow<LoadingState> MutableStateFlow6 = StateFlowKt.MutableStateFlow(LoadingState.Idle.INSTANCE);
        this._transactionLoadingState = MutableStateFlow6;
        this.loadingState = MutableStateFlow6;
        MutableStateFlow<LoadingState> MutableStateFlow7 = StateFlowKt.MutableStateFlow(LoadingState.Idle.INSTANCE);
        this._scheduledTransactionsLoadingState = MutableStateFlow7;
        this.scheduledTransactionsLoadingState = MutableStateFlow7;
    }

    public final StateFlow<Transaction> getTransaction() {
        return this.transaction;
    }

    public final StateFlow<List<Transaction>> getScheduledTransactions() {
        return this.scheduledTransactions;
    }

    public final StateFlow<String> getSnackbarMessage() {
        return this.snackbarMessage;
    }

    public final StateFlow<DeleteState> getDeleteState() {
        return this.deleteState;
    }

    public final StateFlow<Boolean> isRetrying() {
        return this.isRetrying;
    }

    public final StateFlow<LoadingState> getLoadingState() {
        return this.loadingState;
    }

    public final StateFlow<LoadingState> getScheduledTransactionsLoadingState() {
        return this.scheduledTransactionsLoadingState;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getTransaction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransactionDetailsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getTransaction$1", f = "TransactionDetailsViewModel.kt", i = {}, l = {65, 72}, m = "invokeSuspend", n = {}, s = {})
    static final class C07481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UUID $transactionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07481(UUID uuid, Continuation<? super C07481> continuation) {
            super(2, continuation);
            this.$transactionId = uuid;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionDetailsViewModel.this.new C07481(this.$transactionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0078, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.collectLatest(kotlinx.coroutines.flow.FlowKt.stateIn(kotlinx.coroutines.flow.FlowKt.m12020catch(kotlinx.coroutines.flow.FlowKt.onStart((kotlinx.coroutines.flow.Flow) r6, new com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel.C07481.C01441(r5.this$0, null)), new com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel.C07481.AnonymousClass2(r5.this$0, null)), androidx.lifecycle.ViewModelKt.getViewModelScope(r5.this$0), kotlinx.coroutines.flow.SharingStarted.INSTANCE.getLazily(), null), new com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel.C07481.AnonymousClass3(r5.this$0, null), r5) == r0) goto L15;
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
                obj = TransactionDetailsViewModel.this.transactionRepository.getTransactionByIdFlow(this.$transactionId, this);
                if (obj != coroutine_suspended) {
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
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getTransaction$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TransactionDetailsViewModel.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/example/bingwahybrid/domain/model/Transaction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getTransaction$1$1", f = "TransactionDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01441 extends SuspendLambda implements Function2<FlowCollector<? super Transaction>, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TransactionDetailsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01441(TransactionDetailsViewModel transactionDetailsViewModel, Continuation<? super C01441> continuation) {
                super(2, continuation);
                this.this$0 = transactionDetailsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01441(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(FlowCollector<? super Transaction> flowCollector, Continuation<? super Unit> continuation) {
                return ((C01441) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0._transactionLoadingState.setValue(LoadingState.Loading.INSTANCE);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getTransaction$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: TransactionDetailsViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/example/bingwahybrid/domain/model/Transaction;", "e", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getTransaction$1$2", f = "TransactionDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super Transaction>, Throwable, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TransactionDetailsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TransactionDetailsViewModel transactionDetailsViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
                this.this$0 = transactionDetailsViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super Transaction> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = th;
                return anonymousClass2.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Throwable th = (Throwable) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow mutableStateFlow = this.this$0._transactionLoadingState;
                    String message = th.getMessage();
                    if (message == null) {
                        message = "An unknown error occurred";
                    }
                    mutableStateFlow.setValue(new LoadingState.Failure(message));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getTransaction$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: TransactionDetailsViewModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/example/bingwahybrid/domain/model/Transaction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getTransaction$1$3", f = "TransactionDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<Transaction, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TransactionDetailsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(TransactionDetailsViewModel transactionDetailsViewModel, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = transactionDetailsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Transaction transaction, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(transaction, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Transaction transaction = (Transaction) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0._transaction.setValue(transaction);
                    this.this$0._transactionLoadingState.setValue(transaction != null ? new LoadingState.Success("Transaction loaded") : LoadingState.Idle.INSTANCE);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void getTransaction(UUID transactionId) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07481(transactionId, null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getScheduledTransactionsForTransactionId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransactionDetailsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getScheduledTransactionsForTransactionId$1", f = "TransactionDetailsViewModel.kt", i = {}, l = {82, 89}, m = "invokeSuspend", n = {}, s = {})
    static final class C07471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UUID $transactionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07471(UUID uuid, Continuation<? super C07471> continuation) {
            super(2, continuation);
            this.$transactionId = uuid;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionDetailsViewModel.this.new C07471(this.$transactionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x007c, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.collectLatest(kotlinx.coroutines.flow.FlowKt.stateIn(kotlinx.coroutines.flow.FlowKt.m12020catch(kotlinx.coroutines.flow.FlowKt.onStart((kotlinx.coroutines.flow.Flow) r7, new com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel.C07471.C01431(r6.this$0, null)), new com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel.C07471.AnonymousClass2(r6.this$0, null)), androidx.lifecycle.ViewModelKt.getViewModelScope(r6.this$0), kotlinx.coroutines.flow.SharingStarted.INSTANCE.getLazily(), kotlin.collections.CollectionsKt.emptyList()), new com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel.C07471.AnonymousClass3(r6.this$0, null), r6) == r0) goto L15;
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
                obj = TransactionDetailsViewModel.this.transactionRepository.getScheduledTransactionsForTransactionId(this.$transactionId, this);
                if (obj != coroutine_suspended) {
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
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getScheduledTransactionsForTransactionId$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TransactionDetailsViewModel.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/example/bingwahybrid/domain/model/Transaction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getScheduledTransactionsForTransactionId$1$1", f = "TransactionDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01431 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends Transaction>>, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TransactionDetailsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01431(TransactionDetailsViewModel transactionDetailsViewModel, Continuation<? super C01431> continuation) {
                super(2, continuation);
                this.this$0 = transactionDetailsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01431(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends Transaction>> flowCollector, Continuation<? super Unit> continuation) {
                return invoke2((FlowCollector<? super List<Transaction>>) flowCollector, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(FlowCollector<? super List<Transaction>> flowCollector, Continuation<? super Unit> continuation) {
                return ((C01431) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0._scheduledTransactionsLoadingState.setValue(LoadingState.Loading.INSTANCE);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getScheduledTransactionsForTransactionId$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: TransactionDetailsViewModel.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/example/bingwahybrid/domain/model/Transaction;", "e", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getScheduledTransactionsForTransactionId$1$2", f = "TransactionDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends Transaction>>, Throwable, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TransactionDetailsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TransactionDetailsViewModel transactionDetailsViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
                this.this$0 = transactionDetailsViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends Transaction>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return invoke2((FlowCollector<? super List<Transaction>>) flowCollector, th, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(FlowCollector<? super List<Transaction>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = th;
                return anonymousClass2.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Throwable th = (Throwable) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow mutableStateFlow = this.this$0._scheduledTransactionsLoadingState;
                    String message = th.getMessage();
                    if (message == null) {
                        message = "Unknown error loading transactions";
                    }
                    mutableStateFlow.setValue(new LoadingState.Failure(message));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getScheduledTransactionsForTransactionId$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: TransactionDetailsViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "Lcom/example/bingwahybrid/domain/model/Transaction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$getScheduledTransactionsForTransactionId$1$3", f = "TransactionDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<List<? extends Transaction>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TransactionDetailsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(TransactionDetailsViewModel transactionDetailsViewModel, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = transactionDetailsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(List<? extends Transaction> list, Continuation<? super Unit> continuation) {
                return invoke2((List<Transaction>) list, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(List<Transaction> list, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                List list = (List) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0._scheduledTransactions.setValue(list);
                    this.this$0._scheduledTransactionsLoadingState.setValue(!list.isEmpty() ? new LoadingState.Success("Scheduled transactions loaded successfully") : LoadingState.Idle.INSTANCE);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void getScheduledTransactionsForTransactionId(UUID transactionId) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07471(transactionId, null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$retryTransaction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransactionDetailsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$retryTransaction$1", f = "TransactionDetailsViewModel.kt", i = {1}, l = {101, 115}, m = "invokeSuspend", n = {"savedTransaction"}, s = {"L$0"})
    static final class C07491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UUID $transactionId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07491(UUID uuid, Continuation<? super C07491> continuation) {
            super(2, continuation);
            this.$transactionId = uuid;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionDetailsViewModel.this.new C07491(this.$transactionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0097, code lost:
        
            if (r8.this$0.retryTransactionUseCase.invoke(r9, r8) == r0) goto L26;
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
                    TransactionDetailsViewModel.this._isRetrying.setValue(Boxing.boxBoolean(true));
                    this.label = 1;
                    obj = TransactionDetailsViewModel.this.transactionRepository.getTransactionById(this.$transactionId, this);
                    if (obj == coroutine_suspended) {
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
                Transaction transaction = (Transaction) obj;
                if (transaction != null) {
                    Job job = TransactionDetailsViewModel.this.observeTransactionJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    TransactionDetailsViewModel transactionDetailsViewModel = TransactionDetailsViewModel.this;
                    transactionDetailsViewModel.observeTransactionJob = FlowKt.launchIn(FlowKt.onEach(transactionDetailsViewModel.observeTransactionStatusUseCase.invoke(this.$transactionId), new C01451(TransactionDetailsViewModel.this, null)), ViewModelKt.getViewModelScope(TransactionDetailsViewModel.this));
                    this.L$0 = SpillingKt.nullOutSpilledVariable(transaction);
                    this.label = 2;
                } else {
                    throw new Exception("Transaction not found");
                }
            } catch (Exception e) {
                Job job2 = TransactionDetailsViewModel.this.observeTransactionJob;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                TransactionDetailsViewModel.this._snackbarMessage.setValue(e.getMessage());
                TransactionDetailsViewModel.this._isRetrying.setValue(Boxing.boxBoolean(false));
            }
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$retryTransaction$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TransactionDetailsViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$retryTransaction$1$1", f = "TransactionDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01451 extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends String>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TransactionDetailsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01451(TransactionDetailsViewModel transactionDetailsViewModel, Continuation<? super C01451> continuation) {
                super(2, continuation);
                this.this$0 = transactionDetailsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01451 c01451 = new C01451(this.this$0, continuation);
                c01451.L$0 = obj;
                return c01451;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Pair<? extends Boolean, ? extends String> pair, Continuation<? super Unit> continuation) {
                return invoke2((Pair<Boolean, String>) pair, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Pair<Boolean, String> pair, Continuation<? super Unit> continuation) {
                return ((C01451) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Pair pair = (Pair) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean zBooleanValue = ((Boolean) pair.component1()).booleanValue();
                    String str = (String) pair.component2();
                    this.this$0._isRetrying.setValue(Boxing.boxBoolean(false));
                    this.this$0._snackbarMessage.setValue((zBooleanValue ? new StringBuilder("Success: ") : new StringBuilder("Failed: ")).append(str).toString());
                    Job job = this.this$0.observeTransactionJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void retryTransaction(UUID transactionId) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07491(transactionId, null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$deleteTransaction$1, reason: invalid class name */
    /* JADX INFO: compiled from: TransactionDetailsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel$deleteTransaction$1", f = "TransactionDetailsViewModel.kt", i = {0, 0}, l = {129}, m = "invokeSuspend", n = {"transaction", "$i$a$-let-TransactionDetailsViewModel$deleteTransaction$1$1"}, s = {"L$1", "I$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionDetailsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x0095  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AnonymousClass1 anonymousClass1;
            TransactionDetailsViewModel transactionDetailsViewModel;
            Exception exc;
            String message;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    Transaction transaction = (Transaction) TransactionDetailsViewModel.this._transaction.getValue();
                    if (transaction != null) {
                        TransactionDetailsViewModel transactionDetailsViewModel2 = TransactionDetailsViewModel.this;
                        transactionDetailsViewModel2._deleteState.setValue(DeleteState.Deleting.INSTANCE);
                        DeleteTransactionUseCase deleteTransactionUseCase = transactionDetailsViewModel2.deleteTransactionUseCase;
                        UUID id = transaction.getId();
                        this.L$0 = transactionDetailsViewModel2;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(transaction);
                        this.I$0 = 0;
                        this.label = 1;
                        anonymousClass1 = this;
                        try {
                            if (DeleteTransactionUseCase.invoke$default(deleteTransactionUseCase, id, false, anonymousClass1, 2, null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            transactionDetailsViewModel = transactionDetailsViewModel2;
                        } catch (Exception e) {
                            e = e;
                            exc = e;
                            Log.e("TransactionDetailsViewModel", "Error deleting transaction", exc);
                            TransactionDetailsViewModel.this._snackbarMessage.setValue(exc.getMessage());
                            MutableStateFlow mutableStateFlow = TransactionDetailsViewModel.this._deleteState;
                            message = exc.getMessage();
                            if (message == null) {
                                message = "Unknown error";
                            }
                            mutableStateFlow.setValue(new DeleteState.Failed(message));
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    anonymousClass1 = this;
                    exc = e;
                    Log.e("TransactionDetailsViewModel", "Error deleting transaction", exc);
                    TransactionDetailsViewModel.this._snackbarMessage.setValue(exc.getMessage());
                    MutableStateFlow mutableStateFlow2 = TransactionDetailsViewModel.this._deleteState;
                    message = exc.getMessage();
                    if (message == null) {
                        message = "Unknown error";
                    }
                    mutableStateFlow2.setValue(new DeleteState.Failed(message));
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            transactionDetailsViewModel = (TransactionDetailsViewModel) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                anonymousClass1 = this;
            } catch (Exception e3) {
                exc = e3;
                anonymousClass1 = this;
                Log.e("TransactionDetailsViewModel", "Error deleting transaction", exc);
                TransactionDetailsViewModel.this._snackbarMessage.setValue(exc.getMessage());
                MutableStateFlow mutableStateFlow3 = TransactionDetailsViewModel.this._deleteState;
                message = exc.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                mutableStateFlow3.setValue(new DeleteState.Failed(message));
            }
            transactionDetailsViewModel._deleteState.setValue(DeleteState.Deleted.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public final void deleteTransaction() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void resetSnackbarMessage() {
        this._snackbarMessage.setValue(null);
    }
}
