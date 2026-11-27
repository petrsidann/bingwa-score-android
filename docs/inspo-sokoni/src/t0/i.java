package t0;

import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    public static class a {
        public static boolean a(ListView listView, int i10) {
            return listView.canScrollList(i10);
        }

        public static void b(ListView listView, int i10) {
            listView.scrollListBy(i10);
        }
    }

    public static void a(ListView listView, int i10) {
        a.b(listView, i10);
    }
}
