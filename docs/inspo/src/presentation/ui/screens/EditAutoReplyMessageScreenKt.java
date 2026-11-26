package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.MenuKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
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
import androidx.profileinstaller.ProfileVerifier;
import com.example.bingwahybrid.domain.enums.AutoReplyType;
import com.example.bingwahybrid.domain.model.AutoReplyPlaceHolder;
import com.example.bingwahybrid.presentation.ui.components.CustomButtonKt;
import com.example.bingwahybrid.presentation.viewmodel.AutoReplyViewModel;
import io.ktor.http.LinkHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: EditAutoReplyMessageScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001aå\u0001\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u001a2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010 H\u0003¢\u0006\u0002\u0010#\u001a\u001f\u0010$\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010%\u001a\r\u0010&\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010'¨\u0006(²\u0006\n\u0010)\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010,\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020\u0011X\u008a\u008e\u0002"}, d2 = {"EditAutoReplyMessageScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/AutoReplyViewModel;", "autoReplyId", "", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/viewmodel/AutoReplyViewModel;JLandroidx/compose/runtime/Composer;II)V", "EditAutoReplyMessageScreenContent", LinkHeader.Parameters.Title, "", "message", "transactionAmount", "isUpdate", "", "selectedAutoReplyType", "Lcom/example/bingwahybrid/domain/enums/AutoReplyType;", "isActive", "showAmountInput", "autoReplyPlaceHolders", "", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder;", "onTitleChanged", "Lkotlin/Function1;", "onMessageChanged", "onAutoReplyTypeSelected", "onTransactionAmountChanged", "onIsActiveChanged", "onToggleAmountInput", "Lkotlin/Function0;", "onSave", "onDelete", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/example/bingwahybrid/domain/enums/AutoReplyType;ZZLjava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "buildPreviewText", "(Lcom/example/bingwahybrid/domain/enums/AutoReplyType;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "EditAutoReplyMessageScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "autoReplyMessage", "autoReplyTitle", "autoReplyType", "updateSuccess", "showDeleteDialog"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EditAutoReplyMessageScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreen$lambda$32(Modifier modifier, NavHostController navHostController, AutoReplyViewModel autoReplyViewModel, long j, int i, int i2, Composer composer, int i3) {
        EditAutoReplyMessageScreen(modifier, navHostController, autoReplyViewModel, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$78(String str, String str2, String str3, boolean z, AutoReplyType autoReplyType, boolean z2, boolean z3, List list, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function0 function0, Function0 function6, Function0 function7, int i, int i2, int i3, Composer composer, int i4) {
        EditAutoReplyMessageScreenContent(str, str2, str3, z, autoReplyType, z2, z3, list, function1, function2, function3, function4, function5, function0, function6, function7, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenPreview$lambda$95(int i, Composer composer, int i2) {
        EditAutoReplyMessageScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r14v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
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
    public static final void EditAutoReplyMessageScreen(Modifier modifier, final NavHostController navController, AutoReplyViewModel autoReplyViewModel, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        AutoReplyViewModel autoReplyViewModel2;
        final long j2;
        final Modifier modifier3;
        final AutoReplyViewModel autoReplyViewModel3;
        final long j3;
        boolean z;
        final Modifier modifier4;
        CreationExtras.Empty defaultViewModelCreationExtras;
        ?? r14;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(801506473);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditAutoReplyMessageScreen)N(modifier,navController,viewModel,autoReplyId)80@3763L16,81@3831L16,82@3897L16,83@3971L16,84@4027L16,85@4097L16,86@4163L16,89@4284L100,89@4256L128,95@4420L130,95@4390L160,104@4612L525,120@5144L1540,102@4556L2128:EditAutoReplyMessageScreen.kt#oif8tm");
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
                autoReplyViewModel2 = autoReplyViewModel;
                int i5 = composerStartRestartGroup.changedInstance(autoReplyViewModel2) ? 256 : 128;
                i3 |= i5;
            } else {
                autoReplyViewModel2 = autoReplyViewModel;
            }
            i3 |= i5;
        } else {
            autoReplyViewModel2 = autoReplyViewModel;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                j2 = j;
                int i6 = composerStartRestartGroup.changed(j2) ? 2048 : 1024;
                i3 |= i6;
            } else {
                j2 = j;
            }
            i3 |= i6;
        } else {
            j2 = j;
        }
        int i7 = 0;
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "77@3658L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                modifier4 = modifier2;
                i7 = 0;
                r14 = 1;
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
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(AutoReplyViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    autoReplyViewModel2 = (AutoReplyViewModel) viewModel;
                    i3 &= -897;
                    z = true;
                } else {
                    z = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    j2 = -1;
                } else {
                    j2 = j;
                }
                modifier4 = companion;
                r14 = z;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(801506473, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreen (EditAutoReplyMessageScreen.kt:79)");
            }
            final State stateCollectAsState = SnapshotStateKt.collectAsState(autoReplyViewModel2.getAutoReplyMessage(), null, composerStartRestartGroup, i7, r14);
            final State stateCollectAsState2 = SnapshotStateKt.collectAsState(autoReplyViewModel2.getAutoReplyTitle(), null, composerStartRestartGroup, i7, r14);
            final State stateCollectAsState3 = SnapshotStateKt.collectAsState(autoReplyViewModel2.getAutoReplyType(), null, composerStartRestartGroup, i7, r14);
            final State stateCollectAsState4 = SnapshotStateKt.collectAsState(autoReplyViewModel2.getTransactionAmount(), null, composerStartRestartGroup, i7, r14);
            final State stateCollectAsState5 = SnapshotStateKt.collectAsState(autoReplyViewModel2.isActive(), null, composerStartRestartGroup, i7, r14);
            final State stateCollectAsState6 = SnapshotStateKt.collectAsState(autoReplyViewModel2.getShowAmountInput(), null, composerStartRestartGroup, i7, r14);
            State stateCollectAsState7 = SnapshotStateKt.collectAsState(autoReplyViewModel2.getUpdateSuccess(), null, composerStartRestartGroup, i7, r14);
            final List<AutoReplyPlaceHolder> listAllPlaceHolders = AutoReplyPlaceHolder.INSTANCE.allPlaceHolders();
            Long lValueOf = Long.valueOf(j2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1448600877, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            int i8 = (((((i3 & 7168) ^ 3072) <= 2048 || !composerStartRestartGroup.changed(j2)) && (i3 & 3072) != 2048) ? i7 : r14) | (composerStartRestartGroup.changedInstance(autoReplyViewModel2) ? 1 : 0);
            EditAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$1$1 editAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (i8 != 0 || editAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$1$1RememberedValue = new EditAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$1$1(j2, autoReplyViewModel2, null);
                composerStartRestartGroup.updateRememberedValue(editAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(lValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$1$1RememberedValue, composerStartRestartGroup, (i3 >> 9) & 14);
            Boolean boolValueOf = Boolean.valueOf(EditAutoReplyMessageScreen$lambda$6(stateCollectAsState7));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1448605259, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsState7) | composerStartRestartGroup.changedInstance(navController) | composerStartRestartGroup.changedInstance(autoReplyViewModel2);
            EditAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$2$1 editAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || editAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$2$1RememberedValue = new EditAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$2$1(navController, autoReplyViewModel2, stateCollectAsState7, null);
                composerStartRestartGroup.updateRememberedValue(editAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$2$1RememberedValue, composerStartRestartGroup, i7);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(115121765, r14, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$13(j2, navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            final AutoReplyViewModel autoReplyViewModel4 = autoReplyViewModel2;
            final long j4 = j2;
            Function3 function3 = new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31(modifier4, j4, listAllPlaceHolders, autoReplyViewModel4, stateCollectAsState2, stateCollectAsState, stateCollectAsState4, stateCollectAsState3, stateCollectAsState5, stateCollectAsState6, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Modifier modifier5 = modifier4;
            ScaffoldKt.m3481ScaffoldTvnljyQ(companion2, composableLambdaRememberComposableLambda, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1724920454, r14, function3, composerStartRestartGroup, 54), composerStartRestartGroup, 805306422, 508);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            autoReplyViewModel3 = autoReplyViewModel2;
            j3 = j4;
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            autoReplyViewModel3 = autoReplyViewModel2;
            j3 = j;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$32(modifier3, navController, autoReplyViewModel3, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreen$lambda$13(final long j, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C106@4661L160,111@4856L257,105@4626L501:EditAutoReplyMessageScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(115121765, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreen.<anonymous> (EditAutoReplyMessageScreen.kt:105)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(-1250946519, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$13$lambda$9(j, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, ComposableLambdaKt.rememberComposableLambda(-912443349, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$13$lambda$12(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreen$lambda$13$lambda$9(long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C107@4683L120:EditAutoReplyMessageScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1250946519, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreen.<anonymous>.<anonymous> (EditAutoReplyMessageScreen.kt:107)");
            }
            TextKt.m3864TextNvy7gAk(j > 0 ? "Edit AutoReply" : "Create AutoReply", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreen$lambda$13$lambda$12(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C112@4899L76,112@4878L217:EditAutoReplyMessageScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-912443349, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreen.<anonymous>.<anonymous> (EditAutoReplyMessageScreen.kt:112)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -684728553, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$13$lambda$12$lambda$11$lambda$10(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.getLambda$1122304713$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreen$lambda$13$lambda$12$lambda$11$lambda$10(NavHostController navHostController) {
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:66:0x023b  */
    /* JADX WARN: Code duplicated, block: B:71:0x0262  */
    /* JADX WARN: Code duplicated, block: B:76:0x028c  */
    /* JADX WARN: Code duplicated, block: B:79:0x02d0  */
    public static final Unit EditAutoReplyMessageScreen$lambda$31(Modifier modifier, final long j, List list, final AutoReplyViewModel autoReplyViewModel, State state, State state2, State state3, State state4, State state5, State state6, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        String str;
        boolean zChangedInstance;
        Object objRememberedValue;
        boolean zChangedInstance2;
        Object objRememberedValue2;
        boolean zChangedInstance3;
        Object objRememberedValue3;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)127@5416L11,131@5559L21,121@5171L1507:EditAutoReplyMessageScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1724920454, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreen.<anonymous> (EditAutoReplyMessageScreen.kt:121)");
            }
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(PaddingKt.m1119paddingVpY3zN4(PaddingKt.padding(modifier, paddingValues), Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), 0.0f, 1, null), WindowInsetsKt.m1198onlybOOhFvg(WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.INSTANCE.m1222getHorizontalJoeWqyM())), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1942078739, "C142@6063L41,143@6141L43,144@6228L50,145@6325L44,146@6407L35,147@6482L43,148@6552L31,149@6612L42,133@5606L1062:EditAutoReplyMessageScreen.kt#oif8tm");
            String strEditAutoReplyMessageScreen$lambda$1 = EditAutoReplyMessageScreen$lambda$1(state);
            String strEditAutoReplyMessageScreen$lambda$0 = EditAutoReplyMessageScreen$lambda$0(state2);
            String strEditAutoReplyMessageScreen$lambda$3 = EditAutoReplyMessageScreen$lambda$3(state3);
            AutoReplyType autoReplyTypeEditAutoReplyMessageScreen$lambda$2 = EditAutoReplyMessageScreen$lambda$2(state4);
            boolean zEditAutoReplyMessageScreen$lambda$4 = EditAutoReplyMessageScreen$lambda$4(state5);
            boolean z = j > 0;
            boolean zEditAutoReplyMessageScreen$lambda$5 = EditAutoReplyMessageScreen$lambda$5(state6);
            ComposerKt.sourceInformationMarkerStart(composer, -755370759, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(autoReplyViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$15$lambda$14(autoReplyViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function1 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -755368261, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            boolean zChangedInstance5 = composer.changedInstance(autoReplyViewModel);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$17$lambda$16(autoReplyViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Function1 function2 = (Function1) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -755365470, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            boolean zChangedInstance6 = composer.changedInstance(autoReplyViewModel);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$19$lambda$18(autoReplyViewModel, (AutoReplyType) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            Function1 function3 = (Function1) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -755362372, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            boolean zChangedInstance7 = composer.changedInstance(autoReplyViewModel);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$21$lambda$20(autoReplyViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            Function1 function4 = (Function1) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -755359757, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            boolean zChangedInstance8 = composer.changedInstance(autoReplyViewModel);
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChangedInstance8) {
                str = strEditAutoReplyMessageScreen$lambda$0;
            } else {
                str = strEditAutoReplyMessageScreen$lambda$0;
                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                }
                Function1 function5 = (Function1) objRememberedValue8;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -755357349, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                zChangedInstance = composer.changedInstance(autoReplyViewModel);
                objRememberedValue = composer.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$25$lambda$24(autoReplyViewModel);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -755355121, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                zChangedInstance2 = composer.changedInstance(autoReplyViewModel);
                objRememberedValue2 = composer.rememberedValue();
                if (!zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$27$lambda$26(autoReplyViewModel);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Function0 function6 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -755353190, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                zChangedInstance3 = composer.changedInstance(autoReplyViewModel) | composer.changed(j);
                objRememberedValue3 = composer.rememberedValue();
                if (!zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$29$lambda$28(autoReplyViewModel, j);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EditAutoReplyMessageScreenContent(strEditAutoReplyMessageScreen$lambda$1, str, strEditAutoReplyMessageScreen$lambda$3, z, autoReplyTypeEditAutoReplyMessageScreen$lambda$2, zEditAutoReplyMessageScreen$lambda$4, zEditAutoReplyMessageScreen$lambda$5, list, function1, function2, function3, function4, function5, function0, function6, (Function0) objRememberedValue3, composer, 0, 0, 0);
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
            objRememberedValue8 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$23$lambda$22(autoReplyViewModel, ((Boolean) obj).booleanValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue8);
            Function1 function7 = (Function1) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -755357349, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            zChangedInstance = composer.changedInstance(autoReplyViewModel);
            objRememberedValue = composer.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$25$lambda$24(autoReplyViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$25$lambda$24(autoReplyViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function8 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -755355121, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            zChangedInstance2 = composer.changedInstance(autoReplyViewModel);
            objRememberedValue2 = composer.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$27$lambda$26(autoReplyViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$27$lambda$26(autoReplyViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function9 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -755353190, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            zChangedInstance3 = composer.changedInstance(autoReplyViewModel) | composer.changed(j);
            objRememberedValue3 = composer.rememberedValue();
            if (!zChangedInstance3) {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$29$lambda$28(autoReplyViewModel, j);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$29$lambda$28(autoReplyViewModel, j);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EditAutoReplyMessageScreenContent(strEditAutoReplyMessageScreen$lambda$1, str, strEditAutoReplyMessageScreen$lambda$3, z, autoReplyTypeEditAutoReplyMessageScreen$lambda$2, zEditAutoReplyMessageScreen$lambda$4, zEditAutoReplyMessageScreen$lambda$5, list, function1, function2, function3, function4, function7, function8, function9, (Function0) objRememberedValue3, composer, 0, 0, 0);
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
    public static final Unit EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$15$lambda$14(AutoReplyViewModel autoReplyViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        autoReplyViewModel.onAutoReplyTitleChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$17$lambda$16(AutoReplyViewModel autoReplyViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        autoReplyViewModel.onAutoReplyMessageChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$19$lambda$18(AutoReplyViewModel autoReplyViewModel, AutoReplyType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        autoReplyViewModel.onAutoReplyTypeChanged(type);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$21$lambda$20(AutoReplyViewModel autoReplyViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        autoReplyViewModel.onTransactionAmountChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$23$lambda$22(AutoReplyViewModel autoReplyViewModel, boolean z) {
        autoReplyViewModel.onIsActiveChanged(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$25$lambda$24(AutoReplyViewModel autoReplyViewModel) {
        autoReplyViewModel.toggleAmountInputVisibility();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$27$lambda$26(AutoReplyViewModel autoReplyViewModel) {
        autoReplyViewModel.updateAutoReply();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreen$lambda$31$lambda$30$lambda$29$lambda$28(AutoReplyViewModel autoReplyViewModel, long j) {
        autoReplyViewModel.deleteAutoReply(Long.valueOf(j));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012f  */
    /* JADX WARN: Code duplicated, block: B:102:0x0135  */
    /* JADX WARN: Code duplicated, block: B:103:0x0138  */
    /* JADX WARN: Code duplicated, block: B:107:0x0140  */
    /* JADX WARN: Code duplicated, block: B:109:0x0148  */
    /* JADX WARN: Code duplicated, block: B:110:0x014b  */
    /* JADX WARN: Code duplicated, block: B:112:0x0150  */
    /* JADX WARN: Code duplicated, block: B:115:0x0156  */
    /* JADX WARN: Code duplicated, block: B:117:0x015c  */
    /* JADX WARN: Code duplicated, block: B:118:0x015f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0168  */
    /* JADX WARN: Code duplicated, block: B:124:0x016e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0171  */
    /* JADX WARN: Code duplicated, block: B:133:0x018d  */
    /* JADX WARN: Code duplicated, block: B:136:0x0196 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:137:0x0198  */
    /* JADX WARN: Code duplicated, block: B:140:0x019f  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:146:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:148:0x020d  */
    /* JADX WARN: Code duplicated, block: B:150:0x026e  */
    /* JADX WARN: Code duplicated, block: B:153:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:156:0x02de  */
    /* JADX WARN: Code duplicated, block: B:157:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:162:0x0315  */
    /* JADX WARN: Code duplicated, block: B:165:0x037a  */
    /* JADX WARN: Code duplicated, block: B:166:0x037c  */
    /* JADX WARN: Code duplicated, block: B:171:0x038b  */
    /* JADX WARN: Code duplicated, block: B:174:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:177:0x04c1  */
    /* JADX WARN: Code duplicated, block: B:178:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:183:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:186:0x0525  */
    /* JADX WARN: Code duplicated, block: B:187:0x0528  */
    /* JADX WARN: Code duplicated, block: B:190:0x054a  */
    /* JADX WARN: Code duplicated, block: B:191:0x054c  */
    /* JADX WARN: Code duplicated, block: B:194:0x0555  */
    /* JADX WARN: Code duplicated, block: B:195:0x0557  */
    /* JADX WARN: Code duplicated, block: B:200:0x0567  */
    /* JADX WARN: Code duplicated, block: B:203:0x05c9  */
    /* JADX WARN: Code duplicated, block: B:204:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:209:0x05da  */
    /* JADX WARN: Code duplicated, block: B:213:0x069a  */
    /* JADX WARN: Code duplicated, block: B:226:0x081f  */
    /* JADX WARN: Code duplicated, block: B:227:0x0821  */
    /* JADX WARN: Code duplicated, block: B:232:0x0830  */
    /* JADX WARN: Code duplicated, block: B:235:0x0891  */
    /* JADX WARN: Code duplicated, block: B:237:0x08eb  */
    /* JADX WARN: Code duplicated, block: B:240:0x08f7  */
    /* JADX WARN: Code duplicated, block: B:241:0x08fb  */
    /* JADX WARN: Code duplicated, block: B:246:0x092e  */
    /* JADX WARN: Code duplicated, block: B:251:0x0973  */
    /* JADX WARN: Code duplicated, block: B:253:0x09b6  */
    /* JADX WARN: Code duplicated, block: B:256:0x09ed  */
    /* JADX WARN: Code duplicated, block: B:257:0x09ef  */
    /* JADX WARN: Code duplicated, block: B:262:0x09ff  */
    /* JADX WARN: Code duplicated, block: B:265:0x0a45  */
    /* JADX WARN: Code duplicated, block: B:266:0x0a49  */
    /* JADX WARN: Code duplicated, block: B:269:0x0a53  */
    /* JADX WARN: Code duplicated, block: B:276:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0085 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0087  */
    /* JADX WARN: Code duplicated, block: B:41:0x008a  */
    /* JADX WARN: Code duplicated, block: B:44:0x009a  */
    /* JADX WARN: Code duplicated, block: B:45:0x009d  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:85:0x0108  */
    /* JADX WARN: Code duplicated, block: B:87:0x010e  */
    /* JADX WARN: Code duplicated, block: B:88:0x0111  */
    /* JADX WARN: Code duplicated, block: B:90:0x0116  */
    /* JADX WARN: Code duplicated, block: B:93:0x011e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0124  */
    /* JADX WARN: Code duplicated, block: B:96:0x0127  */
    private static final void EditAutoReplyMessageScreenContent(final String str, final String str2, final String str3, boolean z, final AutoReplyType autoReplyType, final boolean z2, final boolean z3, final List<? extends AutoReplyPlaceHolder> list, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function2, final Function1<? super AutoReplyType, Unit> function3, final Function1<? super String, Unit> function4, final Function1<? super Boolean, Unit> function5, final Function0<Unit> function0, final Function0<Unit> function6, final Function0<Unit> function7, Composer composer, final int i, final int i2, final int i3) {
        final boolean z4;
        int i4;
        int i5;
        boolean z5;
        final boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        SoftwareKeyboardController softwareKeyboardController;
        Object objRememberedValue;
        final MutableState mutableState;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z7;
        Object objRememberedValue2;
        int iHashCode2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM5259constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        String str4;
        int i6;
        boolean z8;
        boolean z9;
        boolean z10;
        Object objRememberedValue3;
        boolean z11;
        Object objRememberedValue4;
        boolean z12;
        Object objRememberedValue5;
        final SoftwareKeyboardController softwareKeyboardController2;
        boolean z13;
        boolean z14;
        Object objRememberedValue6;
        int iHashCode3;
        Function0<ComposeUiNode> constructor3;
        Composer composerM5259constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        boolean zChanged;
        Object objRememberedValue7;
        AnnotatedString.Builder builder;
        int iPushStyle;
        int iPushStyle2;
        Object objRememberedValue8;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int iOrdinal;
        int i18;
        Composer composerStartRestartGroup = composer.startRestartGroup(1500203204);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditAutoReplyMessageScreenContent)N(title,message,transactionAmount,isUpdate,selectedAutoReplyType,isActive,showAmountInput,autoReplyPlaceHolders,onTitleChanged,onMessageChanged,onAutoReplyTypeSelected,onTransactionAmountChanged,onIsActiveChanged,onToggleAmountInput,onSave,onDelete)175@7412L7,176@7448L34,204@8313L7483:EditAutoReplyMessageScreen.kt#oif8tm");
        int i19 = (i & 6) == 0 ? (composerStartRestartGroup.changed(str) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i19 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i19 |= composerStartRestartGroup.changed(str3) ? 256 : 128;
        }
        int i20 = i3 & 8;
        if (i20 == 0) {
            if ((i & 3072) == 0) {
                z4 = z;
                i19 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                if (autoReplyType == null) {
                    iOrdinal = -1;
                } else {
                    iOrdinal = autoReplyType.ordinal();
                }
                if (composerStartRestartGroup.changed(iOrdinal)) {
                    i18 = 16384;
                } else {
                    i18 = 8192;
                }
                i19 |= i18;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i17 = 131072;
                } else {
                    i17 = 65536;
                }
                i19 |= i17;
            }
            if ((i & 1572864) != 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i19 |= i16;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(list)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i19 |= i15;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i14 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                } else {
                    i14 = 33554432;
                }
                i19 |= i14;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i13 = 536870912;
                } else {
                    i13 = 268435456;
                }
                i19 |= i13;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
                i4 = i2 | i12;
            } else {
                i4 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i11 = 32;
                } else {
                    i11 = 16;
                }
                i4 |= i11;
            }
            if ((i2 & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i10 = 256;
                } else {
                    i10 = 128;
                }
                i4 |= i10;
            }
            if ((i2 & 3072) != 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i9 = 2048;
                } else {
                    i9 = 1024;
                }
                i4 |= i9;
            }
            if ((i2 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            if ((196608 & i2) == 0) {
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i4 |= i7;
            }
            i5 = i4;
            if ((i19 & 306783379) == 306783378 || (74899 & i5) != 74898) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i19 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i20 != 0) {
                    z4 = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1500203204, i19, i5, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenContent (EditAutoReplyMessageScreen.kt:174)");
                }
                ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localSoftwareKeyboardController);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                softwareKeyboardController = (SoftwareKeyboardController) objConsume;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1413708058, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                boolean z15 = z4;
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (EditAutoReplyMessageScreenContent$lambda$34(mutableState)) {
                    composerStartRestartGroup.startReplaceGroup(-882667298);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-875191679);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "180@7564L28,183@7759L365,196@8154L137,179@7520L781");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1413704352, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$37$lambda$36(mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0((Function0) objRememberedValue8, ComposableLambdaKt.rememberComposableLambda(-777729391, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$40(function7, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1425746157, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$43(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.m9825getLambda$2073762923$app_debug(), ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.getLambda$1897195990$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, 1772598, 0, 16276);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -468094426, "C211@8489L22,209@8415L379,220@8804L41,225@8984L38,226@9033L3189,223@8893L3329,305@12232L41,308@12317L691,328@13018L41,330@13069L29,331@13107L40,354@13831L41,357@13957L24,355@13881L560,371@14450L41,395@15298L40,398@15411L83,403@15553L237,396@15347L443:EditAutoReplyMessageScreen.kt#oif8tm");
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m8336getWordsIUNYP9k(), (Boolean) null, KeyboardType.INSTANCE.m8361getTextPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 122, (DefaultConstructorMarker) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1370368516, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                if ((i19 & 234881024) == 67108864) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z7 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$45$lambda$44(function1, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                OutlinedTextFieldKt.OutlinedTextField(str, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.m9823getLambda$1606827980$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, (i19 & 14) | 1573248, 0, 0, 8355768);
                float f = 16;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, CardDefaults.INSTANCE.m2693cardElevationaqJV_2Y(Dp.m8684constructorimpl(2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62), null, ComposableLambdaKt.rememberComposableLambda(1983591900, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$59(z3, function0, autoReplyType, str3, function3, function4, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 196614, 22);
                composerStartRestartGroup = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 820033389, "C315@12617L10,316@12686L68,313@12506L262,320@12781L39,323@12911L25,321@12833L165:EditAutoReplyMessageScreen.kt#oif8tm");
                if (z2) {
                    str4 = "Deactivate";
                } else {
                    str4 = "Activate";
                }
                String str5 = str4;
                TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 165005358, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                i6 = i5 & 896;
                if (i6 == 256) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if ((i19 & 458752) == 131072) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                z10 = z9 | z8;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z10 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$64$lambda$61$lambda$60(function5, z2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TextKt.m3864TextNvy7gAk(str5, ClickableKt.m584clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue3, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, bodyMedium, composerStartRestartGroup, 0, 0, 131068);
                float f2 = 8;
                SpacerKt.Spacer(SizeKt.m1175width3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 165012515, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                if (i6 == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z11 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$64$lambda$63$lambda$62(function5, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SwitchKt.Switch(z2, (Function1) objRememberedValue4, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composerStartRestartGroup, ((i19 >> 15) & 14) | 384, MenuKt.InTransitionDuration);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                TextKt.m3864TextNvy7gAk("PlaceHolders: ", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceGroup(1370519216);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*334@13216L595");
                for (AutoReplyPlaceHolder autoReplyPlaceHolder : list) {
                    builder = new AnnotatedString.Builder(0, 1, null);
                    iPushStyle = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(12), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65529, (DefaultConstructorMarker) null));
                    try {
                        builder.append(autoReplyPlaceHolder.getKey());
                        Unit unit = Unit.INSTANCE;
                        builder.pop(iPushStyle);
                        iPushStyle2 = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(12), (FontWeight) null, FontStyle.m8228boximpl(FontStyle.INSTANCE.m8237getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65525, (DefaultConstructorMarker) null));
                        try {
                            builder.append(" - " + autoReplyPlaceHolder.getDescription());
                            Unit unit2 = Unit.INSTANCE;
                            builder.pop(iPushStyle2);
                            TextKt.m3865TextZ58ophY(builder.toAnnotatedString(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, null, composerStartRestartGroup, 0, 0, 524286);
                        } catch (Throwable th) {
                            builder.pop(iPushStyle2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        builder.pop(iPushStyle);
                        throw th2;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                KeyboardOptions keyboardOptions2 = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m8334getSentencesIUNYP9k(), (Boolean) null, KeyboardType.INSTANCE.m8361getTextPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 122, (DefaultConstructorMarker) null);
                Modifier modifierM1158heightInVpY3zN4$default = SizeKt.m1158heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(100), 0.0f, 2, null);
                TextStyle textStyle = new TextStyle(0L, TextUnitKt.getSp(18), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(32), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646141, (DefaultConstructorMarker) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1370543494, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                if ((i19 & 1879048192) == 536870912) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z12 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$70$lambda$69(function2, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                OutlinedTextFieldKt.OutlinedTextField(str2, (Function1<? super String, Unit>) objRememberedValue5, modifierM1158heightInVpY3zN4$default, false, false, textStyle, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.getLambda$1922212701$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions2, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i19 >> 3) & 14) | 1769856, 0, 0, 8355736);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                z4 = z15;
                if (z4) {
                    composerStartRestartGroup.startReplaceGroup(-462248819);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "374@14529L750");
                    Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.Horizontal end2 = Arrangement.INSTANCE.getEnd();
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(end2, centerVertically2, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default3);
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
                    Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl3.rememberedValue(), Integer.valueOf(iHashCode3))) {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1862173947, "C380@14780L122,379@14738L527:EditAutoReplyMessageScreen.kt#oif8tm");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1463951465, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                    softwareKeyboardController2 = softwareKeyboardController;
                    zChanged = composerStartRestartGroup.changed(softwareKeyboardController2);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$73$lambda$72$lambda$71(softwareKeyboardController2, mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ButtonKt.TextButton((Function0) objRememberedValue7, null, false, null, null, null, null, null, null, ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.m9824getLambda$2024701038$app_debug(), composerStartRestartGroup, 805306368, 510);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    softwareKeyboardController2 = softwareKeyboardController;
                    composerStartRestartGroup.startReplaceGroup(-476671724);
                }
                composerStartRestartGroup.endReplaceGroup();
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1370590081, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(softwareKeyboardController2);
                if ((i5 & 57344) == 16384) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = zChanged2 | z13;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!z14 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$75$lambda$74(softwareKeyboardController2, function6);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CustomButtonKt.CustomButton((Function0) objRememberedValue6, modifierFillMaxWidth$default4, false, true, ComposableLambdaKt.rememberComposableLambda(-876290310, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$76(z4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 4);
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
            z6 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$78(str, str2, str3, z6, autoReplyType, z2, z3, list, function1, function2, function3, function4, function5, function0, function6, function7, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i19 |= 3072;
        z4 = z;
        if ((i & 24576) == 0) {
            if (autoReplyType == null) {
                iOrdinal = -1;
            } else {
                iOrdinal = autoReplyType.ordinal();
            }
            if (composerStartRestartGroup.changed(iOrdinal)) {
                i18 = 16384;
            } else {
                i18 = 8192;
            }
            i19 |= i18;
        }
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i17 = 131072;
            } else {
                i17 = 65536;
            }
            i19 |= i17;
        }
        if ((i & 1572864) != 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i19 |= i16;
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(list)) {
                i15 = 8388608;
            } else {
                i15 = 4194304;
            }
            i19 |= i15;
        }
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i14 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
            } else {
                i14 = 33554432;
            }
            i19 |= i14;
        }
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i13 = 536870912;
            } else {
                i13 = 268435456;
            }
            i19 |= i13;
        }
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i12 = 4;
            } else {
                i12 = 2;
            }
            i4 = i2 | i12;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i11 = 32;
            } else {
                i11 = 16;
            }
            i4 |= i11;
        }
        if ((i2 & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(function5)) {
                i10 = 256;
            } else {
                i10 = 128;
            }
            i4 |= i10;
        }
        if ((i2 & 3072) != 0) {
            if (composerStartRestartGroup.changedInstance(function0)) {
                i9 = 2048;
            } else {
                i9 = 1024;
            }
            i4 |= i9;
        }
        if ((i2 & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function6)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i4 |= i8;
        }
        if ((196608 & i2) == 0) {
            if (composerStartRestartGroup.changedInstance(function7)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i4 |= i7;
        }
        i5 = i4;
        if ((i19 & 306783379) == 306783378) {
            z5 = true;
        } else {
            z5 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i19 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i20 != 0) {
                z4 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1500203204, i19, i5, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenContent (EditAutoReplyMessageScreen.kt:174)");
            }
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController2 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localSoftwareKeyboardController2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            softwareKeyboardController = (SoftwareKeyboardController) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1413708058, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            boolean z16 = z4;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (EditAutoReplyMessageScreenContent$lambda$34(mutableState)) {
                composerStartRestartGroup.startReplaceGroup(-882667298);
            } else {
                composerStartRestartGroup.startReplaceGroup(-875191679);
                ComposerKt.sourceInformation(composerStartRestartGroup, "180@7564L28,183@7759L365,196@8154L137,179@7520L781");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1413704352, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$37$lambda$36(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0((Function0) objRememberedValue8, ComposableLambdaKt.rememberComposableLambda(-777729391, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$40(function7, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1425746157, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$43(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.m9825getLambda$2073762923$app_debug(), ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.getLambda$1897195990$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, 1772598, 0, 16276);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
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
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -468094426, "C211@8489L22,209@8415L379,220@8804L41,225@8984L38,226@9033L3189,223@8893L3329,305@12232L41,308@12317L691,328@13018L41,330@13069L29,331@13107L40,354@13831L41,357@13957L24,355@13881L560,371@14450L41,395@15298L40,398@15411L83,403@15553L237,396@15347L443:EditAutoReplyMessageScreen.kt#oif8tm");
            Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            KeyboardOptions keyboardOptions3 = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m8336getWordsIUNYP9k(), (Boolean) null, KeyboardType.INSTANCE.m8361getTextPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 122, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1370368516, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            if ((i19 & 234881024) == 67108864) {
                z7 = true;
            } else {
                z7 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z7) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$45$lambda$44(function1, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$45$lambda$44(function1, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OutlinedTextFieldKt.OutlinedTextField(str, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default5, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.m9823getLambda$1606827980$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions3, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, (i19 & 14) | 1573248, 0, 0, 8355768);
            float f3 = 16;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, CardDefaults.INSTANCE.m2693cardElevationaqJV_2Y(Dp.m8684constructorimpl(2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62), null, ComposableLambdaKt.rememberComposableLambda(1983591900, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$59(z3, function0, autoReplyType, str3, function3, function4, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196614, 22);
            composerStartRestartGroup = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.Horizontal end3 = Arrangement.INSTANCE.getEnd();
            Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(end3, centerVertically3, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default6);
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
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 820033389, "C315@12617L10,316@12686L68,313@12506L262,320@12781L39,323@12911L25,321@12833L165:EditAutoReplyMessageScreen.kt#oif8tm");
            if (z2) {
                str4 = "Deactivate";
            } else {
                str4 = "Activate";
            }
            String str6 = str4;
            TextStyle bodyMedium2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 165005358, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            i6 = i5 & 896;
            if (i6 == 256) {
                z8 = true;
            } else {
                z8 = false;
            }
            if ((i19 & 458752) == 131072) {
                z9 = true;
            } else {
                z9 = false;
            }
            z10 = z9 | z8;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z10) {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$64$lambda$61$lambda$60(function5, z2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$64$lambda$61$lambda$60(function5, z2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextKt.m3864TextNvy7gAk(str6, ClickableKt.m584clickableoSLSa3U$default(companion2, false, null, null, null, (Function0) objRememberedValue3, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, bodyMedium2, composerStartRestartGroup, 0, 0, 131068);
            float f4 = 8;
            SpacerKt.Spacer(SizeKt.m1175width3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 165012515, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            if (i6 == 256) {
                z11 = true;
            } else {
                z11 = false;
            }
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!z11) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$64$lambda$63$lambda$62(function5, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$64$lambda$63$lambda$62(function5, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SwitchKt.Switch(z2, (Function1) objRememberedValue4, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composerStartRestartGroup, ((i19 >> 15) & 14) | 384, MenuKt.InTransitionDuration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
            TextKt.m3864TextNvy7gAk("PlaceHolders: ", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceGroup(1370519216);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*334@13216L595");
            while (r0.hasNext()) {
                builder = new AnnotatedString.Builder(0, 1, null);
                iPushStyle = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(12), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65529, (DefaultConstructorMarker) null));
                builder.append(autoReplyPlaceHolder.getKey());
                Unit unit3 = Unit.INSTANCE;
                builder.pop(iPushStyle);
                iPushStyle2 = builder.pushStyle(new SpanStyle(0L, TextUnitKt.getSp(12), (FontWeight) null, FontStyle.m8228boximpl(FontStyle.INSTANCE.m8237getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65525, (DefaultConstructorMarker) null));
                builder.append(" - " + autoReplyPlaceHolder.getDescription());
                Unit unit4 = Unit.INSTANCE;
                builder.pop(iPushStyle2);
                TextKt.m3865TextZ58ophY(builder.toAnnotatedString(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, null, composerStartRestartGroup, 0, 0, 524286);
            }
            composerStartRestartGroup.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
            KeyboardOptions keyboardOptions4 = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m8334getSentencesIUNYP9k(), (Boolean) null, KeyboardType.INSTANCE.m8361getTextPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 122, (DefaultConstructorMarker) null);
            Modifier modifierM1158heightInVpY3zN4$default2 = SizeKt.m1158heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(100), 0.0f, 2, null);
            TextStyle textStyle2 = new TextStyle(0L, TextUnitKt.getSp(18), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(32), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646141, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1370543494, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            if ((i19 & 1879048192) == 536870912) {
                z12 = true;
            } else {
                z12 = false;
            }
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!z12) {
                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$70$lambda$69(function2, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$70$lambda$69(function2, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OutlinedTextFieldKt.OutlinedTextField(str2, (Function1<? super String, Unit>) objRememberedValue5, modifierM1158heightInVpY3zN4$default2, false, false, textStyle2, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.getLambda$1922212701$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions4, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i19 >> 3) & 14) | 1769856, 0, 0, 8355736);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
            z4 = z16;
            if (z4) {
                composerStartRestartGroup.startReplaceGroup(-462248819);
                ComposerKt.sourceInformation(composerStartRestartGroup, "374@14529L750");
                Modifier modifierFillMaxWidth$default7 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.Horizontal end4 = Arrangement.INSTANCE.getEnd();
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(end4, centerVertically4, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default7);
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
                Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1862173947, "C380@14780L122,379@14738L527:EditAutoReplyMessageScreen.kt#oif8tm");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1463951465, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                softwareKeyboardController2 = softwareKeyboardController;
                zChanged = composerStartRestartGroup.changed(softwareKeyboardController2);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$73$lambda$72$lambda$71(softwareKeyboardController2, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$73$lambda$72$lambda$71(softwareKeyboardController2, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ButtonKt.TextButton((Function0) objRememberedValue7, null, false, null, null, null, null, null, null, ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.m9824getLambda$2024701038$app_debug(), composerStartRestartGroup, 805306368, 510);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                softwareKeyboardController2 = softwareKeyboardController;
                composerStartRestartGroup.startReplaceGroup(-476671724);
            }
            composerStartRestartGroup.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composerStartRestartGroup, 6);
            Modifier modifierFillMaxWidth$default8 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1370590081, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(softwareKeyboardController2);
            if ((i5 & 57344) == 16384) {
                z13 = true;
            } else {
                z13 = false;
            }
            z14 = zChanged3 | z13;
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (!z14) {
                objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$75$lambda$74(softwareKeyboardController2, function6);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$75$lambda$74(softwareKeyboardController2, function6);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CustomButtonKt.CustomButton((Function0) objRememberedValue6, modifierFillMaxWidth$default8, false, true, ComposableLambdaKt.rememberComposableLambda(-876290310, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$76(z4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 27696, 4);
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
        z6 = z4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$78(str, str2, str3, z6, autoReplyType, z2, z3, list, function1, function2, function3, function4, function5, function0, function6, function7, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean EditAutoReplyMessageScreenContent$lambda$34(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void EditAutoReplyMessageScreenContent$lambda$35(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$37$lambda$36(MutableState mutableState) {
        EditAutoReplyMessageScreenContent$lambda$35(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$40(final Function0 function0, final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C185@7819L107,184@7777L333:EditAutoReplyMessageScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-777729391, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenContent.<anonymous> (EditAutoReplyMessageScreen.kt:184)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -73633220, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$40$lambda$39$lambda$38(function0, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.getLambda$1675045710$app_debug(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$40$lambda$39$lambda$38(Function0 function0, MutableState mutableState) {
        EditAutoReplyMessageScreenContent$lambda$35(mutableState, false);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$43(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C197@8193L28,197@8172L105:EditAutoReplyMessageScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1425746157, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenContent.<anonymous> (EditAutoReplyMessageScreen.kt:197)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -47488177, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$43$lambda$42$lambda$41(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.getLambda$1027028944$app_debug(), composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$43$lambda$42$lambda$41(MutableState mutableState) {
        EditAutoReplyMessageScreenContent$lambda$35(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$45$lambda$44(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$59(boolean z, final Function0 function0, final AutoReplyType autoReplyType, String str, final Function1 function1, final Function1 function2, ColumnScope Card, Composer composer, int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation(composer, "C227@9047L3165:EditAutoReplyMessageScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983591900, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenContent.<anonymous>.<anonymous> (EditAutoReplyMessageScreen.kt:227)");
            }
            float f = 16;
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1118padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composer, -2077536023, "C232@9228L10,230@9138L180,236@9336L40,242@9618L444,238@9394L668,254@10080L41,293@11790L40,296@11927L58,299@12110L10,297@12002L196:EditAutoReplyMessageScreen.kt#oif8tm");
            TextKt.m3864TextNvy7gAk("Trigger Conditions", null, 0L, null, 0L, null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 1572870, 0, 131006);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composer, 6);
            float f2 = 8;
            FlowLayoutKt.FlowRow(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f2)), Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f2)), null, 0, 0, ComposableLambdaKt.rememberComposableLambda(-2105153631, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$59$lambda$58$lambda$50(autoReplyType, function1, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1573302, 56);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composer, 6);
            if (z) {
                composer.startReplaceGroup(-2076538506);
                ComposerKt.sourceInformation(composer, "258@10228L1022");
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
                ComposerKt.sourceInformationMarkerStart(composer, 514539820, "C264@10530L34,262@10412L457,271@10916L25,271@10895L333:EditAutoReplyMessageScreen.kt#oif8tm");
                Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (DefaultConstructorMarker) null);
                ComposerKt.sourceInformationMarkerStart(composer, 432243049, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                boolean zChanged = composer.changed(function2);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$59$lambda$58$lambda$55$lambda$52$lambda$51(function2, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                i2 = 6;
                OutlinedTextFieldKt.OutlinedTextField(str, (Function1<? super String, Unit>) objRememberedValue, modifierWeight$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.m9822getLambda$1270233427$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.m9827getLambda$815812818$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 14155776, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 8355640);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerStart(composer2, 432255392, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                boolean zChanged2 = composer2.changed(function0);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$59$lambda$58$lambda$55$lambda$54$lambda$53(function0);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                IconButtonKt.IconButton((Function0) objRememberedValue2, null, false, null, null, null, ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.m9826getLambda$658840023$app_debug(), composer2, 1572864, 62);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                i2 = 6;
                composer.startReplaceGroup(-2075496534);
                ComposerKt.sourceInformation(composer, "281@11346L25,280@11296L458");
                ComposerKt.sourceInformationMarkerStart(composer, 1179976319, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                boolean zChanged3 = composer.changed(function0);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$59$lambda$58$lambda$57$lambda$56(function0);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ButtonKt.OutlinedButton((Function0) objRememberedValue3, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, null, null, null, null, ComposableSingletons$EditAutoReplyMessageScreenKt.INSTANCE.getLambda$343409104$app_debug(), composer, 805306416, 508);
                composer2 = composer;
                composer2.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composer2, i2);
            TextKt.m3864TextNvy7gAk("Will trigger on: " + buildPreviewText(autoReplyType, str, composer2, 0), null, 0L, null, 0L, FontStyle.m8228boximpl(FontStyle.INSTANCE.m8237getItalic_LCdwA()), null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, 131038);
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
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$59$lambda$58$lambda$50(AutoReplyType autoReplyType, final Function1 function1, FlowRowScope FlowRow, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation(composer2, "C*246@9839L93,249@9970L26,244@9719L303:EditAutoReplyMessageScreen.kt#oif8tm");
        boolean z = false;
        boolean z2 = true;
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2105153631, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (EditAutoReplyMessageScreen.kt:243)");
            }
            Object[] array = AutoReplyType.getEntries().toArray(new AutoReplyType[0]);
            int length = array.length;
            int i2 = 0;
            while (i2 < length) {
                final AutoReplyType autoReplyType2 = (AutoReplyType) array[i2];
                Object[] objArr = array;
                boolean z3 = autoReplyType == autoReplyType2 ? z2 : z;
                ComposerKt.sourceInformationMarkerStart(composer2, 1368792192, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
                boolean zChanged = composer2.changed(function1) | composer2.changed(autoReplyType2.ordinal());
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$59$lambda$58$lambda$50$lambda$49$lambda$47$lambda$46(function1, autoReplyType2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ChipKt.FilterChip(z3, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(573695120, z2, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenContent$lambda$77$lambda$59$lambda$58$lambda$50$lambda$49$lambda$48(autoReplyType2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), null, false, null, null, null, null, null, null, null, composer2, 384, 0, 4088);
                i2++;
                composer2 = composer;
                z = z;
                length = length;
                z2 = z2;
                array = objArr;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$59$lambda$58$lambda$50$lambda$49$lambda$47$lambda$46(Function1 function1, AutoReplyType autoReplyType) {
        function1.invoke(autoReplyType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$59$lambda$58$lambda$50$lambda$49$lambda$48(AutoReplyType autoReplyType, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C249@9972L22:EditAutoReplyMessageScreen.kt#oif8tm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(573695120, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (EditAutoReplyMessageScreen.kt:249)");
            }
            TextKt.m3864TextNvy7gAk(autoReplyType.getDisplayName(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$59$lambda$58$lambda$55$lambda$52$lambda$51(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$59$lambda$58$lambda$55$lambda$54$lambda$53(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$59$lambda$58$lambda$57$lambda$56(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$64$lambda$61$lambda$60(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$64$lambda$63$lambda$62(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$70$lambda$69(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$73$lambda$72$lambda$71(SoftwareKeyboardController softwareKeyboardController, MutableState mutableState) {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        EditAutoReplyMessageScreenContent$lambda$35(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$75$lambda$74(SoftwareKeyboardController softwareKeyboardController, Function0 function0) {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenContent$lambda$77$lambda$76(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C406@15672L10,404@15567L213:EditAutoReplyMessageScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-876290310, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenContent.<anonymous>.<anonymous> (EditAutoReplyMessageScreen.kt:404)");
            }
            TextKt.m3864TextNvy7gAk(z ? "Update" : "Create", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final String buildPreviewText(AutoReplyType autoReplyType, String str, Composer composer, int i) {
        String displayName;
        composer.startReplaceGroup(-1848290344);
        ComposerKt.sourceInformation(composer, "C(buildPreviewText)N(selectedAutoReplyType,transactionAmount):EditAutoReplyMessageScreen.kt#oif8tm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1848290344, i, -1, "com.example.bingwahybrid.presentation.ui.screens.buildPreviewText (EditAutoReplyMessageScreen.kt:418)");
        }
        if (autoReplyType == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return "No triggers selected";
        }
        if (!StringsKt.isBlank(str)) {
            displayName = autoReplyType.getDisplayName() + " with amount " + str;
        } else {
            displayName = autoReplyType.getDisplayName();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return displayName;
    }

    private static final void EditAutoReplyMessageScreenPreview(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2146156150);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditAutoReplyMessageScreenPreview)448@16850L2,449@16881L2,450@16919L2,451@16960L2,452@16992L2,453@17026L2,454@17047L2,455@17070L2,439@16467L612:EditAutoReplyMessageScreen.kt#oif8tm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2146156150, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenPreview (EditAutoReplyMessageScreen.kt:432)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new AutoReplyPlaceHolder[]{AutoReplyPlaceHolder.FirstName.INSTANCE, AutoReplyPlaceHolder.Surname.INSTANCE, AutoReplyPlaceHolder.MpesaCode.INSTANCE});
            AutoReplyType autoReplyType = AutoReplyType.FAILED;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 871778712, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda37
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenPreview$lambda$80$lambda$79((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 871779704, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda38
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenPreview$lambda$82$lambda$81((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 871780920, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda39
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenPreview$lambda$84$lambda$83((AutoReplyType) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function3 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 871782232, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenPreview$lambda$86$lambda$85((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function4 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 871783256, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda41
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenPreview$lambda$88$lambda$87(((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function1 function5 = (Function1) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 871784344, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda42
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Function0 function0 = (Function0) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 871785016, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            Function0 function6 = (Function0) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 871785752, "CC(remember):EditAutoReplyMessageScreen.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            EditAutoReplyMessageScreenContent("Transaction Failed Response", "Thank you for your purchase", "1000", true, autoReplyType, true, true, listListOf, function1, function2, function3, function4, function5, function0, function6, (Function0) objRememberedValue8, composer2, 920350134, 224694, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreenPreview$lambda$95(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenPreview$lambda$80$lambda$79(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenPreview$lambda$82$lambda$81(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenPreview$lambda$84$lambda$83(AutoReplyType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenPreview$lambda$86$lambda$85(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditAutoReplyMessageScreenPreview$lambda$88$lambda$87(boolean z) {
        return Unit.INSTANCE;
    }

    private static final String EditAutoReplyMessageScreen$lambda$0(State<String> state) {
        return state.getValue();
    }

    private static final String EditAutoReplyMessageScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    private static final AutoReplyType EditAutoReplyMessageScreen$lambda$2(State<? extends AutoReplyType> state) {
        return state.getValue();
    }

    private static final String EditAutoReplyMessageScreen$lambda$3(State<String> state) {
        return state.getValue();
    }

    private static final boolean EditAutoReplyMessageScreen$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean EditAutoReplyMessageScreen$lambda$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean EditAutoReplyMessageScreen$lambda$6(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
