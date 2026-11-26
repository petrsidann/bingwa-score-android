package com.example.bingwahybrid.domain.features.model;

import com.example.bingwahybrid.domain.enums.SubscriptionType;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeaturePass.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\tHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001a¨\u0006'"}, d2 = {"Lcom/example/bingwahybrid/domain/features/model/FeaturePass;", "", "id", "", "name", "description", "limit", "", FirebaseAnalytics.Param.PRICE, "", "type", "Lcom/example/bingwahybrid/domain/enums/SubscriptionType;", "isActive", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DILcom/example/bingwahybrid/domain/enums/SubscriptionType;Z)V", "getId", "()Ljava/lang/String;", "getName", "getDescription", "getLimit", "()D", "getPrice", "()I", "getType", "()Lcom/example/bingwahybrid/domain/enums/SubscriptionType;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FeaturePass {
    public static final int $stable = 0;
    private final String description;
    private final String id;
    private final boolean isActive;
    private final double limit;
    private final String name;
    private final int price;
    private final SubscriptionType type;

    public static /* synthetic */ FeaturePass copy$default(FeaturePass featurePass, String str, String str2, String str3, double d, int i, SubscriptionType subscriptionType, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = featurePass.id;
        }
        if ((i2 & 2) != 0) {
            str2 = featurePass.name;
        }
        if ((i2 & 4) != 0) {
            str3 = featurePass.description;
        }
        if ((i2 & 8) != 0) {
            d = featurePass.limit;
        }
        if ((i2 & 16) != 0) {
            i = featurePass.price;
        }
        if ((i2 & 32) != 0) {
            subscriptionType = featurePass.type;
        }
        if ((i2 & 64) != 0) {
            z = featurePass.isActive;
        }
        boolean z2 = z;
        int i3 = i;
        double d2 = d;
        String str4 = str3;
        return featurePass.copy(str, str2, str4, d2, i3, subscriptionType, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SubscriptionType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    public final FeaturePass copy(String id, String name, String description, double limit, int price, SubscriptionType type, boolean isActive) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(type, "type");
        return new FeaturePass(id, name, description, limit, price, type, isActive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeaturePass)) {
            return false;
        }
        FeaturePass featurePass = (FeaturePass) other;
        return Intrinsics.areEqual(this.id, featurePass.id) && Intrinsics.areEqual(this.name, featurePass.name) && Intrinsics.areEqual(this.description, featurePass.description) && Double.compare(this.limit, featurePass.limit) == 0 && this.price == featurePass.price && this.type == featurePass.type && this.isActive == featurePass.isActive;
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + Double.hashCode(this.limit)) * 31) + Integer.hashCode(this.price)) * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.isActive);
    }

    public String toString() {
        return "FeaturePass(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", limit=" + this.limit + ", price=" + this.price + ", type=" + this.type + ", isActive=" + this.isActive + ")";
    }

    public FeaturePass(String id, String name, String description, double d, int i, SubscriptionType type, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.name = name;
        this.description = description;
        this.limit = d;
        this.price = i;
        this.type = type;
        this.isActive = z;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final double getLimit() {
        return this.limit;
    }

    public final int getPrice() {
        return this.price;
    }

    public /* synthetic */ FeaturePass(String str, String str2, String str3, double d, int i, SubscriptionType subscriptionType, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, d, i, (i2 & 32) != 0 ? SubscriptionType.UNLIMITED : subscriptionType, z);
    }

    public final SubscriptionType getType() {
        return this.type;
    }

    public final boolean isActive() {
        return this.isActive;
    }
}
