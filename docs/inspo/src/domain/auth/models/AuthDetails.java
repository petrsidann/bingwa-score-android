package com.example.bingwahybrid.domain.auth.models;

import com.example.bingwahybrid.core.proguard.KeepApiModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthDetails.kt */
/* JADX INFO: loaded from: classes3.dex */
@KeepApiModel
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/example/bingwahybrid/domain/auth/models/AuthDetails;", "", "agent", "Lcom/example/bingwahybrid/domain/auth/models/Agent;", "token", "", "refreshToken", "<init>", "(Lcom/example/bingwahybrid/domain/auth/models/Agent;Ljava/lang/String;Ljava/lang/String;)V", "getAgent", "()Lcom/example/bingwahybrid/domain/auth/models/Agent;", "getToken", "()Ljava/lang/String;", "getRefreshToken", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AuthDetails {
    public static final int $stable = 8;
    private final Agent agent;
    private final String refreshToken;
    private final String token;

    public static /* synthetic */ AuthDetails copy$default(AuthDetails authDetails, Agent agent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            agent = authDetails.agent;
        }
        if ((i & 2) != 0) {
            str = authDetails.token;
        }
        if ((i & 4) != 0) {
            str2 = authDetails.refreshToken;
        }
        return authDetails.copy(agent, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Agent getAgent() {
        return this.agent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final AuthDetails copy(Agent agent, String token, String refreshToken) {
        Intrinsics.checkNotNullParameter(agent, "agent");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        return new AuthDetails(agent, token, refreshToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthDetails)) {
            return false;
        }
        AuthDetails authDetails = (AuthDetails) other;
        return Intrinsics.areEqual(this.agent, authDetails.agent) && Intrinsics.areEqual(this.token, authDetails.token) && Intrinsics.areEqual(this.refreshToken, authDetails.refreshToken);
    }

    public int hashCode() {
        return (((this.agent.hashCode() * 31) + this.token.hashCode()) * 31) + this.refreshToken.hashCode();
    }

    public String toString() {
        return "AuthDetails(agent=" + this.agent + ", token=" + this.token + ", refreshToken=" + this.refreshToken + ")";
    }

    public AuthDetails(Agent agent, String token, String refreshToken) {
        Intrinsics.checkNotNullParameter(agent, "agent");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        this.agent = agent;
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public final Agent getAgent() {
        return this.agent;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }
}
