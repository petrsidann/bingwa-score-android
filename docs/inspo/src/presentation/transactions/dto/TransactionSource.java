package com.example.bingwahybrid.presentation.transactions.dto;

import androidx.paging.compose.LazyPagingItems;
import com.example.bingwahybrid.domain.model.Transaction;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransactionSource.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/example/bingwahybrid/presentation/transactions/dto/TransactionSource;", "", "<init>", "()V", "ListSource", "PagingSource", "Lcom/example/bingwahybrid/presentation/transactions/dto/TransactionSource$ListSource;", "Lcom/example/bingwahybrid/presentation/transactions/dto/TransactionSource$PagingSource;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class TransactionSource {
    public static final int $stable = 0;

    public /* synthetic */ TransactionSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: TransactionSource.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/example/bingwahybrid/presentation/transactions/dto/TransactionSource$ListSource;", "Lcom/example/bingwahybrid/presentation/transactions/dto/TransactionSource;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/example/bingwahybrid/domain/model/Transaction;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ListSource extends TransactionSource {
        public static final int $stable = 8;
        private final List<Transaction> items;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ListSource copy$default(ListSource listSource, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = listSource.items;
            }
            return listSource.copy(list);
        }

        public final List<Transaction> component1() {
            return this.items;
        }

        public final ListSource copy(List<Transaction> items) {
            Intrinsics.checkNotNullParameter(items, "items");
            return new ListSource(items);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ListSource) && Intrinsics.areEqual(this.items, ((ListSource) other).items);
        }

        public int hashCode() {
            return this.items.hashCode();
        }

        public String toString() {
            return "ListSource(items=" + this.items + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ListSource(List<Transaction> items) {
            super(null);
            Intrinsics.checkNotNullParameter(items, "items");
            this.items = items;
        }

        public final List<Transaction> getItems() {
            return this.items;
        }
    }

    private TransactionSource() {
    }

    /* JADX INFO: compiled from: TransactionSource.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/example/bingwahybrid/presentation/transactions/dto/TransactionSource$PagingSource;", "Lcom/example/bingwahybrid/presentation/transactions/dto/TransactionSource;", FirebaseAnalytics.Param.ITEMS, "Landroidx/paging/compose/LazyPagingItems;", "Lcom/example/bingwahybrid/domain/model/Transaction;", "<init>", "(Landroidx/paging/compose/LazyPagingItems;)V", "getItems", "()Landroidx/paging/compose/LazyPagingItems;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PagingSource extends TransactionSource {
        public static final int $stable = LazyPagingItems.$stable;
        private final LazyPagingItems<Transaction> items;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PagingSource copy$default(PagingSource pagingSource, LazyPagingItems lazyPagingItems, int i, Object obj) {
            if ((i & 1) != 0) {
                lazyPagingItems = pagingSource.items;
            }
            return pagingSource.copy(lazyPagingItems);
        }

        public final LazyPagingItems<Transaction> component1() {
            return this.items;
        }

        public final PagingSource copy(LazyPagingItems<Transaction> items) {
            Intrinsics.checkNotNullParameter(items, "items");
            return new PagingSource(items);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PagingSource) && Intrinsics.areEqual(this.items, ((PagingSource) other).items);
        }

        public int hashCode() {
            return this.items.hashCode();
        }

        public String toString() {
            return "PagingSource(items=" + this.items + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagingSource(LazyPagingItems<Transaction> items) {
            super(null);
            Intrinsics.checkNotNullParameter(items, "items");
            this.items = items;
        }

        public final LazyPagingItems<Transaction> getItems() {
            return this.items;
        }
    }
}
