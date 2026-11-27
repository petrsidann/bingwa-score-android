package je;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f11411a;

    public String a(String str) {
        if (str == null) {
            return null;
        }
        Pattern patternCompile = Pattern.compile("^https?:\\/\\/", 2);
        Pattern patternCompile2 = Pattern.compile("^(asset:\\/\\/)(.*)", 2);
        Pattern patternCompile3 = Pattern.compile("^(file:\\/\\/)(.*)", 2);
        Pattern patternCompile4 = Pattern.compile("^(resource:\\/\\/)(.*)", 2);
        if (patternCompile.matcher(str).find()) {
            return str;
        }
        if (patternCompile2.matcher(str).find()) {
            return patternCompile2.matcher(str).replaceAll("$2");
        }
        if (patternCompile3.matcher(str).find()) {
            return patternCompile3.matcher(str).replaceAll("/$2");
        }
        if (patternCompile4.matcher(str).find()) {
            return patternCompile4.matcher(str).replaceAll("$2");
        }
        return null;
    }

    public zd.g b(String str) {
        if (str != null) {
            if (d("^((http|https):\\/\\/)(www\\.)?[a-zA-Z0-9@:%.\\-_\\\\+~#?&\\/\\/=]{2,2048}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%.\\-_\\\\+~#?&\\/=]*)$", str, Boolean.FALSE).booleanValue()) {
                return zd.g.Network;
            }
            if (c("^file?:\\/\\/", str).booleanValue()) {
                return zd.g.File;
            }
            if (c("^resource?:\\/\\/", str).booleanValue()) {
                return zd.g.Resource;
            }
            if (c("^asset?:\\/\\/", str).booleanValue()) {
                return zd.g.Asset;
            }
        }
        return zd.g.Unknown;
    }

    public Boolean c(String str, String str2) {
        return d(str, str2, Boolean.TRUE);
    }

    public Boolean d(String str, String str2, Boolean bool) {
        return Boolean.valueOf(Pattern.compile(str, 2).matcher(str2).find() && !(bool.booleanValue() && str2.replaceFirst(str, "").isEmpty()));
    }
}
