package dc;

import j6.q;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f6701a = Logger.getLogger(c.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final vb.c.C0304c<a> f6703c;

    public enum a {
        BLOCKING,
        FUTURE,
        ASYNC
    }

    static {
        f6702b = !q.a(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE")) && Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        f6703c = vb.c.C0304c.b("internal-stub-type");
    }
}
