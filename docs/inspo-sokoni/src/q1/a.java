package q1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f14611f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static a f14612g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<BroadcastReceiver, ArrayList<c>> f14614b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f14615c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<b> f14616d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f14617e;

    /* JADX INFO: renamed from: q1.a$a, reason: collision with other inner class name */
    public class HandlerC0257a extends Handler {
        public HandlerC0257a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f14619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<c> f14620b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.f14619a = intent;
            this.f14620b = arrayList;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentFilter f14621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f14622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f14623c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f14624d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f14621a = intentFilter;
            this.f14622b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.f14622b);
            sb2.append(" filter=");
            sb2.append(this.f14621a);
            if (this.f14624d) {
                sb2.append(" DEAD");
            }
            sb2.append("}");
            return sb2.toString();
        }
    }

    public a(Context context) {
        this.f14613a = context;
        this.f14617e = new HandlerC0257a(context.getMainLooper());
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f14611f) {
            if (f14612g == null) {
                f14612g = new a(context.getApplicationContext());
            }
            aVar = f14612g;
        }
        return aVar;
    }

    public void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f14614b) {
                size = this.f14616d.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.f14616d.toArray(bVarArr);
                this.f14616d.clear();
            }
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = bVarArr[i10];
                int size2 = bVar.f14620b.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    c cVar = bVar.f14620b.get(i11);
                    if (!cVar.f14624d) {
                        cVar.f14622b.onReceive(this.f14613a, bVar.f14619a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f14614b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f14614b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f14614b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                String action = intentFilter.getAction(i10);
                ArrayList<c> arrayList2 = this.f14615c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f14615c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean d(Intent intent) {
        int i10;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        String str3;
        synchronized (this.f14614b) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f14613a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z10 = (intent.getFlags() & 8) != 0;
            if (z10) {
                Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.f14615c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z10) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i11 = 0;
                while (i11 < arrayList3.size()) {
                    c cVar = arrayList3.get(i11);
                    if (z10) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f14621a);
                    }
                    if (cVar.f14623c) {
                        if (z10) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i10 = i11;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = strResolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i10 = i11;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = strResolveTypeIfNeeded;
                        int iMatch = cVar.f14621a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (iMatch >= 0) {
                            if (z10) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.f14623c = true;
                        } else if (z10) {
                            if (iMatch == -4) {
                                str3 = "category";
                            } else if (iMatch == -3) {
                                str3 = "action";
                            } else if (iMatch != -2) {
                                str3 = iMatch != -1 ? "unknown reason" : "type";
                            } else {
                                str3 = "data";
                            }
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + str3);
                        }
                        i11 = i10 + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        strResolveTypeIfNeeded = str2;
                    }
                    arrayList4 = arrayList;
                    i11 = i10 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    strResolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i12 = 0; i12 < arrayList5.size(); i12++) {
                        ((c) arrayList5.get(i12)).f14623c = false;
                    }
                    this.f14616d.add(new b(intent, arrayList5));
                    if (!this.f14617e.hasMessages(1)) {
                        this.f14617e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f14614b) {
            ArrayList<c> arrayListRemove = this.f14614b.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                c cVar = arrayListRemove.get(size);
                cVar.f14624d = true;
                for (int i10 = 0; i10 < cVar.f14621a.countActions(); i10++) {
                    String action = cVar.f14621a.getAction(i10);
                    ArrayList<c> arrayList = this.f14615c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            c cVar2 = arrayList.get(size2);
                            if (cVar2.f14622b == broadcastReceiver) {
                                cVar2.f14624d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f14615c.remove(action);
                        }
                    }
                }
            }
        }
    }
}
