package com.example.bingwa;

import android.app.Application;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Application {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0071a f3539a = new C0071a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static io.flutter.embedding.engine.a f3540b;

    /* JADX INFO: renamed from: com.example.bingwa.a$a, reason: collision with other inner class name */
    public static final class C0071a {
        public C0071a() {
        }

        public /* synthetic */ C0071a(g gVar) {
            this();
        }

        public final io.flutter.embedding.engine.a a() {
            io.flutter.embedding.engine.a aVar = a.f3540b;
            if (aVar != null) {
                return aVar;
            }
            k.o("flutterEngine");
            return null;
        }

        public final void b(io.flutter.embedding.engine.a aVar) {
            k.e(aVar, "<set-?>");
            a.f3540b = aVar;
        }
    }
}
