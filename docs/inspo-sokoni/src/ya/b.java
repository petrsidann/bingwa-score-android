package ya;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.g;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    void b(Bundle bundle);

    void c(Bundle bundle);

    void d();

    void h();

    void j();

    void l(ra.b<Activity> bVar, g gVar);

    boolean onActivityResult(int i10, int i11, Intent intent);

    void onNewIntent(Intent intent);

    boolean onRequestPermissionsResult(int i10, String[] strArr, int[] iArr);
}
