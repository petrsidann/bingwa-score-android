package x5;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import z5.g;
import z5.k;
import z5.n;

/* JADX INFO: loaded from: classes.dex */
public class a extends Drawable implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f17991a;

    public static final class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f17992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f17993b;

        public b(b bVar) {
            this.f17992a = (g) bVar.f17992a.getConstantState().newDrawable();
            this.f17993b = bVar.f17993b;
        }

        public b(g gVar) {
            this.f17992a = gVar;
            this.f17993b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }

    public a(b bVar) {
        this.f17991a = bVar;
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }

    @Override // android.graphics.drawable.Drawable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.f17991a = new b(this.f17991a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f17991a;
        if (bVar.f17993b) {
            bVar.f17992a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f17991a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f17991a.f17992a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f17991a.f17992a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f17991a.f17992a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zB = x5.b.b(iArr);
        b bVar = this.f17991a;
        if (bVar.f17993b == zB) {
            return zOnStateChange;
        }
        bVar.f17993b = zB;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f17991a.f17992a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f17991a.f17992a.setColorFilter(colorFilter);
    }

    @Override // z5.n
    public void setShapeAppearanceModel(k kVar) {
        this.f17991a.f17992a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        this.f17991a.f17992a.setTint(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f17991a.f17992a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f17991a.f17992a.setTintMode(mode);
    }
}
