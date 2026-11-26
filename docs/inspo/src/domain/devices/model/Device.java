package com.example.bingwahybrid.domain.devices.model;

import com.example.bingwahybrid.domain.enums.AppState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Device.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/example/bingwahybrid/domain/devices/model/Device;", "", "id", "", "connectId", "appState", "Lcom/example/bingwahybrid/domain/enums/AppState;", "deviceModel", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/example/bingwahybrid/domain/enums/AppState;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getConnectId", "getAppState", "()Lcom/example/bingwahybrid/domain/enums/AppState;", "getDeviceModel", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Device {
    public static final int $stable = 0;
    private final AppState appState;
    private final String connectId;
    private final String deviceModel;
    private final String id;
    private final String name;

    public static /* synthetic */ Device copy$default(Device device, String str, String str2, AppState appState, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = device.id;
        }
        if ((i & 2) != 0) {
            str2 = device.connectId;
        }
        if ((i & 4) != 0) {
            appState = device.appState;
        }
        if ((i & 8) != 0) {
            str3 = device.deviceModel;
        }
        if ((i & 16) != 0) {
            str4 = device.name;
        }
        String str5 = str4;
        AppState appState2 = appState;
        return device.copy(str, str2, appState2, str3, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getConnectId() {
        return this.connectId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AppState getAppState() {
        return this.appState;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Device copy(String id, String connectId, AppState appState, String deviceModel, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(appState, "appState");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        return new Device(id, connectId, appState, deviceModel, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Device)) {
            return false;
        }
        Device device = (Device) other;
        return Intrinsics.areEqual(this.id, device.id) && Intrinsics.areEqual(this.connectId, device.connectId) && this.appState == device.appState && Intrinsics.areEqual(this.deviceModel, device.deviceModel) && Intrinsics.areEqual(this.name, device.name);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.connectId;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.appState.hashCode()) * 31) + this.deviceModel.hashCode()) * 31;
        String str2 = this.name;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Device(id=" + this.id + ", connectId=" + this.connectId + ", appState=" + this.appState + ", deviceModel=" + this.deviceModel + ", name=" + this.name + ")";
    }

    public Device(String id, String str, AppState appState, String deviceModel, String str2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(appState, "appState");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        this.id = id;
        this.connectId = str;
        this.appState = appState;
        this.deviceModel = deviceModel;
        this.name = str2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getConnectId() {
        return this.connectId;
    }

    public final AppState getAppState() {
        return this.appState;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final String getName() {
        return this.name;
    }
}
