package m;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes.dex */
public class d extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Configuration f12792f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f12794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f12795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Configuration f12796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Resources f12797e;

    public static class a {
        public static Context a(d dVar, Configuration configuration) {
            return dVar.createConfigurationContext(configuration);
        }
    }

    public d() {
        super(null);
    }

    public d(Context context, int i10) {
        super(context);
        this.f12793a = i10;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f12794b = theme;
    }

    public static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f12792f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f12792f = configuration2;
        }
        return configuration.equals(f12792f);
    }

    public void a(Configuration configuration) {
        if (this.f12797e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f12796d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f12796d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final Resources b() {
        if (this.f12797e == null) {
            Configuration configuration = this.f12796d;
            this.f12797e = (configuration == null || e(configuration)) ? super.getResources() : a.a(this, this.f12796d).getResources();
        }
        return this.f12797e;
    }

    public int c() {
        return this.f12793a;
    }

    public final void d() {
        boolean z10 = this.f12794b == null;
        if (z10) {
            this.f12794b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f12794b.setTo(theme);
            }
        }
        f(this.f12794b, this.f12793a, z10);
    }

    public void f(Resources.Theme theme, int i10, boolean z10) {
        theme.applyStyle(i10, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f12795c == null) {
            this.f12795c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f12795c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f12794b;
        if (theme != null) {
            return theme;
        }
        if (this.f12793a == 0) {
            this.f12793a = h.i.f9417c;
        }
        d();
        return this.f12794b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        if (this.f12793a != i10) {
            this.f12793a = i10;
            d();
        }
    }
}
