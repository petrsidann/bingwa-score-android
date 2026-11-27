package h8;

import com.google.protobuf.u1;
import d9.d0;

/* JADX INFO: loaded from: classes.dex */
public final class u {
    public static u1 a(d0 d0Var) {
        return d0Var.w0().j0("__local_write_time__").z0();
    }

    public static d0 b(d0 d0Var) {
        d0 d0VarI0 = d0Var.w0().i0("__previous_value__", null);
        return c(d0VarI0) ? b(d0VarI0) : d0VarI0;
    }

    public static boolean c(d0 d0Var) {
        d0 d0VarI0 = d0Var != null ? d0Var.w0().i0("__type__", null) : null;
        return d0VarI0 != null && "server_timestamp".equals(d0VarI0.y0());
    }

    public static d0 d(h7.q qVar, d0 d0Var) {
        d0 d0VarBuild = d0.B0().S("server_timestamp").build();
        d9.u.b bVarH = d9.u.n0().H("__type__", d0VarBuild).H("__local_write_time__", d0.B0().T(u1.j0().F(qVar.k()).E(qVar.h())).build());
        if (c(d0Var)) {
            d0Var = b(d0Var);
        }
        if (d0Var != null) {
            bVarH.H("__previous_value__", d0Var);
        }
        return d0.B0().O(bVarH).build();
    }
}
