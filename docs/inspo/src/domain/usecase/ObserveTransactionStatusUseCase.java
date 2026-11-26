package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.enums.TransactionStatusKt;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: ObserveTransactionStatusUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/ObserveTransactionStatusUseCase;", "", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/TransactionRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "", "", "transactionId", "Ljava/util/UUID;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ObserveTransactionStatusUseCase {
    public static final int $stable = 8;
    private final TransactionRepository transactionRepository;

    @Inject
    public ObserveTransactionStatusUseCase(TransactionRepository transactionRepository) {
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        this.transactionRepository = transactionRepository;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.ObserveTransactionStatusUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: ObserveTransactionStatusUseCase.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.ObserveTransactionStatusUseCase$invoke$1", f = "ObserveTransactionStatusUseCase.kt", i = {0, 0, 0}, l = {20}, m = "invokeSuspend", n = {"$this$flow", "initialStatus", "hasChanged"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends Boolean, ? extends String>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ UUID $transactionId;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UUID uuid, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$transactionId = uuid;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = ObserveTransactionStatusUseCase.this.new AnonymousClass1(this.$transactionId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Pair<? extends Boolean, ? extends String>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Pair<Boolean, String>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Pair<Boolean, String>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            final FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                StateFlow<Map<Long, Transaction>> liveTransactions = ObserveTransactionStatusUseCase.this.transactionRepository.getLiveTransactions();
                final UUID uuid = this.$transactionId;
                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.L$1 = SpillingKt.nullOutSpilledVariable(objectRef);
                this.L$2 = SpillingKt.nullOutSpilledVariable(booleanRef);
                this.label = 1;
                if (liveTransactions.collect(new FlowCollector() { // from class: com.example.bingwahybrid.domain.usecase.ObserveTransactionStatusUseCase.invoke.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Map<Long, Transaction>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Map<Long, Transaction> map, Continuation<? super Unit> continuation) {
                        T next;
                        Collection<Transaction> collectionValues = map.values();
                        UUID uuid2 = uuid;
                        Iterator<T> it = collectionValues.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = (T) null;
                                break;
                            }
                            next = it.next();
                        } while (!Intrinsics.areEqual(((Transaction) next).getId(), uuid2));
                        Transaction transaction = next;
                        if (transaction == null) {
                            return Unit.INSTANCE;
                        }
                        if (objectRef.element == null) {
                            objectRef.element = (T) transaction.getStatus();
                            return Unit.INSTANCE;
                        }
                        boolean z = true;
                        if (transaction.getStatus() != objectRef.element) {
                            booleanRef.element = true;
                        }
                        if (booleanRef.element && TransactionStatusKt.isTerminal(transaction.getStatus())) {
                            FlowCollector<Pair<Boolean, String>> flowCollector2 = flowCollector;
                            if (transaction.getStatus() != TransactionStatus.SUCCESS && transaction.getStatus() != TransactionStatus.PENDING_AWAITING_COMMISSION) {
                                z = false;
                            }
                            Object objEmit = flowCollector2.emit(new Pair<>(Boxing.boxBoolean(z), transaction.getResponseMessage()), continuation);
                            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
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
            throw new KotlinNothingValueException();
        }
    }

    public final Flow<Pair<Boolean, String>> invoke(UUID transactionId) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        return FlowKt.flow(new AnonymousClass1(transactionId, null));
    }
}
