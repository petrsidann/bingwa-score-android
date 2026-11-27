package e9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f7448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f7449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ t[] f7450c;

    public final enum a extends t {
        public a(String str, int i10) {
            super(str, i10, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        f7448a = aVar;
        t tVar = new t("STRING", 1) { // from class: e9.t.b
            {
                a aVar2 = null;
            }
        };
        f7449b = tVar;
        f7450c = new t[]{aVar, tVar};
    }

    public t(String str, int i10) {
        super(str, i10);
    }

    public /* synthetic */ t(String str, int i10, a aVar) {
        this(str, i10);
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f7450c.clone();
    }
}
