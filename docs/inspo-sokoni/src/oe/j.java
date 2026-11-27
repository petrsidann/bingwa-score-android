package oe;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f13878a = Logger.getLogger("okio.Okio");

    public static final boolean b(AssertionError assertionError) {
        kotlin.jvm.internal.k.e(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? ed.t.v(message, "getsockname failed", false, 2, null) : false;
    }

    public static final r c(Socket socket) throws IOException {
        kotlin.jvm.internal.k.e(socket, "<this>");
        s sVar = new s(socket);
        OutputStream outputStream = socket.getOutputStream();
        kotlin.jvm.internal.k.d(outputStream, "getOutputStream()");
        return sVar.v(new l(outputStream, sVar));
    }

    public static final t d(Socket socket) throws IOException {
        kotlin.jvm.internal.k.e(socket, "<this>");
        s sVar = new s(socket);
        InputStream inputStream = socket.getInputStream();
        kotlin.jvm.internal.k.d(inputStream, "getInputStream()");
        return sVar.w(new h(inputStream, sVar));
    }
}
