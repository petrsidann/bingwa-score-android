package td;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends BroadcastReceiver {
    public abstract void a(Context context);

    public abstract void b(Context context, Intent intent);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            a(context);
            rd.a.N(context);
            b(context, intent);
        } catch (ae.a e10) {
            e10.printStackTrace();
        } catch (Exception e11) {
            ae.b.e().g("AwesomeBroadcastReceiver", "UNKNOWN_EXCEPTION", "unexpectedError." + e11.getClass().getSimpleName(), e11);
        }
    }
}
