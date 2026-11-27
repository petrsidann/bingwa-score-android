package zd;

/* JADX INFO: loaded from: classes2.dex */
public enum j implements p {
    Default("Default"),
    BigPicture("BigPicture"),
    BigText("BigText"),
    Inbox("Inbox"),
    ProgressBar("ProgressBar"),
    Messaging("Messaging"),
    MessagingGroup("MessagingGroup"),
    MediaPlayer("MediaPlayer");


    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static j[] f20614o = (j[]) j.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20616a;

    j(String str) {
        this.f20616a = str;
    }

    public static j i(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return null;
        }
        if (p.d(str, length, 0, 'd')) {
            return Default;
        }
        if (p.d(str, length, 0, 'b')) {
            return p.d(str, length, 3, 'p') ? BigPicture : BigText;
        }
        if (p.d(str, length, 0, 'm')) {
            if (p.d(str, length, 2, 'd')) {
                return MediaPlayer;
            }
            return p.d(str, length, 9, 'g') ? MessagingGroup : Messaging;
        }
        if (p.d(str, length, 0, 'i')) {
            return Inbox;
        }
        if (p.d(str, length, 0, 'p')) {
            return ProgressBar;
        }
        return null;
    }

    @Override // zd.p
    public String h() {
        return this.f20616a;
    }
}
