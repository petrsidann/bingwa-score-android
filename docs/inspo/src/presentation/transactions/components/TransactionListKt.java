package com.example.bingwahybrid.presentation.transactions.components;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.paging.LoadState;
import androidx.paging.compose.LazyPagingItems;
import androidx.profileinstaller.ProfileVerifier;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.enums.OfferType;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.presentation.transactions.dto.TransactionSource;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TransactionList.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\u001a\u0091\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000b2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u008e\u0002"}, d2 = {"TransactionList", "", "source", "Lcom/example/bingwahybrid/presentation/transactions/dto/TransactionSource;", "autoScroll", "", "selectionMode", "selectedTransactions", "", "Lcom/example/bingwahybrid/domain/model/Transaction;", "onTransactionClick", "Lkotlin/Function1;", "onRetry", "onLongPress", "onSelectToggle", "(Lcom/example/bingwahybrid/presentation/transactions/dto/TransactionSource;ZZLjava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "TransactionListPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "now", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TransactionListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionList$lambda$34(TransactionSource transactionSource, boolean z, boolean z2, Set set, Function1 function1, Function1 function2, Function1 function3, Function1 function4, int i, int i2, Composer composer, int i3) {
        TransactionList(transactionSource, z, z2, set, function1, function2, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionListPreview$lambda$43(int i, Composer composer, int i2) {
        TransactionListPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionList$lambda$1$lambda$0(Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionList$lambda$3$lambda$2(Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionList$lambda$5$lambda$4(Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionList$lambda$7$lambda$6(Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0126  */
    /* JADX WARN: Code duplicated, block: B:104:0x0138  */
    /* JADX WARN: Code duplicated, block: B:107:0x0147  */
    /* JADX WARN: Code duplicated, block: B:109:0x0159  */
    /* JADX WARN: Code duplicated, block: B:112:0x0168  */
    /* JADX WARN: Code duplicated, block: B:114:0x017a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0188  */
    /* JADX WARN: Code duplicated, block: B:118:0x018c  */
    /* JADX WARN: Code duplicated, block: B:120:0x019e  */
    /* JADX WARN: Code duplicated, block: B:122:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:125:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:128:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:131:0x0200  */
    /* JADX WARN: Code duplicated, block: B:134:0x021e  */
    /* JADX WARN: Code duplicated, block: B:135:0x0220  */
    /* JADX WARN: Code duplicated, block: B:138:0x0227  */
    /* JADX WARN: Code duplicated, block: B:139:0x0229  */
    /* JADX WARN: Code duplicated, block: B:142:0x0236  */
    /* JADX WARN: Code duplicated, block: B:144:0x023e  */
    /* JADX WARN: Code duplicated, block: B:147:0x0278  */
    /* JADX WARN: Code duplicated, block: B:148:0x027a  */
    /* JADX WARN: Code duplicated, block: B:151:0x0286  */
    /* JADX WARN: Code duplicated, block: B:152:0x0288  */
    /* JADX WARN: Code duplicated, block: B:155:0x0292  */
    /* JADX WARN: Code duplicated, block: B:156:0x0294  */
    /* JADX WARN: Code duplicated, block: B:159:0x029d  */
    /* JADX WARN: Code duplicated, block: B:160:0x029f  */
    /* JADX WARN: Code duplicated, block: B:163:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:164:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:168:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:171:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:175:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:178:0x030c  */
    /* JADX WARN: Code duplicated, block: B:180:0x0316  */
    /* JADX WARN: Code duplicated, block: B:183:0x032a  */
    /* JADX WARN: Code duplicated, block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0049  */
    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x005b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x0090  */
    /* JADX WARN: Code duplicated, block: B:51:0x0093  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00be  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00df  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:87:0x0105  */
    /* JADX WARN: Code duplicated, block: B:88:0x0107  */
    /* JADX WARN: Code duplicated, block: B:91:0x0110 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0112  */
    /* JADX WARN: Code duplicated, block: B:93:0x0114  */
    /* JADX WARN: Code duplicated, block: B:95:0x0117  */
    /* JADX WARN: Code duplicated, block: B:96:0x0119  */
    /* JADX WARN: Code duplicated, block: B:98:0x011c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0121  */
    public static final void TransactionList(final TransactionSource source, boolean z, boolean z2, Set<Transaction> set, Function1<? super Transaction, Unit> function1, Function1<? super Transaction, Unit> function2, Function1<? super Transaction, Unit> function3, Function1<? super Transaction, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        int i6;
        Set<Transaction> set2;
        int i7;
        int i8;
        Function1<? super Transaction, Unit> function5;
        int i9;
        int i10;
        Function1<? super Transaction, Unit> function6;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z5;
        Composer composer2;
        final Function1<? super Transaction, Unit> function7;
        final boolean z6;
        final boolean z7;
        final Set<Transaction> set3;
        final Function1<? super Transaction, Unit> function8;
        final Function1<? super Transaction, Unit> function9;
        final Function1<? super Transaction, Unit> function10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z8;
        boolean z9;
        Set<Transaction> setEmptySet;
        Function1<? super Transaction, Unit> function11;
        Function1<? super Transaction, Unit> function12;
        LazyListState lazyListStateRememberLazyListState;
        Object objRememberedValue;
        final MutableLongState mutableLongState;
        boolean z10;
        TransactionListKt$TransactionList$5$1 transactionListKt$TransactionList$5$1RememberedValue;
        Function1<? super Transaction, Unit> function13;
        Function1<? super Transaction, Unit> function14;
        int i16;
        boolean z11;
        boolean z12;
        boolean zChanged;
        TransactionListKt$TransactionList$6$1 transactionListKt$TransactionList$6$1RememberedValue;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        Object objRememberedValue2;
        final Function1<? super Transaction, Unit> function15;
        final Set<Transaction> set4;
        final Function1<? super Transaction, Unit> function16;
        final Function1<? super Transaction, Unit> function17;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        Object objRememberedValue6;
        Intrinsics.checkNotNullParameter(source, "source");
        Composer composerStartRestartGroup = composer.startRestartGroup(-312860661);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TransactionList)N(source,autoScroll,selectionMode,selectedTransactions,onTransactionClick,onRetry,onLongPress,onSelectToggle)44@2020L2,45@2061L2,46@2106L2,47@2154L2,49@2182L23,50@2221L59,52@2307L111,52@2286L132,59@2447L439,59@2424L462,79@3037L2941,75@2892L3086:TransactionList.kt#7qqvjm");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(source) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i17 = i2 & 2;
        if (i17 == 0) {
            if ((i & 48) == 0) {
                z3 = z;
                i3 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        set2 = set;
                        if (composerStartRestartGroup.changedInstance(set2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            function5 = function1;
                            if (composerStartRestartGroup.changedInstance(function5)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 32;
                        if (i10 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            function6 = function2;
                        } else {
                            function6 = function2;
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                if (composerStartRestartGroup.changedInstance(function6)) {
                                    i11 = 131072;
                                } else {
                                    i11 = 65536;
                                }
                                i3 |= i11;
                            }
                        }
                        i12 = i2 & 64;
                        if (i12 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i13 = 1048576;
                            } else {
                                i13 = 524288;
                            }
                            i3 |= i13;
                        }
                        i14 = i2 & 128;
                        if (i14 != 0) {
                            if ((i & 12582912) == 0) {
                                if (composerStartRestartGroup.changedInstance(function4)) {
                                    i15 = 8388608;
                                } else {
                                    i15 = 4194304;
                                }
                                i3 |= i15;
                            }
                            if ((i3 & 4793491) != 4793490) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                function7 = function3;
                                z6 = z3;
                                z7 = z4;
                                set3 = set2;
                                function8 = function6;
                                function9 = function5;
                                function10 = function4;
                            } else {
                                if (i17 != 0) {
                                    z8 = true;
                                } else {
                                    z8 = z3;
                                }
                                if (i4 != 0) {
                                    z9 = false;
                                } else {
                                    z9 = z4;
                                }
                                if (i6 != 0) {
                                    setEmptySet = SetsKt.emptySet();
                                } else {
                                    setEmptySet = set2;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                    }
                                    function5 = (Function1) objRememberedValue6;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                }
                                if (i10 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                    }
                                    function6 = (Function1) objRememberedValue5;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                }
                                if (i12 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                    }
                                    function11 = (Function1) objRememberedValue4;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    function11 = function3;
                                }
                                if (i14 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    function12 = (Function1) objRememberedValue3;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    function12 = function4;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                                }
                                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableLongState = (MutableLongState) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Unit unit = Unit.INSTANCE;
                                z10 = z9;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                                transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                function13 = function6;
                                function14 = function5;
                                if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                                i16 = i3 & 14;
                                if (i16 == 4) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if ((i3 & 112) == 32) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                                transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || transactionListKt$TransactionList$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_4 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                                boolean z19 = z8;
                                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Arrangement.HorizontalOrVertical horizontalOrVertical = horizontalOrVerticalM977spacedBy0680j_4;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                                if (i16 == 4) {
                                    z13 = true;
                                } else {
                                    z13 = false;
                                }
                                boolean zChangedInstance = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                                if ((i3 & 896) == 256) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                boolean z20 = zChangedInstance | z14;
                                if ((57344 & i3) == 16384) {
                                    z15 = true;
                                } else {
                                    z15 = false;
                                }
                                boolean z21 = z20 | z15;
                                if ((458752 & i3) == 131072) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                boolean z22 = z21 | z16;
                                if ((29360128 & i3) == 8388608) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                z18 = ((i3 & 3670016) == 1048576) | z22 | z17;
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!z18 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    z7 = z10;
                                    function15 = function13;
                                    set4 = setEmptySet;
                                    function7 = function11;
                                    function16 = function12;
                                    function17 = function14;
                                    Function1 function18 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(function18);
                                    objRememberedValue2 = function18;
                                } else {
                                    z7 = z10;
                                    function15 = function13;
                                    function17 = function14;
                                    set4 = setEmptySet;
                                    function7 = function11;
                                    function16 = function12;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composer2 = composerStartRestartGroup;
                                LazyDslKt.LazyColumn(modifierFillMaxSize$default, lazyListStateRememberLazyListState, null, false, horizontalOrVertical, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function10 = function16;
                                function8 = function15;
                                function9 = function17;
                                set3 = set4;
                                z6 = z19;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 12582912;
                        if ((i3 & 4793491) != 4793490) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function7 = function3;
                            z6 = z3;
                            z7 = z4;
                            set3 = set2;
                            function8 = function6;
                            function9 = function5;
                            function10 = function4;
                        } else {
                            if (i17 != 0) {
                                z8 = true;
                            } else {
                                z8 = z3;
                            }
                            if (i4 != 0) {
                                z9 = false;
                            } else {
                                z9 = z4;
                            }
                            if (i6 != 0) {
                                setEmptySet = SetsKt.emptySet();
                            } else {
                                setEmptySet = set2;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                function5 = (Function1) objRememberedValue6;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                function6 = (Function1) objRememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            if (i12 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                function11 = (Function1) objRememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function11 = function3;
                            }
                            if (i14 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                function12 = (Function1) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function12 = function4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                            }
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableLongState = (MutableLongState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Unit unit2 = Unit.INSTANCE;
                            z10 = z9;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                            transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            function13 = function6;
                            function14 = function5;
                            if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                            i16 = i3 & 14;
                            if (i16 == 4) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if ((i3 & 112) == 32) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                            transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                            } else {
                                transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_5 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                            boolean z110 = z8;
                            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.HorizontalOrVertical horizontalOrVertical2 = horizontalOrVerticalM977spacedBy0680j_5;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                            if (i16 == 4) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            boolean zChangedInstance2 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                            if ((i3 & 896) == 256) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            boolean z23 = zChangedInstance2 | z14;
                            if ((57344 & i3) == 16384) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            boolean z24 = z23 | z15;
                            if ((458752 & i3) == 131072) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            boolean z25 = z24 | z16;
                            if ((29360128 & i3) == 8388608) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            z18 = ((i3 & 3670016) == 1048576) | z25 | z17;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z18) {
                                z7 = z10;
                                function15 = function13;
                                set4 = setEmptySet;
                                function7 = function11;
                                function16 = function12;
                                function17 = function14;
                                Function1 function19 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(function19);
                                objRememberedValue2 = function19;
                            } else {
                                z7 = z10;
                                function15 = function13;
                                set4 = setEmptySet;
                                function7 = function11;
                                function16 = function12;
                                function17 = function14;
                                Function1 function110 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(function110);
                                objRememberedValue2 = function110;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            LazyDslKt.LazyColumn(modifierFillMaxSize$default2, lazyListStateRememberLazyListState, null, false, horizontalOrVertical2, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function10 = function16;
                            function8 = function15;
                            function9 = function17;
                            set3 = set4;
                            z6 = z110;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    function5 = function1;
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function6 = function2;
                    } else {
                        function6 = function2;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changedInstance(function6)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 128;
                    if (i14 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i15 = 8388608;
                            } else {
                                i15 = 4194304;
                            }
                            i3 |= i15;
                        }
                        if ((i3 & 4793491) != 4793490) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function7 = function3;
                            z6 = z3;
                            z7 = z4;
                            set3 = set2;
                            function8 = function6;
                            function9 = function5;
                            function10 = function4;
                        } else {
                            if (i17 != 0) {
                                z8 = true;
                            } else {
                                z8 = z3;
                            }
                            if (i4 != 0) {
                                z9 = false;
                            } else {
                                z9 = z4;
                            }
                            if (i6 != 0) {
                                setEmptySet = SetsKt.emptySet();
                            } else {
                                setEmptySet = set2;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                function5 = (Function1) objRememberedValue6;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                function6 = (Function1) objRememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            if (i12 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                function11 = (Function1) objRememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function11 = function3;
                            }
                            if (i14 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                function12 = (Function1) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function12 = function4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                            }
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableLongState = (MutableLongState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Unit unit3 = Unit.INSTANCE;
                            z10 = z9;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                            transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            function13 = function6;
                            function14 = function5;
                            if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                            i16 = i3 & 14;
                            if (i16 == 4) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if ((i3 & 112) == 32) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                            transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                            } else {
                                transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_6 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                            boolean z111 = z8;
                            Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.HorizontalOrVertical horizontalOrVertical3 = horizontalOrVerticalM977spacedBy0680j_6;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                            if (i16 == 4) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            boolean zChangedInstance3 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                            if ((i3 & 896) == 256) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            boolean z26 = zChangedInstance3 | z14;
                            if ((57344 & i3) == 16384) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            boolean z27 = z26 | z15;
                            if ((458752 & i3) == 131072) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            boolean z28 = z27 | z16;
                            if ((29360128 & i3) == 8388608) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            z18 = ((i3 & 3670016) == 1048576) | z28 | z17;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z18) {
                                z7 = z10;
                                function15 = function13;
                                set4 = setEmptySet;
                                function7 = function11;
                                function16 = function12;
                                function17 = function14;
                                Function1 function111 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(function111);
                                objRememberedValue2 = function111;
                            } else {
                                z7 = z10;
                                function15 = function13;
                                set4 = setEmptySet;
                                function7 = function11;
                                function16 = function12;
                                function17 = function14;
                                Function1 function112 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(function112);
                                objRememberedValue2 = function112;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            LazyDslKt.LazyColumn(modifierFillMaxSize$default3, lazyListStateRememberLazyListState, null, false, horizontalOrVertical3, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function10 = function16;
                            function8 = function15;
                            function9 = function17;
                            set3 = set4;
                            z6 = z111;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i3 & 4793491) != 4793490) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function7 = function3;
                        z6 = z3;
                        z7 = z4;
                        set3 = set2;
                        function8 = function6;
                        function9 = function5;
                        function10 = function4;
                    } else {
                        if (i17 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if (i4 != 0) {
                            z9 = false;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            setEmptySet = SetsKt.emptySet();
                        } else {
                            setEmptySet = set2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            function5 = (Function1) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function6 = (Function1) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i12 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            function11 = (Function1) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function11 = function3;
                        }
                        if (i14 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function12 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                        }
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableLongState = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Unit unit4 = Unit.INSTANCE;
                        z10 = z9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                        transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        function13 = function6;
                        function14 = function5;
                        if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                        i16 = i3 & 14;
                        if (i16 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if ((i3 & 112) == 32) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                        transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        } else {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_7 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                        boolean z112 = z8;
                        Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVertical4 = horizontalOrVerticalM977spacedBy0680j_7;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                        if (i16 == 4) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean zChangedInstance4 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                        if ((i3 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        boolean z29 = zChangedInstance4 | z14;
                        if ((57344 & i3) == 16384) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        boolean z210 = z29 | z15;
                        if ((458752 & i3) == 131072) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        boolean z211 = z210 | z16;
                        if ((29360128 & i3) == 8388608) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        z18 = ((i3 & 3670016) == 1048576) | z211 | z17;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function113 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function113);
                            objRememberedValue2 = function113;
                        } else {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function114 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function114);
                            objRememberedValue2 = function114;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        LazyDslKt.LazyColumn(modifierFillMaxSize$default4, lazyListStateRememberLazyListState, null, false, horizontalOrVertical4, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function10 = function16;
                        function8 = function15;
                        function9 = function17;
                        set3 = set4;
                        z6 = z112;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                set2 = set;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function5 = function1;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function6 = function2;
                    } else {
                        function6 = function2;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changedInstance(function6)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 128;
                    if (i14 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i15 = 8388608;
                            } else {
                                i15 = 4194304;
                            }
                            i3 |= i15;
                        }
                        if ((i3 & 4793491) != 4793490) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function7 = function3;
                            z6 = z3;
                            z7 = z4;
                            set3 = set2;
                            function8 = function6;
                            function9 = function5;
                            function10 = function4;
                        } else {
                            if (i17 != 0) {
                                z8 = true;
                            } else {
                                z8 = z3;
                            }
                            if (i4 != 0) {
                                z9 = false;
                            } else {
                                z9 = z4;
                            }
                            if (i6 != 0) {
                                setEmptySet = SetsKt.emptySet();
                            } else {
                                setEmptySet = set2;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                function5 = (Function1) objRememberedValue6;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                function6 = (Function1) objRememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            if (i12 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                function11 = (Function1) objRememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function11 = function3;
                            }
                            if (i14 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                function12 = (Function1) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function12 = function4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                            }
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableLongState = (MutableLongState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Unit unit5 = Unit.INSTANCE;
                            z10 = z9;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                            transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            function13 = function6;
                            function14 = function5;
                            if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(unit5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                            i16 = i3 & 14;
                            if (i16 == 4) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if ((i3 & 112) == 32) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                            transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                            } else {
                                transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_8 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                            boolean z113 = z8;
                            Modifier modifierFillMaxSize$default5 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.HorizontalOrVertical horizontalOrVertical5 = horizontalOrVerticalM977spacedBy0680j_8;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                            if (i16 == 4) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            boolean zChangedInstance5 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                            if ((i3 & 896) == 256) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            boolean z212 = zChangedInstance5 | z14;
                            if ((57344 & i3) == 16384) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            boolean z213 = z212 | z15;
                            if ((458752 & i3) == 131072) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            boolean z214 = z213 | z16;
                            if ((29360128 & i3) == 8388608) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            z18 = ((i3 & 3670016) == 1048576) | z214 | z17;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z18) {
                                z7 = z10;
                                function15 = function13;
                                set4 = setEmptySet;
                                function7 = function11;
                                function16 = function12;
                                function17 = function14;
                                Function1 function115 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(function115);
                                objRememberedValue2 = function115;
                            } else {
                                z7 = z10;
                                function15 = function13;
                                set4 = setEmptySet;
                                function7 = function11;
                                function16 = function12;
                                function17 = function14;
                                Function1 function116 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(function116);
                                objRememberedValue2 = function116;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            LazyDslKt.LazyColumn(modifierFillMaxSize$default5, lazyListStateRememberLazyListState, null, false, horizontalOrVertical5, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function10 = function16;
                            function8 = function15;
                            function9 = function17;
                            set3 = set4;
                            z6 = z113;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i3 & 4793491) != 4793490) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function7 = function3;
                        z6 = z3;
                        z7 = z4;
                        set3 = set2;
                        function8 = function6;
                        function9 = function5;
                        function10 = function4;
                    } else {
                        if (i17 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if (i4 != 0) {
                            z9 = false;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            setEmptySet = SetsKt.emptySet();
                        } else {
                            setEmptySet = set2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            function5 = (Function1) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function6 = (Function1) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i12 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            function11 = (Function1) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function11 = function3;
                        }
                        if (i14 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function12 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                        }
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableLongState = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Unit unit6 = Unit.INSTANCE;
                        z10 = z9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                        transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        function13 = function6;
                        function14 = function5;
                        if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                        i16 = i3 & 14;
                        if (i16 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if ((i3 & 112) == 32) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                        transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        } else {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_9 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                        boolean z114 = z8;
                        Modifier modifierFillMaxSize$default6 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVertical6 = horizontalOrVerticalM977spacedBy0680j_9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                        if (i16 == 4) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean zChangedInstance6 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                        if ((i3 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        boolean z215 = zChangedInstance6 | z14;
                        if ((57344 & i3) == 16384) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        boolean z216 = z215 | z15;
                        if ((458752 & i3) == 131072) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        boolean z217 = z216 | z16;
                        if ((29360128 & i3) == 8388608) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        z18 = ((i3 & 3670016) == 1048576) | z217 | z17;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function117 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function117);
                            objRememberedValue2 = function117;
                        } else {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function118 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function118);
                            objRememberedValue2 = function118;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        LazyDslKt.LazyColumn(modifierFillMaxSize$default6, lazyListStateRememberLazyListState, null, false, horizontalOrVertical6, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function10 = function16;
                        function8 = function15;
                        function9 = function17;
                        set3 = set4;
                        z6 = z114;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function5 = function1;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function6 = function2;
                } else {
                    function6 = function2;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function7 = function3;
                        z6 = z3;
                        z7 = z4;
                        set3 = set2;
                        function8 = function6;
                        function9 = function5;
                        function10 = function4;
                    } else {
                        if (i17 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if (i4 != 0) {
                            z9 = false;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            setEmptySet = SetsKt.emptySet();
                        } else {
                            setEmptySet = set2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            function5 = (Function1) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function6 = (Function1) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i12 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            function11 = (Function1) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function11 = function3;
                        }
                        if (i14 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function12 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                        }
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableLongState = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Unit unit7 = Unit.INSTANCE;
                        z10 = z9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                        transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        function13 = function6;
                        function14 = function5;
                        if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                        i16 = i3 & 14;
                        if (i16 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if ((i3 & 112) == 32) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                        transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        } else {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_10 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                        boolean z115 = z8;
                        Modifier modifierFillMaxSize$default7 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVertical7 = horizontalOrVerticalM977spacedBy0680j_10;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                        if (i16 == 4) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean zChangedInstance7 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                        if ((i3 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        boolean z218 = zChangedInstance7 | z14;
                        if ((57344 & i3) == 16384) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        boolean z219 = z218 | z15;
                        if ((458752 & i3) == 131072) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        boolean z2110 = z219 | z16;
                        if ((29360128 & i3) == 8388608) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        z18 = ((i3 & 3670016) == 1048576) | z2110 | z17;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function119 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function119);
                            objRememberedValue2 = function119;
                        } else {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function1110 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function1110);
                            objRememberedValue2 = function1110;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        LazyDslKt.LazyColumn(modifierFillMaxSize$default7, lazyListStateRememberLazyListState, null, false, horizontalOrVertical7, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function10 = function16;
                        function8 = function15;
                        function9 = function17;
                        set3 = set4;
                        z6 = z115;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) != 4793490) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function3;
                    z6 = z3;
                    z7 = z4;
                    set3 = set2;
                    function8 = function6;
                    function9 = function5;
                    function10 = function4;
                } else {
                    if (i17 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        z9 = false;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        setEmptySet = SetsKt.emptySet();
                    } else {
                        setEmptySet = set2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        function5 = (Function1) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function6 = (Function1) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function11 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function11 = function3;
                    }
                    if (i14 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function12 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                    }
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableLongState = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit8 = Unit.INSTANCE;
                    z10 = z9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                    transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    function13 = function6;
                    function14 = function5;
                    if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                    i16 = i3 & 14;
                    if (i16 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if ((i3 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                    transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    } else {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_11 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                    boolean z116 = z8;
                    Modifier modifierFillMaxSize$default8 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVertical8 = horizontalOrVerticalM977spacedBy0680j_11;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                    if (i16 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean zChangedInstance8 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                    if ((i3 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z2111 = zChangedInstance8 | z14;
                    if ((57344 & i3) == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z2112 = z2111 | z15;
                    if ((458752 & i3) == 131072) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean z2113 = z2112 | z16;
                    if ((29360128 & i3) == 8388608) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 = ((i3 & 3670016) == 1048576) | z2113 | z17;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function1111 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function1111);
                        objRememberedValue2 = function1111;
                    } else {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function1112 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function1112);
                        objRememberedValue2 = function1112;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default8, lazyListStateRememberLazyListState, null, false, horizontalOrVertical8, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function10 = function16;
                    function8 = function15;
                    function9 = function17;
                    set3 = set4;
                    z6 = z116;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z4 = z2;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    set2 = set;
                    if (composerStartRestartGroup.changedInstance(set2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function5 = function1;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function6 = function2;
                    } else {
                        function6 = function2;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changedInstance(function6)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 128;
                    if (i14 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i15 = 8388608;
                            } else {
                                i15 = 4194304;
                            }
                            i3 |= i15;
                        }
                        if ((i3 & 4793491) != 4793490) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function7 = function3;
                            z6 = z3;
                            z7 = z4;
                            set3 = set2;
                            function8 = function6;
                            function9 = function5;
                            function10 = function4;
                        } else {
                            if (i17 != 0) {
                                z8 = true;
                            } else {
                                z8 = z3;
                            }
                            if (i4 != 0) {
                                z9 = false;
                            } else {
                                z9 = z4;
                            }
                            if (i6 != 0) {
                                setEmptySet = SetsKt.emptySet();
                            } else {
                                setEmptySet = set2;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                function5 = (Function1) objRememberedValue6;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                function6 = (Function1) objRememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            if (i12 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                function11 = (Function1) objRememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function11 = function3;
                            }
                            if (i14 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                function12 = (Function1) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function12 = function4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                            }
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableLongState = (MutableLongState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Unit unit9 = Unit.INSTANCE;
                            z10 = z9;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                            transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            function13 = function6;
                            function14 = function5;
                            if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(unit9, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                            i16 = i3 & 14;
                            if (i16 == 4) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if ((i3 & 112) == 32) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                            transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                            } else {
                                transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_12 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                            boolean z117 = z8;
                            Modifier modifierFillMaxSize$default9 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.HorizontalOrVertical horizontalOrVertical9 = horizontalOrVerticalM977spacedBy0680j_12;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                            if (i16 == 4) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            boolean zChangedInstance9 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                            if ((i3 & 896) == 256) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            boolean z2114 = zChangedInstance9 | z14;
                            if ((57344 & i3) == 16384) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            boolean z2115 = z2114 | z15;
                            if ((458752 & i3) == 131072) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            boolean z2116 = z2115 | z16;
                            if ((29360128 & i3) == 8388608) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            z18 = ((i3 & 3670016) == 1048576) | z2116 | z17;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z18) {
                                z7 = z10;
                                function15 = function13;
                                set4 = setEmptySet;
                                function7 = function11;
                                function16 = function12;
                                function17 = function14;
                                Function1 function1113 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(function1113);
                                objRememberedValue2 = function1113;
                            } else {
                                z7 = z10;
                                function15 = function13;
                                set4 = setEmptySet;
                                function7 = function11;
                                function16 = function12;
                                function17 = function14;
                                Function1 function1114 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(function1114);
                                objRememberedValue2 = function1114;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            LazyDslKt.LazyColumn(modifierFillMaxSize$default9, lazyListStateRememberLazyListState, null, false, horizontalOrVertical9, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function10 = function16;
                            function8 = function15;
                            function9 = function17;
                            set3 = set4;
                            z6 = z117;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i3 & 4793491) != 4793490) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function7 = function3;
                        z6 = z3;
                        z7 = z4;
                        set3 = set2;
                        function8 = function6;
                        function9 = function5;
                        function10 = function4;
                    } else {
                        if (i17 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if (i4 != 0) {
                            z9 = false;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            setEmptySet = SetsKt.emptySet();
                        } else {
                            setEmptySet = set2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            function5 = (Function1) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function6 = (Function1) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i12 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            function11 = (Function1) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function11 = function3;
                        }
                        if (i14 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function12 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                        }
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableLongState = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Unit unit10 = Unit.INSTANCE;
                        z10 = z9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                        transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        function13 = function6;
                        function14 = function5;
                        if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit10, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                        i16 = i3 & 14;
                        if (i16 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if ((i3 & 112) == 32) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                        transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        } else {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_13 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                        boolean z118 = z8;
                        Modifier modifierFillMaxSize$default10 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVertical10 = horizontalOrVerticalM977spacedBy0680j_13;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                        if (i16 == 4) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean zChangedInstance10 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                        if ((i3 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        boolean z2117 = zChangedInstance10 | z14;
                        if ((57344 & i3) == 16384) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        boolean z2118 = z2117 | z15;
                        if ((458752 & i3) == 131072) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        boolean z2119 = z2118 | z16;
                        if ((29360128 & i3) == 8388608) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        z18 = ((i3 & 3670016) == 1048576) | z2119 | z17;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function1115 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function1115);
                            objRememberedValue2 = function1115;
                        } else {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function1116 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function1116);
                            objRememberedValue2 = function1116;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        LazyDslKt.LazyColumn(modifierFillMaxSize$default10, lazyListStateRememberLazyListState, null, false, horizontalOrVertical10, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function10 = function16;
                        function8 = function15;
                        function9 = function17;
                        set3 = set4;
                        z6 = z118;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function5 = function1;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function6 = function2;
                } else {
                    function6 = function2;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function7 = function3;
                        z6 = z3;
                        z7 = z4;
                        set3 = set2;
                        function8 = function6;
                        function9 = function5;
                        function10 = function4;
                    } else {
                        if (i17 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if (i4 != 0) {
                            z9 = false;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            setEmptySet = SetsKt.emptySet();
                        } else {
                            setEmptySet = set2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            function5 = (Function1) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function6 = (Function1) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i12 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            function11 = (Function1) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function11 = function3;
                        }
                        if (i14 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function12 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                        }
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableLongState = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Unit unit11 = Unit.INSTANCE;
                        z10 = z9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                        transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        function13 = function6;
                        function14 = function5;
                        if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit11, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                        i16 = i3 & 14;
                        if (i16 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if ((i3 & 112) == 32) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                        transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        } else {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_14 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                        boolean z119 = z8;
                        Modifier modifierFillMaxSize$default11 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVertical11 = horizontalOrVerticalM977spacedBy0680j_14;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                        if (i16 == 4) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean zChangedInstance11 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                        if ((i3 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        boolean z21110 = zChangedInstance11 | z14;
                        if ((57344 & i3) == 16384) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        boolean z21111 = z21110 | z15;
                        if ((458752 & i3) == 131072) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        boolean z21112 = z21111 | z16;
                        if ((29360128 & i3) == 8388608) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        z18 = ((i3 & 3670016) == 1048576) | z21112 | z17;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function1117 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function1117);
                            objRememberedValue2 = function1117;
                        } else {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function1118 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function1118);
                            objRememberedValue2 = function1118;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        LazyDslKt.LazyColumn(modifierFillMaxSize$default11, lazyListStateRememberLazyListState, null, false, horizontalOrVertical11, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function10 = function16;
                        function8 = function15;
                        function9 = function17;
                        set3 = set4;
                        z6 = z119;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) != 4793490) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function3;
                    z6 = z3;
                    z7 = z4;
                    set3 = set2;
                    function8 = function6;
                    function9 = function5;
                    function10 = function4;
                } else {
                    if (i17 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        z9 = false;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        setEmptySet = SetsKt.emptySet();
                    } else {
                        setEmptySet = set2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        function5 = (Function1) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function6 = (Function1) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function11 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function11 = function3;
                    }
                    if (i14 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function12 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                    }
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableLongState = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit12 = Unit.INSTANCE;
                    z10 = z9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                    transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    function13 = function6;
                    function14 = function5;
                    if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit12, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                    i16 = i3 & 14;
                    if (i16 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if ((i3 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                    transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    } else {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_15 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                    boolean z1110 = z8;
                    Modifier modifierFillMaxSize$default12 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVertical12 = horizontalOrVerticalM977spacedBy0680j_15;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                    if (i16 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean zChangedInstance12 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                    if ((i3 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z21113 = zChangedInstance12 | z14;
                    if ((57344 & i3) == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z21114 = z21113 | z15;
                    if ((458752 & i3) == 131072) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean z21115 = z21114 | z16;
                    if ((29360128 & i3) == 8388608) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 = ((i3 & 3670016) == 1048576) | z21115 | z17;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function1119 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function1119);
                        objRememberedValue2 = function1119;
                    } else {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function11110 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function11110);
                        objRememberedValue2 = function11110;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default12, lazyListStateRememberLazyListState, null, false, horizontalOrVertical12, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function10 = function16;
                    function8 = function15;
                    function9 = function17;
                    set3 = set4;
                    z6 = z1110;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            set2 = set;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function5 = function1;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function6 = function2;
                } else {
                    function6 = function2;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function7 = function3;
                        z6 = z3;
                        z7 = z4;
                        set3 = set2;
                        function8 = function6;
                        function9 = function5;
                        function10 = function4;
                    } else {
                        if (i17 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if (i4 != 0) {
                            z9 = false;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            setEmptySet = SetsKt.emptySet();
                        } else {
                            setEmptySet = set2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            function5 = (Function1) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function6 = (Function1) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i12 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            function11 = (Function1) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function11 = function3;
                        }
                        if (i14 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function12 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                        }
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableLongState = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Unit unit13 = Unit.INSTANCE;
                        z10 = z9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                        transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        function13 = function6;
                        function14 = function5;
                        if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit13, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                        i16 = i3 & 14;
                        if (i16 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if ((i3 & 112) == 32) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                        transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        } else {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_16 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                        boolean z1111 = z8;
                        Modifier modifierFillMaxSize$default13 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVertical13 = horizontalOrVerticalM977spacedBy0680j_16;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                        if (i16 == 4) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean zChangedInstance13 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                        if ((i3 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        boolean z21116 = zChangedInstance13 | z14;
                        if ((57344 & i3) == 16384) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        boolean z21117 = z21116 | z15;
                        if ((458752 & i3) == 131072) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        boolean z21118 = z21117 | z16;
                        if ((29360128 & i3) == 8388608) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        z18 = ((i3 & 3670016) == 1048576) | z21118 | z17;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function11111 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function11111);
                            objRememberedValue2 = function11111;
                        } else {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function11112 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function11112);
                            objRememberedValue2 = function11112;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        LazyDslKt.LazyColumn(modifierFillMaxSize$default13, lazyListStateRememberLazyListState, null, false, horizontalOrVertical13, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function10 = function16;
                        function8 = function15;
                        function9 = function17;
                        set3 = set4;
                        z6 = z1111;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) != 4793490) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function3;
                    z6 = z3;
                    z7 = z4;
                    set3 = set2;
                    function8 = function6;
                    function9 = function5;
                    function10 = function4;
                } else {
                    if (i17 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        z9 = false;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        setEmptySet = SetsKt.emptySet();
                    } else {
                        setEmptySet = set2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        function5 = (Function1) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function6 = (Function1) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function11 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function11 = function3;
                    }
                    if (i14 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function12 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                    }
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableLongState = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit14 = Unit.INSTANCE;
                    z10 = z9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                    transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    function13 = function6;
                    function14 = function5;
                    if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit14, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                    i16 = i3 & 14;
                    if (i16 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if ((i3 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                    transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    } else {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_17 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                    boolean z1112 = z8;
                    Modifier modifierFillMaxSize$default14 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVertical14 = horizontalOrVerticalM977spacedBy0680j_17;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                    if (i16 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean zChangedInstance14 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                    if ((i3 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z21119 = zChangedInstance14 | z14;
                    if ((57344 & i3) == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z211110 = z21119 | z15;
                    if ((458752 & i3) == 131072) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean z211111 = z211110 | z16;
                    if ((29360128 & i3) == 8388608) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 = ((i3 & 3670016) == 1048576) | z211111 | z17;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function11113 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function11113);
                        objRememberedValue2 = function11113;
                    } else {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function11114 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function11114);
                        objRememberedValue2 = function11114;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default14, lazyListStateRememberLazyListState, null, false, horizontalOrVertical14, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function10 = function16;
                    function8 = function15;
                    function9 = function17;
                    set3 = set4;
                    z6 = z1112;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function5 = function1;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function6 = function2;
            } else {
                function6 = function2;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                if ((i3 & 4793491) != 4793490) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function3;
                    z6 = z3;
                    z7 = z4;
                    set3 = set2;
                    function8 = function6;
                    function9 = function5;
                    function10 = function4;
                } else {
                    if (i17 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        z9 = false;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        setEmptySet = SetsKt.emptySet();
                    } else {
                        setEmptySet = set2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        function5 = (Function1) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function6 = (Function1) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function11 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function11 = function3;
                    }
                    if (i14 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function12 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                    }
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableLongState = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit15 = Unit.INSTANCE;
                    z10 = z9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                    transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    function13 = function6;
                    function14 = function5;
                    if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit15, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                    i16 = i3 & 14;
                    if (i16 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if ((i3 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                    transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    } else {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_18 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                    boolean z1113 = z8;
                    Modifier modifierFillMaxSize$default15 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVertical15 = horizontalOrVerticalM977spacedBy0680j_18;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                    if (i16 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean zChangedInstance15 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                    if ((i3 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z211112 = zChangedInstance15 | z14;
                    if ((57344 & i3) == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z211113 = z211112 | z15;
                    if ((458752 & i3) == 131072) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean z211114 = z211113 | z16;
                    if ((29360128 & i3) == 8388608) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 = ((i3 & 3670016) == 1048576) | z211114 | z17;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function11115 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function11115);
                        objRememberedValue2 = function11115;
                    } else {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function11116 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function11116);
                        objRememberedValue2 = function11116;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default15, lazyListStateRememberLazyListState, null, false, horizontalOrVertical15, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function10 = function16;
                    function8 = function15;
                    function9 = function17;
                    set3 = set4;
                    z6 = z1113;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i3 & 4793491) != 4793490) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function7 = function3;
                z6 = z3;
                z7 = z4;
                set3 = set2;
                function8 = function6;
                function9 = function5;
                function10 = function4;
            } else {
                if (i17 != 0) {
                    z8 = true;
                } else {
                    z8 = z3;
                }
                if (i4 != 0) {
                    z9 = false;
                } else {
                    z9 = z4;
                }
                if (i6 != 0) {
                    setEmptySet = SetsKt.emptySet();
                } else {
                    setEmptySet = set2;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    function5 = (Function1) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    function6 = (Function1) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (i12 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    function11 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function11 = function3;
                }
                if (i14 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function12 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function12 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                }
                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableLongState = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit16 = Unit.INSTANCE;
                z10 = z9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                function13 = function6;
                function14 = function5;
                if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit16, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                i16 = i3 & 14;
                if (i16 == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((i3 & 112) == 32) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                } else {
                    transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_19 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                boolean z1114 = z8;
                Modifier modifierFillMaxSize$default16 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical horizontalOrVertical16 = horizontalOrVerticalM977spacedBy0680j_19;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                if (i16 == 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean zChangedInstance16 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                if ((i3 & 896) == 256) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                boolean z211115 = zChangedInstance16 | z14;
                if ((57344 & i3) == 16384) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                boolean z211116 = z211115 | z15;
                if ((458752 & i3) == 131072) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean z211117 = z211116 | z16;
                if ((29360128 & i3) == 8388608) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                z18 = ((i3 & 3670016) == 1048576) | z211117 | z17;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z18) {
                    z7 = z10;
                    function15 = function13;
                    set4 = setEmptySet;
                    function7 = function11;
                    function16 = function12;
                    function17 = function14;
                    Function1 function11117 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function11117);
                    objRememberedValue2 = function11117;
                } else {
                    z7 = z10;
                    function15 = function13;
                    set4 = setEmptySet;
                    function7 = function11;
                    function16 = function12;
                    function17 = function14;
                    Function1 function11118 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function11118);
                    objRememberedValue2 = function11118;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                LazyDslKt.LazyColumn(modifierFillMaxSize$default16, lazyListStateRememberLazyListState, null, false, horizontalOrVertical16, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function10 = function16;
                function8 = function15;
                function9 = function17;
                set3 = set4;
                z6 = z1114;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z3 = z;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    set2 = set;
                    if (composerStartRestartGroup.changedInstance(set2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function5 = function1;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function6 = function2;
                    } else {
                        function6 = function2;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changedInstance(function6)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 128;
                    if (i14 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i15 = 8388608;
                            } else {
                                i15 = 4194304;
                            }
                            i3 |= i15;
                        }
                        if ((i3 & 4793491) != 4793490) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function7 = function3;
                            z6 = z3;
                            z7 = z4;
                            set3 = set2;
                            function8 = function6;
                            function9 = function5;
                            function10 = function4;
                        } else {
                            if (i17 != 0) {
                                z8 = true;
                            } else {
                                z8 = z3;
                            }
                            if (i4 != 0) {
                                z9 = false;
                            } else {
                                z9 = z4;
                            }
                            if (i6 != 0) {
                                setEmptySet = SetsKt.emptySet();
                            } else {
                                setEmptySet = set2;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                function5 = (Function1) objRememberedValue6;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                function6 = (Function1) objRememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            if (i12 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                function11 = (Function1) objRememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function11 = function3;
                            }
                            if (i14 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                function12 = (Function1) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function12 = function4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                            }
                            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableLongState = (MutableLongState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Unit unit17 = Unit.INSTANCE;
                            z10 = z9;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                            transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            function13 = function6;
                            function14 = function5;
                            if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(unit17, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                            i16 = i3 & 14;
                            if (i16 == 4) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if ((i3 & 112) == 32) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                            transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                            } else {
                                transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_110 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                            boolean z1115 = z8;
                            Modifier modifierFillMaxSize$default17 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.HorizontalOrVertical horizontalOrVertical17 = horizontalOrVerticalM977spacedBy0680j_110;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                            if (i16 == 4) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            boolean zChangedInstance17 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                            if ((i3 & 896) == 256) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            boolean z211118 = zChangedInstance17 | z14;
                            if ((57344 & i3) == 16384) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            boolean z211119 = z211118 | z15;
                            if ((458752 & i3) == 131072) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            boolean z2111110 = z211119 | z16;
                            if ((29360128 & i3) == 8388608) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            z18 = ((i3 & 3670016) == 1048576) | z2111110 | z17;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z18) {
                                z7 = z10;
                                function15 = function13;
                                set4 = setEmptySet;
                                function7 = function11;
                                function16 = function12;
                                function17 = function14;
                                Function1 function11119 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(function11119);
                                objRememberedValue2 = function11119;
                            } else {
                                z7 = z10;
                                function15 = function13;
                                set4 = setEmptySet;
                                function7 = function11;
                                function16 = function12;
                                function17 = function14;
                                Function1 function111110 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(function111110);
                                objRememberedValue2 = function111110;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            LazyDslKt.LazyColumn(modifierFillMaxSize$default17, lazyListStateRememberLazyListState, null, false, horizontalOrVertical17, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function10 = function16;
                            function8 = function15;
                            function9 = function17;
                            set3 = set4;
                            z6 = z1115;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i3 & 4793491) != 4793490) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function7 = function3;
                        z6 = z3;
                        z7 = z4;
                        set3 = set2;
                        function8 = function6;
                        function9 = function5;
                        function10 = function4;
                    } else {
                        if (i17 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if (i4 != 0) {
                            z9 = false;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            setEmptySet = SetsKt.emptySet();
                        } else {
                            setEmptySet = set2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            function5 = (Function1) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function6 = (Function1) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i12 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            function11 = (Function1) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function11 = function3;
                        }
                        if (i14 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function12 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                        }
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableLongState = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Unit unit18 = Unit.INSTANCE;
                        z10 = z9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                        transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        function13 = function6;
                        function14 = function5;
                        if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit18, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                        i16 = i3 & 14;
                        if (i16 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if ((i3 & 112) == 32) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                        transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        } else {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_111 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                        boolean z1116 = z8;
                        Modifier modifierFillMaxSize$default18 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVertical18 = horizontalOrVerticalM977spacedBy0680j_111;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                        if (i16 == 4) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean zChangedInstance18 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                        if ((i3 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        boolean z2111111 = zChangedInstance18 | z14;
                        if ((57344 & i3) == 16384) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        boolean z2111112 = z2111111 | z15;
                        if ((458752 & i3) == 131072) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        boolean z2111113 = z2111112 | z16;
                        if ((29360128 & i3) == 8388608) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        z18 = ((i3 & 3670016) == 1048576) | z2111113 | z17;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function111111 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function111111);
                            objRememberedValue2 = function111111;
                        } else {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function111112 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function111112);
                            objRememberedValue2 = function111112;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        LazyDslKt.LazyColumn(modifierFillMaxSize$default18, lazyListStateRememberLazyListState, null, false, horizontalOrVertical18, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function10 = function16;
                        function8 = function15;
                        function9 = function17;
                        set3 = set4;
                        z6 = z1116;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function5 = function1;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function6 = function2;
                } else {
                    function6 = function2;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function7 = function3;
                        z6 = z3;
                        z7 = z4;
                        set3 = set2;
                        function8 = function6;
                        function9 = function5;
                        function10 = function4;
                    } else {
                        if (i17 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if (i4 != 0) {
                            z9 = false;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            setEmptySet = SetsKt.emptySet();
                        } else {
                            setEmptySet = set2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            function5 = (Function1) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function6 = (Function1) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i12 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            function11 = (Function1) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function11 = function3;
                        }
                        if (i14 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function12 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                        }
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableLongState = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Unit unit19 = Unit.INSTANCE;
                        z10 = z9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                        transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        function13 = function6;
                        function14 = function5;
                        if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit19, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                        i16 = i3 & 14;
                        if (i16 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if ((i3 & 112) == 32) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                        transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        } else {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_112 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                        boolean z1117 = z8;
                        Modifier modifierFillMaxSize$default19 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVertical19 = horizontalOrVerticalM977spacedBy0680j_112;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                        if (i16 == 4) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean zChangedInstance19 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                        if ((i3 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        boolean z2111114 = zChangedInstance19 | z14;
                        if ((57344 & i3) == 16384) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        boolean z2111115 = z2111114 | z15;
                        if ((458752 & i3) == 131072) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        boolean z2111116 = z2111115 | z16;
                        if ((29360128 & i3) == 8388608) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        z18 = ((i3 & 3670016) == 1048576) | z2111116 | z17;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function111113 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function111113);
                            objRememberedValue2 = function111113;
                        } else {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function111114 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function111114);
                            objRememberedValue2 = function111114;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        LazyDslKt.LazyColumn(modifierFillMaxSize$default19, lazyListStateRememberLazyListState, null, false, horizontalOrVertical19, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function10 = function16;
                        function8 = function15;
                        function9 = function17;
                        set3 = set4;
                        z6 = z1117;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) != 4793490) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function3;
                    z6 = z3;
                    z7 = z4;
                    set3 = set2;
                    function8 = function6;
                    function9 = function5;
                    function10 = function4;
                } else {
                    if (i17 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        z9 = false;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        setEmptySet = SetsKt.emptySet();
                    } else {
                        setEmptySet = set2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        function5 = (Function1) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function6 = (Function1) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function11 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function11 = function3;
                    }
                    if (i14 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function12 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                    }
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableLongState = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit110 = Unit.INSTANCE;
                    z10 = z9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                    transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    function13 = function6;
                    function14 = function5;
                    if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit110, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                    i16 = i3 & 14;
                    if (i16 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if ((i3 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                    transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    } else {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_113 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                    boolean z1118 = z8;
                    Modifier modifierFillMaxSize$default110 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVertical110 = horizontalOrVerticalM977spacedBy0680j_113;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                    if (i16 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean zChangedInstance110 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                    if ((i3 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z2111117 = zChangedInstance110 | z14;
                    if ((57344 & i3) == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z2111118 = z2111117 | z15;
                    if ((458752 & i3) == 131072) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean z2111119 = z2111118 | z16;
                    if ((29360128 & i3) == 8388608) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 = ((i3 & 3670016) == 1048576) | z2111119 | z17;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function111115 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function111115);
                        objRememberedValue2 = function111115;
                    } else {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function111116 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function111116);
                        objRememberedValue2 = function111116;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default110, lazyListStateRememberLazyListState, null, false, horizontalOrVertical110, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function10 = function16;
                    function8 = function15;
                    function9 = function17;
                    set3 = set4;
                    z6 = z1118;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            set2 = set;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function5 = function1;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function6 = function2;
                } else {
                    function6 = function2;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function7 = function3;
                        z6 = z3;
                        z7 = z4;
                        set3 = set2;
                        function8 = function6;
                        function9 = function5;
                        function10 = function4;
                    } else {
                        if (i17 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if (i4 != 0) {
                            z9 = false;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            setEmptySet = SetsKt.emptySet();
                        } else {
                            setEmptySet = set2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            function5 = (Function1) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function6 = (Function1) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i12 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            function11 = (Function1) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function11 = function3;
                        }
                        if (i14 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function12 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                        }
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableLongState = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Unit unit111 = Unit.INSTANCE;
                        z10 = z9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                        transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        function13 = function6;
                        function14 = function5;
                        if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit111, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                        i16 = i3 & 14;
                        if (i16 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if ((i3 & 112) == 32) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                        transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        } else {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_114 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                        boolean z1119 = z8;
                        Modifier modifierFillMaxSize$default111 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVertical111 = horizontalOrVerticalM977spacedBy0680j_114;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                        if (i16 == 4) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean zChangedInstance111 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                        if ((i3 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        boolean z21111110 = zChangedInstance111 | z14;
                        if ((57344 & i3) == 16384) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        boolean z21111111 = z21111110 | z15;
                        if ((458752 & i3) == 131072) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        boolean z21111112 = z21111111 | z16;
                        if ((29360128 & i3) == 8388608) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        z18 = ((i3 & 3670016) == 1048576) | z21111112 | z17;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function111117 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function111117);
                            objRememberedValue2 = function111117;
                        } else {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function111118 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function111118);
                            objRememberedValue2 = function111118;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        LazyDslKt.LazyColumn(modifierFillMaxSize$default111, lazyListStateRememberLazyListState, null, false, horizontalOrVertical111, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function10 = function16;
                        function8 = function15;
                        function9 = function17;
                        set3 = set4;
                        z6 = z1119;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) != 4793490) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function3;
                    z6 = z3;
                    z7 = z4;
                    set3 = set2;
                    function8 = function6;
                    function9 = function5;
                    function10 = function4;
                } else {
                    if (i17 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        z9 = false;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        setEmptySet = SetsKt.emptySet();
                    } else {
                        setEmptySet = set2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        function5 = (Function1) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function6 = (Function1) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function11 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function11 = function3;
                    }
                    if (i14 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function12 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                    }
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableLongState = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit112 = Unit.INSTANCE;
                    z10 = z9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                    transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    function13 = function6;
                    function14 = function5;
                    if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit112, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                    i16 = i3 & 14;
                    if (i16 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if ((i3 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                    transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    } else {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_115 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                    boolean z11110 = z8;
                    Modifier modifierFillMaxSize$default112 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVertical112 = horizontalOrVerticalM977spacedBy0680j_115;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                    if (i16 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean zChangedInstance112 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                    if ((i3 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z21111113 = zChangedInstance112 | z14;
                    if ((57344 & i3) == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z21111114 = z21111113 | z15;
                    if ((458752 & i3) == 131072) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean z21111115 = z21111114 | z16;
                    if ((29360128 & i3) == 8388608) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 = ((i3 & 3670016) == 1048576) | z21111115 | z17;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function111119 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function111119);
                        objRememberedValue2 = function111119;
                    } else {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function1111110 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function1111110);
                        objRememberedValue2 = function1111110;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default112, lazyListStateRememberLazyListState, null, false, horizontalOrVertical112, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function10 = function16;
                    function8 = function15;
                    function9 = function17;
                    set3 = set4;
                    z6 = z11110;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function5 = function1;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function6 = function2;
            } else {
                function6 = function2;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                if ((i3 & 4793491) != 4793490) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function3;
                    z6 = z3;
                    z7 = z4;
                    set3 = set2;
                    function8 = function6;
                    function9 = function5;
                    function10 = function4;
                } else {
                    if (i17 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        z9 = false;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        setEmptySet = SetsKt.emptySet();
                    } else {
                        setEmptySet = set2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        function5 = (Function1) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function6 = (Function1) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function11 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function11 = function3;
                    }
                    if (i14 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function12 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                    }
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableLongState = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit113 = Unit.INSTANCE;
                    z10 = z9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                    transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    function13 = function6;
                    function14 = function5;
                    if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit113, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                    i16 = i3 & 14;
                    if (i16 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if ((i3 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                    transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    } else {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_116 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                    boolean z11111 = z8;
                    Modifier modifierFillMaxSize$default113 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVertical113 = horizontalOrVerticalM977spacedBy0680j_116;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                    if (i16 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean zChangedInstance113 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                    if ((i3 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z21111116 = zChangedInstance113 | z14;
                    if ((57344 & i3) == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z21111117 = z21111116 | z15;
                    if ((458752 & i3) == 131072) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean z21111118 = z21111117 | z16;
                    if ((29360128 & i3) == 8388608) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 = ((i3 & 3670016) == 1048576) | z21111118 | z17;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function1111111 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function1111111);
                        objRememberedValue2 = function1111111;
                    } else {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function1111112 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function1111112);
                        objRememberedValue2 = function1111112;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default113, lazyListStateRememberLazyListState, null, false, horizontalOrVertical113, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function10 = function16;
                    function8 = function15;
                    function9 = function17;
                    set3 = set4;
                    z6 = z11111;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i3 & 4793491) != 4793490) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function7 = function3;
                z6 = z3;
                z7 = z4;
                set3 = set2;
                function8 = function6;
                function9 = function5;
                function10 = function4;
            } else {
                if (i17 != 0) {
                    z8 = true;
                } else {
                    z8 = z3;
                }
                if (i4 != 0) {
                    z9 = false;
                } else {
                    z9 = z4;
                }
                if (i6 != 0) {
                    setEmptySet = SetsKt.emptySet();
                } else {
                    setEmptySet = set2;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    function5 = (Function1) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    function6 = (Function1) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (i12 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    function11 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function11 = function3;
                }
                if (i14 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function12 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function12 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                }
                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableLongState = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit114 = Unit.INSTANCE;
                z10 = z9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                function13 = function6;
                function14 = function5;
                if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit114, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                i16 = i3 & 14;
                if (i16 == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((i3 & 112) == 32) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                } else {
                    transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_117 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                boolean z11112 = z8;
                Modifier modifierFillMaxSize$default114 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical horizontalOrVertical114 = horizontalOrVerticalM977spacedBy0680j_117;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                if (i16 == 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean zChangedInstance114 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                if ((i3 & 896) == 256) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                boolean z21111119 = zChangedInstance114 | z14;
                if ((57344 & i3) == 16384) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                boolean z211111110 = z21111119 | z15;
                if ((458752 & i3) == 131072) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean z211111111 = z211111110 | z16;
                if ((29360128 & i3) == 8388608) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                z18 = ((i3 & 3670016) == 1048576) | z211111111 | z17;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z18) {
                    z7 = z10;
                    function15 = function13;
                    set4 = setEmptySet;
                    function7 = function11;
                    function16 = function12;
                    function17 = function14;
                    Function1 function1111113 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function1111113);
                    objRememberedValue2 = function1111113;
                } else {
                    z7 = z10;
                    function15 = function13;
                    set4 = setEmptySet;
                    function7 = function11;
                    function16 = function12;
                    function17 = function14;
                    Function1 function1111114 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function1111114);
                    objRememberedValue2 = function1111114;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                LazyDslKt.LazyColumn(modifierFillMaxSize$default114, lazyListStateRememberLazyListState, null, false, horizontalOrVertical114, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function10 = function16;
                function8 = function15;
                function9 = function17;
                set3 = set4;
                z6 = z11112;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z4 = z2;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                set2 = set;
                if (composerStartRestartGroup.changedInstance(set2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function5 = function1;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function6 = function2;
                } else {
                    function6 = function2;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function7 = function3;
                        z6 = z3;
                        z7 = z4;
                        set3 = set2;
                        function8 = function6;
                        function9 = function5;
                        function10 = function4;
                    } else {
                        if (i17 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if (i4 != 0) {
                            z9 = false;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            setEmptySet = SetsKt.emptySet();
                        } else {
                            setEmptySet = set2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            function5 = (Function1) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            function6 = (Function1) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (i12 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            function11 = (Function1) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function11 = function3;
                        }
                        if (i14 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function12 = (Function1) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function12 = function4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                        }
                        lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableLongState = (MutableLongState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Unit unit115 = Unit.INSTANCE;
                        z10 = z9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                        transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        function13 = function6;
                        function14 = function5;
                        if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit115, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                        i16 = i3 & 14;
                        if (i16 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if ((i3 & 112) == 32) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                        transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        } else {
                            transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                            composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_118 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                        boolean z11113 = z8;
                        Modifier modifierFillMaxSize$default115 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVertical115 = horizontalOrVerticalM977spacedBy0680j_118;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                        if (i16 == 4) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean zChangedInstance115 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                        if ((i3 & 896) == 256) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        boolean z211111112 = zChangedInstance115 | z14;
                        if ((57344 & i3) == 16384) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        boolean z211111113 = z211111112 | z15;
                        if ((458752 & i3) == 131072) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        boolean z211111114 = z211111113 | z16;
                        if ((29360128 & i3) == 8388608) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        z18 = ((i3 & 3670016) == 1048576) | z211111114 | z17;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z18) {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function1111115 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function1111115);
                            objRememberedValue2 = function1111115;
                        } else {
                            z7 = z10;
                            function15 = function13;
                            set4 = setEmptySet;
                            function7 = function11;
                            function16 = function12;
                            function17 = function14;
                            Function1 function1111116 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function1111116);
                            objRememberedValue2 = function1111116;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        LazyDslKt.LazyColumn(modifierFillMaxSize$default115, lazyListStateRememberLazyListState, null, false, horizontalOrVertical115, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function10 = function16;
                        function8 = function15;
                        function9 = function17;
                        set3 = set4;
                        z6 = z11113;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) != 4793490) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function3;
                    z6 = z3;
                    z7 = z4;
                    set3 = set2;
                    function8 = function6;
                    function9 = function5;
                    function10 = function4;
                } else {
                    if (i17 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        z9 = false;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        setEmptySet = SetsKt.emptySet();
                    } else {
                        setEmptySet = set2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        function5 = (Function1) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function6 = (Function1) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function11 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function11 = function3;
                    }
                    if (i14 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function12 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                    }
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableLongState = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit116 = Unit.INSTANCE;
                    z10 = z9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                    transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    function13 = function6;
                    function14 = function5;
                    if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit116, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                    i16 = i3 & 14;
                    if (i16 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if ((i3 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                    transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    } else {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_119 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                    boolean z11114 = z8;
                    Modifier modifierFillMaxSize$default116 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVertical116 = horizontalOrVerticalM977spacedBy0680j_119;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                    if (i16 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean zChangedInstance116 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                    if ((i3 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z211111115 = zChangedInstance116 | z14;
                    if ((57344 & i3) == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z211111116 = z211111115 | z15;
                    if ((458752 & i3) == 131072) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean z211111117 = z211111116 | z16;
                    if ((29360128 & i3) == 8388608) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 = ((i3 & 3670016) == 1048576) | z211111117 | z17;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function1111117 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function1111117);
                        objRememberedValue2 = function1111117;
                    } else {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function1111118 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function1111118);
                        objRememberedValue2 = function1111118;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default116, lazyListStateRememberLazyListState, null, false, horizontalOrVertical116, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function10 = function16;
                    function8 = function15;
                    function9 = function17;
                    set3 = set4;
                    z6 = z11114;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function5 = function1;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function6 = function2;
            } else {
                function6 = function2;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                if ((i3 & 4793491) != 4793490) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function3;
                    z6 = z3;
                    z7 = z4;
                    set3 = set2;
                    function8 = function6;
                    function9 = function5;
                    function10 = function4;
                } else {
                    if (i17 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        z9 = false;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        setEmptySet = SetsKt.emptySet();
                    } else {
                        setEmptySet = set2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        function5 = (Function1) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function6 = (Function1) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function11 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function11 = function3;
                    }
                    if (i14 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function12 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                    }
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableLongState = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit117 = Unit.INSTANCE;
                    z10 = z9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                    transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    function13 = function6;
                    function14 = function5;
                    if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit117, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                    i16 = i3 & 14;
                    if (i16 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if ((i3 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                    transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    } else {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_1110 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                    boolean z11115 = z8;
                    Modifier modifierFillMaxSize$default117 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVertical117 = horizontalOrVerticalM977spacedBy0680j_1110;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                    if (i16 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean zChangedInstance117 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                    if ((i3 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z211111118 = zChangedInstance117 | z14;
                    if ((57344 & i3) == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z211111119 = z211111118 | z15;
                    if ((458752 & i3) == 131072) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean z2111111110 = z211111119 | z16;
                    if ((29360128 & i3) == 8388608) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 = ((i3 & 3670016) == 1048576) | z2111111110 | z17;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function1111119 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function1111119);
                        objRememberedValue2 = function1111119;
                    } else {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function11111110 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function11111110);
                        objRememberedValue2 = function11111110;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default117, lazyListStateRememberLazyListState, null, false, horizontalOrVertical117, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function10 = function16;
                    function8 = function15;
                    function9 = function17;
                    set3 = set4;
                    z6 = z11115;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i3 & 4793491) != 4793490) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function7 = function3;
                z6 = z3;
                z7 = z4;
                set3 = set2;
                function8 = function6;
                function9 = function5;
                function10 = function4;
            } else {
                if (i17 != 0) {
                    z8 = true;
                } else {
                    z8 = z3;
                }
                if (i4 != 0) {
                    z9 = false;
                } else {
                    z9 = z4;
                }
                if (i6 != 0) {
                    setEmptySet = SetsKt.emptySet();
                } else {
                    setEmptySet = set2;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    function5 = (Function1) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    function6 = (Function1) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (i12 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    function11 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function11 = function3;
                }
                if (i14 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function12 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function12 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                }
                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableLongState = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit118 = Unit.INSTANCE;
                z10 = z9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                function13 = function6;
                function14 = function5;
                if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit118, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                i16 = i3 & 14;
                if (i16 == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((i3 & 112) == 32) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                } else {
                    transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_1111 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                boolean z11116 = z8;
                Modifier modifierFillMaxSize$default118 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical horizontalOrVertical118 = horizontalOrVerticalM977spacedBy0680j_1111;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                if (i16 == 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean zChangedInstance118 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                if ((i3 & 896) == 256) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                boolean z2111111111 = zChangedInstance118 | z14;
                if ((57344 & i3) == 16384) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                boolean z2111111112 = z2111111111 | z15;
                if ((458752 & i3) == 131072) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean z2111111113 = z2111111112 | z16;
                if ((29360128 & i3) == 8388608) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                z18 = ((i3 & 3670016) == 1048576) | z2111111113 | z17;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z18) {
                    z7 = z10;
                    function15 = function13;
                    set4 = setEmptySet;
                    function7 = function11;
                    function16 = function12;
                    function17 = function14;
                    Function1 function11111111 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function11111111);
                    objRememberedValue2 = function11111111;
                } else {
                    z7 = z10;
                    function15 = function13;
                    set4 = setEmptySet;
                    function7 = function11;
                    function16 = function12;
                    function17 = function14;
                    Function1 function11111112 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function11111112);
                    objRememberedValue2 = function11111112;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                LazyDslKt.LazyColumn(modifierFillMaxSize$default118, lazyListStateRememberLazyListState, null, false, horizontalOrVertical118, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function10 = function16;
                function8 = function15;
                function9 = function17;
                set3 = set4;
                z6 = z11116;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        set2 = set;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                function5 = function1;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function6 = function2;
            } else {
                function6 = function2;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                if ((i3 & 4793491) != 4793490) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function3;
                    z6 = z3;
                    z7 = z4;
                    set3 = set2;
                    function8 = function6;
                    function9 = function5;
                    function10 = function4;
                } else {
                    if (i17 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        z9 = false;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        setEmptySet = SetsKt.emptySet();
                    } else {
                        setEmptySet = set2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        function5 = (Function1) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        function6 = (Function1) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function11 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function11 = function3;
                    }
                    if (i14 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function12 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function12 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                    }
                    lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableLongState = (MutableLongState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit119 = Unit.INSTANCE;
                    z10 = z9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                    transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    function13 = function6;
                    function14 = function5;
                    if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit119, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                    i16 = i3 & 14;
                    if (i16 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if ((i3 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                    transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    } else {
                        transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                        composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_1112 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                    boolean z11117 = z8;
                    Modifier modifierFillMaxSize$default119 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVertical119 = horizontalOrVerticalM977spacedBy0680j_1112;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                    if (i16 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean zChangedInstance119 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                    if ((i3 & 896) == 256) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    boolean z2111111114 = zChangedInstance119 | z14;
                    if ((57344 & i3) == 16384) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    boolean z2111111115 = z2111111114 | z15;
                    if ((458752 & i3) == 131072) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean z2111111116 = z2111111115 | z16;
                    if ((29360128 & i3) == 8388608) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 = ((i3 & 3670016) == 1048576) | z2111111116 | z17;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z18) {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function11111113 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function11111113);
                        objRememberedValue2 = function11111113;
                    } else {
                        z7 = z10;
                        function15 = function13;
                        set4 = setEmptySet;
                        function7 = function11;
                        function16 = function12;
                        function17 = function14;
                        Function1 function11111114 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function11111114);
                        objRememberedValue2 = function11111114;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    LazyDslKt.LazyColumn(modifierFillMaxSize$default119, lazyListStateRememberLazyListState, null, false, horizontalOrVertical119, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function10 = function16;
                    function8 = function15;
                    function9 = function17;
                    set3 = set4;
                    z6 = z11117;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i3 & 4793491) != 4793490) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function7 = function3;
                z6 = z3;
                z7 = z4;
                set3 = set2;
                function8 = function6;
                function9 = function5;
                function10 = function4;
            } else {
                if (i17 != 0) {
                    z8 = true;
                } else {
                    z8 = z3;
                }
                if (i4 != 0) {
                    z9 = false;
                } else {
                    z9 = z4;
                }
                if (i6 != 0) {
                    setEmptySet = SetsKt.emptySet();
                } else {
                    setEmptySet = set2;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    function5 = (Function1) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    function6 = (Function1) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (i12 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    function11 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function11 = function3;
                }
                if (i14 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function12 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function12 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                }
                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableLongState = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit1110 = Unit.INSTANCE;
                z10 = z9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                function13 = function6;
                function14 = function5;
                if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit1110, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                i16 = i3 & 14;
                if (i16 == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((i3 & 112) == 32) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                } else {
                    transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_1113 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                boolean z11118 = z8;
                Modifier modifierFillMaxSize$default1110 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical horizontalOrVertical1110 = horizontalOrVerticalM977spacedBy0680j_1113;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                if (i16 == 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean zChangedInstance1110 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                if ((i3 & 896) == 256) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                boolean z2111111117 = zChangedInstance1110 | z14;
                if ((57344 & i3) == 16384) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                boolean z2111111118 = z2111111117 | z15;
                if ((458752 & i3) == 131072) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean z2111111119 = z2111111118 | z16;
                if ((29360128 & i3) == 8388608) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                z18 = ((i3 & 3670016) == 1048576) | z2111111119 | z17;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z18) {
                    z7 = z10;
                    function15 = function13;
                    set4 = setEmptySet;
                    function7 = function11;
                    function16 = function12;
                    function17 = function14;
                    Function1 function11111115 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function11111115);
                    objRememberedValue2 = function11111115;
                } else {
                    z7 = z10;
                    function15 = function13;
                    set4 = setEmptySet;
                    function7 = function11;
                    function16 = function12;
                    function17 = function14;
                    Function1 function11111116 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function11111116);
                    objRememberedValue2 = function11111116;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                LazyDslKt.LazyColumn(modifierFillMaxSize$default1110, lazyListStateRememberLazyListState, null, false, horizontalOrVertical1110, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function10 = function16;
                function8 = function15;
                function9 = function17;
                set3 = set4;
                z6 = z11118;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function5 = function1;
        i10 = i2 & 32;
        if (i10 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function2;
        } else {
            function6 = function2;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
        }
        i12 = i2 & 64;
        if (i12 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i13 = 1048576;
            } else {
                i13 = 524288;
            }
            i3 |= i13;
        }
        i14 = i2 & 128;
        if (i14 != 0) {
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i3 |= i15;
            }
            if ((i3 & 4793491) != 4793490) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function7 = function3;
                z6 = z3;
                z7 = z4;
                set3 = set2;
                function8 = function6;
                function9 = function5;
                function10 = function4;
            } else {
                if (i17 != 0) {
                    z8 = true;
                } else {
                    z8 = z3;
                }
                if (i4 != 0) {
                    z9 = false;
                } else {
                    z9 = z4;
                }
                if (i6 != 0) {
                    setEmptySet = SetsKt.emptySet();
                } else {
                    setEmptySet = set2;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    function5 = (Function1) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    function6 = (Function1) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (i12 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    function11 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function11 = function3;
                }
                if (i14 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function12 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function12 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
                }
                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableLongState = (MutableLongState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit1111 = Unit.INSTANCE;
                z10 = z9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
                transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                function13 = function6;
                function14 = function5;
                if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit1111, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
                i16 = i3 & 14;
                if (i16 == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((i3 & 112) == 32) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                } else {
                    transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                    composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_1114 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
                boolean z11119 = z8;
                Modifier modifierFillMaxSize$default1111 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical horizontalOrVertical1111 = horizontalOrVerticalM977spacedBy0680j_1114;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
                if (i16 == 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean zChangedInstance1111 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
                if ((i3 & 896) == 256) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                boolean z21111111110 = zChangedInstance1111 | z14;
                if ((57344 & i3) == 16384) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                boolean z21111111111 = z21111111110 | z15;
                if ((458752 & i3) == 131072) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean z21111111112 = z21111111111 | z16;
                if ((29360128 & i3) == 8388608) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                z18 = ((i3 & 3670016) == 1048576) | z21111111112 | z17;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z18) {
                    z7 = z10;
                    function15 = function13;
                    set4 = setEmptySet;
                    function7 = function11;
                    function16 = function12;
                    function17 = function14;
                    Function1 function11111117 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function11111117);
                    objRememberedValue2 = function11111117;
                } else {
                    z7 = z10;
                    function15 = function13;
                    set4 = setEmptySet;
                    function7 = function11;
                    function16 = function12;
                    function17 = function14;
                    Function1 function11111118 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function11111118);
                    objRememberedValue2 = function11111118;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                LazyDslKt.LazyColumn(modifierFillMaxSize$default1111, lazyListStateRememberLazyListState, null, false, horizontalOrVertical1111, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function10 = function16;
                function8 = function15;
                function9 = function17;
                set3 = set4;
                z6 = z11119;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 12582912;
        if ((i3 & 4793491) != 4793490) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function7 = function3;
            z6 = z3;
            z7 = z4;
            set3 = set2;
            function8 = function6;
            function9 = function5;
            function10 = function4;
        } else {
            if (i17 != 0) {
                z8 = true;
            } else {
                z8 = z3;
            }
            if (i4 != 0) {
                z9 = false;
            } else {
                z9 = z4;
            }
            if (i6 != 0) {
                setEmptySet = SetsKt.emptySet();
            } else {
                setEmptySet = set2;
            }
            if (i8 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11376915, "CC(remember):TransactionList.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$1$lambda$0((Transaction) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                function5 = (Function1) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (i10 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11375603, "CC(remember):TransactionList.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$3$lambda$2((Transaction) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                function6 = (Function1) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (i12 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11374163, "CC(remember):TransactionList.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$5$lambda$4((Transaction) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                function11 = (Function1) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function11 = function3;
            }
            if (i14 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11372627, "CC(remember):TransactionList.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$7$lambda$6((Transaction) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                function12 = (Function1) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function12 = function4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-312860661, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList (TransactionList.kt:48)");
            }
            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11370426, "CC(remember):TransactionList.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableLongState = (MutableLongState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit1112 = Unit.INSTANCE;
            z10 = z9;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11367622, "CC(remember):TransactionList.kt#9igjgp");
            transactionListKt$TransactionList$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
            function13 = function6;
            function14 = function5;
            if (transactionListKt$TransactionList$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                transactionListKt$TransactionList$5$1RememberedValue = new TransactionListKt$TransactionList$5$1(mutableLongState, null);
                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$5$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit1112, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$5$1RememberedValue, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11362814, "CC(remember):TransactionList.kt#9igjgp");
            i16 = i3 & 14;
            if (i16 == 4) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((i3 & 112) == 32) {
                z12 = true;
            } else {
                z12 = false;
            }
            zChanged = z12 | z11 | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
            transactionListKt$TransactionList$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
            } else {
                transactionListKt$TransactionList$6$1RememberedValue = new TransactionListKt$TransactionList$6$1(source, z8, lazyListStateRememberLazyListState, null);
                composerStartRestartGroup.updateRememberedValue(transactionListKt$TransactionList$6$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(source, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) transactionListKt$TransactionList$6$1RememberedValue, composerStartRestartGroup, i16);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_1115 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(0));
            boolean z111110 = z8;
            Modifier modifierFillMaxSize$default1112 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVertical1112 = horizontalOrVerticalM977spacedBy0680j_1115;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -11341432, "CC(remember):TransactionList.kt#9igjgp");
            if (i16 == 4) {
                z13 = true;
            } else {
                z13 = false;
            }
            boolean zChangedInstance1112 = z13 | composerStartRestartGroup.changedInstance(setEmptySet);
            if ((i3 & 896) == 256) {
                z14 = true;
            } else {
                z14 = false;
            }
            boolean z21111111113 = zChangedInstance1112 | z14;
            if ((57344 & i3) == 16384) {
                z15 = true;
            } else {
                z15 = false;
            }
            boolean z21111111114 = z21111111113 | z15;
            if ((458752 & i3) == 131072) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z21111111115 = z21111111114 | z16;
            if ((29360128 & i3) == 8388608) {
                z17 = true;
            } else {
                z17 = false;
            }
            z18 = ((i3 & 3670016) == 1048576) | z21111111115 | z17;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z18) {
                z7 = z10;
                function15 = function13;
                set4 = setEmptySet;
                function7 = function11;
                function16 = function12;
                function17 = function14;
                Function1 function11111119 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function11111119);
                objRememberedValue2 = function11111119;
            } else {
                z7 = z10;
                function15 = function13;
                set4 = setEmptySet;
                function7 = function11;
                function16 = function12;
                function17 = function14;
                Function1 function111111110 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TransactionListKt.TransactionList$lambda$33$lambda$32(source, set4, z7, function17, function15, function16, function7, mutableLongState, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function111111110);
                objRememberedValue2 = function111111110;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyColumn(modifierFillMaxSize$default1112, lazyListStateRememberLazyListState, null, false, horizontalOrVertical1112, null, null, false, null, (Function1) objRememberedValue2, composer2, 24582, 492);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function10 = function16;
            function8 = function15;
            function9 = function17;
            set3 = set4;
            z6 = z111110;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TransactionListKt.TransactionList$lambda$34(source, z6, z7, set3, function9, function8, function7, function10, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long TransactionList$lambda$9(MutableLongState mutableLongState) {
        return mutableLongState.getLongValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionList$lambda$33$lambda$32(TransactionSource transactionSource, final Set set, final boolean z, final Function1 function1, final Function1 function2, final Function1 function3, final Function1 function4, final MutableLongState mutableLongState, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (transactionSource instanceof TransactionSource.ListSource) {
            final List<Transaction> items = ((TransactionSource.ListSource) transactionSource).getItems();
            final Function1 function5 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TransactionListKt.TransactionList$lambda$33$lambda$32$lambda$13((Transaction) obj);
                }
            };
            final TransactionListKt$TransactionList$lambda$33$lambda$32$$inlined$items$default$1 transactionListKt$TransactionList$lambda$33$lambda$32$$inlined$items$default$1 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$TransactionList$lambda$33$lambda$32$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Transaction transaction) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((Transaction) obj);
                }
            };
            LazyColumn.items(items.size(), new Function1<Integer, Object>() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$TransactionList$lambda$33$lambda$32$$inlined$items$default$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return function5.invoke(items.get(i));
                }
            }, new Function1<Integer, Object>() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$TransactionList$lambda$33$lambda$32$$inlined$items$default$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return transactionListKt$TransactionList$lambda$33$lambda$32$$inlined$items$default$1.invoke(items.get(i));
                }
            }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$TransactionList$lambda$33$lambda$32$$inlined$items$default$4
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                    int i3;
                    ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                    if ((i2 & 6) == 0) {
                        i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
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
                    final Transaction transaction = (Transaction) items.get(i);
                    composer.startReplaceGroup(-46784833);
                    ComposerKt.sourceInformation(composer, "CN(transaction)*84@3214L894:TransactionList.kt#7qqvjm");
                    ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                    ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
                    ComposerKt.sourceInformationMarkerStart(composer, 2051433196, "C90@3538L35,91@3613L24,93@3756L31,92@3681L28,85@3247L566,96@3839L247:TransactionList.kt#7qqvjm");
                    long jTransactionList$lambda$9 = TransactionListKt.TransactionList$lambda$9(mutableLongState);
                    boolean zContains = set.contains(transaction);
                    boolean z2 = z;
                    ComposerKt.sourceInformationMarkerStart(composer, -1319289549, "CC(remember):TransactionList.kt#9igjgp");
                    boolean zChanged = composer.changed(function1) | composer.changedInstance(transaction);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        final Function1 function6 = function1;
                        objRememberedValue = (Function1) new Function1<Transaction, Unit>() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$TransactionList$7$1$2$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Transaction transaction2) {
                                invoke2(transaction2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Transaction it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                function6.invoke(transaction);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function7 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -1319287160, "CC(remember):TransactionList.kt#9igjgp");
                    boolean zChanged2 = composer.changed(function2) | composer.changedInstance(transaction);
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        final Function1 function8 = function2;
                        objRememberedValue2 = (Function1) new Function1<Transaction, Unit>() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$TransactionList$7$1$2$1$2$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Transaction transaction2) {
                                invoke2(transaction2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Transaction it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                function8.invoke(transaction);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function9 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -1319282577, "CC(remember):TransactionList.kt#9igjgp");
                    boolean zChanged3 = composer.changed(function3) | composer.changedInstance(transaction);
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        final Function1 function10 = function3;
                        objRememberedValue3 = (Function1) new Function1<Transaction, Unit>() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$TransactionList$7$1$2$1$3$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Transaction transaction2) {
                                invoke2(transaction2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Transaction it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                function10.invoke(transaction);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    Function1 function11 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, -1319284980, "CC(remember):TransactionList.kt#9igjgp");
                    boolean zChanged4 = composer.changed(function4) | composer.changedInstance(transaction);
                    Object objRememberedValue4 = composer.rememberedValue();
                    if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        final Function1 function12 = function4;
                        objRememberedValue4 = (Function1) new Function1<Transaction, Unit>() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$TransactionList$7$1$2$1$4$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Transaction transaction2) {
                                invoke2(transaction2);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Transaction it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                function12.invoke(transaction);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TransactionItemKt.TransactionItem(null, transaction, jTransactionList$lambda$9, zContains, z2, function7, function9, function11, (Function1) objRememberedValue4, composer, 0, 1);
                    DividerKt.m3011HorizontalDivider9IZ8Weo(PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(12), 0.0f, 2, null), Dp.m8684constructorimpl(1), 0L, composer, 54, 4);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        } else {
            if (!(transactionSource instanceof TransactionSource.PagingSource)) {
                throw new NoWhenBranchMatchedException();
            }
            final LazyPagingItems<Transaction> items2 = ((TransactionSource.PagingSource) transactionSource).getItems();
            LazyListScope.items$default(LazyColumn, items2.getItemCount(), new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TransactionListKt.TransactionList$lambda$33$lambda$32$lambda$20(items2, ((Integer) obj).intValue());
                }
            }, null, ComposableLambdaKt.composableLambdaInstance(1304938732, true, new Function4() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return TransactionListKt.TransactionList$lambda$33$lambda$32$lambda$31(items2, set, z, function1, function2, function3, function4, mutableLongState, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }), 4, null);
            if (items2.getLoadState().getAppend() instanceof LoadState.Loading) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TransactionListKt.INSTANCE.m9687getLambda$1692460006$app_debug(), 3, null);
            }
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TransactionListKt.INSTANCE.getLambda$512881430$app_debug(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TransactionList$lambda$33$lambda$32$lambda$13(Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String string = it.getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TransactionList$lambda$33$lambda$32$lambda$20(LazyPagingItems lazyPagingItems, int i) {
        Transaction transaction = (Transaction) lazyPagingItems.get(i);
        return String.valueOf(transaction != null ? transaction.getId() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionList$lambda$33$lambda$32$lambda$31(LazyPagingItems lazyPagingItems, Set set, boolean z, final Function1 function1, final Function1 function2, final Function1 function3, final Function1 function4, MutableLongState mutableLongState, LazyItemScope items, int i, Composer composer, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(items, "$this$items");
        ComposerKt.sourceInformation(composer, "CN(index):TransactionList.kt#7qqvjm");
        if ((i2 & 48) == 0) {
            i3 = i2 | (composer.changed(i) ? 32 : 16);
        } else {
            i3 = i2;
        }
        if (!composer.shouldExecute((i3 & 145) != 144, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1304938732, i3, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionList.<anonymous>.<anonymous>.<anonymous> (TransactionList.kt:112)");
            }
            final Transaction transaction = (Transaction) lazyPagingItems.get(i);
            if (transaction == null) {
                composer.startReplaceGroup(1680845425);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1680845426);
                ComposerKt.sourceInformation(composer, "*113@4477L961");
                ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
                ComposerKt.sourceInformationMarkerStart(composer, -902792060, "C119@4825L35,120@4904L24,122@5055L31,121@4976L28,114@4514L602,124@5145L267:TransactionList.kt#7qqvjm");
                long jTransactionList$lambda$9 = TransactionList$lambda$9(mutableLongState);
                boolean zContains = set.contains(transaction);
                ComposerKt.sourceInformationMarkerStart(composer, -444755232, "CC(remember):TransactionList.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changedInstance(transaction);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29$lambda$22$lambda$21(function1, transaction, (Transaction) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function5 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -444752715, "CC(remember):TransactionList.kt#9igjgp");
                boolean zChanged2 = composer.changed(function2) | composer.changedInstance(transaction);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29$lambda$24$lambda$23(function2, transaction, (Transaction) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Function1 function6 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -444747876, "CC(remember):TransactionList.kt#9igjgp");
                boolean zChanged3 = composer.changed(function3) | composer.changedInstance(transaction);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29$lambda$26$lambda$25(function3, transaction, (Transaction) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Function1 function7 = (Function1) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -444750407, "CC(remember):TransactionList.kt#9igjgp");
                boolean zChanged4 = composer.changed(function4) | composer.changedInstance(transaction);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TransactionListKt.TransactionList$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27(function4, transaction, (Transaction) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TransactionItemKt.TransactionItem(null, transaction, jTransactionList$lambda$9, zContains, z, function5, function6, function7, (Function1) objRememberedValue4, composer, 0, 1);
                DividerKt.m3011HorizontalDivider9IZ8Weo(PaddingKt.m1120paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(12), 0.0f, 2, null), Dp.m8684constructorimpl(1), 0L, composer, 54, 4);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionList$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29$lambda$22$lambda$21(Function1 function1, Transaction transaction, Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(transaction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionList$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29$lambda$24$lambda$23(Function1 function1, Transaction transaction, Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(transaction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionList$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29$lambda$28$lambda$27(Function1 function1, Transaction transaction, Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(transaction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionList$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29$lambda$26$lambda$25(Function1 function1, Transaction transaction, Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(transaction);
        return Unit.INSTANCE;
    }

    private static final void TransactionListPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(481531966);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TransactionListPreview)206@7818L22,207@7860L22,208@7906L27,209@7960L33,204@7707L292:TransactionList.kt#7qqvjm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(481531966, i, -1, "com.example.bingwahybrid.presentation.transactions.components.TransactionListPreview (TransactionList.kt:154)");
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID(...)");
            TransactionStatus transactionStatus = TransactionStatus.FAILED;
            long jCurrentTimeMillis = System.currentTimeMillis();
            Customer customer = new Customer(1, UUID.randomUUID(), "John Doe", "0712345678", 1000, 0L, false, false, 224, null);
            UUID uuidRandomUUID2 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID2, "randomUUID(...)");
            UUID uuidRandomUUID3 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID3, "randomUUID(...)");
            TransactionStatus transactionStatus2 = TransactionStatus.SUCCESS;
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Customer customer2 = new Customer(2, UUID.randomUUID(), "Jane Doe", "0712345679", 1500, 0L, false, false, 224, null);
            UUID uuidRandomUUID4 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID4, "randomUUID(...)");
            TransactionSource.ListSource listSource = new TransactionSource.ListSource(CollectionsKt.listOf((Object[]) new Transaction[]{new Transaction(uuidRandomUUID, "TA8SH5SJ84", 500, jCurrentTimeMillis, "Payment received for Order #123", "Transaction successful", transactionStatus, customer, new Offer(uuidRandomUUID2, "Discount 20%", "*123#", 100, OfferType.DATA, null, false, null, false, false, false, false, false, 0, 0, 0L, null, false, 262112, null), null, null, 0, 0, 0L, null, null, null, 130560, null), new Transaction(uuidRandomUUID3, "TA8SH5SJ85", 1000, jCurrentTimeMillis2, "Payment received for Order #124", "Transaction successful", transactionStatus2, customer2, new Offer(uuidRandomUUID4, "Cashback Offer", "*456#", 200, OfferType.DATA, null, false, null, false, false, false, false, false, 0, 0, 0L, null, false, 262112, null), null, null, 0, 0, 0L, null, null, null, 130560, null)}));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1104189868, "CC(remember):TransactionList.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TransactionListKt.TransactionListPreview$lambda$36$lambda$35((Transaction) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1104188524, "CC(remember):TransactionList.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TransactionListKt.TransactionListPreview$lambda$38$lambda$37((Transaction) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1104187047, "CC(remember):TransactionList.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TransactionListKt.TransactionListPreview$lambda$40$lambda$39((Transaction) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function3 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1104185313, "CC(remember):TransactionList.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TransactionListKt.TransactionListPreview$lambda$42$lambda$41((Transaction) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TransactionList(listSource, false, false, null, function1, function2, function3, (Function1) objRememberedValue4, composerStartRestartGroup, 14376960, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TransactionListKt.TransactionListPreview$lambda$43(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionListPreview$lambda$36$lambda$35(Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionListPreview$lambda$38$lambda$37(Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionListPreview$lambda$40$lambda$39(Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransactionListPreview$lambda$42$lambda$41(Transaction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
