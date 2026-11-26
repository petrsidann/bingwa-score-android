package com.example.bingwahybrid.presentation.transactions.screens;

import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.presentation.offers.dto.DurationFilter;
import com.example.bingwahybrid.presentation.offers.dto.FilterChipState;
import com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TransactionsScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.screens.TransactionsScreenKt$TransactionsScreen$1$1", f = "TransactionsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TransactionsScreenKt$TransactionsScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $initialDuration;
    final /* synthetic */ String $initialStatus;
    final /* synthetic */ TransactionsViewModel $viewModel;
    int label;

    /* JADX INFO: compiled from: TransactionsScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TransactionStatus.values().length];
            try {
                iArr[TransactionStatus.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TransactionStatus.PENDING_AWAITING_COMMISSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TransactionStatus.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TransactionStatus.FAILED_ALREADY_RECOMMENDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TransactionStatus.FAILED_OFFER_DEACTIVATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TransactionStatus.SCHEDULED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TransactionStatus.UNMATCHED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TransactionStatus.RESCHEDULED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TransactionStatus.ENGAGE_BOT_ACTIVE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransactionsScreenKt$TransactionsScreen$1$1(String str, String str2, TransactionsViewModel transactionsViewModel, Continuation<? super TransactionsScreenKt$TransactionsScreen$1$1> continuation) {
        super(2, continuation);
        this.$initialStatus = str;
        this.$initialDuration = str2;
        this.$viewModel = transactionsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransactionsScreenKt$TransactionsScreen$1$1(this.$initialStatus, this.$initialDuration, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransactionsScreenKt$TransactionsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FilterChipState.Successful successful;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String str = this.$initialStatus;
        DurationFilter.Yesterday yesterday = null;
        if (str != null) {
            TransactionsViewModel transactionsViewModel = this.$viewModel;
            TransactionStatus transactionStatusFromString = TransactionStatus.INSTANCE.fromString(str);
            if (transactionStatusFromString != null) {
                switch (WhenMappings.$EnumSwitchMapping$0[transactionStatusFromString.ordinal()]) {
                    case 1:
                        successful = FilterChipState.Successful.INSTANCE;
                        break;
                    case 2:
                        successful = FilterChipState.AwaitingCommission.INSTANCE;
                        break;
                    case 3:
                    case 4:
                    case 5:
                        successful = FilterChipState.Failed.INSTANCE;
                        break;
                    case 6:
                        successful = FilterChipState.Pending.INSTANCE;
                        break;
                    case 7:
                        successful = FilterChipState.Unmatched.INSTANCE;
                        break;
                    case 8:
                        successful = FilterChipState.Scheduled.INSTANCE;
                        break;
                    case 9:
                        successful = FilterChipState.EngageBot.INSTANCE;
                        break;
                    default:
                        successful = null;
                        break;
                }
                if (successful != null) {
                    transactionsViewModel.setSelectedChip(successful);
                }
            }
        }
        String str2 = this.$initialDuration;
        if (str2 != null) {
            TransactionsViewModel transactionsViewModel2 = this.$viewModel;
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case -1621979774:
                    if (lowerCase.equals("yesterday")) {
                        yesterday = DurationFilter.Yesterday.INSTANCE;
                    }
                    break;
                case 110534465:
                    if (lowerCase.equals("today")) {
                        yesterday = DurationFilter.Today.INSTANCE;
                    }
                    break;
                case 960383562:
                    if (lowerCase.equals("last30days")) {
                        yesterday = DurationFilter.Last30Days.INSTANCE;
                    }
                    break;
                case 1975883832:
                    if (lowerCase.equals("last7days")) {
                        yesterday = DurationFilter.Last7Days.INSTANCE;
                    }
                    break;
            }
            if (yesterday != null) {
                transactionsViewModel2.setSelectedDurationFilterChip(yesterday);
            }
        }
        return Unit.INSTANCE;
    }
}
