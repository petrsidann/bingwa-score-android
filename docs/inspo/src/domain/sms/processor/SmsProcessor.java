package com.example.bingwahybrid.domain.sms.processor;

import com.example.bingwahybrid.domain.sms.handler.PrioritizedSmsHandler;
import com.example.bingwahybrid.domain.sms.model.SmsContext;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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

/* JADX INFO: compiled from: SmsProcessor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001c\b\u0007\u0012\u0011\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010R\u0019\u0010\b\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/processor/SmsProcessor;", "", "handlers", "", "Lcom/example/bingwahybrid/domain/sms/handler/PrioritizedSmsHandler;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "(Ljava/util/Set;)V", "orderedHandlers", "", "processMessage", "", "message", "", "sender", "simSlot", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SmsProcessor {
    public static final int $stable = 8;
    private final List<PrioritizedSmsHandler> orderedHandlers;

    @Inject
    public SmsProcessor(Set<PrioritizedSmsHandler> handlers) {
        Intrinsics.checkNotNullParameter(handlers, "handlers");
        this.orderedHandlers = CollectionsKt.sortedWith(handlers, new Comparator() { // from class: com.example.bingwahybrid.domain.sms.processor.SmsProcessor$special$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((PrioritizedSmsHandler) t2).getPriority()), Integer.valueOf(((PrioritizedSmsHandler) t).getPriority()));
            }
        });
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.sms.processor.SmsProcessor$processMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: SmsProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.sms.processor.SmsProcessor$processMessage$1", f = "SmsProcessor.kt", i = {0, 0, 0, 0, 0, 0, 1}, l = {28, 29}, m = "invokeSuspend", n = {"context", "$this$firstOrNull$iv", "element$iv", "it", "$i$f$firstOrNull", "$i$a$-firstOrNull-SmsProcessor$processMessage$1$1", "context"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $message;
        final /* synthetic */ String $sender;
        final /* synthetic */ int $simSlot;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ SmsProcessor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, int i, SmsProcessor smsProcessor, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$message = str;
            this.$sender = str2;
            this.$simSlot = i;
            this.this$0 = smsProcessor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$message, this.$sender, this.$simSlot, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0080, code lost:
        
            if (r12 == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0089, code lost:
        
            if (((java.lang.Boolean) r12).booleanValue() != false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a8, code lost:
        
            if (r6.handle(r9, r11) == r0) goto L24;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0080 -> B:16:0x0083). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            SmsContext smsContext;
            Iterable iterable;
            int i;
            Iterator it;
            Object next;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                SmsContext smsContext2 = new SmsContext(this.$message, this.$sender, this.$simSlot);
                List list = this.this$0.orderedHandlers;
                Iterator it2 = list.iterator();
                smsContext = smsContext2;
                iterable = list;
                i = 0;
                it = it2;
                if (it.hasNext()) {
                    next = it.next();
                    PrioritizedSmsHandler prioritizedSmsHandler = (PrioritizedSmsHandler) next;
                    this.L$0 = smsContext;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$2 = it;
                    this.L$3 = next;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(prioritizedSmsHandler);
                    this.I$0 = i;
                    this.I$1 = 0;
                    this.label = 1;
                    obj = prioritizedSmsHandler.canHandle(smsContext, this);
                } else {
                    next = null;
                    PrioritizedSmsHandler prioritizedSmsHandler2 = (PrioritizedSmsHandler) next;
                    if (prioritizedSmsHandler2 != null) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(smsContext);
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.label = 2;
                    }
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                i = this.I$0;
                next = this.L$3;
                it = (Iterator) this.L$2;
                iterable = (Iterable) this.L$1;
                smsContext = (SmsContext) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void processMessage(String message, String sender, int simSlot) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(sender, "sender");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(message, sender, simSlot, this, null), 3, null);
    }
}
