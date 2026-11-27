package u4;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzkg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f16963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f16964c;

    public y(s sVar, String str) {
        this.f16964c = sVar;
        com.google.android.gms.common.internal.r.f(str);
        this.f16962a = str;
        this.f16963b = -1L;
    }

    public y(s sVar, String str, long j10) {
        this.f16964c = sVar;
        com.google.android.gms.common.internal.r.f(str);
        this.f16962a = str;
        this.f16963b = sVar.D("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j10)}, -1L);
    }

    public final List<w> a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f16964c.x().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{this.f16962a, String.valueOf(this.f16963b)}, null, null, "rowid", "1000");
                if (!cursorQuery.moveToFirst()) {
                    List<w> listEmptyList = Collections.emptyList();
                    cursorQuery.close();
                    return listEmptyList;
                }
                do {
                    long j10 = cursorQuery.getLong(0);
                    long j11 = cursorQuery.getLong(3);
                    boolean z10 = cursorQuery.getLong(5) == 1;
                    byte[] blob = cursorQuery.getBlob(4);
                    if (j10 > this.f16963b) {
                        this.f16963b = j10;
                    }
                    try {
                        zzgf.zzf.zza zzaVar = (zzgf.zzf.zza) we.C(zzgf.zzf.zze(), blob);
                        String string = cursorQuery.getString(1);
                        if (string == null) {
                            string = "";
                        }
                        zzaVar.zza(string).zzb(cursorQuery.getLong(2));
                        arrayList.add(new w(j10, j11, z10, (zzgf.zzf) ((zzkg) zzaVar.zzaj())));
                    } catch (IOException e10) {
                        this.f16964c.zzj().C().c("Data loss. Failed to merge raw event. appId", v5.r(this.f16962a), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e11) {
                this.f16964c.zzj().C().c("Data loss. Error querying raw events batch. appId", v5.r(this.f16962a), e11);
                if (0 != 0) {
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
