package u4;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzbx;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class e5 extends zzbx implements f5 {
    public e5() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) {
        List<sd> listB0;
        m5 o5Var = null;
        h5 j5Var = null;
        switch (i10) {
            case 1:
                n0 n0Var = (n0) zzbw.zza(parcel, n0.CREATOR);
                me meVar = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                Y(n0Var, meVar);
                parcel2.writeNoException();
                return true;
            case 2:
                ze zeVar = (ze) zzbw.zza(parcel, ze.CREATOR);
                me meVar2 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                i0(zeVar, meVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                me meVar3 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                C0(meVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                n0 n0Var2 = (n0) zzbw.zza(parcel, n0.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzbw.zzb(parcel);
                c0(n0Var2, string, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                me meVar4 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                F(meVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                me meVar5 = (me) zzbw.zza(parcel, me.CREATOR);
                boolean zZzc = zzbw.zzc(parcel);
                zzbw.zzb(parcel);
                listB0 = b0(meVar5, zZzc);
                parcel2.writeNoException();
                parcel2.writeTypedList(listB0);
                return true;
            case 9:
                n0 n0Var3 = (n0) zzbw.zza(parcel, n0.CREATOR);
                String string3 = parcel.readString();
                zzbw.zzb(parcel);
                byte[] bArrW = W(n0Var3, string3);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrW);
                return true;
            case 10:
                long j10 = parcel.readLong();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                zzbw.zzb(parcel);
                f0(j10, string4, string5, string6);
                parcel2.writeNoException();
                return true;
            case 11:
                me meVar6 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                String strL0 = l0(meVar6);
                parcel2.writeNoException();
                parcel2.writeString(strL0);
                return true;
            case d9.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                h hVar = (h) zzbw.zza(parcel, h.CREATOR);
                me meVar7 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                A(hVar, meVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                h hVar2 = (h) zzbw.zza(parcel, h.CREATOR);
                zzbw.zzb(parcel);
                j0(hVar2);
                parcel2.writeNoException();
                return true;
            case 14:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zZzc2 = zzbw.zzc(parcel);
                me meVar8 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                listB0 = U0(string7, string8, zZzc2, meVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listB0);
                return true;
            case 15:
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                boolean zZzc3 = zzbw.zzc(parcel);
                zzbw.zzb(parcel);
                listB0 = B(string9, string10, string11, zZzc3);
                parcel2.writeNoException();
                parcel2.writeTypedList(listB0);
                return true;
            case 16:
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                me meVar9 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                listB0 = R0(string12, string13, meVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listB0);
                return true;
            case d9.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                zzbw.zzb(parcel);
                listB0 = h0(string14, string15, string16);
                parcel2.writeNoException();
                parcel2.writeTypedList(listB0);
                return true;
            case d9.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                me meVar10 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                O0(meVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                me meVar11 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                w0(bundle, meVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                me meVar12 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                Y0(meVar12);
                parcel2.writeNoException();
                return true;
            case 21:
                me meVar13 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                q qVarX = X(meVar13);
                parcel2.writeNoException();
                zzbw.zzb(parcel2, qVarX);
                return true;
            case 24:
                me meVar14 = (me) zzbw.zza(parcel, me.CREATOR);
                Bundle bundle2 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                zzbw.zzb(parcel);
                listB0 = T(meVar14, bundle2);
                parcel2.writeNoException();
                parcel2.writeTypedList(listB0);
                return true;
            case 25:
                me meVar15 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                P(meVar15);
                parcel2.writeNoException();
                return true;
            case 26:
                me meVar16 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                m(meVar16);
                parcel2.writeNoException();
                return true;
            case 27:
                me meVar17 = (me) zzbw.zza(parcel, me.CREATOR);
                zzbw.zzb(parcel);
                t0(meVar17);
                parcel2.writeNoException();
                return true;
            case 29:
                me meVar18 = (me) zzbw.zza(parcel, me.CREATOR);
                be beVar = (be) zzbw.zza(parcel, be.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    o5Var = iInterfaceQueryLocalInterface instanceof m5 ? (m5) iInterfaceQueryLocalInterface : new o5(strongBinder);
                }
                zzbw.zzb(parcel);
                S0(meVar18, beVar, o5Var);
                parcel2.writeNoException();
                return true;
            case 30:
                me meVar19 = (me) zzbw.zza(parcel, me.CREATOR);
                f fVar = (f) zzbw.zza(parcel, f.CREATOR);
                zzbw.zzb(parcel);
                m0(meVar19, fVar);
                parcel2.writeNoException();
                return true;
            case 31:
                me meVar20 = (me) zzbw.zza(parcel, me.CREATOR);
                Bundle bundle3 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    j5Var = iInterfaceQueryLocalInterface2 instanceof h5 ? (h5) iInterfaceQueryLocalInterface2 : new j5(strongBinder2);
                }
                zzbw.zzb(parcel);
                G0(meVar20, bundle3, j5Var);
                parcel2.writeNoException();
                return true;
        }
    }
}
