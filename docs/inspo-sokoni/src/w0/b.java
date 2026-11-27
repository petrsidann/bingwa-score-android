package w0;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: loaded from: classes.dex */
public class b extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f17582a;

    public interface a {
        void a(Cursor cursor);

        Cursor b();

        Cursor c(CharSequence charSequence);

        CharSequence convertToString(Cursor cursor);
    }

    public b(a aVar) {
        this.f17582a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f17582a.convertToString((Cursor) obj);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorC = this.f17582a.c(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorC != null) {
            filterResults.count = cursorC.getCount();
        } else {
            filterResults.count = 0;
            cursorC = null;
        }
        filterResults.values = cursorC;
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorB = this.f17582a.b();
        Object obj = filterResults.values;
        if (obj == null || obj == cursorB) {
            return;
        }
        this.f17582a.a((Cursor) obj);
    }
}
