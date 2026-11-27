package u;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<V> implements p6.e<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f15934d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f15935e = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f15936f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f15937l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f15938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile e f15939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile i f15940c;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(a<?> aVar, e eVar, e eVar2);

        public abstract boolean b(a<?> aVar, Object obj, Object obj2);

        public abstract boolean c(a<?> aVar, i iVar, i iVar2);

        public abstract void d(i iVar, i iVar2);

        public abstract void e(i iVar, Thread thread);
    }

    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f15941c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f15942d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f15943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f15944b;

        static {
            if (a.f15934d) {
                f15942d = null;
                f15941c = null;
            } else {
                f15942d = new c(false, null);
                f15941c = new c(true, null);
            }
        }

        public c(boolean z10, Throwable th) {
            this.f15943a = z10;
            this.f15944b = th;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f15945b = new d(new C0291a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f15946a;

        /* JADX INFO: renamed from: u.a$d$a, reason: collision with other inner class name */
        public class C0291a extends Throwable {
            public C0291a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.f15946a = (Throwable) a.l(th);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f15947d = new e(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f15948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f15949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f15950c;

        public e(Runnable runnable, Executor executor) {
            this.f15948a = runnable;
            this.f15949b = executor;
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<i, Thread> f15951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<i, i> f15952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, i> f15953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, e> f15954d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, Object> f15955e;

        public f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f15951a = atomicReferenceFieldUpdater;
            this.f15952b = atomicReferenceFieldUpdater2;
            this.f15953c = atomicReferenceFieldUpdater3;
            this.f15954d = atomicReferenceFieldUpdater4;
            this.f15955e = atomicReferenceFieldUpdater5;
        }

        @Override // u.a.b
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            return u.b.a(this.f15954d, aVar, eVar, eVar2);
        }

        @Override // u.a.b
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            return u.b.a(this.f15955e, aVar, obj, obj2);
        }

        @Override // u.a.b
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            return u.b.a(this.f15953c, aVar, iVar, iVar2);
        }

        @Override // u.a.b
        public void d(i iVar, i iVar2) {
            this.f15952b.lazySet(iVar, iVar2);
        }

        @Override // u.a.b
        public void e(i iVar, Thread thread) {
            this.f15951a.lazySet(iVar, thread);
        }
    }

    public static final class g<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a<V> f15956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p6.e<? extends V> f15957b;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15956a.f15938a != this) {
                return;
            }
            if (a.f15936f.b(this.f15956a, this, a.r(this.f15957b))) {
                a.o(this.f15956a);
            }
        }
    }

    public static final class h extends b {
        public h() {
            super();
        }

        @Override // u.a.b
        public boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f15939b != eVar) {
                    return false;
                }
                aVar.f15939b = eVar2;
                return true;
            }
        }

        @Override // u.a.b
        public boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f15938a != obj) {
                    return false;
                }
                aVar.f15938a = obj2;
                return true;
            }
        }

        @Override // u.a.b
        public boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f15940c != iVar) {
                    return false;
                }
                aVar.f15940c = iVar2;
                return true;
            }
        }

        @Override // u.a.b
        public void d(i iVar, i iVar2) {
            iVar.f15960b = iVar2;
        }

        @Override // u.a.b
        public void e(i iVar, Thread thread) {
            iVar.f15959a = thread;
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f15958c = new i(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f15959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile i f15960b;

        public i() {
            a.f15936f.e(this, Thread.currentThread());
        }

        public i(boolean z10) {
        }

        public void a(i iVar) {
            a.f15936f.d(this, iVar);
        }

        public void b() {
            Thread thread = this.f15959a;
            if (thread != null) {
                this.f15959a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        f15936f = hVar;
        if (th != null) {
            f15935e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f15937l = new Object();
    }

    public static CancellationException k(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static <T> T l(T t10) {
        t10.getClass();
        return t10;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void o(a<?> aVar) {
        e eVar = null;
        while (true) {
            aVar.v();
            aVar.i();
            e eVarN = aVar.n(eVar);
            while (eVarN != null) {
                eVar = eVarN.f15950c;
                Runnable runnable = eVarN.f15948a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f15956a;
                    if (aVar.f15938a == gVar) {
                        if (f15936f.b(aVar, gVar, r(gVar.f15957b))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    p(runnable, eVarN.f15949b);
                }
                eVarN = eVar;
            }
            return;
        }
    }

    public static void p(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f15935e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public static Object r(p6.e<?> eVar) {
        if (eVar instanceof a) {
            Object obj = ((a) eVar).f15938a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (cVar.f15943a) {
                return cVar.f15944b != null ? new c(false, cVar.f15944b) : c.f15942d;
            }
            return obj;
        }
        boolean zIsCancelled = eVar.isCancelled();
        if ((!f15934d) && zIsCancelled) {
            return c.f15942d;
        }
        try {
            Object objS = s(eVar);
            return objS == null ? f15937l : objS;
        } catch (CancellationException e10) {
            if (zIsCancelled) {
                return new c(false, e10);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + eVar, e10));
        } catch (ExecutionException e11) {
            return new d(e11.getCause());
        } catch (Throwable th) {
            return new d(th);
        }
    }

    public static <V> V s(Future<V> future) {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    public final boolean A() {
        Object obj = this.f15938a;
        return (obj instanceof c) && ((c) obj).f15943a;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        c cVar;
        Object obj = this.f15938a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        if (f15934d) {
            cVar = new c(z10, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z10 ? c.f15941c : c.f15942d;
        }
        a<V> aVar = this;
        boolean z11 = false;
        while (true) {
            if (f15936f.b(aVar, obj, cVar)) {
                if (z10) {
                    aVar.t();
                }
                o(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                p6.e<? extends V> eVar = ((g) obj).f15957b;
                if (!(eVar instanceof a)) {
                    eVar.cancel(z10);
                    return true;
                }
                aVar = (a) eVar;
                obj = aVar.f15938a;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z11 = true;
            } else {
                obj = aVar.f15938a;
                if (!(obj instanceof g)) {
                    return z11;
                }
            }
        }
    }

    @Override // p6.e
    public final void d(Runnable runnable, Executor executor) {
        l(runnable);
        l(executor);
        e eVar = this.f15939b;
        if (eVar != e.f15947d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f15950c = eVar;
                if (f15936f.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f15939b;
                }
            } while (eVar != e.f15947d);
        }
        p(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f15938a;
        if ((obj2 != null) && (!(obj2 instanceof g))) {
            return q(obj2);
        }
        i iVar = this.f15940c;
        if (iVar != i.f15958c) {
            i iVar2 = new i();
            do {
                iVar2.a(iVar);
                if (f15936f.c(this, iVar, iVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            w(iVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f15938a;
                    } while (!((obj != null) & (!(obj instanceof g))));
                    return q(obj);
                }
                iVar = this.f15940c;
            } while (iVar != i.f15958c);
        }
        return q(this.f15938a);
    }

    @Override // java.util.concurrent.Future
    public final V get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f15938a;
        if ((obj != null) && (!(obj instanceof g))) {
            return q(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.f15940c;
            if (iVar != i.f15958c) {
                i iVar2 = new i();
                while (true) {
                    iVar2.a(iVar);
                    if (f15936f.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                w(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f15938a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return q(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        w(iVar2);
                        break;
                    }
                    iVar = this.f15940c;
                    if (iVar == i.f15958c) {
                    }
                }
            }
            return q(this.f15938a);
        }
        while (nanos > 0) {
            Object obj3 = this.f15938a;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
                return q(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j11 = -nanos;
            long jConvert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
            long nanos2 = j11 - timeUnit.toNanos(jConvert);
            boolean z10 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z10) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z10) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    public final void h(StringBuilder sb2) {
        String str = "]";
        try {
            Object objS = s(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(z(objS));
            sb2.append("]");
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb2.append(str);
        } catch (RuntimeException e10) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e10.getClass());
            str = " thrown from get()]";
            sb2.append(str);
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append(str);
        }
    }

    public void i() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f15938a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f15938a;
        return (!(obj instanceof g)) & (obj != null);
    }

    public final e n(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f15939b;
        } while (!f15936f.a(this, eVar2, e.f15947d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f15950c;
            eVar4.f15950c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V q(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw k("Task was cancelled.", ((c) obj).f15944b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f15946a);
        }
        if (obj == f15937l) {
            return null;
        }
        return obj;
    }

    public void t() {
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0025  */
    public String toString() {
        String strU;
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (!isCancelled()) {
            if (isDone()) {
                h(sb2);
            } else {
                try {
                    strU = u();
                } catch (RuntimeException e10) {
                    strU = "Exception thrown from implementation: " + e10.getClass();
                }
                if (strU != null && !strU.isEmpty()) {
                    sb2.append("PENDING, info=[");
                    sb2.append(strU);
                    sb2.append("]");
                } else if (isDone()) {
                    h(sb2);
                } else {
                    str = "PENDING";
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
        str = "CANCELLED";
        sb2.append(str);
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String u() {
        Object obj = this.f15938a;
        if (obj instanceof g) {
            return "setFuture=[" + z(((g) obj).f15957b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void v() {
        i iVar;
        do {
            iVar = this.f15940c;
        } while (!f15936f.c(this, iVar, i.f15958c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f15960b;
        }
    }

    public final void w(i iVar) {
        iVar.f15959a = null;
        while (true) {
            i iVar2 = this.f15940c;
            if (iVar2 == i.f15958c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f15960b;
                if (iVar2.f15959a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f15960b = iVar4;
                    if (iVar3.f15959a == null) {
                    }
                } else if (!f15936f.c(this, iVar2, iVar4)) {
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean x(V v10) {
        if (v10 == null) {
            v10 = (V) f15937l;
        }
        if (!f15936f.b(this, null, v10)) {
            return false;
        }
        o(this);
        return true;
    }

    public boolean y(Throwable th) {
        if (!f15936f.b(this, null, new d((Throwable) l(th)))) {
            return false;
        }
        o(this);
        return true;
    }

    public final String z(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }
}
