package zb;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char[] f20463g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f20457a = name;
        this.f20458b = name.length();
    }

    public final String a() {
        int i10;
        int i11;
        char c10;
        int i12 = this.f20459c;
        this.f20460d = i12;
        this.f20461e = i12;
        while (true) {
            int i13 = this.f20459c;
            if (i13 >= this.f20458b) {
                char[] cArr = this.f20463g;
                int i14 = this.f20460d;
                return new String(cArr, i14, this.f20461e - i14);
            }
            char[] cArr2 = this.f20463g;
            char c11 = cArr2[i13];
            if (c11 != ' ') {
                if (c11 != ';') {
                    if (c11 == '\\') {
                        int i15 = this.f20461e;
                        this.f20461e = i15 + 1;
                        cArr2[i15] = d();
                        i13 = this.f20459c;
                    } else if (c11 != '+' && c11 != ',') {
                        int i16 = this.f20461e;
                        this.f20461e = i16 + 1;
                        cArr2[i16] = c11;
                    }
                    this.f20459c = i13 + 1;
                }
                int i17 = this.f20460d;
                return new String(cArr2, i17, this.f20461e - i17);
            }
            int i18 = this.f20461e;
            this.f20462f = i18;
            this.f20459c = i13 + 1;
            this.f20461e = i18 + 1;
            cArr2[i18] = ' ';
            while (true) {
                i10 = this.f20459c;
                i11 = this.f20458b;
                if (i10 >= i11) {
                    break;
                }
                char[] cArr3 = this.f20463g;
                if (cArr3[i10] != ' ') {
                    break;
                }
                int i19 = this.f20461e;
                this.f20461e = i19 + 1;
                cArr3[i19] = ' ';
                this.f20459c = i10 + 1;
            }
            if (i10 == i11 || (c10 = this.f20463g[i10]) == ',' || c10 == '+' || c10 == ';') {
                char[] cArr4 = this.f20463g;
                int i20 = this.f20460d;
                return new String(cArr4, i20, this.f20462f - i20);
            }
        }
    }

    public String b(String str) {
        String strH;
        this.f20459c = 0;
        this.f20460d = 0;
        this.f20461e = 0;
        this.f20462f = 0;
        this.f20463g = this.f20457a.toCharArray();
        String strG = g();
        if (strG == null) {
            return null;
        }
        do {
            int i10 = this.f20459c;
            if (i10 == this.f20458b) {
                return null;
            }
            char c10 = this.f20463g[i10];
            if (c10 == '\"') {
                strH = h();
            } else if (c10 != '#') {
                strH = (c10 == '+' || c10 == ',' || c10 == ';') ? "" : a();
            } else {
                strH = f();
            }
            if (str.equalsIgnoreCase(strG)) {
                return strH;
            }
            int i11 = this.f20459c;
            if (i11 >= this.f20458b) {
                return null;
            }
            char c11 = this.f20463g[i11];
            if (c11 != ',' && c11 != ';' && c11 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f20457a);
            }
            this.f20459c = i11 + 1;
            strG = g();
        } while (strG != null);
        throw new IllegalStateException("Malformed DN: " + this.f20457a);
    }

    public final int c(int i10) {
        int i11;
        int i12;
        int i13 = i10 + 1;
        if (i13 >= this.f20458b) {
            throw new IllegalStateException("Malformed DN: " + this.f20457a);
        }
        char[] cArr = this.f20463g;
        char c10 = cArr[i10];
        if (c10 >= '0' && c10 <= '9') {
            i11 = c10 - '0';
        } else if (c10 >= 'a' && c10 <= 'f') {
            i11 = c10 - 'W';
        } else {
            if (c10 < 'A' || c10 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f20457a);
            }
            i11 = c10 - '7';
        }
        char c11 = cArr[i13];
        if (c11 >= '0' && c11 <= '9') {
            i12 = c11 - '0';
        } else if (c11 >= 'a' && c11 <= 'f') {
            i12 = c11 - 'W';
        } else {
            if (c11 < 'A' || c11 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f20457a);
            }
            i12 = c11 - '7';
        }
        return (i11 << 4) + i12;
    }

    public final char d() {
        int i10 = this.f20459c + 1;
        this.f20459c = i10;
        if (i10 == this.f20458b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f20457a);
        }
        char c10 = this.f20463g[i10];
        if (c10 == ' ' || c10 == '%' || c10 == '\\' || c10 == '_' || c10 == '\"' || c10 == '#') {
            return c10;
        }
        switch (c10) {
            case '*':
            case '+':
            case ',':
                return c10;
            default:
                switch (c10) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c10;
                    default:
                        return e();
                }
        }
    }

    public final char e() {
        int i10;
        int i11;
        int iC = c(this.f20459c);
        this.f20459c++;
        if (iC < 128) {
            return (char) iC;
        }
        if (iC < 192 || iC > 247) {
            return '?';
        }
        if (iC <= 223) {
            i10 = iC & 31;
            i11 = 1;
        } else if (iC <= 239) {
            i10 = iC & 15;
            i11 = 2;
        } else {
            i10 = iC & 7;
            i11 = 3;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.f20459c + 1;
            this.f20459c = i13;
            if (i13 == this.f20458b || this.f20463g[i13] != '\\') {
                return '?';
            }
            int i14 = i13 + 1;
            this.f20459c = i14;
            int iC2 = c(i14);
            this.f20459c++;
            if ((iC2 & 192) != 128) {
                return '?';
            }
            i10 = (i10 << 6) + (iC2 & 63);
        }
        return (char) i10;
    }

    public final String f() {
        char[] cArr;
        char c10;
        int i10 = this.f20459c;
        if (i10 + 4 >= this.f20458b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f20457a);
        }
        this.f20460d = i10;
        while (true) {
            this.f20459c = i10 + 1;
            i10 = this.f20459c;
            if (i10 == this.f20458b || (c10 = (cArr = this.f20463g)[i10]) == '+' || c10 == ',' || c10 == ';') {
                this.f20461e = i10;
                break;
            }
            if (c10 == ' ') {
                this.f20461e = i10;
                do {
                    this.f20459c = i10 + 1;
                    i10 = this.f20459c;
                    if (i10 >= this.f20458b) {
                        break;
                    }
                } while (this.f20463g[i10] == ' ');
            } else if (c10 >= 'A' && c10 <= 'F') {
                cArr[i10] = (char) (c10 + ' ');
            }
        }
        int i11 = this.f20461e;
        int i12 = this.f20460d;
        int i13 = i11 - i12;
        if (i13 < 5 || (i13 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f20457a);
        }
        int i14 = i13 / 2;
        byte[] bArr = new byte[i14];
        int i15 = i12 + 1;
        for (int i16 = 0; i16 < i14; i16++) {
            bArr[i16] = (byte) c(i15);
            i15 += 2;
        }
        return new String(this.f20463g, this.f20460d, i13);
    }

    public final String g() {
        int i10;
        int i11;
        int i12;
        char c10;
        int i13;
        int i14;
        char c11;
        char c12;
        while (true) {
            i10 = this.f20459c;
            i11 = this.f20458b;
            if (i10 >= i11 || this.f20463g[i10] != ' ') {
                break;
            }
            this.f20459c = i10 + 1;
        }
        if (i10 == i11) {
            return null;
        }
        this.f20460d = i10;
        do {
            this.f20459c = i10 + 1;
            i10 = this.f20459c;
            i12 = this.f20458b;
            if (i10 >= i12 || (c12 = this.f20463g[i10]) == '=') {
                break;
            }
        } while (c12 != ' ');
        if (i10 >= i12) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f20457a);
        }
        this.f20461e = i10;
        if (this.f20463g[i10] == ' ') {
            while (true) {
                i13 = this.f20459c;
                i14 = this.f20458b;
                if (i13 >= i14 || (c11 = this.f20463g[i13]) == '=' || c11 != ' ') {
                    break;
                }
                this.f20459c = i13 + 1;
            }
            if (this.f20463g[i13] != '=' || i13 == i14) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f20457a);
            }
        }
        int i15 = this.f20459c;
        do {
            this.f20459c = i15 + 1;
            i15 = this.f20459c;
            if (i15 >= this.f20458b) {
                break;
            }
        } while (this.f20463g[i15] == ' ');
        int i16 = this.f20461e;
        int i17 = this.f20460d;
        if (i16 - i17 > 4) {
            char[] cArr = this.f20463g;
            if (cArr[i17 + 3] == '.' && (((c10 = cArr[i17]) == 'O' || c10 == 'o') && ((cArr[i17 + 1] == 'I' || cArr[i17 + 1] == 'i') && (cArr[i17 + 2] == 'D' || cArr[i17 + 2] == 'd')))) {
                this.f20460d = i17 + 4;
            }
        }
        char[] cArr2 = this.f20463g;
        int i18 = this.f20460d;
        return new String(cArr2, i18, i16 - i18);
    }

    public final String h() {
        int i10 = this.f20459c + 1;
        this.f20459c = i10;
        this.f20460d = i10;
        while (true) {
            this.f20461e = i10;
            int i11 = this.f20459c;
            if (i11 == this.f20458b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f20457a);
            }
            char[] cArr = this.f20463g;
            char c10 = cArr[i11];
            if (c10 == '\"') {
                do {
                    this.f20459c = i11 + 1;
                    i11 = this.f20459c;
                    if (i11 >= this.f20458b) {
                        break;
                    }
                } while (this.f20463g[i11] == ' ');
                char[] cArr2 = this.f20463g;
                int i12 = this.f20460d;
                return new String(cArr2, i12, this.f20461e - i12);
            }
            if (c10 == '\\') {
                cArr[this.f20461e] = d();
            } else {
                cArr[this.f20461e] = c10;
            }
            this.f20459c++;
            i10 = this.f20461e + 1;
        }
    }
}
