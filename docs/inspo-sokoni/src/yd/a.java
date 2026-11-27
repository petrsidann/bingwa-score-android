package yd;

import android.content.Context;
import android.graphics.Bitmap;
import ie.d;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import wd.b;

/* JADX INFO: loaded from: classes2.dex */
public class a extends d<byte[]> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f19654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f19656d;

    public a(Context context, String str, b bVar) {
        this.f19654b = new WeakReference<>(context);
        this.f19655c = str;
        this.f19656d = bVar;
    }

    public byte[] i(Bitmap bitmap, ByteArrayOutputStream byteArrayOutputStream) {
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        bitmap.recycle();
        return byteArray;
    }

    @Override // ie.d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public byte[] a() throws ae.a {
        Context context = this.f19654b.get();
        if (context == null) {
            return null;
        }
        Bitmap bitmapG = je.b.k().g(context, this.f19655c);
        if (bitmapG != null) {
            return i(bitmapG, new ByteArrayOutputStream());
        }
        ae.b bVarE = ae.b.e();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("File '");
        String str = this.f19655c;
        if (str == null) {
            str = "null";
        }
        sb2.append(str);
        sb2.append("' not found or invalid");
        throw bVarE.c("BitmapResourceDecoder", "BACKGROUND_EXECUTION_EXCEPTION", sb2.toString(), "arguments.invalid.bitmap.reference");
    }

    @Override // ie.d
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public byte[] e(byte[] bArr) {
        return bArr;
    }

    @Override // ie.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void h(byte[] bArr, ae.a aVar) {
        this.f19656d.a(bArr, aVar);
    }
}
