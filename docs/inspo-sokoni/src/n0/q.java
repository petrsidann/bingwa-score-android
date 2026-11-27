package n0;

import d9.d0;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f13404a = new e(null, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f13405b = new e(null, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p f13406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f13407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p f13408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p f13409f;

    public static class a implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f13410b = new a(true);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f13411a;

        public a(boolean z10) {
            this.f13411a = z10;
        }

        @Override // n0.q.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            boolean z10 = false;
            while (i10 < i12) {
                int iA = q.a(Character.getDirectionality(charSequence.charAt(i10)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                    } else if (!this.f13411a) {
                        return 1;
                    }
                    i10++;
                    z10 = z10;
                } else if (this.f13411a) {
                    return 0;
                }
                z10 = true;
                i10++;
                z10 = z10;
            }
            if (z10) {
                return this.f13411a ? 1 : 0;
            }
            return 2;
        }
    }

    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13412a = new b();

        @Override // n0.q.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            int iB = 2;
            while (i10 < i12 && iB == 2) {
                iB = q.b(Character.getDirectionality(charSequence.charAt(i10)));
                i10++;
            }
            return iB;
        }
    }

    public interface c {
        int a(CharSequence charSequence, int i10, int i11);
    }

    public static abstract class d implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f13413a;

        public d(c cVar) {
            this.f13413a = cVar;
        }

        public abstract boolean a();

        public final boolean b(CharSequence charSequence, int i10, int i11) {
            int iA = this.f13413a.a(charSequence, i10, i11);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return a();
            }
            return false;
        }

        @Override // n0.p
        public boolean isRtl(CharSequence charSequence, int i10, int i11) {
            if (charSequence == null || i10 < 0 || i11 < 0 || charSequence.length() - i11 < i10) {
                throw new IllegalArgumentException();
            }
            return this.f13413a == null ? a() : b(charSequence, i10, i11);
        }
    }

    public static class e extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f13414b;

        public e(c cVar, boolean z10) {
            super(cVar);
            this.f13414b = z10;
        }

        @Override // n0.q.d
        public boolean a() {
            return this.f13414b;
        }
    }

    public static class f extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f13415b = new f();

        public f() {
            super(null);
        }

        @Override // n0.q.d
        public boolean a() {
            return r.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f13412a;
        f13406c = new e(bVar, false);
        f13407d = new e(bVar, true);
        f13408e = new e(a.f13410b, false);
        f13409f = f.f13415b;
    }

    public static int a(int i10) {
        if (i10 != 0) {
            return (i10 == 1 || i10 == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                return 0;
            }
            switch (i10) {
                case 14:
                case 15:
                    break;
                case 16:
                case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
