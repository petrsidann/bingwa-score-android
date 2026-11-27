package xb;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f18788f = Logger.getLogger(vb.f.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18789a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vb.l0 f18790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection<vb.g0> f18791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f18792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18793e;

    public class a extends ArrayDeque<vb.g0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18794a;

        public a(int i10) {
            this.f18794a = i10;
        }

        @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean add(vb.g0 g0Var) {
            if (size() == this.f18794a) {
                removeFirst();
            }
            p.a(p.this);
            return super.add(g0Var);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18796a;

        static {
            int[] iArr = new int[vb.g0.b.values().length];
            f18796a = iArr;
            try {
                iArr[vb.g0.b.CT_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18796a[vb.g0.b.CT_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public p(vb.l0 l0Var, int i10, long j10, String str) {
        j6.m.p(str, "description");
        this.f18790b = (vb.l0) j6.m.p(l0Var, "logId");
        this.f18791c = i10 > 0 ? new a(i10) : null;
        this.f18792d = j10;
        e(new vb.g0.a().b(str + " created").c(vb.g0.b.CT_INFO).e(j10).a());
    }

    public static /* synthetic */ int a(p pVar) {
        int i10 = pVar.f18793e;
        pVar.f18793e = i10 + 1;
        return i10;
    }

    public static void d(vb.l0 l0Var, Level level, String str) {
        Logger logger = f18788f;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + l0Var + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public vb.l0 b() {
        return this.f18790b;
    }

    public boolean c() {
        boolean z10;
        synchronized (this.f18789a) {
            z10 = this.f18791c != null;
        }
        return z10;
    }

    public void e(vb.g0 g0Var) {
        Level level;
        int i10 = b.f18796a[g0Var.f17365b.ordinal()];
        if (i10 != 1) {
            level = i10 != 2 ? Level.FINEST : Level.FINER;
        } else {
            level = Level.FINE;
        }
        f(g0Var);
        d(this.f18790b, level, g0Var.f17364a);
    }

    public void f(vb.g0 g0Var) {
        synchronized (this.f18789a) {
            Collection<vb.g0> collection = this.f18791c;
            if (collection != null) {
                collection.add(g0Var);
            }
        }
    }
}
