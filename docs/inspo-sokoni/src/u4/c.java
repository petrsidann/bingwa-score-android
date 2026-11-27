package u4;

import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzoh;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class c extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zzfw.zzb f16059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ kf f16060h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(kf kfVar, String str, int i10, zzfw.zzb zzbVar) {
        super(str, i10);
        this.f16060h = kfVar;
        this.f16059g = zzbVar;
    }

    @Override // u4.b
    public final int a() {
        return this.f16059g.zzb();
    }

    @Override // u4.b
    public final boolean i() {
        return this.f16059g.zzk();
    }

    @Override // u4.b
    public final boolean j() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x029d  */
    /* JADX WARN: Code duplicated, block: B:107:0x02af  */
    /* JADX WARN: Code duplicated, block: B:112:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:114:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:115:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:117:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:119:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:122:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:129:0x0340  */
    /* JADX WARN: Code duplicated, block: B:130:0x035f  */
    /* JADX WARN: Code duplicated, block: B:164:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x012e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x01e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x0174 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x01ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x015e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x037b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x0210 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x0271 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x0236 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x037d A[EDGE_INSN: B:177:0x037d->B:132:0x037d BREAK  A[LOOP:0: B:47:0x0118->B:53:0x0149], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x02b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x027b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x037d A[EDGE_INSN: B:180:0x037d->B:132:0x037d BREAK  A[LOOP:0: B:47:0x0118->B:53:0x0149], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x0230 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x0275 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x0338 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x0316 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x02f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:187:0x037d A[EDGE_INSN: B:187:0x037d->B:132:0x037d BREAK  A[LOOP:0: B:47:0x0118->B:53:0x0149], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x01eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x01eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x01eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x010b  */
    /* JADX WARN: Code duplicated, block: B:49:0x011e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0149 A[LOOP:0: B:47:0x0118->B:53:0x0149, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x0164  */
    /* JADX WARN: Code duplicated, block: B:61:0x017a  */
    /* JADX WARN: Code duplicated, block: B:63:0x0184  */
    /* JADX WARN: Code duplicated, block: B:64:0x018d A[PHI: r12
  0x018d: PHI (r12v13 java.lang.String) = (r12v12 java.lang.String), (r12v15 java.lang.String) binds: [B:68:0x019d, B:62:0x0182] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:65:0x018f  */
    /* JADX WARN: Code duplicated, block: B:67:0x0195  */
    /* JADX WARN: Code duplicated, block: B:69:0x019f  */
    /* JADX WARN: Code duplicated, block: B:70:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:72:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:79:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:84:0x0205  */
    /* JADX WARN: Code duplicated, block: B:88:0x0228  */
    /* JADX WARN: Code duplicated, block: B:93:0x0257  */
    /* JADX WARN: Code duplicated, block: B:96:0x0269  */
    public final boolean k(Long l10, Long l11, zzgf.zzf zzfVar, long j10, j0 j0Var, boolean z10) {
        HashSet hashSet;
        Iterator<zzfw.zzc> it;
        t.a aVar;
        Iterator<zzgf.zzh> it2;
        Iterator<zzfw.zzc> it3;
        zzfw.zzc next;
        boolean z11;
        String strZze;
        x5 x5VarH;
        String strB;
        String str;
        Object obj;
        x5 x5VarH2;
        String strB2;
        String strF;
        String str2;
        Boolean boolC;
        Boolean boolB;
        v5 v5VarZzj;
        String str3;
        Boolean boolE;
        zzgf.zzh next2;
        String strZzg;
        Object objZzh;
        zzfw.zzc next3;
        boolean z12 = zzoh.zza() && this.f16060h.a().F(this.f16007a, p0.A0);
        long j11 = this.f16059g.zzj() ? j0Var.f16381e : j10;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        Boolean bool = null;
        if (this.f16060h.zzj().y(2)) {
            this.f16060h.zzj().G().d("Evaluating filter. audience, filter, event", Integer.valueOf(this.f16008b), this.f16059g.zzl() ? Integer.valueOf(this.f16059g.zzb()) : null, this.f16060h.d().b(this.f16059g.zzf()));
            this.f16060h.zzj().G().b("Filter definition", this.f16060h.k().E(this.f16059g));
        }
        if (!this.f16059g.zzl() || this.f16059g.zzb() > 256) {
            this.f16060h.zzj().H().c("Invalid event filter ID. appId, id", v5.r(this.f16007a), String.valueOf(this.f16059g.zzl() ? Integer.valueOf(this.f16059g.zzb()) : null));
            return false;
        }
        boolean z13 = this.f16059g.zzh() || this.f16059g.zzi() || this.f16059g.zzj();
        if (z10 && !z13) {
            this.f16060h.zzj().G().c("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f16008b), this.f16059g.zzl() ? Integer.valueOf(this.f16059g.zzb()) : null);
            return true;
        }
        zzfw.zzb zzbVar = this.f16059g;
        String strZzg2 = zzfVar.zzg();
        if (!zzbVar.zzk()) {
            hashSet = new HashSet();
            it = zzbVar.zzg().iterator();
            while (true) {
                if (it.hasNext()) {
                    aVar = new t.a();
                    it2 = zzfVar.zzh().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            it3 = zzbVar.zzg().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                                next = it3.next();
                                if (next.zzg() || !next.zzf()) {
                                    z11 = false;
                                } else {
                                    z11 = true;
                                }
                                strZze = next.zze();
                                if (strZze.isEmpty()) {
                                    x5VarH = this.f16060h.zzj().H();
                                    strB = this.f16060h.d().b(strZzg2);
                                    str = "Event has empty param name. event";
                                } else {
                                    obj = aVar.get(strZze);
                                    if (obj instanceof Long) {
                                        if (!next.zzh()) {
                                            boolC = b.c(((Long) obj).longValue(), next.zzc());
                                            if (boolC != null) {
                                                break;
                                            }
                                            if (boolC.booleanValue() == z11) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else {
                                            x5VarH2 = this.f16060h.zzj().H();
                                            strB2 = this.f16060h.d().b(strZzg2);
                                            strF = this.f16060h.d().f(strZze);
                                            str2 = "No number filter for long param. event, param";
                                        }
                                    } else if (obj instanceof Double) {
                                        if (!next.zzh()) {
                                            boolB = b.b(((Double) obj).doubleValue(), next.zzc());
                                            if (boolB != null) {
                                                break;
                                            }
                                            if (boolB.booleanValue() == z11) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else {
                                            x5VarH2 = this.f16060h.zzj().H();
                                            strB2 = this.f16060h.d().b(strZzg2);
                                            strF = this.f16060h.d().f(strZze);
                                            str2 = "No number filter for double param. event, param";
                                        }
                                    } else if (obj instanceof String) {
                                        if (next.zzj()) {
                                            boolE = b.g((String) obj, next.zzd(), this.f16060h.zzj());
                                        } else if (next.zzh()) {
                                            str3 = (String) obj;
                                            if (we.c0(str3)) {
                                                boolE = b.e(str3, next.zzc());
                                            } else {
                                                x5VarH2 = this.f16060h.zzj().H();
                                                strB2 = this.f16060h.d().b(strZzg2);
                                                strF = this.f16060h.d().f(strZze);
                                                str2 = "Invalid param value for number filter. event, param";
                                            }
                                        } else {
                                            x5VarH2 = this.f16060h.zzj().H();
                                            strB2 = this.f16060h.d().b(strZzg2);
                                            strF = this.f16060h.d().f(strZze);
                                            str2 = "No filter for String param. event, param";
                                        }
                                        if (boolE != null) {
                                            break;
                                        }
                                        if (boolE.booleanValue() == z11) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    } else {
                                        v5VarZzj = this.f16060h.zzj();
                                        if (obj == null) {
                                            v5VarZzj.G().c("Missing param for filter. event, param", this.f16060h.d().b(strZzg2), this.f16060h.d().f(strZze));
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                        x5VarH2 = v5VarZzj.H();
                                        strB2 = this.f16060h.d().b(strZzg2);
                                        strF = this.f16060h.d().f(strZze);
                                        str2 = "Unknown param type. event, param";
                                    }
                                }
                            }
                        } else {
                            next2 = it2.next();
                            if (!hashSet.contains(next2.zzg())) {
                                if (next2.zzl()) {
                                    strZzg = next2.zzg();
                                    if (next2.zzl()) {
                                        objZzh = Long.valueOf(next2.zzd());
                                    } else {
                                        objZzh = null;
                                    }
                                } else if (next2.zzj()) {
                                    strZzg = next2.zzg();
                                    if (next2.zzj()) {
                                        objZzh = Double.valueOf(next2.zza());
                                    } else {
                                        objZzh = null;
                                    }
                                } else if (next2.zzn()) {
                                    strZzg = next2.zzg();
                                    objZzh = next2.zzh();
                                } else {
                                    x5VarH2 = this.f16060h.zzj().H();
                                    strB2 = this.f16060h.d().b(strZzg2);
                                    strF = this.f16060h.d().f(next2.zzg());
                                    str2 = "Unknown value for param. event, param";
                                }
                                aVar.put(strZzg, objZzh);
                            }
                        }
                        x5VarH2.c(str2, strB2, strF);
                        break;
                    }
                }
                next3 = it.next();
                if (next3.zze().isEmpty()) {
                    x5VarH = this.f16060h.zzj().H();
                    strB = this.f16060h.d().b(strZzg2);
                    str = "null or empty param name in filter. event";
                } else {
                    hashSet.add(next3.zze());
                }
                x5VarH.b(str, strB);
                break;
            }
        }
        Boolean boolC2 = b.c(j11, zzbVar.zze());
        if (boolC2 != null) {
            if (!boolC2.booleanValue()) {
                bool = Boolean.FALSE;
                break;
            }
            hashSet = new HashSet();
            it = zzbVar.zzg().iterator();
            while (true) {
                if (it.hasNext()) {
                    aVar = new t.a();
                    it2 = zzfVar.zzh().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            it3 = zzbVar.zzg().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                                next = it3.next();
                                if (next.zzg()) {
                                    z11 = false;
                                } else {
                                    z11 = false;
                                }
                                strZze = next.zze();
                                if (strZze.isEmpty()) {
                                    x5VarH = this.f16060h.zzj().H();
                                    strB = this.f16060h.d().b(strZzg2);
                                    str = "Event has empty param name. event";
                                } else {
                                    obj = aVar.get(strZze);
                                    if (obj instanceof Long) {
                                        if (!next.zzh()) {
                                            boolC = b.c(((Long) obj).longValue(), next.zzc());
                                            if (boolC != null) {
                                                break;
                                                break;
                                            }
                                            if (boolC.booleanValue() == z11) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else {
                                            x5VarH2 = this.f16060h.zzj().H();
                                            strB2 = this.f16060h.d().b(strZzg2);
                                            strF = this.f16060h.d().f(strZze);
                                            str2 = "No number filter for long param. event, param";
                                        }
                                    } else if (obj instanceof Double) {
                                        if (!next.zzh()) {
                                            boolB = b.b(((Double) obj).doubleValue(), next.zzc());
                                            if (boolB != null) {
                                                break;
                                                break;
                                            }
                                            if (boolB.booleanValue() == z11) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else {
                                            x5VarH2 = this.f16060h.zzj().H();
                                            strB2 = this.f16060h.d().b(strZzg2);
                                            strF = this.f16060h.d().f(strZze);
                                            str2 = "No number filter for double param. event, param";
                                        }
                                    } else if (obj instanceof String) {
                                        if (next.zzj()) {
                                            boolE = b.g((String) obj, next.zzd(), this.f16060h.zzj());
                                        } else if (next.zzh()) {
                                            str3 = (String) obj;
                                            if (we.c0(str3)) {
                                                boolE = b.e(str3, next.zzc());
                                            } else {
                                                x5VarH2 = this.f16060h.zzj().H();
                                                strB2 = this.f16060h.d().b(strZzg2);
                                                strF = this.f16060h.d().f(strZze);
                                                str2 = "Invalid param value for number filter. event, param";
                                            }
                                        } else {
                                            x5VarH2 = this.f16060h.zzj().H();
                                            strB2 = this.f16060h.d().b(strZzg2);
                                            strF = this.f16060h.d().f(strZze);
                                            str2 = "No filter for String param. event, param";
                                        }
                                        if (boolE != null) {
                                            break;
                                            break;
                                        }
                                        if (boolE.booleanValue() == z11) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    } else {
                                        v5VarZzj = this.f16060h.zzj();
                                        if (obj == null) {
                                            v5VarZzj.G().c("Missing param for filter. event, param", this.f16060h.d().b(strZzg2), this.f16060h.d().f(strZze));
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                        x5VarH2 = v5VarZzj.H();
                                        strB2 = this.f16060h.d().b(strZzg2);
                                        strF = this.f16060h.d().f(strZze);
                                        str2 = "Unknown param type. event, param";
                                    }
                                }
                            }
                        } else {
                            next2 = it2.next();
                            if (!hashSet.contains(next2.zzg())) {
                                if (next2.zzl()) {
                                    strZzg = next2.zzg();
                                    if (next2.zzl()) {
                                        objZzh = Long.valueOf(next2.zzd());
                                    } else {
                                        objZzh = null;
                                    }
                                } else if (next2.zzj()) {
                                    strZzg = next2.zzg();
                                    if (next2.zzj()) {
                                        objZzh = Double.valueOf(next2.zza());
                                    } else {
                                        objZzh = null;
                                    }
                                } else if (next2.zzn()) {
                                    strZzg = next2.zzg();
                                    objZzh = next2.zzh();
                                } else {
                                    x5VarH2 = this.f16060h.zzj().H();
                                    strB2 = this.f16060h.d().b(strZzg2);
                                    strF = this.f16060h.d().f(next2.zzg());
                                    str2 = "Unknown value for param. event, param";
                                }
                                aVar.put(strZzg, objZzh);
                            }
                        }
                        x5VarH2.c(str2, strB2, strF);
                        break;
                    }
                }
                next3 = it.next();
                if (next3.zze().isEmpty()) {
                    x5VarH = this.f16060h.zzj().H();
                    strB = this.f16060h.d().b(strZzg2);
                    str = "null or empty param name in filter. event";
                } else {
                    hashSet.add(next3.zze());
                }
                x5VarH.b(str, strB);
                break;
            }
        }
        this.f16060h.zzj().G().b("Event filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        Boolean bool2 = Boolean.TRUE;
        this.f16009c = bool2;
        if (!bool.booleanValue()) {
            return true;
        }
        this.f16010d = bool2;
        if (z13 && zzfVar.zzk()) {
            Long lValueOf = Long.valueOf(zzfVar.zzd());
            if (this.f16059g.zzi()) {
                if (z12 && this.f16059g.zzk()) {
                    lValueOf = l10;
                }
                this.f16012f = lValueOf;
            } else {
                if (z12 && this.f16059g.zzk()) {
                    lValueOf = l11;
                }
                this.f16011e = lValueOf;
            }
        }
        return true;
    }
}
