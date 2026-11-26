package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
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
import androidx.navigation.NavHostController;
import com.example.bingwahybrid.presentation.ui.components.CustomButtonKt;
import com.example.bingwahybrid.presentation.viewmodel.CustomersViewModel;
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
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: EditCustomerScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a1\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001ay\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0003¢\u0006\u0002\u0010\u0017\u001a1\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001c\u001a\r\u0010\u001d\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001e¨\u0006\u001f²\u0006\f\u0010 \u001a\u0004\u0018\u00010\tX\u008a\u0084\u0002²\u0006\f\u0010!\u001a\u0004\u0018\u00010\tX\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010\u0010\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020\u000fX\u008a\u008e\u0002"}, d2 = {"EditCustomerScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/CustomersViewModel;", "customerPhone", "", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/viewmodel/CustomersViewModel;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "EditCustomerScreenContent", "customerName", "accountBalance", "deleteSuccess", "", "isLoading", "onCustomerNameChanged", "Lkotlin/Function1;", "onAccountBalanceChanged", "onSave", "Lkotlin/Function0;", "onDelete", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DeleteCustomerConfirmationDialog", "showDialog", "onConfirm", "onDismiss", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "EditCustomerScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "errorMessage", "successMessage", "editSuccess", "showDeleteCustomerDialog"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EditCustomerScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteCustomerConfirmationDialog$lambda$47(boolean z, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        DeleteCustomerConfirmationDialog(z, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreen$lambda$26(Modifier modifier, NavHostController navHostController, CustomersViewModel customersViewModel, String str, int i, int i2, Composer composer, int i3) {
        EditCustomerScreen(modifier, navHostController, customersViewModel, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreenContent$lambda$44(String str, String str2, String str3, boolean z, boolean z2, Function1 function1, Function1 function2, Function0 function0, Function0 function3, int i, Composer composer, int i2) {
        EditCustomerScreenContent(str, str2, str3, z, z2, function1, function2, function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreenPreview$lambda$56(int i, Composer composer, int i2) {
        EditCustomerScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void EditCustomerScreen(Modifier modifier, final NavHostController navController, CustomersViewModel customersViewModel, final String customerPhone, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        CustomersViewModel customersViewModel2;
        Composer composer2;
        final Modifier modifier3;
        final CustomersViewModel customersViewModel3;
        Modifier.Companion companion;
        int i4;
        Composer composer3;
        final CustomersViewModel customersViewModel4;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(customerPhone, "customerPhone");
        Composer composerStartRestartGroup = composer.startRestartGroup(283784986);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditCustomerScreen)N(modifier,navController,viewModel,customerPhone)58@2628L24,59@2700L16,60@2768L16,61@2830L16,62@2896L16,63@2954L16,64@3018L16,65@3086L16,67@3138L115,67@3108L145,73@3288L96,73@3259L125,79@3421L143,79@3390L174,86@3598L126,86@3570L154,93@3760L130,93@3730L160,101@3923L553,117@4483L789,100@3896L1376:EditCustomerScreen.kt#oif8tm");
        int i5 = i2 & 1;
        if (i5 != 0) {
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
                customersViewModel2 = customersViewModel;
                int i6 = composerStartRestartGroup.changedInstance(customersViewModel2) ? 256 : 128;
                i3 |= i6;
            } else {
                customersViewModel2 = customersViewModel;
            }
            i3 |= i6;
        } else {
            customersViewModel2 = customersViewModel;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(customerPhone) ? 2048 : 1024;
        }
        int i7 = i3;
        if (composerStartRestartGroup.shouldExecute((i7 & 1171) != 1170, i7 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "55@2564L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i7 &= -897;
                }
                companion = modifier2;
                customersViewModel4 = customersViewModel2;
                i4 = 1;
                composer3 = composerStartRestartGroup;
            } else {
                companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
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
                    i4 = 1;
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(CustomersViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    composer3 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    i7 &= -897;
                    customersViewModel4 = (CustomersViewModel) viewModel;
                } else {
                    i4 = 1;
                    composer3 = composerStartRestartGroup;
                    customersViewModel4 = customersViewModel2;
                }
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(283784986, i7, -1, "com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreen (EditCustomerScreen.kt:57)");
            }
            ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer3, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer3.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3);
                composer3.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            State stateCollectAsState = SnapshotStateKt.collectAsState(customersViewModel4.getErrorMessage(), null, composer3, 0, i4);
            State stateCollectAsState2 = SnapshotStateKt.collectAsState(customersViewModel4.getSuccessMessage(), null, composer3, 0, i4);
            State stateCollectAsState3 = SnapshotStateKt.collectAsState(customersViewModel4.getEditSuccess(), null, composer3, 0, i4);
            final State stateCollectAsState4 = SnapshotStateKt.collectAsState(customersViewModel4.getDeleteSuccess(), null, composer3, 0, i4);
            final State stateCollectAsState5 = SnapshotStateKt.collectAsState(customersViewModel4.isLoading(), null, composer3, 0, i4);
            final State stateCollectAsState6 = SnapshotStateKt.collectAsState(customersViewModel4.getCustomerName(), null, composer3, 0, i4);
            final State stateCollectAsState7 = SnapshotStateKt.collectAsState(customersViewModel4.getAccountBalance(), null, composer3, 0, i4);
            ComposerKt.sourceInformationMarkerStart(composer3, 2134456301, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean zChangedInstance = ((i7 & 7168) == 2048) | composer3.changedInstance(customersViewModel4);
            EditCustomerScreenKt$EditCustomerScreen$1$1 editCustomerScreenKt$EditCustomerScreen$1$1RememberedValue = composer3.rememberedValue();
            if (zChangedInstance || editCustomerScreenKt$EditCustomerScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editCustomerScreenKt$EditCustomerScreen$1$1RememberedValue = new EditCustomerScreenKt$EditCustomerScreen$1$1(customerPhone, customersViewModel4, null);
                composer3.updateRememberedValue(editCustomerScreenKt$EditCustomerScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(customerPhone, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editCustomerScreenKt$EditCustomerScreen$1$1RememberedValue, composer3, (i7 >> 9) & 14);
            String strEditCustomerScreen$lambda$0 = EditCustomerScreen$lambda$0(stateCollectAsState);
            ComposerKt.sourceInformationMarkerStart(composer3, 2134461082, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean zChanged = composer3.changed(stateCollectAsState) | composer3.changedInstance(coroutineScope);
            EditCustomerScreenKt$EditCustomerScreen$2$1 editCustomerScreenKt$EditCustomerScreen$2$1RememberedValue = composer3.rememberedValue();
            if (zChanged || editCustomerScreenKt$EditCustomerScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editCustomerScreenKt$EditCustomerScreen$2$1RememberedValue = new EditCustomerScreenKt$EditCustomerScreen$2$1(stateCollectAsState, coroutineScope, null);
                composer3.updateRememberedValue(editCustomerScreenKt$EditCustomerScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(strEditCustomerScreen$lambda$0, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editCustomerScreenKt$EditCustomerScreen$2$1RememberedValue, composer3, 0);
            String strEditCustomerScreen$lambda$1 = EditCustomerScreen$lambda$1(stateCollectAsState2);
            ComposerKt.sourceInformationMarkerStart(composer3, 2134465385, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean zChanged2 = composer3.changed(stateCollectAsState2) | composer3.changedInstance(coroutineScope) | composer3.changedInstance(customersViewModel4);
            EditCustomerScreenKt$EditCustomerScreen$3$1 editCustomerScreenKt$EditCustomerScreen$3$1RememberedValue = composer3.rememberedValue();
            if (zChanged2 || editCustomerScreenKt$EditCustomerScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editCustomerScreenKt$EditCustomerScreen$3$1RememberedValue = new EditCustomerScreenKt$EditCustomerScreen$3$1(stateCollectAsState2, coroutineScope, customersViewModel4, null);
                composer3.updateRememberedValue(editCustomerScreenKt$EditCustomerScreen$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(strEditCustomerScreen$lambda$1, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editCustomerScreenKt$EditCustomerScreen$3$1RememberedValue, composer3, 0);
            Boolean boolValueOf = Boolean.valueOf(EditCustomerScreen$lambda$2(stateCollectAsState3));
            ComposerKt.sourceInformationMarkerStart(composer3, 2134471032, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean zChanged3 = composer3.changed(stateCollectAsState3) | composer3.changedInstance(navController) | composer3.changedInstance(customersViewModel4);
            EditCustomerScreenKt$EditCustomerScreen$4$1 editCustomerScreenKt$EditCustomerScreen$4$1RememberedValue = composer3.rememberedValue();
            if (zChanged3 || editCustomerScreenKt$EditCustomerScreen$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editCustomerScreenKt$EditCustomerScreen$4$1RememberedValue = new EditCustomerScreenKt$EditCustomerScreen$4$1(navController, customersViewModel4, stateCollectAsState3, null);
                composer3.updateRememberedValue(editCustomerScreenKt$EditCustomerScreen$4$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editCustomerScreenKt$EditCustomerScreen$4$1RememberedValue, composer3, 0);
            Boolean boolValueOf2 = Boolean.valueOf(EditCustomerScreen$lambda$3(stateCollectAsState4));
            ComposerKt.sourceInformationMarkerStart(composer3, 2134476220, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean zChanged4 = composer3.changed(stateCollectAsState4) | composer3.changedInstance(navController) | composer3.changedInstance(customersViewModel4);
            EditCustomerScreenKt$EditCustomerScreen$5$1 editCustomerScreenKt$EditCustomerScreen$5$1RememberedValue = composer3.rememberedValue();
            if (zChanged4 || editCustomerScreenKt$EditCustomerScreen$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editCustomerScreenKt$EditCustomerScreen$5$1RememberedValue = new EditCustomerScreenKt$EditCustomerScreen$5$1(navController, customersViewModel4, stateCollectAsState4, null);
                composer3.updateRememberedValue(editCustomerScreenKt$EditCustomerScreen$5$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editCustomerScreenKt$EditCustomerScreen$5$1RememberedValue, composer3, 0);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-966374954, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditCustomerScreenKt.EditCustomerScreen$lambda$15(coroutineScope, navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer3, 54);
            final Modifier modifier4 = companion;
            Function3 function3 = new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EditCustomerScreenKt.EditCustomerScreen$lambda$25(modifier4, customerPhone, customersViewModel4, stateCollectAsState6, stateCollectAsState7, stateCollectAsState4, stateCollectAsState5, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            CustomersViewModel customersViewModel5 = customersViewModel4;
            composer2 = composer3;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-2042474069, true, function3, composer3, 54), composer2, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            customersViewModel3 = customersViewModel5;
            modifier3 = modifier4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            customersViewModel3 = customersViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditCustomerScreenKt.EditCustomerScreen$lambda$26(modifier3, navController, customersViewModel3, customerPhone, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreen$lambda$15(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C104@4032L420,102@3937L529:EditCustomerScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-966374954, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreen.<anonymous> (EditCustomerScreen.kt:102)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$EditCustomerScreenKt.INSTANCE.getLambda$1649534106$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(-208873956, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditCustomerScreenKt.EditCustomerScreen$lambda$15$lambda$14(coroutineScope, navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreen$lambda$15$lambda$14(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C105@4075L239,105@4054L380:EditCustomerScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-208873956, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreen.<anonymous>.<anonymous> (EditCustomerScreen.kt:105)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1135592811, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditCustomerScreenKt.EditCustomerScreen$lambda$15$lambda$14$lambda$13$lambda$12(coroutineScope, navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$EditCustomerScreenKt.INSTANCE.getLambda$2117233978$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreen$lambda$15$lambda$14$lambda$13$lambda$12(CoroutineScope coroutineScope, NavHostController navHostController) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new EditCustomerScreenKt$EditCustomerScreen$6$1$1$1$1(navHostController, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreen$lambda$25(Modifier modifier, String str, final CustomersViewModel customersViewModel, State state, State state2, State state3, State state4, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)118@4510L756:EditCustomerScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2042474069, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreen.<anonymous> (EditCustomerScreen.kt:118)");
            }
            Modifier modifierM1119paddingVpY3zN4 = PaddingKt.m1119paddingVpY3zN4(PaddingKt.padding(SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null), paddingValues), Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8));
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
            ComposerKt.sourceInformationMarkerStart(composer, 742606973, "C130@5001L39,131@5084L41,132@5152L30,133@5211L30,124@4707L549:EditCustomerScreen.kt#oif8tm");
            String strEditCustomerScreen$lambda$5 = EditCustomerScreen$lambda$5(state);
            String strEditCustomerScreen$lambda$6 = EditCustomerScreen$lambda$6(state2);
            boolean zEditCustomerScreen$lambda$3 = EditCustomerScreen$lambda$3(state3);
            boolean zEditCustomerScreen$lambda$4 = EditCustomerScreen$lambda$4(state4);
            ComposerKt.sourceInformationMarkerStart(composer, -1638604024, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(customersViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditCustomerScreenKt.EditCustomerScreen$lambda$25$lambda$24$lambda$17$lambda$16(customersViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1638601366, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(customersViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditCustomerScreenKt.EditCustomerScreen$lambda$25$lambda$24$lambda$19$lambda$18(customersViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1638599201, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(customersViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditCustomerScreenKt.EditCustomerScreen$lambda$25$lambda$24$lambda$21$lambda$20(customersViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function0 function0 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1638597313, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(customersViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditCustomerScreenKt.EditCustomerScreen$lambda$25$lambda$24$lambda$23$lambda$22(customersViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EditCustomerScreenContent(strEditCustomerScreen$lambda$5, strEditCustomerScreen$lambda$6, str, zEditCustomerScreen$lambda$3, zEditCustomerScreen$lambda$4, function1, function2, function0, (Function0) objRememberedValue4, composer, 0);
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
    public static final Unit EditCustomerScreen$lambda$25$lambda$24$lambda$17$lambda$16(CustomersViewModel customersViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        customersViewModel.onCustomerNameChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreen$lambda$25$lambda$24$lambda$19$lambda$18(CustomersViewModel customersViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        customersViewModel.onAccountBalanceChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreen$lambda$25$lambda$24$lambda$21$lambda$20(CustomersViewModel customersViewModel) {
        customersViewModel.updateCustomer();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreen$lambda$25$lambda$24$lambda$23$lambda$22(CustomersViewModel customersViewModel) {
        customersViewModel.deleteCustomer();
        return Unit.INSTANCE;
    }

    private static final void EditCustomerScreenContent(final String str, final String str2, final String str3, final boolean z, final boolean z2, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function2, final Function0<Unit> function0, Function0<Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final Function0<Unit> function4 = function3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1629367720);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditCustomerScreenContent)N(customerName,accountBalance,customerPhone,deleteSuccess,isLoading,onCustomerNameChanged,onAccountBalanceChanged,onSave,onDelete)151@5628L21,152@5686L34,153@5782L7,154@5824L91,154@5794L121,160@5921L2314,228@8372L95,225@8241L232:EditCustomerScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(str3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function4) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 38347923) != 38347922, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1629367720, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenContent (EditCustomerScreen.kt:150)");
            }
            ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1840670966, "CC(remember):EditCustomerScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localSoftwareKeyboardController);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume;
            Boolean boolValueOf = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1840666493, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean z3 = (i2 & 7168) == 2048;
            EditCustomerScreenKt$EditCustomerScreenContent$1$1 editCustomerScreenKt$EditCustomerScreenContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || editCustomerScreenKt$EditCustomerScreenContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editCustomerScreenKt$EditCustomerScreenContent$1$1RememberedValue = new EditCustomerScreenKt$EditCustomerScreenContent$1$1(z, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(editCustomerScreenKt$EditCustomerScreenContent$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editCustomerScreenKt$EditCustomerScreenContent$1$1RememberedValue, composerStartRestartGroup, (i2 >> 9) & 14);
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(WindowInsetsPadding_androidKt.imePadding(Modifier.INSTANCE), scrollStateRememberScrollState, false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            int i3 = i2;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -403962760, "C167@6121L29,165@6040L309,172@6358L41,176@6519L3,173@6408L316,181@6733L41,184@6866L31,182@6783L317,189@7109L40,190@7158L543,206@7710L40,211@7888L341,207@7759L470:EditCustomerScreen.kt#oif8tm");
            KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8361getTextPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -151577957, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean z4 = (i3 & 458752) == 131072;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditCustomerScreenKt.EditCustomerScreenContent$lambda$41$lambda$32$lambda$31(function1, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OutlinedTextFieldKt.OutlinedTextField(str, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditCustomerScreenKt.INSTANCE.m9832getLambda$1465119688$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, (i3 & 14) | 1573248, 0, 0, 8355768);
            float f = 16;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
            KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default2 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -151565247, "CC(remember):EditCustomerScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditCustomerScreenKt.EditCustomerScreenContent$lambda$41$lambda$34$lambda$33((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OutlinedTextFieldKt.OutlinedTextField(str3, (Function1<? super String, Unit>) objRememberedValue3, modifierFillMaxWidth$default2, false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditCustomerScreenKt.INSTANCE.getLambda$2063345583$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default2, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i3 >> 6) & 14) | 1597872, 0, 0, 8355752);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
            KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default3 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -151554115, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean z5 = (i3 & 3670016) == 1048576;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z5 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditCustomerScreenKt.EditCustomerScreenContent$lambda$41$lambda$36$lambda$35(function2, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OutlinedTextFieldKt.OutlinedTextField(str2, (Function1<? super String, Unit>) objRememberedValue4, modifierFillMaxWidth$default3, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditCustomerScreenKt.INSTANCE.getLambda$1062289712$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default3, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i3 >> 3) & 14) | 1573248, 0, 0, 8355768);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composerStartRestartGroup, 6);
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default4);
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
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -832340499, "C194@7308L63,194@7287L404:EditCustomerScreen.kt#oif8tm");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -442491359, "CC(remember):EditCustomerScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditCustomerScreenKt.EditCustomerScreenContent$lambda$41$lambda$39$lambda$38$lambda$37(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonKt.TextButton((Function0) objRememberedValue5, null, false, null, null, null, null, null, null, ComposableSingletons$EditCustomerScreenKt.INSTANCE.m9835getLambda$899402817$app_debug(), composerStartRestartGroup, 805306374, 510);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(8)), composerStartRestartGroup, 6);
            Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2042964174, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditCustomerScreenKt.EditCustomerScreenContent$lambda$41$lambda$40(z2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            int i4 = i3 >> 21;
            CustomButtonKt.CustomButton(function0, modifierFillMaxWidth$default5, false, true, composableLambdaRememberComposableLambda, composerStartRestartGroup, (i4 & 14) | 27696, 4);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            boolean zEditCustomerScreenContent$lambda$28 = EditCustomerScreenContent$lambda$28(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer2, -1840584953, "CC(remember):EditCustomerScreen.kt#9igjgp");
            boolean zChanged = composer2.changed(softwareKeyboardController);
            Object objRememberedValue6 = composer2.rememberedValue();
            if (zChanged || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditCustomerScreenKt.EditCustomerScreenContent$lambda$43$lambda$42(softwareKeyboardController, mutableState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            function4 = function3;
            DeleteCustomerConfirmationDialog(zEditCustomerScreenContent$lambda$28, function4, (Function0) objRememberedValue6, composer2, i4 & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditCustomerScreenKt.EditCustomerScreenContent$lambda$44(str, str2, str3, z, z2, function1, function2, function0, function4, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean EditCustomerScreenContent$lambda$28(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EditCustomerScreenContent$lambda$29(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreenContent$lambda$41$lambda$32$lambda$31(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreenContent$lambda$41$lambda$34$lambda$33(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreenContent$lambda$41$lambda$36$lambda$35(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreenContent$lambda$41$lambda$39$lambda$38$lambda$37(MutableState mutableState) {
        EditCustomerScreenContent$lambda$29(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreenContent$lambda$41$lambda$40(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:EditCustomerScreen.kt#oif8tm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2042964174, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenContent.<anonymous>.<anonymous> (EditCustomerScreen.kt:212)");
            }
            if (z) {
                composer.startReplaceGroup(2035874581);
                ComposerKt.sourceInformation(composer, "213@7935L27");
                ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(null, 0L, 0.0f, 0L, 0, 0.0f, composer, 0, 63);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(2035944579);
                ComposerKt.sourceInformation(composer, "217@8085L10,215@8000L205");
                TextKt.m3864TextNvy7gAk("Update", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 6, 0, 131070);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreenContent$lambda$43$lambda$42(SoftwareKeyboardController softwareKeyboardController, MutableState mutableState) {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        EditCustomerScreenContent$lambda$29(mutableState, false);
        return Unit.INSTANCE;
    }

    public static final void DeleteCustomerConfirmationDialog(final boolean z, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1842179000);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DeleteCustomerConfirmationDialog)N(showDialog,onConfirm,onDismiss):EditCustomerScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onConfirm) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1842179000, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.DeleteCustomerConfirmationDialog (EditCustomerScreen.kt:240)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(737691619);
                ComposerKt.sourceInformation(composerStartRestartGroup, "250@8951L171,257@9152L125,242@8640L647");
                AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0(onDismiss, ComposableLambdaKt.rememberComposableLambda(438227803, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditCustomerScreenKt.DeleteCustomerConfirmationDialog$lambda$45(onConfirm, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1527758951, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditCustomerScreenKt.DeleteCustomerConfirmationDialog$lambda$46(onDismiss, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableSingletons$EditCustomerScreenKt.INSTANCE.getLambda$801221591$app_debug(), ComposableSingletons$EditCustomerScreenKt.INSTANCE.m9834getLambda$181771786$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, ((i2 >> 6) & 14) | 1772592, 0, 16276);
                composer2 = composerStartRestartGroup;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(729109114);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditCustomerScreenKt.DeleteCustomerConfirmationDialog$lambda$47(z, onConfirm, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteCustomerConfirmationDialog$lambda$45(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C251@8969L139:EditCustomerScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(438227803, i, -1, "com.example.bingwahybrid.presentation.ui.screens.DeleteCustomerConfirmationDialog.<anonymous> (EditCustomerScreen.kt:251)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$EditCustomerScreenKt.INSTANCE.getLambda$288066942$app_debug(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteCustomerConfirmationDialog$lambda$46(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C258@9170L93:EditCustomerScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1527758951, i, -1, "com.example.bingwahybrid.presentation.ui.screens.DeleteCustomerConfirmationDialog.<anonymous> (EditCustomerScreen.kt:258)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$EditCustomerScreenKt.INSTANCE.m9833getLambda$1677919812$app_debug(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void EditCustomerScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(632799954);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditCustomerScreenPreview)275@9609L2,276@9647L2,277@9668L2,278@9691L2,269@9387L313:EditCustomerScreen.kt#oif8tm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(632799954, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenPreview (EditCustomerScreen.kt:268)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1764590252, "CC(remember):EditCustomerScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditCustomerScreenKt.EditCustomerScreenPreview$lambda$49$lambda$48((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1764589036, "CC(remember):EditCustomerScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditCustomerScreenKt.EditCustomerScreenPreview$lambda$51$lambda$50((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1764588364, "CC(remember):EditCustomerScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function0 function0 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1764587628, "CC(remember):EditCustomerScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EditCustomerScreenContent("John Doe", "120", "0712345678", false, false, function1, function2, function0, (Function0) objRememberedValue4, composerStartRestartGroup, 115043766);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditCustomerScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditCustomerScreenKt.EditCustomerScreenPreview$lambda$56(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreenPreview$lambda$49$lambda$48(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditCustomerScreenPreview$lambda$51$lambda$50(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String EditCustomerScreen$lambda$0(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String EditCustomerScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean EditCustomerScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean EditCustomerScreen$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean EditCustomerScreen$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String EditCustomerScreen$lambda$5(State<String> state) {
        return state.getValue();
    }

    private static final String EditCustomerScreen$lambda$6(State<String> state) {
        return state.getValue();
    }
}
