package h4;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.r;
import j4.l;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: h4.a$a, reason: collision with other inner class name */
    public static class C0159a<I, O> extends d4.a {
        public static final d CREATOR = new d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f9604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f9605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f9606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f9607e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f9608f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f9609l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Class f9610m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f9611n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public h f9612o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final b f9613p;

        public C0159a(int i10, int i11, boolean z10, int i12, boolean z11, String str, int i13, String str2, g4.b bVar) {
            this.f9603a = i10;
            this.f9604b = i11;
            this.f9605c = z10;
            this.f9606d = i12;
            this.f9607e = z11;
            this.f9608f = str;
            this.f9609l = i13;
            if (str2 == null) {
                this.f9610m = null;
                this.f9611n = null;
            } else {
                this.f9610m = c.class;
                this.f9611n = str2;
            }
            if (bVar == null) {
                this.f9613p = null;
            } else {
                this.f9613p = bVar.T();
            }
        }

        public C0159a(int i10, boolean z10, int i11, boolean z11, String str, int i12, Class cls, b bVar) {
            this.f9603a = 1;
            this.f9604b = i10;
            this.f9605c = z10;
            this.f9606d = i11;
            this.f9607e = z11;
            this.f9608f = str;
            this.f9609l = i12;
            this.f9610m = cls;
            this.f9611n = cls == null ? null : cls.getCanonicalName();
            this.f9613p = bVar;
        }

        public static C0159a<byte[], byte[]> S(String str, int i10) {
            return new C0159a<>(8, false, 8, false, str, i10, null, null);
        }

        public static <T extends a> C0159a<T, T> T(String str, int i10, Class<T> cls) {
            return new C0159a<>(11, false, 11, false, str, i10, cls, null);
        }

        public static <T extends a> C0159a<ArrayList<T>, ArrayList<T>> U(String str, int i10, Class<T> cls) {
            return new C0159a<>(11, true, 11, true, str, i10, cls, null);
        }

        public static C0159a<Integer, Integer> V(String str, int i10) {
            return new C0159a<>(0, false, 0, false, str, i10, null, null);
        }

        public static C0159a<String, String> W(String str, int i10) {
            return new C0159a<>(7, false, 7, false, str, i10, null, null);
        }

        public static C0159a<ArrayList<String>, ArrayList<String>> X(String str, int i10) {
            return new C0159a<>(7, true, 7, true, str, i10, null, null);
        }

        public int Y() {
            return this.f9609l;
        }

        public final g4.b Z() {
            b bVar = this.f9613p;
            if (bVar == null) {
                return null;
            }
            return g4.b.S(bVar);
        }

        public final Object b0(Object obj) {
            r.l(this.f9613p);
            return r.l(this.f9613p.t(obj));
        }

        public final Object c0(Object obj) {
            r.l(this.f9613p);
            return this.f9613p.q(obj);
        }

        public final String d0() {
            String str = this.f9611n;
            if (str == null) {
                return null;
            }
            return str;
        }

        public final Map e0() {
            r.l(this.f9611n);
            r.l(this.f9612o);
            return (Map) r.l(this.f9612o.T(this.f9611n));
        }

        public final void f0(h hVar) {
            this.f9612o = hVar;
        }

        public final boolean g0() {
            return this.f9613p != null;
        }

        public final String toString() {
            p.a aVarA = p.d(this).a("versionCode", Integer.valueOf(this.f9603a)).a("typeIn", Integer.valueOf(this.f9604b)).a("typeInArray", Boolean.valueOf(this.f9605c)).a("typeOut", Integer.valueOf(this.f9606d)).a("typeOutArray", Boolean.valueOf(this.f9607e)).a("outputFieldName", this.f9608f).a("safeParcelFieldId", Integer.valueOf(this.f9609l)).a("concreteTypeName", d0());
            Class cls = this.f9610m;
            if (cls != null) {
                aVarA.a("concreteType.class", cls.getCanonicalName());
            }
            b bVar = this.f9613p;
            if (bVar != null) {
                aVarA.a("converterName", bVar.getClass().getCanonicalName());
            }
            return aVarA.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            int i11 = this.f9603a;
            int iA = d4.c.a(parcel);
            d4.c.t(parcel, 1, i11);
            d4.c.t(parcel, 2, this.f9604b);
            d4.c.g(parcel, 3, this.f9605c);
            d4.c.t(parcel, 4, this.f9606d);
            d4.c.g(parcel, 5, this.f9607e);
            d4.c.E(parcel, 6, this.f9608f, false);
            d4.c.t(parcel, 7, Y());
            d4.c.E(parcel, 8, d0(), false);
            d4.c.C(parcel, 9, Z(), i10, false);
            d4.c.b(parcel, iA);
        }
    }

    public interface b<I, O> {
        Object q(Object obj);

        Object t(Object obj);
    }

    public static final Object zaD(C0159a c0159a, Object obj) {
        return c0159a.f9613p != null ? c0159a.c0(obj) : obj;
    }

    private final void zaE(C0159a c0159a, Object obj) {
        int i10 = c0159a.f9606d;
        Object objB0 = c0159a.b0(obj);
        String str = c0159a.f9608f;
        switch (i10) {
            case 0:
                if (objB0 != null) {
                    setIntegerInternal(c0159a, str, ((Integer) objB0).intValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 1:
                zaf(c0159a, str, (BigInteger) objB0);
                return;
            case 2:
                if (objB0 != null) {
                    setLongInternal(c0159a, str, ((Long) objB0).longValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 3:
            default:
                throw new IllegalStateException("Unsupported type for conversion: " + i10);
            case 4:
                if (objB0 != null) {
                    zan(c0159a, str, ((Double) objB0).doubleValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 5:
                zab(c0159a, str, (BigDecimal) objB0);
                return;
            case 6:
                if (objB0 != null) {
                    setBooleanInternal(c0159a, str, ((Boolean) objB0).booleanValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 7:
                setStringInternal(c0159a, str, (String) objB0);
                return;
            case 8:
            case 9:
                if (objB0 != null) {
                    setDecodedBytesInternal(c0159a, str, (byte[]) objB0);
                    return;
                } else {
                    zaG(str);
                    return;
                }
        }
    }

    private static final void zaF(StringBuilder sb2, C0159a c0159a, Object obj) {
        String string;
        int i10 = c0159a.f9604b;
        if (i10 == 11) {
            Class cls = c0159a.f9610m;
            r.l(cls);
            string = ((a) cls.cast(obj)).toString();
        } else if (i10 != 7) {
            sb2.append(obj);
            return;
        } else {
            string = "\"";
            sb2.append("\"");
            sb2.append(j4.k.a((String) obj));
        }
        sb2.append(string);
    }

    private static final void zaG(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            Log.e("FastJsonResponse", "Output field (" + str + ") has a null value, but expected a primitive");
        }
    }

    public <T extends a> void addConcreteTypeArrayInternal(C0159a c0159a, String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends a> void addConcreteTypeInternal(C0159a c0159a, String str, T t10) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    public abstract Map<String, C0159a<?, ?>> getFieldMappings();

    public Object getFieldValue(C0159a c0159a) {
        String str = c0159a.f9608f;
        if (c0159a.f9610m == null) {
            return getValueObject(str);
        }
        r.q(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", c0159a.f9608f);
        try {
            return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    public abstract Object getValueObject(String str);

    public boolean isFieldSet(C0159a c0159a) {
        if (c0159a.f9606d != 11) {
            return isPrimitiveFieldSet(c0159a.f9608f);
        }
        if (c0159a.f9607e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public abstract boolean isPrimitiveFieldSet(String str);

    public void setBooleanInternal(C0159a<?, ?> c0159a, String str, boolean z10) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    public void setDecodedBytesInternal(C0159a<?, ?> c0159a, String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    public void setIntegerInternal(C0159a<?, ?> c0159a, String str, int i10) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    public void setLongInternal(C0159a<?, ?> c0159a, String str, long j10) {
        throw new UnsupportedOperationException("Long not supported");
    }

    public void setStringInternal(C0159a<?, ?> c0159a, String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    public void setStringMapInternal(C0159a<?, ?> c0159a, String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    public void setStringsInternal(C0159a<?, ?> c0159a, String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    public String toString() {
        String str;
        String strC;
        Map<String, C0159a<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb2 = new StringBuilder(100);
        for (String str2 : fieldMappings.keySet()) {
            C0159a<?, ?> c0159a = fieldMappings.get(str2);
            if (isFieldSet(c0159a)) {
                Object objZaD = zaD(c0159a, getFieldValue(c0159a));
                if (sb2.length() == 0) {
                    sb2.append("{");
                } else {
                    sb2.append(",");
                }
                sb2.append("\"");
                sb2.append(str2);
                sb2.append("\":");
                if (objZaD != null) {
                    switch (c0159a.f9606d) {
                        case 8:
                            sb2.append("\"");
                            strC = j4.c.c((byte[]) objZaD);
                            sb2.append(strC);
                            sb2.append("\"");
                            break;
                        case 9:
                            sb2.append("\"");
                            strC = j4.c.d((byte[]) objZaD);
                            sb2.append(strC);
                            sb2.append("\"");
                            break;
                        case 10:
                            l.a(sb2, (HashMap) objZaD);
                            break;
                        default:
                            if (c0159a.f9605c) {
                                ArrayList arrayList = (ArrayList) objZaD;
                                sb2.append("[");
                                int size = arrayList.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    if (i10 > 0) {
                                        sb2.append(",");
                                    }
                                    Object obj = arrayList.get(i10);
                                    if (obj != null) {
                                        zaF(sb2, c0159a, obj);
                                    }
                                }
                                str = "]";
                            } else {
                                zaF(sb2, c0159a, objZaD);
                            }
                            break;
                    }
                } else {
                    str = "null";
                }
                sb2.append(str);
            }
        }
        sb2.append(sb2.length() > 0 ? "}" : "{}");
        return sb2.toString();
    }

    public final void zaA(C0159a c0159a, String str) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, str);
        } else {
            setStringInternal(c0159a, c0159a.f9608f, str);
        }
    }

    public final void zaB(C0159a c0159a, Map map) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, map);
        } else {
            setStringMapInternal(c0159a, c0159a.f9608f, map);
        }
    }

    public final void zaC(C0159a c0159a, ArrayList arrayList) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, arrayList);
        } else {
            setStringsInternal(c0159a, c0159a.f9608f, arrayList);
        }
    }

    public final void zaa(C0159a c0159a, BigDecimal bigDecimal) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, bigDecimal);
        } else {
            zab(c0159a, c0159a.f9608f, bigDecimal);
        }
    }

    public void zab(C0159a c0159a, String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final void zac(C0159a c0159a, ArrayList arrayList) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, arrayList);
        } else {
            zad(c0159a, c0159a.f9608f, arrayList);
        }
    }

    public void zad(C0159a c0159a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final void zae(C0159a c0159a, BigInteger bigInteger) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, bigInteger);
        } else {
            zaf(c0159a, c0159a.f9608f, bigInteger);
        }
    }

    public void zaf(C0159a c0159a, String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final void zag(C0159a c0159a, ArrayList arrayList) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, arrayList);
        } else {
            zah(c0159a, c0159a.f9608f, arrayList);
        }
    }

    public void zah(C0159a c0159a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final void zai(C0159a c0159a, boolean z10) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, Boolean.valueOf(z10));
        } else {
            setBooleanInternal(c0159a, c0159a.f9608f, z10);
        }
    }

    public final void zaj(C0159a c0159a, ArrayList arrayList) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, arrayList);
        } else {
            zak(c0159a, c0159a.f9608f, arrayList);
        }
    }

    public void zak(C0159a c0159a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final void zal(C0159a c0159a, byte[] bArr) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, bArr);
        } else {
            setDecodedBytesInternal(c0159a, c0159a.f9608f, bArr);
        }
    }

    public final void zam(C0159a c0159a, double d10) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, Double.valueOf(d10));
        } else {
            zan(c0159a, c0159a.f9608f, d10);
        }
    }

    public void zan(C0159a c0159a, String str, double d10) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final void zao(C0159a c0159a, ArrayList arrayList) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, arrayList);
        } else {
            zap(c0159a, c0159a.f9608f, arrayList);
        }
    }

    public void zap(C0159a c0159a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final void zaq(C0159a c0159a, float f10) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, Float.valueOf(f10));
        } else {
            zar(c0159a, c0159a.f9608f, f10);
        }
    }

    public void zar(C0159a c0159a, String str, float f10) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final void zas(C0159a c0159a, ArrayList arrayList) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, arrayList);
        } else {
            zat(c0159a, c0159a.f9608f, arrayList);
        }
    }

    public void zat(C0159a c0159a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final void zau(C0159a c0159a, int i10) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, Integer.valueOf(i10));
        } else {
            setIntegerInternal(c0159a, c0159a.f9608f, i10);
        }
    }

    public final void zav(C0159a c0159a, ArrayList arrayList) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, arrayList);
        } else {
            zaw(c0159a, c0159a.f9608f, arrayList);
        }
    }

    public void zaw(C0159a c0159a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final void zax(C0159a c0159a, long j10) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, Long.valueOf(j10));
        } else {
            setLongInternal(c0159a, c0159a.f9608f, j10);
        }
    }

    public final void zay(C0159a c0159a, ArrayList arrayList) {
        if (c0159a.f9613p != null) {
            zaE(c0159a, arrayList);
        } else {
            zaz(c0159a, c0159a.f9608f, arrayList);
        }
    }

    public void zaz(C0159a c0159a, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }
}
