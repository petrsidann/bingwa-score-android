package w0;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f17583n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f17584o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LayoutInflater f17585p;

    @Deprecated
    public c(Context context, int i10, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        this.f17584o = i10;
        this.f17583n = i10;
        this.f17585p = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // w0.a
    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f17585p.inflate(this.f17584o, viewGroup, false);
    }

    @Override // w0.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f17585p.inflate(this.f17583n, viewGroup, false);
    }
}
