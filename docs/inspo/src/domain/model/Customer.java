package com.example.bingwahybrid.domain.model;

import androidx.autofill.HintConstants;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Customer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J[\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001b¨\u0006+"}, d2 = {"Lcom/example/bingwahybrid/domain/model/Customer;", "", "id", "", "stableId", "Ljava/util/UUID;", "name", "", HintConstants.AUTOFILL_HINT_PHONE, "accountBalance", "lastPurchaseTime", "", "isSavedInContacts", "", "isBlackListed", "<init>", "(ILjava/util/UUID;Ljava/lang/String;Ljava/lang/String;IJZZ)V", "getId", "()I", "getStableId", "()Ljava/util/UUID;", "getName", "()Ljava/lang/String;", "getPhone", "getAccountBalance", "getLastPurchaseTime", "()J", "()Z", "toJson", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Customer {
    public static final int $stable = 8;
    private final int accountBalance;
    private final int id;
    private final boolean isBlackListed;
    private final boolean isSavedInContacts;
    private final long lastPurchaseTime;
    private final String name;
    private final String phone;
    private final UUID stableId;

    public static /* synthetic */ Customer copy$default(Customer customer, int i, UUID uuid, String str, String str2, int i2, long j, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = customer.id;
        }
        if ((i3 & 2) != 0) {
            uuid = customer.stableId;
        }
        if ((i3 & 4) != 0) {
            str = customer.name;
        }
        if ((i3 & 8) != 0) {
            str2 = customer.phone;
        }
        if ((i3 & 16) != 0) {
            i2 = customer.accountBalance;
        }
        if ((i3 & 32) != 0) {
            j = customer.lastPurchaseTime;
        }
        if ((i3 & 64) != 0) {
            z = customer.isSavedInContacts;
        }
        if ((i3 & 128) != 0) {
            z2 = customer.isBlackListed;
        }
        long j2 = j;
        String str3 = str2;
        int i4 = i2;
        String str4 = str;
        return customer.copy(i, uuid, str4, str3, i4, j2, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UUID getStableId() {
        return this.stableId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getAccountBalance() {
        return this.accountBalance;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getLastPurchaseTime() {
        return this.lastPurchaseTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsSavedInContacts() {
        return this.isSavedInContacts;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsBlackListed() {
        return this.isBlackListed;
    }

    public final Customer copy(int id, UUID stableId, String name, String phone, int accountBalance, long lastPurchaseTime, boolean isSavedInContacts, boolean isBlackListed) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phone, "phone");
        return new Customer(id, stableId, name, phone, accountBalance, lastPurchaseTime, isSavedInContacts, isBlackListed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) other;
        return this.id == customer.id && Intrinsics.areEqual(this.stableId, customer.stableId) && Intrinsics.areEqual(this.name, customer.name) && Intrinsics.areEqual(this.phone, customer.phone) && this.accountBalance == customer.accountBalance && this.lastPurchaseTime == customer.lastPurchaseTime && this.isSavedInContacts == customer.isSavedInContacts && this.isBlackListed == customer.isBlackListed;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id) * 31;
        UUID uuid = this.stableId;
        return ((((((((((((iHashCode + (uuid == null ? 0 : uuid.hashCode())) * 31) + this.name.hashCode()) * 31) + this.phone.hashCode()) * 31) + Integer.hashCode(this.accountBalance)) * 31) + Long.hashCode(this.lastPurchaseTime)) * 31) + Boolean.hashCode(this.isSavedInContacts)) * 31) + Boolean.hashCode(this.isBlackListed);
    }

    public String toString() {
        return "Customer(id=" + this.id + ", stableId=" + this.stableId + ", name=" + this.name + ", phone=" + this.phone + ", accountBalance=" + this.accountBalance + ", lastPurchaseTime=" + this.lastPurchaseTime + ", isSavedInContacts=" + this.isSavedInContacts + ", isBlackListed=" + this.isBlackListed + ")";
    }

    public Customer(int i, UUID uuid, String name, String phone, int i2, long j, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.id = i;
        this.stableId = uuid;
        this.name = name;
        this.phone = phone;
        this.accountBalance = i2;
        this.lastPurchaseTime = j;
        this.isSavedInContacts = z;
        this.isBlackListed = z2;
    }

    public final int getId() {
        return this.id;
    }

    public final UUID getStableId() {
        return this.stableId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final int getAccountBalance() {
        return this.accountBalance;
    }

    public /* synthetic */ Customer(int i, UUID uuid, String str, String str2, int i2, long j, boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, uuid, str, str2, (i3 & 16) != 0 ? 0 : i2, (i3 & 32) != 0 ? System.currentTimeMillis() : j, (i3 & 64) != 0 ? false : z, (i3 & 128) != 0 ? false : z2);
    }

    public final long getLastPurchaseTime() {
        return this.lastPurchaseTime;
    }

    public final boolean isSavedInContacts() {
        return this.isSavedInContacts;
    }

    public final boolean isBlackListed() {
        return this.isBlackListed;
    }

    public final JSONObject toJson() throws JSONException {
        Object string;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        UUID uuid = this.stableId;
        if (uuid == null || (string = uuid.toString()) == null) {
            string = JSONObject.NULL;
        }
        jSONObject.put("stableId", string);
        jSONObject.put("name", this.name);
        jSONObject.put(HintConstants.AUTOFILL_HINT_PHONE, this.phone);
        jSONObject.put("isBlacklisted", this.isBlackListed);
        return jSONObject;
    }
}
