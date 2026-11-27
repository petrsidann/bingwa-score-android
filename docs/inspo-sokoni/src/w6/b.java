package w6;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f17648a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f17649b = new AtomicBoolean(false);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: w6.b$b, reason: collision with other inner class name */
    public static abstract class EnumC0311b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0311b f17650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0311b f17651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EnumC0311b[] f17652c;

        /* JADX INFO: renamed from: w6.b$b$a */
        public final enum a extends EnumC0311b {
            public a(String str, int i10) {
                super(str, i10);
            }

            @Override // w6.b.EnumC0311b
            public boolean d() {
                return !b.c();
            }
        }

        /* JADX INFO: renamed from: w6.b$b$b, reason: collision with other inner class name */
        public final enum C0312b extends EnumC0311b {
            public C0312b(String str, int i10) {
                super(str, i10);
            }

            @Override // w6.b.EnumC0311b
            public boolean d() {
                return !b.c() || b.b();
            }
        }

        static {
            a aVar = new a("ALGORITHM_NOT_FIPS", 0);
            f17650a = aVar;
            C0312b c0312b = new C0312b("ALGORITHM_REQUIRES_BORINGCRYPTO", 1);
            f17651b = c0312b;
            f17652c = new EnumC0311b[]{aVar, c0312b};
        }

        public EnumC0311b(String str, int i10) {
            super(str, i10);
        }

        public static EnumC0311b valueOf(String str) {
            return (EnumC0311b) Enum.valueOf(EnumC0311b.class, str);
        }

        public static EnumC0311b[] values() {
            return (EnumC0311b[]) f17652c.clone();
        }

        public abstract boolean d();
    }

    public static Boolean a() {
        try {
            return (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            f17648a.info("Conscrypt is not available or does not support checking for FIPS build.");
            return Boolean.FALSE;
        }
    }

    public static boolean b() {
        return a().booleanValue();
    }

    public static boolean c() {
        return w6.a.a() || f17649b.get();
    }
}
