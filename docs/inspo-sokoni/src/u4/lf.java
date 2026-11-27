package u4;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzkg;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class lf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzgf.zzf f16501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f16502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ kf f16504d;

    public lf(kf kfVar) {
        this.f16504d = kfVar;
    }

    public final zzgf.zzf a(String str, zzgf.zzf zzfVar) {
        x5 x5VarE;
        String str2;
        Object obj;
        String strZzg = zzfVar.zzg();
        List<zzgf.zzh> listZzh = zzfVar.zzh();
        this.f16504d.k();
        Long l10 = (Long) we.b0(zzfVar, "_eid");
        boolean z10 = l10 != null;
        if (z10 && strZzg.equals("_ep")) {
            com.google.android.gms.common.internal.r.l(l10);
            this.f16504d.k();
            strZzg = (String) we.b0(zzfVar, "_en");
            if (TextUtils.isEmpty(strZzg)) {
                this.f16504d.zzj().E().b("Extra parameter without an event name. eventId", l10);
                return null;
            }
            if (this.f16501a == null || this.f16502b == null || l10.longValue() != this.f16502b.longValue()) {
                Pair<zzgf.zzf, Long> pairF = this.f16504d.m().F(str, l10);
                if (pairF == null || (obj = pairF.first) == null) {
                    this.f16504d.zzj().E().c("Extra parameter without existing main event. eventName, eventId", strZzg, l10);
                    return null;
                }
                this.f16501a = (zzgf.zzf) obj;
                this.f16503c = ((Long) pairF.second).longValue();
                this.f16504d.k();
                this.f16502b = (Long) we.b0(this.f16501a, "_eid");
            }
            long j10 = this.f16503c - 1;
            this.f16503c = j10;
            if (j10 <= 0) {
                s sVarM = this.f16504d.m();
                sVarM.j();
                sVarM.zzj().G().b("Clearing complex main event info. appId", str);
                try {
                    sVarM.x().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e10) {
                    sVarM.zzj().C().b("Error clearing complex main event", e10);
                }
            } else {
                this.f16504d.m().k0(str, l10, this.f16503c, this.f16501a);
            }
            ArrayList arrayList = new ArrayList();
            for (zzgf.zzh zzhVar : this.f16501a.zzh()) {
                this.f16504d.k();
                if (we.B(zzfVar, zzhVar.zzg()) == null) {
                    arrayList.add(zzhVar);
                }
            }
            if (arrayList.isEmpty()) {
                x5VarE = this.f16504d.zzj().E();
                str2 = "No unique parameters in main event. eventName";
                x5VarE.b(str2, strZzg);
            } else {
                arrayList.addAll(listZzh);
                listZzh = arrayList;
            }
        } else if (z10) {
            this.f16502b = l10;
            this.f16501a = zzfVar;
            this.f16504d.k();
            long jLongValue = ((Long) we.D(zzfVar, "_epc", 0L)).longValue();
            this.f16503c = jLongValue;
            if (jLongValue <= 0) {
                x5VarE = this.f16504d.zzj().E();
                str2 = "Complex event with zero extra param count. eventName";
                x5VarE.b(str2, strZzg);
            } else {
                this.f16504d.m().k0(str, (Long) com.google.android.gms.common.internal.r.l(l10), this.f16503c, zzfVar);
            }
        }
        return (zzgf.zzf) ((zzkg) zzfVar.zzch().zza(strZzg).zzd().zza(listZzh).zzaj());
    }
}
