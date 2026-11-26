package com.example.bingwahybrid.domain.engine.advanced;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.example.bingwahybrid.domain.devices.model.CurrentDevice;
import com.example.bingwahybrid.domain.devices.repository.CurrentDeviceRepository;
import com.example.bingwahybrid.domain.engine.utils.UssdUtils;
import com.example.bingwahybrid.domain.enums.ProcessingMode;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.enums.InputMode;
import com.example.bingwahybrid.domain.offers.enums.StepType;
import com.example.bingwahybrid.domain.offers.model.VerifiedOfferStep;
import com.example.bingwahybrid.domain.offers.utils.VerifiedOfferStepUtilsKt;
import com.example.bingwahybrid.domain.repository.AccessibilityRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.ussd.enums.StepAction;
import com.example.bingwahybrid.domain.ussd.enums.UssdSessionState;
import com.example.bingwahybrid.domain.ussd.repository.OfferSession;
import com.example.bingwahybrid.domain.ussd.repository.UssdSessionManager;
import com.example.bingwahybrid.domain.ussd.repository.UssdStepsRepository;
import com.example.bingwahybrid.domain.ussd.utils.OfferScanner;
import dagger.hilt.android.AndroidEntryPoint;
import io.ktor.http.ContentType;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: UssdAccessibilityService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\b\b\u0007\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u000203H\u0016J\u0016\u00107\u001a\b\u0012\u0004\u0012\u000209082\u0006\u00104\u001a\u000205H\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u00104\u001a\u000205H\u0002J\u0010\u0010<\u001a\u00020;2\u0006\u00104\u001a\u000205H\u0002J\u0010\u0010=\u001a\u00020;2\u0006\u00104\u001a\u000205H\u0002J\u0010\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020@H\u0002J\u0018\u0010A\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u000209H\u0002J\u0018\u0010C\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010D\u001a\u000209H\u0002J\u0010\u0010E\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\u0010\u0010F\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\b\u0010G\u001a\u000203H\u0002J\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020@082\u0006\u00104\u001a\u000205H\u0002J\u001e\u0010I\u001a\u0002032\f\u0010J\u001a\b\u0012\u0004\u0012\u00020@0K2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010L\u001a\u0002092\u0006\u00104\u001a\u000205H\u0002J\b\u0010M\u001a\u000203H\u0014J\u0010\u0010N\u001a\u0002032\u0006\u0010O\u001a\u000209H\u0002J\u0010\u0010P\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\b\u0010Q\u001a\u000203H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/advanced/UssdAccessibilityService;", "Landroid/accessibilityservice/AccessibilityService;", "<init>", "()V", "ussdStepsRepository", "Lcom/example/bingwahybrid/domain/ussd/repository/UssdStepsRepository;", "getUssdStepsRepository", "()Lcom/example/bingwahybrid/domain/ussd/repository/UssdStepsRepository;", "setUssdStepsRepository", "(Lcom/example/bingwahybrid/domain/ussd/repository/UssdStepsRepository;)V", "sessionManager", "Lcom/example/bingwahybrid/domain/ussd/repository/UssdSessionManager;", "getSessionManager", "()Lcom/example/bingwahybrid/domain/ussd/repository/UssdSessionManager;", "setSessionManager", "(Lcom/example/bingwahybrid/domain/ussd/repository/UssdSessionManager;)V", "accessibilityRepository", "Lcom/example/bingwahybrid/domain/repository/AccessibilityRepository;", "getAccessibilityRepository", "()Lcom/example/bingwahybrid/domain/repository/AccessibilityRepository;", "setAccessibilityRepository", "(Lcom/example/bingwahybrid/domain/repository/AccessibilityRepository;)V", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "getSettingsRepository", "()Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "setSettingsRepository", "(Lcom/example/bingwahybrid/domain/repository/SettingsRepository;)V", "currentDeviceRepository", "Lcom/example/bingwahybrid/domain/devices/repository/CurrentDeviceRepository;", "getCurrentDeviceRepository", "()Lcom/example/bingwahybrid/domain/devices/repository/CurrentDeviceRepository;", "setCurrentDeviceRepository", "(Lcom/example/bingwahybrid/domain/devices/repository/CurrentDeviceRepository;)V", "offerSession", "Lcom/example/bingwahybrid/domain/ussd/repository/OfferSession;", "getOfferSession", "()Lcom/example/bingwahybrid/domain/ussd/repository/OfferSession;", "setOfferSession", "(Lcom/example/bingwahybrid/domain/ussd/repository/OfferSession;)V", "offerScanner", "Lcom/example/bingwahybrid/domain/ussd/utils/OfferScanner;", "getOfferScanner", "()Lcom/example/bingwahybrid/domain/ussd/utils/OfferScanner;", "setOfferScanner", "(Lcom/example/bingwahybrid/domain/ussd/utils/OfferScanner;)V", "serviceJob", "Lkotlinx/coroutines/CompletableJob;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "onAccessibilityEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/accessibility/AccessibilityEvent;", "onInterrupt", "collectAllTexts", "", "", "isUSSDWidget", "", "isFinalDialog", "hasInputField", "isButton", "node", "Landroid/view/accessibility/AccessibilityNodeInfo;", "enterText", ContentType.Text.TYPE, "clickButton", "action", "clickFinalDialogButton", "dismissCurrentDialog", "dismissAllDialogs", "getNodes", "extractNodes", "nodes", "", "getFinalResponse", "onServiceConnected", "completeSession", "finalResponse", "completeSessionWithResponse", "onDestroy", "Companion", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class UssdAccessibilityService extends Hilt_UssdAccessibilityService {

    @Inject
    public AccessibilityRepository accessibilityRepository;

    @Inject
    public CurrentDeviceRepository currentDeviceRepository;

    @Inject
    public OfferScanner offerScanner;

    @Inject
    public OfferSession offerSession;
    private final CompletableJob serviceJob;
    private final CoroutineScope serviceScope;

    @Inject
    public UssdSessionManager sessionManager;

    @Inject
    public SettingsRepository settingsRepository;

    @Inject
    public UssdStepsRepository ussdStepsRepository;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Set<String> ALLOWED_DIALER_PACKAGES = SetsKt.setOf((Object[]) new String[]{"com.android.dialer", "com.google.android.dialer", "com.samsung.android.dialer", "com.android.phone", "com.android.incallui", "com.android.contacts", "com.motorola.dialer", "com.lge.dialer", "com.hb.dialer.free", "com.modoohut.dialer", "com.contapps.android.dialer", "com.truecaller", "com.truecaller.callerid.callername", "com.shsh.android.atakephone", "com.luz.contactdialer", "com.ivp.call.screen", "com.transsion.smartcaller", "com.artostolab.voicedialer", "com.revesoft.mobiledialer.plus2call.onyx"});
    private static final Set<String> SYSTEM_DIALOG_TEXTS = SetsKt.setOf((Object[]) new String[]{"Pop-up window", "Carrier info"});
    private static final List<String> BUTTON_TEXTS = CollectionsKt.listOf((Object[]) new String[]{"send", "ok", "close", "cancel", "back", "got it", "done"});

    /* JADX INFO: compiled from: UssdAccessibilityService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InputMode.values().length];
            try {
                iArr[InputMode.STATIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputMode.DYNAMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[StepType.values().length];
            try {
                iArr2[StepType.SELECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[StepType.INPUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }

    public UssdAccessibilityService() {
        CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.serviceJob = completableJobJob$default;
        this.serviceScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(completableJobJob$default));
    }

    public final UssdStepsRepository getUssdStepsRepository() {
        UssdStepsRepository ussdStepsRepository = this.ussdStepsRepository;
        if (ussdStepsRepository != null) {
            return ussdStepsRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ussdStepsRepository");
        return null;
    }

    public final void setUssdStepsRepository(UssdStepsRepository ussdStepsRepository) {
        Intrinsics.checkNotNullParameter(ussdStepsRepository, "<set-?>");
        this.ussdStepsRepository = ussdStepsRepository;
    }

    public final UssdSessionManager getSessionManager() {
        UssdSessionManager ussdSessionManager = this.sessionManager;
        if (ussdSessionManager != null) {
            return ussdSessionManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        return null;
    }

    public final void setSessionManager(UssdSessionManager ussdSessionManager) {
        Intrinsics.checkNotNullParameter(ussdSessionManager, "<set-?>");
        this.sessionManager = ussdSessionManager;
    }

    public final AccessibilityRepository getAccessibilityRepository() {
        AccessibilityRepository accessibilityRepository = this.accessibilityRepository;
        if (accessibilityRepository != null) {
            return accessibilityRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("accessibilityRepository");
        return null;
    }

    public final void setAccessibilityRepository(AccessibilityRepository accessibilityRepository) {
        Intrinsics.checkNotNullParameter(accessibilityRepository, "<set-?>");
        this.accessibilityRepository = accessibilityRepository;
    }

    public final SettingsRepository getSettingsRepository() {
        SettingsRepository settingsRepository = this.settingsRepository;
        if (settingsRepository != null) {
            return settingsRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("settingsRepository");
        return null;
    }

    public final void setSettingsRepository(SettingsRepository settingsRepository) {
        Intrinsics.checkNotNullParameter(settingsRepository, "<set-?>");
        this.settingsRepository = settingsRepository;
    }

    public final CurrentDeviceRepository getCurrentDeviceRepository() {
        CurrentDeviceRepository currentDeviceRepository = this.currentDeviceRepository;
        if (currentDeviceRepository != null) {
            return currentDeviceRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("currentDeviceRepository");
        return null;
    }

    public final void setCurrentDeviceRepository(CurrentDeviceRepository currentDeviceRepository) {
        Intrinsics.checkNotNullParameter(currentDeviceRepository, "<set-?>");
        this.currentDeviceRepository = currentDeviceRepository;
    }

    public final OfferSession getOfferSession() {
        OfferSession offerSession = this.offerSession;
        if (offerSession != null) {
            return offerSession;
        }
        Intrinsics.throwUninitializedPropertyAccessException("offerSession");
        return null;
    }

    public final void setOfferSession(OfferSession offerSession) {
        Intrinsics.checkNotNullParameter(offerSession, "<set-?>");
        this.offerSession = offerSession;
    }

    public final OfferScanner getOfferScanner() {
        OfferScanner offerScanner = this.offerScanner;
        if (offerScanner != null) {
            return offerScanner;
        }
        Intrinsics.throwUninitializedPropertyAccessException("offerScanner");
        return null;
    }

    public final void setOfferScanner(OfferScanner offerScanner) {
        Intrinsics.checkNotNullParameter(offerScanner, "<set-?>");
        this.offerScanner = offerScanner;
    }

    /* JADX INFO: compiled from: UssdAccessibilityService.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/advanced/UssdAccessibilityService$Companion;", "", "<init>", "()V", "ALLOWED_DIALER_PACKAGES", "", "", "getALLOWED_DIALER_PACKAGES", "()Ljava/util/Set;", "SYSTEM_DIALOG_TEXTS", "BUTTON_TEXTS", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getALLOWED_DIALER_PACKAGES() {
            return UssdAccessibilityService.ALLOWED_DIALER_PACKAGES;
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00dd  */
    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent event) {
        CharSequence packageName;
        String string;
        String inputValue;
        if (event != null && getSessionManager().isSessionActive() && (packageName = event.getPackageName()) != null && (string = packageName.toString()) != null && ALLOWED_DIALER_PACKAGES.contains(string) && getSettingsRepository().getProcessingMode().getValue() == ProcessingMode.ADVANCED) {
            CurrentDevice value = getCurrentDeviceRepository().getCurrentDevice().getValue();
            if (((value.isMIUI() || value.isXiaomi() || value.isEMUI()) && event.getEventType() != 32) || !isUSSDWidget(event)) {
                return;
            }
            if (hasInputField(event)) {
                if (getOfferSession().isActive()) {
                    VerifiedOfferStep verifiedOfferStepCurrentStep = getOfferSession().currentStep();
                    if (verifiedOfferStepCurrentStep == null || getOfferSession().isComplete()) {
                        String finalResponse = getFinalResponse(event);
                        dismissCurrentDialog(event);
                        completeSession(finalResponse);
                        return;
                    }
                    int i = WhenMappings.$EnumSwitchMapping$1[verifiedOfferStepCurrentStep.getType().ordinal()];
                    Pair pair = null;
                    if (i == 1) {
                        String strJoinToString$default = CollectionsKt.joinToString$default(collectAllTexts(event), "\n", null, null, 0, null, null, 62, null);
                        OfferScanner offerScanner = getOfferScanner();
                        String pattern = verifiedOfferStepCurrentStep.getPattern();
                        if (pattern == null) {
                            pattern = "";
                        }
                        StepAction stepActionFindAction = offerScanner.findAction(strJoinToString$default, pattern);
                        if (stepActionFindAction instanceof StepAction.TargetFound) {
                            pair = new Pair(((StepAction.TargetFound) stepActionFindAction).getIndex(), false);
                        } else if (stepActionFindAction instanceof StepAction.More) {
                            getOfferSession().incrementPagination();
                            pair = new Pair(((StepAction.More) stepActionFindAction).getIndex(), true);
                        } else if (stepActionFindAction != null) {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        if (i != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        InputMode inputMode = verifiedOfferStepCurrentStep.getInputMode();
                        int i2 = inputMode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[inputMode.ordinal()];
                        if (i2 == -1) {
                            inputValue = null;
                        } else if (i2 == 1) {
                            inputValue = verifiedOfferStepCurrentStep.getInputValue();
                        } else {
                            if (i2 != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            Transaction currentTransaction = getSessionManager().getCurrentTransaction();
                            if (currentTransaction != null) {
                                inputValue = VerifiedOfferStepUtilsKt.processDynamicInput(verifiedOfferStepCurrentStep, currentTransaction);
                            } else {
                                inputValue = null;
                            }
                        }
                        if (inputValue != null) {
                            pair = new Pair(inputValue, false);
                        }
                    }
                    if (pair != null) {
                        String str = (String) pair.component1();
                        boolean zBooleanValue = ((Boolean) pair.component2()).booleanValue();
                        if (str == null) {
                            completeSessionWithResponse(event);
                            return;
                        }
                        enterText(event, str);
                        clickButton(event, "SEND");
                        if (zBooleanValue) {
                            return;
                        }
                        getOfferSession().moveToNextStep();
                        return;
                    }
                    completeSessionWithResponse(event);
                    return;
                }
                if (getUssdStepsRepository().isEmpty()) {
                    String finalResponse2 = getFinalResponse(event);
                    dismissCurrentDialog(event);
                    completeSession(finalResponse2);
                    return;
                } else {
                    String strPollStep = getUssdStepsRepository().pollStep();
                    Intrinsics.checkNotNull(strPollStep);
                    enterText(event, strPollStep);
                    clickButton(event, "SEND");
                    return;
                }
            }
            if (isFinalDialog(event)) {
                String finalResponse3 = getFinalResponse(event);
                clickFinalDialogButton(event);
                completeSession(finalResponse3);
            }
        }
    }

    private final List<String> collectAllTexts(AccessibilityEvent event) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        List<CharSequence> text = event.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        List<CharSequence> list = text;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) ((CharSequence) it.next()).toString()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
        ArrayList arrayList4 = new ArrayList();
        if (rootInActiveWindow != null) {
            ArrayList<AccessibilityNodeInfo> arrayList5 = new ArrayList();
            extractNodes(arrayList5, rootInActiveWindow);
            for (AccessibilityNodeInfo accessibilityNodeInfo : arrayList5) {
                CharSequence text2 = accessibilityNodeInfo.getText();
                String string7 = (text2 == null || (string6 = text2.toString()) == null) ? null : StringsKt.trim((CharSequence) string6).toString();
                CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
                String string8 = (contentDescription == null || (string5 = contentDescription.toString()) == null) ? null : StringsKt.trim((CharSequence) string5).toString();
                CharSequence hintText = accessibilityNodeInfo.getHintText();
                String string9 = (hintText == null || (string4 = hintText.toString()) == null) ? null : StringsKt.trim((CharSequence) string4).toString();
                String str = string7;
                if (str != null && str.length() != 0) {
                    arrayList4.add(string7);
                }
                String str2 = string8;
                if (str2 != null && str2.length() != 0) {
                    arrayList4.add(string8);
                }
                String str3 = string9;
                if (str3 != null && str3.length() != 0) {
                    arrayList4.add(string9);
                }
            }
        }
        List<AccessibilityNodeInfo> nodes = getNodes(event);
        ArrayList arrayList6 = new ArrayList();
        for (AccessibilityNodeInfo accessibilityNodeInfo2 : nodes) {
            CharSequence text3 = accessibilityNodeInfo2.getText();
            String string10 = (text3 == null || (string3 = text3.toString()) == null) ? null : StringsKt.trim((CharSequence) string3).toString();
            CharSequence contentDescription2 = accessibilityNodeInfo2.getContentDescription();
            String string11 = (contentDescription2 == null || (string2 = contentDescription2.toString()) == null) ? null : StringsKt.trim((CharSequence) string2).toString();
            CharSequence hintText2 = accessibilityNodeInfo2.getHintText();
            String string12 = (hintText2 == null || (string = hintText2.toString()) == null) ? null : StringsKt.trim((CharSequence) string).toString();
            String str4 = string10;
            if (str4 != null && str4.length() != 0) {
                arrayList6.add(string10);
            }
            String str5 = string11;
            if (str5 != null && str5.length() != 0) {
                arrayList6.add(string11);
            }
            String str6 = string12;
            if (str6 != null && str6.length() != 0) {
                arrayList6.add(string12);
            }
        }
        List listPlus = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) arrayList3, (Iterable) arrayList4), (Iterable) arrayList6);
        ArrayList arrayList7 = new ArrayList();
        for (Object obj2 : listPlus) {
            String str7 = (String) obj2;
            if (str7.length() > 0 && !SYSTEM_DIALOG_TEXTS.contains(str7)) {
                arrayList7.add(obj2);
            }
        }
        return CollectionsKt.distinct(arrayList7);
    }

    private final boolean isUSSDWidget(AccessibilityEvent event) {
        List<String> listCollectAllTexts = collectAllTexts(event);
        if ((listCollectAllTexts instanceof Collection) && listCollectAllTexts.isEmpty()) {
            return false;
        }
        for (String str : listCollectAllTexts) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            List<String> list = BUTTON_TEXTS;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual((String) it.next(), lowerCase)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean isFinalDialog(AccessibilityEvent event) {
        int i;
        List<AccessibilityNodeInfo> nodes = getNodes(event);
        if ((nodes instanceof Collection) && nodes.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = nodes.iterator();
            i = 0;
            while (it.hasNext()) {
                if (isButton((AccessibilityNodeInfo) it.next()) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i == 1;
    }

    private final boolean hasInputField(AccessibilityEvent event) {
        List<AccessibilityNodeInfo> nodes = getNodes(event);
        if ((nodes instanceof Collection) && nodes.isEmpty()) {
            return false;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo : nodes) {
            if (accessibilityNodeInfo.isEditable() && accessibilityNodeInfo.isFocusable() && accessibilityNodeInfo.isEnabled()) {
                return true;
            }
        }
        return false;
    }

    private final boolean isButton(AccessibilityNodeInfo node) {
        String string;
        CharSequence className = node.getClassName();
        if (className != null && (string = className.toString()) != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = string.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null && StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "button", false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    private final void enterText(AccessibilityEvent event, String text) {
        Bundle bundle = new Bundle();
        String str = text;
        bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, str);
        for (AccessibilityNodeInfo accessibilityNodeInfo : getNodes(event)) {
            if (accessibilityNodeInfo.isEditable() && accessibilityNodeInfo.isFocusable() && accessibilityNodeInfo.isEnabled()) {
                if (accessibilityNodeInfo.performAction(2097152, bundle)) {
                    return;
                }
                Object systemService = getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(ContentType.Text.TYPE, str));
                accessibilityNodeInfo.performAction(32768);
                return;
            }
        }
    }

    private final void clickButton(AccessibilityEvent event, String action) {
        List<AccessibilityNodeInfo> nodes = getNodes(event);
        ArrayList arrayList = new ArrayList();
        for (Object obj : nodes) {
            if (isButton((AccessibilityNodeInfo) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return;
        }
        if (Intrinsics.areEqual(action, "SEND")) {
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) CollectionsKt.lastOrNull((List) arrayList2);
            if (accessibilityNodeInfo != null) {
                accessibilityNodeInfo.performAction(16);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(action, "CANCEL") || arrayList2.size() <= 1) {
            return;
        }
        ((AccessibilityNodeInfo) arrayList2.get(arrayList2.size() - 2)).performAction(16);
    }

    private final void clickFinalDialogButton(AccessibilityEvent event) {
        List<AccessibilityNodeInfo> nodes = getNodes(event);
        ArrayList arrayList = new ArrayList();
        for (Object obj : nodes) {
            if (isButton((AccessibilityNodeInfo) obj)) {
                arrayList.add(obj);
            }
        }
        AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) CollectionsKt.firstOrNull((List) arrayList);
        if (accessibilityNodeInfo != null) {
            accessibilityNodeInfo.performAction(16);
        }
    }

    private final void dismissCurrentDialog(AccessibilityEvent event) {
        Iterator it = SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(getNodes(event)), new Function1() { // from class: com.example.bingwahybrid.domain.engine.advanced.UssdAccessibilityService$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UssdAccessibilityService.dismissCurrentDialog$lambda$13(this.f$0, (AccessibilityNodeInfo) obj));
            }
        }), new Function1() { // from class: com.example.bingwahybrid.domain.engine.advanced.UssdAccessibilityService$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UssdAccessibilityService.dismissCurrentDialog$lambda$15((AccessibilityNodeInfo) obj));
            }
        }).iterator();
        while (it.hasNext()) {
            ((AccessibilityNodeInfo) it.next()).performAction(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dismissCurrentDialog$lambda$13(UssdAccessibilityService ussdAccessibilityService, AccessibilityNodeInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ussdAccessibilityService.isButton(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dismissCurrentDialog$lambda$15(AccessibilityNodeInfo button) {
        String string;
        Intrinsics.checkNotNullParameter(button, "button");
        List<String> list = BUTTON_TEXTS;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String str : list) {
            CharSequence text = button.getText();
            if (text != null && (string = text.toString()) != null) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String lowerCase = string.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (lowerCase != null && StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str, false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissAllDialogs() {
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        extractNodes(arrayList, rootInActiveWindow);
        Iterator it = SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(arrayList), new Function1() { // from class: com.example.bingwahybrid.domain.engine.advanced.UssdAccessibilityService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UssdAccessibilityService.dismissAllDialogs$lambda$17(this.f$0, (AccessibilityNodeInfo) obj));
            }
        }), new Function1() { // from class: com.example.bingwahybrid.domain.engine.advanced.UssdAccessibilityService$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(UssdAccessibilityService.dismissAllDialogs$lambda$19((AccessibilityNodeInfo) obj));
            }
        }).iterator();
        while (it.hasNext()) {
            ((AccessibilityNodeInfo) it.next()).performAction(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dismissAllDialogs$lambda$17(UssdAccessibilityService ussdAccessibilityService, AccessibilityNodeInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ussdAccessibilityService.isButton(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dismissAllDialogs$lambda$19(AccessibilityNodeInfo button) {
        String lowerCase;
        String string;
        Intrinsics.checkNotNullParameter(button, "button");
        List<String> list = BUTTON_TEXTS;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String str : list) {
            CharSequence text = button.getText();
            if (text == null || (string = text.toString()) == null) {
                lowerCase = null;
            } else {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                lowerCase = string.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            }
            if (Intrinsics.areEqual(lowerCase, str)) {
                return true;
            }
        }
        return false;
    }

    private final List<AccessibilityNodeInfo> getNodes(AccessibilityEvent event) {
        ArrayList arrayList = new ArrayList();
        AccessibilityNodeInfo source = event.getSource();
        if (source != null) {
            extractNodes(arrayList, source);
        }
        return arrayList;
    }

    private final void extractNodes(List<AccessibilityNodeInfo> nodes, AccessibilityNodeInfo node) {
        nodes.add(node);
        int childCount = node.getChildCount();
        for (int i = 0; i < childCount; i++) {
            AccessibilityNodeInfo child = node.getChild(i);
            if (child != null) {
                extractNodes(nodes, child);
            }
        }
    }

    private final String getFinalResponse(AccessibilityEvent event) {
        List<String> listCollectAllTexts = collectAllTexts(event);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listCollectAllTexts) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = ((String) obj).toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String string = StringsKt.trim((CharSequence) lowerCase).toString();
            List<String> list = BUTTON_TEXTS;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (!Intrinsics.areEqual(string, (String) it.next()));
            }
            arrayList.add(obj);
        }
        return StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(arrayList, ServerSentEventKt.SPACE, null, null, 0, null, null, 62, null)).toString();
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.advanced.UssdAccessibilityService$onServiceConnected$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UssdAccessibilityService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.advanced.UssdAccessibilityService$onServiceConnected$1", f = "UssdAccessibilityService.kt", i = {}, l = {338, 342}, m = "invokeSuspend", n = {}, s = {})
    static final class C06731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06731(Continuation<? super C06731> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UssdAccessibilityService.this.new C06731(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0058, code lost:
        
            if (r5.collect(new com.example.bingwahybrid.domain.engine.advanced.UssdAccessibilityService.C06731.C01291<>(), r4) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (UssdAccessibilityService.this.getAccessibilityRepository().notifyAccessibilityServiceConnected(this) != coroutine_suspended) {
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
            throw new KotlinNothingValueException();
            UssdAccessibilityService.this.getCurrentDeviceRepository().detectCurrentDevice();
            StateFlow<UssdSessionState> sessionStateFlow = UssdAccessibilityService.this.getSessionManager().getSessionStateFlow();
            final UssdAccessibilityService ussdAccessibilityService = UssdAccessibilityService.this;
            this.label = 2;
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        super.onServiceConnected();
        BuildersKt__Builders_commonKt.launch$default(this.serviceScope, null, null, new C06731(null), 3, null);
    }

    private final void completeSession(String finalResponse) {
        dismissAllDialogs();
        if (UssdUtils.INSTANCE.isSuccessfulResponse(finalResponse)) {
            getSessionManager().completeSession(new UssdSessionState.Success(finalResponse));
        } else {
            getSessionManager().completeSession(new UssdSessionState.Failure(finalResponse));
        }
    }

    private final void completeSessionWithResponse(AccessibilityEvent event) {
        String finalResponse = getFinalResponse(event);
        dismissCurrentDialog(event);
        completeSession(finalResponse);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.advanced.UssdAccessibilityService$onDestroy$1, reason: invalid class name */
    /* JADX INFO: compiled from: UssdAccessibilityService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.advanced.UssdAccessibilityService$onDestroy$1", f = "UssdAccessibilityService.kt", i = {}, l = {378}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UssdAccessibilityService.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (UssdAccessibilityService.this.getAccessibilityRepository().postAccessibilityServiceStatus(false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Job.DefaultImpls.cancel$default((Job) UssdAccessibilityService.this.serviceJob, (CancellationException) null, 1, (Object) null);
            return Unit.INSTANCE;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BuildersKt__Builders_commonKt.launch$default(this.serviceScope, null, null, new AnonymousClass1(null), 3, null);
    }
}
