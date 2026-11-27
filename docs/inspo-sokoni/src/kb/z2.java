package kb;

import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class z2 {
    public static o7.e a(a1.q qVar) {
        o7.e.a aVarZ = o7.e.Z();
        aVarZ.g(qVar.i());
        if (qVar.e() != null) {
            aVarZ.c(qVar.e());
        }
        if (qVar.h() != null) {
            aVarZ.f(qVar.h());
        }
        aVarZ.d(qVar.f().booleanValue());
        if (qVar.d() != null) {
            aVarZ.b(qVar.d(), qVar.b().booleanValue(), qVar.c());
        }
        if (qVar.g() != null) {
            aVarZ.e(qVar.g());
        }
        return aVarZ.a();
    }

    public static o7.h b(Map<String, Object> map) {
        if (map.get("token") != null) {
            o7.h hVar = u.f12270n.get(Integer.valueOf(((Integer) map.get("token")).intValue()));
            if (hVar != null) {
                return hVar;
            }
            throw v.b();
        }
        Object obj = map.get("signInMethod");
        Objects.requireNonNull(obj);
        String str = (String) obj;
        String str2 = (String) map.get("secret");
        String str3 = (String) map.get("idToken");
        String str4 = (String) map.get("accessToken");
        String str5 = (String) map.get("rawNonce");
        switch (str) {
            case "twitter.com":
                Objects.requireNonNull(str4);
                Objects.requireNonNull(str2);
                return o7.a1.a(str4, str2);
            case "playgames.google.com":
                Object obj2 = map.get("serverAuthCode");
                Objects.requireNonNull(obj2);
                return o7.t0.a((String) obj2);
            case "google.com":
                return o7.g0.a(str3, str4);
            case "facebook.com":
                Objects.requireNonNull(str4);
                return o7.m.a(str4);
            case "oauth":
                Object obj3 = map.get("providerId");
                Objects.requireNonNull(obj3);
                o7.n0.b bVarF = o7.n0.f((String) obj3);
                if (str4 != null) {
                    bVarF.b(str4);
                }
                Objects.requireNonNull(str3);
                if (str5 == null) {
                    bVarF.c(str3);
                } else {
                    bVarF.d(str3, str5);
                }
                return bVarF.a();
            case "phone":
                Object obj4 = map.get("verificationId");
                Objects.requireNonNull(obj4);
                Object obj5 = map.get("smsCode");
                Objects.requireNonNull(obj5);
                return com.google.firebase.auth.b.a((String) obj4, (String) obj5);
            case "password":
                Object obj6 = map.get("email");
                Objects.requireNonNull(obj6);
                Objects.requireNonNull(str2);
                return o7.k.a((String) obj6, str2);
            case "github.com":
                Objects.requireNonNull(str4);
                return o7.e0.a(str4);
            case "emailLink":
                Object obj7 = map.get("email");
                Objects.requireNonNull(obj7);
                Object obj8 = map.get("emailLink");
                Objects.requireNonNull(obj8);
                return o7.k.b((String) obj7, (String) obj8);
            default:
                return null;
        }
    }

    public static List<Object> c(a1.b0 b0Var) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(b0Var.c().n());
        arrayList.add(b0Var.b());
        return arrayList;
    }

    public static List<List<Object>> d(List<o7.j0> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<a1.v> it = e(list).iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().g());
        }
        return arrayList;
    }

    public static List<a1.v> e(List<o7.j0> list) {
        ArrayList arrayList = new ArrayList();
        for (o7.j0 j0Var : list) {
            arrayList.add((j0Var instanceof o7.r0 ? new a1.v.a().e(((o7.r0) j0Var).r()) : new a1.v.a()).b(j0Var.w()).c(Double.valueOf(j0Var.S())).f(j0Var.h()).d(j0Var.T()).a());
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0048 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    public static a1.o f(o7.d dVar) {
        a1.a aVar;
        o7.b bVarB;
        a1.o.a aVar2 = new a1.o.a();
        a1.p.a aVar3 = new a1.p.a();
        int iA = dVar.a();
        if (iA == 0) {
            aVar = a1.a.PASSWORD_RESET;
        } else if (iA == 1) {
            aVar = a1.a.VERIFY_EMAIL;
        } else if (iA == 2) {
            aVar = a1.a.RECOVER_EMAIL;
        } else if (iA == 4) {
            aVar = a1.a.EMAIL_SIGN_IN;
        } else {
            if (iA != 5) {
                if (iA == 6) {
                    aVar = a1.a.REVERT_SECOND_FACTOR_ADDITION;
                }
                bVarB = dVar.b();
                if ((bVarB == null && iA == 1) || iA == 0) {
                    aVar3.b(bVarB.a());
                } else if (iA != 2 || iA == 5) {
                    Objects.requireNonNull(bVarB);
                    o7.a aVar4 = (o7.a) bVarB;
                    aVar3.b(aVar4.a());
                    aVar3.c(aVar4.b());
                }
                aVar2.b(aVar3.a());
                return aVar2.a();
            }
            aVar = a1.a.VERIFY_AND_CHANGE_EMAIL;
        }
        aVar2.c(aVar);
        bVarB = dVar.b();
        if (bVarB == null) {
            if (iA != 2) {
                Objects.requireNonNull(bVarB);
                o7.a aVar5 = (o7.a) bVarB;
                aVar3.b(aVar5.a());
                aVar3.c(aVar5.b());
            } else {
                Objects.requireNonNull(bVarB);
                o7.a aVar6 = (o7.a) bVarB;
                aVar3.b(aVar6.a());
                aVar3.c(aVar6.b());
            }
        } else if (iA != 2) {
            Objects.requireNonNull(bVarB);
            o7.a aVar7 = (o7.a) bVarB;
            aVar3.b(aVar7.a());
            aVar3.c(aVar7.b());
        } else {
            Objects.requireNonNull(bVarB);
            o7.a aVar8 = (o7.a) bVarB;
            aVar3.b(aVar8.a());
            aVar3.c(aVar8.b());
        }
        aVar2.b(aVar3.a());
        return aVar2.a();
    }

    public static a1.r g(o7.g gVar) {
        if (gVar == null) {
            return null;
        }
        a1.r.a aVar = new a1.r.a();
        aVar.b(Boolean.valueOf(gVar.Q()));
        aVar.c(gVar.D());
        aVar.d(gVar.i());
        aVar.e(gVar.v());
        return aVar.a();
    }

    public static a1.s h(o7.h hVar) {
        if (hVar == null) {
            return null;
        }
        int iHashCode = hVar.hashCode();
        u.f12270n.put(Integer.valueOf(iHashCode), hVar);
        a1.s.a aVar = new a1.s.a();
        aVar.d(hVar.S());
        aVar.e(hVar.T());
        aVar.c(Long.valueOf(iHashCode));
        if (hVar instanceof o7.m0) {
            aVar.b(((o7.m0) hVar).V());
        }
        return aVar.a();
    }

    public static a1.a0 i(o7.i iVar) {
        a1.a0.a aVar = new a1.a0.a();
        aVar.b(g(iVar.A()));
        aVar.c(h(iVar.C()));
        aVar.d(j(iVar.N()));
        return aVar.a();
    }

    public static a1.b0 j(o7.a0 a0Var) {
        if (a0Var == null) {
            return null;
        }
        a1.b0.a aVar = new a1.b0.a();
        a1.c0.a aVar2 = new a1.c0.a();
        aVar2.c(a0Var.w());
        aVar2.d(a0Var.P());
        aVar2.f(Boolean.valueOf(a0Var.n()));
        aVar2.e(Boolean.valueOf(a0Var.Y()));
        if (a0Var.U() != null) {
            aVar2.b(Long.valueOf(a0Var.U().s()));
            aVar2.g(Long.valueOf(a0Var.U().x()));
        }
        aVar2.h(a0Var.r());
        aVar2.i(k(a0Var.j()));
        aVar2.k(a0Var.h());
        aVar2.j(a0Var.X());
        aVar.c(aVar2.a());
        aVar.b(m(a0Var.W()));
        return aVar.a();
    }

    public static String k(Uri uri) {
        if (uri == null) {
            return null;
        }
        String string = uri.toString();
        if ("".equals(string)) {
            return null;
        }
        return string;
    }

    public static a1.u l(o7.c0 c0Var) {
        a1.u.a aVar = new a1.u.a();
        aVar.h(c0Var.g());
        aVar.f(c0Var.e());
        aVar.b(Long.valueOf(c0Var.a() * 1000));
        aVar.d(Long.valueOf(c0Var.c() * 1000));
        aVar.e(Long.valueOf(c0Var.d() * 1000));
        aVar.c(c0Var.b());
        aVar.g(c0Var.f());
        return aVar.a();
    }

    public static List<Map<Object, Object>> m(List<? extends o7.b1> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return null;
        }
        for (o7.b1 b1Var : new ArrayList(list)) {
            if (b1Var != null && !"firebase".equals(b1Var.i())) {
                arrayList.add(n(b1Var));
            }
        }
        return arrayList;
    }

    public static Map<Object, Object> n(o7.b1 b1Var) {
        HashMap map = new HashMap();
        map.put("displayName", b1Var.w());
        map.put("email", b1Var.P());
        map.put("isEmailVerified", Boolean.valueOf(b1Var.n()));
        map.put("phoneNumber", b1Var.r());
        map.put("photoUrl", k(b1Var.j()));
        map.put("uid", b1Var.h() == null ? "" : b1Var.h());
        map.put("providerId", b1Var.i());
        map.put("isAnonymous", Boolean.FALSE);
        return map;
    }
}
