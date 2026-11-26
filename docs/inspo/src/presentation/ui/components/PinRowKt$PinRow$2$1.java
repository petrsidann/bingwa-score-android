package com.example.bingwahybrid.presentation.ui.components;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PinRow.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.PinRowKt$PinRow$2$1", f = "PinRow.kt", i = {0}, l = {44}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
final class PinRowKt$PinRow$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $animatedPin$delegate;
    final /* synthetic */ boolean $isLoading;
    final /* synthetic */ String $pin;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PinRowKt$PinRow$2$1(boolean z, String str, MutableState<String> mutableState, Continuation<? super PinRowKt$PinRow$2$1> continuation) {
        super(2, continuation);
        this.$isLoading = z;
        this.$pin = str;
        this.$animatedPin$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PinRowKt$PinRow$2$1(this.$isLoading, this.$pin, this.$animatedPin$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PinRowKt$PinRow$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    /* JADX WARN: Code duplicated, block: B:14:0x0025  */
    /* JADX WARN: Code duplicated, block: B:16:0x003f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0020 -> B:12:0x0022). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003d -> B:17:0x0040). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 != r2) goto L11
            int r1 = r5.I$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L40
        L11:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L19:
            kotlin.ResultKt.throwOnFailure(r6)
        L1c:
            boolean r6 = r5.$isLoading
            if (r6 == 0) goto L4a
            r6 = 0
            r1 = r6
        L22:
            r6 = 5
            if (r1 >= r6) goto L42
            androidx.compose.runtime.MutableState<java.lang.String> r6 = r5.$animatedPin$delegate
            java.lang.String r3 = r5.$pin
            java.lang.String r3 = kotlin.text.StringsKt.take(r3, r1)
            com.example.bingwahybrid.presentation.ui.components.PinRowKt.access$PinRow$lambda$2(r6, r3)
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.I$0 = r1
            r5.label = r2
            r3 = 100
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L40
            return r0
        L40:
            int r1 = r1 + r2
            goto L22
        L42:
            androidx.compose.runtime.MutableState<java.lang.String> r6 = r5.$animatedPin$delegate
            java.lang.String r1 = ""
            com.example.bingwahybrid.presentation.ui.components.PinRowKt.access$PinRow$lambda$2(r6, r1)
            goto L1c
        L4a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.presentation.ui.components.PinRowKt$PinRow$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
