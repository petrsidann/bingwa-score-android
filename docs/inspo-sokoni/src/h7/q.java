package h7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Comparable<q>, Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f9721c = new b(null);
    public static final Parcelable.Creator<q> CREATOR = new a();

    public static final class a implements Parcelable.Creator<q> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public q createFromParcel(Parcel source) {
            kotlin.jvm.internal.k.e(source, "source");
            return new q(source.readLong(), source.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public q[] newArray(int i10) {
            return new q[i10];
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final q c() {
            return new q(new Date());
        }

        public final lc.i<Long, Integer> d(Date date) {
            Long lValueOf;
            long j10 = 1000;
            long time = date.getTime() / j10;
            int time2 = (int) ((date.getTime() % j10) * ((long) 1000000));
            if (time2 < 0) {
                lValueOf = Long.valueOf(time - 1);
                time2 += 1000000000;
            } else {
                lValueOf = Long.valueOf(time);
            }
            return lc.m.a(lValueOf, Integer.valueOf(time2));
        }

        public final void e(long j10, int i10) {
            if (!(i10 >= 0 && i10 < 1000000000)) {
                throw new IllegalArgumentException(("Timestamp nanoseconds out of range: " + i10).toString());
            }
            if (-62135596800L <= j10 && j10 < 253402300800L) {
                return;
            }
            throw new IllegalArgumentException(("Timestamp seconds out of range: " + j10).toString());
        }
    }

    public q(long j10, int i10) {
        f9721c.e(j10, i10);
        this.f9722a = j10;
        this.f9723b = i10;
    }

    public q(Date date) {
        kotlin.jvm.internal.k.e(date, "date");
        b bVar = f9721c;
        lc.i iVarD = bVar.d(date);
        long jLongValue = ((Number) iVarD.a()).longValue();
        int iIntValue = ((Number) iVarD.b()).intValue();
        bVar.e(jLongValue, iIntValue);
        this.f9722a = jLongValue;
        this.f9723b = iIntValue;
    }

    public static final q n() {
        return f9721c.c();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(q other) {
        kotlin.jvm.internal.k.e(other, "other");
        return nc.a.b(this, other, new kotlin.jvm.internal.q() { // from class: h7.q.c
            @Override // kotlin.jvm.internal.q, cd.h
            public Object get(Object obj) {
                return Long.valueOf(((q) obj).k());
            }
        }, new kotlin.jvm.internal.q() { // from class: h7.q.d
            @Override // kotlin.jvm.internal.q, cd.h
            public Object get(Object obj) {
                return Integer.valueOf(((q) obj).h());
            }
        });
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof q) && compareTo((q) obj) == 0);
    }

    public final int h() {
        return this.f9723b;
    }

    public int hashCode() {
        long j10 = this.f9722a;
        return (((((int) j10) * 37 * 37) + ((int) (j10 >> 32))) * 37) + this.f9723b;
    }

    public final long k() {
        return this.f9722a;
    }

    public String toString() {
        return "Timestamp(seconds=" + this.f9722a + ", nanoseconds=" + this.f9723b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        kotlin.jvm.internal.k.e(dest, "dest");
        dest.writeLong(this.f9722a);
        dest.writeInt(this.f9723b);
    }
}
