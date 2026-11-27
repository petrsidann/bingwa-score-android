package s9;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public enum d {
    Inbox,
    Sent,
    Draft;

    public Uri h() {
        String str;
        if (this == Inbox) {
            str = "content://sms/inbox";
        } else {
            str = this == Sent ? "content://sms/sent" : "content://sms/draft";
        }
        return Uri.parse(str);
    }
}
