package n0;

import android.text.SpannableStringBuilder;
import d9.d0;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f13374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f13377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f13378h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f13381c;

    /* JADX INFO: renamed from: n0.a$a, reason: collision with other inner class name */
    public static final class C0225a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public p f13384c;

        public C0225a() {
            c(a.e(Locale.getDefault()));
        }

        public static a b(boolean z10) {
            return z10 ? a.f13378h : a.f13377g;
        }

        public a a() {
            return (this.f13383b == 2 && this.f13384c == a.f13374d) ? b(this.f13382a) : new a(this.f13382a, this.f13383b, this.f13384c);
        }

        public final void c(boolean z10) {
            this.f13382a = z10;
            this.f13384c = a.f13374d;
            this.f13383b = 2;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte[] f13385f = new byte[1792];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f13386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f13387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13388c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13389d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public char f13390e;

        static {
            for (int i10 = 0; i10 < 1792; i10++) {
                f13385f[i10] = Character.getDirectionality(i10);
            }
        }

        public b(CharSequence charSequence, boolean z10) {
            this.f13386a = charSequence;
            this.f13387b = z10;
            this.f13388c = charSequence.length();
        }

        public static byte c(char c10) {
            return c10 < 1792 ? f13385f[c10] : Character.getDirectionality(c10);
        }

        public byte a() {
            char cCharAt = this.f13386a.charAt(this.f13389d - 1);
            this.f13390e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f13386a, this.f13389d);
                this.f13389d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f13389d--;
            byte bC = c(this.f13390e);
            if (!this.f13387b) {
                return bC;
            }
            char c10 = this.f13390e;
            if (c10 == '>') {
                return h();
            }
            return c10 == ';' ? f() : bC;
        }

        public byte b() {
            char cCharAt = this.f13386a.charAt(this.f13389d);
            this.f13390e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f13386a, this.f13389d);
                this.f13389d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f13389d++;
            byte bC = c(this.f13390e);
            if (!this.f13387b) {
                return bC;
            }
            char c10 = this.f13390e;
            if (c10 == '<') {
                return i();
            }
            return c10 == '&' ? g() : bC;
        }

        public int d() {
            this.f13389d = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (this.f13389d < this.f13388c && i10 == 0) {
                byte b10 = b();
                if (b10 != 0) {
                    if (b10 == 1 || b10 == 2) {
                        if (i12 == 0) {
                            return 1;
                        }
                    } else if (b10 != 9) {
                        switch (b10) {
                            case 14:
                            case 15:
                                i12++;
                                i11 = -1;
                                continue;
                            case 16:
                            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                                i12++;
                                i11 = 1;
                                continue;
                            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                                i12--;
                                i11 = 0;
                                continue;
                        }
                    }
                } else if (i12 == 0) {
                    return -1;
                }
                i10 = i12;
            }
            if (i10 == 0) {
                return 0;
            }
            if (i11 != 0) {
                return i11;
            }
            while (this.f13389d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i10 == i12) {
                            return -1;
                        }
                        break;
                    case 16:
                    case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        if (i10 == i12) {
                            return 1;
                        }
                        break;
                    case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                        i12++;
                        continue;
                    default:
                        continue;
                }
                i12--;
            }
            return 0;
        }

        public int e() {
            this.f13389d = this.f13388c;
            int i10 = 0;
            while (true) {
                int i11 = i10;
                while (this.f13389d > 0) {
                    byte bA = a();
                    if (bA == 0) {
                        if (i10 == 0) {
                            return -1;
                        }
                        if (i11 == 0) {
                        }
                    } else if (bA == 1 || bA == 2) {
                        if (i10 == 0) {
                            return 1;
                        }
                        if (i11 == 0) {
                        }
                    } else if (bA != 9) {
                        switch (bA) {
                            case 14:
                            case 15:
                                if (i11 == i10) {
                                    return -1;
                                }
                                i10--;
                                break;
                            case 16:
                            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                                if (i11 == i10) {
                                    return 1;
                                }
                                i10--;
                                break;
                            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                                i10++;
                                break;
                            default:
                                if (i11 != 0) {
                                }
                                break;
                        }
                    } else {
                        continue;
                    }
                }
                return 0;
            }
        }

        public final byte f() {
            char cCharAt;
            int i10 = this.f13389d;
            do {
                int i11 = this.f13389d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f13386a;
                int i12 = i11 - 1;
                this.f13389d = i12;
                cCharAt = charSequence.charAt(i12);
                this.f13390e = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.f13389d = i10;
            this.f13390e = ';';
            return (byte) 13;
        }

        public final byte g() {
            char cCharAt;
            do {
                int i10 = this.f13389d;
                if (i10 >= this.f13388c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f13386a;
                this.f13389d = i10 + 1;
                cCharAt = charSequence.charAt(i10);
                this.f13390e = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        public final byte h() {
            char cCharAt;
            int i10 = this.f13389d;
            while (true) {
                int i11 = this.f13389d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f13386a;
                int i12 = i11 - 1;
                this.f13389d = i12;
                char cCharAt2 = charSequence.charAt(i12);
                this.f13390e = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i13 = this.f13389d;
                        if (i13 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f13386a;
                        int i14 = i13 - 1;
                        this.f13389d = i14;
                        cCharAt = charSequence2.charAt(i14);
                        this.f13390e = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f13389d = i10;
            this.f13390e = '>';
            return (byte) 13;
        }

        public final byte i() {
            char cCharAt;
            int i10 = this.f13389d;
            while (true) {
                int i11 = this.f13389d;
                if (i11 >= this.f13388c) {
                    this.f13389d = i10;
                    this.f13390e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f13386a;
                this.f13389d = i11 + 1;
                char cCharAt2 = charSequence.charAt(i11);
                this.f13390e = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i12 = this.f13389d;
                        if (i12 >= this.f13388c) {
                            break;
                        }
                        CharSequence charSequence2 = this.f13386a;
                        this.f13389d = i12 + 1;
                        cCharAt = charSequence2.charAt(i12);
                        this.f13390e = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
        }
    }

    static {
        p pVar = q.f13406c;
        f13374d = pVar;
        f13375e = Character.toString((char) 8206);
        f13376f = Character.toString((char) 8207);
        f13377g = new a(false, 2, pVar);
        f13378h = new a(true, 2, pVar);
    }

    public a(boolean z10, int i10, p pVar) {
        this.f13379a = z10;
        this.f13380b = i10;
        this.f13381c = pVar;
    }

    public static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0225a().a();
    }

    public static boolean e(Locale locale) {
        return r.a(locale) == 1;
    }

    public boolean d() {
        return (this.f13380b & 2) != 0;
    }

    public final String f(CharSequence charSequence, p pVar) {
        boolean zIsRtl = pVar.isRtl(charSequence, 0, charSequence.length());
        if (!this.f13379a && (zIsRtl || b(charSequence) == 1)) {
            return f13375e;
        }
        if (this.f13379a) {
            return (!zIsRtl || b(charSequence) == -1) ? f13376f : "";
        }
        return "";
    }

    public final String g(CharSequence charSequence, p pVar) {
        boolean zIsRtl = pVar.isRtl(charSequence, 0, charSequence.length());
        if (!this.f13379a && (zIsRtl || a(charSequence) == 1)) {
            return f13375e;
        }
        if (this.f13379a) {
            return (!zIsRtl || a(charSequence) == -1) ? f13376f : "";
        }
        return "";
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f13381c, true);
    }

    public CharSequence i(CharSequence charSequence, p pVar, boolean z10) {
        if (charSequence == null) {
            return null;
        }
        boolean zIsRtl = pVar.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z10) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zIsRtl ? q.f13405b : q.f13404a));
        }
        if (zIsRtl != this.f13379a) {
            spannableStringBuilder.append(zIsRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z10) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zIsRtl ? q.f13405b : q.f13404a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f13381c, true);
    }

    public String k(String str, p pVar, boolean z10) {
        if (str == null) {
            return null;
        }
        return i(str, pVar, z10).toString();
    }
}
