package y7;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import w7.f;
import w7.g;
import w7.h;

/* JADX INFO: loaded from: classes.dex */
public final class e implements f, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f19422a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19423b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonWriter f19424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<?>, w7.e<?>> f19425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<?>, g<?>> f19426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w7.e<Object> f19427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f19428g;

    public e(Writer writer, Map<Class<?>, w7.e<?>> map, Map<Class<?>, g<?>> map2, w7.e<Object> eVar, boolean z10) {
        this.f19424c = new JsonWriter(writer);
        this.f19425d = map;
        this.f19426e = map2;
        this.f19427f = eVar;
        this.f19428g = z10;
    }

    @Override // w7.f
    public f a(w7.d dVar, long j10) {
        return k(dVar.b(), j10);
    }

    @Override // w7.f
    public f b(w7.d dVar, int i10) {
        return j(dVar.b(), i10);
    }

    @Override // w7.f
    public f c(w7.d dVar, Object obj) {
        return l(dVar.b(), obj);
    }

    public e f(int i10) throws IOException {
        t();
        this.f19424c.value(i10);
        return this;
    }

    public e g(long j10) throws IOException {
        t();
        this.f19424c.value(j10);
        return this;
    }

    public e h(Object obj, boolean z10) {
        int i10 = 0;
        if (z10 && o(obj)) {
            Object[] objArr = new Object[1];
            objArr[0] = obj == null ? null : obj.getClass();
            throw new w7.c(String.format("%s cannot be encoded inline", objArr));
        }
        if (obj == null) {
            this.f19424c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f19424c.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f19424c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    h(it.next(), false);
                }
                this.f19424c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f19424c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        l((String) key, entry.getValue());
                    } catch (ClassCastException e10) {
                        throw new w7.c(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e10);
                    }
                }
                this.f19424c.endObject();
                return this;
            }
            w7.e<?> eVar = this.f19425d.get(obj.getClass());
            if (eVar != null) {
                return q(eVar, obj, z10);
            }
            g<?> gVar = this.f19426e.get(obj.getClass());
            if (gVar != null) {
                gVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return q(this.f19427f, obj, z10);
            }
            d(((Enum) obj).name());
            return this;
        }
        if (obj instanceof byte[]) {
            return n((byte[]) obj);
        }
        this.f19424c.beginArray();
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            while (i10 < length) {
                this.f19424c.value(iArr[i10]);
                i10++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i10 < length2) {
                g(jArr[i10]);
                i10++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i10 < length3) {
                this.f19424c.value(dArr[i10]);
                i10++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i10 < length4) {
                this.f19424c.value(zArr[i10]);
                i10++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                h(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                h(obj2, false);
            }
        }
        this.f19424c.endArray();
        return this;
    }

    @Override // w7.h
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public e d(String str) throws IOException {
        t();
        this.f19424c.value(str);
        return this;
    }

    public e j(String str, int i10) throws IOException {
        t();
        this.f19424c.name(str);
        return f(i10);
    }

    public e k(String str, long j10) throws IOException {
        t();
        this.f19424c.name(str);
        return g(j10);
    }

    public e l(String str, Object obj) {
        return this.f19428g ? s(str, obj) : r(str, obj);
    }

    @Override // w7.h
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public e e(boolean z10) throws IOException {
        t();
        this.f19424c.value(z10);
        return this;
    }

    public e n(byte[] bArr) throws IOException {
        t();
        if (bArr == null) {
            this.f19424c.nullValue();
        } else {
            this.f19424c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    public final boolean o(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    public void p() {
        t();
        this.f19424c.flush();
    }

    public e q(w7.e<Object> eVar, Object obj, boolean z10) throws IOException {
        if (!z10) {
            this.f19424c.beginObject();
        }
        eVar.a(obj, this);
        if (!z10) {
            this.f19424c.endObject();
        }
        return this;
    }

    public final e r(String str, Object obj) throws IOException {
        t();
        this.f19424c.name(str);
        if (obj != null) {
            return h(obj, false);
        }
        this.f19424c.nullValue();
        return this;
    }

    public final e s(String str, Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        t();
        this.f19424c.name(str);
        return h(obj, false);
    }

    public final void t() throws IOException {
        if (!this.f19423b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e eVar = this.f19422a;
        if (eVar != null) {
            eVar.t();
            this.f19422a.f19423b = false;
            this.f19422a = null;
            this.f19424c.endObject();
        }
    }
}
