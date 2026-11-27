package g1;

import android.text.Editable;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f8486a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Editable.Factory f8487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f8488c;

    public b() {
        try {
            f8488c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f8487b == null) {
            synchronized (f8486a) {
                if (f8487b == null) {
                    f8487b = new b();
                }
            }
        }
        return f8487b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f8488c;
        return cls != null ? e1.h.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
