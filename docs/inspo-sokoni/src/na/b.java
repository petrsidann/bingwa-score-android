package na;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import fb.i;
import fb.j;
import fb.l;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b implements j.c, xa.a, ya.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f13466f = {"contact_id", "display_name", "mimetype", "account_type", "account_name", "data1", "data2", "data5", "data3", "data4", "data6", "data1", "data1", "data2", "data3", "data1", "data1", "data2", "data3", "data1", "data4", "data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9", "data10"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ContentResolver f13467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f13468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0231b f13469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Resources f13470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorService f13471e = new ThreadPoolExecutor(0, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(1000));

    /* JADX INFO: renamed from: na.b$b, reason: collision with other inner class name */
    public class C0231b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j.d f13472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f13473b;

        public C0231b() {
        }

        public void a(Object obj) {
            j.d dVar = this.f13472a;
            if (dVar != null) {
                dVar.a(obj);
                this.f13472a = null;
            }
        }

        public HashMap b(String str) {
            Cursor cursorQuery = b.this.f13467a.query(ContactsContract.Data.CONTENT_URI, b.f13466f, "contact_id = ?", new String[]{str}, null);
            try {
                ArrayList arrayListO = b.this.o(cursorQuery, this.f13473b);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (arrayListO.size() > 0) {
                    return ((na.a) arrayListO.iterator().next()).i();
                }
                return null;
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        }

        public void c() {
            try {
                Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
                intent.putExtra("finishActivityOnSaveCompleted", true);
                h(intent, 52941);
            } catch (Exception unused) {
            }
        }

        public void d() {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("vnd.android.cursor.dir/contact");
            h(intent, 52943);
        }

        public void e(na.a aVar) {
            String str = aVar.f13449a;
            try {
                if (b(str) != null) {
                    Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, str);
                    Intent intent = new Intent("android.intent.action.EDIT");
                    intent.setDataAndType(uriWithAppendedPath, "vnd.android.cursor.item/contact");
                    intent.putExtra("finishActivityOnSaveCompleted", true);
                    h(intent, 52942);
                } else {
                    a(2);
                }
            } catch (Exception unused) {
                a(2);
            }
        }

        public void f(boolean z10) {
            this.f13473b = z10;
        }

        public void g(j.d dVar) {
            this.f13472a = dVar;
        }

        public void h(Intent intent, int i10) {
            throw null;
        }

        @Override // fb.l
        public boolean onActivityResult(int i10, int i11, Intent intent) {
            if (i10 == 52942 || i10 == 52941) {
                try {
                    a(b(intent.getData().getLastPathSegment()));
                } catch (NullPointerException unused) {
                    a(1);
                }
                return true;
            }
            if (i10 != 52943) {
                a(2);
                return false;
            }
            if (i11 == 0) {
                a(1);
                return true;
            }
            Uri data = intent.getData();
            Cursor cursorQuery = b.this.f13467a.query(data, null, null, null, null);
            if (cursorQuery.moveToFirst()) {
                b.this.l("openDeviceContactPicker", data.getLastPathSegment(), false, false, false, this.f13473b, this.f13472a);
            } else {
                Log.e("flutter_contacts", "onActivityResult - cursor.moveToFirst() returns false");
                a(1);
            }
            cursorQuery.close();
            return true;
        }
    }

    public class c extends C0231b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Context f13475d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ya.c f13476e;

        public c(Context context) {
            super();
            this.f13475d = context;
        }

        @Override // na.b.C0231b
        public void h(Intent intent, int i10) {
            if (this.f13476e == null) {
                this.f13475d.startActivity(intent);
            } else if (intent.resolveActivity(this.f13475d.getPackageManager()) != null) {
                this.f13476e.g().startActivityForResult(intent, i10);
            } else {
                a(2);
            }
        }

        public void i(ya.c cVar) {
            this.f13476e = cVar;
            cVar.b(this);
        }

        public void j() {
            this.f13476e.d(this);
            this.f13476e = null;
        }
    }

    public static class d extends AsyncTask<Void, Void, byte[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final na.a f13478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f13479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ContentResolver f13480c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final j.d f13481d;

        public d(na.a aVar, boolean z10, ContentResolver contentResolver, j.d dVar) {
            this.f13478a = aVar;
            this.f13479b = z10;
            this.f13480c = contentResolver;
            this.f13481d = dVar;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public byte[] doInBackground(Void... voidArr) {
            return b.t(this.f13478a.f13449a, this.f13479b, this.f13480c);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(byte[] bArr) {
            this.f13481d.a(bArr);
        }
    }

    public class e extends AsyncTask<Object, Void, ArrayList<HashMap>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j.d f13483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f13484c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f13485d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f13486e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f13487f;

        public class a implements Comparator<na.a> {
            public a() {
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(na.a aVar, na.a aVar2) {
                return aVar.compareTo(aVar2);
            }
        }

        public e(String str, j.d dVar, boolean z10, boolean z11, boolean z12, boolean z13) {
            this.f13482a = str;
            this.f13483b = dVar;
            this.f13484c = z10;
            this.f13485d = z11;
            this.f13486e = z12;
            this.f13487f = z13;
        }

        /* JADX WARN: Code duplicated, block: B:32:0x007a  */
        /* JADX WARN: Code duplicated, block: B:35:0x0084  */
        /* JADX WARN: Code duplicated, block: B:41:0x00a6  */
        /* JADX WARN: Code duplicated, block: B:45:0x00bd A[LOOP:1: B:43:0x00b7->B:45:0x00bd, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:48:0x009d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:49:0x009a A[SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<HashMap> doInBackground(Object... objArr) {
            b bVar;
            Cursor cursorP;
            b bVar2;
            Cursor cursorQ;
            ArrayList<na.a> arrayListO;
            ArrayList<HashMap> arrayList;
            Iterator it;
            byte[] bArrT;
            String str = this.f13482a;
            str.hashCode();
            switch (str) {
                case "openDeviceContactPicker":
                    bVar = b.this;
                    cursorP = bVar.p(null, (String) objArr[0]);
                    arrayListO = bVar.o(cursorP, this.f13487f);
                    if (this.f13484c) {
                        for (na.a aVar : arrayListO) {
                            bArrT = b.t(aVar.f13449a, this.f13485d, b.this.f13467a);
                            if (bArrT != null) {
                                aVar.f13465v = bArrT;
                            } else {
                                aVar.f13465v = new byte[0];
                            }
                        }
                    }
                    if (this.f13486e) {
                        Collections.sort(arrayListO, new a());
                    }
                    arrayList = new ArrayList<>();
                    it = arrayListO.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((na.a) it.next()).i());
                    }
                    return arrayList;
                case "getContactsForEmail":
                    bVar2 = b.this;
                    cursorQ = bVar2.q((String) objArr[0]);
                    arrayListO = bVar2.o(cursorQ, this.f13487f);
                    if (this.f13484c) {
                        while (r0.hasNext()) {
                            bArrT = b.t(aVar.f13449a, this.f13485d, b.this.f13467a);
                            if (bArrT != null) {
                                aVar.f13465v = bArrT;
                            } else {
                                aVar.f13465v = new byte[0];
                            }
                        }
                    }
                    if (this.f13486e) {
                        Collections.sort(arrayListO, new a());
                    }
                    arrayList = new ArrayList<>();
                    it = arrayListO.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((na.a) it.next()).i());
                    }
                    return arrayList;
                case "getContactsForPhone":
                    bVar2 = b.this;
                    cursorQ = bVar2.r((String) objArr[0]);
                    arrayListO = bVar2.o(cursorQ, this.f13487f);
                    if (this.f13484c) {
                        while (r0.hasNext()) {
                            bArrT = b.t(aVar.f13449a, this.f13485d, b.this.f13467a);
                            if (bArrT != null) {
                                aVar.f13465v = bArrT;
                            } else {
                                aVar.f13465v = new byte[0];
                            }
                        }
                    }
                    if (this.f13486e) {
                        Collections.sort(arrayListO, new a());
                    }
                    arrayList = new ArrayList<>();
                    it = arrayListO.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((na.a) it.next()).i());
                    }
                    return arrayList;
                case "getContacts":
                    bVar = b.this;
                    cursorP = bVar.p((String) objArr[0], null);
                    arrayListO = bVar.o(cursorP, this.f13487f);
                    if (this.f13484c) {
                        while (r0.hasNext()) {
                            bArrT = b.t(aVar.f13449a, this.f13485d, b.this.f13467a);
                            if (bArrT != null) {
                                aVar.f13465v = bArrT;
                            } else {
                                aVar.f13465v = new byte[0];
                            }
                        }
                    }
                    if (this.f13486e) {
                        Collections.sort(arrayListO, new a());
                    }
                    arrayList = new ArrayList<>();
                    it = arrayListO.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((na.a) it.next()).i());
                    }
                    return arrayList;
                default:
                    return null;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ArrayList<HashMap> arrayList) {
            if (arrayList == null) {
                this.f13483b.c();
            } else {
                this.f13483b.a(arrayList);
            }
        }
    }

    public static byte[] t(String str, boolean z10, ContentResolver contentResolver) {
        try {
            InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Long.parseLong(str)), z10);
            if (inputStreamOpenContactPhotoInputStream == null) {
                return null;
            }
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenContactPhotoInputStream);
            inputStreamOpenContactPhotoInputStream.close();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e10) {
            Log.e("flutter_contacts", e10.getMessage());
            return null;
        }
    }

    public final boolean i(na.a aVar) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", null).withValue("account_name", null).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data2", aVar.f13451c).withValue("data5", aVar.f13452d).withValue("data3", aVar.f13453e).withValue("data4", aVar.f13454f).withValue("data6", aVar.f13455l).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/note").withValue("data1", aVar.f13458o).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("data1", aVar.f13456m).withValue("data4", aVar.f13457n).build());
        ContentProviderOperation.Builder builderWithValue = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("is_super_primary", 1).withValue("data15", aVar.f13465v).withValue("mimetype", "vnd.android.cursor.item/photo");
        arrayList.add(builderWithValue.build());
        builderWithValue.withYieldAllowed(true);
        for (na.c cVar : aVar.f13463t) {
            ContentProviderOperation.Builder builderWithValue2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", cVar.f13491b);
            int i10 = cVar.f13492c;
            if (i10 == 0) {
                builderWithValue2.withValue("data2", 0);
                builderWithValue2.withValue("data3", cVar.f13490a);
            } else {
                builderWithValue2.withValue("data2", Integer.valueOf(i10));
            }
            arrayList.add(builderWithValue2.build());
        }
        for (na.c cVar2 : aVar.f13462s) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", cVar2.f13491b).withValue("data2", Integer.valueOf(cVar2.f13492c)).build());
        }
        for (na.d dVar : aVar.f13464u) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data2", Integer.valueOf(dVar.f13499g)).withValue("data3", dVar.f13493a).withValue("data4", dVar.f13494b).withValue("data7", dVar.f13495c).withValue("data8", dVar.f13497e).withValue("data9", dVar.f13496d).withValue("data10", dVar.f13498f).build());
        }
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/contact_event").withValue("data2", 3).withValue("data1", aVar.f13459p).build());
        try {
            this.f13467a.applyBatch("com.android.contacts", arrayList);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean j(na.a aVar) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(ContentProviderOperation.newDelete(ContactsContract.RawContacts.CONTENT_URI).withSelection("contact_id=?", new String[]{String.valueOf(aVar.f13449a)}).build());
        try {
            this.f13467a.applyBatch("com.android.contacts", arrayList);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void k(na.a aVar, boolean z10, j.d dVar) {
        new d(aVar, z10, this.f13467a, dVar).executeOnExecutor(this.f13471e, new Void[0]);
    }

    public final void l(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13, j.d dVar) {
        new e(str, dVar, z10, z11, z12, z13).executeOnExecutor(this.f13471e, str2, Boolean.FALSE);
    }

    public final void m(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13, j.d dVar) {
        new e(str, dVar, z10, z11, z12, z13).executeOnExecutor(this.f13471e, str2, Boolean.TRUE);
    }

    public final void n(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13, j.d dVar) {
        new e(str, dVar, z10, z11, z12, z13).executeOnExecutor(this.f13471e, str2, Boolean.TRUE);
    }

    public final ArrayList<na.a> o(Cursor cursor, boolean z10) {
        ArrayList<na.c> arrayList;
        na.c cVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (cursor != null && cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("contact_id"));
            if (!linkedHashMap.containsKey(string)) {
                linkedHashMap.put(string, new na.a(string));
            }
            na.a aVar = (na.a) linkedHashMap.get(string);
            String string2 = cursor.getString(cursor.getColumnIndex("mimetype"));
            aVar.f13450b = cursor.getString(cursor.getColumnIndex("display_name"));
            aVar.f13460q = cursor.getString(cursor.getColumnIndex("account_type"));
            aVar.f13461r = cursor.getString(cursor.getColumnIndex("account_name"));
            if (string2.equals("vnd.android.cursor.item/name")) {
                aVar.f13451c = cursor.getString(cursor.getColumnIndex("data2"));
                aVar.f13452d = cursor.getString(cursor.getColumnIndex("data5"));
                aVar.f13453e = cursor.getString(cursor.getColumnIndex("data3"));
                aVar.f13454f = cursor.getString(cursor.getColumnIndex("data4"));
                aVar.f13455l = cursor.getString(cursor.getColumnIndex("data6"));
            } else if (string2.equals("vnd.android.cursor.item/note")) {
                aVar.f13458o = cursor.getString(cursor.getColumnIndex("data1"));
            } else if (string2.equals("vnd.android.cursor.item/phone_v2")) {
                String string3 = cursor.getString(cursor.getColumnIndex("data1"));
                if (!TextUtils.isEmpty(string3)) {
                    int i10 = cursor.getInt(cursor.getColumnIndex("data2"));
                    String strC = na.c.c(this.f13470d, i10, cursor, z10);
                    arrayList = aVar.f13463t;
                    cVar = new na.c(strC, string3, i10);
                    arrayList.add(cVar);
                }
            } else if (string2.equals("vnd.android.cursor.item/email_v2")) {
                String string4 = cursor.getString(cursor.getColumnIndex("data1"));
                int i11 = cursor.getInt(cursor.getColumnIndex("data2"));
                if (!TextUtils.isEmpty(string4)) {
                    String strB = na.c.b(this.f13470d, i11, cursor, z10);
                    arrayList = aVar.f13462s;
                    cVar = new na.c(strB, string4, i11);
                    arrayList.add(cVar);
                }
            } else if (string2.equals("vnd.android.cursor.item/organization")) {
                aVar.f13456m = cursor.getString(cursor.getColumnIndex("data1"));
                aVar.f13457n = cursor.getString(cursor.getColumnIndex("data4"));
            } else if (string2.equals("vnd.android.cursor.item/postal-address_v2")) {
                int i12 = cursor.getInt(cursor.getColumnIndex("data2"));
                aVar.f13464u.add(new na.d(na.d.b(this.f13470d, i12, cursor, z10), cursor.getString(cursor.getColumnIndex("data4")), cursor.getString(cursor.getColumnIndex("data7")), cursor.getString(cursor.getColumnIndex("data9")), cursor.getString(cursor.getColumnIndex("data8")), cursor.getString(cursor.getColumnIndex("data10")), i12));
            } else if (string2.equals("vnd.android.cursor.item/contact_event") && cursor.getInt(cursor.getColumnIndex("data2")) == 3) {
                aVar.f13459p = cursor.getString(cursor.getColumnIndex("data1"));
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return new ArrayList<>(linkedHashMap.values());
    }

    @Override // ya.a
    public void onAttachedToActivity(ya.c cVar) {
        C0231b c0231b = this.f13469c;
        if (c0231b instanceof c) {
            ((c) c0231b).i(cVar);
        }
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        this.f13470d = bVar.a().getResources();
        s(bVar.b(), bVar.a());
        this.f13469c = new c(bVar.a());
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        C0231b c0231b = this.f13469c;
        if (c0231b instanceof c) {
            ((c) c0231b).j();
        }
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        C0231b c0231b = this.f13469c;
        if (c0231b instanceof c) {
            ((c) c0231b).j();
        }
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        this.f13468b.e(null);
        this.f13468b = null;
        this.f13467a = null;
        this.f13469c = null;
        this.f13470d = null;
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        String str;
        String str2 = iVar.f8284a;
        str2.hashCode();
        switch (str2) {
            case "openDeviceContactPicker":
                u(dVar, ((Boolean) iVar.a("androidLocalizedLabels")).booleanValue());
                break;
            case "openContactForm":
                boolean zBooleanValue = ((Boolean) iVar.a("androidLocalizedLabels")).booleanValue();
                C0231b c0231b = this.f13469c;
                if (c0231b != null) {
                    c0231b.g(dVar);
                    this.f13469c.f(zBooleanValue);
                    this.f13469c.c();
                    break;
                }
                dVar.a(2);
                break;
            case "addContact":
                if (!i(na.a.h((HashMap) iVar.f8285b))) {
                    str = "Failed to add the contact";
                    dVar.b(null, str, null);
                    break;
                }
                dVar.a(null);
                break;
            case "updateContact":
                if (!v(na.a.h((HashMap) iVar.f8285b))) {
                    str = "Failed to update the contact, make sure it has a valid identifier";
                    dVar.b(null, str, null);
                    break;
                }
                dVar.a(null);
                break;
            case "getContactsForEmail":
                m(iVar.f8284a, (String) iVar.a("email"), ((Boolean) iVar.a("withThumbnails")).booleanValue(), ((Boolean) iVar.a("photoHighResolution")).booleanValue(), ((Boolean) iVar.a("orderByGivenName")).booleanValue(), ((Boolean) iVar.a("androidLocalizedLabels")).booleanValue(), dVar);
                break;
            case "getContactsForPhone":
                n(iVar.f8284a, (String) iVar.a("phone"), ((Boolean) iVar.a("withThumbnails")).booleanValue(), ((Boolean) iVar.a("photoHighResolution")).booleanValue(), ((Boolean) iVar.a("orderByGivenName")).booleanValue(), ((Boolean) iVar.a("androidLocalizedLabels")).booleanValue(), dVar);
                break;
            case "getAvatar":
                k(na.a.h((HashMap) iVar.a("contact")), ((Boolean) iVar.a("photoHighResolution")).booleanValue(), dVar);
                break;
            case "openExistingContact":
                na.a aVarH = na.a.h((HashMap) iVar.a("contact"));
                boolean zBooleanValue2 = ((Boolean) iVar.a("androidLocalizedLabels")).booleanValue();
                C0231b c0231b2 = this.f13469c;
                if (c0231b2 != null) {
                    c0231b2.g(dVar);
                    this.f13469c.f(zBooleanValue2);
                    this.f13469c.e(aVarH);
                    break;
                }
                dVar.a(2);
                break;
            case "deleteContact":
                if (!j(na.a.h((HashMap) iVar.f8285b))) {
                    str = "Failed to delete the contact, make sure it has a valid identifier";
                    dVar.b(null, str, null);
                    break;
                }
                dVar.a(null);
                break;
            case "getContacts":
                l(iVar.f8284a, (String) iVar.a("query"), ((Boolean) iVar.a("withThumbnails")).booleanValue(), ((Boolean) iVar.a("photoHighResolution")).booleanValue(), ((Boolean) iVar.a("orderByGivenName")).booleanValue(), ((Boolean) iVar.a("androidLocalizedLabels")).booleanValue(), dVar);
                break;
            default:
                dVar.c();
                break;
        }
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(ya.c cVar) {
        C0231b c0231b = this.f13469c;
        if (c0231b instanceof c) {
            ((c) c0231b).i(cVar);
        }
    }

    public final Cursor p(String str, String str2) {
        String str3;
        ArrayList arrayList = new ArrayList(Arrays.asList("vnd.android.cursor.item/note", "vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/name", "vnd.android.cursor.item/organization", "vnd.android.cursor.item/postal-address_v2", "vnd.android.cursor.item/contact_event", "account_type"));
        if (str != null) {
            arrayList = new ArrayList();
            arrayList.add(str + "%");
            str3 = "display_name LIKE ?";
        } else {
            str3 = "(mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR account_type=?)";
        }
        if (str2 != null) {
            arrayList.add(str2);
            str3 = str3 + " AND contact_id =?";
        }
        return this.f13467a.query(ContactsContract.Data.CONTENT_URI, f13466f, str3, (String[]) arrayList.toArray(new String[arrayList.size()]), null);
    }

    public final Cursor q(String str) {
        if (str.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList("%" + str + "%"));
        return this.f13467a.query(ContactsContract.Data.CONTENT_URI, f13466f, "data1 LIKE ?", (String[]) arrayList.toArray(new String[arrayList.size()]), null);
    }

    public final Cursor r(String str) {
        if (str.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = this.f13467a.query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"_id"}, null, null, null);
        while (cursorQuery != null && cursorQuery.moveToNext()) {
            arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("_id")));
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return this.f13467a.query(ContactsContract.Data.CONTENT_URI, f13466f, "contact_id IN " + arrayList.toString().replace("[", "(").replace("]", ")"), null, null);
    }

    public final void s(fb.b bVar, Context context) {
        j jVar = new j(bVar, "github.com/clovisnicolas/flutter_contacts");
        this.f13468b = jVar;
        jVar.e(this);
        this.f13467a = context.getContentResolver();
    }

    public final void u(j.d dVar, boolean z10) {
        C0231b c0231b = this.f13469c;
        if (c0231b == null) {
            dVar.a(2);
            return;
        }
        c0231b.g(dVar);
        this.f13469c.f(z10);
        this.f13469c.d();
    }

    public final boolean v(na.a aVar) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype=?", new String[]{String.valueOf(aVar.f13449a), "vnd.android.cursor.item/organization"}).build());
        arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype=?", new String[]{String.valueOf(aVar.f13449a), "vnd.android.cursor.item/phone_v2"}).build());
        arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype=?", new String[]{String.valueOf(aVar.f13449a), "vnd.android.cursor.item/email_v2"}).build());
        arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype=?", new String[]{String.valueOf(aVar.f13449a), "vnd.android.cursor.item/note"}).build());
        arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype=?", new String[]{String.valueOf(aVar.f13449a), "vnd.android.cursor.item/postal-address_v2"}).build());
        arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype=?", new String[]{String.valueOf(aVar.f13449a), "vnd.android.cursor.item/photo"}).build());
        arrayList.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype=?", new String[]{String.valueOf(aVar.f13449a), "vnd.android.cursor.item/name"}).withValue("data2", aVar.f13451c).withValue("data5", aVar.f13452d).withValue("data3", aVar.f13453e).withValue("data4", aVar.f13454f).withValue("data6", aVar.f13455l).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("raw_contact_id", aVar.f13449a).withValue("data2", 1).withValue("data1", aVar.f13456m).withValue("data4", aVar.f13457n).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("mimetype", "vnd.android.cursor.item/note").withValue("raw_contact_id", aVar.f13449a).withValue("data1", aVar.f13458o).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", aVar.f13449a).withValue("is_super_primary", 1).withValue("data15", aVar.f13465v).withValue("mimetype", "vnd.android.cursor.item/photo").build());
        for (na.c cVar : aVar.f13463t) {
            ContentProviderOperation.Builder builderWithValue = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("raw_contact_id", aVar.f13449a).withValue("data1", cVar.f13491b);
            int i10 = cVar.f13492c;
            if (i10 == 0) {
                builderWithValue.withValue("data2", 0);
                builderWithValue.withValue("data3", cVar.f13490a);
            } else {
                builderWithValue.withValue("data2", Integer.valueOf(i10));
            }
            arrayList.add(builderWithValue.build());
        }
        for (na.c cVar2 : aVar.f13462s) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("raw_contact_id", aVar.f13449a).withValue("data1", cVar2.f13491b).withValue("data2", Integer.valueOf(cVar2.f13492c)).build());
        }
        for (na.d dVar : aVar.f13464u) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("raw_contact_id", aVar.f13449a).withValue("data2", Integer.valueOf(dVar.f13499g)).withValue("data4", dVar.f13494b).withValue("data7", dVar.f13495c).withValue("data8", dVar.f13497e).withValue("data9", dVar.f13496d).withValue("data10", dVar.f13498f).build());
        }
        try {
            this.f13467a.applyBatch("com.android.contacts", arrayList);
            return true;
        } catch (Exception e10) {
            Log.e("TAG", "Exception encountered while inserting contact: ");
            e10.printStackTrace();
            return false;
        }
    }
}
