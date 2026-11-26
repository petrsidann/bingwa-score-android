package com.example.bingwahybrid.presentation.sitelink.screens;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
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
import androidx.compose.material3.RadioButtonKt;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextDecoration;
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
import androidx.profileinstaller.ProfileVerifier;
import com.example.bingwahybrid.domain.sitelink.enums.SiteLinkAccountType;
import com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel;
import com.example.bingwahybrid.presentation.ui.components.CustomButtonKt;
import io.ktor.sse.ServerSentEventKt;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: EditSiteLinkScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a)\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aË\u0001\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00162\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001bH\u0007¢\u0006\u0002\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u001bH\u0007¢\u0006\u0002\u0010#\u001a\r\u0010$\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010%¨\u0006&²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u000eX\u008a\u0084\u0002²\u0006\f\u0010'\u001a\u0004\u0018\u00010\u000eX\u008a\u0084\u0002²\u0006\f\u0010(\u001a\u0004\u0018\u00010\u000eX\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\f\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010,\u001a\u00020\u000bX\u008a\u008e\u0002"}, d2 = {"EditSiteLinkScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/sitelink/viewmodel/SiteLinkViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/sitelink/viewmodel/SiteLinkViewModel;Landroidx/compose/runtime/Composer;II)V", "EditSiteLinkScreenContent", "isLoading", "", "isSiteLinkLoading", "siteName", "", "accountNumber", "accountType", "Lcom/example/bingwahybrid/domain/sitelink/enums/SiteLinkAccountType;", HintConstants.AUTOFILL_HINT_USERNAME, "isUsernameAvailable", "isCheckingUsername", "onUsernameChanged", "Lkotlin/Function1;", "onSiteNameChanged", "onAccountNumberChanged", "onAccountTypeChanged", "onUpdateSiteLink", "Lkotlin/Function0;", "onDeleteSiteLinkClick", "(ZZLjava/lang/String;Ljava/lang/String;Lcom/example/bingwahybrid/domain/sitelink/enums/SiteLinkAccountType;Ljava/lang/String;Ljava/lang/Boolean;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "DeleteSiteLinkConfirmationDialog", "showDialog", "isDeleting", "onConfirm", "onDismiss", "(ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "EditSiteLinkScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "errorMessage", "successMessage", "siteLinkGenerationSuccess", "deleteSuccess", "updateSuccess", "showDeleteConfirmationDialog"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EditSiteLinkScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteSiteLinkConfirmationDialog$lambda$74(boolean z, boolean z2, Function0 function0, Function0 function1, int i, int i2, Composer composer, int i3) {
        DeleteSiteLinkConfirmationDialog(z, z2, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreen$lambda$45(Modifier modifier, NavHostController navHostController, SiteLinkViewModel siteLinkViewModel, int i, int i2, Composer composer, int i3) {
        EditSiteLinkScreen(modifier, navHostController, siteLinkViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenContent$lambda$53(boolean z, boolean z2, String str, String str2, SiteLinkAccountType siteLinkAccountType, String str3, Boolean bool, boolean z3, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function0 function0, Function0 function5, int i, int i2, int i3, Composer composer, int i4) {
        EditSiteLinkScreenContent(z, z2, str, str2, siteLinkAccountType, str3, bool, z3, function1, function2, function3, function4, function0, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenContent$lambda$70(boolean z, boolean z2, String str, String str2, SiteLinkAccountType siteLinkAccountType, String str3, Boolean bool, boolean z3, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function0 function0, Function0 function5, int i, int i2, int i3, Composer composer, int i4) {
        EditSiteLinkScreenContent(z, z2, str, str2, siteLinkAccountType, str3, bool, z3, function1, function2, function3, function4, function0, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenPreview$lambda$85(int i, Composer composer, int i2) {
        EditSiteLinkScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
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
    public static final void EditSiteLinkScreen(Modifier modifier, final NavHostController navController, SiteLinkViewModel siteLinkViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        SiteLinkViewModel siteLinkViewModel2;
        final SiteLinkViewModel siteLinkViewModel3;
        final Modifier modifier3;
        final SiteLinkViewModel siteLinkViewModel4;
        CreationExtras.Empty defaultViewModelCreationExtras;
        MutableState mutableState;
        boolean z;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(377706616);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditSiteLinkScreen)N(modifier,navController,viewModel)64@2941L24,65@3007L16,66@3063L16,67@3129L16,68@3191L16,69@3247L16,70@3311L16,71@3379L16,72@3469L16,73@3529L16,74@3595L16,75@3661L16,76@3739L16,77@3815L16,78@3889L16,80@3947L34,82@4008L53,82@3987L74,86@4096L165,86@4067L194,94@4298L167,94@4267L198,102@4501L130,102@4471L160,109@4679L99,109@4637L141,115@4814L179,115@4784L209,124@5026L553,140@5586L1480,123@4999L2067:EditSiteLinkScreen.kt#4cevh3");
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
                siteLinkViewModel2 = siteLinkViewModel;
                int i5 = composerStartRestartGroup.changedInstance(siteLinkViewModel2) ? 256 : 128;
                i3 |= i5;
            } else {
                siteLinkViewModel2 = siteLinkViewModel;
            }
            i3 |= i5;
        } else {
            siteLinkViewModel2 = siteLinkViewModel;
        }
        int i6 = 1;
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "62@2904L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                modifier3 = modifier2;
                siteLinkViewModel4 = siteLinkViewModel2;
                i6 = 1;
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
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(SiteLinkViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    siteLinkViewModel2 = (SiteLinkViewModel) viewModel;
                    i3 &= -897;
                }
                modifier3 = companion;
                siteLinkViewModel4 = siteLinkViewModel2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(377706616, i3, -1, "com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreen (EditSiteLinkScreen.kt:63)");
            }
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
            final State stateCollectAsState = SnapshotStateKt.collectAsState(siteLinkViewModel4.isLoading(), null, composerStartRestartGroup, 0, i6);
            final State stateCollectAsState2 = SnapshotStateKt.collectAsState(siteLinkViewModel4.getSiteName(), null, composerStartRestartGroup, 0, i6);
            final State stateCollectAsState3 = SnapshotStateKt.collectAsState(siteLinkViewModel4.getAccountNumber(), null, composerStartRestartGroup, 0, i6);
            final State stateCollectAsState4 = SnapshotStateKt.collectAsState(siteLinkViewModel4.getAccountType(), null, composerStartRestartGroup, 0, i6);
            final State stateCollectAsState5 = SnapshotStateKt.collectAsState(siteLinkViewModel4.getUsername(), null, composerStartRestartGroup, 0, i6);
            State stateCollectAsState6 = SnapshotStateKt.collectAsState(siteLinkViewModel4.getErrorMessage(), null, composerStartRestartGroup, 0, i6);
            State stateCollectAsState7 = SnapshotStateKt.collectAsState(siteLinkViewModel4.getSuccessMessage(), null, composerStartRestartGroup, 0, i6);
            State stateCollectAsState8 = SnapshotStateKt.collectAsState(siteLinkViewModel4.getSiteLinkGenerationSuccess(), null, composerStartRestartGroup, 0, i6);
            final State stateCollectAsState9 = SnapshotStateKt.collectAsState(siteLinkViewModel4.isDeleting(), null, composerStartRestartGroup, 0, i6);
            State stateCollectAsState10 = SnapshotStateKt.collectAsState(siteLinkViewModel4.getDeleteSuccess(), null, composerStartRestartGroup, 0, i6);
            State stateCollectAsState11 = SnapshotStateKt.collectAsState(siteLinkViewModel4.getUpdateSuccess(), null, composerStartRestartGroup, 0, i6);
            final State stateCollectAsState12 = SnapshotStateKt.collectAsState(siteLinkViewModel4.isUsernameAvailable(), null, composerStartRestartGroup, 0, i6);
            final State stateCollectAsState13 = SnapshotStateKt.collectAsState(siteLinkViewModel4.isCheckingUsername(), null, composerStartRestartGroup, 0, i6);
            final State stateCollectAsState14 = SnapshotStateKt.collectAsState(siteLinkViewModel4.isSiteLinkLoading(), null, composerStartRestartGroup, 0, i6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2096122886, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2096120915, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(siteLinkViewModel4);
            EditSiteLinkScreenKt$EditSiteLinkScreen$1$1 editSiteLinkScreenKt$EditSiteLinkScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || editSiteLinkScreenKt$EditSiteLinkScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editSiteLinkScreenKt$EditSiteLinkScreen$1$1RememberedValue = new EditSiteLinkScreenKt$EditSiteLinkScreen$1$1(siteLinkViewModel4, null);
                composerStartRestartGroup.updateRememberedValue(editSiteLinkScreenKt$EditSiteLinkScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editSiteLinkScreenKt$EditSiteLinkScreen$1$1RememberedValue, composerStartRestartGroup, 6);
            String strEditSiteLinkScreen$lambda$5 = EditSiteLinkScreen$lambda$5(stateCollectAsState6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2096117987, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsState6) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(siteLinkViewModel4);
            EditSiteLinkScreenKt$EditSiteLinkScreen$2$1 editSiteLinkScreenKt$EditSiteLinkScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || editSiteLinkScreenKt$EditSiteLinkScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editSiteLinkScreenKt$EditSiteLinkScreen$2$1RememberedValue = new EditSiteLinkScreenKt$EditSiteLinkScreen$2$1(stateCollectAsState6, coroutineScope, siteLinkViewModel4, null);
                composerStartRestartGroup.updateRememberedValue(editSiteLinkScreenKt$EditSiteLinkScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strEditSiteLinkScreen$lambda$5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editSiteLinkScreenKt$EditSiteLinkScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            String strEditSiteLinkScreen$lambda$6 = EditSiteLinkScreen$lambda$6(stateCollectAsState7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2096111521, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsState7) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(siteLinkViewModel4);
            EditSiteLinkScreenKt$EditSiteLinkScreen$3$1 editSiteLinkScreenKt$EditSiteLinkScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || editSiteLinkScreenKt$EditSiteLinkScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editSiteLinkScreenKt$EditSiteLinkScreen$3$1RememberedValue = new EditSiteLinkScreenKt$EditSiteLinkScreen$3$1(stateCollectAsState7, coroutineScope, siteLinkViewModel4, null);
                composerStartRestartGroup.updateRememberedValue(editSiteLinkScreenKt$EditSiteLinkScreen$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strEditSiteLinkScreen$lambda$6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editSiteLinkScreenKt$EditSiteLinkScreen$3$1RememberedValue, composerStartRestartGroup, 0);
            Boolean boolValueOf = Boolean.valueOf(EditSiteLinkScreen$lambda$10(stateCollectAsState11));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2096105062, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(stateCollectAsState11) | composerStartRestartGroup.changedInstance(siteLinkViewModel4) | composerStartRestartGroup.changedInstance(navController);
            EditSiteLinkScreenKt$EditSiteLinkScreen$4$1 editSiteLinkScreenKt$EditSiteLinkScreen$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || editSiteLinkScreenKt$EditSiteLinkScreen$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editSiteLinkScreenKt$EditSiteLinkScreen$4$1RememberedValue = new EditSiteLinkScreenKt$EditSiteLinkScreen$4$1(siteLinkViewModel4, navController, stateCollectAsState11, null);
                composerStartRestartGroup.updateRememberedValue(editSiteLinkScreenKt$EditSiteLinkScreen$4$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editSiteLinkScreenKt$EditSiteLinkScreen$4$1RememberedValue, composerStartRestartGroup, 0);
            Boolean boolValueOf2 = Boolean.valueOf(EditSiteLinkScreen$lambda$7(stateCollectAsState8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2096099397, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            boolean zChanged4 = composerStartRestartGroup.changed(stateCollectAsState8) | composerStartRestartGroup.changedInstance(navController);
            EditSiteLinkScreenKt$EditSiteLinkScreen$5$1 editSiteLinkScreenKt$EditSiteLinkScreen$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged4 || editSiteLinkScreenKt$EditSiteLinkScreen$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                editSiteLinkScreenKt$EditSiteLinkScreen$5$1RememberedValue = new EditSiteLinkScreenKt$EditSiteLinkScreen$5$1(navController, stateCollectAsState8, null);
                composerStartRestartGroup.updateRememberedValue(editSiteLinkScreenKt$EditSiteLinkScreen$5$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editSiteLinkScreenKt$EditSiteLinkScreen$5$1RememberedValue, composerStartRestartGroup, 0);
            Boolean boolValueOf3 = Boolean.valueOf(EditSiteLinkScreen$lambda$9(stateCollectAsState10));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2096094997, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            boolean zChanged5 = composerStartRestartGroup.changed(stateCollectAsState10) | composerStartRestartGroup.changedInstance(siteLinkViewModel4) | composerStartRestartGroup.changedInstance(navController);
            EditSiteLinkScreenKt$EditSiteLinkScreen$6$1 editSiteLinkScreenKt$EditSiteLinkScreen$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged5 || editSiteLinkScreenKt$EditSiteLinkScreen$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState2;
                z = true;
                editSiteLinkScreenKt$EditSiteLinkScreen$6$1RememberedValue = new EditSiteLinkScreenKt$EditSiteLinkScreen$6$1(siteLinkViewModel4, navController, stateCollectAsState10, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(editSiteLinkScreenKt$EditSiteLinkScreen$6$1RememberedValue);
            } else {
                mutableState = mutableState2;
                z = true;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editSiteLinkScreenKt$EditSiteLinkScreen$6$1RememberedValue, composerStartRestartGroup, 0);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-870520268, z, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$26(coroutineScope, navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            final MutableState mutableState3 = mutableState;
            Function3 function3 = new Function3() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$44(modifier3, siteLinkViewModel4, stateCollectAsState, stateCollectAsState14, stateCollectAsState2, stateCollectAsState3, stateCollectAsState4, stateCollectAsState5, stateCollectAsState12, stateCollectAsState13, mutableState3, stateCollectAsState9, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            modifier2 = modifier3;
            SiteLinkViewModel siteLinkViewModel5 = siteLinkViewModel4;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(294839113, z, function3, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            siteLinkViewModel3 = siteLinkViewModel5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            siteLinkViewModel3 = siteLinkViewModel2;
        }
        final Modifier modifier4 = modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$45(modifier4, navController, siteLinkViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean EditSiteLinkScreen$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EditSiteLinkScreen$lambda$16(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreen$lambda$26(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C127@5135L420,125@5040L529:EditSiteLinkScreen.kt#4cevh3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-870520268, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreen.<anonymous> (EditSiteLinkScreen.kt:125)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$821585400$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(-941240326, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$26$lambda$25(coroutineScope, navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreen$lambda$26$lambda$25(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C128@5178L239,128@5157L380:EditSiteLinkScreen.kt#4cevh3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-941240326, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreen.<anonymous>.<anonymous> (EditSiteLinkScreen.kt:128)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1706147785, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$26$lambda$25$lambda$24$lambda$23(coroutineScope, navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$245536408$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreen$lambda$26$lambda$25$lambda$24$lambda$23(CoroutineScope coroutineScope, NavHostController navHostController) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new EditSiteLinkScreenKt$EditSiteLinkScreen$7$1$1$1$1(navHostController, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreen$lambda$44(Modifier modifier, final SiteLinkViewModel siteLinkViewModel, State state, State state2, State state3, State state4, State state5, State state6, State state7, State state8, final MutableState mutableState, State state9, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)141@5613L1125,169@6898L58,172@6982L68,166@6748L312:EditSiteLinkScreen.kt#4cevh3");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(294839113, i2, -1, "com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreen.<anonymous> (EditSiteLinkScreen.kt:141)");
            }
            Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(PaddingKt.m1120paddingVpY3zN4$default(PaddingKt.padding(SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null), paddingValues), Dp.m8684constructorimpl(16), 0.0f, 2, null));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierImePadding);
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
            ComposerKt.sourceInformationMarkerStart(composer, -262545477, "C157@6260L45,158@6343L45,159@6431L48,160@6520L46,161@6603L30,162@6675L39,148@5823L905:EditSiteLinkScreen.kt#4cevh3");
            boolean zEditSiteLinkScreen$lambda$0 = EditSiteLinkScreen$lambda$0(state);
            boolean zEditSiteLinkScreen$lambda$13 = EditSiteLinkScreen$lambda$13(state2);
            String strEditSiteLinkScreen$lambda$1 = EditSiteLinkScreen$lambda$1(state3);
            String strEditSiteLinkScreen$lambda$2 = EditSiteLinkScreen$lambda$2(state4);
            SiteLinkAccountType siteLinkAccountTypeEditSiteLinkScreen$lambda$3 = EditSiteLinkScreen$lambda$3(state5);
            String strEditSiteLinkScreen$lambda$4 = EditSiteLinkScreen$lambda$4(state6);
            Boolean boolEditSiteLinkScreen$lambda$11 = EditSiteLinkScreen$lambda$11(state7);
            boolean zEditSiteLinkScreen$lambda$12 = EditSiteLinkScreen$lambda$12(state8);
            ComposerKt.sourceInformationMarkerStart(composer, 1099922572, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(siteLinkViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$44$lambda$39$lambda$28$lambda$27(siteLinkViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1099925228, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(siteLinkViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$44$lambda$39$lambda$30$lambda$29(siteLinkViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1099928047, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(siteLinkViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$44$lambda$39$lambda$32$lambda$31(siteLinkViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function1 function3 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1099930893, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(siteLinkViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$44$lambda$39$lambda$34$lambda$33(siteLinkViewModel, (SiteLinkAccountType) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function4 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1099933533, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance5 = composer.changedInstance(siteLinkViewModel);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$44$lambda$39$lambda$36$lambda$35(siteLinkViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Function0 function0 = (Function0) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1099935846, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$44$lambda$39$lambda$38$lambda$37(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EditSiteLinkScreenContent(zEditSiteLinkScreen$lambda$0, zEditSiteLinkScreen$lambda$13, strEditSiteLinkScreen$lambda$1, strEditSiteLinkScreen$lambda$2, siteLinkAccountTypeEditSiteLinkScreen$lambda$3, strEditSiteLinkScreen$lambda$4, boolEditSiteLinkScreen$lambda$11, zEditSiteLinkScreen$lambda$12, function1, function2, function3, function4, function0, (Function0) objRememberedValue6, composer, 0, 3072, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean zEditSiteLinkScreen$lambda$15 = EditSiteLinkScreen$lambda$15(mutableState);
            boolean zEditSiteLinkScreen$lambda$8 = EditSiteLinkScreen$lambda$8(state9);
            ComposerKt.sourceInformationMarkerStart(composer, -127411901, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance6 = composer.changedInstance(siteLinkViewModel);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$44$lambda$41$lambda$40(siteLinkViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            Function0 function5 = (Function0) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -127409203, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            Object objRememberedValue8 = composer.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$44$lambda$43$lambda$42(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DeleteSiteLinkConfirmationDialog(zEditSiteLinkScreen$lambda$15, zEditSiteLinkScreen$lambda$8, function5, (Function0) objRememberedValue8, composer, 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreen$lambda$44$lambda$39$lambda$28$lambda$27(SiteLinkViewModel siteLinkViewModel, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        siteLinkViewModel.onUsernameChanged(name);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreen$lambda$44$lambda$39$lambda$30$lambda$29(SiteLinkViewModel siteLinkViewModel, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        siteLinkViewModel.onSiteNameChanged(name);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreen$lambda$44$lambda$39$lambda$32$lambda$31(SiteLinkViewModel siteLinkViewModel, String acc) {
        Intrinsics.checkNotNullParameter(acc, "acc");
        siteLinkViewModel.onAccountNumberChanged(acc);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreen$lambda$44$lambda$39$lambda$34$lambda$33(SiteLinkViewModel siteLinkViewModel, SiteLinkAccountType acc) {
        Intrinsics.checkNotNullParameter(acc, "acc");
        siteLinkViewModel.onAccountTypeChanged(acc);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreen$lambda$44$lambda$39$lambda$36$lambda$35(SiteLinkViewModel siteLinkViewModel) {
        siteLinkViewModel.updateSiteLink();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreen$lambda$44$lambda$39$lambda$38$lambda$37(MutableState mutableState) {
        EditSiteLinkScreen$lambda$16(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreen$lambda$44$lambda$41$lambda$40(SiteLinkViewModel siteLinkViewModel) {
        siteLinkViewModel.deleteSiteLink();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreen$lambda$44$lambda$43$lambda$42(MutableState mutableState) {
        EditSiteLinkScreen$lambda$16(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenContent$lambda$47$lambda$46(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x014b  */
    /* JADX WARN: Code duplicated, block: B:101:0x014e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0153  */
    /* JADX WARN: Code duplicated, block: B:106:0x0159  */
    /* JADX WARN: Code duplicated, block: B:108:0x015f  */
    /* JADX WARN: Code duplicated, block: B:109:0x0162  */
    /* JADX WARN: Code duplicated, block: B:113:0x016c  */
    /* JADX WARN: Code duplicated, block: B:114:0x016f  */
    /* JADX WARN: Code duplicated, block: B:116:0x0175  */
    /* JADX WARN: Code duplicated, block: B:119:0x017e  */
    /* JADX WARN: Code duplicated, block: B:121:0x0185  */
    /* JADX WARN: Code duplicated, block: B:124:0x018f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0197  */
    /* JADX WARN: Code duplicated, block: B:127:0x019d  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:132:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:136:0x01be  */
    /* JADX WARN: Code duplicated, block: B:140:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:144:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:145:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:148:0x01db  */
    /* JADX WARN: Code duplicated, block: B:150:0x01df  */
    /* JADX WARN: Code duplicated, block: B:152:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:153:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:155:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:156:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:159:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:161:0x0207  */
    /* JADX WARN: Code duplicated, block: B:163:0x0216  */
    /* JADX WARN: Code duplicated, block: B:165:0x021a  */
    /* JADX WARN: Code duplicated, block: B:167:0x022c  */
    /* JADX WARN: Code duplicated, block: B:169:0x023c  */
    /* JADX WARN: Code duplicated, block: B:171:0x0240  */
    /* JADX WARN: Code duplicated, block: B:173:0x0254  */
    /* JADX WARN: Code duplicated, block: B:175:0x0268  */
    /* JADX WARN: Code duplicated, block: B:178:0x0273  */
    /* JADX WARN: Code duplicated, block: B:179:0x027e  */
    /* JADX WARN: Code duplicated, block: B:182:0x029c  */
    /* JADX WARN: Code duplicated, block: B:184:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:187:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:188:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:191:0x0324  */
    /* JADX WARN: Code duplicated, block: B:193:0x0332  */
    /* JADX WARN: Code duplicated, block: B:196:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:199:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:201:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:203:0x0461  */
    /* JADX WARN: Code duplicated, block: B:206:0x046d  */
    /* JADX WARN: Code duplicated, block: B:207:0x0471  */
    /* JADX WARN: Code duplicated, block: B:210:0x0496  */
    /* JADX WARN: Code duplicated, block: B:212:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:215:0x0507  */
    /* JADX WARN: Code duplicated, block: B:216:0x0509  */
    /* JADX WARN: Code duplicated, block: B:219:0x0510  */
    /* JADX WARN: Code duplicated, block: B:221:0x0518  */
    /* JADX WARN: Code duplicated, block: B:224:0x0670  */
    /* JADX WARN: Code duplicated, block: B:226:0x067c  */
    /* JADX WARN: Code duplicated, block: B:227:0x067f  */
    /* JADX WARN: Code duplicated, block: B:231:0x0693  */
    /* JADX WARN: Code duplicated, block: B:232:0x0695  */
    /* JADX WARN: Code duplicated, block: B:235:0x069d  */
    /* JADX WARN: Code duplicated, block: B:239:0x06a9  */
    /* JADX WARN: Code duplicated, block: B:242:0x079e  */
    /* JADX WARN: Code duplicated, block: B:245:0x07aa  */
    /* JADX WARN: Code duplicated, block: B:246:0x07ae  */
    /* JADX WARN: Code duplicated, block: B:249:0x07d3  */
    /* JADX WARN: Code duplicated, block: B:251:0x07e1  */
    /* JADX WARN: Code duplicated, block: B:254:0x0812  */
    /* JADX WARN: Code duplicated, block: B:255:0x0814  */
    /* JADX WARN: Code duplicated, block: B:258:0x0821  */
    /* JADX WARN: Code duplicated, block: B:259:0x0823  */
    /* JADX WARN: Code duplicated, block: B:262:0x082a  */
    /* JADX WARN: Code duplicated, block: B:266:0x0836  */
    /* JADX WARN: Code duplicated, block: B:269:0x0874  */
    /* JADX WARN: Code duplicated, block: B:270:0x0876  */
    /* JADX WARN: Code duplicated, block: B:273:0x087d  */
    /* JADX WARN: Code duplicated, block: B:275:0x0885  */
    /* JADX WARN: Code duplicated, block: B:278:0x093b  */
    /* JADX WARN: Code duplicated, block: B:279:0x093d  */
    /* JADX WARN: Code duplicated, block: B:282:0x0944  */
    /* JADX WARN: Code duplicated, block: B:286:0x0950  */
    /* JADX WARN: Code duplicated, block: B:289:0x0a30  */
    /* JADX WARN: Code duplicated, block: B:292:0x0a3c  */
    /* JADX WARN: Code duplicated, block: B:293:0x0a40  */
    /* JADX WARN: Code duplicated, block: B:296:0x0a65  */
    /* JADX WARN: Code duplicated, block: B:298:0x0a73  */
    /* JADX WARN: Code duplicated, block: B:301:0x0ae9  */
    /* JADX WARN: Code duplicated, block: B:304:0x0af1  */
    /* JADX WARN: Code duplicated, block: B:307:0x0b34  */
    /* JADX WARN: Code duplicated, block: B:309:0x0b46  */
    /* JADX WARN: Code duplicated, block: B:312:0x0b62  */
    /* JADX WARN: Code duplicated, block: B:314:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:315:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0111  */
    /* JADX WARN: Code duplicated, block: B:81:0x0114  */
    /* JADX WARN: Code duplicated, block: B:83:0x0118  */
    /* JADX WARN: Code duplicated, block: B:85:0x0122  */
    /* JADX WARN: Code duplicated, block: B:86:0x0125  */
    /* JADX WARN: Code duplicated, block: B:91:0x0134  */
    /* JADX WARN: Code duplicated, block: B:93:0x013a  */
    /* JADX WARN: Code duplicated, block: B:94:0x013d  */
    /* JADX WARN: Code duplicated, block: B:98:0x0145  */
    public static final void EditSiteLinkScreenContent(final boolean z, boolean z2, final String siteName, final String accountNumber, SiteLinkAccountType siteLinkAccountType, String str, Boolean bool, boolean z3, Function1<? super String, Unit> function1, final Function1<? super String, Unit> onSiteNameChanged, final Function1<? super String, Unit> onAccountNumberChanged, final Function1<? super SiteLinkAccountType, Unit> onAccountTypeChanged, Function0<Unit> function0, Function0<Unit> function2, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        String str2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z4;
        Composer composer2;
        final boolean z5;
        final SiteLinkAccountType siteLinkAccountType2;
        final Boolean bool2;
        final boolean z6;
        final Function1<? super String, Unit> function3;
        final Function0<Unit> function4;
        final String str3;
        final Function0<Unit> function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final boolean z7;
        SiteLinkAccountType siteLinkAccountType3;
        Boolean bool3;
        boolean z8;
        Function1<? super String, Unit> function6;
        final Function0<Unit> function7;
        String str4;
        final Function0<Unit> function8;
        ScrollState scrollStateRememberScrollState;
        int i15;
        final Function1<? super String, Unit> function9;
        final boolean z9;
        final SiteLinkAccountType siteLinkAccountType4;
        Boolean bool4;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z10;
        Object objRememberedValue;
        int i16;
        String str5;
        final Boolean bool5;
        boolean z11;
        boolean z12;
        Object objRememberedValue2;
        final Function1<? super String, Unit> function10;
        int iHashCode2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM5259constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean z13;
        int i17;
        boolean z14;
        Object objRememberedValue3;
        boolean z15;
        Object objRememberedValue4;
        boolean z16;
        Object objRememberedValue5;
        int iHashCode3;
        Function0<ComposeUiNode> constructor3;
        Composer composerM5259constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        boolean z17;
        int iHashCode4;
        Function0<ComposeUiNode> constructor4;
        Composer composerM5259constructorimpl4;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2;
        Object objRememberedValue6;
        Object objRememberedValue7;
        Object objRememberedValue8;
        int i18;
        int i19;
        int i20;
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(accountNumber, "accountNumber");
        Intrinsics.checkNotNullParameter(onSiteNameChanged, "onSiteNameChanged");
        Intrinsics.checkNotNullParameter(onAccountNumberChanged, "onAccountNumberChanged");
        Intrinsics.checkNotNullParameter(onAccountTypeChanged, "onAccountTypeChanged");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1203177779);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditSiteLinkScreenContent)N(isLoading,isSiteLinkLoading,siteName,accountNumber,accountType,username,isUsernameAvailable,isCheckingUsername,onUsernameChanged,onSiteNameChanged,onAccountNumberChanged,onAccountTypeChanged,onUpdateSiteLink,onDeleteSiteLinkClick)189@7444L2,193@7627L2,194@7671L2,196@7701L21,215@8248L4533:EditSiteLinkScreen.kt#4cevh3");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i21 = i3 & 2;
        if (i21 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(siteName) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(accountNumber) ? 2048 : 1024;
        }
        int i22 = i3 & 16;
        if (i22 != 0) {
            i4 |= 24576;
        } else if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(siteLinkAccountType == null ? -1 : siteLinkAccountType.ordinal()) ? 16384 : 8192;
        }
        int i23 = i3 & 32;
        if (i23 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            str2 = str;
        } else {
            str2 = str;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i4 |= composerStartRestartGroup.changed(str2) ? 131072 : 65536;
            }
        }
        int i24 = i3 & 64;
        if (i24 != 0) {
            i4 |= 1572864;
        } else if ((i & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changed(bool) ? 1048576 : 524288;
        }
        int i25 = i3 & 128;
        if (i25 == 0) {
            if ((i & 12582912) == 0) {
                i4 |= composerStartRestartGroup.changed(z3) ? 8388608 : 4194304;
            }
            i5 = i3 & 256;
            if (i5 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i6 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    } else {
                        i6 = 33554432;
                    }
                    i4 |= i6;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(onSiteNameChanged)) {
                        i20 = 536870912;
                    } else {
                        i20 = 268435456;
                    }
                    i4 |= i20;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(onAccountNumberChanged)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i7 = i2 | i19;
                } else {
                    i7 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onAccountTypeChanged)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i7 |= i18;
                }
                i8 = i7;
                i9 = i3 & 4096;
                if (i9 != 0) {
                    i10 = i8 | 384;
                } else if ((i2 & 384) == 0) {
                    i10 = i8 | (composerStartRestartGroup.changedInstance(function0) ? 256 : 128);
                } else {
                    i10 = i8;
                }
                i11 = i3 & 8192;
                if (i11 != 0) {
                    i13 = i10 | 3072;
                } else {
                    i12 = i10;
                    if ((i2 & 3072) != 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i14 = 2048;
                        } else {
                            i14 = 1024;
                        }
                        i12 |= i14;
                    }
                    i13 = i12;
                }
                if ((i4 & 306783379) == 306783378 || (i13 & 1171) != 1170) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    if (i21 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i22 != 0) {
                        siteLinkAccountType3 = SiteLinkAccountType.TILL;
                    } else {
                        siteLinkAccountType3 = siteLinkAccountType;
                    }
                    if (i23 != 0) {
                        str2 = "";
                    }
                    if (i24 != 0) {
                        bool3 = false;
                    } else {
                        bool3 = bool;
                    }
                    if (i25 != 0) {
                        z8 = false;
                    } else {
                        z8 = z3;
                    }
                    if (i5 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -907631025, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$47$lambda$46((String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        function6 = (Function1) objRememberedValue8;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function6 = function1;
                    }
                    if (i9 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -907625169, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda33
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function7 = (Function0) objRememberedValue7;
                    } else {
                        function7 = function0;
                    }
                    if (i11 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -907623761, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda34
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        String str6 = str2;
                        function8 = (Function0) objRememberedValue6;
                        str4 = str6;
                    } else {
                        str4 = str2;
                        function8 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1203177779, i4, i13, "com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenContent (EditSiteLinkScreen.kt:195)");
                    }
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    i15 = i13;
                    function9 = function6;
                    z9 = z8;
                    if (z7) {
                        composerStartRestartGroup.startReplaceGroup(1928529002);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "199@7761L460");
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
                        constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor4);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM5259constructorimpl4 = Updater.m5259constructorimpl(composerStartRestartGroup);
                        Updater.m5266setimpl(composerM5259constructorimpl4, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5266setimpl(composerM5259constructorimpl4, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5259constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl4.rememberedValue(), Integer.valueOf(iHashCode4))) {
                            composerM5259constructorimpl4.updateRememberedValue(Integer.valueOf(iHashCode4));
                            composerM5259constructorimpl4.apply(Integer.valueOf(iHashCode4), setCompositeKeyHash4);
                        }
                        Updater.m5266setimpl(composerM5259constructorimpl4, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 164245272, "C205@7974L41,209@8178L11,206@8028L183:EditSiteLinkScreen.kt#4cevh3");
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                        ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), Dp.m8684constructorimpl(2), 0L, 0, 0.0f, composerStartRestartGroup, 390, 56);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup2 != null) {
                            final SiteLinkAccountType siteLinkAccountType5 = siteLinkAccountType3;
                            final String str7 = str4;
                            final Boolean bool6 = bool3;
                            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda35
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$53(z, z7, siteName, accountNumber, siteLinkAccountType5, str7, bool6, z9, function9, onSiteNameChanged, onAccountNumberChanged, onAccountTypeChanged, function7, function8, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    boolean z18 = z7;
                    Function0<Unit> function11 = function7;
                    Function0<Unit> function12 = function8;
                    siteLinkAccountType4 = siteLinkAccountType3;
                    final String str8 = str4;
                    bool4 = bool3;
                    composerStartRestartGroup.startReplaceGroup(1920823797);
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollStateRememberScrollState, false, null, false, 14, null));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierImePadding);
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
                    if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 988508451, "C223@8471L25,221@8394L421,232@8824L41,235@8971L10,236@9037L11,233@8874L265,240@9148L40,244@9326L112,254@9732L840,242@9249L1410,282@10669L40,283@10718L22,284@10749L492,297@11250L41,300@11382L30,301@11434L96,298@11300L441,307@11750L40,308@11799L501,323@12310L41,329@12531L244,325@12361L414:EditSiteLinkScreen.kt#4cevh3");
                    KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), KeyboardCapitalization.INSTANCE.m8336getWordsIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, WebSocketProtocol.PAYLOAD_SHORT, (Object) null);
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353587844, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    if ((1879048192 & i4) == 536870912) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$55$lambda$54(onSiteNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i16 = i4;
                    OutlinedTextFieldKt.OutlinedTextField(siteName, (Function1<? super String, Unit>) objRememberedValue, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$209762653$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i4 >> 6) & 14) | 1573248, 113246208, 0, 7962552);
                    float f = 16;
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                    TextKt.m3864TextNvy7gAk("https://bingwahybrid.com/" + str8, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16773118, null), composerStartRestartGroup, 0, 0, 131070);
                    float f2 = 8;
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m8333getNoneIUNYP9k(), (Boolean) null, KeyboardType.INSTANCE.m8361getTextPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 122, (DefaultConstructorMarker) null);
                    str5 = str8;
                    if (str5.length() > 0) {
                        bool5 = bool4;
                        if (Intrinsics.areEqual((Object) bool5, (Object) false)) {
                            z11 = true;
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353560397, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                        if ((i16 & 234881024) == 67108864) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z12 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            function10 = function9;
                            objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            function10 = function9;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function1<? super String, Unit> function13 = function10;
                        Boolean bool7 = bool5;
                        OutlinedTextFieldKt.OutlinedTextField(str8, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$226102932$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-245291935, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$58(z9, str8, bool5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), z11, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 15) & 14) | 1573248, 196992, 0, 8343480);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                        TextKt.m3864TextNvy7gAk("Payout Account", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default3);
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
                        Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                            composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                            composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                        }
                        Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1127010563, "C288@10961L79,288@10886L155,292@11100L79,292@11055L125,295@11193L38:EditSiteLinkScreen.kt#4cevh3");
                        if (siteLinkAccountType4 == SiteLinkAccountType.MPESA) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729093974, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                        i17 = i15 & 112;
                        if (i17 == 32) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (z14 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        RadioButtonKt.RadioButton(z13, (Function0) objRememberedValue3, null, false, null, null, composerStartRestartGroup, 0, 60);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729098422, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                        if (i17 == 32) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (z15 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        TextKt.m3864TextNvy7gAk("M-Pesa", ClickableKt.m584clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue4, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262140);
                        SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                        KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default2 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
                        Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353494687, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                        if ((i15 & 14) == 4) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (z16 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        OutlinedTextFieldKt.OutlinedTextField(accountNumber, (Function1<? super String, Unit>) objRememberedValue5, modifierFillMaxWidth$default4, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2051738709, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$66(siteLinkAccountType4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default2, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 9) & 14) | 1573248, 113246208, 0, 7962552);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composerStartRestartGroup, 6);
                        Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(end, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default5);
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
                        Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5259constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl3.rememberedValue(), Integer.valueOf(iHashCode3))) {
                            composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                            composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                        }
                        Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1711102203, "C312@11928L362:EditSiteLinkScreen.kt#4cevh3");
                        ButtonKt.TextButton(function12, null, false, null, null, null, null, null, null, ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.m9598getLambda$1703772645$app_debug(), composerStartRestartGroup, ((i15 >> 9) & 14) | 805306368, 510);
                        function5 = function12;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                        if (!z || str5.length() <= 0) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        CustomButtonKt.CustomButton(function11, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z17, false, ComposableLambdaKt.rememberComposableLambda(-1643042089, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda31
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$68(z, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i15 >> 6) & 14) | 24624, 8);
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
                        str3 = str8;
                        z5 = z18;
                        function3 = function13;
                        function4 = function11;
                        siteLinkAccountType2 = siteLinkAccountType4;
                        bool2 = bool7;
                        z6 = z9;
                    } else {
                        bool5 = bool4;
                    }
                    z11 = false;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353560397, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    if ((i16 & 234881024) == 67108864) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z12) {
                        function10 = function9;
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        function10 = function9;
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1<? super String, Unit> function14 = function10;
                    Boolean bool8 = bool5;
                    OutlinedTextFieldKt.OutlinedTextField(str8, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$226102932$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-245291935, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$58(z9, str8, bool5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), z11, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 15) & 14) | 1573248, 196992, 0, 8343480);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                    TextKt.m3864TextNvy7gAk("Payout Account", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
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
                    if (composerM5259constructorimpl2.getInserting()) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    } else {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1127010563, "C288@10961L79,288@10886L155,292@11100L79,292@11055L125,295@11193L38:EditSiteLinkScreen.kt#4cevh3");
                    if (siteLinkAccountType4 == SiteLinkAccountType.MPESA) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729093974, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    i17 = i15 & 112;
                    if (i17 == 32) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    RadioButtonKt.RadioButton(z13, (Function0) objRememberedValue3, null, false, null, null, composerStartRestartGroup, 0, 60);
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729098422, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    if (i17 == 32) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z15) {
                        objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    TextKt.m3864TextNvy7gAk("M-Pesa", ClickableKt.m584clickableoSLSa3U$default(companion2, false, null, null, null, (Function0) objRememberedValue4, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262140);
                    SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                    KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default3 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
                    Modifier modifierFillMaxWidth$default7 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353494687, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    if ((i15 & 14) == 4) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z16) {
                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    OutlinedTextFieldKt.OutlinedTextField(accountNumber, (Function1<? super String, Unit>) objRememberedValue5, modifierFillMaxWidth$default7, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2051738709, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$66(siteLinkAccountType4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default3, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 9) & 14) | 1573248, 113246208, 0, 7962552);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composerStartRestartGroup, 6);
                    Modifier modifierFillMaxWidth$default8 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.Horizontal end2 = Arrangement.INSTANCE.getEnd();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(end2, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default8);
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
                    if (composerM5259constructorimpl3.getInserting()) {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    } else {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1711102203, "C312@11928L362:EditSiteLinkScreen.kt#4cevh3");
                    ButtonKt.TextButton(function12, null, false, null, null, null, null, null, null, ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.m9598getLambda$1703772645$app_debug(), composerStartRestartGroup, ((i15 >> 9) & 14) | 805306368, 510);
                    function5 = function12;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                    if (z) {
                        z17 = false;
                    } else {
                        z17 = false;
                    }
                    CustomButtonKt.CustomButton(function11, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z17, false, ComposableLambdaKt.rememberComposableLambda(-1643042089, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$68(z, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i15 >> 6) & 14) | 24624, 8);
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
                    str3 = str8;
                    z5 = z18;
                    function3 = function14;
                    function4 = function11;
                    siteLinkAccountType2 = siteLinkAccountType4;
                    bool2 = bool8;
                    z6 = z9;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z5 = z2;
                    siteLinkAccountType2 = siteLinkAccountType;
                    bool2 = bool;
                    z6 = z3;
                    function3 = function1;
                    function4 = function0;
                    str3 = str2;
                    function5 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$70(z, z5, siteName, accountNumber, siteLinkAccountType2, str3, bool2, z6, function3, onSiteNameChanged, onAccountNumberChanged, onAccountTypeChanged, function4, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(onSiteNameChanged)) {
                    i20 = 536870912;
                } else {
                    i20 = 268435456;
                }
                i4 |= i20;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(onAccountNumberChanged)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i7 = i2 | i19;
            } else {
                i7 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(onAccountTypeChanged)) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i7 |= i18;
            }
            i8 = i7;
            i9 = i3 & 4096;
            if (i9 != 0) {
                i10 = i8 | 384;
            } else if ((i2 & 384) == 0) {
                i10 = i8 | (composerStartRestartGroup.changedInstance(function0) ? 256 : 128);
            } else {
                i10 = i8;
            }
            i11 = i3 & 8192;
            if (i11 != 0) {
                i13 = i10 | 3072;
            } else {
                i12 = i10;
                if ((i2 & 3072) != 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i14 = 2048;
                    } else {
                        i14 = 1024;
                    }
                    i12 |= i14;
                }
                i13 = i12;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                if (i21 != 0) {
                    z7 = false;
                } else {
                    z7 = z2;
                }
                if (i22 != 0) {
                    siteLinkAccountType3 = SiteLinkAccountType.TILL;
                } else {
                    siteLinkAccountType3 = siteLinkAccountType;
                }
                if (i23 != 0) {
                    str2 = "";
                }
                if (i24 != 0) {
                    bool3 = false;
                } else {
                    bool3 = bool;
                }
                if (i25 != 0) {
                    z8 = false;
                } else {
                    z8 = z3;
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -907631025, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$47$lambda$46((String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    function6 = (Function1) objRememberedValue8;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function6 = function1;
                }
                if (i9 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -907625169, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda33
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function7 = (Function0) objRememberedValue7;
                } else {
                    function7 = function0;
                }
                if (i11 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -907623761, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda34
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str9 = str2;
                    function8 = (Function0) objRememberedValue6;
                    str4 = str9;
                } else {
                    str4 = str2;
                    function8 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1203177779, i4, i13, "com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenContent (EditSiteLinkScreen.kt:195)");
                }
                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                i15 = i13;
                function9 = function6;
                z9 = z8;
                if (z7) {
                    composerStartRestartGroup.startReplaceGroup(1928529002);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "199@7761L460");
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                    Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(center2, centerHorizontally2, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor4);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM5259constructorimpl4 = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl4, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl4, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5259constructorimpl4.getInserting()) {
                        composerM5259constructorimpl4.updateRememberedValue(Integer.valueOf(iHashCode4));
                        composerM5259constructorimpl4.apply(Integer.valueOf(iHashCode4), setCompositeKeyHash4);
                    } else {
                        composerM5259constructorimpl4.updateRememberedValue(Integer.valueOf(iHashCode4));
                        composerM5259constructorimpl4.apply(Integer.valueOf(iHashCode4), setCompositeKeyHash4);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl4, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 164245272, "C205@7974L41,209@8178L11,206@8028L183:EditSiteLinkScreen.kt#4cevh3");
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                    ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), Dp.m8684constructorimpl(2), 0L, 0, 0.0f, composerStartRestartGroup, 390, 56);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final SiteLinkAccountType siteLinkAccountType6 = siteLinkAccountType3;
                        final String str10 = str4;
                        final Boolean bool9 = bool3;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda35
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$53(z, z7, siteName, accountNumber, siteLinkAccountType6, str10, bool9, z9, function9, onSiteNameChanged, onAccountNumberChanged, onAccountTypeChanged, function7, function8, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                boolean z19 = z7;
                Function0<Unit> function15 = function7;
                Function0<Unit> function16 = function8;
                siteLinkAccountType4 = siteLinkAccountType3;
                final String str11 = str4;
                bool4 = bool3;
                composerStartRestartGroup.startReplaceGroup(1920823797);
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierImePadding2 = WindowInsetsPadding_androidKt.imePadding(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollStateRememberScrollState, false, null, false, 14, null));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierImePadding2);
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
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 988508451, "C223@8471L25,221@8394L421,232@8824L41,235@8971L10,236@9037L11,233@8874L265,240@9148L40,244@9326L112,254@9732L840,242@9249L1410,282@10669L40,283@10718L22,284@10749L492,297@11250L41,300@11382L30,301@11434L96,298@11300L441,307@11750L40,308@11799L501,323@12310L41,329@12531L244,325@12361L414:EditSiteLinkScreen.kt#4cevh3");
                KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default4 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), KeyboardCapitalization.INSTANCE.m8336getWordsIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, WebSocketProtocol.PAYLOAD_SHORT, (Object) null);
                Modifier modifierFillMaxWidth$default9 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353587844, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                if ((1879048192 & i4) == 536870912) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z10) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$55$lambda$54(onSiteNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$55$lambda$54(onSiteNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i16 = i4;
                OutlinedTextFieldKt.OutlinedTextField(siteName, (Function1<? super String, Unit>) objRememberedValue, modifierFillMaxWidth$default9, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$209762653$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default4, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i4 >> 6) & 14) | 1573248, 113246208, 0, 7962552);
                float f3 = 16;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
                TextKt.m3864TextNvy7gAk("https://bingwahybrid.com/" + str11, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16773118, null), composerStartRestartGroup, 0, 0, 131070);
                float f4 = 8;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default10 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                KeyboardOptions keyboardOptions2 = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m8333getNoneIUNYP9k(), (Boolean) null, KeyboardType.INSTANCE.m8361getTextPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 122, (DefaultConstructorMarker) null);
                str5 = str11;
                if (str5.length() > 0) {
                    bool5 = bool4;
                    if (Intrinsics.areEqual((Object) bool5, (Object) false)) {
                        z11 = true;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353560397, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    if ((i16 & 234881024) == 67108864) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z12) {
                        function10 = function9;
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        function10 = function9;
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1<? super String, Unit> function17 = function10;
                    Boolean bool10 = bool5;
                    OutlinedTextFieldKt.OutlinedTextField(str11, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default10, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$226102932$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-245291935, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$58(z9, str11, bool5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), z11, (VisualTransformation) null, keyboardOptions2, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 15) & 14) | 1573248, 196992, 0, 8343480);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
                    TextKt.m3864TextNvy7gAk("Payout Account", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                    Modifier modifierFillMaxWidth$default11 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default11);
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
                    Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5259constructorimpl2.getInserting()) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    } else {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1127010563, "C288@10961L79,288@10886L155,292@11100L79,292@11055L125,295@11193L38:EditSiteLinkScreen.kt#4cevh3");
                    if (siteLinkAccountType4 == SiteLinkAccountType.MPESA) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729093974, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    i17 = i15 & 112;
                    if (i17 == 32) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    RadioButtonKt.RadioButton(z13, (Function0) objRememberedValue3, null, false, null, null, composerStartRestartGroup, 0, 60);
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729098422, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    if (i17 == 32) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z15) {
                        objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    TextKt.m3864TextNvy7gAk("M-Pesa", ClickableKt.m584clickableoSLSa3U$default(companion3, false, null, null, null, (Function0) objRememberedValue4, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262140);
                    SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance5, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
                    KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default5 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
                    Modifier modifierFillMaxWidth$default12 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353494687, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    if ((i15 & 14) == 4) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z16) {
                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    OutlinedTextFieldKt.OutlinedTextField(accountNumber, (Function1<? super String, Unit>) objRememberedValue5, modifierFillMaxWidth$default12, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2051738709, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$66(siteLinkAccountType4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default5, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 9) & 14) | 1573248, 113246208, 0, 7962552);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composerStartRestartGroup, 6);
                    Modifier modifierFillMaxWidth$default13 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.Horizontal end3 = Arrangement.INSTANCE.getEnd();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(end3, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default13);
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
                    Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5259constructorimpl3.getInserting()) {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    } else {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1711102203, "C312@11928L362:EditSiteLinkScreen.kt#4cevh3");
                    ButtonKt.TextButton(function16, null, false, null, null, null, null, null, null, ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.m9598getLambda$1703772645$app_debug(), composerStartRestartGroup, ((i15 >> 9) & 14) | 805306368, 510);
                    function5 = function16;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
                    if (z) {
                        z17 = false;
                    } else {
                        z17 = false;
                    }
                    CustomButtonKt.CustomButton(function15, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z17, false, ComposableLambdaKt.rememberComposableLambda(-1643042089, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$68(z, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i15 >> 6) & 14) | 24624, 8);
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
                    str3 = str11;
                    z5 = z19;
                    function3 = function17;
                    function4 = function15;
                    siteLinkAccountType2 = siteLinkAccountType4;
                    bool2 = bool10;
                    z6 = z9;
                } else {
                    bool5 = bool4;
                }
                z11 = false;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353560397, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                if ((i16 & 234881024) == 67108864) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12) {
                    function10 = function9;
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    function10 = function9;
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function1<? super String, Unit> function18 = function10;
                Boolean bool11 = bool5;
                OutlinedTextFieldKt.OutlinedTextField(str11, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default10, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$226102932$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-245291935, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$58(z9, str11, bool5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), z11, (VisualTransformation) null, keyboardOptions2, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 15) & 14) | 1573248, 196992, 0, 8343480);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
                TextKt.m3864TextNvy7gAk("Payout Account", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                Modifier modifierFillMaxWidth$default14 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default14);
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
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1127010563, "C288@10961L79,288@10886L155,292@11100L79,292@11055L125,295@11193L38:EditSiteLinkScreen.kt#4cevh3");
                if (siteLinkAccountType4 == SiteLinkAccountType.MPESA) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729093974, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                i17 = i15 & 112;
                if (i17 == 32) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                RadioButtonKt.RadioButton(z13, (Function0) objRememberedValue3, null, false, null, null, composerStartRestartGroup, 0, 60);
                Modifier.Companion companion4 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729098422, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                if (i17 == 32) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TextKt.m3864TextNvy7gAk("M-Pesa", ClickableKt.m584clickableoSLSa3U$default(companion4, false, null, null, null, (Function0) objRememberedValue4, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262140);
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance7, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
                KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default6 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
                Modifier modifierFillMaxWidth$default15 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353494687, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                if ((i15 & 14) == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z16) {
                    objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                OutlinedTextFieldKt.OutlinedTextField(accountNumber, (Function1<? super String, Unit>) objRememberedValue5, modifierFillMaxWidth$default15, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2051738709, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$66(siteLinkAccountType4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default6, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 9) & 14) | 1573248, 113246208, 0, 7962552);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default16 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.Horizontal end4 = Arrangement.INSTANCE.getEnd();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(end4, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default16);
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
                Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl3.getInserting()) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                } else {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1711102203, "C312@11928L362:EditSiteLinkScreen.kt#4cevh3");
                ButtonKt.TextButton(function16, null, false, null, null, null, null, null, null, ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.m9598getLambda$1703772645$app_debug(), composerStartRestartGroup, ((i15 >> 9) & 14) | 805306368, 510);
                function5 = function16;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
                if (z) {
                    z17 = false;
                } else {
                    z17 = false;
                }
                CustomButtonKt.CustomButton(function15, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z17, false, ComposableLambdaKt.rememberComposableLambda(-1643042089, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$68(z, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i15 >> 6) & 14) | 24624, 8);
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
                str3 = str11;
                z5 = z19;
                function3 = function18;
                function4 = function15;
                siteLinkAccountType2 = siteLinkAccountType4;
                bool2 = bool11;
                z6 = z9;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z5 = z2;
                siteLinkAccountType2 = siteLinkAccountType;
                bool2 = bool;
                z6 = z3;
                function3 = function1;
                function4 = function0;
                str3 = str2;
                function5 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$70(z, z5, siteName, accountNumber, siteLinkAccountType2, str3, bool2, z6, function3, onSiteNameChanged, onAccountNumberChanged, onAccountTypeChanged, function4, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 12582912;
        i5 = i3 & 256;
        if (i5 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i6 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                } else {
                    i6 = 33554432;
                }
                i4 |= i6;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(onSiteNameChanged)) {
                    i20 = 536870912;
                } else {
                    i20 = 268435456;
                }
                i4 |= i20;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(onAccountNumberChanged)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i7 = i2 | i19;
            } else {
                i7 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(onAccountTypeChanged)) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i7 |= i18;
            }
            i8 = i7;
            i9 = i3 & 4096;
            if (i9 != 0) {
                i10 = i8 | 384;
            } else if ((i2 & 384) == 0) {
                i10 = i8 | (composerStartRestartGroup.changedInstance(function0) ? 256 : 128);
            } else {
                i10 = i8;
            }
            i11 = i3 & 8192;
            if (i11 != 0) {
                i13 = i10 | 3072;
            } else {
                i12 = i10;
                if ((i2 & 3072) != 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i14 = 2048;
                    } else {
                        i14 = 1024;
                    }
                    i12 |= i14;
                }
                i13 = i12;
            }
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                if (i21 != 0) {
                    z7 = false;
                } else {
                    z7 = z2;
                }
                if (i22 != 0) {
                    siteLinkAccountType3 = SiteLinkAccountType.TILL;
                } else {
                    siteLinkAccountType3 = siteLinkAccountType;
                }
                if (i23 != 0) {
                    str2 = "";
                }
                if (i24 != 0) {
                    bool3 = false;
                } else {
                    bool3 = bool;
                }
                if (i25 != 0) {
                    z8 = false;
                } else {
                    z8 = z3;
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -907631025, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$47$lambda$46((String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    function6 = (Function1) objRememberedValue8;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function6 = function1;
                }
                if (i9 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -907625169, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda33
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function7 = (Function0) objRememberedValue7;
                } else {
                    function7 = function0;
                }
                if (i11 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -907623761, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda34
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str12 = str2;
                    function8 = (Function0) objRememberedValue6;
                    str4 = str12;
                } else {
                    str4 = str2;
                    function8 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1203177779, i4, i13, "com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenContent (EditSiteLinkScreen.kt:195)");
                }
                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                i15 = i13;
                function9 = function6;
                z9 = z8;
                if (z7) {
                    composerStartRestartGroup.startReplaceGroup(1928529002);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "199@7761L460");
                    Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical center3 = Arrangement.INSTANCE.getCenter();
                    Alignment.Horizontal centerHorizontally3 = Alignment.INSTANCE.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(center3, centerHorizontally3, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default3);
                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor4);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM5259constructorimpl4 = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl4, measurePolicyColumnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl4, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5259constructorimpl4.getInserting()) {
                        composerM5259constructorimpl4.updateRememberedValue(Integer.valueOf(iHashCode4));
                        composerM5259constructorimpl4.apply(Integer.valueOf(iHashCode4), setCompositeKeyHash4);
                    } else {
                        composerM5259constructorimpl4.updateRememberedValue(Integer.valueOf(iHashCode4));
                        composerM5259constructorimpl4.apply(Integer.valueOf(iHashCode4), setCompositeKeyHash4);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl4, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 164245272, "C205@7974L41,209@8178L11,206@8028L183:EditSiteLinkScreen.kt#4cevh3");
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                    ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), Dp.m8684constructorimpl(2), 0L, 0, 0.0f, composerStartRestartGroup, 390, 56);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final SiteLinkAccountType siteLinkAccountType7 = siteLinkAccountType3;
                        final String str13 = str4;
                        final Boolean bool12 = bool3;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda35
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$53(z, z7, siteName, accountNumber, siteLinkAccountType7, str13, bool12, z9, function9, onSiteNameChanged, onAccountNumberChanged, onAccountTypeChanged, function7, function8, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                boolean z110 = z7;
                Function0<Unit> function19 = function7;
                Function0<Unit> function110 = function8;
                siteLinkAccountType4 = siteLinkAccountType3;
                final String str14 = str4;
                bool4 = bool3;
                composerStartRestartGroup.startReplaceGroup(1920823797);
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierImePadding3 = WindowInsetsPadding_androidKt.imePadding(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollStateRememberScrollState, false, null, false, 14, null));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierImePadding3);
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
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 988508451, "C223@8471L25,221@8394L421,232@8824L41,235@8971L10,236@9037L11,233@8874L265,240@9148L40,244@9326L112,254@9732L840,242@9249L1410,282@10669L40,283@10718L22,284@10749L492,297@11250L41,300@11382L30,301@11434L96,298@11300L441,307@11750L40,308@11799L501,323@12310L41,329@12531L244,325@12361L414:EditSiteLinkScreen.kt#4cevh3");
                KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default7 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), KeyboardCapitalization.INSTANCE.m8336getWordsIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, WebSocketProtocol.PAYLOAD_SHORT, (Object) null);
                Modifier modifierFillMaxWidth$default17 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353587844, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                if ((1879048192 & i4) == 536870912) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z10) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$55$lambda$54(onSiteNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$55$lambda$54(onSiteNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i16 = i4;
                OutlinedTextFieldKt.OutlinedTextField(siteName, (Function1<? super String, Unit>) objRememberedValue, modifierFillMaxWidth$default17, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$209762653$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default7, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i4 >> 6) & 14) | 1573248, 113246208, 0, 7962552);
                float f5 = 16;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f5)), composerStartRestartGroup, 6);
                TextKt.m3864TextNvy7gAk("https://bingwahybrid.com/" + str14, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16773118, null), composerStartRestartGroup, 0, 0, 131070);
                float f6 = 8;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f6)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default18 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                KeyboardOptions keyboardOptions3 = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m8333getNoneIUNYP9k(), (Boolean) null, KeyboardType.INSTANCE.m8361getTextPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 122, (DefaultConstructorMarker) null);
                str5 = str14;
                if (str5.length() > 0) {
                    bool5 = bool4;
                    if (Intrinsics.areEqual((Object) bool5, (Object) false)) {
                        z11 = true;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353560397, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    if ((i16 & 234881024) == 67108864) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z12) {
                        function10 = function9;
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        function10 = function9;
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1<? super String, Unit> function111 = function10;
                    Boolean bool13 = bool5;
                    OutlinedTextFieldKt.OutlinedTextField(str14, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default18, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$226102932$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-245291935, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$58(z9, str14, bool5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), z11, (VisualTransformation) null, keyboardOptions3, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 15) & 14) | 1573248, 196992, 0, 8343480);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f6)), composerStartRestartGroup, 6);
                    TextKt.m3864TextNvy7gAk("Payout Account", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                    Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                    Modifier modifierFillMaxWidth$default19 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy9 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically5, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default19);
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
                    Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5259constructorimpl2.getInserting()) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    } else {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance9 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1127010563, "C288@10961L79,288@10886L155,292@11100L79,292@11055L125,295@11193L38:EditSiteLinkScreen.kt#4cevh3");
                    if (siteLinkAccountType4 == SiteLinkAccountType.MPESA) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729093974, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    i17 = i15 & 112;
                    if (i17 == 32) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    RadioButtonKt.RadioButton(z13, (Function0) objRememberedValue3, null, false, null, null, composerStartRestartGroup, 0, 60);
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729098422, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    if (i17 == 32) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z15) {
                        objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    TextKt.m3864TextNvy7gAk("M-Pesa", ClickableKt.m584clickableoSLSa3U$default(companion5, false, null, null, null, (Function0) objRememberedValue4, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262140);
                    SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance9, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f5)), composerStartRestartGroup, 6);
                    KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default8 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
                    Modifier modifierFillMaxWidth$default110 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353494687, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                    if ((i15 & 14) == 4) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z16) {
                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    OutlinedTextFieldKt.OutlinedTextField(accountNumber, (Function1<? super String, Unit>) objRememberedValue5, modifierFillMaxWidth$default110, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2051738709, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$66(siteLinkAccountType4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default8, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 9) & 14) | 1573248, 113246208, 0, 7962552);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composerStartRestartGroup, 6);
                    Modifier modifierFillMaxWidth$default111 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.Horizontal end5 = Arrangement.INSTANCE.getEnd();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy10 = RowKt.rowMeasurePolicy(end5, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default111);
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
                    Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5259constructorimpl3.getInserting()) {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    } else {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance10 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1711102203, "C312@11928L362:EditSiteLinkScreen.kt#4cevh3");
                    ButtonKt.TextButton(function110, null, false, null, null, null, null, null, null, ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.m9598getLambda$1703772645$app_debug(), composerStartRestartGroup, ((i15 >> 9) & 14) | 805306368, 510);
                    function5 = function110;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f5)), composerStartRestartGroup, 6);
                    if (z) {
                        z17 = false;
                    } else {
                        z17 = false;
                    }
                    CustomButtonKt.CustomButton(function19, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z17, false, ComposableLambdaKt.rememberComposableLambda(-1643042089, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$68(z, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i15 >> 6) & 14) | 24624, 8);
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
                    str3 = str14;
                    z5 = z110;
                    function3 = function111;
                    function4 = function19;
                    siteLinkAccountType2 = siteLinkAccountType4;
                    bool2 = bool13;
                    z6 = z9;
                } else {
                    bool5 = bool4;
                }
                z11 = false;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353560397, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                if ((i16 & 234881024) == 67108864) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12) {
                    function10 = function9;
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    function10 = function9;
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function1<? super String, Unit> function112 = function10;
                Boolean bool14 = bool5;
                OutlinedTextFieldKt.OutlinedTextField(str14, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default18, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$226102932$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-245291935, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$58(z9, str14, bool5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), z11, (VisualTransformation) null, keyboardOptions3, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 15) & 14) | 1573248, 196992, 0, 8343480);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f6)), composerStartRestartGroup, 6);
                TextKt.m3864TextNvy7gAk("Payout Account", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                Modifier modifierFillMaxWidth$default112 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy11 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically6, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default112);
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
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier17, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance11 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1127010563, "C288@10961L79,288@10886L155,292@11100L79,292@11055L125,295@11193L38:EditSiteLinkScreen.kt#4cevh3");
                if (siteLinkAccountType4 == SiteLinkAccountType.MPESA) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729093974, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                i17 = i15 & 112;
                if (i17 == 32) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                RadioButtonKt.RadioButton(z13, (Function0) objRememberedValue3, null, false, null, null, composerStartRestartGroup, 0, 60);
                Modifier.Companion companion6 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729098422, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                if (i17 == 32) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TextKt.m3864TextNvy7gAk("M-Pesa", ClickableKt.m584clickableoSLSa3U$default(companion6, false, null, null, null, (Function0) objRememberedValue4, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262140);
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance11, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f5)), composerStartRestartGroup, 6);
                KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default9 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
                Modifier modifierFillMaxWidth$default113 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353494687, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                if ((i15 & 14) == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z16) {
                    objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                OutlinedTextFieldKt.OutlinedTextField(accountNumber, (Function1<? super String, Unit>) objRememberedValue5, modifierFillMaxWidth$default113, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2051738709, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$66(siteLinkAccountType4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default9, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 9) & 14) | 1573248, 113246208, 0, 7962552);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default114 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.Horizontal end6 = Arrangement.INSTANCE.getEnd();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy12 = RowKt.rowMeasurePolicy(end6, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default114);
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
                Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl3.getInserting()) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                } else {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance12 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1711102203, "C312@11928L362:EditSiteLinkScreen.kt#4cevh3");
                ButtonKt.TextButton(function110, null, false, null, null, null, null, null, null, ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.m9598getLambda$1703772645$app_debug(), composerStartRestartGroup, ((i15 >> 9) & 14) | 805306368, 510);
                function5 = function110;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f5)), composerStartRestartGroup, 6);
                if (z) {
                    z17 = false;
                } else {
                    z17 = false;
                }
                CustomButtonKt.CustomButton(function19, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z17, false, ComposableLambdaKt.rememberComposableLambda(-1643042089, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$68(z, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i15 >> 6) & 14) | 24624, 8);
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
                str3 = str14;
                z5 = z110;
                function3 = function112;
                function4 = function19;
                siteLinkAccountType2 = siteLinkAccountType4;
                bool2 = bool14;
                z6 = z9;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z5 = z2;
                siteLinkAccountType2 = siteLinkAccountType;
                bool2 = bool;
                z6 = z3;
                function3 = function1;
                function4 = function0;
                str3 = str2;
                function5 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$70(z, z5, siteName, accountNumber, siteLinkAccountType2, str3, bool2, z6, function3, onSiteNameChanged, onAccountNumberChanged, onAccountTypeChanged, function4, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 100663296;
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(onSiteNameChanged)) {
                i20 = 536870912;
            } else {
                i20 = 268435456;
            }
            i4 |= i20;
        }
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(onAccountNumberChanged)) {
                i19 = 4;
            } else {
                i19 = 2;
            }
            i7 = i2 | i19;
        } else {
            i7 = i2;
        }
        if ((i2 & 48) == 0) {
            if (composerStartRestartGroup.changedInstance(onAccountTypeChanged)) {
                i18 = 32;
            } else {
                i18 = 16;
            }
            i7 |= i18;
        }
        i8 = i7;
        i9 = i3 & 4096;
        if (i9 != 0) {
            i10 = i8 | 384;
        } else if ((i2 & 384) == 0) {
            i10 = i8 | (composerStartRestartGroup.changedInstance(function0) ? 256 : 128);
        } else {
            i10 = i8;
        }
        i11 = i3 & 8192;
        if (i11 != 0) {
            i13 = i10 | 3072;
        } else {
            i12 = i10;
            if ((i2 & 3072) != 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i14 = 2048;
                } else {
                    i14 = 1024;
                }
                i12 |= i14;
            }
            i13 = i12;
        }
        if ((i4 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
            if (i21 != 0) {
                z7 = false;
            } else {
                z7 = z2;
            }
            if (i22 != 0) {
                siteLinkAccountType3 = SiteLinkAccountType.TILL;
            } else {
                siteLinkAccountType3 = siteLinkAccountType;
            }
            if (i23 != 0) {
                str2 = "";
            }
            if (i24 != 0) {
                bool3 = false;
            } else {
                bool3 = bool;
            }
            if (i25 != 0) {
                z8 = false;
            } else {
                z8 = z3;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -907631025, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$47$lambda$46((String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                function6 = (Function1) objRememberedValue8;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function6 = function1;
            }
            if (i9 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -907625169, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function7 = (Function0) objRememberedValue7;
            } else {
                function7 = function0;
            }
            if (i11 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -907623761, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda34
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String str15 = str2;
                function8 = (Function0) objRememberedValue6;
                str4 = str15;
            } else {
                str4 = str2;
                function8 = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1203177779, i4, i13, "com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenContent (EditSiteLinkScreen.kt:195)");
            }
            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
            i15 = i13;
            function9 = function6;
            z9 = z8;
            if (z7) {
                composerStartRestartGroup.startReplaceGroup(1928529002);
                ComposerKt.sourceInformation(composerStartRestartGroup, "199@7761L460");
                Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical center4 = Arrangement.INSTANCE.getCenter();
                Alignment.Horizontal centerHorizontally4 = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(center4, centerHorizontally4, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default4);
                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM5259constructorimpl4 = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl4, measurePolicyColumnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl4, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl4.getInserting()) {
                    composerM5259constructorimpl4.updateRememberedValue(Integer.valueOf(iHashCode4));
                    composerM5259constructorimpl4.apply(Integer.valueOf(iHashCode4), setCompositeKeyHash4);
                } else {
                    composerM5259constructorimpl4.updateRememberedValue(Integer.valueOf(iHashCode4));
                    composerM5259constructorimpl4.apply(Integer.valueOf(iHashCode4), setCompositeKeyHash4);
                }
                Updater.m5266setimpl(composerM5259constructorimpl4, modifierMaterializeModifier19, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 164245272, "C205@7974L41,209@8178L11,206@8028L183:EditSiteLinkScreen.kt#4cevh3");
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), Dp.m8684constructorimpl(2), 0L, 0, 0.0f, composerStartRestartGroup, 390, 56);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    final SiteLinkAccountType siteLinkAccountType8 = siteLinkAccountType3;
                    final String str16 = str4;
                    final Boolean bool15 = bool3;
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda35
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$53(z, z7, siteName, accountNumber, siteLinkAccountType8, str16, bool15, z9, function9, onSiteNameChanged, onAccountNumberChanged, onAccountTypeChanged, function7, function8, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            boolean z111 = z7;
            Function0<Unit> function113 = function7;
            Function0<Unit> function114 = function8;
            siteLinkAccountType4 = siteLinkAccountType3;
            final String str17 = str4;
            bool4 = bool3;
            composerStartRestartGroup.startReplaceGroup(1920823797);
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierImePadding4 = WindowInsetsPadding_androidKt.imePadding(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), scrollStateRememberScrollState, false, null, false, 14, null));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierImePadding4);
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
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting()) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            } else {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 988508451, "C223@8471L25,221@8394L421,232@8824L41,235@8971L10,236@9037L11,233@8874L265,240@9148L40,244@9326L112,254@9732L840,242@9249L1410,282@10669L40,283@10718L22,284@10749L492,297@11250L41,300@11382L30,301@11434L96,298@11300L441,307@11750L40,308@11799L501,323@12310L41,329@12531L244,325@12361L414:EditSiteLinkScreen.kt#4cevh3");
            KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default10 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), KeyboardCapitalization.INSTANCE.m8336getWordsIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, WebSocketProtocol.PAYLOAD_SHORT, (Object) null);
            Modifier modifierFillMaxWidth$default115 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353587844, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            if ((1879048192 & i4) == 536870912) {
                z10 = true;
            } else {
                z10 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$55$lambda$54(onSiteNameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$55$lambda$54(onSiteNameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            i16 = i4;
            OutlinedTextFieldKt.OutlinedTextField(siteName, (Function1<? super String, Unit>) objRememberedValue, modifierFillMaxWidth$default115, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$209762653$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default10, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i4 >> 6) & 14) | 1573248, 113246208, 0, 7962552);
            float f7 = 16;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f7)), composerStartRestartGroup, 6);
            TextKt.m3864TextNvy7gAk("https://bingwahybrid.com/" + str17, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16773118, null), composerStartRestartGroup, 0, 0, 131070);
            float f8 = 8;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f8)), composerStartRestartGroup, 6);
            Modifier modifierFillMaxWidth$default116 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            KeyboardOptions keyboardOptions4 = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m8333getNoneIUNYP9k(), (Boolean) null, KeyboardType.INSTANCE.m8361getTextPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 122, (DefaultConstructorMarker) null);
            str5 = str17;
            if (str5.length() > 0) {
                bool5 = bool4;
                if (Intrinsics.areEqual((Object) bool5, (Object) false)) {
                    z11 = true;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353560397, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                if ((i16 & 234881024) == 67108864) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z12) {
                    function10 = function9;
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    function10 = function9;
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function1<? super String, Unit> function115 = function10;
                Boolean bool16 = bool5;
                OutlinedTextFieldKt.OutlinedTextField(str17, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default116, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$226102932$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-245291935, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$58(z9, str17, bool5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), z11, (VisualTransformation) null, keyboardOptions4, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 15) & 14) | 1573248, 196992, 0, 8343480);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f8)), composerStartRestartGroup, 6);
                TextKt.m3864TextNvy7gAk("Payout Account", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                Modifier modifierFillMaxWidth$default117 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy13 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically7, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default117);
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
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier111, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance13 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1127010563, "C288@10961L79,288@10886L155,292@11100L79,292@11055L125,295@11193L38:EditSiteLinkScreen.kt#4cevh3");
                if (siteLinkAccountType4 == SiteLinkAccountType.MPESA) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729093974, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                i17 = i15 & 112;
                if (i17 == 32) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                RadioButtonKt.RadioButton(z13, (Function0) objRememberedValue3, null, false, null, null, composerStartRestartGroup, 0, 60);
                Modifier.Companion companion7 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729098422, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                if (i17 == 32) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TextKt.m3864TextNvy7gAk("M-Pesa", ClickableKt.m584clickableoSLSa3U$default(companion7, false, null, null, null, (Function0) objRememberedValue4, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262140);
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance13, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f7)), composerStartRestartGroup, 6);
                KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default11 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
                Modifier modifierFillMaxWidth$default118 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353494687, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
                if ((i15 & 14) == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z16) {
                    objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                OutlinedTextFieldKt.OutlinedTextField(accountNumber, (Function1<? super String, Unit>) objRememberedValue5, modifierFillMaxWidth$default118, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2051738709, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$66(siteLinkAccountType4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default11, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 9) & 14) | 1573248, 113246208, 0, 7962552);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default119 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.Horizontal end7 = Arrangement.INSTANCE.getEnd();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy14 = RowKt.rowMeasurePolicy(end7, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default119);
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
                Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl3.getInserting()) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                } else {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier112, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance14 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1711102203, "C312@11928L362:EditSiteLinkScreen.kt#4cevh3");
                ButtonKt.TextButton(function114, null, false, null, null, null, null, null, null, ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.m9598getLambda$1703772645$app_debug(), composerStartRestartGroup, ((i15 >> 9) & 14) | 805306368, 510);
                function5 = function114;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f7)), composerStartRestartGroup, 6);
                if (z) {
                    z17 = false;
                } else {
                    z17 = false;
                }
                CustomButtonKt.CustomButton(function113, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z17, false, ComposableLambdaKt.rememberComposableLambda(-1643042089, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$68(z, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i15 >> 6) & 14) | 24624, 8);
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
                str3 = str17;
                z5 = z111;
                function3 = function115;
                function4 = function113;
                siteLinkAccountType2 = siteLinkAccountType4;
                bool2 = bool16;
                z6 = z9;
            } else {
                bool5 = bool4;
            }
            z11 = false;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353560397, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            if ((i16 & 234881024) == 67108864) {
                z12 = true;
            } else {
                z12 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z12) {
                function10 = function9;
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                function10 = function9;
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(function10, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function1<? super String, Unit> function116 = function10;
            Boolean bool17 = bool5;
            OutlinedTextFieldKt.OutlinedTextField(str17, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default116, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.getLambda$226102932$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-245291935, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$58(z9, str17, bool5, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), z11, (VisualTransformation) null, keyboardOptions4, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 15) & 14) | 1573248, 196992, 0, 8343480);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f8)), composerStartRestartGroup, 6);
            TextKt.m3864TextNvy7gAk("Payout Account", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
            Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierFillMaxWidth$default1110 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy15 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically8, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default1110);
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
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting()) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            } else {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier113, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance15 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1127010563, "C288@10961L79,288@10886L155,292@11100L79,292@11055L125,295@11193L38:EditSiteLinkScreen.kt#4cevh3");
            if (siteLinkAccountType4 == SiteLinkAccountType.MPESA) {
                z13 = true;
            } else {
                z13 = false;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729093974, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            i17 = i15 & 112;
            if (i17 == 32) {
                z14 = true;
            } else {
                z14 = false;
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z14) {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(onAccountTypeChanged);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            RadioButtonKt.RadioButton(z13, (Function0) objRememberedValue3, null, false, null, null, composerStartRestartGroup, 0, 60);
            Modifier.Companion companion8 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 729098422, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            if (i17 == 32) {
                z15 = true;
            } else {
                z15 = false;
            }
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z15) {
                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(onAccountTypeChanged);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextKt.m3864TextNvy7gAk("M-Pesa", ClickableKt.m584clickableoSLSa3U$default(companion8, false, null, null, null, (Function0) objRememberedValue4, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262140);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance15, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f7)), composerStartRestartGroup, 6);
            KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default12 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
            Modifier modifierFillMaxWidth$default1111 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1353494687, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            if ((i15 & 14) == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z16) {
                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(onAccountNumberChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OutlinedTextFieldKt.OutlinedTextField(accountNumber, (Function1<? super String, Unit>) objRememberedValue5, modifierFillMaxWidth$default1111, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2051738709, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$66(siteLinkAccountType4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default12, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i16 >> 9) & 14) | 1573248, 113246208, 0, 7962552);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composerStartRestartGroup, 6);
            Modifier modifierFillMaxWidth$default1112 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.Horizontal end8 = Arrangement.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy16 = RowKt.rowMeasurePolicy(end8, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default1112);
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
            Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl3.getInserting()) {
                composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
            } else {
                composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
            }
            Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier114, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance16 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1711102203, "C312@11928L362:EditSiteLinkScreen.kt#4cevh3");
            ButtonKt.TextButton(function114, null, false, null, null, null, null, null, null, ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.m9598getLambda$1703772645$app_debug(), composerStartRestartGroup, ((i15 >> 9) & 14) | 805306368, 510);
            function5 = function114;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f7)), composerStartRestartGroup, 6);
            if (z) {
                z17 = false;
            } else {
                z17 = false;
            }
            CustomButtonKt.CustomButton(function113, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z17, false, ComposableLambdaKt.rememberComposableLambda(-1643042089, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$69$lambda$68(z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i15 >> 6) & 14) | 24624, 8);
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
            str3 = str17;
            z5 = z111;
            function3 = function116;
            function4 = function113;
            siteLinkAccountType2 = siteLinkAccountType4;
            bool2 = bool17;
            z6 = z9;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z5 = z2;
            siteLinkAccountType2 = siteLinkAccountType;
            bool2 = bool;
            z6 = z3;
            function3 = function1;
            function4 = function0;
            str3 = str2;
            function5 = function2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditSiteLinkScreenKt.EditSiteLinkScreenContent$lambda$70(z, z5, siteName, accountNumber, siteLinkAccountType2, str3, bool2, z6, function3, onSiteNameChanged, onAccountNumberChanged, onAccountTypeChanged, function4, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenContent$lambda$69$lambda$55$lambda$54(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenContent$lambda$69$lambda$57$lambda$56(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(StringsKt.replace$default(it, ServerSentEventKt.SPACE, "", false, 4, (Object) null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenContent$lambda$69$lambda$58(boolean z, String str, Boolean bool, Composer composer, int i) {
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C:EditSiteLinkScreen.kt#4cevh3");
        if (composer2.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-245291935, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenContent.<anonymous>.<anonymous> (EditSiteLinkScreen.kt:255)");
            }
            if (z) {
                composer2.startReplaceGroup(-1752595864);
                ComposerKt.sourceInformation(composer2, "257@9825L41");
                TextKt.m3864TextNvy7gAk("Checking username availability...", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
                composer.endReplaceGroup();
            } else if (str.length() < 3) {
                composer2.startReplaceGroup(-1752462781);
                ComposerKt.sourceInformation(composer2, "261@9959L46");
                TextKt.m3864TextNvy7gAk("Username must be at least 3 characters", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
                composer.endReplaceGroup();
            } else if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                composer2.startReplaceGroup(-1752313609);
                ComposerKt.sourceInformation(composer2, "267@10215L11,265@10106L154");
                TextKt.m3864TextNvy7gAk("Username is available", null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262138);
                composer.endReplaceGroup();
            } else {
                if (!Intrinsics.areEqual((Object) bool, (Object) false)) {
                    composer2.startReplaceGroup(-1762320223);
                } else {
                    composer2.startReplaceGroup(-1752059595);
                    ComposerKt.sourceInformation(composer2, "274@10475L11,272@10362L156");
                    TextKt.m3864TextNvy7gAk("Username is already taken", null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getError(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262138);
                    composer2 = composer;
                }
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$60$lambda$59(Function1 function1) {
        function1.invoke(SiteLinkAccountType.MPESA);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenContent$lambda$69$lambda$63$lambda$62$lambda$61(Function1 function1) {
        function1.invoke(SiteLinkAccountType.MPESA);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenContent$lambda$69$lambda$65$lambda$64(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenContent$lambda$69$lambda$66(SiteLinkAccountType siteLinkAccountType, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C301@11436L92:EditSiteLinkScreen.kt#4cevh3");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2051738709, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenContent.<anonymous>.<anonymous> (EditSiteLinkScreen.kt:301)");
            }
            TextKt.m3864TextNvy7gAk(siteLinkAccountType == SiteLinkAccountType.TILL ? "Till Number" : "M-Pesa Number", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenContent$lambda$69$lambda$68(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C332@12657L10,330@12545L220:EditSiteLinkScreen.kt#4cevh3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1643042089, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenContent.<anonymous>.<anonymous> (EditSiteLinkScreen.kt:330)");
            }
            TextKt.m3864TextNvy7gAk(!z ? "Update" : "Updating...", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0050  */
    /* JADX WARN: Code duplicated, block: B:25:0x0056  */
    /* JADX WARN: Code duplicated, block: B:26:0x0059  */
    /* JADX WARN: Code duplicated, block: B:30:0x0060  */
    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:33:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x0074  */
    /* JADX WARN: Code duplicated, block: B:38:0x0076  */
    /* JADX WARN: Code duplicated, block: B:41:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0083  */
    /* JADX WARN: Code duplicated, block: B:46:0x008a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:49:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:52:0x010f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0113  */
    /* JADX WARN: Code duplicated, block: B:56:0x011e  */
    /* JADX WARN: Code duplicated, block: B:58:? A[RETURN, SYNTHETIC] */
    public static final void DeleteSiteLinkConfirmationDialog(final boolean z, boolean z2, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i, final int i2) {
        int i3;
        boolean z3;
        boolean z4;
        Composer composer2;
        final boolean z5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final boolean z6;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1800894247);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DeleteSiteLinkConfirmationDialog)N(showDialog,isDeleting,onConfirm,onDismiss):EditSiteLinkScreen.kt#4cevh3");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                z3 = z2;
                i3 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(onConfirm)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onDismiss)) {
                    i4 = 2048;
                } else {
                    i4 = 1024;
                }
                i3 |= i4;
            }
            if ((i3 & 1171) != 1170) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z5 = z3;
            } else {
                if (i6 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1800894247, i3, -1, "com.example.bingwahybrid.presentation.sitelink.screens.DeleteSiteLinkConfirmationDialog (EditSiteLinkScreen.kt:346)");
                }
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(-2003807611);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "356@13281L355,367@13666L125,348@12981L820");
                    z5 = z6;
                    AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0(onDismiss, ComposableLambdaKt.rememberComposableLambda(2047044268, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditSiteLinkScreenKt.DeleteSiteLinkConfirmationDialog$lambda$72(onConfirm, z6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1760849302, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditSiteLinkScreenKt.DeleteSiteLinkConfirmationDialog$lambda$73(onDismiss, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.m9597getLambda$1273775576$app_debug(), ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.m9596getLambda$1030238713$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, ((i3 >> 9) & 14) | 1772592, 0, 16276);
                    composer2 = composerStartRestartGroup;
                } else {
                    composer2 = composerStartRestartGroup;
                    z5 = z6;
                    composer2.startReplaceGroup(-2016701751);
                }
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.DeleteSiteLinkConfirmationDialog$lambda$74(z, z5, onConfirm, onDismiss, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z3 = z2;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(onConfirm)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        }
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(onDismiss)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        if ((i3 & 1171) != 1170) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z5 = z3;
        } else {
            if (i6 != 0) {
                z6 = false;
            } else {
                z6 = z3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1800894247, i3, -1, "com.example.bingwahybrid.presentation.sitelink.screens.DeleteSiteLinkConfirmationDialog (EditSiteLinkScreen.kt:346)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-2003807611);
                ComposerKt.sourceInformation(composerStartRestartGroup, "356@13281L355,367@13666L125,348@12981L820");
                z5 = z6;
                AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0(onDismiss, ComposableLambdaKt.rememberComposableLambda(2047044268, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.DeleteSiteLinkConfirmationDialog$lambda$72(onConfirm, z6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1760849302, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditSiteLinkScreenKt.DeleteSiteLinkConfirmationDialog$lambda$73(onDismiss, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.m9597getLambda$1273775576$app_debug(), ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.m9596getLambda$1030238713$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, ((i3 >> 9) & 14) | 1772592, 0, 16276);
                composer2 = composerStartRestartGroup;
            } else {
                composer2 = composerStartRestartGroup;
                z5 = z6;
                composer2.startReplaceGroup(-2016701751);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditSiteLinkScreenKt.DeleteSiteLinkConfirmationDialog$lambda$74(z, z5, onConfirm, onDismiss, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteSiteLinkConfirmationDialog$lambda$72(Function0 function0, final boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C357@13331L291,357@13299L323:EditSiteLinkScreen.kt#4cevh3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2047044268, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.DeleteSiteLinkConfirmationDialog.<anonymous> (EditSiteLinkScreen.kt:357)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-532534385, true, new Function3() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EditSiteLinkScreenKt.DeleteSiteLinkConfirmationDialog$lambda$72$lambda$71(z, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteSiteLinkConfirmationDialog$lambda$72$lambda$71(boolean z, RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C:EditSiteLinkScreen.kt#4cevh3");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-532534385, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.DeleteSiteLinkConfirmationDialog.<anonymous>.<anonymous> (EditSiteLinkScreen.kt:358)");
            }
            if (z) {
                composer.startReplaceGroup(877370547);
                ComposerKt.sourceInformation(composer, "359@13395L112");
                ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24)), 0L, 0.0f, 0L, 0, 0.0f, composer, 6, 62);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(877532398);
                ComposerKt.sourceInformation(composer, "363@13561L21");
                TextKt.m3864TextNvy7gAk("Delete", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
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
    public static final Unit DeleteSiteLinkConfirmationDialog$lambda$73(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C368@13684L93:EditSiteLinkScreen.kt#4cevh3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1760849302, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.DeleteSiteLinkConfirmationDialog.<anonymous> (EditSiteLinkScreen.kt:368)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$EditSiteLinkScreenKt.INSTANCE.m9599getLambda$45460659$app_debug(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void EditSiteLinkScreenPreview(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(492094143);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditSiteLinkScreenPreview)384@14088L2,385@14125L2,386@14160L2,387@14191L2,388@14227L2,379@13901L334:EditSiteLinkScreen.kt#4cevh3");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(492094143, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenPreview (EditSiteLinkScreen.kt:378)");
            }
            SiteLinkAccountType siteLinkAccountType = SiteLinkAccountType.MPESA;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 456077729, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenPreview$lambda$76$lambda$75((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 456078913, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenPreview$lambda$78$lambda$77((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 456080033, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditSiteLinkScreenKt.EditSiteLinkScreenPreview$lambda$80$lambda$79((SiteLinkAccountType) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function3 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 456081025, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function0 function0 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 456082177, "CC(remember):EditSiteLinkScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            EditSiteLinkScreenContent(false, false, "", "12654", siteLinkAccountType, null, null, false, null, function1, function2, function3, function0, (Function0) objRememberedValue5, composer2, 805334406, 3510, 482);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditSiteLinkScreenKt.EditSiteLinkScreenPreview$lambda$85(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenPreview$lambda$76$lambda$75(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenPreview$lambda$78$lambda$77(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditSiteLinkScreenPreview$lambda$80$lambda$79(SiteLinkAccountType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private static final boolean EditSiteLinkScreen$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String EditSiteLinkScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    private static final String EditSiteLinkScreen$lambda$2(State<String> state) {
        return state.getValue();
    }

    private static final SiteLinkAccountType EditSiteLinkScreen$lambda$3(State<? extends SiteLinkAccountType> state) {
        return state.getValue();
    }

    private static final String EditSiteLinkScreen$lambda$4(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String EditSiteLinkScreen$lambda$5(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String EditSiteLinkScreen$lambda$6(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean EditSiteLinkScreen$lambda$7(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean EditSiteLinkScreen$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean EditSiteLinkScreen$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean EditSiteLinkScreen$lambda$10(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final Boolean EditSiteLinkScreen$lambda$11(State<Boolean> state) {
        return state.getValue();
    }

    private static final boolean EditSiteLinkScreen$lambda$12(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean EditSiteLinkScreen$lambda$13(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
