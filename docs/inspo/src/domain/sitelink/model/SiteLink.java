package com.example.bingwahybrid.domain.sitelink.model;

import androidx.autofill.HintConstants;
import com.example.bingwahybrid.domain.sitelink.enums.SiteLinkAccountType;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SiteLink.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006$"}, d2 = {"Lcom/example/bingwahybrid/domain/sitelink/model/SiteLink;", "", "id", "", "siteName", ImagesContract.URL, "accountType", "Lcom/example/bingwahybrid/domain/sitelink/enums/SiteLinkAccountType;", "accountNumber", "isActive", "", HintConstants.AUTOFILL_HINT_USERNAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/example/bingwahybrid/domain/sitelink/enums/SiteLinkAccountType;Ljava/lang/String;ZLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSiteName", "getUrl", "getAccountType", "()Lcom/example/bingwahybrid/domain/sitelink/enums/SiteLinkAccountType;", "getAccountNumber", "()Z", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SiteLink {
    public static final int $stable = 0;
    private final String accountNumber;
    private final SiteLinkAccountType accountType;
    private final String id;
    private final boolean isActive;
    private final String siteName;
    private final String url;
    private final String username;

    public static /* synthetic */ SiteLink copy$default(SiteLink siteLink, String str, String str2, String str3, SiteLinkAccountType siteLinkAccountType, String str4, boolean z, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = siteLink.id;
        }
        if ((i & 2) != 0) {
            str2 = siteLink.siteName;
        }
        if ((i & 4) != 0) {
            str3 = siteLink.url;
        }
        if ((i & 8) != 0) {
            siteLinkAccountType = siteLink.accountType;
        }
        if ((i & 16) != 0) {
            str4 = siteLink.accountNumber;
        }
        if ((i & 32) != 0) {
            z = siteLink.isActive;
        }
        if ((i & 64) != 0) {
            str5 = siteLink.username;
        }
        boolean z2 = z;
        String str6 = str5;
        String str7 = str4;
        String str8 = str3;
        return siteLink.copy(str, str2, str8, siteLinkAccountType, str7, z2, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSiteName() {
        return this.siteName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SiteLinkAccountType getAccountType() {
        return this.accountType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAccountNumber() {
        return this.accountNumber;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    public final SiteLink copy(String id, String siteName, String url, SiteLinkAccountType accountType, String accountNumber, boolean isActive, String username) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(accountType, "accountType");
        Intrinsics.checkNotNullParameter(accountNumber, "accountNumber");
        return new SiteLink(id, siteName, url, accountType, accountNumber, isActive, username);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteLink)) {
            return false;
        }
        SiteLink siteLink = (SiteLink) other;
        return Intrinsics.areEqual(this.id, siteLink.id) && Intrinsics.areEqual(this.siteName, siteLink.siteName) && Intrinsics.areEqual(this.url, siteLink.url) && this.accountType == siteLink.accountType && Intrinsics.areEqual(this.accountNumber, siteLink.accountNumber) && this.isActive == siteLink.isActive && Intrinsics.areEqual(this.username, siteLink.username);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.id.hashCode() * 31) + this.siteName.hashCode()) * 31) + this.url.hashCode()) * 31) + this.accountType.hashCode()) * 31) + this.accountNumber.hashCode()) * 31) + Boolean.hashCode(this.isActive)) * 31;
        String str = this.username;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SiteLink(id=" + this.id + ", siteName=" + this.siteName + ", url=" + this.url + ", accountType=" + this.accountType + ", accountNumber=" + this.accountNumber + ", isActive=" + this.isActive + ", username=" + this.username + ")";
    }

    public SiteLink(String id, String siteName, String url, SiteLinkAccountType accountType, String accountNumber, boolean z, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(accountType, "accountType");
        Intrinsics.checkNotNullParameter(accountNumber, "accountNumber");
        this.id = id;
        this.siteName = siteName;
        this.url = url;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.isActive = z;
        this.username = str;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSiteName() {
        return this.siteName;
    }

    public final String getUrl() {
        return this.url;
    }

    public /* synthetic */ SiteLink(String str, String str2, String str3, SiteLinkAccountType siteLinkAccountType, String str4, boolean z, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? SiteLinkAccountType.TILL : siteLinkAccountType, str4, (i & 32) != 0 ? false : z, (i & 64) != 0 ? null : str5);
    }

    public final SiteLinkAccountType getAccountType() {
        return this.accountType;
    }

    public final String getAccountNumber() {
        return this.accountNumber;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final String getUsername() {
        return this.username;
    }
}
