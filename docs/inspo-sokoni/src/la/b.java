package la;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import dev.fluttercommunity.plus.androidalarmmanager.AlarmService;
import fb.f;
import fb.i;
import fb.j;
import io.flutter.view.FlutterCallbackInformation;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f12606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public io.flutter.embedding.engine.a f12607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f12608c = new AtomicBoolean(false);

    public class a implements j.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f12609a;

        public a(CountDownLatch countDownLatch) {
            this.f12609a = countDownLatch;
        }

        @Override // fb.j.d
        public void a(Object obj) {
            this.f12609a.countDown();
        }

        @Override // fb.j.d
        public void b(String str, String str2, Object obj) {
            this.f12609a.countDown();
        }

        @Override // fb.j.d
        public void c() {
            this.f12609a.countDown();
        }
    }

    public static void e(Context context, long j10) {
        context.getSharedPreferences("dev.fluttercommunity.plus.android_alarm_manager_plugin", 0).edit().putLong("callback_handle", j10).apply();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void a(Intent intent, CountDownLatch countDownLatch) {
        JSONObject jSONObject;
        long longExtra = intent.getLongExtra("callbackHandle", 0L);
        String stringExtra = intent.getStringExtra("params");
        if (TextUtils.isEmpty(stringExtra)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(stringExtra);
            } catch (JSONException e10) {
                throw new IllegalArgumentException("Can not convert 'params' to JsonObject", e10);
            }
        }
        this.f12606a.d("invokeAlarmManagerCallback", new Object[]{Long.valueOf(longExtra), Integer.valueOf(intent.getIntExtra("id", -1)), jSONObject}, countDownLatch != null ? new a(countDownLatch) : null);
    }

    public final void b(fb.b bVar) {
        j jVar = new j(bVar, "dev.fluttercommunity.plus/android_alarm_manager_background", f.f8283a);
        this.f12606a = jVar;
        jVar.e(this);
    }

    public boolean c() {
        return this.f12608c.get();
    }

    public final void d() {
        this.f12608c.set(true);
        AlarmService.r();
    }

    public void f(Context context) {
        if (c()) {
            return;
        }
        g(context, context.getSharedPreferences("dev.fluttercommunity.plus.android_alarm_manager_plugin", 0).getLong("callback_handle", 0L));
    }

    public void g(Context context, long j10) {
        String str;
        if (this.f12607b != null) {
            str = "Background isolate already started";
        } else {
            Log.i("FlutterBackgroundExecutor", "Starting AlarmService...");
            if (c()) {
                return;
            }
            this.f12607b = new io.flutter.embedding.engine.a(context);
            String strJ = qa.a.e().c().j();
            AssetManager assets = context.getAssets();
            FlutterCallbackInformation flutterCallbackInformationLookupCallbackInformation = FlutterCallbackInformation.lookupCallbackInformation(j10);
            if (flutterCallbackInformationLookupCallbackInformation != null) {
                ta.a aVarK = this.f12607b.k();
                b(aVarK);
                aVarK.i(new ta.a.b(assets, strJ, flutterCallbackInformationLookupCallbackInformation));
                return;
            }
            str = "Fatal: failed to find callback";
        }
        Log.e("FlutterBackgroundExecutor", str);
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        if (!iVar.f8284a.equals("AlarmService.initialized")) {
            dVar.c();
        } else {
            d();
            dVar.a(Boolean.TRUE);
        }
    }
}
