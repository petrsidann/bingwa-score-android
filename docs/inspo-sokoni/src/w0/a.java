package w0;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, w0.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Cursor f17574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f17575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0307a f17577f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DataSetObserver f17578l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public w0.b f17579m;

    /* JADX INFO: renamed from: w0.a$a, reason: collision with other inner class name */
    public class C0307a extends ContentObserver {
        public C0307a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            a.this.h();
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f17572a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f17572a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z10) {
        e(context, cursor, z10 ? 1 : 2);
    }

    public void a(Cursor cursor) {
        Cursor cursorI = i(cursor);
        if (cursorI != null) {
            cursorI.close();
        }
    }

    @Override // w0.b.a
    public Cursor b() {
        return this.f17574c;
    }

    public abstract CharSequence convertToString(Cursor cursor);

    public abstract void d(View view, Context context, Cursor cursor);

    public void e(Context context, Cursor cursor, int i10) {
        b bVar;
        if ((i10 & 1) == 1) {
            i10 |= 2;
            this.f17573b = true;
        } else {
            this.f17573b = false;
        }
        boolean z10 = cursor != null;
        this.f17574c = cursor;
        this.f17572a = z10;
        this.f17575d = context;
        this.f17576e = z10 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i10 & 2) == 2) {
            this.f17577f = new C0307a();
            bVar = new b();
        } else {
            bVar = null;
            this.f17577f = null;
        }
        this.f17578l = bVar;
        if (z10) {
            C0307a c0307a = this.f17577f;
            if (c0307a != null) {
                cursor.registerContentObserver(c0307a);
            }
            DataSetObserver dataSetObserver = this.f17578l;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View f(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f17572a || (cursor = this.f17574c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f17572a) {
            return null;
        }
        this.f17574c.moveToPosition(i10);
        if (view == null) {
            view = f(this.f17575d, this.f17574c, viewGroup);
        }
        d(view, this.f17575d, this.f17574c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f17579m == null) {
            this.f17579m = new w0.b(this);
        }
        return this.f17579m;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        Cursor cursor;
        if (!this.f17572a || (cursor = this.f17574c) == null) {
            return null;
        }
        cursor.moveToPosition(i10);
        return this.f17574c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        Cursor cursor;
        if (this.f17572a && (cursor = this.f17574c) != null && cursor.moveToPosition(i10)) {
            return this.f17574c.getLong(this.f17576e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f17572a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f17574c.moveToPosition(i10)) {
            if (view == null) {
                view = g(this.f17575d, this.f17574c, viewGroup);
            }
            d(view, this.f17575d, this.f17574c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i10);
    }

    public void h() {
        Cursor cursor;
        if (!this.f17573b || (cursor = this.f17574c) == null || cursor.isClosed()) {
            return;
        }
        this.f17572a = this.f17574c.requery();
    }

    public Cursor i(Cursor cursor) {
        Cursor cursor2 = this.f17574c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0307a c0307a = this.f17577f;
            if (c0307a != null) {
                cursor2.unregisterContentObserver(c0307a);
            }
            DataSetObserver dataSetObserver = this.f17578l;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f17574c = cursor;
        if (cursor != null) {
            C0307a c0307a2 = this.f17577f;
            if (c0307a2 != null) {
                cursor.registerContentObserver(c0307a2);
            }
            DataSetObserver dataSetObserver2 = this.f17578l;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f17576e = cursor.getColumnIndexOrThrow("_id");
            this.f17572a = true;
            notifyDataSetChanged();
        } else {
            this.f17576e = -1;
            this.f17572a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
