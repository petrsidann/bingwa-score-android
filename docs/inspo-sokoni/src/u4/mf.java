package u4;

import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.internal.measurement.zzoh;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class mf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zzgf.zzm f16551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BitSet f16552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BitSet f16553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<Integer, Long> f16554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Integer, List<Long>> f16555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ kf f16556h;

    public mf(kf kfVar, String str) {
        this.f16556h = kfVar;
        this.f16549a = str;
        this.f16550b = true;
        this.f16552d = new BitSet();
        this.f16553e = new BitSet();
        this.f16554f = new t.a();
        this.f16555g = new t.a();
    }

    public mf(kf kfVar, String str, zzgf.zzm zzmVar, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.f16556h = kfVar;
        this.f16549a = str;
        this.f16552d = bitSet;
        this.f16553e = bitSet2;
        this.f16554f = map;
        this.f16555g = new t.a();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.f16555g.put(num, arrayList);
            }
        }
        this.f16550b = false;
        this.f16551c = zzmVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.zzgf$zzd$zza, com.google.android.gms.internal.measurement.zzkg$zza] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.google.android.gms.internal.measurement.zzgf$zzm$zza] */
    public final zzgf.zzd a(int i10) {
        ArrayList arrayList;
        ?? arrayList2;
        ?? Zzb = zzgf.zzd.zzb();
        Zzb.zza(i10);
        Zzb.zza(this.f16550b);
        zzgf.zzm zzmVar = this.f16551c;
        if (zzmVar != null) {
            Zzb.zza(zzmVar);
        }
        ?? Zzd = zzgf.zzm.zze().zzb(we.I(this.f16552d)).zzd(we.I(this.f16553e));
        if (this.f16554f == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.f16554f.size());
            Iterator<Integer> it = this.f16554f.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                Long l10 = this.f16554f.get(Integer.valueOf(iIntValue));
                if (l10 != null) {
                    arrayList.add((zzgf.zze) ((zzkg) zzgf.zze.zzc().zza(iIntValue).zza(l10.longValue()).zzaj()));
                }
            }
        }
        if (arrayList != null) {
            Zzd.zza(arrayList);
        }
        if (this.f16555g == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.f16555g.size());
            for (Integer num : this.f16555g.keySet()) {
                zzgf.zzn.zza zzaVarZza = zzgf.zzn.zzc().zza(num.intValue());
                List<Long> list = this.f16555g.get(num);
                if (list != null) {
                    Collections.sort(list);
                    zzaVarZza.zza(list);
                }
                arrayList2.add((zzgf.zzn) ((zzkg) zzaVarZza.zzaj()));
            }
        }
        Zzd.zzc(arrayList2);
        Zzb.zza(Zzd);
        return (zzgf.zzd) ((zzkg) Zzb.zzaj());
    }

    public final void c(b bVar) {
        int iA = bVar.a();
        Boolean bool = bVar.f16009c;
        if (bool != null) {
            this.f16553e.set(iA, bool.booleanValue());
        }
        Boolean bool2 = bVar.f16010d;
        if (bool2 != null) {
            this.f16552d.set(iA, bool2.booleanValue());
        }
        if (bVar.f16011e != null) {
            Long l10 = this.f16554f.get(Integer.valueOf(iA));
            long jLongValue = bVar.f16011e.longValue() / 1000;
            if (l10 == null || jLongValue > l10.longValue()) {
                this.f16554f.put(Integer.valueOf(iA), Long.valueOf(jLongValue));
            }
        }
        if (bVar.f16012f != null) {
            List<Long> arrayList = this.f16555g.get(Integer.valueOf(iA));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f16555g.put(Integer.valueOf(iA), arrayList);
            }
            if (bVar.j()) {
                arrayList.clear();
            }
            if (zzoh.zza() && this.f16556h.a().F(this.f16549a, p0.A0) && bVar.i()) {
                arrayList.clear();
            }
            if (!zzoh.zza() || !this.f16556h.a().F(this.f16549a, p0.A0)) {
                arrayList.add(Long.valueOf(bVar.f16012f.longValue() / 1000));
                return;
            }
            long jLongValue2 = bVar.f16012f.longValue() / 1000;
            if (arrayList.contains(Long.valueOf(jLongValue2))) {
                return;
            }
            arrayList.add(Long.valueOf(jLongValue2));
        }
    }
}
