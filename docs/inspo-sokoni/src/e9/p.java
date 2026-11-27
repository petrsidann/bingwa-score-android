package e9;

import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class p extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7447a;

    public p(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f7447a = bool;
    }

    public p(Number number) {
        Objects.requireNonNull(number);
        this.f7447a = number;
    }

    public p(String str) {
        Objects.requireNonNull(str);
        this.f7447a = str;
    }

    public static boolean x(p pVar) {
        Object obj = pVar.f7447a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // e9.k
    public boolean e() {
        return w() ? ((Boolean) this.f7447a).booleanValue() : Boolean.parseBoolean(k());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f7447a == null) {
            return pVar.f7447a == null;
        }
        if (x(this) && x(pVar)) {
            return v().longValue() == pVar.v().longValue();
        }
        Object obj2 = this.f7447a;
        if (!(obj2 instanceof Number) || !(pVar.f7447a instanceof Number)) {
            return obj2.equals(pVar.f7447a);
        }
        double dDoubleValue = v().doubleValue();
        double dDoubleValue2 = pVar.v().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f7447a == null) {
            return 31;
        }
        if (x(this)) {
            jDoubleToLongBits = v().longValue();
        } else {
            Object obj = this.f7447a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(v().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    @Override // e9.k
    public String k() {
        Object obj = this.f7447a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (y()) {
            return v().toString();
        }
        if (w()) {
            return ((Boolean) this.f7447a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f7447a.getClass());
    }

    public double r() {
        return y() ? v().doubleValue() : Double.parseDouble(k());
    }

    public int s() {
        return y() ? v().intValue() : Integer.parseInt(k());
    }

    public long t() {
        return y() ? v().longValue() : Long.parseLong(k());
    }

    public Number v() {
        Object obj = this.f7447a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new g9.g((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean w() {
        return this.f7447a instanceof Boolean;
    }

    public boolean y() {
        return this.f7447a instanceof Number;
    }

    public boolean z() {
        return this.f7447a instanceof String;
    }
}
