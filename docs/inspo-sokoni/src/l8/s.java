package l8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/* JADX INFO: loaded from: classes.dex */
public class s {

    public static class a {
        public static void a(File file) throws IOException {
            try {
                Files.deleteIfExists(file.toPath());
            } catch (IOException e10) {
                throw new IOException("Failed to delete file " + file + ": " + e10);
            }
        }
    }

    public static void a(File file) throws IOException {
        a.a(file);
    }
}
