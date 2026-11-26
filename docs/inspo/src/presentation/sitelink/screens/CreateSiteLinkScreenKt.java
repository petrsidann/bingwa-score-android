package com.example.bingwahybrid.presentation.sitelink.screens;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
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
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
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

/* JADX INFO: compiled from: CreateSiteLinkScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a)\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u009f\u0001\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00132\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a\r\u0010\u001b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001c¨\u0006\u001d²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\rX\u008a\u0084\u0002²\u0006\f\u0010\u001e\u001a\u0004\u0018\u00010\rX\u008a\u0084\u0002²\u0006\f\u0010\u001f\u001a\u0004\u0018\u00010\rX\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010\u0010\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\u0016X\u008a\u008e\u0002"}, d2 = {"CreateSiteLinkScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/sitelink/viewmodel/SiteLinkViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/sitelink/viewmodel/SiteLinkViewModel;Landroidx/compose/runtime/Composer;II)V", "CreateSiteLinkScreenContent", "isLoading", "", "siteName", "", "accountNumber", HintConstants.AUTOFILL_HINT_USERNAME, "isCheckingUsername", "isUsernameAvailable", "onSiteNameChanged", "Lkotlin/Function1;", "onAccountNumberChanged", "onAccountTypeChanged", "Lcom/example/bingwahybrid/domain/sitelink/enums/SiteLinkAccountType;", "onUsernameChanged", "onRequestSiteLink", "Lkotlin/Function0;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "CreateSiteLinkScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "errorMessage", "successMessage", "siteLinkGenerationSuccess", "accountType"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CreateSiteLinkScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreen$lambda$28(Modifier modifier, NavHostController navHostController, SiteLinkViewModel siteLinkViewModel, int i, int i2, Composer composer, int i3) {
        CreateSiteLinkScreen(modifier, navHostController, siteLinkViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreenContent$lambda$49(boolean z, String str, String str2, String str3, boolean z2, Boolean bool, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function0 function0, int i, int i2, int i3, Composer composer, int i4) {
        CreateSiteLinkScreenContent(z, str, str2, str3, z2, bool, function1, function2, function3, function4, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreenPreview$lambda$60(int i, Composer composer, int i2) {
        CreateSiteLinkScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
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
    public static final void CreateSiteLinkScreen(Modifier modifier, final NavHostController navController, SiteLinkViewModel siteLinkViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        SiteLinkViewModel siteLinkViewModel2;
        final Modifier modifier3;
        final SiteLinkViewModel siteLinkViewModel3;
        final Modifier modifier4;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerStartRestartGroup = composer.startRestartGroup(945957688);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CreateSiteLinkScreen)N(modifier,navController,viewModel)59@2691L24,60@2757L16,61@2813L16,62@2879L16,63@2943L16,64@3011L16,65@3101L16,66@3157L16,67@3233L16,68@3311L16,70@3362L165,70@3333L194,78@3564L167,78@3533L198,87@3780L99,87@3738L141,94@3912L555,110@4474L974,93@3885L1563:CreateSiteLinkScreen.kt#4cevh3");
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
        int i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i6 & 147) != 146, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "57@2654L15");
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
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(SiteLinkViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i6 &= -897;
                    modifier4 = companion;
                    siteLinkViewModel2 = (SiteLinkViewModel) viewModel;
                } else {
                    modifier4 = companion;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(945957688, i6, -1, "com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreen (CreateSiteLinkScreen.kt:58)");
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
            final State stateCollectAsState = SnapshotStateKt.collectAsState(siteLinkViewModel2.isLoading(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState2 = SnapshotStateKt.collectAsState(siteLinkViewModel2.getSiteName(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState3 = SnapshotStateKt.collectAsState(siteLinkViewModel2.getAccountNumber(), null, composerStartRestartGroup, 0, 1);
            State stateCollectAsState4 = SnapshotStateKt.collectAsState(siteLinkViewModel2.getErrorMessage(), null, composerStartRestartGroup, 0, 1);
            State stateCollectAsState5 = SnapshotStateKt.collectAsState(siteLinkViewModel2.getSuccessMessage(), null, composerStartRestartGroup, 0, 1);
            State stateCollectAsState6 = SnapshotStateKt.collectAsState(siteLinkViewModel2.getSiteLinkGenerationSuccess(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState7 = SnapshotStateKt.collectAsState(siteLinkViewModel2.getUsername(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState8 = SnapshotStateKt.collectAsState(siteLinkViewModel2.isCheckingUsername(), null, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState9 = SnapshotStateKt.collectAsState(siteLinkViewModel2.isUsernameAvailable(), null, composerStartRestartGroup, 0, 1);
            String strCreateSiteLinkScreen$lambda$3 = CreateSiteLinkScreen$lambda$3(stateCollectAsState4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1467699811, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsState4) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(siteLinkViewModel2);
            CreateSiteLinkScreenKt$CreateSiteLinkScreen$1$1 createSiteLinkScreenKt$CreateSiteLinkScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || createSiteLinkScreenKt$CreateSiteLinkScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                createSiteLinkScreenKt$CreateSiteLinkScreen$1$1RememberedValue = new CreateSiteLinkScreenKt$CreateSiteLinkScreen$1$1(stateCollectAsState4, coroutineScope, siteLinkViewModel2, null);
                composerStartRestartGroup.updateRememberedValue(createSiteLinkScreenKt$CreateSiteLinkScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strCreateSiteLinkScreen$lambda$3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) createSiteLinkScreenKt$CreateSiteLinkScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            String strCreateSiteLinkScreen$lambda$4 = CreateSiteLinkScreen$lambda$4(stateCollectAsState5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1467693345, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsState5) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(siteLinkViewModel2);
            CreateSiteLinkScreenKt$CreateSiteLinkScreen$2$1 createSiteLinkScreenKt$CreateSiteLinkScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || createSiteLinkScreenKt$CreateSiteLinkScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                createSiteLinkScreenKt$CreateSiteLinkScreen$2$1RememberedValue = new CreateSiteLinkScreenKt$CreateSiteLinkScreen$2$1(stateCollectAsState5, coroutineScope, siteLinkViewModel2, null);
                composerStartRestartGroup.updateRememberedValue(createSiteLinkScreenKt$CreateSiteLinkScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strCreateSiteLinkScreen$lambda$4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) createSiteLinkScreenKt$CreateSiteLinkScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            Boolean boolValueOf = Boolean.valueOf(CreateSiteLinkScreen$lambda$5(stateCollectAsState6));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1467686501, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(stateCollectAsState6) | composerStartRestartGroup.changedInstance(navController);
            CreateSiteLinkScreenKt$CreateSiteLinkScreen$3$1 createSiteLinkScreenKt$CreateSiteLinkScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || createSiteLinkScreenKt$CreateSiteLinkScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                createSiteLinkScreenKt$CreateSiteLinkScreen$3$1RememberedValue = new CreateSiteLinkScreenKt$CreateSiteLinkScreen$3$1(navController, stateCollectAsState6, null);
                composerStartRestartGroup.updateRememberedValue(createSiteLinkScreenKt$CreateSiteLinkScreen$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) createSiteLinkScreenKt$CreateSiteLinkScreen$3$1RememberedValue, composerStartRestartGroup, 0);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2133098228, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateSiteLinkScreenKt.CreateSiteLinkScreen$lambda$15(coroutineScope, navController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            final SiteLinkViewModel siteLinkViewModel4 = siteLinkViewModel2;
            Function3 function3 = new Function3() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CreateSiteLinkScreenKt.CreateSiteLinkScreen$lambda$27(modifier4, siteLinkViewModel4, stateCollectAsState, stateCollectAsState2, stateCollectAsState3, stateCollectAsState7, stateCollectAsState8, stateCollectAsState9, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Modifier modifier5 = modifier4;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1206000247, true, function3, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            siteLinkViewModel3 = siteLinkViewModel4;
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            siteLinkViewModel3 = siteLinkViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateSiteLinkScreenKt.CreateSiteLinkScreen$lambda$28(modifier3, navController, siteLinkViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreen$lambda$15(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C97@4023L420,95@3926L531:CreateSiteLinkScreen.kt#4cevh3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2133098228, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreen.<anonymous> (CreateSiteLinkScreen.kt:95)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$CreateSiteLinkScreenKt.INSTANCE.m9591getLambda$829130568$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(-52883014, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateSiteLinkScreenKt.CreateSiteLinkScreen$lambda$15$lambda$14(coroutineScope, navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreen$lambda$15$lambda$14(final CoroutineScope coroutineScope, final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C98@4066L239,98@4045L380:CreateSiteLinkScreen.kt#4cevh3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-52883014, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreen.<anonymous>.<anonymous> (CreateSiteLinkScreen.kt:98)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 719032713, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreen$lambda$15$lambda$14$lambda$13$lambda$12(coroutineScope, navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$CreateSiteLinkScreenKt.INSTANCE.getLambda$1953847640$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreen$lambda$15$lambda$14$lambda$13$lambda$12(CoroutineScope coroutineScope, NavHostController navHostController) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CreateSiteLinkScreenKt$CreateSiteLinkScreen$4$1$1$1$1(navHostController, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreen$lambda$27(Modifier modifier, final SiteLinkViewModel siteLinkViewModel, State state, State state2, State state3, State state4, State state5, State state6, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)111@4501L941:CreateSiteLinkScreen.kt#4cevh3");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1206000247, i2, -1, "com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreen.<anonymous> (CreateSiteLinkScreen.kt:111)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1768707533, "C125@5052L45,126@5140L48,127@5229L46,128@5313L35,129@5386L31,118@4711L721:CreateSiteLinkScreen.kt#4cevh3");
            boolean zCreateSiteLinkScreen$lambda$0 = CreateSiteLinkScreen$lambda$0(state);
            String strCreateSiteLinkScreen$lambda$1 = CreateSiteLinkScreen$lambda$1(state2);
            String strCreateSiteLinkScreen$lambda$2 = CreateSiteLinkScreen$lambda$2(state3);
            String strCreateSiteLinkScreen$lambda$6 = CreateSiteLinkScreen$lambda$6(state4);
            boolean zCreateSiteLinkScreen$lambda$7 = CreateSiteLinkScreen$lambda$7(state5);
            Boolean boolCreateSiteLinkScreen$lambda$8 = CreateSiteLinkScreen$lambda$8(state6);
            ComposerKt.sourceInformationMarkerStart(composer, 1882617804, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(siteLinkViewModel);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreen$lambda$27$lambda$26$lambda$17$lambda$16(siteLinkViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1882620623, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(siteLinkViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreen$lambda$27$lambda$26$lambda$19$lambda$18(siteLinkViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1882623469, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(siteLinkViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreen$lambda$27$lambda$26$lambda$21$lambda$20(siteLinkViewModel, (SiteLinkAccountType) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function1 function3 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1882626146, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(siteLinkViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreen$lambda$27$lambda$26$lambda$23$lambda$22(siteLinkViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function4 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1882628478, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            boolean zChangedInstance5 = composer.changedInstance(siteLinkViewModel);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreen$lambda$27$lambda$26$lambda$25$lambda$24(siteLinkViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CreateSiteLinkScreenContent(zCreateSiteLinkScreen$lambda$0, strCreateSiteLinkScreen$lambda$1, strCreateSiteLinkScreen$lambda$2, strCreateSiteLinkScreen$lambda$6, zCreateSiteLinkScreen$lambda$7, boolCreateSiteLinkScreen$lambda$8, function1, function2, function3, function4, (Function0) objRememberedValue5, composer, 0, 0, 0);
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
    public static final Unit CreateSiteLinkScreen$lambda$27$lambda$26$lambda$17$lambda$16(SiteLinkViewModel siteLinkViewModel, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        siteLinkViewModel.onSiteNameChanged(name);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreen$lambda$27$lambda$26$lambda$19$lambda$18(SiteLinkViewModel siteLinkViewModel, String acc) {
        Intrinsics.checkNotNullParameter(acc, "acc");
        siteLinkViewModel.onAccountNumberChanged(acc);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreen$lambda$27$lambda$26$lambda$21$lambda$20(SiteLinkViewModel siteLinkViewModel, SiteLinkAccountType acc) {
        Intrinsics.checkNotNullParameter(acc, "acc");
        siteLinkViewModel.onAccountTypeChanged(acc);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreen$lambda$27$lambda$26$lambda$23$lambda$22(SiteLinkViewModel siteLinkViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        siteLinkViewModel.onUsernameChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreen$lambda$27$lambda$26$lambda$25$lambda$24(SiteLinkViewModel siteLinkViewModel) {
        siteLinkViewModel.requestSiteLink();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0167  */
    /* JADX WARN: Code duplicated, block: B:106:0x0182  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:112:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:113:0x0201  */
    /* JADX WARN: Code duplicated, block: B:118:0x0234  */
    /* JADX WARN: Code duplicated, block: B:121:0x0297  */
    /* JADX WARN: Code duplicated, block: B:122:0x0299  */
    /* JADX WARN: Code duplicated, block: B:127:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:130:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:132:0x0406  */
    /* JADX WARN: Code duplicated, block: B:133:0x0408  */
    /* JADX WARN: Code duplicated, block: B:137:0x041c  */
    /* JADX WARN: Code duplicated, block: B:138:0x041e  */
    /* JADX WARN: Code duplicated, block: B:141:0x0426  */
    /* JADX WARN: Code duplicated, block: B:145:0x0432  */
    /* JADX WARN: Code duplicated, block: B:148:0x0540  */
    /* JADX WARN: Code duplicated, block: B:151:0x054c  */
    /* JADX WARN: Code duplicated, block: B:152:0x0550  */
    /* JADX WARN: Code duplicated, block: B:155:0x0575  */
    /* JADX WARN: Code duplicated, block: B:157:0x0583  */
    /* JADX WARN: Code duplicated, block: B:160:0x05b8  */
    /* JADX WARN: Code duplicated, block: B:161:0x05ba  */
    /* JADX WARN: Code duplicated, block: B:164:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:165:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:168:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:172:0x05e2  */
    /* JADX WARN: Code duplicated, block: B:175:0x0617  */
    /* JADX WARN: Code duplicated, block: B:176:0x0619  */
    /* JADX WARN: Code duplicated, block: B:179:0x0620  */
    /* JADX WARN: Code duplicated, block: B:181:0x0628  */
    /* JADX WARN: Code duplicated, block: B:184:0x06e0  */
    /* JADX WARN: Code duplicated, block: B:185:0x06e2  */
    /* JADX WARN: Code duplicated, block: B:188:0x06e9  */
    /* JADX WARN: Code duplicated, block: B:192:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:195:0x0768  */
    /* JADX WARN: Code duplicated, block: B:197:0x0774  */
    /* JADX WARN: Code duplicated, block: B:200:0x077c  */
    /* JADX WARN: Code duplicated, block: B:204:0x07d1  */
    /* JADX WARN: Code duplicated, block: B:206:0x07d6  */
    /* JADX WARN: Code duplicated, block: B:209:0x07e4  */
    /* JADX WARN: Code duplicated, block: B:211:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0133  */
    /* JADX WARN: Code duplicated, block: B:95:0x013c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0140  */
    /* JADX WARN: Code duplicated, block: B:99:0x0152  */
    public static final void CreateSiteLinkScreenContent(boolean z, final String siteName, final String accountNumber, final String username, final boolean z2, Boolean bool, final Function1<? super String, Unit> onSiteNameChanged, final Function1<? super String, Unit> onAccountNumberChanged, final Function1<? super SiteLinkAccountType, Unit> onAccountTypeChanged, final Function1<? super String, Unit> onUsernameChanged, Function0<Unit> function0, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        final Function0<Unit> function1;
        int i6;
        int i7;
        boolean z3;
        Boolean bool2;
        Composer composer2;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object objRememberedValue;
        MutableState mutableState;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z5;
        Object objRememberedValue2;
        String str;
        final Boolean bool3;
        boolean z6;
        boolean z7;
        Object objRememberedValue3;
        int iHashCode2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM5259constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean z8;
        int i8;
        boolean z9;
        Object objRememberedValue4;
        final MutableState mutableState2;
        final MutableState mutableState3;
        boolean z10;
        Object objRememberedValue5;
        boolean z11;
        Object objRememberedValue6;
        boolean z12;
        Object objRememberedValue7;
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(accountNumber, "accountNumber");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(onSiteNameChanged, "onSiteNameChanged");
        Intrinsics.checkNotNullParameter(onAccountNumberChanged, "onAccountNumberChanged");
        Intrinsics.checkNotNullParameter(onAccountTypeChanged, "onAccountTypeChanged");
        Intrinsics.checkNotNullParameter(onUsernameChanged, "onUsernameChanged");
        Composer composerStartRestartGroup = composer.startRestartGroup(1190182783);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CreateSiteLinkScreenContent)N(isLoading,siteName,accountNumber,username,isCheckingUsername,isUsernameAvailable,onSiteNameChanged,onAccountNumberChanged,onAccountTypeChanged,onUsernameChanged,onRequestSiteLink)147@5881L2,149@5912L54,150@5989L21,152@6016L4101:CreateSiteLinkScreen.kt#4cevh3");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i9 = i4;
        if ((i & 48) == 0) {
            i5 = i9 | (composerStartRestartGroup.changed(siteName) ? 32 : 16);
        } else {
            i5 = i9;
        }
        if ((i & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(accountNumber) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(username) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i5 |= composerStartRestartGroup.changed(bool) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onSiteNameChanged) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onAccountNumberChanged) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onAccountTypeChanged) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & i) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onUsernameChanged) ? 536870912 : 268435456;
        }
        int i10 = i5;
        int i11 = i3 & 1024;
        if (i11 == 0) {
            function1 = function0;
            if ((i2 & 6) == 0) {
                i7 = i2 | (composerStartRestartGroup.changedInstance(function1) ? 4 : 2);
            } else {
                i6 = i2;
            }
            if ((i10 & 306783379) == 306783378 || (i6 & 3) != 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i10 & 1)) {
                if (i11 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1304367457, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    function1 = (Function0) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                Function0<Unit> function2 = function1;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1190182783, i10, i6, "com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenContent (CreateSiteLinkScreen.kt:148)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1304368501, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SiteLinkAccountType.MPESA, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                int i12 = i6;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
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
                if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 650901855, "C157@6173L25,155@6096L421,166@6526L41,169@6673L10,170@6739L11,167@6576L265,174@6850L40,178@7028L112,188@7434L840,176@6951L1410,216@8371L40,217@8420L22,218@8451L604,233@9064L41,236@9196L30,237@9248L96,234@9114L441,244@9565L41,250@9817L244,246@9616L445,258@10070L41:CreateSiteLinkScreen.kt#4cevh3");
                KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), KeyboardCapitalization.INSTANCE.m8336getWordsIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, WebSocketProtocol.PAYLOAD_SHORT, (Object) null);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2057214674, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                if ((3670016 & i10) == 1048576) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z5 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$35$lambda$34(onSiteNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                OutlinedTextFieldKt.OutlinedTextField(siteName, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CreateSiteLinkScreenKt.INSTANCE.getLambda$1846945295$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i10 >> 3) & 14) | 1573248, 113246208, 0, 7962552);
                float f = 16;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                TextKt.m3864TextNvy7gAk("https://bingwahybrid.com/" + username, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16773118, null), composerStartRestartGroup, 0, 0, 131070);
                float f2 = 8;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m8333getNoneIUNYP9k(), (Boolean) null, KeyboardType.INSTANCE.m8361getTextPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 122, (DefaultConstructorMarker) null);
                str = username;
                if (str.length() > 0) {
                    bool3 = bool;
                    if (Intrinsics.areEqual((Object) bool3, (Object) false)) {
                        z6 = true;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2057187227, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                    if ((i10 & 1879048192) == 536870912) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z7 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$37$lambda$36(onUsernameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    OutlinedTextFieldKt.OutlinedTextField(username, (Function1<? super String, Unit>) objRememberedValue3, modifierFillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CreateSiteLinkScreenKt.INSTANCE.getLambda$1235417350$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-324103661, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$38(z2, username, bool3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), z6, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i10 >> 9) & 14) | 1573248, 196992, 0, 8343480);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                    TextKt.m3864TextNvy7gAk("Payout Account", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default3);
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
                    if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1189648929, "C222@8663L135,222@8588L211,227@8858L135,227@8813L181,231@9007L38:CreateSiteLinkScreen.kt#4cevh3");
                    if (CreateSiteLinkScreenContent$lambda$32(mutableState) == SiteLinkAccountType.MPESA) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1901284800, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                    i8 = i10 & 234881024;
                    if (i8 == 67108864) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z9 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        mutableState2 = mutableState;
                        objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$40$lambda$39(onAccountTypeChanged, mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        mutableState2 = mutableState;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableState3 = mutableState2;
                    RadioButtonKt.RadioButton(z8, (Function0) objRememberedValue4, null, false, null, null, composerStartRestartGroup, 0, 60);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1901278560, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                    if (i8 == 67108864) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z10 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$42$lambda$41(onAccountTypeChanged, mutableState3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    TextKt.m3864TextNvy7gAk("M-Pesa", ClickableKt.m584clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue5, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262140);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2057117933, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                    if ((i10 & 29360128) == 8388608) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (z11 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$45$lambda$44(onAccountNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    OutlinedTextFieldKt.OutlinedTextField(accountNumber, (Function1<? super String, Unit>) objRememberedValue6, modifierFillMaxWidth$default4, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1962232057, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$46(mutableState3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default2, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i10 >> 6) & 14) | 1573248, 113246208, 0, 7962552);
                    composer2 = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(20)), composer2, 6);
                    if (z) {
                        bool2 = bool;
                    } else {
                        bool2 = bool;
                        if (!Intrinsics.areEqual((Object) bool2, (Object) true) || str.length() == 0) {
                            z12 = true;
                        }
                        z4 = z;
                        CustomButtonKt.CustomButton(function2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z12, false, ComposableLambdaKt.rememberComposableLambda(-319351287, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda24
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$47(z4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer2, 54), composer2, (i12 & 14) | 24624, 8);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composer2, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function1 = function2;
                    }
                    z12 = false;
                    z4 = z;
                    CustomButtonKt.CustomButton(function2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z12, false, ComposableLambdaKt.rememberComposableLambda(-319351287, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$47(z4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composer2, (i12 & 14) | 24624, 8);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composer2, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function1 = function2;
                } else {
                    bool3 = bool;
                }
                z6 = false;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2057187227, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                if ((i10 & 1879048192) == 536870912) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$37$lambda$36(onUsernameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$37$lambda$36(onUsernameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                OutlinedTextFieldKt.OutlinedTextField(username, (Function1<? super String, Unit>) objRememberedValue3, modifierFillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CreateSiteLinkScreenKt.INSTANCE.getLambda$1235417350$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-324103661, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$38(z2, username, bool3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), z6, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i10 >> 9) & 14) | 1573248, 196992, 0, 8343480);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                TextKt.m3864TextNvy7gAk("Payout Account", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default5);
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
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1189648929, "C222@8663L135,222@8588L211,227@8858L135,227@8813L181,231@9007L38:CreateSiteLinkScreen.kt#4cevh3");
                if (CreateSiteLinkScreenContent$lambda$32(mutableState) == SiteLinkAccountType.MPESA) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1901284800, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                i8 = i10 & 234881024;
                if (i8 == 67108864) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z9) {
                    mutableState2 = mutableState;
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$40$lambda$39(onAccountTypeChanged, mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    mutableState2 = mutableState;
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$40$lambda$39(onAccountTypeChanged, mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableState3 = mutableState2;
                RadioButtonKt.RadioButton(z8, (Function0) objRememberedValue4, null, false, null, null, composerStartRestartGroup, 0, 60);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1901278560, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                if (i8 == 67108864) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z10) {
                    objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$42$lambda$41(onAccountTypeChanged, mutableState3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$42$lambda$41(onAccountTypeChanged, mutableState3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TextKt.m3864TextNvy7gAk("M-Pesa", ClickableKt.m584clickableoSLSa3U$default(companion2, false, null, null, null, (Function0) objRememberedValue5, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262140);
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default3 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
                Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2057117933, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                if ((i10 & 29360128) == 8388608) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z11) {
                    objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$45$lambda$44(onAccountNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$45$lambda$44(onAccountNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                OutlinedTextFieldKt.OutlinedTextField(accountNumber, (Function1<? super String, Unit>) objRememberedValue6, modifierFillMaxWidth$default6, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1962232057, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$46(mutableState3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default3, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i10 >> 6) & 14) | 1573248, 113246208, 0, 7962552);
                composer2 = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(20)), composer2, 6);
                if (z) {
                    bool2 = bool;
                    if (!Intrinsics.areEqual((Object) bool2, (Object) true)) {
                    }
                    z12 = true;
                    z4 = z;
                    CustomButtonKt.CustomButton(function2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z12, false, ComposableLambdaKt.rememberComposableLambda(-319351287, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$47(z4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composer2, (i12 & 14) | 24624, 8);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composer2, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function1 = function2;
                } else {
                    bool2 = bool;
                }
                z12 = false;
                z4 = z;
                CustomButtonKt.CustomButton(function2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z12, false, ComposableLambdaKt.rememberComposableLambda(-319351287, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$47(z4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer2, (i12 & 14) | 24624, 8);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composer2, 6);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function1 = function2;
            } else {
                bool2 = bool;
                composer2 = composerStartRestartGroup;
                z4 = z;
                composer2.skipToGroupEnd();
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Boolean bool4 = bool2;
                final boolean z13 = z4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$49(z13, siteName, accountNumber, username, z2, bool4, onSiteNameChanged, onAccountNumberChanged, onAccountTypeChanged, onUsernameChanged, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i7 = i2 | 6;
        function1 = function0;
        i6 = i7;
        if ((i10 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i10 & 1)) {
            if (i11 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1304367457, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                function1 = (Function0) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            Function0<Unit> function3 = function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1190182783, i10, i6, "com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenContent (CreateSiteLinkScreen.kt:148)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1304368501, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SiteLinkAccountType.MPESA, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierVerticalScroll$default2 = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int i13 = i6;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default2);
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
            if (composerM5259constructorimpl.getInserting()) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            } else {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 650901855, "C157@6173L25,155@6096L421,166@6526L41,169@6673L10,170@6739L11,167@6576L265,174@6850L40,178@7028L112,188@7434L840,176@6951L1410,216@8371L40,217@8420L22,218@8451L604,233@9064L41,236@9196L30,237@9248L96,234@9114L441,244@9565L41,250@9817L244,246@9616L445,258@10070L41:CreateSiteLinkScreen.kt#4cevh3");
            KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default4 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), KeyboardCapitalization.INSTANCE.m8336getWordsIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, WebSocketProtocol.PAYLOAD_SHORT, (Object) null);
            Modifier modifierFillMaxWidth$default7 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2057214674, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            if ((3670016 & i10) == 1048576) {
                z5 = true;
            } else {
                z5 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z5) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$35$lambda$34(onSiteNameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$35$lambda$34(onSiteNameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OutlinedTextFieldKt.OutlinedTextField(siteName, (Function1<? super String, Unit>) objRememberedValue2, modifierFillMaxWidth$default7, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CreateSiteLinkScreenKt.INSTANCE.getLambda$1846945295$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default4, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i10 >> 3) & 14) | 1573248, 113246208, 0, 7962552);
            float f3 = 16;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
            TextKt.m3864TextNvy7gAk("https://bingwahybrid.com/" + username, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16773118, null), composerStartRestartGroup, 0, 0, 131070);
            float f4 = 8;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
            Modifier modifierFillMaxWidth$default8 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            KeyboardOptions keyboardOptions2 = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m8333getNoneIUNYP9k(), (Boolean) null, KeyboardType.INSTANCE.m8361getTextPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 122, (DefaultConstructorMarker) null);
            str = username;
            if (str.length() > 0) {
                bool3 = bool;
                if (Intrinsics.areEqual((Object) bool3, (Object) false)) {
                    z6 = true;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2057187227, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                if ((i10 & 1879048192) == 536870912) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$37$lambda$36(onUsernameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$37$lambda$36(onUsernameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                OutlinedTextFieldKt.OutlinedTextField(username, (Function1<? super String, Unit>) objRememberedValue3, modifierFillMaxWidth$default8, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CreateSiteLinkScreenKt.INSTANCE.getLambda$1235417350$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-324103661, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$38(z2, username, bool3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), z6, (VisualTransformation) null, keyboardOptions2, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i10 >> 9) & 14) | 1573248, 196992, 0, 8343480);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
                TextKt.m3864TextNvy7gAk("Payout Account", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
                Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                Modifier modifierFillMaxWidth$default9 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default9);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1189648929, "C222@8663L135,222@8588L211,227@8858L135,227@8813L181,231@9007L38:CreateSiteLinkScreen.kt#4cevh3");
                if (CreateSiteLinkScreenContent$lambda$32(mutableState) == SiteLinkAccountType.MPESA) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1901284800, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                i8 = i10 & 234881024;
                if (i8 == 67108864) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z9) {
                    mutableState2 = mutableState;
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$40$lambda$39(onAccountTypeChanged, mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    mutableState2 = mutableState;
                    objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$40$lambda$39(onAccountTypeChanged, mutableState2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableState3 = mutableState2;
                RadioButtonKt.RadioButton(z8, (Function0) objRememberedValue4, null, false, null, null, composerStartRestartGroup, 0, 60);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1901278560, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                if (i8 == 67108864) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z10) {
                    objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$42$lambda$41(onAccountTypeChanged, mutableState3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$42$lambda$41(onAccountTypeChanged, mutableState3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TextKt.m3864TextNvy7gAk("M-Pesa", ClickableKt.m584clickableoSLSa3U$default(companion3, false, null, null, null, (Function0) objRememberedValue5, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262140);
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
                KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default5 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
                Modifier modifierFillMaxWidth$default10 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2057117933, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
                if ((i10 & 29360128) == 8388608) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z11) {
                    objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$45$lambda$44(onAccountNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$45$lambda$44(onAccountNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                OutlinedTextFieldKt.OutlinedTextField(accountNumber, (Function1<? super String, Unit>) objRememberedValue6, modifierFillMaxWidth$default10, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1962232057, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$46(mutableState3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default5, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i10 >> 6) & 14) | 1573248, 113246208, 0, 7962552);
                composer2 = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(20)), composer2, 6);
                if (z) {
                    bool2 = bool;
                    if (!Intrinsics.areEqual((Object) bool2, (Object) true)) {
                    }
                    z12 = true;
                    z4 = z;
                    CustomButtonKt.CustomButton(function3, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z12, false, ComposableLambdaKt.rememberComposableLambda(-319351287, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$47(z4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composer2, (i13 & 14) | 24624, 8);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composer2, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function1 = function3;
                } else {
                    bool2 = bool;
                }
                z12 = false;
                z4 = z;
                CustomButtonKt.CustomButton(function3, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z12, false, ComposableLambdaKt.rememberComposableLambda(-319351287, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$47(z4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer2, (i13 & 14) | 24624, 8);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composer2, 6);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function1 = function3;
            } else {
                bool3 = bool;
            }
            z6 = false;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2057187227, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            if ((i10 & 1879048192) == 536870912) {
                z7 = true;
            } else {
                z7 = false;
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z7) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$37$lambda$36(onUsernameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$37$lambda$36(onUsernameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OutlinedTextFieldKt.OutlinedTextField(username, (Function1<? super String, Unit>) objRememberedValue3, modifierFillMaxWidth$default8, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CreateSiteLinkScreenKt.INSTANCE.getLambda$1235417350$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-324103661, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$38(z2, username, bool3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), z6, (VisualTransformation) null, keyboardOptions2, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i10 >> 9) & 14) | 1573248, 196992, 0, 8343480);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
            TextKt.m3864TextNvy7gAk("Payout Account", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262142);
            Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierFillMaxWidth$default11 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default11);
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
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting()) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            } else {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1189648929, "C222@8663L135,222@8588L211,227@8858L135,227@8813L181,231@9007L38:CreateSiteLinkScreen.kt#4cevh3");
            if (CreateSiteLinkScreenContent$lambda$32(mutableState) == SiteLinkAccountType.MPESA) {
                z8 = true;
            } else {
                z8 = false;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1901284800, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            i8 = i10 & 234881024;
            if (i8 == 67108864) {
                z9 = true;
            } else {
                z9 = false;
            }
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z9) {
                mutableState2 = mutableState;
                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$40$lambda$39(onAccountTypeChanged, mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                mutableState2 = mutableState;
                objRememberedValue4 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$40$lambda$39(onAccountTypeChanged, mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            mutableState3 = mutableState2;
            RadioButtonKt.RadioButton(z8, (Function0) objRememberedValue4, null, false, null, null, composerStartRestartGroup, 0, 60);
            Modifier.Companion companion4 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1901278560, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            if (i8 == 67108864) {
                z10 = true;
            } else {
                z10 = false;
            }
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z10) {
                objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$42$lambda$41(onAccountTypeChanged, mutableState3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$42$lambda$41(onAccountTypeChanged, mutableState3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextKt.m3864TextNvy7gAk("M-Pesa", ClickableKt.m584clickableoSLSa3U$default(companion4, false, null, null, null, (Function0) objRememberedValue5, 15, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 6, 0, 262140);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
            KeyboardOptions keyboardOptionsM1549copyINvB4aQ$default6 = KeyboardOptions.m1549copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), 0, (Boolean) null, KeyboardType.INSTANCE.m8357getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (Object) null);
            Modifier modifierFillMaxWidth$default12 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2057117933, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            if ((i10 & 29360128) == 8388608) {
                z11 = true;
            } else {
                z11 = false;
            }
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z11) {
                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$45$lambda$44(onAccountNumberChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$45$lambda$44(onAccountNumberChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OutlinedTextFieldKt.OutlinedTextField(accountNumber, (Function1<? super String, Unit>) objRememberedValue6, modifierFillMaxWidth$default12, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1962232057, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$46(mutableState3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1549copyINvB4aQ$default6, (KeyboardActions) null, true, 1, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, ((i10 >> 6) & 14) | 1573248, 113246208, 0, 7962552);
            composer2 = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(20)), composer2, 6);
            if (z) {
                bool2 = bool;
                if (!Intrinsics.areEqual((Object) bool2, (Object) true)) {
                }
                z12 = true;
                z4 = z;
                CustomButtonKt.CustomButton(function3, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z12, false, ComposableLambdaKt.rememberComposableLambda(-319351287, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$47(z4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer2, (i13 & 14) | 24624, 8);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composer2, 6);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function1 = function3;
            } else {
                bool2 = bool;
            }
            z12 = false;
            z4 = z;
            CustomButtonKt.CustomButton(function3, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z12, false, ComposableLambdaKt.rememberComposableLambda(-319351287, true, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$48$lambda$47(z4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, (i13 & 14) | 24624, 8);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composer2, 6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function1 = function3;
        } else {
            bool2 = bool;
            composer2 = composerStartRestartGroup;
            z4 = z;
            composer2.skipToGroupEnd();
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Boolean bool5 = bool2;
            final boolean z14 = z4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateSiteLinkScreenKt.CreateSiteLinkScreenContent$lambda$49(z14, siteName, accountNumber, username, z2, bool5, onSiteNameChanged, onAccountNumberChanged, onAccountTypeChanged, onUsernameChanged, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final SiteLinkAccountType CreateSiteLinkScreenContent$lambda$32(MutableState<SiteLinkAccountType> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreenContent$lambda$48$lambda$35$lambda$34(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreenContent$lambda$48$lambda$37$lambda$36(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(StringsKt.replace$default(it, ServerSentEventKt.SPACE, "", false, 4, (Object) null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreenContent$lambda$48$lambda$38(boolean z, String str, Boolean bool, Composer composer, int i) {
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C:CreateSiteLinkScreen.kt#4cevh3");
        if (composer2.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-324103661, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenContent.<anonymous>.<anonymous> (CreateSiteLinkScreen.kt:189)");
            }
            if (z) {
                composer2.startReplaceGroup(-285614218);
                ComposerKt.sourceInformation(composer2, "191@7527L41");
                TextKt.m3864TextNvy7gAk("Checking username availability...", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
                composer.endReplaceGroup();
            } else if (str.length() < 3) {
                composer2.startReplaceGroup(-285481135);
                ComposerKt.sourceInformation(composer2, "195@7661L46");
                TextKt.m3864TextNvy7gAk("Username must be at least 3 characters", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
                composer.endReplaceGroup();
            } else if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                composer2.startReplaceGroup(-285331963);
                ComposerKt.sourceInformation(composer2, "201@7917L11,199@7808L154");
                TextKt.m3864TextNvy7gAk("Username is available", null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262138);
                composer.endReplaceGroup();
            } else {
                if (!Intrinsics.areEqual((Object) bool, (Object) false)) {
                    composer2.startReplaceGroup(-293058961);
                } else {
                    composer2.startReplaceGroup(-285077949);
                    ComposerKt.sourceInformation(composer2, "208@8177L11,206@8064L156");
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
    public static final Unit CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$40$lambda$39(Function1 function1, MutableState mutableState) {
        mutableState.setValue(SiteLinkAccountType.MPESA);
        function1.invoke(SiteLinkAccountType.MPESA);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreenContent$lambda$48$lambda$43$lambda$42$lambda$41(Function1 function1, MutableState mutableState) {
        mutableState.setValue(SiteLinkAccountType.MPESA);
        function1.invoke(SiteLinkAccountType.MPESA);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreenContent$lambda$48$lambda$45$lambda$44(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreenContent$lambda$48$lambda$46(MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C237@9250L92:CreateSiteLinkScreen.kt#4cevh3");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1962232057, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenContent.<anonymous>.<anonymous> (CreateSiteLinkScreen.kt:237)");
            }
            TextKt.m3864TextNvy7gAk(CreateSiteLinkScreenContent$lambda$32(mutableState) == SiteLinkAccountType.TILL ? "Till Number" : "M-Pesa Number", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreenContent$lambda$48$lambda$47(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C253@9943L10,251@9831L220:CreateSiteLinkScreen.kt#4cevh3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-319351287, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenContent.<anonymous>.<anonymous> (CreateSiteLinkScreen.kt:251)");
            }
            TextKt.m3864TextNvy7gAk(!z ? "Create" : "Creating...", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void CreateSiteLinkScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(282387867);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CreateSiteLinkScreenPreview)272@10453L2,273@10490L2,274@10525L2,275@10557L2,276@10589L2,265@10213L385:CreateSiteLinkScreen.kt#4cevh3");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(282387867, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenPreview (CreateSiteLinkScreen.kt:264)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 791811165, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenPreview$lambda$51$lambda$50((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 791812349, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenPreview$lambda$53$lambda$52((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 791813469, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenPreview$lambda$55$lambda$54((SiteLinkAccountType) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function3 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 791814493, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateSiteLinkScreenKt.CreateSiteLinkScreenPreview$lambda$57$lambda$56((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function4 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 791815517, "CC(remember):CreateSiteLinkScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CreateSiteLinkScreenContent(false, "", "0712345678", "", false, null, function1, function2, function3, function4, (Function0) objRememberedValue5, composerStartRestartGroup, 920350134, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateSiteLinkScreenKt.CreateSiteLinkScreenPreview$lambda$60(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreenPreview$lambda$51$lambda$50(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreenPreview$lambda$53$lambda$52(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreenPreview$lambda$55$lambda$54(SiteLinkAccountType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateSiteLinkScreenPreview$lambda$57$lambda$56(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private static final boolean CreateSiteLinkScreen$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String CreateSiteLinkScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    private static final String CreateSiteLinkScreen$lambda$2(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateSiteLinkScreen$lambda$3(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateSiteLinkScreen$lambda$4(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CreateSiteLinkScreen$lambda$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String CreateSiteLinkScreen$lambda$6(State<String> state) {
        return state.getValue();
    }

    private static final boolean CreateSiteLinkScreen$lambda$7(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final Boolean CreateSiteLinkScreen$lambda$8(State<Boolean> state) {
        return state.getValue();
    }
}
