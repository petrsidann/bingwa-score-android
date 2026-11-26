package com.example.bingwahybrid.presentation.quickdial.screens;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.PhoneKt;
import androidx.compose.material.icons.outlined.CheckKt;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material3.AlertDialogDefaults;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.hilt.lifecycle.viewmodel.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavHostController;
import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.presentation.quickdial.viewmodel.QuickDialViewModel;
import com.example.bingwahybrid.presentation.ui.components.CustomButtonKt;
import io.ktor.sse.ServerSentEventKt;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: QuickDialScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a)\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a9\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001a|\u0010\u0012\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000b2!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00010\u001a2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010 \u001a+\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010%\u001a\r\u0010&\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010'¨\u0006(²\u0006\n\u0010\u0018\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\u0010\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u008a\u0084\u0002²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\rX\u008a\u0084\u0002²\u0006\f\u0010)\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\f\u0010*\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"QuickDialScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/quickdial/viewmodel/QuickDialViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/quickdial/viewmodel/QuickDialViewModel;Landroidx/compose/runtime/Composer;II)V", "UssdResponseDialog", "message", "", "isUssdDialSuccess", "", "onDismiss", "Lkotlin/Function0;", "onFinishClick", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "QuickDialScreenContent", "offers", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "selectedOffer", "isDialing", "customerPhone", "onCustomerPhoneChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", HintConstants.AUTOFILL_HINT_PHONE, "onOfferChanged", "onDial", "(Ljava/util/List;Lcom/example/bingwahybrid/domain/offers/model/Offer;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SelectionChip", "offer", "isSelected", "onClick", "(Lcom/example/bingwahybrid/domain/offers/model/Offer;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "QuickDialScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "ussdResponse", "errorMessage", "showDialog", "dialogMessage"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class QuickDialScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreen$lambda$31(Modifier modifier, NavHostController navHostController, QuickDialViewModel quickDialViewModel, int i, int i2, Composer composer, int i3) {
        QuickDialScreen(modifier, navHostController, quickDialViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreenContent$lambda$49(List list, Offer offer, boolean z, String str, Function1 function1, Function1 function2, Function0 function0, int i, int i2, Composer composer, int i3) {
        QuickDialScreenContent(list, offer, z, str, function1, function2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreenPreview$lambda$60(int i, Composer composer, int i2) {
        QuickDialScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionChip$lambda$53(Offer offer, boolean z, Function0 function0, int i, Composer composer, int i2) {
        SelectionChip(offer, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UssdResponseDialog$lambda$37(String str, boolean z, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        UssdResponseDialog(str, z, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
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
    public static final void QuickDialScreen(Modifier modifier, final NavHostController navController, QuickDialViewModel quickDialViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        QuickDialViewModel quickDialViewModel2;
        final Modifier modifier3;
        final QuickDialViewModel quickDialViewModel3;
        final Modifier modifier4;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(1576924370);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(QuickDialScreen)N(modifier,navController,viewModel)78@3669L24,79@3743L16,80@3795L16,81@3861L16,82@3919L16,83@3983L16,84@4047L16,85@4086L34,86@4146L31,87@4233L16,89@4284L148,89@4255L177,96@4466L141,96@4437L170,103@4631L285,111@4918L718,103@4613L1023:QuickDialScreen.kt#e6wuav");
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
            i3 |= composerStartRestartGroup.changedInstance(navController) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                quickDialViewModel2 = quickDialViewModel;
                int i5 = composerStartRestartGroup.changedInstance(quickDialViewModel2) ? 256 : 128;
                i3 |= i5;
            } else {
                quickDialViewModel2 = quickDialViewModel;
            }
            i3 |= i5;
        } else {
            quickDialViewModel2 = quickDialViewModel;
        }
        int i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i6 & 147) != 146, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "76@3632L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i6 &= -897;
                }
                modifier4 = modifier2;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
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
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(QuickDialViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i6 &= -897;
                    modifier4 = companion;
                    quickDialViewModel2 = (QuickDialViewModel) viewModel;
                } else {
                    modifier4 = companion;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1576924370, i6, -1, "com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreen (QuickDialScreen.kt:77)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State stateCollectAsState = SnapshotStateKt.collectAsState(quickDialViewModel2.getCustomerPhone(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState2 = SnapshotStateKt.collectAsState(quickDialViewModel2.getOffers(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState3 = SnapshotStateKt.collectAsState(quickDialViewModel2.getSelectedOffer(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState4 = SnapshotStateKt.collectAsState(quickDialViewModel2.isDialing(), null, composerStartRestartGroup, 0, 1);
            State stateCollectAsState5 = SnapshotStateKt.collectAsState(quickDialViewModel2.getUssdResponse(), null, composerStartRestartGroup, 0, 1);
            State stateCollectAsState6 = SnapshotStateKt.collectAsState(quickDialViewModel2.getErrorMessage(), null, composerStartRestartGroup, 0, 1);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -699115532, "CC(remember):QuickDialScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -699113615, "CC(remember):QuickDialScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            State stateCollectAsState7 = SnapshotStateKt.collectAsState(quickDialViewModel2.getUssdDialSuccess(), null, composerStartRestartGroup, 0, 1);
            String strQuickDialScreen$lambda$4 = QuickDialScreen$lambda$4(stateCollectAsState5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -699109082, "CC(remember):QuickDialScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsState5) | composerStartRestartGroup.changedInstance(quickDialViewModel2);
            QuickDialScreenKt$QuickDialScreen$1$1 quickDialScreenKt$QuickDialScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || quickDialScreenKt$QuickDialScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                quickDialScreenKt$QuickDialScreen$1$1RememberedValue = new QuickDialScreenKt$QuickDialScreen$1$1(stateCollectAsState5, quickDialViewModel2, mutableState2, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(quickDialScreenKt$QuickDialScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strQuickDialScreen$lambda$4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) quickDialScreenKt$QuickDialScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            String strQuickDialScreen$lambda$5 = QuickDialScreen$lambda$5(stateCollectAsState6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -699103265, "CC(remember):QuickDialScreen.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsState6) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(quickDialViewModel2);
            QuickDialScreenKt$QuickDialScreen$2$1 quickDialScreenKt$QuickDialScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || quickDialScreenKt$QuickDialScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                quickDialScreenKt$QuickDialScreen$2$1RememberedValue = new QuickDialScreenKt$QuickDialScreen$2$1(stateCollectAsState6, coroutineScope, quickDialViewModel2, null);
                composerStartRestartGroup.updateRememberedValue(quickDialScreenKt$QuickDialScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strQuickDialScreen$lambda$5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) quickDialScreenKt$QuickDialScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            final QuickDialViewModel quickDialViewModel4 = quickDialViewModel2;
            Modifier modifier5 = modifier4;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-1682062194, true, new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickDialScreenKt.QuickDialScreen$lambda$18(navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-740454365, true, new Function3() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return QuickDialScreenKt.QuickDialScreen$lambda$26(modifier4, quickDialViewModel4, stateCollectAsState3, stateCollectAsState2, stateCollectAsState, stateCollectAsState4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            composerStartRestartGroup = composerStartRestartGroup;
            if (!QuickDialScreen$lambda$7(mutableState)) {
                composerStartRestartGroup.startReplaceGroup(-201800368);
            } else {
                composerStartRestartGroup.startReplaceGroup(-196179448);
                ComposerKt.sourceInformation(composerStartRestartGroup, "136@5800L22,137@5852L22,133@5668L216");
                String strQuickDialScreen$lambda$10 = QuickDialScreen$lambda$10(mutableState2);
                boolean zQuickDialScreen$lambda$12 = QuickDialScreen$lambda$12(stateCollectAsState7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -699060696, "CC(remember):QuickDialScreen.kt#9igjgp");
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return QuickDialScreenKt.QuickDialScreen$lambda$28$lambda$27(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function0 function0 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -699059032, "CC(remember):QuickDialScreen.kt#9igjgp");
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return QuickDialScreenKt.QuickDialScreen$lambda$30$lambda$29(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                UssdResponseDialog(strQuickDialScreen$lambda$10, zQuickDialScreen$lambda$12, function0, (Function0) objRememberedValue5, composerStartRestartGroup, 3456);
                composerStartRestartGroup = composerStartRestartGroup;
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            quickDialViewModel3 = quickDialViewModel4;
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            quickDialViewModel3 = quickDialViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickDialScreenKt.QuickDialScreen$lambda$31(modifier3, navController, quickDialViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean QuickDialScreen$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QuickDialScreen$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String QuickDialScreen$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreen$lambda$18(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C104@4700L209,104@4641L269:QuickDialScreen.kt#e6wuav");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1682062194, i, -1, "com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreen.<anonymous> (QuickDialScreen.kt:104)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$QuickDialScreenKt.INSTANCE.getLambda$202752594$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(448560468, true, new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickDialScreenKt.QuickDialScreen$lambda$18$lambda$17(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreen$lambda$18$lambda$17(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C105@4735L60,105@4714L185:QuickDialScreen.kt#e6wuav");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(448560468, i, -1, "com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreen.<anonymous>.<anonymous> (QuickDialScreen.kt:105)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1569881328, "CC(remember):QuickDialScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickDialScreenKt.QuickDialScreen$lambda$18$lambda$17$lambda$16$lambda$15(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$QuickDialScreenKt.INSTANCE.m9543getLambda$1699659022$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreen$lambda$18$lambda$17$lambda$16$lambda$15(NavHostController navHostController) {
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreen$lambda$26(Modifier modifier, final QuickDialViewModel quickDialViewModel, final State state, State state2, State state3, State state4, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)112@4945L685:QuickDialScreen.kt#e6wuav");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-740454365, i2, -1, "com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreen.<anonymous> (QuickDialScreen.kt:112)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.padding(modifier, paddingValues), 0.0f, 1, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, -578415250, "C120@5225L52,121@5312L161,125@5500L20,117@5080L540:QuickDialScreen.kt#e6wuav");
            List<Offer> listQuickDialScreen$lambda$1 = QuickDialScreen$lambda$1(state2);
            String strQuickDialScreen$lambda$0 = QuickDialScreen$lambda$0(state3);
            Offer offerQuickDialScreen$lambda$2 = QuickDialScreen$lambda$2(state);
            boolean zQuickDialScreen$lambda$3 = QuickDialScreen$lambda$3(state4);
            ComposerKt.sourceInformationMarkerStart(composer, 1643913581, "CC(remember):QuickDialScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(quickDialViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QuickDialScreenKt.QuickDialScreen$lambda$26$lambda$25$lambda$20$lambda$19(quickDialViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1643916474, "CC(remember):QuickDialScreen.kt#9igjgp");
            boolean zChanged = composer.changed(state) | composer.changedInstance(quickDialViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QuickDialScreenKt.QuickDialScreen$lambda$26$lambda$25$lambda$22$lambda$21(quickDialViewModel, state, (Offer) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1643922349, "CC(remember):QuickDialScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(quickDialViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickDialScreenKt.QuickDialScreen$lambda$26$lambda$25$lambda$24$lambda$23(quickDialViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            QuickDialScreenContent(listQuickDialScreen$lambda$1, offerQuickDialScreen$lambda$2, zQuickDialScreen$lambda$3, strQuickDialScreen$lambda$0, function1, function2, (Function0) objRememberedValue3, composer, 0, 0);
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
    public static final Unit QuickDialScreen$lambda$26$lambda$25$lambda$20$lambda$19(QuickDialViewModel quickDialViewModel, String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        quickDialViewModel.onCustomerPhoneChanged(phone);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreen$lambda$26$lambda$25$lambda$22$lambda$21(QuickDialViewModel quickDialViewModel, State state, Offer offer) {
        Intrinsics.checkNotNullParameter(offer, "offer");
        if (Intrinsics.areEqual(offer, QuickDialScreen$lambda$2(state))) {
            offer = null;
        }
        quickDialViewModel.onSelectOffer(offer);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreen$lambda$26$lambda$25$lambda$24$lambda$23(QuickDialViewModel quickDialViewModel) {
        quickDialViewModel.dial();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreen$lambda$28$lambda$27(MutableState mutableState) {
        QuickDialScreen$lambda$8(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreen$lambda$30$lambda$29(MutableState mutableState) {
        QuickDialScreen$lambda$8(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final void UssdResponseDialog(final String str, final boolean z, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i) {
        int i2;
        Function0<Unit> function2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1296313407);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(UssdResponseDialog)N(message,isUssdDialSuccess,onDismiss,onFinishClick)152@6178L2775,149@6057L2896:QuickDialScreen.kt#e6wuav");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function2 = function0;
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        } else {
            function2 = function0;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1296313407, i2, -1, "com.example.bingwahybrid.presentation.quickdial.screens.UssdResponseDialog (QuickDialScreen.kt:148)");
            }
            AndroidDialog_androidKt.Dialog(function2, new DialogProperties(false, false, false, 5, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(1709926920, true, new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickDialScreenKt.UssdResponseDialog$lambda$36(z, str, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 6) & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickDialScreenKt.UssdResponseDialog$lambda$37(str, z, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UssdResponseDialog$lambda$36(final boolean z, final String str, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C153@6188L2759:QuickDialScreen.kt#e6wuav");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1709926920, i, -1, "com.example.bingwahybrid.presentation.quickdial.screens.UssdResponseDialog.<anonymous> (QuickDialScreen.kt:153)");
            }
            Modifier modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.wrapContentWidth$default(PaddingKt.m1118padding3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), null, false, 3, null), null, false, 3, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierWrapContentHeight$default);
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
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1545000469, "C160@6401L6,163@6556L2380,159@6354L2582:QuickDialScreen.kt#e6wuav");
            SurfaceKt.m3692SurfaceT9BRK9s(PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m8684constructorimpl(32), 0.0f, 0.0f, 13, null), MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getMedium(), 0L, 0L, AlertDialogDefaults.INSTANCE.m2570getTonalElevationD9Ej5fM(), 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1301709639, true, new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickDialScreenKt.UssdResponseDialog$lambda$36$lambda$35$lambda$34(z, str, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12582918, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
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
    public static final Unit UssdResponseDialog$lambda$36$lambda$35$lambda$34(boolean z, String str, Function0 function0, Composer composer, int i) {
        long errorContainer;
        ComposerKt.sourceInformation(composer, "C164@6574L2348:QuickDialScreen.kt#e6wuav");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1301709639, i, -1, "com.example.bingwahybrid.presentation.quickdial.screens.UssdResponseDialog.<anonymous>.<anonymous>.<anonymous> (QuickDialScreen.kt:164)");
            }
            float f = 16;
            Modifier modifierM1119paddingVpY3zN4 = PaddingKt.m1119paddingVpY3zN4(Modifier.INSTANCE, Dp.m8684constructorimpl(f), Dp.m8684constructorimpl(24));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1538642278, "C168@6780L1255,192@8056L41,195@8210L10,193@8118L223,199@8362L41,200@8424L480:QuickDialScreen.kt#e6wuav");
            Modifier modifierClip = ClipKt.clip(columnScopeInstance.align(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(54)), Alignment.INSTANCE.getCenterHorizontally()), RoundedCornerShapeKt.getCircleShape());
            if (z) {
                composer.startReplaceGroup(-1158005075);
                ComposerKt.sourceInformation(composer, "173@7059L11");
                errorContainer = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer();
            } else {
                composer.startReplaceGroup(-1158003541);
                ComposerKt.sourceInformation(composer, "173@7107L11");
                errorContainer = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getErrorContainer();
            }
            composer.endReplaceGroup();
            Modifier modifierM543backgroundbw27NRU$default = BackgroundKt.m543backgroundbw27NRU$default(modifierClip, errorContainer, null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM543backgroundbw27NRU$default);
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
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1538729921, "C:QuickDialScreen.kt#e6wuav");
            if (z) {
                composer.startReplaceGroup(-1538719413);
                ComposerKt.sourceInformation(composer, "180@7488L11,177@7297L316");
                IconKt.m3158Iconww6aTOc(CheckKt.getCheck(Icons.Outlined.INSTANCE), "Success", SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer(), composer, 432, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1538344561);
                ComposerKt.sourceInformation(composer, "187@7864L11,184@7675L312");
                IconKt.m3158Iconww6aTOc(CloseKt.getClose(Icons.Outlined.INSTANCE), "Error", SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnErrorContainer(), composer, 432, 0);
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composer, 6);
            TextKt.m3864TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8545getStarte0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 0, 0, 131070);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(28)), composer, 6);
            CustomButtonKt.CustomButton(function0, SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.9f), false, false, ComposableSingletons$QuickDialScreenKt.INSTANCE.getLambda$255217233$app_debug(), composer, 27696, 4);
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

    /* JADX WARN: Code duplicated, block: B:102:0x0352  */
    /* JADX WARN: Code duplicated, block: B:104:0x0358  */
    /* JADX WARN: Code duplicated, block: B:107:0x0366  */
    /* JADX WARN: Code duplicated, block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0076  */
    /* JADX WARN: Code duplicated, block: B:32:0x007c  */
    /* JADX WARN: Code duplicated, block: B:33:0x007f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:39:0x008c  */
    /* JADX WARN: Code duplicated, block: B:40:0x008f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0097  */
    /* JADX WARN: Code duplicated, block: B:46:0x009d  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00af  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:70:0x0154  */
    /* JADX WARN: Code duplicated, block: B:73:0x0160  */
    /* JADX WARN: Code duplicated, block: B:74:0x0164  */
    /* JADX WARN: Code duplicated, block: B:79:0x0197  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:83:0x0201  */
    /* JADX WARN: Code duplicated, block: B:88:0x0210  */
    /* JADX WARN: Code duplicated, block: B:91:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:92:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:99:0x0314  */
    public static final void QuickDialScreenContent(List<Offer> list, Offer offer, boolean z, final String customerPhone, final Function1<? super String, Unit> onCustomerPhoneChanged, Function1<? super Offer, Unit> onOfferChanged, final Function0<Unit> onDial, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        boolean z3;
        final Function1<? super Offer, Unit> function1;
        Composer composer2;
        final Offer offer2;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final boolean z5;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z6;
        Object objRememberedValue;
        int i4;
        boolean z7;
        boolean z8;
        Object objRememberedValue2;
        int i5;
        int i6;
        int i7;
        int i8;
        final List<Offer> offers = list;
        Intrinsics.checkNotNullParameter(offers, "offers");
        Intrinsics.checkNotNullParameter(customerPhone, "customerPhone");
        Intrinsics.checkNotNullParameter(onCustomerPhoneChanged, "onCustomerPhoneChanged");
        Intrinsics.checkNotNullParameter(onOfferChanged, "onOfferChanged");
        Intrinsics.checkNotNullParameter(onDial, "onDial");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1206917033);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(QuickDialScreenContent)N(offers,selectedOffer,isDialing,customerPhone,onCustomerPhoneChanged,onOfferChanged,onDial)233@9347L21,229@9230L2274:QuickDialScreen.kt#e6wuav");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(offers) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(offer) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 == 0) {
            if ((i & 384) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(customerPhone)) {
                    i8 = 2048;
                } else {
                    i8 = 1024;
                }
                i3 |= i8;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onCustomerPhoneChanged)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(onOfferChanged)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i3 |= i6;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(onDial)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((599187 & i3) != 599186) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                function1 = onOfferChanged;
                composer2 = composerStartRestartGroup;
                offer2 = offer;
                composer2.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i9 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1206917033, i3, -1, "com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenContent (QuickDialScreen.kt:228)");
                }
                float f = 16;
                Modifier modifierM1119paddingVpY3zN4 = PaddingKt.m1119paddingVpY3zN4(ScrollKt.verticalScroll$default(WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), Dp.m8684constructorimpl(f), Dp.m8684constructorimpl(8));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1119paddingVpY3zN4);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 257855504, "C238@9526L117,245@9864L1018,236@9444L1448,271@10901L41,279@11239L259,272@10951L547:QuickDialScreen.kt#e6wuav");
                KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407323390, "CC(remember):QuickDialScreen.kt#9igjgp");
                if ((57344 & i3) == 16384) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return QuickDialScreenKt.QuickDialScreenContent$lambda$48$lambda$39$lambda$38(onCustomerPhoneChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                boolean z9 = z5;
                i4 = i3;
                OutlinedTextFieldKt.OutlinedTextField(customerPhone, (Function1<? super String, Unit>) objRememberedValue, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$QuickDialScreenKt.INSTANCE.getLambda$1085452007$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-2112131196, true, new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return QuickDialScreenKt.QuickDialScreenContent$lambda$48$lambda$43(z5, onDial, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i3 >> 9) & 14) | 806879616, 0, 0, 8355256);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                GridCells.Fixed fixed = new GridCells.Fixed(3);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_4 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(1));
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_5 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(4));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407268432, "CC(remember):QuickDialScreen.kt#9igjgp");
                offers = list;
                offer2 = offer;
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(offers) | composerStartRestartGroup.changedInstance(offer2);
                if ((i4 & 458752) == 131072) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = zChangedInstance | z7;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z8 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    function1 = onOfferChanged;
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return QuickDialScreenKt.QuickDialScreenContent$lambda$48$lambda$47$lambda$46(offers, offer2, function1, (LazyGridScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    function1 = onOfferChanged;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LazyGridDslKt.LazyVerticalGrid(fixed, modifierWeight$default, null, null, false, horizontalOrVerticalM977spacedBy0680j_4, horizontalOrVerticalM977spacedBy0680j_5, null, false, null, (Function1) objRememberedValue2, composerStartRestartGroup, 1769472, 0, 924);
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
                z4 = z9;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Offer offer3 = offer2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return QuickDialScreenKt.QuickDialScreenContent$lambda$49(offers, offer3, z4, customerPhone, onCustomerPhoneChanged, function1, onDial, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changed(customerPhone)) {
                i8 = 2048;
            } else {
                i8 = 1024;
            }
            i3 |= i8;
        }
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(onCustomerPhoneChanged)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i3 |= i7;
        }
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(onOfferChanged)) {
                i6 = 131072;
            } else {
                i6 = 65536;
            }
            i3 |= i6;
        }
        if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(onDial)) {
                i5 = 1048576;
            } else {
                i5 = 524288;
            }
            i3 |= i5;
        }
        if ((599187 & i3) != 599186) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            function1 = onOfferChanged;
            composer2 = composerStartRestartGroup;
            offer2 = offer;
            composer2.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i9 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1206917033, i3, -1, "com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenContent (QuickDialScreen.kt:228)");
            }
            float f2 = 16;
            Modifier modifierM1119paddingVpY3zN5 = PaddingKt.m1119paddingVpY3zN4(ScrollKt.verticalScroll$default(WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), Dp.m8684constructorimpl(f2), Dp.m8684constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1119paddingVpY3zN5);
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
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 257855504, "C238@9526L117,245@9864L1018,236@9444L1448,271@10901L41,279@11239L259,272@10951L547:QuickDialScreen.kt#e6wuav");
            KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default2 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407323390, "CC(remember):QuickDialScreen.kt#9igjgp");
            if ((57344 & i3) == 16384) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QuickDialScreenKt.QuickDialScreenContent$lambda$48$lambda$39$lambda$38(onCustomerPhoneChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QuickDialScreenKt.QuickDialScreenContent$lambda$48$lambda$39$lambda$38(onCustomerPhoneChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z10 = z5;
            i4 = i3;
            OutlinedTextFieldKt.OutlinedTextField(customerPhone, (Function1<? super String, Unit>) objRememberedValue, modifierFillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$QuickDialScreenKt.INSTANCE.getLambda$1085452007$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-2112131196, true, new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickDialScreenKt.QuickDialScreenContent$lambda$48$lambda$43(z5, onDial, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default2, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i3 >> 9) & 14) | 806879616, 0, 0, 8355256);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
            Modifier modifierWeight$default2 = ColumnScope.weight$default(columnScopeInstance2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
            GridCells.Fixed fixed2 = new GridCells.Fixed(3);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_6 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(1));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_7 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(4));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407268432, "CC(remember):QuickDialScreen.kt#9igjgp");
            offers = list;
            offer2 = offer;
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(offers) | composerStartRestartGroup.changedInstance(offer2);
            if ((i4 & 458752) == 131072) {
                z7 = true;
            } else {
                z7 = false;
            }
            z8 = zChangedInstance2 | z7;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z8) {
                function1 = onOfferChanged;
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QuickDialScreenKt.QuickDialScreenContent$lambda$48$lambda$47$lambda$46(offers, offer2, function1, (LazyGridScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                function1 = onOfferChanged;
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QuickDialScreenKt.QuickDialScreenContent$lambda$48$lambda$47$lambda$46(offers, offer2, function1, (LazyGridScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LazyGridDslKt.LazyVerticalGrid(fixed2, modifierWeight$default2, null, null, false, horizontalOrVerticalM977spacedBy0680j_6, horizontalOrVerticalM977spacedBy0680j_7, null, false, null, (Function1) objRememberedValue2, composerStartRestartGroup, 1769472, 0, 924);
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
            z4 = z10;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Offer offer4 = offer2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickDialScreenKt.QuickDialScreenContent$lambda$49(offers, offer4, z4, customerPhone, onCustomerPhoneChanged, function1, onDial, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreenContent$lambda$48$lambda$39$lambda$38(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(StringsKt.replace$default(it, ServerSentEventKt.SPACE, "", false, 4, (Object) null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreenContent$lambda$48$lambda$43$lambda$41$lambda$40(boolean z, Function0 function0) {
        if (!z) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreenContent$lambda$48$lambda$43(final boolean z, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C252@10162L11,247@9924L28,255@10297L571,246@9882L986:QuickDialScreen.kt#e6wuav");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2112131196, i, -1, "com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenContent.<anonymous>.<anonymous> (QuickDialScreen.kt:246)");
            }
            boolean z2 = !z;
            float f = 8;
            Modifier modifierM542backgroundbw27NRU = BackgroundKt.m542backgroundbw27NRU(PaddingKt.m1118padding3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(f)));
            ComposerKt.sourceInformationMarkerStart(composer, 1761453600, "CC(remember):QuickDialScreen.kt#9igjgp");
            boolean zChanged = composer.changed(z) | composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickDialScreenKt.QuickDialScreenContent$lambda$48$lambda$43$lambda$41$lambda$40(z, function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, modifierM542backgroundbw27NRU, z2, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1022536410, true, new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickDialScreenKt.QuickDialScreenContent$lambda$48$lambda$43$lambda$42(z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreenContent$lambda$48$lambda$43$lambda$42(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:QuickDialScreen.kt#e6wuav");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1022536410, i, -1, "com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenContent.<anonymous>.<anonymous>.<anonymous> (QuickDialScreen.kt:256)");
            }
            if (z) {
                composer.startReplaceGroup(1820884085);
                ComposerKt.sourceInformation(composer, "259@10498L11,257@10360L183");
                ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0.0f, 0L, 0, 0.0f, composer, 6, 60);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1821120677);
                ComposerKt.sourceInformation(composer, "265@10771L11,262@10597L231");
                IconKt.m3158Iconww6aTOc(PhoneKt.getPhone(Icons.Filled.INSTANCE), "Dial", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer(), composer, 48, 4);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void SelectionChip(final Offer offer, final boolean z, final Function0<Unit> onClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(offer, "offer");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1121570112);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionChip)N(offer,isSelected,onClick)299@11670L348,297@11615L793:QuickDialScreen.kt#e6wuav");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(offer) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1121570112, i2, -1, "com.example.bingwahybrid.presentation.quickdial.screens.SelectionChip (QuickDialScreen.kt:296)");
            }
            int i3 = i2 >> 3;
            ChipKt.FilterChip(z, onClick, ComposableLambdaKt.rememberComposableLambda(-857986067, true, new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickDialScreenKt.SelectionChip$lambda$52(offer, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, false, null, z ? ComposableSingletons$QuickDialScreenKt.INSTANCE.m9544getLambda$1716337886$app_debug() : null, null, null, null, null, null, composerStartRestartGroup, (i3 & 14) | 384 | (i3 & 112), 0, 4024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickDialScreenKt.SelectionChip$lambda$53(offer, z, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void QuickDialScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2011269365);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(QuickDialScreenPreview)339@12982L2,341@13032L2,340@13003L2,336@12862L240:QuickDialScreen.kt#e6wuav");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2011269365, i, -1, "com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenPreview (QuickDialScreen.kt:327)");
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID(...)");
            UUID uuidRandomUUID2 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID2, "randomUUID(...)");
            UUID uuidRandomUUID3 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID3, "randomUUID(...)");
            UUID uuidRandomUUID4 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID4, "randomUUID(...)");
            UUID uuidRandomUUID5 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID5, "randomUUID(...)");
            List listListOf = CollectionsKt.listOf((Object[]) new Offer[]{new Offer(uuidRandomUUID, "Offer 1", "*123#", 100, OfferType.DATA, null, false, null, false, false, false, false, false, 0, 0, 0L, null, false, 262112, null), new Offer(uuidRandomUUID2, "Offer 2", "*124#", 200, OfferType.DATA, null, false, null, false, false, false, false, false, 0, 0, 0L, null, false, 262112, null), new Offer(uuidRandomUUID3, "Offer 3", "*125#", 50, OfferType.SMS, null, false, null, false, false, false, false, false, 0, 0, 0L, null, false, 262112, null), new Offer(uuidRandomUUID4, "Offer 4", "*126#", 30, OfferType.DATA, null, false, null, false, false, false, false, false, 0, 0, 0L, null, false, 262112, null), new Offer(uuidRandomUUID5, "Offer 5", "*127#", 500, OfferType.DATA, null, false, null, false, false, false, false, false, 0, 0, 0L, null, false, 262112, null)});
            Offer offer = (Offer) listListOf.get(1);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -94558323, "CC(remember):QuickDialScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QuickDialScreenKt.QuickDialScreenPreview$lambda$55$lambda$54((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -94556723, "CC(remember):QuickDialScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QuickDialScreenKt.QuickDialScreenPreview$lambda$57$lambda$56((Offer) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -94557651, "CC(remember):QuickDialScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            QuickDialScreenContent(listListOf, offer, false, "0712345678", function1, function2, (Function0) objRememberedValue3, composerStartRestartGroup, 1797504, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickDialScreenKt.QuickDialScreenPreview$lambda$60(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreenPreview$lambda$55$lambda$54(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreenPreview$lambda$57$lambda$56(Offer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private static final String QuickDialScreen$lambda$0(State<String> state) {
        return state.getValue();
    }

    private static final List<Offer> QuickDialScreen$lambda$1(State<? extends List<Offer>> state) {
        return state.getValue();
    }

    private static final Offer QuickDialScreen$lambda$2(State<Offer> state) {
        return state.getValue();
    }

    private static final boolean QuickDialScreen$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String QuickDialScreen$lambda$4(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String QuickDialScreen$lambda$5(State<String> state) {
        return state.getValue();
    }

    private static final boolean QuickDialScreen$lambda$12(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickDialScreenContent$lambda$48$lambda$47$lambda$46(final List list, final Offer offer, final Function1 function1, LazyGridScope LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        final QuickDialScreenKt$QuickDialScreenContent$lambda$48$lambda$47$lambda$46$$inlined$items$default$1 quickDialScreenKt$QuickDialScreenContent$lambda$48$lambda$47$lambda$46$$inlined$items$default$1 = new Function1() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$QuickDialScreenContent$lambda$48$lambda$47$lambda$46$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Offer offer2) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Offer) obj);
            }
        };
        LazyVerticalGrid.items(list.size(), null, null, new Function1<Integer, Object>() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$QuickDialScreenContent$lambda$48$lambda$47$lambda$46$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return quickDialScreenKt$QuickDialScreenContent$lambda$48$lambda$47$lambda$46$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$QuickDialScreenContent$lambda$48$lambda$47$lambda$46$$inlined$items$default$5
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)539@23988L22:LazyGridDsl.kt#7791vq");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1117249557, i3, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:539)");
                }
                final Offer offer2 = (Offer) list.get(i);
                composer.startReplaceGroup(791354826);
                ComposerKt.sourceInformation(composer, "CN(offer)*284@11431L25,281@11294L180:QuickDialScreen.kt#e6wuav");
                boolean zAreEqual = Intrinsics.areEqual(offer2, offer);
                ComposerKt.sourceInformationMarkerStart(composer, -2052678178, "CC(remember):QuickDialScreen.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changedInstance(offer2);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function2 = function1;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$QuickDialScreenContent$1$3$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function2.invoke(offer2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                QuickDialScreenKt.SelectionChip(offer2, zAreEqual, (Function0) objRememberedValue, composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionChip$lambda$52(Offer offer, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C308@11973L10,300@11684L324:QuickDialScreen.kt#e6wuav");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-857986067, i, -1, "com.example.bingwahybrid.presentation.quickdial.screens.SelectionChip.<anonymous> (QuickDialScreen.kt:300)");
            }
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            int iPushStyle = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(10), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65533, (DefaultConstructorMarker) null));
            try {
                builder.append(offer.getName());
                Unit unit = Unit.INSTANCE;
                builder.pop(iPushStyle);
                TextKt.m3865TextZ58ophY(builder.toAnnotatedString(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 0, 0, 262142);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } catch (Throwable th) {
                builder.pop(iPushStyle);
                throw th;
            }
        }
        return Unit.INSTANCE;
    }
}
