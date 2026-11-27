package n;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class a implements j0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f13340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f13341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Intent f13342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char f13343g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public char f13345i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f13347k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f13348l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f13349m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f13350n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f13351o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13344h = 4096;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13346j = 4096;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ColorStateList f13352p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f13353q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f13354r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f13355s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13356t = 16;

    public a(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.f13348l = context;
        this.f13337a = i11;
        this.f13338b = i10;
        this.f13339c = i13;
        this.f13340d = charSequence;
    }

    @Override // j0.b
    public j0.b a(p0.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // j0.b
    public p0.b b() {
        return null;
    }

    public final void c() {
        Drawable drawable = this.f13347k;
        if (drawable != null) {
            if (this.f13354r || this.f13355s) {
                Drawable drawableR = i0.a.r(drawable);
                this.f13347k = drawableR;
                Drawable drawableMutate = drawableR.mutate();
                this.f13347k = drawableMutate;
                if (this.f13354r) {
                    i0.a.o(drawableMutate, this.f13352p);
                }
                if (this.f13355s) {
                    i0.a.p(this.f13347k, this.f13353q);
                }
            }
        }
    }

    @Override // j0.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // j0.b, android.view.MenuItem
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public j0.b setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // j0.b, android.view.MenuItem
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public j0.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // j0.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // j0.b, android.view.MenuItem
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public j0.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // j0.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // j0.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f13346j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f13345i;
    }

    @Override // j0.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f13350n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f13338b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f13347k;
    }

    @Override // j0.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f13352p;
    }

    @Override // j0.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f13353q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f13342f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f13337a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // j0.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f13344h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f13343g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f13339c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f13340d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f13341e;
        return charSequence != null ? charSequence : this.f13340d;
    }

    @Override // j0.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f13351o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // j0.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f13356t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f13356t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f13356t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f13356t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f13345i = Character.toLowerCase(c10);
        return this;
    }

    @Override // j0.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f13345i = Character.toLowerCase(c10);
        this.f13346j = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f13356t = (z10 ? 1 : 0) | (this.f13356t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f13356t = (z10 ? 2 : 0) | (this.f13356t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public j0.b setContentDescription(CharSequence charSequence) {
        this.f13350n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f13356t = (z10 ? 16 : 0) | (this.f13356t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f13347k = f0.a.getDrawable(this.f13348l, i10);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f13347k = drawable;
        c();
        return this;
    }

    @Override // j0.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f13352p = colorStateList;
        this.f13354r = true;
        c();
        return this;
    }

    @Override // j0.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f13353q = mode;
        this.f13355s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f13342f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f13343g = c10;
        return this;
    }

    @Override // j0.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f13343g = c10;
        this.f13344h = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f13349m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f13343g = c10;
        this.f13345i = Character.toLowerCase(c11);
        return this;
    }

    @Override // j0.b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f13343g = c10;
        this.f13344h = KeyEvent.normalizeMetaState(i10);
        this.f13345i = Character.toLowerCase(c11);
        this.f13346j = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @Override // j0.b, android.view.MenuItem
    public void setShowAsAction(int i10) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f13340d = this.f13348l.getResources().getString(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f13340d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f13341e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public j0.b setTooltipText(CharSequence charSequence) {
        this.f13351o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        this.f13356t = (this.f13356t & 8) | (z10 ? 0 : 8);
        return this;
    }
}
