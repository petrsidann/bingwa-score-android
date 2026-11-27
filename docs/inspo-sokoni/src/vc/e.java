package vc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import lc.q;
import mc.j;

/* JADX INFO: loaded from: classes2.dex */
public class e extends d {
    public static final byte[] a(File file) throws IllegalAccessException, IOException, InvocationTargetException {
        k.e(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i10 = (int) length;
            byte[] bArrD = new byte[i10];
            int i11 = i10;
            int i12 = 0;
            while (i11 > 0) {
                int i13 = fileInputStream.read(bArrD, i12, i11);
                if (i13 < 0) {
                    break;
                }
                i11 -= i13;
                i12 += i13;
            }
            if (i11 > 0) {
                bArrD = Arrays.copyOf(bArrD, i12);
                k.d(bArrD, "copyOf(...)");
            } else {
                int i14 = fileInputStream.read();
                if (i14 != -1) {
                    c cVar = new c(8193);
                    cVar.write(i14);
                    a.b(fileInputStream, cVar, 0, 2, null);
                    int size = cVar.size() + i10;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrD2 = cVar.d();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrD, size);
                    k.d(bArrCopyOf, "copyOf(...)");
                    bArrD = j.d(bArrD2, bArrCopyOf, i10, 0, cVar.size());
                }
            }
            b.a(fileInputStream, null);
            return bArrD;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final void b(File file, byte[] array) throws IllegalAccessException, IOException, InvocationTargetException {
        k.e(file, "<this>");
        k.e(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            q qVar = q.f12711a;
            b.a(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(fileOutputStream, th);
                throw th2;
            }
        }
    }
}
