package com.example.bingwahybrid.presentation.sitelink.viewmodel;

import android.util.Log;
import androidx.compose.material.MenuKt;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: AddSiteLinkOfferViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010#\u001a\u00020\u000eH\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010#\u001a\u00020\u000eJ\u0018\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R \u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00190\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011¨\u0006+"}, d2 = {"Lcom/example/bingwahybrid/presentation/sitelink/viewmodel/AddSiteLinkOfferViewModel;", "Landroidx/lifecycle/ViewModel;", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;)V", "_onlineOffers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "onlineOffers", "Lkotlinx/coroutines/flow/StateFlow;", "allOffers", "_selectedOfferType", "Lcom/example/bingwahybrid/domain/offers/enums/OfferType;", "selectedOfferType", "getSelectedOfferType", "()Lkotlinx/coroutines/flow/StateFlow;", "filteredOffers", "getFilteredOffers", "_loadingStates", "", "Ljava/util/UUID;", "", "loadingStates", "", "getLoadingStates", "_isLoadingOffers", "isLoadingOffers", "_errorMessage", "", "errorMessage", "getErrorMessage", "filterOffers", "offers", "offerType", "onOfferTypeSelected", "", "fetchOnlineOffers", "isInitial", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addOfferToSiteLink", "offer", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AddSiteLinkOfferViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _errorMessage;
    private final MutableStateFlow<Boolean> _isLoadingOffers;
    private final MutableStateFlow<Map<UUID, Boolean>> _loadingStates;
    private final MutableStateFlow<List<Offer>> _onlineOffers;
    private final MutableStateFlow<OfferType> _selectedOfferType;
    private final StateFlow<List<Offer>> allOffers;
    private final StateFlow<String> errorMessage;
    private final StateFlow<List<Offer>> filteredOffers;
    private final StateFlow<Boolean> isLoadingOffers;
    private final StateFlow<Map<UUID, Boolean>> loadingStates;
    private final OfferRepository offerRepository;
    private final StateFlow<List<Offer>> onlineOffers;
    private final StateFlow<OfferType> selectedOfferType;

    /* JADX INFO: compiled from: AddSiteLinkOfferViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfferType.values().length];
            try {
                iArr[OfferType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OfferType.DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OfferType.VOICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OfferType.SMS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.AddSiteLinkOfferViewModel$fetchOnlineOffers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AddSiteLinkOfferViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.AddSiteLinkOfferViewModel", f = "AddSiteLinkOfferViewModel.kt", i = {0}, l = {MenuKt.OutTransitionDuration}, m = "fetchOnlineOffers", n = {"isInitial"}, s = {"Z$0"})
    static final class C07311 extends ContinuationImpl {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C07311(Continuation<? super C07311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AddSiteLinkOfferViewModel.this.fetchOnlineOffers(false, this);
        }
    }

    @Inject
    public AddSiteLinkOfferViewModel(OfferRepository offerRepository) {
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        this.offerRepository = offerRepository;
        MutableStateFlow<List<Offer>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._onlineOffers = MutableStateFlow;
        StateFlow<List<Offer>> stateFlowAsStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.onlineOffers = stateFlowAsStateFlow;
        AddSiteLinkOfferViewModel addSiteLinkOfferViewModel = this;
        StateFlow<List<Offer>> stateFlowStateIn = FlowKt.stateIn(offerRepository.getOffers(), ViewModelKt.getViewModelScope(addSiteLinkOfferViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), CollectionsKt.emptyList());
        this.allOffers = stateFlowStateIn;
        MutableStateFlow<OfferType> MutableStateFlow2 = StateFlowKt.MutableStateFlow(OfferType.NONE);
        this._selectedOfferType = MutableStateFlow2;
        StateFlow<OfferType> stateFlowAsStateFlow2 = FlowKt.asStateFlow(MutableStateFlow2);
        this.selectedOfferType = stateFlowAsStateFlow2;
        this.filteredOffers = FlowKt.stateIn(FlowKt.combine(stateFlowStateIn, stateFlowAsStateFlow, stateFlowAsStateFlow2, new AddSiteLinkOfferViewModel$filteredOffers$1(this, null)), ViewModelKt.getViewModelScope(addSiteLinkOfferViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), CollectionsKt.emptyList());
        MutableStateFlow<Map<UUID, Boolean>> MutableStateFlow3 = StateFlowKt.MutableStateFlow(new LinkedHashMap());
        this._loadingStates = MutableStateFlow3;
        this.loadingStates = MutableStateFlow3;
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(false);
        this._isLoadingOffers = MutableStateFlow4;
        this.isLoadingOffers = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<String> MutableStateFlow5 = StateFlowKt.MutableStateFlow(null);
        this._errorMessage = MutableStateFlow5;
        this.errorMessage = FlowKt.asStateFlow(MutableStateFlow5);
    }

    public final StateFlow<OfferType> getSelectedOfferType() {
        return this.selectedOfferType;
    }

    public final StateFlow<List<Offer>> getFilteredOffers() {
        return this.filteredOffers;
    }

    public final StateFlow<Map<UUID, Boolean>> getLoadingStates() {
        return this.loadingStates;
    }

    public final StateFlow<Boolean> isLoadingOffers() {
        return this.isLoadingOffers;
    }

    public final StateFlow<String> getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Offer> filterOffers(List<Offer> offers, OfferType offerType) {
        int i = WhenMappings.$EnumSwitchMapping$0[offerType.ordinal()];
        if (i == 1) {
            return offers;
        }
        if (i == 2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : offers) {
                if (((Offer) obj).getType() == OfferType.DATA) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        if (i == 3) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : offers) {
                if (((Offer) obj2).getType() == OfferType.VOICE) {
                    arrayList2.add(obj2);
                }
            }
            return arrayList2;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : offers) {
            if (((Offer) obj3).getType() == OfferType.SMS) {
                arrayList3.add(obj3);
            }
        }
        return arrayList3;
    }

    public final void onOfferTypeSelected(OfferType offerType) {
        Intrinsics.checkNotNullParameter(offerType, "offerType");
        this._selectedOfferType.setValue(offerType);
    }

    public static /* synthetic */ Object fetchOnlineOffers$default(AddSiteLinkOfferViewModel addSiteLinkOfferViewModel, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return addSiteLinkOfferViewModel.fetchOnlineOffers(z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchOnlineOffers(boolean z, Continuation<? super Unit> continuation) {
        C07311 c07311;
        if (continuation instanceof C07311) {
            c07311 = (C07311) continuation;
            if ((c07311.label & Integer.MIN_VALUE) != 0) {
                c07311.label -= Integer.MIN_VALUE;
            } else {
                c07311 = new C07311(continuation);
            }
        } else {
            c07311 = new C07311(continuation);
        }
        Object remoteOffers = c07311.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07311.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(remoteOffers);
                this._isLoadingOffers.setValue(Boxing.boxBoolean(z));
                OfferRepository offerRepository = this.offerRepository;
                c07311.Z$0 = z;
                c07311.label = 1;
                remoteOffers = offerRepository.getRemoteOffers("sitelink", c07311);
                if (remoteOffers == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z2 = c07311.Z$0;
                ResultKt.throwOnFailure(remoteOffers);
            }
            this._onlineOffers.setValue((List) remoteOffers);
        } catch (Exception e) {
            this._errorMessage.setValue(e.getMessage());
        } finally {
            this._isLoadingOffers.setValue(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.AddSiteLinkOfferViewModel$addOfferToSiteLink$1, reason: invalid class name */
    /* JADX INFO: compiled from: AddSiteLinkOfferViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.AddSiteLinkOfferViewModel$addOfferToSiteLink$1", f = "AddSiteLinkOfferViewModel.kt", i = {}, l = {91, 92, 93}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Offer $offer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Offer offer, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$offer = offer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AddSiteLinkOfferViewModel.this.new AnonymousClass1(this.$offer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0092, code lost:
        
            if (com.example.bingwahybrid.presentation.sitelink.viewmodel.AddSiteLinkOfferViewModel.fetchOnlineOffers$default(r9.this$0, false, r9, 1, null) == r1) goto L27;
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
                    MutableStateFlow mutableStateFlow = AddSiteLinkOfferViewModel.this._loadingStates;
                    Map mutableMap = MapsKt.toMutableMap((Map) AddSiteLinkOfferViewModel.this._loadingStates.getValue());
                    mutableMap.put(this.$offer.getId(), Boxing.boxBoolean(true));
                    mutableStateFlow.setValue(mutableMap);
                    this.label = 1;
                    if (AddSiteLinkOfferViewModel.this.offerRepository.addOfferRemote(this.$offer, this) == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 3;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
                this.label = 2;
                if (AddSiteLinkOfferViewModel.this.offerRepository.addChannelToOffer(this.$offer.getId(), "sitelink", this) != coroutine_suspended) {
                    this.label = 3;
                }
                return coroutine_suspended;
            } catch (Exception e) {
                AddSiteLinkOfferViewModel.this._errorMessage.setValue(e.getMessage());
                Log.e("AddSiteLinkOfferVM", "Error adding offer: " + e.getMessage(), e);
            } finally {
                MutableStateFlow mutableStateFlow2 = AddSiteLinkOfferViewModel.this._loadingStates;
                Map mutableMap2 = MapsKt.toMutableMap((Map) AddSiteLinkOfferViewModel.this._loadingStates.getValue());
                mutableMap2.put(this.$offer.getId(), Boxing.boxBoolean(false));
                mutableStateFlow2.setValue(mutableMap2);
            }
        }
    }

    public final void addOfferToSiteLink(Offer offer) {
        Intrinsics.checkNotNullParameter(offer, "offer");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(offer, null), 2, null);
    }
}
