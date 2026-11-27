package b8;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f2972a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f2973b = new e();

    public static class a extends u {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Object> f2974c;

        public a(List<Object> list) {
            this.f2974c = list;
        }

        @Override // b8.u
        public String d() {
            return "FieldValue.arrayRemove";
        }

        public List<Object> i() {
            return this.f2974c;
        }
    }

    public static class b extends u {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Object> f2975c;

        public b(List<Object> list) {
            this.f2975c = list;
        }

        @Override // b8.u
        public String d() {
            return "FieldValue.arrayUnion";
        }

        public List<Object> i() {
            return this.f2975c;
        }
    }

    public static class c extends u {
        @Override // b8.u
        public String d() {
            return "FieldValue.delete";
        }
    }

    public static class d extends u {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Number f2976c;

        public d(Number number) {
            this.f2976c = number;
        }

        @Override // b8.u
        public String d() {
            return "FieldValue.increment";
        }

        public Number i() {
            return this.f2976c;
        }
    }

    public static class e extends u {
        @Override // b8.u
        public String d() {
            return "FieldValue.serverTimestamp";
        }
    }

    public static u a(Object... objArr) {
        return new a(Arrays.asList(objArr));
    }

    public static u b(Object... objArr) {
        return new b(Arrays.asList(objArr));
    }

    public static u c() {
        return f2972a;
    }

    public static u e(double d10) {
        return new d(Double.valueOf(d10));
    }

    public static u f(long j10) {
        return new d(Long.valueOf(j10));
    }

    public static u g() {
        return f2973b;
    }

    public static z1 h(double[] dArr) {
        return new z1(dArr);
    }

    public abstract String d();
}
