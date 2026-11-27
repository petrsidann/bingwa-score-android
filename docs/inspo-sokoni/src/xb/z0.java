package xb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 implements d0.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Throwable f19099a = d();

    public static final class a implements c {
        public static void b() {
            if (z0.f19099a != null) {
                throw new UnsupportedOperationException("JNDI is not currently available", z0.f19099a);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
        public static void c(NamingEnumeration<?> namingEnumeration, NamingException namingException) throws NamingException {
            try {
                namingEnumeration.close();
                throw namingException;
            } catch (NamingException unused) {
                throw namingException;
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
        public static void d(DirContext dirContext, NamingException namingException) throws NamingException {
            try {
                dirContext.close();
                throw namingException;
            } catch (NamingException unused) {
                throw namingException;
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
        @Override // xb.z0.c
        public List<String> a(String str, String str2) throws NamingException {
            b();
            String[] strArr = {str};
            ArrayList arrayList = new ArrayList();
            Hashtable hashtable = new Hashtable();
            hashtable.put("com.sun.jndi.ldap.connect.timeout", "5000");
            hashtable.put("com.sun.jndi.ldap.read.timeout", "5000");
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            try {
                NamingEnumeration all = initialDirContext.getAttributes(str2, strArr).getAll();
                while (all.hasMore()) {
                    try {
                        NamingEnumeration all2 = ((Attribute) all.next()).getAll();
                        while (all2.hasMore()) {
                            try {
                                arrayList.add(String.valueOf(all2.next()));
                            } catch (NamingException e10) {
                                c(all2, e10);
                            }
                        }
                        all2.close();
                    } catch (NamingException e11) {
                        c(all, e11);
                    }
                }
                all.close();
            } catch (NamingException e12) {
                d(initialDirContext, e12);
            }
            initialDirContext.close();
            return arrayList;
        }
    }

    public static final class b implements d0.f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Logger f19100b = Logger.getLogger(b.class.getName());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Pattern f19101c = Pattern.compile("\\s+");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f19102a;

        public b(c cVar) {
            this.f19102a = cVar;
        }

        public static String b(String str) {
            StringBuilder sb2 = new StringBuilder(str.length());
            int i10 = 0;
            boolean z10 = false;
            while (i10 < str.length()) {
                char cCharAt = str.charAt(i10);
                if (z10) {
                    if (cCharAt == '\"') {
                        z10 = false;
                    } else {
                        if (cCharAt == '\\') {
                            i10++;
                            cCharAt = str.charAt(i10);
                        }
                        sb2.append(cCharAt);
                    }
                } else if (cCharAt != ' ') {
                    if (cCharAt == '\"') {
                        z10 = true;
                    } else {
                        sb2.append(cCharAt);
                    }
                }
                i10++;
            }
            return sb2.toString();
        }

        @Override // xb.d0.f
        public List<String> a(String str) {
            Logger logger = f19100b;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                logger.log(level, "About to query TXT records for {0}", new Object[]{str});
            }
            List<String> listA = this.f19102a.a("TXT", "dns:///" + str);
            if (logger.isLoggable(level)) {
                logger.log(level, "Found {0} TXT records", new Object[]{Integer.valueOf(listA.size())});
            }
            ArrayList arrayList = new ArrayList(listA.size());
            Iterator<String> it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(b(it.next()));
            }
            return Collections.unmodifiableList(arrayList);
        }
    }

    public interface c {
        List<String> a(String str, String str2);
    }

    public static Throwable d() {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
        } catch (ClassNotFoundException e10) {
            return e10;
        } catch (Error e11) {
            return e11;
        } catch (RuntimeException e12) {
            return e12;
        }
    }

    @Override // xb.d0.g
    public d0.f a() {
        if (b() != null) {
            return null;
        }
        return new b(new a());
    }

    @Override // xb.d0.g
    public Throwable b() {
        return f19099a;
    }
}
