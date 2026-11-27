package p7;

/* JADX INFO: loaded from: classes.dex */
public final class v1 extends r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14332c;

    public v1(String str, String str2, String str3) {
        this.f14330a = str;
        this.f14331b = str2;
        this.f14332c = str3;
    }

    @Override // p7.r1
    public final String b() {
        return this.f14331b;
    }

    @Override // p7.r1
    public final String c() {
        return this.f14332c;
    }

    @Override // p7.r1
    public final String d() {
        return this.f14330a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r1) {
            r1 r1Var = (r1) obj;
            String str = this.f14330a;
            if (str != null ? str.equals(r1Var.d()) : r1Var.d() == null) {
                String str2 = this.f14331b;
                if (str2 != null ? str2.equals(r1Var.b()) : r1Var.b() == null) {
                    String str3 = this.f14332c;
                    String strC = r1Var.c();
                    if (str3 != null ? str3.equals(strC) : strC == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f14330a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f14331b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f14332c;
        return iHashCode2 ^ (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return "AttestationResult{recaptchaV2Token=" + this.f14330a + ", playIntegrityToken=" + this.f14331b + ", recaptchaEnterpriseToken=" + this.f14332c + "}";
    }
}
