package xb;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f19034a = new ArrayList<>();

    public x0 a(Object obj) {
        this.f19034a.add(String.valueOf(obj));
        return this;
    }

    public x0 b(String str, Object obj) {
        this.f19034a.add(str + "=" + obj);
        return this;
    }

    public String toString() {
        return this.f19034a.toString();
    }
}
