package com.example.bingwahybrid.presentation.offers.screens;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.MenuKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ExpandLessKt;
import androidx.compose.material.icons.filled.ExpandMoreKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TimePickerKt;
import androidx.compose.material3.TimePickerState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
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
import androidx.profileinstaller.ProfileVerifier;
import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.offers.model.OfferKt;
import com.example.bingwahybrid.presentation.offers.components.IncrementerKt;
import com.example.bingwahybrid.presentation.offers.dto.OfferSettingsState;
import com.example.bingwahybrid.presentation.offers.viewmodel.OfferSettingsViewModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.LinkHeader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OfferSettingsScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a9\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001ao\u0010\u0014\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0007¢\u0006\u0002\u0010\u001b\u001a9\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0012H\u0007¢\u0006\u0002\u0010!¨\u0006\"²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002²\u0006\f\u0010%\u001a\u0004\u0018\u00010&X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\u0010X\u008a\u008e\u0002"}, d2 = {"OfferSettingsScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "offerId", "Ljava/util/UUID;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/offers/viewmodel/OfferSettingsViewModel;", "(Landroidx/compose/ui/Modifier;Ljava/util/UUID;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/offers/viewmodel/OfferSettingsViewModel;Landroidx/compose/runtime/Composer;II)V", "SettingSwitch", LinkHeader.Parameters.Title, "", "subtitle", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "CollapsibleSection", "initiallyExpanded", "toggleable", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/lang/String;ZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "MyTimePickerDialog", "initialTime", "onDismissRequest", "Lkotlin/Function0;", "onTimeSelected", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_debug", "state", "Lcom/example/bingwahybrid/presentation/offers/dto/OfferSettingsState;", "currentOffer", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "showDialog", "expanded"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OfferSettingsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollapsibleSection$lambda$67(String str, String str2, boolean z, boolean z2, boolean z3, Function1 function1, Function3 function3, int i, int i2, Composer composer, int i3) {
        CollapsibleSection(str, str2, z, z2, z3, function1, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyTimePickerDialog$lambda$74(String str, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        MyTimePickerDialog(str, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$53(Modifier modifier, UUID uuid, NavHostController navHostController, OfferSettingsViewModel offerSettingsViewModel, int i, int i2, Composer composer, int i3) {
        OfferSettingsScreen(modifier, uuid, navHostController, offerSettingsViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingSwitch$lambda$56(String str, String str2, boolean z, Function1 function1, int i, Composer composer, int i2) {
        SettingSwitch(str, str2, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

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
    public static final void OfferSettingsScreen(Modifier modifier, final UUID offerId, final NavHostController navController, OfferSettingsViewModel offerSettingsViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        OfferSettingsViewModel offerSettingsViewModel2;
        final Modifier.Companion companion;
        final OfferSettingsViewModel offerSettingsViewModel3;
        final OfferSettingsViewModel offerSettingsViewModel4;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(offerId, "offerId");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(1799688847);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OfferSettingsScreen)N(modifier,offerId,navController,viewModel)65@2928L16,66@2992L16,67@3025L24,69@3079L44,69@3055L68,73@3164L170,73@3129L205,81@3367L577,97@3946L6706,80@3340L7312:OfferSettingsScreen.kt#6kthjn");
        int i4 = i2 & 1;
        if (i4 != 0) {
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
            i3 |= composerStartRestartGroup.changedInstance(offerId) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(navController) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                offerSettingsViewModel2 = offerSettingsViewModel;
                int i5 = composerStartRestartGroup.changedInstance(offerSettingsViewModel2) ? 2048 : 1024;
                i3 |= i5;
            } else {
                offerSettingsViewModel2 = offerSettingsViewModel;
            }
            i3 |= i5;
        } else {
            offerSettingsViewModel2 = offerSettingsViewModel;
        }
        int i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i6 & 1171) != 1170, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "63@2872L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 8) != 0) {
                    i6 &= -7169;
                }
                companion = modifier2;
                offerSettingsViewModel4 = offerSettingsViewModel2;
            } else {
                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 8) != 0) {
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
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(OfferSettingsViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    offerSettingsViewModel4 = (OfferSettingsViewModel) viewModel;
                    i6 &= -7169;
                } else {
                    offerSettingsViewModel4 = offerSettingsViewModel2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1799688847, i6, -1, "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreen (OfferSettingsScreen.kt:64)");
            }
            final State stateCollectAsState = SnapshotStateKt.collectAsState(offerSettingsViewModel4.getUiState(), null, composerStartRestartGroup, 0, r9);
            final State stateCollectAsState2 = SnapshotStateKt.collectAsState(offerSettingsViewModel4.getCurrentOffer(), null, composerStartRestartGroup, 0, r9);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1370824965, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(offerSettingsViewModel4) | composerStartRestartGroup.changedInstance(offerId);
            OfferSettingsScreenKt$OfferSettingsScreen$1$1 offerSettingsScreenKt$OfferSettingsScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || offerSettingsScreenKt$OfferSettingsScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                offerSettingsScreenKt$OfferSettingsScreen$1$1RememberedValue = new OfferSettingsScreenKt$OfferSettingsScreen$1$1(offerSettingsViewModel4, offerId, null);
                composerStartRestartGroup.updateRememberedValue(offerSettingsScreenKt$OfferSettingsScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(offerId, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) offerSettingsScreenKt$OfferSettingsScreen$1$1RememberedValue, composerStartRestartGroup, (i6 >> 3) & 14);
            String errorMessage = OfferSettingsScreen$lambda$0(stateCollectAsState).getErrorMessage();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1370822119, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(offerSettingsViewModel4);
            OfferSettingsScreenKt$OfferSettingsScreen$2$1 offerSettingsScreenKt$OfferSettingsScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || offerSettingsScreenKt$OfferSettingsScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                offerSettingsScreenKt$OfferSettingsScreen$2$1RememberedValue = new OfferSettingsScreenKt$OfferSettingsScreen$2$1(coroutineScope, offerSettingsViewModel4, stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(offerSettingsScreenKt$OfferSettingsScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(errorMessage, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) offerSettingsScreenKt$OfferSettingsScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1764710069, r9, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfferSettingsScreenKt.OfferSettingsScreen$lambda$7(coroutineScope, navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-156890080, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52(companion, stateCollectAsState2, stateCollectAsState, offerSettingsViewModel4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            OfferSettingsViewModel offerSettingsViewModel5 = offerSettingsViewModel4;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda, null, null, null, 0, 0L, 0L, null, composableLambdaRememberComposableLambda2, composerStartRestartGroup, 805306416, 509);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            offerSettingsViewModel3 = offerSettingsViewModel5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
            offerSettingsViewModel3 = offerSettingsViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfferSettingsScreenKt.OfferSettingsScreen$lambda$53(companion, offerId, navController, offerSettingsViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$7(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C86@3513L420,82@3381L553:OfferSettingsScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1764710069, i, -1, "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreen.<anonymous> (OfferSettingsScreen.kt:82)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$OfferSettingsScreenKt.INSTANCE.m9503getLambda$957923313$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(895586193, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfferSettingsScreenKt.OfferSettingsScreen$lambda$7$lambda$6(coroutineScope, navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$7$lambda$6(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C87@3556L239,87@3535L380:OfferSettingsScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(895586193, i, -1, "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreen.<anonymous>.<anonymous> (OfferSettingsScreen.kt:87)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1664873888, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OfferSettingsScreenKt.OfferSettingsScreen$lambda$7$lambda$6$lambda$5$lambda$4(coroutineScope, navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$OfferSettingsScreenKt.INSTANCE.getLambda$142944431$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$7$lambda$6$lambda$5$lambda$4(CoroutineScope coroutineScope, NavHostController navHostController) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OfferSettingsScreenKt$OfferSettingsScreen$3$1$1$1$1(navHostController, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52(Modifier modifier, final State state, final State state2, final OfferSettingsViewModel offerSettingsViewModel, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)105@4206L6440,99@3974L6672:OfferSettingsScreen.kt#6kthjn");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-156890080, i2, -1, "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreen.<anonymous> (OfferSettingsScreen.kt:99)");
            }
            Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(PaddingKt.m1120paddingVpY3zN4$default(PaddingKt.padding(modifier, paddingValues), Dp.m8684constructorimpl(16), 0.0f, 2, null));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_4 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(24));
            ComposerKt.sourceInformationMarkerStart(composer, -447496760, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(state) | composer.changed(state2) | composer.changedInstance(offerSettingsViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50(state, offerSettingsViewModel, state2, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LazyDslKt.LazyColumn(modifierImePadding, null, null, false, horizontalOrVerticalM977spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue, composer, 24576, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50(State state, final OfferSettingsViewModel offerSettingsViewModel, final State state2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        Offer offerOfferSettingsScreen$lambda$1 = OfferSettingsScreen$lambda$1(state);
        if ((offerOfferSettingsScreen$lambda$1 != null ? offerOfferSettingsScreen$lambda$1.getType() : null) == OfferType.DATA) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-794054320, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22(offerSettingsViewModel, state2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$OfferSettingsScreenKt.INSTANCE.m9500getLambda$33268473$app_debug(), 3, null);
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-45705291, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$28(state2, offerSettingsViewModel, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$OfferSettingsScreenKt.INSTANCE.getLambda$1400450092$app_debug(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1850729235, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41(offerSettingsViewModel, state2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$OfferSettingsScreenKt.INSTANCE.m9502getLambda$806941266$app_debug(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(236846703, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$44(offerSettingsViewModel, state2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        Offer offerOfferSettingsScreen$lambda$2 = OfferSettingsScreen$lambda$1(state);
        if (offerOfferSettingsScreen$lambda$2 != null && OfferKt.supportsStrictMode(offerOfferSettingsScreen$lambda$2)) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$OfferSettingsScreenKt.INSTANCE.m9501getLambda$503428345$app_debug(), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(467330302, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$47(offerSettingsViewModel, state2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1280634672, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$49(state2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22(final OfferSettingsViewModel offerSettingsViewModel, final State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C115@4660L38,116@4721L1283,110@4347L1657:OfferSettingsScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-794054320, i, -1, "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfferSettingsScreen.kt:110)");
            }
            boolean autoReschedule = OfferSettingsScreen$lambda$0(state).getAutoReschedule();
            ComposerKt.sourceInformationMarkerStart(composer, 1417989174, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(offerSettingsViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda36
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$9$lambda$8(offerSettingsViewModel, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CollapsibleSection("Auto Reschedule", "Reschedule already recommended offers to run the following day", false, true, autoReschedule, (Function1) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-421423890, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21(offerSettingsViewModel, state, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1575990, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$9$lambda$8(OfferSettingsViewModel offerSettingsViewModel, boolean z) {
        offerSettingsViewModel.updateAutoReschedule(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21(final OfferSettingsViewModel offerSettingsViewModel, State state, ColumnScope CollapsibleSection, Composer composer, int i) {
        final MutableState mutableState;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(CollapsibleSection, "$this$CollapsibleSection");
        ComposerKt.sourceInformation(composer2, "C:OfferSettingsScreen.kt#6kthjn");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-421423890, i, -1, "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfferSettingsScreen.kt:117)");
            }
            if (!OfferSettingsScreen$lambda$0(state).getAutoReschedule()) {
                composer2.startReplaceGroup(-454385004);
            } else {
                composer2.startReplaceGroup(-449611717);
                ComposerKt.sourceInformation(composer2, "118@4821L34,126@5256L21,122@5030L2,120@4885L501");
                ComposerKt.sourceInformationMarkerStart(composer2, -1261429232, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                Object objRememberedValue = composer2.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                String str = OfferSettingsScreen$lambda$0(state).getAutoRescheduleRunTime() + " Hrs";
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composer2, -1261415325, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                Object objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$14$lambda$13(mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierM584clickableoSLSa3U$default = ClickableKt.m584clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (Function0) objRememberedValue2, 15, null);
                ComposerKt.sourceInformationMarkerStart(composer2, -1261422576, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                Object objRememberedValue3 = composer2.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$16$lambda$15((String) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                OutlinedTextFieldKt.OutlinedTextField(str, (Function1<? super String, Unit>) objRememberedValue3, modifierM584clickableoSLSa3U$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$OfferSettingsScreenKt.INSTANCE.getLambda$1354329763$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1575984, 0, 0, 8388528);
                composer2 = composer;
                if (!OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$11(mutableState2)) {
                    composer2.startReplaceGroup(-454385004);
                } else {
                    composer2.startReplaceGroup(-448979224);
                    ComposerKt.sourceInformation(composer2, "132@5541L22,134@5697L195,131@5466L460");
                    String autoRescheduleRunTime = OfferSettingsScreen$lambda$0(state).getAutoRescheduleRunTime();
                    ComposerKt.sourceInformationMarkerStart(composer2, -1261406204, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        mutableState = mutableState2;
                        objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$18$lambda$17(mutableState);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        mutableState = mutableState2;
                    }
                    Function0 function0 = (Function0) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1261401039, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                    boolean zChangedInstance = composer2.changedInstance(offerSettingsViewModel);
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda31
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$20$lambda$19(offerSettingsViewModel, mutableState, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    MyTimePickerDialog(autoRescheduleRunTime, function0, (Function1) objRememberedValue5, composer2, 48);
                }
                composer2.endReplaceGroup();
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final boolean OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$16$lambda$15(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$14$lambda$13(MutableState mutableState) {
        OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$12(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$18$lambda$17(MutableState mutableState) {
        OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$12(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$20$lambda$19(OfferSettingsViewModel offerSettingsViewModel, MutableState mutableState, String timeString) {
        Intrinsics.checkNotNullParameter(timeString, "timeString");
        offerSettingsViewModel.updateRescheduleTime(timeString);
        OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$22$lambda$21$lambda$12(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$28(final State state, final OfferSettingsViewModel offerSettingsViewModel, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C155@6404L610,151@6187L827:OfferSettingsScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-45705291, i, -1, "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfferSettingsScreen.kt:151)");
            }
            CollapsibleSection("USSD Timeout", "Set a higher timeout when in low network coverage areas", true, false, false, null, ComposableLambdaKt.rememberComposableLambda(1358481619, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$28$lambda$27(state, offerSettingsViewModel, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1573302, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$28$lambda$27(final State state, final OfferSettingsViewModel offerSettingsViewModel, ColumnScope CollapsibleSection, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(CollapsibleSection, "$this$CollapsibleSection");
        ComposerKt.sourceInformation(composer, "C159@6588L163,163@6791L182,156@6426L570:OfferSettingsScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1358481619, i, -1, "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfferSettingsScreen.kt:156)");
            }
            int ussdTimeoutSeconds = OfferSettingsScreen$lambda$0(state).getUssdTimeoutSeconds();
            ComposerKt.sourceInformationMarkerStart(composer, -169216074, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(state) | composer.changedInstance(offerSettingsViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$28$lambda$27$lambda$24$lambda$23(offerSettingsViewModel, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -169209559, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(state) | composer.changedInstance(offerSettingsViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$28$lambda$27$lambda$26$lambda$25(offerSettingsViewModel, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IncrementerKt.Incrementer(null, "Timeout (seconds)", ussdTimeoutSeconds, function0, (Function0) objRememberedValue2, false, composer, 48, 33);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$28$lambda$27$lambda$24$lambda$23(OfferSettingsViewModel offerSettingsViewModel, State state) {
        offerSettingsViewModel.updateUssdTimeout(OfferSettingsScreen$lambda$0(state).getUssdTimeoutSeconds() + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$28$lambda$27$lambda$26$lambda$25(OfferSettingsViewModel offerSettingsViewModel, State state) {
        offerSettingsViewModel.updateUssdTimeout(RangesKt.coerceAtLeast(OfferSettingsScreen$lambda$0(state).getUssdTimeoutSeconds() - 1, 0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41(final OfferSettingsViewModel offerSettingsViewModel, final State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C182@7421L33,183@7473L1851,177@7165L2159:OfferSettingsScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1850729235, i, -1, "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfferSettingsScreen.kt:177)");
            }
            boolean autoRetry = OfferSettingsScreen$lambda$0(state).getAutoRetry();
            ComposerKt.sourceInformationMarkerStart(composer, -434324530, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(offerSettingsViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41$lambda$30$lambda$29(offerSettingsViewModel, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CollapsibleSection("Auto Retry", "Retry failed requests automatically", false, true, autoRetry, (Function1) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-1046839669, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41$lambda$40(state, offerSettingsViewModel, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1575990, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41$lambda$30$lambda$29(OfferSettingsViewModel offerSettingsViewModel, boolean z) {
        offerSettingsViewModel.updateAutoRetry(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41$lambda$40(final State state, final OfferSettingsViewModel offerSettingsViewModel, ColumnScope CollapsibleSection, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(CollapsibleSection, "$this$CollapsibleSection");
        ComposerKt.sourceInformation(composer2, "C:OfferSettingsScreen.kt#6kthjn");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1046839669, i, -1, "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfferSettingsScreen.kt:184)");
            }
            if (!OfferSettingsScreen$lambda$0(state).getAutoRetry()) {
                composer2.startReplaceGroup(-650457129);
            } else {
                composer2.startReplaceGroup(-642944775);
                ComposerKt.sourceInformation(composer2, "185@7542L1742");
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_4 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(16));
                ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer2, 6);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composer2);
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1535044466, "C193@8003L62,194@8113L313,189@7747L780,208@8804L62,209@8914L313,204@8557L701:OfferSettingsScreen.kt#6kthjn");
                Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                int retryIntervalMins = OfferSettingsScreen$lambda$0(state).getRetryIntervalMins();
                ComposerKt.sourceInformationMarkerStart(composer2, 1850639624, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                boolean zChangedInstance = composer2.changedInstance(offerSettingsViewModel) | composer2.changed(state);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41$lambda$40$lambda$39$lambda$32$lambda$31(offerSettingsViewModel, state);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 1850643395, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                boolean zChangedInstance2 = composer2.changedInstance(offerSettingsViewModel) | composer2.changed(state);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41$lambda$40$lambda$39$lambda$34$lambda$33(offerSettingsViewModel, state);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Function0 function1 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                IncrementerKt.Incrementer(modifierWeight$default, "Retry Interval (minutes)", retryIntervalMins, function0, function1, OfferSettingsScreen$lambda$0(state).getRetryIntervalMins() > 1, composer2, 48, 0);
                Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                int numberOfRetries = OfferSettingsScreen$lambda$0(state).getNumberOfRetries();
                ComposerKt.sourceInformationMarkerStart(composer2, 1850665256, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                boolean zChangedInstance3 = composer2.changedInstance(offerSettingsViewModel) | composer2.changed(state);
                Object objRememberedValue3 = composer2.rememberedValue();
                if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41$lambda$40$lambda$39$lambda$36$lambda$35(offerSettingsViewModel, state);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                Function0 function2 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 1850669027, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                boolean zChangedInstance4 = composer2.changedInstance(offerSettingsViewModel) | composer2.changed(state);
                Object objRememberedValue4 = composer2.rememberedValue();
                if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41$lambda$40$lambda$39$lambda$38$lambda$37(offerSettingsViewModel, state);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2 = composer2;
                IncrementerKt.Incrementer(modifierWeight$default2, "Number of Retries", numberOfRetries, function2, (Function0) objRememberedValue4, false, composer2, 48, 32);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41$lambda$40$lambda$39$lambda$32$lambda$31(OfferSettingsViewModel offerSettingsViewModel, State state) {
        offerSettingsViewModel.updateRetryInterval(OfferSettingsScreen$lambda$0(state).getRetryIntervalMins() + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41$lambda$40$lambda$39$lambda$34$lambda$33(OfferSettingsViewModel offerSettingsViewModel, State state) {
        offerSettingsViewModel.updateRetryInterval(RangesKt.coerceAtLeast(OfferSettingsScreen$lambda$0(state).getRetryIntervalMins() - 1, 0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41$lambda$40$lambda$39$lambda$36$lambda$35(OfferSettingsViewModel offerSettingsViewModel, State state) {
        offerSettingsViewModel.updateNumberOfRetries(OfferSettingsScreen$lambda$0(state).getNumberOfRetries() + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$41$lambda$40$lambda$39$lambda$38$lambda$37(OfferSettingsViewModel offerSettingsViewModel, State state) {
        offerSettingsViewModel.updateNumberOfRetries(RangesKt.coerceAtLeast(OfferSettingsScreen$lambda$0(state).getNumberOfRetries() - 1, 0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$44(final OfferSettingsViewModel offerSettingsViewModel, State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C232@9758L51,228@9495L315:OfferSettingsScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(236846703, i, -1, "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfferSettingsScreen.kt:228)");
            }
            boolean autoRetryConnectionProblems = OfferSettingsScreen$lambda$0(state).getAutoRetryConnectionProblems();
            ComposerKt.sourceInformationMarkerStart(composer, -23574462, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(offerSettingsViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$44$lambda$43$lambda$42(offerSettingsViewModel, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SettingSwitch("Auto Retry Connection Problems", "Automatically retry when connection issues occur", autoRetryConnectionProblems, (Function1) objRememberedValue, composer, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$44$lambda$43$lambda$42(OfferSettingsViewModel offerSettingsViewModel, boolean z) {
        offerSettingsViewModel.updateAutoRetryConnectionProblems(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$47(final OfferSettingsViewModel offerSettingsViewModel, State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C245@10252L34,241@10013L274:OfferSettingsScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(467330302, i, -1, "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfferSettingsScreen.kt:241)");
            }
            boolean strictMode = OfferSettingsScreen$lambda$0(state).getStrictMode();
            ComposerKt.sourceInformationMarkerStart(composer, -1867137472, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(offerSettingsViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OfferSettingsScreenKt.OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$47$lambda$46$lambda$45(offerSettingsViewModel, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SettingSwitch("Strict Mode", "Only mark successful on receiving commission", strictMode, (Function1) objRememberedValue, composer, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$47$lambda$46$lambda$45(OfferSettingsViewModel offerSettingsViewModel, boolean z) {
        offerSettingsViewModel.updateStrictMode(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferSettingsScreen$lambda$52$lambda$51$lambda$50$lambda$49(State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C:OfferSettingsScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1280634672, i, -1, "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OfferSettingsScreen.kt:249)");
            }
            String errorMessage = OfferSettingsScreen$lambda$0(state).getErrorMessage();
            if (errorMessage == null) {
                composer.startReplaceGroup(-806931462);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-806931461);
                ComposerKt.sourceInformation(composer, "*252@10500L11,250@10410L194");
                TextKt.m3864TextNvy7gAk(errorMessage, PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(8), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getError(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 48, 0, 262136);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void SettingSwitch(final String title, final String subtitle, final boolean z, final Function1<? super Boolean, Unit> onCheckedChange, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(1227046881);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingSwitch)N(title,subtitle,checked,onCheckedChange)268@10798L489:OfferSettingsScreen.kt#6kthjn");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(subtitle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCheckedChange) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1227046881, i2, -1, "com.example.bingwahybrid.presentation.offers.screens.SettingSwitch (OfferSettingsScreen.kt:267)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1868602803, "C273@10976L157,277@11142L139:OfferSettingsScreen.kt#6kthjn");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 107339498, "C274@11031L10,274@10997L55,275@11102L10,275@11065L58:OfferSettingsScreen.kt#6kthjn");
            int i3 = i2;
            composer2 = composerStartRestartGroup;
            TextKt.m3864TextNvy7gAk(title, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composer2, i2 & 14, 0, 131070);
            TextKt.m3864TextNvy7gAk(subtitle, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer2, (i3 >> 3) & 14, 0, 131070);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            int i4 = i3 >> 6;
            SwitchKt.Switch(z, onCheckedChange, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composer2, (i4 & 14) | 384 | (i4 & 112), MenuKt.InTransitionDuration);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfferSettingsScreenKt.SettingSwitch$lambda$56(title, subtitle, z, onCheckedChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollapsibleSection$lambda$58$lambda$57(boolean z) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:101:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:104:0x01de  */
    /* JADX WARN: Code duplicated, block: B:106:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:110:0x022f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0236  */
    /* JADX WARN: Code duplicated, block: B:115:0x023e  */
    /* JADX WARN: Code duplicated, block: B:118:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:121:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:122:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:125:0x02db  */
    /* JADX WARN: Code duplicated, block: B:127:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:130:0x036b  */
    /* JADX WARN: Code duplicated, block: B:133:0x0377  */
    /* JADX WARN: Code duplicated, block: B:134:0x037b  */
    /* JADX WARN: Code duplicated, block: B:137:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:139:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:142:0x0461  */
    /* JADX WARN: Code duplicated, block: B:143:0x0499  */
    /* JADX WARN: Code duplicated, block: B:145:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:146:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:150:0x04e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:151:0x04e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:158:0x053f  */
    /* JADX WARN: Code duplicated, block: B:160:0x0548  */
    /* JADX WARN: Code duplicated, block: B:163:0x0556  */
    /* JADX WARN: Code duplicated, block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0068  */
    /* JADX WARN: Code duplicated, block: B:33:0x006c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x0081  */
    /* JADX WARN: Code duplicated, block: B:42:0x0084  */
    /* JADX WARN: Code duplicated, block: B:44:0x0088  */
    /* JADX WARN: Code duplicated, block: B:46:0x0090  */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x009f  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:55:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:86:0x0109  */
    /* JADX WARN: Code duplicated, block: B:88:0x0119  */
    /* JADX WARN: Code duplicated, block: B:91:0x0121  */
    /* JADX WARN: Code duplicated, block: B:94:0x013d  */
    /* JADX WARN: Code duplicated, block: B:97:0x01a9  */
    public static final void CollapsibleSection(final String title, final String subtitle, boolean z, boolean z2, boolean z3, Function1<? super Boolean, Unit> function1, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        int i6;
        boolean z6;
        int i7;
        int i8;
        Function1<? super Boolean, Unit> function2;
        int i9;
        boolean z7;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3;
        final boolean z8;
        final Function1<? super Boolean, Unit> function4;
        final boolean z9;
        final boolean z10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z11;
        final boolean z12;
        boolean z13;
        Function1<? super Boolean, Unit> function5;
        Object objRememberedValue;
        final MutableState mutableState;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z14;
        Object objRememberedValue2;
        int iHashCode2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM5259constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        int iHashCode3;
        Function0<ComposeUiNode> constructor3;
        Composer composerM5259constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        boolean z15;
        int i10;
        Function1<? super Boolean, Unit> function6;
        ImageVector expandMore;
        Object objRememberedValue3;
        int i11;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2101339188);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollapsibleSection)N(title,subtitle,initiallyExpanded,toggleable,checked,onCheckedChange,content)292@11511L2,295@11588L46,297@11640L1317:OfferSettingsScreen.kt#6kthjn");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(subtitle) ? 32 : 16;
        }
        int i12 = i2 & 4;
        if (i12 == 0) {
            if ((i & 384) == 0) {
                z4 = z;
                i3 |= composerStartRestartGroup.changed(z4) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z5 = z2;
                    if (composerStartRestartGroup.changed(z5)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        z6 = z3;
                        if (composerStartRestartGroup.changed(z6)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function2 = function1;
                    } else {
                        function2 = function1;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                    }
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(content)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 599187) != 599186) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z7, i3 & 1)) {
                        function3 = content;
                        composerStartRestartGroup.skipToGroupEnd();
                        z8 = z4;
                        function4 = function2;
                        z9 = z5;
                    } else {
                        if (i12 != 0) {
                            z11 = false;
                        } else {
                            z11 = z4;
                        }
                        if (i4 != 0) {
                            z12 = false;
                        } else {
                            z12 = z5;
                        }
                        if (i6 != 0) {
                            z13 = true;
                        } else {
                            z13 = z6;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752323506, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return OfferSettingsScreenKt.CollapsibleSection$lambda$58$lambda$57(((Boolean) obj).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function5 = (Function1) objRememberedValue3;
                        } else {
                            function5 = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2101339188, i3, -1, "com.example.bingwahybrid.presentation.offers.screens.CollapsibleSection (OfferSettingsScreen.kt:294)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752320998, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z11), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float f = 8;
                        Modifier modifierM1120paddingVpY3zN4$default = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f), 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1120paddingVpY3zN4$default);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -53157831, "C305@11832L41,302@11747L1062:OfferSettingsScreen.kt#6kthjn");
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1248639201, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                        z14 = (i3 & 7168) == 2048;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z14 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierM584clickableoSLSa3U$default = ClickableKt.m584clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (Function0) objRememberedValue2, 15, null);
                        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM584clickableoSLSa3U$default);
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
                        Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                            composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                            composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                        }
                        Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1601221542, "C309@12020L336:OfferSettingsScreen.kt#6kthjn");
                        Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor3);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM5259constructorimpl3 = Updater.m5259constructorimpl(composerStartRestartGroup);
                        Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5259constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl3.rememberedValue(), Integer.valueOf(iHashCode3))) {
                            composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                            composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                        }
                        Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2135554748, "C312@12141L10,312@12107L55,315@12257L10,313@12179L163:OfferSettingsScreen.kt#6kthjn");
                        z15 = z12;
                        i10 = i3;
                        TextKt.m3864TextNvy7gAk(title, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, i3 & 14, 0, 131070);
                        TextKt.m3864TextNvy7gAk(subtitle, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, Integer.MAX_VALUE, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), composerStartRestartGroup, (i10 >> 3) & 14, 24576, 114686);
                        composerStartRestartGroup = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z15) {
                            composerStartRestartGroup.startReplaceGroup(1601565765);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "320@12403L171");
                            int i13 = i10 >> 12;
                            boolean z16 = z13;
                            Function1<? super Boolean, Unit> function7 = function5;
                            SwitchKt.Switch(z16, function7, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composerStartRestartGroup, (i13 & 14) | 384 | (i13 & 112), MenuKt.InTransitionDuration);
                            z6 = z16;
                            function6 = function7;
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            z6 = z13;
                            function6 = function5;
                            composerStartRestartGroup.startReplaceGroup(1601773155);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "326@12612L173");
                            if (CollapsibleSection$lambda$60(mutableState)) {
                                expandMore = ExpandLessKt.getExpandLess(Icons.INSTANCE.getDefault());
                            } else {
                                expandMore = ExpandMoreKt.getExpandMore(Icons.INSTANCE.getDefault());
                            }
                            IconKt.m3158Iconww6aTOc(expandMore, (String) null, (Modifier) null, 0L, composerStartRestartGroup, 48, 12);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if ((z15 || !z6) && (z15 || !CollapsibleSection$lambda$60(mutableState))) {
                            function3 = content;
                            composerStartRestartGroup.startReplaceGroup(-64849172);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-52072863);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "333@12890L29,334@12932L9");
                            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                            function3 = content;
                            function3.invoke(columnScopeInstance, composerStartRestartGroup, Integer.valueOf(((i10 >> 15) & 112) | 6));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function4 = function6;
                        z8 = z11;
                        z9 = z15;
                    }
                    z10 = z6;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OfferSettingsScreenKt.CollapsibleSection$lambda$67(title, subtitle, z8, z9, z10, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                z6 = z3;
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function2 = function1;
                } else {
                    function2 = function1;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i3 & 599187) != 599186) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z7, i3 & 1)) {
                    function3 = content;
                    composerStartRestartGroup.skipToGroupEnd();
                    z8 = z4;
                    function4 = function2;
                    z9 = z5;
                } else {
                    if (i12 != 0) {
                        z11 = false;
                    } else {
                        z11 = z4;
                    }
                    if (i4 != 0) {
                        z12 = false;
                    } else {
                        z12 = z5;
                    }
                    if (i6 != 0) {
                        z13 = true;
                    } else {
                        z13 = z6;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752323506, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OfferSettingsScreenKt.CollapsibleSection$lambda$58$lambda$57(((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function5 = (Function1) objRememberedValue3;
                    } else {
                        function5 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2101339188, i3, -1, "com.example.bingwahybrid.presentation.offers.screens.CollapsibleSection (OfferSettingsScreen.kt:294)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752320998, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z11), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float f2 = 8;
                    Modifier modifierM1120paddingVpY3zN4$default2 = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f2), 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1120paddingVpY3zN4$default2);
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
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -53157831, "C305@11832L41,302@11747L1062:OfferSettingsScreen.kt#6kthjn");
                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1248639201, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z14) {
                        objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM584clickableoSLSa3U$default2 = ClickableKt.m584clickableoSLSa3U$default(modifierFillMaxWidth$default2, false, null, null, null, (Function0) objRememberedValue2, 15, null);
                    Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically2, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM584clickableoSLSa3U$default2);
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
                    Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl2.getInserting()) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    } else {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1601221542, "C309@12020L336:OfferSettingsScreen.kt#6kthjn");
                    Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default2);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM5259constructorimpl3 = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl3.getInserting()) {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    } else {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2135554748, "C312@12141L10,312@12107L55,315@12257L10,313@12179L163:OfferSettingsScreen.kt#6kthjn");
                    z15 = z12;
                    i10 = i3;
                    TextKt.m3864TextNvy7gAk(title, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, i3 & 14, 0, 131070);
                    TextKt.m3864TextNvy7gAk(subtitle, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, Integer.MAX_VALUE, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), composerStartRestartGroup, (i10 >> 3) & 14, 24576, 114686);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z15) {
                        composerStartRestartGroup.startReplaceGroup(1601565765);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "320@12403L171");
                        int i14 = i10 >> 12;
                        boolean z17 = z13;
                        Function1<? super Boolean, Unit> function8 = function5;
                        SwitchKt.Switch(z17, function8, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composerStartRestartGroup, (i14 & 14) | 384 | (i14 & 112), MenuKt.InTransitionDuration);
                        z6 = z17;
                        function6 = function8;
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        z6 = z13;
                        function6 = function5;
                        composerStartRestartGroup.startReplaceGroup(1601773155);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "326@12612L173");
                        if (CollapsibleSection$lambda$60(mutableState)) {
                            expandMore = ExpandLessKt.getExpandLess(Icons.INSTANCE.getDefault());
                        } else {
                            expandMore = ExpandMoreKt.getExpandMore(Icons.INSTANCE.getDefault());
                        }
                        IconKt.m3158Iconww6aTOc(expandMore, (String) null, (Modifier) null, 0L, composerStartRestartGroup, 48, 12);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z15) {
                        function3 = content;
                        composerStartRestartGroup.startReplaceGroup(-64849172);
                    } else {
                        function3 = content;
                        composerStartRestartGroup.startReplaceGroup(-64849172);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function6;
                    z8 = z11;
                    z9 = z15;
                }
                z10 = z6;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfferSettingsScreenKt.CollapsibleSection$lambda$67(title, subtitle, z8, z9, z10, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z5 = z2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    z6 = z3;
                    if (composerStartRestartGroup.changed(z6)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function2 = function1;
                } else {
                    function2 = function1;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i3 & 599187) != 599186) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z7, i3 & 1)) {
                    function3 = content;
                    composerStartRestartGroup.skipToGroupEnd();
                    z8 = z4;
                    function4 = function2;
                    z9 = z5;
                } else {
                    if (i12 != 0) {
                        z11 = false;
                    } else {
                        z11 = z4;
                    }
                    if (i4 != 0) {
                        z12 = false;
                    } else {
                        z12 = z5;
                    }
                    if (i6 != 0) {
                        z13 = true;
                    } else {
                        z13 = z6;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752323506, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OfferSettingsScreenKt.CollapsibleSection$lambda$58$lambda$57(((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function5 = (Function1) objRememberedValue3;
                    } else {
                        function5 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2101339188, i3, -1, "com.example.bingwahybrid.presentation.offers.screens.CollapsibleSection (OfferSettingsScreen.kt:294)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752320998, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z11), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float f3 = 8;
                    Modifier modifierM1120paddingVpY3zN4$default3 = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f3), 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1120paddingVpY3zN4$default3);
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
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -53157831, "C305@11832L41,302@11747L1062:OfferSettingsScreen.kt#6kthjn");
                    Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1248639201, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z14) {
                        objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM584clickableoSLSa3U$default3 = ClickableKt.m584clickableoSLSa3U$default(modifierFillMaxWidth$default3, false, null, null, null, (Function0) objRememberedValue2, 15, null);
                    Arrangement.HorizontalOrVertical spaceBetween3 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(spaceBetween3, centerVertically3, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM584clickableoSLSa3U$default3);
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
                    Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl2.getInserting()) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    } else {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1601221542, "C309@12020L336:OfferSettingsScreen.kt#6kthjn");
                    Modifier modifierWeight$default3 = RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default3);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM5259constructorimpl3 = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyColumnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl3.getInserting()) {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    } else {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2135554748, "C312@12141L10,312@12107L55,315@12257L10,313@12179L163:OfferSettingsScreen.kt#6kthjn");
                    z15 = z12;
                    i10 = i3;
                    TextKt.m3864TextNvy7gAk(title, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, i3 & 14, 0, 131070);
                    TextKt.m3864TextNvy7gAk(subtitle, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, Integer.MAX_VALUE, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), composerStartRestartGroup, (i10 >> 3) & 14, 24576, 114686);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z15) {
                        composerStartRestartGroup.startReplaceGroup(1601565765);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "320@12403L171");
                        int i15 = i10 >> 12;
                        boolean z18 = z13;
                        Function1<? super Boolean, Unit> function9 = function5;
                        SwitchKt.Switch(z18, function9, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composerStartRestartGroup, (i15 & 14) | 384 | (i15 & 112), MenuKt.InTransitionDuration);
                        z6 = z18;
                        function6 = function9;
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        z6 = z13;
                        function6 = function5;
                        composerStartRestartGroup.startReplaceGroup(1601773155);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "326@12612L173");
                        if (CollapsibleSection$lambda$60(mutableState)) {
                            expandMore = ExpandLessKt.getExpandLess(Icons.INSTANCE.getDefault());
                        } else {
                            expandMore = ExpandMoreKt.getExpandMore(Icons.INSTANCE.getDefault());
                        }
                        IconKt.m3158Iconww6aTOc(expandMore, (String) null, (Modifier) null, 0L, composerStartRestartGroup, 48, 12);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z15) {
                        function3 = content;
                        composerStartRestartGroup.startReplaceGroup(-64849172);
                    } else {
                        function3 = content;
                        composerStartRestartGroup.startReplaceGroup(-64849172);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function6;
                    z8 = z11;
                    z9 = z15;
                }
                z10 = z6;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfferSettingsScreenKt.CollapsibleSection$lambda$67(title, subtitle, z8, z9, z10, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z6 = z3;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function2 = function1;
            } else {
                function2 = function1;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i3 & 599187) != 599186) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z7, i3 & 1)) {
                function3 = content;
                composerStartRestartGroup.skipToGroupEnd();
                z8 = z4;
                function4 = function2;
                z9 = z5;
            } else {
                if (i12 != 0) {
                    z11 = false;
                } else {
                    z11 = z4;
                }
                if (i4 != 0) {
                    z12 = false;
                } else {
                    z12 = z5;
                }
                if (i6 != 0) {
                    z13 = true;
                } else {
                    z13 = z6;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752323506, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfferSettingsScreenKt.CollapsibleSection$lambda$58$lambda$57(((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function5 = (Function1) objRememberedValue3;
                } else {
                    function5 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2101339188, i3, -1, "com.example.bingwahybrid.presentation.offers.screens.CollapsibleSection (OfferSettingsScreen.kt:294)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752320998, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z11), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float f4 = 8;
                Modifier modifierM1120paddingVpY3zN4$default4 = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f4), 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1120paddingVpY3zN4$default4);
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
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -53157831, "C305@11832L41,302@11747L1062:OfferSettingsScreen.kt#6kthjn");
                Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1248639201, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z14) {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM584clickableoSLSa3U$default4 = ClickableKt.m584clickableoSLSa3U$default(modifierFillMaxWidth$default4, false, null, null, null, (Function0) objRememberedValue2, 15, null);
                Arrangement.HorizontalOrVertical spaceBetween4 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(spaceBetween4, centerVertically4, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM584clickableoSLSa3U$default4);
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
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1601221542, "C309@12020L336:OfferSettingsScreen.kt#6kthjn");
                Modifier modifierWeight$default4 = RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default4);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5259constructorimpl3 = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyColumnMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl3.getInserting()) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                } else {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2135554748, "C312@12141L10,312@12107L55,315@12257L10,313@12179L163:OfferSettingsScreen.kt#6kthjn");
                z15 = z12;
                i10 = i3;
                TextKt.m3864TextNvy7gAk(title, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, i3 & 14, 0, 131070);
                TextKt.m3864TextNvy7gAk(subtitle, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, Integer.MAX_VALUE, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), composerStartRestartGroup, (i10 >> 3) & 14, 24576, 114686);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z15) {
                    composerStartRestartGroup.startReplaceGroup(1601565765);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "320@12403L171");
                    int i16 = i10 >> 12;
                    boolean z19 = z13;
                    Function1<? super Boolean, Unit> function10 = function5;
                    SwitchKt.Switch(z19, function10, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composerStartRestartGroup, (i16 & 14) | 384 | (i16 & 112), MenuKt.InTransitionDuration);
                    z6 = z19;
                    function6 = function10;
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    z6 = z13;
                    function6 = function5;
                    composerStartRestartGroup.startReplaceGroup(1601773155);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "326@12612L173");
                    if (CollapsibleSection$lambda$60(mutableState)) {
                        expandMore = ExpandLessKt.getExpandLess(Icons.INSTANCE.getDefault());
                    } else {
                        expandMore = ExpandMoreKt.getExpandMore(Icons.INSTANCE.getDefault());
                    }
                    IconKt.m3158Iconww6aTOc(expandMore, (String) null, (Modifier) null, 0L, composerStartRestartGroup, 48, 12);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z15) {
                    function3 = content;
                    composerStartRestartGroup.startReplaceGroup(-64849172);
                } else {
                    function3 = content;
                    composerStartRestartGroup.startReplaceGroup(-64849172);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function6;
                z8 = z11;
                z9 = z15;
            }
            z10 = z6;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfferSettingsScreenKt.CollapsibleSection$lambda$67(title, subtitle, z8, z9, z10, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z4 = z;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z5 = z2;
                if (composerStartRestartGroup.changed(z5)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    z6 = z3;
                    if (composerStartRestartGroup.changed(z6)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function2 = function1;
                } else {
                    function2 = function1;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i3 & 599187) != 599186) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z7, i3 & 1)) {
                    function3 = content;
                    composerStartRestartGroup.skipToGroupEnd();
                    z8 = z4;
                    function4 = function2;
                    z9 = z5;
                } else {
                    if (i12 != 0) {
                        z11 = false;
                    } else {
                        z11 = z4;
                    }
                    if (i4 != 0) {
                        z12 = false;
                    } else {
                        z12 = z5;
                    }
                    if (i6 != 0) {
                        z13 = true;
                    } else {
                        z13 = z6;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752323506, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return OfferSettingsScreenKt.CollapsibleSection$lambda$58$lambda$57(((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function5 = (Function1) objRememberedValue3;
                    } else {
                        function5 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2101339188, i3, -1, "com.example.bingwahybrid.presentation.offers.screens.CollapsibleSection (OfferSettingsScreen.kt:294)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752320998, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z11), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float f5 = 8;
                    Modifier modifierM1120paddingVpY3zN4$default5 = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f5), 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy9 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1120paddingVpY3zN4$default5);
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
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance9 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -53157831, "C305@11832L41,302@11747L1062:OfferSettingsScreen.kt#6kthjn");
                    Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1248639201, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z14) {
                        objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM584clickableoSLSa3U$default5 = ClickableKt.m584clickableoSLSa3U$default(modifierFillMaxWidth$default5, false, null, null, null, (Function0) objRememberedValue2, 15, null);
                    Arrangement.HorizontalOrVertical spaceBetween5 = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(spaceBetween5, centerVertically5, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM584clickableoSLSa3U$default5);
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
                    Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl2.getInserting()) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    } else {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1601221542, "C309@12020L336:OfferSettingsScreen.kt#6kthjn");
                    Modifier modifierWeight$default5 = RowScope.weight$default(rowScopeInstance5, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy10 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default5);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM5259constructorimpl3 = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyColumnMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl3.getInserting()) {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    } else {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance10 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2135554748, "C312@12141L10,312@12107L55,315@12257L10,313@12179L163:OfferSettingsScreen.kt#6kthjn");
                    z15 = z12;
                    i10 = i3;
                    TextKt.m3864TextNvy7gAk(title, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, i3 & 14, 0, 131070);
                    TextKt.m3864TextNvy7gAk(subtitle, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, Integer.MAX_VALUE, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), composerStartRestartGroup, (i10 >> 3) & 14, 24576, 114686);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z15) {
                        composerStartRestartGroup.startReplaceGroup(1601565765);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "320@12403L171");
                        int i17 = i10 >> 12;
                        boolean z110 = z13;
                        Function1<? super Boolean, Unit> function11 = function5;
                        SwitchKt.Switch(z110, function11, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composerStartRestartGroup, (i17 & 14) | 384 | (i17 & 112), MenuKt.InTransitionDuration);
                        z6 = z110;
                        function6 = function11;
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        z6 = z13;
                        function6 = function5;
                        composerStartRestartGroup.startReplaceGroup(1601773155);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "326@12612L173");
                        if (CollapsibleSection$lambda$60(mutableState)) {
                            expandMore = ExpandLessKt.getExpandLess(Icons.INSTANCE.getDefault());
                        } else {
                            expandMore = ExpandMoreKt.getExpandMore(Icons.INSTANCE.getDefault());
                        }
                        IconKt.m3158Iconww6aTOc(expandMore, (String) null, (Modifier) null, 0L, composerStartRestartGroup, 48, 12);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z15) {
                        function3 = content;
                        composerStartRestartGroup.startReplaceGroup(-64849172);
                    } else {
                        function3 = content;
                        composerStartRestartGroup.startReplaceGroup(-64849172);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function6;
                    z8 = z11;
                    z9 = z15;
                }
                z10 = z6;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfferSettingsScreenKt.CollapsibleSection$lambda$67(title, subtitle, z8, z9, z10, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z6 = z3;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function2 = function1;
            } else {
                function2 = function1;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i3 & 599187) != 599186) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z7, i3 & 1)) {
                function3 = content;
                composerStartRestartGroup.skipToGroupEnd();
                z8 = z4;
                function4 = function2;
                z9 = z5;
            } else {
                if (i12 != 0) {
                    z11 = false;
                } else {
                    z11 = z4;
                }
                if (i4 != 0) {
                    z12 = false;
                } else {
                    z12 = z5;
                }
                if (i6 != 0) {
                    z13 = true;
                } else {
                    z13 = z6;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752323506, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfferSettingsScreenKt.CollapsibleSection$lambda$58$lambda$57(((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function5 = (Function1) objRememberedValue3;
                } else {
                    function5 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2101339188, i3, -1, "com.example.bingwahybrid.presentation.offers.screens.CollapsibleSection (OfferSettingsScreen.kt:294)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752320998, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z11), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float f6 = 8;
                Modifier modifierM1120paddingVpY3zN4$default6 = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f6), 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy11 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1120paddingVpY3zN4$default6);
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
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance11 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -53157831, "C305@11832L41,302@11747L1062:OfferSettingsScreen.kt#6kthjn");
                Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1248639201, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z14) {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM584clickableoSLSa3U$default6 = ClickableKt.m584clickableoSLSa3U$default(modifierFillMaxWidth$default6, false, null, null, null, (Function0) objRememberedValue2, 15, null);
                Arrangement.HorizontalOrVertical spaceBetween6 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(spaceBetween6, centerVertically6, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM584clickableoSLSa3U$default6);
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
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier17, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1601221542, "C309@12020L336:OfferSettingsScreen.kt#6kthjn");
                Modifier modifierWeight$default6 = RowScope.weight$default(rowScopeInstance6, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy12 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default6);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5259constructorimpl3 = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyColumnMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl3.getInserting()) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                } else {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance12 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2135554748, "C312@12141L10,312@12107L55,315@12257L10,313@12179L163:OfferSettingsScreen.kt#6kthjn");
                z15 = z12;
                i10 = i3;
                TextKt.m3864TextNvy7gAk(title, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, i3 & 14, 0, 131070);
                TextKt.m3864TextNvy7gAk(subtitle, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, Integer.MAX_VALUE, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), composerStartRestartGroup, (i10 >> 3) & 14, 24576, 114686);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z15) {
                    composerStartRestartGroup.startReplaceGroup(1601565765);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "320@12403L171");
                    int i18 = i10 >> 12;
                    boolean z111 = z13;
                    Function1<? super Boolean, Unit> function12 = function5;
                    SwitchKt.Switch(z111, function12, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composerStartRestartGroup, (i18 & 14) | 384 | (i18 & 112), MenuKt.InTransitionDuration);
                    z6 = z111;
                    function6 = function12;
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    z6 = z13;
                    function6 = function5;
                    composerStartRestartGroup.startReplaceGroup(1601773155);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "326@12612L173");
                    if (CollapsibleSection$lambda$60(mutableState)) {
                        expandMore = ExpandLessKt.getExpandLess(Icons.INSTANCE.getDefault());
                    } else {
                        expandMore = ExpandMoreKt.getExpandMore(Icons.INSTANCE.getDefault());
                    }
                    IconKt.m3158Iconww6aTOc(expandMore, (String) null, (Modifier) null, 0L, composerStartRestartGroup, 48, 12);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z15) {
                    function3 = content;
                    composerStartRestartGroup.startReplaceGroup(-64849172);
                } else {
                    function3 = content;
                    composerStartRestartGroup.startReplaceGroup(-64849172);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function6;
                z8 = z11;
                z9 = z15;
            }
            z10 = z6;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfferSettingsScreenKt.CollapsibleSection$lambda$67(title, subtitle, z8, z9, z10, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z5 = z2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                z6 = z3;
                if (composerStartRestartGroup.changed(z6)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function2 = function1;
            } else {
                function2 = function1;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i3 & 599187) != 599186) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z7, i3 & 1)) {
                function3 = content;
                composerStartRestartGroup.skipToGroupEnd();
                z8 = z4;
                function4 = function2;
                z9 = z5;
            } else {
                if (i12 != 0) {
                    z11 = false;
                } else {
                    z11 = z4;
                }
                if (i4 != 0) {
                    z12 = false;
                } else {
                    z12 = z5;
                }
                if (i6 != 0) {
                    z13 = true;
                } else {
                    z13 = z6;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752323506, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OfferSettingsScreenKt.CollapsibleSection$lambda$58$lambda$57(((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function5 = (Function1) objRememberedValue3;
                } else {
                    function5 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2101339188, i3, -1, "com.example.bingwahybrid.presentation.offers.screens.CollapsibleSection (OfferSettingsScreen.kt:294)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752320998, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z11), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float f7 = 8;
                Modifier modifierM1120paddingVpY3zN4$default7 = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f7), 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy13 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1120paddingVpY3zN4$default7);
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
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier19, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance13 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -53157831, "C305@11832L41,302@11747L1062:OfferSettingsScreen.kt#6kthjn");
                Modifier modifierFillMaxWidth$default7 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1248639201, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z14) {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM584clickableoSLSa3U$default7 = ClickableKt.m584clickableoSLSa3U$default(modifierFillMaxWidth$default7, false, null, null, null, (Function0) objRememberedValue2, 15, null);
                Arrangement.HorizontalOrVertical spaceBetween7 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(spaceBetween7, centerVertically7, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM584clickableoSLSa3U$default7);
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
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1601221542, "C309@12020L336:OfferSettingsScreen.kt#6kthjn");
                Modifier modifierWeight$default7 = RowScope.weight$default(rowScopeInstance7, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy14 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default7);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5259constructorimpl3 = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyColumnMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl3.getInserting()) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                } else {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier111, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance14 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2135554748, "C312@12141L10,312@12107L55,315@12257L10,313@12179L163:OfferSettingsScreen.kt#6kthjn");
                z15 = z12;
                i10 = i3;
                TextKt.m3864TextNvy7gAk(title, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, i3 & 14, 0, 131070);
                TextKt.m3864TextNvy7gAk(subtitle, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, Integer.MAX_VALUE, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), composerStartRestartGroup, (i10 >> 3) & 14, 24576, 114686);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z15) {
                    composerStartRestartGroup.startReplaceGroup(1601565765);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "320@12403L171");
                    int i19 = i10 >> 12;
                    boolean z112 = z13;
                    Function1<? super Boolean, Unit> function13 = function5;
                    SwitchKt.Switch(z112, function13, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composerStartRestartGroup, (i19 & 14) | 384 | (i19 & 112), MenuKt.InTransitionDuration);
                    z6 = z112;
                    function6 = function13;
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    z6 = z13;
                    function6 = function5;
                    composerStartRestartGroup.startReplaceGroup(1601773155);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "326@12612L173");
                    if (CollapsibleSection$lambda$60(mutableState)) {
                        expandMore = ExpandLessKt.getExpandLess(Icons.INSTANCE.getDefault());
                    } else {
                        expandMore = ExpandMoreKt.getExpandMore(Icons.INSTANCE.getDefault());
                    }
                    IconKt.m3158Iconww6aTOc(expandMore, (String) null, (Modifier) null, 0L, composerStartRestartGroup, 48, 12);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z15) {
                    function3 = content;
                    composerStartRestartGroup.startReplaceGroup(-64849172);
                } else {
                    function3 = content;
                    composerStartRestartGroup.startReplaceGroup(-64849172);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function6;
                z8 = z11;
                z9 = z15;
            }
            z10 = z6;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfferSettingsScreenKt.CollapsibleSection$lambda$67(title, subtitle, z8, z9, z10, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z6 = z3;
        i8 = i2 & 32;
        if (i8 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2 = function1;
        } else {
            function2 = function1;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
        }
        if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        }
        if ((i3 & 599187) != 599186) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z7, i3 & 1)) {
            function3 = content;
            composerStartRestartGroup.skipToGroupEnd();
            z8 = z4;
            function4 = function2;
            z9 = z5;
        } else {
            if (i12 != 0) {
                z11 = false;
            } else {
                z11 = z4;
            }
            if (i4 != 0) {
                z12 = false;
            } else {
                z12 = z5;
            }
            if (i6 != 0) {
                z13 = true;
            } else {
                z13 = z6;
            }
            if (i8 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752323506, "CC(remember):OfferSettingsScreen.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OfferSettingsScreenKt.CollapsibleSection$lambda$58$lambda$57(((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function5 = (Function1) objRememberedValue3;
            } else {
                function5 = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2101339188, i3, -1, "com.example.bingwahybrid.presentation.offers.screens.CollapsibleSection (OfferSettingsScreen.kt:294)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -752320998, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z11), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float f8 = 8;
            Modifier modifierM1120paddingVpY3zN4$default8 = PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8684constructorimpl(f8), 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy15 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1120paddingVpY3zN4$default8);
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
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl.getInserting()) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            } else {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier112, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance15 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -53157831, "C305@11832L41,302@11747L1062:OfferSettingsScreen.kt#6kthjn");
            Modifier modifierFillMaxWidth$default8 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1248639201, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            if ((i3 & 7168) == 2048) {
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z14) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OfferSettingsScreenKt.CollapsibleSection$lambda$66$lambda$63$lambda$62(z12, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM584clickableoSLSa3U$default8 = ClickableKt.m584clickableoSLSa3U$default(modifierFillMaxWidth$default8, false, null, null, null, (Function0) objRememberedValue2, 15, null);
            Arrangement.HorizontalOrVertical spaceBetween8 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(spaceBetween8, centerVertically8, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM584clickableoSLSa3U$default8);
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
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl2.getInserting()) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            } else {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier113, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1601221542, "C309@12020L336:OfferSettingsScreen.kt#6kthjn");
            Modifier modifierWeight$default8 = RowScope.weight$default(rowScopeInstance8, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy16 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default8);
            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM5259constructorimpl3 = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyColumnMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl3.getInserting()) {
                composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
            } else {
                composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
            }
            Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier114, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance16 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2135554748, "C312@12141L10,312@12107L55,315@12257L10,313@12179L163:OfferSettingsScreen.kt#6kthjn");
            z15 = z12;
            i10 = i3;
            TextKt.m3864TextNvy7gAk(title, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composerStartRestartGroup, i3 & 14, 0, 131070);
            TextKt.m3864TextNvy7gAk(subtitle, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, Integer.MAX_VALUE, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodySmall(), composerStartRestartGroup, (i10 >> 3) & 14, 24576, 114686);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (z15) {
                composerStartRestartGroup.startReplaceGroup(1601565765);
                ComposerKt.sourceInformation(composerStartRestartGroup, "320@12403L171");
                int i110 = i10 >> 12;
                boolean z113 = z13;
                Function1<? super Boolean, Unit> function14 = function5;
                SwitchKt.Switch(z113, function14, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composerStartRestartGroup, (i110 & 14) | 384 | (i110 & 112), MenuKt.InTransitionDuration);
                z6 = z113;
                function6 = function14;
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                z6 = z13;
                function6 = function5;
                composerStartRestartGroup.startReplaceGroup(1601773155);
                ComposerKt.sourceInformation(composerStartRestartGroup, "326@12612L173");
                if (CollapsibleSection$lambda$60(mutableState)) {
                    expandMore = ExpandLessKt.getExpandLess(Icons.INSTANCE.getDefault());
                } else {
                    expandMore = ExpandMoreKt.getExpandMore(Icons.INSTANCE.getDefault());
                }
                IconKt.m3158Iconww6aTOc(expandMore, (String) null, (Modifier) null, 0L, composerStartRestartGroup, 48, 12);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (z15) {
                function3 = content;
                composerStartRestartGroup.startReplaceGroup(-64849172);
            } else {
                function3 = content;
                composerStartRestartGroup.startReplaceGroup(-64849172);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function6;
            z8 = z11;
            z9 = z15;
        }
        z10 = z6;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfferSettingsScreenKt.CollapsibleSection$lambda$67(title, subtitle, z8, z9, z10, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean CollapsibleSection$lambda$60(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CollapsibleSection$lambda$61(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollapsibleSection$lambda$66$lambda$63$lambda$62(boolean z, MutableState mutableState) {
        if (!z) {
            CollapsibleSection$lambda$61(mutableState, !CollapsibleSection$lambda$60(mutableState));
        }
        return Unit.INSTANCE;
    }

    public static final void MyTimePickerDialog(final String str, final Function0<Unit> onDismissRequest, final Function1<? super String, Unit> onTimeSelected, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(onTimeSelected, "onTimeSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(1011014099);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MyTimePickerDialog)N(initialTime,onDismissRequest,onTimeSelected)347@13177L354,360@13555L112,367@13755L316,376@14097L109,381@14223L134,365@13673L690:OfferSettingsScreen.kt#6kthjn");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismissRequest) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onTimeSelected) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1011014099, i3, -1, "com.example.bingwahybrid.presentation.offers.screens.MyTimePickerDialog (OfferSettingsScreen.kt:346)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 921947477, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                try {
                    String str2 = str;
                    if (str2 != null && !StringsKt.isBlank(str2)) {
                        objRememberedValue = LocalTime.parse(str, DateTimeFormatter.ofPattern("HH:mm"));
                    } else {
                        objRememberedValue = LocalTime.now();
                    }
                } catch (Exception unused) {
                    objRememberedValue = LocalTime.now();
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            LocalTime localTime = (LocalTime) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final TimePickerState timePickerStateRememberTimePickerState = TimePickerKt.rememberTimePickerState(localTime.getHour(), localTime.getMinute(), false, composerStartRestartGroup, 0, 4);
            composer2 = composerStartRestartGroup;
            AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0(onDismissRequest, ComposableLambdaKt.rememberComposableLambda(-1634127733, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfferSettingsScreenKt.MyTimePickerDialog$lambda$71(timePickerStateRememberTimePickerState, onTimeSelected, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(465610697, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfferSettingsScreenKt.MyTimePickerDialog$lambda$72(onDismissRequest, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, ComposableLambdaKt.rememberComposableLambda(-679748954, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfferSettingsScreenKt.MyTimePickerDialog$lambda$73(timePickerStateRememberTimePickerState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, ((i3 >> 3) & 14) | 1575984, 0, 16308);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfferSettingsScreenKt.MyTimePickerDialog$lambda$74(str, onDismissRequest, onTimeSelected, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyTimePickerDialog$lambda$71(final TimePickerState timePickerState, final Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C368@13790L227,368@13769L292:OfferSettingsScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1634127733, i, -1, "com.example.bingwahybrid.presentation.offers.screens.MyTimePickerDialog.<anonymous> (OfferSettingsScreen.kt:368)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1561280270, "CC(remember):OfferSettingsScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(timePickerState) | composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OfferSettingsScreenKt.MyTimePickerDialog$lambda$71$lambda$70$lambda$69(timePickerState, function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$OfferSettingsScreenKt.INSTANCE.getLambda$265296430$app_debug(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyTimePickerDialog$lambda$71$lambda$70$lambda$69(TimePickerState timePickerState, Function1 function1) {
        String str = LocalTime.of(timePickerState.getHour(), timePickerState.getMinute()).format(DateTimeFormatter.ofPattern("HH:mm"));
        Intrinsics.checkNotNull(str);
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyTimePickerDialog$lambda$72(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C377@14111L85:OfferSettingsScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(465610697, i, -1, "com.example.bingwahybrid.presentation.offers.screens.MyTimePickerDialog.<anonymous> (OfferSettingsScreen.kt:377)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$OfferSettingsScreenKt.INSTANCE.m9499getLambda$1929932436$app_debug(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyTimePickerDialog$lambda$73(TimePickerState timePickerState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C382@14237L110:OfferSettingsScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-679748954, i, -1, "com.example.bingwahybrid.presentation.offers.screens.MyTimePickerDialog.<anonymous> (OfferSettingsScreen.kt:382)");
            }
            TimePickerKt.m3916TimePickermT9BvqQ(timePickerState, ScaleKt.scale(Modifier.INSTANCE, 0.9f), null, 0, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfferSettingsState OfferSettingsScreen$lambda$0(State<OfferSettingsState> state) {
        return state.getValue();
    }

    private static final Offer OfferSettingsScreen$lambda$1(State<Offer> state) {
        return state.getValue();
    }
}
