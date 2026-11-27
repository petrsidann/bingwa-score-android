package z5;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f20178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f20179b;

    public b(float f10, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f20178a;
            f10 += ((b) cVar).f20179b;
        }
        this.f20178a = cVar;
        this.f20179b = f10;
    }

    @Override // z5.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f20178a.a(rectF) + this.f20179b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f20178a.equals(bVar.f20178a) && this.f20179b == bVar.f20179b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20178a, Float.valueOf(this.f20179b)});
    }
}
