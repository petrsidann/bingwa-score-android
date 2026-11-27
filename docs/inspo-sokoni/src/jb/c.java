package jb;

import fb.i;
import fb.j;

/* JADX INFO: loaded from: classes2.dex */
public class c implements j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f11338a;

    public c(a aVar) {
        this.f11338a = aVar;
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        String str = iVar.f8284a;
        str.hashCode();
        if (str.equals("check")) {
            dVar.a(this.f11338a.b());
        } else {
            dVar.c();
        }
    }
}
