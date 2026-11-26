package com.example.bingwahybrid.domain.subscriptions.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignedSubscription.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/example/bingwahybrid/domain/subscriptions/model/SignedSubscription;", "", "data", "Lcom/example/bingwahybrid/domain/subscriptions/model/Subscription;", "signature", "", "<init>", "(Lcom/example/bingwahybrid/domain/subscriptions/model/Subscription;Ljava/lang/String;)V", "getData", "()Lcom/example/bingwahybrid/domain/subscriptions/model/Subscription;", "getSignature", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SignedSubscription {
    public static final int $stable = 0;
    private final Subscription data;
    private final String signature;

    public static /* synthetic */ SignedSubscription copy$default(SignedSubscription signedSubscription, Subscription subscription, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            subscription = signedSubscription.data;
        }
        if ((i & 2) != 0) {
            str = signedSubscription.signature;
        }
        return signedSubscription.copy(subscription, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Subscription getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    public final SignedSubscription copy(Subscription data, String signature) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(signature, "signature");
        return new SignedSubscription(data, signature);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignedSubscription)) {
            return false;
        }
        SignedSubscription signedSubscription = (SignedSubscription) other;
        return Intrinsics.areEqual(this.data, signedSubscription.data) && Intrinsics.areEqual(this.signature, signedSubscription.signature);
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.signature.hashCode();
    }

    public String toString() {
        return "SignedSubscription(data=" + this.data + ", signature=" + this.signature + ")";
    }

    public SignedSubscription(Subscription data, String signature) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(signature, "signature");
        this.data = data;
        this.signature = signature;
    }

    public final Subscription getData() {
        return this.data;
    }

    public final String getSignature() {
        return this.signature;
    }
}
