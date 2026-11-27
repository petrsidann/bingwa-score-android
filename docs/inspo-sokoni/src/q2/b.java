package q2;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.inputmethodservice.InputMethodService;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14626a = new b();

    public final Context a(Context context) {
        k.e(context, "context");
        Context baseContext = context;
        while (baseContext instanceof ContextWrapper) {
            if ((baseContext instanceof Activity) || (baseContext instanceof InputMethodService)) {
                return baseContext;
            }
            ContextWrapper contextWrapper = (ContextWrapper) baseContext;
            if (contextWrapper.getBaseContext() == null) {
                return baseContext;
            }
            baseContext = contextWrapper.getBaseContext();
            k.d(baseContext, "iterator.baseContext");
        }
        throw new IllegalArgumentException("Context " + context + " is not a UiContext");
    }
}
