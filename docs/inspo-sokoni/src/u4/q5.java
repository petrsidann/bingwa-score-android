package u4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class q5 extends f4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p5 f16723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f16724d;

    public q5(k7 k7Var) {
        super(k7Var);
        this.f16723c = new p5(this, zza(), "google_app_measurement_local.db");
    }

    public static long y(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return -1L;
            }
            long j10 = cursorQuery.getLong(0);
            cursorQuery.close();
            return j10;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0054  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f5 A[PHI: r6 r9
  0x00f5: PHI (r6v3 int) = (r6v1 int), (r6v4 int) binds: [B:72:0x0110, B:65:0x00f3] A[DONT_GENERATE, DONT_INLINE]
  0x00f5: PHI (r9v7 android.database.sqlite.SQLiteDatabase) = (r9v6 android.database.sqlite.SQLiteDatabase), (r9v8 android.database.sqlite.SQLiteDatabase) binds: [B:72:0x0110, B:65:0x00f3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:77:0x011c  */
    /* JADX WARN: Code duplicated, block: B:79:0x0121  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    public final boolean A(int i10, byte[] bArr) throws Throwable {
        SQLiteDatabase sQLiteDatabaseH;
        ?? RawQuery;
        long j10;
        j();
        ?? r10 = 0;
        if (this.f16724d) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i10));
        contentValues.put("entry", bArr);
        int i11 = 0;
        int i12 = 5;
        for (int i13 = 5; i11 < i13; i13 = 5) {
            ?? r11 = 0;
             = 0;
            r11 = 0;
            ?? r12 = 0;
            r11 = 0;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabaseH = H();
                try {
                    if (sQLiteDatabaseH == null) {
                        this.f16724d = true;
                        if (sQLiteDatabaseH != null) {
                            sQLiteDatabaseH.close();
                        }
                        return r10;
                    }
                    sQLiteDatabaseH.beginTransaction();
                    RawQuery = sQLiteDatabaseH.rawQuery("select count(1) from messages", null);
                    if (RawQuery != 0) {
                        try {
                            if (RawQuery.moveToFirst()) {
                                j10 = RawQuery.getLong(r10);
                            } else {
                                j10 = 0;
                            }
                        } catch (SQLiteDatabaseLockedException unused) {
                            r12 = RawQuery;
                            SystemClock.sleep(i12);
                            i12 += 20;
                            if (r12 != 0) {
                                r12.close();
                            }
                            if (sQLiteDatabaseH != null) {
                                sQLiteDatabaseH.close();
                            }
                            i11++;
                            r10 = 0;
                        } catch (SQLiteFullException e10) {
                            e = e10;
                            r11 = RawQuery;
                            try {
                                zzj().C().b("Error writing entry; local database full", e);
                                this.f16724d = true;
                                if (r11 != 0) {
                                    r11.close();
                                }
                                if (sQLiteDatabaseH != null) {
                                    sQLiteDatabaseH.close();
                                }
                                i11++;
                                r10 = 0;
                            } catch (Throwable th) {
                                th = th;
                                if (r11 != 0) {
                                    r11.close();
                                }
                                if (sQLiteDatabaseH != null) {
                                    sQLiteDatabaseH.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e11) {
                            e = e11;
                            sQLiteDatabase = sQLiteDatabaseH;
                            RawQuery = RawQuery;
                            if (sQLiteDatabase != null) {
                                try {
                                    if (sQLiteDatabase.inTransaction()) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    sQLiteDatabaseH = sQLiteDatabase;
                                    r11 = RawQuery;
                                    if (r11 != 0) {
                                        r11.close();
                                    }
                                    if (sQLiteDatabaseH != null) {
                                        sQLiteDatabaseH.close();
                                    }
                                    throw th;
                                }
                            }
                            zzj().C().b("Error writing entry to local database", e);
                            this.f16724d = true;
                            if (RawQuery != 0) {
                                RawQuery.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i11++;
                            r10 = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            r11 = RawQuery;
                            if (r11 != 0) {
                                r11.close();
                            }
                            if (sQLiteDatabaseH != null) {
                                sQLiteDatabaseH.close();
                            }
                            throw th;
                        }
                    } else {
                        j10 = 0;
                    }
                    if (j10 >= 100000) {
                        zzj().C().a("Data loss, local db full");
                        long j11 = (100000 - j10) + 1;
                        String[] strArr = new String[1];
                        strArr[r10] = Long.toString(j11);
                        long jDelete = sQLiteDatabaseH.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                        if (jDelete != j11) {
                            zzj().C().d("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j11), Long.valueOf(jDelete), Long.valueOf(j11 - jDelete));
                        }
                    }
                    sQLiteDatabaseH.insertOrThrow("messages", null, contentValues);
                    sQLiteDatabaseH.setTransactionSuccessful();
                    sQLiteDatabaseH.endTransaction();
                    if (RawQuery != 0) {
                        RawQuery.close();
                    }
                    sQLiteDatabaseH.close();
                    return true;
                } catch (SQLiteDatabaseLockedException unused2) {
                } catch (SQLiteFullException e12) {
                    e = e12;
                } catch (SQLiteException e13) {
                    e = e13;
                    RawQuery = 0;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                sQLiteDatabaseH = null;
            } catch (SQLiteFullException e14) {
                e = e14;
                sQLiteDatabaseH = null;
            } catch (SQLiteException e15) {
                e = e15;
                RawQuery = 0;
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabaseH = null;
                if (r11 != 0) {
                    r11.close();
                }
                if (sQLiteDatabaseH != null) {
                    sQLiteDatabaseH.close();
                }
                throw th;
            }
        }
        zzj().G().a("Failed to write entry to local database");
        return false;
    }

    public final boolean B(h hVar) {
        g();
        byte[] bArrM0 = af.m0(hVar);
        if (bArrM0.length <= 131072) {
            return A(2, bArrM0);
        }
        zzj().E().a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean C(n0 n0Var) {
        Parcel parcelObtain = Parcel.obtain();
        n0Var.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return A(0, bArrMarshall);
        }
        zzj().E().a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean D(ze zeVar) {
        Parcel parcelObtain = Parcel.obtain();
        zeVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return A(1, bArrMarshall);
        }
        zzj().E().a("User property too long for local database. Sending directly to service");
        return false;
    }

    public final void E() {
        int iDelete;
        j();
        try {
            SQLiteDatabase sQLiteDatabaseH = H();
            if (sQLiteDatabaseH == null || (iDelete = sQLiteDatabaseH.delete("messages", null, null) + 0) <= 0) {
                return;
            }
            zzj().G().b("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e10) {
            zzj().C().b("Error resetting local analytics data. error", e10);
        }
    }

    public final boolean F() {
        return A(3, new byte[0]);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006a A[PHI: r4
  0x006a: PHI (r4v3 int) = (r4v1 int), (r4v1 int), (r4v4 int) binds: [B:29:0x0061, B:36:0x007c, B:32:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    public final boolean G() {
        j();
        if (this.f16724d || !I()) {
            return false;
        }
        int i10 = 5;
        for (int i11 = 0; i11 < 5; i11++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase sQLiteDatabaseH = H();
                    if (sQLiteDatabaseH == null) {
                        this.f16724d = true;
                        if (sQLiteDatabaseH != null) {
                            sQLiteDatabaseH.close();
                        }
                        return false;
                    }
                    sQLiteDatabaseH.beginTransaction();
                    sQLiteDatabaseH.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    sQLiteDatabaseH.setTransactionSuccessful();
                    sQLiteDatabaseH.endTransaction();
                    sQLiteDatabaseH.close();
                    return true;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(i10);
                    i10 += 20;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            } catch (SQLiteFullException e10) {
                zzj().C().b("Error deleting app launch break from local database", e10);
                this.f16724d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e11) {
                if (0 != 0) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                zzj().C().b("Error deleting app launch break from local database", e11);
                this.f16724d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        zzj().H().a("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    public final SQLiteDatabase H() {
        if (this.f16724d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f16723c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f16724d = true;
        return null;
    }

    public final boolean I() {
        return zza().getDatabasePath("google_app_measurement_local.db").exists();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ j a() {
        return super.a();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ h0 c() {
        return super.c();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ s5 d() {
        return super.d();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ i6 e() {
        return super.e();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ ab f() {
        return super.f();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ af g() {
        return super.g();
    }

    @Override // u4.g5, u4.o8
    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    @Override // u4.g5, u4.o8
    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    @Override // u4.g5, u4.o8
    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ a k() {
        return super.k();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ n5 l() {
        return super.l();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ q5 m() {
        return super.m();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ e9 n() {
        return super.n();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ db o() {
        return super.o();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ kb p() {
        return super.p();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ qb q() {
        return super.q();
    }

    @Override // u4.g5
    public final /* bridge */ /* synthetic */ id r() {
        return super.r();
    }

    @Override // u4.f4
    public final boolean t() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0199 A[Catch: all -> 0x01e1, TryCatch #0 {all -> 0x01e1, blocks: (B:113:0x0193, B:115:0x0199, B:116:0x019c, B:131:0x01c7, B:123:0x01b4), top: B:149:0x0193 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:126:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:128:0x01c0 A[PHI: r8 r15
  0x01c0: PHI (r8v3 int) = (r8v1 int), (r8v1 int), (r8v4 int) binds: [B:119:0x01ae, B:134:0x01d9, B:127:0x01be] A[DONT_GENERATE, DONT_INLINE]
  0x01c0: PHI (r15v6 android.database.sqlite.SQLiteDatabase) = 
  (r15v4 android.database.sqlite.SQLiteDatabase)
  (r15v5 android.database.sqlite.SQLiteDatabase)
  (r15v7 android.database.sqlite.SQLiteDatabase)
 binds: [B:119:0x01ae, B:134:0x01d9, B:127:0x01be] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:133:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:141:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:143:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:149:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x01dc A[SYNTHETIC] */
    public final List<d4.a> z(int i10) throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabaseH;
        String str;
        String[] strArr;
        Parcelable parcelable;
        x5 x5VarC;
        String str2;
        j();
        Cursor cursor = null;
        if (this.f16724d) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!I()) {
            return arrayList;
        }
        int i11 = 5;
        int i12 = 0;
        for (int i13 = 5; i12 < i13; i13 = 5) {
            try {
                sQLiteDatabaseH = H();
                if (sQLiteDatabaseH == null) {
                    try {
                        this.f16724d = true;
                        if (sQLiteDatabaseH != null) {
                            sQLiteDatabaseH.close();
                        }
                        return null;
                    } catch (SQLiteFullException e10) {
                        e = e10;
                        cursorQuery = null;
                        zzj().C().b("Error reading entries from local database", e);
                        this.f16724d = true;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (sQLiteDatabaseH != null) {
                            sQLiteDatabaseH.close();
                        }
                        i12++;
                    } catch (SQLiteException e11) {
                        e = e11;
                        cursorQuery = null;
                        if (sQLiteDatabaseH != null) {
                            try {
                                if (sQLiteDatabaseH.inTransaction()) {
                                    sQLiteDatabaseH.endTransaction();
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursorQuery;
                                sQLiteDatabase = sQLiteDatabaseH;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        }
                        zzj().C().b("Error reading entries from local database", e);
                        this.f16724d = true;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (sQLiteDatabaseH != null) {
                            sQLiteDatabaseH.close();
                        }
                        i12++;
                    }
                } else {
                    try {
                        try {
                            sQLiteDatabaseH.beginTransaction();
                            long jY = y(sQLiteDatabaseH);
                            long j10 = -1;
                            if (jY != -1) {
                                str = "rowid<?";
                                strArr = new String[]{String.valueOf(jY)};
                            } else {
                                str = null;
                                strArr = null;
                            }
                            sQLiteDatabase = sQLiteDatabaseH;
                            try {
                                cursorQuery = sQLiteDatabaseH.query("messages", new String[]{"rowid", "type", "entry"}, str, strArr, null, null, "rowid asc", Integer.toString(100));
                                while (cursorQuery.moveToNext()) {
                                    try {
                                        j10 = cursorQuery.getLong(0);
                                        int i14 = cursorQuery.getInt(1);
                                        byte[] blob = cursorQuery.getBlob(2);
                                        if (i14 == 0) {
                                            Parcel parcelObtain = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain.unmarshall(blob, 0, blob.length);
                                                    parcelObtain.setDataPosition(0);
                                                    parcelable = (n0) n0.CREATOR.createFromParcel(parcelObtain);
                                                    parcelObtain.recycle();
                                                    if (parcelable != null) {
                                                        arrayList.add(parcelable);
                                                    }
                                                } catch (d4.b.a unused) {
                                                    zzj().C().a("Failed to load event from local database");
                                                    parcelObtain.recycle();
                                                }
                                            } catch (Throwable th2) {
                                                parcelObtain.recycle();
                                                throw th2;
                                            }
                                        } else if (i14 == 1) {
                                            Parcel parcelObtain2 = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain2.unmarshall(blob, 0, blob.length);
                                                    parcelObtain2.setDataPosition(0);
                                                    parcelable = (ze) ze.CREATOR.createFromParcel(parcelObtain2);
                                                    parcelObtain2.recycle();
                                                } catch (d4.b.a unused2) {
                                                    zzj().C().a("Failed to load user property from local database");
                                                    parcelObtain2.recycle();
                                                    parcelable = null;
                                                }
                                                if (parcelable != null) {
                                                    arrayList.add(parcelable);
                                                }
                                            } catch (Throwable th3) {
                                                parcelObtain2.recycle();
                                                throw th3;
                                            }
                                        } else if (i14 == 2) {
                                            Parcel parcelObtain3 = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain3.unmarshall(blob, 0, blob.length);
                                                    parcelObtain3.setDataPosition(0);
                                                    parcelable = (h) h.CREATOR.createFromParcel(parcelObtain3);
                                                    parcelObtain3.recycle();
                                                } catch (d4.b.a unused3) {
                                                    zzj().C().a("Failed to load conditional user property from local database");
                                                    parcelObtain3.recycle();
                                                    parcelable = null;
                                                }
                                                if (parcelable != null) {
                                                    arrayList.add(parcelable);
                                                }
                                            } catch (Throwable th4) {
                                                parcelObtain3.recycle();
                                                throw th4;
                                            }
                                        } else {
                                            if (i14 == 3) {
                                                x5VarC = zzj().H();
                                                str2 = "Skipping app launch break";
                                            } else {
                                                x5VarC = zzj().C();
                                                str2 = "Unknown record type in local database";
                                            }
                                            x5VarC.a(str2);
                                        }
                                    } catch (SQLiteDatabaseLockedException unused4) {
                                        sQLiteDatabaseH = sQLiteDatabase;
                                        SystemClock.sleep(i11);
                                        i11 += 20;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseH != null) {
                                            sQLiteDatabaseH.close();
                                        }
                                        i12++;
                                    } catch (SQLiteFullException e12) {
                                        e = e12;
                                        sQLiteDatabaseH = sQLiteDatabase;
                                        zzj().C().b("Error reading entries from local database", e);
                                        this.f16724d = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseH != null) {
                                            sQLiteDatabaseH.close();
                                        }
                                        i12++;
                                    } catch (SQLiteException e13) {
                                        e = e13;
                                        sQLiteDatabaseH = sQLiteDatabase;
                                        if (sQLiteDatabaseH != null) {
                                            if (sQLiteDatabaseH.inTransaction()) {
                                                sQLiteDatabaseH.endTransaction();
                                            }
                                        }
                                        zzj().C().b("Error reading entries from local database", e);
                                        this.f16724d = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseH != null) {
                                            sQLiteDatabaseH.close();
                                        }
                                        i12++;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        cursor = cursorQuery;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        throw th;
                                    }
                                }
                                if (sQLiteDatabase.delete("messages", "rowid <= ?", new String[]{Long.toString(j10)}) < arrayList.size()) {
                                    zzj().C().a("Fewer entries removed from local database than expected");
                                }
                                sQLiteDatabase.setTransactionSuccessful();
                                sQLiteDatabase.endTransaction();
                                cursorQuery.close();
                                sQLiteDatabase.close();
                                return arrayList;
                            } catch (SQLiteDatabaseLockedException unused5) {
                                cursorQuery = null;
                                sQLiteDatabaseH = sQLiteDatabase;
                                SystemClock.sleep(i11);
                                i11 += 20;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                if (sQLiteDatabaseH != null) {
                                    sQLiteDatabaseH.close();
                                }
                                i12++;
                            } catch (SQLiteFullException e14) {
                                e = e14;
                                cursorQuery = null;
                            } catch (SQLiteException e15) {
                                e = e15;
                                cursorQuery = null;
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (SQLiteFullException e16) {
                            e = e16;
                            cursorQuery = null;
                            zzj().C().b("Error reading entries from local database", e);
                            this.f16724d = true;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (sQLiteDatabaseH != null) {
                                sQLiteDatabaseH.close();
                            }
                            i12++;
                        } catch (SQLiteException e17) {
                            e = e17;
                            cursorQuery = null;
                            if (sQLiteDatabaseH != null) {
                                if (sQLiteDatabaseH.inTransaction()) {
                                    sQLiteDatabaseH.endTransaction();
                                }
                            }
                            zzj().C().b("Error reading entries from local database", e);
                            this.f16724d = true;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (sQLiteDatabaseH != null) {
                                sQLiteDatabaseH.close();
                            }
                            i12++;
                        }
                    } catch (SQLiteDatabaseLockedException unused6) {
                        sQLiteDatabase = sQLiteDatabaseH;
                    } catch (Throwable th7) {
                        th = th7;
                        sQLiteDatabase = sQLiteDatabaseH;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteDatabaseLockedException unused7) {
                cursorQuery = null;
                sQLiteDatabaseH = null;
            } catch (SQLiteFullException e18) {
                e = e18;
                cursorQuery = null;
                sQLiteDatabaseH = null;
            } catch (SQLiteException e19) {
                e = e19;
                cursorQuery = null;
                sQLiteDatabaseH = null;
            } catch (Throwable th8) {
                th = th8;
                sQLiteDatabase = null;
            }
        }
        zzj().H().a("Failed to read events from database in reasonable time");
        return null;
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ j4.d zzb() {
        return super.zzb();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ g zzd() {
        return super.zzd();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ v5 zzj() {
        return super.zzj();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ d7 zzl() {
        return super.zzl();
    }
}
