package f7;

import f7.j;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
public final class i<T_WRAPPER extends j<T_ENGINE>, T_ENGINE> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f8215b = Logger.getLogger(i.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Provider> f8216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f8217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i<j.a, Cipher> f8218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i<j.e, Mac> f8219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i<j.g, Signature> f8220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i<j.f, MessageDigest> f8221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final i<j.b, KeyAgreement> f8222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final i<j.d, KeyPairGenerator> f8223j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final i<j.c, KeyFactory> f8224k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T_WRAPPER f8225a;

    static {
        if (w6.b.c()) {
            f8216c = b("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt");
            f8217d = false;
        } else {
            f8216c = q.b() ? b("GmsCore_OpenSSL", "AndroidOpenSSL") : new ArrayList<>();
            f8217d = true;
        }
        f8218e = new i<>(new j.a());
        f8219f = new i<>(new j.e());
        f8220g = new i<>(new j.g());
        f8221h = new i<>(new j.f());
        f8222i = new i<>(new j.b());
        f8223j = new i<>(new j.d());
        f8224k = new i<>(new j.c());
    }

    public i(T_WRAPPER t_wrapper) {
        this.f8225a = t_wrapper;
    }

    public static List<Provider> b(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                f8215b.info(String.format("Provider %s not available", str));
            }
        }
        return arrayList;
    }

    public T_ENGINE a(String str) throws GeneralSecurityException {
        Iterator<Provider> it = f8216c.iterator();
        Exception exc = null;
        while (it.hasNext()) {
            try {
                return (T_ENGINE) this.f8225a.a(str, it.next());
            } catch (Exception e10) {
                if (exc == null) {
                    exc = e10;
                }
            }
        }
        if (f8217d) {
            return (T_ENGINE) this.f8225a.a(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
