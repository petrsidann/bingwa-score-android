package com.example.bingwahybrid.domain.auth.models;

import androidx.autofill.HintConstants;
import com.example.bingwahybrid.core.proguard.KeepApiModel;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Agent.kt */
/* JADX INFO: loaded from: classes3.dex */
@KeepApiModel
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J[\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0017R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0017¨\u0006&"}, d2 = {"Lcom/example/bingwahybrid/domain/auth/models/Agent;", "", "id", "Ljava/util/UUID;", "firstName", "", "lastName", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "email", "pin", "isActive", "", "isSuspended", "<init>", "(Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getId", "()Ljava/util/UUID;", "getFirstName", "()Ljava/lang/String;", "getLastName", "getPhoneNumber", "getEmail", "getPin", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Agent {
    public static final int $stable = 8;
    private final String email;
    private final String firstName;
    private final UUID id;
    private final boolean isActive;
    private final boolean isSuspended;
    private final String lastName;
    private final String phoneNumber;
    private final String pin;

    public static /* synthetic */ Agent copy$default(Agent agent, UUID uuid, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            uuid = agent.id;
        }
        if ((i & 2) != 0) {
            str = agent.firstName;
        }
        if ((i & 4) != 0) {
            str2 = agent.lastName;
        }
        if ((i & 8) != 0) {
            str3 = agent.phoneNumber;
        }
        if ((i & 16) != 0) {
            str4 = agent.email;
        }
        if ((i & 32) != 0) {
            str5 = agent.pin;
        }
        if ((i & 64) != 0) {
            z = agent.isActive;
        }
        if ((i & 128) != 0) {
            z2 = agent.isSuspended;
        }
        boolean z3 = z;
        boolean z4 = z2;
        String str6 = str4;
        String str7 = str5;
        return agent.copy(uuid, str, str2, str3, str6, str7, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UUID getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLastName() {
        return this.lastName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPin() {
        return this.pin;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsSuspended() {
        return this.isSuspended;
    }

    public final Agent copy(UUID id, String firstName, String lastName, String phoneNumber, String email, String pin, boolean isActive, boolean isSuspended) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(email, "email");
        return new Agent(id, firstName, lastName, phoneNumber, email, pin, isActive, isSuspended);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Agent)) {
            return false;
        }
        Agent agent = (Agent) other;
        return Intrinsics.areEqual(this.id, agent.id) && Intrinsics.areEqual(this.firstName, agent.firstName) && Intrinsics.areEqual(this.lastName, agent.lastName) && Intrinsics.areEqual(this.phoneNumber, agent.phoneNumber) && Intrinsics.areEqual(this.email, agent.email) && Intrinsics.areEqual(this.pin, agent.pin) && this.isActive == agent.isActive && this.isSuspended == agent.isSuspended;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.id.hashCode() * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31) + this.phoneNumber.hashCode()) * 31) + this.email.hashCode()) * 31;
        String str = this.pin;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isActive)) * 31) + Boolean.hashCode(this.isSuspended);
    }

    public String toString() {
        return "Agent(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", phoneNumber=" + this.phoneNumber + ", email=" + this.email + ", pin=" + this.pin + ", isActive=" + this.isActive + ", isSuspended=" + this.isSuspended + ")";
    }

    public Agent(UUID id, String firstName, String lastName, String phoneNumber, String email, String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(email, "email");
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.pin = str;
        this.isActive = z;
        this.isSuspended = z2;
    }

    public /* synthetic */ Agent(UUID uuid, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uuid, str, str2, str3, str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? false : z, (i & 128) != 0 ? false : z2);
    }

    public final UUID getId() {
        return this.id;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPin() {
        return this.pin;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isSuspended() {
        return this.isSuspended;
    }
}
