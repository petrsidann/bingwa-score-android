package com.example.bingwahybrid.presentation.ui.screens;

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
import androidx.compose.material.MenuKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.style.TextOverflow;
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
import com.example.bingwahybrid.domain.enums.AutoReplyType;
import com.example.bingwahybrid.domain.model.AutoReply;
import com.example.bingwahybrid.presentation.navigation.Route;
import com.example.bingwahybrid.presentation.viewmodel.AutoReplyViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: AutoReplyScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a)\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aS\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001aC\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0017¨\u0006\u0018²\u0006\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u008a\u0084\u0002"}, d2 = {"AutoReplyScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/AutoReplyViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/viewmodel/AutoReplyViewModel;Landroidx/compose/runtime/Composer;II)V", "AutoReplyScreenContent", "autoReplies", "", "Lcom/example/bingwahybrid/domain/model/AutoReply;", "onActiveStatusChanged", "Lkotlin/Function2;", "", "onEdit", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "AutoReplyItem", "autoReply", "(Lcom/example/bingwahybrid/domain/model/AutoReply;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "AutoReplyScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AutoReplyScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyItem$lambda$28(AutoReply autoReply, Function2 function2, Function1 function1, int i, Composer composer, int i2) {
        AutoReplyItem(autoReply, function2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreen$lambda$14(Modifier modifier, NavHostController navHostController, AutoReplyViewModel autoReplyViewModel, int i, int i2, Composer composer, int i3) {
        AutoReplyScreen(modifier, navHostController, autoReplyViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreenContent$lambda$19(Modifier modifier, List list, Function2 function2, Function1 function1, int i, int i2, Composer composer, int i3) {
        AutoReplyScreenContent(modifier, list, function2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreenPreview$lambda$33(int i, Composer composer, int i2) {
        AutoReplyScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
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
    public static final void AutoReplyScreen(Modifier modifier, final NavHostController navController, AutoReplyViewModel autoReplyViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier modifier3;
        final Modifier.Companion companion;
        CreationExtras.Empty defaultViewModelCreationExtras;
        int i4;
        final AutoReplyViewModel autoReplyViewModel2 = autoReplyViewModel;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1657624141);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AutoReplyScreen)N(modifier,navController,viewModel)51@2275L16,53@2325L72,53@2297L100,59@2472L395,71@2900L356,83@3263L655,57@2403L1515:AutoReplyScreen.kt#oif8tm");
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
            if ((i2 & 4) != 0) {
                i4 = 128;
            } else {
                if ((i & 512) == 0 ? composerStartRestartGroup.changed(autoReplyViewModel2) : composerStartRestartGroup.changedInstance(autoReplyViewModel2)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
            }
            i3 |= i4;
        }
        int i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i6 & 147) != 146, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "49@2205L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i6 &= -897;
                }
                companion = modifier2;
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
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(AutoReplyViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    autoReplyViewModel2 = (AutoReplyViewModel) viewModel;
                    i6 &= -897;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1657624141, i6, -1, "com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreen (AutoReplyScreen.kt:50)");
            }
            final State stateCollectAsState = SnapshotStateKt.collectAsState(autoReplyViewModel2.getAutoRepliesFlow(), null, composerStartRestartGroup, 0, 1);
            List<AutoReply> listAutoReplyScreen$lambda$0 = AutoReplyScreen$lambda$0(stateCollectAsState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 456077051, "CC(remember):AutoReplyScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsState);
            AutoReplyScreenKt$AutoReplyScreen$1$1 autoReplyScreenKt$AutoReplyScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || autoReplyScreenKt$AutoReplyScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                autoReplyScreenKt$AutoReplyScreen$1$1RememberedValue = new AutoReplyScreenKt$AutoReplyScreen$1$1(stateCollectAsState, null);
                composerStartRestartGroup.updateRememberedValue(autoReplyScreenKt$AutoReplyScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(listAutoReplyScreen$lambda$0, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) autoReplyScreenKt$AutoReplyScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            ScaffoldKt.m3481ScaffoldTvnljyQ(WindowInsetsPadding_androidKt.imePadding(Modifier.INSTANCE), ComposableLambdaKt.rememberComposableLambda(1147327863, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoReplyScreenKt.AutoReplyScreen$lambda$5(navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, ComposableLambdaKt.rememberComposableLambda(1895163066, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoReplyScreenKt.AutoReplyScreen$lambda$8(navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-783435902, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AutoReplyScreenKt.AutoReplyScreen$lambda$13(companion, autoReplyViewModel2, navController, stateCollectAsState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805330992, 492);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        final AutoReplyViewModel autoReplyViewModel3 = autoReplyViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoReplyScreenKt.AutoReplyScreen$lambda$14(modifier3, navController, autoReplyViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreen$lambda$5(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C62@2586L257,60@2486L371:AutoReplyScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1147327863, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreen.<anonymous> (AutoReplyScreen.kt:60)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$AutoReplyScreenKt.INSTANCE.getLambda$1230965811$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(376426353, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoReplyScreenKt.AutoReplyScreen$lambda$5$lambda$4(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreen$lambda$5$lambda$4(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C63@2629L76,63@2608L217:AutoReplyScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(376426353, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreen.<anonymous>.<anonymous> (AutoReplyScreen.kt:63)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 968473821, "CC(remember):AutoReplyScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AutoReplyScreenKt.AutoReplyScreen$lambda$5$lambda$4$lambda$3$lambda$2(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$AutoReplyScreenKt.INSTANCE.getLambda$472711059$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreen$lambda$5$lambda$4$lambda$3$lambda$2(NavHostController navHostController) {
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreen$lambda$8(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C73@2962L95,72@2914L332:AutoReplyScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1895163066, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreen.<anonymous> (AutoReplyScreen.kt:72)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 185575001, "CC(remember):AutoReplyScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AutoReplyScreenKt.AutoReplyScreen$lambda$8$lambda$7$lambda$6(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FloatingActionButtonKt.m3100FloatingActionButtonXz6DiA((Function0) objRememberedValue, null, null, 0L, 0L, null, null, ComposableSingletons$AutoReplyScreenKt.INSTANCE.getLambda$351635516$app_debug(), composer, 12582912, WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreen$lambda$8$lambda$7$lambda$6(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, Route.EditAutoReplyMessage.INSTANCE.getName(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreen$lambda$13(Modifier modifier, final AutoReplyViewModel autoReplyViewModel, final NavHostController navHostController, State state, PaddingValues paddingValues, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)89@3524L106,92@3653L249,84@3290L622:AutoReplyScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i |= composer.changed(paddingValues) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-783435902, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreen.<anonymous> (AutoReplyScreen.kt:84)");
            }
            Modifier modifierM1119paddingVpY3zN4 = PaddingKt.m1119paddingVpY3zN4(PaddingKt.padding(modifier, paddingValues), Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8));
            List<AutoReply> listAutoReplyScreen$lambda$0 = AutoReplyScreen$lambda$0(state);
            ComposerKt.sourceInformationMarkerStart(composer, -1262616564, "CC(remember):AutoReplyScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(autoReplyViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AutoReplyScreenKt.AutoReplyScreen$lambda$13$lambda$10$lambda$9(autoReplyViewModel, (AutoReply) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function2 function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1262612293, "CC(remember):AutoReplyScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(navHostController);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AutoReplyScreenKt.AutoReplyScreen$lambda$13$lambda$12$lambda$11(navHostController, (AutoReply) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AutoReplyScreenContent(modifierM1119paddingVpY3zN4, listAutoReplyScreen$lambda$0, function2, (Function1) objRememberedValue2, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreen$lambda$13$lambda$10$lambda$9(AutoReplyViewModel autoReplyViewModel, AutoReply autoReply, boolean z) {
        Intrinsics.checkNotNullParameter(autoReply, "autoReply");
        autoReplyViewModel.onAutoReplyStatusChanged(autoReply, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreen$lambda$13$lambda$12$lambda$11(NavHostController navHostController, AutoReply autoReply) {
        Intrinsics.checkNotNullParameter(autoReply, "autoReply");
        NavController.navigate$default((NavController) navHostController, StringsKt.replace$default(Route.EditAutoReplyMessage.INSTANCE.getName(), "{id}", String.valueOf(autoReply.getId()), false, 4, (Object) null), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    public static final void AutoReplyScreenContent(Modifier modifier, final List<AutoReply> autoReplies, final Function2<? super AutoReply, ? super Boolean, Unit> onActiveStatusChanged, final Function1<? super AutoReply, Unit> onEdit, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(autoReplies, "autoReplies");
        Intrinsics.checkNotNullParameter(onActiveStatusChanged, "onActiveStatusChanged");
        Intrinsics.checkNotNullParameter(onEdit, "onEdit");
        Composer composerStartRestartGroup = composer.startRestartGroup(1666213221);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AutoReplyScreenContent)N(modifier,autoReplies,onActiveStatusChanged,onEdit)113@4190L447,111@4129L508:AutoReplyScreen.kt#oif8tm");
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
            i3 |= composerStartRestartGroup.changedInstance(autoReplies) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onActiveStatusChanged) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onEdit) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1666213221, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenContent (AutoReplyScreen.kt:110)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -791887004, "CC(remember):AutoReplyScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(autoReplies) | ((i3 & 896) == 256) | ((i3 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AutoReplyScreenKt.AutoReplyScreenContent$lambda$18$lambda$17(autoReplies, onActiveStatusChanged, onEdit, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier4 = companion;
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyColumn(modifierFillMaxWidth$default, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 0, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoReplyScreenKt.AutoReplyScreenContent$lambda$19(modifier3, autoReplies, onActiveStatusChanged, onEdit, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreenContent$lambda$18$lambda$17(final List list, final Function2 function2, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function1 function3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AutoReplyScreenKt.AutoReplyScreenContent$lambda$18$lambda$17$lambda$15((AutoReply) obj);
            }
        };
        final AutoReplyScreenKt$AutoReplyScreenContent$lambda$18$lambda$17$$inlined$items$default$1 autoReplyScreenKt$AutoReplyScreenContent$lambda$18$lambda$17$$inlined$items$default$1 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$AutoReplyScreenContent$lambda$18$lambda$17$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(AutoReply autoReply) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((AutoReply) obj);
            }
        };
        LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$AutoReplyScreenContent$lambda$18$lambda$17$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function3.invoke(list.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$AutoReplyScreenContent$lambda$18$lambda$17$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return autoReplyScreenKt$AutoReplyScreenContent$lambda$18$lambda$17$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$AutoReplyScreenContent$lambda$18$lambda$17$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
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
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                AutoReply autoReply = (AutoReply) list.get(i);
                composer.startReplaceGroup(2117637841);
                ComposerKt.sourceInformation(composer, "CN(autoReply)*118@4325L162,123@4500L40:AutoReplyScreen.kt#oif8tm");
                AutoReplyScreenKt.AutoReplyItem(autoReply, function2, function1, composer, 0);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(8)), composer, 6);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$AutoReplyScreenKt.INSTANCE.getLambda$1405903152$app_debug(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AutoReplyScreenContent$lambda$18$lambda$17$lambda$15(AutoReply autoReply) {
        Intrinsics.checkNotNullParameter(autoReply, "autoReply");
        return Long.valueOf(autoReply.getId());
    }

    public static final void AutoReplyItem(final AutoReply autoReply, final Function2<? super AutoReply, ? super Boolean, Unit> onActiveStatusChanged, final Function1<? super AutoReply, Unit> onEdit, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(autoReply, "autoReply");
        Intrinsics.checkNotNullParameter(onActiveStatusChanged, "onActiveStatusChanged");
        Intrinsics.checkNotNullParameter(onEdit, "onEdit");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1798077491);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AutoReplyItem)N(autoReply,onActiveStatusChanged,onEdit)140@4879L19,142@4985L11,143@5056L11,141@4930L157,145@5107L41,148@5155L1225,138@4796L1584:AutoReplyScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(autoReply) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onActiveStatusChanged) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onEdit) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1798077491, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.AutoReplyItem (AutoReplyScreen.kt:137)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            int i3 = i2;
            boolean z = false;
            CardElevation cardElevationM2693cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2693cardElevationaqJV_2Y(Dp.m8684constructorimpl(0), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62);
            CardColors cardColorsM2692cardColorsro_MJ88 = CardDefaults.INSTANCE.m2692cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurfaceContainer(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1375600906, "CC(remember):AutoReplyScreen.kt#9igjgp");
            boolean z2 = (i3 & 896) == 256;
            if ((i3 & 14) == 4) {
                z = true;
            }
            boolean z3 = z2 | z;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AutoReplyScreenKt.AutoReplyItem$lambda$21$lambda$20(onEdit, autoReply);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CardKt.Card((Function0) objRememberedValue, modifierFillMaxWidth$default, false, null, cardColorsM2692cardColorsro_MJ88, cardElevationM2693cardElevationaqJV_2Y, null, null, ComposableLambdaKt.rememberComposableLambda(2098847938, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AutoReplyScreenKt.AutoReplyItem$lambda$27(autoReply, onActiveStatusChanged, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 204);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoReplyScreenKt.AutoReplyItem$lambda$28(autoReply, onActiveStatusChanged, onEdit, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyItem$lambda$21$lambda$20(Function1 function1, AutoReply autoReply) {
        function1.invoke(autoReply);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyItem$lambda$27(final AutoReply autoReply, final Function2 function2, ColumnScope Card, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation(composer, "C149@5200L1174:AutoReplyScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2098847938, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AutoReplyItem.<anonymous> (AutoReplyScreen.kt:149)");
            }
            float f = 16;
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1443507229, "C152@5311L551,168@5875L40,169@5963L401:AutoReplyScreen.kt#oif8tm");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1510498085, "C157@5490L10,155@5398L132,161@5641L10,159@5547L301:AutoReplyScreen.kt#oif8tm");
            TextKt.m3864TextNvy7gAk(autoReply.getTitle(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 0, 0, 131070);
            TextKt.m3864TextNvy7gAk(autoReply.getMessage(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8592getEllipsisgIe3tQ8(), false, 2, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), 0L, 0L, null, FontStyle.m8228boximpl(FontStyle.INSTANCE.m8237getItalic_LCdwA()), null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777207, null), composer, 0, 24960, 110590);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.m1175width3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composer, 6);
            Arrangement.HorizontalOrVertical spaceAround = Arrangement.INSTANCE.getSpaceAround();
            Alignment.Horizontal end = Alignment.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(spaceAround, end, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, 622219560, "C175@6214L40,173@6118L232:AutoReplyScreen.kt#oif8tm");
            boolean zIsActive = autoReply.isActive();
            ComposerKt.sourceInformationMarkerStart(composer, 435716475, "CC(remember):AutoReplyScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function2) | composer.changed(autoReply);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AutoReplyScreenKt.AutoReplyItem$lambda$27$lambda$26$lambda$25$lambda$24$lambda$23(function2, autoReply, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(zIsActive, (Function1) objRememberedValue, ScaleKt.scale(Modifier.INSTANCE, 0.8f), null, false, null, null, composer, 384, MenuKt.InTransitionDuration);
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
    public static final Unit AutoReplyItem$lambda$27$lambda$26$lambda$25$lambda$24$lambda$23(Function2 function2, AutoReply autoReply, boolean z) {
        function2.invoke(autoReply, Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    private static final void AutoReplyScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1105442392);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AutoReplyScreenPreview)213@7297L11,214@7327L2,211@7206L130:AutoReplyScreen.kt#oif8tm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1105442392, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenPreview (AutoReplyScreen.kt:186)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new AutoReply[]{new AutoReply(1L, "Success AutoReply", "Offer successful. Thanks for your purchase", true, AutoReplyType.SUCCESS, null, 32, null), new AutoReply(2L, "Failed AutoReply", "Transaction failed, please try again", false, AutoReplyType.FAILED, null, 32, null), new AutoReply(3L, "Offer Unavailable", "Offer unavailable. Please enter the correct amount", true, AutoReplyType.OFFER_UNAVAILABLE, null, 32, null)});
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1473245827, "CC(remember):AutoReplyScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AutoReplyScreenKt.AutoReplyScreenPreview$lambda$30$lambda$29((AutoReply) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function2 function2 = (Function2) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1473246778, "CC(remember):AutoReplyScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AutoReplyScreenKt.AutoReplyScreenPreview$lambda$32$lambda$31((AutoReply) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AutoReplyScreenContent(null, listListOf, function2, (Function1) objRememberedValue2, composerStartRestartGroup, 3456, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AutoReplyScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoReplyScreenKt.AutoReplyScreenPreview$lambda$33(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreenPreview$lambda$30$lambda$29(AutoReply autoReply, boolean z) {
        Intrinsics.checkNotNullParameter(autoReply, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoReplyScreenPreview$lambda$32$lambda$31(AutoReply it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AutoReply> AutoReplyScreen$lambda$0(State<? extends List<AutoReply>> state) {
        return state.getValue();
    }
}
