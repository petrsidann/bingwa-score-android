package com.example.bingwahybrid.domain.updates.enums;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/example/bingwahybrid/domain/updates/enums/UpdateState;", "", "<init>", "()V", "Loading", "UpToDate", "UpdateRequired", "Downloading", "Installing", "Error", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState$Downloading;", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState$Error;", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState$Installing;", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState$Loading;", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState$UpToDate;", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState$UpdateRequired;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class UpdateState {
    public static final int $stable = 0;

    public /* synthetic */ UpdateState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: UpdateState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/updates/enums/UpdateState$Loading;", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Loading extends UpdateState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Loading)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 220044643;
        }

        public String toString() {
            return "Loading";
        }

        private Loading() {
            super(null);
        }
    }

    private UpdateState() {
    }

    /* JADX INFO: compiled from: UpdateState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/updates/enums/UpdateState$UpToDate;", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpToDate extends UpdateState {
        public static final int $stable = 0;
        public static final UpToDate INSTANCE = new UpToDate();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpToDate)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1556209661;
        }

        public String toString() {
            return "UpToDate";
        }

        private UpToDate() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: UpdateState.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/example/bingwahybrid/domain/updates/enums/UpdateState$UpdateRequired;", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState;", "apkUrl", "", "changelog", "isMandatory", "", "versionCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getApkUrl", "()Ljava/lang/String;", "getChangelog", "()Z", "getVersionCode", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpdateRequired extends UpdateState {
        public static final int $stable = 0;
        private final String apkUrl;
        private final String changelog;
        private final boolean isMandatory;
        private final String versionCode;

        public static /* synthetic */ UpdateRequired copy$default(UpdateRequired updateRequired, String str, String str2, boolean z, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updateRequired.apkUrl;
            }
            if ((i & 2) != 0) {
                str2 = updateRequired.changelog;
            }
            if ((i & 4) != 0) {
                z = updateRequired.isMandatory;
            }
            if ((i & 8) != 0) {
                str3 = updateRequired.versionCode;
            }
            return updateRequired.copy(str, str2, z, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getApkUrl() {
            return this.apkUrl;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getChangelog() {
            return this.changelog;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsMandatory() {
            return this.isMandatory;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getVersionCode() {
            return this.versionCode;
        }

        public final UpdateRequired copy(String apkUrl, String changelog, boolean isMandatory, String versionCode) {
            Intrinsics.checkNotNullParameter(apkUrl, "apkUrl");
            Intrinsics.checkNotNullParameter(changelog, "changelog");
            Intrinsics.checkNotNullParameter(versionCode, "versionCode");
            return new UpdateRequired(apkUrl, changelog, isMandatory, versionCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateRequired)) {
                return false;
            }
            UpdateRequired updateRequired = (UpdateRequired) other;
            return Intrinsics.areEqual(this.apkUrl, updateRequired.apkUrl) && Intrinsics.areEqual(this.changelog, updateRequired.changelog) && this.isMandatory == updateRequired.isMandatory && Intrinsics.areEqual(this.versionCode, updateRequired.versionCode);
        }

        public int hashCode() {
            return (((((this.apkUrl.hashCode() * 31) + this.changelog.hashCode()) * 31) + Boolean.hashCode(this.isMandatory)) * 31) + this.versionCode.hashCode();
        }

        public String toString() {
            return "UpdateRequired(apkUrl=" + this.apkUrl + ", changelog=" + this.changelog + ", isMandatory=" + this.isMandatory + ", versionCode=" + this.versionCode + ")";
        }

        public final String getApkUrl() {
            return this.apkUrl;
        }

        public final String getChangelog() {
            return this.changelog;
        }

        public final boolean isMandatory() {
            return this.isMandatory;
        }

        public final String getVersionCode() {
            return this.versionCode;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateRequired(String apkUrl, String changelog, boolean z, String versionCode) {
            super(null);
            Intrinsics.checkNotNullParameter(apkUrl, "apkUrl");
            Intrinsics.checkNotNullParameter(changelog, "changelog");
            Intrinsics.checkNotNullParameter(versionCode, "versionCode");
            this.apkUrl = apkUrl;
            this.changelog = changelog;
            this.isMandatory = z;
            this.versionCode = versionCode;
        }
    }

    /* JADX INFO: compiled from: UpdateState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/updates/enums/UpdateState$Downloading;", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState;", NotificationCompat.CATEGORY_PROGRESS, "", "<init>", "(I)V", "getProgress", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Downloading extends UpdateState {
        public static final int $stable = 0;
        private final int progress;

        public static /* synthetic */ Downloading copy$default(Downloading downloading, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = downloading.progress;
            }
            return downloading.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getProgress() {
            return this.progress;
        }

        public final Downloading copy(int progress) {
            return new Downloading(progress);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Downloading) && this.progress == ((Downloading) other).progress;
        }

        public int hashCode() {
            return Integer.hashCode(this.progress);
        }

        public String toString() {
            return "Downloading(progress=" + this.progress + ")";
        }

        public Downloading(int i) {
            super(null);
            this.progress = i;
        }

        public final int getProgress() {
            return this.progress;
        }
    }

    /* JADX INFO: compiled from: UpdateState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/updates/enums/UpdateState$Installing;", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Installing extends UpdateState {
        public static final int $stable = 0;
        public static final Installing INSTANCE = new Installing();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Installing)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1722238688;
        }

        public String toString() {
            return "Installing";
        }

        private Installing() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: UpdateState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/updates/enums/UpdateState$Error;", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Error extends UpdateState {
        public static final int $stable = 0;
        private final String message;

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.message;
            }
            return error.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Error copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Error(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.message, ((Error) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Error(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}
