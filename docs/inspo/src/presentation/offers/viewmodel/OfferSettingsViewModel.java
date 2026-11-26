package com.example.bingwahybrid.presentation.offers.viewmodel;

import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.presentation.offers.dto.OfferSettingsState;
import com.fasterxml.jackson.core.io.doubleparser.FastDoubleMath;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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

/* JADX INFO: compiled from: OfferSettingsViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J\u0006\u0010\u0017\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u001dJ\u000e\u0010#\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010(\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006)"}, d2 = {"Lcom/example/bingwahybrid/presentation/offers/viewmodel/OfferSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bingwahybrid/presentation/offers/dto/OfferSettingsState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_currentOffer", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "currentOffer", "getCurrentOffer", "loadOffer", "", "offerId", "Ljava/util/UUID;", "updateStatesFromDatabase", "offer", "clearErrorMessage", "updateAutoReschedule", "enabled", "", "updateUssdTimeout", "seconds", "", "updateAutoRetry", "updateNumberOfRetries", "count", "updateRetryInterval", "mins", "updateAutoRetryConnectionProblems", "updateRescheduleTime", "timeString", "", "updateStrictMode", "updateOffer", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfferSettingsViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Offer> _currentOffer;
    private final MutableStateFlow<OfferSettingsState> _uiState;
    private final StateFlow<Offer> currentOffer;
    private final OfferRepository offerRepository;
    private final StateFlow<OfferSettingsState> uiState;

    @Inject
    public OfferSettingsViewModel(OfferRepository offerRepository) {
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        this.offerRepository = offerRepository;
        MutableStateFlow<OfferSettingsState> MutableStateFlow = StateFlowKt.MutableStateFlow(new OfferSettingsState(false, null, false, null, 0, false, 0, 0, false, false, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null));
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Offer> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._currentOffer = MutableStateFlow2;
        this.currentOffer = FlowKt.asStateFlow(MutableStateFlow2);
    }

    public final StateFlow<OfferSettingsState> getUiState() {
        return this.uiState;
    }

    public final StateFlow<Offer> getCurrentOffer() {
        return this.currentOffer;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.offers.viewmodel.OfferSettingsViewModel$loadOffer$1, reason: invalid class name */
    /* JADX INFO: compiled from: OfferSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.viewmodel.OfferSettingsViewModel$loadOffer$1", f = "OfferSettingsViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UUID $offerId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UUID uuid, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$offerId = uuid;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OfferSettingsViewModel.this.new AnonymousClass1(this.$offerId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object value2;
            Object value3;
            Object value4;
            Object offerById;
            Object value5;
            Object value6;
            Object value7;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        MutableStateFlow mutableStateFlow = OfferSettingsViewModel.this._uiState;
                        do {
                            value4 = mutableStateFlow.getValue();
                        } while (!mutableStateFlow.compareAndSet(value4, OfferSettingsState.copy$default((OfferSettingsState) value4, true, null, false, null, 0, false, 0, 0, false, false, 1022, null)));
                        this.label = 1;
                        offerById = OfferSettingsViewModel.this.offerRepository.getOfferById(this.$offerId, this);
                        if (offerById == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        offerById = obj;
                    }
                    Offer offer = (Offer) offerById;
                    if (offer != null) {
                        OfferSettingsViewModel.this._currentOffer.setValue(offer);
                        OfferSettingsViewModel.this.updateStatesFromDatabase(offer);
                        MutableStateFlow mutableStateFlow2 = OfferSettingsViewModel.this._uiState;
                        do {
                            value5 = mutableStateFlow2.getValue();
                        } while (!mutableStateFlow2.compareAndSet(value5, OfferSettingsState.copy$default((OfferSettingsState) value5, false, null, false, null, 0, false, 0, 0, false, false, 1022, null)));
                        return Unit.INSTANCE;
                    }
                    MutableStateFlow mutableStateFlow3 = OfferSettingsViewModel.this._uiState;
                    do {
                        value6 = mutableStateFlow3.getValue();
                    } while (!mutableStateFlow3.compareAndSet(value6, OfferSettingsState.copy$default((OfferSettingsState) value6, false, "Offer not found", false, null, 0, false, 0, 0, false, false, PointerIconCompat.TYPE_GRABBING, null)));
                    Unit unit = Unit.INSTANCE;
                    MutableStateFlow mutableStateFlow4 = OfferSettingsViewModel.this._uiState;
                    do {
                        value7 = mutableStateFlow4.getValue();
                    } while (!mutableStateFlow4.compareAndSet(value7, OfferSettingsState.copy$default((OfferSettingsState) value7, false, null, false, null, 0, false, 0, 0, false, false, 1022, null)));
                    return unit;
                } catch (Exception e) {
                    MutableStateFlow mutableStateFlow5 = OfferSettingsViewModel.this._uiState;
                    do {
                        value = mutableStateFlow5.getValue();
                    } while (!mutableStateFlow5.compareAndSet(value, OfferSettingsState.copy$default((OfferSettingsState) value, false, e.getMessage(), false, null, 0, false, 0, 0, false, false, PointerIconCompat.TYPE_GRABBING, null)));
                    MutableStateFlow mutableStateFlow6 = OfferSettingsViewModel.this._uiState;
                    do {
                        value2 = mutableStateFlow6.getValue();
                    } while (!mutableStateFlow6.compareAndSet(value2, OfferSettingsState.copy$default((OfferSettingsState) value2, false, null, false, null, 0, false, 0, 0, false, false, 1022, null)));
                }
            } catch (Throwable th) {
                MutableStateFlow mutableStateFlow7 = OfferSettingsViewModel.this._uiState;
                do {
                    value3 = mutableStateFlow7.getValue();
                } while (!mutableStateFlow7.compareAndSet(value3, OfferSettingsState.copy$default((OfferSettingsState) value3, false, null, false, null, 0, false, 0, 0, false, false, 1022, null)));
                throw th;
            }
        }
    }

    public final void loadOffer(UUID offerId) {
        Intrinsics.checkNotNullParameter(offerId, "offerId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(offerId, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStatesFromDatabase(Offer offer) {
        OfferSettingsState value;
        MutableStateFlow<OfferSettingsState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, OfferSettingsState.copy$default(value, false, null, offer.getAutoReschedule(), offer.getAutoRescheduleRunTime(), (int) (offer.getUssdTimeoutMillis() / ((long) 1000)), offer.getAutoRetry(), offer.getNumberOfRetries(), offer.getRetryIntervalMins(), offer.getAutoRetryConnectionProblems(), offer.getStrictMode(), 3, null)));
    }

    public final void clearErrorMessage() {
        OfferSettingsState value;
        MutableStateFlow<OfferSettingsState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, OfferSettingsState.copy$default(value, false, null, false, null, 0, false, 0, 0, false, false, PointerIconCompat.TYPE_GRABBING, null)));
    }

    public final void updateAutoReschedule(boolean enabled) {
        OfferSettingsState value;
        MutableStateFlow<OfferSettingsState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, OfferSettingsState.copy$default(value, false, null, enabled, null, 0, false, 0, 0, false, false, PointerIconCompat.TYPE_ZOOM_OUT, null)));
        updateOffer();
    }

    public final void updateUssdTimeout(int seconds) {
        OfferSettingsState value;
        MutableStateFlow<OfferSettingsState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, OfferSettingsState.copy$default(value, false, null, false, null, seconds, false, 0, 0, false, false, PointerIconCompat.TYPE_CROSSHAIR, null)));
        updateOffer();
    }

    public final void updateAutoRetry(boolean enabled) {
        OfferSettingsState value;
        OfferSettingsState value2;
        if (!enabled && this._uiState.getValue().getAutoRetryConnectionProblems()) {
            MutableStateFlow<OfferSettingsState> mutableStateFlow = this._uiState;
            do {
                value2 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value2, OfferSettingsState.copy$default(value2, false, null, false, null, 0, false, 0, 0, false, false, 767, null)));
        }
        MutableStateFlow<OfferSettingsState> mutableStateFlow2 = this._uiState;
        do {
            value = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value, OfferSettingsState.copy$default(value, false, null, false, null, 0, enabled, 0, 0, false, false, 991, null)));
        updateOffer();
    }

    public final void updateNumberOfRetries(int count) {
        OfferSettingsState value;
        MutableStateFlow<OfferSettingsState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, OfferSettingsState.copy$default(value, false, null, false, null, 0, false, count, 0, false, false, 959, null)));
        updateOffer();
    }

    public final void updateRetryInterval(int mins) {
        OfferSettingsState value;
        MutableStateFlow<OfferSettingsState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, OfferSettingsState.copy$default(value, false, null, false, null, 0, false, 0, mins, false, false, 895, null)));
        updateOffer();
    }

    public final void updateAutoRetryConnectionProblems(boolean enabled) {
        OfferSettingsState value;
        OfferSettingsState value2;
        if (enabled && !this._uiState.getValue().getAutoRetry()) {
            MutableStateFlow<OfferSettingsState> mutableStateFlow = this._uiState;
            do {
                value2 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value2, OfferSettingsState.copy$default(value2, false, null, false, null, 0, true, 0, 0, false, false, 991, null)));
        }
        MutableStateFlow<OfferSettingsState> mutableStateFlow2 = this._uiState;
        do {
            value = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value, OfferSettingsState.copy$default(value, false, null, false, null, 0, false, 0, 0, enabled, false, 767, null)));
        updateOffer();
    }

    public final void updateRescheduleTime(String timeString) {
        String timeString2 = timeString;
        Intrinsics.checkNotNullParameter(timeString2, "timeString");
        MutableStateFlow<OfferSettingsState> mutableStateFlow = this._uiState;
        while (true) {
            OfferSettingsState value = mutableStateFlow.getValue();
            if (mutableStateFlow.compareAndSet(value, OfferSettingsState.copy$default(value, false, null, false, timeString2, 0, false, 0, 0, false, false, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null))) {
                updateOffer();
                return;
            }
            timeString2 = timeString;
        }
    }

    public final void updateStrictMode(boolean enabled) {
        OfferSettingsState value;
        MutableStateFlow<OfferSettingsState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, OfferSettingsState.copy$default(value, false, null, false, null, 0, false, 0, 0, false, enabled, 511, null)));
        updateOffer();
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.offers.viewmodel.OfferSettingsViewModel$updateOffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfferSettingsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.viewmodel.OfferSettingsViewModel$updateOffer$1", f = "OfferSettingsViewModel.kt", i = {0, 0}, l = {135}, m = "invokeSuspend", n = {"offer", "updatedOffer"}, s = {"L$0", "L$1"})
    static final class C07211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C07211(Continuation<? super C07211> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OfferSettingsViewModel.this.new C07211(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object value2;
            Object value3;
            Object value4;
            Offer offer;
            Object value5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        MutableStateFlow mutableStateFlow = OfferSettingsViewModel.this._uiState;
                        do {
                            value4 = mutableStateFlow.getValue();
                        } while (!mutableStateFlow.compareAndSet(value4, OfferSettingsState.copy$default((OfferSettingsState) value4, true, null, false, null, 0, false, 0, 0, false, false, 1022, null)));
                        Offer offer2 = (Offer) OfferSettingsViewModel.this._currentOffer.getValue();
                        if (offer2 != null) {
                            boolean autoReschedule = ((OfferSettingsState) OfferSettingsViewModel.this._uiState.getValue()).getAutoReschedule();
                            String autoRescheduleRunTime = ((OfferSettingsState) OfferSettingsViewModel.this._uiState.getValue()).getAutoRescheduleRunTime();
                            long ussdTimeoutSeconds = ((long) ((OfferSettingsState) OfferSettingsViewModel.this._uiState.getValue()).getUssdTimeoutSeconds()) * 1000;
                            Offer offerCopy$default = Offer.copy$default(offer2, null, null, null, 0, null, null, autoReschedule, autoRescheduleRunTime, false, false, false, ((OfferSettingsState) OfferSettingsViewModel.this._uiState.getValue()).getAutoRetryConnectionProblems(), ((OfferSettingsState) OfferSettingsViewModel.this._uiState.getValue()).getAutoRetry(), ((OfferSettingsState) OfferSettingsViewModel.this._uiState.getValue()).getNumberOfRetries(), ((OfferSettingsState) OfferSettingsViewModel.this._uiState.getValue()).getRetryIntervalMins(), ussdTimeoutSeconds, null, ((OfferSettingsState) OfferSettingsViewModel.this._uiState.getValue()).getStrictMode(), 67391, null);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(offer2);
                            this.L$1 = offerCopy$default;
                            this.label = 1;
                            if (OfferSettingsViewModel.this.offerRepository.updateOffer(offerCopy$default, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            offer = offerCopy$default;
                        } else {
                            throw new Exception("No offer loaded");
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        offer = (Offer) this.L$1;
                        ResultKt.throwOnFailure(obj);
                    }
                    OfferSettingsViewModel.this._currentOffer.setValue(offer);
                    MutableStateFlow mutableStateFlow2 = OfferSettingsViewModel.this._uiState;
                    do {
                        value5 = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value5, OfferSettingsState.copy$default((OfferSettingsState) value5, false, null, false, null, 0, false, 0, 0, false, false, 1022, null)));
                } catch (Exception e) {
                    MutableStateFlow mutableStateFlow3 = OfferSettingsViewModel.this._uiState;
                    do {
                        value = mutableStateFlow3.getValue();
                    } while (!mutableStateFlow3.compareAndSet(value, OfferSettingsState.copy$default((OfferSettingsState) value, false, e.getMessage(), false, null, 0, false, 0, 0, false, false, PointerIconCompat.TYPE_GRABBING, null)));
                    MutableStateFlow mutableStateFlow4 = OfferSettingsViewModel.this._uiState;
                    do {
                        value2 = mutableStateFlow4.getValue();
                    } while (!mutableStateFlow4.compareAndSet(value2, OfferSettingsState.copy$default((OfferSettingsState) value2, false, null, false, null, 0, false, 0, 0, false, false, 1022, null)));
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                MutableStateFlow mutableStateFlow5 = OfferSettingsViewModel.this._uiState;
                do {
                    value3 = mutableStateFlow5.getValue();
                } while (!mutableStateFlow5.compareAndSet(value3, OfferSettingsState.copy$default((OfferSettingsState) value3, false, null, false, null, 0, false, 0, 0, false, false, 1022, null)));
                throw th;
            }
        }
    }

    private final void updateOffer() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07211(null), 3, null);
    }
}
