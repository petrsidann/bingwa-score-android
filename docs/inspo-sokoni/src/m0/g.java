package m0;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import h0.j;

/* JADX INFO: loaded from: classes.dex */
public class g {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b[] f12888b;

        @Deprecated
        public a(int i10, b[] bVarArr) {
            this.f12887a = i10;
            this.f12888b = bVarArr;
        }

        public static a a(int i10, b[] bVarArr) {
            return new a(i10, bVarArr);
        }

        public b[] b() {
            return this.f12888b;
        }

        public int c() {
            return this.f12887a;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f12889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f12891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f12892d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f12893e;

        @Deprecated
        public b(Uri uri, int i10, int i11, boolean z10, int i12) {
            this.f12889a = (Uri) o0.h.g(uri);
            this.f12890b = i10;
            this.f12891c = i11;
            this.f12892d = z10;
            this.f12893e = i12;
        }

        public static b a(Uri uri, int i10, int i11, boolean z10, int i12) {
            return new b(uri, i10, i11, z10, i12);
        }

        public int b() {
            return this.f12893e;
        }

        public int c() {
            return this.f12890b;
        }

        public Uri d() {
            return this.f12889a;
        }

        public int e() {
            return this.f12891c;
        }

        public boolean f() {
            return this.f12892d;
        }
    }

    public static class c {
        public void a(int i10) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return j.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, e eVar) {
        return d.e(context, eVar, cancellationSignal);
    }

    public static Typeface c(Context context, e eVar, int i10, boolean z10, int i11, Handler handler, c cVar) {
        m0.a aVar = new m0.a(cVar, handler);
        return z10 ? f.e(context, eVar, aVar, i10, i11) : f.d(context, eVar, i10, null, aVar);
    }
}
