package com.example.bingwahybrid.domain.sitelink.usecase;

import androidx.autofill.HintConstants;
import com.example.bingwahybrid.domain.sitelink.enums.SiteLinkAccountType;
import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RequestSiteLinkUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/example/bingwahybrid/domain/sitelink/usecase/RequestSiteLinkUseCase;", "", "siteLinkRepository", "Lcom/example/bingwahybrid/domain/sitelink/repository/SiteLinkRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/sitelink/repository/SiteLinkRepository;)V", "invoke", "", "siteName", "", "accountNumber", "accountType", "Lcom/example/bingwahybrid/domain/sitelink/enums/SiteLinkAccountType;", HintConstants.AUTOFILL_HINT_USERNAME, "(Ljava/lang/String;Ljava/lang/String;Lcom/example/bingwahybrid/domain/sitelink/enums/SiteLinkAccountType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RequestSiteLinkUseCase {
    public static final int $stable = 8;
    private final SiteLinkRepository siteLinkRepository;

    @Inject
    public RequestSiteLinkUseCase(SiteLinkRepository siteLinkRepository) {
        Intrinsics.checkNotNullParameter(siteLinkRepository, "siteLinkRepository");
        this.siteLinkRepository = siteLinkRepository;
    }

    public final Object invoke(String str, String str2, SiteLinkAccountType siteLinkAccountType, String str3, Continuation<? super Unit> continuation) {
        Object objCreateSiteLink = this.siteLinkRepository.createSiteLink(str, str2, siteLinkAccountType, str3, continuation);
        return objCreateSiteLink == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCreateSiteLink : Unit.INSTANCE;
    }
}
