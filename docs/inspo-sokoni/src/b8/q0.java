package b8;

/* JADX INFO: loaded from: classes.dex */
public class q0 implements Comparable<q0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f2950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f2951b;

    public q0(double d10, double d11) {
        if (Double.isNaN(d10) || d10 < -90.0d || d10 > 90.0d) {
            throw new IllegalArgumentException("Latitude must be in the range of [-90, 90]");
        }
        if (Double.isNaN(d11) || d11 < -180.0d || d11 > 180.0d) {
            throw new IllegalArgumentException("Longitude must be in the range of [-180, 180]");
        }
        this.f2950a = d10;
        this.f2951b = d11;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(q0 q0Var) {
        int iK = l8.g0.k(this.f2950a, q0Var.f2950a);
        return iK == 0 ? l8.g0.k(this.f2951b, q0Var.f2951b) : iK;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return this.f2950a == q0Var.f2950a && this.f2951b == q0Var.f2951b;
    }

    public double h() {
        return this.f2950a;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f2950a);
        int i10 = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f2951b);
        return (i10 * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }

    public double i() {
        return this.f2951b;
    }

    public String toString() {
        return "GeoPoint { latitude=" + this.f2950a + ", longitude=" + this.f2951b + " }";
    }
}
