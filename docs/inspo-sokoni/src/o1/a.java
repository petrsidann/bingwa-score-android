package o1;

import android.os.Bundle;
import androidx.lifecycle.j0;
import androidx.lifecycle.k;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: o1.a$a, reason: collision with other inner class name */
    public interface InterfaceC0233a<D> {
        void a(p1.b<D> bVar);

        p1.b<D> b(int i10, Bundle bundle);

        void c(p1.b<D> bVar, D d10);
    }

    public static <T extends k & j0> a b(T t10) {
        return new b(t10, t10.m());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> p1.b<D> c(int i10, Bundle bundle, InterfaceC0233a<D> interfaceC0233a);

    public abstract void d();
}
