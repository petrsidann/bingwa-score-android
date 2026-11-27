package e0;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class k extends Activity implements androidx.lifecycle.k, p0.s.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t.g<Class<Object>, Object> f6801a = new t.g<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.lifecycle.l f6802b = new androidx.lifecycle.l(this);

    public static boolean x(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return false;
        }
        String str = strArr[0];
        str.hashCode();
        switch (str) {
            case "--translation":
                return Build.VERSION.SDK_INT >= 31;
            case "--dump-dumpable":
            case "--list-dumpables":
                return Build.VERSION.SDK_INT >= 33;
            case "--contentcapture":
                return Build.VERSION.SDK_INT >= 29;
            case "--autofill":
                return true;
            default:
                return false;
        }
    }

    public androidx.lifecycle.g a() {
        return this.f6802b;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !p0.s.d(decorView, keyEvent)) {
            return p0.s.e(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !p0.s.d(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // p0.s.a
    public boolean n(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.x.e(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f6802b.j(androidx.lifecycle.g.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public final boolean w(String[] strArr) {
        return !x(strArr);
    }
}
