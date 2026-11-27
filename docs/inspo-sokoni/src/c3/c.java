package c3;

/* JADX INFO: loaded from: classes.dex */
public final class c extends c3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f3214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f3222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f3223j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f3224k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f3225l;

    public static final class b extends c3.a.AbstractC0063a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f3226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f3228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f3229d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3230e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f3231f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f3232g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f3233h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f3234i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f3235j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f3236k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f3237l;

        @Override // c3.a.AbstractC0063a
        public c3.a a() {
            return new c(this.f3226a, this.f3227b, this.f3228c, this.f3229d, this.f3230e, this.f3231f, this.f3232g, this.f3233h, this.f3234i, this.f3235j, this.f3236k, this.f3237l);
        }

        @Override // c3.a.AbstractC0063a
        public c3.a.AbstractC0063a b(String str) {
            this.f3237l = str;
            return this;
        }

        @Override // c3.a.AbstractC0063a
        public c3.a.AbstractC0063a c(String str) {
            this.f3235j = str;
            return this;
        }

        @Override // c3.a.AbstractC0063a
        public c3.a.AbstractC0063a d(String str) {
            this.f3229d = str;
            return this;
        }

        @Override // c3.a.AbstractC0063a
        public c3.a.AbstractC0063a e(String str) {
            this.f3233h = str;
            return this;
        }

        @Override // c3.a.AbstractC0063a
        public c3.a.AbstractC0063a f(String str) {
            this.f3228c = str;
            return this;
        }

        @Override // c3.a.AbstractC0063a
        public c3.a.AbstractC0063a g(String str) {
            this.f3234i = str;
            return this;
        }

        @Override // c3.a.AbstractC0063a
        public c3.a.AbstractC0063a h(String str) {
            this.f3232g = str;
            return this;
        }

        @Override // c3.a.AbstractC0063a
        public c3.a.AbstractC0063a i(String str) {
            this.f3236k = str;
            return this;
        }

        @Override // c3.a.AbstractC0063a
        public c3.a.AbstractC0063a j(String str) {
            this.f3227b = str;
            return this;
        }

        @Override // c3.a.AbstractC0063a
        public c3.a.AbstractC0063a k(String str) {
            this.f3231f = str;
            return this;
        }

        @Override // c3.a.AbstractC0063a
        public c3.a.AbstractC0063a l(String str) {
            this.f3230e = str;
            return this;
        }

        @Override // c3.a.AbstractC0063a
        public c3.a.AbstractC0063a m(Integer num) {
            this.f3226a = num;
            return this;
        }
    }

    public c(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f3214a = num;
        this.f3215b = str;
        this.f3216c = str2;
        this.f3217d = str3;
        this.f3218e = str4;
        this.f3219f = str5;
        this.f3220g = str6;
        this.f3221h = str7;
        this.f3222i = str8;
        this.f3223j = str9;
        this.f3224k = str10;
        this.f3225l = str11;
    }

    @Override // c3.a
    public String b() {
        return this.f3225l;
    }

    @Override // c3.a
    public String c() {
        return this.f3223j;
    }

    @Override // c3.a
    public String d() {
        return this.f3217d;
    }

    @Override // c3.a
    public String e() {
        return this.f3221h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c3.a)) {
            return false;
        }
        c3.a aVar = (c3.a) obj;
        Integer num = this.f3214a;
        if (num != null ? num.equals(aVar.m()) : aVar.m() == null) {
            String str = this.f3215b;
            if (str != null ? str.equals(aVar.j()) : aVar.j() == null) {
                String str2 = this.f3216c;
                if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                    String str3 = this.f3217d;
                    if (str3 != null ? str3.equals(aVar.d()) : aVar.d() == null) {
                        String str4 = this.f3218e;
                        if (str4 != null ? str4.equals(aVar.l()) : aVar.l() == null) {
                            String str5 = this.f3219f;
                            if (str5 != null ? str5.equals(aVar.k()) : aVar.k() == null) {
                                String str6 = this.f3220g;
                                if (str6 != null ? str6.equals(aVar.h()) : aVar.h() == null) {
                                    String str7 = this.f3221h;
                                    if (str7 != null ? str7.equals(aVar.e()) : aVar.e() == null) {
                                        String str8 = this.f3222i;
                                        if (str8 != null ? str8.equals(aVar.g()) : aVar.g() == null) {
                                            String str9 = this.f3223j;
                                            if (str9 != null ? str9.equals(aVar.c()) : aVar.c() == null) {
                                                String str10 = this.f3224k;
                                                if (str10 != null ? str10.equals(aVar.i()) : aVar.i() == null) {
                                                    String str11 = this.f3225l;
                                                    String strB = aVar.b();
                                                    if (str11 == null) {
                                                        if (strB == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(strB)) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // c3.a
    public String f() {
        return this.f3216c;
    }

    @Override // c3.a
    public String g() {
        return this.f3222i;
    }

    @Override // c3.a
    public String h() {
        return this.f3220g;
    }

    public int hashCode() {
        Integer num = this.f3214a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f3215b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f3216c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f3217d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f3218e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f3219f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f3220g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f3221h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f3222i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f3223j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f3224k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f3225l;
        return iHashCode11 ^ (str11 != null ? str11.hashCode() : 0);
    }

    @Override // c3.a
    public String i() {
        return this.f3224k;
    }

    @Override // c3.a
    public String j() {
        return this.f3215b;
    }

    @Override // c3.a
    public String k() {
        return this.f3219f;
    }

    @Override // c3.a
    public String l() {
        return this.f3218e;
    }

    @Override // c3.a
    public Integer m() {
        return this.f3214a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f3214a + ", model=" + this.f3215b + ", hardware=" + this.f3216c + ", device=" + this.f3217d + ", product=" + this.f3218e + ", osBuild=" + this.f3219f + ", manufacturer=" + this.f3220g + ", fingerprint=" + this.f3221h + ", locale=" + this.f3222i + ", country=" + this.f3223j + ", mccMnc=" + this.f3224k + ", applicationBuild=" + this.f3225l + "}";
    }
}
