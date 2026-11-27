package z7;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f implements w7.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f20359f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final w7.d f20360g = w7.d.a("key").b(z7.a.b().c(1).a()).a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final w7.d f20361h = w7.d.a("value").b(z7.a.b().c(2).a()).a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final w7.e<Map.Entry<Object, Object>> f20362i = new w7.e() { // from class: z7.e
        @Override // w7.b
        public final void a(Object obj, w7.f fVar) {
            f.t((Map.Entry) obj, fVar);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f20363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, w7.e<?>> f20364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, w7.g<?>> f20365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w7.e<Object> f20366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f20367e = new i(this);

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20368a;

        static {
            int[] iArr = new int[d.a.values().length];
            f20368a = iArr;
            try {
                iArr[d.a.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20368a[d.a.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20368a[d.a.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f(OutputStream outputStream, Map<Class<?>, w7.e<?>> map, Map<Class<?>, w7.g<?>> map2, w7.e<Object> eVar) {
        this.f20363a = outputStream;
        this.f20364b = map;
        this.f20365c = map2;
        this.f20366d = eVar;
    }

    public static ByteBuffer m(int i10) {
        return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static d r(w7.d dVar) {
        d dVar2 = (d) dVar.c(d.class);
        if (dVar2 != null) {
            return dVar2;
        }
        throw new w7.c("Field has no @Protobuf config");
    }

    public static int s(w7.d dVar) {
        d dVar2 = (d) dVar.c(d.class);
        if (dVar2 != null) {
            return dVar2.tag();
        }
        throw new w7.c("Field has no @Protobuf config");
    }

    public static /* synthetic */ void t(Map.Entry entry, w7.f fVar) {
        fVar.c(f20360g, entry.getKey());
        fVar.c(f20361h, entry.getValue());
    }

    @Override // w7.f
    public w7.f c(w7.d dVar, Object obj) {
        return g(dVar, obj, true);
    }

    public w7.f e(w7.d dVar, double d10, boolean z10) throws IOException {
        if (z10 && d10 == 0.0d) {
            return this;
        }
        u((s(dVar) << 3) | 1);
        this.f20363a.write(m(8).putDouble(d10).array());
        return this;
    }

    public w7.f f(w7.d dVar, float f10, boolean z10) throws IOException {
        if (z10 && f10 == 0.0f) {
            return this;
        }
        u((s(dVar) << 3) | 5);
        this.f20363a.write(m(4).putFloat(f10).array());
        return this;
    }

    public w7.f g(w7.d dVar, Object obj, boolean z10) {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z10 && charSequence.length() == 0) {
                return this;
            }
            u((s(dVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f20359f);
            u(bytes.length);
            this.f20363a.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                g(dVar, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                o(f20362i, dVar, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            return e(dVar, ((Double) obj).doubleValue(), z10);
        }
        if (obj instanceof Float) {
            return f(dVar, ((Float) obj).floatValue(), z10);
        }
        if (obj instanceof Number) {
            return k(dVar, ((Number) obj).longValue(), z10);
        }
        if (obj instanceof Boolean) {
            return l(dVar, ((Boolean) obj).booleanValue(), z10);
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z10 && bArr.length == 0) {
                return this;
            }
            u((s(dVar) << 3) | 2);
            u(bArr.length);
            this.f20363a.write(bArr);
            return this;
        }
        w7.e<?> eVar = this.f20364b.get(obj.getClass());
        if (eVar != null) {
            return o(eVar, dVar, obj, z10);
        }
        w7.g<?> gVar = this.f20365c.get(obj.getClass());
        if (gVar != null) {
            return p(gVar, dVar, obj, z10);
        }
        if (obj instanceof c) {
            return b(dVar, ((c) obj).a());
        }
        return obj instanceof Enum ? b(dVar, ((Enum) obj).ordinal()) : o(this.f20366d, dVar, obj, z10);
    }

    @Override // w7.f
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public f b(w7.d dVar, int i10) {
        return i(dVar, i10, true);
    }

    public f i(w7.d dVar, int i10, boolean z10) throws IOException {
        if (z10 && i10 == 0) {
            return this;
        }
        d dVarR = r(dVar);
        int i11 = a.f20368a[dVarR.intEncoding().ordinal()];
        if (i11 == 1) {
            u(dVarR.tag() << 3);
            u(i10);
        } else if (i11 == 2) {
            u(dVarR.tag() << 3);
            u((i10 << 1) ^ (i10 >> 31));
        } else if (i11 == 3) {
            u((dVarR.tag() << 3) | 5);
            this.f20363a.write(m(4).putInt(i10).array());
        }
        return this;
    }

    @Override // w7.f
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public f a(w7.d dVar, long j10) {
        return k(dVar, j10, true);
    }

    public f k(w7.d dVar, long j10, boolean z10) throws IOException {
        if (z10 && j10 == 0) {
            return this;
        }
        d dVarR = r(dVar);
        int i10 = a.f20368a[dVarR.intEncoding().ordinal()];
        if (i10 == 1) {
            u(dVarR.tag() << 3);
            v(j10);
        } else if (i10 == 2) {
            u(dVarR.tag() << 3);
            v((j10 >> 63) ^ (j10 << 1));
        } else if (i10 == 3) {
            u((dVarR.tag() << 3) | 1);
            this.f20363a.write(m(8).putLong(j10).array());
        }
        return this;
    }

    public f l(w7.d dVar, boolean z10, boolean z11) {
        return i(dVar, z10 ? 1 : 0, z11);
    }

    public final <T> long n(w7.e<T> eVar, T t10) throws IOException {
        b bVar = new b();
        try {
            OutputStream outputStream = this.f20363a;
            this.f20363a = bVar;
            try {
                eVar.a(t10, this);
                this.f20363a = outputStream;
                long jD = bVar.d();
                bVar.close();
                return jD;
            } catch (Throwable th) {
                this.f20363a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                bVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final <T> f o(w7.e<T> eVar, w7.d dVar, T t10, boolean z10) throws IOException {
        long jN = n(eVar, t10);
        if (z10 && jN == 0) {
            return this;
        }
        u((s(dVar) << 3) | 2);
        v(jN);
        eVar.a(t10, this);
        return this;
    }

    public final <T> f p(w7.g<T> gVar, w7.d dVar, T t10, boolean z10) {
        this.f20367e.b(dVar, z10);
        gVar.a(t10, this.f20367e);
        return this;
    }

    public f q(Object obj) {
        if (obj == null) {
            return this;
        }
        w7.e<?> eVar = this.f20364b.get(obj.getClass());
        if (eVar != null) {
            eVar.a(obj, this);
            return this;
        }
        throw new w7.c("No encoder for " + obj.getClass());
    }

    public final void u(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            this.f20363a.write((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.f20363a.write(i10 & 127);
    }

    public final void v(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            this.f20363a.write((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        this.f20363a.write(((int) j10) & 127);
    }
}
