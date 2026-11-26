package com.example.bingwahybrid.presentation.transactions.viewmodel;

import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms__PagingDataTransformsKt;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.enums.TransactionStatusKt;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.presentation.offers.dto.DurationFilter;
import com.example.bingwahybrid.presentation.offers.dto.FilterChipState;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: TransactionsViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/example/bingwahybrid/domain/model/Transaction;", "chip", "Lcom/example/bingwahybrid/presentation/offers/dto/FilterChipState;", "duration", "Lcom/example/bingwahybrid/presentation/offers/dto/DurationFilter;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$pagedTransactions$1", f = "TransactionsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TransactionsViewModel$pagedTransactions$1 extends SuspendLambda implements Function3<FilterChipState, DurationFilter, Continuation<? super Flow<? extends PagingData<Transaction>>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ TransactionsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransactionsViewModel$pagedTransactions$1(TransactionsViewModel transactionsViewModel, Continuation<? super TransactionsViewModel$pagedTransactions$1> continuation) {
        super(3, continuation);
        this.this$0 = transactionsViewModel;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FilterChipState filterChipState, DurationFilter durationFilter, Continuation<? super Flow<PagingData<Transaction>>> continuation) {
        TransactionsViewModel$pagedTransactions$1 transactionsViewModel$pagedTransactions$1 = new TransactionsViewModel$pagedTransactions$1(this.this$0, continuation);
        transactionsViewModel$pagedTransactions$1.L$0 = filterChipState;
        transactionsViewModel$pagedTransactions$1.L$1 = durationFilter;
        return transactionsViewModel$pagedTransactions$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FilterChipState filterChipState, DurationFilter durationFilter, Continuation<? super Flow<? extends PagingData<Transaction>>> continuation) {
        return invoke2(filterChipState, durationFilter, (Continuation<? super Flow<PagingData<Transaction>>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayListListOf;
        FilterChipState filterChipState = (FilterChipState) this.L$0;
        DurationFilter durationFilter = (DurationFilter) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Pair durationRange = this.this$0.getDurationRange(durationFilter);
            Long l = (Long) durationRange.component1();
            Long l2 = (Long) durationRange.component2();
            if (!(filterChipState instanceof FilterChipState.Failed)) {
                if (filterChipState instanceof FilterChipState.Successful) {
                    arrayListListOf = CollectionsKt.listOf(TransactionStatus.SUCCESS);
                } else if (filterChipState instanceof FilterChipState.AwaitingCommission) {
                    arrayListListOf = CollectionsKt.listOf(TransactionStatus.PENDING_AWAITING_COMMISSION);
                } else if (filterChipState instanceof FilterChipState.Unmatched) {
                    arrayListListOf = CollectionsKt.listOf(TransactionStatus.UNMATCHED);
                } else if (filterChipState instanceof FilterChipState.Scheduled) {
                    arrayListListOf = CollectionsKt.listOf(TransactionStatus.RESCHEDULED);
                } else if (filterChipState instanceof FilterChipState.Pending) {
                    arrayListListOf = CollectionsKt.listOf(TransactionStatus.SCHEDULED);
                } else {
                    arrayListListOf = filterChipState instanceof FilterChipState.EngageBot ? CollectionsKt.listOf(TransactionStatus.ENGAGE_BOT_ACTIVE) : CollectionsKt.emptyList();
                }
            } else {
                EnumEntries<TransactionStatus> entries = TransactionStatus.getEntries();
                ArrayList arrayList = new ArrayList();
                for (TransactionStatus transactionStatus : entries) {
                    if (TransactionStatusKt.isFailed(transactionStatus)) {
                        arrayList.add(transactionStatus);
                    }
                }
                arrayListListOf = arrayList;
            }
            TransactionType transactionType = filterChipState instanceof FilterChipState.SiteLink ? TransactionType.SITE_LINK : null;
            if (filterChipState instanceof FilterChipState.Pending) {
                final Flow<PagingData<Transaction>> pagedTransactions = this.this$0.transactionRepository.getPagedTransactions(arrayListListOf, transactionType, l, l2);
                final TransactionsViewModel transactionsViewModel = this.this$0;
                return new Flow<PagingData<Transaction>>() { // from class: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$pagedTransactions$1$invokeSuspend$$inlined$map$1
                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super PagingData<Transaction>> flowCollector, Continuation continuation) {
                        Object objCollect = pagedTransactions.collect(new AnonymousClass2(flowCollector, transactionsViewModel), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$pagedTransactions$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                        final /* synthetic */ TransactionsViewModel this$0;

                        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$pagedTransactions$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$pagedTransactions$1$invokeSuspend$$inlined$map$1$2", f = "TransactionsViewModel.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
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

                        public AnonymousClass2(FlowCollector flowCollector, TransactionsViewModel transactionsViewModel) {
                            this.$this_unsafeFlow = flowCollector;
                            this.this$0 = transactionsViewModel;
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
                                PagingData pagingDataFilter = PagingDataTransforms__PagingDataTransformsKt.filter((PagingData) obj, new TransactionsViewModel$pagedTransactions$1$1$1(this.this$0, null));
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(pagingDataFilter, anonymousClass1) == coroutine_suspended) {
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
                };
            }
            return this.this$0.transactionRepository.getPagedTransactions(arrayListListOf, transactionType, l, l2);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
