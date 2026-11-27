package m;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.widget.h1;
import androidx.appcompat.widget.l0;
import h.j;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p0.x;

/* JADX INFO: loaded from: classes.dex */
public class g extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Class<?>[] f12811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class<?>[] f12812f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f12813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f12814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f12815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f12816d;

    public static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class<?>[] f12817c = {MenuItem.class};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f12818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f12819b;

        public a(Object obj, String str) {
            this.f12818a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f12819b = cls.getMethod(str, f12817c);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f12819b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f12819b.invoke(this.f12818a, menuItem)).booleanValue();
                }
                this.f12819b.invoke(this.f12818a, menuItem);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public class b {
        public p0.b A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Menu f12820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f12825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f12826g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f12827h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f12828i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f12829j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f12830k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f12831l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f12832m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public char f12833n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f12834o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public char f12835p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f12836q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f12837r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f12838s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f12839t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f12840u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f12841v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f12842w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f12843x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f12844y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f12845z;

        public b(Menu menu) {
            this.f12820a = menu;
            h();
        }

        public void a() {
            this.f12827h = true;
            i(this.f12820a.add(this.f12821b, this.f12828i, this.f12829j, this.f12830k));
        }

        public SubMenu b() {
            this.f12827h = true;
            SubMenu subMenuAddSubMenu = this.f12820a.addSubMenu(this.f12821b, this.f12828i, this.f12829j, this.f12830k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public final char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        public boolean d() {
            return this.f12827h;
        }

        public final <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f12815c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e10) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.f12815c.obtainStyledAttributes(attributeSet, j.f9490o1);
            this.f12821b = typedArrayObtainStyledAttributes.getResourceId(j.f9500q1, 0);
            this.f12822c = typedArrayObtainStyledAttributes.getInt(j.f9510s1, 0);
            this.f12823d = typedArrayObtainStyledAttributes.getInt(j.f9515t1, 0);
            this.f12824e = typedArrayObtainStyledAttributes.getInt(j.f9520u1, 0);
            this.f12825f = typedArrayObtainStyledAttributes.getBoolean(j.f9505r1, true);
            this.f12826g = typedArrayObtainStyledAttributes.getBoolean(j.f9495p1, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void g(AttributeSet attributeSet) {
            h1 h1VarU = h1.u(g.this.f12815c, attributeSet, j.f9525v1);
            this.f12828i = h1VarU.n(j.f9540y1, 0);
            this.f12829j = (h1VarU.k(j.B1, this.f12822c) & (-65536)) | (h1VarU.k(j.C1, this.f12823d) & 65535);
            this.f12830k = h1VarU.p(j.D1);
            this.f12831l = h1VarU.p(j.E1);
            this.f12832m = h1VarU.n(j.f9530w1, 0);
            this.f12833n = c(h1VarU.o(j.F1));
            this.f12834o = h1VarU.k(j.M1, 4096);
            this.f12835p = c(h1VarU.o(j.G1));
            this.f12836q = h1VarU.k(j.Q1, 4096);
            int i10 = j.H1;
            this.f12837r = h1VarU.s(i10) ? h1VarU.a(i10, false) : this.f12824e;
            this.f12838s = h1VarU.a(j.f9545z1, false);
            this.f12839t = h1VarU.a(j.A1, this.f12825f);
            this.f12840u = h1VarU.a(j.f9535x1, this.f12826g);
            this.f12841v = h1VarU.k(j.R1, -1);
            this.f12845z = h1VarU.o(j.I1);
            this.f12842w = h1VarU.n(j.J1, 0);
            this.f12843x = h1VarU.o(j.L1);
            String strO = h1VarU.o(j.K1);
            this.f12844y = strO;
            boolean z10 = strO != null;
            if (z10 && this.f12842w == 0 && this.f12843x == null) {
                this.A = (p0.b) e(strO, g.f12812f, g.this.f12814b);
            } else {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = h1VarU.p(j.N1);
            this.C = h1VarU.p(j.S1);
            int i11 = j.P1;
            if (h1VarU.s(i11)) {
                this.E = l0.d(h1VarU.k(i11, -1), this.E);
            } else {
                this.E = null;
            }
            int i12 = j.O1;
            if (h1VarU.s(i12)) {
                this.D = h1VarU.c(i12);
            } else {
                this.D = null;
            }
            h1VarU.w();
            this.f12827h = false;
        }

        public void h() {
            this.f12821b = 0;
            this.f12822c = 0;
            this.f12823d = 0;
            this.f12824e = 0;
            this.f12825f = true;
            this.f12826g = true;
        }

        public final void i(MenuItem menuItem) {
            boolean z10 = false;
            menuItem.setChecked(this.f12838s).setVisible(this.f12839t).setEnabled(this.f12840u).setCheckable(this.f12837r >= 1).setTitleCondensed(this.f12831l).setIcon(this.f12832m);
            int i10 = this.f12841v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f12845z != null) {
                if (g.this.f12815c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f12845z));
            }
            if (this.f12837r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.g) {
                    ((androidx.appcompat.view.menu.g) menuItem).t(true);
                } else if (menuItem instanceof n.c) {
                    ((n.c) menuItem).h(true);
                }
            }
            String str = this.f12843x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f12811e, g.this.f12813a));
                z10 = true;
            }
            int i11 = this.f12842w;
            if (i11 > 0) {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i11);
                }
            }
            p0.b bVar = this.A;
            if (bVar != null) {
                x.a(menuItem, bVar);
            }
            x.c(menuItem, this.B);
            x.g(menuItem, this.C);
            x.b(menuItem, this.f12833n, this.f12834o);
            x.f(menuItem, this.f12835p, this.f12836q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                x.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                x.d(menuItem, colorStateList);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f12811e = clsArr;
        f12812f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f12815c = context;
        Object[] objArr = {context};
        this.f12813a = objArr;
        this.f12814b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object b() {
        if (this.f12816d == null) {
            this.f12816d = a(this.f12815c);
        }
        return this.f12816d;
    }

    public final void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                    break;
                }
                throw new RuntimeException("Expecting menu, got " + name);
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        boolean z10 = false;
        boolean z11 = false;
        String str = null;
        while (!z10) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z11 && name2.equals(str)) {
                        z11 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            p0.b bVar2 = bVar.A;
                            if (bVar2 == null || !bVar2.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z10 = true;
                    }
                }
            } else if (!z11) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z11 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i10, Menu menu) {
        if (!(menu instanceof j0.a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f12815c.getResources().getLayout(i10);
                    c(layout, Xml.asAttributeSet(layout), menu);
                    if (layout != null) {
                        layout.close();
                    }
                } catch (XmlPullParserException e10) {
                    throw new InflateException("Error inflating menu XML", e10);
                }
            } catch (IOException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
