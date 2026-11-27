package z7;

/* JADX INFO: loaded from: classes.dex */
public class i implements w7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20376a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20377b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w7.d f20378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f20379d;

    public i(f fVar) {
        this.f20379d = fVar;
    }

    public final void a() {
        if (this.f20376a) {
            throw new w7.c("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f20376a = true;
    }

    public void b(w7.d dVar, boolean z10) {
        this.f20376a = false;
        this.f20378c = dVar;
        this.f20377b = z10;
    }

    @Override // w7.h
    public w7.h d(String str) {
        a();
        this.f20379d.g(this.f20378c, str, this.f20377b);
        return this;
    }

    @Override // w7.h
    public w7.h e(boolean z10) {
        a();
        this.f20379d.l(this.f20378c, z10, this.f20377b);
        return this;
    }
}
