package u4;

import com.google.android.gms.internal.measurement.zzda;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class cb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final URL f16073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f16074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final za f16075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f16077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ab f16078f;

    public cb(ab abVar, String str, URL url, byte[] bArr, Map<String, String> map, za zaVar) {
        this.f16078f = abVar;
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.l(url);
        com.google.android.gms.common.internal.r.l(zaVar);
        this.f16073a = url;
        this.f16074b = bArr;
        this.f16075c = zaVar;
        this.f16076d = str;
        this.f16077e = map;
    }

    public final void a(final int i10, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.f16078f.zzl().y(new Runnable() { // from class: u4.bb
            @Override // java.lang.Runnable
            public final void run() {
                cb cbVar = this.f16042a;
                cbVar.f16075c.a(cbVar.f16076d, i10, exc, bArr, map);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:48:0x010f  */
    /* JADX WARN: Code duplicated, block: B:60:0x0136  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        Map<String, List<String>> map;
        Map<String, List<String>> map2;
        this.f16078f.h();
        int responseCode = 0;
        try {
            URLConnection uRLConnectionZza = zzda.zza().zza(this.f16073a, "client-measurement");
            if (!(uRLConnectionZza instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionZza;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                try {
                    Map<String, String> map3 = this.f16077e;
                    if (map3 != null) {
                        for (Map.Entry<String, String> entry : map3.entrySet()) {
                            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    byte[] bArr = this.f16074b;
                    if (bArr != null) {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(bArr);
                            gZIPOutputStream.close();
                            byteArrayOutputStream.close();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            this.f16078f.zzj().G().b("Uploading data. size", Integer.valueOf(byteArray.length));
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                            httpURLConnection.setFixedLengthStreamingMode(byteArray.length);
                            httpURLConnection.connect();
                            OutputStream outputStream3 = httpURLConnection.getOutputStream();
                            try {
                                outputStream3.write(byteArray);
                                outputStream3.close();
                            } catch (IOException e10) {
                                map = null;
                                outputStream2 = outputStream3;
                                e = e10;
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (IOException e11) {
                                        this.f16078f.zzj().C().c("Error closing HTTP compressed POST connection output stream. appId", v5.r(this.f16076d), e11);
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                a(responseCode, e, null, map);
                            } catch (Throwable th) {
                                map2 = null;
                                outputStream = outputStream3;
                                th = th;
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e12) {
                                        this.f16078f.zzj().C().c("Error closing HTTP compressed POST connection output stream. appId", v5.r(this.f16076d), e12);
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                a(responseCode, null, null, map2);
                                throw th;
                            }
                        } catch (IOException e13) {
                            this.f16078f.zzj().C().b("Failed to gzip post request content", e13);
                            throw e13;
                        }
                    }
                    responseCode = httpURLConnection.getResponseCode();
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    try {
                        ab abVar = this.f16078f;
                        byte[] bArrQ = ab.q(httpURLConnection);
                        httpURLConnection.disconnect();
                        a(responseCode, null, bArrQ, headerFields);
                    } catch (IOException e14) {
                        map = headerFields;
                        e = e14;
                        outputStream2 = null;
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        a(responseCode, e, null, map);
                    } catch (Throwable th2) {
                        map2 = headerFields;
                        th = th2;
                        outputStream = null;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        a(responseCode, null, null, map2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                    map2 = outputStream;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    a(responseCode, null, null, map2);
                    throw th;
                }
            } catch (IOException e15) {
                e = e15;
                outputStream2 = null;
                map = outputStream2;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                a(responseCode, e, null, map);
            }
        } catch (IOException e16) {
            e = e16;
            httpURLConnection = null;
            outputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            outputStream = null;
        }
    }
}
