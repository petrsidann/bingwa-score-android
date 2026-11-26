package com.example.bingwahybrid.presentation.autorenewal.screens;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material.icons.filled.ArrowDropUpKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
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
import com.example.bingwahybrid.domain.enums.RenewInterval;
import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.presentation.ui.components.CustomButtonKt;
import com.example.bingwahybrid.presentation.ui.components.SingleLineTextFieldKt;
import com.example.bingwahybrid.presentation.viewmodel.AddAutoRenewTransactionViewModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AddAutoRenewTransactionScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u001a)\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a¸\u0001\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e28\u0010\u000f\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u001026\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00010\u00102!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00010\u001cH\u0003¢\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010 ¨\u0006!²\u0006\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020#X\u008a\u0084\u0002²\u0006\f\u0010$\u001a\u0004\u0018\u00010\u000eX\u008a\u0084\u0002²\u0006\n\u0010%\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020#X\u008a\u008e\u0002²\u0006\f\u0010'\u001a\u0004\u0018\u00010\fX\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010+\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020\u0019X\u008a\u008e\u0002"}, d2 = {"AddAutoRenewTransactionScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/AddAutoRenewTransactionViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/viewmodel/AddAutoRenewTransactionViewModel;Landroidx/compose/runtime/Composer;II)V", "AddAutoRenewTransactionScreenContent", "offers", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "customerPhone", "", "onReschedule", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "offer", "", "time", "onAutoRenew", "", "renewCount", "Lcom/example/bingwahybrid/domain/enums/RenewInterval;", "interval", "onCustomerPhoneChanged", "Lkotlin/Function1;", HintConstants.AUTOFILL_HINT_PHONE, "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "AddAutoRenewTransactionScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "rescheduleSuccess", "", "snackBarMessage", "offerExpanded", "repeatCountIntervalExpanded", "selectedOffer", "selectedDateMillis", "selectedTimeMillis", "selectedDateTime", "autoRenew", "renewIntervalUnit"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AddAutoRenewTransactionScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreen$lambda$18(Modifier modifier, NavHostController navHostController, AddAutoRenewTransactionViewModel addAutoRenewTransactionViewModel, int i, int i2, Composer composer, int i3) {
        AddAutoRenewTransactionScreen(modifier, navHostController, addAutoRenewTransactionViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$98(List list, String str, Function2 function2, Function2 function3, Function1 function1, int i, Composer composer, int i2) {
        AddAutoRenewTransactionScreenContent(list, str, function2, function3, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenPreview$lambda$105(int i, Composer composer, int i2) {
        AddAutoRenewTransactionScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0106  */
    /* JADX WARN: Code duplicated, block: B:66:0x0128  */
    /* JADX WARN: Code duplicated, block: B:71:0x0184  */
    /* JADX WARN: Code duplicated, block: B:76:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:79:0x020e  */
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
    public static final void AddAutoRenewTransactionScreen(Modifier modifier, final NavHostController navController, AddAutoRenewTransactionViewModel addAutoRenewTransactionViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        AddAutoRenewTransactionViewModel addAutoRenewTransactionViewModel2;
        final Modifier.Companion companion;
        final AddAutoRenewTransactionViewModel addAutoRenewTransactionViewModel3;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Object objRememberedValue;
        final CoroutineScope coroutineScope;
        State stateCollectAsState;
        State stateCollectAsState2;
        boolean zChanged;
        AddAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1 addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1RememberedValue;
        boolean zChanged2;
        AddAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1 addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1RememberedValue;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-906788870);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AddAutoRenewTransactionScreen)N(modifier,navController,viewModel)80@3641L24,81@3701L16,82@3767L16,83@3841L16,84@3911L16,86@3967L91,86@3933L125,92@4096L144,92@4064L176,100@4273L556,116@4836L734,99@4246L1324:AddAutoRenewTransactionScreen.kt#cnhgb");
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
                addAutoRenewTransactionViewModel2 = addAutoRenewTransactionViewModel;
                int i5 = composerStartRestartGroup.changedInstance(addAutoRenewTransactionViewModel2) ? 256 : 128;
                i3 |= i5;
            } else {
                addAutoRenewTransactionViewModel2 = addAutoRenewTransactionViewModel;
            }
            i3 |= i5;
        } else {
            addAutoRenewTransactionViewModel2 = addAutoRenewTransactionViewModel;
        }
        int i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i6 & 147) != 146, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "78@3604L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i6 &= -897;
                }
                companion = modifier2;
            } else {
                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
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
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(AddAutoRenewTransactionViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    addAutoRenewTransactionViewModel3 = (AddAutoRenewTransactionViewModel) viewModel;
                    i6 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-906788870, i6, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreen (AddAutoRenewTransactionScreen.kt:79)");
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
                final State stateCollectAsState3 = SnapshotStateKt.collectAsState(addAutoRenewTransactionViewModel3.getOffers(), null, composerStartRestartGroup, 0, 1);
                final State stateCollectAsState4 = SnapshotStateKt.collectAsState(addAutoRenewTransactionViewModel3.getCustomerPhone(), null, composerStartRestartGroup, 0, 1);
                stateCollectAsState = SnapshotStateKt.collectAsState(addAutoRenewTransactionViewModel3.getRescheduleSuccess(), null, composerStartRestartGroup, 0, 1);
                stateCollectAsState2 = SnapshotStateKt.collectAsState(addAutoRenewTransactionViewModel3.getSnackBarMessage(), null, composerStartRestartGroup, 0, 1);
                Boolean boolValueOf = Boolean.valueOf(AddAutoRenewTransactionScreen$lambda$2(stateCollectAsState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 454275445, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(navController);
                addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1RememberedValue = new AddAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1(navController, stateCollectAsState, null);
                    composerStartRestartGroup.updateRememberedValue(addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                String strAddAutoRenewTransactionScreen$lambda$3 = AddAutoRenewTransactionScreen$lambda$3(stateCollectAsState2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 454279626, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(addAutoRenewTransactionViewModel3);
                addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged2 || addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1RememberedValue = new AddAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1(stateCollectAsState2, coroutineScope, addAutoRenewTransactionViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strAddAutoRenewTransactionScreen$lambda$3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(814196150, true, new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreen$lambda$9(coroutineScope, navController, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1878271435, true, new Function3() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreen$lambda$17(companion, addAutoRenewTransactionViewModel3, stateCollectAsState3, stateCollectAsState4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            addAutoRenewTransactionViewModel3 = addAutoRenewTransactionViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-906788870, i6, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreen (AddAutoRenewTransactionScreen.kt:79)");
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
            final State stateCollectAsState5 = SnapshotStateKt.collectAsState(addAutoRenewTransactionViewModel3.getOffers(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState6 = SnapshotStateKt.collectAsState(addAutoRenewTransactionViewModel3.getCustomerPhone(), null, composerStartRestartGroup, 0, 1);
            stateCollectAsState = SnapshotStateKt.collectAsState(addAutoRenewTransactionViewModel3.getRescheduleSuccess(), null, composerStartRestartGroup, 0, 1);
            stateCollectAsState2 = SnapshotStateKt.collectAsState(addAutoRenewTransactionViewModel3.getSnackBarMessage(), null, composerStartRestartGroup, 0, 1);
            Boolean boolValueOf2 = Boolean.valueOf(AddAutoRenewTransactionScreen$lambda$2(stateCollectAsState));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 454275445, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(navController);
            addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1RememberedValue = new AddAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1(navController, stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1RememberedValue);
            } else {
                addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1RememberedValue = new AddAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1(navController, stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            String strAddAutoRenewTransactionScreen$lambda$4 = AddAutoRenewTransactionScreen$lambda$3(stateCollectAsState2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 454279626, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(addAutoRenewTransactionViewModel3);
            addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1RememberedValue = new AddAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1(stateCollectAsState2, coroutineScope, addAutoRenewTransactionViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1RememberedValue);
            } else {
                addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1RememberedValue = new AddAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1(stateCollectAsState2, coroutineScope, addAutoRenewTransactionViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strAddAutoRenewTransactionScreen$lambda$4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(814196150, true, new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreen$lambda$9(coroutineScope, navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1878271435, true, new Function3() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreen$lambda$17(companion, addAutoRenewTransactionViewModel3, stateCollectAsState5, stateCollectAsState6, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
            addAutoRenewTransactionViewModel3 = addAutoRenewTransactionViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreen$lambda$18(companion, navController, addAutoRenewTransactionViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreen$lambda$9(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C103@4385L420,101@4287L532:AddAutoRenewTransactionScreen.kt#cnhgb");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(814196150, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreen.<anonymous> (AddAutoRenewTransactionScreen.kt:101)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$AddAutoRenewTransactionScreenKt.INSTANCE.m9387getLambda$38990470$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(-827798148, true, new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreen$lambda$9$lambda$8(coroutineScope, navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreen$lambda$9$lambda$8(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C104@4428L239,104@4407L380:AddAutoRenewTransactionScreen.kt#cnhgb");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-827798148, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreen.<anonymous>.<anonymous> (AddAutoRenewTransactionScreen.kt:104)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -945068853, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreen$lambda$9$lambda$8$lambda$7$lambda$6(coroutineScope, navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$AddAutoRenewTransactionScreenKt.INSTANCE.getLambda$1434590746$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreen$lambda$9$lambda$8$lambda$7$lambda$6(CoroutineScope coroutineScope, NavHostController navHostController) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AddAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreen$3$1$1$1$1(navHostController, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreen$lambda$17(Modifier modifier, final AddAutoRenewTransactionViewModel addAutoRenewTransactionViewModel, State state, State state2, PaddingValues paddingValues, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)117@4863L701:AddAutoRenewTransactionScreen.kt#cnhgb");
        if ((i & 6) == 0) {
            i |= composer.changed(paddingValues) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1878271435, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreen.<anonymous> (AddAutoRenewTransactionScreen.kt:117)");
            }
            Modifier modifierM1119paddingVpY3zN4 = PaddingKt.m1119paddingVpY3zN4(SizeKt.fillMaxSize$default(PaddingKt.padding(modifier, paddingValues), 0.0f, 1, null), Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8));
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
            ComposerKt.sourceInformationMarkerStart(composer, -189058508, "C127@5304L97,130@5433L107,126@5219L52,123@5060L494:AddAutoRenewTransactionScreen.kt#cnhgb");
            List<Offer> listAddAutoRenewTransactionScreen$lambda$0 = AddAutoRenewTransactionScreen$lambda$0(state);
            String strAddAutoRenewTransactionScreen$lambda$1 = AddAutoRenewTransactionScreen$lambda$1(state2);
            ComposerKt.sourceInformationMarkerStart(composer, 686645410, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(addAutoRenewTransactionViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreen$lambda$17$lambda$16$lambda$11$lambda$10(addAutoRenewTransactionViewModel, (Offer) obj, ((Long) obj2).longValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function2 function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 686649548, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(addAutoRenewTransactionViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreen$lambda$17$lambda$16$lambda$13$lambda$12(addAutoRenewTransactionViewModel, ((Integer) obj).intValue(), (RenewInterval) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function2 function3 = (Function2) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 686642645, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(addAutoRenewTransactionViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreen$lambda$17$lambda$16$lambda$15$lambda$14(addAutoRenewTransactionViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AddAutoRenewTransactionScreenContent(listAddAutoRenewTransactionScreen$lambda$0, strAddAutoRenewTransactionScreen$lambda$1, function2, function3, (Function1) objRememberedValue3, composer, 0);
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
    public static final Unit AddAutoRenewTransactionScreen$lambda$17$lambda$16$lambda$15$lambda$14(AddAutoRenewTransactionViewModel addAutoRenewTransactionViewModel, String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        addAutoRenewTransactionViewModel.onCustomerPhoneChanged(phone);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreen$lambda$17$lambda$16$lambda$11$lambda$10(AddAutoRenewTransactionViewModel addAutoRenewTransactionViewModel, Offer offer, long j) {
        addAutoRenewTransactionViewModel.scheduleTransaction(offer, j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreen$lambda$17$lambda$16$lambda$13$lambda$12(AddAutoRenewTransactionViewModel addAutoRenewTransactionViewModel, int i, RenewInterval interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        addAutoRenewTransactionViewModel.onAutoRenew(i, interval);
        return Unit.INSTANCE;
    }

    private static final void AddAutoRenewTransactionScreenContent(final List<Offer> list, final String str, Function2<? super Offer, ? super Long, Unit> function2, final Function2<? super Integer, ? super RenewInterval, Unit> function3, final Function1<? super String, Unit> function1, Composer composer, final int i) {
        int i2;
        final Function2<? super Offer, ? super Long, Unit> function4;
        Object obj;
        final MutableState mutableState;
        String name;
        final MutableState mutableState2;
        float f;
        String str2;
        final MutableLongState mutableLongState;
        final MutableLongState mutableLongState2;
        final MutableLongState mutableLongState3;
        final MutableState mutableState3;
        int i3;
        int i4;
        final MutableState mutableState4;
        final MutableState mutableState5;
        boolean z;
        final MutableState mutableState6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1676077420);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AddAutoRenewTransactionScreenContent)N(offers,customerPhone,onReschedule,onAutoRenew,onCustomerPhoneChanged)146@5900L7,147@5930L21,150@6020L34,151@6094L34,153@6155L41,154@6227L54,155@6312L54,157@6396L114,160@6532L33,161@6588L31,171@6831L46,173@6883L9515,398@16459L422,398@16404L477:AddAutoRenewTransactionScreen.kt#cnhgb");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1676077420, i2, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenContent (AddAutoRenewTransactionScreen.kt:145)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
            Calendar calendar = Calendar.getInstance();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -97650314, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState7 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -97647946, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState8 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -97645987, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState9 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -97643670, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotLongStateKt.mutableLongStateOf(calendar.getTimeInMillis());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            MutableLongState mutableLongState4 = (MutableLongState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -97640950, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = SnapshotLongStateKt.mutableLongStateOf(calendar.getTimeInMillis());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            MutableLongState mutableLongState5 = (MutableLongState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -97638202, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(12, 1);
                objRememberedValue6 = SnapshotLongStateKt.mutableLongStateOf(calendar2.getTimeInMillis());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            MutableLongState mutableLongState6 = (MutableLongState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -97633931, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            MutableState mutableState10 = (MutableState) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -97632141, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            MutableState mutableState11 = (MutableState) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final List listListOf = CollectionsKt.listOf((Object[]) new RenewInterval[]{RenewInterval.MINUTE, RenewInterval.HOUR, RenewInterval.DAY, RenewInterval.WEEK, RenewInterval.MONTH});
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -97624350, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                obj = null;
                objRememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(RenewInterval.DAY, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            } else {
                obj = null;
            }
            MutableState mutableState12 = (MutableState) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, obj), scrollStateRememberScrollState, false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
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
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1774190797, "C180@7086L30,178@7004L332,187@7346L41,191@7481L6,192@7518L24,193@7581L11,189@7397L1968,235@9374L40,257@10215L41,259@10266L3310,331@13586L428,385@16001L41,386@16110L69,386@16051L341:AddAutoRenewTransactionScreen.kt#cnhgb");
            KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1027056552, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            boolean z2 = (i2 & 57344) == 16384;
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$48$lambda$47(function1, (String) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i5 = i2;
            OutlinedTextFieldKt.OutlinedTextField(str, (Function1<? super String, Unit>) objRememberedValue10, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddAutoRenewTransactionScreenKt.INSTANCE.getLambda$1643953444$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i2 >> 3) & 14) | 1573248, 0, 0, 8355768);
            float f2 = 16;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
            Modifier modifierClip = ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getSmall());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1027070370, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState7;
                objRememberedValue11 = new Function0() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$50$lambda$49(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
            } else {
                mutableState = mutableState7;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            MutableState mutableState13 = mutableState;
            Modifier modifierM543backgroundbw27NRU$default = BackgroundKt.m543backgroundbw27NRU$default(ClickableKt.m584clickableoSLSa3U$default(modifierClip, false, null, null, null, (Function0) objRememberedValue11, 15, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurfaceContainer(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM543backgroundbw27NRU$default);
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
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1472796077, "C195@7627L982,218@8713L25,219@8801L11,220@8836L519,216@8622L733:AddAutoRenewTransactionScreen.kt#cnhgb");
            float f3 = 8;
            Modifier modifierM1122paddingqDBjuR0$default = PaddingKt.m1122paddingqDBjuR0$default(SizeKt.m1156height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(45)), Dp.m8684constructorimpl(f3), 0.0f, Dp.m8684constructorimpl(f3), 0.0f, 10, null);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1122paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM5259constructorimpl3 = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl3.rememberedValue(), Integer.valueOf(iHashCode3))) {
                composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
            }
            Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -362524368, "C205@8070L10,206@8135L11,203@7956L319,213@8556L11,210@8292L303:AddAutoRenewTransactionScreen.kt#cnhgb");
            Offer offerAddAutoRenewTransactionScreenContent$lambda$26 = AddAutoRenewTransactionScreenContent$lambda$26(mutableState9);
            if (offerAddAutoRenewTransactionScreenContent$lambda$26 == null || (name = offerAddAutoRenewTransactionScreenContent$lambda$26.getName()) == null) {
                name = "Select Offer";
            }
            String str3 = "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp";
            TextKt.m3864TextNvy7gAk(name, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), null, 0L, null, null, null, 0L, null, TextAlign.m8533boximpl(TextAlign.INSTANCE.m8545getStarte0LSkKk()), 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 0, 0, 130040);
            IconKt.m3158Iconww6aTOc(AddAutoRenewTransactionScreenContent$lambda$20(mutableState13) ? ArrowDropUpKt.getArrowDropUp(Icons.INSTANCE.getDefault()) : ArrowDropDownKt.getArrowDropDown(Icons.INSTANCE.getDefault()), AddAutoRenewTransactionScreenContent$lambda$20(mutableState13) ? "Collapse Dropdown" : "Expand Dropdown", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), composerStartRestartGroup, 0, 4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean zAddAutoRenewTransactionScreenContent$lambda$20 = AddAutoRenewTransactionScreenContent$lambda$20(mutableState13);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1155855159, str3);
            Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                mutableState2 = mutableState13;
                objRememberedValue12 = new Function0() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$59$lambda$53$lambda$52(mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
            } else {
                mutableState2 = mutableState13;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidMenu_androidKt.m2588DropdownMenuIlH_yew(zAddAutoRenewTransactionScreenContent$lambda$20, (Function0) objRememberedValue12, BackgroundKt.m543backgroundbw27NRU$default(Modifier.INSTANCE, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), null, 2, null), 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(27706293, true, new Function3() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$59$lambda$58(list, mutableState9, mutableState2, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 48, 2040);
            Composer composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composer2, 6);
            Offer offerAddAutoRenewTransactionScreenContent$lambda$27 = AddAutoRenewTransactionScreenContent$lambda$26(mutableState9);
            if (offerAddAutoRenewTransactionScreenContent$lambda$27 == null) {
                composer2.startReplaceGroup(1776338072);
                composer2.endReplaceGroup();
                str2 = "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh";
                f = 0.0f;
            } else {
                composer2.startReplaceGroup(1776338073);
                ComposerKt.sourceInformation(composer2, "*237@9465L730");
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default2);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                Composer composerM5259constructorimpl4 = Updater.m5259constructorimpl(composer2);
                Updater.m5266setimpl(composerM5259constructorimpl4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl4.rememberedValue(), Integer.valueOf(iHashCode4))) {
                    composerM5259constructorimpl4.updateRememberedValue(Integer.valueOf(iHashCode4));
                    composerM5259constructorimpl4.apply(Integer.valueOf(iHashCode4), setCompositeKeyHash4);
                }
                Updater.m5266setimpl(composerM5259constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -324224293, "C240@9556L625:AddAutoRenewTransactionScreen.kt#cnhgb");
                composer2.startReplaceGroup(266636187);
                ComposerKt.sourceInformation(composer2, "*242@9668L10,244@9822L11,250@10056L10");
                AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                int iPushStyle = builder.pushStyle(SpanStyle.m8050copyGSF8kmg$default(MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall().toSpanStyle(), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getSecondary(), 0L, FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65530, null));
                try {
                    builder.append("Ksh " + offerAddAutoRenewTransactionScreenContent$lambda$27.getPrice());
                    Unit unit = Unit.INSTANCE;
                    builder.pop(iPushStyle);
                    builder.append(" -> ");
                    int iPushStyle2 = builder.pushStyle(MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall().toSpanStyle());
                    try {
                        builder.append(offerAddAutoRenewTransactionScreenContent$lambda$27.getUssdCode());
                        Unit unit2 = Unit.INSTANCE;
                        builder.pop(iPushStyle2);
                        AnnotatedString annotatedString = builder.toAnnotatedString();
                        composer2.endReplaceGroup();
                        f = 0.0f;
                        str2 = "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh";
                        TextKt.m3865TextZ58ophY(annotatedString, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, null, composer2, 0, 0, 524286);
                        composer2 = composer2;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Unit unit3 = Unit.INSTANCE;
                        composer2.endReplaceGroup();
                        Unit unit4 = Unit.INSTANCE;
                    } catch (Throwable th) {
                        builder.pop(iPushStyle2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    builder.pop(iPushStyle);
                    throw th2;
                }
            }
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composer2, 6);
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str2);
            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default3);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor5);
            } else {
                composer2.useNode();
            }
            Composer composerM5259constructorimpl5 = Updater.m5259constructorimpl(composer2);
            Updater.m5266setimpl(composerM5259constructorimpl5, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl5.rememberedValue(), Integer.valueOf(iHashCode5))) {
                composerM5259constructorimpl5.updateRememberedValue(Integer.valueOf(iHashCode5));
                composerM5259constructorimpl5.apply(Integer.valueOf(iHashCode5), setCompositeKeyHash5);
            }
            Updater.m5266setimpl(composerM5259constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -922562887, "C264@10440L1212,286@11667L271,263@10402L1536,295@11951L12,297@12014L1323,322@13352L214,296@11976L1590:AddAutoRenewTransactionScreen.kt#cnhgb");
            ComposerKt.sourceInformationMarkerStart(composer2, -861044822, str3);
            boolean zChangedInstance = composer2.changedInstance(context);
            Object objRememberedValue13 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                mutableLongState = mutableLongState4;
                mutableLongState2 = mutableLongState5;
                mutableLongState3 = mutableLongState6;
                objRememberedValue13 = new Function0() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$73$lambda$67$lambda$66(context, mutableLongState, mutableLongState2, mutableLongState3);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue13);
            } else {
                mutableLongState = mutableLongState4;
                mutableLongState2 = mutableLongState5;
                mutableLongState3 = mutableLongState6;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            final MutableLongState mutableLongState7 = mutableLongState;
            Composer composer3 = composer2;
            final MutableLongState mutableLongState8 = mutableLongState2;
            final MutableLongState mutableLongState9 = mutableLongState3;
            String str4 = str2;
            ButtonKt.TextButton((Function0) objRememberedValue13, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(948682795, true, new Function3() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$73$lambda$68(mutableLongState, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer2, 54), composer3, 805306368, 510);
            TextKt.m3864TextNvy7gAk(" at ", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 6, 0, 262142);
            ComposerKt.sourceInformationMarkerStart(composer3, -860994343, str3);
            boolean zChangedInstance2 = composer3.changedInstance(context);
            Object objRememberedValue14 = composer3.rememberedValue();
            if (zChangedInstance2 || objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue14 = new Function0() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$73$lambda$71$lambda$70(context, mutableLongState8, mutableLongState7, mutableLongState9);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue14);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ButtonKt.TextButton((Function0) objRememberedValue14, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(896162338, true, new Function3() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$73$lambda$72(mutableLongState8, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer3, 54), composer3, 805306368, 510);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(0));
            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(start, centerVertically3, composer3, 54);
            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, str4);
            int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer3, modifierM1118padding3ABfNKs);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor6);
            } else {
                composer3.useNode();
            }
            Composer composerM5259constructorimpl6 = Updater.m5259constructorimpl(composer3);
            Updater.m5266setimpl(composerM5259constructorimpl6, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl6.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl6.rememberedValue(), Integer.valueOf(iHashCode6))) {
                composerM5259constructorimpl6.updateRememberedValue(Integer.valueOf(iHashCode6));
                composerM5259constructorimpl6.apply(Integer.valueOf(iHashCode6), setCompositeKeyHash6);
            }
            Updater.m5266setimpl(composerM5259constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, 1657936235, "C338@13873L18,338@13825L67,340@13977L26,339@13905L99:AddAutoRenewTransactionScreen.kt#cnhgb");
            boolean zAddAutoRenewTransactionScreenContent$lambda$39 = AddAutoRenewTransactionScreenContent$lambda$39(mutableState10);
            ComposerKt.sourceInformationMarkerStart(composer3, -2024726793, str3);
            Object objRememberedValue15 = composer3.rememberedValue();
            if (objRememberedValue15 == Composer.INSTANCE.getEmpty()) {
                mutableState3 = mutableState10;
                objRememberedValue15 = new Function1() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$78$lambda$75$lambda$74(mutableState3, ((Boolean) obj2).booleanValue());
                    }
                };
                composer3.updateRememberedValue(objRememberedValue15);
            } else {
                mutableState3 = mutableState10;
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            final MutableState mutableState14 = mutableState3;
            CheckboxKt.Checkbox(zAddAutoRenewTransactionScreenContent$lambda$39, (Function1) objRememberedValue15, null, false, null, null, composer3, 48, 60);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -2024723457, str3);
            Object objRememberedValue16 = composer3.rememberedValue();
            if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue16 = new Function0() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$78$lambda$77$lambda$76(mutableState14);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue16);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            TextKt.m3864TextNvy7gAk("Auto-Renew", ClickableKt.m584clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue16, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 6, 0, 262140);
            composerStartRestartGroup = composer3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (AddAutoRenewTransactionScreenContent$lambda$39(mutableState14)) {
                composerStartRestartGroup.startReplaceGroup(1780938039);
                ComposerKt.sourceInformation(composerStartRestartGroup, "343@14052L40,344@14105L1876");
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str4);
                int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor7);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5259constructorimpl7 = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl7, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl7.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl7.rememberedValue(), Integer.valueOf(iHashCode7))) {
                    composerM5259constructorimpl7.updateRememberedValue(Integer.valueOf(iHashCode7));
                    composerM5259constructorimpl7.apply(Integer.valueOf(iHashCode7), setCompositeKeyHash7);
                }
                Updater.m5266setimpl(composerM5259constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -827054344, "C347@14205L40,348@14262L39,350@14402L270,349@14318L355,357@14690L39,358@14746L1221:AddAutoRenewTransactionScreen.kt#cnhgb");
                TextKt.m3864TextNvy7gAk("Renew daily for the next ", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                SpacerKt.Spacer(SizeKt.m1175width3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
                String strAddAutoRenewTransactionScreenContent$lambda$42 = AddAutoRenewTransactionScreenContent$lambda$42(mutableState11);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -580863689, str3);
                i3 = i5;
                boolean z3 = (i3 & 7168) == 2048;
                Object objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                    mutableState4 = mutableState11;
                    mutableState5 = mutableState12;
                    objRememberedValue17 = new Function1() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$93$lambda$80$lambda$79(function3, mutableState4, mutableState5, (String) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue17);
                } else {
                    mutableState4 = mutableState11;
                    mutableState5 = mutableState12;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SingleLineTextFieldKt.SingleLineTextField(strAddAutoRenewTransactionScreenContent$lambda$42, (Function1) objRememberedValue17, composerStartRestartGroup, 0);
                SpacerKt.Spacer(SizeKt.m1175width3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Modifier.Companion companion3 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str4);
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor8);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5259constructorimpl8 = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl8.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl8.rememberedValue(), Integer.valueOf(iHashCode8))) {
                    composerM5259constructorimpl8.updateRememberedValue(Integer.valueOf(iHashCode8));
                    composerM5259constructorimpl8.apply(Integer.valueOf(iHashCode8), setCompositeKeyHash8);
                }
                Updater.m5266setimpl(composerM5259constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1289351003, "C364@15022L38,359@14772L332,367@15221L39,367@15262L687,366@15125L824:AddAutoRenewTransactionScreen.kt#cnhgb");
                String lowerCase = AddAutoRenewTransactionScreenContent$lambda$45(mutableState5).name().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (lowerCase.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    z = false;
                    String strValueOf = String.valueOf(lowerCase.charAt(0));
                    Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    StringBuilder sbAppend = sb.append((Object) upperCase);
                    String strSubstring = lowerCase.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    lowerCase = sbAppend.append(strSubstring).toString();
                } else {
                    z = false;
                }
                String str5 = lowerCase + "(s)";
                Modifier.Companion companion4 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 318693493, str3);
                Object objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                    mutableState6 = mutableState8;
                    objRememberedValue18 = new Function0() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$93$lambda$92$lambda$83$lambda$82(mutableState6);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue18);
                } else {
                    mutableState6 = mutableState8;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final MutableState mutableState15 = mutableState5;
                final MutableState mutableState16 = mutableState6;
                final MutableState mutableState17 = mutableState4;
                TextKt.m3864TextNvy7gAk(str5, PaddingKt.m1118padding3ABfNKs(ClickableKt.m584clickableoSLSa3U$default(companion4, false, null, null, null, (Function0) objRememberedValue18, 15, null), Dp.m8684constructorimpl(f3)), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 0, 0, 262140);
                boolean zAddAutoRenewTransactionScreenContent$lambda$23 = AddAutoRenewTransactionScreenContent$lambda$23(mutableState16);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 318699862, str3);
                Object objRememberedValue19 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue19 = new Function0() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$93$lambda$92$lambda$85$lambda$84(mutableState16);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue19);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i4 = 6;
                str3 = str3;
                AndroidMenu_androidKt.m2588DropdownMenuIlH_yew(zAddAutoRenewTransactionScreenContent$lambda$23, (Function0) objRememberedValue19, null, 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-124481612, true, new Function3() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$93$lambda$92$lambda$91(listListOf, function3, mutableState15, mutableState16, mutableState17, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 48, 2044);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                i3 = i5;
                i4 = 6;
                composerStartRestartGroup.startReplaceGroup(1766950808);
            }
            composerStartRestartGroup.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24)), composerStartRestartGroup, i4);
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, r65);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1027345359, str3);
            boolean z4 = (i3 & 896) == 256;
            Object objRememberedValue20 = composerStartRestartGroup.rememberedValue();
            if (z4 || objRememberedValue20 == Composer.INSTANCE.getEmpty()) {
                function4 = function2;
                objRememberedValue20 = new Function0() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$95$lambda$94(function4, mutableState9, mutableLongState9);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue20);
            } else {
                function4 = function2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CustomButtonKt.CustomButton((Function0) objRememberedValue20, modifierFillMaxWidth$default4, false, false, ComposableSingletons$AddAutoRenewTransactionScreenKt.INSTANCE.m9386getLambda$1488186082$app_debug(), composerStartRestartGroup, 24624, 12);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Long lValueOf = Long.valueOf(AddAutoRenewTransactionScreenContent$lambda$29(r33));
            Long lValueOf2 = Long.valueOf(AddAutoRenewTransactionScreenContent$lambda$32(mutableLongState8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -97315878, str3);
            AddAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreenContent$2$1 addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreenContent$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreenContent$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreenContent$2$1RememberedValue = new AddAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreenContent$2$1(mutableLongState7, mutableLongState8, mutableLongState9, 0);
                composerStartRestartGroup.updateRememberedValue(addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreenContent$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(lValueOf, lValueOf2, (Function2) addAutoRenewTransactionScreenKt$AddAutoRenewTransactionScreenContent$2$1RememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function4 = function2;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Offer, ? super Long, Unit> function5 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$98(list, str, function5, function3, function1, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final boolean AddAutoRenewTransactionScreenContent$lambda$20(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AddAutoRenewTransactionScreenContent$lambda$21(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean AddAutoRenewTransactionScreenContent$lambda$23(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AddAutoRenewTransactionScreenContent$lambda$24(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Offer AddAutoRenewTransactionScreenContent$lambda$26(MutableState<Offer> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long AddAutoRenewTransactionScreenContent$lambda$29(MutableLongState mutableLongState) {
        return mutableLongState.getLongValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long AddAutoRenewTransactionScreenContent$lambda$32(MutableLongState mutableLongState) {
        return mutableLongState.getLongValue();
    }

    private static final long AddAutoRenewTransactionScreenContent$lambda$36(MutableLongState mutableLongState) {
        return mutableLongState.getLongValue();
    }

    private static final boolean AddAutoRenewTransactionScreenContent$lambda$39(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AddAutoRenewTransactionScreenContent$lambda$40(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String AddAutoRenewTransactionScreenContent$lambda$42(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final RenewInterval AddAutoRenewTransactionScreenContent$lambda$45(MutableState<RenewInterval> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$48$lambda$47(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$50$lambda$49(MutableState mutableState) {
        AddAutoRenewTransactionScreenContent$lambda$21(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$59$lambda$53$lambda$52(MutableState mutableState) {
        AddAutoRenewTransactionScreenContent$lambda$21(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$59$lambda$58(List list, final MutableState mutableState, final MutableState mutableState2, ColumnScope DropdownMenu, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer2, "C*225@9051L271,222@8927L115,222@8900L423:AddAutoRenewTransactionScreen.kt#cnhgb");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(27706293, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenContent.<anonymous>.<anonymous>.<anonymous> (AddAutoRenewTransactionScreen.kt:221)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final Offer offer = (Offer) it.next();
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(857410112, true, new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$59$lambda$58$lambda$57$lambda$54(offer, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -655942717, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
                boolean zChangedInstance = composer2.changedInstance(offer);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$59$lambda$58$lambda$57$lambda$56$lambda$55(offer, mutableState, mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) objRememberedValue, null, null, null, false, null, null, null, composer2, 6, 508);
                composer2 = composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$59$lambda$58$lambda$57$lambda$56$lambda$55(Offer offer, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(offer);
        AddAutoRenewTransactionScreenContent$lambda$21(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$59$lambda$58$lambda$57$lambda$54(Offer offer, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C228@9180L10,229@9253L11,226@9077L223:AddAutoRenewTransactionScreen.kt#cnhgb");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(857410112, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddAutoRenewTransactionScreen.kt:226)");
            }
            TextKt.m3864TextNvy7gAk(offer.getName(), null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$73$lambda$67$lambda$66(Context context, final MutableLongState mutableLongState, final MutableLongState mutableLongState2, final MutableLongState mutableLongState3) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(AddAutoRenewTransactionScreenContent$lambda$29(mutableLongState));
        new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda22
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$73$lambda$67$lambda$66$lambda$65(calendar, mutableLongState, mutableLongState2, mutableLongState3, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddAutoRenewTransactionScreenContent$lambda$96$lambda$73$lambda$67$lambda$66$lambda$65(Calendar calendar, MutableLongState mutableLongState, MutableLongState mutableLongState2, MutableLongState mutableLongState3, DatePicker datePicker, int i, int i2, int i3) {
        calendar.set(i, i2, i3);
        mutableLongState.setLongValue(calendar.getTimeInMillis());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(AddAutoRenewTransactionScreenContent$lambda$32(mutableLongState2));
        calendar2.set(1, i);
        calendar2.set(2, i2);
        calendar2.set(5, i3);
        mutableLongState3.setLongValue(calendar2.getTimeInMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$73$lambda$68(MutableLongState mutableLongState, RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C287@11685L239:AddAutoRenewTransactionScreen.kt#cnhgb");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(948682795, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenContent.<anonymous>.<anonymous>.<anonymous> (AddAutoRenewTransactionScreen.kt:287)");
            }
            String str = new SimpleDateFormat("EEE dd/MM/yyyy", Locale.getDefault()).format(new Date(AddAutoRenewTransactionScreenContent$lambda$29(mutableLongState)));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            TextKt.m3864TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$73$lambda$71$lambda$70(Context context, final MutableLongState mutableLongState, final MutableLongState mutableLongState2, final MutableLongState mutableLongState3) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(AddAutoRenewTransactionScreenContent$lambda$32(mutableLongState));
        new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda26
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public final void onTimeSet(TimePicker timePicker, int i, int i2) {
                AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$73$lambda$71$lambda$70$lambda$69(calendar, mutableLongState, mutableLongState2, mutableLongState3, timePicker, i, i2);
            }
        }, calendar.get(11), calendar.get(12), true).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddAutoRenewTransactionScreenContent$lambda$96$lambda$73$lambda$71$lambda$70$lambda$69(Calendar calendar, MutableLongState mutableLongState, MutableLongState mutableLongState2, MutableLongState mutableLongState3, TimePicker timePicker, int i, int i2) {
        calendar.set(11, i);
        calendar.set(12, i2);
        calendar.set(13, 0);
        calendar.set(14, 0);
        mutableLongState.setLongValue(calendar.getTimeInMillis());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(AddAutoRenewTransactionScreenContent$lambda$29(mutableLongState2));
        calendar2.set(11, i);
        calendar2.set(12, i2);
        mutableLongState3.setLongValue(calendar2.getTimeInMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$73$lambda$72(MutableLongState mutableLongState, RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C323@13370L182:AddAutoRenewTransactionScreen.kt#cnhgb");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(896162338, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenContent.<anonymous>.<anonymous>.<anonymous> (AddAutoRenewTransactionScreen.kt:323)");
            }
            String str = new SimpleDateFormat("HH:mm 'Hrs'", Locale.getDefault()).format(new Date(AddAutoRenewTransactionScreenContent$lambda$32(mutableLongState)));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            TextKt.m3864TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$78$lambda$75$lambda$74(MutableState mutableState, boolean z) {
        AddAutoRenewTransactionScreenContent$lambda$40(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$78$lambda$77$lambda$76(MutableState mutableState) {
        AddAutoRenewTransactionScreenContent$lambda$40(mutableState, !AddAutoRenewTransactionScreenContent$lambda$39(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$93$lambda$80$lambda$79(Function2 function2, MutableState mutableState, MutableState mutableState2, String newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        mutableState.setValue(newValue);
        function2.invoke(Integer.valueOf(newValue.length() > 0 ? Integer.parseInt(newValue) : 0), AddAutoRenewTransactionScreenContent$lambda$45(mutableState2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$93$lambda$92$lambda$83$lambda$82(MutableState mutableState) {
        AddAutoRenewTransactionScreenContent$lambda$24(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$93$lambda$92$lambda$85$lambda$84(MutableState mutableState) {
        AddAutoRenewTransactionScreenContent$lambda$24(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$93$lambda$92$lambda$91(List list, final Function2 function2, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, ColumnScope DropdownMenu, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer2, "C*373@15643L257,369@15380L254,369@15353L548:AddAutoRenewTransactionScreen.kt#cnhgb");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-124481612, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddAutoRenewTransactionScreen.kt:368)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final RenewInterval renewInterval = (RenewInterval) it.next();
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1777356055, true, new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$93$lambda$92$lambda$91$lambda$90$lambda$87(renewInterval, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, 1134411799, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
                boolean zChanged = composer2.changed(renewInterval.ordinal()) | composer2.changed(function2);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Function0 function0 = new Function0() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenContent$lambda$96$lambda$93$lambda$92$lambda$91$lambda$90$lambda$89$lambda$88(renewInterval, function2, mutableState, mutableState2, mutableState3);
                        }
                    };
                    composer2.updateRememberedValue(function0);
                    objRememberedValue = function0;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) objRememberedValue, null, null, null, false, null, null, null, composer2, 6, 508);
                composer2 = composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$93$lambda$92$lambda$91$lambda$90$lambda$89$lambda$88(RenewInterval renewInterval, Function2 function2, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        mutableState.setValue(renewInterval);
        AddAutoRenewTransactionScreenContent$lambda$24(mutableState2, false);
        Integer intOrNull = StringsKt.toIntOrNull(AddAutoRenewTransactionScreenContent$lambda$42(mutableState3));
        function2.invoke(Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 0), AddAutoRenewTransactionScreenContent$lambda$45(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$93$lambda$92$lambda$91$lambda$90$lambda$87(RenewInterval renewInterval, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C374@15677L193:AddAutoRenewTransactionScreen.kt#cnhgb");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1777356055, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddAutoRenewTransactionScreen.kt:374)");
            }
            String lowerCase = renewInterval.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase.length() > 0) {
                StringBuilder sb = new StringBuilder();
                String strValueOf = String.valueOf(lowerCase.charAt(0));
                Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                StringBuilder sbAppend = sb.append((Object) upperCase);
                String strSubstring = lowerCase.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                lowerCase = sbAppend.append(strSubstring).toString();
            }
            TextKt.m3864TextNvy7gAk(lowerCase + "(s)", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenContent$lambda$96$lambda$95$lambda$94(Function2 function2, MutableState mutableState, MutableLongState mutableLongState) {
        function2.invoke(AddAutoRenewTransactionScreenContent$lambda$26(mutableState), Long.valueOf(AddAutoRenewTransactionScreenContent$lambda$36(mutableLongState)));
        return Unit.INSTANCE;
    }

    private static final void AddAutoRenewTransactionScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2067253071);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AddAutoRenewTransactionScreenPreview)426@17367L11,427@17402L11,425@17340L2,422@17216L204:AddAutoRenewTransactionScreen.kt#cnhgb");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2067253071, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenPreview (AddAutoRenewTransactionScreen.kt:411)");
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID(...)");
            List listListOf = CollectionsKt.listOf(new Offer(uuidRandomUUID, "2GB for 2 Hours", "*188*2*1*BH*1#", 30, OfferType.DATA, null, false, null, false, false, false, false, false, 0, 0, 0L, null, false, 262112, null));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939641382, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenPreview$lambda$100$lambda$99((Offer) obj, ((Long) obj2).longValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function2 function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939640262, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenPreview$lambda$102$lambda$101(((Integer) obj).intValue(), (RenewInterval) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function2 function3 = (Function2) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939642255, "CC(remember):AddAutoRenewTransactionScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenPreview$lambda$104$lambda$103((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AddAutoRenewTransactionScreenContent(listListOf, "", function2, function3, (Function1) objRememberedValue3, composerStartRestartGroup, 28080);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddAutoRenewTransactionScreenKt.AddAutoRenewTransactionScreenPreview$lambda$105(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenPreview$lambda$104$lambda$103(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenPreview$lambda$100$lambda$99(Offer offer, long j) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAutoRenewTransactionScreenPreview$lambda$102$lambda$101(int i, RenewInterval renewInterval) {
        Intrinsics.checkNotNullParameter(renewInterval, "<unused var>");
        return Unit.INSTANCE;
    }

    private static final List<Offer> AddAutoRenewTransactionScreen$lambda$0(State<? extends List<Offer>> state) {
        return state.getValue();
    }

    private static final String AddAutoRenewTransactionScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AddAutoRenewTransactionScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddAutoRenewTransactionScreen$lambda$3(State<String> state) {
        return state.getValue();
    }
}
