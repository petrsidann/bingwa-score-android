package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.sitelink.model.SiteLink;
import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivateSiteLinkUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086B¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/ActivateSiteLinkUseCase;", "", "siteLinkRepository", "Lcom/example/bingwahybrid/domain/sitelink/repository/SiteLinkRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/sitelink/repository/SiteLinkRepository;)V", "invoke", "", "siteLink", "Lcom/example/bingwahybrid/domain/sitelink/model/SiteLink;", "isActive", "", "(Lcom/example/bingwahybrid/domain/sitelink/model/SiteLink;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ActivateSiteLinkUseCase {
    public static final int $stable = 8;
    private final SiteLinkRepository siteLinkRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.ActivateSiteLinkUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActivateSiteLinkUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.ActivateSiteLinkUseCase", f = "ActivateSiteLinkUseCase.kt", i = {0, 0, 1, 1}, l = {13, 15}, m = "invoke", n = {"siteLink", "isActive", "siteLink", "isActive"}, s = {"L$0", "Z$0", "L$0", "Z$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActivateSiteLinkUseCase.this.invoke(null, false, this);
        }
    }

    @Inject
    public ActivateSiteLinkUseCase(SiteLinkRepository siteLinkRepository) {
        Intrinsics.checkNotNullParameter(siteLinkRepository, "siteLinkRepository");
        this.siteLinkRepository = siteLinkRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (r5.activateSiteLink(r6, r0) == r1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
    
        if (r5.deactivateSiteLink(r6, r0) == r1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(SiteLink siteLink, boolean z, Continuation<? super Unit> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (z) {
                SiteLinkRepository siteLinkRepository = this.siteLinkRepository;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(siteLink);
                anonymousClass1.Z$0 = z;
                anonymousClass1.label = 1;
            } else {
                SiteLinkRepository siteLinkRepository2 = this.siteLinkRepository;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(siteLink);
                anonymousClass1.Z$0 = z;
                anonymousClass1.label = 2;
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z2 = anonymousClass1.Z$0;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
