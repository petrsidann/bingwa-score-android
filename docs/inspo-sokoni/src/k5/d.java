package k5;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
public interface d {

    public static class b implements TypeEvaluator<e> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f11525b = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f11526a = new e();

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f10, e eVar, e eVar2) {
            this.f11526a.a(t5.a.c(eVar.f11529a, eVar2.f11529a, f10), t5.a.c(eVar.f11530b, eVar2.f11530b, f10), t5.a.c(eVar.f11531c, eVar2.f11531c, f10));
            return this.f11526a;
        }
    }

    public static class c extends Property<d, e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<d, e> f11527a = new c("circularReveal");

        public c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* JADX INFO: renamed from: k5.d$d, reason: collision with other inner class name */
    public static class C0195d extends Property<d, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<d, Integer> f11528a = new C0195d("circularRevealScrimColor");

        public C0195d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f11529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f11530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f11531c;

        public e() {
        }

        public e(float f10, float f11, float f12) {
            this.f11529a = f10;
            this.f11530b = f11;
            this.f11531c = f12;
        }

        public void a(float f10, float f11, float f12) {
            this.f11529a = f10;
            this.f11530b = f11;
            this.f11531c = f12;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i10);

    void setRevealInfo(e eVar);
}
