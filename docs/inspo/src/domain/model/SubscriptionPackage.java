package com.example.bingwahybrid.domain.model;

import com.example.bingwahybrid.domain.enums.SubscriptionType;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubscriptionPackage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJV\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0007HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/example/bingwahybrid/domain/model/SubscriptionPackage;", "", "id", "Ljava/util/UUID;", "name", "", FirebaseAnalytics.Param.PRICE, "", "description", "limit", "", "type", "Lcom/example/bingwahybrid/domain/enums/SubscriptionType;", "updatedAt", "", "<init>", "(Ljava/util/UUID;Ljava/lang/String;ILjava/lang/String;DLcom/example/bingwahybrid/domain/enums/SubscriptionType;Ljava/lang/Long;)V", "getId", "()Ljava/util/UUID;", "getName", "()Ljava/lang/String;", "getPrice", "()I", "getDescription", "getLimit", "()D", "getType", "()Lcom/example/bingwahybrid/domain/enums/SubscriptionType;", "getUpdatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/UUID;Ljava/lang/String;ILjava/lang/String;DLcom/example/bingwahybrid/domain/enums/SubscriptionType;Ljava/lang/Long;)Lcom/example/bingwahybrid/domain/model/SubscriptionPackage;", "equals", "", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SubscriptionPackage {
    public static final int $stable = 8;
    private final String description;
    private final UUID id;
    private final double limit;
    private final String name;
    private final int price;
    private final SubscriptionType type;
    private final Long updatedAt;

    public static /* synthetic */ SubscriptionPackage copy$default(SubscriptionPackage subscriptionPackage, UUID uuid, String str, int i, String str2, double d, SubscriptionType subscriptionType, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            uuid = subscriptionPackage.id;
        }
        if ((i2 & 2) != 0) {
            str = subscriptionPackage.name;
        }
        if ((i2 & 4) != 0) {
            i = subscriptionPackage.price;
        }
        if ((i2 & 8) != 0) {
            str2 = subscriptionPackage.description;
        }
        if ((i2 & 16) != 0) {
            d = subscriptionPackage.limit;
        }
        if ((i2 & 32) != 0) {
            subscriptionType = subscriptionPackage.type;
        }
        if ((i2 & 64) != 0) {
            l = subscriptionPackage.updatedAt;
        }
        double d2 = d;
        int i3 = i;
        String str3 = str2;
        return subscriptionPackage.copy(uuid, str, i3, str3, d2, subscriptionType, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UUID getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final double getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SubscriptionType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getUpdatedAt() {
        return this.updatedAt;
    }

    public final SubscriptionPackage copy(UUID id, String name, int price, String description, double limit, SubscriptionType type, Long updatedAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(type, "type");
        return new SubscriptionPackage(id, name, price, description, limit, type, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionPackage)) {
            return false;
        }
        SubscriptionPackage subscriptionPackage = (SubscriptionPackage) other;
        return Intrinsics.areEqual(this.id, subscriptionPackage.id) && Intrinsics.areEqual(this.name, subscriptionPackage.name) && this.price == subscriptionPackage.price && Intrinsics.areEqual(this.description, subscriptionPackage.description) && Double.compare(this.limit, subscriptionPackage.limit) == 0 && this.type == subscriptionPackage.type && Intrinsics.areEqual(this.updatedAt, subscriptionPackage.updatedAt);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.price)) * 31) + this.description.hashCode()) * 31) + Double.hashCode(this.limit)) * 31) + this.type.hashCode()) * 31;
        Long l = this.updatedAt;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "SubscriptionPackage(id=" + this.id + ", name=" + this.name + ", price=" + this.price + ", description=" + this.description + ", limit=" + this.limit + ", type=" + this.type + ", updatedAt=" + this.updatedAt + ")";
    }

    public SubscriptionPackage(UUID id, String name, int i, String description, double d, SubscriptionType type, Long l) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.name = name;
        this.price = i;
        this.description = description;
        this.limit = d;
        this.type = type;
        this.updatedAt = l;
    }

    public /* synthetic */ SubscriptionPackage(UUID uuid, String str, int i, String str2, double d, SubscriptionType subscriptionType, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(uuid, str, i, str2, d, subscriptionType, (i2 & 64) != 0 ? null : l);
    }

    public final UUID getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPrice() {
        return this.price;
    }

    public final String getDescription() {
        return this.description;
    }

    public final double getLimit() {
        return this.limit;
    }

    public final SubscriptionType getType() {
        return this.type;
    }

    public final Long getUpdatedAt() {
        return this.updatedAt;
    }
}
