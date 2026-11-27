package a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f1a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SparseArray<C0000a> f4d = new SparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SparseArray<androidx.constraintlayout.widget.d> f5e = new SparseArray<>();

    /* JADX INFO: renamed from: a0.a$a, reason: collision with other inner class name */
    public static class C0000a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<b> f7b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.constraintlayout.widget.d f9d;

        public C0000a(Context context, XmlPullParser xmlPullParser) {
            this.f8c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), d.f43d5);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == d.f50e5) {
                    this.f6a = typedArrayObtainStyledAttributes.getResourceId(index, this.f6a);
                } else if (index == d.f57f5) {
                    this.f8c = typedArrayObtainStyledAttributes.getResourceId(index, this.f8c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f8c);
                    context.getResources().getResourceName(this.f8c);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
                        this.f9d = dVar;
                        dVar.e(context, this.f8c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(b bVar) {
            this.f7b.add(bVar);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f10a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f11b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f12c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f13d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.constraintlayout.widget.d f15f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f10a = Float.NaN;
            this.f11b = Float.NaN;
            this.f12c = Float.NaN;
            this.f13d = Float.NaN;
            this.f14e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), d.f197z5);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == d.A5) {
                    this.f14e = typedArrayObtainStyledAttributes.getResourceId(index, this.f14e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f14e);
                    context.getResources().getResourceName(this.f14e);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
                        this.f15f = dVar;
                        dVar.e(context, this.f14e);
                    }
                } else if (index == d.B5) {
                    this.f13d = typedArrayObtainStyledAttributes.getDimension(index, this.f13d);
                } else if (index == d.C5) {
                    this.f11b = typedArrayObtainStyledAttributes.getDimension(index, this.f11b);
                } else if (index == d.D5) {
                    this.f12c = typedArrayObtainStyledAttributes.getDimension(index, this.f12c);
                } else if (index == d.E5) {
                    this.f10a = typedArrayObtainStyledAttributes.getDimension(index, this.f10a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public a(Context context, ConstraintLayout constraintLayout, int i10) {
        this.f1a = constraintLayout;
        a(context, i10);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void a(Context context, int i10) {
        byte b10;
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            C0000a c0000a = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                b10 = 4;
                            } else {
                                b10 = -1;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                b10 = 2;
                            } else {
                                b10 = -1;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                b10 = 1;
                            } else {
                                b10 = -1;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                b10 = 0;
                            } else {
                                b10 = -1;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                b10 = 3;
                            } else {
                                b10 = -1;
                            }
                            break;
                        default:
                            b10 = -1;
                            break;
                    }
                    if (b10 != 0 && b10 != 1) {
                        if (b10 == 2) {
                            c0000a = new C0000a(context, xml);
                            this.f4d.put(c0000a.f6a, c0000a);
                        } else if (b10 == 3) {
                            b bVar = new b(context, xml);
                            if (c0000a != null) {
                                c0000a.a(bVar);
                            }
                        } else if (b10 != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            b(context, xml);
                        }
                    }
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    public final void b(Context context, XmlPullParser xmlPullParser) {
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            if ("id".equals(xmlPullParser.getAttributeName(i10))) {
                String attributeValue = xmlPullParser.getAttributeValue(i10);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                dVar.m(context, xmlPullParser);
                this.f5e.put(identifier, dVar);
                return;
            }
        }
    }

    public void c(a0.b bVar) {
    }
}
