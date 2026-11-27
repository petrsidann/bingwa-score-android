package q9;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cipher f14904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SecureRandom f14905b = new SecureRandom();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Key f14906c;

    public h(Context context, a aVar) {
        String strC = c();
        SharedPreferences sharedPreferences = context.getSharedPreferences("FlutterSecureKeyStorage", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        String string = sharedPreferences.getString(strC, null);
        this.f14904a = d();
        if (string != null) {
            try {
                this.f14906c = aVar.b(Base64.decode(string, 0), "AES");
                return;
            } catch (Exception e10) {
                Log.e("StorageCipher18Impl", "unwrap key failed", e10);
            }
        }
        byte[] bArr = new byte[16];
        this.f14905b.nextBytes(bArr);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f14906c = secretKeySpec;
        editorEdit.putString(strC, Base64.encodeToString(aVar.a(secretKeySpec), 0));
        editorEdit.apply();
    }

    @Override // q9.i
    public byte[] a(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        int iE = e();
        byte[] bArr2 = new byte[iE];
        this.f14905b.nextBytes(bArr2);
        this.f14904a.init(1, this.f14906c, f(bArr2));
        byte[] bArrDoFinal = this.f14904a.doFinal(bArr);
        byte[] bArr3 = new byte[bArrDoFinal.length + iE];
        System.arraycopy(bArr2, 0, bArr3, 0, iE);
        System.arraycopy(bArrDoFinal, 0, bArr3, iE, bArrDoFinal.length);
        return bArr3;
    }

    @Override // q9.i
    public byte[] b(byte[] bArr) throws InvalidKeyException, InvalidAlgorithmParameterException {
        int iE = e();
        byte[] bArr2 = new byte[iE];
        System.arraycopy(bArr, 0, bArr2, 0, iE);
        AlgorithmParameterSpec algorithmParameterSpecF = f(bArr2);
        int length = bArr.length - e();
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, iE, bArr3, 0, length);
        this.f14904a.init(2, this.f14906c, algorithmParameterSpecF);
        return this.f14904a.doFinal(bArr3);
    }

    public String c() {
        return "VGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK";
    }

    public Cipher d() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    public int e() {
        return 16;
    }

    public AlgorithmParameterSpec f(byte[] bArr) {
        return new IvParameterSpec(bArr);
    }
}
