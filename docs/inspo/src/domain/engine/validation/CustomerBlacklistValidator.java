package com.example.bingwahybrid.domain.engine.validation;

import com.example.bingwahybrid.domain.engine.validation.enums.ValidationResult;
import com.example.bingwahybrid.domain.enums.AutoReplyType;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.messaging.usecase.SendAutoReplyMessageUseCase;
import com.example.bingwahybrid.domain.model.Transaction;
import io.ktor.sse.ServerSentEventKt;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CustomerBlacklistValidator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/validation/CustomerBlacklistValidator;", "Lcom/example/bingwahybrid/domain/engine/validation/TransactionValidator;", "sendAutoReplyMessageUseCase", "Lcom/example/bingwahybrid/domain/messaging/usecase/SendAutoReplyMessageUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/messaging/usecase/SendAutoReplyMessageUseCase;)V", "excludedTypes", "", "Lcom/example/bingwahybrid/domain/enums/TransactionType;", "validate", "Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult;", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomerBlacklistValidator implements TransactionValidator {
    public static final int $stable = 8;
    private final Set<TransactionType> excludedTypes;
    private final SendAutoReplyMessageUseCase sendAutoReplyMessageUseCase;

    @Inject
    public CustomerBlacklistValidator(SendAutoReplyMessageUseCase sendAutoReplyMessageUseCase) {
        Intrinsics.checkNotNullParameter(sendAutoReplyMessageUseCase, "sendAutoReplyMessageUseCase");
        this.sendAutoReplyMessageUseCase = sendAutoReplyMessageUseCase;
        this.excludedTypes = SetsKt.setOf((Object[]) new TransactionType[]{TransactionType.SUBSCRIPTION_RENEWAL, TransactionType.AIRTIME_BALANCE_CHECK});
    }

    @Override // com.example.bingwahybrid.domain.engine.validation.TransactionValidator
    public Object validate(Transaction transaction, Continuation<? super ValidationResult> continuation) {
        if (this.excludedTypes.contains(transaction.getType())) {
            return ValidationResult.Success.INSTANCE;
        }
        if (transaction.getCustomer().isBlackListed()) {
            String str = (String) CollectionsKt.firstOrNull(StringsKt.split$default((CharSequence) transaction.getCustomer().getName(), new String[]{ServerSentEventKt.SPACE}, false, 0, 6, (Object) null));
            if (str == null) {
                str = "Customer";
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass2(transaction, null), 3, null);
            return new ValidationResult.Failure(TransactionStatus.BLOCKED, "You have blacklisted " + str + " from receiving offers");
        }
        return ValidationResult.Success.INSTANCE;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.validation.CustomerBlacklistValidator$validate$2, reason: invalid class name */
    /* JADX INFO: compiled from: CustomerBlacklistValidator.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.validation.CustomerBlacklistValidator$validate$2", f = "CustomerBlacklistValidator.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Transaction $transaction;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Transaction transaction, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$transaction = transaction;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CustomerBlacklistValidator.this.new AnonymousClass2(this.$transaction, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CustomerBlacklistValidator.this.sendAutoReplyMessageUseCase.invoke(this.$transaction, AutoReplyType.CUSTOMER_BLOCKED, this) == coroutine_suspended) {
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
}
