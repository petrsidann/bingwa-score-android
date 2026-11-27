package j5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import java.util.List;
import q0.p;
import s5.g;
import z4.j;

/* JADX INFO: loaded from: classes.dex */
public class b extends g {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f11249n = j.f19960n;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11251f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d f11252l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f11253m;

    public class a implements d {
        public a(c cVar) {
        }
    }

    /* JADX INFO: renamed from: j5.b$b, reason: collision with other inner class name */
    public static class C0183b extends ViewGroup.MarginLayoutParams {
        public C0183b(int i10, int i11) {
            super(i10, i11);
        }

        public C0183b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0183b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @Deprecated
    public interface c {
    }

    public interface d {
    }

    public class e implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ ViewGroup.OnHierarchyChangeListener a(e eVar, ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
            throw null;
        }
    }

    private int getVisibleChipCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof Chip) && e(i11)) {
                i10++;
            }
        }
        return i10;
    }

    @Override // s5.g
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0183b);
    }

    public int d(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if ((childAt instanceof Chip) && e(i11)) {
                if (((Chip) childAt) == view) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    public final boolean e(int i10) {
        return getChildAt(i10).getVisibility() == 0;
    }

    public boolean f() {
        throw null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0183b(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0183b(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0183b(layoutParams);
    }

    public int getCheckedChipId() {
        throw null;
    }

    public List<Integer> getCheckedChipIds() {
        throw null;
    }

    public int getChipSpacingHorizontal() {
        return this.f11250e;
    }

    public int getChipSpacingVertical() {
        return this.f11251f;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.f11253m != -1) {
            throw null;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        p.D0(accessibilityNodeInfo).f0(p.f.a(getRowCount(), c() ? getVisibleChipCount() : -1, false, f() ? 1 : 2));
    }

    public void setChipSpacing(int i10) {
        setChipSpacingHorizontal(i10);
        setChipSpacingVertical(i10);
    }

    public void setChipSpacingHorizontal(int i10) {
        if (this.f11250e != i10) {
            this.f11250e = i10;
            setItemSpacing(i10);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i10) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i10));
    }

    public void setChipSpacingResource(int i10) {
        setChipSpacing(getResources().getDimensionPixelOffset(i10));
    }

    public void setChipSpacingVertical(int i10) {
        if (this.f11251f != i10) {
            this.f11251f = i10;
            setLineSpacing(i10);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i10) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i10));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i10) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(c cVar) {
        if (cVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new a(cVar));
        }
    }

    public void setOnCheckedStateChangeListener(d dVar) {
        this.f11252l = dVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        e.a(null, onHierarchyChangeListener);
    }

    public void setSelectionRequired(boolean z10) {
        throw null;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i10) {
        setSingleLine(getResources().getBoolean(i10));
    }

    @Override // s5.g
    public void setSingleLine(boolean z10) {
        super.setSingleLine(z10);
    }

    public void setSingleSelection(int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }

    public void setSingleSelection(boolean z10) {
        throw null;
    }
}
