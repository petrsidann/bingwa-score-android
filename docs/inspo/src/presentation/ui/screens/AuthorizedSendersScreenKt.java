package com.example.bingwahybrid.presentation.ui.screens;

import androidx.autofill.HintConstants;
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
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.MessageKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.FloatingActionButtonKt;
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
import androidx.compose.runtime.ProvidableCompositionLocal;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
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
import com.example.bingwahybrid.domain.sms.model.AuthorizedSender;
import com.example.bingwahybrid.presentation.viewmodel.AuthorizedSendersViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: AuthorizedSendersScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u001a)\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a/\u0010\u000b\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u0010H\u0003¢\u0006\u0002\u0010\u0011\u001a#\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0003¢\u0006\u0002\u0010\u0016\u001aE\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0003¢\u0006\u0002\u0010\u001d¨\u0006\u001e²\u0006\u0010\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u0084\u0002²\u0006\f\u0010\"\u001a\u0004\u0018\u00010\u0019X\u008a\u0084\u0002"}, d2 = {"AuthorizedSendersScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/AuthorizedSendersViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/viewmodel/AuthorizedSendersViewModel;Landroidx/compose/runtime/Composer;II)V", "EmptyState", "(Landroidx/compose/runtime/Composer;I)V", "AuthorizedSendersList", "senders", "", "Lcom/example/bingwahybrid/domain/sms/model/AuthorizedSender;", "onDeleteSender", "Lkotlin/Function1;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SenderItem", "sender", "onDelete", "Lkotlin/Function0;", "(Lcom/example/bingwahybrid/domain/sms/model/AuthorizedSender;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AddSenderDialog", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "", "onPhoneNumberChange", "onDismiss", "onConfirm", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug", "authorizedSenders", "isAddDialogVisible", "", "snackbarMessage"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AuthorizedSendersScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddSenderDialog$lambda$41(String str, Function1 function1, Function0 function0, Function0 function2, int i, Composer composer, int i2) {
        AddSenderDialog(str, function1, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthorizedSendersList$lambda$26(List list, Function1 function1, int i, Composer composer, int i2) {
        AuthorizedSendersList(list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthorizedSendersScreen$lambda$18(Modifier modifier, NavHostController navHostController, AuthorizedSendersViewModel authorizedSendersViewModel, int i, int i2, Composer composer, int i3) {
        AuthorizedSendersScreen(modifier, navHostController, authorizedSendersViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyState$lambda$20(int i, Composer composer, int i2) {
        EmptyState(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SenderItem$lambda$30(AuthorizedSender authorizedSender, Function0 function0, int i, Composer composer, int i2) {
        SenderItem(authorizedSender, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
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
    public static final void AuthorizedSendersScreen(Modifier modifier, final NavHostController navController, AuthorizedSendersViewModel authorizedSendersViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final AuthorizedSendersViewModel authorizedSendersViewModel2;
        final Modifier modifier3;
        final AuthorizedSendersViewModel authorizedSendersViewModel3;
        final Modifier modifier4;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(421793643);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AuthorizedSendersScreen)N(modifier,navController,viewModel)57@2703L24,58@2785L16,59@2861L16,60@2923L16,61@2993L16,63@3047L144,63@3015L176,71@3224L351,81@3608L176,86@3791L794,70@3197L1388:AuthorizedSendersScreen.kt#oif8tm");
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
                authorizedSendersViewModel2 = authorizedSendersViewModel;
                int i5 = composerStartRestartGroup.changedInstance(authorizedSendersViewModel2) ? 256 : 128;
                i3 |= i5;
            } else {
                authorizedSendersViewModel2 = authorizedSendersViewModel;
            }
            i3 |= i5;
        } else {
            authorizedSendersViewModel2 = authorizedSendersViewModel;
        }
        int i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i6 & 147) != 146, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "55@2666L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i6 &= -897;
                }
                modifier4 = modifier2;
            } else {
                Modifier modifierM1119paddingVpY3zN4 = i4 != 0 ? PaddingKt.m1119paddingVpY3zN4(Modifier.INSTANCE, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)) : modifier2;
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
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(AuthorizedSendersViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i6 &= -897;
                    modifier4 = modifierM1119paddingVpY3zN4;
                    authorizedSendersViewModel2 = (AuthorizedSendersViewModel) viewModel;
                } else {
                    modifier4 = modifierM1119paddingVpY3zN4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(421793643, i6, -1, "com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreen (AuthorizedSendersScreen.kt:56)");
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
            final State stateCollectAsState = SnapshotStateKt.collectAsState(authorizedSendersViewModel2.getAuthorizedSenders(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState2 = SnapshotStateKt.collectAsState(authorizedSendersViewModel2.isAddDialogVisible(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState3 = SnapshotStateKt.collectAsState(authorizedSendersViewModel2.getPhoneNumber(), null, composerStartRestartGroup, 0, 1);
            State stateCollectAsState4 = SnapshotStateKt.collectAsState(authorizedSendersViewModel2.getSnackbarMessage(), null, composerStartRestartGroup, 0, 1);
            String strAuthorizedSendersScreen$lambda$3 = AuthorizedSendersScreen$lambda$3(stateCollectAsState4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1616785211, "CC(remember):AuthorizedSendersScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsState4) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(authorizedSendersViewModel2);
            AuthorizedSendersScreenKt$AuthorizedSendersScreen$1$1 authorizedSendersScreenKt$AuthorizedSendersScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || authorizedSendersScreenKt$AuthorizedSendersScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                authorizedSendersScreenKt$AuthorizedSendersScreen$1$1RememberedValue = new AuthorizedSendersScreenKt$AuthorizedSendersScreen$1$1(stateCollectAsState4, coroutineScope, authorizedSendersViewModel2, null);
                composerStartRestartGroup.updateRememberedValue(authorizedSendersScreenKt$AuthorizedSendersScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strAuthorizedSendersScreen$lambda$3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) authorizedSendersScreenKt$AuthorizedSendersScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2109853905, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthorizedSendersScreenKt.AuthorizedSendersScreen$lambda$8(navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1392010610, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthorizedSendersScreenKt.AuthorizedSendersScreen$lambda$11(authorizedSendersViewModel2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            final AuthorizedSendersViewModel authorizedSendersViewModel4 = authorizedSendersViewModel2;
            Function3 function3 = new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthorizedSendersScreenKt.AuthorizedSendersScreen$lambda$17(modifier4, authorizedSendersViewModel4, stateCollectAsState, stateCollectAsState2, stateCollectAsState3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Modifier modifier5 = modifier4;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda, null, null, composableLambdaRememberComposableLambda2, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1019846598, true, function3, composerStartRestartGroup, 54), composerStartRestartGroup, 805330992, 493);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            authorizedSendersViewModel3 = authorizedSendersViewModel4;
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            authorizedSendersViewModel3 = authorizedSendersViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthorizedSendersScreenKt.AuthorizedSendersScreen$lambda$18(modifier3, navController, authorizedSendersViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthorizedSendersScreen$lambda$8(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C74@3338L213,72@3238L327:AuthorizedSendersScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2109853905, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreen.<anonymous> (AuthorizedSendersScreen.kt:72)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$AuthorizedSendersScreenKt.INSTANCE.m9814getLambda$1762594325$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(39541545, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthorizedSendersScreenKt.AuthorizedSendersScreen$lambda$8$lambda$7(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthorizedSendersScreen$lambda$8$lambda$7(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C75@3381L32,75@3360L173:AuthorizedSendersScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(39541545, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreen.<anonymous>.<anonymous> (AuthorizedSendersScreen.kt:75)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -655279511, "CC(remember):AuthorizedSendersScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AuthorizedSendersScreenKt.AuthorizedSendersScreen$lambda$8$lambda$7$lambda$6$lambda$5(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$AuthorizedSendersScreenKt.INSTANCE.getLambda$2113062219$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthorizedSendersScreen$lambda$8$lambda$7$lambda$6$lambda$5(NavHostController navHostController) {
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthorizedSendersScreen$lambda$11(final AuthorizedSendersViewModel authorizedSendersViewModel, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C82@3653L29,82@3622L152:AuthorizedSendersScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1392010610, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreen.<anonymous> (AuthorizedSendersScreen.kt:82)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1987368623, "CC(remember):AuthorizedSendersScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(authorizedSendersViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AuthorizedSendersScreenKt.AuthorizedSendersScreen$lambda$11$lambda$10$lambda$9(authorizedSendersViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FloatingActionButtonKt.m3100FloatingActionButtonXz6DiA((Function0) objRememberedValue, null, null, 0L, 0L, null, null, ComposableSingletons$AuthorizedSendersScreenKt.INSTANCE.m9815getLambda$1954143500$app_debug(), composer, 12582912, WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthorizedSendersScreen$lambda$11$lambda$10$lambda$9(AuthorizedSendersViewModel authorizedSendersViewModel) {
        authorizedSendersViewModel.showAddDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthorizedSendersScreen$lambda$17(Modifier modifier, AuthorizedSendersViewModel authorizedSendersViewModel, State state, State state2, State state3, PaddingValues paddingValues, Composer composer, int i) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)87@3818L761:AuthorizedSendersScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i |= composer.changed(paddingValues) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1019846598, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreen.<anonymous> (AuthorizedSendersScreen.kt:87)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.padding(modifier, paddingValues), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1000293060, "C:AuthorizedSendersScreen.kt#oif8tm");
            if (AuthorizedSendersScreen$lambda$0(state).isEmpty()) {
                composer.startReplaceGroup(1000307970);
                ComposerKt.sourceInformation(composer, "93@4001L12");
                EmptyState(composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1000362158);
                ComposerKt.sourceInformation(composer, "97@4160L33,95@4051L160");
                List<AuthorizedSender> listAuthorizedSendersScreen$lambda$0 = AuthorizedSendersScreen$lambda$0(state);
                ComposerKt.sourceInformationMarkerStart(composer, 1140652309, "CC(remember):AuthorizedSendersScreen.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(authorizedSendersViewModel);
                AuthorizedSendersScreenKt$AuthorizedSendersScreen$4$1$1$1 authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$1$1RememberedValue = composer.rememberedValue();
                if (zChangedInstance || authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$1$1RememberedValue = new AuthorizedSendersScreenKt$AuthorizedSendersScreen$4$1$1$1(authorizedSendersViewModel);
                    composer.updateRememberedValue(authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AuthorizedSendersList(listAuthorizedSendersScreen$lambda$0, (Function1) ((KFunction) authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$1$1RememberedValue), composer, 0);
                composer.endReplaceGroup();
            }
            if (!AuthorizedSendersScreen$lambda$1(state2)) {
                composer2 = composer;
                composer2.startReplaceGroup(996354478);
            } else {
                composer.startReplaceGroup(1000593852);
                ComposerKt.sourceInformation(composer, "104@4387L28,105@4449L24,106@4507L30,102@4281L274");
                String strAuthorizedSendersScreen$lambda$2 = AuthorizedSendersScreen$lambda$2(state3);
                ComposerKt.sourceInformationMarkerStart(composer, 1140659568, "CC(remember):AuthorizedSendersScreen.kt#9igjgp");
                boolean zChangedInstance2 = composer.changedInstance(authorizedSendersViewModel);
                AuthorizedSendersScreenKt$AuthorizedSendersScreen$4$1$2$1 authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$2$1RememberedValue = composer.rememberedValue();
                if (zChangedInstance2 || authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$2$1RememberedValue = new AuthorizedSendersScreenKt$AuthorizedSendersScreen$4$1$2$1(authorizedSendersViewModel);
                    composer.updateRememberedValue(authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Function1 function1 = (Function1) ((KFunction) authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$2$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composer, 1140661548, "CC(remember):AuthorizedSendersScreen.kt#9igjgp");
                boolean zChangedInstance3 = composer.changedInstance(authorizedSendersViewModel);
                AuthorizedSendersScreenKt$AuthorizedSendersScreen$4$1$3$1 authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$3$1RememberedValue = composer.rememberedValue();
                if (zChangedInstance3 || authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$3$1RememberedValue = new AuthorizedSendersScreenKt$AuthorizedSendersScreen$4$1$3$1(authorizedSendersViewModel);
                    composer.updateRememberedValue(authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Function0 function0 = (Function0) ((KFunction) authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$3$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composer, 1140663410, "CC(remember):AuthorizedSendersScreen.kt#9igjgp");
                boolean zChangedInstance4 = composer.changedInstance(authorizedSendersViewModel);
                AuthorizedSendersScreenKt$AuthorizedSendersScreen$4$1$4$1 authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$4$1RememberedValue = composer.rememberedValue();
                if (zChangedInstance4 || authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$4$1RememberedValue = new AuthorizedSendersScreenKt$AuthorizedSendersScreen$4$1$4$1(authorizedSendersViewModel);
                    composer.updateRememberedValue(authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$4$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer2 = composer;
                AddSenderDialog(strAuthorizedSendersScreen$lambda$2, function1, function0, (Function0) ((KFunction) authorizedSendersScreenKt$AuthorizedSendersScreen$4$1$4$1RememberedValue), composer2, 0);
            }
            composer2.endReplaceGroup();
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
        return Unit.INSTANCE;
    }

    private static final void EmptyState(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-651511827);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EmptyState)115@4632L538:AuthorizedSendersScreen.kt#oif8tm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-651511827, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EmptyState (AuthorizedSendersScreen.kt:114)");
            }
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(16));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1118padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1032415067, "C124@4937L10,122@4849L118,128@5069L10,129@5126L11,126@4976L188:AuthorizedSendersScreen.kt#oif8tm");
            composer2 = composerStartRestartGroup;
            TextKt.m3864TextNvy7gAk("No authorized senders yet", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composer2, 6, 0, 131070);
            TextKt.m3864TextNvy7gAk("Add senders using the + button", null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 6, 0, 131066);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthorizedSendersScreenKt.EmptyState$lambda$20(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void AuthorizedSendersList(final List<AuthorizedSender> list, final Function1<? super AuthorizedSender, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-725123337);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AuthorizedSendersList)N(senders,onDeleteSender)139@5325L383,139@5314L394:AuthorizedSendersScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-725123337, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersList (AuthorizedSendersScreen.kt:138)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1058819690, "CC(remember):AuthorizedSendersScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(list) | ((i2 & 112) == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AuthorizedSendersScreenKt.AuthorizedSendersList$lambda$25$lambda$24(list, function1, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 511);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthorizedSendersScreenKt.AuthorizedSendersList$lambda$26(list, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuthorizedSendersList$lambda$25$lambda$24(final List list, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function1 function2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuthorizedSendersScreenKt.AuthorizedSendersList$lambda$25$lambda$24$lambda$21((AuthorizedSender) obj);
            }
        };
        final AuthorizedSendersScreenKt$AuthorizedSendersList$lambda$25$lambda$24$$inlined$items$default$1 authorizedSendersScreenKt$AuthorizedSendersList$lambda$25$lambda$24$$inlined$items$default$1 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$AuthorizedSendersList$lambda$25$lambda$24$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(AuthorizedSender authorizedSender) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((AuthorizedSender) obj);
            }
        };
        LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$AuthorizedSendersList$lambda$25$lambda$24$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function2.invoke(list.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$AuthorizedSendersList$lambda$25$lambda$24$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return authorizedSendersScreenKt$AuthorizedSendersList$lambda$25$lambda$24$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$AuthorizedSendersList$lambda$25$lambda$24$$inlined$items$default$4
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
                final AuthorizedSender authorizedSender = (AuthorizedSender) list.get(i);
                composer.startReplaceGroup(416638142);
                ComposerKt.sourceInformation(composer, "CN(sender)*146@5505L26,144@5433L112,148@5558L40:AuthorizedSendersScreen.kt#oif8tm");
                ComposerKt.sourceInformationMarkerStart(composer, 1121820762, "CC(remember):AuthorizedSendersScreen.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changed(authorizedSender);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function3 = function1;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$AuthorizedSendersList$1$1$2$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function3.invoke(authorizedSender);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AuthorizedSendersScreenKt.SenderItem(authorizedSender, (Function0) objRememberedValue, composer, 0);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(8)), composer, 6);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$AuthorizedSendersScreenKt.INSTANCE.getLambda$316576578$app_debug(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AuthorizedSendersList$lambda$25$lambda$24$lambda$21(AuthorizedSender it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SenderItem(final AuthorizedSender authorizedSender, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1554261851);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SenderItem)N(sender,onDelete)163@5868L1031,161@5812L1087:AuthorizedSendersScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(authorizedSender) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1554261851, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.SenderItem (AuthorizedSendersScreen.kt:160)");
            }
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-312754793, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthorizedSendersScreenKt.SenderItem$lambda$29(function0, authorizedSender, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196614, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthorizedSendersScreenKt.SenderItem$lambda$30(authorizedSender, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SenderItem$lambda$29(Function0 function0, AuthorizedSender authorizedSender, ColumnScope Card, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation(composer, "C164@5878L1015:AuthorizedSendersScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-312754793, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SenderItem.<anonymous> (AuthorizedSendersScreen.kt:164)");
            }
            float f = 16;
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(f));
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1296786482, "C171@6125L507,185@6645L238:AuthorizedSendersScreen.kt#oif8tm");
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1939652197, "C174@6225L184,181@6516L10,179@6426L192:AuthorizedSendersScreen.kt#oif8tm");
            IconKt.m3158Iconww6aTOc(MessageKt.getMessage(Icons.AutoMirrored.Outlined.INSTANCE), "Message", SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24)), 0L, composer, 432, 8);
            TextKt.m3864TextNvy7gAk(authorizedSender.getSender(), PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8684constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 48, 0, 131068);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton(function0, null, false, null, null, null, ComposableSingletons$AuthorizedSendersScreenKt.INSTANCE.m9812getLambda$1187796327$app_debug(), composer, 1572864, 62);
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

    private static final void AddSenderDialog(final String str, final Function1<? super String, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final boolean z;
        Composer composerStartRestartGroup = composer.startRestartGroup(-316308987);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AddSenderDialog)N(phoneNumber,onPhoneNumberChange,onDismiss,onConfirm)203@7131L7,238@8343L170,246@8539L102,211@7366L951,206@7229L1418:AuthorizedSendersScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-316308987, i3, -1, "com.example.bingwahybrid.presentation.ui.screens.AddSenderDialog (AuthorizedSendersScreen.kt:202)");
            }
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localSoftwareKeyboardController);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume;
            if (str.length() != 10) {
                z = false;
                break;
            }
            String str2 = str;
            int i4 = 0;
            while (true) {
                if (i4 >= str2.length()) {
                    z = true;
                    break;
                } else {
                    if (!Character.isDigit(str2.charAt(i4))) {
                        z = false;
                        break;
                    }
                    i4++;
                }
            }
            composer2 = composerStartRestartGroup;
            AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0(function0, ComposableLambdaKt.rememberComposableLambda(-1392858035, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthorizedSendersScreenKt.AddSenderDialog$lambda$32(function2, z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(978858831, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthorizedSendersScreenKt.AddSenderDialog$lambda$33(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableSingletons$AuthorizedSendersScreenKt.INSTANCE.m9816getLambda$944391599$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1906016814, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthorizedSendersScreenKt.AddSenderDialog$lambda$40(softwareKeyboardController, z, function2, str, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, ((i3 >> 6) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthorizedSendersScreenKt.AddSenderDialog$lambda$41(str, function1, function0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddSenderDialog$lambda$40$lambda$38$lambda$37(Function1 function1, String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.length() <= 10) {
            String str = input;
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                }
            }
            function1.invoke(input);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddSenderDialog$lambda$40(final SoftwareKeyboardController softwareKeyboardController, final boolean z, final Function0 function0, final String str, final Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C226@7984L129,214@7468L177,231@8166L126,212@7380L927:AuthorizedSendersScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1906016814, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AddSenderDialog.<anonymous> (AuthorizedSendersScreen.kt:212)");
            }
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m8360getPhonePjHm6EE(), ImeAction.INSTANCE.m8301getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composer, -2026070253, "CC(remember):AuthorizedSendersScreen.kt#9igjgp");
            boolean zChanged = composer.changed(softwareKeyboardController) | composer.changed(z) | composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AuthorizedSendersScreenKt.AddSenderDialog$lambda$40$lambda$35$lambda$34(softwareKeyboardController, z, function0, (KeyboardActionScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            KeyboardActions keyboardActions = new KeyboardActions((Function1) objRememberedValue, null, null, null, null, null, 62, null);
            ComposerKt.sourceInformationMarkerStart(composer, -2026086717, "CC(remember):AuthorizedSendersScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(function1);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AuthorizedSendersScreenKt.AddSenderDialog$lambda$40$lambda$38$lambda$37(function1, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(str, (Function1<? super String, Unit>) objRememberedValue2, (Modifier) null, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AuthorizedSendersScreenKt.INSTANCE.getLambda$478970988$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1885724999, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.AuthorizedSendersScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthorizedSendersScreenKt.AddSenderDialog$lambda$40$lambda$39(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), false, (VisualTransformation) null, keyboardOptions, keyboardActions, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1572864, 12779904, 0, 8155068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddSenderDialog$lambda$40$lambda$35$lambda$34(SoftwareKeyboardController softwareKeyboardController, boolean z, Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
        if (z) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddSenderDialog$lambda$40$lambda$39(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C232@8188L86:AuthorizedSendersScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1885724999, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AddSenderDialog.<anonymous>.<anonymous> (AuthorizedSendersScreen.kt:232)");
            }
            TextKt.m3864TextNvy7gAk(str.length() + "/10", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddSenderDialog$lambda$32(Function0 function0, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C239@8357L146:AuthorizedSendersScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1392858035, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AddSenderDialog.<anonymous> (AuthorizedSendersScreen.kt:239)");
            }
            ButtonKt.TextButton(function0, null, z, null, null, null, null, null, null, ComposableSingletons$AuthorizedSendersScreenKt.INSTANCE.m9813getLambda$1455737526$app_debug(), composer, 805306368, 506);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddSenderDialog$lambda$33(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C247@8553L78:AuthorizedSendersScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(978858831, i, -1, "com.example.bingwahybrid.presentation.ui.screens.AddSenderDialog.<anonymous> (AuthorizedSendersScreen.kt:247)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$AuthorizedSendersScreenKt.INSTANCE.getLambda$915979340$app_debug(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final List<AuthorizedSender> AuthorizedSendersScreen$lambda$0(State<? extends List<AuthorizedSender>> state) {
        return state.getValue();
    }

    private static final boolean AuthorizedSendersScreen$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String AuthorizedSendersScreen$lambda$2(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuthorizedSendersScreen$lambda$3(State<String> state) {
        return state.getValue();
    }
}
