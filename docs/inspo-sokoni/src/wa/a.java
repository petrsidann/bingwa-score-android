package wa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import java.util.Iterator;
import ub.h;

/* JADX INFO: loaded from: classes2.dex */
public class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FlutterMutatorsStack f17832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f17833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17837f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ra.a f17838l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalFocusChangeListener f17839m;

    /* JADX INFO: renamed from: wa.a$a, reason: collision with other inner class name */
    public class ViewTreeObserverOnGlobalFocusChangeListenerC0314a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnFocusChangeListener f17840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f17841b;

        public ViewTreeObserverOnGlobalFocusChangeListenerC0314a(View.OnFocusChangeListener onFocusChangeListener, View view) {
            this.f17840a = onFocusChangeListener;
            this.f17841b = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f17840a;
            View view3 = this.f17841b;
            onFocusChangeListener.onFocusChange(view3, h.d(view3));
        }
    }

    public a(Context context, float f10, ra.a aVar) {
        super(context, null);
        this.f17833b = f10;
        this.f17838l = aVar;
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f17832a.getFinalMatrix());
        float f10 = this.f17833b;
        matrix.preScale(1.0f / f10, 1.0f / f10);
        matrix.postTranslate(-this.f17834c, -this.f17835d);
        return matrix;
    }

    public void a(FlutterMutatorsStack flutterMutatorsStack, int i10, int i11, int i12, int i13) {
        this.f17832a = flutterMutatorsStack;
        this.f17834c = i10;
        this.f17835d = i11;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i12, i13);
        layoutParams.leftMargin = i10;
        layoutParams.topMargin = i11;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    public void b() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f17839m) == null) {
            return;
        }
        this.f17839m = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.save();
        Iterator<Path> it = this.f17832a.getFinalClippingPaths().iterator();
        while (it.hasNext()) {
            Path path = new Path(it.next());
            path.offset(-this.f17834c, -this.f17835d);
            canvas.clipPath(path);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i10;
        float f10;
        if (this.f17838l == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                f10 = this.f17834c;
                i10 = this.f17835d;
            } else {
                matrix.postTranslate(this.f17836e, this.f17837f);
                this.f17836e = this.f17834c;
                this.f17837f = this.f17835d;
            }
            return this.f17838l.k(motionEvent, matrix);
        }
        int i11 = this.f17834c;
        this.f17836e = i11;
        i10 = this.f17835d;
        this.f17837f = i10;
        f10 = i11;
        matrix.postTranslate(f10, i10);
        return this.f17838l.k(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f17839m == null) {
            ViewTreeObserverOnGlobalFocusChangeListenerC0314a viewTreeObserverOnGlobalFocusChangeListenerC0314a = new ViewTreeObserverOnGlobalFocusChangeListenerC0314a(onFocusChangeListener, this);
            this.f17839m = viewTreeObserverOnGlobalFocusChangeListenerC0314a;
            viewTreeObserver.addOnGlobalFocusChangeListener(viewTreeObserverOnGlobalFocusChangeListenerC0314a);
        }
    }
}
