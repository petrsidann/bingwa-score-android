package z5;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f20177a;

    public a(float f10) {
        this.f20177a = f10;
    }

    @Override // z5.c
    public float a(RectF rectF) {
        return this.f20177a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f20177a == ((a) obj).f20177a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f20177a)});
    }
}
