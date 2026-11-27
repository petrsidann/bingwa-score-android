package i1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class z<H> extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f10489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f10490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f10491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h0 f10493e;

    public z(Activity activity, Context context, Handler handler, int i10) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(handler, "handler");
        this.f10489a = activity;
        this.f10490b = context;
        this.f10491c = handler;
        this.f10492d = i10;
        this.f10493e = new i0();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public z(u activity) {
        this(activity, activity, new Handler(), 0);
        kotlin.jvm.internal.k.e(activity, "activity");
    }

    public void A(p fragment, Intent intent, int i10, Bundle bundle) {
        kotlin.jvm.internal.k.e(fragment, "fragment");
        kotlin.jvm.internal.k.e(intent, "intent");
        if (!(i10 == -1)) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host".toString());
        }
        f0.a.startActivity(this.f10490b, intent, bundle);
    }

    public void B() {
    }

    @Override // i1.w
    public View j(int i10) {
        return null;
    }

    @Override // i1.w
    public boolean l() {
        return true;
    }

    public final Activity n() {
        return this.f10489a;
    }

    public final Context o() {
        return this.f10490b;
    }

    public final h0 q() {
        return this.f10493e;
    }

    public final Handler w() {
        return this.f10491c;
    }

    public void x(String prefix, FileDescriptor fileDescriptor, PrintWriter writer, String[] strArr) {
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(writer, "writer");
    }

    public abstract H y();

    public LayoutInflater z() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f10490b);
        kotlin.jvm.internal.k.d(layoutInflaterFrom, "from(context)");
        return layoutInflaterFrom;
    }
}
