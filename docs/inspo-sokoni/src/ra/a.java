package ra;

import android.content.Context;
import android.graphics.Matrix;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Matrix f15178e = new Matrix();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterRenderer f15179a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, float[]> f15182d = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f15180b = b0.a();

    public a(FlutterRenderer flutterRenderer, boolean z10) {
        this.f15179a = flutterRenderer;
        this.f15181c = z10;
    }

    public final void a(MotionEvent motionEvent, int i10, int i11, int i12, Matrix matrix, ByteBuffer byteBuffer) {
        b(motionEvent, i10, i11, i12, matrix, byteBuffer, null);
    }

    public final void b(MotionEvent motionEvent, int i10, int i11, int i12, Matrix matrix, ByteBuffer byteBuffer, Context context) {
        long buttonState;
        long j10;
        double d10;
        double max;
        double min;
        double d11;
        double d12;
        double dC;
        double dG;
        InputDevice.MotionRange motionRange;
        int i13 = -1;
        if (i11 == -1) {
            return;
        }
        int pointerId = motionEvent.getPointerId(i10);
        int iF = f(motionEvent.getToolType(i10));
        float[] fArr = {motionEvent.getX(i10), motionEvent.getY(i10)};
        matrix.mapPoints(fArr);
        if (iF == 1) {
            buttonState = motionEvent.getButtonState() & 31;
            if (buttonState == 0 && motionEvent.getSource() == 8194 && i11 == 4) {
                this.f15182d.put(Integer.valueOf(pointerId), fArr);
            }
        } else {
            buttonState = iF == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
        }
        boolean zContainsKey = this.f15182d.containsKey(Integer.valueOf(pointerId));
        if (zContainsKey) {
            int iE = e(i11);
            if (iE == -1) {
                return;
            } else {
                i13 = iE;
            }
        }
        long jD = this.f15181c ? this.f15180b.c(motionEvent).d() : 0L;
        int i14 = motionEvent.getActionMasked() == 8 ? 1 : 0;
        int i15 = i13;
        long eventTime = motionEvent.getEventTime() * 1000;
        byteBuffer.putLong(jD);
        byteBuffer.putLong(eventTime);
        if (zContainsKey) {
            byteBuffer.putLong(i15);
            j10 = 4;
        } else {
            byteBuffer.putLong(i11);
            j10 = iF;
        }
        byteBuffer.putLong(j10);
        byteBuffer.putLong(i14);
        byteBuffer.putLong(pointerId);
        byteBuffer.putLong(0L);
        if (zContainsKey) {
            float[] fArr2 = this.f15182d.get(Integer.valueOf(pointerId));
            byteBuffer.putDouble(fArr2[0]);
            d10 = fArr2[1];
        } else {
            byteBuffer.putDouble(fArr[0]);
            d10 = fArr[1];
        }
        byteBuffer.putDouble(d10);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putLong(buttonState);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getPressure(i10));
        if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
            max = 1.0d;
            min = 0.0d;
        } else {
            min = motionRange.getMin();
            max = motionRange.getMax();
        }
        byteBuffer.putDouble(min);
        byteBuffer.putDouble(max);
        if (iF == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(24, i10));
            d11 = 0.0d;
        } else {
            d11 = 0.0d;
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d11);
        byteBuffer.putDouble(motionEvent.getSize(i10));
        byteBuffer.putDouble(motionEvent.getToolMajor(i10));
        byteBuffer.putDouble(motionEvent.getToolMinor(i10));
        byteBuffer.putDouble(d11);
        byteBuffer.putDouble(d11);
        byteBuffer.putDouble(motionEvent.getAxisValue(8, i10));
        if (iF == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(25, i10));
        } else {
            byteBuffer.putDouble(d11);
        }
        byteBuffer.putLong(i12);
        if (i14 == 1) {
            if (context != null) {
                dC = c(context);
                dG = g(context);
            } else {
                dC = 48.0d;
                dG = 48.0d;
            }
            double d13 = dC * ((double) (-motionEvent.getAxisValue(10, i10)));
            double d14 = dG * ((double) (-motionEvent.getAxisValue(9, i10)));
            byteBuffer.putDouble(d13);
            byteBuffer.putDouble(d14);
        } else {
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        if (zContainsKey) {
            float[] fArr3 = this.f15182d.get(Integer.valueOf(pointerId));
            byteBuffer.putDouble(fArr[0] - fArr3[0]);
            byteBuffer.putDouble(fArr[1] - fArr3[1]);
            d12 = 0.0d;
        } else {
            d12 = 0.0d;
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d12);
        byteBuffer.putDouble(d12);
        byteBuffer.putDouble(1.0d);
        byteBuffer.putDouble(d12);
        byteBuffer.putLong(0L);
        if (zContainsKey && i15 == 9) {
            this.f15182d.remove(Integer.valueOf(pointerId));
        }
    }

    public final float c(Context context) {
        return ViewConfiguration.get(context).getScaledHorizontalScrollFactor();
    }

    public final int d(int i10) {
        if (i10 == 0) {
            return 4;
        }
        if (i10 == 1) {
            return 6;
        }
        if (i10 == 5) {
            return 4;
        }
        if (i10 == 6) {
            return 6;
        }
        if (i10 == 2) {
            return 5;
        }
        if (i10 == 7) {
            return 3;
        }
        if (i10 == 3) {
            return 0;
        }
        return i10 == 8 ? 3 : -1;
    }

    public final int e(int i10) {
        if (i10 == 4) {
            return 7;
        }
        if (i10 == 5) {
            return 8;
        }
        return (i10 == 6 || i10 == 0) ? 9 : -1;
    }

    public final int f(int i10) {
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 2;
        }
        if (i10 != 3) {
            return i10 != 4 ? 5 : 3;
        }
        return 1;
    }

    public final float g(Context context) {
        return h(context);
    }

    public final float h(Context context) {
        return ViewConfiguration.get(context).getScaledVerticalScrollFactor();
    }

    public boolean i(MotionEvent motionEvent, Context context) {
        boolean zIsFromSource = motionEvent.isFromSource(2);
        boolean z10 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!zIsFromSource || !z10) {
            return false;
        }
        int iD = d(motionEvent.getActionMasked());
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 36 * 8);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        b(motionEvent, motionEvent.getActionIndex(), iD, 0, f15178e, byteBufferAllocateDirect, context);
        if (byteBufferAllocateDirect.position() % 288 != 0) {
            throw new AssertionError("Packet position is not on field boundary.");
        }
        this.f15179a.m(byteBufferAllocateDirect, byteBufferAllocateDirect.position());
        return true;
    }

    public boolean j(MotionEvent motionEvent) {
        return k(motionEvent, f15178e);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00bb  */
    public boolean k(MotionEvent motionEvent, Matrix matrix) {
        int actionIndex;
        int i10;
        int i11;
        int actionMasked = motionEvent.getActionMasked();
        int iD = d(motionEvent.getActionMasked());
        boolean z10 = actionMasked == 0 || actionMasked == 5;
        boolean z11 = !z10 && (actionMasked == 1 || actionMasked == 6);
        int i12 = (z11 && f(motionEvent.getToolType(motionEvent.getActionIndex())) == 0) ? 1 : 0;
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((pointerCount + i12) * 36 * 8);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        if (!z10) {
            if (z11) {
                for (int i13 = 0; i13 < pointerCount; i13++) {
                    if (i13 != motionEvent.getActionIndex() && motionEvent.getToolType(i13) == 1) {
                        a(motionEvent, i13, 5, 1, matrix, byteBufferAllocateDirect);
                    }
                }
                a(motionEvent, motionEvent.getActionIndex(), iD, 0, matrix, byteBufferAllocateDirect);
                if (i12 != 0) {
                    actionIndex = motionEvent.getActionIndex();
                    i10 = 2;
                    i11 = 0;
                }
            } else {
                for (int i14 = 0; i14 < pointerCount; i14++) {
                    a(motionEvent, i14, iD, 0, matrix, byteBufferAllocateDirect);
                }
            }
            if (byteBufferAllocateDirect.position() % 288 == 0) {
                throw new AssertionError("Packet position is not on field boundary");
            }
            this.f15179a.m(byteBufferAllocateDirect, byteBufferAllocateDirect.position());
            return true;
        }
        actionIndex = motionEvent.getActionIndex();
        i11 = 0;
        i10 = iD;
        a(motionEvent, actionIndex, i10, i11, matrix, byteBufferAllocateDirect);
        if (byteBufferAllocateDirect.position() % 288 == 0) {
            throw new AssertionError("Packet position is not on field boundary");
        }
        this.f15179a.m(byteBufferAllocateDirect, byteBufferAllocateDirect.position());
        return true;
    }
}
