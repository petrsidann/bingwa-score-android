package com.example.bingwahybrid.presentation.settings.autosave.screens;

import android.app.Activity;
import android.content.Context;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.MenuKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextFieldColors;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.lifecycle.viewmodel.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavHostController;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.utils.SnackbarManager;
import com.example.bingwahybrid.presentation.settings.autosave.components.AutoSaveContactsToggleHandlerKt;
import com.example.bingwahybrid.presentation.settings.autosave.viewmodel.AutoSaveContactsViewModel;
import com.example.bingwahybrid.presentation.ui.components.CustomButtonKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AutoSaveContactsSettingsScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001aa\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0003¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0016²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\f\u0010\u0018\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u008e\u0002"}, d2 = {"AutoSaveContactsSettingsScreen", "", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/settings/autosave/viewmodel/AutoSaveContactsViewModel;", "(Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/settings/autosave/viewmodel/AutoSaveContactsViewModel;Landroidx/compose/runtime/Composer;II)V", "AutoSaveContactsSettingsScreenContent", "isAutoSaveEnabled", "", "suffixInput", "", "onSuffixChange", "Lkotlin/Function1;", "onToggleAutoSave", "onSave", "Lkotlin/Function0;", "onBackPressed", "(ZLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AutoSaveContactsSettingsScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "AutoSaveContactsSettingsScreenDisabledPreview", "app_debug", "suffix", "snackBarMessage"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AutoSaveContactsSettingsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreen$lambda$28(NavHostController navHostController, AutoSaveContactsViewModel autoSaveContactsViewModel, int i, int i2, Composer composer, int i3) {
        AutoSaveContactsSettingsScreen(navHostController, autoSaveContactsViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreenContent$lambda$37(boolean z, String str, Function1 function1, Function1 function2, Function0 function0, Function0 function3, int i, Composer composer, int i2) {
        AutoSaveContactsSettingsScreenContent(z, str, function1, function2, function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreenDisabledPreview$lambda$39(int i, Composer composer, int i2) {
        AutoSaveContactsSettingsScreenDisabledPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreenPreview$lambda$38(int i, Composer composer, int i2) {
        AutoSaveContactsSettingsScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0046  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:53:0x0116  */
    /* JADX WARN: Code duplicated, block: B:56:0x0145  */
    /* JADX WARN: Code duplicated, block: B:57:0x0148  */
    /* JADX WARN: Code duplicated, block: B:60:0x0175  */
    /* JADX WARN: Code duplicated, block: B:65:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:72:0x01db  */
    /* JADX WARN: Code duplicated, block: B:74:0x01e1 A[PHI: r17
  0x01e1: PHI (r17v4 int) = (r17v1 int), (r17v6 int) binds: [B:73:0x01df, B:71:0x01d8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:78:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:83:0x0219  */
    /* JADX WARN: Code duplicated, block: B:85:0x021f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0231  */
    /* JADX WARN: Code duplicated, block: B:93:0x0239  */
    /* JADX WARN: Code duplicated, block: B:96:0x0290  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void AutoSaveContactsSettingsScreen(final NavHostController navController, AutoSaveContactsViewModel autoSaveContactsViewModel, Composer composer, final int i, final int i2) {
        int i3;
        CreationExtras.Empty defaultViewModelCreationExtras;
        int i4;
        int i5;
        Object objRememberedValue;
        final CoroutineScope coroutineScope;
        Context context;
        Activity activity;
        State stateCollectAsState;
        State stateCollectAsState2;
        Object objRememberedValue2;
        final MutableState mutableState;
        boolean zChanged;
        AutoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1 autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1RememberedValue;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        AutoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1 autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue;
        boolean zChangedInstance;
        Object objRememberedValue3;
        int i8;
        final AutoSaveContactsViewModel autoSaveContactsViewModel2 = autoSaveContactsViewModel;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(65825483);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AutoSaveContactsSettingsScreen)N(navController,viewModel)52@2502L24,53@2558L7,56@2664L16,57@2732L16,58@2802L16,59@2842L35,61@2906L36,61@2883L59,65@2980L144,65@2948L176,75@3375L351,73@3254L472,86@3759L368,96@4134L2706,85@3732L3108:AutoSaveContactsSettingsScreen.kt#jqlgt");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(navController) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) != 0) {
                i8 = 16;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(autoSaveContactsViewModel2) : composerStartRestartGroup.changedInstance(autoSaveContactsViewModel2)) {
                    i8 = 32;
                } else {
                    i8 = 16;
                }
            }
            i3 |= i8;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "50@2465L15");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 2) != 0) {
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
                    CreationExtras creationExtras = defaultViewModelCreationExtras;
                    i4 = 1;
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(AutoSaveContactsViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, creationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AutoSaveContactsViewModel autoSaveContactsViewModel3 = (AutoSaveContactsViewModel) viewModel;
                    i3 &= -113;
                    i5 = 0;
                    autoSaveContactsViewModel2 = autoSaveContactsViewModel3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(65825483, i3, -1, "com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreen (AutoSaveContactsSettingsScreen.kt:51)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume;
                if (context instanceof Activity) {
                    activity = (Activity) context;
                } else {
                    activity = null;
                }
                final State stateCollectAsState3 = SnapshotStateKt.collectAsState(autoSaveContactsViewModel2.isAutoSaveEnabled(), null, composerStartRestartGroup, i5, i4);
                stateCollectAsState = SnapshotStateKt.collectAsState(autoSaveContactsViewModel2.getAutoSaveContactsSuffix(), null, composerStartRestartGroup, i5, i4);
                stateCollectAsState2 = SnapshotStateKt.collectAsState(autoSaveContactsViewModel2.getSnackBarMessage(), null, composerStartRestartGroup, i5, i4);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1166202770, "CC(remember):AutoSaveContactsSettingsScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AutoSaveContactsSettingsScreen$lambda$1(stateCollectAsState), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String strAutoSaveContactsSettingsScreen$lambda$1 = AutoSaveContactsSettingsScreen$lambda$1(stateCollectAsState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1166200721, "CC(remember):AutoSaveContactsSettingsScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCollectAsState);
                autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1RememberedValue = new AutoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1(stateCollectAsState, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strAutoSaveContactsSettingsScreen$lambda$1, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                String strAutoSaveContactsSettingsScreen$lambda$2 = AutoSaveContactsSettingsScreen$lambda$2(stateCollectAsState2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1166198245, "CC(remember):AutoSaveContactsSettingsScreen.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope);
                i6 = (i3 & 112) ^ 48;
                if (i6 > 32 || !composerStartRestartGroup.changedInstance(autoSaveContactsViewModel2)) {
                    i7 = i3;
                    if ((i7 & 48) != 32) {
                        z = false;
                    }
                    z2 = z | zChanged2;
                    autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2 || autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue = new AutoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1(stateCollectAsState2, coroutineScope, autoSaveContactsViewModel2, null);
                        composerStartRestartGroup.updateRememberedValue(autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(strAutoSaveContactsSettingsScreen$lambda$2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                    ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions = new ActivityResultContracts.RequestMultiplePermissions();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1166185398, "CC(remember):AutoSaveContactsSettingsScreen.kt#9igjgp");
                    zChangedInstance = ((i6 <= 32 && composerStartRestartGroup.changedInstance(autoSaveContactsViewModel2)) || (i7 & 48) == 32) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$10$lambda$9(autoSaveContactsViewModel2, coroutineScope, (Map) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    final AutoSaveContactsViewModel autoSaveContactsViewModel4 = autoSaveContactsViewModel2;
                    final Activity activity2 = activity;
                    ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-1318056825, true, new Function2() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$14(navController, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(192180636, true, new Function3() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$27(autoSaveContactsViewModel4, navController, activity2, managedActivityResultLauncherRememberLauncherForActivityResult, stateCollectAsState3, mutableState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    autoSaveContactsViewModel2 = autoSaveContactsViewModel4;
                } else {
                    i7 = i3;
                }
                z = true;
                z2 = z | zChanged2;
                autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue = new AutoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1(stateCollectAsState2, coroutineScope, autoSaveContactsViewModel2, null);
                    composerStartRestartGroup.updateRememberedValue(autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue);
                } else {
                    autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue = new AutoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1(stateCollectAsState2, coroutineScope, autoSaveContactsViewModel2, null);
                    composerStartRestartGroup.updateRememberedValue(autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strAutoSaveContactsSettingsScreen$lambda$2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions2 = new ActivityResultContracts.RequestMultiplePermissions();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1166185398, "CC(remember):AutoSaveContactsSettingsScreen.kt#9igjgp");
                zChangedInstance = ((i6 <= 32 && composerStartRestartGroup.changedInstance(autoSaveContactsViewModel2)) || (i7 & 48) == 32) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$10$lambda$9(autoSaveContactsViewModel2, coroutineScope, (Map) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$10$lambda$9(autoSaveContactsViewModel2, coroutineScope, (Map) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions2, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                final AutoSaveContactsViewModel autoSaveContactsViewModel5 = autoSaveContactsViewModel2;
                final Activity activity3 = activity;
                ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-1318056825, true, new Function2() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$14(navController, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(192180636, true, new Function3() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$27(autoSaveContactsViewModel5, navController, activity3, managedActivityResultLauncherRememberLauncherForActivityResult2, stateCollectAsState3, mutableState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                autoSaveContactsViewModel2 = autoSaveContactsViewModel5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
            }
            i4 = 1;
            i5 = 0;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(65825483, i3, -1, "com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreen (AutoSaveContactsSettingsScreen.kt:51)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume2;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            final State stateCollectAsState4 = SnapshotStateKt.collectAsState(autoSaveContactsViewModel2.isAutoSaveEnabled(), null, composerStartRestartGroup, i5, i4);
            stateCollectAsState = SnapshotStateKt.collectAsState(autoSaveContactsViewModel2.getAutoSaveContactsSuffix(), null, composerStartRestartGroup, i5, i4);
            stateCollectAsState2 = SnapshotStateKt.collectAsState(autoSaveContactsViewModel2.getSnackBarMessage(), null, composerStartRestartGroup, i5, i4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1166202770, "CC(remember):AutoSaveContactsSettingsScreen.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AutoSaveContactsSettingsScreen$lambda$1(stateCollectAsState), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String strAutoSaveContactsSettingsScreen$lambda$3 = AutoSaveContactsSettingsScreen$lambda$1(stateCollectAsState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1166200721, "CC(remember):AutoSaveContactsSettingsScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCollectAsState);
            autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1RememberedValue = new AutoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1(stateCollectAsState, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1RememberedValue);
            } else {
                autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1RememberedValue = new AutoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1(stateCollectAsState, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strAutoSaveContactsSettingsScreen$lambda$3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            String strAutoSaveContactsSettingsScreen$lambda$4 = AutoSaveContactsSettingsScreen$lambda$2(stateCollectAsState2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1166198245, "CC(remember):AutoSaveContactsSettingsScreen.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope);
            i6 = (i3 & 112) ^ 48;
            if (i6 > 32) {
                i7 = i3;
                if ((i7 & 48) != 32) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                i7 = i3;
                if ((i7 & 48) != 32) {
                    z = true;
                } else {
                    z = false;
                }
            }
            z2 = z | zChanged3;
            autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue = new AutoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1(stateCollectAsState2, coroutineScope, autoSaveContactsViewModel2, null);
                composerStartRestartGroup.updateRememberedValue(autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue);
            } else {
                autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue = new AutoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1(stateCollectAsState2, coroutineScope, autoSaveContactsViewModel2, null);
                composerStartRestartGroup.updateRememberedValue(autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strAutoSaveContactsSettingsScreen$lambda$4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) autoSaveContactsSettingsScreenKt$AutoSaveContactsSettingsScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions3 = new ActivityResultContracts.RequestMultiplePermissions();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1166185398, "CC(remember):AutoSaveContactsSettingsScreen.kt#9igjgp");
            zChangedInstance = ((i6 <= 32 && composerStartRestartGroup.changedInstance(autoSaveContactsViewModel2)) || (i7 & 48) == 32) | composerStartRestartGroup.changedInstance(coroutineScope);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$10$lambda$9(autoSaveContactsViewModel2, coroutineScope, (Map) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$10$lambda$9(autoSaveContactsViewModel2, coroutineScope, (Map) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult3 = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions3, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
            final AutoSaveContactsViewModel autoSaveContactsViewModel6 = autoSaveContactsViewModel2;
            final Activity activity4 = activity;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-1318056825, true, new Function2() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$14(navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(192180636, true, new Function3() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$27(autoSaveContactsViewModel6, navController, activity4, managedActivityResultLauncherRememberLauncherForActivityResult3, stateCollectAsState4, mutableState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            autoSaveContactsViewModel2 = autoSaveContactsViewModel6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$28(navController, autoSaveContactsViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String AutoSaveContactsSettingsScreen$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreen$lambda$10$lambda$9(AutoSaveContactsViewModel autoSaveContactsViewModel, CoroutineScope coroutineScope, Map permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Collection collectionValues = permissions.values();
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            autoSaveContactsViewModel.updateAutoSaveEnabled(true);
            SnackbarManager.INSTANCE.showMessage(coroutineScope, "Contacts auto-save enabled");
        } else {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    SnackbarManager.INSTANCE.showMessage(coroutineScope, "Permission denied");
                }
            }
            autoSaveContactsViewModel.updateAutoSaveEnabled(true);
            SnackbarManager.INSTANCE.showMessage(coroutineScope, "Contacts auto-save enabled");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreen$lambda$14(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C89@3889L213,87@3773L344:AutoSaveContactsSettingsScreen.kt#jqlgt");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1318056825, i, -1, "com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreen.<anonymous> (AutoSaveContactsSettingsScreen.kt:87)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$AutoSaveContactsSettingsScreenKt.INSTANCE.m9573getLambda$355764149$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(-582985139, true, new Function2() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$14$lambda$13(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreen$lambda$14$lambda$13(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C90@3932L32,90@3911L173:AutoSaveContactsSettingsScreen.kt#jqlgt");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-582985139, i, -1, "com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreen.<anonymous>.<anonymous> (AutoSaveContactsSettingsScreen.kt:90)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1902968691, "CC(remember):AutoSaveContactsSettingsScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$14$lambda$13$lambda$12$lambda$11(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$AutoSaveContactsSettingsScreenKt.INSTANCE.m9569getLambda$1165285141$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreen$lambda$14$lambda$13$lambda$12$lambda$11(NavHostController navHostController) {
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreen$lambda$27(final AutoSaveContactsViewModel autoSaveContactsViewModel, final NavHostController navHostController, final Activity activity, final ManagedActivityResultLauncher managedActivityResultLauncher, State state, final MutableState mutableState, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)97@4161L2673:AutoSaveContactsSettingsScreen.kt#jqlgt");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(192180636, i2, -1, "com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreen.<anonymous> (AutoSaveContactsSettingsScreen.kt:97)");
            }
            float f = 16;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.m1120paddingVpY3zN4$default(PaddingKt.padding(Modifier.INSTANCE, paddingValues), Dp.m8684constructorimpl(f), 0.0f, 2, null), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -120953954, "C103@4341L1245,136@5758L10,133@5600L194,141@5896L20,143@5994L61,139@5808L562,154@6424L138,153@6384L440:AutoSaveContactsSettingsScreen.kt#jqlgt");
            float f2 = 8;
            Modifier modifierM1120paddingVpY3zN4$default = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f2), 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1120paddingVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1737107974, "C109@4561L367,119@5040L450,117@4945L627:AutoSaveContactsSettingsScreen.kt#jqlgt");
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
            ComposerKt.sourceInformationMarkerStart(composer, 620491575, "C110@4622L33,113@4803L10,111@4676L234:AutoSaveContactsSettingsScreen.kt#jqlgt");
            TextKt.m3864TextNvy7gAk("Auto-Save Contacts", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            TextKt.m3864TextNvy7gAk("Automatically save customers to contacts", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(2), 0.0f, 0.0f, 13, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 54, 0, 131068);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean zAutoSaveContactsSettingsScreen$lambda$0 = AutoSaveContactsSettingsScreen$lambda$0(state);
            ComposerKt.sourceInformationMarkerStart(composer, -1995683624, "CC(remember):AutoSaveContactsSettingsScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(activity) | composer.changedInstance(managedActivityResultLauncher) | composer.changedInstance(autoSaveContactsViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$27$lambda$26$lambda$19$lambda$18$lambda$17(activity, managedActivityResultLauncher, autoSaveContactsViewModel, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(zAutoSaveContactsSettingsScreen$lambda$0, (Function1) objRememberedValue, PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8684constructorimpl(f2), 0.0f, 0.0f, 0.0f, 14, null), null, false, null, null, composer, 384, MenuKt.InTransitionDuration);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m3864TextNvy7gAk("Contact Suffix", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(f), 0.0f, Dp.m8684constructorimpl(f2), 5, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 54, 0, 131068);
            String strAutoSaveContactsSettingsScreen$lambda$4 = AutoSaveContactsSettingsScreen$lambda$4(mutableState);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            boolean zAutoSaveContactsSettingsScreen$lambda$1 = AutoSaveContactsSettingsScreen$lambda$0(state);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m8361getTextPjHm6EE(), ImeAction.INSTANCE.m8301getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1658713542, "CC(remember):AutoSaveContactsSettingsScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$27$lambda$26$lambda$21$lambda$20(mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(strAutoSaveContactsSettingsScreen$lambda$4, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default, zAutoSaveContactsSettingsScreen$lambda$1, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1755300908, true, new Function2() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$27$lambda$26$lambda$23(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AutoSaveContactsSettingsScreenKt.INSTANCE.m9570getLambda$116560821$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 14156208, 12779520, 0, 8224560);
            ComposerKt.sourceInformationMarkerStart(composer, 1658730556, "CC(remember):AutoSaveContactsSettingsScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(autoSaveContactsViewModel) | composer.changedInstance(navHostController);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$27$lambda$26$lambda$25$lambda$24(autoSaveContactsViewModel, navHostController, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            float f3 = 0;
            CustomButtonKt.CustomButton((Function0) objRememberedValue3, PaddingKt.m1121paddingqDBjuR0(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(f3), Dp.m8684constructorimpl(f), Dp.m8684constructorimpl(f3), Dp.m8684constructorimpl(f3)), AutoSaveContactsSettingsScreen$lambda$0(state), false, ComposableSingletons$AutoSaveContactsSettingsScreenKt.INSTANCE.m9571getLambda$1219604570$app_debug(), composer, 24576, 8);
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
    public static final Unit AutoSaveContactsSettingsScreen$lambda$27$lambda$26$lambda$19$lambda$18$lambda$17(Activity activity, ManagedActivityResultLauncher managedActivityResultLauncher, final AutoSaveContactsViewModel autoSaveContactsViewModel, boolean z) {
        AutoSaveContactsToggleHandlerKt.handleAutoSaveContactsToggle(z, activity, managedActivityResultLauncher, new Function2() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreen$lambda$27$lambda$26$lambda$19$lambda$18$lambda$17$lambda$16(autoSaveContactsViewModel, (AppSetting) obj, ((Boolean) obj2).booleanValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreen$lambda$27$lambda$26$lambda$19$lambda$18$lambda$17$lambda$16(AutoSaveContactsViewModel autoSaveContactsViewModel, AppSetting appSetting, boolean z) {
        Intrinsics.checkNotNullParameter(appSetting, "<unused var>");
        autoSaveContactsViewModel.updateAutoSaveEnabled(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreen$lambda$27$lambda$26$lambda$21$lambda$20(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreen$lambda$27$lambda$26$lambda$23(MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C143@5996L57:AutoSaveContactsSettingsScreen.kt#jqlgt");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1755300908, i, -1, "com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreen.<anonymous>.<anonymous>.<anonymous> (AutoSaveContactsSettingsScreen.kt:143)");
            }
            String strAutoSaveContactsSettingsScreen$lambda$4 = AutoSaveContactsSettingsScreen$lambda$4(mutableState);
            if (strAutoSaveContactsSettingsScreen$lambda$4.length() == 0) {
                strAutoSaveContactsSettingsScreen$lambda$4 = "Bingwa";
            }
            TextKt.m3864TextNvy7gAk("e.g. Jane Doe " + ((Object) strAutoSaveContactsSettingsScreen$lambda$4), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreen$lambda$27$lambda$26$lambda$25$lambda$24(AutoSaveContactsViewModel autoSaveContactsViewModel, NavHostController navHostController, MutableState mutableState) {
        autoSaveContactsViewModel.saveAutoSaveContactsSuffix(AutoSaveContactsSettingsScreen$lambda$4(mutableState));
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AutoSaveContactsSettingsScreenContent(final boolean z, final String str, final Function1<? super String, Unit> function1, final Function1<? super Boolean, Unit> function2, final Function0<Unit> function0, final Function0<Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(599384617);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AutoSaveContactsSettingsScreenContent)N(isAutoSaveEnabled,suffixInput,onSuffixChange,onToggleAutoSave,onSave,onBackPressed)180@7172L342,190@7521L2134,179@7145L2510:AutoSaveContactsSettingsScreen.kt#jqlgt");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(599384617, i2, -1, "com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenContent (AutoSaveContactsSettingsScreen.kt:178)");
            }
            composer2 = composerStartRestartGroup;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-954790683, true, new Function2() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreenContent$lambda$30(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1067857594, true, new Function3() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreenContent$lambda$36(str, function1, z, function0, function2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreenContent$lambda$37(z, str, function1, function2, function0, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreenContent$lambda$30(final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C183@7295L194,181@7186L318:AutoSaveContactsSettingsScreen.kt#jqlgt");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-954790683, i, -1, "com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenContent.<anonymous> (AutoSaveContactsSettingsScreen.kt:181)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$AutoSaveContactsSettingsScreenKt.INSTANCE.getLambda$755011497$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(-267012821, true, new Function2() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreenContent$lambda$30$lambda$29(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreenContent$lambda$30$lambda$29(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C184@7317L154:AutoSaveContactsSettingsScreen.kt#jqlgt");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-267012821, i, -1, "com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenContent.<anonymous>.<anonymous> (AutoSaveContactsSettingsScreen.kt:184)");
            }
            IconButtonKt.IconButton(function0, null, false, null, null, null, ComposableSingletons$AutoSaveContactsSettingsScreenKt.INSTANCE.m9574getLambda$659466167$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoSaveContactsSettingsScreenContent$lambda$36(final String str, Function1 function1, boolean z, Function0 function0, Function1 function2, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)191@7548L2101:AutoSaveContactsSettingsScreen.kt#jqlgt");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1067857594, i2, -1, "com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenContent.<anonymous> (AutoSaveContactsSettingsScreen.kt:191)");
            }
            float f = 16;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.m1120paddingVpY3zN4$default(PaddingKt.padding(Modifier.INSTANCE, paddingValues), Dp.m8684constructorimpl(f), 0.0f, 2, null), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 199835132, "C197@7728L811,221@8711L10,218@8553L194,228@8941L61,224@8761L556,238@9331L308:AutoSaveContactsSettingsScreen.kt#jqlgt");
            float f2 = 8;
            Modifier modifierM1120paddingVpY3zN4$default = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f2), 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1120paddingVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 289157646, "C203@7948L367,211@8332L193:AutoSaveContactsSettingsScreen.kt#jqlgt");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1947436377, "C204@8009L33,207@8190L10,205@8063L234:AutoSaveContactsSettingsScreen.kt#jqlgt");
            TextKt.m3864TextNvy7gAk("Auto-Save Contacts", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            TextKt.m3864TextNvy7gAk("Automatically save customers to contacts", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(2), 0.0f, 0.0f, 13, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 54, 0, 131068);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(z, function2, PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8684constructorimpl(f2), 0.0f, 0.0f, 0.0f, 14, null), null, false, null, null, composer, 384, MenuKt.InTransitionDuration);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m3864TextNvy7gAk("Contact Suffix", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(f), 0.0f, Dp.m8684constructorimpl(f2), 5, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 54, 0, 131068);
            OutlinedTextFieldKt.OutlinedTextField(str, (Function1<? super String, Unit>) function1, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(188220746, true, new Function2() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreenContent$lambda$36$lambda$35$lambda$34(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AutoSaveContactsSettingsScreenKt.INSTANCE.m9572getLambda$231898199$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m8361getTextPjHm6EE(), ImeAction.INSTANCE.m8301getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null), (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 14156160, 12779520, 0, 8224560);
            float f3 = 0;
            CustomButtonKt.CustomButton(function0, PaddingKt.m1121paddingqDBjuR0(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(f3), Dp.m8684constructorimpl(f), Dp.m8684constructorimpl(f3), Dp.m8684constructorimpl(f3)), z, false, ComposableSingletons$AutoSaveContactsSettingsScreenKt.INSTANCE.m9575getLambda$794007996$app_debug(), composer, 24576, 8);
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
    public static final Unit AutoSaveContactsSettingsScreenContent$lambda$36$lambda$35$lambda$34(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C228@8943L57:AutoSaveContactsSettingsScreen.kt#jqlgt");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(188220746, i, -1, "com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenContent.<anonymous>.<anonymous>.<anonymous> (AutoSaveContactsSettingsScreen.kt:228)");
            }
            String str2 = str;
            if (str2.length() == 0) {
                str2 = "Bingwa";
            }
            TextKt.m3864TextNvy7gAk("e.g. Jane Doe " + ((Object) str2), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void AutoSaveContactsSettingsScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(669340595);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AutoSaveContactsSettingsScreenPreview)255@9754L276:AutoSaveContactsSettingsScreen.kt#jqlgt");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(669340595, i, -1, "com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenPreview (AutoSaveContactsSettingsScreen.kt:254)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableSingletons$AutoSaveContactsSettingsScreenKt.INSTANCE.getLambda$1033578847$app_debug(), composerStartRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreenPreview$lambda$38(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AutoSaveContactsSettingsScreenDisabledPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(983175759);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AutoSaveContactsSettingsScreenDisabledPreview)270@10165L277:AutoSaveContactsSettingsScreen.kt#jqlgt");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(983175759, i, -1, "com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenDisabledPreview (AutoSaveContactsSettingsScreen.kt:269)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableSingletons$AutoSaveContactsSettingsScreenKt.INSTANCE.getLambda$1504017403$app_debug(), composerStartRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.settings.autosave.screens.AutoSaveContactsSettingsScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoSaveContactsSettingsScreenKt.AutoSaveContactsSettingsScreenDisabledPreview$lambda$39(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean AutoSaveContactsSettingsScreen$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AutoSaveContactsSettingsScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AutoSaveContactsSettingsScreen$lambda$2(State<String> state) {
        return state.getValue();
    }
}
