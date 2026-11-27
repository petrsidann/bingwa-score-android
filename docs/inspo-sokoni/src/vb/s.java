package vb;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f17500b = Logger.getLogger(s.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f17501c = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17502a = 0;

    public interface a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f17503a;

        static {
            AtomicReference atomicReference = new AtomicReference();
            f17503a = a(atomicReference);
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                s.f17500b.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }

        public static c a(AtomicReference<? super ClassNotFoundException> atomicReference) {
            try {
                return (c) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(c.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e10) {
                atomicReference.set(e10);
                return new q1();
            } catch (Exception e11) {
                throw new RuntimeException("Storage override failed to initialize", e11);
            }
        }
    }

    public static abstract class c {
        public abstract s a();

        public abstract void b(s sVar, s sVar2);

        public abstract s c(s sVar);
    }

    public s() {
        k(0);
    }

    public static <T> T d(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static s e() {
        s sVarA = j().a();
        return sVarA == null ? f17501c : sVarA;
    }

    public static c j() {
        return b.f17503a;
    }

    public static void k(int i10) {
        if (i10 == 1000) {
            f17500b.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }

    public void a(a aVar, Executor executor) {
        d(aVar, "cancellationListener");
        d(executor, "executor");
    }

    public s b() {
        s sVarC = j().c(this);
        return sVarC == null ? f17501c : sVarC;
    }

    public Throwable c() {
        return null;
    }

    public void f(s sVar) {
        d(sVar, "toAttach");
        j().b(this, sVar);
    }

    public u g() {
        return null;
    }

    public boolean h() {
        return false;
    }

    public void i(a aVar) {
    }
}
