package g0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class e {

    public static class a {
        public static int a(TypedArray typedArray, int i10) {
            return typedArray.getType(i10);
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d[] f8442a;

        public c(d[] dVarArr) {
            this.f8442a = dVarArr;
        }

        public d[] a() {
            return this.f8442a;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f8445c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f8446d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f8447e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f8448f;

        public d(String str, int i10, boolean z10, String str2, int i11, int i12) {
            this.f8443a = str;
            this.f8444b = i10;
            this.f8445c = z10;
            this.f8446d = str2;
            this.f8447e = i11;
            this.f8448f = i12;
        }

        public String a() {
            return this.f8443a;
        }

        public int b() {
            return this.f8448f;
        }

        public int c() {
            return this.f8447e;
        }

        public String d() {
            return this.f8446d;
        }

        public int e() {
            return this.f8444b;
        }

        public boolean f() {
            return this.f8445c;
        }
    }

    /* JADX INFO: renamed from: g0.e$e, reason: collision with other inner class name */
    public static final class C0147e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m0.e f8449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f8452d;

        public C0147e(m0.e eVar, int i10, int i11, String str) {
            this.f8449a = eVar;
            this.f8451c = i10;
            this.f8450b = i11;
            this.f8452d = str;
        }

        public int a() {
            return this.f8451c;
        }

        public m0.e b() {
            return this.f8449a;
        }

        public String c() {
            return this.f8452d;
        }

        public int d() {
            return this.f8450b;
        }
    }

    public static int a(TypedArray typedArray, int i10) {
        return a.a(typedArray, i10);
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i10) {
        if (i10 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i10);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i11 = 0; i11 < typedArrayObtainTypedArray.length(); i11++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i11, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i10)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static b d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    public static b e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), d0.g.f6244h);
        String string = typedArrayObtainAttributes.getString(d0.g.f6245i);
        String string2 = typedArrayObtainAttributes.getString(d0.g.f6249m);
        String string3 = typedArrayObtainAttributes.getString(d0.g.f6250n);
        int resourceId = typedArrayObtainAttributes.getResourceId(d0.g.f6246j, 0);
        int integer = typedArrayObtainAttributes.getInteger(d0.g.f6247k, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(d0.g.f6248l, 500);
        String string4 = typedArrayObtainAttributes.getString(d0.g.f6251o);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new C0147e(new m0.e(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((d[]) arrayList.toArray(new d[0]));
    }

    public static d f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), d0.g.f6252p);
        int i10 = d0.g.f6261y;
        if (!typedArrayObtainAttributes.hasValue(i10)) {
            i10 = d0.g.f6254r;
        }
        int i11 = typedArrayObtainAttributes.getInt(i10, 400);
        int i12 = d0.g.f6259w;
        if (!typedArrayObtainAttributes.hasValue(i12)) {
            i12 = d0.g.f6255s;
        }
        boolean z10 = 1 == typedArrayObtainAttributes.getInt(i12, 0);
        int i13 = d0.g.f6262z;
        if (!typedArrayObtainAttributes.hasValue(i13)) {
            i13 = d0.g.f6256t;
        }
        int i14 = d0.g.f6260x;
        if (!typedArrayObtainAttributes.hasValue(i14)) {
            i14 = d0.g.f6257u;
        }
        String string = typedArrayObtainAttributes.getString(i14);
        int i15 = typedArrayObtainAttributes.getInt(i13, 0);
        int i16 = d0.g.f6258v;
        if (!typedArrayObtainAttributes.hasValue(i16)) {
            i16 = d0.g.f6253q;
        }
        int resourceId = typedArrayObtainAttributes.getResourceId(i16, 0);
        String string2 = typedArrayObtainAttributes.getString(i16);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i11, z10, string, i15, resourceId);
    }

    public static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i10 = 1;
        while (i10 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i10++;
            } else if (next == 3) {
                i10--;
            }
        }
    }

    public static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
