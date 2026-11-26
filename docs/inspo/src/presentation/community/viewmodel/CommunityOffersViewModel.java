package com.example.bingwahybrid.presentation.community.viewmodel;

import androidx.core.location.LocationRequestCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.enums.LoadingState;
import com.example.bingwahybrid.domain.features.repository.FeatureRepository;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.model.OfferVerificationInfo;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.offers.usecase.CreateVerifiedOfferUseCase;
import com.example.bingwahybrid.domain.offers.usecase.DeleteOfferUseCase;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: CommunityOffersViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010)\u001a\u00020*J\u0016\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020&J\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020*J\u001e\u00100\u001a\u00020*2\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020&H\u0082@¢\u0006\u0002\u00101J\u0006\u00102\u001a\u00020*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\"\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010'\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$0\u0012¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0014¨\u00063"}, d2 = {"Lcom/example/bingwahybrid/presentation/community/viewmodel/CommunityOffersViewModel;", "Landroidx/lifecycle/ViewModel;", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "createVerifiedOfferUseCase", "Lcom/example/bingwahybrid/domain/offers/usecase/CreateVerifiedOfferUseCase;", "deleteOfferUseCase", "Lcom/example/bingwahybrid/domain/offers/usecase/DeleteOfferUseCase;", "featureRepository", "Lcom/example/bingwahybrid/domain/features/repository/FeatureRepository;", "subscriptionRepository", "Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;Lcom/example/bingwahybrid/domain/offers/usecase/CreateVerifiedOfferUseCase;Lcom/example/bingwahybrid/domain/offers/usecase/DeleteOfferUseCase;Lcom/example/bingwahybrid/domain/features/repository/FeatureRepository;Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;)V", "_loadingState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bingwahybrid/domain/enums/LoadingState;", "loadingState", "Lkotlinx/coroutines/flow/StateFlow;", "getLoadingState", "()Lkotlinx/coroutines/flow/StateFlow;", "_hakikishaOffers", "", "Lcom/example/bingwahybrid/presentation/community/viewmodel/HakikishaOfferWithStatus;", "hakikishaOffers", "getHakikishaOffers", "_downloadingOfferIds", "", "Ljava/util/UUID;", "downloadingOfferIds", "getDownloadingOfferIds", "_snackBarMessage", "", "snackBarMessage", "getSnackBarMessage", "_showOverwriteDialog", "Lkotlin/Pair;", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "Lcom/example/bingwahybrid/domain/offers/model/OfferVerificationInfo;", "showOverwriteDialog", "getShowOverwriteDialog", "loadHakikishaOffers", "", "downloadOffer", "offer", "verificationInfo", "confirmOverwrite", "cancelOverwrite", "proceedWithDownload", "(Lcom/example/bingwahybrid/domain/offers/model/Offer;Lcom/example/bingwahybrid/domain/offers/model/OfferVerificationInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetSnackBarMessage", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommunityOffersViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Set<UUID>> _downloadingOfferIds;
    private final MutableStateFlow<List<HakikishaOfferWithStatus>> _hakikishaOffers;
    private final MutableStateFlow<LoadingState> _loadingState;
    private final MutableStateFlow<Pair<Offer, OfferVerificationInfo>> _showOverwriteDialog;
    private final MutableStateFlow<String> _snackBarMessage;
    private final CreateVerifiedOfferUseCase createVerifiedOfferUseCase;
    private final DeleteOfferUseCase deleteOfferUseCase;
    private final StateFlow<Set<UUID>> downloadingOfferIds;
    private final FeatureRepository featureRepository;
    private final StateFlow<List<HakikishaOfferWithStatus>> hakikishaOffers;
    private final StateFlow<LoadingState> loadingState;
    private final OfferRepository offerRepository;
    private final StateFlow<Pair<Offer, OfferVerificationInfo>> showOverwriteDialog;
    private final StateFlow<String> snackBarMessage;
    private final SubscriptionRepository subscriptionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.community.viewmodel.CommunityOffersViewModel$proceedWithDownload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommunityOffersViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.community.viewmodel.CommunityOffersViewModel", f = "CommunityOffersViewModel.kt", i = {0, 0}, l = {133}, m = "proceedWithDownload", n = {"offer", "verificationInfo"}, s = {"L$0", "L$1"})
    static final class C07171 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C07171(Continuation<? super C07171> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommunityOffersViewModel.this.proceedWithDownload(null, null, this);
        }
    }

    @Inject
    public CommunityOffersViewModel(OfferRepository offerRepository, CreateVerifiedOfferUseCase createVerifiedOfferUseCase, DeleteOfferUseCase deleteOfferUseCase, FeatureRepository featureRepository, SubscriptionRepository subscriptionRepository) {
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        Intrinsics.checkNotNullParameter(createVerifiedOfferUseCase, "createVerifiedOfferUseCase");
        Intrinsics.checkNotNullParameter(deleteOfferUseCase, "deleteOfferUseCase");
        Intrinsics.checkNotNullParameter(featureRepository, "featureRepository");
        Intrinsics.checkNotNullParameter(subscriptionRepository, "subscriptionRepository");
        this.offerRepository = offerRepository;
        this.createVerifiedOfferUseCase = createVerifiedOfferUseCase;
        this.deleteOfferUseCase = deleteOfferUseCase;
        this.featureRepository = featureRepository;
        this.subscriptionRepository = subscriptionRepository;
        MutableStateFlow<LoadingState> MutableStateFlow = StateFlowKt.MutableStateFlow(LoadingState.Idle.INSTANCE);
        this._loadingState = MutableStateFlow;
        this.loadingState = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<List<HakikishaOfferWithStatus>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._hakikishaOffers = MutableStateFlow2;
        this.hakikishaOffers = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<Set<UUID>> MutableStateFlow3 = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this._downloadingOfferIds = MutableStateFlow3;
        this.downloadingOfferIds = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<String> MutableStateFlow4 = StateFlowKt.MutableStateFlow(null);
        this._snackBarMessage = MutableStateFlow4;
        this.snackBarMessage = MutableStateFlow4;
        MutableStateFlow<Pair<Offer, OfferVerificationInfo>> MutableStateFlow5 = StateFlowKt.MutableStateFlow(null);
        this._showOverwriteDialog = MutableStateFlow5;
        this.showOverwriteDialog = FlowKt.asStateFlow(MutableStateFlow5);
        loadHakikishaOffers();
    }

    public final StateFlow<LoadingState> getLoadingState() {
        return this.loadingState;
    }

    public final StateFlow<List<HakikishaOfferWithStatus>> getHakikishaOffers() {
        return this.hakikishaOffers;
    }

    public final StateFlow<Set<UUID>> getDownloadingOfferIds() {
        return this.downloadingOfferIds;
    }

    public final StateFlow<String> getSnackBarMessage() {
        return this.snackBarMessage;
    }

    public final StateFlow<Pair<Offer, OfferVerificationInfo>> getShowOverwriteDialog() {
        return this.showOverwriteDialog;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.community.viewmodel.CommunityOffersViewModel$loadHakikishaOffers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommunityOffersViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.community.viewmodel.CommunityOffersViewModel$loadHakikishaOffers$1", f = "CommunityOffersViewModel.kt", i = {1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {63, 64, 66, 72}, m = "invokeSuspend", n = {"features", "features", "features", "verifiedOffers", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "offer", "verificationInfo", "feature", "$i$f$map", "$i$f$mapTo", "$i$a$-map-CommunityOffersViewModel$loadHakikishaOffers$1$offersWithStatus$1", "requiresPurchase"}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "I$3"})
    static final class C07161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        C07161(Continuation<? super C07161> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CommunityOffersViewModel.this.new C07161(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x00f4 A[Catch: Exception -> 0x0076, TryCatch #0 {Exception -> 0x0076, blocks: (B:9:0x0048, B:44:0x0175, B:50:0x018c, B:54:0x0193, B:33:0x00ee, B:35:0x00f4, B:37:0x0115, B:40:0x011d, B:55:0x01a1, B:14:0x0062, B:32:0x00ce, B:17:0x006c, B:29:0x00b5, B:18:0x0070, B:26:0x009a, B:23:0x007c), top: B:63:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:37:0x0115 A[Catch: Exception -> 0x0076, TryCatch #0 {Exception -> 0x0076, blocks: (B:9:0x0048, B:44:0x0175, B:50:0x018c, B:54:0x0193, B:33:0x00ee, B:35:0x00f4, B:37:0x0115, B:40:0x011d, B:55:0x01a1, B:14:0x0062, B:32:0x00ce, B:17:0x006c, B:29:0x00b5, B:18:0x0070, B:26:0x009a, B:23:0x007c), top: B:63:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:38:0x011a  */
        /* JADX WARN: Code duplicated, block: B:40:0x011d A[Catch: Exception -> 0x0076, TryCatch #0 {Exception -> 0x0076, blocks: (B:9:0x0048, B:44:0x0175, B:50:0x018c, B:54:0x0193, B:33:0x00ee, B:35:0x00f4, B:37:0x0115, B:40:0x011d, B:55:0x01a1, B:14:0x0062, B:32:0x00ce, B:17:0x006c, B:29:0x00b5, B:18:0x0070, B:26:0x009a, B:23:0x007c), top: B:63:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:43:0x016e  */
        /* JADX WARN: Code duplicated, block: B:45:0x017c  */
        /* JADX WARN: Code duplicated, block: B:47:0x0187 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:49:0x018b  */
        /* JADX WARN: Code duplicated, block: B:52:0x0190  */
        /* JADX WARN: Code duplicated, block: B:53:0x0192  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v11 */
        /* JADX WARN: Type inference failed for: r12v13 */
        /* JADX WARN: Type inference failed for: r12v14 */
        /* JADX WARN: Type inference failed for: r12v15 */
        /* JADX WARN: Type inference failed for: r12v4 */
        /* JADX WARN: Type inference failed for: r12v8 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x016e -> B:44:0x0175). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x017c -> B:46:0x0185). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instruction units count: 525
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.presentation.community.viewmodel.CommunityOffersViewModel.C07161.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void loadHakikishaOffers() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07161(null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.community.viewmodel.CommunityOffersViewModel$downloadOffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommunityOffersViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.community.viewmodel.CommunityOffersViewModel$downloadOffer$1", f = "CommunityOffersViewModel.kt", i = {1}, l = {99, LocationRequestCompat.QUALITY_LOW_POWER}, m = "invokeSuspend", n = {"existingOffer"}, s = {"L$0"})
    static final class C07151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Offer $offer;
        final /* synthetic */ OfferVerificationInfo $verificationInfo;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07151(Offer offer, OfferVerificationInfo offerVerificationInfo, Continuation<? super C07151> continuation) {
            super(2, continuation);
            this.$offer = offer;
            this.$verificationInfo = offerVerificationInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CommunityOffersViewModel.this.new C07151(this.$offer, this.$verificationInfo, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
        
            if (r6.this$0.proceedWithDownload(r6.$offer, r6.$verificationInfo, r6) == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = CommunityOffersViewModel.this.offerRepository.getOfferByPrice(this.$offer.getPrice(), this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
                Offer offer = (Offer) obj;
                if (offer != null) {
                    CommunityOffersViewModel.this._showOverwriteDialog.setValue(new Pair(this.$offer, this.$verificationInfo));
                    return Unit.INSTANCE;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(offer);
                this.label = 2;
            } catch (Exception e) {
                CommunityOffersViewModel.this._snackBarMessage.setValue("Failed to download offer: " + e.getMessage());
            }
        }
    }

    public final void downloadOffer(Offer offer, OfferVerificationInfo verificationInfo) {
        Intrinsics.checkNotNullParameter(offer, "offer");
        Intrinsics.checkNotNullParameter(verificationInfo, "verificationInfo");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07151(offer, verificationInfo, null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.community.viewmodel.CommunityOffersViewModel$confirmOverwrite$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommunityOffersViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.community.viewmodel.CommunityOffersViewModel$confirmOverwrite$1", f = "CommunityOffersViewModel.kt", i = {1, 1, 1, 2}, l = {115, 116, 117}, m = "invokeSuspend", n = {"existingOffer", "it", "$i$a$-let-CommunityOffersViewModel$confirmOverwrite$1$1", "existingOffer"}, s = {"L$0", "L$1", "I$0", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Offer $newOffer;
        final /* synthetic */ OfferVerificationInfo $verificationInfo;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Offer offer, OfferVerificationInfo offerVerificationInfo, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$newOffer = offer;
            this.$verificationInfo = offerVerificationInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CommunityOffersViewModel.this.new AnonymousClass1(this.$newOffer, this.$verificationInfo, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0078 A[Catch: all -> 0x0035, Exception -> 0x0038, Merged into TryCatch #0 {all -> 0x0035, Exception -> 0x0038, blocks: (B:8:0x0018, B:33:0x009c, B:13:0x002d, B:29:0x0078, B:14:0x0031, B:24:0x0055, B:26:0x005a, B:21:0x003d), top: B:39:0x000c }, PHI: r2
  0x0078: PHI (r2v6 com.example.bingwahybrid.domain.offers.model.Offer) = 
  (r2v5 com.example.bingwahybrid.domain.offers.model.Offer)
  (r2v5 com.example.bingwahybrid.domain.offers.model.Offer)
  (r2v11 com.example.bingwahybrid.domain.offers.model.Offer)
 binds: [B:25:0x0058, B:27:0x0075, B:13:0x002d] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE] */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x008f, code lost:
        
            if (r8.this$0.proceedWithDownload(r8.$newOffer, r8.$verificationInfo, r8) == r1) goto L31;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Offer offer;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = CommunityOffersViewModel.this.offerRepository.getOfferByPrice(this.$newOffer.getPrice(), this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    offer = (Offer) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(offer);
                    this.L$1 = null;
                    this.label = 3;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
                offer = (Offer) obj;
                if (offer != null) {
                    DeleteOfferUseCase deleteOfferUseCase = CommunityOffersViewModel.this.deleteOfferUseCase;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(offer);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(offer);
                    this.I$0 = 0;
                    this.label = 2;
                    if (deleteOfferUseCase.invoke(offer, this) != coroutine_suspended) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(offer);
                        this.L$1 = null;
                        this.label = 3;
                    }
                } else {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(offer);
                    this.L$1 = null;
                    this.label = 3;
                }
                return coroutine_suspended;
            } catch (Exception e) {
                CommunityOffersViewModel.this._snackBarMessage.setValue("Failed to overwrite offer: " + e.getMessage());
            } finally {
                CommunityOffersViewModel.this._showOverwriteDialog.setValue(null);
            }
        }
    }

    public final void confirmOverwrite() {
        Pair<Offer, OfferVerificationInfo> value = this._showOverwriteDialog.getValue();
        if (value == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(value.component1(), value.component2(), null), 3, null);
    }

    public final void cancelOverwrite() {
        this._showOverwriteDialog.setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object proceedWithDownload(Offer offer, OfferVerificationInfo offerVerificationInfo, Continuation<? super Unit> continuation) {
        C07171 c07171;
        if (continuation instanceof C07171) {
            c07171 = (C07171) continuation;
            if ((c07171.label & Integer.MIN_VALUE) != 0) {
                c07171.label -= Integer.MIN_VALUE;
            } else {
                c07171 = new C07171(continuation);
            }
        } else {
            c07171 = new C07171(continuation);
        }
        Object obj = c07171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07171.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow<Set<UUID>> mutableStateFlow = this._downloadingOfferIds;
                mutableStateFlow.setValue(SetsKt.plus(mutableStateFlow.getValue(), offer.getId()));
                CreateVerifiedOfferUseCase createVerifiedOfferUseCase = this.createVerifiedOfferUseCase;
                c07171.L$0 = offer;
                c07171.L$1 = SpillingKt.nullOutSpilledVariable(offerVerificationInfo);
                c07171.label = 1;
                if (createVerifiedOfferUseCase.invoke(offer, offerVerificationInfo, c07171) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                offer = (Offer) c07171.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this._snackBarMessage.setValue("Offer '" + offer.getName() + "' downloaded successfully");
            MutableStateFlow<Set<UUID>> mutableStateFlow2 = this._downloadingOfferIds;
            mutableStateFlow2.setValue(SetsKt.minus(mutableStateFlow2.getValue(), offer.getId()));
        } catch (Exception e) {
            this._snackBarMessage.setValue("Failed to download offer: " + e.getMessage());
            MutableStateFlow<Set<UUID>> mutableStateFlow3 = this._downloadingOfferIds;
            mutableStateFlow3.setValue(SetsKt.minus(mutableStateFlow3.getValue(), offer.getId()));
        }
        return Unit.INSTANCE;
    }

    public final void resetSnackBarMessage() {
        this._snackBarMessage.setValue(null);
    }
}
