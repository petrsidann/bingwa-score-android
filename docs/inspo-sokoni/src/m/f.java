package m;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f12806b;

    public static class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f12807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f12808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<f> f12809c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final t.g<Menu, Menu> f12810d = new t.g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f12808b = context;
            this.f12807a = callback;
        }

        @Override // m.b.a
        public void a(b bVar) {
            this.f12807a.onDestroyActionMode(e(bVar));
        }

        @Override // m.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f12807a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // m.b.a
        public boolean c(b bVar, Menu menu) {
            return this.f12807a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // m.b.a
        public boolean d(b bVar, MenuItem menuItem) {
            return this.f12807a.onActionItemClicked(e(bVar), new n.c(this.f12808b, (j0.b) menuItem));
        }

        public ActionMode e(b bVar) {
            int size = this.f12809c.size();
            for (int i10 = 0; i10 < size; i10++) {
                f fVar = this.f12809c.get(i10);
                if (fVar != null && fVar.f12806b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f12808b, bVar);
            this.f12809c.add(fVar2);
            return fVar2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = this.f12810d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            n.e eVar = new n.e(this.f12808b, (j0.a) menu);
            this.f12810d.put(menu, eVar);
            return eVar;
        }
    }

    public f(Context context, b bVar) {
        this.f12805a = context;
        this.f12806b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f12806b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f12806b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new n.e(this.f12805a, (j0.a) this.f12806b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f12806b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f12806b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f12806b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f12806b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f12806b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f12806b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f12806b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f12806b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i10) {
        this.f12806b.n(i10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f12806b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f12806b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i10) {
        this.f12806b.q(i10);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f12806b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z10) {
        this.f12806b.s(z10);
    }
}
