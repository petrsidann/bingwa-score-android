package r;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f14970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f14971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f14972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f14973d;

    /* JADX INFO: renamed from: r.a$a, reason: collision with other inner class name */
    public static final class C0263a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f14974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f14975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f14976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f14977d;

        public a a() {
            return new a(this.f14974a, this.f14975b, this.f14976c, this.f14977d);
        }
    }

    public a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f14970a = num;
        this.f14971b = num2;
        this.f14972c = num3;
        this.f14973d = num4;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f14970a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f14971b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f14972c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f14973d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
