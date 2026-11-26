package com.example.bingwahybrid.presentation.transactions.screens;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
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
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.presentation.transactions.viewmodel.RescheduleTransactionViewModel;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RescheduleTransactionScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a\u0097\u0001\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u000328\u0010\f\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00010\r26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001aH\u0007¢\u0006\u0002\u0010\u001b\u001a\r\u0010\u001c\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d¨\u0006\u001e²\u0006\f\u0010\u001f\u001a\u0004\u0018\u00010 X\u008a\u0084\u0002²\u0006\u0010\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001aX\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\"X\u008a\u0084\u0002²\u0006\f\u0010#\u001a\u0004\u0018\u00010\tX\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\"X\u008a\u008e\u0002²\u0006\f\u0010&\u001a\u0004\u0018\u00010\u000eX\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010+\u001a\u00020\u0017X\u008a\u008e\u0002"}, d2 = {"RescheduleTransactionScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/transactions/viewmodel/RescheduleTransactionViewModel;", "transactionId", "", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/transactions/viewmodel/RescheduleTransactionViewModel;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "RescheduleOfferScreenContent", "onReschedule", "Lkotlin/Function2;", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "Lkotlin/ParameterName;", "name", "offer", "", "time", "onAutoRenew", "", "renewCount", "Lcom/example/bingwahybrid/domain/enums/RenewInterval;", "interval", "offers", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Ljava/util/List;Landroidx/compose/runtime/Composer;II)V", "RescheduleOfferScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "rescheduleSuccess", "", "snackbarMessage", "offerExpanded", "repeatCountIntervalExpanded", "selectedOffer", "selectedDateMillis", "selectedTimeMillis", "selectedDateTime", "autoRenew", "renewIntervalUnit"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RescheduleTransactionScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$95(Modifier modifier, Function2 function2, Function2 function3, List list, int i, int i2, Composer composer, int i3) {
        RescheduleOfferScreenContent(modifier, function2, function3, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenPreview$lambda$100(int i, Composer composer, int i2) {
        RescheduleOfferScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleTransactionScreen$lambda$17(Modifier modifier, NavHostController navHostController, RescheduleTransactionViewModel rescheduleTransactionViewModel, String str, int i, int i2, Composer composer, int i3) {
        RescheduleTransactionScreen(modifier, navHostController, rescheduleTransactionViewModel, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x027e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0282  */
    /* JADX WARN: Code duplicated, block: B:106:0x028e  */
    /* JADX WARN: Code duplicated, block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX WARN: Code duplicated, block: B:28:0x0059  */
    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    /* JADX WARN: Code duplicated, block: B:34:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x0070  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:45:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x008f  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:72:0x0123  */
    /* JADX WARN: Code duplicated, block: B:74:0x012f  */
    /* JADX WARN: Code duplicated, block: B:77:0x013b  */
    /* JADX WARN: Code duplicated, block: B:80:0x015d  */
    /* JADX WARN: Code duplicated, block: B:83:0x019f  */
    /* JADX WARN: Code duplicated, block: B:84:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:89:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:94:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:99:0x022b  */
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
    public static final void RescheduleTransactionScreen(Modifier modifier, NavHostController navHostController, RescheduleTransactionViewModel rescheduleTransactionViewModel, final String transactionId, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        NavHostController navHostController2;
        RescheduleTransactionViewModel rescheduleTransactionViewModel2;
        boolean z;
        final Modifier.Companion companion;
        final NavHostController navHostController3;
        final RescheduleTransactionViewModel rescheduleTransactionViewModel3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i4;
        int i5;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Object objRememberedValue;
        final CoroutineScope coroutineScope;
        State stateCollectAsState;
        State stateCollectAsState2;
        boolean z2;
        boolean zChangedInstance;
        RescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1 rescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1RememberedValue;
        boolean zChanged;
        RescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1 rescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1RememberedValue;
        boolean zChanged2;
        RescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1 rescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1RememberedValue;
        int i6;
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Composer composerStartRestartGroup = composer.startRestartGroup(918598320);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RescheduleTransactionScreen)N(modifier,navController,viewModel,transactionId)78@3524L24,79@3594L16,80@3646L16,81@3720L16,82@3790L16,84@3842L111,84@3812L141,90@3993L92,90@3959L126,96@4123L144,96@4091L176,104@4300L563,120@4870L568,103@4273L1165:RescheduleTransactionScreen.kt#jgxt63");
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
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                navHostController2 = navHostController;
                i3 |= composerStartRestartGroup.changedInstance(navHostController2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    rescheduleTransactionViewModel2 = rescheduleTransactionViewModel;
                    int i9 = composerStartRestartGroup.changedInstance(rescheduleTransactionViewModel2) ? 256 : 128;
                    i3 |= i9;
                } else {
                    rescheduleTransactionViewModel2 = rescheduleTransactionViewModel;
                }
                i3 |= i9;
            } else {
                rescheduleTransactionViewModel2 = rescheduleTransactionViewModel;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(transactionId)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@3460L15");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i8 != 0) {
                        navHostController3 = null;
                    } else {
                        navHostController3 = navHostController2;
                    }
                    if ((i2 & 4) != 0) {
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
                        i4 = 1;
                        ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(RescheduleTransactionViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        RescheduleTransactionViewModel rescheduleTransactionViewModel4 = (RescheduleTransactionViewModel) viewModel;
                        i5 = i3 & (-897);
                        rescheduleTransactionViewModel3 = rescheduleTransactionViewModel4;
                    } else {
                        i4 = 1;
                        i5 = i3;
                        rescheduleTransactionViewModel3 = rescheduleTransactionViewModel2;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = modifier2;
                    i5 = i3;
                    navHostController3 = navHostController2;
                    rescheduleTransactionViewModel3 = rescheduleTransactionViewModel2;
                    i4 = 1;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(918598320, i5, -1, "com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreen (RescheduleTransactionScreen.kt:77)");
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
                final State stateCollectAsState3 = SnapshotStateKt.collectAsState(rescheduleTransactionViewModel3.getTransaction(), null, composerStartRestartGroup, 0, i4);
                final State stateCollectAsState4 = SnapshotStateKt.collectAsState(rescheduleTransactionViewModel3.getOffers(), null, composerStartRestartGroup, 0, i4);
                stateCollectAsState = SnapshotStateKt.collectAsState(rescheduleTransactionViewModel3.getRescheduleSuccess(), null, composerStartRestartGroup, 0, i4);
                stateCollectAsState2 = SnapshotStateKt.collectAsState(rescheduleTransactionViewModel3.getSnackBarMessage(), null, composerStartRestartGroup, 0, i4);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1990258273, "CC(remember):RescheduleTransactionScreen.kt#9igjgp");
                if ((i5 & 7168) == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChangedInstance = z2 | composerStartRestartGroup.changedInstance(rescheduleTransactionViewModel3);
                rescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || rescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    rescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1RememberedValue = new RescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1(transactionId, rescheduleTransactionViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(rescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(transactionId, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1RememberedValue, composerStartRestartGroup, (i5 >> 9) & 14);
                Boolean boolValueOf = Boolean.valueOf(RescheduleTransactionScreen$lambda$2(stateCollectAsState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1990253460, "CC(remember):RescheduleTransactionScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(navHostController3);
                rescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || rescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    rescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1RememberedValue = new RescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1(navHostController3, stateCollectAsState, null);
                    composerStartRestartGroup.updateRememberedValue(rescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                String strRescheduleTransactionScreen$lambda$3 = RescheduleTransactionScreen$lambda$3(stateCollectAsState2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1990249248, "CC(remember):RescheduleTransactionScreen.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(rescheduleTransactionViewModel3);
                rescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged2 || rescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    rescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1RememberedValue = new RescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1(stateCollectAsState2, coroutineScope, rescheduleTransactionViewModel3, null);
                    composerStartRestartGroup.updateRememberedValue(rescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strRescheduleTransactionScreen$lambda$3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1RememberedValue, composerStartRestartGroup, 0);
                ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(1222793580, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RescheduleTransactionScreenKt.RescheduleTransactionScreen$lambda$10(coroutineScope, navHostController3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1596926017, true, new Function3() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return RescheduleTransactionScreenKt.RescheduleTransactionScreen$lambda$16(companion, rescheduleTransactionViewModel3, stateCollectAsState3, stateCollectAsState4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                navHostController3 = navHostController2;
                rescheduleTransactionViewModel3 = rescheduleTransactionViewModel2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RescheduleTransactionScreenKt.RescheduleTransactionScreen$lambda$17(companion, navHostController3, rescheduleTransactionViewModel3, transactionId, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        navHostController2 = navHostController;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                rescheduleTransactionViewModel2 = rescheduleTransactionViewModel;
                if (composerStartRestartGroup.changedInstance(rescheduleTransactionViewModel2)) {
                }
                i3 |= i9;
            } else {
                rescheduleTransactionViewModel2 = rescheduleTransactionViewModel;
            }
            i3 |= i9;
        } else {
            rescheduleTransactionViewModel2 = rescheduleTransactionViewModel;
        }
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changed(transactionId)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "75@3460L15");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i8 != 0) {
                    navHostController3 = null;
                } else {
                    navHostController3 = navHostController2;
                }
                if ((i2 & 4) != 0) {
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
                    i4 = 1;
                    ViewModel viewModel2 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(RescheduleTransactionViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory2, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    RescheduleTransactionViewModel rescheduleTransactionViewModel5 = (RescheduleTransactionViewModel) viewModel2;
                    i5 = i3 & (-897);
                    rescheduleTransactionViewModel3 = rescheduleTransactionViewModel5;
                } else {
                    i4 = 1;
                    i5 = i3;
                    rescheduleTransactionViewModel3 = rescheduleTransactionViewModel2;
                }
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i8 != 0) {
                    navHostController3 = null;
                } else {
                    navHostController3 = navHostController2;
                }
                if ((i2 & 4) != 0) {
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
                    i4 = 1;
                    ViewModel viewModel3 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(RescheduleTransactionViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory3, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    RescheduleTransactionViewModel rescheduleTransactionViewModel6 = (RescheduleTransactionViewModel) viewModel3;
                    i5 = i3 & (-897);
                    rescheduleTransactionViewModel3 = rescheduleTransactionViewModel6;
                } else {
                    i4 = 1;
                    i5 = i3;
                    rescheduleTransactionViewModel3 = rescheduleTransactionViewModel2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(918598320, i5, -1, "com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreen (RescheduleTransactionScreen.kt:77)");
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
            final State stateCollectAsState5 = SnapshotStateKt.collectAsState(rescheduleTransactionViewModel3.getTransaction(), null, composerStartRestartGroup, 0, i4);
            final State stateCollectAsState6 = SnapshotStateKt.collectAsState(rescheduleTransactionViewModel3.getOffers(), null, composerStartRestartGroup, 0, i4);
            stateCollectAsState = SnapshotStateKt.collectAsState(rescheduleTransactionViewModel3.getRescheduleSuccess(), null, composerStartRestartGroup, 0, i4);
            stateCollectAsState2 = SnapshotStateKt.collectAsState(rescheduleTransactionViewModel3.getSnackBarMessage(), null, composerStartRestartGroup, 0, i4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1990258273, "CC(remember):RescheduleTransactionScreen.kt#9igjgp");
            if ((i5 & 7168) == 2048) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChangedInstance = z2 | composerStartRestartGroup.changedInstance(rescheduleTransactionViewModel3);
            rescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                rescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1RememberedValue = new RescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1(transactionId, rescheduleTransactionViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(rescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1RememberedValue);
            } else {
                rescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1RememberedValue = new RescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1(transactionId, rescheduleTransactionViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(rescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(transactionId, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rescheduleTransactionScreenKt$RescheduleTransactionScreen$1$1RememberedValue, composerStartRestartGroup, (i5 >> 9) & 14);
            Boolean boolValueOf2 = Boolean.valueOf(RescheduleTransactionScreen$lambda$2(stateCollectAsState));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1990253460, "CC(remember):RescheduleTransactionScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(navHostController3);
            rescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                rescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1RememberedValue = new RescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1(navHostController3, stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(rescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1RememberedValue);
            } else {
                rescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1RememberedValue = new RescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1(navHostController3, stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(rescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rescheduleTransactionScreenKt$RescheduleTransactionScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            String strRescheduleTransactionScreen$lambda$4 = RescheduleTransactionScreen$lambda$3(stateCollectAsState2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1990249248, "CC(remember):RescheduleTransactionScreen.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(rescheduleTransactionViewModel3);
            rescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                rescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1RememberedValue = new RescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1(stateCollectAsState2, coroutineScope, rescheduleTransactionViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(rescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1RememberedValue);
            } else {
                rescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1RememberedValue = new RescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1(stateCollectAsState2, coroutineScope, rescheduleTransactionViewModel3, null);
                composerStartRestartGroup.updateRememberedValue(rescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strRescheduleTransactionScreen$lambda$4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1RememberedValue, composerStartRestartGroup, 0);
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(1222793580, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RescheduleTransactionScreenKt.RescheduleTransactionScreen$lambda$10(coroutineScope, navHostController3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1596926017, true, new Function3() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RescheduleTransactionScreenKt.RescheduleTransactionScreen$lambda$16(companion, rescheduleTransactionViewModel3, stateCollectAsState5, stateCollectAsState6, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
            navHostController3 = navHostController2;
            rescheduleTransactionViewModel3 = rescheduleTransactionViewModel2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RescheduleTransactionScreenKt.RescheduleTransactionScreen$lambda$17(companion, navHostController3, rescheduleTransactionViewModel3, transactionId, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleTransactionScreen$lambda$10(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C107@4418L421,105@4314L539:RescheduleTransactionScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1222793580, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreen.<anonymous> (RescheduleTransactionScreen.kt:105)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$RescheduleTransactionScreenKt.INSTANCE.getLambda$1649205296$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(-480729166, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RescheduleTransactionScreenKt.RescheduleTransactionScreen$lambda$10$lambda$9(coroutineScope, navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleTransactionScreen$lambda$10$lambda$9(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C108@4461L240,108@4440L381:RescheduleTransactionScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-480729166, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreen.<anonymous>.<anonymous> (RescheduleTransactionScreen.kt:108)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1875741058, "CC(remember):RescheduleTransactionScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RescheduleTransactionScreenKt.RescheduleTransactionScreen$lambda$10$lambda$9$lambda$8$lambda$7(coroutineScope, navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$RescheduleTransactionScreenKt.INSTANCE.getLambda$421546192$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleTransactionScreen$lambda$10$lambda$9$lambda$8$lambda$7(CoroutineScope coroutineScope, NavHostController navHostController) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new RescheduleTransactionScreenKt$RescheduleTransactionScreen$4$1$1$1$1(navHostController, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleTransactionScreen$lambda$16(Modifier modifier, final RescheduleTransactionViewModel rescheduleTransactionViewModel, final State state, State state2, PaddingValues paddingValues, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)121@4897L535:RescheduleTransactionScreen.kt#jgxt63");
        if ((i & 6) == 0) {
            i |= composer.changed(paddingValues) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1596926017, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreen.<anonymous> (RescheduleTransactionScreen.kt:121)");
            }
            Modifier modifierM1119paddingVpY3zN4 = PaddingKt.m1119paddingVpY3zN4(PaddingKt.padding(modifier, paddingValues), Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8));
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
            ComposerKt.sourceInformationMarkerStart(composer, 2072394021, "C127@5124L112,131@5301L107,126@5063L359:RescheduleTransactionScreen.kt#jgxt63");
            List<Offer> listRescheduleTransactionScreen$lambda$1 = RescheduleTransactionScreen$lambda$1(state2);
            ComposerKt.sourceInformationMarkerStart(composer, -2011356857, "CC(remember):RescheduleTransactionScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(rescheduleTransactionViewModel) | composer.changed(state);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RescheduleTransactionScreenKt.RescheduleTransactionScreen$lambda$16$lambda$15$lambda$12$lambda$11(rescheduleTransactionViewModel, state, (Offer) obj, ((Long) obj2).longValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function2 function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -2011351198, "CC(remember):RescheduleTransactionScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(rescheduleTransactionViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RescheduleTransactionScreenKt.RescheduleTransactionScreen$lambda$16$lambda$15$lambda$14$lambda$13(rescheduleTransactionViewModel, ((Integer) obj).intValue(), (RenewInterval) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            RescheduleOfferScreenContent(null, function2, (Function2) objRememberedValue2, listRescheduleTransactionScreen$lambda$1, composer, 0, 1);
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
    public static final Unit RescheduleTransactionScreen$lambda$16$lambda$15$lambda$12$lambda$11(RescheduleTransactionViewModel rescheduleTransactionViewModel, State state, Offer offer, long j) {
        rescheduleTransactionViewModel.rescheduleTransaction(RescheduleTransactionScreen$lambda$0(state), offer, j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleTransactionScreen$lambda$16$lambda$15$lambda$14$lambda$13(RescheduleTransactionViewModel rescheduleTransactionViewModel, int i, RenewInterval interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        rescheduleTransactionViewModel.onAutoRenew(i, interval);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [int] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r32v1 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    public static final void RescheduleOfferScreenContent(androidx.compose.ui.Modifier r95, kotlin.jvm.functions.Function2<? super com.example.bingwahybrid.domain.offers.model.Offer, ? super java.lang.Long, kotlin.Unit> r96, final kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.example.bingwahybrid.domain.enums.RenewInterval, kotlin.Unit> r97, final java.util.List<com.example.bingwahybrid.domain.offers.model.Offer> r98, androidx.compose.runtime.Composer r99, final int r100, final int r101) {
        /*
            Method dump skipped, instruction units count: 4212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt.RescheduleOfferScreenContent(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, java.util.List, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean RescheduleOfferScreenContent$lambda$19(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void RescheduleOfferScreenContent$lambda$20(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean RescheduleOfferScreenContent$lambda$22(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void RescheduleOfferScreenContent$lambda$23(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Offer RescheduleOfferScreenContent$lambda$25(MutableState<Offer> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long RescheduleOfferScreenContent$lambda$28(MutableLongState mutableLongState) {
        return mutableLongState.getLongValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long RescheduleOfferScreenContent$lambda$31(MutableLongState mutableLongState) {
        return mutableLongState.getLongValue();
    }

    private static final long RescheduleOfferScreenContent$lambda$35(MutableLongState mutableLongState) {
        return mutableLongState.getLongValue();
    }

    private static final boolean RescheduleOfferScreenContent$lambda$38(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void RescheduleOfferScreenContent$lambda$39(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String RescheduleOfferScreenContent$lambda$41(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final RenewInterval RescheduleOfferScreenContent$lambda$44(MutableState<RenewInterval> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$47$lambda$46(MutableState mutableState) {
        RescheduleOfferScreenContent$lambda$20(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$56$lambda$50$lambda$49(MutableState mutableState) {
        RescheduleOfferScreenContent$lambda$20(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$56$lambda$55(List list, final MutableState mutableState, final MutableState mutableState2, ColumnScope DropdownMenu, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer2, "C*214@8465L271,211@8341L115,211@8314L423:RescheduleTransactionScreen.kt#jgxt63");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1281925630, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.RescheduleOfferScreenContent.<anonymous>.<anonymous>.<anonymous> (RescheduleTransactionScreen.kt:210)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final Offer offer = (Offer) it.next();
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1070028781, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RescheduleTransactionScreenKt.RescheduleOfferScreenContent$lambda$93$lambda$56$lambda$55$lambda$54$lambda$51(offer, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -981122250, "CC(remember):RescheduleTransactionScreen.kt#9igjgp");
                boolean zChangedInstance = composer2.changedInstance(offer);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RescheduleTransactionScreenKt.RescheduleOfferScreenContent$lambda$93$lambda$56$lambda$55$lambda$54$lambda$53$lambda$52(offer, mutableState, mutableState2);
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
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$56$lambda$55$lambda$54$lambda$53$lambda$52(Offer offer, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(offer);
        RescheduleOfferScreenContent$lambda$20(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$56$lambda$55$lambda$54$lambda$51(Offer offer, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C217@8594L10,218@8667L11,215@8491L223:RescheduleTransactionScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1070028781, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.RescheduleOfferScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RescheduleTransactionScreen.kt:215)");
            }
            TextKt.m3864TextNvy7gAk(offer.getName(), null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$70$lambda$64$lambda$63(Context context, final MutableLongState mutableLongState, final MutableLongState mutableLongState2, final MutableLongState mutableLongState3) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(RescheduleOfferScreenContent$lambda$28(mutableLongState));
        new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda24
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                RescheduleTransactionScreenKt.RescheduleOfferScreenContent$lambda$93$lambda$70$lambda$64$lambda$63$lambda$62(calendar, mutableLongState, mutableLongState2, mutableLongState3, datePicker, i, i2, i3);
            }
        }, calendar.get(1), calendar.get(2), calendar.get(5)).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RescheduleOfferScreenContent$lambda$93$lambda$70$lambda$64$lambda$63$lambda$62(Calendar calendar, MutableLongState mutableLongState, MutableLongState mutableLongState2, MutableLongState mutableLongState3, DatePicker datePicker, int i, int i2, int i3) {
        calendar.set(i, i2, i3);
        mutableLongState.setLongValue(calendar.getTimeInMillis());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(RescheduleOfferScreenContent$lambda$31(mutableLongState2));
        calendar2.set(1, i);
        calendar2.set(2, i2);
        calendar2.set(5, i3);
        mutableLongState3.setLongValue(calendar2.getTimeInMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$70$lambda$65(MutableLongState mutableLongState, RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C276@11028L239:RescheduleTransactionScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(640553672, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.RescheduleOfferScreenContent.<anonymous>.<anonymous>.<anonymous> (RescheduleTransactionScreen.kt:276)");
            }
            String str = new SimpleDateFormat("EEE dd/MM/yyyy", Locale.getDefault()).format(new Date(RescheduleOfferScreenContent$lambda$28(mutableLongState)));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            TextKt.m3864TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$70$lambda$68$lambda$67(Context context, final MutableLongState mutableLongState, final MutableLongState mutableLongState2, final MutableLongState mutableLongState3) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(RescheduleOfferScreenContent$lambda$31(mutableLongState));
        new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda22
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public final void onTimeSet(TimePicker timePicker, int i, int i2) {
                RescheduleTransactionScreenKt.RescheduleOfferScreenContent$lambda$93$lambda$70$lambda$68$lambda$67$lambda$66(calendar, mutableLongState, mutableLongState2, mutableLongState3, timePicker, i, i2);
            }
        }, calendar.get(11), calendar.get(12), true).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RescheduleOfferScreenContent$lambda$93$lambda$70$lambda$68$lambda$67$lambda$66(Calendar calendar, MutableLongState mutableLongState, MutableLongState mutableLongState2, MutableLongState mutableLongState3, TimePicker timePicker, int i, int i2) {
        calendar.set(11, i);
        calendar.set(12, i2);
        calendar.set(13, 0);
        calendar.set(14, 0);
        mutableLongState.setLongValue(calendar.getTimeInMillis());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(RescheduleOfferScreenContent$lambda$28(mutableLongState2));
        calendar2.set(11, i);
        calendar2.set(12, i2);
        mutableLongState3.setLongValue(calendar2.getTimeInMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$70$lambda$69(MutableLongState mutableLongState, RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C312@12713L182:RescheduleTransactionScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-745648143, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.RescheduleOfferScreenContent.<anonymous>.<anonymous>.<anonymous> (RescheduleTransactionScreen.kt:312)");
            }
            String str = new SimpleDateFormat("HH:mm 'Hrs'", Locale.getDefault()).format(new Date(RescheduleOfferScreenContent$lambda$31(mutableLongState)));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            TextKt.m3864TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$75$lambda$72$lambda$71(MutableState mutableState, boolean z) {
        RescheduleOfferScreenContent$lambda$39(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$75$lambda$74$lambda$73(MutableState mutableState) {
        RescheduleOfferScreenContent$lambda$39(mutableState, !RescheduleOfferScreenContent$lambda$38(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$90$lambda$77$lambda$76(Function2 function2, MutableState mutableState, MutableState mutableState2, String newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        mutableState.setValue(newValue);
        function2.invoke(Integer.valueOf(newValue.length() > 0 ? Integer.parseInt(newValue) : 0), RescheduleOfferScreenContent$lambda$44(mutableState2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$90$lambda$89$lambda$80$lambda$79(MutableState mutableState) {
        RescheduleOfferScreenContent$lambda$23(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$90$lambda$89$lambda$82$lambda$81(MutableState mutableState) {
        RescheduleOfferScreenContent$lambda$23(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$90$lambda$89$lambda$88(List list, final Function2 function2, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, ColumnScope DropdownMenu, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer2, "C*362@15036L257,358@14773L254,358@14746L548:RescheduleTransactionScreen.kt#jgxt63");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(892353567, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.RescheduleOfferScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RescheduleTransactionScreen.kt:357)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final RenewInterval renewInterval = (RenewInterval) it.next();
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1291916362, true, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RescheduleTransactionScreenKt.RescheduleOfferScreenContent$lambda$93$lambda$90$lambda$89$lambda$88$lambda$87$lambda$84(renewInterval, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -43384936, "CC(remember):RescheduleTransactionScreen.kt#9igjgp");
                boolean zChanged = composer2.changed(renewInterval.ordinal()) | composer2.changed(function2);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Function0 function0 = new Function0() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RescheduleTransactionScreenKt.RescheduleOfferScreenContent$lambda$93$lambda$90$lambda$89$lambda$88$lambda$87$lambda$86$lambda$85(renewInterval, function2, mutableState, mutableState2, mutableState3);
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
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$90$lambda$89$lambda$88$lambda$87$lambda$86$lambda$85(RenewInterval renewInterval, Function2 function2, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        mutableState.setValue(renewInterval);
        RescheduleOfferScreenContent$lambda$23(mutableState2, false);
        Integer intOrNull = StringsKt.toIntOrNull(RescheduleOfferScreenContent$lambda$41(mutableState3));
        function2.invoke(Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 0), RescheduleOfferScreenContent$lambda$44(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$90$lambda$89$lambda$88$lambda$87$lambda$84(RenewInterval renewInterval, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C363@15070L193:RescheduleTransactionScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1291916362, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.RescheduleOfferScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RescheduleTransactionScreen.kt:363)");
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
    public static final Unit RescheduleOfferScreenContent$lambda$93$lambda$92$lambda$91(Function2 function2, MutableState mutableState, MutableLongState mutableLongState) {
        function2.invoke(RescheduleOfferScreenContent$lambda$25(mutableState), Long.valueOf(RescheduleOfferScreenContent$lambda$35(mutableLongState)));
        return Unit.INSTANCE;
    }

    private static final void RescheduleOfferScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1552373687);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RescheduleOfferScreenPreview)412@16656L11,413@16691L11,411@16603L130:RescheduleTransactionScreen.kt#jgxt63");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1552373687, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.RescheduleOfferScreenPreview (RescheduleTransactionScreen.kt:400)");
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID(...)");
            List listListOf = CollectionsKt.listOf(new Offer(uuidRandomUUID, "2GB for 2 Hours", "*188*2*1*BH*1#", 30, OfferType.DATA, null, false, null, false, false, false, false, false, 0, 0, 0L, null, false, 262112, null));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1477473538, "CC(remember):RescheduleTransactionScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RescheduleTransactionScreenKt.RescheduleOfferScreenPreview$lambda$97$lambda$96((Offer) obj, ((Long) obj2).longValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function2 function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1477474658, "CC(remember):RescheduleTransactionScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RescheduleTransactionScreenKt.RescheduleOfferScreenPreview$lambda$99$lambda$98(((Integer) obj).intValue(), (RenewInterval) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            RescheduleOfferScreenContent(null, function2, (Function2) objRememberedValue2, listListOf, composerStartRestartGroup, 432, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RescheduleTransactionScreenKt.RescheduleOfferScreenPreview$lambda$100(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenPreview$lambda$97$lambda$96(Offer offer, long j) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RescheduleOfferScreenPreview$lambda$99$lambda$98(int i, RenewInterval renewInterval) {
        Intrinsics.checkNotNullParameter(renewInterval, "<unused var>");
        return Unit.INSTANCE;
    }

    private static final Transaction RescheduleTransactionScreen$lambda$0(State<Transaction> state) {
        return state.getValue();
    }

    private static final List<Offer> RescheduleTransactionScreen$lambda$1(State<? extends List<Offer>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean RescheduleTransactionScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String RescheduleTransactionScreen$lambda$3(State<String> state) {
        return state.getValue();
    }
}
