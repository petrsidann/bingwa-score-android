package com.zaihui.installplugin;

import android.content.Context;
import android.net.Uri;
import f0.e;
import java.io.File;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class InstallFileProvider extends e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f6095l = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final Uri a(Context context, File file) {
            k.e(context, "context");
            k.e(file, "file");
            Uri uriG = e.g(context, context.getPackageName() + ".installFileProvider.install", file);
            k.d(uriG, "getUriForFile(...)");
            return uriG;
        }
    }
}
