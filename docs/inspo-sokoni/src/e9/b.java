package e9;

import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f7384a;

    public b(Field field) {
        Objects.requireNonNull(field);
        this.f7384a = field;
    }

    public String toString() {
        return this.f7384a.toString();
    }
}
