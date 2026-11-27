package u9;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import fb.j;
import fb.l;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class b implements l {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f17048o = (c.class.hashCode() + 43) & 65535;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f17049p = (c.class.hashCode() + 83) & 65535;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f17050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j.d f17051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f17053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f17054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17055f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String[] f17056l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public fb.c.b f17057m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f17058n;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f17059a;

        public a(Intent intent) {
            this.f17059a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            String str;
            Uri uri;
            u9.a aVarM;
            if (this.f17059a != null) {
                ArrayList arrayList = new ArrayList();
                int i10 = 0;
                if (this.f17059a.getClipData() != null) {
                    int itemCount = this.f17059a.getClipData().getItemCount();
                    while (i10 < itemCount) {
                        Uri uri2 = this.f17059a.getClipData().getItemAt(i10).getUri();
                        if (Objects.equals(b.this.f17054e, "image/*") && b.this.f17055f > 0) {
                            uri2 = d.b(uri2, b.this.f17055f, b.this.f17050a.getApplicationContext());
                        }
                        u9.a aVarM2 = d.m(b.this.f17050a, uri2, b.this.f17053d);
                        if (aVarM2 != null) {
                            arrayList.add(aVarM2);
                            Log.d("FilePickerDelegate", "[MultiFilePick] File #" + i10 + " - URI: " + uri2.getPath());
                        }
                        i10++;
                    }
                } else if (this.f17059a.getData() != null) {
                    Uri data = this.f17059a.getData();
                    if (Objects.equals(b.this.f17054e, "image/*") && b.this.f17055f > 0) {
                        data = d.b(data, b.this.f17055f, b.this.f17050a.getApplicationContext());
                    }
                    if (b.this.f17054e.equals("dir")) {
                        Uri uriBuildDocumentUriUsingTree = DocumentsContract.buildDocumentUriUsingTree(data, DocumentsContract.getTreeDocumentId(data));
                        Log.d("FilePickerDelegate", "[SingleFilePick] File URI:" + uriBuildDocumentUriUsingTree.toString());
                        String strG = d.g(uriBuildDocumentUriUsingTree, b.this.f17050a);
                        if (strG != null) {
                            b.this.m(strG);
                            return;
                        } else {
                            b.this.l("unknown_path", "Failed to retrieve directory path.");
                            return;
                        }
                    }
                    u9.a aVarM3 = d.m(b.this.f17050a, data, b.this.f17053d);
                    if (aVarM3 != null) {
                        arrayList.add(aVarM3);
                    }
                    if (arrayList.isEmpty()) {
                        bVar = b.this;
                        str = "Failed to retrieve path.";
                        bVar.l("unknown_path", str);
                        return;
                    }
                    Log.d("FilePickerDelegate", "File path:" + arrayList.toString());
                } else if (this.f17059a.getExtras() != null) {
                    Bundle extras = this.f17059a.getExtras();
                    if (!extras.keySet().contains("selectedItems")) {
                        bVar = b.this;
                        str = "Failed to retrieve path from bundle.";
                        bVar.l("unknown_path", str);
                        return;
                    }
                    ArrayList<Parcelable> arrayListN = b.this.n(extras);
                    if (arrayListN != null) {
                        for (Parcelable parcelable : arrayListN) {
                            if ((parcelable instanceof Uri) && (aVarM = d.m(b.this.f17050a, (uri = (Uri) parcelable), b.this.f17053d)) != null) {
                                arrayList.add(aVarM);
                                Log.d("FilePickerDelegate", "[MultiFilePick] File #" + i10 + " - URI: " + uri.getPath());
                            }
                            i10++;
                        }
                    }
                }
                b.this.m(arrayList);
                return;
            }
            b.this.l("unknown_activity", "Unknown activity error, please fill an issue.");
        }
    }

    /* JADX INFO: renamed from: u9.b$b, reason: collision with other inner class name */
    public class HandlerC0296b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f17061a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0296b(Looper looper, boolean z10) {
            super(looper);
            this.f17061a = z10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b.this.f17057m.a(Boolean.valueOf(this.f17061a));
        }
    }

    public b(Activity activity) {
        this(activity, null);
    }

    public b(Activity activity, j.d dVar) {
        this.f17052c = false;
        this.f17053d = false;
        this.f17055f = 20;
        this.f17050a = activity;
        this.f17051b = dVar;
    }

    public static void k(j.d dVar) {
        dVar.b("already_active", "File picker is already active", null);
    }

    public final void i() {
        this.f17051b = null;
    }

    public final void j(boolean z10) {
        if (this.f17057m == null || this.f17054e.equals("dir")) {
            return;
        }
        new HandlerC0296b(Looper.getMainLooper(), z10).obtainMessage().sendToTarget();
    }

    public final void l(String str, String str2) {
        if (this.f17051b == null) {
            return;
        }
        j(false);
        this.f17051b.b(str, str2, null);
        i();
    }

    public final void m(Object obj) {
        j(false);
        if (this.f17051b != null) {
            if (obj != null && !(obj instanceof String)) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    arrayList.add(((u9.a) it.next()).a());
                }
                obj = arrayList;
            }
            this.f17051b.a(obj);
            i();
        }
    }

    public final ArrayList<Parcelable> n(Bundle bundle) {
        return Build.VERSION.SDK_INT >= 33 ? bundle.getParcelableArrayList("selectedItems", Parcelable.class) : bundle.getParcelableArrayList("selectedItems");
    }

    public void o(String str, String str2, String str3, String[] strArr, byte[] bArr, j.d dVar) {
        if (!q(dVar)) {
            k(dVar);
            return;
        }
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (str != null && !str.isEmpty()) {
            intent.putExtra("android.intent.extra.TITLE", str);
        }
        this.f17058n = bArr;
        if (str2 == null || "dir".equals(str2) || str2.split(",").length != 1) {
            intent.setType("*/*");
        } else {
            intent.setType(str2);
        }
        if (str3 != null && !str3.isEmpty()) {
            intent.putExtra("android.provider.extra.INITIAL_URI", Uri.parse(str3));
        }
        if (strArr != null && strArr.length > 0) {
            intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
        }
        if (intent.resolveActivity(this.f17050a.getPackageManager()) != null) {
            this.f17050a.startActivityForResult(intent, f17049p);
        } else {
            Log.e("FilePickerDelegate", "Can't find a valid activity to handle the request. Make sure you've a file explorer installed.");
            l("invalid_format_type", "Can't handle the provided file type.");
        }
    }

    @Override // fb.l
    public boolean onActivityResult(int i10, int i11, Intent intent) {
        if (i10 != f17049p) {
            if (this.f17054e == null) {
                return false;
            }
            int i12 = f17048o;
            if (i10 == i12 && i11 == -1) {
                j(true);
                new Thread(new a(intent)).start();
                return true;
            }
            if (i10 == i12 && i11 == 0) {
                Log.i("FilePickerDelegate", "User cancelled the picker request");
                m(null);
                return true;
            }
            if (i10 == i12) {
                l("unknown_activity", "Unknown activity error, please fill an issue.");
            }
            return false;
        }
        if (i11 == -1) {
            if (intent == null) {
                return false;
            }
            j(true);
            Uri data = intent.getData();
            if (data != null) {
                String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + File.separator + d.f(data, this.f17050a);
                try {
                    OutputStream outputStreamOpenOutputStream = this.f17050a.getContentResolver().openOutputStream(data);
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.write(this.f17058n);
                        outputStreamOpenOutputStream.flush();
                        outputStreamOpenOutputStream.close();
                    }
                    m(str);
                    return true;
                } catch (IOException e10) {
                    Log.i("FilePickerDelegate", "Error while saving file", e10);
                    l("Error while saving file", e10.getMessage());
                }
            }
        }
        if (i11 == 0) {
            Log.i("FilePickerDelegate", "User cancelled the save request");
            m(null);
        }
        return false;
    }

    public void p(fb.c.b bVar) {
        this.f17057m = bVar;
    }

    public final boolean q(j.d dVar) {
        if (this.f17051b != null) {
            return false;
        }
        this.f17051b = dVar;
        return true;
    }

    public final void r() {
        Intent intent;
        String str = this.f17054e;
        if (str == null) {
            return;
        }
        if (str.equals("dir")) {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        } else {
            if (this.f17054e.equals("image/*")) {
                intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            } else {
                intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
            }
            Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath() + File.separator);
            Log.d("FilePickerDelegate", "Selected type " + this.f17054e);
            intent.setDataAndType(uri, this.f17054e);
            intent.setType(this.f17054e);
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", this.f17052c);
            intent.putExtra("multi-pick", this.f17052c);
            if (this.f17054e.contains(",")) {
                this.f17056l = this.f17054e.split(",");
            }
            String[] strArr = this.f17056l;
            if (strArr != null) {
                intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
            }
        }
        if (intent.resolveActivity(this.f17050a.getPackageManager()) != null) {
            this.f17050a.startActivityForResult(intent, f17048o);
        } else {
            Log.e("FilePickerDelegate", "Can't find a valid activity to handle the request. Make sure you've a file explorer installed.");
            l("invalid_format_type", "Can't handle the provided file type.");
        }
    }

    public void s(String str, boolean z10, boolean z11, String[] strArr, int i10, j.d dVar) {
        if (!q(dVar)) {
            k(dVar);
            return;
        }
        this.f17054e = str;
        this.f17052c = z10;
        this.f17053d = z11;
        this.f17056l = strArr;
        this.f17055f = i10;
        r();
    }
}
