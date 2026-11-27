package g2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import g0.h;
import g0.l;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class c extends e implements Animatable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0149c f8524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f8525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArgbEvaluator f8526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f8527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator.AnimatorListener f8528f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList<g2.b> f8529l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Drawable.Callback f8530m;

    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            c.this.scheduleSelf(runnable, j10);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f8529l);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((g2.b) arrayList.get(i10)).b(c.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f8529l);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((g2.b) arrayList.get(i10)).c(c.this);
            }
        }
    }

    /* JADX INFO: renamed from: g2.c$c, reason: collision with other inner class name */
    public static class C0149c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f f8534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AnimatorSet f8535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList<Animator> f8536d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public t.a<Animator, String> f8537e;

        public C0149c(Context context, C0149c c0149c, Drawable.Callback callback, Resources resources) {
            if (c0149c != null) {
                this.f8533a = c0149c.f8533a;
                f fVar = c0149c.f8534b;
                if (fVar != null) {
                    Drawable.ConstantState constantState = fVar.getConstantState();
                    this.f8534b = (f) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    f fVar2 = (f) this.f8534b.mutate();
                    this.f8534b = fVar2;
                    fVar2.setCallback(callback);
                    this.f8534b.setBounds(c0149c.f8534b.getBounds());
                    this.f8534b.g(false);
                }
                ArrayList<Animator> arrayList = c0149c.f8536d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f8536d = new ArrayList<>(size);
                    this.f8537e = new t.a<>(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        Animator animator = c0149c.f8536d.get(i10);
                        Animator animatorClone = animator.clone();
                        String str = c0149c.f8537e.get(animator);
                        animatorClone.setTarget(this.f8534b.c(str));
                        this.f8536d.add(animatorClone);
                        this.f8537e.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f8535c == null) {
                this.f8535c = new AnimatorSet();
            }
            this.f8535c.playTogether(this.f8536d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f8533a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public static class d extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f8538a;

        public d(Drawable.ConstantState constantState) {
            this.f8538a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f8538a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f8538a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f8538a.newDrawable();
            cVar.f8539a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f8530m);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f8538a.newDrawable(resources);
            cVar.f8539a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f8530m);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f8538a.newDrawable(resources, theme);
            cVar.f8539a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f8530m);
            return cVar;
        }
    }

    public c() {
        this(null, null, null);
    }

    public c(Context context) {
        this(context, null, null);
    }

    public c(Context context, C0149c c0149c, Resources resources) {
        this.f8526d = null;
        this.f8528f = null;
        this.f8529l = null;
        a aVar = new a();
        this.f8530m = aVar;
        this.f8525c = context;
        if (c0149c != null) {
            this.f8524b = c0149c;
        } else {
            this.f8524b = new C0149c(context, c0149c, aVar, resources);
        }
    }

    public static c a(Context context, int i10) {
        c cVar = new c(context);
        Drawable drawableE = h.e(context.getResources(), i10, context.getTheme());
        cVar.f8539a = drawableE;
        drawableE.setCallback(cVar.f8530m);
        cVar.f8527e = new d(cVar.f8539a.getConstantState());
        return cVar;
    }

    public static void c(AnimatedVectorDrawable animatedVectorDrawable, g2.b bVar) {
        animatedVectorDrawable.registerAnimationCallback(bVar.a());
    }

    public static boolean g(AnimatedVectorDrawable animatedVectorDrawable, g2.b bVar) {
        return animatedVectorDrawable.unregisterAnimationCallback(bVar.a());
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            i0.a.a(drawable, theme);
        }
    }

    public void b(g2.b bVar) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            c((AnimatedVectorDrawable) drawable, bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        if (this.f8529l == null) {
            this.f8529l = new ArrayList<>();
        }
        if (this.f8529l.contains(bVar)) {
            return;
        }
        this.f8529l.add(bVar);
        if (this.f8528f == null) {
            this.f8528f = new b();
        }
        this.f8524b.f8535c.addListener(this.f8528f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            return i0.a.b(drawable);
        }
        return false;
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final void d() {
        Animator.AnimatorListener animatorListener = this.f8528f;
        if (animatorListener != null) {
            this.f8524b.f8535c.removeListener(animatorListener);
            this.f8528f = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f8524b.f8534b.draw(canvas);
        if (this.f8524b.f8535c.isStarted()) {
            invalidateSelf();
        }
    }

    public final void e(String str, Animator animator) {
        animator.setTarget(this.f8524b.f8534b.c(str));
        C0149c c0149c = this.f8524b;
        if (c0149c.f8536d == null) {
            c0149c.f8536d = new ArrayList<>();
            this.f8524b.f8537e = new t.a<>();
        }
        this.f8524b.f8536d.add(animator);
        this.f8524b.f8537e.put(animator, str);
    }

    public boolean f(g2.b bVar) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            g((AnimatedVectorDrawable) drawable, bVar);
        }
        ArrayList<g2.b> arrayList = this.f8529l;
        if (arrayList == null || bVar == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(bVar);
        if (this.f8529l.size() == 0) {
            d();
        }
        return zRemove;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f8539a;
        return drawable != null ? i0.a.d(drawable) : this.f8524b.f8534b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f8539a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f8524b.f8533a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f8539a;
        return drawable != null ? i0.a.e(drawable) : this.f8524b.f8534b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f8539a != null) {
            return new d(this.f8539a.getConstantState());
        }
        return null;
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f8539a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f8524b.f8534b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f8539a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f8524b.f8534b.getIntrinsicWidth();
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f8539a;
        return drawable != null ? drawable.getOpacity() : this.f8524b.f8534b.getOpacity();
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes;
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            i0.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    typedArrayObtainAttributes = l.i(resources, theme, attributeSet, g2.a.f8514e);
                    int resourceId = typedArrayObtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f fVarB = f.b(resources, resourceId, theme);
                        fVarB.g(false);
                        fVarB.setCallback(this.f8530m);
                        f fVar = this.f8524b.f8534b;
                        if (fVar != null) {
                            fVar.setCallback(null);
                        }
                        this.f8524b.f8534b = fVarB;
                    }
                } else if ("target".equals(name)) {
                    typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, g2.a.f8515f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f8525c;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        e(string, g2.d.a(context, resourceId2));
                    }
                } else {
                    continue;
                }
                typedArrayObtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.f8524b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f8539a;
        return drawable != null ? i0.a.h(drawable) : this.f8524b.f8534b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f8539a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f8524b.f8535c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f8539a;
        return drawable != null ? drawable.isStateful() : this.f8524b.f8534b.isStateful();
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f8524b.f8534b.setBounds(rect);
        }
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f8539a;
        return drawable != null ? drawable.setLevel(i10) : this.f8524b.f8534b.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f8539a;
        return drawable != null ? drawable.setState(iArr) : this.f8524b.f8534b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f8524b.f8534b.setAlpha(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            i0.a.j(drawable, z10);
        } else {
            this.f8524b.f8534b.setAutoMirrored(z10);
        }
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f8524b.f8534b.setColorFilter(colorFilter);
        }
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // g2.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            i0.a.n(drawable, i10);
        } else {
            this.f8524b.f8534b.setTint(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            i0.a.o(drawable, colorStateList);
        } else {
            this.f8524b.f8534b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            i0.a.p(drawable, mode);
        } else {
            this.f8524b.f8534b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f8524b.f8534b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f8524b.f8535c.isStarted()) {
                return;
            }
            this.f8524b.f8535c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f8539a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f8524b.f8535c.end();
        }
    }
}
