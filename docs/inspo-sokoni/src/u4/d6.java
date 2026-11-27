package u4;

import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final URL f16093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f16094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b6 f16095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f16097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c6 f16098f;

    public d6(c6 c6Var, String str, URL url, byte[] bArr, Map<String, String> map, b6 b6Var) {
        this.f16098f = c6Var;
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.l(url);
        com.google.android.gms.common.internal.r.l(b6Var);
        this.f16093a = url;
        this.f16094b = bArr;
        this.f16095c = b6Var;
        this.f16096d = str;
        this.f16097e = map;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0110  */
    /* JADX WARN: Code duplicated, block: B:63:0x014b  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: u4.e6.<init>(java.lang.String, u4.b6, int, java.lang.Throwable, byte[], java.util.Map, u4.g6):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:224)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:93)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // java.lang.Runnable
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.d6.run():void");
    }
}
