package ra;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: classes.dex */
public class l extends TextureView implements io.flutter.embedding.engine.renderer.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FlutterRenderer f15253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Surface f15254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextureView.SurfaceTextureListener f15255e;

    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            qa.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
            l.this.f15251a = true;
            if (l.this.q()) {
                l.this.m();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            qa.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
            l.this.f15251a = false;
            if (l.this.q()) {
                l.this.n();
            }
            if (l.this.f15254d == null) {
                return true;
            }
            l.this.f15254d.release();
            l.this.f15254d = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            qa.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
            if (l.this.q()) {
                l.this.l(i10, i11);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public l(Context context) {
        this(context, null);
    }

    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15251a = false;
        this.f15252b = false;
        this.f15255e = new a();
        o();
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void a() {
        if (this.f15253c == null) {
            qa.b.g("FlutterTextureView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (p()) {
            qa.b.f("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            m();
        }
        this.f15252b = false;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void b(FlutterRenderer flutterRenderer) {
        qa.b.f("FlutterTextureView", "Attaching to FlutterRenderer.");
        if (this.f15253c != null) {
            qa.b.f("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f15253c.A();
        }
        this.f15253c = flutterRenderer;
        a();
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void c() {
        if (this.f15253c == null) {
            qa.b.g("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.f15252b = true;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void d() {
        if (this.f15253c == null) {
            qa.b.g("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            qa.b.f("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
            n();
        }
        this.f15253c = null;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public FlutterRenderer getAttachedRenderer() {
        return this.f15253c;
    }

    public final void l(int i10, int i11) {
        if (this.f15253c == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        qa.b.f("FlutterTextureView", "Notifying FlutterRenderer that Android surface size has changed to " + i10 + " x " + i11);
        this.f15253c.B(i10, i11);
    }

    public final void m() {
        if (this.f15253c == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = this.f15254d;
        if (surface != null) {
            surface.release();
            this.f15254d = null;
        }
        Surface surface2 = new Surface(getSurfaceTexture());
        this.f15254d = surface2;
        this.f15253c.z(surface2, this.f15252b);
    }

    public final void n() {
        FlutterRenderer flutterRenderer = this.f15253c;
        if (flutterRenderer == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        flutterRenderer.A();
        Surface surface = this.f15254d;
        if (surface != null) {
            surface.release();
            this.f15254d = null;
        }
    }

    public final void o() {
        setSurfaceTextureListener(this.f15255e);
    }

    public boolean p() {
        return this.f15251a;
    }

    public final boolean q() {
        return (this.f15253c == null || this.f15252b) ? false : true;
    }

    public void setRenderSurface(Surface surface) {
        this.f15254d = surface;
    }
}
