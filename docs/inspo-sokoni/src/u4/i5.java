package u4;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbu;
import com.google.android.gms.internal.measurement.zzbw;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i5 extends zzbu implements f5 {
    public i5(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // u4.f5
    public final void A(h hVar, me meVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, hVar);
        zzbw.zza(parcelB_, meVar);
        zzb(12, parcelB_);
    }

    @Override // u4.f5
    public final List<ze> B(String str, String str2, String str3, boolean z10) {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        parcelB_.writeString(str3);
        zzbw.zza(parcelB_, z10);
        Parcel parcelZza = zza(15, parcelB_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(ze.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // u4.f5
    public final void C0(me meVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, meVar);
        zzb(4, parcelB_);
    }

    @Override // u4.f5
    public final void F(me meVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, meVar);
        zzb(6, parcelB_);
    }

    @Override // u4.f5
    public final void G0(me meVar, Bundle bundle, h5 h5Var) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, meVar);
        zzbw.zza(parcelB_, bundle);
        zzbw.zza(parcelB_, h5Var);
        zzb(31, parcelB_);
    }

    @Override // u4.f5
    public final void O0(me meVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, meVar);
        zzb(18, parcelB_);
    }

    @Override // u4.f5
    public final void P(me meVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, meVar);
        zzb(25, parcelB_);
    }

    @Override // u4.f5
    public final List<h> R0(String str, String str2, me meVar) {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        zzbw.zza(parcelB_, meVar);
        Parcel parcelZza = zza(16, parcelB_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(h.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // u4.f5
    public final void S0(me meVar, be beVar, m5 m5Var) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, meVar);
        zzbw.zza(parcelB_, beVar);
        zzbw.zza(parcelB_, m5Var);
        zzb(29, parcelB_);
    }

    @Override // u4.f5
    public final List<sd> T(me meVar, Bundle bundle) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, meVar);
        zzbw.zza(parcelB_, bundle);
        Parcel parcelZza = zza(24, parcelB_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(sd.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // u4.f5
    public final List<ze> U0(String str, String str2, boolean z10, me meVar) {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        zzbw.zza(parcelB_, z10);
        zzbw.zza(parcelB_, meVar);
        Parcel parcelZza = zza(14, parcelB_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(ze.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // u4.f5
    public final byte[] W(n0 n0Var, String str) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, n0Var);
        parcelB_.writeString(str);
        Parcel parcelZza = zza(9, parcelB_);
        byte[] bArrCreateByteArray = parcelZza.createByteArray();
        parcelZza.recycle();
        return bArrCreateByteArray;
    }

    @Override // u4.f5
    public final q X(me meVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, meVar);
        Parcel parcelZza = zza(21, parcelB_);
        q qVar = (q) zzbw.zza(parcelZza, q.CREATOR);
        parcelZza.recycle();
        return qVar;
    }

    @Override // u4.f5
    public final void Y(n0 n0Var, me meVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, n0Var);
        zzbw.zza(parcelB_, meVar);
        zzb(1, parcelB_);
    }

    @Override // u4.f5
    public final void Y0(me meVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, meVar);
        zzb(20, parcelB_);
    }

    @Override // u4.f5
    public final void c0(n0 n0Var, String str, String str2) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, n0Var);
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        zzb(5, parcelB_);
    }

    @Override // u4.f5
    public final void f0(long j10, String str, String str2, String str3) {
        Parcel parcelB_ = b_();
        parcelB_.writeLong(j10);
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        parcelB_.writeString(str3);
        zzb(10, parcelB_);
    }

    @Override // u4.f5
    public final List<h> h0(String str, String str2, String str3) {
        Parcel parcelB_ = b_();
        parcelB_.writeString(str);
        parcelB_.writeString(str2);
        parcelB_.writeString(str3);
        Parcel parcelZza = zza(17, parcelB_);
        ArrayList arrayListCreateTypedArrayList = parcelZza.createTypedArrayList(h.CREATOR);
        parcelZza.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // u4.f5
    public final void i0(ze zeVar, me meVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, zeVar);
        zzbw.zza(parcelB_, meVar);
        zzb(2, parcelB_);
    }

    @Override // u4.f5
    public final void j0(h hVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, hVar);
        zzb(13, parcelB_);
    }

    @Override // u4.f5
    public final String l0(me meVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, meVar);
        Parcel parcelZza = zza(11, parcelB_);
        String string = parcelZza.readString();
        parcelZza.recycle();
        return string;
    }

    @Override // u4.f5
    public final void m(me meVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, meVar);
        zzb(26, parcelB_);
    }

    @Override // u4.f5
    public final void m0(me meVar, f fVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, meVar);
        zzbw.zza(parcelB_, fVar);
        zzb(30, parcelB_);
    }

    @Override // u4.f5
    public final void t0(me meVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, meVar);
        zzb(27, parcelB_);
    }

    @Override // u4.f5
    public final void w0(Bundle bundle, me meVar) {
        Parcel parcelB_ = b_();
        zzbw.zza(parcelB_, bundle);
        zzbw.zza(parcelB_, meVar);
        zzb(19, parcelB_);
    }
}
