package u2;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import d9.a0;
import d9.d0;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static String a(String str) {
        return "content://com.android.externalstorage.documents/tree/primary%3AAndroid%2Fdata/document/primary%3AAndroid%2Fdata%2F" + b(str, false, true);
    }

    public static String b(String str, boolean z10, boolean z11) {
        File parentFile;
        if (z10 && (parentFile = new File(str).getParentFile()) != null) {
            str = parentFile.getAbsolutePath();
        }
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        String strReplace = str.replace("/storage/emulated/0/", "").replace("Android/data/", "");
        return z11 ? strReplace.replace("/", "%2F") : strReplace;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        try {
            return file.getCanonicalPath();
        } catch (IOException unused) {
            return file.getPath();
        }
    }

    public static String d(String str) {
        String[] strArrSplit = str.split("\\.");
        byte b10 = 1;
        String lowerCase = strArrSplit[strArrSplit.length - 1].toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase.hashCode()) {
            case -1137141488:
                b10 = !lowerCase.equals("torrent") ? (byte) -1 : (byte) 0;
                break;
            case 99:
                if (!lowerCase.equals("c")) {
                    b10 = -1;
                }
                break;
            case 104:
                b10 = !lowerCase.equals("h") ? (byte) -1 : (byte) 2;
                break;
            case 122:
                b10 = !lowerCase.equals("z") ? (byte) -1 : (byte) 3;
                break;
            case 3315:
                b10 = !lowerCase.equals("gz") ? (byte) -1 : (byte) 4;
                break;
            case 3401:
                b10 = !lowerCase.equals("js") ? (byte) -1 : (byte) 5;
                break;
            case 3633:
                b10 = !lowerCase.equals("rc") ? (byte) -1 : (byte) 6;
                break;
            case 3669:
                b10 = !lowerCase.equals("sh") ? (byte) -1 : (byte) 7;
                break;
            case 52316:
                b10 = !lowerCase.equals("3gp") ? (byte) -1 : (byte) 8;
                break;
            case 96796:
                b10 = !lowerCase.equals("apk") ? (byte) -1 : (byte) 9;
                break;
            case 96884:
                b10 = !lowerCase.equals("asf") ? (byte) -1 : (byte) 10;
                break;
            case 96980:
                b10 = !lowerCase.equals("avi") ? (byte) -1 : (byte) 11;
                break;
            case 97543:
                b10 = !lowerCase.equals("bin") ? (byte) -1 : (byte) 12;
                break;
            case 97669:
                b10 = !lowerCase.equals("bmp") ? (byte) -1 : (byte) 13;
                break;
            case 98723:
                b10 = !lowerCase.equals("cpp") ? (byte) -1 : (byte) 14;
                break;
            case 98822:
                b10 = !lowerCase.equals("csv") ? (byte) -1 : (byte) 15;
                break;
            case 99640:
                b10 = !lowerCase.equals("doc") ? (byte) -1 : (byte) 16;
                break;
            case 100882:
                b10 = !lowerCase.equals("exe") ? (byte) -1 : (byte) 17;
                break;
            case 102340:
                b10 = !lowerCase.equals("gif") ? (byte) -1 : (byte) 18;
                break;
            case 102575:
                b10 = !lowerCase.equals("gpx") ? (byte) -1 : (byte) 19;
                break;
            case 103649:
                b10 = !lowerCase.equals("htm") ? (byte) -1 : (byte) 20;
                break;
            case 104987:
                b10 = !lowerCase.equals("jar") ? (byte) -1 : (byte) 21;
                break;
            case 105441:
                b10 = !lowerCase.equals("jpg") ? (byte) -1 : (byte) 22;
                break;
            case 106314:
                b10 = !lowerCase.equals("kml") ? (byte) -1 : (byte) 23;
                break;
            case 106447:
                b10 = !lowerCase.equals("m3u") ? (byte) -1 : (byte) 24;
                break;
            case 106458:
                b10 = !lowerCase.equals("m4a") ? (byte) -1 : (byte) 25;
                break;
            case 106459:
                b10 = !lowerCase.equals("m4b") ? (byte) -1 : (byte) 26;
                break;
            case 106473:
                b10 = !lowerCase.equals("m4p") ? (byte) -1 : (byte) 27;
                break;
            case 106478:
                b10 = !lowerCase.equals("m4u") ? (byte) -1 : (byte) 28;
                break;
            case 106479:
                b10 = !lowerCase.equals("m4v") ? (byte) -1 : (byte) 29;
                break;
            case 107332:
                b10 = !lowerCase.equals("log") ? (byte) -1 : (byte) 30;
                break;
            case 108271:
                b10 = !lowerCase.equals("mp2") ? (byte) -1 : (byte) 31;
                break;
            case 108272:
                b10 = !lowerCase.equals("mp3") ? (byte) -1 : (byte) 32;
                break;
            case 108273:
                b10 = !lowerCase.equals("mp4") ? (byte) -1 : (byte) 33;
                break;
            case 108308:
                b10 = !lowerCase.equals("mov") ? (byte) -1 : (byte) 34;
                break;
            case 108320:
                b10 = !lowerCase.equals("mpc") ? (byte) -1 : (byte) 35;
                break;
            case 108322:
                b10 = !lowerCase.equals("mpe") ? (byte) -1 : (byte) 36;
                break;
            case 108324:
                b10 = !lowerCase.equals("mpg") ? (byte) -1 : (byte) 37;
                break;
            case 108417:
                b10 = !lowerCase.equals("msg") ? (byte) -1 : (byte) 38;
                break;
            case 109967:
                b10 = !lowerCase.equals("ogg") ? (byte) -1 : (byte) 39;
                break;
            case 110834:
                b10 = !lowerCase.equals("pdf") ? (byte) -1 : (byte) 40;
                break;
            case 111145:
                b10 = !lowerCase.equals("png") ? (byte) -1 : (byte) 41;
                break;
            case 111219:
                b10 = !lowerCase.equals("pps") ? (byte) -1 : (byte) 42;
                break;
            case 111220:
                b10 = !lowerCase.equals("ppt") ? (byte) -1 : (byte) 43;
                break;
            case 113252:
                b10 = !lowerCase.equals("rtf") ? (byte) -1 : (byte) 44;
                break;
            case 114597:
                b10 = !lowerCase.equals("tar") ? (byte) -1 : (byte) 45;
                break;
            case 114791:
                b10 = !lowerCase.equals("tgz") ? (byte) -1 : (byte) 46;
                break;
            case 115312:
                b10 = !lowerCase.equals("txt") ? (byte) -1 : (byte) 47;
                break;
            case 117484:
                b10 = !lowerCase.equals("wav") ? (byte) -1 : (byte) 48;
                break;
            case 117835:
                b10 = !lowerCase.equals("wma") ? (byte) -1 : (byte) 49;
                break;
            case 117856:
                b10 = !lowerCase.equals("wmv") ? (byte) -1 : (byte) 50;
                break;
            case 117946:
                b10 = !lowerCase.equals("wps") ? (byte) -1 : (byte) 51;
                break;
            case 118783:
                b10 = !lowerCase.equals("xls") ? (byte) -1 : (byte) 52;
                break;
            case 118807:
                b10 = !lowerCase.equals("xml") ? (byte) -1 : (byte) 53;
                break;
            case 120609:
                b10 = !lowerCase.equals("zip") ? (byte) -1 : (byte) 54;
                break;
            case 3059492:
                b10 = !lowerCase.equals("conf") ? (byte) -1 : (byte) 55;
                break;
            case 3088960:
                b10 = !lowerCase.equals("docx") ? (byte) -1 : (byte) 56;
                break;
            case 3183070:
                b10 = !lowerCase.equals("gtar") ? (byte) -1 : (byte) 57;
                break;
            case 3213227:
                b10 = !lowerCase.equals("html") ? (byte) -1 : (byte) 58;
                break;
            case 3254818:
                b10 = !lowerCase.equals("java") ? (byte) -1 : (byte) 59;
                break;
            case 3268712:
                b10 = !lowerCase.equals("jpeg") ? (byte) -1 : (byte) 60;
                break;
            case 3358085:
                b10 = !lowerCase.equals("mpeg") ? (byte) -1 : (byte) 61;
                break;
            case 3358096:
                b10 = !lowerCase.equals("mpg4") ? (byte) -1 : (byte) 62;
                break;
            case 3358141:
                b10 = !lowerCase.equals("mpga") ? (byte) -1 : (byte) 63;
                break;
            case 3447940:
                b10 = !lowerCase.equals("pptx") ? (byte) -1 : (byte) 64;
                break;
            case 3449699:
                b10 = !lowerCase.equals("prop") ? (byte) -1 : (byte) 65;
                break;
            case 3504679:
                b10 = !lowerCase.equals("rmvb") ? (byte) -1 : (byte) 66;
                break;
            case 3682393:
                b10 = !lowerCase.equals("xlsx") ? (byte) -1 : (byte) 67;
                break;
            case 94742904:
                b10 = !lowerCase.equals("class") ? (byte) -1 : (byte) 68;
                break;
            default:
                b10 = -1;
                break;
        }
        switch (b10) {
            case 0:
                return "application/x-bittorrent";
            case 1:
            case 2:
                return "text/plain";
            case 3:
                return "application/x-compress";
            case 4:
                return "application/x-gzip";
            case 5:
                return "application/x-javascript";
            case 6:
            case 7:
                return "text/plain";
            case 8:
                return "video/3gpp";
            case 9:
                return "application/vnd.android.package-archive";
            case 10:
                return "video/x-ms-asf";
            case 11:
                return "video/x-msvideo";
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case 68:
                return "application/octet-stream";
            case 13:
                return "image/bmp";
            case 14:
                return "text/plain";
            case 15:
            case 52:
                return "application/vnd.ms-excel";
            case 16:
                return "application/msword";
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return "image/gif";
            case 19:
                return "application/gpx+xml";
            case 20:
                return "text/html";
            case 21:
                return "application/java-archive";
            case 22:
                return "image/jpeg";
            case 23:
                return "application/vnd.google-earth.kml+xml";
            case 24:
                return "audio/x-mpegurl";
            case 25:
            case 26:
            case 27:
                return "audio/mp4a-latm";
            case 28:
                return "video/vnd.mpegurl";
            case 29:
                return "video/x-m4v";
            case 30:
                return "text/plain";
            case 31:
            case 32:
                return "audio/x-mpeg";
            case 33:
                return "video/mp4";
            case 34:
                return "video/quicktime";
            case 35:
                return "application/vnd.mpohun.certificate";
            case 36:
            case 37:
                return "video/mpeg";
            case 38:
                return "application/vnd.ms-outlook";
            case 39:
                return "audio/ogg";
            case 40:
                return "application/pdf";
            case 41:
                return "image/png";
            case 42:
            case 43:
                return "application/vnd.ms-powerpoint";
            case 44:
                return "application/rtf";
            case 45:
                return "application/x-tar";
            case 46:
                return "application/x-compressed";
            case 47:
                return "text/plain";
            case 48:
                return "audio/x-wav";
            case 49:
                return "audio/x-ms-wma";
            case 50:
                return "audio/x-ms-wmv";
            case 51:
                return "application/vnd.ms-works";
            case 53:
                return "text/plain";
            case 54:
                return "application/x-zip-compressed";
            case 55:
                return "text/plain";
            case 56:
                return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            case 57:
                return "application/x-gtar";
            case 58:
                return "text/html";
            case 59:
                return "text/plain";
            case 60:
                return "image/jpeg";
            case 61:
                return "video/mpeg";
            case 62:
                return "video/mp4";
            case 63:
                return "audio/mpeg";
            case 64:
                return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
            case 65:
                return "text/plain";
            case 66:
                return "audio/x-pn-realaudio";
            case 67:
                return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            default:
                return "*/*";
        }
    }

    public static Uri e(Context context, String str) {
        if (k(context, str)) {
            return Uri.parse(a(str));
        }
        return f0.e.g(context, context.getPackageName() + ".fileProvider.com.crazecoder.openfile", new File(str));
    }

    public static boolean f(String str) {
        return str.contains("audio/");
    }

    public static boolean g(String str, String str2) {
        return h(str) && (i(str2) || l(str2) || f(str2));
    }

    public static boolean h(String str) {
        String[] strArr = {Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getPath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getPath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS).getPath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_AUDIOBOOKS).getPath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getPath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS).getPath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS).getPath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RECORDINGS).getPath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getPath(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_SCREENSHOTS).getPath()};
        for (int i10 = 0; i10 < 13; i10++) {
            if (str.contains(strArr[i10])) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(String str) {
        return str.contains("image/");
    }

    public static boolean j(String str) {
        return !new File(str).canRead();
    }

    public static boolean k(Context context, String str) {
        return str.contains("/Android/data/") && !str.contains(context.getPackageName());
    }

    public static boolean l(String str) {
        return str.contains("video/");
    }
}
