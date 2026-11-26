package com.example.bingwahybrid.domain.sms.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthorizedSender.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/model/AuthorizedSender;", "", "id", "", "sender", "", "<init>", "(JLjava/lang/String;)V", "getId", "()J", "getSender", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AuthorizedSender {
    public static final int $stable = 0;
    private final long id;
    private final String sender;

    public static /* synthetic */ AuthorizedSender copy$default(AuthorizedSender authorizedSender, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = authorizedSender.id;
        }
        if ((i & 2) != 0) {
            str = authorizedSender.sender;
        }
        return authorizedSender.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSender() {
        return this.sender;
    }

    public final AuthorizedSender copy(long id, String sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        return new AuthorizedSender(id, sender);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthorizedSender)) {
            return false;
        }
        AuthorizedSender authorizedSender = (AuthorizedSender) other;
        return this.id == authorizedSender.id && Intrinsics.areEqual(this.sender, authorizedSender.sender);
    }

    public int hashCode() {
        return (Long.hashCode(this.id) * 31) + this.sender.hashCode();
    }

    public String toString() {
        return "AuthorizedSender(id=" + this.id + ", sender=" + this.sender + ")";
    }

    public AuthorizedSender(long j, String sender) {
        Intrinsics.checkNotNullParameter(sender, "sender");
        this.id = j;
        this.sender = sender;
    }

    public final long getId() {
        return this.id;
    }

    public final String getSender() {
        return this.sender;
    }
}
