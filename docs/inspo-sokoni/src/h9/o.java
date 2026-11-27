package h9;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final e9.x<BigInteger> A;
    public static final e9.x<g9.g> B;
    public static final e9.y C;
    public static final e9.x<StringBuilder> D;
    public static final e9.y E;
    public static final e9.x<StringBuffer> F;
    public static final e9.y G;
    public static final e9.x<URL> H;
    public static final e9.y I;
    public static final e9.x<URI> J;
    public static final e9.y K;
    public static final e9.x<InetAddress> L;
    public static final e9.y M;
    public static final e9.x<UUID> N;
    public static final e9.y O;
    public static final e9.x<Currency> P;
    public static final e9.y Q;
    public static final e9.x<Calendar> R;
    public static final e9.y S;
    public static final e9.x<Locale> T;
    public static final e9.y U;
    public static final e9.x<e9.k> V;
    public static final e9.y W;
    public static final e9.y X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e9.x<Class> f9882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e9.y f9883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e9.x<BitSet> f9884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e9.y f9885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e9.x<Boolean> f9886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e9.x<Boolean> f9887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e9.y f9888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e9.x<Number> f9889h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e9.y f9890i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e9.x<Number> f9891j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e9.y f9892k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e9.x<Number> f9893l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e9.y f9894m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e9.x<AtomicInteger> f9895n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final e9.y f9896o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final e9.x<AtomicBoolean> f9897p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final e9.y f9898q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e9.x<AtomicIntegerArray> f9899r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final e9.y f9900s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final e9.x<Number> f9901t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final e9.x<Number> f9902u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final e9.x<Number> f9903v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final e9.x<Character> f9904w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final e9.y f9905x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final e9.x<String> f9906y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final e9.x<BigDecimal> f9907z;

    public class a extends e9.x<AtomicIntegerArray> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray c(m9.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.d();
            while (aVar.I()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.d0()));
                } catch (NumberFormatException e10) {
                    throw new e9.s(e10);
                }
            }
            aVar.z();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            cVar.k();
            int length = atomicIntegerArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                cVar.k0(atomicIntegerArray.get(i10));
            }
            cVar.z();
        }
    }

    public class a0 implements e9.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f9908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e9.x f9909b;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        public class a<T1> extends e9.x<T1> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Class f9910a;

            public a(Class cls) {
                this.f9910a = cls;
            }

            @Override // e9.x
            public T1 c(m9.a aVar) {
                T1 t10 = (T1) a0.this.f9909b.c(aVar);
                if (t10 == null || this.f9910a.isInstance(t10)) {
                    return t10;
                }
                throw new e9.s("Expected a " + this.f9910a.getName() + " but was " + t10.getClass().getName() + "; at path " + aVar.G());
            }

            @Override // e9.x
            public void e(m9.c cVar, T1 t10) {
                a0.this.f9909b.e(cVar, t10);
            }
        }

        public a0(Class cls, e9.x xVar) {
            this.f9908a = cls;
            this.f9909b = xVar;
        }

        @Override // e9.y
        public <T2> e9.x<T2> create(e9.e eVar, l9.a<T2> aVar) {
            Class<? super T2> clsC = aVar.c();
            if (this.f9908a.isAssignableFrom(clsC)) {
                return new a(clsC);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f9908a.getName() + ",adapter=" + this.f9909b + "]";
        }
    }

    public class b extends e9.x<Number> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            try {
                return Long.valueOf(aVar.e0());
            } catch (NumberFormatException e10) {
                throw new e9.s(e10);
            }
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.L();
            } else {
                cVar.k0(number.longValue());
            }
        }
    }

    public static /* synthetic */ class b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9912a;

        static {
            int[] iArr = new int[m9.b.values().length];
            f9912a = iArr;
            try {
                iArr[m9.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9912a[m9.b.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9912a[m9.b.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9912a[m9.b.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9912a[m9.b.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9912a[m9.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class c extends e9.x<Number> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number c(m9.a aVar) throws IOException {
            if (aVar.l0() != m9.b.NULL) {
                return Float.valueOf((float) aVar.c0());
            }
            aVar.h0();
            return null;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.L();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            cVar.m0(number);
        }
    }

    public class c0 extends e9.x<Boolean> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean c(m9.a aVar) throws IOException {
            m9.b bVarL0 = aVar.l0();
            if (bVarL0 != m9.b.NULL) {
                return bVarL0 == m9.b.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.j0())) : Boolean.valueOf(aVar.Q());
            }
            aVar.h0();
            return null;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Boolean bool) throws IOException {
            cVar.l0(bool);
        }
    }

    public class d extends e9.x<Number> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number c(m9.a aVar) throws IOException {
            if (aVar.l0() != m9.b.NULL) {
                return Double.valueOf(aVar.c0());
            }
            aVar.h0();
            return null;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.L();
            } else {
                cVar.j0(number.doubleValue());
            }
        }
    }

    public class d0 extends e9.x<Boolean> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean c(m9.a aVar) throws IOException {
            if (aVar.l0() != m9.b.NULL) {
                return Boolean.valueOf(aVar.j0());
            }
            aVar.h0();
            return null;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Boolean bool) throws IOException {
            cVar.n0(bool == null ? "null" : bool.toString());
        }
    }

    public class e extends e9.x<Character> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Character c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            String strJ0 = aVar.j0();
            if (strJ0.length() == 1) {
                return Character.valueOf(strJ0.charAt(0));
            }
            throw new e9.s("Expecting character, got: " + strJ0 + "; at " + aVar.G());
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Character ch) throws IOException {
            cVar.n0(ch == null ? null : String.valueOf(ch));
        }
    }

    public class e0 extends e9.x<Number> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            try {
                int iD0 = aVar.d0();
                if (iD0 <= 255 && iD0 >= -128) {
                    return Byte.valueOf((byte) iD0);
                }
                throw new e9.s("Lossy conversion from " + iD0 + " to byte; at path " + aVar.G());
            } catch (NumberFormatException e10) {
                throw new e9.s(e10);
            }
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.L();
            } else {
                cVar.k0(number.byteValue());
            }
        }
    }

    public class f extends e9.x<String> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public String c(m9.a aVar) throws IOException {
            m9.b bVarL0 = aVar.l0();
            if (bVarL0 != m9.b.NULL) {
                return bVarL0 == m9.b.BOOLEAN ? Boolean.toString(aVar.Q()) : aVar.j0();
            }
            aVar.h0();
            return null;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, String str) throws IOException {
            cVar.n0(str);
        }
    }

    public class f0 extends e9.x<Number> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            try {
                int iD0 = aVar.d0();
                if (iD0 <= 65535 && iD0 >= -32768) {
                    return Short.valueOf((short) iD0);
                }
                throw new e9.s("Lossy conversion from " + iD0 + " to short; at path " + aVar.G());
            } catch (NumberFormatException e10) {
                throw new e9.s(e10);
            }
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.L();
            } else {
                cVar.k0(number.shortValue());
            }
        }
    }

    public class g extends e9.x<BigDecimal> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public BigDecimal c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            String strJ0 = aVar.j0();
            try {
                return new BigDecimal(strJ0);
            } catch (NumberFormatException e10) {
                throw new e9.s("Failed parsing '" + strJ0 + "' as BigDecimal; at path " + aVar.G(), e10);
            }
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, BigDecimal bigDecimal) throws IOException {
            cVar.m0(bigDecimal);
        }
    }

    public class g0 extends e9.x<Number> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            try {
                return Integer.valueOf(aVar.d0());
            } catch (NumberFormatException e10) {
                throw new e9.s(e10);
            }
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.L();
            } else {
                cVar.k0(number.intValue());
            }
        }
    }

    public class h extends e9.x<BigInteger> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public BigInteger c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            String strJ0 = aVar.j0();
            try {
                return new BigInteger(strJ0);
            } catch (NumberFormatException e10) {
                throw new e9.s("Failed parsing '" + strJ0 + "' as BigInteger; at path " + aVar.G(), e10);
            }
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, BigInteger bigInteger) throws IOException {
            cVar.m0(bigInteger);
        }
    }

    public class h0 extends e9.x<AtomicInteger> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicInteger c(m9.a aVar) {
            try {
                return new AtomicInteger(aVar.d0());
            } catch (NumberFormatException e10) {
                throw new e9.s(e10);
            }
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, AtomicInteger atomicInteger) throws IOException {
            cVar.k0(atomicInteger.get());
        }
    }

    public class i extends e9.x<g9.g> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public g9.g c(m9.a aVar) throws IOException {
            if (aVar.l0() != m9.b.NULL) {
                return new g9.g(aVar.j0());
            }
            aVar.h0();
            return null;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, g9.g gVar) throws IOException {
            cVar.m0(gVar);
        }
    }

    public class i0 extends e9.x<AtomicBoolean> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean c(m9.a aVar) {
            return new AtomicBoolean(aVar.Q());
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, AtomicBoolean atomicBoolean) throws IOException {
            cVar.o0(atomicBoolean.get());
        }
    }

    public class j extends e9.x<StringBuilder> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public StringBuilder c(m9.a aVar) throws IOException {
            if (aVar.l0() != m9.b.NULL) {
                return new StringBuilder(aVar.j0());
            }
            aVar.h0();
            return null;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, StringBuilder sb2) throws IOException {
            cVar.n0(sb2 == null ? null : sb2.toString());
        }
    }

    public static final class j0<T extends Enum<T>> extends e9.x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, T> f9913a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, T> f9914b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<T, String> f9915c = new HashMap();

        public class a implements PrivilegedAction<Field[]> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Class f9916a;

            public a(Class cls) {
                this.f9916a = cls;
            }

            @Override // java.security.PrivilegedAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Field[] run() {
                Field[] declaredFields = this.f9916a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public j0(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r10 = (Enum) field.get(null);
                    String strName = r10.name();
                    String string = r10.toString();
                    f9.c cVar = (f9.c) field.getAnnotation(f9.c.class);
                    if (cVar != null) {
                        strName = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.f9913a.put(str, (T) r10);
                        }
                    }
                    this.f9913a.put(strName, (T) r10);
                    this.f9914b.put(string, (T) r10);
                    this.f9915c.put((T) r10, strName);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public T c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            String strJ0 = aVar.j0();
            T t10 = this.f9913a.get(strJ0);
            return t10 == null ? this.f9914b.get(strJ0) : t10;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, T t10) throws IOException {
            cVar.n0(t10 == null ? null : this.f9915c.get(t10));
        }
    }

    public class k extends e9.x<Class> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Class c(m9.a aVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    public class l extends e9.x<StringBuffer> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public StringBuffer c(m9.a aVar) throws IOException {
            if (aVar.l0() != m9.b.NULL) {
                return new StringBuffer(aVar.j0());
            }
            aVar.h0();
            return null;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, StringBuffer stringBuffer) throws IOException {
            cVar.n0(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    public class m extends e9.x<URL> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public URL c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            String strJ0 = aVar.j0();
            if ("null".equals(strJ0)) {
                return null;
            }
            return new URL(strJ0);
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, URL url) throws IOException {
            cVar.n0(url == null ? null : url.toExternalForm());
        }
    }

    public class n extends e9.x<URI> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public URI c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            try {
                String strJ0 = aVar.j0();
                if ("null".equals(strJ0)) {
                    return null;
                }
                return new URI(strJ0);
            } catch (URISyntaxException e10) {
                throw new e9.l(e10);
            }
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, URI uri) throws IOException {
            cVar.n0(uri == null ? null : uri.toASCIIString());
        }
    }

    /* JADX INFO: renamed from: h9.o$o, reason: collision with other inner class name */
    public class C0161o extends e9.x<InetAddress> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public InetAddress c(m9.a aVar) throws IOException {
            if (aVar.l0() != m9.b.NULL) {
                return InetAddress.getByName(aVar.j0());
            }
            aVar.h0();
            return null;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, InetAddress inetAddress) throws IOException {
            cVar.n0(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    public class p extends e9.x<UUID> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public UUID c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            String strJ0 = aVar.j0();
            try {
                return UUID.fromString(strJ0);
            } catch (IllegalArgumentException e10) {
                throw new e9.s("Failed parsing '" + strJ0 + "' as UUID; at path " + aVar.G(), e10);
            }
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, UUID uuid) throws IOException {
            cVar.n0(uuid == null ? null : uuid.toString());
        }
    }

    public class q extends e9.x<Currency> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Currency c(m9.a aVar) throws IOException {
            String strJ0 = aVar.j0();
            try {
                return Currency.getInstance(strJ0);
            } catch (IllegalArgumentException e10) {
                throw new e9.s("Failed parsing '" + strJ0 + "' as Currency; at path " + aVar.G(), e10);
            }
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Currency currency) throws IOException {
            cVar.n0(currency.getCurrencyCode());
        }
    }

    public class r extends e9.x<Calendar> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Calendar c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            aVar.e();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (aVar.l0() != m9.b.END_OBJECT) {
                String strF0 = aVar.f0();
                int iD0 = aVar.d0();
                if ("year".equals(strF0)) {
                    i10 = iD0;
                } else if ("month".equals(strF0)) {
                    i11 = iD0;
                } else if ("dayOfMonth".equals(strF0)) {
                    i12 = iD0;
                } else if ("hourOfDay".equals(strF0)) {
                    i13 = iD0;
                } else if ("minute".equals(strF0)) {
                    i14 = iD0;
                } else if ("second".equals(strF0)) {
                    i15 = iD0;
                }
            }
            aVar.B();
            return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                cVar.L();
                return;
            }
            cVar.t();
            cVar.I("year");
            cVar.k0(calendar.get(1));
            cVar.I("month");
            cVar.k0(calendar.get(2));
            cVar.I("dayOfMonth");
            cVar.k0(calendar.get(5));
            cVar.I("hourOfDay");
            cVar.k0(calendar.get(11));
            cVar.I("minute");
            cVar.k0(calendar.get(12));
            cVar.I("second");
            cVar.k0(calendar.get(13));
            cVar.B();
        }
    }

    public class s extends e9.x<Locale> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Locale c(m9.a aVar) throws IOException {
            if (aVar.l0() == m9.b.NULL) {
                aVar.h0();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.j0(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (strNextToken2 == null && strNextToken3 == null) {
                return new Locale(strNextToken);
            }
            return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, Locale locale) throws IOException {
            cVar.n0(locale == null ? null : locale.toString());
        }
    }

    public class t extends e9.x<e9.k> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public e9.k c(m9.a aVar) throws IOException {
            if (aVar instanceof h9.f) {
                return ((h9.f) aVar).y0();
            }
            m9.b bVarL0 = aVar.l0();
            e9.k kVarH = h(aVar, bVarL0);
            if (kVarH == null) {
                return g(aVar, bVarL0);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (aVar.I()) {
                    String strF0 = kVarH instanceof e9.n ? aVar.f0() : null;
                    m9.b bVarL1 = aVar.l0();
                    e9.k kVarH2 = h(aVar, bVarL1);
                    boolean z10 = kVarH2 != null;
                    if (kVarH2 == null) {
                        kVarH2 = g(aVar, bVarL1);
                    }
                    if (kVarH instanceof e9.h) {
                        ((e9.h) kVarH).r(kVarH2);
                    } else {
                        ((e9.n) kVarH).r(strF0, kVarH2);
                    }
                    if (z10) {
                        arrayDeque.addLast(kVarH);
                        kVarH = kVarH2;
                    }
                } else {
                    if (kVarH instanceof e9.h) {
                        aVar.z();
                    } else {
                        aVar.B();
                    }
                    if (arrayDeque.isEmpty()) {
                        return kVarH;
                    }
                    kVarH = (e9.k) arrayDeque.removeLast();
                }
            }
        }

        public final e9.k g(m9.a aVar, m9.b bVar) throws IOException {
            int i10 = b0.f9912a[bVar.ordinal()];
            if (i10 == 1) {
                return new e9.p(new g9.g(aVar.j0()));
            }
            if (i10 == 2) {
                return new e9.p(aVar.j0());
            }
            if (i10 == 3) {
                return new e9.p(Boolean.valueOf(aVar.Q()));
            }
            if (i10 == 6) {
                aVar.h0();
                return e9.m.f7445a;
            }
            throw new IllegalStateException("Unexpected token: " + bVar);
        }

        public final e9.k h(m9.a aVar, m9.b bVar) throws IOException {
            int i10 = b0.f9912a[bVar.ordinal()];
            if (i10 == 4) {
                aVar.d();
                return new e9.h();
            }
            if (i10 != 5) {
                return null;
            }
            aVar.e();
            return new e9.n();
        }

        @Override // e9.x
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, e9.k kVar) throws IOException {
            if (kVar == null || kVar.n()) {
                cVar.L();
                return;
            }
            if (kVar.q()) {
                e9.p pVarJ = kVar.j();
                if (pVarJ.y()) {
                    cVar.m0(pVarJ.v());
                    return;
                } else if (pVarJ.w()) {
                    cVar.o0(pVarJ.e());
                    return;
                } else {
                    cVar.n0(pVarJ.k());
                    return;
                }
            }
            if (kVar.l()) {
                cVar.k();
                Iterator<e9.k> it = kVar.h().iterator();
                while (it.hasNext()) {
                    e(cVar, it.next());
                }
                cVar.z();
                return;
            }
            if (!kVar.o()) {
                throw new IllegalArgumentException("Couldn't write " + kVar.getClass());
            }
            cVar.t();
            for (Map.Entry<String, e9.k> entry : kVar.i().s()) {
                cVar.I(entry.getKey());
                e(cVar, entry.getValue());
            }
            cVar.B();
        }
    }

    public class u implements e9.y {
        @Override // e9.y
        public <T> e9.x<T> create(e9.e eVar, l9.a<T> aVar) {
            Class<? super T> clsC = aVar.c();
            if (!Enum.class.isAssignableFrom(clsC) || clsC == Enum.class) {
                return null;
            }
            if (!clsC.isEnum()) {
                clsC = clsC.getSuperclass();
            }
            return new j0(clsC);
        }
    }

    public class v extends e9.x<BitSet> {
        @Override // e9.x
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public BitSet c(m9.a aVar) throws IOException {
            BitSet bitSet = new BitSet();
            aVar.d();
            m9.b bVarL0 = aVar.l0();
            int i10 = 0;
            while (bVarL0 != m9.b.END_ARRAY) {
                int i11 = b0.f9912a[bVarL0.ordinal()];
                boolean zQ = true;
                if (i11 == 1 || i11 == 2) {
                    int iD0 = aVar.d0();
                    if (iD0 == 0) {
                        zQ = false;
                    } else if (iD0 != 1) {
                        throw new e9.s("Invalid bitset value " + iD0 + ", expected 0 or 1; at path " + aVar.G());
                    }
                } else {
                    if (i11 != 3) {
                        throw new e9.s("Invalid bitset value type: " + bVarL0 + "; at path " + aVar.D());
                    }
                    zQ = aVar.Q();
                }
                if (zQ) {
                    bitSet.set(i10);
                }
                i10++;
                bVarL0 = aVar.l0();
            }
            aVar.z();
            return bitSet;
        }

        @Override // e9.x
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(m9.c cVar, BitSet bitSet) throws IOException {
            cVar.k();
            int length = bitSet.length();
            for (int i10 = 0; i10 < length; i10++) {
                cVar.k0(bitSet.get(i10) ? 1L : 0L);
            }
            cVar.z();
        }
    }

    public class w implements e9.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l9.a f9918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e9.x f9919b;

        public w(l9.a aVar, e9.x xVar) {
            this.f9918a = aVar;
            this.f9919b = xVar;
        }

        @Override // e9.y
        public <T> e9.x<T> create(e9.e eVar, l9.a<T> aVar) {
            if (aVar.equals(this.f9918a)) {
                return this.f9919b;
            }
            return null;
        }
    }

    public class x implements e9.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f9920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e9.x f9921b;

        public x(Class cls, e9.x xVar) {
            this.f9920a = cls;
            this.f9921b = xVar;
        }

        @Override // e9.y
        public <T> e9.x<T> create(e9.e eVar, l9.a<T> aVar) {
            if (aVar.c() == this.f9920a) {
                return this.f9921b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f9920a.getName() + ",adapter=" + this.f9921b + "]";
        }
    }

    public class y implements e9.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f9922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f9923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e9.x f9924c;

        public y(Class cls, Class cls2, e9.x xVar) {
            this.f9922a = cls;
            this.f9923b = cls2;
            this.f9924c = xVar;
        }

        @Override // e9.y
        public <T> e9.x<T> create(e9.e eVar, l9.a<T> aVar) {
            Class<? super T> clsC = aVar.c();
            if (clsC == this.f9922a || clsC == this.f9923b) {
                return this.f9924c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f9923b.getName() + "+" + this.f9922a.getName() + ",adapter=" + this.f9924c + "]";
        }
    }

    public class z implements e9.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f9925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f9926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e9.x f9927c;

        public z(Class cls, Class cls2, e9.x xVar) {
            this.f9925a = cls;
            this.f9926b = cls2;
            this.f9927c = xVar;
        }

        @Override // e9.y
        public <T> e9.x<T> create(e9.e eVar, l9.a<T> aVar) {
            Class<? super T> clsC = aVar.c();
            if (clsC == this.f9925a || clsC == this.f9926b) {
                return this.f9927c;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f9925a.getName() + "+" + this.f9926b.getName() + ",adapter=" + this.f9927c + "]";
        }
    }

    static {
        e9.x<Class> xVarB = new k().b();
        f9882a = xVarB;
        f9883b = a(Class.class, xVarB);
        e9.x<BitSet> xVarB2 = new v().b();
        f9884c = xVarB2;
        f9885d = a(BitSet.class, xVarB2);
        c0 c0Var = new c0();
        f9886e = c0Var;
        f9887f = new d0();
        f9888g = b(Boolean.TYPE, Boolean.class, c0Var);
        e0 e0Var = new e0();
        f9889h = e0Var;
        f9890i = b(Byte.TYPE, Byte.class, e0Var);
        f0 f0Var = new f0();
        f9891j = f0Var;
        f9892k = b(Short.TYPE, Short.class, f0Var);
        g0 g0Var = new g0();
        f9893l = g0Var;
        f9894m = b(Integer.TYPE, Integer.class, g0Var);
        e9.x<AtomicInteger> xVarB3 = new h0().b();
        f9895n = xVarB3;
        f9896o = a(AtomicInteger.class, xVarB3);
        e9.x<AtomicBoolean> xVarB4 = new i0().b();
        f9897p = xVarB4;
        f9898q = a(AtomicBoolean.class, xVarB4);
        e9.x<AtomicIntegerArray> xVarB5 = new a().b();
        f9899r = xVarB5;
        f9900s = a(AtomicIntegerArray.class, xVarB5);
        f9901t = new b();
        f9902u = new c();
        f9903v = new d();
        e eVar = new e();
        f9904w = eVar;
        f9905x = b(Character.TYPE, Character.class, eVar);
        f fVar = new f();
        f9906y = fVar;
        f9907z = new g();
        A = new h();
        B = new i();
        C = a(String.class, fVar);
        j jVar = new j();
        D = jVar;
        E = a(StringBuilder.class, jVar);
        l lVar = new l();
        F = lVar;
        G = a(StringBuffer.class, lVar);
        m mVar = new m();
        H = mVar;
        I = a(URL.class, mVar);
        n nVar = new n();
        J = nVar;
        K = a(URI.class, nVar);
        C0161o c0161o = new C0161o();
        L = c0161o;
        M = e(InetAddress.class, c0161o);
        p pVar = new p();
        N = pVar;
        O = a(UUID.class, pVar);
        e9.x<Currency> xVarB6 = new q().b();
        P = xVarB6;
        Q = a(Currency.class, xVarB6);
        r rVar = new r();
        R = rVar;
        S = d(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        T = sVar;
        U = a(Locale.class, sVar);
        t tVar = new t();
        V = tVar;
        W = e(e9.k.class, tVar);
        X = new u();
    }

    public static <TT> e9.y a(Class<TT> cls, e9.x<TT> xVar) {
        return new x(cls, xVar);
    }

    public static <TT> e9.y b(Class<TT> cls, Class<TT> cls2, e9.x<? super TT> xVar) {
        return new y(cls, cls2, xVar);
    }

    public static <TT> e9.y c(l9.a<TT> aVar, e9.x<TT> xVar) {
        return new w(aVar, xVar);
    }

    public static <TT> e9.y d(Class<TT> cls, Class<? extends TT> cls2, e9.x<? super TT> xVar) {
        return new z(cls, cls2, xVar);
    }

    public static <T1> e9.y e(Class<T1> cls, e9.x<T1> xVar) {
        return new a0(cls, xVar);
    }
}
