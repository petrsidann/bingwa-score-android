package com.example.bingwahybrid.presentation.ui.screens;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
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
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.profileinstaller.ProfileVerifier;
import com.example.bingwahybrid.presentation.navigation.Route;
import com.example.bingwahybrid.presentation.ui.components.CustomButtonKt;
import com.example.bingwahybrid.presentation.ui.components.ValidatedTextFieldKt;
import com.example.bingwahybrid.presentation.viewmodel.RegisterViewModel;
import io.ktor.sse.ServerSentEventKt;
import java.util.Locale;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ActorCoroutine;

/* JADX INFO: compiled from: RegisterScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aã\u0001\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u001bH\u0007¢\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010 ¨\u0006!²\u0006\n\u0010\"\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\f\u0010#\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\f\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\f\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\f\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002"}, d2 = {"RegisterScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/RegisterViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/viewmodel/RegisterViewModel;Landroidx/compose/runtime/Composer;II)V", "RegisterScreenContent", "firstName", "", "lastName", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "email", "isLoading", "", "firstNameError", "lastNameError", "phoneNumberError", "emailError", "onFirstNameChanged", "Lkotlin/Function1;", "onLastNameChanged", "onPhoneNumberChanged", "onEmailChanged", "onRegister", "Lkotlin/Function0;", "onRegisterWithGoogle", "onGoToLogin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "PreviewRegisterScreen", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "registerSuccess", "snackbarMessage"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RegisterScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewRegisterScreen$lambda$60(int i, Composer composer, int i2) {
        PreviewRegisterScreen(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RegisterScreen$lambda$29(Modifier modifier, NavHostController navHostController, RegisterViewModel registerViewModel, int i, int i2, Composer composer, int i3) {
        RegisterScreen(modifier, navHostController, registerViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RegisterScreenContent$lambda$45(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function0 function0, Function0 function5, Function0 function6, int i, int i2, int i3, Composer composer, int i4) {
        RegisterScreenContent(str, str2, str3, str4, z, str5, str6, str7, str8, function1, function2, function3, function4, function0, function5, function6, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0292  */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:34:0x0067  */
    /* JADX WARN: Code duplicated, block: B:38:0x0073  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00de  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:66:0x0110  */
    /* JADX WARN: Code duplicated, block: B:68:0x011c  */
    /* JADX WARN: Code duplicated, block: B:71:0x0129  */
    /* JADX WARN: Code duplicated, block: B:74:0x014b  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:92:0x022b  */
    /* JADX WARN: Code duplicated, block: B:95:0x0280  */
    /* JADX WARN: Code duplicated, block: B:97:0x0286  */
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
    public static final void RegisterScreen(Modifier modifier, NavHostController navHostController, RegisterViewModel registerViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        NavHostController navHostController2;
        int i4;
        boolean z;
        final Modifier modifier3;
        final NavHostController navHostController3;
        final RegisterViewModel registerViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        NavHostController navHostController4;
        ActorCoroutine actorCoroutine;
        int i5;
        final Modifier modifier4;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Object objRememberedValue;
        CoroutineScope coroutineScope;
        State stateCollectAsState;
        State stateCollectAsState2;
        final State stateCollectAsState3;
        boolean zChanged;
        RegisterScreenKt$RegisterScreen$1$1 registerScreenKt$RegisterScreen$1$1RememberedValue;
        boolean zChanged2;
        RegisterScreenKt$RegisterScreen$2$1 registerScreenKt$RegisterScreen$2$1RememberedValue;
        int i6;
        boolean zChangedInstance;
        RegisterViewModel registerViewModel3 = registerViewModel;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1966898041);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RegisterScreen)N(modifier,navController,viewModel)47@2151L24,48@2229L16,49@2299L16,50@2357L16,52@2416L16,53@2472L16,55@2535L16,56@2585L16,58@2654L16,59@2720L16,60@2792L16,61@2852L16,63@2906L144,63@2874L176,70@3088L138,70@3056L170,77@3287L1123,77@3233L1178:RegisterScreen.kt#oif8tm");
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
                if ((i2 & 4) != 0) {
                    i6 = 128;
                } else {
                    if ((i & 512) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(registerViewModel3);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(registerViewModel3);
                    }
                    if (zChangedInstance) {
                        i6 = 256;
                    } else {
                        i6 = 128;
                    }
                }
                i3 |= i6;
            }
            i4 = i3;
            if ((i4 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "45@2114L15");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i8 != 0) {
                        navHostController4 = null;
                    } else {
                        navHostController4 = navHostController2;
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
                        ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(RegisterViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        RegisterViewModel registerViewModel4 = (RegisterViewModel) viewModel;
                        i4 &= -897;
                        actorCoroutine = null;
                        registerViewModel3 = registerViewModel4;
                        modifier4 = companion;
                        i5 = 1;
                    } else {
                        actorCoroutine = null;
                        i5 = 1;
                        modifier4 = companion;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i4 &= -897;
                    }
                    modifier4 = modifier2;
                    navHostController4 = navHostController2;
                    actorCoroutine = null;
                    i5 = 1;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1966898041, i4, -1, "com.example.bingwahybrid.presentation.ui.screens.RegisterScreen (RegisterScreen.kt:46)");
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
                stateCollectAsState = SnapshotStateKt.collectAsState(registerViewModel3.getRegisterSuccess(), actorCoroutine, composerStartRestartGroup, 0, i5);
                stateCollectAsState2 = SnapshotStateKt.collectAsState(registerViewModel3.getSnackbarMessage(), actorCoroutine, composerStartRestartGroup, 0, i5);
                final State stateCollectAsState4 = SnapshotStateKt.collectAsState(registerViewModel3.isLoading(), actorCoroutine, composerStartRestartGroup, 0, i5);
                final State stateCollectAsState5 = SnapshotStateKt.collectAsState(registerViewModel3.getFirstName(), actorCoroutine, composerStartRestartGroup, 0, i5);
                final State stateCollectAsState6 = SnapshotStateKt.collectAsState(registerViewModel3.getLastName(), actorCoroutine, composerStartRestartGroup, 0, i5);
                final State stateCollectAsState7 = SnapshotStateKt.collectAsState(registerViewModel3.getPhoneNumber(), actorCoroutine, composerStartRestartGroup, 0, i5);
                stateCollectAsState3 = SnapshotStateKt.collectAsState(registerViewModel3.getEmail(), actorCoroutine, composerStartRestartGroup, 0, i5);
                final State stateCollectAsState8 = SnapshotStateKt.collectAsState(registerViewModel3.getFirstNameError(), actorCoroutine, composerStartRestartGroup, 0, i5);
                final State stateCollectAsState9 = SnapshotStateKt.collectAsState(registerViewModel3.getLastNameError(), actorCoroutine, composerStartRestartGroup, 0, i5);
                final State stateCollectAsState10 = SnapshotStateKt.collectAsState(registerViewModel3.getPhoneNumberError(), actorCoroutine, composerStartRestartGroup, 0, i5);
                final State stateCollectAsState11 = SnapshotStateKt.collectAsState(registerViewModel3.getEmailError(), actorCoroutine, composerStartRestartGroup, 0, i5);
                String strRegisterScreen$lambda$1 = RegisterScreen$lambda$1(stateCollectAsState2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -403376937, "CC(remember):RegisterScreen.kt#9igjgp");
                zChanged = ((((i4 & 896) ^ 384) <= 256 && composerStartRestartGroup.changedInstance(registerViewModel3)) || (i4 & 384) == 256) | composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope);
                registerScreenKt$RegisterScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || registerScreenKt$RegisterScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    registerScreenKt$RegisterScreen$1$1RememberedValue = new RegisterScreenKt$RegisterScreen$1$1(stateCollectAsState2, coroutineScope, registerViewModel3, actorCoroutine);
                    composerStartRestartGroup.updateRememberedValue(registerScreenKt$RegisterScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strRegisterScreen$lambda$1, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) registerScreenKt$RegisterScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                Boolean boolValueOf = Boolean.valueOf(RegisterScreen$lambda$0(stateCollectAsState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -403371119, "CC(remember):RegisterScreen.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(navHostController4) | composerStartRestartGroup.changed(stateCollectAsState3);
                registerScreenKt$RegisterScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged2 || registerScreenKt$RegisterScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    registerScreenKt$RegisterScreen$2$1RememberedValue = new RegisterScreenKt$RegisterScreen$2$1(navHostController4, stateCollectAsState, stateCollectAsState3, actorCoroutine);
                    composerStartRestartGroup.updateRememberedValue(registerScreenKt$RegisterScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) registerScreenKt$RegisterScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                final RegisterViewModel registerViewModel5 = registerViewModel3;
                final NavHostController navHostController5 = navHostController4;
                Modifier modifier5 = modifier4;
                ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, actorCoroutine), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(370991384, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return RegisterScreenKt.RegisterScreen$lambda$28(modifier4, registerViewModel5, navHostController5, stateCollectAsState5, stateCollectAsState6, stateCollectAsState7, stateCollectAsState3, stateCollectAsState4, stateCollectAsState8, stateCollectAsState9, stateCollectAsState10, stateCollectAsState11, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306374, 510);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                navHostController3 = navHostController4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                navHostController3 = navHostController2;
            }
            registerViewModel2 = registerViewModel3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RegisterScreenKt.RegisterScreen$lambda$29(modifier3, navHostController3, registerViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        navHostController2 = navHostController;
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i6 = 128;
            } else {
                if ((i & 512) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(registerViewModel3);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(registerViewModel3);
                }
                if (zChangedInstance) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
            }
            i3 |= i6;
        }
        i4 = i3;
        if ((i4 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "45@2114L15");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i8 != 0) {
                    navHostController4 = null;
                } else {
                    navHostController4 = navHostController2;
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
                    ViewModel viewModel2 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(RegisterViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory2, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    RegisterViewModel registerViewModel6 = (RegisterViewModel) viewModel2;
                    i4 &= -897;
                    actorCoroutine = null;
                    registerViewModel3 = registerViewModel6;
                    modifier4 = companion;
                    i5 = 1;
                } else {
                    actorCoroutine = null;
                    i5 = 1;
                    modifier4 = companion;
                }
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i8 != 0) {
                    navHostController4 = null;
                } else {
                    navHostController4 = navHostController2;
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
                    ViewModel viewModel3 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(RegisterViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory3, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    RegisterViewModel registerViewModel7 = (RegisterViewModel) viewModel3;
                    i4 &= -897;
                    actorCoroutine = null;
                    registerViewModel3 = registerViewModel7;
                    modifier4 = companion;
                    i5 = 1;
                } else {
                    actorCoroutine = null;
                    i5 = 1;
                    modifier4 = companion;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1966898041, i4, -1, "com.example.bingwahybrid.presentation.ui.screens.RegisterScreen (RegisterScreen.kt:46)");
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
            stateCollectAsState = SnapshotStateKt.collectAsState(registerViewModel3.getRegisterSuccess(), actorCoroutine, composerStartRestartGroup, 0, i5);
            stateCollectAsState2 = SnapshotStateKt.collectAsState(registerViewModel3.getSnackbarMessage(), actorCoroutine, composerStartRestartGroup, 0, i5);
            final State stateCollectAsState12 = SnapshotStateKt.collectAsState(registerViewModel3.isLoading(), actorCoroutine, composerStartRestartGroup, 0, i5);
            final State stateCollectAsState13 = SnapshotStateKt.collectAsState(registerViewModel3.getFirstName(), actorCoroutine, composerStartRestartGroup, 0, i5);
            final State stateCollectAsState14 = SnapshotStateKt.collectAsState(registerViewModel3.getLastName(), actorCoroutine, composerStartRestartGroup, 0, i5);
            final State stateCollectAsState15 = SnapshotStateKt.collectAsState(registerViewModel3.getPhoneNumber(), actorCoroutine, composerStartRestartGroup, 0, i5);
            stateCollectAsState3 = SnapshotStateKt.collectAsState(registerViewModel3.getEmail(), actorCoroutine, composerStartRestartGroup, 0, i5);
            final State stateCollectAsState16 = SnapshotStateKt.collectAsState(registerViewModel3.getFirstNameError(), actorCoroutine, composerStartRestartGroup, 0, i5);
            final State stateCollectAsState17 = SnapshotStateKt.collectAsState(registerViewModel3.getLastNameError(), actorCoroutine, composerStartRestartGroup, 0, i5);
            final State stateCollectAsState18 = SnapshotStateKt.collectAsState(registerViewModel3.getPhoneNumberError(), actorCoroutine, composerStartRestartGroup, 0, i5);
            final State stateCollectAsState19 = SnapshotStateKt.collectAsState(registerViewModel3.getEmailError(), actorCoroutine, composerStartRestartGroup, 0, i5);
            String strRegisterScreen$lambda$2 = RegisterScreen$lambda$1(stateCollectAsState2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -403376937, "CC(remember):RegisterScreen.kt#9igjgp");
            zChanged = ((((i4 & 896) ^ 384) <= 256 && composerStartRestartGroup.changedInstance(registerViewModel3)) || (i4 & 384) == 256) | composerStartRestartGroup.changed(stateCollectAsState2) | composerStartRestartGroup.changedInstance(coroutineScope);
            registerScreenKt$RegisterScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                registerScreenKt$RegisterScreen$1$1RememberedValue = new RegisterScreenKt$RegisterScreen$1$1(stateCollectAsState2, coroutineScope, registerViewModel3, actorCoroutine);
                composerStartRestartGroup.updateRememberedValue(registerScreenKt$RegisterScreen$1$1RememberedValue);
            } else {
                registerScreenKt$RegisterScreen$1$1RememberedValue = new RegisterScreenKt$RegisterScreen$1$1(stateCollectAsState2, coroutineScope, registerViewModel3, actorCoroutine);
                composerStartRestartGroup.updateRememberedValue(registerScreenKt$RegisterScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strRegisterScreen$lambda$2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) registerScreenKt$RegisterScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            Boolean boolValueOf2 = Boolean.valueOf(RegisterScreen$lambda$0(stateCollectAsState));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -403371119, "CC(remember):RegisterScreen.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(stateCollectAsState) | composerStartRestartGroup.changedInstance(navHostController4) | composerStartRestartGroup.changed(stateCollectAsState3);
            registerScreenKt$RegisterScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                registerScreenKt$RegisterScreen$2$1RememberedValue = new RegisterScreenKt$RegisterScreen$2$1(navHostController4, stateCollectAsState, stateCollectAsState3, actorCoroutine);
                composerStartRestartGroup.updateRememberedValue(registerScreenKt$RegisterScreen$2$1RememberedValue);
            } else {
                registerScreenKt$RegisterScreen$2$1RememberedValue = new RegisterScreenKt$RegisterScreen$2$1(navHostController4, stateCollectAsState, stateCollectAsState3, actorCoroutine);
                composerStartRestartGroup.updateRememberedValue(registerScreenKt$RegisterScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) registerScreenKt$RegisterScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            final RegisterViewModel registerViewModel8 = registerViewModel3;
            final NavHostController navHostController6 = navHostController4;
            Modifier modifier6 = modifier4;
            ScaffoldKt.m3481ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, actorCoroutine), null, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(370991384, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RegisterScreenKt.RegisterScreen$lambda$28(modifier4, registerViewModel8, navHostController6, stateCollectAsState13, stateCollectAsState14, stateCollectAsState15, stateCollectAsState3, stateCollectAsState12, stateCollectAsState16, stateCollectAsState17, stateCollectAsState18, stateCollectAsState19, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306374, 510);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
            navHostController3 = navHostController4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            navHostController3 = navHostController2;
        }
        registerViewModel2 = registerViewModel3;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RegisterScreenKt.RegisterScreen$lambda$29(modifier3, navHostController3, registerViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:62:0x020f  */
    /* JADX WARN: Code duplicated, block: B:67:0x0234  */
    /* JADX WARN: Code duplicated, block: B:70:0x0278  */
    public static final Unit RegisterScreen$lambda$28(Modifier modifier, final RegisterViewModel registerViewModel, final NavHostController navHostController, State state, State state2, State state3, State state4, State state5, State state6, State state7, State state8, State state9, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        String str;
        boolean zChangedInstance;
        Object objRememberedValue;
        boolean zChangedInstance2;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)78@3314L1090:RegisterScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(370991384, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.RegisterScreen.<anonymous> (RegisterScreen.kt:78)");
            }
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(PaddingKt.padding(modifier, paddingValues), Dp.m8684constructorimpl(20));
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
            ComposerKt.sourceInformationMarkerStart(composer, -2129401403, "C93@3889L36,94@3963L35,95@4039L38,96@4112L32,97@4175L53,99@4269L34,100@4335L45,83@3450L944:RegisterScreen.kt#oif8tm");
            String strRegisterScreen$lambda$3 = RegisterScreen$lambda$3(state);
            String strRegisterScreen$lambda$4 = RegisterScreen$lambda$4(state2);
            String strRegisterScreen$lambda$5 = RegisterScreen$lambda$5(state3);
            String strRegisterScreen$lambda$6 = RegisterScreen$lambda$6(state4);
            boolean zRegisterScreen$lambda$2 = RegisterScreen$lambda$2(state5);
            String strRegisterScreen$lambda$7 = RegisterScreen$lambda$7(state6);
            String strRegisterScreen$lambda$8 = RegisterScreen$lambda$8(state7);
            String strRegisterScreen$lambda$9 = RegisterScreen$lambda$9(state8);
            String strRegisterScreen$lambda$10 = RegisterScreen$lambda$10(state9);
            ComposerKt.sourceInformationMarkerStart(composer, 2009532754, "CC(remember):RegisterScreen.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(registerViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.RegisterScreen$lambda$28$lambda$27$lambda$14$lambda$13(registerViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function1 function1 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 2009535121, "CC(remember):RegisterScreen.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(registerViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.RegisterScreen$lambda$28$lambda$27$lambda$16$lambda$15(registerViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function2 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 2009537556, "CC(remember):RegisterScreen.kt#9igjgp");
            boolean zChangedInstance5 = composer.changedInstance(registerViewModel);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.RegisterScreen$lambda$28$lambda$27$lambda$18$lambda$17(registerViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Function1 function3 = (Function1) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 2009539886, "CC(remember):RegisterScreen.kt#9igjgp");
            boolean zChangedInstance6 = composer.changedInstance(registerViewModel);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.RegisterScreen$lambda$28$lambda$27$lambda$20$lambda$19(registerViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            Function1 function4 = (Function1) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 2009541923, "CC(remember):RegisterScreen.kt#9igjgp");
            boolean zChangedInstance7 = composer.changedInstance(registerViewModel);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance7) {
                str = strRegisterScreen$lambda$4;
            } else {
                str = strRegisterScreen$lambda$4;
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                }
                Function0 function0 = (Function0) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 2009544912, "CC(remember):RegisterScreen.kt#9igjgp");
                zChangedInstance = composer.changedInstance(registerViewModel);
                objRememberedValue = composer.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RegisterScreenKt.RegisterScreen$lambda$28$lambda$27$lambda$24$lambda$23(registerViewModel);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function5 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 2009547035, "CC(remember):RegisterScreen.kt#9igjgp");
                zChangedInstance2 = composer.changedInstance(navHostController);
                objRememberedValue2 = composer.rememberedValue();
                if (!zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RegisterScreenKt.RegisterScreen$lambda$28$lambda$27$lambda$26$lambda$25(navHostController);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                RegisterScreenContent(strRegisterScreen$lambda$3, str, strRegisterScreen$lambda$5, strRegisterScreen$lambda$6, zRegisterScreen$lambda$2, strRegisterScreen$lambda$7, strRegisterScreen$lambda$8, strRegisterScreen$lambda$9, strRegisterScreen$lambda$10, function1, function2, function3, function4, function0, function5, (Function0) objRememberedValue2, composer, 0, 0, 0);
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
            objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return RegisterScreenKt.RegisterScreen$lambda$28$lambda$27$lambda$22$lambda$21(registerViewModel);
                }
            };
            composer.updateRememberedValue(objRememberedValue7);
            Function0 function6 = (Function0) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 2009544912, "CC(remember):RegisterScreen.kt#9igjgp");
            zChangedInstance = composer.changedInstance(registerViewModel);
            objRememberedValue = composer.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RegisterScreenKt.RegisterScreen$lambda$28$lambda$27$lambda$24$lambda$23(registerViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RegisterScreenKt.RegisterScreen$lambda$28$lambda$27$lambda$24$lambda$23(registerViewModel);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function7 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 2009547035, "CC(remember):RegisterScreen.kt#9igjgp");
            zChangedInstance2 = composer.changedInstance(navHostController);
            objRememberedValue2 = composer.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RegisterScreenKt.RegisterScreen$lambda$28$lambda$27$lambda$26$lambda$25(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RegisterScreenKt.RegisterScreen$lambda$28$lambda$27$lambda$26$lambda$25(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            RegisterScreenContent(strRegisterScreen$lambda$3, str, strRegisterScreen$lambda$5, strRegisterScreen$lambda$6, zRegisterScreen$lambda$2, strRegisterScreen$lambda$7, strRegisterScreen$lambda$8, strRegisterScreen$lambda$9, strRegisterScreen$lambda$10, function1, function2, function3, function4, function6, function7, (Function0) objRememberedValue2, composer, 0, 0, 0);
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
    public static final Unit RegisterScreen$lambda$28$lambda$27$lambda$14$lambda$13(RegisterViewModel registerViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        registerViewModel.onFirstNameChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RegisterScreen$lambda$28$lambda$27$lambda$16$lambda$15(RegisterViewModel registerViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        registerViewModel.onLastNameChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RegisterScreen$lambda$28$lambda$27$lambda$18$lambda$17(RegisterViewModel registerViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        registerViewModel.onPhoneNumberChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RegisterScreen$lambda$28$lambda$27$lambda$20$lambda$19(RegisterViewModel registerViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        registerViewModel.onEmailChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RegisterScreen$lambda$28$lambda$27$lambda$22$lambda$21(RegisterViewModel registerViewModel) {
        registerViewModel.register();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RegisterScreen$lambda$28$lambda$27$lambda$24$lambda$23(RegisterViewModel registerViewModel) {
        registerViewModel.registerWithGoogle();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RegisterScreen$lambda$28$lambda$27$lambda$26$lambda$25(NavHostController navHostController) {
        if (navHostController != null) {
            NavController.navigate$default((NavController) navHostController, Route.Login.INSTANCE.getName(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0167  */
    /* JADX WARN: Code duplicated, block: B:102:0x016d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0170  */
    /* JADX WARN: Code duplicated, block: B:107:0x0178  */
    /* JADX WARN: Code duplicated, block: B:109:0x017e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0186  */
    /* JADX WARN: Code duplicated, block: B:115:0x018c  */
    /* JADX WARN: Code duplicated, block: B:116:0x018f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0197  */
    /* JADX WARN: Code duplicated, block: B:122:0x019d  */
    /* JADX WARN: Code duplicated, block: B:123:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:127:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:131:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:135:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:137:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:138:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:140:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:141:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:144:0x01db  */
    /* JADX WARN: Code duplicated, block: B:146:0x01df  */
    /* JADX WARN: Code duplicated, block: B:147:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:150:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:152:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:154:0x020d  */
    /* JADX WARN: Code duplicated, block: B:157:0x0215  */
    /* JADX WARN: Code duplicated, block: B:160:0x0274  */
    /* JADX WARN: Code duplicated, block: B:163:0x0280  */
    /* JADX WARN: Code duplicated, block: B:164:0x0284  */
    /* JADX WARN: Code duplicated, block: B:167:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:169:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:172:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:175:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:176:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:179:0x0405  */
    /* JADX WARN: Code duplicated, block: B:181:0x0413  */
    /* JADX WARN: Code duplicated, block: B:184:0x0442  */
    /* JADX WARN: Code duplicated, block: B:185:0x0444  */
    /* JADX WARN: Code duplicated, block: B:188:0x0464  */
    /* JADX WARN: Code duplicated, block: B:189:0x0466  */
    /* JADX WARN: Code duplicated, block: B:192:0x046d  */
    /* JADX WARN: Code duplicated, block: B:194:0x0475  */
    /* JADX WARN: Code duplicated, block: B:197:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:198:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:201:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:202:0x04db  */
    /* JADX WARN: Code duplicated, block: B:205:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:207:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:210:0x0532  */
    /* JADX WARN: Code duplicated, block: B:211:0x0534  */
    /* JADX WARN: Code duplicated, block: B:214:0x0550  */
    /* JADX WARN: Code duplicated, block: B:215:0x0552  */
    /* JADX WARN: Code duplicated, block: B:218:0x0559  */
    /* JADX WARN: Code duplicated, block: B:222:0x0565  */
    /* JADX WARN: Code duplicated, block: B:225:0x059d  */
    /* JADX WARN: Code duplicated, block: B:226:0x059f  */
    /* JADX WARN: Code duplicated, block: B:229:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:230:0x05bf  */
    /* JADX WARN: Code duplicated, block: B:233:0x05c6  */
    /* JADX WARN: Code duplicated, block: B:237:0x05d2  */
    /* JADX WARN: Code duplicated, block: B:240:0x068c  */
    /* JADX WARN: Code duplicated, block: B:243:0x0698  */
    /* JADX WARN: Code duplicated, block: B:244:0x069c  */
    /* JADX WARN: Code duplicated, block: B:247:0x06c1  */
    /* JADX WARN: Code duplicated, block: B:249:0x06cf  */
    /* JADX WARN: Code duplicated, block: B:252:0x0793  */
    /* JADX WARN: Code duplicated, block: B:254:0x07a5  */
    /* JADX WARN: Code duplicated, block: B:257:0x07bc  */
    /* JADX WARN: Code duplicated, block: B:259:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:65:0x0102  */
    /* JADX WARN: Code duplicated, block: B:67:0x0106  */
    /* JADX WARN: Code duplicated, block: B:69:0x0110  */
    /* JADX WARN: Code duplicated, block: B:70:0x0113  */
    /* JADX WARN: Code duplicated, block: B:75:0x0122  */
    /* JADX WARN: Code duplicated, block: B:76:0x0125  */
    /* JADX WARN: Code duplicated, block: B:78:0x0129  */
    /* JADX WARN: Code duplicated, block: B:80:0x0133  */
    /* JADX WARN: Code duplicated, block: B:81:0x0136  */
    /* JADX WARN: Code duplicated, block: B:86:0x0145  */
    /* JADX WARN: Code duplicated, block: B:88:0x014b  */
    /* JADX WARN: Code duplicated, block: B:89:0x014e  */
    /* JADX WARN: Code duplicated, block: B:93:0x0156  */
    /* JADX WARN: Code duplicated, block: B:95:0x015c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0161  */
    public static final void RegisterScreenContent(final String firstName, final String lastName, final String phoneNumber, final String email, boolean z, String str, String str2, String str3, String str4, final Function1<? super String, Unit> onFirstNameChanged, final Function1<? super String, Unit> onLastNameChanged, final Function1<? super String, Unit> onPhoneNumberChanged, final Function1<? super String, Unit> onEmailChanged, final Function0<Unit> onRegister, Function0<Unit> function0, final Function0<Unit> onGoToLogin, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        boolean z2;
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
        boolean z3;
        final String str5;
        final String str6;
        final String str7;
        final Function0<Unit> function1;
        Composer composer2;
        final boolean z4;
        final String str8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str9;
        String str10;
        String str11;
        String str12;
        Function0<Unit> function2;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int iHashCode2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM5259constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean z5;
        boolean z6;
        Object objRememberedValue;
        boolean z7;
        boolean z8;
        Object objRememberedValue2;
        boolean z9;
        boolean z10;
        Object objRememberedValue3;
        boolean z11;
        boolean z12;
        Object objRememberedValue4;
        int iHashCode3;
        Function0<ComposeUiNode> constructor3;
        Composer composerM5259constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        Object objRememberedValue5;
        int i15;
        int i16;
        int i17;
        int i18;
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(onFirstNameChanged, "onFirstNameChanged");
        Intrinsics.checkNotNullParameter(onLastNameChanged, "onLastNameChanged");
        Intrinsics.checkNotNullParameter(onPhoneNumberChanged, "onPhoneNumberChanged");
        Intrinsics.checkNotNullParameter(onEmailChanged, "onEmailChanged");
        Intrinsics.checkNotNullParameter(onRegister, "onRegister");
        Intrinsics.checkNotNullParameter(onGoToLogin, "onGoToLogin");
        Composer composerStartRestartGroup = composer.startRestartGroup(-112538811);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RegisterScreenContent)N(firstName,lastName,phoneNumber,email,isLoading,firstNameError,lastNameError,phoneNumberError,emailError,onFirstNameChanged,onLastNameChanged,onPhoneNumberChanged,onEmailChanged,onRegister,onRegisterWithGoogle,onGoToLogin)122@4948L2,125@4989L3980:RegisterScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(firstName) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(lastName) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(phoneNumber) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(email) ? 2048 : 1024;
        }
        int i19 = i3 & 16;
        if (i19 == 0) {
            if ((i & 24576) == 0) {
                z2 = z;
                i4 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(str2)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(str3)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(str4)) {
                            i12 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(onFirstNameChanged)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i4 |= i18;
                    }
                    if ((i2 & 6) == 0) {
                        i13 = i2 | (composerStartRestartGroup.changedInstance(onLastNameChanged) ? 4 : 2);
                    } else {
                        i13 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(onPhoneNumberChanged)) {
                            i17 = 32;
                        } else {
                            i17 = 16;
                        }
                        i13 |= i17;
                    }
                    if ((i2 & 384) == 0) {
                        i13 |= composerStartRestartGroup.changedInstance(onEmailChanged) ? 256 : 128;
                    }
                    if ((i2 & 3072) == 0) {
                        if (composerStartRestartGroup.changedInstance(onRegister)) {
                            i16 = 2048;
                        } else {
                            i16 = 1024;
                        }
                        i13 |= i16;
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(onGoToLogin)) {
                            i15 = 131072;
                        } else {
                            i15 = 65536;
                        }
                        i13 |= i15;
                    }
                    i14 = i13;
                    if ((i4 & 306783379) == 306783378 || (66707 & i14) != 66706) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        str5 = str;
                        str6 = str2;
                        str7 = str4;
                        function1 = function0;
                        composer2 = composerStartRestartGroup;
                        z4 = z2;
                        str8 = str3;
                    } else {
                        if (i19 != 0) {
                            z2 = false;
                        }
                        if (i5 != 0) {
                            str9 = null;
                        } else {
                            str9 = str;
                        }
                        if (i7 != 0) {
                            str10 = null;
                        } else {
                            str10 = str2;
                        }
                        if (i9 != 0) {
                            str11 = null;
                        } else {
                            str11 = str3;
                        }
                        if (i11 != 0) {
                            str12 = null;
                        } else {
                            str12 = str4;
                        }
                        if ((i3 & 16384) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -775597913, "CC(remember):RegisterScreen.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function2 = (Function0) objRememberedValue5;
                        } else {
                            function2 = function0;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-112538811, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.RegisterScreenContent (RegisterScreen.kt:124)");
                        }
                        Alignment.Horizontal start = Alignment.INSTANCE.getStart();
                        Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, start, composerStartRestartGroup, 54);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -179615442, "C132@5237L10,133@5303L11,130@5149L244,137@5402L41,138@5452L779,160@6240L40,164@6406L28,161@6289L343,170@6641L40,174@6794L147,171@6690L437,183@7136L41,189@7309L882,185@7187L1004,213@8201L712,234@8922L41:RegisterScreen.kt#oif8tm");
                        TextKt.m3864TextNvy7gAk("Create an Account With Us", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composerStartRestartGroup, 6, 0, 131070);
                        float f = 16;
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        float f2 = 8;
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_4 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f2));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_4, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -650903453, "C145@5717L26,142@5592L310,154@6039L25,151@5916L305:RegisterScreen.kt#oif8tm");
                        if (str9 != null) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780121829, "CC(remember):RegisterScreen.kt#9igjgp");
                        if ((1879048192 & i4) == 536870912) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i20 = i4 >> 3;
                        int i21 = i4;
                        final boolean z13 = z2;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str9, 0, modifierWeight$default, false, composerStartRestartGroup, (i4 & 14) | 384 | (i20 & 57344), 160);
                        String str13 = str9;
                        if (str10 != null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780132132, "CC(remember):RegisterScreen.kt#9igjgp");
                        if ((i14 & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z8 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function3 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i22 = (i20 & 14) | 384;
                        int i23 = i21 >> 6;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, function3, "Last Name", z7, str10, 0, modifierWeight$default2, false, composerStartRestartGroup, i22 | (i23 & 57344), 160);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                        if (str11 != null) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        int iM8360getPhonePjHm6EE = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                        Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421399605, "CC(remember):RegisterScreen.kt#9igjgp");
                        if ((i14 & 112) == 32) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z10 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i24 = 1769856 | (i23 & 14);
                        int i25 = i21 >> 9;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str11, iM8360getPhonePjHm6EE, modifierFillMaxWidth$default2, false, composerStartRestartGroup, i24 | (i25 & 57344), 128);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                        if (str12 != null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        int iM8356getEmailPjHm6EE = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                        Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421387070, "CC(remember):RegisterScreen.kt#9igjgp");
                        if ((i14 & 896) == 256) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!z12 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        String str14 = str12;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str14, iM8356getEmailPjHm6EE, modifierFillMaxWidth$default3, false, composerStartRestartGroup, 1769856 | (i25 & 14) | ((i21 >> 12) & 57344), 128);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), composerStartRestartGroup, 6);
                        CustomButtonKt.CustomButton(onRegister, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-473116933, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$42(z13, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                        Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(end, centerVertically, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default4);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1154680270, "C219@8469L10,218@8390L114,222@8518L385:RegisterScreen.kt#oif8tm");
                        TextKt.m3864TextNvy7gAk("Already have an account?", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 6, 0, 131070);
                        ButtonKt.TextButton(onGoToLogin, null, false, null, null, null, null, null, null, ComposableSingletons$RegisterScreenKt.INSTANCE.getLambda$284261687$app_debug(), composerStartRestartGroup, ((i14 >> 15) & 14) | 805306368, 510);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = composerStartRestartGroup;
                        z4 = z13;
                        str7 = str14;
                        str6 = str10;
                        str8 = str11;
                        function1 = function2;
                        str5 = str13;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$45(firstName, lastName, phoneNumber, email, z4, str5, str6, str8, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onRegister, function1, onGoToLogin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(onFirstNameChanged)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i4 |= i18;
                }
                if ((i2 & 6) == 0) {
                    i13 = i2 | (composerStartRestartGroup.changedInstance(onLastNameChanged) ? 4 : 2);
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onPhoneNumberChanged)) {
                        i17 = 32;
                    } else {
                        i17 = 16;
                    }
                    i13 |= i17;
                }
                if ((i2 & 384) == 0) {
                    i13 |= composerStartRestartGroup.changedInstance(onEmailChanged) ? 256 : 128;
                }
                if ((i2 & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(onRegister)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i13 |= i16;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(onGoToLogin)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i13 |= i15;
                }
                i14 = i13;
                if ((i4 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str5 = str;
                    str6 = str2;
                    str7 = str4;
                    function1 = function0;
                    composer2 = composerStartRestartGroup;
                    z4 = z2;
                    str8 = str3;
                } else {
                    if (i19 != 0) {
                        z2 = false;
                    }
                    if (i5 != 0) {
                        str9 = null;
                    } else {
                        str9 = str;
                    }
                    if (i7 != 0) {
                        str10 = null;
                    } else {
                        str10 = str2;
                    }
                    if (i9 != 0) {
                        str11 = null;
                    } else {
                        str11 = str3;
                    }
                    if (i11 != 0) {
                        str12 = null;
                    } else {
                        str12 = str4;
                    }
                    if ((i3 & 16384) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -775597913, "CC(remember):RegisterScreen.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function2 = (Function0) objRememberedValue5;
                    } else {
                        function2 = function0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-112538811, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.RegisterScreenContent (RegisterScreen.kt:124)");
                    }
                    Alignment.Horizontal start2 = Alignment.INSTANCE.getStart();
                    Arrangement.Vertical top2 = Arrangement.INSTANCE.getTop();
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(top2, start2, composerStartRestartGroup, 54);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -179615442, "C132@5237L10,133@5303L11,130@5149L244,137@5402L41,138@5452L779,160@6240L40,164@6406L28,161@6289L343,170@6641L40,174@6794L147,171@6690L437,183@7136L41,189@7309L882,185@7187L1004,213@8201L712,234@8922L41:RegisterScreen.kt#oif8tm");
                    TextKt.m3864TextNvy7gAk("Create an Account With Us", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composerStartRestartGroup, 6, 0, 131070);
                    float f3 = 16;
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
                    Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    float f4 = 8;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_5 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f4));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_5, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default5);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -650903453, "C145@5717L26,142@5592L310,154@6039L25,151@5916L305:RegisterScreen.kt#oif8tm");
                    if (str9 != null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Modifier modifierWeight$default3 = RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780121829, "CC(remember):RegisterScreen.kt#9igjgp");
                    if ((1879048192 & i4) == 536870912) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i26 = i4 >> 3;
                    int i27 = i4;
                    final boolean z14 = z2;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str9, 0, modifierWeight$default3, false, composerStartRestartGroup, (i4 & 14) | 384 | (i26 & 57344), 160);
                    String str15 = str9;
                    if (str10 != null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierWeight$default4 = RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780132132, "CC(remember):RegisterScreen.kt#9igjgp");
                    if ((i14 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function4 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i28 = (i26 & 14) | 384;
                    int i29 = i27 >> 6;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, function4, "Last Name", z7, str10, 0, modifierWeight$default4, false, composerStartRestartGroup, i28 | (i29 & 57344), 160);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
                    if (str11 != null) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    int iM8360getPhonePjHm6EE2 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                    Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421399605, "CC(remember):RegisterScreen.kt#9igjgp");
                    if ((i14 & 112) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i210 = 1769856 | (i29 & 14);
                    int i211 = i27 >> 9;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str11, iM8360getPhonePjHm6EE2, modifierFillMaxWidth$default6, false, composerStartRestartGroup, i210 | (i211 & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
                    if (str12 != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    int iM8356getEmailPjHm6EE2 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                    Modifier modifierFillMaxWidth$default7 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421387070, "CC(remember):RegisterScreen.kt#9igjgp");
                    if ((i14 & 896) == 256) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z12) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str16 = str12;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str16, iM8356getEmailPjHm6EE2, modifierFillMaxWidth$default7, false, composerStartRestartGroup, 1769856 | (i211 & 14) | ((i27 >> 12) & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), composerStartRestartGroup, 6);
                    CustomButtonKt.CustomButton(onRegister, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-473116933, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$42(z14, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                    Modifier modifierFillMaxWidth$default8 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.Horizontal end2 = Arrangement.INSTANCE.getEnd();
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(end2, centerVertically2, composerStartRestartGroup, 54);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1154680270, "C219@8469L10,218@8390L114,222@8518L385:RegisterScreen.kt#oif8tm");
                    TextKt.m3864TextNvy7gAk("Already have an account?", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 6, 0, 131070);
                    ButtonKt.TextButton(onGoToLogin, null, false, null, null, null, null, null, null, ComposableSingletons$RegisterScreenKt.INSTANCE.getLambda$284261687$app_debug(), composerStartRestartGroup, ((i14 >> 15) & 14) | 805306368, 510);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    z4 = z14;
                    str7 = str16;
                    str6 = str10;
                    str8 = str11;
                    function1 = function2;
                    str5 = str15;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$45(firstName, lastName, phoneNumber, email, z4, str5, str6, str8, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onRegister, function1, onGoToLogin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 12582912;
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(str4)) {
                        i12 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(onFirstNameChanged)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i4 |= i18;
                }
                if ((i2 & 6) == 0) {
                    i13 = i2 | (composerStartRestartGroup.changedInstance(onLastNameChanged) ? 4 : 2);
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onPhoneNumberChanged)) {
                        i17 = 32;
                    } else {
                        i17 = 16;
                    }
                    i13 |= i17;
                }
                if ((i2 & 384) == 0) {
                    i13 |= composerStartRestartGroup.changedInstance(onEmailChanged) ? 256 : 128;
                }
                if ((i2 & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(onRegister)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i13 |= i16;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(onGoToLogin)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i13 |= i15;
                }
                i14 = i13;
                if ((i4 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str5 = str;
                    str6 = str2;
                    str7 = str4;
                    function1 = function0;
                    composer2 = composerStartRestartGroup;
                    z4 = z2;
                    str8 = str3;
                } else {
                    if (i19 != 0) {
                        z2 = false;
                    }
                    if (i5 != 0) {
                        str9 = null;
                    } else {
                        str9 = str;
                    }
                    if (i7 != 0) {
                        str10 = null;
                    } else {
                        str10 = str2;
                    }
                    if (i9 != 0) {
                        str11 = null;
                    } else {
                        str11 = str3;
                    }
                    if (i11 != 0) {
                        str12 = null;
                    } else {
                        str12 = str4;
                    }
                    if ((i3 & 16384) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -775597913, "CC(remember):RegisterScreen.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function2 = (Function0) objRememberedValue5;
                    } else {
                        function2 = function0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-112538811, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.RegisterScreenContent (RegisterScreen.kt:124)");
                    }
                    Alignment.Horizontal start3 = Alignment.INSTANCE.getStart();
                    Arrangement.Vertical top3 = Arrangement.INSTANCE.getTop();
                    Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(top3, start3, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default3);
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
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -179615442, "C132@5237L10,133@5303L11,130@5149L244,137@5402L41,138@5452L779,160@6240L40,164@6406L28,161@6289L343,170@6641L40,174@6794L147,171@6690L437,183@7136L41,189@7309L882,185@7187L1004,213@8201L712,234@8922L41:RegisterScreen.kt#oif8tm");
                    TextKt.m3864TextNvy7gAk("Create an Account With Us", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composerStartRestartGroup, 6, 0, 131070);
                    float f5 = 16;
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f5)), composerStartRestartGroup, 6);
                    Modifier modifierFillMaxWidth$default9 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    float f6 = 8;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_6 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f6));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_6, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default9);
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
                    Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl2.getInserting()) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    } else {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -650903453, "C145@5717L26,142@5592L310,154@6039L25,151@5916L305:RegisterScreen.kt#oif8tm");
                    if (str9 != null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Modifier modifierWeight$default5 = RowScope.weight$default(rowScopeInstance5, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780121829, "CC(remember):RegisterScreen.kt#9igjgp");
                    if ((1879048192 & i4) == 536870912) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i212 = i4 >> 3;
                    int i213 = i4;
                    final boolean z15 = z2;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str9, 0, modifierWeight$default5, false, composerStartRestartGroup, (i4 & 14) | 384 | (i212 & 57344), 160);
                    String str17 = str9;
                    if (str10 != null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierWeight$default6 = RowScope.weight$default(rowScopeInstance5, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780132132, "CC(remember):RegisterScreen.kt#9igjgp");
                    if ((i14 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function5 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i214 = (i212 & 14) | 384;
                    int i215 = i213 >> 6;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, function5, "Last Name", z7, str10, 0, modifierWeight$default6, false, composerStartRestartGroup, i214 | (i215 & 57344), 160);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f6)), composerStartRestartGroup, 6);
                    if (str11 != null) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    int iM8360getPhonePjHm6EE3 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                    Modifier modifierFillMaxWidth$default10 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421399605, "CC(remember):RegisterScreen.kt#9igjgp");
                    if ((i14 & 112) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i216 = 1769856 | (i215 & 14);
                    int i217 = i213 >> 9;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str11, iM8360getPhonePjHm6EE3, modifierFillMaxWidth$default10, false, composerStartRestartGroup, i216 | (i217 & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f6)), composerStartRestartGroup, 6);
                    if (str12 != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    int iM8356getEmailPjHm6EE3 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                    Modifier modifierFillMaxWidth$default11 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421387070, "CC(remember):RegisterScreen.kt#9igjgp");
                    if ((i14 & 896) == 256) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z12) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str18 = str12;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str18, iM8356getEmailPjHm6EE3, modifierFillMaxWidth$default11, false, composerStartRestartGroup, 1769856 | (i217 & 14) | ((i213 >> 12) & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), composerStartRestartGroup, 6);
                    CustomButtonKt.CustomButton(onRegister, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-473116933, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$42(z15, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                    Modifier modifierFillMaxWidth$default12 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.Horizontal end3 = Arrangement.INSTANCE.getEnd();
                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(end3, centerVertically3, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default12);
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
                    Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl3.getInserting()) {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    } else {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1154680270, "C219@8469L10,218@8390L114,222@8518L385:RegisterScreen.kt#oif8tm");
                    TextKt.m3864TextNvy7gAk("Already have an account?", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 6, 0, 131070);
                    ButtonKt.TextButton(onGoToLogin, null, false, null, null, null, null, null, null, ComposableSingletons$RegisterScreenKt.INSTANCE.getLambda$284261687$app_debug(), composerStartRestartGroup, ((i14 >> 15) & 14) | 805306368, 510);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f5)), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    z4 = z15;
                    str7 = str18;
                    str6 = str10;
                    str8 = str11;
                    function1 = function2;
                    str5 = str17;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$45(firstName, lastName, phoneNumber, email, z4, str5, str6, str8, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onRegister, function1, onGoToLogin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(onFirstNameChanged)) {
                    i18 = 536870912;
                } else {
                    i18 = 268435456;
                }
                i4 |= i18;
            }
            if ((i2 & 6) == 0) {
                i13 = i2 | (composerStartRestartGroup.changedInstance(onLastNameChanged) ? 4 : 2);
            } else {
                i13 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(onPhoneNumberChanged)) {
                    i17 = 32;
                } else {
                    i17 = 16;
                }
                i13 |= i17;
            }
            if ((i2 & 384) == 0) {
                i13 |= composerStartRestartGroup.changedInstance(onEmailChanged) ? 256 : 128;
            }
            if ((i2 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onRegister)) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i13 |= i16;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(onGoToLogin)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i13 |= i15;
            }
            i14 = i13;
            if ((i4 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str5 = str;
                str6 = str2;
                str7 = str4;
                function1 = function0;
                composer2 = composerStartRestartGroup;
                z4 = z2;
                str8 = str3;
            } else {
                if (i19 != 0) {
                    z2 = false;
                }
                if (i5 != 0) {
                    str9 = null;
                } else {
                    str9 = str;
                }
                if (i7 != 0) {
                    str10 = null;
                } else {
                    str10 = str2;
                }
                if (i9 != 0) {
                    str11 = null;
                } else {
                    str11 = str3;
                }
                if (i11 != 0) {
                    str12 = null;
                } else {
                    str12 = str4;
                }
                if ((i3 & 16384) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -775597913, "CC(remember):RegisterScreen.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function2 = (Function0) objRememberedValue5;
                } else {
                    function2 = function0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-112538811, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.RegisterScreenContent (RegisterScreen.kt:124)");
                }
                Alignment.Horizontal start4 = Alignment.INSTANCE.getStart();
                Arrangement.Vertical top4 = Arrangement.INSTANCE.getTop();
                Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(top4, start4, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default4);
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
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -179615442, "C132@5237L10,133@5303L11,130@5149L244,137@5402L41,138@5452L779,160@6240L40,164@6406L28,161@6289L343,170@6641L40,174@6794L147,171@6690L437,183@7136L41,189@7309L882,185@7187L1004,213@8201L712,234@8922L41:RegisterScreen.kt#oif8tm");
                TextKt.m3864TextNvy7gAk("Create an Account With Us", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composerStartRestartGroup, 6, 0, 131070);
                float f7 = 16;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f7)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default13 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                float f8 = 8;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_7 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f8));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_7, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default13);
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
                if (!composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -650903453, "C145@5717L26,142@5592L310,154@6039L25,151@5916L305:RegisterScreen.kt#oif8tm");
                if (str9 != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Modifier modifierWeight$default7 = RowScope.weight$default(rowScopeInstance7, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780121829, "CC(remember):RegisterScreen.kt#9igjgp");
                if ((1879048192 & i4) == 536870912) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i218 = i4 >> 3;
                int i219 = i4;
                final boolean z16 = z2;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str9, 0, modifierWeight$default7, false, composerStartRestartGroup, (i4 & 14) | 384 | (i218 & 57344), 160);
                String str19 = str9;
                if (str10 != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Modifier modifierWeight$default8 = RowScope.weight$default(rowScopeInstance7, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780132132, "CC(remember):RegisterScreen.kt#9igjgp");
                if ((i14 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function6 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2110 = (i218 & 14) | 384;
                int i2111 = i219 >> 6;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, function6, "Last Name", z7, str10, 0, modifierWeight$default8, false, composerStartRestartGroup, i2110 | (i2111 & 57344), 160);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f8)), composerStartRestartGroup, 6);
                if (str11 != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                int iM8360getPhonePjHm6EE4 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                Modifier modifierFillMaxWidth$default14 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421399605, "CC(remember):RegisterScreen.kt#9igjgp");
                if ((i14 & 112) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2112 = 1769856 | (i2111 & 14);
                int i2113 = i219 >> 9;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str11, iM8360getPhonePjHm6EE4, modifierFillMaxWidth$default14, false, composerStartRestartGroup, i2112 | (i2113 & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f8)), composerStartRestartGroup, 6);
                if (str12 != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                int iM8356getEmailPjHm6EE4 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                Modifier modifierFillMaxWidth$default15 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421387070, "CC(remember):RegisterScreen.kt#9igjgp");
                if ((i14 & 896) == 256) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z12) {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String str110 = str12;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str110, iM8356getEmailPjHm6EE4, modifierFillMaxWidth$default15, false, composerStartRestartGroup, 1769856 | (i2113 & 14) | ((i219 >> 12) & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), composerStartRestartGroup, 6);
                CustomButtonKt.CustomButton(onRegister, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-473116933, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$42(z16, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                Modifier modifierFillMaxWidth$default16 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.Horizontal end4 = Arrangement.INSTANCE.getEnd();
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(end4, centerVertically4, composerStartRestartGroup, 54);
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
                if (!composerM5259constructorimpl3.getInserting()) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                } else {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1154680270, "C219@8469L10,218@8390L114,222@8518L385:RegisterScreen.kt#oif8tm");
                TextKt.m3864TextNvy7gAk("Already have an account?", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 6, 0, 131070);
                ButtonKt.TextButton(onGoToLogin, null, false, null, null, null, null, null, null, ComposableSingletons$RegisterScreenKt.INSTANCE.getLambda$284261687$app_debug(), composerStartRestartGroup, ((i14 >> 15) & 14) | 805306368, 510);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f7)), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                z4 = z16;
                str7 = str110;
                str6 = str10;
                str8 = str11;
                function1 = function2;
                str5 = str19;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$45(firstName, lastName, phoneNumber, email, z4, str5, str6, str8, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onRegister, function1, onGoToLogin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        z2 = z;
        i5 = i3 & 32;
        if (i5 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(str)) {
                i6 = 131072;
            } else {
                i6 = 65536;
            }
            i4 |= i6;
        }
        i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(str2)) {
                i8 = 1048576;
            } else {
                i8 = 524288;
            }
            i4 |= i8;
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(str3)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(str4)) {
                        i12 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(onFirstNameChanged)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i4 |= i18;
                }
                if ((i2 & 6) == 0) {
                    i13 = i2 | (composerStartRestartGroup.changedInstance(onLastNameChanged) ? 4 : 2);
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(onPhoneNumberChanged)) {
                        i17 = 32;
                    } else {
                        i17 = 16;
                    }
                    i13 |= i17;
                }
                if ((i2 & 384) == 0) {
                    i13 |= composerStartRestartGroup.changedInstance(onEmailChanged) ? 256 : 128;
                }
                if ((i2 & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(onRegister)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i13 |= i16;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(onGoToLogin)) {
                        i15 = 131072;
                    } else {
                        i15 = 65536;
                    }
                    i13 |= i15;
                }
                i14 = i13;
                if ((i4 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str5 = str;
                    str6 = str2;
                    str7 = str4;
                    function1 = function0;
                    composer2 = composerStartRestartGroup;
                    z4 = z2;
                    str8 = str3;
                } else {
                    if (i19 != 0) {
                        z2 = false;
                    }
                    if (i5 != 0) {
                        str9 = null;
                    } else {
                        str9 = str;
                    }
                    if (i7 != 0) {
                        str10 = null;
                    } else {
                        str10 = str2;
                    }
                    if (i9 != 0) {
                        str11 = null;
                    } else {
                        str11 = str3;
                    }
                    if (i11 != 0) {
                        str12 = null;
                    } else {
                        str12 = str4;
                    }
                    if ((i3 & 16384) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -775597913, "CC(remember):RegisterScreen.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function2 = (Function0) objRememberedValue5;
                    } else {
                        function2 = function0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-112538811, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.RegisterScreenContent (RegisterScreen.kt:124)");
                    }
                    Alignment.Horizontal start5 = Alignment.INSTANCE.getStart();
                    Arrangement.Vertical top5 = Arrangement.INSTANCE.getTop();
                    Modifier modifierFillMaxSize$default5 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(top5, start5, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default5);
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
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -179615442, "C132@5237L10,133@5303L11,130@5149L244,137@5402L41,138@5452L779,160@6240L40,164@6406L28,161@6289L343,170@6641L40,174@6794L147,171@6690L437,183@7136L41,189@7309L882,185@7187L1004,213@8201L712,234@8922L41:RegisterScreen.kt#oif8tm");
                    TextKt.m3864TextNvy7gAk("Create an Account With Us", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composerStartRestartGroup, 6, 0, 131070);
                    float f9 = 16;
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f9)), composerStartRestartGroup, 6);
                    Modifier modifierFillMaxWidth$default17 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    float f10 = 8;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_8 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f10));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy9 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_8, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default17);
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
                    Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl2.getInserting()) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    } else {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance9 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -650903453, "C145@5717L26,142@5592L310,154@6039L25,151@5916L305:RegisterScreen.kt#oif8tm");
                    if (str9 != null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Modifier modifierWeight$default9 = RowScope.weight$default(rowScopeInstance9, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780121829, "CC(remember):RegisterScreen.kt#9igjgp");
                    if ((1879048192 & i4) == 536870912) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2114 = i4 >> 3;
                    int i2115 = i4;
                    final boolean z17 = z2;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str9, 0, modifierWeight$default9, false, composerStartRestartGroup, (i4 & 14) | 384 | (i2114 & 57344), 160);
                    String str111 = str9;
                    if (str10 != null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierWeight$default10 = RowScope.weight$default(rowScopeInstance9, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780132132, "CC(remember):RegisterScreen.kt#9igjgp");
                    if ((i14 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function7 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2116 = (i2114 & 14) | 384;
                    int i2117 = i2115 >> 6;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, function7, "Last Name", z7, str10, 0, modifierWeight$default10, false, composerStartRestartGroup, i2116 | (i2117 & 57344), 160);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f10)), composerStartRestartGroup, 6);
                    if (str11 != null) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    int iM8360getPhonePjHm6EE5 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                    Modifier modifierFillMaxWidth$default18 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421399605, "CC(remember):RegisterScreen.kt#9igjgp");
                    if ((i14 & 112) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2118 = 1769856 | (i2117 & 14);
                    int i2119 = i2115 >> 9;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str11, iM8360getPhonePjHm6EE5, modifierFillMaxWidth$default18, false, composerStartRestartGroup, i2118 | (i2119 & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f10)), composerStartRestartGroup, 6);
                    if (str12 != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    int iM8356getEmailPjHm6EE5 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                    Modifier modifierFillMaxWidth$default19 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421387070, "CC(remember):RegisterScreen.kt#9igjgp");
                    if ((i14 & 896) == 256) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z12) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str112 = str12;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str112, iM8356getEmailPjHm6EE5, modifierFillMaxWidth$default19, false, composerStartRestartGroup, 1769856 | (i2119 & 14) | ((i2115 >> 12) & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), composerStartRestartGroup, 6);
                    CustomButtonKt.CustomButton(onRegister, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-473116933, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$42(z17, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                    Modifier modifierFillMaxWidth$default110 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.Horizontal end5 = Arrangement.INSTANCE.getEnd();
                    Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy10 = RowKt.rowMeasurePolicy(end5, centerVertically5, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default110);
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
                    Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl3.getInserting()) {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    } else {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance10 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1154680270, "C219@8469L10,218@8390L114,222@8518L385:RegisterScreen.kt#oif8tm");
                    TextKt.m3864TextNvy7gAk("Already have an account?", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 6, 0, 131070);
                    ButtonKt.TextButton(onGoToLogin, null, false, null, null, null, null, null, null, ComposableSingletons$RegisterScreenKt.INSTANCE.getLambda$284261687$app_debug(), composerStartRestartGroup, ((i14 >> 15) & 14) | 805306368, 510);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f9)), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    z4 = z17;
                    str7 = str112;
                    str6 = str10;
                    str8 = str11;
                    function1 = function2;
                    str5 = str111;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$45(firstName, lastName, phoneNumber, email, z4, str5, str6, str8, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onRegister, function1, onGoToLogin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(onFirstNameChanged)) {
                    i18 = 536870912;
                } else {
                    i18 = 268435456;
                }
                i4 |= i18;
            }
            if ((i2 & 6) == 0) {
                i13 = i2 | (composerStartRestartGroup.changedInstance(onLastNameChanged) ? 4 : 2);
            } else {
                i13 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(onPhoneNumberChanged)) {
                    i17 = 32;
                } else {
                    i17 = 16;
                }
                i13 |= i17;
            }
            if ((i2 & 384) == 0) {
                i13 |= composerStartRestartGroup.changedInstance(onEmailChanged) ? 256 : 128;
            }
            if ((i2 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onRegister)) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i13 |= i16;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(onGoToLogin)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i13 |= i15;
            }
            i14 = i13;
            if ((i4 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str5 = str;
                str6 = str2;
                str7 = str4;
                function1 = function0;
                composer2 = composerStartRestartGroup;
                z4 = z2;
                str8 = str3;
            } else {
                if (i19 != 0) {
                    z2 = false;
                }
                if (i5 != 0) {
                    str9 = null;
                } else {
                    str9 = str;
                }
                if (i7 != 0) {
                    str10 = null;
                } else {
                    str10 = str2;
                }
                if (i9 != 0) {
                    str11 = null;
                } else {
                    str11 = str3;
                }
                if (i11 != 0) {
                    str12 = null;
                } else {
                    str12 = str4;
                }
                if ((i3 & 16384) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -775597913, "CC(remember):RegisterScreen.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function2 = (Function0) objRememberedValue5;
                } else {
                    function2 = function0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-112538811, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.RegisterScreenContent (RegisterScreen.kt:124)");
                }
                Alignment.Horizontal start6 = Alignment.INSTANCE.getStart();
                Arrangement.Vertical top6 = Arrangement.INSTANCE.getTop();
                Modifier modifierFillMaxSize$default6 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(top6, start6, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default6);
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
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -179615442, "C132@5237L10,133@5303L11,130@5149L244,137@5402L41,138@5452L779,160@6240L40,164@6406L28,161@6289L343,170@6641L40,174@6794L147,171@6690L437,183@7136L41,189@7309L882,185@7187L1004,213@8201L712,234@8922L41:RegisterScreen.kt#oif8tm");
                TextKt.m3864TextNvy7gAk("Create an Account With Us", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composerStartRestartGroup, 6, 0, 131070);
                float f11 = 16;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f11)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default111 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                float f12 = 8;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_9 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f12));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy11 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_9, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default111);
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
                if (!composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier17, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance11 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -650903453, "C145@5717L26,142@5592L310,154@6039L25,151@5916L305:RegisterScreen.kt#oif8tm");
                if (str9 != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Modifier modifierWeight$default11 = RowScope.weight$default(rowScopeInstance11, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780121829, "CC(remember):RegisterScreen.kt#9igjgp");
                if ((1879048192 & i4) == 536870912) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21110 = i4 >> 3;
                int i21111 = i4;
                final boolean z18 = z2;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str9, 0, modifierWeight$default11, false, composerStartRestartGroup, (i4 & 14) | 384 | (i21110 & 57344), 160);
                String str113 = str9;
                if (str10 != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Modifier modifierWeight$default12 = RowScope.weight$default(rowScopeInstance11, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780132132, "CC(remember):RegisterScreen.kt#9igjgp");
                if ((i14 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function8 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21112 = (i21110 & 14) | 384;
                int i21113 = i21111 >> 6;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, function8, "Last Name", z7, str10, 0, modifierWeight$default12, false, composerStartRestartGroup, i21112 | (i21113 & 57344), 160);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f12)), composerStartRestartGroup, 6);
                if (str11 != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                int iM8360getPhonePjHm6EE6 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                Modifier modifierFillMaxWidth$default112 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421399605, "CC(remember):RegisterScreen.kt#9igjgp");
                if ((i14 & 112) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21114 = 1769856 | (i21113 & 14);
                int i21115 = i21111 >> 9;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str11, iM8360getPhonePjHm6EE6, modifierFillMaxWidth$default112, false, composerStartRestartGroup, i21114 | (i21115 & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f12)), composerStartRestartGroup, 6);
                if (str12 != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                int iM8356getEmailPjHm6EE6 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                Modifier modifierFillMaxWidth$default113 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421387070, "CC(remember):RegisterScreen.kt#9igjgp");
                if ((i14 & 896) == 256) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z12) {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String str114 = str12;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str114, iM8356getEmailPjHm6EE6, modifierFillMaxWidth$default113, false, composerStartRestartGroup, 1769856 | (i21115 & 14) | ((i21111 >> 12) & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), composerStartRestartGroup, 6);
                CustomButtonKt.CustomButton(onRegister, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-473116933, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$42(z18, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                Modifier modifierFillMaxWidth$default114 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.Horizontal end6 = Arrangement.INSTANCE.getEnd();
                Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy12 = RowKt.rowMeasurePolicy(end6, centerVertically6, composerStartRestartGroup, 54);
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
                if (!composerM5259constructorimpl3.getInserting()) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                } else {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance12 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1154680270, "C219@8469L10,218@8390L114,222@8518L385:RegisterScreen.kt#oif8tm");
                TextKt.m3864TextNvy7gAk("Already have an account?", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 6, 0, 131070);
                ButtonKt.TextButton(onGoToLogin, null, false, null, null, null, null, null, null, ComposableSingletons$RegisterScreenKt.INSTANCE.getLambda$284261687$app_debug(), composerStartRestartGroup, ((i14 >> 15) & 14) | 805306368, 510);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f11)), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                z4 = z18;
                str7 = str114;
                str6 = str10;
                str8 = str11;
                function1 = function2;
                str5 = str113;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$45(firstName, lastName, phoneNumber, email, z4, str5, str6, str8, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onRegister, function1, onGoToLogin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 12582912;
        i11 = i3 & 256;
        if (i11 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(str4)) {
                    i12 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(onFirstNameChanged)) {
                    i18 = 536870912;
                } else {
                    i18 = 268435456;
                }
                i4 |= i18;
            }
            if ((i2 & 6) == 0) {
                i13 = i2 | (composerStartRestartGroup.changedInstance(onLastNameChanged) ? 4 : 2);
            } else {
                i13 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(onPhoneNumberChanged)) {
                    i17 = 32;
                } else {
                    i17 = 16;
                }
                i13 |= i17;
            }
            if ((i2 & 384) == 0) {
                i13 |= composerStartRestartGroup.changedInstance(onEmailChanged) ? 256 : 128;
            }
            if ((i2 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onRegister)) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i13 |= i16;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(onGoToLogin)) {
                    i15 = 131072;
                } else {
                    i15 = 65536;
                }
                i13 |= i15;
            }
            i14 = i13;
            if ((i4 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str5 = str;
                str6 = str2;
                str7 = str4;
                function1 = function0;
                composer2 = composerStartRestartGroup;
                z4 = z2;
                str8 = str3;
            } else {
                if (i19 != 0) {
                    z2 = false;
                }
                if (i5 != 0) {
                    str9 = null;
                } else {
                    str9 = str;
                }
                if (i7 != 0) {
                    str10 = null;
                } else {
                    str10 = str2;
                }
                if (i9 != 0) {
                    str11 = null;
                } else {
                    str11 = str3;
                }
                if (i11 != 0) {
                    str12 = null;
                } else {
                    str12 = str4;
                }
                if ((i3 & 16384) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -775597913, "CC(remember):RegisterScreen.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function2 = (Function0) objRememberedValue5;
                } else {
                    function2 = function0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-112538811, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.RegisterScreenContent (RegisterScreen.kt:124)");
                }
                Alignment.Horizontal start7 = Alignment.INSTANCE.getStart();
                Arrangement.Vertical top7 = Arrangement.INSTANCE.getTop();
                Modifier modifierFillMaxSize$default7 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(top7, start7, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default7);
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
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier19, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -179615442, "C132@5237L10,133@5303L11,130@5149L244,137@5402L41,138@5452L779,160@6240L40,164@6406L28,161@6289L343,170@6641L40,174@6794L147,171@6690L437,183@7136L41,189@7309L882,185@7187L1004,213@8201L712,234@8922L41:RegisterScreen.kt#oif8tm");
                TextKt.m3864TextNvy7gAk("Create an Account With Us", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composerStartRestartGroup, 6, 0, 131070);
                float f13 = 16;
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f13)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default115 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                float f14 = 8;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_10 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f14));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy13 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_10, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default115);
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
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance13 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -650903453, "C145@5717L26,142@5592L310,154@6039L25,151@5916L305:RegisterScreen.kt#oif8tm");
                if (str9 != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Modifier modifierWeight$default13 = RowScope.weight$default(rowScopeInstance13, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780121829, "CC(remember):RegisterScreen.kt#9igjgp");
                if ((1879048192 & i4) == 536870912) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21116 = i4 >> 3;
                int i21117 = i4;
                final boolean z19 = z2;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str9, 0, modifierWeight$default13, false, composerStartRestartGroup, (i4 & 14) | 384 | (i21116 & 57344), 160);
                String str115 = str9;
                if (str10 != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Modifier modifierWeight$default14 = RowScope.weight$default(rowScopeInstance13, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780132132, "CC(remember):RegisterScreen.kt#9igjgp");
                if ((i14 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function9 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21118 = (i21116 & 14) | 384;
                int i21119 = i21117 >> 6;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, function9, "Last Name", z7, str10, 0, modifierWeight$default14, false, composerStartRestartGroup, i21118 | (i21119 & 57344), 160);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f14)), composerStartRestartGroup, 6);
                if (str11 != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                int iM8360getPhonePjHm6EE7 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                Modifier modifierFillMaxWidth$default116 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421399605, "CC(remember):RegisterScreen.kt#9igjgp");
                if ((i14 & 112) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i211110 = 1769856 | (i21119 & 14);
                int i211111 = i21117 >> 9;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str11, iM8360getPhonePjHm6EE7, modifierFillMaxWidth$default116, false, composerStartRestartGroup, i211110 | (i211111 & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f14)), composerStartRestartGroup, 6);
                if (str12 != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                int iM8356getEmailPjHm6EE7 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                Modifier modifierFillMaxWidth$default117 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421387070, "CC(remember):RegisterScreen.kt#9igjgp");
                if ((i14 & 896) == 256) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z12) {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String str116 = str12;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str116, iM8356getEmailPjHm6EE7, modifierFillMaxWidth$default117, false, composerStartRestartGroup, 1769856 | (i211111 & 14) | ((i21117 >> 12) & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), composerStartRestartGroup, 6);
                CustomButtonKt.CustomButton(onRegister, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-473116933, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$42(z19, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                Modifier modifierFillMaxWidth$default118 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.Horizontal end7 = Arrangement.INSTANCE.getEnd();
                Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy14 = RowKt.rowMeasurePolicy(end7, centerVertically7, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default118);
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
                Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl3.getInserting()) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                } else {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier111, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance14 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1154680270, "C219@8469L10,218@8390L114,222@8518L385:RegisterScreen.kt#oif8tm");
                TextKt.m3864TextNvy7gAk("Already have an account?", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 6, 0, 131070);
                ButtonKt.TextButton(onGoToLogin, null, false, null, null, null, null, null, null, ComposableSingletons$RegisterScreenKt.INSTANCE.getLambda$284261687$app_debug(), composerStartRestartGroup, ((i14 >> 15) & 14) | 805306368, 510);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f13)), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                z4 = z19;
                str7 = str116;
                str6 = str10;
                str8 = str11;
                function1 = function2;
                str5 = str115;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$45(firstName, lastName, phoneNumber, email, z4, str5, str6, str8, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onRegister, function1, onGoToLogin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 100663296;
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(onFirstNameChanged)) {
                i18 = 536870912;
            } else {
                i18 = 268435456;
            }
            i4 |= i18;
        }
        if ((i2 & 6) == 0) {
            i13 = i2 | (composerStartRestartGroup.changedInstance(onLastNameChanged) ? 4 : 2);
        } else {
            i13 = i2;
        }
        if ((i2 & 48) == 0) {
            if (composerStartRestartGroup.changedInstance(onPhoneNumberChanged)) {
                i17 = 32;
            } else {
                i17 = 16;
            }
            i13 |= i17;
        }
        if ((i2 & 384) == 0) {
            i13 |= composerStartRestartGroup.changedInstance(onEmailChanged) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(onRegister)) {
                i16 = 2048;
            } else {
                i16 = 1024;
            }
            i13 |= i16;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(onGoToLogin)) {
                i15 = 131072;
            } else {
                i15 = 65536;
            }
            i13 |= i15;
        }
        i14 = i13;
        if ((i4 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            str5 = str;
            str6 = str2;
            str7 = str4;
            function1 = function0;
            composer2 = composerStartRestartGroup;
            z4 = z2;
            str8 = str3;
        } else {
            if (i19 != 0) {
                z2 = false;
            }
            if (i5 != 0) {
                str9 = null;
            } else {
                str9 = str;
            }
            if (i7 != 0) {
                str10 = null;
            } else {
                str10 = str2;
            }
            if (i9 != 0) {
                str11 = null;
            } else {
                str11 = str3;
            }
            if (i11 != 0) {
                str12 = null;
            } else {
                str12 = str4;
            }
            if ((i3 & 16384) != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -775597913, "CC(remember):RegisterScreen.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function2 = (Function0) objRememberedValue5;
            } else {
                function2 = function0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-112538811, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.RegisterScreenContent (RegisterScreen.kt:124)");
            }
            Alignment.Horizontal start8 = Alignment.INSTANCE.getStart();
            Arrangement.Vertical top8 = Arrangement.INSTANCE.getTop();
            Modifier modifierFillMaxSize$default8 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(top8, start8, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default8);
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
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl.getInserting()) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            } else {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier112, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -179615442, "C132@5237L10,133@5303L11,130@5149L244,137@5402L41,138@5452L779,160@6240L40,164@6406L28,161@6289L343,170@6641L40,174@6794L147,171@6690L437,183@7136L41,189@7309L882,185@7187L1004,213@8201L712,234@8922L41:RegisterScreen.kt#oif8tm");
            TextKt.m3864TextNvy7gAk("Create an Account With Us", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composerStartRestartGroup, 6, 0, 131070);
            float f15 = 16;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f15)), composerStartRestartGroup, 6);
            Modifier modifierFillMaxWidth$default119 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            float f16 = 8;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_11 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f16));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy15 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_11, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default119);
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
            if (!composerM5259constructorimpl2.getInserting()) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            } else {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier113, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance15 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -650903453, "C145@5717L26,142@5592L310,154@6039L25,151@5916L305:RegisterScreen.kt#oif8tm");
            if (str9 != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            Modifier modifierWeight$default15 = RowScope.weight$default(rowScopeInstance15, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780121829, "CC(remember):RegisterScreen.kt#9igjgp");
            if ((1879048192 & i4) == 536870912) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(onFirstNameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i211112 = i4 >> 3;
            int i211113 = i4;
            final boolean z110 = z2;
            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str9, 0, modifierWeight$default15, false, composerStartRestartGroup, (i4 & 14) | 384 | (i211112 & 57344), 160);
            String str117 = str9;
            if (str10 != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Modifier modifierWeight$default16 = RowScope.weight$default(rowScopeInstance15, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1780132132, "CC(remember):RegisterScreen.kt#9igjgp");
            if ((i14 & 14) == 4) {
                z8 = true;
            } else {
                z8 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z8) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(onLastNameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function10 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i211114 = (i211112 & 14) | 384;
            int i211115 = i211113 >> 6;
            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, function10, "Last Name", z7, str10, 0, modifierWeight$default16, false, composerStartRestartGroup, i211114 | (i211115 & 57344), 160);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f16)), composerStartRestartGroup, 6);
            if (str11 != null) {
                z9 = true;
            } else {
                z9 = false;
            }
            int iM8360getPhonePjHm6EE8 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
            Modifier modifierFillMaxWidth$default1110 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421399605, "CC(remember):RegisterScreen.kt#9igjgp");
            if ((i14 & 112) == 32) {
                z10 = true;
            } else {
                z10 = false;
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z10) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$38$lambda$37(onPhoneNumberChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i211116 = 1769856 | (i211115 & 14);
            int i211117 = i211113 >> 9;
            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str11, iM8360getPhonePjHm6EE8, modifierFillMaxWidth$default1110, false, composerStartRestartGroup, i211116 | (i211117 & 57344), 128);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f16)), composerStartRestartGroup, 6);
            if (str12 != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            int iM8356getEmailPjHm6EE8 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
            Modifier modifierFillMaxWidth$default1111 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -421387070, "CC(remember):RegisterScreen.kt#9igjgp");
            if ((i14 & 896) == 256) {
                z12 = true;
            } else {
                z12 = false;
            }
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!z12) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$40$lambda$39(onEmailChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String str118 = str12;
            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str118, iM8356getEmailPjHm6EE8, modifierFillMaxWidth$default1111, false, composerStartRestartGroup, 1769856 | (i211117 & 14) | ((i211113 >> 12) & 57344), 128);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), composerStartRestartGroup, 6);
            CustomButtonKt.CustomButton(onRegister, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-473116933, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RegisterScreenKt.RegisterScreenContent$lambda$44$lambda$42(z110, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
            Modifier modifierFillMaxWidth$default1112 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.Horizontal end8 = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy16 = RowKt.rowMeasurePolicy(end8, centerVertically8, composerStartRestartGroup, 54);
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
            if (!composerM5259constructorimpl3.getInserting()) {
                composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
            } else {
                composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
            }
            Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier114, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance16 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1154680270, "C219@8469L10,218@8390L114,222@8518L385:RegisterScreen.kt#oif8tm");
            TextKt.m3864TextNvy7gAk("Already have an account?", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 6, 0, 131070);
            ButtonKt.TextButton(onGoToLogin, null, false, null, null, null, null, null, null, ComposableSingletons$RegisterScreenKt.INSTANCE.getLambda$284261687$app_debug(), composerStartRestartGroup, ((i14 >> 15) & 14) | 805306368, 510);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f15)), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composerStartRestartGroup;
            z4 = z110;
            str7 = str118;
            str6 = str10;
            str8 = str11;
            function1 = function2;
            str5 = str117;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RegisterScreenKt.RegisterScreenContent$lambda$45(firstName, lastName, phoneNumber, email, z4, str5, str6, str8, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onRegister, function1, onGoToLogin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RegisterScreenContent$lambda$44$lambda$36$lambda$33$lambda$32(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RegisterScreenContent$lambda$44$lambda$36$lambda$35$lambda$34(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RegisterScreenContent$lambda$44$lambda$38$lambda$37(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RegisterScreenContent$lambda$44$lambda$40$lambda$39(Function1 function1, String newEmail) {
        Intrinsics.checkNotNullParameter(newEmail, "newEmail");
        String lowerCase = newEmail.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        function1.invoke(StringsKt.replace$default(lowerCase, ServerSentEventKt.SPACE, "", false, 4, (Object) null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RegisterScreenContent$lambda$44$lambda$42(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C190@7323L858:RegisterScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-473116933, i, -1, "com.example.bingwahybrid.presentation.ui.screens.RegisterScreenContent.<anonymous>.<anonymous> (RegisterScreen.kt:190)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1883266170, "C202@7809L10,203@7883L11,200@7675L492:RegisterScreen.kt#oif8tm");
            if (!z) {
                composer.startReplaceGroup(1875890029);
            } else {
                composer.startReplaceGroup(1883264805);
                ComposerKt.sourceInformation(composer, "194@7448L192");
                ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(boxScopeInstance.align(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(28)), Alignment.INSTANCE.getCenterStart()), 0L, 0.0f, 0L, 0, 0.0f, composer, 0, 62);
            }
            composer.endReplaceGroup();
            TextKt.m3864TextNvy7gAk(z ? "Creating Account..." : "Create Account", PaddingKt.m1119paddingVpY3zN4(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer, 0, 0, 131068);
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

    public static final void PreviewRegisterScreen(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1912678246);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewRegisterScreen)251@9343L2,252@9375L2,253@9410L2,254@9439L2,255@9464L2,256@9499L2,257@9525L2,241@9051L482:RegisterScreen.kt#oif8tm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1912678246, i, -1, "com.example.bingwahybrid.presentation.ui.screens.PreviewRegisterScreen (RegisterScreen.kt:240)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 162220124, "CC(remember):RegisterScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.PreviewRegisterScreen$lambda$47$lambda$46((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 162221148, "CC(remember):RegisterScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.PreviewRegisterScreen$lambda$49$lambda$48((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 162222268, "CC(remember):RegisterScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.PreviewRegisterScreen$lambda$51$lambda$50((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function3 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 162223196, "CC(remember):RegisterScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RegisterScreenKt.PreviewRegisterScreen$lambda$53$lambda$52((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function4 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 162223996, "CC(remember):RegisterScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function0 function0 = (Function0) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 162225116, "CC(remember):RegisterScreen.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Function0 function5 = (Function0) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 162225948, "CC(remember):RegisterScreen.kt#9igjgp");
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            RegisterScreenContent("", "", "", "", true, null, null, null, null, function1, function2, function3, function4, function0, function5, (Function0) objRememberedValue7, composer2, 920350134, 224694, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.RegisterScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RegisterScreenKt.PreviewRegisterScreen$lambda$60(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewRegisterScreen$lambda$47$lambda$46(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewRegisterScreen$lambda$49$lambda$48(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewRegisterScreen$lambda$51$lambda$50(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewRegisterScreen$lambda$53$lambda$52(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean RegisterScreen$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String RegisterScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    private static final boolean RegisterScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String RegisterScreen$lambda$3(State<String> state) {
        return state.getValue();
    }

    private static final String RegisterScreen$lambda$4(State<String> state) {
        return state.getValue();
    }

    private static final String RegisterScreen$lambda$5(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String RegisterScreen$lambda$6(State<String> state) {
        return state.getValue();
    }

    private static final String RegisterScreen$lambda$7(State<String> state) {
        return state.getValue();
    }

    private static final String RegisterScreen$lambda$8(State<String> state) {
        return state.getValue();
    }

    private static final String RegisterScreen$lambda$9(State<String> state) {
        return state.getValue();
    }

    private static final String RegisterScreen$lambda$10(State<String> state) {
        return state.getValue();
    }
}
