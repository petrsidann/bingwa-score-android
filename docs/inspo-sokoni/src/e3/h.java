package e3;

import android.content.Context;
import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
public abstract class h {
    public static h a(Context context, n3.a aVar, n3.a aVar2, String str) {
        return new c(context, aVar, aVar2, str);
    }

    public abstract Context b();

    public abstract String c();

    public abstract n3.a d();

    public abstract n3.a e();
}
