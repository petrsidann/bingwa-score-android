package y1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f19323a = {112, 114, 111, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f19324b = {112, 114, 109, 0};

    public static void A(InputStream inputStream) {
        c.h(inputStream);
        int iJ = c.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            c.j(inputStream);
            for (int iJ2 = c.j(inputStream); iJ2 > 0; iJ2--) {
                c.h(inputStream);
            }
            iJ--;
        }
    }

    public static boolean B(OutputStream outputStream, byte[] bArr, b[] bVarArr) throws IOException {
        if (Arrays.equals(bArr, k.f19325a)) {
            N(outputStream, bVarArr);
            return true;
        }
        if (Arrays.equals(bArr, k.f19326b)) {
            M(outputStream, bVarArr);
            return true;
        }
        if (Arrays.equals(bArr, k.f19328d)) {
            K(outputStream, bVarArr);
            return true;
        }
        if (Arrays.equals(bArr, k.f19327c)) {
            L(outputStream, bVarArr);
            return true;
        }
        if (!Arrays.equals(bArr, k.f19329e)) {
            return false;
        }
        J(outputStream, bVarArr);
        return true;
    }

    public static void C(OutputStream outputStream, b bVar) throws IOException {
        int iIntValue = 0;
        for (int i10 : bVar.f19306h) {
            Integer numValueOf = Integer.valueOf(i10);
            c.p(outputStream, numValueOf.intValue() - iIntValue);
            iIntValue = numValueOf.intValue();
        }
    }

    public static l D(b[] bVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            c.p(byteArrayOutputStream, bVarArr.length);
            int i10 = 2;
            for (b bVar : bVarArr) {
                c.q(byteArrayOutputStream, bVar.f19301c);
                c.q(byteArrayOutputStream, bVar.f19302d);
                c.q(byteArrayOutputStream, bVar.f19305g);
                String strJ = j(bVar.f19299a, bVar.f19300b, k.f19325a);
                int iK = c.k(strJ);
                c.p(byteArrayOutputStream, iK);
                i10 = i10 + 4 + 4 + 4 + 2 + (iK * 1);
                c.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i10 == byteArray.length) {
                l lVar = new l(d.DEX_FILES, i10, byteArray, false);
                byteArrayOutputStream.close();
                return lVar;
            }
            throw c.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void E(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f19323a);
        outputStream.write(bArr);
    }

    public static void F(OutputStream outputStream, b bVar) throws IOException {
        I(outputStream, bVar);
        C(outputStream, bVar);
        H(outputStream, bVar);
    }

    public static void G(OutputStream outputStream, b bVar, String str) throws IOException {
        c.p(outputStream, c.k(str));
        c.p(outputStream, bVar.f19303e);
        c.q(outputStream, bVar.f19304f);
        c.q(outputStream, bVar.f19301c);
        c.q(outputStream, bVar.f19305g);
        c.n(outputStream, str);
    }

    public static void H(OutputStream outputStream, b bVar) throws IOException {
        byte[] bArr = new byte[k(bVar.f19305g)];
        for (Map.Entry<Integer, Integer> entry : bVar.f19307i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            if ((iIntValue2 & 2) != 0) {
                z(bArr, 2, iIntValue, bVar);
            }
            if ((iIntValue2 & 4) != 0) {
                z(bArr, 4, iIntValue, bVar);
            }
        }
        outputStream.write(bArr);
    }

    public static void I(OutputStream outputStream, b bVar) throws IOException {
        int i10 = 0;
        for (Map.Entry<Integer, Integer> entry : bVar.f19307i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                c.p(outputStream, iIntValue - i10);
                c.p(outputStream, 0);
                i10 = iIntValue;
            }
        }
    }

    public static void J(OutputStream outputStream, b[] bVarArr) throws IOException {
        c.p(outputStream, bVarArr.length);
        for (b bVar : bVarArr) {
            String strJ = j(bVar.f19299a, bVar.f19300b, k.f19329e);
            c.p(outputStream, c.k(strJ));
            c.p(outputStream, bVar.f19307i.size());
            c.p(outputStream, bVar.f19306h.length);
            c.q(outputStream, bVar.f19301c);
            c.n(outputStream, strJ);
            Iterator<Integer> it = bVar.f19307i.keySet().iterator();
            while (it.hasNext()) {
                c.p(outputStream, it.next().intValue());
            }
            for (int i10 : bVar.f19306h) {
                c.p(outputStream, i10);
            }
        }
    }

    public static void K(OutputStream outputStream, b[] bVarArr) throws IOException {
        c.r(outputStream, bVarArr.length);
        for (b bVar : bVarArr) {
            int size = bVar.f19307i.size() * 4;
            String strJ = j(bVar.f19299a, bVar.f19300b, k.f19328d);
            c.p(outputStream, c.k(strJ));
            c.p(outputStream, bVar.f19306h.length);
            c.q(outputStream, size);
            c.q(outputStream, bVar.f19301c);
            c.n(outputStream, strJ);
            Iterator<Integer> it = bVar.f19307i.keySet().iterator();
            while (it.hasNext()) {
                c.p(outputStream, it.next().intValue());
                c.p(outputStream, 0);
            }
            for (int i10 : bVar.f19306h) {
                c.p(outputStream, i10);
            }
        }
    }

    public static void L(OutputStream outputStream, b[] bVarArr) throws IOException {
        byte[] bArrB = b(bVarArr, k.f19327c);
        c.r(outputStream, bVarArr.length);
        c.m(outputStream, bArrB);
    }

    public static void M(OutputStream outputStream, b[] bVarArr) throws IOException {
        byte[] bArrB = b(bVarArr, k.f19326b);
        c.r(outputStream, bVarArr.length);
        c.m(outputStream, bArrB);
    }

    public static void N(OutputStream outputStream, b[] bVarArr) throws IOException {
        O(outputStream, bVarArr);
    }

    public static void O(OutputStream outputStream, b[] bVarArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(bVarArr));
        arrayList.add(c(bVarArr));
        arrayList.add(d(bVarArr));
        long length2 = ((long) k.f19325a.length) + ((long) f19323a.length) + 4 + ((long) (arrayList.size() * 16));
        c.q(outputStream, arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            l lVar = (l) arrayList.get(i10);
            c.q(outputStream, lVar.f19332a.h());
            c.q(outputStream, length2);
            if (lVar.f19335d) {
                byte[] bArr = lVar.f19334c;
                long length3 = bArr.length;
                byte[] bArrB = c.b(bArr);
                arrayList2.add(bArrB);
                c.q(outputStream, bArrB.length);
                c.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(lVar.f19334c);
                c.q(outputStream, lVar.f19334c.length);
                c.q(outputStream, 0L);
                length = lVar.f19334c.length;
            }
            length2 += (long) length;
        }
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            outputStream.write((byte[]) arrayList2.get(i11));
        }
    }

    public static int a(b bVar) {
        Iterator<Map.Entry<Integer, Integer>> it = bVar.f19307i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= it.next().getValue().intValue();
        }
        return iIntValue;
    }

    public static byte[] b(b[] bVarArr, byte[] bArr) throws IOException {
        int i10 = 0;
        int iK = 0;
        for (b bVar : bVarArr) {
            iK += c.k(j(bVar.f19299a, bVar.f19300b, bArr)) + 16 + (bVar.f19303e * 2) + bVar.f19304f + k(bVar.f19305g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, k.f19327c)) {
            int length = bVarArr.length;
            while (i10 < length) {
                b bVar2 = bVarArr[i10];
                G(byteArrayOutputStream, bVar2, j(bVar2.f19299a, bVar2.f19300b, bArr));
                F(byteArrayOutputStream, bVar2);
                i10++;
            }
        } else {
            for (b bVar3 : bVarArr) {
                G(byteArrayOutputStream, bVar3, j(bVar3.f19299a, bVar3.f19300b, bArr));
            }
            int length2 = bVarArr.length;
            while (i10 < length2) {
                F(byteArrayOutputStream, bVarArr[i10]);
                i10++;
            }
        }
        if (byteArrayOutputStream.size() == iK) {
            return byteArrayOutputStream.toByteArray();
        }
        throw c.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    public static l c(b[] bVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            try {
                b bVar = bVarArr[i11];
                c.p(byteArrayOutputStream, i11);
                c.p(byteArrayOutputStream, bVar.f19303e);
                i10 = i10 + 2 + 2 + (bVar.f19303e * 2);
                C(byteArrayOutputStream, bVar);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i10 == byteArray.length) {
            l lVar = new l(d.CLASSES, i10, byteArray, true);
            byteArrayOutputStream.close();
            return lVar;
        }
        throw c.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    public static l d(b[] bVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            try {
                b bVar = bVarArr[i11];
                int iA = a(bVar);
                byte[] bArrE = e(bVar);
                byte[] bArrF = f(bVar);
                c.p(byteArrayOutputStream, i11);
                int length = bArrE.length + 2 + bArrF.length;
                c.q(byteArrayOutputStream, length);
                c.p(byteArrayOutputStream, iA);
                byteArrayOutputStream.write(bArrE);
                byteArrayOutputStream.write(bArrF);
                i10 = i10 + 2 + 4 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i10 == byteArray.length) {
            l lVar = new l(d.METHODS, i10, byteArray, true);
            byteArrayOutputStream.close();
            return lVar;
        }
        throw c.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    public static byte[] e(b bVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, bVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static byte[] f(b bVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, bVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String g(String str, String str2) {
        if ("!".equals(str2)) {
            return str.replace(":", "!");
        }
        return ":".equals(str2) ? str.replace("!", ":") : str;
    }

    public static String h(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    public static b i(b[] bVarArr, String str) {
        if (bVarArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            if (bVarArr[i10].f19300b.equals(strH)) {
                return bVarArr[i10];
            }
        }
        return null;
    }

    public static String j(String str, String str2, byte[] bArr) {
        String strA = k.a(bArr);
        if (str.length() <= 0) {
            return g(str2, strA);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, strA);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + k.a(bArr) + str2;
    }

    public static int k(int i10) {
        return y(i10 * 2) / 8;
    }

    public static int l(int i10, int i11, int i12) {
        if (i10 == 1) {
            throw c.c("HOT methods are not stored in the bitmap");
        }
        if (i10 == 2) {
            return i11;
        }
        if (i10 == 4) {
            return i11 + i12;
        }
        throw c.c("Unexpected flag: " + i10);
    }

    public static int[] m(InputStream inputStream, int i10) {
        int[] iArr = new int[i10];
        int iH = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iH += c.h(inputStream);
            iArr[i11] = iH;
        }
        return iArr;
    }

    public static int n(BitSet bitSet, int i10, int i11) {
        int i12 = bitSet.get(l(2, i10, i11)) ? 2 : 0;
        return bitSet.get(l(4, i10, i11)) ? i12 | 4 : i12;
    }

    public static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, c.d(inputStream, bArr.length))) {
            return c.d(inputStream, k.f19326b.length);
        }
        throw c.c("Invalid magic");
    }

    public static void p(InputStream inputStream, b bVar) {
        int iAvailable = inputStream.available() - bVar.f19304f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += c.h(inputStream);
            bVar.f19307i.put(Integer.valueOf(iH), 1);
            for (int iH2 = c.h(inputStream); iH2 > 0; iH2--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw c.c("Read too much data during profile line parse");
        }
    }

    public static b[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, b[] bVarArr) {
        if (Arrays.equals(bArr, k.f19330f)) {
            if (Arrays.equals(k.f19325a, bArr2)) {
                throw c.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return r(inputStream, bArr, bVarArr);
        }
        if (Arrays.equals(bArr, k.f19331g)) {
            return t(inputStream, bArr2, bVarArr);
        }
        throw c.c("Unsupported meta version");
    }

    public static b[] r(InputStream inputStream, byte[] bArr, b[] bVarArr) throws IOException {
        if (!Arrays.equals(bArr, k.f19330f)) {
            throw c.c("Unsupported meta version");
        }
        int iJ = c.j(inputStream);
        byte[] bArrE = c.e(inputStream, (int) c.i(inputStream), (int) c.i(inputStream));
        if (inputStream.read() > 0) {
            throw c.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            b[] bVarArrS = s(byteArrayInputStream, iJ, bVarArr);
            byteArrayInputStream.close();
            return bVarArrS;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static b[] s(InputStream inputStream, int i10, b[] bVarArr) {
        if (inputStream.available() == 0) {
            return new b[0];
        }
        if (i10 != bVarArr.length) {
            throw c.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i10];
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iH = c.h(inputStream);
            iArr[i11] = c.h(inputStream);
            strArr[i11] = c.f(inputStream, iH);
        }
        for (int i12 = 0; i12 < i10; i12++) {
            b bVar = bVarArr[i12];
            if (!bVar.f19300b.equals(strArr[i12])) {
                throw c.c("Order of dexfiles in metadata did not match baseline");
            }
            int i13 = iArr[i12];
            bVar.f19303e = i13;
            bVar.f19306h = m(inputStream, i13);
        }
        return bVarArr;
    }

    public static b[] t(InputStream inputStream, byte[] bArr, b[] bVarArr) throws IOException {
        int iH = c.h(inputStream);
        byte[] bArrE = c.e(inputStream, (int) c.i(inputStream), (int) c.i(inputStream));
        if (inputStream.read() > 0) {
            throw c.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            b[] bVarArrU = u(byteArrayInputStream, bArr, iH, bVarArr);
            byteArrayInputStream.close();
            return bVarArrU;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static b[] u(InputStream inputStream, byte[] bArr, int i10, b[] bVarArr) {
        if (inputStream.available() == 0) {
            return new b[0];
        }
        if (i10 != bVarArr.length) {
            throw c.c("Mismatched number of dex files found in metadata");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            c.h(inputStream);
            String strF = c.f(inputStream, c.h(inputStream));
            long jI = c.i(inputStream);
            int iH = c.h(inputStream);
            b bVarI = i(bVarArr, strF);
            if (bVarI == null) {
                throw c.c("Missing profile key: " + strF);
            }
            bVarI.f19302d = jI;
            int[] iArrM = m(inputStream, iH);
            if (Arrays.equals(bArr, k.f19329e)) {
                bVarI.f19303e = iH;
                bVarI.f19306h = iArrM;
            }
        }
        return bVarArr;
    }

    public static void v(InputStream inputStream, b bVar) {
        BitSet bitSetValueOf = BitSet.valueOf(c.d(inputStream, c.a(bVar.f19305g * 2)));
        int i10 = 0;
        while (true) {
            int i11 = bVar.f19305g;
            if (i10 >= i11) {
                return;
            }
            int iN = n(bitSetValueOf, i10, i11);
            if (iN != 0) {
                Integer num = bVar.f19307i.get(Integer.valueOf(i10));
                if (num == null) {
                    num = 0;
                }
                bVar.f19307i.put(Integer.valueOf(i10), Integer.valueOf(iN | num.intValue()));
            }
            i10++;
        }
    }

    public static b[] w(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, k.f19326b)) {
            throw c.c("Unsupported version");
        }
        int iJ = c.j(inputStream);
        byte[] bArrE = c.e(inputStream, (int) c.i(inputStream), (int) c.i(inputStream));
        if (inputStream.read() > 0) {
            throw c.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            b[] bVarArrX = x(byteArrayInputStream, str, iJ);
            byteArrayInputStream.close();
            return bVarArrX;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static b[] x(InputStream inputStream, String str, int i10) {
        if (inputStream.available() == 0) {
            return new b[0];
        }
        b[] bVarArr = new b[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iH = c.h(inputStream);
            int iH2 = c.h(inputStream);
            bVarArr[i11] = new b(str, c.f(inputStream, iH), c.i(inputStream), 0L, iH2, (int) c.i(inputStream), (int) c.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i12 = 0; i12 < i10; i12++) {
            b bVar = bVarArr[i12];
            p(inputStream, bVar);
            bVar.f19306h = m(inputStream, bVar.f19303e);
            v(inputStream, bVar);
        }
        return bVarArr;
    }

    public static int y(int i10) {
        return ((i10 + 8) - 1) & (-8);
    }

    public static void z(byte[] bArr, int i10, int i11, b bVar) {
        int iL = l(i10, i11, bVar.f19305g);
        int i12 = iL / 8;
        bArr[i12] = (byte) ((1 << (iL % 8)) | bArr[i12]);
    }
}
