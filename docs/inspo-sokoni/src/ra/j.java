package ra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import android.view.View;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class j extends View implements io.flutter.embedding.engine.renderer.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageReader f15233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Image f15234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f15235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlutterRenderer f15236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f15237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15238f;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15239a;

        static {
            int[] iArr = new int[b.values().length];
            f15239a = iArr;
            try {
                iArr[b.background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15239a[b.overlay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        background,
        overlay
    }

    public j(Context context, int i10, int i11, b bVar) {
        this(context, h(i10, i11), bVar);
    }

    public j(Context context, ImageReader imageReader, b bVar) {
        super(context, null);
        this.f15238f = false;
        this.f15233a = imageReader;
        this.f15237e = bVar;
        i();
    }

    public static ImageReader h(int i10, int i11) {
        int i12;
        int i13;
        if (i10 <= 0) {
            j("ImageReader width must be greater than 0, but given width=%d, set width=1", Integer.valueOf(i10));
            i12 = 1;
        } else {
            i12 = i10;
        }
        if (i11 <= 0) {
            j("ImageReader height must be greater than 0, but given height=%d, set height=1", Integer.valueOf(i11));
            i13 = 1;
        } else {
            i13 = i11;
        }
        return Build.VERSION.SDK_INT >= 29 ? ImageReader.newInstance(i12, i13, 1, 3, 768L) : ImageReader.newInstance(i12, i13, 1, 3);
    }

    public static void j(String str, Object... objArr) {
        qa.b.g("FlutterImageView", String.format(Locale.US, str, objArr));
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void a() {
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void b(FlutterRenderer flutterRenderer) {
        if (a.f15239a[this.f15237e.ordinal()] == 1) {
            flutterRenderer.C(this.f15233a.getSurface());
        }
        setAlpha(1.0f);
        this.f15236d = flutterRenderer;
        this.f15238f = true;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void c() {
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void d() {
        if (this.f15238f) {
            setAlpha(0.0f);
            e();
            this.f15235c = null;
            f();
            invalidate();
            this.f15238f = false;
        }
    }

    public boolean e() {
        if (!this.f15238f) {
            return false;
        }
        Image imageAcquireLatestImage = this.f15233a.acquireLatestImage();
        if (imageAcquireLatestImage != null) {
            f();
            this.f15234b = imageAcquireLatestImage;
            invalidate();
        }
        return imageAcquireLatestImage != null;
    }

    public final void f() {
        Image image = this.f15234b;
        if (image != null) {
            image.close();
            this.f15234b = null;
        }
    }

    public void g() {
        this.f15233a.close();
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public FlutterRenderer getAttachedRenderer() {
        return this.f15236d;
    }

    public ImageReader getImageReader() {
        return this.f15233a;
    }

    public Surface getSurface() {
        return this.f15233a.getSurface();
    }

    public final void i() {
        setAlpha(0.0f);
    }

    public void k(int i10, int i11) {
        if (this.f15236d == null) {
            return;
        }
        if (i10 == this.f15233a.getWidth() && i11 == this.f15233a.getHeight()) {
            return;
        }
        f();
        g();
        this.f15233a = h(i10, i11);
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 29) {
            HardwareBuffer hardwareBuffer = this.f15234b.getHardwareBuffer();
            this.f15235c = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.f15234b.getPlanes();
        if (planes.length != 1) {
            return;
        }
        Image.Plane plane = planes[0];
        int rowStride = plane.getRowStride() / plane.getPixelStride();
        int height = this.f15234b.getHeight();
        Bitmap bitmap = this.f15235c;
        if (bitmap == null || bitmap.getWidth() != rowStride || this.f15235c.getHeight() != height) {
            this.f15235c = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
        }
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        this.f15235c.copyPixelsFromBuffer(buffer);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f15234b != null) {
            l();
        }
        Bitmap bitmap = this.f15235c;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        if (!(i10 == this.f15233a.getWidth() && i11 == this.f15233a.getHeight()) && this.f15237e == b.background && this.f15238f) {
            k(i10, i11);
            this.f15236d.C(this.f15233a.getSurface());
        }
    }
}
