package e9;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    @Deprecated
    public k() {
    }

    public boolean e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public h h() {
        if (l()) {
            return (h) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public n i() {
        if (o()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public p j() {
        if (q()) {
            return (p) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String k() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean l() {
        return this instanceof h;
    }

    public boolean n() {
        return this instanceof m;
    }

    public boolean o() {
        return this instanceof n;
    }

    public boolean q() {
        return this instanceof p;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            m9.c cVar = new m9.c(stringWriter);
            cVar.g0(true);
            g9.m.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
