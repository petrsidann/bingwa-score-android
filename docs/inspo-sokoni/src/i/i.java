package i;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import p0.s;

/* JADX INFO: loaded from: classes.dex */
public class i extends d.k implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f10048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s.a f10049e;

    public i(Context context, int i10) {
        super(context, i(context, i10));
        this.f10049e = new s.a() { // from class: i.h
            @Override // p0.s.a
            public final boolean n(KeyEvent keyEvent) {
                return this.f10047a.j(keyEvent);
            }
        };
        e eVarG = g();
        eVarG.L(i(context, i10));
        eVarG.x(null);
    }

    public static int i(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(h.a.f9311z, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // d.k, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g().e(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        g().y();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return s.e(this.f10049e, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // i.c
    public void f(m.b bVar) {
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i10) {
        return (T) g().j(i10);
    }

    public e g() {
        if (this.f10048d == null) {
            this.f10048d = e.i(this, this);
        }
        return this.f10048d;
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        g().t();
    }

    boolean j(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean k(int i10) {
        return g().G(i10);
    }

    @Override // i.c
    public void o(m.b bVar) {
    }

    @Override // d.k, android.app.Dialog
    public void onCreate(Bundle bundle) {
        g().s();
        super.onCreate(bundle);
        g().x(bundle);
    }

    @Override // d.k, android.app.Dialog
    public void onStop() {
        super.onStop();
        g().D();
    }

    @Override // i.c
    public m.b q(m.b.a aVar) {
        return null;
    }

    @Override // d.k, android.app.Dialog
    public void setContentView(int i10) {
        g().H(i10);
    }

    @Override // d.k, android.app.Dialog
    public void setContentView(View view) {
        g().I(view);
    }

    @Override // d.k, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g().J(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i10) {
        super.setTitle(i10);
        g().M(getContext().getString(i10));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        g().M(charSequence);
    }
}
