package i1;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;

/* JADX INFO: loaded from: classes.dex */
public class a0 implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f10117a;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n0 f10118a;

        public a(n0 n0Var) {
            this.f10118a = n0Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            p pVarK = this.f10118a.k();
            this.f10118a.m();
            x0.u((ViewGroup) pVarK.O.getParent(), a0.this.f10117a).q();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public a0(h0 h0Var) {
        this.f10117a = h0Var;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        n0 n0VarV;
        StringBuilder sb2;
        String str2;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f10117a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h1.c.f9585a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(h1.c.f9586b);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(h1.c.f9587c, -1);
        String string = typedArrayObtainStyledAttributes.getString(h1.c.f9588d);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !y.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id2 = view != null ? view.getId() : 0;
        if (id2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        p pVarH0 = resourceId != -1 ? this.f10117a.h0(resourceId) : null;
        if (pVarH0 == null && string != null) {
            pVarH0 = this.f10117a.i0(string);
        }
        if (pVarH0 == null && id2 != -1) {
            pVarH0 = this.f10117a.h0(id2);
        }
        if (pVarH0 == null) {
            pVarH0 = this.f10117a.t0().a(context.getClassLoader(), attributeValue);
            pVarH0.f10341u = true;
            pVarH0.D = resourceId != 0 ? resourceId : id2;
            pVarH0.E = id2;
            pVarH0.F = string;
            pVarH0.f10342v = true;
            h0 h0Var = this.f10117a;
            pVarH0.f10346z = h0Var;
            pVarH0.A = h0Var.v0();
            pVarH0.B0(this.f10117a.v0().o(), attributeSet, pVarH0.f10320b);
            n0VarV = this.f10117a.i(pVarH0);
            if (h0.I0(2)) {
                sb2 = new StringBuilder();
                sb2.append("Fragment ");
                sb2.append(pVarH0);
                str2 = " has been inflated via the <fragment> tag: id=0x";
                sb2.append(str2);
                sb2.append(Integer.toHexString(resourceId));
                Log.v("FragmentManager", sb2.toString());
            }
        } else {
            if (pVarH0.f10342v) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
            }
            pVarH0.f10342v = true;
            h0 h0Var2 = this.f10117a;
            pVarH0.f10346z = h0Var2;
            pVarH0.A = h0Var2.v0();
            pVarH0.B0(this.f10117a.v0().o(), attributeSet, pVarH0.f10320b);
            n0VarV = this.f10117a.v(pVarH0);
            if (h0.I0(2)) {
                sb2 = new StringBuilder();
                sb2.append("Retained Fragment ");
                sb2.append(pVarH0);
                str2 = " has been re-attached via the <fragment> tag: id=0x";
                sb2.append(str2);
                sb2.append(Integer.toHexString(resourceId));
                Log.v("FragmentManager", sb2.toString());
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        j1.c.g(pVarH0, viewGroup);
        pVarH0.N = viewGroup;
        n0VarV.m();
        n0VarV.j();
        View view2 = pVarH0.O;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (pVarH0.O.getTag() == null) {
            pVarH0.O.setTag(string);
        }
        pVarH0.O.addOnAttachStateChangeListener(new a(n0VarV));
        return pVarH0.O;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
