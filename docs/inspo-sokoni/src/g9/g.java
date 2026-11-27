package g9;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class g extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9074a;

    public g(String str) {
        this.f9074a = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f9074a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        String str = this.f9074a;
        String str2 = ((g) obj).f9074a;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f9074a);
    }

    public int hashCode() {
        return this.f9074a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f9074a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f9074a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f9074a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f9074a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f9074a).longValue();
        }
    }

    public String toString() {
        return this.f9074a;
    }
}
