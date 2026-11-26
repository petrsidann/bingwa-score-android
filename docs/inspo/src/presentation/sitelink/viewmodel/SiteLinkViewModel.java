package com.example.bingwahybrid.presentation.sitelink.viewmodel;

import androidx.autofill.HintConstants;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.devices.model.Device;
import com.example.bingwahybrid.domain.devices.repository.DeviceRepository;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.sitelink.enums.SiteLinkAccountType;
import com.example.bingwahybrid.domain.sitelink.model.SiteLink;
import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import com.example.bingwahybrid.domain.sitelink.usecase.DeleteSiteLinkOfferUseCase;
import com.example.bingwahybrid.domain.sitelink.usecase.DeleteSiteLinkUseCase;
import com.example.bingwahybrid.domain.sitelink.usecase.GetSiteLinkUseCase;
import com.example.bingwahybrid.domain.sitelink.usecase.RequestSiteLinkUseCase;
import com.example.bingwahybrid.domain.sitelink.usecase.UpdateSiteLinkUseCase;
import com.example.bingwahybrid.domain.usecase.ActivateSiteLinkUseCase;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SiteLinkViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u000204J\u000e\u0010`\u001a\u00020^2\u0006\u0010a\u001a\u000204J\u000e\u0010b\u001a\u00020^2\u0006\u0010a\u001a\u00020FJ\u000e\u0010c\u001a\u00020^2\u0006\u0010d\u001a\u000204J\u000e\u0010e\u001a\u00020^H\u0086@¢\u0006\u0002\u0010fJ\u000e\u0010g\u001a\u00020#H\u0086@¢\u0006\u0002\u0010fJ\u0006\u0010h\u001a\u00020^J\u000e\u0010i\u001a\u00020^2\u0006\u0010j\u001a\u00020#J\b\u0010k\u001a\u00020^H\u0002J\u0006\u0010l\u001a\u00020^J\u0006\u0010m\u001a\u00020^J\u0006\u0010n\u001a\u00020^J\u0006\u0010o\u001a\u00020^J\u000e\u0010p\u001a\u00020^2\u0006\u0010q\u001a\u00020\u0019J\u000e\u0010r\u001a\u00020^H\u0082@¢\u0006\u0002\u0010fJ\u0018\u0010s\u001a\u00020^2\u0006\u0010t\u001a\u00020)2\b\u0010u\u001a\u0004\u0018\u00010XJ\u0006\u0010v\u001a\u00020^J\u0006\u0010w\u001a\u00020^J\u0006\u0010x\u001a\u00020^R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u001b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u001b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR \u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020#0(0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020#0+0\u001b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020#0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020#0\u001b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020#0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020#0\u001b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u0016\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040\u001b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001dR\u0016\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040\u001b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001dR\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020#0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020#0\u001b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u001dR\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020#0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020#0\u001b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001dR\u0014\u0010?\u001a\b\u0012\u0004\u0012\u0002040\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u0002040\u001b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001dR\u0014\u0010B\u001a\b\u0012\u0004\u0012\u0002040\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010C\u001a\b\u0012\u0004\u0012\u0002040\u001b¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u001dR\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020F0\u001b¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u001dR\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020#0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020#0\u001b¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u001dR\u0014\u0010K\u001a\b\u0012\u0004\u0012\u0002040\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010L\u001a\b\u0012\u0004\u0012\u0002040\u001b¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u001dR\u0016\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u001b¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u001dR\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020#0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020#0\u001b¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u001dR\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010T\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020#0+0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010U\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020#0+0\u001b¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u001dR\u001a\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020X0\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020X0\u00180\u001b¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u001dR%\u0010[\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020)\u0012\u0006\u0012\u0004\u0018\u00010X0+0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\u001d¨\u0006y"}, d2 = {"Lcom/example/bingwahybrid/presentation/sitelink/viewmodel/SiteLinkViewModel;", "Landroidx/lifecycle/ViewModel;", "getSiteLinkUseCase", "Lcom/example/bingwahybrid/domain/sitelink/usecase/GetSiteLinkUseCase;", "requestSiteLinkUseCase", "Lcom/example/bingwahybrid/domain/sitelink/usecase/RequestSiteLinkUseCase;", "offerRepository", "Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;", "deleteSiteLinkOfferUseCase", "Lcom/example/bingwahybrid/domain/sitelink/usecase/DeleteSiteLinkOfferUseCase;", "activateSiteLinkUseCase", "Lcom/example/bingwahybrid/domain/usecase/ActivateSiteLinkUseCase;", "updateSiteLinkUseCase", "Lcom/example/bingwahybrid/domain/sitelink/usecase/UpdateSiteLinkUseCase;", "deleteSiteLinkUseCase", "Lcom/example/bingwahybrid/domain/sitelink/usecase/DeleteSiteLinkUseCase;", "siteLinkRepository", "Lcom/example/bingwahybrid/domain/sitelink/repository/SiteLinkRepository;", "deviceRepository", "Lcom/example/bingwahybrid/domain/devices/repository/DeviceRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/sitelink/usecase/GetSiteLinkUseCase;Lcom/example/bingwahybrid/domain/sitelink/usecase/RequestSiteLinkUseCase;Lcom/example/bingwahybrid/domain/offers/repository/OfferRepository;Lcom/example/bingwahybrid/domain/sitelink/usecase/DeleteSiteLinkOfferUseCase;Lcom/example/bingwahybrid/domain/usecase/ActivateSiteLinkUseCase;Lcom/example/bingwahybrid/domain/sitelink/usecase/UpdateSiteLinkUseCase;Lcom/example/bingwahybrid/domain/sitelink/usecase/DeleteSiteLinkUseCase;Lcom/example/bingwahybrid/domain/sitelink/repository/SiteLinkRepository;Lcom/example/bingwahybrid/domain/devices/repository/DeviceRepository;)V", "_onlineOffers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "onlineOffers", "Lkotlinx/coroutines/flow/StateFlow;", "getOnlineOffers", "()Lkotlinx/coroutines/flow/StateFlow;", "_mySiteLink", "Lcom/example/bingwahybrid/domain/sitelink/model/SiteLink;", "mySiteLink", "getMySiteLink", "_isSiteLinkLoading", "", "isSiteLinkLoading", "_isLoading", "isLoading", "_loadingStates", "", "Ljava/util/UUID;", "loadingStates", "", "getLoadingStates", "_siteLinkGenerationSuccess", "siteLinkGenerationSuccess", "getSiteLinkGenerationSuccess", "_siteLinkUpdateSuccess", "updateSuccess", "getUpdateSuccess", "_errorMessage", "", "errorMessage", "getErrorMessage", "_successMessage", "successMessage", "getSuccessMessage", "_isDeleting", "isDeleting", "_deleteSuccess", "deleteSuccess", "getDeleteSuccess", "_siteName", "siteName", "getSiteName", "_accountNumber", "accountNumber", "getAccountNumber", "_accountType", "Lcom/example/bingwahybrid/domain/sitelink/enums/SiteLinkAccountType;", "accountType", "getAccountType", "_isSiteLinkActive", "isSiteLinkActive", "_username", HintConstants.AUTOFILL_HINT_USERNAME, "getUsername", "_isUsernameAvailable", "isUsernameAvailable", "_isCheckingUsername", "isCheckingUsername", "usernameCheckJob", "Lkotlinx/coroutines/Job;", "_deviceSelectionLoadingStates", "deviceSelectionLoadingStates", "getDeviceSelectionLoadingStates", "_myDevices", "Lcom/example/bingwahybrid/domain/devices/model/Device;", "myDevices", "getMyDevices", "offerDevice", "getOfferDevice", "onSiteNameChanged", "", "name", "onAccountNumberChanged", "acc", "onAccountTypeChanged", "onUsernameChanged", HintConstants.AUTOFILL_HINT_NEW_USERNAME, "fetchSiteLinkOffers", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchMySiteLink", "loadAllSiteLinkData", "onSiteLinkActiveStatusChanged", "newStatus", "checkUsernameAvailability", "getAndFillSiteLinkDetails", "requestSiteLink", "updateSiteLink", "deleteSiteLink", "removeSiteLinkOffer", "offer", "loadDevices", "updateOfferProcessingDevice", "offerId", "device", "resetSnackBarMessage", "resetDeleteSuccess", "resetUpdateSuccess", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SiteLinkViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _accountNumber;
    private final MutableStateFlow<SiteLinkAccountType> _accountType;
    private final MutableStateFlow<Boolean> _deleteSuccess;
    private final MutableStateFlow<Map<UUID, Boolean>> _deviceSelectionLoadingStates;
    private final MutableStateFlow<String> _errorMessage;
    private final MutableStateFlow<Boolean> _isCheckingUsername;
    private final MutableStateFlow<Boolean> _isDeleting;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<Boolean> _isSiteLinkActive;
    private final MutableStateFlow<Boolean> _isSiteLinkLoading;
    private final MutableStateFlow<Boolean> _isUsernameAvailable;
    private final MutableStateFlow<Map<UUID, Boolean>> _loadingStates;
    private final MutableStateFlow<List<Device>> _myDevices;
    private final MutableStateFlow<SiteLink> _mySiteLink;
    private final MutableStateFlow<List<Offer>> _onlineOffers;
    private final MutableStateFlow<Boolean> _siteLinkGenerationSuccess;
    private final MutableStateFlow<Boolean> _siteLinkUpdateSuccess;
    private final MutableStateFlow<String> _siteName;
    private final MutableStateFlow<String> _successMessage;
    private final MutableStateFlow<String> _username;
    private final StateFlow<String> accountNumber;
    private final StateFlow<SiteLinkAccountType> accountType;
    private final ActivateSiteLinkUseCase activateSiteLinkUseCase;
    private final DeleteSiteLinkOfferUseCase deleteSiteLinkOfferUseCase;
    private final DeleteSiteLinkUseCase deleteSiteLinkUseCase;
    private final StateFlow<Boolean> deleteSuccess;
    private final DeviceRepository deviceRepository;
    private final StateFlow<Map<UUID, Boolean>> deviceSelectionLoadingStates;
    private final StateFlow<String> errorMessage;
    private final GetSiteLinkUseCase getSiteLinkUseCase;
    private final StateFlow<Boolean> isCheckingUsername;
    private final StateFlow<Boolean> isDeleting;
    private final StateFlow<Boolean> isLoading;
    private final StateFlow<Boolean> isSiteLinkActive;
    private final StateFlow<Boolean> isSiteLinkLoading;
    private final StateFlow<Boolean> isUsernameAvailable;
    private final StateFlow<Map<UUID, Boolean>> loadingStates;
    private final StateFlow<List<Device>> myDevices;
    private final StateFlow<SiteLink> mySiteLink;
    private final StateFlow<Map<UUID, Device>> offerDevice;
    private final OfferRepository offerRepository;
    private final StateFlow<List<Offer>> onlineOffers;
    private final RequestSiteLinkUseCase requestSiteLinkUseCase;
    private final StateFlow<Boolean> siteLinkGenerationSuccess;
    private final SiteLinkRepository siteLinkRepository;
    private final StateFlow<String> siteName;
    private final StateFlow<String> successMessage;
    private final UpdateSiteLinkUseCase updateSiteLinkUseCase;
    private final StateFlow<Boolean> updateSuccess;
    private final StateFlow<String> username;
    private Job usernameCheckJob;

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$fetchMySiteLink$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SiteLinkViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel", f = "SiteLinkViewModel.kt", i = {}, l = {160}, m = "fetchMySiteLink", n = {}, s = {})
    static final class C07331 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07331(Continuation<? super C07331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SiteLinkViewModel.this.fetchMySiteLink(this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$fetchSiteLinkOffers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SiteLinkViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel", f = "SiteLinkViewModel.kt", i = {}, l = {151}, m = "fetchSiteLinkOffers", n = {}, s = {})
    static final class C07341 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07341(Continuation<? super C07341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SiteLinkViewModel.this.fetchSiteLinkOffers(this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$loadDevices$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SiteLinkViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel", f = "SiteLinkViewModel.kt", i = {}, l = {418}, m = "loadDevices", n = {}, s = {})
    static final class C07371 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07371(Continuation<? super C07371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SiteLinkViewModel.this.loadDevices(this);
        }
    }

    @Inject
    public SiteLinkViewModel(GetSiteLinkUseCase getSiteLinkUseCase, RequestSiteLinkUseCase requestSiteLinkUseCase, OfferRepository offerRepository, DeleteSiteLinkOfferUseCase deleteSiteLinkOfferUseCase, ActivateSiteLinkUseCase activateSiteLinkUseCase, UpdateSiteLinkUseCase updateSiteLinkUseCase, DeleteSiteLinkUseCase deleteSiteLinkUseCase, SiteLinkRepository siteLinkRepository, DeviceRepository deviceRepository) {
        Intrinsics.checkNotNullParameter(getSiteLinkUseCase, "getSiteLinkUseCase");
        Intrinsics.checkNotNullParameter(requestSiteLinkUseCase, "requestSiteLinkUseCase");
        Intrinsics.checkNotNullParameter(offerRepository, "offerRepository");
        Intrinsics.checkNotNullParameter(deleteSiteLinkOfferUseCase, "deleteSiteLinkOfferUseCase");
        Intrinsics.checkNotNullParameter(activateSiteLinkUseCase, "activateSiteLinkUseCase");
        Intrinsics.checkNotNullParameter(updateSiteLinkUseCase, "updateSiteLinkUseCase");
        Intrinsics.checkNotNullParameter(deleteSiteLinkUseCase, "deleteSiteLinkUseCase");
        Intrinsics.checkNotNullParameter(siteLinkRepository, "siteLinkRepository");
        Intrinsics.checkNotNullParameter(deviceRepository, "deviceRepository");
        this.getSiteLinkUseCase = getSiteLinkUseCase;
        this.requestSiteLinkUseCase = requestSiteLinkUseCase;
        this.offerRepository = offerRepository;
        this.deleteSiteLinkOfferUseCase = deleteSiteLinkOfferUseCase;
        this.activateSiteLinkUseCase = activateSiteLinkUseCase;
        this.updateSiteLinkUseCase = updateSiteLinkUseCase;
        this.deleteSiteLinkUseCase = deleteSiteLinkUseCase;
        this.siteLinkRepository = siteLinkRepository;
        this.deviceRepository = deviceRepository;
        MutableStateFlow<List<Offer>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._onlineOffers = MutableStateFlow;
        StateFlow<List<Offer>> stateFlowAsStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.onlineOffers = stateFlowAsStateFlow;
        MutableStateFlow<SiteLink> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._mySiteLink = MutableStateFlow2;
        this.mySiteLink = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._isSiteLinkLoading = MutableStateFlow3;
        this.isSiteLinkLoading = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow4;
        this.isLoading = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<Map<UUID, Boolean>> MutableStateFlow5 = StateFlowKt.MutableStateFlow(new LinkedHashMap());
        this._loadingStates = MutableStateFlow5;
        this.loadingStates = MutableStateFlow5;
        MutableStateFlow<Boolean> MutableStateFlow6 = StateFlowKt.MutableStateFlow(false);
        this._siteLinkGenerationSuccess = MutableStateFlow6;
        this.siteLinkGenerationSuccess = FlowKt.asStateFlow(MutableStateFlow6);
        MutableStateFlow<Boolean> MutableStateFlow7 = StateFlowKt.MutableStateFlow(false);
        this._siteLinkUpdateSuccess = MutableStateFlow7;
        this.updateSuccess = FlowKt.asStateFlow(MutableStateFlow7);
        MutableStateFlow<String> MutableStateFlow8 = StateFlowKt.MutableStateFlow(null);
        this._errorMessage = MutableStateFlow8;
        this.errorMessage = FlowKt.asStateFlow(MutableStateFlow8);
        MutableStateFlow<String> MutableStateFlow9 = StateFlowKt.MutableStateFlow(null);
        this._successMessage = MutableStateFlow9;
        this.successMessage = FlowKt.asStateFlow(MutableStateFlow9);
        MutableStateFlow<Boolean> MutableStateFlow10 = StateFlowKt.MutableStateFlow(false);
        this._isDeleting = MutableStateFlow10;
        this.isDeleting = FlowKt.asStateFlow(MutableStateFlow10);
        MutableStateFlow<Boolean> MutableStateFlow11 = StateFlowKt.MutableStateFlow(false);
        this._deleteSuccess = MutableStateFlow11;
        this.deleteSuccess = FlowKt.asStateFlow(MutableStateFlow11);
        MutableStateFlow<String> MutableStateFlow12 = StateFlowKt.MutableStateFlow("");
        this._siteName = MutableStateFlow12;
        this.siteName = FlowKt.asStateFlow(MutableStateFlow12);
        MutableStateFlow<String> MutableStateFlow13 = StateFlowKt.MutableStateFlow("");
        this._accountNumber = MutableStateFlow13;
        this.accountNumber = FlowKt.asStateFlow(MutableStateFlow13);
        MutableStateFlow<SiteLinkAccountType> MutableStateFlow14 = StateFlowKt.MutableStateFlow(SiteLinkAccountType.MPESA);
        this._accountType = MutableStateFlow14;
        this.accountType = FlowKt.asStateFlow(MutableStateFlow14);
        MutableStateFlow<Boolean> MutableStateFlow15 = StateFlowKt.MutableStateFlow(false);
        this._isSiteLinkActive = MutableStateFlow15;
        this.isSiteLinkActive = FlowKt.asStateFlow(MutableStateFlow15);
        MutableStateFlow<String> MutableStateFlow16 = StateFlowKt.MutableStateFlow("");
        this._username = MutableStateFlow16;
        this.username = FlowKt.asStateFlow(MutableStateFlow16);
        MutableStateFlow<Boolean> MutableStateFlow17 = StateFlowKt.MutableStateFlow(null);
        this._isUsernameAvailable = MutableStateFlow17;
        this.isUsernameAvailable = FlowKt.asStateFlow(MutableStateFlow17);
        MutableStateFlow<Boolean> MutableStateFlow18 = StateFlowKt.MutableStateFlow(false);
        this._isCheckingUsername = MutableStateFlow18;
        this.isCheckingUsername = FlowKt.asStateFlow(MutableStateFlow18);
        MutableStateFlow<Map<UUID, Boolean>> MutableStateFlow19 = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this._deviceSelectionLoadingStates = MutableStateFlow19;
        this.deviceSelectionLoadingStates = FlowKt.asStateFlow(MutableStateFlow19);
        MutableStateFlow<List<Device>> MutableStateFlow20 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._myDevices = MutableStateFlow20;
        StateFlow<List<Device>> stateFlowAsStateFlow2 = FlowKt.asStateFlow(MutableStateFlow20);
        this.myDevices = stateFlowAsStateFlow2;
        this.offerDevice = FlowKt.stateIn(FlowKt.combine(stateFlowAsStateFlow, stateFlowAsStateFlow2, new SiteLinkViewModel$offerDevice$1(null)), ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getLazily(), MapsKt.emptyMap());
    }

    public final StateFlow<List<Offer>> getOnlineOffers() {
        return this.onlineOffers;
    }

    public final StateFlow<SiteLink> getMySiteLink() {
        return this.mySiteLink;
    }

    public final StateFlow<Boolean> isSiteLinkLoading() {
        return this.isSiteLinkLoading;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final StateFlow<Map<UUID, Boolean>> getLoadingStates() {
        return this.loadingStates;
    }

    public final StateFlow<Boolean> getSiteLinkGenerationSuccess() {
        return this.siteLinkGenerationSuccess;
    }

    public final StateFlow<Boolean> getUpdateSuccess() {
        return this.updateSuccess;
    }

    public final StateFlow<String> getErrorMessage() {
        return this.errorMessage;
    }

    public final StateFlow<String> getSuccessMessage() {
        return this.successMessage;
    }

    public final StateFlow<Boolean> isDeleting() {
        return this.isDeleting;
    }

    public final StateFlow<Boolean> getDeleteSuccess() {
        return this.deleteSuccess;
    }

    public final StateFlow<String> getSiteName() {
        return this.siteName;
    }

    public final StateFlow<String> getAccountNumber() {
        return this.accountNumber;
    }

    public final StateFlow<SiteLinkAccountType> getAccountType() {
        return this.accountType;
    }

    public final StateFlow<Boolean> isSiteLinkActive() {
        return this.isSiteLinkActive;
    }

    public final StateFlow<String> getUsername() {
        return this.username;
    }

    public final StateFlow<Boolean> isUsernameAvailable() {
        return this.isUsernameAvailable;
    }

    public final StateFlow<Boolean> isCheckingUsername() {
        return this.isCheckingUsername;
    }

    public final StateFlow<Map<UUID, Boolean>> getDeviceSelectionLoadingStates() {
        return this.deviceSelectionLoadingStates;
    }

    public final StateFlow<List<Device>> getMyDevices() {
        return this.myDevices;
    }

    public final StateFlow<Map<UUID, Device>> getOfferDevice() {
        return this.offerDevice;
    }

    public final void onSiteNameChanged(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this._siteName.setValue(name);
    }

    public final void onAccountNumberChanged(String acc) {
        Intrinsics.checkNotNullParameter(acc, "acc");
        this._accountNumber.setValue(acc);
    }

    public final void onAccountTypeChanged(SiteLinkAccountType acc) {
        Intrinsics.checkNotNullParameter(acc, "acc");
        this._accountType.setValue(acc);
    }

    public final void onUsernameChanged(String newUsername) {
        Intrinsics.checkNotNullParameter(newUsername, "newUsername");
        this._username.setValue(newUsername);
        checkUsernameAvailability();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchSiteLinkOffers(Continuation<? super Unit> continuation) {
        C07341 c07341;
        if (continuation instanceof C07341) {
            c07341 = (C07341) continuation;
            if ((c07341.label & Integer.MIN_VALUE) != 0) {
                c07341.label -= Integer.MIN_VALUE;
            } else {
                c07341 = new C07341(continuation);
            }
        } else {
            c07341 = new C07341(continuation);
        }
        Object remoteOffers = c07341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07341.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(remoteOffers);
                OfferRepository offerRepository = this.offerRepository;
                c07341.label = 1;
                remoteOffers = offerRepository.getRemoteOffers("sitelink", c07341);
                if (remoteOffers == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(remoteOffers);
            }
            this._onlineOffers.setValue((List) remoteOffers);
        } catch (Exception e) {
            this._errorMessage.setValue(e.getMessage());
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchMySiteLink(Continuation<? super Boolean> continuation) {
        C07331 c07331;
        if (continuation instanceof C07331) {
            c07331 = (C07331) continuation;
            if ((c07331.label & Integer.MIN_VALUE) != 0) {
                c07331.label -= Integer.MIN_VALUE;
            } else {
                c07331 = new C07331(continuation);
            }
        } else {
            c07331 = new C07331(continuation);
        }
        Object objInvoke = c07331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07331.label;
        boolean z = false;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objInvoke);
                GetSiteLinkUseCase getSiteLinkUseCase = this.getSiteLinkUseCase;
                c07331.label = 1;
                objInvoke = getSiteLinkUseCase.invoke(c07331);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objInvoke);
            }
            SiteLink siteLink = (SiteLink) objInvoke;
            this._mySiteLink.setValue(siteLink);
            this._isSiteLinkActive.setValue(Boxing.boxBoolean(siteLink != null ? siteLink.isActive() : false));
            z = true;
        } catch (Exception e) {
            this._errorMessage.setValue(e.getMessage());
            this._mySiteLink.setValue(null);
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$loadAllSiteLinkData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SiteLinkViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$loadAllSiteLinkData$1", f = "SiteLinkViewModel.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
    static final class C07361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07361(Continuation<? super C07361> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SiteLinkViewModel.this.new C07361(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v5, types: [kotlinx.coroutines.flow.MutableStateFlow] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SiteLinkViewModel.this._isSiteLinkLoading.setValue(Boxing.boxBoolean(true));
                    this.label = 1;
                    if (SupervisorKt.supervisorScope(new C01371(SiteLinkViewModel.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                SiteLinkViewModel.this._errorMessage.setValue(e.getMessage());
            } finally {
                SiteLinkViewModel.this._isSiteLinkLoading.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$loadAllSiteLinkData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SiteLinkViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$loadAllSiteLinkData$1$1", f = "SiteLinkViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SiteLinkViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01371(SiteLinkViewModel siteLinkViewModel, Continuation<? super C01371> continuation) {
                super(2, continuation);
                this.this$0 = siteLinkViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01371 c01371 = new C01371(this.this$0, continuation);
                c01371.L$0 = obj;
                return c01371;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
                return ((C01371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$loadAllSiteLinkData$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SiteLinkViewModel.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$loadAllSiteLinkData$1$1$1", f = "SiteLinkViewModel.kt", i = {0, 0, 0}, l = {177}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-SiteLinkViewModel$loadAllSiteLinkData$1$1$1$1"}, s = {"L$0", "L$1", "I$0"})
            static final class C01381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int I$0;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;
                final /* synthetic */ SiteLinkViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01381(SiteLinkViewModel siteLinkViewModel, Continuation<? super C01381> continuation) {
                    super(2, continuation);
                    this.this$0 = siteLinkViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01381 c01381 = new C01381(this.this$0, continuation);
                    c01381.L$0 = obj;
                    return c01381;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            SiteLinkViewModel siteLinkViewModel = this.this$0;
                            Result.Companion companion = Result.INSTANCE;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.I$0 = 0;
                            this.label = 1;
                            obj = siteLinkViewModel.fetchMySiteLink(this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Result.m10476constructorimpl(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.m10476constructorimpl(ResultKt.createFailure(th));
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new C01381(this.this$0, null), 2, null);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new AnonymousClass2(this.this$0, null), 2, null);
                    return BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new AnonymousClass3(this.this$0, null), 2, null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$loadAllSiteLinkData$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: SiteLinkViewModel.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$loadAllSiteLinkData$1$1$2", f = "SiteLinkViewModel.kt", i = {0, 0, 0}, l = {181}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-SiteLinkViewModel$loadAllSiteLinkData$1$1$2$1"}, s = {"L$0", "L$1", "I$0"})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int I$0;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;
                final /* synthetic */ SiteLinkViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(SiteLinkViewModel siteLinkViewModel, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = siteLinkViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            SiteLinkViewModel siteLinkViewModel = this.this$0;
                            Result.Companion companion = Result.INSTANCE;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.I$0 = 0;
                            this.label = 1;
                            if (siteLinkViewModel.fetchSiteLinkOffers(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Result.m10476constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.m10476constructorimpl(ResultKt.createFailure(th));
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$loadAllSiteLinkData$1$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: SiteLinkViewModel.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$loadAllSiteLinkData$1$1$3", f = "SiteLinkViewModel.kt", i = {0, 0, 0}, l = {185}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-SiteLinkViewModel$loadAllSiteLinkData$1$1$3$1"}, s = {"L$0", "L$1", "I$0"})
            static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int I$0;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;
                final /* synthetic */ SiteLinkViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(SiteLinkViewModel siteLinkViewModel, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.this$0 = siteLinkViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            SiteLinkViewModel siteLinkViewModel = this.this$0;
                            Result.Companion companion = Result.INSTANCE;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.I$0 = 0;
                            this.label = 1;
                            if (siteLinkViewModel.loadDevices(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Result.m10476constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.m10476constructorimpl(ResultKt.createFailure(th));
                    }
                    return Unit.INSTANCE;
                }
            }
        }
    }

    public final void loadAllSiteLinkData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07361(null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$onSiteLinkActiveStatusChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SiteLinkViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$onSiteLinkActiveStatusChanged$1", f = "SiteLinkViewModel.kt", i = {0}, l = {204}, m = "invokeSuspend", n = {"currentSiteLink"}, s = {"L$0"})
    static final class C07381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $newStatus;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07381(boolean z, Continuation<? super C07381> continuation) {
            super(2, continuation);
            this.$newStatus = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SiteLinkViewModel.this.new C07381(this.$newStatus, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SiteLinkViewModel.this._isLoading.setValue(Boxing.boxBoolean(true));
                    SiteLink value = SiteLinkViewModel.this.getMySiteLink().getValue();
                    if (value != null) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(value);
                        this.label = 1;
                        if (SiteLinkViewModel.this.activateSiteLinkUseCase.invoke(value, this.$newStatus, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw new Exception("No SiteLink found");
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                SiteLinkViewModel.this._isSiteLinkActive.setValue(Boxing.boxBoolean(this.$newStatus));
            } catch (Exception e) {
                SiteLinkViewModel.this._errorMessage.setValue(e.getMessage());
            } finally {
                SiteLinkViewModel.this._isLoading.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
    }

    public final void onSiteLinkActiveStatusChanged(boolean newStatus) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07381(newStatus, null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$checkUsernameAvailability$1, reason: invalid class name */
    /* JADX INFO: compiled from: SiteLinkViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$checkUsernameAvailability$1", f = "SiteLinkViewModel.kt", i = {0, 1, 1, 1}, l = {223, 227}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-SiteLinkViewModel$checkUsernameAvailability$1$1"}, s = {"L$0", "L$0", "L$1", "I$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = SiteLinkViewModel.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
        
            if (r10 == r1) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objM10476constructorimpl;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (SiteLinkViewModel.this.getUsername().getValue().length() < 3) {
                        SiteLinkViewModel.this._isUsernameAvailable.setValue(null);
                        return Unit.INSTANCE;
                    }
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    if (DelayKt.delay(500L, this) != coroutine_suspended) {
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
                objM10476constructorimpl = Result.m10476constructorimpl(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
                SiteLinkViewModel siteLinkViewModel = SiteLinkViewModel.this;
                if (Result.m10483isSuccessimpl(objM10476constructorimpl)) {
                    siteLinkViewModel._isUsernameAvailable.setValue(Boxing.boxBoolean(((Boolean) objM10476constructorimpl).booleanValue()));
                }
                SiteLinkViewModel siteLinkViewModel2 = SiteLinkViewModel.this;
                Throwable thM10479exceptionOrNullimpl = Result.m10479exceptionOrNullimpl(objM10476constructorimpl);
                if (thM10479exceptionOrNullimpl != null) {
                    if (!(thM10479exceptionOrNullimpl instanceof CancellationException)) {
                        siteLinkViewModel2._errorMessage.setValue(thM10479exceptionOrNullimpl.getMessage());
                        siteLinkViewModel2._isUsernameAvailable.setValue(null);
                    }
                    if (thM10479exceptionOrNullimpl instanceof UnknownHostException) {
                        siteLinkViewModel2._errorMessage.setValue("No internet connection");
                    }
                }
                SiteLinkViewModel.this._isCheckingUsername.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
                SiteLinkViewModel.this._isCheckingUsername.setValue(Boxing.boxBoolean(true));
                SiteLinkViewModel siteLinkViewModel3 = SiteLinkViewModel.this;
                Result.Companion companion = Result.INSTANCE;
                SiteLinkRepository siteLinkRepository = siteLinkViewModel3.siteLinkRepository;
                String value = siteLinkViewModel3.getUsername().getValue();
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.I$0 = 0;
                this.label = 2;
                obj = siteLinkRepository.checkUsernameAvailability(value, this);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM10476constructorimpl = Result.m10476constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    private final void checkUsernameAvailability() {
        Job job = this.usernameCheckJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.usernameCheckJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$getAndFillSiteLinkDetails$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SiteLinkViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$getAndFillSiteLinkDetails$1", f = "SiteLinkViewModel.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
    static final class C07351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07351(Continuation<? super C07351> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SiteLinkViewModel.this.new C07351(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x009e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SiteLink value;
            String username;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SiteLinkViewModel.this._isSiteLinkLoading.setValue(Boxing.boxBoolean(true));
                    value = SiteLinkViewModel.this.getMySiteLink().getValue();
                    if (value == null) {
                        this.label = 1;
                        obj = SiteLinkViewModel.this.siteLinkRepository.getMySiteLink(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    SiteLinkViewModel.this._mySiteLink.setValue(value);
                    SiteLinkViewModel.this._siteName.setValue(value.getSiteName());
                    SiteLinkViewModel.this._accountNumber.setValue(value.getAccountNumber());
                    SiteLinkViewModel.this._accountType.setValue(value.getAccountType());
                    MutableStateFlow mutableStateFlow = SiteLinkViewModel.this._username;
                    username = value.getUsername();
                    if (username == null) {
                        username = "";
                    }
                    mutableStateFlow.setValue(username);
                    SiteLinkViewModel.this._isSiteLinkActive.setValue(Boxing.boxBoolean(value.isActive()));
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                value = (SiteLink) obj;
                if (value == null) {
                    Unit unit = Unit.INSTANCE;
                    SiteLinkViewModel.this._isSiteLinkLoading.setValue(Boxing.boxBoolean(false));
                    return unit;
                }
                SiteLinkViewModel.this._mySiteLink.setValue(value);
                SiteLinkViewModel.this._siteName.setValue(value.getSiteName());
                SiteLinkViewModel.this._accountNumber.setValue(value.getAccountNumber());
                SiteLinkViewModel.this._accountType.setValue(value.getAccountType());
                MutableStateFlow mutableStateFlow2 = SiteLinkViewModel.this._username;
                username = value.getUsername();
                if (username == null) {
                    username = "";
                }
                mutableStateFlow2.setValue(username);
                SiteLinkViewModel.this._isSiteLinkActive.setValue(Boxing.boxBoolean(value.isActive()));
            } catch (Exception e) {
                MutableStateFlow mutableStateFlow3 = SiteLinkViewModel.this._errorMessage;
                String message = e.getMessage();
                if (message == null) {
                    message = "Failed to load SiteLink details";
                }
                mutableStateFlow3.setValue(message);
            } finally {
                SiteLinkViewModel.this._isSiteLinkLoading.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
    }

    public final void getAndFillSiteLinkDetails() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07351(null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$requestSiteLink$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SiteLinkViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$requestSiteLink$1", f = "SiteLinkViewModel.kt", i = {0, 0, 0, 0}, l = {297}, m = "invokeSuspend", n = {"siteName", "accountNumber", "isTill", "isMpesa"}, s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C07401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        C07401(Continuation<? super C07401> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SiteLinkViewModel.this.new C07401(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SiteLinkViewModel.this._isLoading.setValue(Boxing.boxBoolean(true));
                    String str = (String) SiteLinkViewModel.this._siteName.getValue();
                    String str2 = (String) SiteLinkViewModel.this._accountNumber.getValue();
                    int i2 = SiteLinkViewModel.this.getAccountType().getValue() == SiteLinkAccountType.TILL ? 1 : 0;
                    int i3 = SiteLinkViewModel.this.getAccountType().getValue() == SiteLinkAccountType.MPESA ? 1 : 0;
                    if (str.length() == 0) {
                        throw new Exception("Site Name cannot be empty");
                    }
                    if (str.length() <= 3) {
                        throw new Exception("Site Name too short");
                    }
                    if (str2.length() == 0) {
                        if (i2 != 0) {
                            throw new Exception("Till Number cannot be empty");
                        }
                        throw new Exception("M-Pesa Number cannot be empty");
                    }
                    if (i3 != 0 && str2.length() < 10) {
                        throw new Exception("M-Pesa number too short");
                    }
                    if (i3 != 0 && str2.length() > 14) {
                        throw new Exception("M-Pesa Number too long");
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                    this.I$0 = i2;
                    this.I$1 = i3;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getIO(), new C01391(SiteLinkViewModel.this, str, str2, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                SiteLinkViewModel.this._siteLinkGenerationSuccess.setValue(Boxing.boxBoolean(true));
                SiteLinkViewModel.this._successMessage.setValue("SiteLink generated successfully");
            } catch (Exception e) {
                SiteLinkViewModel.this._siteLinkGenerationSuccess.setValue(Boxing.boxBoolean(false));
                SiteLinkViewModel.this._errorMessage.setValue(e.getMessage());
            } finally {
                SiteLinkViewModel.this._isLoading.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$requestSiteLink$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SiteLinkViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$requestSiteLink$1$1", f = "SiteLinkViewModel.kt", i = {}, l = {298}, m = "invokeSuspend", n = {}, s = {})
        static final class C01391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $accountNumber;
            final /* synthetic */ String $siteName;
            int label;
            final /* synthetic */ SiteLinkViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01391(SiteLinkViewModel siteLinkViewModel, String str, String str2, Continuation<? super C01391> continuation) {
                super(2, continuation);
                this.this$0 = siteLinkViewModel;
                this.$siteName = str;
                this.$accountNumber = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01391(this.this$0, this.$siteName, this.$accountNumber, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.this$0.requestSiteLinkUseCase.invoke(this.$siteName, this.$accountNumber, this.this$0.getAccountType().getValue(), (String) this.this$0._username.getValue(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }

    public final void requestSiteLink() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07401(null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$updateSiteLink$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SiteLinkViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$updateSiteLink$1", f = "SiteLinkViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {365}, m = "invokeSuspend", n = {"siteName", "accountNumber", HintConstants.AUTOFILL_HINT_USERNAME, "siteLink", "updatedSiteLink", "isTill", "isMpesa"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"})
    static final class C07421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        C07421(Continuation<? super C07421> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SiteLinkViewModel.this.new C07421(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            boolean z;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            SiteLinkViewModel.this._isLoading.setValue(Boxing.boxBoolean(true));
                            String str = (String) SiteLinkViewModel.this._siteName.getValue();
                            String str2 = (String) SiteLinkViewModel.this._accountNumber.getValue();
                            String str3 = (String) SiteLinkViewModel.this._username.getValue();
                            int i2 = SiteLinkViewModel.this.getAccountType().getValue() == SiteLinkAccountType.TILL ? 1 : 0;
                            int i3 = SiteLinkViewModel.this.getAccountType().getValue() == SiteLinkAccountType.MPESA ? 1 : 0;
                            if (str.length() == 0) {
                                throw new Exception("Site Name cannot be empty");
                            }
                            if (str.length() <= 3) {
                                throw new Exception("Site Name too short");
                            }
                            if (str2.length() == 0) {
                                if (i2 != 0) {
                                    throw new Exception("Till Number cannot be empty");
                                }
                                throw new Exception("M-Pesa Number cannot be empty");
                            }
                            if (i3 != 0 && str2.length() < 10) {
                                throw new Exception("M-Pesa number too short");
                            }
                            if (i3 != 0 && str2.length() > 14) {
                                throw new Exception("M-Pesa Number too long");
                            }
                            if (str3.length() > 0 && str3.length() < 3) {
                                throw new Exception("Username must be at least 3 characters");
                            }
                            SiteLink value = SiteLinkViewModel.this.getMySiteLink().getValue();
                            if (value == null) {
                                throw new Exception("You don't seem to have a SiteLink. Please create one then try again");
                            }
                            SiteLinkAccountType value2 = SiteLinkViewModel.this.getAccountType().getValue();
                            String username = str3.length() > 0 ? str3 : null;
                            if (username == null) {
                                username = value.getUsername();
                            }
                            String str4 = username;
                            int i4 = i3;
                            z = false;
                            SiteLink siteLinkCopy$default = SiteLink.copy$default(value, null, str, null, value2, str2, false, str4, 37, null);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(str3);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(value);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(siteLinkCopy$default);
                            this.I$0 = i2;
                            this.I$1 = i4;
                            this.label = 1;
                            if (SiteLinkViewModel.this.updateSiteLinkUseCase.invoke(siteLinkCopy$default, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            z = false;
                        }
                        SiteLinkViewModel.this._siteLinkUpdateSuccess.setValue(Boxing.boxBoolean(true));
                        SiteLinkViewModel.this._successMessage.setValue("SiteLink updated successfully");
                    } catch (Throwable th) {
                        th = th;
                        SiteLinkViewModel.this._isLoading.setValue(Boxing.boxBoolean(false));
                        throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    SiteLinkViewModel.this._siteLinkUpdateSuccess.setValue(Boxing.boxBoolean(false));
                    SiteLinkViewModel.this._errorMessage.setValue(e.getMessage());
                }
            } catch (Exception e2) {
                e = e2;
                z = false;
                SiteLinkViewModel.this._siteLinkUpdateSuccess.setValue(Boxing.boxBoolean(false));
                SiteLinkViewModel.this._errorMessage.setValue(e.getMessage());
            } catch (Throwable th2) {
                th = th2;
                SiteLinkViewModel.this._isLoading.setValue(Boxing.boxBoolean(false));
                throw th;
            }
            SiteLinkViewModel.this._isLoading.setValue(Boxing.boxBoolean(z));
            return Unit.INSTANCE;
        }
    }

    public final void updateSiteLink() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07421(null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$deleteSiteLink$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SiteLinkViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$deleteSiteLink$1", f = "SiteLinkViewModel.kt", i = {0}, l = {383}, m = "invokeSuspend", n = {"currentSiteLink"}, s = {"L$0"})
    static final class C07321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C07321(Continuation<? super C07321> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SiteLinkViewModel.this.new C07321(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SiteLinkViewModel.this._isDeleting.setValue(Boxing.boxBoolean(true));
                    SiteLink value = SiteLinkViewModel.this.getMySiteLink().getValue();
                    if (value != null) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(value);
                        this.label = 1;
                        if (SiteLinkViewModel.this.deleteSiteLinkUseCase.invoke(value, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw new Exception("No SiteLink found to delete.");
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                SiteLinkViewModel.this._deleteSuccess.setValue(Boxing.boxBoolean(true));
                SiteLinkViewModel.this._successMessage.setValue("SiteLink deleted successfully");
            } catch (Exception e) {
                SiteLinkViewModel.this._deleteSuccess.setValue(Boxing.boxBoolean(false));
                MutableStateFlow mutableStateFlow = SiteLinkViewModel.this._errorMessage;
                String message = e.getMessage();
                if (message == null) {
                    message = "Failed to delete SiteLink";
                }
                mutableStateFlow.setValue(message);
            } finally {
                SiteLinkViewModel.this._isDeleting.setValue(Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
    }

    public final void deleteSiteLink() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07321(null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$removeSiteLinkOffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SiteLinkViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$removeSiteLinkOffer$1", f = "SiteLinkViewModel.kt", i = {}, l = {402, 403}, m = "invokeSuspend", n = {}, s = {})
    static final class C07391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Offer $offer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07391(Offer offer, Continuation<? super C07391> continuation) {
            super(2, continuation);
            this.$offer = offer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SiteLinkViewModel.this.new C07391(this.$offer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
        
            if (r7.this$0.fetchSiteLinkOffers(r7) == r0) goto L22;
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
                    SiteLinkViewModel.this._successMessage.setValue("Offer removed successfully");
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow = SiteLinkViewModel.this._loadingStates;
                Map mutableMap = MapsKt.toMutableMap((Map) SiteLinkViewModel.this._loadingStates.getValue());
                mutableMap.put(this.$offer.getId(), Boxing.boxBoolean(true));
                mutableStateFlow.setValue(mutableMap);
                this.label = 1;
                if (SiteLinkViewModel.this.deleteSiteLinkOfferUseCase.invoke(this.$offer, this) == coroutine_suspended) {
                }
                return coroutine_suspended;
                this.label = 2;
            } catch (Exception e) {
                SiteLinkViewModel.this._isLoading.setValue(Boxing.boxBoolean(false));
                SiteLinkViewModel.this._errorMessage.setValue(e.getMessage());
            } finally {
                MutableStateFlow mutableStateFlow2 = SiteLinkViewModel.this._loadingStates;
                Map mutableMap2 = MapsKt.toMutableMap((Map) SiteLinkViewModel.this._loadingStates.getValue());
                mutableMap2.put(this.$offer.getId(), Boxing.boxBoolean(false));
                mutableStateFlow2.setValue(mutableMap2);
            }
        }
    }

    public final void removeSiteLinkOffer(Offer offer) {
        Intrinsics.checkNotNullParameter(offer, "offer");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07391(offer, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object loadDevices(Continuation<? super Unit> continuation) throws Exception {
        C07371 c07371;
        if (continuation instanceof C07371) {
            c07371 = (C07371) continuation;
            if ((c07371.label & Integer.MIN_VALUE) != 0) {
                c07371.label -= Integer.MIN_VALUE;
            } else {
                c07371 = new C07371(continuation);
            }
        } else {
            c07371 = new C07371(continuation);
        }
        Object myDevices = c07371.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07371.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(myDevices);
                DeviceRepository deviceRepository = this.deviceRepository;
                c07371.label = 1;
                myDevices = deviceRepository.getMyDevices(c07371);
                if (myDevices == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(myDevices);
            }
            this._myDevices.setValue((List) myDevices);
        } catch (Exception e) {
            if (e instanceof UnknownHostException) {
                this._errorMessage.setValue("No internet connection");
            } else {
                if (e instanceof CancellationException) {
                    throw e;
                }
                MutableStateFlow<String> mutableStateFlow = this._errorMessage;
                String message = e.getMessage();
                if (message == null) {
                    message = "Failed to load devices";
                }
                mutableStateFlow.setValue(message);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$updateOfferProcessingDevice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SiteLinkViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$updateOfferProcessingDevice$1", f = "SiteLinkViewModel.kt", i = {}, l = {437, 438}, m = "invokeSuspend", n = {}, s = {})
    static final class C07411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Device $device;
        final /* synthetic */ UUID $offerId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07411(UUID uuid, Device device, Continuation<? super C07411> continuation) {
            super(2, continuation);
            this.$offerId = uuid;
            this.$device = device;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SiteLinkViewModel.this.new C07411(this.$offerId, this.$device, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
        
            if (r7.this$0.fetchSiteLinkOffers(r7) == r0) goto L26;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
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
                        MutableStateFlow mutableStateFlow = SiteLinkViewModel.this._deviceSelectionLoadingStates;
                        Map mutableMap = MapsKt.toMutableMap((Map) SiteLinkViewModel.this._deviceSelectionLoadingStates.getValue());
                        mutableMap.put(this.$offerId, Boxing.boxBoolean(false));
                        mutableStateFlow.setValue(mutableMap);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow mutableStateFlow2 = SiteLinkViewModel.this._deviceSelectionLoadingStates;
                    Map mutableMap2 = MapsKt.toMutableMap((Map) SiteLinkViewModel.this._deviceSelectionLoadingStates.getValue());
                    mutableMap2.put(this.$offerId, Boxing.boxBoolean(true));
                    mutableStateFlow2.setValue(mutableMap2);
                    SiteLinkRepository siteLinkRepository = SiteLinkViewModel.this.siteLinkRepository;
                    UUID uuid = this.$offerId;
                    Device device = this.$device;
                    String connectId = device != null ? device.getConnectId() : null;
                    this.label = 1;
                    if (siteLinkRepository.updateProcessingDevice(uuid, connectId, this) == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                    this.label = 2;
                } catch (Exception e) {
                    if (e instanceof UnknownHostException) {
                        SiteLinkViewModel.this._errorMessage.setValue("No internet connection");
                    } else {
                        if (e instanceof CancellationException) {
                            throw e;
                        }
                        MutableStateFlow mutableStateFlow3 = SiteLinkViewModel.this._errorMessage;
                        String message = e.getMessage();
                        if (message == null) {
                            message = "Failed to update relay device";
                        }
                        mutableStateFlow3.setValue(message);
                    }
                }
            } catch (Throwable th) {
                MutableStateFlow mutableStateFlow4 = SiteLinkViewModel.this._deviceSelectionLoadingStates;
                Map mutableMap3 = MapsKt.toMutableMap((Map) SiteLinkViewModel.this._deviceSelectionLoadingStates.getValue());
                mutableMap3.put(this.$offerId, Boxing.boxBoolean(false));
                mutableStateFlow4.setValue(mutableMap3);
                throw th;
            }
        }
    }

    public final void updateOfferProcessingDevice(UUID offerId, Device device) {
        Intrinsics.checkNotNullParameter(offerId, "offerId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07411(offerId, device, null), 2, null);
    }

    public final void resetSnackBarMessage() {
        this._errorMessage.setValue(null);
        this._successMessage.setValue(null);
    }

    public final void resetDeleteSuccess() {
        this._deleteSuccess.setValue(false);
    }

    public final void resetUpdateSuccess() {
        this._siteLinkUpdateSuccess.setValue(false);
    }
}
