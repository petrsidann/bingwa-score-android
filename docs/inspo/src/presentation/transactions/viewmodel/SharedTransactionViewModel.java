package com.example.bingwahybrid.presentation.transactions.viewmodel;

import androidx.lifecycle.ViewModel;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SharedTransactionViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/example/bingwahybrid/presentation/transactions/viewmodel/SharedTransactionViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_deletedTransactionId", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/util/UUID;", "deletedTransactionId", "Lkotlinx/coroutines/flow/StateFlow;", "getDeletedTransactionId", "()Lkotlinx/coroutines/flow/StateFlow;", "setDeletedTransactionId", "", "transactionId", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedTransactionViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<UUID> _deletedTransactionId;
    private final StateFlow<UUID> deletedTransactionId;

    public SharedTransactionViewModel() {
        MutableStateFlow<UUID> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._deletedTransactionId = MutableStateFlow;
        this.deletedTransactionId = MutableStateFlow;
    }

    public final StateFlow<UUID> getDeletedTransactionId() {
        return this.deletedTransactionId;
    }

    public final void setDeletedTransactionId(UUID transactionId) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        this._deletedTransactionId.setValue(transactionId);
    }
}
