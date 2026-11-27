package c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3105a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f3106b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.a f3107c;

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

    /* JADX INFO: renamed from: c.b$b, reason: collision with other inner class name */
    public class BinderC0058b extends c.a.AbstractBinderC0056a {
        public BinderC0058b() {
        }

        @Override // c.a
        public void h1(int i10, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f3106b;
            if (handler != null) {
                handler.post(bVar.new c(i10, bundle));
            } else {
                bVar.a(i10, bundle);
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f3110b;

        public c(int i10, Bundle bundle) {
            this.f3109a = i10;
            this.f3110b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f3109a, this.f3110b);
        }
    }

    public b(Parcel parcel) {
        this.f3107c = c.a.AbstractBinderC0056a.b(parcel.readStrongBinder());
    }

    public void a(int i10, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        synchronized (this) {
            if (this.f3107c == null) {
                this.f3107c = new BinderC0058b();
            }
            parcel.writeStrongBinder(this.f3107c.asBinder());
        }
    }
}
