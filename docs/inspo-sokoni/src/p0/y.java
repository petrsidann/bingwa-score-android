package p0;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public interface y {
    boolean a(MenuItem menuItem);

    default void b(Menu menu) {
    }

    void c(Menu menu, MenuInflater menuInflater);

    default void d(Menu menu) {
    }
}
