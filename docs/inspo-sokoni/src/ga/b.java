package ga;

import ea.c0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements e {
    @Override // ga.e
    public c0 d() {
        return new c0(l(), m());
    }

    @Override // ga.e
    public boolean e() {
        return Boolean.TRUE.equals(c("noResult"));
    }

    @Override // ga.e
    public Integer f() {
        return (Integer) c("transactionId");
    }

    @Override // ga.e
    public boolean g() {
        return h("transactionId") && f() == null;
    }

    @Override // ga.e
    public Boolean i() {
        return j("inTransaction");
    }

    public final Boolean j(String str) {
        Object objC = c(str);
        if (objC instanceof Boolean) {
            return (Boolean) objC;
        }
        return null;
    }

    public boolean k() {
        return Boolean.TRUE.equals(c("continueOnError"));
    }

    public final String l() {
        return (String) c("sql");
    }

    public final List<Object> m() {
        return (List) c("arguments");
    }

    public String toString() {
        return "" + getMethod() + " " + l() + " " + m();
    }
}
