package eb;

import android.os.Build;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f7715b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.a<Object> f7716a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentLinkedQueue<b> f7717a = new ConcurrentLinkedQueue<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f7718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f7719c;

        /* JADX INFO: renamed from: eb.p$a$a, reason: collision with other inner class name */
        public class C0129a implements fb.a.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f7720a;

            public C0129a(b bVar) {
                this.f7720a = bVar;
            }

            @Override // fb.a.e
            public void a(Object obj) {
                a.this.f7717a.remove(this.f7720a);
                if (a.this.f7717a.isEmpty()) {
                    return;
                }
                qa.b.b("SettingsChannel", "The queue becomes empty after removing config generation " + String.valueOf(this.f7720a.f7723a));
            }
        }

        public static class b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static int f7722c = Integer.MIN_VALUE;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f7723a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DisplayMetrics f7724b;

            public b(DisplayMetrics displayMetrics) {
                int i10 = f7722c;
                f7722c = i10 + 1;
                this.f7723a = i10;
                this.f7724b = displayMetrics;
            }
        }

        public fb.a.e b(b bVar) {
            this.f7717a.add(bVar);
            b bVar2 = this.f7719c;
            this.f7719c = bVar;
            if (bVar2 == null) {
                return null;
            }
            return new C0129a(bVar2);
        }

        public b c(int i10) {
            b bVar;
            StringBuilder sb2;
            String strValueOf;
            if (this.f7718b == null) {
                this.f7718b = this.f7717a.poll();
            }
            while (true) {
                bVar = this.f7718b;
                if (bVar == null || bVar.f7723a >= i10) {
                    break;
                }
                this.f7718b = this.f7717a.poll();
            }
            if (bVar == null) {
                sb2 = new StringBuilder();
                sb2.append("Cannot find config with generation: ");
                sb2.append(String.valueOf(i10));
                strValueOf = ", after exhausting the queue.";
            } else {
                if (bVar.f7723a == i10) {
                    return bVar;
                }
                sb2 = new StringBuilder();
                sb2.append("Cannot find config with generation: ");
                sb2.append(String.valueOf(i10));
                sb2.append(", the oldest config is now: ");
                strValueOf = String.valueOf(this.f7718b.f7723a);
            }
            sb2.append(strValueOf);
            qa.b.b("SettingsChannel", sb2.toString());
            return null;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fb.a<Object> f7725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, Object> f7726b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public DisplayMetrics f7727c;

        public b(fb.a<Object> aVar) {
            this.f7725a = aVar;
        }

        public void a() {
            qa.b.f("SettingsChannel", "Sending message: \ntextScaleFactor: " + this.f7726b.get("textScaleFactor") + "\nalwaysUse24HourFormat: " + this.f7726b.get("alwaysUse24HourFormat") + "\nplatformBrightness: " + this.f7726b.get("platformBrightness"));
            DisplayMetrics displayMetrics = this.f7727c;
            if (!p.c() || displayMetrics == null) {
                this.f7725a.c(this.f7726b);
                return;
            }
            a.b bVar = new a.b(displayMetrics);
            fb.a.e<Object> eVarB = p.f7715b.b(bVar);
            this.f7726b.put("configurationId", Integer.valueOf(bVar.f7723a));
            this.f7725a.d(this.f7726b, eVarB);
        }

        public b b(boolean z10) {
            this.f7726b.put("brieflyShowPassword", Boolean.valueOf(z10));
            return this;
        }

        public b c(DisplayMetrics displayMetrics) {
            this.f7727c = displayMetrics;
            return this;
        }

        public b d(boolean z10) {
            this.f7726b.put("nativeSpellCheckServiceDefined", Boolean.valueOf(z10));
            return this;
        }

        public b e(c cVar) {
            this.f7726b.put("platformBrightness", cVar.f7731a);
            return this;
        }

        public b f(float f10) {
            this.f7726b.put("textScaleFactor", Float.valueOf(f10));
            return this;
        }

        public b g(boolean z10) {
            this.f7726b.put("alwaysUse24HourFormat", Boolean.valueOf(z10));
            return this;
        }
    }

    public enum c {
        light("light"),
        dark("dark");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7731a;

        c(String str) {
            this.f7731a = str;
        }
    }

    public p(ta.a aVar) {
        this.f7716a = new fb.a<>(aVar, "flutter/settings", fb.e.f8282a);
    }

    public static DisplayMetrics b(int i10) {
        a.b bVarC = f7715b.c(i10);
        if (bVarC == null) {
            return null;
        }
        return bVarC.f7724b;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 34;
    }

    public b d() {
        return new b(this.f7716a);
    }
}
