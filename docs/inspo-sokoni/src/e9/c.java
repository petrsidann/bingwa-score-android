package e9;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements e9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f7386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f7387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f7388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f7389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f7390f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f7391l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ c[] f7392m;

    public final enum a extends c {
        public a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // e9.d
        public String d(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f7385a = aVar;
        c cVar = new c("UPPER_CAMEL_CASE", 1) { // from class: e9.c.b
            {
                a aVar2 = null;
            }

            @Override // e9.d
            public String d(Field field) {
                return c.i(field.getName());
            }
        };
        f7386b = cVar;
        c cVar2 = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: e9.c.c
            {
                a aVar2 = null;
            }

            @Override // e9.d
            public String d(Field field) {
                return c.i(c.h(field.getName(), ' '));
            }
        };
        f7387c = cVar2;
        c cVar3 = new c("UPPER_CASE_WITH_UNDERSCORES", 3) { // from class: e9.c.d
            {
                a aVar2 = null;
            }

            @Override // e9.d
            public String d(Field field) {
                return c.h(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        };
        f7388d = cVar3;
        c cVar4 = new c("LOWER_CASE_WITH_UNDERSCORES", 4) { // from class: e9.c.e
            {
                a aVar2 = null;
            }

            @Override // e9.d
            public String d(Field field) {
                return c.h(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        };
        f7389e = cVar4;
        c cVar5 = new c("LOWER_CASE_WITH_DASHES", 5) { // from class: e9.c.f
            {
                a aVar2 = null;
            }

            @Override // e9.d
            public String d(Field field) {
                return c.h(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        };
        f7390f = cVar5;
        c cVar6 = new c("LOWER_CASE_WITH_DOTS", 6) { // from class: e9.c.g
            {
                a aVar2 = null;
            }

            @Override // e9.d
            public String d(Field field) {
                return c.h(field.getName(), '.').toLowerCase(Locale.ENGLISH);
            }
        };
        f7391l = cVar6;
        f7392m = new c[]{aVar, cVar, cVar2, cVar3, cVar4, cVar5, cVar6};
    }

    public c(String str, int i10) {
        super(str, i10);
    }

    public /* synthetic */ c(String str, int i10, a aVar) {
        this(str, i10);
    }

    public static String h(String str, char c10) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (Character.isUpperCase(cCharAt) && sb2.length() != 0) {
                sb2.append(c10);
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    public static String i(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                if (i10 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i10) + upperCase + str.substring(i10 + 1);
            }
        }
        return str;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f7392m.clone();
    }
}
