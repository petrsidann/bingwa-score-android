package y6;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.shaded.protobuf.q;
import e7.c0;
import e7.t;
import f7.k;
import java.io.CharConversionException;
import java.io.FileNotFoundException;
import r6.o;

/* JADX INFO: loaded from: classes.dex */
public final class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f19408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19409b;

    public d(Context context, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        this.f19409b = str;
        Context applicationContext = context.getApplicationContext();
        this.f19408a = str2 == null ? PreferenceManager.getDefaultSharedPreferences(applicationContext) : applicationContext.getSharedPreferences(str2, 0);
    }

    @Override // r6.o
    public t a() {
        return t.R(b(), q.b());
    }

    public final byte[] b() throws CharConversionException {
        try {
            String string = this.f19408a.getString(this.f19409b, null);
            if (string != null) {
                return k.a(string);
            }
            throw new FileNotFoundException(String.format("can't read keyset; the pref value %s does not exist", this.f19409b));
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", this.f19409b));
        }
    }

    @Override // r6.o
    public c0 read() {
        return c0.W(b(), q.b());
    }
}
