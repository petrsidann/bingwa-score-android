package k8;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;
import vb.l1;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f11773d = new HashSet(Arrays.asList("date", "x-google-backends", "x-google-netmon-label", "x-google-service", "x-google-gfe-request-trace"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0 f11774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l8.g f11775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f11776c;

    public class a extends y.e<d9.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f11777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f11778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f11779c;

        public a(List list, List list2, TaskCompletionSource taskCompletionSource) {
            this.f11777a = list;
            this.f11778b = list2;
            this.f11779c = taskCompletionSource;
        }

        @Override // k8.y.e
        public void a(l1 l1Var) {
            if (l1Var.o()) {
                this.f11779c.trySetResult(Collections.emptyList());
                return;
            }
            com.google.firebase.firestore.f fVarU = l8.g0.u(l1Var);
            if (fVarU.a() == com.google.firebase.firestore.f.a.UNAUTHENTICATED) {
                q.this.f11776c.h();
            }
            this.f11779c.trySetException(fVarU);
        }

        @Override // k8.y.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(d9.e eVar) {
            this.f11777a.add(eVar);
            if (this.f11777a.size() == this.f11778b.size()) {
                HashMap map = new HashMap();
                Iterator it = this.f11777a.iterator();
                while (it.hasNext()) {
                    h8.r rVarM = q.this.f11774a.m((d9.e) it.next());
                    map.put(rVarM.getKey(), rVarM);
                }
                ArrayList arrayList = new ArrayList();
                Iterator it2 = this.f11778b.iterator();
                while (it2.hasNext()) {
                    arrayList.add((h8.r) map.get((h8.k) it2.next()));
                }
                this.f11779c.trySetResult(arrayList);
            }
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11781a;

        static {
            int[] iArr = new int[com.google.firebase.firestore.f.a.values().length];
            f11781a = iArr;
            try {
                iArr[com.google.firebase.firestore.f.a.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.DEADLINE_EXCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.RESOURCE_EXHAUSTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.INTERNAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.UNAVAILABLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.UNAUTHENTICATED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.INVALID_ARGUMENT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.NOT_FOUND.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.ALREADY_EXISTS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.PERMISSION_DENIED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.FAILED_PRECONDITION.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.ABORTED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.OUT_OF_RANGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.UNIMPLEMENTED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f11781a[com.google.firebase.firestore.f.a.DATA_LOSS.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public q(l8.g gVar, o0 o0Var, y yVar) {
        this.f11775b = gVar;
        this.f11774a = o0Var;
        this.f11776c = yVar;
    }

    public static boolean g(l1 l1Var) {
        l1Var.m();
        Throwable thL = l1Var.l();
        if (!(thL instanceof SSLHandshakeException)) {
            return false;
        }
        thL.getMessage().contains("no ciphers available");
        return false;
    }

    public static boolean h(com.google.firebase.firestore.f.a aVar) {
        switch (b.f11781a[aVar.ordinal()]) {
            case 1:
                throw new IllegalArgumentException("Treated status OK as error");
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return false;
            case 9:
            case 10:
            case 11:
            case d9.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            case 13:
            case 14:
            case 15:
            case 16:
            case d9.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return true;
            default:
                throw new IllegalArgumentException("Unknown gRPC status code: " + aVar);
        }
    }

    public static boolean i(l1 l1Var) {
        return h(com.google.firebase.firestore.f.a.i(l1Var.m().i()));
    }

    public static boolean j(l1 l1Var) {
        return i(l1Var) && !l1Var.m().equals(l1.b.ABORTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List k(Task task) throws Exception {
        if (!task.isSuccessful()) {
            if ((task.getException() instanceof com.google.firebase.firestore.f) && ((com.google.firebase.firestore.f) task.getException()).a() == com.google.firebase.firestore.f.a.UNAUTHENTICATED) {
                this.f11776c.h();
            }
            throw task.getException();
        }
        d9.i iVar = (d9.i) task.getResult();
        h8.v vVarY = this.f11774a.y(iVar.e0());
        int iH0 = iVar.h0();
        ArrayList arrayList = new ArrayList(iH0);
        for (int i10 = 0; i10 < iH0; i10++) {
            arrayList.add(this.f11774a.p(iVar.g0(i10), vVarY));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map l(HashMap map, Task task) throws Exception {
        if (!task.isSuccessful()) {
            if ((task.getException() instanceof com.google.firebase.firestore.f) && ((com.google.firebase.firestore.f) task.getException()).a() == com.google.firebase.firestore.f.a.UNAUTHENTICATED) {
                this.f11776c.h();
            }
            throw task.getException();
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, d9.d0> entry : ((d9.x) task.getResult()).f0().e0().entrySet()) {
            l8.b.d(map.containsKey(entry.getKey()), "%s not present in aliasMap", entry.getKey());
            map2.put((String) map.get(entry.getKey()), entry.getValue());
        }
        return map2;
    }

    public Task<List<i8.i>> d(List<i8.f> list) {
        d9.h.b bVarJ0 = d9.h.j0();
        bVarJ0.F(this.f11774a.a());
        Iterator<i8.f> it = list.iterator();
        while (it.hasNext()) {
            bVarJ0.E(this.f11774a.O(it.next()));
        }
        return this.f11776c.n(d9.r.b(), bVarJ0.build()).continueWith(this.f11775b.o(), new Continuation() { // from class: k8.o
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f11754a.k(task);
            }
        });
    }

    public a1 e(a1.a aVar) {
        return new a1(this.f11776c, this.f11775b, this.f11774a, aVar);
    }

    public b1 f(b1.a aVar) {
        return new b1(this.f11776c, this.f11775b, this.f11774a, aVar);
    }

    public Task<List<h8.r>> m(List<h8.k> list) {
        d9.d.b bVarJ0 = d9.d.j0();
        bVarJ0.F(this.f11774a.a());
        Iterator<h8.k> it = list.iterator();
        while (it.hasNext()) {
            bVarJ0.E(this.f11774a.L(it.next()));
        }
        ArrayList arrayList = new ArrayList();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f11776c.o(d9.r.a(), bVarJ0.build(), new a(arrayList, list, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public Task<Map<String, d9.d0>> n(e8.b1 b1Var, List<com.google.firebase.firestore.a> list) {
        d9.a0.d dVarS = this.f11774a.S(b1Var.C());
        final HashMap<String, String> map = new HashMap<>();
        d9.y yVarU = this.f11774a.U(dVarS, list, map);
        d9.w.b bVarH0 = d9.w.h0();
        bVarH0.E(dVarS.h0());
        bVarH0.F(yVarU);
        return this.f11776c.n(d9.r.d(), bVarH0.build()).continueWith(this.f11775b.o(), new Continuation() { // from class: k8.p
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f11770a.l(map, task);
            }
        });
    }

    public void o() {
        this.f11776c.q();
    }
}
