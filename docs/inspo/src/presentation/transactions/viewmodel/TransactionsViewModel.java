package com.example.bingwahybrid.presentation.transactions.viewmodel;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.PagingData;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.DeleteTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.RetryTransactionUseCase;
import com.example.bingwahybrid.domain.utils.TimeUtilsKt;
import com.example.bingwahybrid.presentation.offers.dto.DurationFilter;
import com.example.bingwahybrid.presentation.offers.dto.FilterChipState;
import com.google.android.gms.actions.SearchIntents;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: TransactionsViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u00020/J\u000e\u00108\u001a\u0002062\u0006\u00109\u001a\u00020\fJ\u0006\u0010:\u001a\u000206J\u0006\u0010;\u001a\u000206J\u0006\u0010<\u001a\u000206J\u000e\u0010=\u001a\u0002062\u0006\u0010>\u001a\u00020\u0017J\u0006\u0010?\u001a\u000206J\u0010\u0010@\u001a\u0002062\b\u00109\u001a\u0004\u0018\u00010\u0012J\"\u0010A\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010C\u0012\u0006\u0012\u0004\u0018\u00010C0B2\b\u0010D\u001a\u0004\u0018\u00010\u0012H\u0002J\u000e\u0010E\u001a\u0002062\u0006\u0010>\u001a\u00020\u0017J\b\u0010F\u001a\u000206H\u0002J\u0006\u0010G\u001a\u000206J\u0006\u0010H\u001a\u000206J\u0006\u0010I\u001a\u000206J\u0014\u0010J\u001a\u0002062\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001c0\u001b¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0010R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0010R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0010R\u001a\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170+0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170+0\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0010R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0010R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020%0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020%0\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0010¨\u0006L"}, d2 = {"Lcom/example/bingwahybrid/presentation/transactions/viewmodel/TransactionsViewModel;", "Landroidx/lifecycle/ViewModel;", "retryTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/RetryTransactionUseCase;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "deleteTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/DeleteTransactionUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/usecase/RetryTransactionUseCase;Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/usecase/DeleteTransactionUseCase;)V", "_selectedChip", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;", "selectedChip", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectedChip", "()Lkotlinx/coroutines/flow/StateFlow;", "_selectedDurationFilterChip", "Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter;", "selectedDurationFilterChip", "getSelectedDurationFilterChip", "_liveTransactions", "", "Lcom/example/bingwahybrid/domain/model/Transaction;", "liveTransactions", "getLiveTransactions", "pagedTransactions", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "getPagedTransactions$annotations", "()V", "getPagedTransactions", "()Lkotlinx/coroutines/flow/Flow;", "_searchedTransactions", "searchedTransactions", "getSearchedTransactions", "_isSearching", "", "isSearching", "_selectionMode", "selectionMode", "getSelectionMode", "_selectedTransactions", "", "selectedTransactions", "getSelectedTransactions", "_searchText", "", "searchText", "getSearchText", "_showSearch", "showSearch", "getShowSearch", "updateSearchQuery", "", SearchIntents.EXTRA_QUERY, "setSelectedChip", "chip", "startSearch", "startSelectionMode", "stopSelectionMode", "toggleSelectedTransaction", "transaction", "stopSearch", "setSelectedDurationFilterChip", "getDurationRange", "Lkotlin/Pair;", "", "filter", "retryTransaction", "listenForLiveSearch", "clearSearch", "retryFailedSelected", "deleteSelected", "selectAllVisibleTransactions", "transactions", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TransactionsViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> _isSearching;
    private final StateFlow<List<Transaction>> _liveTransactions;
    private final MutableStateFlow<String> _searchText;
    private final MutableStateFlow<List<Transaction>> _searchedTransactions;
    private final MutableStateFlow<FilterChipState> _selectedChip;
    private final MutableStateFlow<DurationFilter> _selectedDurationFilterChip;
    private final MutableStateFlow<Set<Transaction>> _selectedTransactions;
    private final MutableStateFlow<Boolean> _selectionMode;
    private final MutableStateFlow<Boolean> _showSearch;
    private final DeleteTransactionUseCase deleteTransactionUseCase;
    private final StateFlow<Boolean> isSearching;
    private final StateFlow<List<Transaction>> liveTransactions;
    private final Flow<PagingData<Transaction>> pagedTransactions;
    private final RetryTransactionUseCase retryTransactionUseCase;
    private final StateFlow<String> searchText;
    private final StateFlow<List<Transaction>> searchedTransactions;
    private final StateFlow<FilterChipState> selectedChip;
    private final StateFlow<DurationFilter> selectedDurationFilterChip;
    private final StateFlow<Set<Transaction>> selectedTransactions;
    private final StateFlow<Boolean> selectionMode;
    private final StateFlow<Boolean> showSearch;
    private final TransactionRepository transactionRepository;

    public static /* synthetic */ void getPagedTransactions$annotations() {
    }

    @Inject
    public TransactionsViewModel(RetryTransactionUseCase retryTransactionUseCase, TransactionRepository transactionRepository, DeleteTransactionUseCase deleteTransactionUseCase) {
        Intrinsics.checkNotNullParameter(retryTransactionUseCase, "retryTransactionUseCase");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(deleteTransactionUseCase, "deleteTransactionUseCase");
        this.retryTransactionUseCase = retryTransactionUseCase;
        this.transactionRepository = transactionRepository;
        this.deleteTransactionUseCase = deleteTransactionUseCase;
        MutableStateFlow<FilterChipState> MutableStateFlow = StateFlowKt.MutableStateFlow(FilterChipState.Live.INSTANCE);
        this._selectedChip = MutableStateFlow;
        MutableStateFlow<FilterChipState> mutableStateFlow = MutableStateFlow;
        this.selectedChip = mutableStateFlow;
        MutableStateFlow<DurationFilter> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._selectedDurationFilterChip = MutableStateFlow2;
        this.selectedDurationFilterChip = MutableStateFlow2;
        final StateFlow<Map<Long, Transaction>> liveTransactions = transactionRepository.getLiveTransactions();
        Flow<List<? extends Transaction>> flow = new Flow<List<? extends Transaction>>() { // from class: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$special$$inlined$map$1

            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$special$$inlined$map$1$2", f = "TransactionsViewModel.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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
                        List list = CollectionsKt.toList(CollectionsKt.toSet(((Map) obj).values()));
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(list, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(FlowCollector<? super List<? extends Transaction>> flowCollector, Continuation continuation) {
                Object objCollect = liveTransactions.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        TransactionsViewModel transactionsViewModel = this;
        StateFlow<List<Transaction>> stateFlowStateIn = FlowKt.stateIn(flow, ViewModelKt.getViewModelScope(transactionsViewModel), SharingStarted.INSTANCE.getLazily(), CollectionsKt.emptyList());
        this._liveTransactions = stateFlowStateIn;
        this.liveTransactions = FlowKt.stateIn(FlowKt.combine(stateFlowStateIn, mutableStateFlow, new TransactionsViewModel$liveTransactions$1(null)), ViewModelKt.getViewModelScope(transactionsViewModel), SharingStarted.INSTANCE.getLazily(), CollectionsKt.emptyList());
        this.pagedTransactions = CachedPagingDataKt.cachedIn(FlowKt.transformLatest(FlowKt.combine(MutableStateFlow, MutableStateFlow2, new TransactionsViewModel$pagedTransactions$1(this, null)), new TransactionsViewModel$special$$inlined$flatMapLatest$1(null)), ViewModelKt.getViewModelScope(transactionsViewModel));
        MutableStateFlow<List<Transaction>> MutableStateFlow3 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._searchedTransactions = MutableStateFlow3;
        this.searchedTransactions = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(false);
        this._isSearching = MutableStateFlow4;
        this.isSearching = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<Boolean> MutableStateFlow5 = StateFlowKt.MutableStateFlow(false);
        this._selectionMode = MutableStateFlow5;
        this.selectionMode = FlowKt.asStateFlow(MutableStateFlow5);
        MutableStateFlow<Set<Transaction>> MutableStateFlow6 = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this._selectedTransactions = MutableStateFlow6;
        this.selectedTransactions = FlowKt.asStateFlow(MutableStateFlow6);
        MutableStateFlow<String> MutableStateFlow7 = StateFlowKt.MutableStateFlow("");
        this._searchText = MutableStateFlow7;
        this.searchText = FlowKt.asStateFlow(MutableStateFlow7);
        MutableStateFlow<Boolean> MutableStateFlow8 = StateFlowKt.MutableStateFlow(false);
        this._showSearch = MutableStateFlow8;
        this.showSearch = FlowKt.asStateFlow(MutableStateFlow8);
        listenForLiveSearch();
    }

    public final StateFlow<FilterChipState> getSelectedChip() {
        return this.selectedChip;
    }

    public final StateFlow<DurationFilter> getSelectedDurationFilterChip() {
        return this.selectedDurationFilterChip;
    }

    public final StateFlow<List<Transaction>> getLiveTransactions() {
        return this.liveTransactions;
    }

    public final Flow<PagingData<Transaction>> getPagedTransactions() {
        return this.pagedTransactions;
    }

    public final StateFlow<List<Transaction>> getSearchedTransactions() {
        return this.searchedTransactions;
    }

    public final StateFlow<Boolean> isSearching() {
        return this.isSearching;
    }

    public final StateFlow<Boolean> getSelectionMode() {
        return this.selectionMode;
    }

    public final StateFlow<Set<Transaction>> getSelectedTransactions() {
        return this.selectedTransactions;
    }

    public final StateFlow<String> getSearchText() {
        return this.searchText;
    }

    public final StateFlow<Boolean> getShowSearch() {
        return this.showSearch;
    }

    public final void updateSearchQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        this._searchText.setValue(query);
    }

    public final void setSelectedChip(FilterChipState chip) {
        Intrinsics.checkNotNullParameter(chip, "chip");
        this._selectedChip.setValue(chip);
        if ((chip instanceof FilterChipState.Live) || (chip instanceof FilterChipState.Scheduled)) {
            this._selectedDurationFilterChip.setValue(null);
        } else if (this._selectedDurationFilterChip.getValue() == null) {
            this._selectedDurationFilterChip.setValue(DurationFilter.Today.INSTANCE);
        }
    }

    public final void startSearch() {
        this._showSearch.setValue(true);
    }

    public final void startSelectionMode() {
        this._selectionMode.setValue(true);
    }

    public final void stopSelectionMode() {
        this._selectionMode.setValue(false);
        this._selectedTransactions.setValue(SetsKt.emptySet());
    }

    public final void toggleSelectedTransaction(Transaction transaction) {
        Set<Transaction> setPlus;
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        MutableStateFlow<Set<Transaction>> mutableStateFlow = this._selectedTransactions;
        if (mutableStateFlow.getValue().contains(transaction)) {
            setPlus = SetsKt.minus(this._selectedTransactions.getValue(), transaction);
        } else {
            setPlus = SetsKt.plus(this._selectedTransactions.getValue(), transaction);
        }
        mutableStateFlow.setValue(setPlus);
    }

    public final void stopSearch() {
        this._isSearching.setValue(false);
        this._showSearch.setValue(false);
    }

    public final void setSelectedDurationFilterChip(DurationFilter chip) {
        if (Intrinsics.areEqual(this._selectedChip.getValue(), FilterChipState.Scheduled.INSTANCE) || Intrinsics.areEqual(this._selectedChip.getValue(), FilterChipState.Live.INSTANCE)) {
            return;
        }
        this._selectedDurationFilterChip.setValue(chip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Long, Long> getDurationRange(DurationFilter filter) {
        if (filter instanceof DurationFilter.Today) {
            return TimeUtilsKt.todayRange();
        }
        if (filter instanceof DurationFilter.Yesterday) {
            return TimeUtilsKt.yesterdayRange();
        }
        if (filter instanceof DurationFilter.Last7Days) {
            return TimeUtilsKt.last7DaysRange();
        }
        return filter instanceof DurationFilter.Last30Days ? TimeUtilsKt.last30DaysRange() : new Pair<>(null, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$retryTransaction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransactionsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$retryTransaction$1", f = "TransactionsViewModel.kt", i = {}, l = {206}, m = "invokeSuspend", n = {}, s = {})
    static final class C07521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Transaction $transaction;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07521(Transaction transaction, Continuation<? super C07521> continuation) {
            super(2, continuation);
            this.$transaction = transaction;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionsViewModel.this.new C07521(this.$transaction, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (TransactionsViewModel.this.retryTransactionUseCase.invoke(this.$transaction, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                Log.e("TransactionsViewModel", e.getMessage(), e);
            }
            return Unit.INSTANCE;
        }
    }

    public final void retryTransaction(Transaction transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07521(transaction, null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$listenForLiveSearch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransactionsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$listenForLiveSearch$1", f = "TransactionsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07501(Continuation<? super C07501> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionsViewModel.this.new C07501(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FlowKt.launchIn(FlowKt.onEach(FlowKt.transformLatest(FlowKt.distinctUntilChanged(FlowKt.debounce(TransactionsViewModel.this._searchText, 500L)), new TransactionsViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1(null, TransactionsViewModel.this)), new AnonymousClass2(TransactionsViewModel.this, null)), ViewModelKt.getViewModelScope(TransactionsViewModel.this));
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$listenForLiveSearch$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: TransactionsViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "transactions", "", "Lcom/example/bingwahybrid/domain/model/Transaction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$listenForLiveSearch$1$2", f = "TransactionsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<List<? extends Transaction>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TransactionsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TransactionsViewModel transactionsViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = transactionsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(List<? extends Transaction> list, Continuation<? super Unit> continuation) {
                return invoke2((List<Transaction>) list, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(List<Transaction> list, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                List list = (List) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0._searchedTransactions.setValue(list);
                    this.this$0._isSearching.setValue(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void listenForLiveSearch() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07501(null), 3, null);
    }

    public final void clearSearch() {
        this._searchText.setValue("");
        this._searchedTransactions.setValue(CollectionsKt.emptyList());
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$retryFailedSelected$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransactionsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$retryFailedSelected$1", f = "TransactionsViewModel.kt", i = {0, 0, 0, 0, 0}, l = {249}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "transaction", "$i$f$forEach", "$i$a$-forEach-TransactionsViewModel$retryFailedSelected$1$1"}, s = {"L$0", "L$3", "L$4", "I$0", "I$1"})
    static final class C07511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        C07511(Continuation<? super C07511> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionsViewModel.this.new C07511(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterator it;
            Iterable iterable;
            TransactionsViewModel transactionsViewModel;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Set<Transaction> value = TransactionsViewModel.this.getSelectedTransactions().getValue();
                    TransactionsViewModel transactionsViewModel2 = TransactionsViewModel.this;
                    it = value.iterator();
                    iterable = value;
                    transactionsViewModel = transactionsViewModel2;
                    i = 0;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = this.I$0;
                    it = (Iterator) this.L$2;
                    transactionsViewModel = (TransactionsViewModel) this.L$1;
                    iterable = (Iterable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (it.hasNext()) {
                    Object next = it.next();
                    Transaction transaction = (Transaction) next;
                    if (transaction.getOffer() != null) {
                        RetryTransactionUseCase retryTransactionUseCase = transactionsViewModel.retryTransactionUseCase;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                        this.L$1 = transactionsViewModel;
                        this.L$2 = it;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(next);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(transaction);
                        this.I$0 = i;
                        this.I$1 = 0;
                        this.label = 1;
                        if (retryTransactionUseCase.invoke(transaction, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                TransactionsViewModel.this.stopSelectionMode();
            } catch (Exception e) {
                Log.e("TransactionsViewModel", String.valueOf(e.getMessage()));
            }
            return Unit.INSTANCE;
        }
    }

    public final void retryFailedSelected() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07511(null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$deleteSelected$1, reason: invalid class name */
    /* JADX INFO: compiled from: TransactionsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$deleteSelected$1", f = "TransactionsViewModel.kt", i = {0, 0, 0, 0, 0}, l = {262, 264}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "transaction", "$i$f$forEach", "$i$a$-forEach-TransactionsViewModel$deleteSelected$1$1"}, s = {"L$0", "L$3", "L$4", "I$0", "I$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransactionsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x00b0, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel.AnonymousClass1.AnonymousClass2(r14.this$0, null), r14) == r6) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Iterable iterable;
            TransactionsViewModel transactionsViewModel;
            Iterator it;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Set<Transaction> value = TransactionsViewModel.this.getSelectedTransactions().getValue();
                    iterable = value;
                    transactionsViewModel = TransactionsViewModel.this;
                    it = value.iterator();
                    i = 0;
                } else {
                    if (i2 == 1) {
                        int i3 = this.I$0;
                        Iterator it2 = (Iterator) this.L$2;
                        TransactionsViewModel transactionsViewModel2 = (TransactionsViewModel) this.L$1;
                        Iterable iterable2 = (Iterable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        i = i3;
                        it = it2;
                        transactionsViewModel = transactionsViewModel2;
                        iterable = iterable2;
                    } else {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    TransactionsViewModel.this.stopSelectionMode();
                    return Unit.INSTANCE;
                }
                while (it.hasNext()) {
                    Object next = it.next();
                    Transaction transaction = (Transaction) next;
                    DeleteTransactionUseCase deleteTransactionUseCase = transactionsViewModel.deleteTransactionUseCase;
                    UUID id = transaction.getId();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$1 = transactionsViewModel;
                    this.L$2 = it;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(next);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(transaction);
                    this.I$0 = i;
                    this.I$1 = 0;
                    this.label = 1;
                    if (DeleteTransactionUseCase.invoke$default(deleteTransactionUseCase, id, false, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.label = 2;
            } catch (Exception e) {
                Log.e("TransactionsViewModel", String.valueOf(e.getMessage()));
            }
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$deleteSelected$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: TransactionsViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$deleteSelected$1$2", f = "TransactionsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TransactionsViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TransactionsViewModel transactionsViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = transactionsViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0._selectedTransactions.setValue(SetsKt.emptySet());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void deleteSelected() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    public final void selectAllVisibleTransactions(List<Transaction> transactions) {
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        MutableStateFlow<Set<Transaction>> mutableStateFlow = this._selectedTransactions;
        mutableStateFlow.setValue(SetsKt.plus((Set) mutableStateFlow.getValue(), (Iterable) CollectionsKt.toSet(transactions)));
    }
}
