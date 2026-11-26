package com.example.bingwahybrid.presentation.autorenewal.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.enums.LoadingState;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: AutoRenewViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/example/bingwahybrid/presentation/autorenewal/viewmodel/AutoRenewViewModel;", "Landroidx/lifecycle/ViewModel;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;)V", "_loadingState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bingwahybrid/domain/enums/LoadingState;", "loadingState", "Lkotlinx/coroutines/flow/StateFlow;", "getLoadingState", "()Lkotlinx/coroutines/flow/StateFlow;", "_transactions", "", "Lcom/example/bingwahybrid/domain/model/Transaction;", "transactions", "getTransactions", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AutoRenewViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<LoadingState> _loadingState;
    private final MutableStateFlow<List<Transaction>> _transactions;
    private final StateFlow<LoadingState> loadingState;
    private final TransactionRepository transactionRepository;
    private final StateFlow<List<Transaction>> transactions;

    @Inject
    public AutoRenewViewModel(TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        this.transactionRepository = transactionRepository;
        MutableStateFlow<LoadingState> MutableStateFlow = StateFlowKt.MutableStateFlow(LoadingState.Idle.INSTANCE);
        this._loadingState = MutableStateFlow;
        this.loadingState = MutableStateFlow;
        MutableStateFlow<List<Transaction>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._transactions = MutableStateFlow2;
        this.transactions = MutableStateFlow2;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final StateFlow<LoadingState> getLoadingState() {
        return this.loadingState;
    }

    public final StateFlow<List<Transaction>> getTransactions() {
        return this.transactions;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.autorenewal.viewmodel.AutoRenewViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoRenewViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.autorenewal.viewmodel.AutoRenewViewModel$1", f = "AutoRenewViewModel.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoRenewViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                    AutoRenewViewModel.this._loadingState.setValue(LoadingState.Loading.INSTANCE);
                    Flow<List<Transaction>> autoRenewalParentTransactions = AutoRenewViewModel.this.transactionRepository.getAutoRenewalParentTransactions();
                    final AutoRenewViewModel autoRenewViewModel = AutoRenewViewModel.this;
                    this.label = 1;
                    Object objCollect = autoRenewalParentTransactions.collect(new FlowCollector() { // from class: com.example.bingwahybrid.presentation.autorenewal.viewmodel.AutoRenewViewModel.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<Transaction>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<Transaction> list, Continuation<? super Unit> continuation) {
                            autoRenewViewModel._transactions.setValue(list);
                            autoRenewViewModel._loadingState.setValue(new LoadingState.Success("Transactions loaded successfully"));
                            return Unit.INSTANCE;
                        }
                    }, this);
                    this = objCollect;
                    if (objCollect == coroutine_suspended) {
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
                AutoRenewViewModel.this._loadingState.setValue(new LoadingState.Failure(String.valueOf(e.getMessage())));
            }
            return Unit.INSTANCE;
        }
    }
}
