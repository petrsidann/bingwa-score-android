package fe;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8358f;

    @Override // fe.a
    public String N() {
        return M();
    }

    @Override // fe.a
    public Map<String, Object> O() {
        HashMap map = new HashMap();
        D("channelGroupName", map, this.f8357e);
        D("channelGroupKey", map, this.f8358f);
        return map;
    }

    @Override // fe.a
    public void P(Context context) throws ae.a {
        if (this.f8328b.e(this.f8357e).booleanValue()) {
            throw ae.b.e().c("NotificationChannelGroupModel", "INVALID_ARGUMENTS", "Channel group name cannot be null or empty", "arguments.invalid.channelGroup.name");
        }
        if (this.f8328b.e(this.f8358f).booleanValue()) {
            throw ae.b.e().c("NotificationChannelGroupModel", "INVALID_ARGUMENTS", "Channel group key cannot be null or empty", "arguments.invalid.channelGroup.key");
        }
    }

    @Override // fe.a
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public e a(String str) {
        return (e) super.L(str);
    }

    @Override // fe.a
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public e b(Map<String, Object> map) {
        this.f8357e = h(map, "channelGroupName", String.class, null);
        this.f8358f = h(map, "channelGroupKey", String.class, null);
        return this;
    }
}
