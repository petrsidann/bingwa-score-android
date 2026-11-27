package b8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double[] f3015a;

    public z1(double[] dArr) {
        this.f3015a = dArr == null ? new double[0] : (double[]) dArr.clone();
    }

    public double[] a() {
        return (double[]) this.f3015a.clone();
    }

    public List<Double> b() {
        ArrayList arrayList = new ArrayList(this.f3015a.length);
        int i10 = 0;
        while (true) {
            double[] dArr = this.f3015a;
            if (i10 >= dArr.length) {
                return arrayList;
            }
            arrayList.add(i10, Double.valueOf(dArr[i10]));
            i10++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f3015a, ((z1) obj).f3015a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f3015a);
    }
}
