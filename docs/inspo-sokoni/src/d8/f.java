package d8;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import l8.v;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f6489g = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f6490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InputStream f6491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputStreamReader f6492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f6493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ByteBuffer f6494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f6495f;

    public f(g gVar, InputStream inputStream) {
        this.f6490a = gVar;
        this.f6491b = inputStream;
        this.f6492c = new InputStreamReader(inputStream);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1024);
        this.f6494e = byteBufferAllocate;
        byteBufferAllocate.flip();
    }

    public final IllegalArgumentException a(String str) throws IOException {
        b();
        throw new IllegalArgumentException("Invalid bundle: " + str);
    }

    public void b() throws IOException {
        this.f6491b.close();
    }

    public final c c(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("metadata")) {
            e eVarB = this.f6490a.b(jSONObject.getJSONObject("metadata"));
            v.a("BundleElement", "BundleMetadata element loaded", new Object[0]);
            return eVarB;
        }
        if (jSONObject.has("namedQuery")) {
            j jVarQ = this.f6490a.q(jSONObject.getJSONObject("namedQuery"));
            v.a("BundleElement", "Query loaded: " + jVarQ.b(), new Object[0]);
            return jVarQ;
        }
        if (jSONObject.has("documentMetadata")) {
            h hVarC = this.f6490a.c(jSONObject.getJSONObject("documentMetadata"));
            v.a("BundleElement", "Document metadata loaded: " + hVarC.b(), new Object[0]);
            return hVarC;
        }
        if (!jSONObject.has("document")) {
            throw a("Cannot decode unknown Bundle element: " + str);
        }
        b bVarF = this.f6490a.f(jSONObject.getJSONObject("document"));
        v.a("BundleElement", "Document loaded: " + bVarF.b(), new Object[0]);
        return bVarF;
    }

    public e d() {
        e eVar = this.f6493d;
        if (eVar != null) {
            return eVar;
        }
        c cVarK = k();
        if (!(cVarK instanceof e)) {
            throw a("Expected first element in bundle to be a metadata object");
        }
        e eVar2 = (e) cVarK;
        this.f6493d = eVar2;
        this.f6495f = 0L;
        return eVar2;
    }

    public long e() {
        return this.f6495f;
    }

    public c f() {
        d();
        return k();
    }

    public final int g() {
        this.f6494e.mark();
        for (int i10 = 0; i10 < this.f6494e.remaining(); i10++) {
            try {
                if (this.f6494e.get() == 123) {
                    return i10;
                }
            } finally {
                this.f6494e.reset();
            }
        }
        return -1;
    }

    public final boolean h() throws IOException {
        this.f6494e.compact();
        int i10 = this.f6491b.read(this.f6494e.array(), this.f6494e.arrayOffset() + this.f6494e.position(), this.f6494e.remaining());
        boolean z10 = i10 > 0;
        if (z10) {
            ByteBuffer byteBuffer = this.f6494e;
            byteBuffer.position(byteBuffer.position() + i10);
        }
        this.f6494e.flip();
        return z10;
    }

    public final String i(int i10) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (i10 > 0) {
            if (this.f6494e.remaining() == 0 && !h()) {
                throw a("Reached the end of bundle when more data was expected.");
            }
            int iMin = Math.min(i10, this.f6494e.remaining());
            byteArrayOutputStream.write(this.f6494e.array(), this.f6494e.arrayOffset() + this.f6494e.position(), iMin);
            ByteBuffer byteBuffer = this.f6494e;
            byteBuffer.position(byteBuffer.position() + iMin);
            i10 -= iMin;
        }
        return byteArrayOutputStream.toString(f6489g.name());
    }

    public final String j() {
        int iG;
        do {
            iG = g();
            if (iG != -1) {
                break;
            }
        } while (h());
        if (this.f6494e.remaining() == 0) {
            return null;
        }
        if (iG == -1) {
            throw a("Reached the end of bundle when a length string is expected.");
        }
        byte[] bArr = new byte[iG];
        this.f6494e.get(bArr);
        return f6489g.decode(ByteBuffer.wrap(bArr)).toString();
    }

    public final c k() {
        String strJ = j();
        if (strJ == null) {
            return null;
        }
        int i10 = Integer.parseInt(strJ);
        String strI = i(i10);
        this.f6495f += (long) (strJ.getBytes(f6489g).length + i10);
        return c(strI);
    }
}
