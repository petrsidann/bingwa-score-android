package i1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public class n extends p implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public Handler f10282j0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f10291s0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public Dialog f10293u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f10294v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f10295w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f10296x0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Runnable f10283k0 = new a();

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public DialogInterface.OnCancelListener f10284l0 = new b();

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public DialogInterface.OnDismissListener f10285m0 = new c();

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f10286n0 = 0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f10287o0 = 0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f10288p0 = true;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f10289q0 = true;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f10290r0 = -1;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public androidx.lifecycle.r<androidx.lifecycle.k> f10292t0 = new d();

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f10297y0 = false;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.f10285m0.onDismiss(n.this.f10293u0);
        }
    }

    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (n.this.f10293u0 != null) {
                n nVar = n.this;
                nVar.onCancel(nVar.f10293u0);
            }
        }
    }

    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (n.this.f10293u0 != null) {
                n nVar = n.this;
                nVar.onDismiss(nVar.f10293u0);
            }
        }
    }

    public class d implements androidx.lifecycle.r<androidx.lifecycle.k> {
        public d() {
        }

        @Override // androidx.lifecycle.r
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.lifecycle.k kVar) {
            if (kVar == null || !n.this.f10289q0) {
                return;
            }
            View viewR1 = n.this.r1();
            if (viewR1.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (n.this.f10293u0 != null) {
                if (h0.I0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + n.this.f10293u0);
                }
                n.this.f10293u0.setContentView(viewR1);
            }
        }
    }

    public class e extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f10302a;

        public e(w wVar) {
            this.f10302a = wVar;
        }

        @Override // i1.w
        public View j(int i10) {
            return this.f10302a.l() ? this.f10302a.j(i10) : n.this.M1(i10);
        }

        @Override // i1.w
        public boolean l() {
            return this.f10302a.l() || n.this.N1();
        }
    }

    public void H1() {
        I1(false, false, false);
    }

    public final void I1(boolean z10, boolean z11, boolean z12) {
        if (this.f10295w0) {
            return;
        }
        this.f10295w0 = true;
        this.f10296x0 = false;
        Dialog dialog = this.f10293u0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f10293u0.dismiss();
            if (!z11) {
                if (Looper.myLooper() == this.f10282j0.getLooper()) {
                    onDismiss(this.f10293u0);
                } else {
                    this.f10282j0.post(this.f10283k0);
                }
            }
        }
        this.f10294v0 = true;
        if (this.f10290r0 >= 0) {
            if (z12) {
                H().c1(this.f10290r0, 1);
            } else {
                H().a1(this.f10290r0, 1, z10);
            }
            this.f10290r0 = -1;
            return;
        }
        p0 p0VarN = H().n();
        p0VarN.o(true);
        p0VarN.l(this);
        if (z12) {
            p0VarN.h();
        } else if (z10) {
            p0VarN.g();
        } else {
            p0VarN.f();
        }
    }

    public Dialog J1() {
        return this.f10293u0;
    }

    public int K1() {
        return this.f10287o0;
    }

    @Override // i1.p
    public void L0(Bundle bundle) {
        super.L0(bundle);
        Dialog dialog = this.f10293u0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i10 = this.f10286n0;
        if (i10 != 0) {
            bundle.putInt("android:style", i10);
        }
        int i11 = this.f10287o0;
        if (i11 != 0) {
            bundle.putInt("android:theme", i11);
        }
        boolean z10 = this.f10288p0;
        if (!z10) {
            bundle.putBoolean("android:cancelable", z10);
        }
        boolean z11 = this.f10289q0;
        if (!z11) {
            bundle.putBoolean("android:showsDialog", z11);
        }
        int i12 = this.f10290r0;
        if (i12 != -1) {
            bundle.putInt("android:backStackId", i12);
        }
    }

    public Dialog L1(Bundle bundle) {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new d.k(q1(), K1());
    }

    @Override // i1.p
    public void M0() {
        super.M0();
        Dialog dialog = this.f10293u0;
        if (dialog != null) {
            this.f10294v0 = false;
            dialog.show();
            View decorView = this.f10293u0.getWindow().getDecorView();
            androidx.lifecycle.k0.a(decorView, this);
            androidx.lifecycle.l0.a(decorView, this);
            b2.g.a(decorView, this);
        }
    }

    public View M1(int i10) {
        Dialog dialog = this.f10293u0;
        if (dialog != null) {
            return dialog.findViewById(i10);
        }
        return null;
    }

    @Override // i1.p
    public void N0() {
        super.N0();
        Dialog dialog = this.f10293u0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public boolean N1() {
        return this.f10297y0;
    }

    public final void O1(Bundle bundle) {
        if (this.f10289q0 && !this.f10297y0) {
            try {
                this.f10291s0 = true;
                Dialog dialogL1 = L1(bundle);
                this.f10293u0 = dialogL1;
                if (this.f10289q0) {
                    R1(dialogL1, this.f10286n0);
                    Context contextT = t();
                    if (contextT instanceof Activity) {
                        this.f10293u0.setOwnerActivity((Activity) contextT);
                    }
                    this.f10293u0.setCancelable(this.f10288p0);
                    this.f10293u0.setOnCancelListener(this.f10284l0);
                    this.f10293u0.setOnDismissListener(this.f10285m0);
                    this.f10297y0 = true;
                } else {
                    this.f10293u0 = null;
                }
            } finally {
                this.f10291s0 = false;
            }
        }
    }

    @Override // i1.p
    public void P0(Bundle bundle) {
        Bundle bundle2;
        super.P0(bundle);
        if (this.f10293u0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f10293u0.onRestoreInstanceState(bundle2);
    }

    public final Dialog P1() {
        Dialog dialogJ1 = J1();
        if (dialogJ1 != null) {
            return dialogJ1;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void Q1(boolean z10) {
        this.f10289q0 = z10;
    }

    public void R1(Dialog dialog, int i10) {
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void S1(h0 h0Var, String str) {
        this.f10295w0 = false;
        this.f10296x0 = true;
        p0 p0VarN = h0Var.n();
        p0VarN.o(true);
        p0VarN.d(this, str);
        p0VarN.f();
    }

    @Override // i1.p
    public void W0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.W0(layoutInflater, viewGroup, bundle);
        if (this.O != null || this.f10293u0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f10293u0.onRestoreInstanceState(bundle2);
    }

    @Override // i1.p
    public w g() {
        return new e(super.g());
    }

    @Override // i1.p
    @Deprecated
    public void j0(Bundle bundle) {
        super.j0(bundle);
    }

    @Override // i1.p
    public void m0(Context context) {
        super.m0(context);
        W().i(this.f10292t0);
        if (this.f10296x0) {
            return;
        }
        this.f10295w0 = false;
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f10294v0) {
            return;
        }
        if (h0.I0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        I1(true, true, false);
    }

    @Override // i1.p
    public void p0(Bundle bundle) {
        super.p0(bundle);
        this.f10282j0 = new Handler();
        this.f10289q0 = this.E == 0;
        if (bundle != null) {
            this.f10286n0 = bundle.getInt("android:style", 0);
            this.f10287o0 = bundle.getInt("android:theme", 0);
            this.f10288p0 = bundle.getBoolean("android:cancelable", true);
            this.f10289q0 = bundle.getBoolean("android:showsDialog", this.f10289q0);
            this.f10290r0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // i1.p
    public void w0() {
        super.w0();
        Dialog dialog = this.f10293u0;
        if (dialog != null) {
            this.f10294v0 = true;
            dialog.setOnDismissListener(null);
            this.f10293u0.dismiss();
            if (!this.f10295w0) {
                onDismiss(this.f10293u0);
            }
            this.f10293u0 = null;
            this.f10297y0 = false;
        }
    }

    @Override // i1.p
    public void x0() {
        super.x0();
        if (!this.f10296x0 && !this.f10295w0) {
            this.f10295w0 = true;
        }
        W().m(this.f10292t0);
    }

    @Override // i1.p
    public LayoutInflater y0(Bundle bundle) {
        StringBuilder sb2;
        String str;
        LayoutInflater layoutInflaterY0 = super.y0(bundle);
        if (this.f10289q0 && !this.f10291s0) {
            O1(bundle);
            if (h0.I0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.f10293u0;
            return dialog != null ? layoutInflaterY0.cloneInContext(dialog.getContext()) : layoutInflaterY0;
        }
        if (h0.I0(2)) {
            String str2 = "getting layout inflater for DialogFragment " + this;
            if (this.f10289q0) {
                sb2 = new StringBuilder();
                str = "mCreatingDialog = true: ";
            } else {
                sb2 = new StringBuilder();
                str = "mShowsDialog = false: ";
            }
            sb2.append(str);
            sb2.append(str2);
            Log.d("FragmentManager", sb2.toString());
        }
        return layoutInflaterY0;
    }
}
