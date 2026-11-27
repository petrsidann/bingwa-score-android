package kb;

import android.util.Log;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a1 {

    public enum a {
        UNKNOWN(0),
        PASSWORD_RESET(1),
        VERIFY_EMAIL(2),
        RECOVER_EMAIL(3),
        EMAIL_SIGN_IN(4),
        VERIFY_AND_CHANGE_EMAIL(5),
        REVERT_SECOND_FACTOR_ADDITION(6);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11953a;

        a(int i10) {
            this.f11953a = i10;
        }
    }

    public static final class a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b0 f11954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r f11955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s f11956c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public b0 f11957a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public r f11958b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public s f11959c;

            public a0 a() {
                a0 a0Var = new a0();
                a0Var.d(this.f11957a);
                a0Var.b(this.f11958b);
                a0Var.c(this.f11959c);
                return a0Var;
            }

            public a b(r rVar) {
                this.f11958b = rVar;
                return this;
            }

            public a c(s sVar) {
                this.f11959c = sVar;
                return this;
            }

            public a d(b0 b0Var) {
                this.f11957a = b0Var;
                return this;
            }
        }

        public static a0 a(ArrayList<Object> arrayList) {
            a0 a0Var = new a0();
            a0Var.d((b0) arrayList.get(0));
            a0Var.b((r) arrayList.get(1));
            a0Var.c((s) arrayList.get(2));
            return a0Var;
        }

        public void b(r rVar) {
            this.f11955b = rVar;
        }

        public void c(s sVar) {
            this.f11956c = sVar;
        }

        public void d(b0 b0Var) {
            this.f11954a = b0Var;
        }

        public ArrayList<Object> e() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f11954a);
            arrayList.add(this.f11955b);
            arrayList.add(this.f11956c);
            return arrayList;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11962c;

        public static b a(ArrayList<Object> arrayList) {
            b bVar = new b();
            bVar.e((String) arrayList.get(0));
            bVar.g((String) arrayList.get(1));
            bVar.f((String) arrayList.get(2));
            return bVar;
        }

        public String b() {
            return this.f11960a;
        }

        public String c() {
            return this.f11962c;
        }

        public String d() {
            return this.f11961b;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"appName\" is null.");
            }
            this.f11960a = str;
        }

        public void f(String str) {
            this.f11962c = str;
        }

        public void g(String str) {
            this.f11961b = str;
        }

        public ArrayList<Object> h() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f11960a);
            arrayList.add(this.f11961b);
            arrayList.add(this.f11962c);
            return arrayList;
        }
    }

    public static final class b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c0 f11963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Map<Object, Object>> f11964b;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public c0 f11965a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List<Map<Object, Object>> f11966b;

            public b0 a() {
                b0 b0Var = new b0();
                b0Var.e(this.f11965a);
                b0Var.d(this.f11966b);
                return b0Var;
            }

            public a b(List<Map<Object, Object>> list) {
                this.f11966b = list;
                return this;
            }

            public a c(c0 c0Var) {
                this.f11965a = c0Var;
                return this;
            }
        }

        public static b0 a(ArrayList<Object> arrayList) {
            b0 b0Var = new b0();
            b0Var.e((c0) arrayList.get(0));
            b0Var.d((List) arrayList.get(1));
            return b0Var;
        }

        public List<Map<Object, Object>> b() {
            return this.f11964b;
        }

        public c0 c() {
            return this.f11963a;
        }

        public void d(List<Map<Object, Object>> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"providerData\" is null.");
            }
            this.f11964b = list;
        }

        public void e(c0 c0Var) {
            if (c0Var == null) {
                throw new IllegalStateException("Nonnull field \"userInfo\" is null.");
            }
            this.f11963a = c0Var;
        }

        public ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f11963a);
            arrayList.add(this.f11964b);
            return arrayList;
        }
    }

    public interface c {

        public class a implements f0<a0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11967a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11968b;

            public a(ArrayList arrayList, fb.a.e eVar) {
                this.f11967a = arrayList;
                this.f11968b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f11968b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a0 a0Var) {
                this.f11967a.add(0, a0Var);
                this.f11968b.a(this.f11967a);
            }
        }

        public class b implements f0<a0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11969a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11970b;

            public b(ArrayList arrayList, fb.a.e eVar) {
                this.f11969a = arrayList;
                this.f11970b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f11970b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a0 a0Var) {
                this.f11969a.add(0, a0Var);
                this.f11970b.a(this.f11969a);
            }
        }

        /* JADX INFO: renamed from: kb.a1$c$c, reason: collision with other inner class name */
        public class C0204c implements f0<a0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11971a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11972b;

            public C0204c(ArrayList arrayList, fb.a.e eVar) {
                this.f11971a = arrayList;
                this.f11972b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f11972b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a0 a0Var) {
                this.f11971a.add(0, a0Var);
                this.f11972b.a(this.f11971a);
            }
        }

        public class d implements f0<a0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11973a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11974b;

            public d(ArrayList arrayList, fb.a.e eVar) {
                this.f11973a = arrayList;
                this.f11974b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f11974b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a0 a0Var) {
                this.f11973a.add(0, a0Var);
                this.f11974b.a(this.f11973a);
            }
        }

        public class e implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11975a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11976b;

            public e(ArrayList arrayList, fb.a.e eVar) {
                this.f11975a = arrayList;
                this.f11976b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f11975a.add(0, null);
                this.f11976b.a(this.f11975a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f11976b.a(a1.a(th));
            }
        }

        public class f implements f0<List<String>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11977a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11978b;

            public f(ArrayList arrayList, fb.a.e eVar) {
                this.f11977a = arrayList;
                this.f11978b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f11978b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(List<String> list) {
                this.f11977a.add(0, list);
                this.f11978b.a(this.f11977a);
            }
        }

        public class g implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11979a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11980b;

            public g(ArrayList arrayList, fb.a.e eVar) {
                this.f11979a = arrayList;
                this.f11980b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f11979a.add(0, null);
                this.f11980b.a(this.f11979a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f11980b.a(a1.a(th));
            }
        }

        public class h implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11981a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11982b;

            public h(ArrayList arrayList, fb.a.e eVar) {
                this.f11981a = arrayList;
                this.f11982b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f11981a.add(0, null);
                this.f11982b.a(this.f11981a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f11982b.a(a1.a(th));
            }
        }

        public class i implements f0<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11983a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11984b;

            public i(ArrayList arrayList, fb.a.e eVar) {
                this.f11983a = arrayList;
                this.f11984b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f11984b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f11983a.add(0, str);
                this.f11984b.a(this.f11983a);
            }
        }

        public class j implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11985a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11986b;

            public j(ArrayList arrayList, fb.a.e eVar) {
                this.f11985a = arrayList;
                this.f11986b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f11985a.add(0, null);
                this.f11986b.a(this.f11985a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f11986b.a(a1.a(th));
            }
        }

        public class k implements f0<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11987a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11988b;

            public k(ArrayList arrayList, fb.a.e eVar) {
                this.f11987a = arrayList;
                this.f11988b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f11988b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f11987a.add(0, str);
                this.f11988b.a(this.f11987a);
            }
        }

        public class l implements f0<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11989a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11990b;

            public l(ArrayList arrayList, fb.a.e eVar) {
                this.f11989a = arrayList;
                this.f11990b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f11990b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f11989a.add(0, str);
                this.f11990b.a(this.f11989a);
            }
        }

        public class m implements f0<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11991a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11992b;

            public m(ArrayList arrayList, fb.a.e eVar) {
                this.f11991a = arrayList;
                this.f11992b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f11992b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f11991a.add(0, str);
                this.f11992b.a(this.f11991a);
            }
        }

        public class n implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11993a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11994b;

            public n(ArrayList arrayList, fb.a.e eVar) {
                this.f11993a = arrayList;
                this.f11994b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f11993a.add(0, null);
                this.f11994b.a(this.f11993a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f11994b.a(a1.a(th));
            }
        }

        public class o implements f0<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11995a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11996b;

            public o(ArrayList arrayList, fb.a.e eVar) {
                this.f11995a = arrayList;
                this.f11996b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f11996b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f11995a.add(0, str);
                this.f11996b.a(this.f11995a);
            }
        }

        public class p implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11997a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f11998b;

            public p(ArrayList arrayList, fb.a.e eVar) {
                this.f11997a = arrayList;
                this.f11998b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f11997a.add(0, null);
                this.f11998b.a(this.f11997a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f11998b.a(a1.a(th));
            }
        }

        public class q implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f11999a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12000b;

            public q(ArrayList arrayList, fb.a.e eVar) {
                this.f11999a = arrayList;
                this.f12000b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f11999a.add(0, null);
                this.f12000b.a(this.f11999a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f12000b.a(a1.a(th));
            }
        }

        public class r implements f0<o> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12001a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12002b;

            public r(ArrayList arrayList, fb.a.e eVar) {
                this.f12001a = arrayList;
                this.f12002b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12002b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(o oVar) {
                this.f12001a.add(0, oVar);
                this.f12002b.a(this.f12001a);
            }
        }

        public class s implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12003a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12004b;

            public s(ArrayList arrayList, fb.a.e eVar) {
                this.f12003a = arrayList;
                this.f12004b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f12003a.add(0, null);
                this.f12004b.a(this.f12003a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f12004b.a(a1.a(th));
            }
        }

        public class t implements f0<a0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12005a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12006b;

            public t(ArrayList arrayList, fb.a.e eVar) {
                this.f12005a = arrayList;
                this.f12006b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12006b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a0 a0Var) {
                this.f12005a.add(0, a0Var);
                this.f12006b.a(this.f12005a);
            }
        }

        public class u implements f0<a0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12007a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12008b;

            public u(ArrayList arrayList, fb.a.e eVar) {
                this.f12007a = arrayList;
                this.f12008b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12008b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a0 a0Var) {
                this.f12007a.add(0, a0Var);
                this.f12008b.a(this.f12007a);
            }
        }

        public class v implements f0<a0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12009a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12010b;

            public v(ArrayList arrayList, fb.a.e eVar) {
                this.f12009a = arrayList;
                this.f12010b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12010b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a0 a0Var) {
                this.f12009a.add(0, a0Var);
                this.f12010b.a(this.f12009a);
            }
        }

        static /* synthetic */ void C(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.J((b) arrayList.get(0), (y) arrayList.get(1), new d(new ArrayList(), eVar));
        }

        static /* synthetic */ void G(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            b bVar = (b) arrayList2.get(0);
            String str = (String) arrayList2.get(1);
            Number number = (Number) arrayList2.get(2);
            cVar.c0(bVar, str, number == null ? null : Long.valueOf(number.longValue()), new p(arrayList, eVar));
        }

        static /* synthetic */ void K(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.A((b) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new s(new ArrayList(), eVar));
        }

        static /* synthetic */ void M(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.f0((b) arrayList.get(0), (String) arrayList.get(1), new i(new ArrayList(), eVar));
        }

        static /* synthetic */ void N(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.k((b) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new b(new ArrayList(), eVar));
        }

        static /* synthetic */ void O(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.E((b) arrayList.get(0), (String) arrayList.get(1), new r(new ArrayList(), eVar));
        }

        static /* synthetic */ void S(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.i0((b) arrayList.get(0), (t) arrayList.get(1), new j(new ArrayList(), eVar));
        }

        static /* synthetic */ void U(c cVar, Object obj, fb.a.e eVar) {
            cVar.n((b) ((ArrayList) obj).get(0), new u(new ArrayList(), eVar));
        }

        static void X(fb.b bVar, c cVar) {
            Z(bVar, "", cVar);
        }

        static void Z(fb.b bVar, String str, final c cVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            fb.a aVar = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.registerIdTokenListener" + str2, a());
            if (cVar != null) {
                aVar.e(new fb.a.d() { // from class: kb.b1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.p(this.f12186a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            fb.a aVar2 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.registerAuthStateListener" + str2, a());
            if (cVar != null) {
                aVar2.e(new fb.a.d() { // from class: kb.d1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.g(this.f12196a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            fb.a aVar3 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.useEmulator" + str2, a());
            if (cVar != null) {
                aVar3.e(new fb.a.d() { // from class: kb.g1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.G(this.f12211a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            fb.a aVar4 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.applyActionCode" + str2, a());
            if (cVar != null) {
                aVar4.e(new fb.a.d() { // from class: kb.h1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.u(this.f12215a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            fb.a aVar5 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.checkActionCode" + str2, a());
            if (cVar != null) {
                aVar5.e(new fb.a.d() { // from class: kb.i1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.O(this.f12219a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
            fb.a aVar6 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.confirmPasswordReset" + str2, a());
            if (cVar != null) {
                aVar6.e(new fb.a.d() { // from class: kb.j1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.K(this.f12223a, obj, eVar);
                    }
                });
            } else {
                aVar6.e(null);
            }
            fb.a aVar7 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.createUserWithEmailAndPassword" + str2, a());
            if (cVar != null) {
                aVar7.e(new fb.a.d() { // from class: kb.k1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.g0(this.f12227a, obj, eVar);
                    }
                });
            } else {
                aVar7.e(null);
            }
            fb.a aVar8 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInAnonymously" + str2, a());
            if (cVar != null) {
                aVar8.e(new fb.a.d() { // from class: kb.l1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.U(this.f12233a, obj, eVar);
                    }
                });
            } else {
                aVar8.e(null);
            }
            fb.a aVar9 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithCredential" + str2, a());
            if (cVar != null) {
                aVar9.e(new fb.a.d() { // from class: kb.n1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.o(this.f12241a, obj, eVar);
                    }
                });
            } else {
                aVar9.e(null);
            }
            fb.a aVar10 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithCustomToken" + str2, a());
            if (cVar != null) {
                aVar10.e(new fb.a.d() { // from class: kb.o1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.s(this.f12247a, obj, eVar);
                    }
                });
            } else {
                aVar10.e(null);
            }
            fb.a aVar11 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithEmailAndPassword" + str2, a());
            if (cVar != null) {
                aVar11.e(new fb.a.d() { // from class: kb.m1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.N(this.f12236a, obj, eVar);
                    }
                });
            } else {
                aVar11.e(null);
            }
            fb.a aVar12 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithEmailLink" + str2, a());
            if (cVar != null) {
                aVar12.e(new fb.a.d() { // from class: kb.p1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.t(this.f12252a, obj, eVar);
                    }
                });
            } else {
                aVar12.e(null);
            }
            fb.a aVar13 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithProvider" + str2, a());
            if (cVar != null) {
                aVar13.e(new fb.a.d() { // from class: kb.q1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.C(this.f12256a, obj, eVar);
                    }
                });
            } else {
                aVar13.e(null);
            }
            fb.a aVar14 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signOut" + str2, a());
            if (cVar != null) {
                aVar14.e(new fb.a.d() { // from class: kb.r1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.c(this.f12260a, obj, eVar);
                    }
                });
            } else {
                aVar14.e(null);
            }
            fb.a aVar15 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.fetchSignInMethodsForEmail" + str2, a());
            if (cVar != null) {
                aVar15.e(new fb.a.d() { // from class: kb.s1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.q(this.f12264a, obj, eVar);
                    }
                });
            } else {
                aVar15.e(null);
            }
            fb.a aVar16 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.sendPasswordResetEmail" + str2, a());
            if (cVar != null) {
                aVar16.e(new fb.a.d() { // from class: kb.t1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.e0(this.f12268a, obj, eVar);
                    }
                });
            } else {
                aVar16.e(null);
            }
            fb.a aVar17 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.sendSignInLinkToEmail" + str2, a());
            if (cVar != null) {
                aVar17.e(new fb.a.d() { // from class: kb.u1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.p0(this.f12280a, obj, eVar);
                    }
                });
            } else {
                aVar17.e(null);
            }
            fb.a aVar18 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.setLanguageCode" + str2, a());
            if (cVar != null) {
                aVar18.e(new fb.a.d() { // from class: kb.v1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.M(this.f12283a, obj, eVar);
                    }
                });
            } else {
                aVar18.e(null);
            }
            fb.a aVar19 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.setSettings" + str2, a());
            if (cVar != null) {
                aVar19.e(new fb.a.d() { // from class: kb.w1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.S(this.f12291a, obj, eVar);
                    }
                });
            } else {
                aVar19.e(null);
            }
            fb.a aVar20 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.verifyPasswordResetCode" + str2, a());
            if (cVar != null) {
                aVar20.e(new fb.a.d() { // from class: kb.c1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.w(this.f12191a, obj, eVar);
                    }
                });
            } else {
                aVar20.e(null);
            }
            fb.a aVar21 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.verifyPhoneNumber" + str2, a());
            if (cVar != null) {
                aVar21.e(new fb.a.d() { // from class: kb.e1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.b0(this.f12201a, obj, eVar);
                    }
                });
            } else {
                aVar21.e(null);
            }
            fb.a aVar22 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.revokeTokenWithAuthorizationCode" + str2, a());
            if (cVar != null) {
                aVar22.e(new fb.a.d() { // from class: kb.f1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.c.h0(this.f12206a, obj, eVar);
                    }
                });
            } else {
                aVar22.e(null);
            }
        }

        static fb.h<Object> a() {
            return d.f12035d;
        }

        static /* synthetic */ void b0(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.h((b) arrayList.get(0), (e0) arrayList.get(1), new m(new ArrayList(), eVar));
        }

        static /* synthetic */ void c(c cVar, Object obj, fb.a.e eVar) {
            cVar.L((b) ((ArrayList) obj).get(0), new e(new ArrayList(), eVar));
        }

        static /* synthetic */ void e0(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.x((b) arrayList.get(0), (String) arrayList.get(1), (q) arrayList.get(2), new g(new ArrayList(), eVar));
        }

        static /* synthetic */ void g(c cVar, Object obj, fb.a.e eVar) {
            cVar.R((b) ((ArrayList) obj).get(0), new o(new ArrayList(), eVar));
        }

        static /* synthetic */ void g0(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.a0((b) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new t(new ArrayList(), eVar));
        }

        static /* synthetic */ void h0(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.d((b) arrayList.get(0), (String) arrayList.get(1), new n(new ArrayList(), eVar));
        }

        static /* synthetic */ void o(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.v((b) arrayList.get(0), (Map) arrayList.get(1), new v(new ArrayList(), eVar));
        }

        static /* synthetic */ void p(c cVar, Object obj, fb.a.e eVar) {
            cVar.i((b) ((ArrayList) obj).get(0), new k(new ArrayList(), eVar));
        }

        static /* synthetic */ void p0(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.P((b) arrayList.get(0), (String) arrayList.get(1), (q) arrayList.get(2), new h(new ArrayList(), eVar));
        }

        static /* synthetic */ void q(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.f((b) arrayList.get(0), (String) arrayList.get(1), new f(new ArrayList(), eVar));
        }

        static /* synthetic */ void s(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.W((b) arrayList.get(0), (String) arrayList.get(1), new a(new ArrayList(), eVar));
        }

        static /* synthetic */ void t(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.o0((b) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new C0204c(new ArrayList(), eVar));
        }

        static /* synthetic */ void u(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.e((b) arrayList.get(0), (String) arrayList.get(1), new q(new ArrayList(), eVar));
        }

        static /* synthetic */ void w(c cVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            cVar.I((b) arrayList.get(0), (String) arrayList.get(1), new l(new ArrayList(), eVar));
        }

        void A(b bVar, String str, String str2, g0 g0Var);

        void E(b bVar, String str, f0<o> f0Var);

        void I(b bVar, String str, f0<String> f0Var);

        void J(b bVar, y yVar, f0<a0> f0Var);

        void L(b bVar, g0 g0Var);

        void P(b bVar, String str, q qVar, g0 g0Var);

        void R(b bVar, f0<String> f0Var);

        void W(b bVar, String str, f0<a0> f0Var);

        void a0(b bVar, String str, String str2, f0<a0> f0Var);

        void c0(b bVar, String str, Long l10, g0 g0Var);

        void d(b bVar, String str, g0 g0Var);

        void e(b bVar, String str, g0 g0Var);

        void f(b bVar, String str, f0<List<String>> f0Var);

        void f0(b bVar, String str, f0<String> f0Var);

        void h(b bVar, e0 e0Var, f0<String> f0Var);

        void i(b bVar, f0<String> f0Var);

        void i0(b bVar, t tVar, g0 g0Var);

        void k(b bVar, String str, String str2, f0<a0> f0Var);

        void n(b bVar, f0<a0> f0Var);

        void o0(b bVar, String str, String str2, f0<a0> f0Var);

        void v(b bVar, Map<String, Object> map, f0<a0> f0Var);

        void x(b bVar, String str, q qVar, g0 g0Var);
    }

    public static final class c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f12014d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f12015e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f12016f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Boolean f12017g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f12018h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f12019i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f12020j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Long f12021k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Long f12022l;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f12023a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f12024b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f12025c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f12026d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f12027e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Boolean f12028f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public Boolean f12029g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f12030h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public String f12031i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public String f12032j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public Long f12033k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public Long f12034l;

            public c0 a() {
                c0 c0Var = new c0();
                c0Var.m(this.f12023a);
                c0Var.d(this.f12024b);
                c0Var.c(this.f12025c);
                c0Var.i(this.f12026d);
                c0Var.h(this.f12027e);
                c0Var.e(this.f12028f);
                c0Var.f(this.f12029g);
                c0Var.j(this.f12030h);
                c0Var.l(this.f12031i);
                c0Var.k(this.f12032j);
                c0Var.b(this.f12033k);
                c0Var.g(this.f12034l);
                return c0Var;
            }

            public a b(Long l10) {
                this.f12033k = l10;
                return this;
            }

            public a c(String str) {
                this.f12025c = str;
                return this;
            }

            public a d(String str) {
                this.f12024b = str;
                return this;
            }

            public a e(Boolean bool) {
                this.f12028f = bool;
                return this;
            }

            public a f(Boolean bool) {
                this.f12029g = bool;
                return this;
            }

            public a g(Long l10) {
                this.f12034l = l10;
                return this;
            }

            public a h(String str) {
                this.f12027e = str;
                return this;
            }

            public a i(String str) {
                this.f12026d = str;
                return this;
            }

            public a j(String str) {
                this.f12031i = str;
                return this;
            }

            public a k(String str) {
                this.f12023a = str;
                return this;
            }
        }

        public static c0 a(ArrayList<Object> arrayList) {
            Long lValueOf;
            c0 c0Var = new c0();
            c0Var.m((String) arrayList.get(0));
            c0Var.d((String) arrayList.get(1));
            c0Var.c((String) arrayList.get(2));
            c0Var.i((String) arrayList.get(3));
            c0Var.h((String) arrayList.get(4));
            c0Var.e((Boolean) arrayList.get(5));
            c0Var.f((Boolean) arrayList.get(6));
            c0Var.j((String) arrayList.get(7));
            c0Var.l((String) arrayList.get(8));
            c0Var.k((String) arrayList.get(9));
            Object obj = arrayList.get(10);
            Long lValueOf2 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            c0Var.b(lValueOf);
            Object obj2 = arrayList.get(11);
            if (obj2 != null) {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            c0Var.g(lValueOf2);
            return c0Var;
        }

        public void b(Long l10) {
            this.f12021k = l10;
        }

        public void c(String str) {
            this.f12013c = str;
        }

        public void d(String str) {
            this.f12012b = str;
        }

        public void e(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isAnonymous\" is null.");
            }
            this.f12016f = bool;
        }

        public void f(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isEmailVerified\" is null.");
            }
            this.f12017g = bool;
        }

        public void g(Long l10) {
            this.f12022l = l10;
        }

        public void h(String str) {
            this.f12015e = str;
        }

        public void i(String str) {
            this.f12014d = str;
        }

        public void j(String str) {
            this.f12018h = str;
        }

        public void k(String str) {
            this.f12020j = str;
        }

        public void l(String str) {
            this.f12019i = str;
        }

        public void m(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"uid\" is null.");
            }
            this.f12011a = str;
        }

        public ArrayList<Object> n() {
            ArrayList<Object> arrayList = new ArrayList<>(12);
            arrayList.add(this.f12011a);
            arrayList.add(this.f12012b);
            arrayList.add(this.f12013c);
            arrayList.add(this.f12014d);
            arrayList.add(this.f12015e);
            arrayList.add(this.f12016f);
            arrayList.add(this.f12017g);
            arrayList.add(this.f12018h);
            arrayList.add(this.f12019i);
            arrayList.add(this.f12020j);
            arrayList.add(this.f12021k);
            arrayList.add(this.f12022l);
            return arrayList;
        }
    }

    public static class d extends fb.p {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f12035d = new d();

        @Override // fb.p
        public Object g(byte b10, ByteBuffer byteBuffer) {
            switch (b10) {
                case -128:
                    return b.a((ArrayList) f(byteBuffer));
                case -127:
                    return o.a((ArrayList) f(byteBuffer));
                case -126:
                    return p.a((ArrayList) f(byteBuffer));
                case -125:
                    return q.a((ArrayList) f(byteBuffer));
                case -124:
                    return r.a((ArrayList) f(byteBuffer));
                case -123:
                    return s.a((ArrayList) f(byteBuffer));
                case -122:
                    return t.a((ArrayList) f(byteBuffer));
                case -121:
                    return u.a((ArrayList) f(byteBuffer));
                case -120:
                    return v.a((ArrayList) f(byteBuffer));
                case -119:
                    return w.a((ArrayList) f(byteBuffer));
                case -118:
                    return x.a((ArrayList) f(byteBuffer));
                case -117:
                    return y.a((ArrayList) f(byteBuffer));
                case -116:
                    return z.a((ArrayList) f(byteBuffer));
                case -115:
                    return a0.a((ArrayList) f(byteBuffer));
                case -114:
                    return b0.a((ArrayList) f(byteBuffer));
                case -113:
                    return c0.a((ArrayList) f(byteBuffer));
                case -112:
                    return d0.a((ArrayList) f(byteBuffer));
                case -111:
                    return e0.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b10, byteBuffer);
            }
        }

        @Override // fb.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> arrayListN;
            if (obj instanceof b) {
                byteArrayOutputStream.write(128);
                arrayListN = ((b) obj).h();
            } else if (obj instanceof o) {
                byteArrayOutputStream.write(129);
                arrayListN = ((o) obj).d();
            } else if (obj instanceof p) {
                byteArrayOutputStream.write(130);
                arrayListN = ((p) obj).d();
            } else if (obj instanceof q) {
                byteArrayOutputStream.write(131);
                arrayListN = ((q) obj).r();
            } else if (obj instanceof r) {
                byteArrayOutputStream.write(132);
                arrayListN = ((r) obj).g();
            } else if (obj instanceof s) {
                byteArrayOutputStream.write(133);
                arrayListN = ((s) obj).f();
            } else if (obj instanceof t) {
                byteArrayOutputStream.write(134);
                arrayListN = ((t) obj).k();
            } else if (obj instanceof u) {
                byteArrayOutputStream.write(135);
                arrayListN = ((u) obj).i();
            } else if (obj instanceof v) {
                byteArrayOutputStream.write(ModuleDescriptor.MODULE_VERSION);
                arrayListN = ((v) obj).g();
            } else if (obj instanceof w) {
                byteArrayOutputStream.write(137);
                arrayListN = ((w) obj).c();
            } else if (obj instanceof x) {
                byteArrayOutputStream.write(138);
                arrayListN = ((x) obj).f();
            } else if (obj instanceof y) {
                byteArrayOutputStream.write(139);
                arrayListN = ((y) obj).h();
            } else if (obj instanceof z) {
                byteArrayOutputStream.write(140);
                arrayListN = ((z) obj).g();
            } else if (obj instanceof a0) {
                byteArrayOutputStream.write(141);
                arrayListN = ((a0) obj).e();
            } else if (obj instanceof b0) {
                byteArrayOutputStream.write(142);
                arrayListN = ((b0) obj).f();
            } else if (obj instanceof c0) {
                byteArrayOutputStream.write(143);
                arrayListN = ((c0) obj).n();
            } else if (obj instanceof d0) {
                byteArrayOutputStream.write(144);
                arrayListN = ((d0) obj).j();
            } else if (!(obj instanceof e0)) {
                super.p(byteArrayOutputStream, obj);
                return;
            } else {
                byteArrayOutputStream.write(145);
                arrayListN = ((e0) obj).n();
            }
            p(byteArrayOutputStream, arrayListN);
        }
    }

    public static final class d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f12038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f12039d;

        public static d0 a(ArrayList<Object> arrayList) {
            d0 d0Var = new d0();
            d0Var.f((String) arrayList.get(0));
            d0Var.h((String) arrayList.get(1));
            d0Var.g((Boolean) arrayList.get(2));
            d0Var.i((Boolean) arrayList.get(3));
            return d0Var;
        }

        public String b() {
            return this.f12036a;
        }

        public Boolean c() {
            return this.f12038c;
        }

        public String d() {
            return this.f12037b;
        }

        public Boolean e() {
            return this.f12039d;
        }

        public void f(String str) {
            this.f12036a = str;
        }

        public void g(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"displayNameChanged\" is null.");
            }
            this.f12038c = bool;
        }

        public void h(String str) {
            this.f12037b = str;
        }

        public void i(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"photoUrlChanged\" is null.");
            }
            this.f12039d = bool;
        }

        public ArrayList<Object> j() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            arrayList.add(this.f12036a);
            arrayList.add(this.f12037b);
            arrayList.add(this.f12038c);
            arrayList.add(this.f12039d);
            return arrayList;
        }
    }

    public interface e {

        public class a implements f0<b0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12040a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12041b;

            public a(ArrayList arrayList, fb.a.e eVar) {
                this.f12040a = arrayList;
                this.f12041b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12041b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(b0 b0Var) {
                this.f12040a.add(0, b0Var);
                this.f12041b.a(this.f12040a);
            }
        }

        public class b implements f0<b0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12042a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12043b;

            public b(ArrayList arrayList, fb.a.e eVar) {
                this.f12042a = arrayList;
                this.f12043b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12043b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(b0 b0Var) {
                this.f12042a.add(0, b0Var);
                this.f12043b.a(this.f12042a);
            }
        }

        public class c implements f0<b0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12044a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12045b;

            public c(ArrayList arrayList, fb.a.e eVar) {
                this.f12044a = arrayList;
                this.f12045b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12045b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(b0 b0Var) {
                this.f12044a.add(0, b0Var);
                this.f12045b.a(this.f12044a);
            }
        }

        public class d implements f0<b0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12046a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12047b;

            public d(ArrayList arrayList, fb.a.e eVar) {
                this.f12046a = arrayList;
                this.f12047b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12047b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(b0 b0Var) {
                this.f12046a.add(0, b0Var);
                this.f12047b.a(this.f12046a);
            }
        }

        /* JADX INFO: renamed from: kb.a1$e$e, reason: collision with other inner class name */
        public class C0205e implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12048a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12049b;

            public C0205e(ArrayList arrayList, fb.a.e eVar) {
                this.f12048a = arrayList;
                this.f12049b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f12048a.add(0, null);
                this.f12049b.a(this.f12048a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f12049b.a(a1.a(th));
            }
        }

        public class f implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12050a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12051b;

            public f(ArrayList arrayList, fb.a.e eVar) {
                this.f12050a = arrayList;
                this.f12051b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f12050a.add(0, null);
                this.f12051b.a(this.f12050a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f12051b.a(a1.a(th));
            }
        }

        public class g implements f0<u> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12052a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12053b;

            public g(ArrayList arrayList, fb.a.e eVar) {
                this.f12052a = arrayList;
                this.f12053b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12053b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(u uVar) {
                this.f12052a.add(0, uVar);
                this.f12053b.a(this.f12052a);
            }
        }

        public class h implements f0<a0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12054a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12055b;

            public h(ArrayList arrayList, fb.a.e eVar) {
                this.f12054a = arrayList;
                this.f12055b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12055b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a0 a0Var) {
                this.f12054a.add(0, a0Var);
                this.f12055b.a(this.f12054a);
            }
        }

        public class i implements f0<a0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12056a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12057b;

            public i(ArrayList arrayList, fb.a.e eVar) {
                this.f12056a = arrayList;
                this.f12057b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12057b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a0 a0Var) {
                this.f12056a.add(0, a0Var);
                this.f12057b.a(this.f12056a);
            }
        }

        public class j implements f0<a0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12058a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12059b;

            public j(ArrayList arrayList, fb.a.e eVar) {
                this.f12058a = arrayList;
                this.f12059b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12059b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a0 a0Var) {
                this.f12058a.add(0, a0Var);
                this.f12059b.a(this.f12058a);
            }
        }

        public class k implements f0<a0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12060a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12061b;

            public k(ArrayList arrayList, fb.a.e eVar) {
                this.f12060a = arrayList;
                this.f12061b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12061b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a0 a0Var) {
                this.f12060a.add(0, a0Var);
                this.f12061b.a(this.f12060a);
            }
        }

        public class l implements f0<b0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12062a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12063b;

            public l(ArrayList arrayList, fb.a.e eVar) {
                this.f12062a = arrayList;
                this.f12063b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12063b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(b0 b0Var) {
                this.f12062a.add(0, b0Var);
                this.f12063b.a(this.f12062a);
            }
        }

        public class m implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12064a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12065b;

            public m(ArrayList arrayList, fb.a.e eVar) {
                this.f12064a = arrayList;
                this.f12065b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f12064a.add(0, null);
                this.f12065b.a(this.f12064a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f12065b.a(a1.a(th));
            }
        }

        public class n implements f0<a0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12066a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12067b;

            public n(ArrayList arrayList, fb.a.e eVar) {
                this.f12066a = arrayList;
                this.f12067b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12067b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a0 a0Var) {
                this.f12066a.add(0, a0Var);
                this.f12067b.a(this.f12066a);
            }
        }

        static /* synthetic */ void B(e eVar, Object obj, fb.a.e eVar2) {
            ArrayList arrayList = (ArrayList) obj;
            eVar.K((b) arrayList.get(0), (d0) arrayList.get(1), new d(new ArrayList(), eVar2));
        }

        static /* synthetic */ void D(e eVar, Object obj, fb.a.e eVar2) {
            ArrayList arrayList = (ArrayList) obj;
            eVar.H((b) arrayList.get(0), (Map) arrayList.get(1), new h(new ArrayList(), eVar2));
        }

        static /* synthetic */ void L(e eVar, Object obj, fb.a.e eVar2) {
            ArrayList arrayList = (ArrayList) obj;
            eVar.Q((b) arrayList.get(0), (y) arrayList.get(1), new i(new ArrayList(), eVar2));
        }

        static /* synthetic */ void P(e eVar, Object obj, fb.a.e eVar2) {
            ArrayList arrayList = (ArrayList) obj;
            eVar.G((b) arrayList.get(0), (Map) arrayList.get(1), new j(new ArrayList(), eVar2));
        }

        static fb.h<Object> a() {
            return f.f12074d;
        }

        static /* synthetic */ void c(e eVar, Object obj, fb.a.e eVar2) {
            ArrayList arrayList = (ArrayList) obj;
            eVar.S((b) arrayList.get(0), (y) arrayList.get(1), new k(new ArrayList(), eVar2));
        }

        static void d(fb.b bVar, String str, final e eVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            fb.a aVar = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.delete" + str2, a());
            if (eVar != null) {
                aVar.e(new fb.a.d() { // from class: kb.x1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.o(this.f12297a, obj, eVar2);
                    }
                });
            } else {
                aVar.e(null);
            }
            fb.a aVar2 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.getIdToken" + str2, a());
            if (eVar != null) {
                aVar2.e(new fb.a.d() { // from class: kb.g2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.u(this.f12212a, obj, eVar2);
                    }
                });
            } else {
                aVar2.e(null);
            }
            fb.a aVar3 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.linkWithCredential" + str2, a());
            if (eVar != null) {
                aVar3.e(new fb.a.d() { // from class: kb.h2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.D(this.f12216a, obj, eVar2);
                    }
                });
            } else {
                aVar3.e(null);
            }
            fb.a aVar4 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.linkWithProvider" + str2, a());
            if (eVar != null) {
                aVar4.e(new fb.a.d() { // from class: kb.i2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.L(this.f12220a, obj, eVar2);
                    }
                });
            } else {
                aVar4.e(null);
            }
            fb.a aVar5 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.reauthenticateWithCredential" + str2, a());
            if (eVar != null) {
                aVar5.e(new fb.a.d() { // from class: kb.j2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.P(this.f12224a, obj, eVar2);
                    }
                });
            } else {
                aVar5.e(null);
            }
            fb.a aVar6 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.reauthenticateWithProvider" + str2, a());
            if (eVar != null) {
                aVar6.e(new fb.a.d() { // from class: kb.k2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.c(this.f12228a, obj, eVar2);
                    }
                });
            } else {
                aVar6.e(null);
            }
            fb.a aVar7 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.reload" + str2, a());
            if (eVar != null) {
                aVar7.e(new fb.a.d() { // from class: kb.y1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.g(this.f12302a, obj, eVar2);
                    }
                });
            } else {
                aVar7.e(null);
            }
            fb.a aVar8 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.sendEmailVerification" + str2, a());
            if (eVar != null) {
                aVar8.e(new fb.a.d() { // from class: kb.z1
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.l(this.f12317a, obj, eVar2);
                    }
                });
            } else {
                aVar8.e(null);
            }
            fb.a aVar9 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.unlink" + str2, a());
            if (eVar != null) {
                aVar9.e(new fb.a.d() { // from class: kb.a2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.n(this.f12182a, obj, eVar2);
                    }
                });
            } else {
                aVar9.e(null);
            }
            fb.a aVar10 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.updateEmail" + str2, a());
            if (eVar != null) {
                aVar10.e(new fb.a.d() { // from class: kb.b2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.s(this.f12187a, obj, eVar2);
                    }
                });
            } else {
                aVar10.e(null);
            }
            fb.a aVar11 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.updatePassword" + str2, a());
            if (eVar != null) {
                aVar11.e(new fb.a.d() { // from class: kb.c2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.p(this.f12192a, obj, eVar2);
                    }
                });
            } else {
                aVar11.e(null);
            }
            fb.a aVar12 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.updatePhoneNumber" + str2, a());
            if (eVar != null) {
                aVar12.e(new fb.a.d() { // from class: kb.d2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.m(this.f12197a, obj, eVar2);
                    }
                });
            } else {
                aVar12.e(null);
            }
            fb.a aVar13 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.updateProfile" + str2, a());
            if (eVar != null) {
                aVar13.e(new fb.a.d() { // from class: kb.e2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.B(this.f12202a, obj, eVar2);
                    }
                });
            } else {
                aVar13.e(null);
            }
            fb.a aVar14 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.verifyBeforeUpdateEmail" + str2, a());
            if (eVar != null) {
                aVar14.e(new fb.a.d() { // from class: kb.f2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar2) {
                        a1.e.x(this.f12207a, obj, eVar2);
                    }
                });
            } else {
                aVar14.e(null);
            }
        }

        static /* synthetic */ void g(e eVar, Object obj, fb.a.e eVar2) {
            eVar.f((b) ((ArrayList) obj).get(0), new l(new ArrayList(), eVar2));
        }

        static /* synthetic */ void l(e eVar, Object obj, fb.a.e eVar2) {
            ArrayList arrayList = (ArrayList) obj;
            eVar.r((b) arrayList.get(0), (q) arrayList.get(1), new m(new ArrayList(), eVar2));
        }

        static /* synthetic */ void m(e eVar, Object obj, fb.a.e eVar2) {
            ArrayList arrayList = (ArrayList) obj;
            eVar.N((b) arrayList.get(0), (Map) arrayList.get(1), new c(new ArrayList(), eVar2));
        }

        static /* synthetic */ void n(e eVar, Object obj, fb.a.e eVar2) {
            ArrayList arrayList = (ArrayList) obj;
            eVar.t((b) arrayList.get(0), (String) arrayList.get(1), new n(new ArrayList(), eVar2));
        }

        static /* synthetic */ void o(e eVar, Object obj, fb.a.e eVar2) {
            eVar.I((b) ((ArrayList) obj).get(0), new f(new ArrayList(), eVar2));
        }

        static /* synthetic */ void p(e eVar, Object obj, fb.a.e eVar2) {
            ArrayList arrayList = (ArrayList) obj;
            eVar.A((b) arrayList.get(0), (String) arrayList.get(1), new b(new ArrayList(), eVar2));
        }

        static /* synthetic */ void s(e eVar, Object obj, fb.a.e eVar2) {
            ArrayList arrayList = (ArrayList) obj;
            eVar.k((b) arrayList.get(0), (String) arrayList.get(1), new a(new ArrayList(), eVar2));
        }

        static /* synthetic */ void u(e eVar, Object obj, fb.a.e eVar2) {
            ArrayList arrayList = (ArrayList) obj;
            eVar.C((b) arrayList.get(0), (Boolean) arrayList.get(1), new g(new ArrayList(), eVar2));
        }

        static /* synthetic */ void x(e eVar, Object obj, fb.a.e eVar2) {
            ArrayList arrayList = (ArrayList) obj;
            eVar.e((b) arrayList.get(0), (String) arrayList.get(1), (q) arrayList.get(2), new C0205e(new ArrayList(), eVar2));
        }

        static void z(fb.b bVar, e eVar) {
            d(bVar, "", eVar);
        }

        void A(b bVar, String str, f0<b0> f0Var);

        void C(b bVar, Boolean bool, f0<u> f0Var);

        void G(b bVar, Map<String, Object> map, f0<a0> f0Var);

        void H(b bVar, Map<String, Object> map, f0<a0> f0Var);

        void I(b bVar, g0 g0Var);

        void K(b bVar, d0 d0Var, f0<b0> f0Var);

        void N(b bVar, Map<String, Object> map, f0<b0> f0Var);

        void Q(b bVar, y yVar, f0<a0> f0Var);

        void S(b bVar, y yVar, f0<a0> f0Var);

        void e(b bVar, String str, q qVar, g0 g0Var);

        void f(b bVar, f0<b0> f0Var);

        void k(b bVar, String str, f0<b0> f0Var);

        void r(b bVar, q qVar, g0 g0Var);

        void t(b bVar, String str, f0<a0> f0Var);
    }

    public static final class e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f12069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f12070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f12071d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f12072e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f12073f;

        public static e0 a(ArrayList<Object> arrayList) {
            Long lValueOf;
            e0 e0Var = new e0();
            e0Var.l((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            Long lValueOf2 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            e0Var.m(lValueOf);
            Object obj2 = arrayList.get(2);
            if (obj2 != null) {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            e0Var.i(lValueOf2);
            e0Var.h((String) arrayList.get(3));
            e0Var.j((String) arrayList.get(4));
            e0Var.k((String) arrayList.get(5));
            return e0Var;
        }

        public String b() {
            return this.f12071d;
        }

        public Long c() {
            return this.f12070c;
        }

        public String d() {
            return this.f12072e;
        }

        public String e() {
            return this.f12073f;
        }

        public String f() {
            return this.f12068a;
        }

        public Long g() {
            return this.f12069b;
        }

        public void h(String str) {
            this.f12071d = str;
        }

        public void i(Long l10) {
            this.f12070c = l10;
        }

        public void j(String str) {
            this.f12072e = str;
        }

        public void k(String str) {
            this.f12073f = str;
        }

        public void l(String str) {
            this.f12068a = str;
        }

        public void m(Long l10) {
            if (l10 == null) {
                throw new IllegalStateException("Nonnull field \"timeout\" is null.");
            }
            this.f12069b = l10;
        }

        public ArrayList<Object> n() {
            ArrayList<Object> arrayList = new ArrayList<>(6);
            arrayList.add(this.f12068a);
            arrayList.add(this.f12069b);
            arrayList.add(this.f12070c);
            arrayList.add(this.f12071d);
            arrayList.add(this.f12072e);
            arrayList.add(this.f12073f);
            return arrayList;
        }
    }

    public static class f extends fb.p {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final f f12074d = new f();

        @Override // fb.p
        public Object g(byte b10, ByteBuffer byteBuffer) {
            switch (b10) {
                case -128:
                    return b.a((ArrayList) f(byteBuffer));
                case -127:
                    return o.a((ArrayList) f(byteBuffer));
                case -126:
                    return p.a((ArrayList) f(byteBuffer));
                case -125:
                    return q.a((ArrayList) f(byteBuffer));
                case -124:
                    return r.a((ArrayList) f(byteBuffer));
                case -123:
                    return s.a((ArrayList) f(byteBuffer));
                case -122:
                    return t.a((ArrayList) f(byteBuffer));
                case -121:
                    return u.a((ArrayList) f(byteBuffer));
                case -120:
                    return v.a((ArrayList) f(byteBuffer));
                case -119:
                    return w.a((ArrayList) f(byteBuffer));
                case -118:
                    return x.a((ArrayList) f(byteBuffer));
                case -117:
                    return y.a((ArrayList) f(byteBuffer));
                case -116:
                    return z.a((ArrayList) f(byteBuffer));
                case -115:
                    return a0.a((ArrayList) f(byteBuffer));
                case -114:
                    return b0.a((ArrayList) f(byteBuffer));
                case -113:
                    return c0.a((ArrayList) f(byteBuffer));
                case -112:
                    return d0.a((ArrayList) f(byteBuffer));
                case -111:
                    return e0.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b10, byteBuffer);
            }
        }

        @Override // fb.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> arrayListN;
            if (obj instanceof b) {
                byteArrayOutputStream.write(128);
                arrayListN = ((b) obj).h();
            } else if (obj instanceof o) {
                byteArrayOutputStream.write(129);
                arrayListN = ((o) obj).d();
            } else if (obj instanceof p) {
                byteArrayOutputStream.write(130);
                arrayListN = ((p) obj).d();
            } else if (obj instanceof q) {
                byteArrayOutputStream.write(131);
                arrayListN = ((q) obj).r();
            } else if (obj instanceof r) {
                byteArrayOutputStream.write(132);
                arrayListN = ((r) obj).g();
            } else if (obj instanceof s) {
                byteArrayOutputStream.write(133);
                arrayListN = ((s) obj).f();
            } else if (obj instanceof t) {
                byteArrayOutputStream.write(134);
                arrayListN = ((t) obj).k();
            } else if (obj instanceof u) {
                byteArrayOutputStream.write(135);
                arrayListN = ((u) obj).i();
            } else if (obj instanceof v) {
                byteArrayOutputStream.write(ModuleDescriptor.MODULE_VERSION);
                arrayListN = ((v) obj).g();
            } else if (obj instanceof w) {
                byteArrayOutputStream.write(137);
                arrayListN = ((w) obj).c();
            } else if (obj instanceof x) {
                byteArrayOutputStream.write(138);
                arrayListN = ((x) obj).f();
            } else if (obj instanceof y) {
                byteArrayOutputStream.write(139);
                arrayListN = ((y) obj).h();
            } else if (obj instanceof z) {
                byteArrayOutputStream.write(140);
                arrayListN = ((z) obj).g();
            } else if (obj instanceof a0) {
                byteArrayOutputStream.write(141);
                arrayListN = ((a0) obj).e();
            } else if (obj instanceof b0) {
                byteArrayOutputStream.write(142);
                arrayListN = ((b0) obj).f();
            } else if (obj instanceof c0) {
                byteArrayOutputStream.write(143);
                arrayListN = ((c0) obj).n();
            } else if (obj instanceof d0) {
                byteArrayOutputStream.write(144);
                arrayListN = ((d0) obj).j();
            } else if (!(obj instanceof e0)) {
                super.p(byteArrayOutputStream, obj);
                return;
            } else {
                byteArrayOutputStream.write(145);
                arrayListN = ((e0) obj).n();
            }
            p(byteArrayOutputStream, arrayListN);
        }
    }

    public interface f0<T> {
        void a(T t10);

        void b(Throwable th);
    }

    public static class g extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f12076b;

        public g(String str, String str2, Object obj) {
            super(str2);
            this.f12075a = str;
            this.f12076b = obj;
        }
    }

    public interface g0 {
        void a();

        void b(Throwable th);
    }

    public interface h {

        public class a implements f0<a0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12077a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12078b;

            public a(ArrayList arrayList, fb.a.e eVar) {
                this.f12077a = arrayList;
                this.f12078b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12078b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(a0 a0Var) {
                this.f12077a.add(0, a0Var);
                this.f12078b.a(this.f12077a);
            }
        }

        static fb.h<Object> a() {
            return i.f12079d;
        }

        static void d(fb.b bVar, String str, final h hVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactoResolverHostApi.resolveSignIn" + str2, a()).e(hVar != null ? new fb.a.d() { // from class: kb.l2
                @Override // fb.a.d
                public final void a(Object obj, fb.a.e eVar) {
                    a1.h.s(this.f12234a, obj, eVar);
                }
            } : null);
        }

        static /* synthetic */ void s(h hVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            hVar.n((String) arrayList.get(0), (x) arrayList.get(1), (String) arrayList.get(2), new a(new ArrayList(), eVar));
        }

        static void t(fb.b bVar, h hVar) {
            d(bVar, "", hVar);
        }

        void n(String str, x xVar, String str2, f0<a0> f0Var);
    }

    public static class i extends fb.p {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final i f12079d = new i();

        @Override // fb.p
        public Object g(byte b10, ByteBuffer byteBuffer) {
            switch (b10) {
                case -128:
                    return r.a((ArrayList) f(byteBuffer));
                case -127:
                    return s.a((ArrayList) f(byteBuffer));
                case -126:
                    return x.a((ArrayList) f(byteBuffer));
                case -125:
                    return a0.a((ArrayList) f(byteBuffer));
                case -124:
                    return b0.a((ArrayList) f(byteBuffer));
                case -123:
                    return c0.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b10, byteBuffer);
            }
        }

        @Override // fb.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> arrayListN;
            if (obj instanceof r) {
                byteArrayOutputStream.write(128);
                arrayListN = ((r) obj).g();
            } else if (obj instanceof s) {
                byteArrayOutputStream.write(129);
                arrayListN = ((s) obj).f();
            } else if (obj instanceof x) {
                byteArrayOutputStream.write(130);
                arrayListN = ((x) obj).f();
            } else if (obj instanceof a0) {
                byteArrayOutputStream.write(131);
                arrayListN = ((a0) obj).e();
            } else if (obj instanceof b0) {
                byteArrayOutputStream.write(132);
                arrayListN = ((b0) obj).f();
            } else if (!(obj instanceof c0)) {
                super.p(byteArrayOutputStream, obj);
                return;
            } else {
                byteArrayOutputStream.write(133);
                arrayListN = ((c0) obj).n();
            }
            p(byteArrayOutputStream, arrayListN);
        }
    }

    public interface j {

        public class a implements f0<z> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12080a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12081b;

            public a(ArrayList arrayList, fb.a.e eVar) {
                this.f12080a = arrayList;
                this.f12081b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12081b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(z zVar) {
                this.f12080a.add(0, zVar);
                this.f12081b.a(this.f12080a);
            }
        }

        public class b implements f0<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12082a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12083b;

            public b(ArrayList arrayList, fb.a.e eVar) {
                this.f12082a = arrayList;
                this.f12083b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12083b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f12082a.add(0, str);
                this.f12083b.a(this.f12082a);
            }
        }

        public class c implements f0<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12084a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12085b;

            public c(ArrayList arrayList, fb.a.e eVar) {
                this.f12084a = arrayList;
                this.f12085b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12085b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f12084a.add(0, str);
                this.f12085b.a(this.f12084a);
            }
        }

        static fb.h<Object> a() {
            return k.f12086d;
        }

        static void b(fb.b bVar, j jVar) {
            h(bVar, "", jVar);
        }

        static /* synthetic */ void e(j jVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            jVar.d((String) arrayList.get(0), (String) arrayList.get(1), new c(new ArrayList(), eVar));
        }

        static void h(fb.b bVar, String str, final j jVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            fb.a aVar = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.generateSecret" + str2, a());
            if (jVar != null) {
                aVar.e(new fb.a.d() { // from class: kb.m2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.j.k(this.f12237a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            fb.a aVar2 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.getAssertionForEnrollment" + str2, a());
            if (jVar != null) {
                aVar2.e(new fb.a.d() { // from class: kb.n2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.j.l(this.f12242a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            fb.a aVar3 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.getAssertionForSignIn" + str2, a());
            if (jVar != null) {
                aVar3.e(new fb.a.d() { // from class: kb.o2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.j.e(this.f12248a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
        }

        static /* synthetic */ void k(j jVar, Object obj, fb.a.e eVar) {
            jVar.c((String) ((ArrayList) obj).get(0), new a(new ArrayList(), eVar));
        }

        static /* synthetic */ void l(j jVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            jVar.i((String) arrayList.get(0), (String) arrayList.get(1), new b(new ArrayList(), eVar));
        }

        void c(String str, f0<z> f0Var);

        void d(String str, String str2, f0<String> f0Var);

        void i(String str, String str2, f0<String> f0Var);
    }

    public static class k extends fb.p {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final k f12086d = new k();

        @Override // fb.p
        public Object g(byte b10, ByteBuffer byteBuffer) {
            return b10 != -128 ? super.g(b10, byteBuffer) : z.a((ArrayList) f(byteBuffer));
        }

        @Override // fb.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (!(obj instanceof z)) {
                super.p(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(128);
                p(byteArrayOutputStream, ((z) obj).g());
            }
        }
    }

    public interface l {

        public class a implements f0<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12087a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12088b;

            public a(ArrayList arrayList, fb.a.e eVar) {
                this.f12087a = arrayList;
                this.f12088b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12088b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f12087a.add(0, str);
                this.f12088b.a(this.f12087a);
            }
        }

        public class b implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12089a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12090b;

            public b(ArrayList arrayList, fb.a.e eVar) {
                this.f12089a = arrayList;
                this.f12090b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f12089a.add(0, null);
                this.f12090b.a(this.f12089a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f12090b.a(a1.a(th));
            }
        }

        static fb.h<Object> a() {
            return new fb.p();
        }

        static void c(fb.b bVar, String str, final l lVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            fb.a aVar = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpSecretHostApi.generateQrCodeUrl" + str2, a());
            if (lVar != null) {
                aVar.e(new fb.a.d() { // from class: kb.p2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.l.d(this.f12253a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            fb.a aVar2 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpSecretHostApi.openInOtpApp" + str2, a());
            if (lVar != null) {
                aVar2.e(new fb.a.d() { // from class: kb.q2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.l.f(this.f12257a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
        }

        static /* synthetic */ void d(l lVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            lVar.i((String) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new a(new ArrayList(), eVar));
        }

        static /* synthetic */ void f(l lVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            lVar.b((String) arrayList.get(0), (String) arrayList.get(1), new b(new ArrayList(), eVar));
        }

        static void h(fb.b bVar, l lVar) {
            c(bVar, "", lVar);
        }

        void b(String str, String str2, g0 g0Var);

        void i(String str, String str2, String str3, f0<String> f0Var);
    }

    public interface m {

        public class a implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12091a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12092b;

            public a(ArrayList arrayList, fb.a.e eVar) {
                this.f12091a = arrayList;
                this.f12092b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f12091a.add(0, null);
                this.f12092b.a(this.f12091a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f12092b.a(a1.a(th));
            }
        }

        public class b implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12093a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12094b;

            public b(ArrayList arrayList, fb.a.e eVar) {
                this.f12093a = arrayList;
                this.f12094b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f12093a.add(0, null);
                this.f12094b.a(this.f12093a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f12094b.a(a1.a(th));
            }
        }

        public class c implements f0<w> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12095a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12096b;

            public c(ArrayList arrayList, fb.a.e eVar) {
                this.f12095a = arrayList;
                this.f12096b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12096b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(w wVar) {
                this.f12095a.add(0, wVar);
                this.f12096b.a(this.f12095a);
            }
        }

        public class d implements g0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12097a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12098b;

            public d(ArrayList arrayList, fb.a.e eVar) {
                this.f12097a = arrayList;
                this.f12098b = eVar;
            }

            @Override // kb.a1.g0
            public void a() {
                this.f12097a.add(0, null);
                this.f12098b.a(this.f12097a);
            }

            @Override // kb.a1.g0
            public void b(Throwable th) {
                this.f12098b.a(a1.a(th));
            }
        }

        public class e implements f0<List<v>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12099a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12100b;

            public e(ArrayList arrayList, fb.a.e eVar) {
                this.f12099a = arrayList;
                this.f12100b = eVar;
            }

            @Override // kb.a1.f0
            public void b(Throwable th) {
                this.f12100b.a(a1.a(th));
            }

            @Override // kb.a1.f0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(List<v> list) {
                this.f12099a.add(0, list);
                this.f12100b.a(this.f12099a);
            }
        }

        static fb.h<Object> a() {
            return n.f12101d;
        }

        static /* synthetic */ void b(m mVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            mVar.g((b) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new b(new ArrayList(), eVar));
        }

        static /* synthetic */ void c(m mVar, Object obj, fb.a.e eVar) {
            mVar.f((b) ((ArrayList) obj).get(0), new c(new ArrayList(), eVar));
        }

        static /* synthetic */ void e(m mVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            mVar.q((b) arrayList.get(0), (String) arrayList.get(1), new d(new ArrayList(), eVar));
        }

        static /* synthetic */ void k(m mVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            mVar.l((b) arrayList.get(0), (x) arrayList.get(1), (String) arrayList.get(2), new a(new ArrayList(), eVar));
        }

        static void p(fb.b bVar, m mVar) {
            r(bVar, "", mVar);
        }

        static void r(fb.b bVar, String str, final m mVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            fb.a aVar = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.enrollPhone" + str2, a());
            if (mVar != null) {
                aVar.e(new fb.a.d() { // from class: kb.r2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.m.k(this.f12261a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            fb.a aVar2 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.enrollTotp" + str2, a());
            if (mVar != null) {
                aVar2.e(new fb.a.d() { // from class: kb.s2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.m.b(this.f12265a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            fb.a aVar3 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.getSession" + str2, a());
            if (mVar != null) {
                aVar3.e(new fb.a.d() { // from class: kb.t2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.m.c(this.f12269a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            fb.a aVar4 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.unenroll" + str2, a());
            if (mVar != null) {
                aVar4.e(new fb.a.d() { // from class: kb.u2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.m.e(this.f12281a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            fb.a aVar5 = new fb.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.getEnrolledFactors" + str2, a());
            if (mVar != null) {
                aVar5.e(new fb.a.d() { // from class: kb.v2
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a1.m.v(this.f12284a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
        }

        static /* synthetic */ void v(m mVar, Object obj, fb.a.e eVar) {
            mVar.m((b) ((ArrayList) obj).get(0), new e(new ArrayList(), eVar));
        }

        void f(b bVar, f0<w> f0Var);

        void g(b bVar, String str, String str2, g0 g0Var);

        void l(b bVar, x xVar, String str, g0 g0Var);

        void m(b bVar, f0<List<v>> f0Var);

        void q(b bVar, String str, g0 g0Var);
    }

    public static class n extends fb.p {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final n f12101d = new n();

        @Override // fb.p
        public Object g(byte b10, ByteBuffer byteBuffer) {
            switch (b10) {
                case -128:
                    return b.a((ArrayList) f(byteBuffer));
                case -127:
                    return v.a((ArrayList) f(byteBuffer));
                case -126:
                    return w.a((ArrayList) f(byteBuffer));
                case -125:
                    return x.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b10, byteBuffer);
            }
        }

        @Override // fb.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> arrayListF;
            if (obj instanceof b) {
                byteArrayOutputStream.write(128);
                arrayListF = ((b) obj).h();
            } else if (obj instanceof v) {
                byteArrayOutputStream.write(129);
                arrayListF = ((v) obj).g();
            } else if (obj instanceof w) {
                byteArrayOutputStream.write(130);
                arrayListF = ((w) obj).c();
            } else if (!(obj instanceof x)) {
                super.p(byteArrayOutputStream, obj);
                return;
            } else {
                byteArrayOutputStream.write(131);
                arrayListF = ((x) obj).f();
            }
            p(byteArrayOutputStream, arrayListF);
        }
    }

    public static final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f12102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p f12103b;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public a f12104a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public p f12105b;

            public o a() {
                o oVar = new o();
                oVar.c(this.f12104a);
                oVar.b(this.f12105b);
                return oVar;
            }

            public a b(p pVar) {
                this.f12105b = pVar;
                return this;
            }

            public a c(a aVar) {
                this.f12104a = aVar;
                return this;
            }
        }

        public static o a(ArrayList<Object> arrayList) {
            o oVar = new o();
            oVar.c(a.values()[((Integer) arrayList.get(0)).intValue()]);
            oVar.b((p) arrayList.get(1));
            return oVar;
        }

        public void b(p pVar) {
            if (pVar == null) {
                throw new IllegalStateException("Nonnull field \"data\" is null.");
            }
            this.f12103b = pVar;
        }

        public void c(a aVar) {
            if (aVar == null) {
                throw new IllegalStateException("Nonnull field \"operation\" is null.");
            }
            this.f12102a = aVar;
        }

        public ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            a aVar = this.f12102a;
            arrayList.add(aVar == null ? null : Integer.valueOf(aVar.f11953a));
            arrayList.add(this.f12103b);
            return arrayList;
        }
    }

    public static final class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12107b;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f12108a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f12109b;

            public p a() {
                p pVar = new p();
                pVar.b(this.f12108a);
                pVar.c(this.f12109b);
                return pVar;
            }

            public a b(String str) {
                this.f12108a = str;
                return this;
            }

            public a c(String str) {
                this.f12109b = str;
                return this;
            }
        }

        public static p a(ArrayList<Object> arrayList) {
            p pVar = new p();
            pVar.b((String) arrayList.get(0));
            pVar.c((String) arrayList.get(1));
            return pVar;
        }

        public void b(String str) {
            this.f12106a = str;
        }

        public void c(String str) {
            this.f12107b = str;
        }

        public ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f12106a);
            arrayList.add(this.f12107b);
            return arrayList;
        }
    }

    public static final class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f12112c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f12113d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f12114e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f12115f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f12116g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f12117h;

        public static q a(ArrayList<Object> arrayList) {
            q qVar = new q();
            qVar.q((String) arrayList.get(0));
            qVar.m((String) arrayList.get(1));
            qVar.n((Boolean) arrayList.get(2));
            qVar.o((String) arrayList.get(3));
            qVar.l((String) arrayList.get(4));
            qVar.j((Boolean) arrayList.get(5));
            qVar.k((String) arrayList.get(6));
            qVar.p((String) arrayList.get(7));
            return qVar;
        }

        public Boolean b() {
            return this.f12115f;
        }

        public String c() {
            return this.f12116g;
        }

        public String d() {
            return this.f12114e;
        }

        public String e() {
            return this.f12111b;
        }

        public Boolean f() {
            return this.f12112c;
        }

        public String g() {
            return this.f12113d;
        }

        public String h() {
            return this.f12117h;
        }

        public String i() {
            return this.f12110a;
        }

        public void j(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"androidInstallApp\" is null.");
            }
            this.f12115f = bool;
        }

        public void k(String str) {
            this.f12116g = str;
        }

        public void l(String str) {
            this.f12114e = str;
        }

        public void m(String str) {
            this.f12111b = str;
        }

        public void n(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"handleCodeInApp\" is null.");
            }
            this.f12112c = bool;
        }

        public void o(String str) {
            this.f12113d = str;
        }

        public void p(String str) {
            this.f12117h = str;
        }

        public void q(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"url\" is null.");
            }
            this.f12110a = str;
        }

        public ArrayList<Object> r() {
            ArrayList<Object> arrayList = new ArrayList<>(8);
            arrayList.add(this.f12110a);
            arrayList.add(this.f12111b);
            arrayList.add(this.f12112c);
            arrayList.add(this.f12113d);
            arrayList.add(this.f12114e);
            arrayList.add(this.f12115f);
            arrayList.add(this.f12116g);
            arrayList.add(this.f12117h);
            return arrayList;
        }
    }

    public static final class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f12118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12120c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f12121d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, Object> f12122e;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Boolean f12123a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f12124b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f12125c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f12126d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Map<String, Object> f12127e;

            public r a() {
                r rVar = new r();
                rVar.c(this.f12123a);
                rVar.e(this.f12124b);
                rVar.f(this.f12125c);
                rVar.b(this.f12126d);
                rVar.d(this.f12127e);
                return rVar;
            }

            public a b(Boolean bool) {
                this.f12123a = bool;
                return this;
            }

            public a c(Map<String, Object> map) {
                this.f12127e = map;
                return this;
            }

            public a d(String str) {
                this.f12124b = str;
                return this;
            }

            public a e(String str) {
                this.f12125c = str;
                return this;
            }
        }

        public static r a(ArrayList<Object> arrayList) {
            r rVar = new r();
            rVar.c((Boolean) arrayList.get(0));
            rVar.e((String) arrayList.get(1));
            rVar.f((String) arrayList.get(2));
            rVar.b((String) arrayList.get(3));
            rVar.d((Map) arrayList.get(4));
            return rVar;
        }

        public void b(String str) {
            this.f12121d = str;
        }

        public void c(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isNewUser\" is null.");
            }
            this.f12118a = bool;
        }

        public void d(Map<String, Object> map) {
            this.f12122e = map;
        }

        public void e(String str) {
            this.f12119b = str;
        }

        public void f(String str) {
            this.f12120c = str;
        }

        public ArrayList<Object> g() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.f12118a);
            arrayList.add(this.f12119b);
            arrayList.add(this.f12120c);
            arrayList.add(this.f12121d);
            arrayList.add(this.f12122e);
            return arrayList;
        }
    }

    public static final class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f12130c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f12131d;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f12132a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f12133b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Long f12134c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f12135d;

            public s a() {
                s sVar = new s();
                sVar.d(this.f12132a);
                sVar.e(this.f12133b);
                sVar.c(this.f12134c);
                sVar.b(this.f12135d);
                return sVar;
            }

            public a b(String str) {
                this.f12135d = str;
                return this;
            }

            public a c(Long l10) {
                this.f12134c = l10;
                return this;
            }

            public a d(String str) {
                this.f12132a = str;
                return this;
            }

            public a e(String str) {
                this.f12133b = str;
                return this;
            }
        }

        public static s a(ArrayList<Object> arrayList) {
            Long lValueOf;
            s sVar = new s();
            sVar.d((String) arrayList.get(0));
            sVar.e((String) arrayList.get(1));
            Object obj = arrayList.get(2);
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            sVar.c(lValueOf);
            sVar.b((String) arrayList.get(3));
            return sVar;
        }

        public void b(String str) {
            this.f12131d = str;
        }

        public void c(Long l10) {
            if (l10 == null) {
                throw new IllegalStateException("Nonnull field \"nativeId\" is null.");
            }
            this.f12130c = l10;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"providerId\" is null.");
            }
            this.f12128a = str;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"signInMethod\" is null.");
            }
            this.f12129b = str;
        }

        public ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            arrayList.add(this.f12128a);
            arrayList.add(this.f12129b);
            arrayList.add(this.f12130c);
            arrayList.add(this.f12131d);
            return arrayList;
        }
    }

    public static final class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f12136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12138c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f12139d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Boolean f12140e;

        public static t a(ArrayList<Object> arrayList) {
            t tVar = new t();
            tVar.f((Boolean) arrayList.get(0));
            tVar.j((String) arrayList.get(1));
            tVar.h((String) arrayList.get(2));
            tVar.i((String) arrayList.get(3));
            tVar.g((Boolean) arrayList.get(4));
            return tVar;
        }

        public Boolean b() {
            return this.f12136a;
        }

        public Boolean c() {
            return this.f12140e;
        }

        public String d() {
            return this.f12138c;
        }

        public String e() {
            return this.f12139d;
        }

        public void f(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"appVerificationDisabledForTesting\" is null.");
            }
            this.f12136a = bool;
        }

        public void g(Boolean bool) {
            this.f12140e = bool;
        }

        public void h(String str) {
            this.f12138c = str;
        }

        public void i(String str) {
            this.f12139d = str;
        }

        public void j(String str) {
            this.f12137b = str;
        }

        public ArrayList<Object> k() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.f12136a);
            arrayList.add(this.f12137b);
            arrayList.add(this.f12138c);
            arrayList.add(this.f12139d);
            arrayList.add(this.f12140e);
            return arrayList;
        }
    }

    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f12142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f12143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f12144d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f12145e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map<String, Object> f12146f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f12147g;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f12148a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Long f12149b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Long f12150c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Long f12151d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f12152e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Map<String, Object> f12153f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public String f12154g;

            public u a() {
                u uVar = new u();
                uVar.h(this.f12148a);
                uVar.d(this.f12149b);
                uVar.b(this.f12150c);
                uVar.e(this.f12151d);
                uVar.f(this.f12152e);
                uVar.c(this.f12153f);
                uVar.g(this.f12154g);
                return uVar;
            }

            public a b(Long l10) {
                this.f12150c = l10;
                return this;
            }

            public a c(Map<String, Object> map) {
                this.f12153f = map;
                return this;
            }

            public a d(Long l10) {
                this.f12149b = l10;
                return this;
            }

            public a e(Long l10) {
                this.f12151d = l10;
                return this;
            }

            public a f(String str) {
                this.f12152e = str;
                return this;
            }

            public a g(String str) {
                this.f12154g = str;
                return this;
            }

            public a h(String str) {
                this.f12148a = str;
                return this;
            }
        }

        public static u a(ArrayList<Object> arrayList) {
            Long lValueOf;
            Long lValueOf2;
            u uVar = new u();
            uVar.h((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            Long lValueOf3 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            uVar.d(lValueOf);
            Object obj2 = arrayList.get(2);
            if (obj2 == null) {
                lValueOf2 = null;
            } else {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            uVar.b(lValueOf2);
            Object obj3 = arrayList.get(3);
            if (obj3 != null) {
                lValueOf3 = Long.valueOf(obj3 instanceof Integer ? ((Integer) obj3).intValue() : ((Long) obj3).longValue());
            }
            uVar.e(lValueOf3);
            uVar.f((String) arrayList.get(4));
            uVar.c((Map) arrayList.get(5));
            uVar.g((String) arrayList.get(6));
            return uVar;
        }

        public void b(Long l10) {
            this.f12143c = l10;
        }

        public void c(Map<String, Object> map) {
            this.f12146f = map;
        }

        public void d(Long l10) {
            this.f12142b = l10;
        }

        public void e(Long l10) {
            this.f12144d = l10;
        }

        public void f(String str) {
            this.f12145e = str;
        }

        public void g(String str) {
            this.f12147g = str;
        }

        public void h(String str) {
            this.f12141a = str;
        }

        public ArrayList<Object> i() {
            ArrayList<Object> arrayList = new ArrayList<>(7);
            arrayList.add(this.f12141a);
            arrayList.add(this.f12142b);
            arrayList.add(this.f12143c);
            arrayList.add(this.f12144d);
            arrayList.add(this.f12145e);
            arrayList.add(this.f12146f);
            arrayList.add(this.f12147g);
            return arrayList;
        }
    }

    public static final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f12156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f12158d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f12159e;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f12160a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Double f12161b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f12162c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f12163d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f12164e;

            public v a() {
                v vVar = new v();
                vVar.b(this.f12160a);
                vVar.c(this.f12161b);
                vVar.d(this.f12162c);
                vVar.f(this.f12163d);
                vVar.e(this.f12164e);
                return vVar;
            }

            public a b(String str) {
                this.f12160a = str;
                return this;
            }

            public a c(Double d10) {
                this.f12161b = d10;
                return this;
            }

            public a d(String str) {
                this.f12162c = str;
                return this;
            }

            public a e(String str) {
                this.f12164e = str;
                return this;
            }

            public a f(String str) {
                this.f12163d = str;
                return this;
            }
        }

        public static v a(ArrayList<Object> arrayList) {
            v vVar = new v();
            vVar.b((String) arrayList.get(0));
            vVar.c((Double) arrayList.get(1));
            vVar.d((String) arrayList.get(2));
            vVar.f((String) arrayList.get(3));
            vVar.e((String) arrayList.get(4));
            return vVar;
        }

        public void b(String str) {
            this.f12155a = str;
        }

        public void c(Double d10) {
            if (d10 == null) {
                throw new IllegalStateException("Nonnull field \"enrollmentTimestamp\" is null.");
            }
            this.f12156b = d10;
        }

        public void d(String str) {
            this.f12157c = str;
        }

        public void e(String str) {
            this.f12159e = str;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"uid\" is null.");
            }
            this.f12158d = str;
        }

        public ArrayList<Object> g() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.f12155a);
            arrayList.add(this.f12156b);
            arrayList.add(this.f12157c);
            arrayList.add(this.f12158d);
            arrayList.add(this.f12159e);
            return arrayList;
        }
    }

    public static final class w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12165a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f12166a;

            public w a() {
                w wVar = new w();
                wVar.b(this.f12166a);
                return wVar;
            }

            public a b(String str) {
                this.f12166a = str;
                return this;
            }
        }

        public static w a(ArrayList<Object> arrayList) {
            w wVar = new w();
            wVar.b((String) arrayList.get(0));
            return wVar;
        }

        public void b(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"id\" is null.");
            }
            this.f12165a = str;
        }

        public ArrayList<Object> c() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.f12165a);
            return arrayList;
        }
    }

    public static final class x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12168b;

        public static x a(ArrayList<Object> arrayList) {
            x xVar = new x();
            xVar.e((String) arrayList.get(0));
            xVar.d((String) arrayList.get(1));
            return xVar;
        }

        public String b() {
            return this.f12168b;
        }

        public String c() {
            return this.f12167a;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"verificationCode\" is null.");
            }
            this.f12168b = str;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"verificationId\" is null.");
            }
            this.f12167a = str;
        }

        public ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f12167a);
            arrayList.add(this.f12168b);
            return arrayList;
        }
    }

    public static final class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<String> f12170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, String> f12171c;

        public static y a(ArrayList<Object> arrayList) {
            y yVar = new y();
            yVar.f((String) arrayList.get(0));
            yVar.g((List) arrayList.get(1));
            yVar.e((Map) arrayList.get(2));
            return yVar;
        }

        public Map<String, String> b() {
            return this.f12171c;
        }

        public String c() {
            return this.f12169a;
        }

        public List<String> d() {
            return this.f12170b;
        }

        public void e(Map<String, String> map) {
            this.f12171c = map;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"providerId\" is null.");
            }
            this.f12169a = str;
        }

        public void g(List<String> list) {
            this.f12170b = list;
        }

        public ArrayList<Object> h() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f12169a);
            arrayList.add(this.f12170b);
            arrayList.add(this.f12171c);
            return arrayList;
        }
    }

    public static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f12172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f12173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f12174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f12175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f12176e;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Long f12177a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Long f12178b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Long f12179c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f12180d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f12181e;

            public z a() {
                z zVar = new z();
                zVar.b(this.f12177a);
                zVar.c(this.f12178b);
                zVar.d(this.f12179c);
                zVar.e(this.f12180d);
                zVar.f(this.f12181e);
                return zVar;
            }

            public a b(Long l10) {
                this.f12177a = l10;
                return this;
            }

            public a c(Long l10) {
                this.f12178b = l10;
                return this;
            }

            public a d(Long l10) {
                this.f12179c = l10;
                return this;
            }

            public a e(String str) {
                this.f12180d = str;
                return this;
            }

            public a f(String str) {
                this.f12181e = str;
                return this;
            }
        }

        public static z a(ArrayList<Object> arrayList) {
            Long lValueOf;
            Long lValueOf2;
            z zVar = new z();
            Object obj = arrayList.get(0);
            Long lValueOf3 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            zVar.b(lValueOf);
            Object obj2 = arrayList.get(1);
            if (obj2 == null) {
                lValueOf2 = null;
            } else {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            zVar.c(lValueOf2);
            Object obj3 = arrayList.get(2);
            if (obj3 != null) {
                lValueOf3 = Long.valueOf(obj3 instanceof Integer ? ((Integer) obj3).intValue() : ((Long) obj3).longValue());
            }
            zVar.d(lValueOf3);
            zVar.e((String) arrayList.get(3));
            zVar.f((String) arrayList.get(4));
            return zVar;
        }

        public void b(Long l10) {
            this.f12172a = l10;
        }

        public void c(Long l10) {
            this.f12173b = l10;
        }

        public void d(Long l10) {
            this.f12174c = l10;
        }

        public void e(String str) {
            this.f12175d = str;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"secretKey\" is null.");
            }
            this.f12176e = str;
        }

        public ArrayList<Object> g() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.f12172a);
            arrayList.add(this.f12173b);
            arrayList.add(this.f12174c);
            arrayList.add(this.f12175d);
            arrayList.add(this.f12176e);
            return arrayList;
        }
    }

    public static ArrayList<Object> a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof g) {
            g gVar = (g) th;
            arrayList.add(gVar.f12075a);
            arrayList.add(gVar.getMessage());
            obj = gVar.f12076b;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
