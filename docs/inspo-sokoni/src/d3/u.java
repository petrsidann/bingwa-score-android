package d3;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class u implements Closeable {

    public interface a {
        a a(Context context);

        u build();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        d().close();
    }

    public abstract l3.d d();

    public abstract t e();
}
