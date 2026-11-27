package s0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f15402a;

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputContentInfo f15403a;

        public a(Object obj) {
            this.f15403a = (InputContentInfo) obj;
        }

        @Override // s0.e.b
        public Uri a() {
            return this.f15403a.getContentUri();
        }

        @Override // s0.e.b
        public void b() {
            this.f15403a.requestPermission();
        }

        @Override // s0.e.b
        public Uri c() {
            return this.f15403a.getLinkUri();
        }

        @Override // s0.e.b
        public ClipDescription d() {
            return this.f15403a.getDescription();
        }

        @Override // s0.e.b
        public Object e() {
            return this.f15403a;
        }
    }

    public interface b {
        Uri a();

        void b();

        Uri c();

        ClipDescription d();

        Object e();
    }

    public e(b bVar) {
        this.f15402a = bVar;
    }

    public static e f(Object obj) {
        if (obj == null) {
            return null;
        }
        return new e(new a(obj));
    }

    public Uri a() {
        return this.f15402a.a();
    }

    public ClipDescription b() {
        return this.f15402a.d();
    }

    public Uri c() {
        return this.f15402a.c();
    }

    public void d() {
        this.f15402a.b();
    }

    public Object e() {
        return this.f15402a.e();
    }
}
