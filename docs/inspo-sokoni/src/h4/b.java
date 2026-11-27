package h4;

import android.os.Parcel;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends a implements d4.d {
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        a aVar = (a) obj;
        for (a.C0159a<?, ?> c0159a : getFieldMappings().values()) {
            if (isFieldSet(c0159a)) {
                if (!aVar.isFieldSet(c0159a) || !p.b(getFieldValue(c0159a), aVar.getFieldValue(c0159a))) {
                    return false;
                }
            } else if (aVar.isFieldSet(c0159a)) {
                return false;
            }
        }
        return true;
    }

    @Override // h4.a
    public Object getValueObject(String str) {
        return null;
    }

    public int hashCode() {
        int iHashCode = 0;
        for (a.C0159a<?, ?> c0159a : getFieldMappings().values()) {
            if (isFieldSet(c0159a)) {
                iHashCode = (iHashCode * 31) + r.l(getFieldValue(c0159a)).hashCode();
            }
        }
        return iHashCode;
    }

    @Override // h4.a
    public boolean isPrimitiveFieldSet(String str) {
        return false;
    }

    public byte[] toByteArray() {
        Parcel parcelObtain = Parcel.obtain();
        writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }
}
