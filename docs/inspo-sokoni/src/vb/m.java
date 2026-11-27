package vb;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface m extends o, v {

    public static final class a implements m {
        @Override // vb.o, vb.v
        public String a() {
            return "gzip";
        }

        @Override // vb.v
        public InputStream b(InputStream inputStream) {
            return new GZIPInputStream(inputStream);
        }

        @Override // vb.o
        public OutputStream c(OutputStream outputStream) {
            return new GZIPOutputStream(outputStream);
        }
    }

    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f17449a = new b();

        @Override // vb.o, vb.v
        public String a() {
            return "identity";
        }

        @Override // vb.v
        public InputStream b(InputStream inputStream) {
            return inputStream;
        }

        @Override // vb.o
        public OutputStream c(OutputStream outputStream) {
            return outputStream;
        }
    }
}
