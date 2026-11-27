package y6;

import android.content.Context;
import android.util.Log;
import com.google.crypto.tink.shaded.protobuf.c0;
import java.io.FileNotFoundException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.ProviderException;
import r6.k;
import r6.m;
import r6.n;
import r6.o;
import r6.p;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f19389d = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f19390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r6.a f19391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f19392c;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o f19393a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p f19394b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f19395c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public r6.a f19396d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f19397e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public k f19398f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public KeyStore f19399g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public n f19400h;

        public synchronized a d() {
            if (this.f19395c != null) {
                this.f19396d = g();
            }
            this.f19400h = f();
            return new a(this);
        }

        public final n e() {
            r6.a aVar = this.f19396d;
            if (aVar != null) {
                try {
                    return n.j(m.j(this.f19393a, aVar));
                } catch (c0 | GeneralSecurityException e10) {
                    Log.w(a.f19389d, "cannot decrypt keyset: ", e10);
                }
            }
            return n.j(r6.b.a(this.f19393a));
        }

        public final n f() throws GeneralSecurityException {
            try {
                return e();
            } catch (FileNotFoundException e10) {
                if (Log.isLoggable(a.f19389d, 4)) {
                    Log.i(a.f19389d, String.format("keyset not found, will generate a new one. %s", e10.getMessage()));
                }
                if (this.f19398f == null) {
                    throw new GeneralSecurityException("cannot read or generate keyset");
                }
                n nVarA = n.i().a(this.f19398f);
                n nVarH = nVarA.h(nVarA.d().g().R(0).R());
                if (this.f19396d != null) {
                    nVarH.d().l(this.f19394b, this.f19396d);
                } else {
                    r6.b.b(nVarH.d(), this.f19394b);
                }
                return nVarH;
            }
        }

        public final r6.a g() throws KeyStoreException {
            if (!a.d()) {
                Log.w(a.f19389d, "Android Keystore requires at least Android M");
                return null;
            }
            c cVarA = this.f19399g != null ? new c.b().b(this.f19399g).a() : new c();
            boolean zE = cVarA.e(this.f19395c);
            if (!zE) {
                try {
                    c.d(this.f19395c);
                } catch (GeneralSecurityException | ProviderException e10) {
                    Log.w(a.f19389d, "cannot use Android Keystore, it'll be disabled", e10);
                    return null;
                }
            }
            try {
                return cVarA.b(this.f19395c);
            } catch (GeneralSecurityException | ProviderException e11) {
                if (zE) {
                    throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.f19395c), e11);
                }
                Log.w(a.f19389d, "cannot use Android Keystore, it'll be disabled", e11);
                return null;
            }
        }

        public b h(k kVar) {
            this.f19398f = kVar;
            return this;
        }

        public b i(String str) {
            if (!str.startsWith("android-keystore://")) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            }
            if (!this.f19397e) {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
            this.f19395c = str;
            return this;
        }

        public b j(Context context, String str, String str2) {
            if (context == null) {
                throw new IllegalArgumentException("need an Android context");
            }
            if (str == null) {
                throw new IllegalArgumentException("need a keyset name");
            }
            this.f19393a = new d(context, str, str2);
            this.f19394b = new e(context, str, str2);
            return this;
        }
    }

    public a(b bVar) {
        this.f19390a = bVar.f19394b;
        this.f19391b = bVar.f19396d;
        this.f19392c = bVar.f19400h;
    }

    public static boolean d() {
        return true;
    }

    public synchronized m c() {
        return this.f19392c.d();
    }
}
