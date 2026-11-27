package c4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class m extends i1.n {
    public DialogInterface.OnCancelListener A0;
    public Dialog B0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public Dialog f3390z0;

    public static m T1(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        m mVar = new m();
        Dialog dialog2 = (Dialog) com.google.android.gms.common.internal.r.m(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        mVar.f3390z0 = dialog2;
        if (onCancelListener != null) {
            mVar.A0 = onCancelListener;
        }
        return mVar;
    }

    @Override // i1.n
    public Dialog L1(Bundle bundle) {
        Dialog dialog = this.f3390z0;
        if (dialog != null) {
            return dialog;
        }
        Q1(false);
        if (this.B0 == null) {
            this.B0 = new AlertDialog.Builder((Context) com.google.android.gms.common.internal.r.l(t())).create();
        }
        return this.B0;
    }

    @Override // i1.n
    public void S1(i1.h0 h0Var, String str) {
        super.S1(h0Var, str);
    }

    @Override // i1.n, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.A0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
