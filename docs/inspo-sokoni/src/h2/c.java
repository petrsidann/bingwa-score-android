package h2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f9595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f9596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f9599h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9600i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9601j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9602k;

    public c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new t.a(), new t.a(), new t.a());
    }

    public c(Parcel parcel, int i10, int i11, String str, t.a<String, Method> aVar, t.a<String, Method> aVar2, t.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f9595d = new SparseIntArray();
        this.f9600i = -1;
        this.f9602k = -1;
        this.f9596e = parcel;
        this.f9597f = i10;
        this.f9598g = i11;
        this.f9601j = i10;
        this.f9599h = str;
    }

    @Override // h2.b
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f9596e.writeInt(-1);
        } else {
            this.f9596e.writeInt(bArr.length);
            this.f9596e.writeByteArray(bArr);
        }
    }

    @Override // h2.b
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f9596e, 0);
    }

    @Override // h2.b
    public void E(int i10) {
        this.f9596e.writeInt(i10);
    }

    @Override // h2.b
    public void G(Parcelable parcelable) {
        this.f9596e.writeParcelable(parcelable, 0);
    }

    @Override // h2.b
    public void I(String str) {
        this.f9596e.writeString(str);
    }

    @Override // h2.b
    public void a() {
        int i10 = this.f9600i;
        if (i10 >= 0) {
            int i11 = this.f9595d.get(i10);
            int iDataPosition = this.f9596e.dataPosition();
            this.f9596e.setDataPosition(i11);
            this.f9596e.writeInt(iDataPosition - i11);
            this.f9596e.setDataPosition(iDataPosition);
        }
    }

    @Override // h2.b
    public b b() {
        Parcel parcel = this.f9596e;
        int iDataPosition = parcel.dataPosition();
        int i10 = this.f9601j;
        if (i10 == this.f9597f) {
            i10 = this.f9598g;
        }
        return new c(parcel, iDataPosition, i10, this.f9599h + "  ", this.f9592a, this.f9593b, this.f9594c);
    }

    @Override // h2.b
    public boolean g() {
        return this.f9596e.readInt() != 0;
    }

    @Override // h2.b
    public byte[] i() {
        int i10 = this.f9596e.readInt();
        if (i10 < 0) {
            return null;
        }
        byte[] bArr = new byte[i10];
        this.f9596e.readByteArray(bArr);
        return bArr;
    }

    @Override // h2.b
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f9596e);
    }

    @Override // h2.b
    public boolean m(int i10) {
        while (this.f9601j < this.f9598g) {
            int i11 = this.f9602k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f9596e.setDataPosition(this.f9601j);
            int i12 = this.f9596e.readInt();
            this.f9602k = this.f9596e.readInt();
            this.f9601j += i12;
        }
        return this.f9602k == i10;
    }

    @Override // h2.b
    public int o() {
        return this.f9596e.readInt();
    }

    @Override // h2.b
    public <T extends Parcelable> T q() {
        return (T) this.f9596e.readParcelable(getClass().getClassLoader());
    }

    @Override // h2.b
    public String s() {
        return this.f9596e.readString();
    }

    @Override // h2.b
    public void w(int i10) {
        a();
        this.f9600i = i10;
        this.f9595d.put(i10, this.f9596e.dataPosition());
        E(0);
        E(i10);
    }

    @Override // h2.b
    public void y(boolean z10) {
        this.f9596e.writeInt(z10 ? 1 : 0);
    }
}
