package mb;

import android.util.Log;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f13129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13130b;

        public static a a(ArrayList<Object> arrayList) {
            a aVar = new a();
            aVar.e(d.values()[((Integer) arrayList.get(0)).intValue()]);
            aVar.d((String) arrayList.get(1));
            return aVar;
        }

        public String b() {
            return this.f13130b;
        }

        public d c() {
            return this.f13129a;
        }

        public void d(String str) {
            this.f13130b = str;
        }

        public void e(d dVar) {
            if (dVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f13129a = dVar;
        }

        public ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            d dVar = this.f13129a;
            arrayList.add(dVar == null ? null : Integer.valueOf(dVar.f13144a));
            arrayList.add(this.f13130b);
            return arrayList;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f13131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Double f13133c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public d f13134a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f13135b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Double f13136c;

            public b a() {
                b bVar = new b();
                bVar.c(this.f13134a);
                bVar.b(this.f13135b);
                bVar.d(this.f13136c);
                return bVar;
            }

            public a b(String str) {
                this.f13135b = str;
                return this;
            }

            public a c(d dVar) {
                this.f13134a = dVar;
                return this;
            }

            public a d(Double d10) {
                this.f13136c = d10;
                return this;
            }
        }

        public static b a(ArrayList<Object> arrayList) {
            b bVar = new b();
            bVar.c(d.values()[((Integer) arrayList.get(0)).intValue()]);
            bVar.b((String) arrayList.get(1));
            bVar.d((Double) arrayList.get(2));
            return bVar;
        }

        public void b(String str) {
            this.f13132b = str;
        }

        public void c(d dVar) {
            if (dVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f13131a = dVar;
        }

        public void d(Double d10) {
            this.f13133c = d10;
        }

        public ArrayList<Object> e() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            d dVar = this.f13131a;
            arrayList.add(dVar == null ? null : Integer.valueOf(dVar.f13144a));
            arrayList.add(this.f13132b);
            arrayList.add(this.f13133c);
            return arrayList;
        }
    }

    public enum c {
        SERVER(0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13139a;

        c(int i10) {
            this.f13139a = i10;
        }
    }

    public enum d {
        COUNT(0),
        SUM(1),
        AVERAGE(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13144a;

        d(int i10) {
            this.f13144a = i10;
        }
    }

    public enum e {
        ADDED(0),
        MODIFIED(1),
        REMOVED(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13149a;

        e(int i10) {
            this.f13149a = i10;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<Object, Object> f13151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public n f13152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public EnumC0222z f13153d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public y f13154e;

        public static f a(ArrayList<Object> arrayList) {
            f fVar = new f();
            fVar.i((String) arrayList.get(0));
            fVar.g((Map) arrayList.get(1));
            Object obj = arrayList.get(2);
            fVar.h(obj == null ? null : n.a((ArrayList) obj));
            Object obj2 = arrayList.get(3);
            fVar.k(obj2 == null ? null : EnumC0222z.values()[((Integer) obj2).intValue()]);
            Object obj3 = arrayList.get(4);
            fVar.j(obj3 != null ? y.values()[((Integer) obj3).intValue()] : null);
            return fVar;
        }

        public Map<Object, Object> b() {
            return this.f13151b;
        }

        public n c() {
            return this.f13152c;
        }

        public String d() {
            return this.f13150a;
        }

        public y e() {
            return this.f13154e;
        }

        public EnumC0222z f() {
            return this.f13153d;
        }

        public void g(Map<Object, Object> map) {
            this.f13151b = map;
        }

        public void h(n nVar) {
            this.f13152c = nVar;
        }

        public void i(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"path\" is null.");
            }
            this.f13150a = str;
        }

        public void j(y yVar) {
            this.f13154e = yVar;
        }

        public void k(EnumC0222z enumC0222z) {
            this.f13153d = enumC0222z;
        }

        public ArrayList<Object> l() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.f13150a);
            arrayList.add(this.f13151b);
            n nVar = this.f13152c;
            arrayList.add(nVar == null ? null : nVar.f());
            EnumC0222z enumC0222z = this.f13153d;
            arrayList.add(enumC0222z == null ? null : Integer.valueOf(enumC0222z.f13281a));
            y yVar = this.f13154e;
            arrayList.add(yVar != null ? Integer.valueOf(yVar.f13276a) : null);
            return arrayList;
        }
    }

    public interface g {

        public class a implements x<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13155a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13156b;

            public a(ArrayList arrayList, fb.a.e eVar) {
                this.f13155a = arrayList;
                this.f13156b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13156b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f13155a.add(0, str);
                this.f13156b.a(this.f13155a);
            }
        }

        public class b implements x<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13157a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13158b;

            public b(ArrayList arrayList, fb.a.e eVar) {
                this.f13157a = arrayList;
                this.f13158b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13158b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f13157a.add(0, str);
                this.f13158b.a(this.f13157a);
            }
        }

        public class c implements x<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13159a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13160b;

            public c(ArrayList arrayList, fb.a.e eVar) {
                this.f13159a = arrayList;
                this.f13160b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13160b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f13159a.add(0, null);
                this.f13160b.a(this.f13159a);
            }
        }

        public class d implements x<o> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13161a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13162b;

            public d(ArrayList arrayList, fb.a.e eVar) {
                this.f13161a = arrayList;
                this.f13162b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13162b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(o oVar) {
                this.f13161a.add(0, oVar);
                this.f13162b.a(this.f13161a);
            }
        }

        public class e implements x<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13163a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13164b;

            public e(ArrayList arrayList, fb.a.e eVar) {
                this.f13163a = arrayList;
                this.f13164b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13164b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f13163a.add(0, null);
                this.f13164b.a(this.f13163a);
            }
        }

        public class f implements x<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13165a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13166b;

            public f(ArrayList arrayList, fb.a.e eVar) {
                this.f13165a = arrayList;
                this.f13166b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13166b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f13165a.add(0, null);
                this.f13166b.a(this.f13165a);
            }
        }

        /* JADX INFO: renamed from: mb.z$g$g, reason: collision with other inner class name */
        public class C0221g implements x<o> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13167a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13168b;

            public C0221g(ArrayList arrayList, fb.a.e eVar) {
                this.f13167a = arrayList;
                this.f13168b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13168b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(o oVar) {
                this.f13167a.add(0, oVar);
                this.f13168b.a(this.f13167a);
            }
        }

        public class h implements x<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13169a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13170b;

            public h(ArrayList arrayList, fb.a.e eVar) {
                this.f13169a = arrayList;
                this.f13170b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13170b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f13169a.add(0, null);
                this.f13170b.a(this.f13169a);
            }
        }

        public class i implements x<s> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13171a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13172b;

            public i(ArrayList arrayList, fb.a.e eVar) {
                this.f13171a = arrayList;
                this.f13172b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13172b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(s sVar) {
                this.f13171a.add(0, sVar);
                this.f13172b.a(this.f13171a);
            }
        }

        public class j implements x<List<b>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13173a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13174b;

            public j(ArrayList arrayList, fb.a.e eVar) {
                this.f13173a = arrayList;
                this.f13174b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13174b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(List<b> list) {
                this.f13173a.add(0, list);
                this.f13174b.a(this.f13173a);
            }
        }

        public class k implements x<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13175a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13176b;

            public k(ArrayList arrayList, fb.a.e eVar) {
                this.f13175a = arrayList;
                this.f13176b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13176b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f13175a.add(0, str);
                this.f13176b.a(this.f13175a);
            }
        }

        public class l implements x<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13177a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13178b;

            public l(ArrayList arrayList, fb.a.e eVar) {
                this.f13177a = arrayList;
                this.f13178b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13178b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f13177a.add(0, null);
                this.f13178b.a(this.f13177a);
            }
        }

        public class m implements x<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13179a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13180b;

            public m(ArrayList arrayList, fb.a.e eVar) {
                this.f13179a = arrayList;
                this.f13180b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13180b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f13179a.add(0, str);
                this.f13180b.a(this.f13179a);
            }
        }

        public class n implements x<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13181a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13182b;

            public n(ArrayList arrayList, fb.a.e eVar) {
                this.f13181a = arrayList;
                this.f13182b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13182b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f13181a.add(0, str);
                this.f13182b.a(this.f13181a);
            }
        }

        public class o implements x<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13183a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13184b;

            public o(ArrayList arrayList, fb.a.e eVar) {
                this.f13183a = arrayList;
                this.f13184b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13184b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f13183a.add(0, null);
                this.f13184b.a(this.f13183a);
            }
        }

        public class p implements x<s> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13185a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13186b;

            public p(ArrayList arrayList, fb.a.e eVar) {
                this.f13185a = arrayList;
                this.f13186b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13186b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(s sVar) {
                this.f13185a.add(0, sVar);
                this.f13186b.a(this.f13185a);
            }
        }

        public class q implements x<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13187a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13188b;

            public q(ArrayList arrayList, fb.a.e eVar) {
                this.f13187a = arrayList;
                this.f13188b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13188b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f13187a.add(0, null);
                this.f13188b.a(this.f13187a);
            }
        }

        public class r implements x<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13189a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13190b;

            public r(ArrayList arrayList, fb.a.e eVar) {
                this.f13189a = arrayList;
                this.f13190b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13190b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f13189a.add(0, null);
                this.f13190b.a(this.f13189a);
            }
        }

        public class s implements x<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13191a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13192b;

            public s(ArrayList arrayList, fb.a.e eVar) {
                this.f13191a = arrayList;
                this.f13192b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13192b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f13191a.add(0, null);
                this.f13192b.a(this.f13191a);
            }
        }

        public class t implements x<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13193a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13194b;

            public t(ArrayList arrayList, fb.a.e eVar) {
                this.f13193a = arrayList;
                this.f13194b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13194b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f13193a.add(0, null);
                this.f13194b.a(this.f13193a);
            }
        }

        public class u implements x<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13195a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13196b;

            public u(ArrayList arrayList, fb.a.e eVar) {
                this.f13195a = arrayList;
                this.f13196b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13196b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f13195a.add(0, null);
                this.f13196b.a(this.f13195a);
            }
        }

        public class v implements x<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13197a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13198b;

            public v(ArrayList arrayList, fb.a.e eVar) {
                this.f13197a = arrayList;
                this.f13198b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13198b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f13197a.add(0, null);
                this.f13198b.a(this.f13197a);
            }
        }

        public class w implements x<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13199a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f13200b;

            public w(ArrayList arrayList, fb.a.e eVar) {
                this.f13199a = arrayList;
                this.f13200b = eVar;
            }

            @Override // mb.z.x
            public void b(Throwable th) {
                this.f13200b.a(z.a(th));
            }

            @Override // mb.z.x
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f13199a.add(0, null);
                this.f13200b.a(this.f13199a);
            }
        }

        static /* synthetic */ void C(g gVar, Object obj, fb.a.e eVar) {
            gVar.P((i) ((ArrayList) obj).get(0), new a(new ArrayList(), eVar));
        }

        static /* synthetic */ void F(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.k0((i) arrayList.get(0), l.values()[((Integer) arrayList.get(1)).intValue()], new o(new ArrayList(), eVar));
        }

        static /* synthetic */ void H(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.o((i) arrayList.get(0), (List) arrayList.get(1), new l(new ArrayList(), eVar));
        }

        static /* synthetic */ void I(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.Z((i) arrayList.get(0), (byte[]) arrayList.get(1), new k(new ArrayList(), eVar));
        }

        static /* synthetic */ void M(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            i iVar = (i) arrayList2.get(0);
            Number number = (Number) arrayList2.get(1);
            Number number2 = (Number) arrayList2.get(2);
            gVar.h0(iVar, number == null ? null : Long.valueOf(number.longValue()), number2 != null ? Long.valueOf(number2.longValue()) : null, new b(arrayList, eVar));
        }

        static /* synthetic */ void N(g gVar, Object obj, fb.a.e eVar) {
            gVar.A((Boolean) ((ArrayList) obj).get(0), new w(new ArrayList(), eVar));
        }

        static /* synthetic */ void O(g gVar, Object obj, fb.a.e eVar) {
            gVar.Q((i) ((ArrayList) obj).get(0), new r(new ArrayList(), eVar));
        }

        static /* synthetic */ void T(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.L((String) arrayList.get(0), v.values()[((Integer) arrayList.get(1)).intValue()], (List) arrayList.get(2), new c(new ArrayList(), eVar));
        }

        static /* synthetic */ void V(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.s((i) arrayList.get(0), (f) arrayList.get(1), new e(new ArrayList(), eVar));
        }

        static fb.h<Object> a() {
            return h.f13201e;
        }

        static /* synthetic */ void a0(g gVar, Object obj, fb.a.e eVar) {
            gVar.g((i) ((ArrayList) obj).get(0), new q(new ArrayList(), eVar));
        }

        static /* synthetic */ void c(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.b((i) arrayList.get(0), (f) arrayList.get(1), new h(new ArrayList(), eVar));
        }

        static /* synthetic */ void d0(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.U((i) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new d(new ArrayList(), eVar));
        }

        static /* synthetic */ void e0(g gVar, Object obj, fb.a.e eVar) {
            gVar.s0((i) ((ArrayList) obj).get(0), new t(new ArrayList(), eVar));
        }

        static /* synthetic */ void f(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.u((i) arrayList.get(0), (String) arrayList.get(1), (Boolean) arrayList.get(2), (r) arrayList.get(3), (q) arrayList.get(4), (Boolean) arrayList.get(5), k.values()[((Integer) arrayList.get(6)).intValue()], new m(new ArrayList(), eVar));
        }

        static /* synthetic */ void f0(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.q((i) arrayList.get(0), (f) arrayList.get(1), new f(new ArrayList(), eVar));
        }

        static /* synthetic */ void h(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.g0((i) arrayList.get(0), (String) arrayList.get(1), new v(new ArrayList(), eVar));
        }

        static /* synthetic */ void i(g gVar, Object obj, fb.a.e eVar) {
            gVar.j0((i) ((ArrayList) obj).get(0), new u(new ArrayList(), eVar));
        }

        static void l(fb.b bVar, final g gVar) {
            fb.a aVar = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.loadBundle", a());
            if (gVar != null) {
                aVar.e(new fb.a.d() { // from class: mb.a0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.I(this.f13031a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            fb.a aVar2 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.namedQueryGet", a());
            if (gVar != null) {
                aVar2.e(new fb.a.d() { // from class: mb.c0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.x(this.f13038a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            fb.a aVar3 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.clearPersistence", a());
            if (gVar != null) {
                aVar3.e(new fb.a.d() { // from class: mb.g0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.a0(this.f13051a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            fb.a aVar4 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.disableNetwork", a());
            if (gVar != null) {
                aVar4.e(new fb.a.d() { // from class: mb.h0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.O(this.f13055a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            fb.a aVar5 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.enableNetwork", a());
            if (gVar != null) {
                aVar5.e(new fb.a.d() { // from class: mb.i0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.p0(this.f13058a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
            fb.a aVar6 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.terminate", a());
            if (gVar != null) {
                aVar6.e(new fb.a.d() { // from class: mb.j0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.e0(this.f13061a, obj, eVar);
                    }
                });
            } else {
                aVar6.e(null);
            }
            fb.a aVar7 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.waitForPendingWrites", a());
            if (gVar != null) {
                aVar7.e(new fb.a.d() { // from class: mb.k0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.i(this.f13064a, obj, eVar);
                    }
                });
            } else {
                aVar7.e(null);
            }
            fb.a aVar8 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.setIndexConfiguration", a());
            if (gVar != null) {
                aVar8.e(new fb.a.d() { // from class: mb.m0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.h(this.f13072a, obj, eVar);
                    }
                });
            } else {
                aVar8.e(null);
            }
            fb.a aVar9 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.setLoggingEnabled", a());
            if (gVar != null) {
                aVar9.e(new fb.a.d() { // from class: mb.n0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.N(this.f13076a, obj, eVar);
                    }
                });
            } else {
                aVar9.e(null);
            }
            fb.a aVar10 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.snapshotsInSyncSetup", a());
            if (gVar != null) {
                aVar10.e(new fb.a.d() { // from class: mb.o0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.C(this.f13078a, obj, eVar);
                    }
                });
            } else {
                aVar10.e(null);
            }
            fb.a aVar11 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.transactionCreate", a());
            if (gVar != null) {
                aVar11.e(new fb.a.d() { // from class: mb.l0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.M(this.f13068a, obj, eVar);
                    }
                });
            } else {
                aVar11.e(null);
            }
            fb.a aVar12 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.transactionStoreResult", a());
            if (gVar != null) {
                aVar12.e(new fb.a.d() { // from class: mb.p0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.T(this.f13084a, obj, eVar);
                    }
                });
            } else {
                aVar12.e(null);
            }
            fb.a aVar13 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.transactionGet", a());
            if (gVar != null) {
                aVar13.e(new fb.a.d() { // from class: mb.q0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.d0(this.f13089a, obj, eVar);
                    }
                });
            } else {
                aVar13.e(null);
            }
            fb.a aVar14 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.documentReferenceSet", a());
            if (gVar != null) {
                aVar14.e(new fb.a.d() { // from class: mb.r0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.V(this.f13096a, obj, eVar);
                    }
                });
            } else {
                aVar14.e(null);
            }
            fb.a aVar15 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.documentReferenceUpdate", a());
            if (gVar != null) {
                aVar15.e(new fb.a.d() { // from class: mb.s0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.f0(this.f13099a, obj, eVar);
                    }
                });
            } else {
                aVar15.e(null);
            }
            fb.a aVar16 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.documentReferenceGet", a());
            if (gVar != null) {
                aVar16.e(new fb.a.d() { // from class: mb.t0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.o0(this.f13103a, obj, eVar);
                    }
                });
            } else {
                aVar16.e(null);
            }
            fb.a aVar17 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.documentReferenceDelete", a());
            if (gVar != null) {
                aVar17.e(new fb.a.d() { // from class: mb.u0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.c(this.f13107a, obj, eVar);
                    }
                });
            } else {
                aVar17.e(null);
            }
            fb.a aVar18 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.queryGet", a());
            if (gVar != null) {
                aVar18.e(new fb.a.d() { // from class: mb.v0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.m(this.f13112a, obj, eVar);
                    }
                });
            } else {
                aVar18.e(null);
            }
            fb.a aVar19 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.aggregateQuery", a());
            if (gVar != null) {
                aVar19.e(new fb.a.d() { // from class: mb.w0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.z(this.f13115a, obj, eVar);
                    }
                });
            } else {
                aVar19.e(null);
            }
            fb.a aVar20 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.writeBatchCommit", a());
            if (gVar != null) {
                aVar20.e(new fb.a.d() { // from class: mb.b0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.H(this.f13034a, obj, eVar);
                    }
                });
            } else {
                aVar20.e(null);
            }
            fb.a aVar21 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.querySnapshot", a());
            if (gVar != null) {
                aVar21.e(new fb.a.d() { // from class: mb.d0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.f(this.f13041a, obj, eVar);
                    }
                });
            } else {
                aVar21.e(null);
            }
            fb.a aVar22 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.documentReferenceSnapshot", a());
            if (gVar != null) {
                aVar22.e(new fb.a.d() { // from class: mb.e0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.t(this.f13044a, obj, eVar);
                    }
                });
            } else {
                aVar22.e(null);
            }
            fb.a aVar23 = new fb.a(bVar, "dev.flutter.pigeon.cloud_firestore_platform_interface.FirebaseFirestoreHostApi.persistenceCacheIndexManagerRequest", a());
            if (gVar != null) {
                aVar23.e(new fb.a.d() { // from class: mb.f0
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        z.g.F(this.f13048a, obj, eVar);
                    }
                });
            } else {
                aVar23.e(null);
            }
        }

        static /* synthetic */ void m(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.e((i) arrayList.get(0), (String) arrayList.get(1), (Boolean) arrayList.get(2), (r) arrayList.get(3), (q) arrayList.get(4), new i(new ArrayList(), eVar));
        }

        static /* synthetic */ void o0(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.w((i) arrayList.get(0), (f) arrayList.get(1), new C0221g(new ArrayList(), eVar));
        }

        static /* synthetic */ void p0(g gVar, Object obj, fb.a.e eVar) {
            gVar.c0((i) ((ArrayList) obj).get(0), new s(new ArrayList(), eVar));
        }

        static /* synthetic */ void t(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.J((i) arrayList.get(0), (f) arrayList.get(1), (Boolean) arrayList.get(2), k.values()[((Integer) arrayList.get(3)).intValue()], new n(new ArrayList(), eVar));
        }

        static /* synthetic */ void x(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.S((i) arrayList.get(0), (String) arrayList.get(1), (q) arrayList.get(2), new p(new ArrayList(), eVar));
        }

        static /* synthetic */ void z(g gVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            gVar.r0((i) arrayList.get(0), (String) arrayList.get(1), (r) arrayList.get(2), c.values()[((Integer) arrayList.get(3)).intValue()], (List) arrayList.get(4), (Boolean) arrayList.get(5), new j(new ArrayList(), eVar));
        }

        void A(Boolean bool, x<Void> xVar);

        void J(i iVar, f fVar, Boolean bool, k kVar, x<String> xVar);

        void L(String str, v vVar, List<u> list, x<Void> xVar);

        void P(i iVar, x<String> xVar);

        void Q(i iVar, x<Void> xVar);

        void S(i iVar, String str, q qVar, x<s> xVar);

        void U(i iVar, String str, String str2, x<o> xVar);

        void Z(i iVar, byte[] bArr, x<String> xVar);

        void b(i iVar, f fVar, x<Void> xVar);

        void c0(i iVar, x<Void> xVar);

        void e(i iVar, String str, Boolean bool, r rVar, q qVar, x<s> xVar);

        void g(i iVar, x<Void> xVar);

        void g0(i iVar, String str, x<Void> xVar);

        void h0(i iVar, Long l10, Long l11, x<String> xVar);

        void j0(i iVar, x<Void> xVar);

        void k0(i iVar, l lVar, x<Void> xVar);

        void o(i iVar, List<u> list, x<Void> xVar);

        void q(i iVar, f fVar, x<Void> xVar);

        void r0(i iVar, String str, r rVar, c cVar, List<a> list, Boolean bool, x<List<b>> xVar);

        void s(i iVar, f fVar, x<Void> xVar);

        void s0(i iVar, x<Void> xVar);

        void u(i iVar, String str, Boolean bool, r rVar, q qVar, Boolean bool2, k kVar, x<String> xVar);

        void w(i iVar, f fVar, x<o> xVar);
    }

    public static class h extends mb.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final h f13201e = new h();

        @Override // mb.c, fb.p
        public Object g(byte b10, ByteBuffer byteBuffer) {
            switch (b10) {
                case -128:
                    return a.a((ArrayList) f(byteBuffer));
                case -127:
                    return b.a((ArrayList) f(byteBuffer));
                case -126:
                    return f.a((ArrayList) f(byteBuffer));
                case -125:
                    return i.a((ArrayList) f(byteBuffer));
                case -124:
                    return m.a((ArrayList) f(byteBuffer));
                case -123:
                    return n.a((ArrayList) f(byteBuffer));
                case -122:
                    return o.a((ArrayList) f(byteBuffer));
                case -121:
                    return p.a((ArrayList) f(byteBuffer));
                case -120:
                    return q.a((ArrayList) f(byteBuffer));
                case -119:
                    return r.a((ArrayList) f(byteBuffer));
                case -118:
                    return s.a((ArrayList) f(byteBuffer));
                case -117:
                    return t.a((ArrayList) f(byteBuffer));
                case -116:
                    return u.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b10, byteBuffer);
            }
        }

        @Override // mb.c, fb.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> arrayListJ;
            if (obj instanceof a) {
                byteArrayOutputStream.write(128);
                arrayListJ = ((a) obj).f();
            } else if (obj instanceof b) {
                byteArrayOutputStream.write(129);
                arrayListJ = ((b) obj).e();
            } else if (obj instanceof f) {
                byteArrayOutputStream.write(130);
                arrayListJ = ((f) obj).l();
            } else if (obj instanceof i) {
                byteArrayOutputStream.write(131);
                arrayListJ = ((i) obj).h();
            } else if (obj instanceof m) {
                byteArrayOutputStream.write(132);
                arrayListJ = ((m) obj).f();
            } else if (obj instanceof n) {
                byteArrayOutputStream.write(133);
                arrayListJ = ((n) obj).f();
            } else if (obj instanceof o) {
                byteArrayOutputStream.write(134);
                arrayListJ = ((o) obj).e();
            } else if (obj instanceof p) {
                byteArrayOutputStream.write(135);
                arrayListJ = ((p) obj).k();
            } else if (obj instanceof q) {
                byteArrayOutputStream.write(ModuleDescriptor.MODULE_VERSION);
                arrayListJ = ((q) obj).f();
            } else if (obj instanceof r) {
                byteArrayOutputStream.write(137);
                arrayListJ = ((r) obj).t();
            } else if (obj instanceof s) {
                byteArrayOutputStream.write(138);
                arrayListJ = ((s) obj).e();
            } else if (obj instanceof t) {
                byteArrayOutputStream.write(139);
                arrayListJ = ((t) obj).d();
            } else if (!(obj instanceof u)) {
                super.p(byteArrayOutputStream, obj);
                return;
            } else {
                byteArrayOutputStream.write(140);
                arrayListJ = ((u) obj).j();
            }
            p(byteArrayOutputStream, arrayListJ);
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p f13203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13204c;

        public static i a(ArrayList<Object> arrayList) {
            i iVar = new i();
            iVar.e((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            iVar.g(obj == null ? null : p.a((ArrayList) obj));
            iVar.f((String) arrayList.get(2));
            return iVar;
        }

        public String b() {
            return this.f13202a;
        }

        public String c() {
            return this.f13204c;
        }

        public p d() {
            return this.f13203b;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"appName\" is null.");
            }
            this.f13202a = str;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"databaseURL\" is null.");
            }
            this.f13204c = str;
        }

        public void g(p pVar) {
            if (pVar == null) {
                throw new IllegalStateException("Nonnull field \"settings\" is null.");
            }
            this.f13203b = pVar;
        }

        public ArrayList<Object> h() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f13202a);
            p pVar = this.f13203b;
            arrayList.add(pVar == null ? null : pVar.k());
            arrayList.add(this.f13204c);
            return arrayList;
        }
    }

    public static class j extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f13206b;

        public j(String str, String str2, Object obj) {
            super(str2);
            this.f13205a = str;
            this.f13206b = obj;
        }
    }

    public enum k {
        DEFAULT_SOURCE(0),
        CACHE(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13210a;

        k(int i10) {
            this.f13210a = i10;
        }
    }

    public enum l {
        ENABLE_INDEX_AUTO_CREATION(0),
        DISABLE_INDEX_AUTO_CREATION(1),
        DELETE_ALL_INDEXES(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13215a;

        l(int i10) {
            this.f13215a = i10;
        }
    }

    public static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f13216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o f13217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f13218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f13219d;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public e f13220a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public o f13221b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Long f13222c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Long f13223d;

            public m a() {
                m mVar = new m();
                mVar.e(this.f13220a);
                mVar.b(this.f13221b);
                mVar.d(this.f13222c);
                mVar.c(this.f13223d);
                return mVar;
            }

            public a b(o oVar) {
                this.f13221b = oVar;
                return this;
            }

            public a c(Long l10) {
                this.f13223d = l10;
                return this;
            }

            public a d(Long l10) {
                this.f13222c = l10;
                return this;
            }

            public a e(e eVar) {
                this.f13220a = eVar;
                return this;
            }
        }

        public static m a(ArrayList<Object> arrayList) {
            Long lValueOf;
            m mVar = new m();
            mVar.e(e.values()[((Integer) arrayList.get(0)).intValue()]);
            Object obj = arrayList.get(1);
            Long lValueOf2 = null;
            mVar.b(obj == null ? null : o.a((ArrayList) obj));
            Object obj2 = arrayList.get(2);
            if (obj2 == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            mVar.d(lValueOf);
            Object obj3 = arrayList.get(3);
            if (obj3 != null) {
                lValueOf2 = Long.valueOf(obj3 instanceof Integer ? ((Integer) obj3).intValue() : ((Long) obj3).longValue());
            }
            mVar.c(lValueOf2);
            return mVar;
        }

        public void b(o oVar) {
            if (oVar == null) {
                throw new IllegalStateException("Nonnull field \"document\" is null.");
            }
            this.f13217b = oVar;
        }

        public void c(Long l10) {
            if (l10 == null) {
                throw new IllegalStateException("Nonnull field \"newIndex\" is null.");
            }
            this.f13219d = l10;
        }

        public void d(Long l10) {
            if (l10 == null) {
                throw new IllegalStateException("Nonnull field \"oldIndex\" is null.");
            }
            this.f13218c = l10;
        }

        public void e(e eVar) {
            if (eVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f13216a = eVar;
        }

        public ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            e eVar = this.f13216a;
            arrayList.add(eVar == null ? null : Integer.valueOf(eVar.f13149a));
            o oVar = this.f13217b;
            arrayList.add(oVar != null ? oVar.e() : null);
            arrayList.add(this.f13218c);
            arrayList.add(this.f13219d);
            return arrayList;
        }
    }

    public static final class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f13224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<List<String>> f13225b;

        public static n a(ArrayList<Object> arrayList) {
            n nVar = new n();
            nVar.d((Boolean) arrayList.get(0));
            nVar.e((List) arrayList.get(1));
            return nVar;
        }

        public Boolean b() {
            return this.f13224a;
        }

        public List<List<String>> c() {
            return this.f13225b;
        }

        public void d(Boolean bool) {
            this.f13224a = bool;
        }

        public void e(List<List<String>> list) {
            this.f13225b = list;
        }

        public ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f13224a);
            arrayList.add(this.f13225b);
            return arrayList;
        }
    }

    public static final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, Object> f13227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public t f13228c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f13229a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Map<String, Object> f13230b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public t f13231c;

            public o a() {
                o oVar = new o();
                oVar.d(this.f13229a);
                oVar.b(this.f13230b);
                oVar.c(this.f13231c);
                return oVar;
            }

            public a b(Map<String, Object> map) {
                this.f13230b = map;
                return this;
            }

            public a c(t tVar) {
                this.f13231c = tVar;
                return this;
            }

            public a d(String str) {
                this.f13229a = str;
                return this;
            }
        }

        public static o a(ArrayList<Object> arrayList) {
            o oVar = new o();
            oVar.d((String) arrayList.get(0));
            oVar.b((Map) arrayList.get(1));
            Object obj = arrayList.get(2);
            oVar.c(obj == null ? null : t.a((ArrayList) obj));
            return oVar;
        }

        public void b(Map<String, Object> map) {
            this.f13227b = map;
        }

        public void c(t tVar) {
            if (tVar == null) {
                throw new IllegalStateException("Nonnull field \"metadata\" is null.");
            }
            this.f13228c = tVar;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"path\" is null.");
            }
            this.f13226a = str;
        }

        public ArrayList<Object> e() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f13226a);
            arrayList.add(this.f13227b);
            t tVar = this.f13228c;
            arrayList.add(tVar == null ? null : tVar.d());
            return arrayList;
        }
    }

    public static final class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f13232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f13234c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f13235d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Boolean f13236e;

        public static p a(ArrayList<Object> arrayList) {
            Long lValueOf;
            p pVar = new p();
            pVar.i((Boolean) arrayList.get(0));
            pVar.g((String) arrayList.get(1));
            pVar.j((Boolean) arrayList.get(2));
            Object obj = arrayList.get(3);
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            pVar.f(lValueOf);
            pVar.h((Boolean) arrayList.get(4));
            return pVar;
        }

        public Long b() {
            return this.f13235d;
        }

        public String c() {
            return this.f13233b;
        }

        public Boolean d() {
            return this.f13232a;
        }

        public Boolean e() {
            return this.f13234c;
        }

        public void f(Long l10) {
            this.f13235d = l10;
        }

        public void g(String str) {
            this.f13233b = str;
        }

        public void h(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"ignoreUndefinedProperties\" is null.");
            }
            this.f13236e = bool;
        }

        public void i(Boolean bool) {
            this.f13232a = bool;
        }

        public void j(Boolean bool) {
            this.f13234c = bool;
        }

        public ArrayList<Object> k() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.f13232a);
            arrayList.add(this.f13233b);
            arrayList.add(this.f13234c);
            arrayList.add(this.f13235d);
            arrayList.add(this.f13236e);
            return arrayList;
        }
    }

    public static final class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EnumC0222z f13237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public y f13238b;

        public static q a(ArrayList<Object> arrayList) {
            q qVar = new q();
            qVar.e(EnumC0222z.values()[((Integer) arrayList.get(0)).intValue()]);
            qVar.d(y.values()[((Integer) arrayList.get(1)).intValue()]);
            return qVar;
        }

        public y b() {
            return this.f13238b;
        }

        public EnumC0222z c() {
            return this.f13237a;
        }

        public void d(y yVar) {
            if (yVar == null) {
                throw new IllegalStateException("Nonnull field \"serverTimestampBehavior\" is null.");
            }
            this.f13238b = yVar;
        }

        public void e(EnumC0222z enumC0222z) {
            if (enumC0222z == null) {
                throw new IllegalStateException("Nonnull field \"source\" is null.");
            }
            this.f13237a = enumC0222z;
        }

        public ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            EnumC0222z enumC0222z = this.f13237a;
            arrayList.add(enumC0222z == null ? null : Integer.valueOf(enumC0222z.f13281a));
            y yVar = this.f13238b;
            arrayList.add(yVar != null ? Integer.valueOf(yVar.f13276a) : null);
            return arrayList;
        }
    }

    public static final class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<List<Object>> f13239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<List<Object>> f13240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f13241c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f13242d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<Object> f13243e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<Object> f13244f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<Object> f13245g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<Object> f13246h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Map<String, Object> f13247i;

        public static r a(ArrayList<Object> arrayList) {
            Long lValueOf;
            r rVar = new r();
            rVar.s((List) arrayList.get(0));
            rVar.p((List) arrayList.get(1));
            Object obj = arrayList.get(2);
            Long lValueOf2 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            rVar.n(lValueOf);
            Object obj2 = arrayList.get(3);
            if (obj2 != null) {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            rVar.o(lValueOf2);
            rVar.r((List) arrayList.get(4));
            rVar.q((List) arrayList.get(5));
            rVar.k((List) arrayList.get(6));
            rVar.l((List) arrayList.get(7));
            rVar.m((Map) arrayList.get(8));
            return rVar;
        }

        public List<Object> b() {
            return this.f13245g;
        }

        public List<Object> c() {
            return this.f13246h;
        }

        public Map<String, Object> d() {
            return this.f13247i;
        }

        public Long e() {
            return this.f13241c;
        }

        public Long f() {
            return this.f13242d;
        }

        public List<List<Object>> g() {
            return this.f13240b;
        }

        public List<Object> h() {
            return this.f13244f;
        }

        public List<Object> i() {
            return this.f13243e;
        }

        public List<List<Object>> j() {
            return this.f13239a;
        }

        public void k(List<Object> list) {
            this.f13245g = list;
        }

        public void l(List<Object> list) {
            this.f13246h = list;
        }

        public void m(Map<String, Object> map) {
            this.f13247i = map;
        }

        public void n(Long l10) {
            this.f13241c = l10;
        }

        public void o(Long l10) {
            this.f13242d = l10;
        }

        public void p(List<List<Object>> list) {
            this.f13240b = list;
        }

        public void q(List<Object> list) {
            this.f13244f = list;
        }

        public void r(List<Object> list) {
            this.f13243e = list;
        }

        public void s(List<List<Object>> list) {
            this.f13239a = list;
        }

        public ArrayList<Object> t() {
            ArrayList<Object> arrayList = new ArrayList<>(9);
            arrayList.add(this.f13239a);
            arrayList.add(this.f13240b);
            arrayList.add(this.f13241c);
            arrayList.add(this.f13242d);
            arrayList.add(this.f13243e);
            arrayList.add(this.f13244f);
            arrayList.add(this.f13245g);
            arrayList.add(this.f13246h);
            arrayList.add(this.f13247i);
            return arrayList;
        }
    }

    public static final class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<o> f13248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<m> f13249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public t f13250c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List<o> f13251a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List<m> f13252b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public t f13253c;

            public s a() {
                s sVar = new s();
                sVar.c(this.f13251a);
                sVar.b(this.f13252b);
                sVar.d(this.f13253c);
                return sVar;
            }

            public a b(List<m> list) {
                this.f13252b = list;
                return this;
            }

            public a c(List<o> list) {
                this.f13251a = list;
                return this;
            }

            public a d(t tVar) {
                this.f13253c = tVar;
                return this;
            }
        }

        public static s a(ArrayList<Object> arrayList) {
            s sVar = new s();
            sVar.c((List) arrayList.get(0));
            sVar.b((List) arrayList.get(1));
            Object obj = arrayList.get(2);
            sVar.d(obj == null ? null : t.a((ArrayList) obj));
            return sVar;
        }

        public void b(List<m> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"documentChanges\" is null.");
            }
            this.f13249b = list;
        }

        public void c(List<o> list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"documents\" is null.");
            }
            this.f13248a = list;
        }

        public void d(t tVar) {
            if (tVar == null) {
                throw new IllegalStateException("Nonnull field \"metadata\" is null.");
            }
            this.f13250c = tVar;
        }

        public ArrayList<Object> e() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.f13248a);
            arrayList.add(this.f13249b);
            t tVar = this.f13250c;
            arrayList.add(tVar == null ? null : tVar.d());
            return arrayList;
        }
    }

    public static final class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f13254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Boolean f13255b;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Boolean f13256a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Boolean f13257b;

            public t a() {
                t tVar = new t();
                tVar.b(this.f13256a);
                tVar.c(this.f13257b);
                return tVar;
            }

            public a b(Boolean bool) {
                this.f13256a = bool;
                return this;
            }

            public a c(Boolean bool) {
                this.f13257b = bool;
                return this;
            }
        }

        public static t a(ArrayList<Object> arrayList) {
            t tVar = new t();
            tVar.b((Boolean) arrayList.get(0));
            tVar.c((Boolean) arrayList.get(1));
            return tVar;
        }

        public void b(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"hasPendingWrites\" is null.");
            }
            this.f13254a = bool;
        }

        public void c(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isFromCache\" is null.");
            }
            this.f13255b = bool;
        }

        public ArrayList<Object> d() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f13254a);
            arrayList.add(this.f13255b);
            return arrayList;
        }
    }

    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w f13258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, Object> f13260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public n f13261d;

        public static u a(ArrayList<Object> arrayList) {
            u uVar = new u();
            uVar.i(w.values()[((Integer) arrayList.get(0)).intValue()]);
            uVar.h((String) arrayList.get(1));
            uVar.f((Map) arrayList.get(2));
            Object obj = arrayList.get(3);
            uVar.g(obj == null ? null : n.a((ArrayList) obj));
            return uVar;
        }

        public Map<String, Object> b() {
            return this.f13260c;
        }

        public n c() {
            return this.f13261d;
        }

        public String d() {
            return this.f13259b;
        }

        public w e() {
            return this.f13258a;
        }

        public void f(Map<String, Object> map) {
            this.f13260c = map;
        }

        public void g(n nVar) {
            this.f13261d = nVar;
        }

        public void h(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"path\" is null.");
            }
            this.f13259b = str;
        }

        public void i(w wVar) {
            if (wVar == null) {
                throw new IllegalStateException("Nonnull field \"type\" is null.");
            }
            this.f13258a = wVar;
        }

        public ArrayList<Object> j() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            w wVar = this.f13258a;
            arrayList.add(wVar == null ? null : Integer.valueOf(wVar.f13271a));
            arrayList.add(this.f13259b);
            arrayList.add(this.f13260c);
            n nVar = this.f13261d;
            arrayList.add(nVar != null ? nVar.f() : null);
            return arrayList;
        }
    }

    public enum v {
        SUCCESS(0),
        FAILURE(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13265a;

        v(int i10) {
            this.f13265a = i10;
        }
    }

    public enum w {
        GET(0),
        UPDATE(1),
        SET(2),
        DELETE_TYPE(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13271a;

        w(int i10) {
            this.f13271a = i10;
        }
    }

    public interface x<T> {
        void a(T t10);

        void b(Throwable th);
    }

    public enum y {
        NONE(0),
        ESTIMATE(1),
        PREVIOUS(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13276a;

        y(int i10) {
            this.f13276a = i10;
        }
    }

    /* JADX INFO: renamed from: mb.z$z, reason: collision with other inner class name */
    public enum EnumC0222z {
        SERVER_AND_CACHE(0),
        SERVER(1),
        CACHE(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13281a;

        EnumC0222z(int i10) {
            this.f13281a = i10;
        }
    }

    public static ArrayList<Object> a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof j) {
            j jVar = (j) th;
            arrayList.add(jVar.f13205a);
            arrayList.add(jVar.getMessage());
            obj = jVar.f13206b;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
