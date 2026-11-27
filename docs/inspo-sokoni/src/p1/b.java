package p1;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class b<D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a<D> f14082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f14083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14084d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14085e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14086f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14087g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14088h = false;

    public interface a<D> {
        void a(b<D> bVar, D d10);
    }

    public b(Context context) {
        this.f14083c = context.getApplicationContext();
    }

    public void a() {
        this.f14085e = true;
        j();
    }

    public boolean b() {
        return k();
    }

    public void c() {
        this.f14088h = false;
    }

    public String d(D d10) {
        StringBuilder sb2 = new StringBuilder(64);
        o0.b.a(d10, sb2);
        sb2.append("}");
        return sb2.toString();
    }

    public void e() {
    }

    public void f(D d10) {
        a<D> aVar = this.f14082b;
        if (aVar != null) {
            aVar.a(this, d10);
        }
    }

    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f14081a);
        printWriter.print(" mListener=");
        printWriter.println(this.f14082b);
        if (this.f14084d || this.f14087g || this.f14088h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f14084d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f14087g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f14088h);
        }
        if (this.f14085e || this.f14086f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f14085e);
            printWriter.print(" mReset=");
            printWriter.println(this.f14086f);
        }
    }

    public void h() {
        m();
    }

    public boolean i() {
        return this.f14085e;
    }

    public void j() {
    }

    public boolean k() {
        throw null;
    }

    public void l() {
        if (this.f14084d) {
            h();
        } else {
            this.f14087g = true;
        }
    }

    public void m() {
    }

    public void n() {
    }

    public void o() {
        throw null;
    }

    public void p() {
    }

    public void q(int i10, a<D> aVar) {
        if (this.f14082b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f14082b = aVar;
        this.f14081a = i10;
    }

    public void r() {
        n();
        this.f14086f = true;
        this.f14084d = false;
        this.f14085e = false;
        this.f14087g = false;
        this.f14088h = false;
    }

    public void s() {
        if (this.f14088h) {
            l();
        }
    }

    public final void t() {
        this.f14084d = true;
        this.f14086f = false;
        this.f14085e = false;
        o();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        o0.b.a(this, sb2);
        sb2.append(" id=");
        sb2.append(this.f14081a);
        sb2.append("}");
        return sb2.toString();
    }

    public void u() {
        this.f14084d = false;
        p();
    }

    public void v(a<D> aVar) {
        a<D> aVar2 = this.f14082b;
        if (aVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (aVar2 != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f14082b = null;
    }
}
