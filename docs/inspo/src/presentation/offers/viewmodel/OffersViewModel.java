package com.example.bingwahybrid.presentation.offers.viewmodel;

import androidx.compose.material.TextFieldImplKt;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.enums.LoadingState;
import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.offers.repository.SharedOffersRepository;
import com.example.bingwahybrid.domain.offers.usecase.DeleteOfferUseCase;
import com.example.bingwahybrid.domain.utils.NavigationManager;
import com.example.bingwahybrid.presentation.offers.dto.OfferDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: OffersViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00102\u001a\u000203H\u0002J$\u00104\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u00106\u001a\u00020'H\u0002J\u000e\u00107\u001a\u0002032\u0006\u00106\u001a\u00020'J\u0006\u00108\u001a\u00020'J\u000e\u00109\u001a\u0002032\u0006\u00106\u001a\u00020'J\u0016\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020<H\u0086@¢\u0006\u0002\u0010=J\u000e\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020#J\u0006\u0010@\u001a\u000203J\u0006\u0010A\u001a\u000203J\u0006\u0010B\u001a\u000203J\u0016\u0010C\u001a\u0002032\u0006\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020\u0019J\u0006\u0010F\u001a\u000203J\u0006\u0010G\u001a\u000203R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010R\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0010R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0010R\u001a\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0010R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00190\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0010R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00190\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0010¨\u0006H"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/viewmodel/OffersViewModel;", "Landroidx/lifecycle/ViewModel;", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "sharedOffersRepository", "Lcom/example/bingwahybrid/domain/offers/repository/SharedOffersRepository;", "deleteOfferUseCase", "Lcom/example/bingwahybrid/domain/offers/usecase/DeleteOfferUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;Lcom/example/bingwahybrid/domain/offers/repository/SharedOffersRepository;Lcom/example/bingwahybrid/domain/offers/usecase/DeleteOfferUseCase;)V", "_offersLoadingState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bingwahybrid/domain/enums/LoadingState;", "offersLoadingState", "Lkotlinx/coroutines/flow/StateFlow;", "getOffersLoadingState", "()Lkotlinx/coroutines/flow/StateFlow;", "allOffers", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "_snackBarMessage", "", "snackBarMessage", "getSnackBarMessage", "_addOfferSuccess", "", "addOfferSuccess", "getAddOfferSuccess", "_editOfferSuccess", "editOfferSuccess", "getEditOfferSuccess", "_selectedOffer", "selectedOffer", "getSelectedOffer", "_offerDetails", "Lcom/example/bingwahybrid/presentation/offers/dto/OfferDetails;", "offerDetails", "getOfferDetails", "_selectedOfferType", "Lcom/example/bingwahybrid/domain/offers/enums/OfferType;", "selectedOfferType", "getSelectedOfferType", "_filteredOffers", "filteredOffers", "getFilteredOffers", "_isDeleting", "isDeleting", "_deleteSuccess", "deleteSuccess", "getDeleteSuccess", "observeFilteredOffers", "", "filterOffers", "offers", "offerType", "setOfferTypeToAdd", "getOfferTypeToAdd", "onOfferTypeSelected", "getOfferById", "offerId", "Ljava/util/UUID;", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOfferDetails", "newDetails", "saveOffer", "updateOffer", "deleteOffer", "toggleOfferActive", "offer", "isActive", "resetSnackBarMessage", "resetDeleteSuccess", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OffersViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> _addOfferSuccess;
    private final MutableStateFlow<Boolean> _deleteSuccess;
    private final MutableStateFlow<Boolean> _editOfferSuccess;
    private final MutableStateFlow<List<Offer>> _filteredOffers;
    private final MutableStateFlow<Boolean> _isDeleting;
    private final MutableStateFlow<OfferDetails> _offerDetails;
    private final MutableStateFlow<LoadingState> _offersLoadingState;
    private final MutableStateFlow<Offer> _selectedOffer;
    private final MutableStateFlow<OfferType> _selectedOfferType;
    private final MutableStateFlow<String> _snackBarMessage;
    private final StateFlow<Boolean> addOfferSuccess;
    private final StateFlow<List<Offer>> allOffers;
    private final DeleteOfferUseCase deleteOfferUseCase;
    private final StateFlow<Boolean> deleteSuccess;
    private final StateFlow<Boolean> editOfferSuccess;
    private final StateFlow<List<Offer>> filteredOffers;
    private final StateFlow<Boolean> isDeleting;
    private final StateFlow<OfferDetails> offerDetails;
    private final OfferRepository offerRepository;
    private final StateFlow<LoadingState> offersLoadingState;
    private final StateFlow<Offer> selectedOffer;
    private final StateFlow<OfferType> selectedOfferType;
    private final SharedOffersRepository sharedOffersRepository;
    private final StateFlow<String> snackBarMessage;

    /* JADX INFO: compiled from: OffersViewModel.kt */
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

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$getOfferById$1, reason: invalid class name */
    /* JADX INFO: compiled from: OffersViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel", f = "OffersViewModel.kt", i = {0}, l = {117}, m = "getOfferById", n = {"offerId"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OffersViewModel.this.getOfferById(null, this);
        }
    }

    @Inject
    public OffersViewModel(OfferRepository offerRepository, SharedOffersRepository sharedOffersRepository, DeleteOfferUseCase deleteOfferUseCase) {
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        Intrinsics.checkNotNullParameter(sharedOffersRepository, "sharedOffersRepository");
        Intrinsics.checkNotNullParameter(deleteOfferUseCase, "deleteOfferUseCase");
        this.offerRepository = offerRepository;
        this.sharedOffersRepository = sharedOffersRepository;
        this.deleteOfferUseCase = deleteOfferUseCase;
        MutableStateFlow<LoadingState> MutableStateFlow = StateFlowKt.MutableStateFlow(LoadingState.Idle.INSTANCE);
        this._offersLoadingState = MutableStateFlow;
        this.offersLoadingState = FlowKt.asStateFlow(MutableStateFlow);
        final Flow flowOnStart = FlowKt.onStart(offerRepository.getOffers(), new OffersViewModel$allOffers$1(this, null));
        this.allOffers = FlowKt.stateIn(FlowKt.m12020catch(new Flow<List<? extends Offer>>() { // from class: com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$special$$inlined$map$1

            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ OffersViewModel this$0;

                /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$special$$inlined$map$1$2", f = "OffersViewModel.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, OffersViewModel offersViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = offersViewModel;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        List list = (List) obj;
                        this.this$0._offersLoadingState.setValue(new LoadingState.Success("Loaded " + list.size() + " offers"));
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(list, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends Offer>> flowCollector, Continuation continuation) {
                Object objCollect = flowOnStart.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new OffersViewModel$allOffers$3(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), CollectionsKt.emptyList());
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._snackBarMessage = MutableStateFlow2;
        this.snackBarMessage = MutableStateFlow2;
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._addOfferSuccess = MutableStateFlow3;
        this.addOfferSuccess = MutableStateFlow3;
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(false);
        this._editOfferSuccess = MutableStateFlow4;
        this.editOfferSuccess = MutableStateFlow4;
        MutableStateFlow<Offer> MutableStateFlow5 = StateFlowKt.MutableStateFlow(null);
        this._selectedOffer = MutableStateFlow5;
        this.selectedOffer = FlowKt.asStateFlow(MutableStateFlow5);
        MutableStateFlow<OfferDetails> MutableStateFlow6 = StateFlowKt.MutableStateFlow(new OfferDetails(null, null, null, null, false, false, 63, null));
        this._offerDetails = MutableStateFlow6;
        this.offerDetails = MutableStateFlow6;
        MutableStateFlow<OfferType> MutableStateFlow7 = StateFlowKt.MutableStateFlow(OfferType.NONE);
        this._selectedOfferType = MutableStateFlow7;
        this.selectedOfferType = MutableStateFlow7;
        MutableStateFlow<List<Offer>> MutableStateFlow8 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._filteredOffers = MutableStateFlow8;
        this.filteredOffers = MutableStateFlow8;
        MutableStateFlow<Boolean> MutableStateFlow9 = StateFlowKt.MutableStateFlow(false);
        this._isDeleting = MutableStateFlow9;
        this.isDeleting = FlowKt.asStateFlow(MutableStateFlow9);
        MutableStateFlow<Boolean> MutableStateFlow10 = StateFlowKt.MutableStateFlow(false);
        this._deleteSuccess = MutableStateFlow10;
        this.deleteSuccess = FlowKt.asStateFlow(MutableStateFlow10);
        observeFilteredOffers();
    }

    public final StateFlow<LoadingState> getOffersLoadingState() {
        return this.offersLoadingState;
    }

    public final StateFlow<String> getSnackBarMessage() {
        return this.snackBarMessage;
    }

    public final StateFlow<Boolean> getAddOfferSuccess() {
        return this.addOfferSuccess;
    }

    public final StateFlow<Boolean> getEditOfferSuccess() {
        return this.editOfferSuccess;
    }

    public final StateFlow<Offer> getSelectedOffer() {
        return this.selectedOffer;
    }

    public final StateFlow<OfferDetails> getOfferDetails() {
        return this.offerDetails;
    }

    public final StateFlow<OfferType> getSelectedOfferType() {
        return this.selectedOfferType;
    }

    public final StateFlow<List<Offer>> getFilteredOffers() {
        return this.filteredOffers;
    }

    public final StateFlow<Boolean> isDeleting() {
        return this.isDeleting;
    }

    public final StateFlow<Boolean> getDeleteSuccess() {
        return this.deleteSuccess;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$observeFilteredOffers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OffersViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "offers", "offerType", "Lcom/example/bingwahybrid/domain/offers/enums/OfferType;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$observeFilteredOffers$1", f = "OffersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07221 extends SuspendLambda implements Function3<List<? extends Offer>, OfferType, Continuation<? super List<? extends Offer>>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        C07221(Continuation<? super C07221> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(List<? extends Offer> list, OfferType offerType, Continuation<? super List<? extends Offer>> continuation) {
            return invoke2((List<Offer>) list, offerType, (Continuation<? super List<Offer>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(List<Offer> list, OfferType offerType, Continuation<? super List<Offer>> continuation) {
            C07221 c07221 = OffersViewModel.this.new C07221(continuation);
            c07221.L$0 = list;
            c07221.L$1 = offerType;
            return c07221.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list = (List) this.L$0;
            OfferType offerType = (OfferType) this.L$1;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return OffersViewModel.this.filterOffers(list, offerType);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void observeFilteredOffers() {
        FlowKt.launchIn(FlowKt.onEach(FlowKt.combine(this.allOffers, this.selectedOfferType, new C07221(null)), new AnonymousClass2(null)), ViewModelKt.getViewModelScope(this));
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$observeFilteredOffers$2, reason: invalid class name */
    /* JADX INFO: compiled from: OffersViewModel.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "filtered", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$observeFilteredOffers$2", f = "OffersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<List<? extends Offer>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = OffersViewModel.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(List<? extends Offer> list, Continuation<? super Unit> continuation) {
            return invoke2((List<Offer>) list, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(List<Offer> list, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list = (List) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                OffersViewModel.this._filteredOffers.setValue(list);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
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

    public final void setOfferTypeToAdd(OfferType offerType) {
        Intrinsics.checkNotNullParameter(offerType, "offerType");
        this.sharedOffersRepository.setOfferTypeToAdd(offerType);
    }

    public final OfferType getOfferTypeToAdd() {
        return this.sharedOffersRepository.getOfferTypeToAdd();
    }

    public final void onOfferTypeSelected(OfferType offerType) {
        Intrinsics.checkNotNullParameter(offerType, "offerType");
        this._selectedOfferType.setValue(offerType);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getOfferById(UUID uuid, Continuation<? super Unit> continuation) {
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
        Object offerById = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(offerById);
            OfferRepository offerRepository = this.offerRepository;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(uuid);
            anonymousClass1.label = 1;
            offerById = offerRepository.getOfferById(uuid, anonymousClass1);
            if (offerById == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(offerById);
        }
        Offer offer = (Offer) offerById;
        if (offer != null) {
            this._selectedOffer.setValue(offer);
            this._offerDetails.setValue(new OfferDetails(offer.getName(), offer.getUssdCode(), String.valueOf(offer.getPrice()), offer.getType(), offer.getAutoReschedule(), offer.isActive()));
        }
        return Unit.INSTANCE;
    }

    public final void updateOfferDetails(OfferDetails newDetails) {
        Intrinsics.checkNotNullParameter(newDetails, "newDetails");
        this._offerDetails.setValue(newDetails);
    }

    public final void saveOffer() {
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID(...)");
        String offerName = this._offerDetails.getValue().getOfferName();
        String ussdCode = this._offerDetails.getValue().getUssdCode();
        Integer intOrNull = StringsKt.toIntOrNull(this._offerDetails.getValue().getPrice());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07231(new Offer(uuidRandomUUID, offerName, ussdCode, intOrNull != null ? intOrNull.intValue() : 0, getOfferTypeToAdd(), null, false, null, this._offerDetails.getValue().isActive(), false, false, false, false, 0, 0, 0L, null, false, 261856, null), null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$saveOffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OffersViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$saveOffer$1", f = "OffersViewModel.kt", i = {1}, l = {146, TextFieldImplKt.AnimationDuration}, m = "invokeSuspend", n = {"existingOffer"}, s = {"L$0"})
    static final class C07231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Offer $newOffer;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07231(Offer offer, Continuation<? super C07231> continuation) {
            super(2, continuation);
            this.$newOffer = offer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OffersViewModel.this.new C07231(this.$newOffer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
        
            if (r6.this$0.offerRepository.addOffer(r6.$newOffer, r6) == r0) goto L23;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    OffersViewModel.this._addOfferSuccess.setValue(Boxing.boxBoolean(true));
                    OffersViewModel.this._snackBarMessage.setValue("Offer added successfully");
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = OffersViewModel.this.offerRepository.getOfferByPrice(this.$newOffer.getPrice(), this);
                if (obj == coroutine_suspended) {
                }
                return coroutine_suspended;
                Offer offer = (Offer) obj;
                if (offer != null) {
                    throw new Exception("An offer with similar amount exists. Please try a different amount");
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(offer);
                this.label = 2;
            } catch (Exception e) {
                OffersViewModel.this._snackBarMessage.setValue(e.getMessage());
                OffersViewModel.this._addOfferSuccess.setValue(Boxing.boxBoolean(false));
            }
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$updateOffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OffersViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$updateOffer$1", f = "OffersViewModel.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {175, 180}, m = "invokeSuspend", n = {"offer", "updatedOffer", "$i$a$-let-OffersViewModel$updateOffer$1$1", "offer", "existingOffer", "updatedOffer", "$i$a$-let-OffersViewModel$updateOffer$1$1"}, s = {"L$1", "L$2", "I$0", "L$1", "L$2", "L$3", "I$0"})
    static final class C07251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        C07251(Continuation<? super C07251> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OffersViewModel.this.new C07251(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:45:0x014e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            OffersViewModel offersViewModel;
            OffersViewModel offersViewModel2;
            Object offerByPrice;
            Offer offer;
            Offer offer2;
            int i;
            Offer offer3;
            OfferRepository offerRepository;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Object value = OffersViewModel.this._selectedOffer.getValue();
                offersViewModel = OffersViewModel.this;
                Offer offer4 = (Offer) value;
                if (offer4 != null) {
                    String offerName = ((OfferDetails) offersViewModel._offerDetails.getValue()).getOfferName();
                    String ussdCode = offer4.isVerified() ? offer4.getUssdCode() : ((OfferDetails) offersViewModel._offerDetails.getValue()).getUssdCode();
                    Integer intOrNull = StringsKt.toIntOrNull(((OfferDetails) offersViewModel._offerDetails.getValue()).getPrice());
                    Offer offerCopy$default = Offer.copy$default(offer4, null, offerName, ussdCode, intOrNull != null ? intOrNull.intValue() : 0, ((OfferDetails) offersViewModel._offerDetails.getValue()).getType(), null, ((OfferDetails) offersViewModel._offerDetails.getValue()).getAutoReschedule(), null, ((OfferDetails) offersViewModel._offerDetails.getValue()).isActive(), false, false, false, false, 0, 0, 0L, null, false, 261793, null);
                    try {
                        OfferRepository offerRepository2 = offersViewModel.offerRepository;
                        int price = offerCopy$default.getPrice();
                        this.L$0 = offersViewModel;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(offer4);
                        this.L$2 = offerCopy$default;
                        this.I$0 = 0;
                        this.label = 1;
                        offerByPrice = offerRepository2.getOfferByPrice(price, this);
                        if (offerByPrice != coroutine_suspended) {
                            offer = offer4;
                            offer2 = offerCopy$default;
                            i = 0;
                            offer3 = (Offer) offerByPrice;
                            if (offer3 != null) {
                                throw new Exception("An offer with similar amount exists. Please try a different amount");
                            }
                            offerRepository = offersViewModel.offerRepository;
                            this.L$0 = offersViewModel;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(offer);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(offer3);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(offer2);
                            this.I$0 = i;
                            this.label = 2;
                            if (offerRepository.updateOffer(offer2, this) != coroutine_suspended) {
                                offersViewModel2 = offersViewModel;
                                offersViewModel2._editOfferSuccess.setValue(Boxing.boxBoolean(true));
                                offersViewModel2._snackBarMessage.setValue("Offer updated successfully");
                                NavigationManager.INSTANCE.back();
                            }
                        }
                        return coroutine_suspended;
                    } catch (Exception e) {
                        e = e;
                        offersViewModel2 = offersViewModel;
                        offersViewModel2._editOfferSuccess.setValue(Boxing.boxBoolean(false));
                        offersViewModel2._snackBarMessage.setValue(e.getMessage());
                    }
                } else {
                    return Unit.INSTANCE;
                }
            } else if (i2 == 1) {
                i = this.I$0;
                Offer offer5 = (Offer) this.L$2;
                Offer offer6 = (Offer) this.L$1;
                OffersViewModel offersViewModel3 = (OffersViewModel) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    offer = offer6;
                    offer2 = offer5;
                    offersViewModel = offersViewModel3;
                    offerByPrice = obj;
                    offer3 = (Offer) offerByPrice;
                    if (offer3 != null && !Intrinsics.areEqual(offer3.getId(), offer2.getId())) {
                        throw new Exception("An offer with similar amount exists. Please try a different amount");
                    }
                    offerRepository = offersViewModel.offerRepository;
                    this.L$0 = offersViewModel;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(offer);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(offer3);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(offer2);
                    this.I$0 = i;
                    this.label = 2;
                    if (offerRepository.updateOffer(offer2, this) != coroutine_suspended) {
                        offersViewModel2 = offersViewModel;
                        offersViewModel2._editOfferSuccess.setValue(Boxing.boxBoolean(true));
                        offersViewModel2._snackBarMessage.setValue("Offer updated successfully");
                        NavigationManager.INSTANCE.back();
                    }
                    return coroutine_suspended;
                } catch (Exception e2) {
                    e = e2;
                    offersViewModel2 = offersViewModel3;
                    offersViewModel2._editOfferSuccess.setValue(Boxing.boxBoolean(false));
                    offersViewModel2._snackBarMessage.setValue(e.getMessage());
                }
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                offersViewModel2 = (OffersViewModel) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    offersViewModel2._editOfferSuccess.setValue(Boxing.boxBoolean(true));
                    offersViewModel2._snackBarMessage.setValue("Offer updated successfully");
                    NavigationManager.INSTANCE.back();
                } catch (Exception e3) {
                    e = e3;
                    offersViewModel2._editOfferSuccess.setValue(Boxing.boxBoolean(false));
                    offersViewModel2._snackBarMessage.setValue(e.getMessage());
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void updateOffer() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07251(null), 3, null);
    }

    public final void deleteOffer() {
        Offer value = this._selectedOffer.getValue();
        if (value != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OffersViewModel$deleteOffer$1$1(this, value, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$toggleOfferActive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OffersViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel$toggleOfferActive$1", f = "OffersViewModel.kt", i = {0}, l = {218}, m = "invokeSuspend", n = {"updatedOffer"}, s = {"L$0"})
    static final class C07241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isActive;
        final /* synthetic */ Offer $offer;
        Object L$0;
        int label;
        final /* synthetic */ OffersViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07241(Offer offer, boolean z, OffersViewModel offersViewModel, Continuation<? super C07241> continuation) {
            super(2, continuation);
            this.$offer = offer;
            this.$isActive = z;
            this.this$0 = offersViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07241(this.$offer, this.$isActive, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Offer offerCopy$default = Offer.copy$default(this.$offer, null, null, null, 0, null, null, false, null, this.$isActive, false, false, false, false, 0, 0, 0L, null, false, 261887, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(offerCopy$default);
                    this.label = 1;
                    if (this.this$0.offerRepository.updateOffer(offerCopy$default, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0._snackBarMessage.setValue(this.$isActive ? "Offer activated" : "Offer deactivated");
            } catch (Exception e) {
                this.this$0._snackBarMessage.setValue(e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    public final void toggleOfferActive(Offer offer, boolean isActive) {
        Intrinsics.checkNotNullParameter(offer, "offer");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07241(offer, isActive, this, null), 3, null);
    }

    public final void resetSnackBarMessage() {
        this._snackBarMessage.setValue(null);
    }

    public final void resetDeleteSuccess() {
        this._deleteSuccess.setValue(false);
    }
}
