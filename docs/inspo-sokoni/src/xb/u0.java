package xb;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u0 extends xb.a.c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final vb.o0.a<Integer> f18972w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final vb.a1.g<Integer> f18973x;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public vb.l1 f18974s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public vb.a1 f18975t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Charset f18976u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f18977v;

    public class a implements vb.o0.a<Integer> {
        @Override // vb.a1.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer b(byte[] bArr) {
            if (bArr.length >= 3) {
                return Integer.valueOf(((bArr[0] - 48) * 100) + ((bArr[1] - 48) * 10) + (bArr[2] - 48));
            }
            throw new NumberFormatException("Malformed status code " + new String(bArr, vb.o0.f17465a));
        }

        @Override // vb.a1.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(Integer num) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        a aVar = new a();
        f18972w = aVar;
        f18973x = vb.o0.b(":status", aVar);
    }

    public u0(int i10, o2 o2Var, u2 u2Var) {
        super(i10, o2Var, u2Var);
        this.f18976u = j6.c.f11263c;
    }

    public static Charset O(vb.a1 a1Var) {
        String str = (String) a1Var.g(r0.f18864j);
        if (str != null) {
            String[] strArrSplit = str.split("charset=", 2);
            try {
                return Charset.forName(strArrSplit[strArrSplit.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return j6.c.f11263c;
    }

    public static void R(vb.a1 a1Var) {
        a1Var.e(f18973x);
        a1Var.e(vb.q0.f17491b);
        a1Var.e(vb.q0.f17490a);
    }

    public abstract void P(vb.l1 l1Var, boolean z10, vb.a1 a1Var);

    public final vb.l1 Q(vb.a1 a1Var) {
        vb.l1 l1Var = (vb.l1) a1Var.g(vb.q0.f17491b);
        if (l1Var != null) {
            return l1Var.q((String) a1Var.g(vb.q0.f17490a));
        }
        if (this.f18977v) {
            return vb.l1.f17407g.q("missing GRPC status in response");
        }
        Integer num = (Integer) a1Var.g(f18973x);
        return (num != null ? r0.m(num.intValue()) : vb.l1.f17419s.q("missing HTTP status code")).e("missing GRPC status, inferred error from HTTP status code");
    }

    public void S(y1 y1Var, boolean z10) throws Throwable {
        vb.l1 l1Var = this.f18974s;
        if (l1Var != null) {
            this.f18974s = l1Var.e("DATA-----------------------------\n" + z1.e(y1Var, this.f18976u));
            y1Var.close();
            if (this.f18974s.n().length() > 1000 || z10) {
                P(this.f18974s, false, this.f18975t);
                return;
            }
            return;
        }
        if (!this.f18977v) {
            P(vb.l1.f17419s.q("headers not received before payload"), false, new vb.a1());
            return;
        }
        int iA = y1Var.a();
        D(y1Var);
        if (z10) {
            this.f18974s = vb.l1.f17419s.q(iA > 0 ? "Received unexpected EOS on non-empty DATA frame from server" : "Received unexpected EOS on empty DATA frame from server");
            vb.a1 a1Var = new vb.a1();
            this.f18975t = a1Var;
            N(this.f18974s, false, a1Var);
        }
    }

    public void T(vb.a1 a1Var) {
        j6.m.p(a1Var, "headers");
        vb.l1 l1Var = this.f18974s;
        if (l1Var != null) {
            this.f18974s = l1Var.e("headers: " + a1Var);
            return;
        }
        try {
            if (this.f18977v) {
                vb.l1 l1VarQ = vb.l1.f17419s.q("Received headers twice");
                this.f18974s = l1VarQ;
                if (l1VarQ != null) {
                    this.f18974s = l1VarQ.e("headers: " + a1Var);
                    this.f18975t = a1Var;
                    this.f18976u = O(a1Var);
                    return;
                }
                return;
            }
            Integer num = (Integer) a1Var.g(f18973x);
            if (num != null && num.intValue() >= 100 && num.intValue() < 200) {
                vb.l1 l1Var2 = this.f18974s;
                if (l1Var2 != null) {
                    this.f18974s = l1Var2.e("headers: " + a1Var);
                    this.f18975t = a1Var;
                    this.f18976u = O(a1Var);
                    return;
                }
                return;
            }
            this.f18977v = true;
            vb.l1 l1VarV = V(a1Var);
            this.f18974s = l1VarV;
            if (l1VarV != null) {
                if (l1VarV != null) {
                    this.f18974s = l1VarV.e("headers: " + a1Var);
                    this.f18975t = a1Var;
                    this.f18976u = O(a1Var);
                    return;
                }
                return;
            }
            R(a1Var);
            E(a1Var);
            vb.l1 l1Var3 = this.f18974s;
            if (l1Var3 != null) {
                this.f18974s = l1Var3.e("headers: " + a1Var);
                this.f18975t = a1Var;
                this.f18976u = O(a1Var);
            }
        } catch (Throwable th) {
            vb.l1 l1Var4 = this.f18974s;
            if (l1Var4 != null) {
                this.f18974s = l1Var4.e("headers: " + a1Var);
                this.f18975t = a1Var;
                this.f18976u = O(a1Var);
            }
            throw th;
        }
    }

    public void U(vb.a1 a1Var) {
        j6.m.p(a1Var, "trailers");
        if (this.f18974s == null && !this.f18977v) {
            vb.l1 l1VarV = V(a1Var);
            this.f18974s = l1VarV;
            if (l1VarV != null) {
                this.f18975t = a1Var;
            }
        }
        vb.l1 l1Var = this.f18974s;
        if (l1Var == null) {
            vb.l1 l1VarQ = Q(a1Var);
            R(a1Var);
            F(a1Var, l1VarQ);
        } else {
            vb.l1 l1VarE = l1Var.e("trailers: " + a1Var);
            this.f18974s = l1VarE;
            P(l1VarE, false, this.f18975t);
        }
    }

    public final vb.l1 V(vb.a1 a1Var) {
        Integer num = (Integer) a1Var.g(f18973x);
        if (num == null) {
            return vb.l1.f17419s.q("Missing HTTP status code");
        }
        String str = (String) a1Var.g(r0.f18864j);
        if (r0.n(str)) {
            return null;
        }
        return r0.m(num.intValue()).e("invalid content-type: " + str);
    }

    @Override // xb.a.c, xb.l1.b
    public /* bridge */ /* synthetic */ void c(boolean z10) {
        super.c(z10);
    }
}
