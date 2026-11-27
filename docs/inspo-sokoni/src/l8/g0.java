package l8;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;
import vb.l1;
import vb.m1;
import vb.n1;

/* JADX INFO: loaded from: classes.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Random f12553a = new SecureRandom();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Continuation<Void, Void> f12554b = new Continuation() { // from class: l8.b0
        @Override // com.google.android.gms.tasks.Continuation
        public final Object then(Task task) {
            return g0.z(task);
        }
    };

    public static StringBuilder A(CharSequence charSequence, int i10, CharSequence charSequence2) {
        StringBuilder sb2 = new StringBuilder();
        if (i10 != 0) {
            sb2.append(charSequence);
            for (int i11 = 1; i11 < i10; i11++) {
                sb2.append(charSequence2);
                sb2.append(charSequence);
            }
        }
        return sb2;
    }

    public static String B(com.google.protobuf.i iVar) {
        int size = iVar.size();
        StringBuilder sb2 = new StringBuilder(size * 2);
        for (int i10 = 0; i10 < size; i10++) {
            int iJ = iVar.j(i10) & 255;
            sb2.append(Character.forDigit(iJ >>> 4, 16));
            sb2.append(Character.forDigit(iJ & 15, 16));
        }
        return sb2.toString();
    }

    public static String C(Object obj) {
        return obj == null ? "null" : obj.getClass().getName();
    }

    public static Continuation<Void, Void> D() {
        return f12554b;
    }

    public static <T> T e(Iterator<T> it) {
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static List<Object> f(int i10, Object obj, Object obj2, Object... objArr) {
        if (objArr.length % 2 == 1) {
            throw new IllegalArgumentException("Missing value in call to update().  There must be an even number of arguments that alternate between field names and values");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        arrayList.add(obj2);
        Collections.addAll(arrayList, objArr);
        for (int i11 = 0; i11 < arrayList.size(); i11 += 2) {
            Object obj3 = arrayList.get(i11);
            if (!(obj3 instanceof String) && !(obj3 instanceof b8.t)) {
                throw new IllegalArgumentException("Excepted field name at argument position " + (i11 + i10 + 1) + " but got " + obj3 + " in call to update.  The arguments to update should alternate between field names and values");
            }
        }
        return arrayList;
    }

    public static <T extends Comparable<T>> Comparator<T> g() {
        return new Comparator() { // from class: l8.d0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Comparable) obj).compareTo((Comparable) obj2);
            }
        };
    }

    public static int h(boolean z10, boolean z11) {
        if (z10 == z11) {
            return 0;
        }
        return z10 ? 1 : -1;
    }

    public static int i(byte[] bArr, byte[] bArr2) {
        int iMin = Math.min(bArr.length, bArr2.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            int i11 = bArr[i10] & 255;
            int i12 = bArr2[i10] & 255;
            if (i11 < i12) {
                return -1;
            }
            if (i11 > i12) {
                return 1;
            }
        }
        return l(bArr.length, bArr2.length);
    }

    public static int j(com.google.protobuf.i iVar, com.google.protobuf.i iVar2) {
        int iMin = Math.min(iVar.size(), iVar2.size());
        for (int i10 = 0; i10 < iMin; i10++) {
            int iJ = iVar.j(i10) & 255;
            int iJ2 = iVar2.j(i10) & 255;
            if (iJ < iJ2) {
                return -1;
            }
            if (iJ > iJ2) {
                return 1;
            }
        }
        return l(iVar.size(), iVar2.size());
    }

    public static int k(double d10, double d11) {
        return i6.a.c(d10, d11);
    }

    public static int l(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }

    public static int m(long j10, long j11) {
        return i6.a.a(j10, j11);
    }

    public static int n(double d10, long j10) {
        return i6.a.b(d10, j10);
    }

    public static int o(String str, String str2) {
        return j(com.google.protobuf.i.s(str), com.google.protobuf.i.s(str2));
    }

    public static Exception p(Exception exc) {
        l1 l1VarA;
        if (exc instanceof m1) {
            l1VarA = ((m1) exc).a();
        } else {
            if (!(exc instanceof n1)) {
                return exc;
            }
            l1VarA = ((n1) exc).a();
        }
        return u(l1VarA);
    }

    public static void q(final RuntimeException runtimeException) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: l8.c0
            @Override // java.lang.Runnable
            public final void run() {
                g0.w(runtimeException);
            }
        });
    }

    public static <T> void r(Collection<T> collection, Collection<T> collection2, Comparator<T> comparator, n<T> nVar, n<T> nVar2) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, comparator);
        ArrayList arrayList2 = new ArrayList(collection2);
        Collections.sort(arrayList2, comparator);
        s(arrayList.iterator(), arrayList2.iterator(), comparator, nVar, nVar2);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0023  */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void s(Iterator<T> it, Iterator<T> it2, Comparator<? super T> comparator, n<T> nVar, n<T> nVar2) {
        while (true) {
            T t10 = (Object) e(it);
            while (true) {
                a0.d dVar = (Object) e(it2);
                while (true) {
                    if (t10 == null && dVar == 0) {
                        return;
                    }
                    boolean z10 = false;
                    boolean z11 = true;
                    if (t10 != null && dVar != 0) {
                        int iCompare = comparator.compare(t10, dVar);
                        if (iCompare >= 0) {
                            if (iCompare > 0) {
                                z11 = false;
                                z10 = true;
                            } else {
                                z11 = false;
                            }
                        }
                    } else if (t10 == null) {
                        z11 = false;
                        z10 = true;
                    }
                    if (z10) {
                        nVar.accept(dVar);
                    } else if (z11) {
                        nVar2.accept(t10);
                        t10 = (Object) e(it);
                    }
                }
            }
        }
    }

    public static <T extends Comparable<T>> void t(SortedSet<T> sortedSet, SortedSet<T> sortedSet2, n<T> nVar, n<T> nVar2) {
        s(sortedSet.iterator(), sortedSet2.iterator(), sortedSet.comparator() != null ? sortedSet.comparator() : new Comparator() { // from class: l8.e0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Comparable) obj).compareTo((Comparable) obj2);
            }
        }, nVar, nVar2);
    }

    public static com.google.firebase.firestore.f u(l1 l1Var) {
        m1 m1VarC = l1Var.c();
        return new com.google.firebase.firestore.f(m1VarC.getMessage(), com.google.firebase.firestore.f.a.i(l1Var.m().i()), m1VarC);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> v(Map<K, V> map, int i10, final Comparator<V> comparator) {
        if (map.size() <= i10) {
            return map;
        }
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator() { // from class: l8.f0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return g0.y(comparator, (Map.Entry) obj, (Map.Entry) obj2);
            }
        });
        HashMap map2 = new HashMap();
        for (int i11 = 0; i11 < i10; i11++) {
            map2.put(((Map.Entry) arrayList.get(i11)).getKey(), ((Map.Entry) arrayList.get(i11)).getValue());
        }
        return map2;
    }

    public static /* synthetic */ void w(RuntimeException runtimeException) {
        throw runtimeException;
    }

    public static /* synthetic */ int y(Comparator comparator, Map.Entry entry, Map.Entry entry2) {
        return comparator.compare(entry.getValue(), entry2.getValue());
    }

    public static /* synthetic */ Void z(Task task) throws Exception {
        if (task.isSuccessful()) {
            return (Void) task.getResult();
        }
        Exception excP = p(task.getException());
        if (excP instanceof com.google.firebase.firestore.f) {
            throw excP;
        }
        throw new com.google.firebase.firestore.f(excP.getMessage(), com.google.firebase.firestore.f.a.UNKNOWN, excP);
    }
}
