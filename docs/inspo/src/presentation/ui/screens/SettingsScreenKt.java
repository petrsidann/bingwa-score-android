package com.example.bingwahybrid.presentation.ui.screens;

import android.app.Activity;
import android.content.Context;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.MenuKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIosKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.hilt.lifecycle.viewmodel.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.example.bingwahybrid.domain.auth.models.Agent;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.enums.ProcessingMode;
import com.example.bingwahybrid.domain.utils.SnackbarManager;
import com.example.bingwahybrid.presentation.navigation.Route;
import com.example.bingwahybrid.presentation.settings.autosave.components.AutoSaveContactsToggleHandlerKt;
import com.example.bingwahybrid.presentation.ui.components.ProfileScreenContentKt;
import com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.LinkHeader;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: SettingsScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a£\u0001\u0010\t\u001a\u00020\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00132\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0007¢\u0006\u0002\u0010\u001a\u001a\u0015\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a \u0010\u001f\u001a\u00020\u00012\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b!H\u0007¢\u0006\u0002\u0010\"\u001a3\u0010#\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0007¢\u0006\u0002\u0010'\u001aV\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\r2\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000f2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017¢\u0006\u0002\b!H\u0007¢\u0006\u0002\u0010-\u001a\r\u0010.\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010/¨\u00060²\u0006\f\u00101\u001a\u0004\u0018\u000102X\u008a\u0084\u0002²\u0006\f\u00103\u001a\u0004\u0018\u00010\u001dX\u008a\u0084\u0002²\u0006\u0016\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u00104\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"SettingsScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/SettingsViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/viewmodel/SettingsViewModel;Landroidx/compose/runtime/Composer;II)V", "SettingsScreenContent", "settings", "", "Lcom/example/bingwahybrid/domain/enums/AppSetting;", "", "onSettingChange", "Lkotlin/Function2;", "processingMode", "Lcom/example/bingwahybrid/domain/enums/ProcessingMode;", "onProcessingModeChanged", "Lkotlin/Function1;", "engageBotActive", "onEngageBotActiveChanged", "onOpenBlackList", "Lkotlin/Function0;", "openAuthorizedSenders", "onOpenAutoSaveContactsSettings", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lcom/example/bingwahybrid/domain/enums/ProcessingMode;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SectionTitle", LinkHeader.Parameters.Title, "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "SettingItem", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ProcessingModeItem", "description", "isSelected", "onSelect", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SwitchSettingItem", "setting", "isChecked", "onCheckedChange", "icon", "(Lcom/example/bingwahybrid/domain/enums/AppSetting;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SettingsScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "agent", "Lcom/example/bingwahybrid/domain/auth/models/Agent;", "snackBarMessage", "isAccessibilityServiceEnabled"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SettingsScreenKt {

    /* JADX INFO: compiled from: SettingsScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppSetting.values().length];
            try {
                iArr[AppSetting.AUTO_SAVE_CONTACTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProcessingModeItem$lambda$92(String str, String str2, boolean z, Function0 function0, int i, Composer composer, int i2) {
        ProcessingModeItem(str, str2, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SectionTitle$lambda$85(String str, int i, Composer composer, int i2) {
        SectionTitle(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingItem$lambda$87(Function2 function2, int i, Composer composer, int i2) {
        SettingItem(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$34(Modifier modifier, NavHostController navHostController, SettingsViewModel settingsViewModel, int i, int i2, Composer composer, int i3) {
        SettingsScreen(modifier, navHostController, settingsViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$84(Map map, Function2 function2, ProcessingMode processingMode, Function1 function1, boolean z, Function1 function3, Function0 function0, Function0 function4, Function0 function5, int i, int i2, Composer composer, int i3) {
        SettingsScreenContent(map, function2, processingMode, function1, z, function3, function0, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenPreview$lambda$110(int i, Composer composer, int i2) {
        SettingsScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchSettingItem$lambda$97(AppSetting appSetting, String str, boolean z, Function2 function2, Function2 function3, int i, int i2, Composer composer, int i3) {
        SwitchSettingItem(appSetting, str, z, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0241  */
    /* JADX WARN: Code duplicated, block: B:104:0x0249  */
    /* JADX WARN: Code duplicated, block: B:107:0x026a  */
    /* JADX WARN: Code duplicated, block: B:109:0x0270  */
    /* JADX WARN: Code duplicated, block: B:115:0x027d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0285  */
    /* JADX WARN: Code duplicated, block: B:120:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    /* JADX WARN: Code duplicated, block: B:64:0x0119  */
    /* JADX WARN: Code duplicated, block: B:67:0x013b  */
    /* JADX WARN: Code duplicated, block: B:70:0x018d  */
    /* JADX WARN: Code duplicated, block: B:73:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:74:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:81:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:83:0x01e3 A[PHI: r18
  0x01e3: PHI (r18v4 android.app.Activity) = (r18v1 android.app.Activity), (r18v6 android.app.Activity) binds: [B:82:0x01e1, B:80:0x01da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:84:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:87:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:89:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:92:0x0227  */
    /* JADX WARN: Code duplicated, block: B:96:0x0231  */
    /* JADX WARN: Code duplicated, block: B:98:0x0237 A[PHI: r21
  0x0237: PHI (r21v2 androidx.compose.runtime.State) = (r21v0 androidx.compose.runtime.State), (r21v3 androidx.compose.runtime.State) binds: [B:97:0x0235, B:95:0x022e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:99:0x0239  */
    public static final void SettingsScreen(Modifier modifier, final NavHostController navController, SettingsViewModel settingsViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final SettingsViewModel settingsViewModel2;
        final Modifier modifier3;
        Modifier modifier4;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Composer composer3;
        final SettingsViewModel settingsViewModel3;
        int i4;
        Object objRememberedValue;
        final CoroutineScope coroutineScope;
        State stateCollectAsState;
        State stateCollectAsState2;
        Object objRememberedValue2;
        final MutableState mutableState;
        Context context;
        Activity activity;
        int i5;
        Activity activity2;
        boolean z;
        boolean zChangedInstance;
        Object objRememberedValue3;
        State state;
        boolean z2;
        boolean z3;
        SettingsScreenKt$SettingsScreen$1$1 settingsScreenKt$SettingsScreen$1$1RememberedValue;
        boolean z4;
        SettingsScreenKt$SettingsScreen$2$1 settingsScreenKt$SettingsScreen$2$1RememberedValue;
        int i6;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(132948487);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingsScreen)N(modifier,navController,viewModel)61@2888L24,62@2946L16,63@3016L16,64@3072L16,65@3140L16,66@3210L16,67@3268L34,69@3335L7,74@3527L342,72@3414L455,85@3908L144,85@3876L176,92@4079L191,92@4058L212,99@4294L341,110@4637L2502,99@4276L2863:SettingsScreen.kt#oif8tm");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(navController) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i6 = 128;
            } else {
                if ((i & 512) == 0 ? composerStartRestartGroup.changed(settingsViewModel) : composerStartRestartGroup.changedInstance(settingsViewModel)) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
            }
            i3 |= i6;
        }
        int i8 = i3;
        if (composerStartRestartGroup.shouldExecute((i8 & 147) != 146, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "59@2851L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i8 &= -897;
                }
                modifier4 = modifier2;
            } else {
                modifier4 = i7 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1890788296, "CC(hiltViewModel)P(1)51@2126L7,55@2260L46:HiltViewModel.kt#9mcars");
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1192010736, "CC(hiltViewModel)P(1)38@1622L7,43@1774L47,44@1833L54:HiltViewModel.kt#gplxbw");
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(SettingsViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    composer3 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    i8 &= -897;
                    settingsViewModel3 = (SettingsViewModel) viewModel;
                    i4 = 1;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(132948487, i8, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreen (SettingsScreen.kt:60)");
                }
                ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composer3, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3);
                    composer3.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                final State stateCollectAsState3 = SnapshotStateKt.collectAsState(settingsViewModel3.m9983getAgent(), null, composer3, 0, i4);
                stateCollectAsState = SnapshotStateKt.collectAsState(settingsViewModel3.getSnackBarMessage(), null, composer3, 0, i4);
                stateCollectAsState2 = SnapshotStateKt.collectAsState(settingsViewModel3.m9985getSettings(), null, composer3, 0, i4);
                final State stateCollectAsState4 = SnapshotStateKt.collectAsState(settingsViewModel3.getProcessingMode(), null, composer3, 0, i4);
                final State stateCollectAsState5 = SnapshotStateKt.collectAsState(settingsViewModel3.m9984getEngageBotActive(), null, composer3, 0, i4);
                ComposerKt.sourceInformationMarkerStart(composer3, -1085503735, "CC(remember):SettingsScreen.kt#9igjgp");
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composer3.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                context = (Context) objConsume;
                if (context instanceof Activity) {
                    activity = (Activity) context;
                } else {
                    activity = null;
                }
                ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions = new ActivityResultContracts.RequestMultiplePermissions();
                ComposerKt.sourceInformationMarkerStart(composer3, -1085495139, "CC(remember):SettingsScreen.kt#9igjgp");
                i5 = (i8 & 896) ^ 384;
                if (i5 > 256 || !composer3.changedInstance(settingsViewModel3)) {
                    activity2 = activity;
                    if ((i8 & 384) != 256) {
                        z = false;
                    }
                    zChangedInstance = z | composer3.changedInstance(coroutineScope);
                    objRememberedValue3 = composer3.rememberedValue();
                    if (!zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SettingsScreenKt.SettingsScreen$lambda$10$lambda$9(settingsViewModel3, coroutineScope, (Map) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions, (Function1) objRememberedValue3, composer3, 0);
                    String strSettingsScreen$lambda$1 = SettingsScreen$lambda$1(stateCollectAsState);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1085483145, "CC(remember):SettingsScreen.kt#9igjgp");
                    boolean zChanged = composer3.changed(stateCollectAsState) | composer3.changedInstance(coroutineScope);
                    if (i5 > 256 || !composer3.changedInstance(settingsViewModel3)) {
                        state = stateCollectAsState2;
                        if ((i8 & 384) != 256) {
                            z2 = false;
                        }
                        z3 = z2 | zChanged;
                        settingsScreenKt$SettingsScreen$1$1RememberedValue = composer3.rememberedValue();
                        if (!z3 || settingsScreenKt$SettingsScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            settingsScreenKt$SettingsScreen$1$1RememberedValue = new SettingsScreenKt$SettingsScreen$1$1(stateCollectAsState, coroutineScope, settingsViewModel3, null);
                            composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        EffectsKt.LaunchedEffect(strSettingsScreen$lambda$1, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) settingsScreenKt$SettingsScreen$1$1RememberedValue, composer3, 0);
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1085477626, "CC(remember):SettingsScreen.kt#9igjgp");
                        z4 = (i5 <= 256 && composer3.changedInstance(settingsViewModel3)) || (i8 & 384) == 256;
                        settingsScreenKt$SettingsScreen$2$1RememberedValue = composer3.rememberedValue();
                        if (!z4 || settingsScreenKt$SettingsScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            settingsScreenKt$SettingsScreen$2$1RememberedValue = new SettingsScreenKt$SettingsScreen$2$1(settingsViewModel3, mutableState, null);
                            composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) settingsScreenKt$SettingsScreen$2$1RememberedValue, composer3, 6);
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(536718531, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SettingsScreenKt.SettingsScreen$lambda$16(navController, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54);
                        Composer composer4 = composer3;
                        modifier3 = modifier4;
                        final Activity activity3 = activity2;
                        final State state2 = state;
                        ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1824129384, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return SettingsScreenKt.SettingsScreen$lambda$33(modifier3, navController, stateCollectAsState3, state2, activity3, managedActivityResultLauncherRememberLauncherForActivityResult, settingsViewModel3, stateCollectAsState4, mutableState, stateCollectAsState5, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer4, 54), composer4, 805306416, 509);
                        composer2 = composer4;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        settingsViewModel2 = settingsViewModel3;
                    } else {
                        state = stateCollectAsState2;
                    }
                    z2 = true;
                    z3 = z2 | zChanged;
                    settingsScreenKt$SettingsScreen$1$1RememberedValue = composer3.rememberedValue();
                    if (!z3) {
                        settingsScreenKt$SettingsScreen$1$1RememberedValue = new SettingsScreenKt$SettingsScreen$1$1(stateCollectAsState, coroutineScope, settingsViewModel3, null);
                        composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$1$1RememberedValue);
                    } else {
                        settingsScreenKt$SettingsScreen$1$1RememberedValue = new SettingsScreenKt$SettingsScreen$1$1(stateCollectAsState, coroutineScope, settingsViewModel3, null);
                        composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    EffectsKt.LaunchedEffect(strSettingsScreen$lambda$1, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) settingsScreenKt$SettingsScreen$1$1RememberedValue, composer3, 0);
                    Unit unit2 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1085477626, "CC(remember):SettingsScreen.kt#9igjgp");
                    if (i5 <= 256) {
                    }
                    settingsScreenKt$SettingsScreen$2$1RememberedValue = composer3.rememberedValue();
                    if (!z4) {
                        settingsScreenKt$SettingsScreen$2$1RememberedValue = new SettingsScreenKt$SettingsScreen$2$1(settingsViewModel3, mutableState, null);
                        composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$2$1RememberedValue);
                    } else {
                        settingsScreenKt$SettingsScreen$2$1RememberedValue = new SettingsScreenKt$SettingsScreen$2$1(settingsViewModel3, mutableState, null);
                        composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) settingsScreenKt$SettingsScreen$2$1RememberedValue, composer3, 6);
                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(536718531, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SettingsScreenKt.SettingsScreen$lambda$16(navController, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54);
                    Composer composer5 = composer3;
                    modifier3 = modifier4;
                    final Activity activity4 = activity2;
                    final State state3 = state;
                    ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda2, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1824129384, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return SettingsScreenKt.SettingsScreen$lambda$33(modifier3, navController, stateCollectAsState3, state3, activity4, managedActivityResultLauncherRememberLauncherForActivityResult, settingsViewModel3, stateCollectAsState4, mutableState, stateCollectAsState5, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer5, 54), composer5, 805306416, 509);
                    composer2 = composer5;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    settingsViewModel2 = settingsViewModel3;
                } else {
                    activity2 = activity;
                }
                z = true;
                zChangedInstance = z | composer3.changedInstance(coroutineScope);
                objRememberedValue3 = composer3.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SettingsScreenKt.SettingsScreen$lambda$10$lambda$9(settingsViewModel3, coroutineScope, (Map) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SettingsScreenKt.SettingsScreen$lambda$10$lambda$9(settingsViewModel3, coroutineScope, (Map) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions, (Function1) objRememberedValue3, composer3, 0);
                String strSettingsScreen$lambda$2 = SettingsScreen$lambda$1(stateCollectAsState);
                ComposerKt.sourceInformationMarkerStart(composer3, -1085483145, "CC(remember):SettingsScreen.kt#9igjgp");
                boolean zChanged2 = composer3.changed(stateCollectAsState) | composer3.changedInstance(coroutineScope);
                if (i5 > 256) {
                    state = stateCollectAsState2;
                    if ((i8 & 384) != 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    state = stateCollectAsState2;
                    if ((i8 & 384) != 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                z3 = z2 | zChanged2;
                settingsScreenKt$SettingsScreen$1$1RememberedValue = composer3.rememberedValue();
                if (!z3) {
                    settingsScreenKt$SettingsScreen$1$1RememberedValue = new SettingsScreenKt$SettingsScreen$1$1(stateCollectAsState, coroutineScope, settingsViewModel3, null);
                    composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$1$1RememberedValue);
                } else {
                    settingsScreenKt$SettingsScreen$1$1RememberedValue = new SettingsScreenKt$SettingsScreen$1$1(stateCollectAsState, coroutineScope, settingsViewModel3, null);
                    composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                EffectsKt.LaunchedEffect(strSettingsScreen$lambda$2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) settingsScreenKt$SettingsScreen$1$1RememberedValue, composer3, 0);
                Unit unit3 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, -1085477626, "CC(remember):SettingsScreen.kt#9igjgp");
                if (i5 <= 256) {
                }
                settingsScreenKt$SettingsScreen$2$1RememberedValue = composer3.rememberedValue();
                if (!z4) {
                    settingsScreenKt$SettingsScreen$2$1RememberedValue = new SettingsScreenKt$SettingsScreen$2$1(settingsViewModel3, mutableState, null);
                    composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$2$1RememberedValue);
                } else {
                    settingsScreenKt$SettingsScreen$2$1RememberedValue = new SettingsScreenKt$SettingsScreen$2$1(settingsViewModel3, mutableState, null);
                    composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) settingsScreenKt$SettingsScreen$2$1RememberedValue, composer3, 6);
                ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(536718531, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreen$lambda$16(navController, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54);
                Composer composer6 = composer3;
                modifier3 = modifier4;
                final Activity activity5 = activity2;
                final State state4 = state;
                ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda3, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1824129384, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SettingsScreenKt.SettingsScreen$lambda$33(modifier3, navController, stateCollectAsState3, state4, activity5, managedActivityResultLauncherRememberLauncherForActivityResult2, settingsViewModel3, stateCollectAsState4, mutableState, stateCollectAsState5, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer6, 54), composer6, 805306416, 509);
                composer2 = composer6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                settingsViewModel2 = settingsViewModel3;
            }
            i4 = 1;
            composer3 = composerStartRestartGroup;
            settingsViewModel3 = settingsViewModel;
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(132948487, i8, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreen (SettingsScreen.kt:60)");
            }
            ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer3, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composer3.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3);
                composer3.updateRememberedValue(objRememberedValue);
            }
            coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            final State stateCollectAsState6 = SnapshotStateKt.collectAsState(settingsViewModel3.m9983getAgent(), null, composer3, 0, i4);
            stateCollectAsState = SnapshotStateKt.collectAsState(settingsViewModel3.getSnackBarMessage(), null, composer3, 0, i4);
            stateCollectAsState2 = SnapshotStateKt.collectAsState(settingsViewModel3.m9985getSettings(), null, composer3, 0, i4);
            final State stateCollectAsState7 = SnapshotStateKt.collectAsState(settingsViewModel3.getProcessingMode(), null, composer3, 0, i4);
            final State stateCollectAsState8 = SnapshotStateKt.collectAsState(settingsViewModel3.m9984getEngageBotActive(), null, composer3, 0, i4);
            ComposerKt.sourceInformationMarkerStart(composer3, -1085503735, "CC(remember):SettingsScreen.kt#9igjgp");
            objRememberedValue2 = composer3.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer3.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer3.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            context = (Context) objConsume2;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions2 = new ActivityResultContracts.RequestMultiplePermissions();
            ComposerKt.sourceInformationMarkerStart(composer3, -1085495139, "CC(remember):SettingsScreen.kt#9igjgp");
            i5 = (i8 & 896) ^ 384;
            if (i5 > 256) {
                activity2 = activity;
                if ((i8 & 384) != 256) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                activity2 = activity;
                if ((i8 & 384) != 256) {
                    z = true;
                } else {
                    z = false;
                }
            }
            zChangedInstance = z | composer3.changedInstance(coroutineScope);
            objRememberedValue3 = composer3.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsScreenKt.SettingsScreen$lambda$10$lambda$9(settingsViewModel3, coroutineScope, (Map) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsScreenKt.SettingsScreen$lambda$10$lambda$9(settingsViewModel3, coroutineScope, (Map) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult3 = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions2, (Function1) objRememberedValue3, composer3, 0);
            String strSettingsScreen$lambda$3 = SettingsScreen$lambda$1(stateCollectAsState);
            ComposerKt.sourceInformationMarkerStart(composer3, -1085483145, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean zChanged3 = composer3.changed(stateCollectAsState) | composer3.changedInstance(coroutineScope);
            if (i5 > 256) {
                state = stateCollectAsState2;
                if ((i8 & 384) != 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                state = stateCollectAsState2;
                if ((i8 & 384) != 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            z3 = z2 | zChanged3;
            settingsScreenKt$SettingsScreen$1$1RememberedValue = composer3.rememberedValue();
            if (!z3) {
                settingsScreenKt$SettingsScreen$1$1RememberedValue = new SettingsScreenKt$SettingsScreen$1$1(stateCollectAsState, coroutineScope, settingsViewModel3, null);
                composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$1$1RememberedValue);
            } else {
                settingsScreenKt$SettingsScreen$1$1RememberedValue = new SettingsScreenKt$SettingsScreen$1$1(stateCollectAsState, coroutineScope, settingsViewModel3, null);
                composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(strSettingsScreen$lambda$3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) settingsScreenKt$SettingsScreen$1$1RememberedValue, composer3, 0);
            Unit unit4 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -1085477626, "CC(remember):SettingsScreen.kt#9igjgp");
            if (i5 <= 256) {
            }
            settingsScreenKt$SettingsScreen$2$1RememberedValue = composer3.rememberedValue();
            if (!z4) {
                settingsScreenKt$SettingsScreen$2$1RememberedValue = new SettingsScreenKt$SettingsScreen$2$1(settingsViewModel3, mutableState, null);
                composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$2$1RememberedValue);
            } else {
                settingsScreenKt$SettingsScreen$2$1RememberedValue = new SettingsScreenKt$SettingsScreen$2$1(settingsViewModel3, mutableState, null);
                composer3.updateRememberedValue(settingsScreenKt$SettingsScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(unit4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) settingsScreenKt$SettingsScreen$2$1RememberedValue, composer3, 6);
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(536718531, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreen$lambda$16(navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer3, 54);
            Composer composer7 = composer3;
            modifier3 = modifier4;
            final Activity activity6 = activity2;
            final State state5 = state;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda4, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1824129384, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SettingsScreenKt.SettingsScreen$lambda$33(modifier3, navController, stateCollectAsState6, state5, activity6, managedActivityResultLauncherRememberLauncherForActivityResult3, settingsViewModel3, stateCollectAsState7, mutableState, stateCollectAsState8, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer7, 54), composer7, 805306416, 509);
            composer2 = composer7;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            settingsViewModel2 = settingsViewModel3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            settingsViewModel2 = settingsViewModel;
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreen$lambda$34(modifier3, navController, settingsViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean SettingsScreen$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsScreen$lambda$7(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$10$lambda$9(SettingsViewModel settingsViewModel, CoroutineScope coroutineScope, Map permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Collection collectionValues = permissions.values();
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            settingsViewModel.updateSetting(AppSetting.AUTO_SAVE_CONTACTS, true);
            SnackbarManager.INSTANCE.showMessage(coroutineScope, "Contacts auto-save enabled");
        } else {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    SnackbarManager.INSTANCE.showMessage(coroutineScope, "Permission denied");
                }
            }
            settingsViewModel.updateSetting(AppSetting.AUTO_SAVE_CONTACTS, true);
            SnackbarManager.INSTANCE.showMessage(coroutineScope, "Contacts auto-save enabled");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$16(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C102@4386L233,100@4304L325:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(536718531, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreen.<anonymous> (SettingsScreen.kt:100)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$SettingsScreenKt.INSTANCE.getLambda$1566527367$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(291603721, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda49
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreen$lambda$16$lambda$15(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$16$lambda$15(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C103@4425L68,103@4404L201:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(291603721, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreen.<anonymous>.<anonymous> (SettingsScreen.kt:103)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1058302957, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreen$lambda$16$lambda$15$lambda$14$lambda$13(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.m9866getLambda$2086332377$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$16$lambda$15$lambda$14$lambda$13(NavHostController navHostController) {
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$33(Modifier modifier, final NavHostController navHostController, State state, State state2, final Activity activity, final ManagedActivityResultLauncher managedActivityResultLauncher, final SettingsViewModel settingsViewModel, State state3, final MutableState mutableState, State state4, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)111@4664L2469:SettingsScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1824129384, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreen.<anonymous> (SettingsScreen.kt:111)");
            }
            Modifier modifierM1120paddingVpY3zN4$default = PaddingKt.m1120paddingVpY3zN4$default(PaddingKt.padding(modifier, paddingValues), Dp.m8684constructorimpl(16), 0.0f, 2, null);
            Alignment.Horizontal start = Alignment.INSTANCE.getStart();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1120paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1800111292, "C128@5219L767,147@6079L379,157@6554L150,162@6740L84,165@6866L92,168@7009L99,126@5125L1997:SettingsScreen.kt#oif8tm");
            Agent agentSettingsScreen$lambda$0 = SettingsScreen$lambda$0(state);
            if (agentSettingsScreen$lambda$0 == null) {
                composer.startReplaceGroup(-1800166908);
            } else {
                composer.startReplaceGroup(-1800166907);
                ComposerKt.sourceInformation(composer, "*120@4984L94,118@4894L203");
                ComposerKt.sourceInformationMarkerStart(composer, 927840140, "CC(remember):SettingsScreen.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(navHostController);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SettingsScreenKt.SettingsScreen$lambda$33$lambda$32$lambda$19$lambda$18$lambda$17(navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ProfileScreenContentKt.ProfileScreenContent(agentSettingsScreen$lambda$0, (Function0) objRememberedValue, composer, Agent.$stable);
            }
            composer.endReplaceGroup();
            Map<AppSetting, Boolean> mapSettingsScreen$lambda$2 = SettingsScreen$lambda$2(state2);
            ComposerKt.sourceInformationMarkerStart(composer, 1327415053, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreen$lambda$33$lambda$32$lambda$21$lambda$20(activity, managedActivityResultLauncher, settingsViewModel, (AppSetting) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function2 function2 = (Function2) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ProcessingMode processingModeSettingsScreen$lambda$3 = SettingsScreen$lambda$3(state3);
            ComposerKt.sourceInformationMarkerStart(composer, 1327442185, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsScreenKt.SettingsScreen$lambda$33$lambda$32$lambda$23$lambda$22(navHostController, settingsViewModel, mutableState, (ProcessingMode) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function1 function1 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean zSettingsScreen$lambda$4 = SettingsScreen$lambda$4(state4);
            ComposerKt.sourceInformationMarkerStart(composer, 1327457156, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsScreenKt.SettingsScreen$lambda$33$lambda$32$lambda$25$lambda$24(settingsViewModel, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function3 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1327463042, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(navHostController);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda44
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreen$lambda$33$lambda$32$lambda$27$lambda$26(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Function0 function0 = (Function0) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1327467082, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(navHostController);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda47
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreen$lambda$33$lambda$32$lambda$29$lambda$28(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            Function0 function4 = (Function0) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1327471665, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(navHostController);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda48
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreen$lambda$33$lambda$32$lambda$31$lambda$30(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SettingsScreenContent(mapSettingsScreen$lambda$2, function2, processingModeSettingsScreen$lambda$3, function1, zSettingsScreen$lambda$4, function3, function0, function4, (Function0) objRememberedValue7, composer, 199728, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$33$lambda$32$lambda$19$lambda$18$lambda$17(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, Route.EditProfile.INSTANCE.getName(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$33$lambda$32$lambda$21$lambda$20(Activity activity, ManagedActivityResultLauncher managedActivityResultLauncher, SettingsViewModel settingsViewModel, AppSetting setting, boolean z) {
        Intrinsics.checkNotNullParameter(setting, "setting");
        if (WhenMappings.$EnumSwitchMapping$0[setting.ordinal()] == 1) {
            AutoSaveContactsToggleHandlerKt.handleAutoSaveContactsToggle(z, activity, managedActivityResultLauncher, new SettingsScreenKt$SettingsScreen$4$1$2$1$1(settingsViewModel));
        } else {
            settingsViewModel.updateSetting(setting, z);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$33$lambda$32$lambda$23$lambda$22(NavHostController navHostController, SettingsViewModel settingsViewModel, MutableState mutableState, ProcessingMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (mode == ProcessingMode.ADVANCED && !SettingsScreen$lambda$6(mutableState)) {
            NavController.navigate$default((NavController) navHostController, Route.AccessibilityInfo.INSTANCE.getName(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        } else {
            settingsViewModel.setProcessingMode(mode);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$33$lambda$32$lambda$25$lambda$24(SettingsViewModel settingsViewModel, boolean z) {
        settingsViewModel.toggleEngageBotActive(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$33$lambda$32$lambda$27$lambda$26(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, Route.BlackList.INSTANCE.getName(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$33$lambda$32$lambda$29$lambda$28(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, Route.AuthorizedSenders.INSTANCE.getName(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$33$lambda$32$lambda$31$lambda$30(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, Route.AutoSaveContactsSettings.INSTANCE.getName(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0181  */
    /* JADX WARN: Code duplicated, block: B:105:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:108:0x0201  */
    /* JADX WARN: Code duplicated, block: B:109:0x0205  */
    /* JADX WARN: Code duplicated, block: B:114:0x0238  */
    /* JADX WARN: Code duplicated, block: B:117:0x0596  */
    /* JADX WARN: Code duplicated, block: B:120:0x05a2  */
    /* JADX WARN: Code duplicated, block: B:121:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:126:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:129:0x0608  */
    /* JADX WARN: Code duplicated, block: B:130:0x060a  */
    /* JADX WARN: Code duplicated, block: B:133:0x061b  */
    /* JADX WARN: Code duplicated, block: B:134:0x061d  */
    /* JADX WARN: Code duplicated, block: B:141:0x0630  */
    /* JADX WARN: Code duplicated, block: B:144:0x0655  */
    /* JADX WARN: Code duplicated, block: B:145:0x0657  */
    /* JADX WARN: Code duplicated, block: B:148:0x0661  */
    /* JADX WARN: Code duplicated, block: B:153:0x0671  */
    /* JADX WARN: Code duplicated, block: B:156:0x06b6  */
    /* JADX WARN: Code duplicated, block: B:158:0x06be  */
    /* JADX WARN: Code duplicated, block: B:161:0x06cf  */
    /* JADX WARN: Code duplicated, block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00df  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:78:0x0105  */
    /* JADX WARN: Code duplicated, block: B:79:0x0107  */
    /* JADX WARN: Code duplicated, block: B:82:0x0110  */
    /* JADX WARN: Code duplicated, block: B:84:0x0114  */
    /* JADX WARN: Code duplicated, block: B:86:0x0126  */
    /* JADX WARN: Code duplicated, block: B:88:0x0134  */
    /* JADX WARN: Code duplicated, block: B:90:0x0138  */
    /* JADX WARN: Code duplicated, block: B:92:0x014a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0159  */
    /* JADX WARN: Code duplicated, block: B:97:0x016b  */
    /* JADX WARN: Code duplicated, block: B:99:0x0179  */
    public static final void SettingsScreenContent(final Map<AppSetting, Boolean> settings, final Function2<? super AppSetting, ? super Boolean, Unit> onSettingChange, final ProcessingMode processingMode, Function1<? super ProcessingMode, Unit> onProcessingModeChanged, final boolean z, final Function1<? super Boolean, Unit> onEngageBotActiveChanged, Function0<Unit> function0, Function0<Unit> function1, Function0<Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Function0<Unit> function3;
        int i5;
        int i6;
        int i7;
        boolean z2;
        final Function1<? super ProcessingMode, Unit> function4;
        Composer composer2;
        final Function0<Unit> function5;
        final Function0<Unit> function6;
        final Function0<Unit> function7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function0<Unit> function8;
        Function0<Unit> function9;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int iHashCode2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM5259constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean z3;
        int i8;
        boolean z4;
        Object objRememberedValue;
        boolean z5;
        boolean z6;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(onSettingChange, "onSettingChange");
        Intrinsics.checkNotNullParameter(processingMode, "processingMode");
        Intrinsics.checkNotNullParameter(onProcessingModeChanged, "onProcessingModeChanged");
        Intrinsics.checkNotNullParameter(onEngageBotActiveChanged, "onEngageBotActiveChanged");
        Composer composerStartRestartGroup = composer.startRestartGroup(-177485349);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingsScreenContent)N(settings,onSettingChange,processingMode,onProcessingModeChanged,engageBotActive,onEngageBotActiveChanged,onOpenBlackList,openAuthorizedSenders,onOpenAutoSaveContactsSettings)185@7478L2,186@7522L2,187@7575L2,189@7605L21,191@7632L12172:SettingsScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(settings) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onSettingChange) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(processingMode.ordinal()) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onProcessingModeChanged) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onEngageBotActiveChanged) ? 131072 : 65536;
        }
        int i9 = i2 & 64;
        if (i9 == 0) {
            if ((1572864 & i) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function0) ? 1048576 : 524288;
            }
            i4 = i2 & 128;
            if (i4 != 0) {
                i3 |= 12582912;
                function3 = function1;
            } else {
                function3 = function1;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i5 = 8388608;
                    } else {
                        i5 = 4194304;
                    }
                    i3 |= i5;
                }
            }
            i6 = i2 & 256;
            if (i6 != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i7 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                } else {
                    i7 = 33554432;
                }
                i3 |= i7;
            }
            if ((i3 & 38347923) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                function4 = onProcessingModeChanged;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function5 = function0;
                function6 = function2;
                function7 = function3;
            } else {
                if (i9 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1235282173, "CC(remember):SettingsScreen.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    function8 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function8 = function0;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1235283581, "CC(remember):SettingsScreen.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda28
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    function3 = (Function0) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1235285277, "CC(remember):SettingsScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function9 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function9 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-177485349, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent (SettingsScreen.kt:188)");
                }
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                final Function0<Unit> function10 = function3;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -123660668, "C196@7752L25,199@7872L10,197@7786L174,203@7982L375,203@7970L387,213@8379L375,213@8367L387,223@8764L41,226@8902L10,224@8814L176,229@9011L361,229@8999L373,238@9393L361,238@9381L373,248@9764L41,251@9900L10,249@9814L174,254@10009L359,254@9997L371,263@10389L359,263@10377L371,274@10759L41,275@10809L34,276@10864L300,276@10852L312,285@11186L296,285@11174L308,294@11504L307,294@11492L319,303@11833L310,303@11821L322,311@12164L1404,311@12152L1416,346@13577L41,347@13627L28,348@13676L1343,348@13664L1355,383@15040L1413,383@15028L1425,419@16463L41,420@16513L29,421@16563L1188,421@16551L1200,452@17761L41,453@17811L30,454@17862L1131,454@17850L1143,485@19003L41,486@19053L31,487@19093L705:SettingsScreen.kt#oif8tm");
                SectionTitle("SIM Setup", composerStartRestartGroup, 6);
                float f = 8;
                final Function0<Unit> function11 = function9;
                int i10 = i3;
                TextKt.m3864TextNvy7gAk("SIM to receive payments", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f), 7, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composerStartRestartGroup, 54, 0, 131068);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(501490601, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$41(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(35677664, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$42(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                float f2 = 16;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                TextKt.m3864TextNvy7gAk("Bingwa SIM (To run USSDs)", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f), 7, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composerStartRestartGroup, 54, 0, 131068);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(93659937, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda34
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$43(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(151642210, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda35
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$44(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                TextKt.m3864TextNvy7gAk("Send Auto-Replies Using", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f), 7, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composerStartRestartGroup, 54, 0, 131068);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(209624483, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda36
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$45(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(267606756, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda37
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$46(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                SectionTitle("Message Processing", composerStartRestartGroup, 6);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(325589029, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda38
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$47(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(383571302, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$48(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(441553575, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$49(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(499535848, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$50(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(515603220, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$56(function10, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                SectionTitle("My Customers", composerStartRestartGroup, 6);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(573585493, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$63(function11, settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(631567766, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$69(function8, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                SectionTitle("Hybrid Portal", composerStartRestartGroup, 6);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(689550039, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$74(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                SectionTitle("Customer Tools", composerStartRestartGroup, 6);
                SettingItem(ComposableLambdaKt.rememberComposableLambda(747532312, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$77(z, onEngageBotActiveChanged, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                SectionTitle("Processing Mode", composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5259constructorimpl2 = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -306976705, "C492@19394L51,488@19150L309,498@19721L52,494@19472L315:SettingsScreen.kt#oif8tm");
                if (processingMode == ProcessingMode.EXPRESS) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1672463238, "CC(remember):SettingsScreen.kt#9igjgp");
                i8 = i10 & 7168;
                if (i8 == 2048) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    function4 = onProcessingModeChanged;
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$82$lambda$79$lambda$78(function4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    function4 = onProcessingModeChanged;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProcessingModeItem("Express Mode", "Processes USSDs that can be completed in one request", z3, (Function0) objRememberedValue, composerStartRestartGroup, 54);
                if (processingMode == ProcessingMode.ADVANCED) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1672452773, "CC(remember):SettingsScreen.kt#9igjgp");
                z6 = i8 == 2048;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$82$lambda$81$lambda$80(function4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                ProcessingModeItem("Advanced Mode", "Processes USSDs that require multiple steps to complete", z5, (Function0) objRememberedValue2, composer2, 54);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                Function0<Unit> function12 = function8;
                function6 = function11;
                function5 = function12;
                function7 = function10;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function1<? super ProcessingMode, Unit> function13 = function4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$84(settings, onSettingChange, processingMode, function13, z, onEngageBotActiveChanged, function5, function7, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        i4 = i2 & 128;
        if (i4 != 0) {
            i3 |= 12582912;
            function3 = function1;
        } else {
            function3 = function1;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i5 = 8388608;
                } else {
                    i5 = 4194304;
                }
                i3 |= i5;
            }
        }
        i6 = i2 & 256;
        if (i6 != 0) {
            i3 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i7 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
            } else {
                i7 = 33554432;
            }
            i3 |= i7;
        }
        if ((i3 & 38347923) != 38347922) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            function4 = onProcessingModeChanged;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function5 = function0;
            function6 = function2;
            function7 = function3;
        } else {
            if (i9 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1235282173, "CC(remember):SettingsScreen.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                function8 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function8 = function0;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1235283581, "CC(remember):SettingsScreen.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                function3 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1235285277, "CC(remember):SettingsScreen.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                function9 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function9 = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-177485349, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent (SettingsScreen.kt:188)");
            }
            Modifier modifierVerticalScroll$default2 = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            final Function0 function14 = function3;
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl.getInserting()) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            } else {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -123660668, "C196@7752L25,199@7872L10,197@7786L174,203@7982L375,203@7970L387,213@8379L375,213@8367L387,223@8764L41,226@8902L10,224@8814L176,229@9011L361,229@8999L373,238@9393L361,238@9381L373,248@9764L41,251@9900L10,249@9814L174,254@10009L359,254@9997L371,263@10389L359,263@10377L371,274@10759L41,275@10809L34,276@10864L300,276@10852L312,285@11186L296,285@11174L308,294@11504L307,294@11492L319,303@11833L310,303@11821L322,311@12164L1404,311@12152L1416,346@13577L41,347@13627L28,348@13676L1343,348@13664L1355,383@15040L1413,383@15028L1425,419@16463L41,420@16513L29,421@16563L1188,421@16551L1200,452@17761L41,453@17811L30,454@17862L1131,454@17850L1143,485@19003L41,486@19053L31,487@19093L705:SettingsScreen.kt#oif8tm");
            SectionTitle("SIM Setup", composerStartRestartGroup, 6);
            float f3 = 8;
            final Function0 function15 = function9;
            int i11 = i3;
            TextKt.m3864TextNvy7gAk("SIM to receive payments", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f3), 7, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composerStartRestartGroup, 54, 0, 131068);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(501490601, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$41(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(35677664, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$42(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            float f4 = 16;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
            TextKt.m3864TextNvy7gAk("Bingwa SIM (To run USSDs)", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f3), 7, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composerStartRestartGroup, 54, 0, 131068);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(93659937, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$43(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(151642210, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$44(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
            TextKt.m3864TextNvy7gAk("Send Auto-Replies Using", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f3), 7, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composerStartRestartGroup, 54, 0, 131068);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(209624483, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$45(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(267606756, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$46(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
            SectionTitle("Message Processing", composerStartRestartGroup, 6);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(325589029, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda38
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$47(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(383571302, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$48(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(441553575, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$49(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(499535848, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$50(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(515603220, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$56(function14, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
            SectionTitle("My Customers", composerStartRestartGroup, 6);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(573585493, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$63(function15, settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(631567766, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$69(function8, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
            SectionTitle("Hybrid Portal", composerStartRestartGroup, 6);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(689550039, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$74(settings, onSettingChange, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
            SectionTitle("Customer Tools", composerStartRestartGroup, 6);
            SettingItem(ComposableLambdaKt.rememberComposableLambda(747532312, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$77(z, onEngageBotActiveChanged, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
            SectionTitle("Processing Mode", composerStartRestartGroup, 6);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5259constructorimpl2 = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl2.getInserting()) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            } else {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -306976705, "C492@19394L51,488@19150L309,498@19721L52,494@19472L315:SettingsScreen.kt#oif8tm");
            if (processingMode == ProcessingMode.EXPRESS) {
                z3 = true;
            } else {
                z3 = false;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1672463238, "CC(remember):SettingsScreen.kt#9igjgp");
            i8 = i11 & 7168;
            if (i8 == 2048) {
                z4 = true;
            } else {
                z4 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4) {
                function4 = onProcessingModeChanged;
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$82$lambda$79$lambda$78(function4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                function4 = onProcessingModeChanged;
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$82$lambda$79$lambda$78(function4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProcessingModeItem("Express Mode", "Processes USSDs that can be completed in one request", z3, (Function0) objRememberedValue, composerStartRestartGroup, 54);
            if (processingMode == ProcessingMode.ADVANCED) {
                z5 = true;
            } else {
                z5 = false;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1672452773, "CC(remember):SettingsScreen.kt#9igjgp");
            if (i8 == 2048) {
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$82$lambda$81$lambda$80(function4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$82$lambda$81$lambda$80(function4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            ProcessingModeItem("Advanced Mode", "Processes USSDs that require multiple steps to complete", z5, (Function0) objRememberedValue2, composer2, 54);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            Function0<Unit> function16 = function8;
            function6 = function15;
            function5 = function16;
            function7 = function14;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1 function17 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenContent$lambda$84(settings, onSettingChange, processingMode, function17, z, onEngageBotActiveChanged, function5, function7, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$41(Map map, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C204@7996L351:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(501490601, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:204)");
            }
            AppSetting appSetting = AppSetting.RECEIVE_PAYMENTS_VIA_SIM_1;
            Boolean bool = (Boolean) map.get(AppSetting.RECEIVE_PAYMENTS_VIA_SIM_1);
            SwitchSettingItem(appSetting, "SIM 1", bool != null ? bool.booleanValue() : false, function2, ComposableSingletons$SettingsScreenKt.INSTANCE.m9862getLambda$1051673943$app_debug(), composer, 24630, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$42(Map map, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C214@8393L351:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(35677664, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:214)");
            }
            AppSetting appSetting = AppSetting.RECEIVE_PAYMENTS_VIA_SIM_2;
            Boolean bool = (Boolean) map.get(AppSetting.RECEIVE_PAYMENTS_VIA_SIM_2);
            SwitchSettingItem(appSetting, "SIM 2", bool != null ? bool.booleanValue() : false, function2, ComposableSingletons$SettingsScreenKt.INSTANCE.getLambda$2093169888$app_debug(), composer, 24630, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$43(Map map, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C230@9025L337:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(93659937, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:230)");
            }
            AppSetting appSetting = AppSetting.DIAL_USSD_VIA_SIM_1;
            Boolean bool = (Boolean) map.get(AppSetting.DIAL_USSD_VIA_SIM_1);
            SwitchSettingItem(appSetting, "SIM 1", bool != null ? bool.booleanValue() : false, function2, ComposableSingletons$SettingsScreenKt.INSTANCE.m9867getLambda$2143815135$app_debug(), composer, 24630, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$44(Map map, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C239@9407L337:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(151642210, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:239)");
            }
            AppSetting appSetting = AppSetting.DIAL_USSD_VIA_SIM_2;
            Boolean bool = (Boolean) map.get(AppSetting.DIAL_USSD_VIA_SIM_2);
            SwitchSettingItem(appSetting, "SIM 2", bool != null ? bool.booleanValue() : false, function2, ComposableSingletons$SettingsScreenKt.INSTANCE.m9865getLambda$2085832862$app_debug(), composer, 24630, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$45(Map map, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C255@10023L335:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(209624483, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:255)");
            }
            AppSetting appSetting = AppSetting.SEND_SMS_VIA_SIM_1;
            Boolean bool = (Boolean) map.get(AppSetting.SEND_SMS_VIA_SIM_1);
            SwitchSettingItem(appSetting, "SIM 1", bool != null ? bool.booleanValue() : false, function2, ComposableSingletons$SettingsScreenKt.INSTANCE.m9864getLambda$2027850589$app_debug(), composer, 24630, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$46(Map map, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C264@10403L335:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(267606756, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:264)");
            }
            AppSetting appSetting = AppSetting.SEND_SMS_VIA_SIM_2;
            Boolean bool = (Boolean) map.get(AppSetting.SEND_SMS_VIA_SIM_2);
            SwitchSettingItem(appSetting, "SIM 2", bool != null ? bool.booleanValue() : false, function2, ComposableSingletons$SettingsScreenKt.INSTANCE.m9863getLambda$1969868316$app_debug(), composer, 24630, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$47(Map map, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C277@10878L276:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(325589029, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:277)");
            }
            AppSetting appSetting = AppSetting.PROCESS_MPESA_MESSAGES;
            Boolean bool = (Boolean) map.get(AppSetting.PROCESS_MPESA_MESSAGES);
            SwitchSettingItem(appSetting, "Process M-Pesa Messages", bool != null ? bool.booleanValue() : false, function2, null, composer, 54, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$48(Map map, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C286@11200L272:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(383571302, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:286)");
            }
            AppSetting appSetting = AppSetting.PROCESS_TILL_MESSAGES;
            Boolean bool = (Boolean) map.get(AppSetting.PROCESS_TILL_MESSAGES);
            SwitchSettingItem(appSetting, "Process Till Messages", bool != null ? bool.booleanValue() : false, function2, null, composer, 54, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$49(Map map, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C295@11518L283:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(441553575, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:295)");
            }
            AppSetting appSetting = AppSetting.PROCESS_PAY_BILL_MESSAGES;
            Boolean bool = (Boolean) map.get(AppSetting.PROCESS_PAY_BILL_MESSAGES);
            SwitchSettingItem(appSetting, "Process PayBill Messages", bool != null ? bool.booleanValue() : false, function2, null, composer, 54, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$50(Map map, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C304@11847L286:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(499535848, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:304)");
            }
            AppSetting appSetting = AppSetting.PROCESS_SITE_LINK_MESSAGES;
            Boolean bool = (Boolean) map.get(AppSetting.PROCESS_SITE_LINK_MESSAGES);
            SwitchSettingItem(appSetting, "Process SiteLink Messages", bool != null ? bool.booleanValue() : false, function2, null, composer, 54, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$56(final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C315@12289L27,312@12178L1380:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(515603220, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:312)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1573459407, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$56$lambda$52$lambda$51(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            float f = 4;
            Modifier modifierM1119paddingVpY3zN4 = PaddingKt.m1119paddingVpY3zN4(ClickableKt.m584clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (Function0) objRememberedValue, 15, null), Dp.m8684constructorimpl(2), Dp.m8684constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1119paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1501181647, "C318@12414L1130:SettingsScreen.kt#oif8tm");
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl2 = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1378543138, "C323@12607L657,338@13285L241:SettingsScreen.kt#oif8tm");
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl3 = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl3.rememberedValue(), Integer.valueOf(iHashCode3))) {
                composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
            }
            Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -35396909, "C328@12831L10,326@12718L159,333@13047L10,334@13119L11,331@12903L339:SettingsScreen.kt#oif8tm");
            TextKt.m3864TextNvy7gAk("Authorized Senders", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 6, 0, 131070);
            TextKt.m3864TextNvy7gAk("Messages from these senders will be processed too", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(f), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 54, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconKt.m3158Iconww6aTOc(ArrowForwardIosKt.getArrowForwardIos(Icons.AutoMirrored.Filled.INSTANCE), "Authorized Senders", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8684constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), 0L, composer, 432, 8);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$56$lambda$52$lambda$51(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$63(final Function0 function0, Map map, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C349@13690L1319:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(573585493, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:349)");
            }
            float f = 8;
            Modifier modifierM1120paddingVpY3zN4$default = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f), 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1120paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 583481293, "C358@14029L36,355@13910L734,376@14789L114,374@14663L332:SettingsScreen.kt#oif8tm");
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 988656061, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$63$lambda$62$lambda$58$lambda$57(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM1120paddingVpY3zN4$default2 = PaddingKt.m1120paddingVpY3zN4$default(ClickableKt.m584clickableoSLSa3U$default(modifierWeight$default, false, null, null, null, (Function0) objRememberedValue, 15, null), 0.0f, Dp.m8684constructorimpl(4), 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1120paddingVpY3zN4$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl2 = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -652765410, "C363@14261L10,361@14156L147,367@14443L10,368@14511L11,365@14324L302:SettingsScreen.kt#oif8tm");
            TextKt.m3864TextNvy7gAk("Auto-Save Contacts", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 6, 0, 131070);
            TextKt.m3864TextNvy7gAk("Tap to configure the name suffix", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 54, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Boolean bool = (Boolean) map.get(AppSetting.AUTO_SAVE_CONTACTS);
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            ComposerKt.sourceInformationMarkerStart(composer, 988680459, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(function2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$63$lambda$62$lambda$61$lambda$60(function2, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(zBooleanValue, (Function1) objRememberedValue2, ScaleKt.scale(PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8684constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, null), 0.8f), null, false, null, null, composer, 384, MenuKt.InTransitionDuration);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$63$lambda$62$lambda$58$lambda$57(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$63$lambda$62$lambda$61$lambda$60(Function2 function2, boolean z) {
        function2.invoke(AppSetting.AUTO_SAVE_CONTACTS, Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$69(final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C387@15165L21,384@15054L1389:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(631567766, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:384)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1346238411, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$69$lambda$65$lambda$64(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            float f = 8;
            Modifier modifierM1120paddingVpY3zN4$default = PaddingKt.m1120paddingVpY3zN4$default(ClickableKt.m584clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (Function0) objRememberedValue, 15, null), 0.0f, Dp.m8684constructorimpl(f), 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1120paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1247700693, "C390@15265L1164:SettingsScreen.kt#oif8tm");
            Modifier modifierM1120paddingVpY3zN4$default2 = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f), 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1120paddingVpY3zN4$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl2 = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 167540268, "C396@15508L650,410@16179L232:SettingsScreen.kt#oif8tm");
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl3 = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl3.rememberedValue(), Integer.valueOf(iHashCode3))) {
                composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
            }
            Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1510686776, "C401@15723L10,399@15619L150,405@15941L10,406@16013L11,403@15794L342:SettingsScreen.kt#oif8tm");
            TextKt.m3864TextNvy7gAk("BlackList", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 6, 0, 131070);
            TextKt.m3864TextNvy7gAk("Blacklisted customers will not be recommended offers", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(4), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 54, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconKt.m3158Iconww6aTOc(ArrowForwardIosKt.getArrowForwardIos(Icons.AutoMirrored.Filled.INSTANCE), "BlackList", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8684constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, null), 0L, composer, 432, 8);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$69$lambda$65$lambda$64(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$74(Map map, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C422@16577L1164:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(689550039, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:422)");
            }
            float f = 8;
            Modifier modifierM1120paddingVpY3zN4$default = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f), 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1120paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 2129560421, "C428@16796L587,444@17528L56,442@17400L327:SettingsScreen.kt#oif8tm");
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl2 = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 893318492, "C433@16995L10,431@16895L142,437@17182L10,438@17250L11,435@17058L307:SettingsScreen.kt#oif8tm");
            TextKt.m3864TextNvy7gAk("Hybrid Portal", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 6, 0, 131070);
            TextKt.m3864TextNvy7gAk("View and manage transactions remotely", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 54, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Boolean bool = (Boolean) map.get(AppSetting.HYBRID_PORTAL_ACTIVE);
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            ComposerKt.sourceInformationMarkerStart(composer, 761454707, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda50
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsScreenKt.SettingsScreenContent$lambda$83$lambda$74$lambda$73$lambda$72$lambda$71(function2, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(zBooleanValue, (Function1) objRememberedValue, ScaleKt.scale(PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8684constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, null), 0.8f), null, false, null, null, composer, 384, MenuKt.InTransitionDuration);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$74$lambda$73$lambda$72$lambda$71(Function2 function2, boolean z) {
        function2.invoke(AppSetting.HYBRID_PORTAL_ACTIVE, Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$77(boolean z, Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C455@17876L1107:SettingsScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(747532312, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenContent.<anonymous>.<anonymous> (SettingsScreen.kt:455)");
            }
            float f = 8;
            Modifier modifierM1120paddingVpY3zN4$default = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f), 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1120paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1392366691, "C461@18095L597,475@18709L260:SettingsScreen.kt#oif8tm");
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl2 = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1666360753, "C466@18290L10,464@18194L138,470@18491L10,471@18559L11,468@18353L321:SettingsScreen.kt#oif8tm");
            TextKt.m3864TextNvy7gAk("EngageBot", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 6, 0, 131070);
            TextKt.m3864TextNvy7gAk("Engage your customers on already recommended offers", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(2), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 54, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(z, function1, ScaleKt.scale(PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8684constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, null), 0.8f), null, false, null, null, composer, 384, MenuKt.InTransitionDuration);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$82$lambda$79$lambda$78(Function1 function1) {
        function1.invoke(ProcessingMode.EXPRESS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenContent$lambda$83$lambda$82$lambda$81$lambda$80(Function1 function1) {
        function1.invoke(ProcessingMode.ADVANCED);
        return Unit.INSTANCE;
    }

    public static final void SectionTitle(final String title, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1832974975);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SectionTitle)N(title)509@19916L10,510@19981L11,507@19858L211:SettingsScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(title) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1832974975, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.SectionTitle (SettingsScreen.kt:506)");
            }
            composer2 = composerStartRestartGroup;
            TextKt.m3864TextNvy7gAk(title, PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(16), 7, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineSmall(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, (i2 & 14) | 48, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SectionTitle$lambda$85(title, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SettingItem(final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(888275841);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingItem)N(content)520@20147L186:SettingsScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(content) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(888275841, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingItem (SettingsScreen.kt:519)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1120paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(2), 1, null), 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1718626845, "C526@20318L9:SettingsScreen.kt#oif8tm");
            content.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingItem$lambda$87(content, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ProcessingModeItem(final String title, final String description, final boolean z, final Function0<Unit> onSelect, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        Composer composerStartRestartGroup = composer.startRestartGroup(881113974);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProcessingModeItem)N(title,description,isSelected,onSelect)538@20477L664:SettingsScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(description) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onSelect) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(881113974, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.ProcessingModeItem (SettingsScreen.kt:537)");
            }
            float f = 8;
            Modifier modifierM1120paddingVpY3zN4$default = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f), 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1120paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 495928994, "C544@20648L88,551@20851L14,548@20745L390:SettingsScreen.kt#oif8tm");
            RadioButtonKt.RadioButton(z, onSelect, null, false, null, null, composerStartRestartGroup, (i3 >> 6) & WebSocketProtocol.PAYLOAD_SHORT, 60);
            Modifier modifierM1122paddingqDBjuR0$default = PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8684constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -399638264, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z2 = (i3 & 7168) == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt.ProcessingModeItem$lambda$91$lambda$89$lambda$88(onSelect);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM584clickableoSLSa3U$default = ClickableKt.m584clickableoSLSa3U$default(modifierM1122paddingqDBjuR0$default, false, null, null, null, (Function0) objRememberedValue, 15, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM584clickableoSLSa3U$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5259constructorimpl2 = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 281718632, "C555@20964L10,553@20890L108,559@21091L10,557@21011L114:SettingsScreen.kt#oif8tm");
            composer2 = composerStartRestartGroup;
            TextKt.m3864TextNvy7gAk(title, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composer2, i3 & 14, 0, 131070);
            TextKt.m3864TextNvy7gAk(description, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, (i3 >> 3) & 14, 0, 131070);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.ProcessingModeItem$lambda$92(title, description, z, onSelect, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProcessingModeItem$lambda$91$lambda$89$lambda$88(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0096  */
    /* JADX WARN: Code duplicated, block: B:46:0x0098  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:58:0x0111  */
    /* JADX WARN: Code duplicated, block: B:61:0x011d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0121  */
    /* JADX WARN: Code duplicated, block: B:67:0x0154  */
    /* JADX WARN: Code duplicated, block: B:70:0x0183  */
    /* JADX WARN: Code duplicated, block: B:71:0x018a  */
    /* JADX WARN: Code duplicated, block: B:74:0x0210  */
    /* JADX WARN: Code duplicated, block: B:75:0x0213  */
    /* JADX WARN: Code duplicated, block: B:79:0x021b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0233  */
    /* JADX WARN: Code duplicated, block: B:89:0x027b  */
    /* JADX WARN: Code duplicated, block: B:91:0x0281  */
    /* JADX WARN: Code duplicated, block: B:94:0x028e  */
    /* JADX WARN: Code duplicated, block: B:96:? A[RETURN, SYNTHETIC] */
    public static final void SwitchSettingItem(AppSetting appSetting, final String title, final boolean z, Function2<? super AppSetting, ? super Boolean, Unit> onCheckedChange, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function3;
        boolean z2;
        final Function2<? super AppSetting, ? super Boolean, Unit> function4;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i4;
        boolean z3;
        boolean z4;
        boolean z5;
        Object objRememberedValue;
        final AppSetting setting = appSetting;
        Intrinsics.checkNotNullParameter(setting, "setting");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(2032122409);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchSettingItem)N(setting,title,isChecked,onCheckedChange,icon)573@21352L603:SettingsScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(setting.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(title) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onCheckedChange) ? 2048 : 1024;
        }
        int i5 = i2 & 16;
        if (i5 == 0) {
            if ((i & 24576) == 0) {
                function3 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
            }
            if ((i3 & 9363) != 9362) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                function4 = onCheckedChange;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function5 = function3;
            } else {
                if (i5 != 0) {
                    function6 = null;
                } else {
                    function6 = function3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2032122409, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.SwitchSettingItem (SettingsScreen.kt:572)");
                }
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1120paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(4), 1, null), 0.0f, 1, null);
                Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 676937997, "C585@21734L10,581@21607L158,589@21845L32,587@21774L175:SettingsScreen.kt#oif8tm");
                if (function6 == null) {
                    composerStartRestartGroup.startReplaceGroup(676932880);
                } else {
                    composerStartRestartGroup.startReplaceGroup(676932881);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*580@21592L4");
                    function6.invoke(composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                i4 = i3;
                Function2<? super Composer, ? super Integer, Unit> function7 = function6;
                z3 = true;
                TextKt.m3864TextNvy7gAk(title, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, (i3 >> 3) & 14, 0, 131068);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 576034181, "CC(remember):SettingsScreen.kt#9igjgp");
                if ((i4 & 7168) == 2048) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if ((i4 & 14) != 4) {
                    z3 = false;
                }
                z5 = z4 | z3;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    setting = appSetting;
                    function4 = onCheckedChange;
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda51
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SettingsScreenKt.SwitchSettingItem$lambda$96$lambda$95$lambda$94(function4, setting, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    setting = appSetting;
                    function4 = onCheckedChange;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SwitchKt.Switch(z, (Function1) objRememberedValue, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composerStartRestartGroup, ((i4 >> 6) & 14) | 384, MenuKt.InTransitionDuration);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function5 = function7;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SwitchSettingItem$lambda$97(setting, title, z, function4, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function3 = function2;
        if ((i3 & 9363) != 9362) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            function4 = onCheckedChange;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function5 = function3;
        } else {
            if (i5 != 0) {
                function6 = null;
            } else {
                function6 = function3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2032122409, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.SwitchSettingItem (SettingsScreen.kt:572)");
            }
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(PaddingKt.m1120paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(4), 1, null), 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceEvenly2 = Arrangement.INSTANCE.getSpaceEvenly();
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceEvenly2, centerVertically2, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl.getInserting()) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            } else {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 676937997, "C585@21734L10,581@21607L158,589@21845L32,587@21774L175:SettingsScreen.kt#oif8tm");
            if (function6 == null) {
                composerStartRestartGroup.startReplaceGroup(676932880);
            } else {
                composerStartRestartGroup.startReplaceGroup(676932881);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*580@21592L4");
                function6.invoke(composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            i4 = i3;
            Function2<? super Composer, ? super Integer, Unit> function8 = function6;
            z3 = true;
            TextKt.m3864TextNvy7gAk(title, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, (i3 >> 3) & 14, 0, 131068);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 576034181, "CC(remember):SettingsScreen.kt#9igjgp");
            if ((i4 & 7168) == 2048) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((i4 & 14) != 4) {
                z3 = false;
            }
            z5 = z4 | z3;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z5) {
                setting = appSetting;
                function4 = onCheckedChange;
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda51
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsScreenKt.SwitchSettingItem$lambda$96$lambda$95$lambda$94(function4, setting, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                setting = appSetting;
                function4 = onCheckedChange;
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda51
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsScreenKt.SwitchSettingItem$lambda$96$lambda$95$lambda$94(function4, setting, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SwitchKt.Switch(z, (Function1) objRememberedValue, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composerStartRestartGroup, ((i4 >> 6) & 14) | 384, MenuKt.InTransitionDuration);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function5 = function8;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SwitchSettingItem$lambda$97(setting, title, z, function4, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchSettingItem$lambda$96$lambda$95$lambda$94(Function2 function2, AppSetting appSetting, boolean z) {
        function2.invoke(appSetting, Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    public static final void SettingsScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(782104092);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingsScreenPreview)601@22162L11,603@22258L2,605@22330L2,606@22360L2,607@22396L2,608@22441L2,599@22084L365:SettingsScreen.kt#oif8tm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(782104092, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SettingsScreenPreview (SettingsScreen.kt:597)");
            }
            Map mapEmptyMap = MapsKt.emptyMap();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -17237849, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda39
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsScreenKt.SettingsScreenPreview$lambda$99$lambda$98((AppSetting) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function2 function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProcessingMode processingMode = ProcessingMode.EXPRESS;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -17234786, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsScreenKt.SettingsScreenPreview$lambda$101$lambda$100((ProcessingMode) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -17232482, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda41
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsScreenKt.SettingsScreenPreview$lambda$103$lambda$102(((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function3 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -17231522, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda42
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function0 function0 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -17230370, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda43
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function0 function4 = (Function0) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -17228930, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda45
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SettingsScreenContent(mapEmptyMap, function2, processingMode, function1, false, function3, function0, function4, (Function0) objRememberedValue6, composerStartRestartGroup, 115043766, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda46
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingsScreenPreview$lambda$110(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenPreview$lambda$99$lambda$98(AppSetting appSetting, boolean z) {
        Intrinsics.checkNotNullParameter(appSetting, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenPreview$lambda$101$lambda$100(ProcessingMode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreenPreview$lambda$103$lambda$102(boolean z) {
        return Unit.INSTANCE;
    }

    private static final Agent SettingsScreen$lambda$0(State<Agent> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    private static final Map<AppSetting, Boolean> SettingsScreen$lambda$2(State<? extends Map<AppSetting, Boolean>> state) {
        return state.getValue();
    }

    private static final ProcessingMode SettingsScreen$lambda$3(State<? extends ProcessingMode> state) {
        return state.getValue();
    }

    private static final boolean SettingsScreen$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
