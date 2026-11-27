package ra;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: classes.dex */
public class k extends SurfaceView implements io.flutter.embedding.engine.renderer.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f15243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlutterRenderer f15246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SurfaceHolder.Callback f15247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final io.flutter.embedding.engine.renderer.d f15248f;

    public class a implements SurfaceHolder.Callback {
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            qa.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
            if (k.this.p()) {
                k.this.k(i11, i12);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            qa.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.startRenderingToSurface()");
            k.this.f15244b = true;
            if (k.this.p()) {
                k.this.l();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            qa.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.stopRenderingToSurface()");
            k.this.f15244b = false;
            if (k.this.p()) {
                k.this.m();
            }
        }
    }

    public class b implements io.flutter.embedding.engine.renderer.d {
        public b() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void c() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void e() {
            qa.b.f("FlutterSurfaceView", "onFlutterUiDisplayed()");
            k.this.setAlpha(1.0f);
            if (k.this.f15246d != null) {
                k.this.f15246d.u(this);
            }
        }
    }

    public k(Context context, AttributeSet attributeSet, boolean z10) {
        super(context, attributeSet);
        this.f15244b = false;
        this.f15245c = false;
        this.f15247e = new a();
        this.f15248f = new b();
        this.f15243a = z10;
        n();
    }

    public k(Context context, boolean z10) {
        this(context, null, z10);
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void a() {
        FlutterRenderer flutterRenderer = this.f15246d;
        if (flutterRenderer == null) {
            qa.b.g("FlutterSurfaceView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        flutterRenderer.j(this.f15248f);
        if (o()) {
            qa.b.f("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            l();
        }
        this.f15245c = false;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void b(FlutterRenderer flutterRenderer) {
        qa.b.f("FlutterSurfaceView", "Attaching to FlutterRenderer.");
        if (this.f15246d != null) {
            qa.b.f("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f15246d.A();
            this.f15246d.u(this.f15248f);
        }
        this.f15246d = flutterRenderer;
        a();
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void c() {
        if (this.f15246d == null) {
            qa.b.g("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.f15245c = true;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void d() {
        if (this.f15246d == null) {
            qa.b.g("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            qa.b.f("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
            m();
        }
        setAlpha(0.0f);
        this.f15246d.u(this.f15248f);
        this.f15246d = null;
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i10 = iArr[0];
        region.op(i10, iArr[1], (getRight() + i10) - getLeft(), (iArr[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public FlutterRenderer getAttachedRenderer() {
        return this.f15246d;
    }

    public final void k(int i10, int i11) {
        if (this.f15246d == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        qa.b.f("FlutterSurfaceView", "Notifying FlutterRenderer that Android surface size has changed to " + i10 + " x " + i11);
        this.f15246d.B(i10, i11);
    }

    public final void l() {
        if (this.f15246d == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.f15246d.z(getHolder().getSurface(), this.f15245c);
    }

    public final void m() {
        FlutterRenderer flutterRenderer = this.f15246d;
        if (flutterRenderer == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        flutterRenderer.A();
    }

    public final void n() {
        if (this.f15243a) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.f15247e);
        setAlpha(0.0f);
    }

    public boolean o() {
        return this.f15244b;
    }

    public final boolean p() {
        return (this.f15246d == null || this.f15245c) ? false : true;
    }
}
