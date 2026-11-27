package u4;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.internal.measurement.zzoh;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class kf extends fe {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set<Integer> f16470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<Integer, mf> f16471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f16472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f16473h;

    public kf(ge geVar) {
        super(geVar);
    }

    @Override // u4.fe
    public final boolean t() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:274:0x02fd A[SYNTHETIC] */
    public final List<zzgf.zzd> u(String str, List<zzgf.zzf> list, List<zzgf.zzp> list2, Long l10, Long l11, boolean z10) {
        boolean z11;
        boolean z12;
        d dVar;
        j0 j0Var;
        lf lfVar;
        Map<Integer, zzgf.zzm> map;
        List<zzfw.zzb> list3;
        Map<Integer, zzgf.zzm> map2;
        boolean z13;
        Map<Integer, List<Integer>> map3;
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.l(list);
        com.google.android.gms.common.internal.r.l(list2);
        this.f16469d = str;
        this.f16470e = new HashSet();
        this.f16471f = new t.a();
        this.f16472g = l10;
        this.f16473h = l11;
        Iterator<zzgf.zzf> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z11 = false;
                break;
            }
            if ("_s".equals(it.next().zzg())) {
                z11 = true;
                break;
            }
        }
        boolean z14 = zzoh.zza() && a().F(this.f16469d, p0.A0);
        boolean z15 = zzoh.zza() && a().F(this.f16469d, p0.f16692z0);
        if (z11) {
            s sVarM = m();
            String str2 = this.f16469d;
            sVarM.q();
            sVarM.j();
            com.google.android.gms.common.internal.r.f(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                sVarM.x().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e10) {
                sVarM.zzj().C().c("Error resetting session-scoped event counts. appId", v5.r(str2), e10);
            }
        }
        Map<Integer, List<zzfw.zzb>> mapEmptyMap = Collections.emptyMap();
        if (z15 && z14) {
            mapEmptyMap = m().f1(this.f16469d);
        }
        Map<Integer, zzgf.zzm> mapE1 = m().e1(this.f16469d);
        if (mapE1.isEmpty()) {
            z12 = true;
            dVar = null;
        } else {
            HashSet hashSet = new HashSet(mapE1.keySet());
            if (z11) {
                String str3 = this.f16469d;
                Map<Integer, List<Integer>> mapG1 = m().g1(this.f16469d);
                com.google.android.gms.common.internal.r.f(str3);
                com.google.android.gms.common.internal.r.l(mapE1);
                t.a aVar = new t.a();
                if (!mapE1.isEmpty()) {
                    Iterator<Integer> it2 = mapE1.keySet().iterator();
                    while (it2.hasNext()) {
                        int iIntValue = it2.next().intValue();
                        zzgf.zzm zzmVar = mapE1.get(Integer.valueOf(iIntValue));
                        List<Integer> list4 = mapG1.get(Integer.valueOf(iIntValue));
                        if (list4 == null || list4.isEmpty()) {
                            map3 = mapG1;
                            aVar.put(Integer.valueOf(iIntValue), zzmVar);
                            mapG1 = map3;
                        } else {
                            List<Long> listJ = k().J(zzmVar.zzi(), list4);
                            if (!listJ.isEmpty()) {
                                zzgf.zzm.zza zzaVarZzb = zzmVar.zzch().zzb().zzb(listJ);
                                zzaVarZzb.zzd().zzd(k().J(zzmVar.zzk(), list4));
                                ArrayList arrayList = new ArrayList();
                                for (zzgf.zze zzeVar : zzmVar.zzh()) {
                                    Map<Integer, List<Integer>> map4 = mapG1;
                                    if (!list4.contains(Integer.valueOf(zzeVar.zza()))) {
                                        arrayList.add(zzeVar);
                                    }
                                    mapG1 = map4;
                                }
                                map3 = mapG1;
                                zzaVarZzb.zza().zza(arrayList);
                                ArrayList arrayList2 = new ArrayList();
                                for (zzgf.zzn zznVar : zzmVar.zzj()) {
                                    if (!list4.contains(Integer.valueOf(zznVar.zzb()))) {
                                        arrayList2.add(zznVar);
                                    }
                                }
                                zzaVarZzb.zzc().zzc(arrayList2);
                                aVar.put(Integer.valueOf(iIntValue), (zzgf.zzm) ((zzkg) zzaVarZzb.zzaj()));
                                mapG1 = map3;
                            }
                        }
                    }
                }
                map = aVar;
            } else {
                map = mapE1;
            }
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                int iIntValue2 = ((Integer) it3.next()).intValue();
                zzgf.zzm zzmVar2 = map.get(Integer.valueOf(iIntValue2));
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                t.a aVar2 = new t.a();
                if (zzmVar2 != null && zzmVar2.zza() != 0) {
                    for (zzgf.zze zzeVar2 : zzmVar2.zzh()) {
                        if (zzeVar2.zzf()) {
                            aVar2.put(Integer.valueOf(zzeVar2.zza()), zzeVar2.zze() ? Long.valueOf(zzeVar2.zzb()) : null);
                        }
                    }
                }
                t.a aVar3 = new t.a();
                if (zzmVar2 != null && zzmVar2.zzc() != 0) {
                    for (zzgf.zzn zznVar2 : zzmVar2.zzj()) {
                        if (zznVar2.zzf() && zznVar2.zza() > 0) {
                            aVar3.put(Integer.valueOf(zznVar2.zzb()), Long.valueOf(zznVar2.zza(zznVar2.zza() - 1)));
                        }
                    }
                }
                if (zzmVar2 != null) {
                    int i10 = 0;
                    while (i10 < (zzmVar2.zzd() << 6)) {
                        if (we.Z(zzmVar2.zzk(), i10)) {
                            map2 = map;
                            zzj().G().c("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue2), Integer.valueOf(i10));
                            bitSet2.set(i10);
                            if (we.Z(zzmVar2.zzi(), i10)) {
                                bitSet.set(i10);
                                z13 = true;
                            }
                            if (!z13) {
                                aVar2.remove(Integer.valueOf(i10));
                            }
                            i10++;
                            map = map2;
                        } else {
                            map2 = map;
                        }
                        z13 = false;
                        if (!z13) {
                            aVar2.remove(Integer.valueOf(i10));
                        }
                        i10++;
                        map = map2;
                    }
                }
                Map<Integer, zzgf.zzm> map5 = map;
                zzgf.zzm zzmVar3 = mapE1.get(Integer.valueOf(iIntValue2));
                if (z15 && z14 && (list3 = mapEmptyMap.get(Integer.valueOf(iIntValue2))) != null && this.f16473h != null && this.f16472g != null) {
                    for (zzfw.zzb zzbVar : list3) {
                        int iZzb = zzbVar.zzb();
                        long jLongValue = this.f16473h.longValue() / 1000;
                        if (zzbVar.zzi()) {
                            jLongValue = this.f16472g.longValue() / 1000;
                        }
                        if (aVar2.containsKey(Integer.valueOf(iZzb))) {
                            aVar2.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        }
                        if (aVar3.containsKey(Integer.valueOf(iZzb))) {
                            aVar3.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        }
                    }
                }
                this.f16471f.put(Integer.valueOf(iIntValue2), new mf(this, this.f16469d, zzmVar3, bitSet, bitSet2, aVar2, aVar3));
                it3 = it3;
                map = map5;
            }
            dVar = null;
            z12 = true;
        }
        if (!list.isEmpty()) {
            lf lfVar2 = new lf(this);
            t.a aVar4 = new t.a();
            for (zzgf.zzf zzfVar : list) {
                zzgf.zzf zzfVarA = lfVar2.a(this.f16469d, zzfVar);
                if (zzfVarA != null) {
                    s sVarM2 = m();
                    String str4 = this.f16469d;
                    String strZzg = zzfVarA.zzg();
                    j0 j0VarP0 = sVarM2.P0(str4, zzfVar.zzg());
                    if (j0VarP0 == null) {
                        sVarM2.zzj().H().c("Event aggregate wasn't created during raw event logging. appId, event", v5.r(str4), sVarM2.d().b(strZzg));
                        j0Var = new j0(str4, zzfVar.zzg(), 1L, 1L, 1L, zzfVar.zzd(), 0L, null, null, null, null);
                    } else {
                        j0Var = new j0(j0VarP0.f16377a, j0VarP0.f16378b, j0VarP0.f16379c + 1, j0VarP0.f16380d + 1, j0VarP0.f16381e + 1, j0VarP0.f16382f, j0VarP0.f16383g, j0VarP0.f16384h, j0VarP0.f16385i, j0VarP0.f16386j, j0VarP0.f16387k);
                    }
                    m().c0(j0Var);
                    if (!z10) {
                        long j10 = j0Var.f16379c;
                        String strZzg2 = zzfVarA.zzg();
                        Map<Integer, List<zzfw.zzb>> mapT0 = (Map) aVar4.get(strZzg2);
                        if (mapT0 == null) {
                            mapT0 = m().T0(this.f16469d, strZzg2);
                            aVar4.put(strZzg2, mapT0);
                        }
                        Iterator<Integer> it4 = mapT0.keySet().iterator();
                        while (it4.hasNext()) {
                            int iIntValue3 = it4.next().intValue();
                            if (this.f16470e.contains(Integer.valueOf(iIntValue3))) {
                                zzj().G().b("Skipping failed audience ID", Integer.valueOf(iIntValue3));
                            } else {
                                Iterator<zzfw.zzb> it5 = mapT0.get(Integer.valueOf(iIntValue3)).iterator();
                                boolean zK = z12;
                                while (true) {
                                    if (!it5.hasNext()) {
                                        lfVar = lfVar2;
                                        break;
                                    }
                                    zzfw.zzb next = it5.next();
                                    c cVar = new c(this, this.f16469d, iIntValue3, next);
                                    lfVar = lfVar2;
                                    zK = cVar.k(this.f16472g, this.f16473h, zzfVarA, j10, j0Var, w(iIntValue3, next.zzb()));
                                    if (!zK) {
                                        this.f16470e.add(Integer.valueOf(iIntValue3));
                                        break;
                                    }
                                    v(Integer.valueOf(iIntValue3)).c(cVar);
                                    lfVar2 = lfVar;
                                }
                                if (!zK) {
                                    this.f16470e.add(Integer.valueOf(iIntValue3));
                                }
                                lfVar2 = lfVar;
                            }
                        }
                    }
                }
            }
        }
        if (z10) {
            return new ArrayList();
        }
        if (!list2.isEmpty()) {
            t.a aVar5 = new t.a();
            for (zzgf.zzp zzpVar : list2) {
                String strZzg3 = zzpVar.zzg();
                Map<Integer, List<zzfw.zze>> mapV0 = (Map) aVar5.get(strZzg3);
                if (mapV0 == null) {
                    mapV0 = m().V0(this.f16469d, strZzg3);
                    aVar5.put(strZzg3, mapV0);
                }
                Iterator<Integer> it6 = mapV0.keySet().iterator();
                while (it6.hasNext()) {
                    int iIntValue4 = it6.next().intValue();
                    if (this.f16470e.contains(Integer.valueOf(iIntValue4))) {
                        zzj().G().b("Skipping failed audience ID", Integer.valueOf(iIntValue4));
                        break;
                    }
                    boolean zK2 = z12;
                    for (zzfw.zze zzeVar3 : mapV0.get(Integer.valueOf(iIntValue4))) {
                        if (zzj().y(2)) {
                            zzj().G().d("Evaluating filter. audience, filter, property", Integer.valueOf(iIntValue4), zzeVar3.zzi() ? Integer.valueOf(zzeVar3.zza()) : null, d().g(zzeVar3.zze()));
                            zzj().G().b("Filter definition", k().F(zzeVar3));
                        }
                        if (!zzeVar3.zzi() || zzeVar3.zza() > 256) {
                            zzj().H().c("Invalid property filter ID. appId, id", v5.r(this.f16469d), String.valueOf(zzeVar3.zzi() ? Integer.valueOf(zzeVar3.zza()) : null));
                            zK2 = false;
                            break;
                        }
                        e eVar = new e(this, this.f16469d, iIntValue4, zzeVar3);
                        zK2 = eVar.k(this.f16472g, this.f16473h, zzpVar, w(iIntValue4, zzeVar3.zza()));
                        if (!zK2) {
                            this.f16470e.add(Integer.valueOf(iIntValue4));
                            break;
                        }
                        v(Integer.valueOf(iIntValue4)).c(eVar);
                    }
                    if (!zK2) {
                        this.f16470e.add(Integer.valueOf(iIntValue4));
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Set<Integer> setKeySet = this.f16471f.keySet();
        setKeySet.removeAll(this.f16470e);
        Iterator<Integer> it7 = setKeySet.iterator();
        while (it7.hasNext()) {
            int iIntValue5 = it7.next().intValue();
            mf mfVar = this.f16471f.get(Integer.valueOf(iIntValue5));
            com.google.android.gms.common.internal.r.l(mfVar);
            zzgf.zzd zzdVarA = mfVar.a(iIntValue5);
            arrayList3.add(zzdVarA);
            s sVarM3 = m();
            String str5 = this.f16469d;
            zzgf.zzm zzmVarZzd = zzdVarA.zzd();
            sVarM3.q();
            sVarM3.j();
            com.google.android.gms.common.internal.r.f(str5);
            com.google.android.gms.common.internal.r.l(zzmVarZzd);
            byte[] bArrZzce = zzmVarZzd.zzce();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str5);
            contentValues2.put("audience_id", Integer.valueOf(iIntValue5));
            contentValues2.put("current_results", bArrZzce);
            try {
                try {
                    if (sVarM3.x().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                        sVarM3.zzj().C().b("Failed to insert filter results (got -1). appId", v5.r(str5));
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    sVarM3.zzj().C().c("Error storing filter results. appId", v5.r(str5), e);
                }
            } catch (SQLiteException e12) {
                e = e12;
            }
        }
        return arrayList3;
    }

    public final mf v(Integer num) {
        if (this.f16471f.containsKey(num)) {
            return this.f16471f.get(num);
        }
        mf mfVar = new mf(this, this.f16469d);
        this.f16471f.put(num, mfVar);
        return mfVar;
    }

    public final boolean w(int i10, int i11) {
        mf mfVar = this.f16471f.get(Integer.valueOf(i10));
        if (mfVar == null) {
            return false;
        }
        return mfVar.f16552d.get(i11);
    }
}
