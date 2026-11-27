package b3;

import d3.g;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f2761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f2762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f2763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<a3.c> f2764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f2765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f2766h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2768b;

    static {
        String strA = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f2761c = strA;
        String strA2 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f2762d = strA2;
        String strA3 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f2763e = strA3;
        f2764f = Collections.unmodifiableSet(new HashSet(Arrays.asList(a3.c.b("proto"), a3.c.b("json"))));
        f2765g = new a(strA, null);
        f2766h = new a(strA2, strA3);
    }

    public a(String str, String str2) {
        this.f2767a = str;
        this.f2768b = str2;
    }

    public static a c(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }

    @Override // d3.g
    public Set<a3.c> a() {
        return f2764f;
    }

    public byte[] b() {
        String str = this.f2768b;
        if (str == null && this.f2767a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f2767a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    public String d() {
        return this.f2768b;
    }

    public String e() {
        return this.f2767a;
    }

    @Override // d3.f
    public byte[] getExtras() {
        return b();
    }

    @Override // d3.f
    public String getName() {
        return "cct";
    }
}
