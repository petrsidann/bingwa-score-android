package d4;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static <T extends d> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        r.l(creator);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        T tCreateFromParcel = creator.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return tCreateFromParcel;
    }

    public static <T extends d> T b(Intent intent, String str, Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return (T) a(byteArrayExtra, creator);
    }

    public static <T extends d> T c(String str, Parcelable.Creator<T> creator) {
        return (T) a(j4.c.a(str), creator);
    }

    public static <T extends d> byte[] d(T t10) {
        Parcel parcelObtain = Parcel.obtain();
        t10.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public static <T extends d> void e(T t10, Intent intent, String str) {
        intent.putExtra(str, d(t10));
    }

    public static <T extends d> String f(T t10) {
        return j4.c.d(d(t10));
    }
}
