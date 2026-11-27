package oe;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Socket f13902o;

    public s(Socket socket) {
        kotlin.jvm.internal.k.e(socket, "socket");
        this.f13902o = socket;
    }

    @Override // oe.c
    public IOException t(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // oe.c
    public void x() {
        Level level;
        StringBuilder sb2;
        Logger logger;
        Throwable th;
        try {
            this.f13902o.close();
        } catch (AssertionError e10) {
            if (!i.c(e10)) {
                throw e10;
            }
            Logger logger2 = j.f13878a;
            level = Level.WARNING;
            sb2 = new StringBuilder();
            th = e10;
            logger = logger2;
            sb2.append("Failed to close timed out socket ");
            sb2.append(this.f13902o);
            logger.log(level, sb2.toString(), th);
        } catch (Exception e11) {
            Logger logger3 = j.f13878a;
            level = Level.WARNING;
            sb2 = new StringBuilder();
            th = e11;
            logger = logger3;
            sb2.append("Failed to close timed out socket ");
            sb2.append(this.f13902o);
            logger.log(level, sb2.toString(), th);
        }
    }
}
