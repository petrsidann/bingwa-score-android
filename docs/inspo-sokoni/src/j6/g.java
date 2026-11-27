package j6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0185b f11271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C0185b f11272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f11273d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f11274e;

        public static final class a extends C0185b {
            public a() {
                super();
            }
        }

        /* JADX INFO: renamed from: j6.g$b$b, reason: collision with other inner class name */
        public static class C0185b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f11275a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f11276b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public C0185b f11277c;

            public C0185b() {
            }
        }

        public b(String str) {
            C0185b c0185b = new C0185b();
            this.f11271b = c0185b;
            this.f11272c = c0185b;
            this.f11273d = false;
            this.f11274e = false;
            this.f11270a = (String) m.o(str);
        }

        public static boolean l(Object obj) {
            if (obj instanceof CharSequence) {
                return ((CharSequence) obj).length() == 0;
            }
            if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            }
            if (obj instanceof Map) {
                return ((Map) obj).isEmpty();
            }
            if (obj instanceof j) {
                return !((j) obj).d();
            }
            return obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public b a(String str, double d10) {
            return j(str, String.valueOf(d10));
        }

        public b b(String str, int i10) {
            return j(str, String.valueOf(i10));
        }

        public b c(String str, long j10) {
            return j(str, String.valueOf(j10));
        }

        public b d(String str, Object obj) {
            return h(str, obj);
        }

        public b e(String str, boolean z10) {
            return j(str, String.valueOf(z10));
        }

        public final C0185b f() {
            C0185b c0185b = new C0185b();
            this.f11272c.f11277c = c0185b;
            this.f11272c = c0185b;
            return c0185b;
        }

        public final b g(Object obj) {
            f().f11276b = obj;
            return this;
        }

        public final b h(String str, Object obj) {
            C0185b c0185bF = f();
            c0185bF.f11276b = obj;
            c0185bF.f11275a = (String) m.o(str);
            return this;
        }

        public final a i() {
            a aVar = new a();
            this.f11272c.f11277c = aVar;
            this.f11272c = aVar;
            return aVar;
        }

        public final b j(String str, Object obj) {
            a aVarI = i();
            aVarI.f11276b = obj;
            aVarI.f11275a = (String) m.o(str);
            return this;
        }

        public b k(Object obj) {
            return g(obj);
        }

        public b m() {
            this.f11273d = true;
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0030  */
        /* JADX WARN: Code duplicated, block: B:14:0x0037  */
        /* JADX WARN: Code duplicated, block: B:16:0x0041  */
        /* JADX WARN: Code duplicated, block: B:19:0x005e  */
        public String toString() {
            String str;
            boolean z10 = this.f11273d;
            boolean z11 = this.f11274e;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.f11270a);
            sb2.append('{');
            String str2 = "";
            for (C0185b c0185b = this.f11271b.f11277c; c0185b != null; c0185b = c0185b.f11277c) {
                Object obj = c0185b.f11276b;
                if (c0185b instanceof a) {
                    sb2.append(str2);
                    str = c0185b.f11275a;
                    if (str != null) {
                        sb2.append(str);
                        sb2.append('=');
                    }
                    if (obj == null && obj.getClass().isArray()) {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb2.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    } else {
                        sb2.append(obj);
                    }
                    str2 = ", ";
                } else if (obj == null) {
                    if (!z10) {
                        sb2.append(str2);
                        str = c0185b.f11275a;
                        if (str != null) {
                            sb2.append(str);
                            sb2.append('=');
                        }
                        if (obj == null) {
                            sb2.append(obj);
                        } else {
                            sb2.append(obj);
                        }
                        str2 = ", ";
                    }
                } else if (!z11 || !l(obj)) {
                    sb2.append(str2);
                    str = c0185b.f11275a;
                    if (str != null) {
                        sb2.append(str);
                        sb2.append('=');
                    }
                    if (obj == null) {
                        sb2.append(obj);
                    } else {
                        sb2.append(obj);
                    }
                    str2 = ", ";
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static b a(Class<?> cls) {
        return new b(cls.getSimpleName());
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
