package com.example.bingwahybrid.presentation.ui.screens;

import androidx.autofill.HintConstants;
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
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
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
import com.example.bingwahybrid.presentation.viewmodel.EditProfileViewModel;
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

/* JADX INFO: compiled from: EditProfileScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aÓ\u0001\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00162\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001bH\u0007¢\u0006\u0002\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001f¨\u0006 ²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\f\u0010!\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\f\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\f\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002²\u0006\f\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002"}, d2 = {"EditProfileScreen", "", "modifier", "Landroidx/compose/ui/Modifier;", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/viewmodel/EditProfileViewModel;", "(Landroidx/compose/ui/Modifier;Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/viewmodel/EditProfileViewModel;Landroidx/compose/runtime/Composer;II)V", "EditProfileScreenContent", "firstName", "", "lastName", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "email", "isLoading", "", "firstNameError", "lastNameError", "phoneNumberError", "emailError", "onFirstNameChanged", "Lkotlin/Function1;", "onLastNameChanged", "onPhoneNumberChanged", "onEmailChanged", "onUpdate", "Lkotlin/Function0;", "onChangePin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "EditProfileScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "snackBarMessage"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EditProfileScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreen$lambda$29(Modifier modifier, NavHostController navHostController, EditProfileViewModel editProfileViewModel, int i, int i2, Composer composer, int i3) {
        EditProfileScreen(modifier, navHostController, editProfileViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreenContent$lambda$42(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function0 function0, Function0 function5, int i, int i2, int i3, Composer composer, int i4) {
        EditProfileScreenContent(str, str2, str3, str4, z, str5, str6, str7, str8, function1, function2, function3, function4, function0, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreenPreview$lambda$55(int i, Composer composer, int i2) {
        EditProfileScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

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
    /* JADX WARN: Code duplicated, block: B:87:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:90:0x023f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0245  */
    /* JADX WARN: Code duplicated, block: B:95:0x0251  */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v34, types: [kotlin.coroutines.Continuation, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
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
    public static final void EditProfileScreen(Modifier modifier, NavHostController navHostController, EditProfileViewModel editProfileViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        NavHostController navHostController2;
        int i4;
        boolean z;
        final NavHostController navHostController3;
        final Modifier modifier3;
        final EditProfileViewModel editProfileViewModel2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final NavHostController navHostController4;
        ?? r5;
        ?? r6;
        final Modifier modifier4;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        Object objRememberedValue;
        CoroutineScope coroutineScope;
        State stateCollectAsState;
        ?? r8;
        EditProfileScreenKt$EditProfileScreen$1$1 editProfileScreenKt$EditProfileScreen$1$1RememberedValue;
        int i5;
        boolean zChangedInstance;
        EditProfileViewModel editProfileViewModel3 = editProfileViewModel;
        Composer composerStartRestartGroup = composer.startRestartGroup(1526402543);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditProfileScreen)N(modifier,navController,viewModel)49@2271L24,50@2337L16,51@2407L16,53@2466L16,54@2522L16,55@2584L16,56@2634L16,58@2703L16,59@2769L16,60@2841L16,61@2901L16,63@2955L144,63@2923L176,71@3132L390,83@3529L1125,70@3105L1549:EditProfileScreen.kt#oif8tm");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                navHostController2 = navHostController;
                i3 |= composerStartRestartGroup.changedInstance(navHostController2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) != 0) {
                    i5 = 128;
                } else {
                    if ((i & 512) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(editProfileViewModel3);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(editProfileViewModel3);
                    }
                    if (zChangedInstance) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                }
                i3 |= i5;
            }
            i4 = i3;
            if ((i4 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "47@2234L15");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
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
                        ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(EditProfileViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EditProfileViewModel editProfileViewModel4 = (EditProfileViewModel) viewModel;
                        i4 &= -897;
                        r5 = 0;
                        editProfileViewModel3 = editProfileViewModel4;
                        modifier4 = companion;
                        r6 = 1;
                    } else {
                        r5 = 0;
                        r6 = 1;
                        modifier4 = companion;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i4 &= -897;
                    }
                    modifier4 = modifier2;
                    navHostController4 = navHostController2;
                    r5 = 0;
                    r6 = 1;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1526402543, i4, -1, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreen (EditProfileScreen.kt:48)");
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
                final State stateCollectAsState2 = SnapshotStateKt.collectAsState(editProfileViewModel3.isLoading(), r5, composerStartRestartGroup, 0, r6);
                stateCollectAsState = SnapshotStateKt.collectAsState(editProfileViewModel3.getSnackBarMessage(), r5, composerStartRestartGroup, 0, r6);
                final State stateCollectAsState3 = SnapshotStateKt.collectAsState(editProfileViewModel3.getFirstName(), r5, composerStartRestartGroup, 0, r6);
                final State stateCollectAsState4 = SnapshotStateKt.collectAsState(editProfileViewModel3.getLastName(), r5, composerStartRestartGroup, 0, r6);
                final State stateCollectAsState5 = SnapshotStateKt.collectAsState(editProfileViewModel3.getPhoneNumber(), r5, composerStartRestartGroup, 0, r6);
                final State stateCollectAsState6 = SnapshotStateKt.collectAsState(editProfileViewModel3.getEmail(), r5, composerStartRestartGroup, 0, r6);
                final State stateCollectAsState7 = SnapshotStateKt.collectAsState(editProfileViewModel3.getFirstNameError(), r5, composerStartRestartGroup, 0, r6);
                final State stateCollectAsState8 = SnapshotStateKt.collectAsState(editProfileViewModel3.getLastNameError(), r5, composerStartRestartGroup, 0, r6);
                final State stateCollectAsState9 = SnapshotStateKt.collectAsState(editProfileViewModel3.getPhoneNumberError(), r5, composerStartRestartGroup, 0, r6);
                final State stateCollectAsState10 = SnapshotStateKt.collectAsState(editProfileViewModel3.getEmailError(), r5, composerStartRestartGroup, 0, r6);
                String strEditProfileScreen$lambda$1 = EditProfileScreen$lambda$1(stateCollectAsState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2005941985, "CC(remember):EditProfileScreen.kt#9igjgp");
                r8 = (composerStartRestartGroup.changed(stateCollectAsState) ? 1 : 0) | (composerStartRestartGroup.changedInstance(coroutineScope) ? 1 : 0) | (((((i4 & 896) ^ 384) > 256 || !composerStartRestartGroup.changedInstance(editProfileViewModel3)) && (i4 & 384) != 256) ? 0 : r6);
                editProfileScreenKt$EditProfileScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (r8 == 0 || editProfileScreenKt$EditProfileScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    editProfileScreenKt$EditProfileScreen$1$1RememberedValue = new EditProfileScreenKt$EditProfileScreen$1$1(stateCollectAsState, coroutineScope, editProfileViewModel3, r5);
                    composerStartRestartGroup.updateRememberedValue(editProfileScreenKt$EditProfileScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strEditProfileScreen$lambda$1, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editProfileScreenKt$EditProfileScreen$1$1RememberedValue, composerStartRestartGroup, 0);
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(174347955, r6, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditProfileScreenKt.EditProfileScreen$lambda$14(navHostController4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                final EditProfileViewModel editProfileViewModel5 = editProfileViewModel3;
                final NavHostController navHostController5 = navHostController4;
                modifier2 = modifier4;
                ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1174553726, r6, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return EditProfileScreenKt.EditProfileScreen$lambda$28(modifier4, editProfileViewModel5, navHostController5, stateCollectAsState6, stateCollectAsState3, stateCollectAsState4, stateCollectAsState5, stateCollectAsState2, stateCollectAsState7, stateCollectAsState8, stateCollectAsState9, stateCollectAsState10, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navHostController3 = navHostController5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                navHostController3 = navHostController2;
            }
            modifier3 = modifier2;
            editProfileViewModel2 = editProfileViewModel3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditProfileScreenKt.EditProfileScreen$lambda$29(modifier3, navHostController3, editProfileViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        navHostController2 = navHostController;
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i5 = 128;
            } else {
                if ((i & 512) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(editProfileViewModel3);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(editProfileViewModel3);
                }
                if (zChangedInstance) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
            }
            i3 |= i5;
        }
        i4 = i3;
        if ((i4 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "47@2234L15");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
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
                    ViewModel viewModel2 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(EditProfileViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory2, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EditProfileViewModel editProfileViewModel6 = (EditProfileViewModel) viewModel2;
                    i4 &= -897;
                    r5 = 0;
                    editProfileViewModel3 = editProfileViewModel6;
                    modifier4 = companion;
                    r6 = 1;
                } else {
                    r5 = 0;
                    r6 = 1;
                    modifier4 = companion;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
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
                    ViewModel viewModel3 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(EditProfileViewModel.class), current, (String) null, factoryCreateHiltViewModelFactory3, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EditProfileViewModel editProfileViewModel7 = (EditProfileViewModel) viewModel3;
                    i4 &= -897;
                    r5 = 0;
                    editProfileViewModel3 = editProfileViewModel7;
                    modifier4 = companion;
                    r6 = 1;
                } else {
                    r5 = 0;
                    r6 = 1;
                    modifier4 = companion;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1526402543, i4, -1, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreen (EditProfileScreen.kt:48)");
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
            final State stateCollectAsState11 = SnapshotStateKt.collectAsState(editProfileViewModel3.isLoading(), r5, composerStartRestartGroup, 0, r6);
            stateCollectAsState = SnapshotStateKt.collectAsState(editProfileViewModel3.getSnackBarMessage(), r5, composerStartRestartGroup, 0, r6);
            final State stateCollectAsState12 = SnapshotStateKt.collectAsState(editProfileViewModel3.getFirstName(), r5, composerStartRestartGroup, 0, r6);
            final State stateCollectAsState13 = SnapshotStateKt.collectAsState(editProfileViewModel3.getLastName(), r5, composerStartRestartGroup, 0, r6);
            final State stateCollectAsState14 = SnapshotStateKt.collectAsState(editProfileViewModel3.getPhoneNumber(), r5, composerStartRestartGroup, 0, r6);
            final State stateCollectAsState15 = SnapshotStateKt.collectAsState(editProfileViewModel3.getEmail(), r5, composerStartRestartGroup, 0, r6);
            final State stateCollectAsState16 = SnapshotStateKt.collectAsState(editProfileViewModel3.getFirstNameError(), r5, composerStartRestartGroup, 0, r6);
            final State stateCollectAsState17 = SnapshotStateKt.collectAsState(editProfileViewModel3.getLastNameError(), r5, composerStartRestartGroup, 0, r6);
            final State stateCollectAsState18 = SnapshotStateKt.collectAsState(editProfileViewModel3.getPhoneNumberError(), r5, composerStartRestartGroup, 0, r6);
            final State stateCollectAsState19 = SnapshotStateKt.collectAsState(editProfileViewModel3.getEmailError(), r5, composerStartRestartGroup, 0, r6);
            String strEditProfileScreen$lambda$2 = EditProfileScreen$lambda$1(stateCollectAsState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2005941985, "CC(remember):EditProfileScreen.kt#9igjgp");
            r8 = (composerStartRestartGroup.changed(stateCollectAsState) ? 1 : 0) | (composerStartRestartGroup.changedInstance(coroutineScope) ? 1 : 0) | (((((i4 & 896) ^ 384) > 256 || !composerStartRestartGroup.changedInstance(editProfileViewModel3)) && (i4 & 384) != 256) ? 0 : r6);
            editProfileScreenKt$EditProfileScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (r8 == 0) {
                editProfileScreenKt$EditProfileScreen$1$1RememberedValue = new EditProfileScreenKt$EditProfileScreen$1$1(stateCollectAsState, coroutineScope, editProfileViewModel3, r5);
                composerStartRestartGroup.updateRememberedValue(editProfileScreenKt$EditProfileScreen$1$1RememberedValue);
            } else {
                editProfileScreenKt$EditProfileScreen$1$1RememberedValue = new EditProfileScreenKt$EditProfileScreen$1$1(stateCollectAsState, coroutineScope, editProfileViewModel3, r5);
                composerStartRestartGroup.updateRememberedValue(editProfileScreenKt$EditProfileScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strEditProfileScreen$lambda$2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) editProfileScreenKt$EditProfileScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(174347955, r6, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditProfileScreenKt.EditProfileScreen$lambda$14(navHostController4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            final EditProfileViewModel editProfileViewModel8 = editProfileViewModel3;
            final NavHostController navHostController6 = navHostController4;
            modifier2 = modifier4;
            ScaffoldKt.m3481ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda2, null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1174553726, r6, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EditProfileScreenKt.EditProfileScreen$lambda$28(modifier4, editProfileViewModel8, navHostController6, stateCollectAsState15, stateCollectAsState12, stateCollectAsState13, stateCollectAsState14, stateCollectAsState11, stateCollectAsState16, stateCollectAsState17, stateCollectAsState18, stateCollectAsState19, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            navHostController3 = navHostController6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            navHostController3 = navHostController2;
        }
        modifier3 = modifier2;
        editProfileViewModel2 = editProfileViewModel3;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditProfileScreenKt.EditProfileScreen$lambda$29(modifier3, navHostController3, editProfileViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreen$lambda$14(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C74@3240L258,72@3146L366:EditProfileScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(174347955, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreen.<anonymous> (EditProfileScreen.kt:72)");
            }
            AppBarKt.m2627TopAppBarGHTll3U(ComposableSingletons$EditProfileScreenKt.INSTANCE.m9840getLambda$873230225$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(-1142395603, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditProfileScreenKt.EditProfileScreen$lambda$14$lambda$13(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, null, null, composer, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreen$lambda$14$lambda$13(final NavHostController navHostController, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C75@3283L77,75@3262L218:EditProfileScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1142395603, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreen.<anonymous>.<anonymous> (EditProfileScreen.kt:75)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1669454746, "CC(remember):EditProfileScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditProfileScreenKt.EditProfileScreen$lambda$14$lambda$13$lambda$12$lambda$11(navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9839getLambda$241861681$app_debug(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreen$lambda$14$lambda$13$lambda$12$lambda$11(NavHostController navHostController) {
        if (navHostController != null) {
            navHostController.popBackStack();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:62:0x021e  */
    /* JADX WARN: Code duplicated, block: B:65:0x025e  */
    public static final Unit EditProfileScreen$lambda$28(Modifier modifier, final EditProfileViewModel editProfileViewModel, final NavHostController navHostController, final State state, State state2, State state3, State state4, State state5, State state6, State state7, State state8, State state9, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        String str;
        boolean zChangedInstance;
        Object objRememberedValue;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)84@3556L1092:EditProfileScreen.kt#oif8tm");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1174553726, i2, -1, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreen.<anonymous> (EditProfileScreen.kt:84)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 287515111, "C99@4164L36,100@4238L35,101@4314L38,102@4387L32,103@4448L29,104@4509L115,89@3722L916:EditProfileScreen.kt#oif8tm");
            String strEditProfileScreen$lambda$2 = EditProfileScreen$lambda$2(state2);
            String strEditProfileScreen$lambda$3 = EditProfileScreen$lambda$3(state3);
            String strEditProfileScreen$lambda$4 = EditProfileScreen$lambda$4(state4);
            String strEditProfileScreen$lambda$5 = EditProfileScreen$lambda$5(state);
            boolean zEditProfileScreen$lambda$0 = EditProfileScreen$lambda$0(state5);
            String strEditProfileScreen$lambda$6 = EditProfileScreen$lambda$6(state6);
            String strEditProfileScreen$lambda$7 = EditProfileScreen$lambda$7(state7);
            String strEditProfileScreen$lambda$8 = EditProfileScreen$lambda$8(state8);
            String strEditProfileScreen$lambda$9 = EditProfileScreen$lambda$9(state9);
            ComposerKt.sourceInformationMarkerStart(composer, -960543380, "CC(remember):EditProfileScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(editProfileViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreen$lambda$28$lambda$27$lambda$16$lambda$15(editProfileViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -960541013, "CC(remember):EditProfileScreen.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(editProfileViewModel);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreen$lambda$28$lambda$27$lambda$18$lambda$17(editProfileViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function1 function2 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -960538578, "CC(remember):EditProfileScreen.kt#9igjgp");
            boolean zChangedInstance4 = composer.changedInstance(editProfileViewModel);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreen$lambda$28$lambda$27$lambda$20$lambda$19(editProfileViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function1 function3 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -960536248, "CC(remember):EditProfileScreen.kt#9igjgp");
            boolean zChangedInstance5 = composer.changedInstance(editProfileViewModel);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreen$lambda$28$lambda$27$lambda$22$lambda$21(editProfileViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Function1 function4 = (Function1) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -960534299, "CC(remember):EditProfileScreen.kt#9igjgp");
            boolean zChangedInstance6 = composer.changedInstance(editProfileViewModel);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance6) {
                str = strEditProfileScreen$lambda$3;
            } else {
                str = strEditProfileScreen$lambda$3;
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                }
                Function0 function0 = (Function0) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -960532261, "CC(remember):EditProfileScreen.kt#9igjgp");
                zChangedInstance = composer.changedInstance(navHostController) | composer.changed(state);
                objRememberedValue = composer.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EditProfileScreenKt.EditProfileScreen$lambda$28$lambda$27$lambda$26$lambda$25(navHostController, state);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EditProfileScreenContent(strEditProfileScreen$lambda$2, str, strEditProfileScreen$lambda$4, strEditProfileScreen$lambda$5, zEditProfileScreen$lambda$0, strEditProfileScreen$lambda$6, strEditProfileScreen$lambda$7, strEditProfileScreen$lambda$8, strEditProfileScreen$lambda$9, function1, function2, function3, function4, function0, (Function0) objRememberedValue, composer, 0, 0, 0);
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
            objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EditProfileScreenKt.EditProfileScreen$lambda$28$lambda$27$lambda$24$lambda$23(editProfileViewModel);
                }
            };
            composer.updateRememberedValue(objRememberedValue6);
            Function0 function5 = (Function0) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -960532261, "CC(remember):EditProfileScreen.kt#9igjgp");
            zChangedInstance = composer.changedInstance(navHostController) | composer.changed(state);
            objRememberedValue = composer.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditProfileScreenKt.EditProfileScreen$lambda$28$lambda$27$lambda$26$lambda$25(navHostController, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EditProfileScreenKt.EditProfileScreen$lambda$28$lambda$27$lambda$26$lambda$25(navHostController, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EditProfileScreenContent(strEditProfileScreen$lambda$2, str, strEditProfileScreen$lambda$4, strEditProfileScreen$lambda$5, zEditProfileScreen$lambda$0, strEditProfileScreen$lambda$6, strEditProfileScreen$lambda$7, strEditProfileScreen$lambda$8, strEditProfileScreen$lambda$9, function1, function2, function3, function4, function5, (Function0) objRememberedValue, composer, 0, 0, 0);
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
    public static final Unit EditProfileScreen$lambda$28$lambda$27$lambda$16$lambda$15(EditProfileViewModel editProfileViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        editProfileViewModel.onFirstNameChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreen$lambda$28$lambda$27$lambda$18$lambda$17(EditProfileViewModel editProfileViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        editProfileViewModel.onLastNameChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreen$lambda$28$lambda$27$lambda$20$lambda$19(EditProfileViewModel editProfileViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        editProfileViewModel.onPhoneNumberChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreen$lambda$28$lambda$27$lambda$22$lambda$21(EditProfileViewModel editProfileViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        editProfileViewModel.onEmailChanged(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreen$lambda$28$lambda$27$lambda$24$lambda$23(EditProfileViewModel editProfileViewModel) {
        editProfileViewModel.updateProfile();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreen$lambda$28$lambda$27$lambda$26$lambda$25(NavHostController navHostController, State state) {
        if (navHostController != null) {
            NavController.navigate$default((NavController) navHostController, StringsKt.replace$default(Route.ResetPassword.INSTANCE.getName(), "{email}", EditProfileScreen$lambda$5(state), false, 4, (Object) null), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x016c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0172  */
    /* JADX WARN: Code duplicated, block: B:104:0x0175  */
    /* JADX WARN: Code duplicated, block: B:108:0x017d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0183  */
    /* JADX WARN: Code duplicated, block: B:114:0x018b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0191  */
    /* JADX WARN: Code duplicated, block: B:117:0x0194  */
    /* JADX WARN: Code duplicated, block: B:121:0x019c  */
    /* JADX WARN: Code duplicated, block: B:123:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:124:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:128:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:132:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:135:0x01c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:136:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:140:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:142:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:145:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:146:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:148:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:149:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:152:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:155:0x024b  */
    /* JADX WARN: Code duplicated, block: B:158:0x0257  */
    /* JADX WARN: Code duplicated, block: B:159:0x025b  */
    /* JADX WARN: Code duplicated, block: B:162:0x0280  */
    /* JADX WARN: Code duplicated, block: B:164:0x028e  */
    /* JADX WARN: Code duplicated, block: B:167:0x0311  */
    /* JADX WARN: Code duplicated, block: B:170:0x031d  */
    /* JADX WARN: Code duplicated, block: B:171:0x0321  */
    /* JADX WARN: Code duplicated, block: B:174:0x0346  */
    /* JADX WARN: Code duplicated, block: B:176:0x0354  */
    /* JADX WARN: Code duplicated, block: B:179:0x0383  */
    /* JADX WARN: Code duplicated, block: B:180:0x0385  */
    /* JADX WARN: Code duplicated, block: B:183:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:184:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:187:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:189:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:192:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:193:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:196:0x041a  */
    /* JADX WARN: Code duplicated, block: B:197:0x041c  */
    /* JADX WARN: Code duplicated, block: B:200:0x0423  */
    /* JADX WARN: Code duplicated, block: B:202:0x042b  */
    /* JADX WARN: Code duplicated, block: B:205:0x0474  */
    /* JADX WARN: Code duplicated, block: B:206:0x0476  */
    /* JADX WARN: Code duplicated, block: B:209:0x0494  */
    /* JADX WARN: Code duplicated, block: B:210:0x0496  */
    /* JADX WARN: Code duplicated, block: B:213:0x049d  */
    /* JADX WARN: Code duplicated, block: B:215:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:218:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:219:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:222:0x0502  */
    /* JADX WARN: Code duplicated, block: B:223:0x0504  */
    /* JADX WARN: Code duplicated, block: B:226:0x050b  */
    /* JADX WARN: Code duplicated, block: B:230:0x0517  */
    /* JADX WARN: Code duplicated, block: B:233:0x05a2  */
    /* JADX WARN: Code duplicated, block: B:236:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:237:0x05b2  */
    /* JADX WARN: Code duplicated, block: B:240:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:242:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:245:0x06a0  */
    /* JADX WARN: Code duplicated, block: B:247:0x06ad  */
    /* JADX WARN: Code duplicated, block: B:250:0x06be  */
    /* JADX WARN: Code duplicated, block: B:252:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:65:0x0104  */
    /* JADX WARN: Code duplicated, block: B:66:0x0107  */
    /* JADX WARN: Code duplicated, block: B:68:0x010b  */
    /* JADX WARN: Code duplicated, block: B:70:0x0115  */
    /* JADX WARN: Code duplicated, block: B:71:0x0118  */
    /* JADX WARN: Code duplicated, block: B:76:0x0127  */
    /* JADX WARN: Code duplicated, block: B:77:0x012a  */
    /* JADX WARN: Code duplicated, block: B:79:0x012e  */
    /* JADX WARN: Code duplicated, block: B:81:0x0138  */
    /* JADX WARN: Code duplicated, block: B:82:0x013b  */
    /* JADX WARN: Code duplicated, block: B:87:0x014a  */
    /* JADX WARN: Code duplicated, block: B:89:0x0150  */
    /* JADX WARN: Code duplicated, block: B:90:0x0153  */
    /* JADX WARN: Code duplicated, block: B:94:0x015b  */
    /* JADX WARN: Code duplicated, block: B:96:0x0161  */
    /* JADX WARN: Code duplicated, block: B:98:0x0166  */
    public static final void EditProfileScreenContent(final String firstName, final String lastName, final String phoneNumber, final String email, boolean z, String str, String str2, String str3, String str4, final Function1<? super String, Unit> onFirstNameChanged, final Function1<? super String, Unit> onLastNameChanged, final Function1<? super String, Unit> onPhoneNumberChanged, final Function1<? super String, Unit> onEmailChanged, final Function0<Unit> onUpdate, final Function0<Unit> onChangePin, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        boolean z2;
        int i5;
        String str5;
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
        final String str6;
        final String str7;
        final boolean z4;
        final String str8;
        final String str9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str10;
        String str11;
        String str12;
        String str13;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        String str14;
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
        Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
        Intrinsics.checkNotNullParameter(onChangePin, "onChangePin");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1654994685);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditProfileScreenContent)N(firstName,lastName,phoneNumber,email,isLoading,firstNameError,lastNameError,phoneNumberError,emailError,onFirstNameChanged,onLastNameChanged,onPhoneNumberChanged,onEmailChanged,onUpdate,onChangePin)130@5190L3052:EditProfileScreen.kt#oif8tm");
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
                str5 = str;
            } else {
                str5 = str;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(str5)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                if ((i & 1572864) == 0) {
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
                            if (composerStartRestartGroup.changedInstance(onUpdate)) {
                                i16 = 2048;
                            } else {
                                i16 = 1024;
                            }
                            i13 |= i16;
                        }
                        if ((i2 & 24576) == 0) {
                            if (composerStartRestartGroup.changedInstance(onChangePin)) {
                                i15 = 16384;
                            } else {
                                i15 = 8192;
                            }
                            i13 |= i15;
                        }
                        i14 = i13;
                        if ((i4 & 306783379) == 306783378 || (i14 & 9363) != 9362) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            str6 = str2;
                            str7 = str4;
                            z4 = z2;
                            str8 = str5;
                            str9 = str3;
                        } else {
                            if (i19 != 0) {
                                z2 = false;
                            }
                            if (i5 != 0) {
                                str10 = null;
                            } else {
                                str10 = str5;
                            }
                            if (i7 != 0) {
                                str11 = null;
                            } else {
                                str11 = str2;
                            }
                            if (i9 != 0) {
                                str12 = null;
                            } else {
                                str12 = str3;
                            }
                            if (i11 != 0) {
                                str13 = null;
                            } else {
                                str13 = str4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
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
                            str14 = str11;
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            float f = 8;
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_4 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f));
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                            if (str10 != null) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                            if ((1879048192 & i4) == 536870912) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z6 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i20 = i4 >> 3;
                            final boolean z13 = z2;
                            int i21 = i4;
                            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default, false, composerStartRestartGroup, (i4 & 14) | 384 | (i20 & 57344), 160);
                            String str15 = str10;
                            if (str14 != null) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                            if ((i14 & 14) == 4) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z8 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i22 = i21 >> 6;
                            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default2, false, composerStartRestartGroup, (i20 & 14) | 384 | (i22 & 57344), 160);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                            if (str12 != null) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            int iM8360getPhonePjHm6EE = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                            if ((i14 & 112) == 32) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z10 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i23 = 1769856 | (i22 & 14);
                            int i24 = i21 >> 9;
                            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE, modifierFillMaxWidth$default2, false, composerStartRestartGroup, i23 | (i24 & 57344), 128);
                            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
                            if (str13 != null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            int iM8356getEmailPjHm6EE = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                            if ((i14 & 896) == 256) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!z12 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            String str16 = str13;
                            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str16, iM8356getEmailPjHm6EE, modifierFillMaxWidth$default3, false, composerStartRestartGroup, 1769856 | (i24 & 14) | ((i21 >> 12) & 57344), 128);
                            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composerStartRestartGroup, 6);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                            ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                            CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z13, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                            composerStartRestartGroup = composerStartRestartGroup;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z13;
                            str9 = str12;
                            str6 = str14;
                            str7 = str16;
                            str8 = str15;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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
                        if (composerStartRestartGroup.changedInstance(onUpdate)) {
                            i16 = 2048;
                        } else {
                            i16 = 1024;
                        }
                        i13 |= i16;
                    }
                    if ((i2 & 24576) == 0) {
                        if (composerStartRestartGroup.changedInstance(onChangePin)) {
                            i15 = 16384;
                        } else {
                            i15 = 8192;
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
                        str6 = str2;
                        str7 = str4;
                        z4 = z2;
                        str8 = str5;
                        str9 = str3;
                    } else {
                        if (i19 != 0) {
                            z2 = false;
                        }
                        if (i5 != 0) {
                            str10 = null;
                        } else {
                            str10 = str5;
                        }
                        if (i7 != 0) {
                            str11 = null;
                        } else {
                            str11 = str2;
                        }
                        if (i9 != 0) {
                            str12 = null;
                        } else {
                            str12 = str3;
                        }
                        if (i11 != 0) {
                            str13 = null;
                        } else {
                            str13 = str4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
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
                        str14 = str11;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                        Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        float f2 = 8;
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_5 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f2));
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                        if (str10 != null) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        Modifier modifierWeight$default3 = RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((1879048192 & i4) == 536870912) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i25 = i4 >> 3;
                        final boolean z14 = z2;
                        int i26 = i4;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default3, false, composerStartRestartGroup, (i4 & 14) | 384 | (i25 & 57344), 160);
                        String str17 = str10;
                        if (str14 != null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        Modifier modifierWeight$default4 = RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((i14 & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i27 = i26 >> 6;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default4, false, composerStartRestartGroup, (i25 & 14) | 384 | (i27 & 57344), 160);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                        if (str12 != null) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        int iM8360getPhonePjHm6EE2 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                        Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((i14 & 112) == 32) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z10) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i28 = 1769856 | (i27 & 14);
                        int i29 = i26 >> 9;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE2, modifierFillMaxWidth$default6, false, composerStartRestartGroup, i28 | (i29 & 57344), 128);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
                        if (str13 != null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        int iM8356getEmailPjHm6EE2 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                        Modifier modifierFillMaxWidth$default7 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((i14 & 896) == 256) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!z12) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        String str18 = str13;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str18, iM8356getEmailPjHm6EE2, modifierFillMaxWidth$default7, false, composerStartRestartGroup, 1769856 | (i29 & 14) | ((i26 >> 12) & 57344), 128);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f2)), composerStartRestartGroup, 6);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                        ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                        CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z14, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                        composerStartRestartGroup = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z14;
                        str9 = str12;
                        str6 = str14;
                        str7 = str18;
                        str8 = str17;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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
                        if (composerStartRestartGroup.changedInstance(onUpdate)) {
                            i16 = 2048;
                        } else {
                            i16 = 1024;
                        }
                        i13 |= i16;
                    }
                    if ((i2 & 24576) == 0) {
                        if (composerStartRestartGroup.changedInstance(onChangePin)) {
                            i15 = 16384;
                        } else {
                            i15 = 8192;
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
                        str6 = str2;
                        str7 = str4;
                        z4 = z2;
                        str8 = str5;
                        str9 = str3;
                    } else {
                        if (i19 != 0) {
                            z2 = false;
                        }
                        if (i5 != 0) {
                            str10 = null;
                        } else {
                            str10 = str5;
                        }
                        if (i7 != 0) {
                            str11 = null;
                        } else {
                            str11 = str2;
                        }
                        if (i9 != 0) {
                            str12 = null;
                        } else {
                            str12 = str3;
                        }
                        if (i11 != 0) {
                            str13 = null;
                        } else {
                            str13 = str4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
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
                        str14 = str11;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                        Modifier modifierFillMaxWidth$default9 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        float f3 = 8;
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_6 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f3));
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                        if (str10 != null) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        Modifier modifierWeight$default5 = RowScope.weight$default(rowScopeInstance5, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((1879048192 & i4) == 536870912) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i210 = i4 >> 3;
                        final boolean z15 = z2;
                        int i211 = i4;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default5, false, composerStartRestartGroup, (i4 & 14) | 384 | (i210 & 57344), 160);
                        String str19 = str10;
                        if (str14 != null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        Modifier modifierWeight$default6 = RowScope.weight$default(rowScopeInstance5, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((i14 & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i212 = i211 >> 6;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default6, false, composerStartRestartGroup, (i210 & 14) | 384 | (i212 & 57344), 160);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
                        if (str12 != null) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        int iM8360getPhonePjHm6EE3 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                        Modifier modifierFillMaxWidth$default10 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((i14 & 112) == 32) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z10) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i213 = 1769856 | (i212 & 14);
                        int i214 = i211 >> 9;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE3, modifierFillMaxWidth$default10, false, composerStartRestartGroup, i213 | (i214 & 57344), 128);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
                        if (str13 != null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        int iM8356getEmailPjHm6EE3 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                        Modifier modifierFillMaxWidth$default11 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((i14 & 896) == 256) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!z12) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        String str110 = str13;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str110, iM8356getEmailPjHm6EE3, modifierFillMaxWidth$default11, false, composerStartRestartGroup, 1769856 | (i214 & 14) | ((i211 >> 12) & 57344), 128);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f3)), composerStartRestartGroup, 6);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                        ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                        CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z15, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                        composerStartRestartGroup = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z15;
                        str9 = str12;
                        str6 = str14;
                        str7 = str110;
                        str8 = str19;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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
                    if (composerStartRestartGroup.changedInstance(onUpdate)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i13 |= i16;
                }
                if ((i2 & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(onChangePin)) {
                        i15 = 16384;
                    } else {
                        i15 = 8192;
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
                    str6 = str2;
                    str7 = str4;
                    z4 = z2;
                    str8 = str5;
                    str9 = str3;
                } else {
                    if (i19 != 0) {
                        z2 = false;
                    }
                    if (i5 != 0) {
                        str10 = null;
                    } else {
                        str10 = str5;
                    }
                    if (i7 != 0) {
                        str11 = null;
                    } else {
                        str11 = str2;
                    }
                    if (i9 != 0) {
                        str12 = null;
                    } else {
                        str12 = str3;
                    }
                    if (i11 != 0) {
                        str13 = null;
                    } else {
                        str13 = str4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
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
                    str14 = str11;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                    Modifier modifierFillMaxWidth$default13 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    float f4 = 8;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_7 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f4));
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                    if (str10 != null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Modifier modifierWeight$default7 = RowScope.weight$default(rowScopeInstance7, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((1879048192 & i4) == 536870912) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i215 = i4 >> 3;
                    final boolean z16 = z2;
                    int i216 = i4;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default7, false, composerStartRestartGroup, (i4 & 14) | 384 | (i215 & 57344), 160);
                    String str111 = str10;
                    if (str14 != null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierWeight$default8 = RowScope.weight$default(rowScopeInstance7, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i217 = i216 >> 6;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default8, false, composerStartRestartGroup, (i215 & 14) | 384 | (i217 & 57344), 160);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
                    if (str12 != null) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    int iM8360getPhonePjHm6EE4 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                    Modifier modifierFillMaxWidth$default14 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 112) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i218 = 1769856 | (i217 & 14);
                    int i219 = i216 >> 9;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE4, modifierFillMaxWidth$default14, false, composerStartRestartGroup, i218 | (i219 & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
                    if (str13 != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    int iM8356getEmailPjHm6EE4 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                    Modifier modifierFillMaxWidth$default15 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 896) == 256) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z12) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str112 = str13;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str112, iM8356getEmailPjHm6EE4, modifierFillMaxWidth$default15, false, composerStartRestartGroup, 1769856 | (i219 & 14) | ((i216 >> 12) & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f4)), composerStartRestartGroup, 6);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                    ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                    CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z16, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z16;
                    str9 = str12;
                    str6 = str14;
                    str7 = str112;
                    str8 = str111;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 1572864;
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
                        if (composerStartRestartGroup.changedInstance(onUpdate)) {
                            i16 = 2048;
                        } else {
                            i16 = 1024;
                        }
                        i13 |= i16;
                    }
                    if ((i2 & 24576) == 0) {
                        if (composerStartRestartGroup.changedInstance(onChangePin)) {
                            i15 = 16384;
                        } else {
                            i15 = 8192;
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
                        str6 = str2;
                        str7 = str4;
                        z4 = z2;
                        str8 = str5;
                        str9 = str3;
                    } else {
                        if (i19 != 0) {
                            z2 = false;
                        }
                        if (i5 != 0) {
                            str10 = null;
                        } else {
                            str10 = str5;
                        }
                        if (i7 != 0) {
                            str11 = null;
                        } else {
                            str11 = str2;
                        }
                        if (i9 != 0) {
                            str12 = null;
                        } else {
                            str12 = str3;
                        }
                        if (i11 != 0) {
                            str13 = null;
                        } else {
                            str13 = str4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
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
                        str14 = str11;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                        Modifier modifierFillMaxWidth$default17 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        float f5 = 8;
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_8 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f5));
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                        if (str10 != null) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        Modifier modifierWeight$default9 = RowScope.weight$default(rowScopeInstance9, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((1879048192 & i4) == 536870912) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i2110 = i4 >> 3;
                        final boolean z17 = z2;
                        int i2111 = i4;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default9, false, composerStartRestartGroup, (i4 & 14) | 384 | (i2110 & 57344), 160);
                        String str113 = str10;
                        if (str14 != null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        Modifier modifierWeight$default10 = RowScope.weight$default(rowScopeInstance9, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((i14 & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i2112 = i2111 >> 6;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default10, false, composerStartRestartGroup, (i2110 & 14) | 384 | (i2112 & 57344), 160);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f5)), composerStartRestartGroup, 6);
                        if (str12 != null) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        int iM8360getPhonePjHm6EE5 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                        Modifier modifierFillMaxWidth$default18 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((i14 & 112) == 32) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z10) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i2113 = 1769856 | (i2112 & 14);
                        int i2114 = i2111 >> 9;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE5, modifierFillMaxWidth$default18, false, composerStartRestartGroup, i2113 | (i2114 & 57344), 128);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f5)), composerStartRestartGroup, 6);
                        if (str13 != null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        int iM8356getEmailPjHm6EE5 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                        Modifier modifierFillMaxWidth$default19 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((i14 & 896) == 256) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!z12) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        String str114 = str13;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str114, iM8356getEmailPjHm6EE5, modifierFillMaxWidth$default19, false, composerStartRestartGroup, 1769856 | (i2114 & 14) | ((i2111 >> 12) & 57344), 128);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f5)), composerStartRestartGroup, 6);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                        ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                        CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z17, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                        composerStartRestartGroup = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z17;
                        str9 = str12;
                        str6 = str14;
                        str7 = str114;
                        str8 = str113;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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
                    if (composerStartRestartGroup.changedInstance(onUpdate)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i13 |= i16;
                }
                if ((i2 & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(onChangePin)) {
                        i15 = 16384;
                    } else {
                        i15 = 8192;
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
                    str6 = str2;
                    str7 = str4;
                    z4 = z2;
                    str8 = str5;
                    str9 = str3;
                } else {
                    if (i19 != 0) {
                        z2 = false;
                    }
                    if (i5 != 0) {
                        str10 = null;
                    } else {
                        str10 = str5;
                    }
                    if (i7 != 0) {
                        str11 = null;
                    } else {
                        str11 = str2;
                    }
                    if (i9 != 0) {
                        str12 = null;
                    } else {
                        str12 = str3;
                    }
                    if (i11 != 0) {
                        str13 = null;
                    } else {
                        str13 = str4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
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
                    str14 = str11;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                    Modifier modifierFillMaxWidth$default111 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    float f6 = 8;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_9 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f6));
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                    if (str10 != null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Modifier modifierWeight$default11 = RowScope.weight$default(rowScopeInstance11, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((1879048192 & i4) == 536870912) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2115 = i4 >> 3;
                    final boolean z18 = z2;
                    int i2116 = i4;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default11, false, composerStartRestartGroup, (i4 & 14) | 384 | (i2115 & 57344), 160);
                    String str115 = str10;
                    if (str14 != null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierWeight$default12 = RowScope.weight$default(rowScopeInstance11, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2117 = i2116 >> 6;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default12, false, composerStartRestartGroup, (i2115 & 14) | 384 | (i2117 & 57344), 160);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f6)), composerStartRestartGroup, 6);
                    if (str12 != null) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    int iM8360getPhonePjHm6EE6 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                    Modifier modifierFillMaxWidth$default112 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 112) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2118 = 1769856 | (i2117 & 14);
                    int i2119 = i2116 >> 9;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE6, modifierFillMaxWidth$default112, false, composerStartRestartGroup, i2118 | (i2119 & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f6)), composerStartRestartGroup, 6);
                    if (str13 != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    int iM8356getEmailPjHm6EE6 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                    Modifier modifierFillMaxWidth$default113 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 896) == 256) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z12) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str116 = str13;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str116, iM8356getEmailPjHm6EE6, modifierFillMaxWidth$default113, false, composerStartRestartGroup, 1769856 | (i2119 & 14) | ((i2116 >> 12) & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f6)), composerStartRestartGroup, 6);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                    ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                    CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z18, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z18;
                    str9 = str12;
                    str6 = str14;
                    str7 = str116;
                    str8 = str115;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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
                    if (composerStartRestartGroup.changedInstance(onUpdate)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i13 |= i16;
                }
                if ((i2 & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(onChangePin)) {
                        i15 = 16384;
                    } else {
                        i15 = 8192;
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
                    str6 = str2;
                    str7 = str4;
                    z4 = z2;
                    str8 = str5;
                    str9 = str3;
                } else {
                    if (i19 != 0) {
                        z2 = false;
                    }
                    if (i5 != 0) {
                        str10 = null;
                    } else {
                        str10 = str5;
                    }
                    if (i7 != 0) {
                        str11 = null;
                    } else {
                        str11 = str2;
                    }
                    if (i9 != 0) {
                        str12 = null;
                    } else {
                        str12 = str3;
                    }
                    if (i11 != 0) {
                        str13 = null;
                    } else {
                        str13 = str4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
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
                    str14 = str11;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                    Modifier modifierFillMaxWidth$default115 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    float f7 = 8;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_10 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f7));
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                    if (str10 != null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Modifier modifierWeight$default13 = RowScope.weight$default(rowScopeInstance13, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((1879048192 & i4) == 536870912) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i21110 = i4 >> 3;
                    final boolean z19 = z2;
                    int i21111 = i4;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default13, false, composerStartRestartGroup, (i4 & 14) | 384 | (i21110 & 57344), 160);
                    String str117 = str10;
                    if (str14 != null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierWeight$default14 = RowScope.weight$default(rowScopeInstance13, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i21112 = i21111 >> 6;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default14, false, composerStartRestartGroup, (i21110 & 14) | 384 | (i21112 & 57344), 160);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f7)), composerStartRestartGroup, 6);
                    if (str12 != null) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    int iM8360getPhonePjHm6EE7 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                    Modifier modifierFillMaxWidth$default116 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 112) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i21113 = 1769856 | (i21112 & 14);
                    int i21114 = i21111 >> 9;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE7, modifierFillMaxWidth$default116, false, composerStartRestartGroup, i21113 | (i21114 & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f7)), composerStartRestartGroup, 6);
                    if (str13 != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    int iM8356getEmailPjHm6EE7 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                    Modifier modifierFillMaxWidth$default117 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 896) == 256) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z12) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str118 = str13;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str118, iM8356getEmailPjHm6EE7, modifierFillMaxWidth$default117, false, composerStartRestartGroup, 1769856 | (i21114 & 14) | ((i21111 >> 12) & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f7)), composerStartRestartGroup, 6);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                    ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                    CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z19, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z19;
                    str9 = str12;
                    str6 = str14;
                    str7 = str118;
                    str8 = str117;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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
                if (composerStartRestartGroup.changedInstance(onUpdate)) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i13 |= i16;
            }
            if ((i2 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onChangePin)) {
                    i15 = 16384;
                } else {
                    i15 = 8192;
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
                str6 = str2;
                str7 = str4;
                z4 = z2;
                str8 = str5;
                str9 = str3;
            } else {
                if (i19 != 0) {
                    z2 = false;
                }
                if (i5 != 0) {
                    str10 = null;
                } else {
                    str10 = str5;
                }
                if (i7 != 0) {
                    str11 = null;
                } else {
                    str11 = str2;
                }
                if (i9 != 0) {
                    str12 = null;
                } else {
                    str12 = str3;
                }
                if (i11 != 0) {
                    str13 = null;
                } else {
                    str13 = str4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
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
                str14 = str11;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                Modifier modifierFillMaxWidth$default119 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                float f8 = 8;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_11 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f8));
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                if (str10 != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Modifier modifierWeight$default15 = RowScope.weight$default(rowScopeInstance15, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((1879048192 & i4) == 536870912) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21115 = i4 >> 3;
                final boolean z110 = z2;
                int i21116 = i4;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default15, false, composerStartRestartGroup, (i4 & 14) | 384 | (i21115 & 57344), 160);
                String str119 = str10;
                if (str14 != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Modifier modifierWeight$default16 = RowScope.weight$default(rowScopeInstance15, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((i14 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21117 = i21116 >> 6;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default16, false, composerStartRestartGroup, (i21115 & 14) | 384 | (i21117 & 57344), 160);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f8)), composerStartRestartGroup, 6);
                if (str12 != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                int iM8360getPhonePjHm6EE8 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                Modifier modifierFillMaxWidth$default1110 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((i14 & 112) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21118 = 1769856 | (i21117 & 14);
                int i21119 = i21116 >> 9;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE8, modifierFillMaxWidth$default1110, false, composerStartRestartGroup, i21118 | (i21119 & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f8)), composerStartRestartGroup, 6);
                if (str13 != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                int iM8356getEmailPjHm6EE8 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                Modifier modifierFillMaxWidth$default1111 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((i14 & 896) == 256) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z12) {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String str1110 = str13;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str1110, iM8356getEmailPjHm6EE8, modifierFillMaxWidth$default1111, false, composerStartRestartGroup, 1769856 | (i21119 & 14) | ((i21116 >> 12) & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f8)), composerStartRestartGroup, 6);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z110, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z110;
                str9 = str12;
                str6 = str14;
                str7 = str1110;
                str8 = str119;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        z2 = z;
        i5 = i3 & 32;
        if (i5 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            str5 = str;
        } else {
            str5 = str;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(str5)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
        }
        i7 = i3 & 64;
        if (i7 != 0) {
            if ((i & 1572864) == 0) {
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
                        if (composerStartRestartGroup.changedInstance(onUpdate)) {
                            i16 = 2048;
                        } else {
                            i16 = 1024;
                        }
                        i13 |= i16;
                    }
                    if ((i2 & 24576) == 0) {
                        if (composerStartRestartGroup.changedInstance(onChangePin)) {
                            i15 = 16384;
                        } else {
                            i15 = 8192;
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
                        str6 = str2;
                        str7 = str4;
                        z4 = z2;
                        str8 = str5;
                        str9 = str3;
                    } else {
                        if (i19 != 0) {
                            z2 = false;
                        }
                        if (i5 != 0) {
                            str10 = null;
                        } else {
                            str10 = str5;
                        }
                        if (i7 != 0) {
                            str11 = null;
                        } else {
                            str11 = str2;
                        }
                        if (i9 != 0) {
                            str12 = null;
                        } else {
                            str12 = str3;
                        }
                        if (i11 != 0) {
                            str13 = null;
                        } else {
                            str13 = str4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
                        }
                        Alignment.Horizontal start9 = Alignment.INSTANCE.getStart();
                        Arrangement.Vertical top9 = Arrangement.INSTANCE.getTop();
                        Modifier modifierFillMaxSize$default9 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy9 = ColumnKt.columnMeasurePolicy(top9, start9, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier115 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default9);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        str14 = str11;
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
                        Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5259constructorimpl.getInserting()) {
                            composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                            composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                        } else {
                            composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                            composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                        }
                        Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier115, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance9 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                        Modifier modifierFillMaxWidth$default1113 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        float f9 = 8;
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_12 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f9));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy17 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_12, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default1113);
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
                        Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy17, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5259constructorimpl2.getInserting()) {
                            composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                            composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                        } else {
                            composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                            composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                        }
                        Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier116, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance17 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                        if (str10 != null) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        Modifier modifierWeight$default17 = RowScope.weight$default(rowScopeInstance17, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((1879048192 & i4) == 536870912) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i211110 = i4 >> 3;
                        final boolean z111 = z2;
                        int i211111 = i4;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default17, false, composerStartRestartGroup, (i4 & 14) | 384 | (i211110 & 57344), 160);
                        String str1111 = str10;
                        if (str14 != null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        Modifier modifierWeight$default18 = RowScope.weight$default(rowScopeInstance17, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((i14 & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i211112 = i211111 >> 6;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default18, false, composerStartRestartGroup, (i211110 & 14) | 384 | (i211112 & 57344), 160);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f9)), composerStartRestartGroup, 6);
                        if (str12 != null) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        int iM8360getPhonePjHm6EE9 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                        Modifier modifierFillMaxWidth$default1114 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((i14 & 112) == 32) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z10) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i211113 = 1769856 | (i211112 & 14);
                        int i211114 = i211111 >> 9;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE9, modifierFillMaxWidth$default1114, false, composerStartRestartGroup, i211113 | (i211114 & 57344), 128);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f9)), composerStartRestartGroup, 6);
                        if (str13 != null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        int iM8356getEmailPjHm6EE9 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                        Modifier modifierFillMaxWidth$default1115 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                        if ((i14 & 896) == 256) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!z12) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        String str1112 = str13;
                        ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str1112, iM8356getEmailPjHm6EE9, modifierFillMaxWidth$default1115, false, composerStartRestartGroup, 1769856 | (i211114 & 14) | ((i211111 >> 12) & 57344), 128);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f9)), composerStartRestartGroup, 6);
                        Modifier modifierFillMaxWidth$default1116 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal end9 = Arrangement.INSTANCE.getEnd();
                        Alignment.Vertical centerVertically9 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy18 = RowKt.rowMeasurePolicy(end9, centerVertically9, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default1116);
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
                        Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy18, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5259constructorimpl3.getInserting()) {
                            composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                            composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                        } else {
                            composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                            composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                        }
                        Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier117, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance18 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                        ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                        CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z111, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                        composerStartRestartGroup = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z111;
                        str9 = str12;
                        str6 = str14;
                        str7 = str1112;
                        str8 = str1111;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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
                    if (composerStartRestartGroup.changedInstance(onUpdate)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i13 |= i16;
                }
                if ((i2 & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(onChangePin)) {
                        i15 = 16384;
                    } else {
                        i15 = 8192;
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
                    str6 = str2;
                    str7 = str4;
                    z4 = z2;
                    str8 = str5;
                    str9 = str3;
                } else {
                    if (i19 != 0) {
                        z2 = false;
                    }
                    if (i5 != 0) {
                        str10 = null;
                    } else {
                        str10 = str5;
                    }
                    if (i7 != 0) {
                        str11 = null;
                    } else {
                        str11 = str2;
                    }
                    if (i9 != 0) {
                        str12 = null;
                    } else {
                        str12 = str3;
                    }
                    if (i11 != 0) {
                        str13 = null;
                    } else {
                        str13 = str4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
                    }
                    Alignment.Horizontal start10 = Alignment.INSTANCE.getStart();
                    Arrangement.Vertical top10 = Arrangement.INSTANCE.getTop();
                    Modifier modifierFillMaxSize$default10 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy10 = ColumnKt.columnMeasurePolicy(top10, start10, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier118 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default10);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    str14 = str11;
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
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier118, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance10 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                    Modifier modifierFillMaxWidth$default1117 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    float f10 = 8;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_13 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f10));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy19 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_13, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default1117);
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
                    Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy19, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap119, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl2.getInserting()) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    } else {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier119, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance19 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                    if (str10 != null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Modifier modifierWeight$default19 = RowScope.weight$default(rowScopeInstance19, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((1879048192 & i4) == 536870912) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211115 = i4 >> 3;
                    final boolean z112 = z2;
                    int i211116 = i4;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default19, false, composerStartRestartGroup, (i4 & 14) | 384 | (i211115 & 57344), 160);
                    String str1113 = str10;
                    if (str14 != null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierWeight$default110 = RowScope.weight$default(rowScopeInstance19, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211117 = i211116 >> 6;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default110, false, composerStartRestartGroup, (i211115 & 14) | 384 | (i211117 & 57344), 160);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f10)), composerStartRestartGroup, 6);
                    if (str12 != null) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    int iM8360getPhonePjHm6EE10 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                    Modifier modifierFillMaxWidth$default1118 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 112) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i211118 = 1769856 | (i211117 & 14);
                    int i211119 = i211116 >> 9;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE10, modifierFillMaxWidth$default1118, false, composerStartRestartGroup, i211118 | (i211119 & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f10)), composerStartRestartGroup, 6);
                    if (str13 != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    int iM8356getEmailPjHm6EE10 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                    Modifier modifierFillMaxWidth$default1119 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 896) == 256) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z12) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str1114 = str13;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str1114, iM8356getEmailPjHm6EE10, modifierFillMaxWidth$default1119, false, composerStartRestartGroup, 1769856 | (i211119 & 14) | ((i211116 >> 12) & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f10)), composerStartRestartGroup, 6);
                    Modifier modifierFillMaxWidth$default11110 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.Horizontal end10 = Arrangement.INSTANCE.getEnd();
                    Alignment.Vertical centerVertically10 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy110 = RowKt.rowMeasurePolicy(end10, centerVertically10, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap1110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default11110);
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
                    Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap1110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl3.getInserting()) {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    } else {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier1110, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance110 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                    ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                    CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z112, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z112;
                    str9 = str12;
                    str6 = str14;
                    str7 = str1114;
                    str8 = str1113;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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
                    if (composerStartRestartGroup.changedInstance(onUpdate)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i13 |= i16;
                }
                if ((i2 & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(onChangePin)) {
                        i15 = 16384;
                    } else {
                        i15 = 8192;
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
                    str6 = str2;
                    str7 = str4;
                    z4 = z2;
                    str8 = str5;
                    str9 = str3;
                } else {
                    if (i19 != 0) {
                        z2 = false;
                    }
                    if (i5 != 0) {
                        str10 = null;
                    } else {
                        str10 = str5;
                    }
                    if (i7 != 0) {
                        str11 = null;
                    } else {
                        str11 = str2;
                    }
                    if (i9 != 0) {
                        str12 = null;
                    } else {
                        str12 = str3;
                    }
                    if (i11 != 0) {
                        str13 = null;
                    } else {
                        str13 = str4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
                    }
                    Alignment.Horizontal start11 = Alignment.INSTANCE.getStart();
                    Arrangement.Vertical top11 = Arrangement.INSTANCE.getTop();
                    Modifier modifierFillMaxSize$default11 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy11 = ColumnKt.columnMeasurePolicy(top11, start11, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap1111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default11);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    str14 = str11;
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
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap1111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier1111, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance11 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                    Modifier modifierFillMaxWidth$default11111 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    float f11 = 8;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_14 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f11));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy111 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_14, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap1112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default11111);
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
                    Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap1112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl2.getInserting()) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    } else {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier1112, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance111 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                    if (str10 != null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Modifier modifierWeight$default111 = RowScope.weight$default(rowScopeInstance111, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((1879048192 & i4) == 536870912) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2111110 = i4 >> 3;
                    final boolean z113 = z2;
                    int i2111111 = i4;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default111, false, composerStartRestartGroup, (i4 & 14) | 384 | (i2111110 & 57344), 160);
                    String str1115 = str10;
                    if (str14 != null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierWeight$default112 = RowScope.weight$default(rowScopeInstance111, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2111112 = i2111111 >> 6;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default112, false, composerStartRestartGroup, (i2111110 & 14) | 384 | (i2111112 & 57344), 160);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f11)), composerStartRestartGroup, 6);
                    if (str12 != null) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    int iM8360getPhonePjHm6EE11 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                    Modifier modifierFillMaxWidth$default11112 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 112) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i2111113 = 1769856 | (i2111112 & 14);
                    int i2111114 = i2111111 >> 9;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE11, modifierFillMaxWidth$default11112, false, composerStartRestartGroup, i2111113 | (i2111114 & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f11)), composerStartRestartGroup, 6);
                    if (str13 != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    int iM8356getEmailPjHm6EE11 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                    Modifier modifierFillMaxWidth$default11113 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 896) == 256) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z12) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str1116 = str13;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str1116, iM8356getEmailPjHm6EE11, modifierFillMaxWidth$default11113, false, composerStartRestartGroup, 1769856 | (i2111114 & 14) | ((i2111111 >> 12) & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f11)), composerStartRestartGroup, 6);
                    Modifier modifierFillMaxWidth$default11114 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.Horizontal end11 = Arrangement.INSTANCE.getEnd();
                    Alignment.Vertical centerVertically11 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy112 = RowKt.rowMeasurePolicy(end11, centerVertically11, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap1113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default11114);
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
                    Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap1113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl3.getInserting()) {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    } else {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier1113, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance112 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                    ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                    CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z113, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z113;
                    str9 = str12;
                    str6 = str14;
                    str7 = str1116;
                    str8 = str1115;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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
                if (composerStartRestartGroup.changedInstance(onUpdate)) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i13 |= i16;
            }
            if ((i2 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onChangePin)) {
                    i15 = 16384;
                } else {
                    i15 = 8192;
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
                str6 = str2;
                str7 = str4;
                z4 = z2;
                str8 = str5;
                str9 = str3;
            } else {
                if (i19 != 0) {
                    z2 = false;
                }
                if (i5 != 0) {
                    str10 = null;
                } else {
                    str10 = str5;
                }
                if (i7 != 0) {
                    str11 = null;
                } else {
                    str11 = str2;
                }
                if (i9 != 0) {
                    str12 = null;
                } else {
                    str12 = str3;
                }
                if (i11 != 0) {
                    str13 = null;
                } else {
                    str13 = str4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
                }
                Alignment.Horizontal start12 = Alignment.INSTANCE.getStart();
                Arrangement.Vertical top12 = Arrangement.INSTANCE.getTop();
                Modifier modifierFillMaxSize$default12 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy12 = ColumnKt.columnMeasurePolicy(top12, start12, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap1114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default12);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                str14 = str11;
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
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap1114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier1114, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance12 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                Modifier modifierFillMaxWidth$default11115 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                float f12 = 8;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_15 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f12));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy113 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_15, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap1115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1115 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default11115);
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
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy113, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap1115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier1115, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance113 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                if (str10 != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Modifier modifierWeight$default113 = RowScope.weight$default(rowScopeInstance113, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((1879048192 & i4) == 536870912) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2111115 = i4 >> 3;
                final boolean z114 = z2;
                int i2111116 = i4;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default113, false, composerStartRestartGroup, (i4 & 14) | 384 | (i2111115 & 57344), 160);
                String str1117 = str10;
                if (str14 != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Modifier modifierWeight$default114 = RowScope.weight$default(rowScopeInstance113, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((i14 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2111117 = i2111116 >> 6;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default114, false, composerStartRestartGroup, (i2111115 & 14) | 384 | (i2111117 & 57344), 160);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f12)), composerStartRestartGroup, 6);
                if (str12 != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                int iM8360getPhonePjHm6EE12 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                Modifier modifierFillMaxWidth$default11116 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((i14 & 112) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i2111118 = 1769856 | (i2111117 & 14);
                int i2111119 = i2111116 >> 9;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE12, modifierFillMaxWidth$default11116, false, composerStartRestartGroup, i2111118 | (i2111119 & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f12)), composerStartRestartGroup, 6);
                if (str13 != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                int iM8356getEmailPjHm6EE12 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                Modifier modifierFillMaxWidth$default11117 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((i14 & 896) == 256) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z12) {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String str1118 = str13;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str1118, iM8356getEmailPjHm6EE12, modifierFillMaxWidth$default11117, false, composerStartRestartGroup, 1769856 | (i2111119 & 14) | ((i2111116 >> 12) & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f12)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default11118 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.Horizontal end12 = Arrangement.INSTANCE.getEnd();
                Alignment.Vertical centerVertically12 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy114 = RowKt.rowMeasurePolicy(end12, centerVertically12, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap1116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default11118);
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
                Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy114, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap1116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl3.getInserting()) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                } else {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier1116, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance114 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z114, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z114;
                str9 = str12;
                str6 = str14;
                str7 = str1118;
                str8 = str1117;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 1572864;
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
                    if (composerStartRestartGroup.changedInstance(onUpdate)) {
                        i16 = 2048;
                    } else {
                        i16 = 1024;
                    }
                    i13 |= i16;
                }
                if ((i2 & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(onChangePin)) {
                        i15 = 16384;
                    } else {
                        i15 = 8192;
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
                    str6 = str2;
                    str7 = str4;
                    z4 = z2;
                    str8 = str5;
                    str9 = str3;
                } else {
                    if (i19 != 0) {
                        z2 = false;
                    }
                    if (i5 != 0) {
                        str10 = null;
                    } else {
                        str10 = str5;
                    }
                    if (i7 != 0) {
                        str11 = null;
                    } else {
                        str11 = str2;
                    }
                    if (i9 != 0) {
                        str12 = null;
                    } else {
                        str12 = str3;
                    }
                    if (i11 != 0) {
                        str13 = null;
                    } else {
                        str13 = str4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
                    }
                    Alignment.Horizontal start13 = Alignment.INSTANCE.getStart();
                    Arrangement.Vertical top13 = Arrangement.INSTANCE.getTop();
                    Modifier modifierFillMaxSize$default13 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy13 = ColumnKt.columnMeasurePolicy(top13, start13, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap1117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default13);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    str14 = str11;
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
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap1117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier1117, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance13 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                    Modifier modifierFillMaxWidth$default11119 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    float f13 = 8;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_16 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f13));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy115 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_16, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap1118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1118 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default11119);
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
                    Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy115, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap1118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl2.getInserting()) {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    } else {
                        composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                        composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier1118, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance115 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                    if (str10 != null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Modifier modifierWeight$default115 = RowScope.weight$default(rowScopeInstance115, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((1879048192 & i4) == 536870912) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i21111110 = i4 >> 3;
                    final boolean z115 = z2;
                    int i21111111 = i4;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default115, false, composerStartRestartGroup, (i4 & 14) | 384 | (i21111110 & 57344), 160);
                    String str1119 = str10;
                    if (str14 != null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierWeight$default116 = RowScope.weight$default(rowScopeInstance115, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i21111112 = i21111111 >> 6;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default116, false, composerStartRestartGroup, (i21111110 & 14) | 384 | (i21111112 & 57344), 160);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f13)), composerStartRestartGroup, 6);
                    if (str12 != null) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    int iM8360getPhonePjHm6EE13 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                    Modifier modifierFillMaxWidth$default111110 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 112) == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i21111113 = 1769856 | (i21111112 & 14);
                    int i21111114 = i21111111 >> 9;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE13, modifierFillMaxWidth$default111110, false, composerStartRestartGroup, i21111113 | (i21111114 & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f13)), composerStartRestartGroup, 6);
                    if (str13 != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    int iM8356getEmailPjHm6EE13 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                    Modifier modifierFillMaxWidth$default111111 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                    if ((i14 & 896) == 256) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z12) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str11110 = str13;
                    ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str11110, iM8356getEmailPjHm6EE13, modifierFillMaxWidth$default111111, false, composerStartRestartGroup, 1769856 | (i21111114 & 14) | ((i21111111 >> 12) & 57344), 128);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f13)), composerStartRestartGroup, 6);
                    Modifier modifierFillMaxWidth$default111112 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.Horizontal end13 = Arrangement.INSTANCE.getEnd();
                    Alignment.Vertical centerVertically13 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy116 = RowKt.rowMeasurePolicy(end13, centerVertically13, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap1119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default111112);
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
                    Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy116, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap1119, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl3.getInserting()) {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    } else {
                        composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                        composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier1119, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance116 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                    ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                    CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z115, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z115;
                    str9 = str12;
                    str6 = str14;
                    str7 = str11110;
                    str8 = str1119;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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
                if (composerStartRestartGroup.changedInstance(onUpdate)) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i13 |= i16;
            }
            if ((i2 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onChangePin)) {
                    i15 = 16384;
                } else {
                    i15 = 8192;
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
                str6 = str2;
                str7 = str4;
                z4 = z2;
                str8 = str5;
                str9 = str3;
            } else {
                if (i19 != 0) {
                    z2 = false;
                }
                if (i5 != 0) {
                    str10 = null;
                } else {
                    str10 = str5;
                }
                if (i7 != 0) {
                    str11 = null;
                } else {
                    str11 = str2;
                }
                if (i9 != 0) {
                    str12 = null;
                } else {
                    str12 = str3;
                }
                if (i11 != 0) {
                    str13 = null;
                } else {
                    str13 = str4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
                }
                Alignment.Horizontal start14 = Alignment.INSTANCE.getStart();
                Arrangement.Vertical top14 = Arrangement.INSTANCE.getTop();
                Modifier modifierFillMaxSize$default14 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy14 = ColumnKt.columnMeasurePolicy(top14, start14, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default14);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                str14 = str11;
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
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap11110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier11110, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance14 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                Modifier modifierFillMaxWidth$default111113 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                float f14 = 8;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_17 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f14));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy117 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_17, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default111113);
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
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy117, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap11111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier11111, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance117 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                if (str10 != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Modifier modifierWeight$default117 = RowScope.weight$default(rowScopeInstance117, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((1879048192 & i4) == 536870912) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21111115 = i4 >> 3;
                final boolean z116 = z2;
                int i21111116 = i4;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default117, false, composerStartRestartGroup, (i4 & 14) | 384 | (i21111115 & 57344), 160);
                String str11111 = str10;
                if (str14 != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Modifier modifierWeight$default118 = RowScope.weight$default(rowScopeInstance117, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((i14 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21111117 = i21111116 >> 6;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default118, false, composerStartRestartGroup, (i21111115 & 14) | 384 | (i21111117 & 57344), 160);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f14)), composerStartRestartGroup, 6);
                if (str12 != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                int iM8360getPhonePjHm6EE14 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                Modifier modifierFillMaxWidth$default111114 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((i14 & 112) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i21111118 = 1769856 | (i21111117 & 14);
                int i21111119 = i21111116 >> 9;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE14, modifierFillMaxWidth$default111114, false, composerStartRestartGroup, i21111118 | (i21111119 & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f14)), composerStartRestartGroup, 6);
                if (str13 != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                int iM8356getEmailPjHm6EE14 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                Modifier modifierFillMaxWidth$default111115 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((i14 & 896) == 256) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z12) {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String str11112 = str13;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str11112, iM8356getEmailPjHm6EE14, modifierFillMaxWidth$default111115, false, composerStartRestartGroup, 1769856 | (i21111119 & 14) | ((i21111116 >> 12) & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f14)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default111116 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.Horizontal end14 = Arrangement.INSTANCE.getEnd();
                Alignment.Vertical centerVertically14 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy118 = RowKt.rowMeasurePolicy(end14, centerVertically14, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default111116);
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
                Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy118, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap11112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl3.getInserting()) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                } else {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier11112, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance118 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z116, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z116;
                str9 = str12;
                str6 = str14;
                str7 = str11112;
                str8 = str11111;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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
                if (composerStartRestartGroup.changedInstance(onUpdate)) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i13 |= i16;
            }
            if ((i2 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onChangePin)) {
                    i15 = 16384;
                } else {
                    i15 = 8192;
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
                str6 = str2;
                str7 = str4;
                z4 = z2;
                str8 = str5;
                str9 = str3;
            } else {
                if (i19 != 0) {
                    z2 = false;
                }
                if (i5 != 0) {
                    str10 = null;
                } else {
                    str10 = str5;
                }
                if (i7 != 0) {
                    str11 = null;
                } else {
                    str11 = str2;
                }
                if (i9 != 0) {
                    str12 = null;
                } else {
                    str12 = str3;
                }
                if (i11 != 0) {
                    str13 = null;
                } else {
                    str13 = str4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
                }
                Alignment.Horizontal start15 = Alignment.INSTANCE.getStart();
                Arrangement.Vertical top15 = Arrangement.INSTANCE.getTop();
                Modifier modifierFillMaxSize$default15 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy15 = ColumnKt.columnMeasurePolicy(top15, start15, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default15);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                str14 = str11;
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
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap11113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier11113, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance15 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
                Modifier modifierFillMaxWidth$default111117 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                float f15 = 8;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_18 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f15));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy119 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_18, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default111117);
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
                Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy119, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap11114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl2.getInserting()) {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                } else {
                    composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                    composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
                }
                Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier11114, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance119 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
                if (str10 != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Modifier modifierWeight$default119 = RowScope.weight$default(rowScopeInstance119, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((1879048192 & i4) == 536870912) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i211111110 = i4 >> 3;
                final boolean z117 = z2;
                int i211111111 = i4;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default119, false, composerStartRestartGroup, (i4 & 14) | 384 | (i211111110 & 57344), 160);
                String str11113 = str10;
                if (str14 != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Modifier modifierWeight$default1110 = RowScope.weight$default(rowScopeInstance119, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((i14 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i211111112 = i211111111 >> 6;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default1110, false, composerStartRestartGroup, (i211111110 & 14) | 384 | (i211111112 & 57344), 160);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f15)), composerStartRestartGroup, 6);
                if (str12 != null) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                int iM8360getPhonePjHm6EE15 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
                Modifier modifierFillMaxWidth$default111118 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((i14 & 112) == 32) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i211111113 = 1769856 | (i211111112 & 14);
                int i211111114 = i211111111 >> 9;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE15, modifierFillMaxWidth$default111118, false, composerStartRestartGroup, i211111113 | (i211111114 & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f15)), composerStartRestartGroup, 6);
                if (str13 != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                int iM8356getEmailPjHm6EE15 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
                Modifier modifierFillMaxWidth$default111119 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
                if ((i14 & 896) == 256) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z12) {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String str11114 = str13;
                ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str11114, iM8356getEmailPjHm6EE15, modifierFillMaxWidth$default111119, false, composerStartRestartGroup, 1769856 | (i211111114 & 14) | ((i211111111 >> 12) & 57344), 128);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f15)), composerStartRestartGroup, 6);
                Modifier modifierFillMaxWidth$default1111110 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.Horizontal end15 = Arrangement.INSTANCE.getEnd();
                Alignment.Vertical centerVertically15 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy1110 = RowKt.rowMeasurePolicy(end15, centerVertically15, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11115 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default1111110);
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
                Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy1110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap11115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl3.getInserting()) {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                } else {
                    composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                    composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
                }
                Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier11115, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance1110 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
                ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
                CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z117, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z117;
                str9 = str12;
                str6 = str14;
                str7 = str11114;
                str8 = str11113;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
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
            if (composerStartRestartGroup.changedInstance(onUpdate)) {
                i16 = 2048;
            } else {
                i16 = 1024;
            }
            i13 |= i16;
        }
        if ((i2 & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(onChangePin)) {
                i15 = 16384;
            } else {
                i15 = 8192;
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
            str6 = str2;
            str7 = str4;
            z4 = z2;
            str8 = str5;
            str9 = str3;
        } else {
            if (i19 != 0) {
                z2 = false;
            }
            if (i5 != 0) {
                str10 = null;
            } else {
                str10 = str5;
            }
            if (i7 != 0) {
                str11 = null;
            } else {
                str11 = str2;
            }
            if (i9 != 0) {
                str12 = null;
            } else {
                str12 = str3;
            }
            if (i11 != 0) {
                str13 = null;
            } else {
                str13 = str4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1654994685, i4, i14, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent (EditProfileScreen.kt:129)");
            }
            Alignment.Horizontal start16 = Alignment.INSTANCE.getStart();
            Arrangement.Vertical top16 = Arrangement.INSTANCE.getTop();
            Modifier modifierFillMaxSize$default16 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy16 = ColumnKt.columnMeasurePolicy(top16, start16, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap11116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier11116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default16);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            str14 = str11;
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
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap11116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl.getInserting()) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            } else {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier11116, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance16 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2087746224, "C135@5350L779,157@6138L40,161@6304L28,158@6187L343,167@6539L40,171@6692L22,168@6588L312,177@6909L40,178@6958L544,194@7511L41,200@7690L546,196@7570L666:EditProfileScreen.kt#oif8tm");
            Modifier modifierFillMaxWidth$default1111111 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            float f16 = 8;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_19 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(f16));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy1111 = RowKt.rowMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_19, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap11117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier11117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default1111111);
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
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyRowMeasurePolicy1111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap11117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl2.getInserting()) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            } else {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier11117, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance1111 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609419547, "C142@5615L26,139@5490L310,151@5937L25,148@5814L305:EditProfileScreen.kt#oif8tm");
            if (str10 != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            Modifier modifierWeight$default1111 = RowScope.weight$default(rowScopeInstance1111, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227270691, "CC(remember):EditProfileScreen.kt#9igjgp");
            if ((1879048192 & i4) == 536870912) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(onFirstNameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i211111115 = i4 >> 3;
            final boolean z118 = z2;
            int i211111116 = i4;
            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(firstName, (Function1) objRememberedValue, "First Name", z5, str10, 0, modifierWeight$default1111, false, composerStartRestartGroup, (i4 & 14) | 384 | (i211111115 & 57344), 160);
            String str11115 = str10;
            if (str14 != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Modifier modifierWeight$default1112 = RowScope.weight$default(rowScopeInstance1111, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227280994, "CC(remember):EditProfileScreen.kt#9igjgp");
            if ((i14 & 14) == 4) {
                z8 = true;
            } else {
                z8 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z8) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(onLastNameChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i211111117 = i211111116 >> 6;
            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(lastName, (Function1) objRememberedValue2, "Last Name", z7, str14, 0, modifierWeight$default1112, false, composerStartRestartGroup, (i211111115 & 14) | 384 | (i211111117 & 57344), 160);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f16)), composerStartRestartGroup, 6);
            if (str12 != null) {
                z9 = true;
            } else {
                z9 = false;
            }
            int iM8360getPhonePjHm6EE16 = KeyboardType.INSTANCE.m8360getPhonePjHm6EE();
            Modifier modifierFillMaxWidth$default1111112 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621508311, "CC(remember):EditProfileScreen.kt#9igjgp");
            if ((i14 & 112) == 32) {
                z10 = true;
            } else {
                z10 = false;
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z10) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$36$lambda$35(onPhoneNumberChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i211111118 = 1769856 | (i211111117 & 14);
            int i211111119 = i211111116 >> 9;
            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(phoneNumber, (Function1) objRememberedValue3, "Phone Number", z9, str12, iM8360getPhonePjHm6EE16, modifierFillMaxWidth$default1111112, false, composerStartRestartGroup, i211111118 | (i211111119 & 57344), 128);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f16)), composerStartRestartGroup, 6);
            if (str13 != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            int iM8356getEmailPjHm6EE16 = KeyboardType.INSTANCE.m8356getEmailPjHm6EE();
            Modifier modifierFillMaxWidth$default1111113 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -621495901, "CC(remember):EditProfileScreen.kt#9igjgp");
            if ((i14 & 896) == 256) {
                z12 = true;
            } else {
                z12 = false;
            }
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!z12) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$38$lambda$37(onEmailChanged, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String str11116 = str13;
            ValidatedTextFieldKt.m9789ValidatedTextFieldCUnxt74(email, (Function1) objRememberedValue4, "Email", z11, str11116, iM8356getEmailPjHm6EE16, modifierFillMaxWidth$default1111113, false, composerStartRestartGroup, 1769856 | (i211111119 & 14) | ((i211111116 >> 12) & 57344), 128);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f16)), composerStartRestartGroup, 6);
            Modifier modifierFillMaxWidth$default1111114 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.Horizontal end16 = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical centerVertically16 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy1112 = RowKt.rowMeasurePolicy(end16, centerVertically16, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap11118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier11118 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default1111114);
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
            Updater.m5266setimpl(composerM5259constructorimpl3, measurePolicyRowMeasurePolicy1112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl3, currentCompositionLocalMap11118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl3.getInserting()) {
                composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
            } else {
                composerM5259constructorimpl3.updateRememberedValue(Integer.valueOf(iHashCode3));
                composerM5259constructorimpl3.apply(Integer.valueOf(iHashCode3), setCompositeKeyHash3);
            }
            Updater.m5266setimpl(composerM5259constructorimpl3, modifierMaterializeModifier11118, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance1112 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1490436984, "C183@7147L345:EditProfileScreen.kt#oif8tm");
            ButtonKt.TextButton(onChangePin, null, false, null, null, null, null, null, null, ComposableSingletons$EditProfileScreenKt.INSTANCE.m9838getLambda$1459862539$app_debug(), composerStartRestartGroup, ((i14 >> 12) & 14) | 805306368, 510);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(16)), composerStartRestartGroup, 6);
            CustomButtonKt.CustomButton(onUpdate, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, ComposableLambdaKt.rememberComposableLambda(-55633991, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditProfileScreenKt.EditProfileScreenContent$lambda$41$lambda$40(z118, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 9) & 14) | 24624, 12);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z118;
            str9 = str12;
            str6 = str14;
            str7 = str11116;
            str8 = str11115;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditProfileScreenKt.EditProfileScreenContent$lambda$42(firstName, lastName, phoneNumber, email, z4, str8, str6, str9, str7, onFirstNameChanged, onLastNameChanged, onPhoneNumberChanged, onEmailChanged, onUpdate, onChangePin, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreenContent$lambda$41$lambda$34$lambda$31$lambda$30(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreenContent$lambda$41$lambda$34$lambda$33$lambda$32(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreenContent$lambda$41$lambda$36$lambda$35(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreenContent$lambda$41$lambda$38$lambda$37(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreenContent$lambda$41$lambda$40(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:EditProfileScreen.kt#oif8tm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-55633991, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenContent.<anonymous>.<anonymous> (EditProfileScreen.kt:201)");
            }
            if (z) {
                composer.startReplaceGroup(465183888);
                ComposerKt.sourceInformation(composer, "202@7737L121");
                ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(32)), 0L, 0.0f, 0L, 0, 0.0f, composer, 6, 62);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(465347661);
                ComposerKt.sourceInformation(composer, "209@7981L10,207@7896L316");
                TextKt.m3864TextNvy7gAk("Update", PaddingKt.m1119paddingVpY3zN4(Modifier.INSTANCE, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 54, 0, 131068);
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

    private static final void EditProfileScreenPreview(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1526434648);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EditProfileScreenPreview)233@8630L2,234@8662L2,235@8697L2,236@8726L2,237@8749L2,238@8775L2,223@8335L449:EditProfileScreen.kt#oif8tm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1526434648, i, -1, "com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenPreview (EditProfileScreen.kt:222)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975106214, "CC(remember):EditProfileScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreenPreview$lambda$44$lambda$43((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975105190, "CC(remember):EditProfileScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreenPreview$lambda$46$lambda$45((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975104070, "CC(remember):EditProfileScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreenPreview$lambda$48$lambda$47((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function3 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975103142, "CC(remember):EditProfileScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EditProfileScreenKt.EditProfileScreenPreview$lambda$50$lambda$49((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function4 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975102406, "CC(remember):EditProfileScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function0 function0 = (Function0) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975101574, "CC(remember):EditProfileScreen.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            EditProfileScreenContent("", "", "", "", true, null, null, null, null, function1, function2, function3, function4, function0, (Function0) objRememberedValue6, composer2, 920350134, 28086, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.EditProfileScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EditProfileScreenKt.EditProfileScreenPreview$lambda$55(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreenPreview$lambda$44$lambda$43(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreenPreview$lambda$46$lambda$45(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreenPreview$lambda$48$lambda$47(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EditProfileScreenPreview$lambda$50$lambda$49(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private static final boolean EditProfileScreen$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String EditProfileScreen$lambda$1(State<String> state) {
        return state.getValue();
    }

    private static final String EditProfileScreen$lambda$2(State<String> state) {
        return state.getValue();
    }

    private static final String EditProfileScreen$lambda$3(State<String> state) {
        return state.getValue();
    }

    private static final String EditProfileScreen$lambda$4(State<String> state) {
        return state.getValue();
    }

    private static final String EditProfileScreen$lambda$5(State<String> state) {
        return state.getValue();
    }

    private static final String EditProfileScreen$lambda$6(State<String> state) {
        return state.getValue();
    }

    private static final String EditProfileScreen$lambda$7(State<String> state) {
        return state.getValue();
    }

    private static final String EditProfileScreen$lambda$8(State<String> state) {
        return state.getValue();
    }

    private static final String EditProfileScreen$lambda$9(State<String> state) {
        return state.getValue();
    }
}
