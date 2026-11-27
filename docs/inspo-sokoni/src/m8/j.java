package m8;

/* JADX INFO: loaded from: classes.dex */
public interface j {

    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12985a;

        a(int i10) {
            this.f12985a = i10;
        }

        public int h() {
            return this.f12985a;
        }
    }

    a b(String str);
}
