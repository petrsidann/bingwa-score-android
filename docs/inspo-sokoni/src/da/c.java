package da;

import android.net.Uri;
import android.provider.Telephony;
import kotlin.jvm.internal.k;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'b' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f6670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f6671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f6672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f6673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ c[] f6674f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ rc.a f6675l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f6676a;

    static {
        Uri CONTENT_URI = Telephony.Sms.Inbox.CONTENT_URI;
        k.d(CONTENT_URI, "CONTENT_URI");
        f6670b = new c("INBOX", 0, CONTENT_URI);
        Uri CONTENT_URI2 = Telephony.Sms.Sent.CONTENT_URI;
        k.d(CONTENT_URI2, "CONTENT_URI");
        f6671c = new c("SENT", 1, CONTENT_URI2);
        Uri CONTENT_URI3 = Telephony.Sms.Draft.CONTENT_URI;
        k.d(CONTENT_URI3, "CONTENT_URI");
        f6672d = new c("DRAFT", 2, CONTENT_URI3);
        Uri CONTENT_URI4 = Telephony.Sms.Conversations.CONTENT_URI;
        k.d(CONTENT_URI4, "CONTENT_URI");
        f6673e = new c("CONVERSATIONS", 3, CONTENT_URI4);
        c[] cVarArrD = d();
        f6674f = cVarArrD;
        f6675l = rc.b.a(cVarArrD);
    }

    public c(String str, int i10, Uri uri) {
        super(str, i10);
        this.f6676a = uri;
    }

    public static final /* synthetic */ c[] d() {
        return new c[]{f6670b, f6671c, f6672d, f6673e};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f6674f.clone();
    }

    public final Uri h() {
        return this.f6676a;
    }
}
