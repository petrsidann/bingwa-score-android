package com.example.bingwahybrid.domain.devices.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CurrentDevice.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003JO\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/example/bingwahybrid/domain/devices/model/CurrentDevice;", "", "isMIUI", "", "isEMUI", "isFuntouch", "isOneUI", "isVivo", "isXiaomi", "isSamsung", "<init>", "(ZZZZZZZ)V", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CurrentDevice {
    public static final int $stable = 0;
    private final boolean isEMUI;
    private final boolean isFuntouch;
    private final boolean isMIUI;
    private final boolean isOneUI;
    private final boolean isSamsung;
    private final boolean isVivo;
    private final boolean isXiaomi;

    public CurrentDevice() {
        this(false, false, false, false, false, false, false, 127, null);
    }

    public static /* synthetic */ CurrentDevice copy$default(CurrentDevice currentDevice, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        if ((i & 1) != 0) {
            z = currentDevice.isMIUI;
        }
        if ((i & 2) != 0) {
            z2 = currentDevice.isEMUI;
        }
        if ((i & 4) != 0) {
            z3 = currentDevice.isFuntouch;
        }
        if ((i & 8) != 0) {
            z4 = currentDevice.isOneUI;
        }
        if ((i & 16) != 0) {
            z5 = currentDevice.isVivo;
        }
        if ((i & 32) != 0) {
            z6 = currentDevice.isXiaomi;
        }
        if ((i & 64) != 0) {
            z7 = currentDevice.isSamsung;
        }
        boolean z8 = z6;
        boolean z9 = z7;
        boolean z10 = z5;
        boolean z11 = z3;
        return currentDevice.copy(z, z2, z11, z4, z10, z8, z9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsMIUI() {
        return this.isMIUI;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsEMUI() {
        return this.isEMUI;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsFuntouch() {
        return this.isFuntouch;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsOneUI() {
        return this.isOneUI;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsVivo() {
        return this.isVivo;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsXiaomi() {
        return this.isXiaomi;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsSamsung() {
        return this.isSamsung;
    }

    public final CurrentDevice copy(boolean isMIUI, boolean isEMUI, boolean isFuntouch, boolean isOneUI, boolean isVivo, boolean isXiaomi, boolean isSamsung) {
        return new CurrentDevice(isMIUI, isEMUI, isFuntouch, isOneUI, isVivo, isXiaomi, isSamsung);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CurrentDevice)) {
            return false;
        }
        CurrentDevice currentDevice = (CurrentDevice) other;
        return this.isMIUI == currentDevice.isMIUI && this.isEMUI == currentDevice.isEMUI && this.isFuntouch == currentDevice.isFuntouch && this.isOneUI == currentDevice.isOneUI && this.isVivo == currentDevice.isVivo && this.isXiaomi == currentDevice.isXiaomi && this.isSamsung == currentDevice.isSamsung;
    }

    public int hashCode() {
        return (((((((((((Boolean.hashCode(this.isMIUI) * 31) + Boolean.hashCode(this.isEMUI)) * 31) + Boolean.hashCode(this.isFuntouch)) * 31) + Boolean.hashCode(this.isOneUI)) * 31) + Boolean.hashCode(this.isVivo)) * 31) + Boolean.hashCode(this.isXiaomi)) * 31) + Boolean.hashCode(this.isSamsung);
    }

    public String toString() {
        return "CurrentDevice(isMIUI=" + this.isMIUI + ", isEMUI=" + this.isEMUI + ", isFuntouch=" + this.isFuntouch + ", isOneUI=" + this.isOneUI + ", isVivo=" + this.isVivo + ", isXiaomi=" + this.isXiaomi + ", isSamsung=" + this.isSamsung + ")";
    }

    public CurrentDevice(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.isMIUI = z;
        this.isEMUI = z2;
        this.isFuntouch = z3;
        this.isOneUI = z4;
        this.isVivo = z5;
        this.isXiaomi = z6;
        this.isSamsung = z7;
    }

    public /* synthetic */ CurrentDevice(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? false : z6, (i & 64) != 0 ? false : z7);
    }

    public final boolean isMIUI() {
        return this.isMIUI;
    }

    public final boolean isEMUI() {
        return this.isEMUI;
    }

    public final boolean isFuntouch() {
        return this.isFuntouch;
    }

    public final boolean isOneUI() {
        return this.isOneUI;
    }

    public final boolean isVivo() {
        return this.isVivo;
    }

    public final boolean isXiaomi() {
        return this.isXiaomi;
    }

    public final boolean isSamsung() {
        return this.isSamsung;
    }
}
