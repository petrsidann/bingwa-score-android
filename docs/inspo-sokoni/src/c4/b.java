package c4;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f3337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f3334e = new b(0);
    public static final Parcelable.Creator<b> CREATOR = new p();

    public b(int i10) {
        this(i10, null, null);
    }

    public b(int i10, int i11, PendingIntent pendingIntent, String str) {
        this.f3335a = i10;
        this.f3336b = i11;
        this.f3337c = pendingIntent;
        this.f3338d = str;
    }

    public b(int i10, PendingIntent pendingIntent) {
        this(i10, pendingIntent, null);
    }

    public b(int i10, PendingIntent pendingIntent, String str) {
        this(1, i10, pendingIntent, str);
    }

    public static String X(int i10) {
        if (i10 == 99) {
            return "UNFINISHED";
        }
        if (i10 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i10) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i10) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case d9.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        return "SIGN_IN_FAILED";
                    case d9.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i10 + ")";
                }
        }
    }

    public int S() {
        return this.f3336b;
    }

    public String T() {
        return this.f3338d;
    }

    public PendingIntent U() {
        return this.f3337c;
    }

    public boolean V() {
        return (this.f3336b == 0 || this.f3337c == null) ? false : true;
    }

    public boolean W() {
        return this.f3336b == 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3336b == bVar.f3336b && com.google.android.gms.common.internal.p.b(this.f3337c, bVar.f3337c) && com.google.android.gms.common.internal.p.b(this.f3338d, bVar.f3338d);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(Integer.valueOf(this.f3336b), this.f3337c, this.f3338d);
    }

    public String toString() {
        com.google.android.gms.common.internal.p.a aVarD = com.google.android.gms.common.internal.p.d(this);
        aVarD.a("statusCode", X(this.f3336b));
        aVarD.a("resolution", this.f3337c);
        aVarD.a("message", this.f3338d);
        return aVarD.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f3335a;
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, i11);
        d4.c.t(parcel, 2, S());
        d4.c.C(parcel, 3, U(), i10, false);
        d4.c.E(parcel, 4, T(), false);
        d4.c.b(parcel, iA);
    }
}
