package td;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends a {
    @Override // td.a
    public void b(Context context, Intent intent) {
        if (intent.getAction() != null) {
            ie.b.s(context);
        }
    }
}
