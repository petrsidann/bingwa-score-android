package g;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class c extends g.a<Intent, f.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8424a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Override // g.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, Intent input) {
        k.e(context, "context");
        k.e(input, "input");
        return input;
    }

    @Override // g.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public f.a c(int i10, Intent intent) {
        return new f.a(i10, intent);
    }
}
