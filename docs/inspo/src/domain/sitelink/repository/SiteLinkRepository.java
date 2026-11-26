package com.example.bingwahybrid.domain.sitelink.repository;

import androidx.autofill.HintConstants;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.sitelink.enums.SiteLinkAccountType;
import com.example.bingwahybrid.domain.sitelink.model.SiteLink;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: SiteLinkRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004H¦@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H¦@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H¦@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H¦@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u001eJ \u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006%À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/sitelink/repository/SiteLinkRepository;", "", "siteLink", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/bingwahybrid/domain/sitelink/model/SiteLink;", "getSiteLink", "()Lkotlinx/coroutines/flow/StateFlow;", "createSiteLink", "", "siteName", "", "accountNumber", "accountType", "Lcom/example/bingwahybrid/domain/sitelink/enums/SiteLinkAccountType;", HintConstants.AUTOFILL_HINT_USERNAME, "(Ljava/lang/String;Ljava/lang/String;Lcom/example/bingwahybrid/domain/sitelink/enums/SiteLinkAccountType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMySiteLink", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activateSiteLink", "(Lcom/example/bingwahybrid/domain/sitelink/model/SiteLink;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deactivateSiteLink", "updateSiteLink", "updateSiteLinkOffer", "offer", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "(Lcom/example/bingwahybrid/domain/offers/model/Offer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addSiteLinkOffer", "deleteSiteLinkOffer", "checkUsernameAvailability", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProcessingDevice", "offerId", "Ljava/util/UUID;", "deviceId", "(Ljava/util/UUID;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSiteLink", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SiteLinkRepository {
    Object activateSiteLink(SiteLink siteLink, Continuation<? super Unit> continuation);

    Object addSiteLinkOffer(Offer offer, Continuation<? super Unit> continuation);

    Object checkUsernameAvailability(String str, Continuation<? super Boolean> continuation);

    Object createSiteLink(String str, String str2, SiteLinkAccountType siteLinkAccountType, String str3, Continuation<? super Unit> continuation);

    Object deactivateSiteLink(SiteLink siteLink, Continuation<? super Unit> continuation);

    Object deleteSiteLink(SiteLink siteLink, Continuation<? super Unit> continuation);

    Object deleteSiteLinkOffer(Offer offer, Continuation<? super Unit> continuation);

    Object getMySiteLink(Continuation<? super SiteLink> continuation);

    StateFlow<SiteLink> getSiteLink();

    Object updateProcessingDevice(UUID uuid, String str, Continuation<? super Unit> continuation);

    Object updateSiteLink(SiteLink siteLink, Continuation<? super Unit> continuation);

    Object updateSiteLinkOffer(Offer offer, Continuation<? super Unit> continuation);
}
