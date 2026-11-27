package f;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IntentSender f8013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f8014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f8012e = new c(null);
    public static final Parcelable.Creator<f> CREATOR = new b();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentSender f8017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Intent f8018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8020d;

        public a(IntentSender intentSender) {
            k.e(intentSender, "intentSender");
            this.f8017a = intentSender;
        }

        public final f a() {
            return new f(this.f8017a, this.f8018b, this.f8019c, this.f8020d);
        }

        public final a b(Intent intent) {
            this.f8018b = intent;
            return this;
        }

        public final a c(int i10, int i11) {
            this.f8020d = i10;
            this.f8019c = i11;
            return this;
        }
    }

    public static final class b implements Parcelable.Creator<f> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel inParcel) {
            k.e(inParcel, "inParcel");
            return new f(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i10) {
            return new f[i10];
        }
    }

    public static final class c {
        public c() {
        }

        public /* synthetic */ c(g gVar) {
            this();
        }
    }

    public f(IntentSender intentSender, Intent intent, int i10, int i11) {
        k.e(intentSender, "intentSender");
        this.f8013a = intentSender;
        this.f8014b = intent;
        this.f8015c = i10;
        this.f8016d = i11;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(Parcel parcel) {
        k.e(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        k.b(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }

    public final Intent a() {
        return this.f8014b;
    }

    public final int b() {
        return this.f8015c;
    }

    public final int c() {
        return this.f8016d;
    }

    public final IntentSender d() {
        return this.f8013a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        k.e(dest, "dest");
        dest.writeParcelable(this.f8013a, i10);
        dest.writeParcelable(this.f8014b, i10);
        dest.writeInt(this.f8015c);
        dest.writeInt(this.f8016d);
    }
}
