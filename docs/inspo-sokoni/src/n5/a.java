package n5;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Dialog f13425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13428d;

    public a(Dialog dialog, Rect rect) {
        this.f13425a = dialog;
        this.f13426b = rect.left;
        this.f13427c = rect.top;
        this.f13428d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.f13426b + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        int top = this.f13427c + viewFindViewById.getTop();
        if (new RectF(left, top, width, viewFindViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i10 = this.f13428d;
            motionEventObtain.setLocation((-i10) - 1, (-i10) - 1);
        }
        view.performClick();
        return this.f13425a.onTouchEvent(motionEventObtain);
    }
}
