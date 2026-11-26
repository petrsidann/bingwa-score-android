package com.example.bingwahybrid.domain.sitelink.usecase;

import com.example.bingwahybrid.domain.sitelink.model.SiteLink;
import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetSiteLinkUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086B¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/example/bingwahybrid/domain/sitelink/usecase/GetSiteLinkUseCase;", "", "siteLinkRepository", "Lcom/example/bingwahybrid/domain/sitelink/repository/SiteLinkRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/sitelink/repository/SiteLinkRepository;)V", "invoke", "Lcom/example/bingwahybrid/domain/sitelink/model/SiteLink;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetSiteLinkUseCase {
    public static final int $stable = 8;
    private final SiteLinkRepository siteLinkRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.sitelink.usecase.GetSiteLinkUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetSiteLinkUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.sitelink.usecase.GetSiteLinkUseCase", f = "GetSiteLinkUseCase.kt", i = {}, l = {11}, m = "invoke", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetSiteLinkUseCase.this.invoke(this);
        }
    }

    @Inject
    public GetSiteLinkUseCase(SiteLinkRepository siteLinkRepository) {
        Intrinsics.checkNotNullParameter(siteLinkRepository, "siteLinkRepository");
        this.siteLinkRepository = siteLinkRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object invoke(Continuation<? super SiteLink> continuation) {
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
        Object mySiteLink = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(mySiteLink);
            SiteLinkRepository siteLinkRepository = this.siteLinkRepository;
            anonymousClass1.label = 1;
            mySiteLink = siteLinkRepository.getMySiteLink(anonymousClass1);
            if (mySiteLink == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(mySiteLink);
        }
        return (SiteLink) mySiteLink;
    }
}
