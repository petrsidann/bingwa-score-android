package k6;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class a implements j6.e<Map.Entry<?, ?>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11542a = new C0197a("KEY", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f11543b = new b("VALUE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a[] f11544c = d();

        /* JADX INFO: renamed from: k6.b0$a$a, reason: collision with other inner class name */
        public final enum C0197a extends a {
            public C0197a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // j6.e
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        public final enum b extends a {
            public b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // j6.e
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        public a(String str, int i10) {
            super(str, i10);
        }

        public /* synthetic */ a(String str, int i10, a0 a0Var) {
            this(str, i10);
        }

        public static /* synthetic */ a[] d() {
            return new a[]{f11542a, f11543b};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f11544c.clone();
        }
    }

    public static boolean a(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K> j6.e<Map.Entry<K, ?>, K> b() {
        return a.f11542a;
    }

    public static String c(Map<?, ?> map) {
        StringBuilder sbA = h.a(map.size());
        sbA.append('{');
        boolean z10 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z10) {
                sbA.append(", ");
            }
            sbA.append(entry.getKey());
            sbA.append('=');
            sbA.append(entry.getValue());
            z10 = false;
        }
        sbA.append('}');
        return sbA.toString();
    }

    public static <V> j6.e<Map.Entry<?, V>, V> d() {
        return a.f11543b;
    }
}
