package d4;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    public static class a extends RuntimeException {
        public a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static Double A(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        if (iK == 0) {
            return null;
        }
        N(parcel, i10, iK, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float B(Parcel parcel, int i10) {
        O(parcel, i10, 4);
        return parcel.readFloat();
    }

    public static Float C(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        if (iK == 0) {
            return null;
        }
        N(parcel, i10, iK, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int D(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder E(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iK);
        return strongBinder;
    }

    public static int F(Parcel parcel, int i10) {
        O(parcel, i10, 4);
        return parcel.readInt();
    }

    public static Integer G(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        if (iK == 0) {
            return null;
        }
        N(parcel, i10, iK, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long H(Parcel parcel, int i10) {
        O(parcel, i10, 8);
        return parcel.readLong();
    }

    public static Long I(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        if (iK == 0) {
            return null;
        }
        N(parcel, i10, iK, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short J(Parcel parcel, int i10) {
        O(parcel, i10, 4);
        return (short) parcel.readInt();
    }

    public static int K(Parcel parcel, int i10) {
        return (i10 & (-65536)) != -65536 ? (char) (i10 >> 16) : parcel.readInt();
    }

    public static void L(Parcel parcel, int i10) {
        parcel.setDataPosition(parcel.dataPosition() + K(parcel, i10));
    }

    public static int M(Parcel parcel) {
        int iD = D(parcel);
        int iK = K(parcel, iD);
        int iW = w(iD);
        int iDataPosition = parcel.dataPosition();
        if (iW != 20293) {
            throw new a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(iD))), parcel);
        }
        int i10 = iK + iDataPosition;
        if (i10 >= iDataPosition && i10 <= parcel.dataSize()) {
            return i10;
        }
        throw new a("Size read is invalid start=" + iDataPosition + " end=" + i10, parcel);
    }

    public static void N(Parcel parcel, int i10, int i11, int i12) {
        if (i11 == i12) {
            return;
        }
        throw new a("Expected size " + i12 + " got " + i11 + " (0x" + Integer.toHexString(i11) + ")", parcel);
    }

    public static void O(Parcel parcel, int i10, int i11) {
        int iK = K(parcel, i10);
        if (iK == i11) {
            return;
        }
        throw new a("Expected size " + i11 + " got " + iK + " (0x" + Integer.toHexString(iK) + ")", parcel);
    }

    public static BigDecimal a(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i11 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iK);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i11);
    }

    public static BigDecimal[] b(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        int i11 = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            byte[] bArrCreateByteArray = parcel.createByteArray();
            bigDecimalArr[i12] = new BigDecimal(new BigInteger(bArrCreateByteArray), parcel.readInt());
        }
        parcel.setDataPosition(iDataPosition + iK);
        return bigDecimalArr;
    }

    public static BigInteger c(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iK);
        return new BigInteger(bArrCreateByteArray);
    }

    public static BigInteger[] d(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        int i11 = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bigIntegerArr[i12] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(iDataPosition + iK);
        return bigIntegerArr;
    }

    public static boolean[] e(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(iDataPosition + iK);
        return zArrCreateBooleanArray;
    }

    public static Bundle f(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iK);
        return bundle;
    }

    public static byte[] g(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iK);
        return bArrCreateByteArray;
    }

    public static byte[][] h(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        int i11 = parcel.readInt();
        byte[][] bArr = new byte[i11][];
        for (int i12 = 0; i12 < i11; i12++) {
            bArr[i12] = parcel.createByteArray();
        }
        parcel.setDataPosition(iDataPosition + iK);
        return bArr;
    }

    public static double[] i(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        double[] dArrCreateDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(iDataPosition + iK);
        return dArrCreateDoubleArray;
    }

    public static float[] j(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        float[] fArrCreateFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(iDataPosition + iK);
        return fArrCreateFloatArray;
    }

    public static int[] k(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iK);
        return iArrCreateIntArray;
    }

    public static ArrayList<Integer> l(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i11 = parcel.readInt();
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(iDataPosition + iK);
        return arrayList;
    }

    public static long[] m(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        long[] jArrCreateLongArray = parcel.createLongArray();
        parcel.setDataPosition(iDataPosition + iK);
        return jArrCreateLongArray;
    }

    public static Parcel n(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(parcel, iDataPosition, iK);
        parcel.setDataPosition(iDataPosition + iK);
        return parcelObtain;
    }

    public static Parcel[] o(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        int i11 = parcel.readInt();
        Parcel[] parcelArr = new Parcel[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = parcel.readInt();
            if (i13 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i13);
                parcelArr[i12] = parcelObtain;
                parcel.setDataPosition(iDataPosition2 + i13);
            } else {
                parcelArr[i12] = null;
            }
        }
        parcel.setDataPosition(iDataPosition + iK);
        return parcelArr;
    }

    public static <T extends Parcelable> T p(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iK);
        return tCreateFromParcel;
    }

    public static String q(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iK);
        return string;
    }

    public static String[] r(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iK);
        return strArrCreateStringArray;
    }

    public static ArrayList<String> s(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iK);
        return arrayListCreateStringArrayList;
    }

    public static <T> T[] t(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iK);
        return tArr;
    }

    public static <T> ArrayList<T> u(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int iK = K(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iK == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iK);
        return arrayListCreateTypedArrayList;
    }

    public static void v(Parcel parcel, int i10) {
        if (parcel.dataPosition() == i10) {
            return;
        }
        throw new a("Overread allowed size end=" + i10, parcel);
    }

    public static int w(int i10) {
        return (char) i10;
    }

    public static boolean x(Parcel parcel, int i10) {
        O(parcel, i10, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean y(Parcel parcel, int i10) {
        int iK = K(parcel, i10);
        if (iK == 0) {
            return null;
        }
        N(parcel, i10, iK, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static double z(Parcel parcel, int i10) {
        O(parcel, i10, 8);
        return parcel.readDouble();
    }
}
