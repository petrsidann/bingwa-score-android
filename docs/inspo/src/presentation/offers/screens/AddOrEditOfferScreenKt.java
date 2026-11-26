package com.example.bingwahybrid.presentation.offers.screens;

import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.MenuKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardCapitalization;
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
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.presentation.navigation.Route;
import com.example.bingwahybrid.presentation.offers.dto.OfferDetails;
import com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel;
import com.example.bingwahybrid.presentation.ui.components.CustomButtonKt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
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
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: AddOrEditOfferScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a/\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a;\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\f\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u008a\u0084\u0002²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u001a\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u000bX\u008a\u008e\u0002"}, d2 = {"AddOrEditOfferScreen", "", "viewModel", "Lcom/example/bingwahybrid/presentation/offers/viewmodel/OffersViewModel;", "offerId", "Ljava/util/UUID;", "navController", "Landroidx/navigation/NavHostController;", "(Lcom/example/bingwahybrid/presentation/offers/viewmodel/OffersViewModel;Ljava/util/UUID;Landroidx/navigation/NavHostController;Landroidx/compose/runtime/Composer;II)V", "DeleteOfferConfirmationDialog", "showDialog", "", "isDeleting", "onConfirm", "Lkotlin/Function0;", "onDismiss", "(ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug", "offerDetails", "Lcom/example/bingwahybrid/presentation/offers/dto/OfferDetails;", "selectedOffer", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "snackBarMessage", "", "editOfferSuccess", "addOfferSuccess", "deleteSuccess", "showDeleteConfirmationDialog"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AddOrEditOfferScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$45(OffersViewModel offersViewModel, UUID uuid, NavHostController navHostController, int i, int i2, Composer composer, int i3) {
        AddOrEditOfferScreen(offersViewModel, uuid, navHostController, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteOfferConfirmationDialog$lambda$49(boolean z, boolean z2, Function0 function0, Function0 function1, int i, int i2, Composer composer, int i3) {
        DeleteOfferConfirmationDialog(z, z2, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0204  */
    /* JADX WARN: Code duplicated, block: B:103:0x020c  */
    /* JADX WARN: Code duplicated, block: B:106:0x023d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0247  */
    /* JADX WARN: Code duplicated, block: B:112:0x024d A[PHI: r27
  0x024d: PHI (r27v5 androidx.compose.runtime.State) = (r27v3 androidx.compose.runtime.State), (r27v6 androidx.compose.runtime.State) binds: [B:111:0x024b, B:109:0x0244] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:113:0x024f  */
    /* JADX WARN: Code duplicated, block: B:116:0x0258  */
    /* JADX WARN: Code duplicated, block: B:118:0x0260  */
    /* JADX WARN: Code duplicated, block: B:121:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:123:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:126:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:128:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    /* JADX WARN: Code duplicated, block: B:134:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:138:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:141:0x0368  */
    /* JADX WARN: Code duplicated, block: B:143:0x036e  */
    /* JADX WARN: Code duplicated, block: B:146:0x037c  */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x006e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:61:0x0103  */
    /* JADX WARN: Code duplicated, block: B:63:0x010f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0117  */
    /* JADX WARN: Code duplicated, block: B:67:0x011a  */
    /* JADX WARN: Code duplicated, block: B:68:0x011c  */
    /* JADX WARN: Code duplicated, block: B:72:0x012a  */
    /* JADX WARN: Code duplicated, block: B:75:0x014c  */
    /* JADX WARN: Code duplicated, block: B:78:0x0199  */
    /* JADX WARN: Code duplicated, block: B:79:0x019c  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:95:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:97:0x01f8 A[PHI: r27
  0x01f8: PHI (r27v7 boolean) = (r27v1 boolean), (r27v8 boolean) binds: [B:96:0x01f6, B:94:0x01ef] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:98:0x01fa  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void AddOrEditOfferScreen(OffersViewModel offersViewModel, UUID uuid, NavHostController navHostController, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        NavHostController navHostController2;
        boolean z;
        final OffersViewModel offersViewModel2;
        final NavHostController navHostController3;
        final UUID uuid2;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        CoroutineContext coroutineContext;
        int i4;
        int i5;
        int i6;
        OffersViewModel offersViewModel3;
        Object obj2;
        int i7;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        NavHostController navHostController4;
        final UUID uuid3;
        Object objRememberedValue;
        final CoroutineScope coroutineScope;
        State stateCollectAsState;
        State stateCollectAsState2;
        State stateCollectAsState3;
        State stateCollectAsState4;
        State stateCollectAsState5;
        int i8;
        Offer offerAddOrEditOfferScreen$lambda$1;
        int i9;
        boolean z2;
        Object objRememberedValue2;
        final MutableState mutableState;
        boolean zChangedInstance;
        int i10;
        boolean z3;
        boolean z4;
        boolean z5;
        Object objRememberedValue3;
        int i11;
        State state;
        boolean z6;
        boolean z7;
        Object objRememberedValue4;
        boolean zChanged;
        Object objRememberedValue5;
        boolean zChanged2;
        Object objRememberedValue6;
        final OffersViewModel offersViewModel4;
        final NavHostController navHostController5;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2016916714);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AddOrEditOfferScreen)N(viewModel,offerId,navController)62@2787L24,63@2859L16,64@2925L16,65@2995L16,66@3067L16,67@3137L16,68@3197L16,69@3263L16,73@3416L34,75@3480L92,75@3456L116,81@3610L144,81@3578L176,88@3810L172,88@3760L222,96@4018L180,96@3988L210,105@4231L1011,132@5244L4178,104@4204L5218:AddOrEditOfferScreen.kt#6kthjn");
        if ((i & 6) == 0) {
            if ((i2 & 1) != 0) {
                i12 = 2;
            } else {
                if ((i & 8) == 0 ? composerStartRestartGroup.changed(offersViewModel) : composerStartRestartGroup.changedInstance(offersViewModel)) {
                    i12 = 4;
                } else {
                    i12 = 2;
                }
            }
            i3 = i12 | i;
        } else {
            i3 = i;
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
            obj = uuid;
        } else {
            obj = uuid;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        int i14 = i2 & 4;
        if (i14 == 0) {
            if ((i & 384) == 0) {
                navHostController2 = navHostController;
                i3 |= composerStartRestartGroup.changedInstance(navHostController2) ? 256 : 128;
            }
            if ((i3 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "58@2677L15");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if ((i2 & 1) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1890788296, "CC(hiltViewModel)P(1)51@2126L7,55@2260L46:HiltViewModel.kt#9mcars");
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
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
                        i5 = 1;
                        coroutineContext = null;
                        ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(OffersViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i6 = i3 & (-15);
                        offersViewModel3 = (OffersViewModel) viewModel;
                        i4 = 0;
                    } else {
                        coroutineContext = null;
                        i4 = 0;
                        i5 = 1;
                        i6 = i3;
                        offersViewModel3 = offersViewModel;
                    }
                    if (i13 != 0) {
                        obj = coroutineContext;
                    }
                    if (i14 != 0) {
                        obj2 = coroutineContext;
                    } else {
                        obj2 = navHostController;
                    }
                    i7 = i6;
                    navHostController4 = obj2;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 1) != 0) {
                        i3 &= -15;
                    }
                    int i15 = i3;
                    offersViewModel3 = offersViewModel;
                    coroutineContext = null;
                    navHostController4 = navHostController2;
                    i4 = 0;
                    i7 = i15;
                    i5 = 1;
                }
                uuid3 = obj;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2016916714, i7, -1, "com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreen (AddOrEditOfferScreen.kt:61)");
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
                stateCollectAsState = SnapshotStateKt.collectAsState(offersViewModel3.getOfferDetails(), coroutineContext, composerStartRestartGroup, i4, i5);
                State stateCollectAsState6 = SnapshotStateKt.collectAsState(offersViewModel3.getSelectedOffer(), coroutineContext, composerStartRestartGroup, i4, i5);
                stateCollectAsState2 = SnapshotStateKt.collectAsState(offersViewModel3.getSnackBarMessage(), coroutineContext, composerStartRestartGroup, i4, i5);
                stateCollectAsState3 = SnapshotStateKt.collectAsState(offersViewModel3.getEditOfferSuccess(), coroutineContext, composerStartRestartGroup, i4, i5);
                stateCollectAsState4 = SnapshotStateKt.collectAsState(offersViewModel3.getAddOfferSuccess(), coroutineContext, composerStartRestartGroup, i4, i5);
                final State stateCollectAsState7 = SnapshotStateKt.collectAsState(offersViewModel3.isDeleting(), coroutineContext, composerStartRestartGroup, i4, i5);
                stateCollectAsState5 = SnapshotStateKt.collectAsState(offersViewModel3.getDeleteSuccess(), coroutineContext, composerStartRestartGroup, i4, i5);
                if (uuid3 != 0) {
                    i8 = i5;
                } else {
                    i8 = i4;
                }
                offerAddOrEditOfferScreen$lambda$1 = AddOrEditOfferScreen$lambda$1(stateCollectAsState6);
                if (offerAddOrEditOfferScreen$lambda$1 == null && offerAddOrEditOfferScreen$lambda$1.isVerified() == i5) {
                    i9 = i5;
                } else {
                    i9 = i4;
                }
                z2 = i4;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226684424, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226682318, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(uuid3);
                i10 = (i7 & 14) ^ 6;
                if (i10 > 4 || !composerStartRestartGroup.changedInstance(offersViewModel3)) {
                    z3 = zChangedInstance;
                    if ((i7 & 6) != 4) {
                        z4 = z2 ? 1 : 0;
                    }
                    z5 = z3 | z4;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z5 == 0 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$1$1(uuid3, offersViewModel3, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(uuid3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composerStartRestartGroup, (i7 >> 3) & 14);
                    String strAddOrEditOfferScreen$lambda$2 = AddOrEditOfferScreen$lambda$2(stateCollectAsState2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226678106, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
                    boolean z8 = (composerStartRestartGroup.changed(stateCollectAsState2) ? 1 : 0) | (composerStartRestartGroup.changedInstance(coroutineScope) ? 1 : 0);
                    i11 = i7;
                    if (i10 > 4 || !composerStartRestartGroup.changedInstance(offersViewModel3)) {
                        state = stateCollectAsState;
                        if ((i11 & 6) != 4) {
                            z6 = z2 ? 1 : 0;
                        }
                        z7 = z6 | z8;
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (z7 == 0 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$2$1(stateCollectAsState2, coroutineScope, offersViewModel3, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(strAddOrEditOfferScreen$lambda$2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue4, composerStartRestartGroup, z2 ? 1 : 0);
                        Boolean boolValueOf = Boolean.valueOf(AddOrEditOfferScreen$lambda$3(stateCollectAsState3));
                        Boolean boolValueOf2 = Boolean.valueOf(AddOrEditOfferScreen$lambda$4(stateCollectAsState4));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226671678, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(stateCollectAsState3) | composerStartRestartGroup.changed(stateCollectAsState4) | composerStartRestartGroup.changedInstance(navHostController4);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1(stateCollectAsState3, stateCollectAsState4, navHostController4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf, boolValueOf2, (Function2) objRememberedValue5, composerStartRestartGroup, 0);
                        Boolean boolValueOf3 = Boolean.valueOf(AddOrEditOfferScreen$lambda$6(stateCollectAsState5));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226665014, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(stateCollectAsState5) | ((i10 <= 4 && composerStartRestartGroup.changedInstance(offersViewModel3)) || (i11 & 6) == 4) | composerStartRestartGroup.changedInstance(navHostController4);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            offersViewModel4 = offersViewModel3;
                            NavHostController navHostController6 = navHostController4;
                            navHostController5 = navHostController6;
                            objRememberedValue6 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$4$1(offersViewModel4, navHostController6, stateCollectAsState5, mutableState, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            offersViewModel4 = offersViewModel3;
                            navHostController5 = navHostController4;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                        final boolean z9 = i8;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-980935982, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj3, Object obj4) {
                                return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$21(z9, coroutineScope, navHostController5, uuid3, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        final State state2 = state;
                        final boolean z10 = i9;
                        offersViewModel2 = offersViewModel4;
                        ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-39328153, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44(offersViewModel4, state2, z10, z9, mutableState, stateCollectAsState7, (PaddingValues) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        navHostController3 = navHostController5;
                        uuid2 = uuid3;
                    } else {
                        state = stateCollectAsState;
                    }
                    z6 = true;
                    z7 = z6 | z8;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z7 == 0) {
                        objRememberedValue4 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$2$1(stateCollectAsState2, coroutineScope, offersViewModel3, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$2$1(stateCollectAsState2, coroutineScope, offersViewModel3, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(strAddOrEditOfferScreen$lambda$2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue4, composerStartRestartGroup, z2 ? 1 : 0);
                    Boolean boolValueOf4 = Boolean.valueOf(AddOrEditOfferScreen$lambda$3(stateCollectAsState3));
                    Boolean boolValueOf5 = Boolean.valueOf(AddOrEditOfferScreen$lambda$4(stateCollectAsState4));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226671678, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateCollectAsState3) | composerStartRestartGroup.changed(stateCollectAsState4) | composerStartRestartGroup.changedInstance(navHostController4);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue5 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1(stateCollectAsState3, stateCollectAsState4, navHostController4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1(stateCollectAsState3, stateCollectAsState4, navHostController4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf4, boolValueOf5, (Function2) objRememberedValue5, composerStartRestartGroup, 0);
                    Boolean boolValueOf6 = Boolean.valueOf(AddOrEditOfferScreen$lambda$6(stateCollectAsState5));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226665014, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(stateCollectAsState5) | ((i10 <= 4 && composerStartRestartGroup.changedInstance(offersViewModel3)) || (i11 & 6) == 4) | composerStartRestartGroup.changedInstance(navHostController4);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        offersViewModel4 = offersViewModel3;
                        NavHostController navHostController7 = navHostController4;
                        navHostController5 = navHostController7;
                        objRememberedValue6 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$4$1(offersViewModel4, navHostController7, stateCollectAsState5, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        offersViewModel4 = offersViewModel3;
                        NavHostController navHostController8 = navHostController4;
                        navHostController5 = navHostController8;
                        objRememberedValue6 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$4$1(offersViewModel4, navHostController8, stateCollectAsState5, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                    final boolean z11 = i8;
                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-980935982, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$21(z11, coroutineScope, navHostController5, uuid3, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    final State state3 = state;
                    final boolean z12 = i9;
                    offersViewModel2 = offersViewModel4;
                    ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda2, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-39328153, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj3, Object obj4, Object obj5) {
                            return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44(offersViewModel4, state3, z12, z11, mutableState, stateCollectAsState7, (PaddingValues) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navHostController3 = navHostController5;
                    uuid2 = uuid3;
                } else {
                    z3 = zChangedInstance;
                }
                z4 = true;
                z5 = z3 | z4;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z5 == 0) {
                    objRememberedValue3 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$1$1(uuid3, offersViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$1$1(uuid3, offersViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(uuid3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composerStartRestartGroup, (i7 >> 3) & 14);
                String strAddOrEditOfferScreen$lambda$3 = AddOrEditOfferScreen$lambda$2(stateCollectAsState2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226678106, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
                boolean z13 = (composerStartRestartGroup.changed(stateCollectAsState2) ? 1 : 0) | (composerStartRestartGroup.changedInstance(coroutineScope) ? 1 : 0);
                i11 = i7;
                if (i10 > 4) {
                    state = stateCollectAsState;
                    if ((i11 & 6) != 4) {
                        z6 = true;
                    } else {
                        z6 = z2 ? 1 : 0;
                    }
                } else {
                    state = stateCollectAsState;
                    if ((i11 & 6) != 4) {
                        z6 = true;
                    } else {
                        z6 = z2 ? 1 : 0;
                    }
                }
                z7 = z6 | z13;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z7 == 0) {
                    objRememberedValue4 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$2$1(stateCollectAsState2, coroutineScope, offersViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$2$1(stateCollectAsState2, coroutineScope, offersViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strAddOrEditOfferScreen$lambda$3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue4, composerStartRestartGroup, z2 ? 1 : 0);
                Boolean boolValueOf7 = Boolean.valueOf(AddOrEditOfferScreen$lambda$3(stateCollectAsState3));
                Boolean boolValueOf8 = Boolean.valueOf(AddOrEditOfferScreen$lambda$4(stateCollectAsState4));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226671678, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCollectAsState3) | composerStartRestartGroup.changed(stateCollectAsState4) | composerStartRestartGroup.changedInstance(navHostController4);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue5 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1(stateCollectAsState3, stateCollectAsState4, navHostController4, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1(stateCollectAsState3, stateCollectAsState4, navHostController4, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf7, boolValueOf8, (Function2) objRememberedValue5, composerStartRestartGroup, 0);
                Boolean boolValueOf9 = Boolean.valueOf(AddOrEditOfferScreen$lambda$6(stateCollectAsState5));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226665014, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(stateCollectAsState5) | ((i10 <= 4 && composerStartRestartGroup.changedInstance(offersViewModel3)) || (i11 & 6) == 4) | composerStartRestartGroup.changedInstance(navHostController4);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    offersViewModel4 = offersViewModel3;
                    NavHostController navHostController9 = navHostController4;
                    navHostController5 = navHostController9;
                    objRememberedValue6 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$4$1(offersViewModel4, navHostController9, stateCollectAsState5, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    offersViewModel4 = offersViewModel3;
                    NavHostController navHostController10 = navHostController4;
                    navHostController5 = navHostController10;
                    objRememberedValue6 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$4$1(offersViewModel4, navHostController10, stateCollectAsState5, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf9, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                final boolean z14 = i8;
                ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-980935982, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$21(z14, coroutineScope, navHostController5, uuid3, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54);
                final State state4 = state;
                final boolean z15 = i9;
                offersViewModel2 = offersViewModel4;
                ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda3, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-39328153, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj3, Object obj4, Object obj5) {
                        return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44(offersViewModel4, state4, z15, z14, mutableState, stateCollectAsState7, (PaddingValues) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navHostController3 = navHostController5;
                uuid2 = uuid3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                offersViewModel2 = offersViewModel;
                navHostController3 = navHostController;
                uuid2 = obj;
                composer2 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$45(offersViewModel2, uuid2, navHostController3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        navHostController2 = navHostController;
        if ((i3 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "58@2677L15");
            if ((i & 1) != 0) {
                if ((i2 & 1) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1890788296, "CC(hiltViewModel)P(1)51@2126L7,55@2260L46:HiltViewModel.kt#9mcars");
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1192010736, "CC(hiltViewModel)P(1)38@1622L7,43@1774L47,44@1833L54:HiltViewModel.kt#gplxbw");
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory2 = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    i5 = 1;
                    coroutineContext = null;
                    ViewModel viewModel2 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(OffersViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory2, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i6 = i3 & (-15);
                    offersViewModel3 = (OffersViewModel) viewModel2;
                    i4 = 0;
                } else {
                    coroutineContext = null;
                    i4 = 0;
                    i5 = 1;
                    i6 = i3;
                    offersViewModel3 = offersViewModel;
                }
                if (i13 != 0) {
                    obj = coroutineContext;
                }
                if (i14 != 0) {
                    obj2 = coroutineContext;
                } else {
                    obj2 = navHostController;
                }
                i7 = i6;
                navHostController4 = obj2;
            } else {
                if ((i2 & 1) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1890788296, "CC(hiltViewModel)P(1)51@2126L7,55@2260L46:HiltViewModel.kt#9mcars");
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1192010736, "CC(hiltViewModel)P(1)38@1622L7,43@1774L47,44@1833L54:HiltViewModel.kt#gplxbw");
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory3 = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    i5 = 1;
                    coroutineContext = null;
                    ViewModel viewModel3 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(OffersViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory3, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i6 = i3 & (-15);
                    offersViewModel3 = (OffersViewModel) viewModel3;
                    i4 = 0;
                } else {
                    coroutineContext = null;
                    i4 = 0;
                    i5 = 1;
                    i6 = i3;
                    offersViewModel3 = offersViewModel;
                }
                if (i13 != 0) {
                    obj = coroutineContext;
                }
                if (i14 != 0) {
                    obj2 = coroutineContext;
                } else {
                    obj2 = navHostController;
                }
                i7 = i6;
                navHostController4 = obj2;
            }
            uuid3 = obj;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2016916714, i7, -1, "com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreen (AddOrEditOfferScreen.kt:61)");
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
            stateCollectAsState = SnapshotStateKt.collectAsState(offersViewModel3.getOfferDetails(), coroutineContext, composerStartRestartGroup, i4, i5);
            State stateCollectAsState8 = SnapshotStateKt.collectAsState(offersViewModel3.getSelectedOffer(), coroutineContext, composerStartRestartGroup, i4, i5);
            stateCollectAsState2 = SnapshotStateKt.collectAsState(offersViewModel3.getSnackBarMessage(), coroutineContext, composerStartRestartGroup, i4, i5);
            stateCollectAsState3 = SnapshotStateKt.collectAsState(offersViewModel3.getEditOfferSuccess(), coroutineContext, composerStartRestartGroup, i4, i5);
            stateCollectAsState4 = SnapshotStateKt.collectAsState(offersViewModel3.getAddOfferSuccess(), coroutineContext, composerStartRestartGroup, i4, i5);
            final State stateCollectAsState9 = SnapshotStateKt.collectAsState(offersViewModel3.isDeleting(), coroutineContext, composerStartRestartGroup, i4, i5);
            stateCollectAsState5 = SnapshotStateKt.collectAsState(offersViewModel3.getDeleteSuccess(), coroutineContext, composerStartRestartGroup, i4, i5);
            if (uuid3 != 0) {
                i8 = i5;
            } else {
                i8 = i4;
            }
            offerAddOrEditOfferScreen$lambda$1 = AddOrEditOfferScreen$lambda$1(stateCollectAsState8);
            if (offerAddOrEditOfferScreen$lambda$1 == null) {
                i9 = i4;
            } else {
                i9 = i4;
            }
            z2 = i4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226684424, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226682318, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(uuid3);
            i10 = (i7 & 14) ^ 6;
            if (i10 > 4) {
                z3 = zChangedInstance;
                if ((i7 & 6) != 4) {
                    z4 = true;
                } else {
                    z4 = z2 ? 1 : 0;
                }
            } else {
                z3 = zChangedInstance;
                if ((i7 & 6) != 4) {
                    z4 = true;
                } else {
                    z4 = z2 ? 1 : 0;
                }
            }
            z5 = z3 | z4;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z5 == 0) {
                objRememberedValue3 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$1$1(uuid3, offersViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$1$1(uuid3, offersViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(uuid3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composerStartRestartGroup, (i7 >> 3) & 14);
            String strAddOrEditOfferScreen$lambda$4 = AddOrEditOfferScreen$lambda$2(stateCollectAsState2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226678106, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            boolean z16 = (composerStartRestartGroup.changed(stateCollectAsState2) ? 1 : 0) | (composerStartRestartGroup.changedInstance(coroutineScope) ? 1 : 0);
            i11 = i7;
            if (i10 > 4) {
                state = stateCollectAsState;
                if ((i11 & 6) != 4) {
                    z6 = true;
                } else {
                    z6 = z2 ? 1 : 0;
                }
            } else {
                state = stateCollectAsState;
                if ((i11 & 6) != 4) {
                    z6 = true;
                } else {
                    z6 = z2 ? 1 : 0;
                }
            }
            z7 = z6 | z16;
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z7 == 0) {
                objRememberedValue4 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$2$1(stateCollectAsState2, coroutineScope, offersViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$2$1(stateCollectAsState2, coroutineScope, offersViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strAddOrEditOfferScreen$lambda$4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue4, composerStartRestartGroup, z2 ? 1 : 0);
            Boolean boolValueOf10 = Boolean.valueOf(AddOrEditOfferScreen$lambda$3(stateCollectAsState3));
            Boolean boolValueOf11 = Boolean.valueOf(AddOrEditOfferScreen$lambda$4(stateCollectAsState4));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226671678, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCollectAsState3) | composerStartRestartGroup.changed(stateCollectAsState4) | composerStartRestartGroup.changedInstance(navHostController4);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue5 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1(stateCollectAsState3, stateCollectAsState4, navHostController4, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$3$1(stateCollectAsState3, stateCollectAsState4, navHostController4, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf10, boolValueOf11, (Function2) objRememberedValue5, composerStartRestartGroup, 0);
            Boolean boolValueOf12 = Boolean.valueOf(AddOrEditOfferScreen$lambda$6(stateCollectAsState5));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1226665014, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(stateCollectAsState5) | ((i10 <= 4 && composerStartRestartGroup.changedInstance(offersViewModel3)) || (i11 & 6) == 4) | composerStartRestartGroup.changedInstance(navHostController4);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                offersViewModel4 = offersViewModel3;
                NavHostController navHostController11 = navHostController4;
                navHostController5 = navHostController11;
                objRememberedValue6 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$4$1(offersViewModel4, navHostController11, stateCollectAsState5, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                offersViewModel4 = offersViewModel3;
                NavHostController navHostController12 = navHostController4;
                navHostController5 = navHostController12;
                objRememberedValue6 = (Function2) new AddOrEditOfferScreenKt$AddOrEditOfferScreen$4$1(offersViewModel4, navHostController12, stateCollectAsState5, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf12, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
            final boolean z17 = i8;
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-980935982, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$21(z17, coroutineScope, navHostController5, uuid3, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54);
            final State state5 = state;
            final boolean z18 = i9;
            offersViewModel2 = offersViewModel4;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda4, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-39328153, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44(offersViewModel4, state5, z18, z17, mutableState, stateCollectAsState9, (PaddingValues) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            navHostController3 = navHostController5;
            uuid2 = uuid3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            offersViewModel2 = offersViewModel;
            navHostController3 = navHostController;
            uuid2 = obj;
            composer2 = composerStartRestartGroup;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$45(offersViewModel2, uuid2, navHostController3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    private static final boolean AddOrEditOfferScreen$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddOrEditOfferScreen$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$21(final boolean z, final CoroutineScope coroutineScope, final NavHostController navHostController, final UUID uuid, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C106@4263L122,110@4404L381,120@4797L434,106@4245L987:AddOrEditOfferScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-980935982, i, -1, "com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreen.<anonymous> (AddOrEditOfferScreen.kt:106)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(903878806, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$21$lambda$14(z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, ComposableLambdaKt.rememberComposableLambda(1149686680, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$21$lambda$17(coroutineScope, navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.rememberComposableLambda(-1925429055, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$21$lambda$20(z, navHostController, uuid, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), 0.0f, null, null, null, composer, 3462, 242);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$21$lambda$14(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C107@4281L90:AddOrEditOfferScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(903878806, i, -1, "com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreen.<anonymous>.<anonymous> (AddOrEditOfferScreen.kt:107)");
            }
            TextKt.m3864TextNvy7gAk(z ? "Edit Offer" : "Create Offer", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$21$lambda$17(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C111@4443L216,111@4422L349:AddOrEditOfferScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1149686680, i, -1, "com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreen.<anonymous>.<anonymous> (AddOrEditOfferScreen.kt:111)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1042305872, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$21$lambda$17$lambda$16$lambda$15(coroutineScope, navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$AddOrEditOfferScreenKt.INSTANCE.m9495getLambda$998532810$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$21$lambda$17$lambda$16$lambda$15(CoroutineScope coroutineScope, NavHostController navHostController) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AddOrEditOfferScreenKt$AddOrEditOfferScreen$5$2$1$1$1(navHostController, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$21$lambda$20(boolean z, final NavHostController navHostController, final UUID uuid, RowScope TopAppBar, Composer composer, int i) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        ComposerKt.sourceInformation(composer, "C:AddOrEditOfferScreen.kt#6kthjn");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1925429055, i, -1, "com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreen.<anonymous>.<anonymous> (AddOrEditOfferScreen.kt:121)");
            }
            if (z) {
                composer.startReplaceGroup(-1168695651);
                ComposerKt.sourceInformation(composer, "122@4872L114,122@4851L348");
                ComposerKt.sourceInformationMarkerStart(composer, 793585235, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(navHostController) | composer.changedInstance(uuid);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$21$lambda$20$lambda$19$lambda$18(navHostController, uuid);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer2 = composer;
                IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$AddOrEditOfferScreenKt.INSTANCE.getLambda$908664872$app_debug(), composer2, 1572864, 62);
            } else {
                composer2 = composer;
                composer2.startReplaceGroup(-1173499039);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$21$lambda$20$lambda$19$lambda$18(NavHostController navHostController, UUID uuid) {
        if (navHostController != null) {
            NavHostController navHostController2 = navHostController;
            Route.Offers offers = Route.Offers.INSTANCE;
            String string = uuid.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            NavController.navigate$default((NavController) navHostController2, offers.settings(string), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$44(final OffersViewModel offersViewModel, final State state, boolean z, final boolean z2, MutableState mutableState, State state2, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        final MutableState mutableState2;
        final MutableState mutableState3;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)133@5271L4145:AddOrEditOfferScreen.kt#6kthjn");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-39328153, i2, -1, "com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreen.<anonymous> (AddOrEditOfferScreen.kt:133)");
            }
            float f = 16;
            float f2 = 8;
            Modifier modifierM1119paddingVpY3zN4 = PaddingKt.m1119paddingVpY3zN4(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues), Dp.m8684constructorimpl(f), Dp.m8684constructorimpl(f2));
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
            ComposerKt.sourceInformationMarkerStart(composer, 246711332, "C141@5567L67,139@5468L280,145@5761L40,149@5913L66,147@5815L457,155@6285L40,159@6434L63,157@6339L375,165@6728L41,167@6783L1058,213@8616L40,217@8742L68,219@8877L258,215@8670L465,232@9378L27,231@9308L40,228@9149L257:AddOrEditOfferScreen.kt#6kthjn");
            String offerName = AddOrEditOfferScreen$lambda$0(state).getOfferName();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1116336384, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(offersViewModel) | composer.changed(state);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44$lambda$43$lambda$23$lambda$22(offersViewModel, state, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(offerName, (Function1<? super String, Unit>) objRememberedValue, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddOrEditOfferScreenKt.INSTANCE.m9494getLambda$862895881$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573248, 0, 0, 8388536);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composer, 6);
            String ussdCode = AddOrEditOfferScreen$lambda$0(state).getUssdCode();
            KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), KeyboardCapitalization.INSTANCE.m8332getCharactersIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, WebSocketProtocol.PAYLOAD_SHORT, (Object) null);
            boolean z3 = !z;
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1116347455, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(offersViewModel) | composer.changed(state);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44$lambda$43$lambda$25$lambda$24(offersViewModel, state, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(ussdCode, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default2, z3, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddOrEditOfferScreenKt.INSTANCE.getLambda$1029967022$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573248, 0, 0, 8355760);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composer, 6);
            String price = AddOrEditOfferScreen$lambda$0(state).getPrice();
            KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default2 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1116364124, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(offersViewModel) | composer.changed(state);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44$lambda$43$lambda$27$lambda$26(offersViewModel, state, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(price, (Function1<? super String, Unit>) objRememberedValue3, modifierFillMaxWidth$default3, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddOrEditOfferScreenKt.INSTANCE.m9490getLambda$1126160401$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default2, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573248, 0, 0, 8355768);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composer, 6);
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default4);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1291743489, "C174@7079L10,175@7152L246,172@6992L407,182@7416L39,184@7551L226,183@7472L355:AddOrEditOfferScreen.kt#6kthjn");
            TextStyle bodyMedium = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium();
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 928166711, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(offersViewModel) | composer.changed(state);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44$lambda$43$lambda$32$lambda$29$lambda$28(offersViewModel, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m3864TextNvy7gAk("Activate", ClickableKt.m584clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue4, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, bodyMedium, composer, 6, 0, 131068);
            SpacerKt.Spacer(SizeKt.m1175width3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composer, 6);
            boolean zIsActive = AddOrEditOfferScreen$lambda$0(state).isActive();
            ComposerKt.sourceInformationMarkerStart(composer, 928179459, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            boolean zChangedInstance5 = composer.changedInstance(offersViewModel) | composer.changed(state);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44$lambda$43$lambda$32$lambda$31$lambda$30(offersViewModel, state, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(zIsActive, (Function1) objRememberedValue5, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composer, 384, MenuKt.InTransitionDuration);
            Composer composer2 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (z2) {
                composer2.startReplaceGroup(248993768);
                ComposerKt.sourceInformation(composer2, "195@7887L40,196@7944L644");
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(4)), composer2, 6);
                Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.Horizontal end2 = Arrangement.INSTANCE.getEnd();
                ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(end2, Alignment.INSTANCE.getTop(), composer2, 6);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default5);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                Composer composerM5259constructorimpl3 = Updater.m5259constructorimpl(composer2);
                Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl3.rememberedValue(), Integer.valueOf(iHashCode3))) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1553368290, "C199@8106L83,199@8085L485:AddOrEditOfferScreen.kt#6kthjn");
                ComposerKt.sourceInformationMarkerStart(composer2, -1473911729, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
                Object objRememberedValue6 = composer2.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    mutableState3 = mutableState;
                    objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44$lambda$43$lambda$35$lambda$34$lambda$33(mutableState3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                } else {
                    mutableState3 = mutableState;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                mutableState2 = mutableState3;
                ButtonKt.TextButton((Function0) objRememberedValue6, null, false, null, null, null, null, null, null, ComposableSingletons$AddOrEditOfferScreenKt.INSTANCE.m9491getLambda$1138972199$app_debug(), composer, 805306374, 510);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
            } else {
                mutableState2 = mutableState;
                composer2.startReplaceGroup(241164005);
            }
            composer2.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composer2, 6);
            Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1116437985, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            boolean zChanged = composer2.changed(z2) | composer2.changedInstance(offersViewModel);
            Object objRememberedValue7 = composer2.rememberedValue();
            if (zChanged || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44$lambda$43$lambda$37$lambda$36(z2, offersViewModel);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            CustomButtonKt.CustomButton((Function0) objRememberedValue7, modifierFillMaxWidth$default6, false, true, ComposableLambdaKt.rememberComposableLambda(-333119119, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44$lambda$43$lambda$38(z2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, 27696, 4);
            boolean zAddOrEditOfferScreen$lambda$8 = AddOrEditOfferScreen$lambda$8(mutableState2);
            boolean zAddOrEditOfferScreen$lambda$5 = AddOrEditOfferScreen$lambda$5(state2);
            ComposerKt.sourceInformationMarkerStart(composer2, 1116458296, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            boolean zChangedInstance6 = composer2.changedInstance(offersViewModel);
            Object objRememberedValue8 = composer2.rememberedValue();
            if (zChangedInstance6 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44$lambda$43$lambda$40$lambda$39(offersViewModel);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue8);
            }
            Function0 function0 = (Function0) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, 1116456069, "CC(remember):AddOrEditOfferScreen.kt#9igjgp");
            Object objRememberedValue9 = composer2.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function0() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$44$lambda$43$lambda$42$lambda$41(mutableState2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            DeleteOfferConfirmationDialog(zAddOrEditOfferScreen$lambda$8, zAddOrEditOfferScreen$lambda$5, function0, (Function0) objRememberedValue9, composer2, 3072, 0);
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
    public static final Unit AddOrEditOfferScreen$lambda$44$lambda$43$lambda$23$lambda$22(OffersViewModel offersViewModel, State state, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        offersViewModel.updateOfferDetails(OfferDetails.copy$default(AddOrEditOfferScreen$lambda$0(state), it, null, null, null, false, false, 62, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$44$lambda$43$lambda$25$lambda$24(OffersViewModel offersViewModel, State state, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        offersViewModel.updateOfferDetails(OfferDetails.copy$default(AddOrEditOfferScreen$lambda$0(state), null, it, null, null, false, false, 61, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$44$lambda$43$lambda$27$lambda$26(OffersViewModel offersViewModel, State state, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        offersViewModel.updateOfferDetails(OfferDetails.copy$default(AddOrEditOfferScreen$lambda$0(state), null, null, it, null, false, false, 59, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$44$lambda$43$lambda$32$lambda$29$lambda$28(OffersViewModel offersViewModel, State state) {
        offersViewModel.updateOfferDetails(OfferDetails.copy$default(AddOrEditOfferScreen$lambda$0(state), null, null, null, null, false, !AddOrEditOfferScreen$lambda$0(state).isActive(), 31, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$44$lambda$43$lambda$32$lambda$31$lambda$30(OffersViewModel offersViewModel, State state, boolean z) {
        offersViewModel.updateOfferDetails(OfferDetails.copy$default(AddOrEditOfferScreen$lambda$0(state), null, null, null, null, false, z, 31, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$44$lambda$43$lambda$35$lambda$34$lambda$33(MutableState mutableState) {
        AddOrEditOfferScreen$lambda$9(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$44$lambda$43$lambda$37$lambda$36(boolean z, OffersViewModel offersViewModel) {
        if (z) {
            offersViewModel.updateOffer();
        } else {
            offersViewModel.saveOffer();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$44$lambda$43$lambda$38(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C222@9001L10,220@8895L226:AddOrEditOfferScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-333119119, i, -1, "com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreen.<anonymous>.<anonymous>.<anonymous> (AddOrEditOfferScreen.kt:220)");
            }
            TextKt.m3864TextNvy7gAk(z ? "Update" : "Create", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$44$lambda$43$lambda$42$lambda$41(MutableState mutableState) {
        AddOrEditOfferScreen$lambda$9(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddOrEditOfferScreen$lambda$44$lambda$43$lambda$40$lambda$39(OffersViewModel offersViewModel) {
        offersViewModel.deleteOffer();
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
    public static final void DeleteOfferConfirmationDialog(final boolean z, boolean z2, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i, final int i2) {
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
        Composer composerStartRestartGroup = composer.startRestartGroup(1952165559);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DeleteOfferConfirmationDialog)N(showDialog,isDeleting,onConfirm,onDismiss):AddOrEditOfferScreen.kt#6kthjn");
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
                    ComposerKt.traceEventStart(1952165559, i3, -1, "com.example.bingwahybrid.presentation.offers.screens.DeleteOfferConfirmationDialog (AddOrEditOfferScreen.kt:243)");
                }
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(-1187784628);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "249@9831L315,259@10164L109,245@9619L655");
                    z5 = z6;
                    AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0(onDismiss, ComposableLambdaKt.rememberComposableLambda(1255232964, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AddOrEditOfferScreenKt.DeleteOfferConfirmationDialog$lambda$47(onConfirm, z6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1378514630, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AddOrEditOfferScreenKt.DeleteOfferConfirmationDialog$lambda$48(onDismiss, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableSingletons$AddOrEditOfferScreenKt.INSTANCE.getLambda$1501796296$app_debug(), ComposableSingletons$AddOrEditOfferScreenKt.INSTANCE.m9492getLambda$584046519$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, ((i3 >> 9) & 14) | 1772592, 0, 16276);
                    composer2 = composerStartRestartGroup;
                } else {
                    composer2 = composerStartRestartGroup;
                    z5 = z6;
                    composer2.startReplaceGroup(-1197338549);
                }
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddOrEditOfferScreenKt.DeleteOfferConfirmationDialog$lambda$49(z, z5, onConfirm, onDismiss, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                ComposerKt.traceEventStart(1952165559, i3, -1, "com.example.bingwahybrid.presentation.offers.screens.DeleteOfferConfirmationDialog (AddOrEditOfferScreen.kt:243)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-1187784628);
                ComposerKt.sourceInformation(composerStartRestartGroup, "249@9831L315,259@10164L109,245@9619L655");
                z5 = z6;
                AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0(onDismiss, ComposableLambdaKt.rememberComposableLambda(1255232964, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddOrEditOfferScreenKt.DeleteOfferConfirmationDialog$lambda$47(onConfirm, z6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1378514630, true, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddOrEditOfferScreenKt.DeleteOfferConfirmationDialog$lambda$48(onDismiss, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableSingletons$AddOrEditOfferScreenKt.INSTANCE.getLambda$1501796296$app_debug(), ComposableSingletons$AddOrEditOfferScreenKt.INSTANCE.m9492getLambda$584046519$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, ((i3 >> 9) & 14) | 1772592, 0, 16276);
                composer2 = composerStartRestartGroup;
            } else {
                composer2 = composerStartRestartGroup;
                z5 = z6;
                composer2.startReplaceGroup(-1197338549);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddOrEditOfferScreenKt.DeleteOfferConfirmationDialog$lambda$49(z, z5, onConfirm, onDismiss, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteOfferConfirmationDialog$lambda$47(Function0 function0, final boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C250@9877L259,250@9845L291:AddOrEditOfferScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1255232964, i, -1, "com.example.bingwahybrid.presentation.offers.screens.DeleteOfferConfirmationDialog.<anonymous> (AddOrEditOfferScreen.kt:250)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-743049279, true, new Function3() { // from class: com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AddOrEditOfferScreenKt.DeleteOfferConfirmationDialog$lambda$47$lambda$46(z, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteOfferConfirmationDialog$lambda$47$lambda$46(boolean z, RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C:AddOrEditOfferScreen.kt#6kthjn");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743049279, i, -1, "com.example.bingwahybrid.presentation.offers.screens.DeleteOfferConfirmationDialog.<anonymous>.<anonymous> (AddOrEditOfferScreen.kt:251)");
            }
            if (z) {
                composer.startReplaceGroup(80411089);
                ComposerKt.sourceInformation(composer, "252@9933L104");
                ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24)), 0L, 0.0f, 0L, 0, 0.0f, composer, 6, 62);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(80557316);
                ComposerKt.sourceInformation(composer, "256@10083L21");
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
    public static final Unit DeleteOfferConfirmationDialog$lambda$48(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C260@10178L85:AddOrEditOfferScreen.kt#6kthjn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1378514630, i, -1, "com.example.bingwahybrid.presentation.offers.screens.DeleteOfferConfirmationDialog.<anonymous> (AddOrEditOfferScreen.kt:260)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$AddOrEditOfferScreenKt.INSTANCE.m9493getLambda$619767613$app_debug(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final OfferDetails AddOrEditOfferScreen$lambda$0(State<OfferDetails> state) {
        return state.getValue();
    }

    private static final Offer AddOrEditOfferScreen$lambda$1(State<Offer> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddOrEditOfferScreen$lambda$2(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AddOrEditOfferScreen$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AddOrEditOfferScreen$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean AddOrEditOfferScreen$lambda$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AddOrEditOfferScreen$lambda$6(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
