package h4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.r;
import j4.l;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {
    public static final Parcelable.Creator<c> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Parcel f9615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9616c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f9617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f9618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9619f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f9620l;

    public c(int i10, Parcel parcel, h hVar) {
        this.f9614a = i10;
        this.f9615b = (Parcel) r.l(parcel);
        this.f9617d = hVar;
        this.f9618e = hVar == null ? null : hVar.S();
        this.f9619f = 2;
    }

    public static final void d(StringBuilder sb2, int i10, Object obj) {
        switch (i10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb2.append(obj);
                return;
            case 7:
                sb2.append("\"");
                sb2.append(j4.k.a(r.l(obj).toString()));
                sb2.append("\"");
                return;
            case 8:
                sb2.append("\"");
                sb2.append(j4.c.c((byte[]) obj));
                sb2.append("\"");
                return;
            case 9:
                sb2.append("\"");
                sb2.append(j4.c.d((byte[]) obj));
                sb2.append("\"");
                return;
            case 10:
                l.a(sb2, (HashMap) r.l(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i10);
        }
    }

    public static final void e(StringBuilder sb2, a.C0159a c0159a, Object obj) {
        if (!c0159a.f9605c) {
            d(sb2, c0159a.f9604b, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb2.append("[");
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            d(sb2, c0159a.f9604b, arrayList.get(i10));
        }
        sb2.append("]");
    }

    public final Parcel a() {
        int i10 = this.f9619f;
        if (i10 != 0) {
            if (i10 == 1) {
                d4.c.b(this.f9615b, this.f9620l);
            }
            return this.f9615b;
        }
        int iA = d4.c.a(this.f9615b);
        this.f9620l = iA;
        d4.c.b(this.f9615b, iA);
        this.f9619f = 2;
        return this.f9615b;
    }

    @Override // h4.a
    public final <T extends a> void addConcreteTypeArrayInternal(a.C0159a c0159a, String str, ArrayList<T> arrayList) {
        b(c0159a);
        ArrayList arrayList2 = new ArrayList();
        ((ArrayList) r.l(arrayList)).size();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList2.add(((c) arrayList.get(i10)).a());
        }
        d4.c.B(this.f9615b, c0159a.Y(), arrayList2, true);
    }

    @Override // h4.a
    public final <T extends a> void addConcreteTypeInternal(a.C0159a c0159a, String str, T t10) {
        b(c0159a);
        d4.c.A(this.f9615b, c0159a.Y(), ((c) t10).a(), true);
    }

    public final void b(a.C0159a c0159a) {
        if (c0159a.f9609l == -1) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
        Parcel parcel = this.f9615b;
        if (parcel == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        int i10 = this.f9619f;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
            }
        } else {
            this.f9620l = d4.c.a(parcel);
            this.f9619f = 1;
        }
    }

    public final void c(StringBuilder sb2, Map map, Parcel parcel) {
        Object objC;
        String strA;
        String str;
        Object objValueOf;
        Object objZaD;
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((a.C0159a) entry.getValue()).Y(), entry);
        }
        sb2.append('{');
        int iM = d4.b.M(parcel);
        boolean z10 = false;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(d4.b.w(iD));
            if (entry2 != null) {
                if (z10) {
                    sb2.append(",");
                }
                String str2 = (String) entry2.getKey();
                a.C0159a c0159a = (a.C0159a) entry2.getValue();
                sb2.append("\"");
                sb2.append(str2);
                sb2.append("\":");
                if (c0159a.g0()) {
                    int i10 = c0159a.f9606d;
                    switch (i10) {
                        case 0:
                            objValueOf = Integer.valueOf(d4.b.F(parcel, iD));
                            objZaD = a.zaD(c0159a, objValueOf);
                            e(sb2, c0159a, objZaD);
                            break;
                        case 1:
                            objValueOf = d4.b.c(parcel, iD);
                            objZaD = a.zaD(c0159a, objValueOf);
                            e(sb2, c0159a, objZaD);
                            break;
                        case 2:
                            objValueOf = Long.valueOf(d4.b.H(parcel, iD));
                            objZaD = a.zaD(c0159a, objValueOf);
                            e(sb2, c0159a, objZaD);
                            break;
                        case 3:
                            objValueOf = Float.valueOf(d4.b.B(parcel, iD));
                            objZaD = a.zaD(c0159a, objValueOf);
                            e(sb2, c0159a, objZaD);
                            break;
                        case 4:
                            objValueOf = Double.valueOf(d4.b.z(parcel, iD));
                            objZaD = a.zaD(c0159a, objValueOf);
                            e(sb2, c0159a, objZaD);
                            break;
                        case 5:
                            objValueOf = d4.b.a(parcel, iD);
                            objZaD = a.zaD(c0159a, objValueOf);
                            e(sb2, c0159a, objZaD);
                            break;
                        case 6:
                            objValueOf = Boolean.valueOf(d4.b.x(parcel, iD));
                            objZaD = a.zaD(c0159a, objValueOf);
                            e(sb2, c0159a, objZaD);
                            break;
                        case 7:
                            objValueOf = d4.b.q(parcel, iD);
                            objZaD = a.zaD(c0159a, objValueOf);
                            e(sb2, c0159a, objZaD);
                            break;
                        case 8:
                        case 9:
                            objZaD = a.zaD(c0159a, d4.b.g(parcel, iD));
                            e(sb2, c0159a, objZaD);
                            break;
                        case 10:
                            Bundle bundleF = d4.b.f(parcel, iD);
                            HashMap map2 = new HashMap();
                            for (String str3 : bundleF.keySet()) {
                                map2.put(str3, (String) r.l(bundleF.getString(str3)));
                            }
                            objZaD = a.zaD(c0159a, map2);
                            e(sb2, c0159a, objZaD);
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + i10);
                    }
                } else {
                    if (c0159a.f9607e) {
                        sb2.append("[");
                        switch (c0159a.f9606d) {
                            case 0:
                                j4.b.e(sb2, d4.b.k(parcel, iD));
                                break;
                            case 1:
                                j4.b.g(sb2, d4.b.d(parcel, iD));
                                break;
                            case 2:
                                j4.b.f(sb2, d4.b.m(parcel, iD));
                                break;
                            case 3:
                                j4.b.d(sb2, d4.b.j(parcel, iD));
                                break;
                            case 4:
                                j4.b.c(sb2, d4.b.i(parcel, iD));
                                break;
                            case 5:
                                j4.b.g(sb2, d4.b.b(parcel, iD));
                                break;
                            case 6:
                                j4.b.h(sb2, d4.b.e(parcel, iD));
                                break;
                            case 7:
                                j4.b.i(sb2, d4.b.r(parcel, iD));
                                break;
                            case 8:
                            case 9:
                            case 10:
                                throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            case 11:
                                Parcel[] parcelArrO = d4.b.o(parcel, iD);
                                int length = parcelArrO.length;
                                for (int i11 = 0; i11 < length; i11++) {
                                    if (i11 > 0) {
                                        sb2.append(",");
                                    }
                                    parcelArrO[i11].setDataPosition(0);
                                    c(sb2, c0159a.e0(), parcelArrO[i11]);
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out.");
                        }
                        str = "]";
                    } else {
                        switch (c0159a.f9606d) {
                            case 0:
                                sb2.append(d4.b.F(parcel, iD));
                                break;
                            case 1:
                                objC = d4.b.c(parcel, iD);
                                sb2.append(objC);
                                break;
                            case 2:
                                sb2.append(d4.b.H(parcel, iD));
                                break;
                            case 3:
                                sb2.append(d4.b.B(parcel, iD));
                                break;
                            case 4:
                                sb2.append(d4.b.z(parcel, iD));
                                break;
                            case 5:
                                objC = d4.b.a(parcel, iD);
                                sb2.append(objC);
                                break;
                            case 6:
                                sb2.append(d4.b.x(parcel, iD));
                                break;
                            case 7:
                                String strQ = d4.b.q(parcel, iD);
                                sb2.append("\"");
                                strA = j4.k.a(strQ);
                                sb2.append(strA);
                                sb2.append("\"");
                                break;
                            case 8:
                                byte[] bArrG = d4.b.g(parcel, iD);
                                sb2.append("\"");
                                strA = j4.c.c(bArrG);
                                sb2.append(strA);
                                sb2.append("\"");
                                break;
                            case 9:
                                byte[] bArrG2 = d4.b.g(parcel, iD);
                                sb2.append("\"");
                                strA = j4.c.d(bArrG2);
                                sb2.append(strA);
                                sb2.append("\"");
                                break;
                            case 10:
                                Bundle bundleF2 = d4.b.f(parcel, iD);
                                Set<String> setKeySet = bundleF2.keySet();
                                sb2.append("{");
                                boolean z11 = true;
                                for (String str4 : setKeySet) {
                                    if (!z11) {
                                        sb2.append(",");
                                    }
                                    sb2.append("\"");
                                    sb2.append(str4);
                                    sb2.append("\":\"");
                                    sb2.append(j4.k.a(bundleF2.getString(str4)));
                                    sb2.append("\"");
                                    z11 = false;
                                }
                                str = "}";
                                break;
                            case 11:
                                Parcel parcelN = d4.b.n(parcel, iD);
                                parcelN.setDataPosition(0);
                                c(sb2, c0159a.e0(), parcelN);
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out");
                        }
                    }
                    sb2.append(str);
                }
                z10 = true;
            }
        }
        if (parcel.dataPosition() == iM) {
            sb2.append('}');
            return;
        }
        throw new d4.b.a("Overread allowed size end=" + iM, parcel);
    }

    @Override // h4.a
    public final Map<String, a.C0159a<?, ?>> getFieldMappings() {
        h hVar = this.f9617d;
        if (hVar == null) {
            return null;
        }
        return hVar.T((String) r.l(this.f9618e));
    }

    @Override // h4.b, h4.a
    public final Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // h4.b, h4.a
    public final boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // h4.a
    public final void setBooleanInternal(a.C0159a<?, ?> c0159a, String str, boolean z10) {
        b(c0159a);
        d4.c.g(this.f9615b, c0159a.Y(), z10);
    }

    @Override // h4.a
    public final void setDecodedBytesInternal(a.C0159a<?, ?> c0159a, String str, byte[] bArr) {
        b(c0159a);
        d4.c.k(this.f9615b, c0159a.Y(), bArr, true);
    }

    @Override // h4.a
    public final void setIntegerInternal(a.C0159a<?, ?> c0159a, String str, int i10) {
        b(c0159a);
        d4.c.t(this.f9615b, c0159a.Y(), i10);
    }

    @Override // h4.a
    public final void setLongInternal(a.C0159a<?, ?> c0159a, String str, long j10) {
        b(c0159a);
        d4.c.x(this.f9615b, c0159a.Y(), j10);
    }

    @Override // h4.a
    public final void setStringInternal(a.C0159a<?, ?> c0159a, String str, String str2) {
        b(c0159a);
        d4.c.E(this.f9615b, c0159a.Y(), str2, true);
    }

    @Override // h4.a
    public final void setStringMapInternal(a.C0159a<?, ?> c0159a, String str, Map<String, String> map) {
        b(c0159a);
        Bundle bundle = new Bundle();
        for (String str2 : ((Map) r.l(map)).keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        d4.c.j(this.f9615b, c0159a.Y(), bundle, true);
    }

    @Override // h4.a
    public final void setStringsInternal(a.C0159a<?, ?> c0159a, String str, ArrayList<String> arrayList) {
        b(c0159a);
        int size = ((ArrayList) r.l(arrayList)).size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = arrayList.get(i10);
        }
        d4.c.F(this.f9615b, c0159a.Y(), strArr, true);
    }

    @Override // h4.a
    public final String toString() {
        r.m(this.f9617d, "Cannot convert to JSON on client side.");
        Parcel parcelA = a();
        parcelA.setDataPosition(0);
        StringBuilder sb2 = new StringBuilder(100);
        c(sb2, (Map) r.l(this.f9617d.T((String) r.l(this.f9618e))), parcelA);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f9614a;
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, i11);
        d4.c.A(parcel, 2, a(), false);
        d4.c.C(parcel, 3, this.f9616c != 0 ? this.f9617d : null, i10, false);
        d4.c.b(parcel, iA);
    }

    @Override // h4.a
    public final void zab(a.C0159a c0159a, String str, BigDecimal bigDecimal) {
        b(c0159a);
        d4.c.c(this.f9615b, c0159a.Y(), bigDecimal, true);
    }

    @Override // h4.a
    public final void zad(a.C0159a c0159a, String str, ArrayList arrayList) {
        b(c0159a);
        int size = ((ArrayList) r.l(arrayList)).size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i10 = 0; i10 < size; i10++) {
            bigDecimalArr[i10] = (BigDecimal) arrayList.get(i10);
        }
        d4.c.d(this.f9615b, c0159a.Y(), bigDecimalArr, true);
    }

    @Override // h4.a
    public final void zaf(a.C0159a c0159a, String str, BigInteger bigInteger) {
        b(c0159a);
        d4.c.e(this.f9615b, c0159a.Y(), bigInteger, true);
    }

    @Override // h4.a
    public final void zah(a.C0159a c0159a, String str, ArrayList arrayList) {
        b(c0159a);
        int size = ((ArrayList) r.l(arrayList)).size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i10 = 0; i10 < size; i10++) {
            bigIntegerArr[i10] = (BigInteger) arrayList.get(i10);
        }
        d4.c.f(this.f9615b, c0159a.Y(), bigIntegerArr, true);
    }

    @Override // h4.a
    public final void zak(a.C0159a c0159a, String str, ArrayList arrayList) {
        b(c0159a);
        int size = ((ArrayList) r.l(arrayList)).size();
        boolean[] zArr = new boolean[size];
        for (int i10 = 0; i10 < size; i10++) {
            zArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue();
        }
        d4.c.h(this.f9615b, c0159a.Y(), zArr, true);
    }

    @Override // h4.a
    public final void zan(a.C0159a c0159a, String str, double d10) {
        b(c0159a);
        d4.c.m(this.f9615b, c0159a.Y(), d10);
    }

    @Override // h4.a
    public final void zap(a.C0159a c0159a, String str, ArrayList arrayList) {
        b(c0159a);
        int size = ((ArrayList) r.l(arrayList)).size();
        double[] dArr = new double[size];
        for (int i10 = 0; i10 < size; i10++) {
            dArr[i10] = ((Double) arrayList.get(i10)).doubleValue();
        }
        d4.c.n(this.f9615b, c0159a.Y(), dArr, true);
    }

    @Override // h4.a
    public final void zar(a.C0159a c0159a, String str, float f10) {
        b(c0159a);
        d4.c.p(this.f9615b, c0159a.Y(), f10);
    }

    @Override // h4.a
    public final void zat(a.C0159a c0159a, String str, ArrayList arrayList) {
        b(c0159a);
        int size = ((ArrayList) r.l(arrayList)).size();
        float[] fArr = new float[size];
        for (int i10 = 0; i10 < size; i10++) {
            fArr[i10] = ((Float) arrayList.get(i10)).floatValue();
        }
        d4.c.q(this.f9615b, c0159a.Y(), fArr, true);
    }

    @Override // h4.a
    public final void zaw(a.C0159a c0159a, String str, ArrayList arrayList) {
        b(c0159a);
        int size = ((ArrayList) r.l(arrayList)).size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = ((Integer) arrayList.get(i10)).intValue();
        }
        d4.c.u(this.f9615b, c0159a.Y(), iArr, true);
    }

    @Override // h4.a
    public final void zaz(a.C0159a c0159a, String str, ArrayList arrayList) {
        b(c0159a);
        int size = ((ArrayList) r.l(arrayList)).size();
        long[] jArr = new long[size];
        for (int i10 = 0; i10 < size; i10++) {
            jArr[i10] = ((Long) arrayList.get(i10)).longValue();
        }
        d4.c.y(this.f9615b, c0159a.Y(), jArr, true);
    }
}
