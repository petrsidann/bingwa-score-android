package yb;

import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Logger f19605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Level f19606b;

    public enum a {
        INBOUND,
        OUTBOUND
    }

    public enum b {
        HEADER_TABLE_SIZE(1),
        ENABLE_PUSH(2),
        MAX_CONCURRENT_STREAMS(4),
        MAX_FRAME_SIZE(5),
        MAX_HEADER_LIST_SIZE(6),
        INITIAL_WINDOW_SIZE(7);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19617a;

        b(int i10) {
            this.f19617a = i10;
        }

        public int d() {
            return this.f19617a;
        }
    }

    public j(Level level, Class<?> cls) {
        this(level, Logger.getLogger(cls.getName()));
    }

    public j(Level level, Logger logger) {
        this.f19606b = (Level) j6.m.p(level, "level");
        this.f19605a = (Logger) j6.m.p(logger, "logger");
    }

    public static String l(ac.i iVar) {
        EnumMap enumMap = new EnumMap(b.class);
        for (b bVar : b.values()) {
            if (iVar.d(bVar.d())) {
                enumMap.put(bVar, Integer.valueOf(iVar.a(bVar.d())));
            }
        }
        return enumMap.toString();
    }

    public static String m(oe.d dVar) {
        if (dVar.size() <= 64) {
            return dVar.j0().q();
        }
        return dVar.k0((int) Math.min(dVar.size(), 64L)).q() + "...";
    }

    public final boolean a() {
        return this.f19605a.isLoggable(this.f19606b);
    }

    public void b(a aVar, int i10, oe.d dVar, int i11, boolean z10) {
        if (a()) {
            this.f19605a.log(this.f19606b, aVar + " DATA: streamId=" + i10 + " endStream=" + z10 + " length=" + i11 + " bytes=" + m(dVar));
        }
    }

    public void c(a aVar, int i10, ac.a aVar2, oe.g gVar) {
        if (a()) {
            this.f19605a.log(this.f19606b, aVar + " GO_AWAY: lastStreamId=" + i10 + " errorCode=" + aVar2 + " length=" + gVar.y() + " bytes=" + m(new oe.d().m0(gVar)));
        }
    }

    public void d(a aVar, int i10, List<ac.d> list, boolean z10) {
        if (a()) {
            this.f19605a.log(this.f19606b, aVar + " HEADERS: streamId=" + i10 + " headers=" + list + " endStream=" + z10);
        }
    }

    public void e(a aVar, long j10) {
        if (a()) {
            this.f19605a.log(this.f19606b, aVar + " PING: ack=false bytes=" + j10);
        }
    }

    public void f(a aVar, long j10) {
        if (a()) {
            this.f19605a.log(this.f19606b, aVar + " PING: ack=true bytes=" + j10);
        }
    }

    public void g(a aVar, int i10, int i11, List<ac.d> list) {
        if (a()) {
            this.f19605a.log(this.f19606b, aVar + " PUSH_PROMISE: streamId=" + i10 + " promisedStreamId=" + i11 + " headers=" + list);
        }
    }

    public void h(a aVar, int i10, ac.a aVar2) {
        if (a()) {
            this.f19605a.log(this.f19606b, aVar + " RST_STREAM: streamId=" + i10 + " errorCode=" + aVar2);
        }
    }

    public void i(a aVar, ac.i iVar) {
        if (a()) {
            this.f19605a.log(this.f19606b, aVar + " SETTINGS: ack=false settings=" + l(iVar));
        }
    }

    public void j(a aVar) {
        if (a()) {
            this.f19605a.log(this.f19606b, aVar + " SETTINGS: ack=true");
        }
    }

    public void k(a aVar, int i10, long j10) {
        if (a()) {
            this.f19605a.log(this.f19606b, aVar + " WINDOW_UPDATE: streamId=" + i10 + " windowSizeIncrement=" + j10);
        }
    }
}
