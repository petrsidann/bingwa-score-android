package q9;

import android.content.Context;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes.dex */
public class o extends h {
    public o(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // q9.h
    public String c() {
        return "VGhpcyBpcyB0aGUga2V5IGZvcihBIHNlY3XyZZBzdG9yYWdlIEFFUyBLZXkK";
    }

    @Override // q9.h
    public Cipher d() {
        return Cipher.getInstance("AES/GCM/NoPadding");
    }

    @Override // q9.h
    public int e() {
        return 12;
    }

    @Override // q9.h
    public AlgorithmParameterSpec f(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }
}
