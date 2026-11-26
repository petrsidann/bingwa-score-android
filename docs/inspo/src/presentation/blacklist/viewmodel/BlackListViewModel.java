package com.example.bingwahybrid.presentation.blacklist.viewmodel;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.google.android.gms.actions.SearchIntents;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: BlackListViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0017J\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u001bJ\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0017J\u000e\u0010#\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0017J\b\u0010$\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000b¨\u0006%"}, d2 = {"Lcom/example/bingwahybrid/presentation/blacklist/viewmodel/BlackListViewModel;", "Landroidx/lifecycle/ViewModel;", "customerRepository", "Lcom/example/bingwahybrid/domain/repository/CustomerRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/CustomerRepository;)V", "blackList", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/bingwahybrid/domain/model/Customer;", "getBlackList", "()Lkotlinx/coroutines/flow/StateFlow;", "_allCustomers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "allCustomers", "getAllCustomers", "_isSearching", "", "isSearching", "_searchedCustomers", "searchedCustomers", "getSearchedCustomers", "_searchQuery", "", "searchQuery", "getSearchQuery", "fetchAllCustomers", "", "updateSearchQuery", SearchIntents.EXTRA_QUERY, "startSearch", "stopSearch", "clearSearch", "removeFromBlackList", "customerPhone", "addToBlackList", "listenForLiveSearch", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BlackListViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<List<Customer>> _allCustomers;
    private final MutableStateFlow<Boolean> _isSearching;
    private final MutableStateFlow<String> _searchQuery;
    private final MutableStateFlow<List<Customer>> _searchedCustomers;
    private final StateFlow<List<Customer>> allCustomers;
    private final StateFlow<List<Customer>> blackList;
    private final CustomerRepository customerRepository;
    private final StateFlow<Boolean> isSearching;
    private final StateFlow<String> searchQuery;
    private final StateFlow<List<Customer>> searchedCustomers;

    @Inject
    public BlackListViewModel(CustomerRepository customerRepository) {
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        this.customerRepository = customerRepository;
        this.blackList = FlowKt.stateIn(customerRepository.getBlackListedCustomers(), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), CollectionsKt.emptyList());
        MutableStateFlow<List<Customer>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._allCustomers = MutableStateFlow;
        this.allCustomers = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._isSearching = MutableStateFlow2;
        this.isSearching = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<List<Customer>> MutableStateFlow3 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._searchedCustomers = MutableStateFlow3;
        this.searchedCustomers = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<String> MutableStateFlow4 = StateFlowKt.MutableStateFlow("");
        this._searchQuery = MutableStateFlow4;
        this.searchQuery = FlowKt.asStateFlow(MutableStateFlow4);
        fetchAllCustomers();
        listenForLiveSearch();
    }

    public final StateFlow<List<Customer>> getBlackList() {
        return this.blackList;
    }

    public final StateFlow<List<Customer>> getAllCustomers() {
        return this.allCustomers;
    }

    public final StateFlow<Boolean> isSearching() {
        return this.isSearching;
    }

    public final StateFlow<List<Customer>> getSearchedCustomers() {
        return this.searchedCustomers;
    }

    public final StateFlow<String> getSearchQuery() {
        return this.searchQuery;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.blacklist.viewmodel.BlackListViewModel$fetchAllCustomers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlackListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.blacklist.viewmodel.BlackListViewModel$fetchAllCustomers$1", f = "BlackListViewModel.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    static final class C07121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C07121(Continuation<? super C07121> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlackListViewModel.this.new C07121(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow2 = BlackListViewModel.this._allCustomers;
                this.L$0 = mutableStateFlow2;
                this.label = 1;
                Object allCustomers = BlackListViewModel.this.customerRepository.getAllCustomers(this);
                if (allCustomers == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = allCustomers;
                mutableStateFlow = mutableStateFlow2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableStateFlow = (MutableStateFlow) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            mutableStateFlow.setValue(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchAllCustomers() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07121(null), 2, null);
    }

    public final void updateSearchQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        this._searchQuery.setValue(query);
    }

    public final void startSearch() {
        this._isSearching.setValue(true);
    }

    public final void stopSearch() {
        this._isSearching.setValue(false);
        clearSearch();
    }

    public final void clearSearch() {
        this._searchQuery.setValue("");
        this._searchedCustomers.setValue(CollectionsKt.emptyList());
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.blacklist.viewmodel.BlackListViewModel$removeFromBlackList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlackListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.blacklist.viewmodel.BlackListViewModel$removeFromBlackList$1", f = "BlackListViewModel.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    static final class C07141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $customerPhone;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07141(String str, Continuation<? super C07141> continuation) {
            super(2, continuation);
            this.$customerPhone = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlackListViewModel.this.new C07141(this.$customerPhone, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BlackListViewModel.this.customerRepository.removeFromBlackList(this.$customerPhone, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BlackListViewModel.this.fetchAllCustomers();
            return Unit.INSTANCE;
        }
    }

    public final void removeFromBlackList(String customerPhone) {
        Intrinsics.checkNotNullParameter(customerPhone, "customerPhone");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07141(customerPhone, null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.blacklist.viewmodel.BlackListViewModel$addToBlackList$1, reason: invalid class name */
    /* JADX INFO: compiled from: BlackListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.blacklist.viewmodel.BlackListViewModel$addToBlackList$1", f = "BlackListViewModel.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $customerPhone;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$customerPhone = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlackListViewModel.this.new AnonymousClass1(this.$customerPhone, continuation);
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
                if (BlackListViewModel.this.customerRepository.addToBlackList(this.$customerPhone, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BlackListViewModel.this.fetchAllCustomers();
            return Unit.INSTANCE;
        }
    }

    public final void addToBlackList(String customerPhone) {
        Intrinsics.checkNotNullParameter(customerPhone, "customerPhone");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(customerPhone, null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.blacklist.viewmodel.BlackListViewModel$listenForLiveSearch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlackListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.blacklist.viewmodel.BlackListViewModel$listenForLiveSearch$1", f = "BlackListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07131(Continuation<? super C07131> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlackListViewModel.this.new C07131(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FlowKt.launchIn(FlowKt.onEach(FlowKt.transformLatest(FlowKt.distinctUntilChanged(FlowKt.debounce(BlackListViewModel.this._searchQuery, 500L)), new BlackListViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1(null, BlackListViewModel.this)), new AnonymousClass2(BlackListViewModel.this, null)), ViewModelKt.getViewModelScope(BlackListViewModel.this));
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.blacklist.viewmodel.BlackListViewModel$listenForLiveSearch$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: BlackListViewModel.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "transactions", "", "Lcom/example/bingwahybrid/domain/model/Customer;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.blacklist.viewmodel.BlackListViewModel$listenForLiveSearch$1$2", f = "BlackListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<List<? extends Customer>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ BlackListViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(BlackListViewModel blackListViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = blackListViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(List<? extends Customer> list, Continuation<? super Unit> continuation) {
                return invoke2((List<Customer>) list, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(List<Customer> list, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                List list = (List) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0._searchedCustomers.setValue(list);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void listenForLiveSearch() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07131(null), 3, null);
    }
}
