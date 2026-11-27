package i1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f10120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f10121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f10122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f10123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f10125f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f10126l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f10127m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CharSequence f10128n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f10129o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CharSequence f10130p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<String> f10131q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList<String> f10132r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f10133s;

    public class a implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i10) {
            return new b[i10];
        }
    }

    public b(Parcel parcel) {
        this.f10120a = parcel.createIntArray();
        this.f10121b = parcel.createStringArrayList();
        this.f10122c = parcel.createIntArray();
        this.f10123d = parcel.createIntArray();
        this.f10124e = parcel.readInt();
        this.f10125f = parcel.readString();
        this.f10126l = parcel.readInt();
        this.f10127m = parcel.readInt();
        this.f10128n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f10129o = parcel.readInt();
        this.f10130p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f10131q = parcel.createStringArrayList();
        this.f10132r = parcel.createStringArrayList();
        this.f10133s = parcel.readInt() != 0;
    }

    public b(i1.a aVar) {
        int size = aVar.f10378c.size();
        this.f10120a = new int[size * 6];
        if (!aVar.f10384i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f10121b = new ArrayList<>(size);
        this.f10122c = new int[size];
        this.f10123d = new int[size];
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            p0.a aVar2 = aVar.f10378c.get(i10);
            int i12 = i11 + 1;
            this.f10120a[i11] = aVar2.f10395a;
            ArrayList<String> arrayList = this.f10121b;
            p pVar = aVar2.f10396b;
            arrayList.add(pVar != null ? pVar.f10328f : null);
            int[] iArr = this.f10120a;
            int i13 = i12 + 1;
            iArr[i12] = aVar2.f10397c ? 1 : 0;
            int i14 = i13 + 1;
            iArr[i13] = aVar2.f10398d;
            int i15 = i14 + 1;
            iArr[i14] = aVar2.f10399e;
            int i16 = i15 + 1;
            iArr[i15] = aVar2.f10400f;
            iArr[i16] = aVar2.f10401g;
            this.f10122c[i10] = aVar2.f10402h.ordinal();
            this.f10123d[i10] = aVar2.f10403i.ordinal();
            i10++;
            i11 = i16 + 1;
        }
        this.f10124e = aVar.f10383h;
        this.f10125f = aVar.f10386k;
        this.f10126l = aVar.f10115v;
        this.f10127m = aVar.f10387l;
        this.f10128n = aVar.f10388m;
        this.f10129o = aVar.f10389n;
        this.f10130p = aVar.f10390o;
        this.f10131q = aVar.f10391p;
        this.f10132r = aVar.f10392q;
        this.f10133s = aVar.f10393r;
    }

    public final void a(i1.a aVar) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 >= this.f10120a.length) {
                aVar.f10383h = this.f10124e;
                aVar.f10386k = this.f10125f;
                aVar.f10384i = true;
                aVar.f10387l = this.f10127m;
                aVar.f10388m = this.f10128n;
                aVar.f10389n = this.f10129o;
                aVar.f10390o = this.f10130p;
                aVar.f10391p = this.f10131q;
                aVar.f10392q = this.f10132r;
                aVar.f10393r = this.f10133s;
                return;
            }
            p0.a aVar2 = new p0.a();
            int i12 = i10 + 1;
            aVar2.f10395a = this.f10120a[i10];
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i11 + " base fragment #" + this.f10120a[i12]);
            }
            aVar2.f10402h = androidx.lifecycle.g.b.values()[this.f10122c[i11]];
            aVar2.f10403i = androidx.lifecycle.g.b.values()[this.f10123d[i11]];
            int[] iArr = this.f10120a;
            int i13 = i12 + 1;
            if (iArr[i12] == 0) {
                z10 = false;
            }
            aVar2.f10397c = z10;
            int i14 = i13 + 1;
            int i15 = iArr[i13];
            aVar2.f10398d = i15;
            int i16 = i14 + 1;
            int i17 = iArr[i14];
            aVar2.f10399e = i17;
            int i18 = i16 + 1;
            int i19 = iArr[i16];
            aVar2.f10400f = i19;
            int i20 = iArr[i18];
            aVar2.f10401g = i20;
            aVar.f10379d = i15;
            aVar.f10380e = i17;
            aVar.f10381f = i19;
            aVar.f10382g = i20;
            aVar.e(aVar2);
            i11++;
            i10 = i18 + 1;
        }
    }

    public i1.a b(h0 h0Var) {
        i1.a aVar = new i1.a(h0Var);
        a(aVar);
        aVar.f10115v = this.f10126l;
        for (int i10 = 0; i10 < this.f10121b.size(); i10++) {
            String str = this.f10121b.get(i10);
            if (str != null) {
                aVar.f10378c.get(i10).f10396b = h0Var.f0(str);
            }
        }
        aVar.p(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f10120a);
        parcel.writeStringList(this.f10121b);
        parcel.writeIntArray(this.f10122c);
        parcel.writeIntArray(this.f10123d);
        parcel.writeInt(this.f10124e);
        parcel.writeString(this.f10125f);
        parcel.writeInt(this.f10126l);
        parcel.writeInt(this.f10127m);
        TextUtils.writeToParcel(this.f10128n, parcel, 0);
        parcel.writeInt(this.f10129o);
        TextUtils.writeToParcel(this.f10130p, parcel, 0);
        parcel.writeStringList(this.f10131q);
        parcel.writeStringList(this.f10132r);
        parcel.writeInt(this.f10133s ? 1 : 0);
    }
}
