package com.example.bingwahybrid.domain.features.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Feature.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/example/bingwahybrid/domain/features/model/Feature;", "", "id", "", "code", "name", "description", "requiresPurchase", "", "isActive", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getId", "()Ljava/lang/String;", "getCode", "getName", "getDescription", "getRequiresPurchase", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Feature {
    public static final int $stable = 0;
    private final String code;
    private final String description;
    private final String id;
    private final boolean isActive;
    private final String name;
    private final boolean requiresPurchase;

    public static /* synthetic */ Feature copy$default(Feature feature, String str, String str2, String str3, String str4, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feature.id;
        }
        if ((i & 2) != 0) {
            str2 = feature.code;
        }
        if ((i & 4) != 0) {
            str3 = feature.name;
        }
        if ((i & 8) != 0) {
            str4 = feature.description;
        }
        if ((i & 16) != 0) {
            z = feature.requiresPurchase;
        }
        if ((i & 32) != 0) {
            z2 = feature.isActive;
        }
        boolean z3 = z;
        boolean z4 = z2;
        return feature.copy(str, str2, str3, str4, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getRequiresPurchase() {
        return this.requiresPurchase;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    public final Feature copy(String id, String code, String name, String description, boolean requiresPurchase, boolean isActive) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        return new Feature(id, code, name, description, requiresPurchase, isActive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Feature)) {
            return false;
        }
        Feature feature = (Feature) other;
        return Intrinsics.areEqual(this.id, feature.id) && Intrinsics.areEqual(this.code, feature.code) && Intrinsics.areEqual(this.name, feature.name) && Intrinsics.areEqual(this.description, feature.description) && this.requiresPurchase == feature.requiresPurchase && this.isActive == feature.isActive;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.code.hashCode()) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + Boolean.hashCode(this.requiresPurchase)) * 31) + Boolean.hashCode(this.isActive);
    }

    public String toString() {
        return "Feature(id=" + this.id + ", code=" + this.code + ", name=" + this.name + ", description=" + this.description + ", requiresPurchase=" + this.requiresPurchase + ", isActive=" + this.isActive + ")";
    }

    public Feature(String id, String code, String name, String description, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.requiresPurchase = z;
        this.isActive = z2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getRequiresPurchase() {
        return this.requiresPurchase;
    }

    public final boolean isActive() {
        return this.isActive;
    }
}
