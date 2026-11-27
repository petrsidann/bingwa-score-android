package u9;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static boolean a(Context context) {
        try {
            n(new File(context.getCacheDir() + "/file_picker/"));
            return true;
        } catch (Exception e10) {
            Log.e("FilePickerUtils", "There was an error while clearing cached files: " + e10.toString());
            return false;
        }
    }

    public static Uri b(Uri uri, int i10, Context context) {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                File fileC = c();
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                FileOutputStream fileOutputStream = new FileOutputStream(fileC);
                bitmapDecodeStream.compress(Bitmap.CompressFormat.JPEG, i10, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                Uri uriFromFile = Uri.fromFile(fileC);
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                return uriFromFile;
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e10) {
            throw new RuntimeException(e10);
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static File c() {
        return File.createTempFile("JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_", ".jpg", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    public static String d(Class<?> cls, Object obj) {
        try {
            if (Build.VERSION.SDK_INT < 30) {
                return (String) cls.getMethod("getPath", new Class[0]).invoke(obj, new Object[0]);
            }
            File file = (File) cls.getMethod("getDirectory", new Class[0]).invoke(obj, new Object[0]);
            if (file != null) {
                return file.getPath();
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static String e(Uri uri) {
        String str;
        String[] strArrSplit = DocumentsContract.getTreeDocumentId(uri).split(":");
        return (strArrSplit.length < 2 || (str = strArrSplit[1]) == null) ? File.separator : str;
    }

    public static String f(Uri uri, Context context) {
        String string = null;
        try {
            if (uri.getScheme().equals("content")) {
                Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_display_name"));
                        }
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                }
                cursorQuery.close();
            }
            if (string != null) {
                return string;
            }
            String path = uri.getPath();
            int iLastIndexOf = path.lastIndexOf(47);
            return iLastIndexOf != -1 ? path.substring(iLastIndexOf + 1) : path;
        } catch (Exception e10) {
            Log.e("FilePickerUtils", "Failed to handle file name: " + e10.toString());
            return null;
        }
    }

    public static String g(Uri uri, Context context) {
        if (uri == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 30 && k(uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            if (documentId.equals("downloads")) {
                return path;
            }
            if (!documentId.matches("^ms[df]\\:.*")) {
                if (documentId.startsWith("raw:")) {
                    return documentId.split(":")[1];
                }
                return null;
            }
            return path + "/" + f(uri, context);
        }
        String strJ = j(i(uri), context);
        new a.C0295a();
        if (strJ == null) {
            return File.separator;
        }
        String str = File.separator;
        if (strJ.endsWith(str)) {
            strJ = strJ.substring(0, strJ.length() - 1);
        }
        String strE = e(uri);
        if (strE.endsWith(str)) {
            strE = strE.substring(0, strE.length() - 1);
        }
        if (strE.length() <= 0) {
            return strJ;
        }
        if (strE.startsWith(str)) {
            return strJ + strE;
        }
        return strJ + str + strE;
    }

    public static String[] h(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(arrayList.get(i10));
            if (mimeTypeFromExtension == null) {
                Log.w("FilePickerUtils", "Custom file type " + arrayList.get(i10) + " is unsupported and will be ignored.");
            } else {
                arrayList2.add(mimeTypeFromExtension);
            }
        }
        Log.d("FilePickerUtils", "Allowed file extensions mimes: " + arrayList2);
        return (String[]) arrayList2.toArray(new String[0]);
    }

    public static String i(Uri uri) {
        String[] strArrSplit = DocumentsContract.getTreeDocumentId(uri).split(":");
        if (strArrSplit.length > 0) {
            return strArrSplit[0];
        }
        return null;
    }

    public static String j(String str, Context context) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getUuid", new Class[0]);
            Method method3 = cls.getMethod("isPrimary", new Class[0]);
            Object objInvoke = method.invoke(storageManager, new Object[0]);
            if (objInvoke == null) {
                return null;
            }
            int length = Array.getLength(objInvoke);
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = Array.get(objInvoke, i10);
                String str2 = (String) method2.invoke(obj, new Object[0]);
                if (((Boolean) method3.invoke(obj, new Object[0])) != null && "primary".equals(str)) {
                    return d(cls, obj);
                }
                if (str2 != null && str2.equals(str)) {
                    return d(cls, obj);
                }
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static boolean k(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static void l(File file, a.C0295a c0295a) {
        String str;
        try {
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                bufferedInputStream.read(bArr, 0, length);
                bufferedInputStream.close();
            } catch (FileNotFoundException e10) {
                str = "File not found: " + e10.getMessage();
                Log.e("FilePickerUtils", str, null);
            } catch (IOException e11) {
                str = "Failed to close file streams: " + e11.getMessage();
                Log.e("FilePickerUtils", str, null);
            }
            c0295a.b(bArr);
        } catch (Exception e12) {
            Log.e("FilePickerUtils", "Failed to load bytes into memory with error " + e12.toString() + ". Probably the file is too big to fit device memory. Bytes won't be added to the file this time.");
        }
    }

    public static a m(Context context, Uri uri, boolean z10) {
        FileOutputStream fileOutputStream;
        StringBuilder sb2;
        String str;
        Log.i("FilePickerUtils", "Caching from URI: " + uri.toString());
        a.C0295a c0295a = new a.C0295a();
        String strF = f(uri, context);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(context.getCacheDir().getAbsolutePath());
        sb3.append("/file_picker/");
        sb3.append(System.currentTimeMillis());
        sb3.append("/");
        sb3.append(strF != null ? strF : "unamed");
        String string = sb3.toString();
        File file = new File(string);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(string);
                try {
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i10 = inputStreamOpenInputStream.read(bArr);
                            if (i10 < 0) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, i10);
                        }
                        bufferedOutputStream.flush();
                        fileOutputStream.getFD().sync();
                    } catch (Throwable th) {
                        fileOutputStream.getFD().sync();
                        throw th;
                    }
                } catch (Exception e10) {
                    e = e10;
                    try {
                        fileOutputStream.close();
                        sb2 = new StringBuilder();
                        str = "Failed to retrieve path: ";
                    } catch (IOException | NullPointerException unused) {
                        sb2 = new StringBuilder();
                        str = "Failed to close file streams: ";
                    }
                    sb2.append(str);
                    sb2.append(e.getMessage());
                    Log.e("FilePickerUtils", sb2.toString(), null);
                    return null;
                }
            } catch (Exception e11) {
                e = e11;
                fileOutputStream = null;
            }
        }
        Log.d("FilePickerUtils", "File loaded and cached at:" + string);
        if (z10) {
            l(file, c0295a);
        }
        c0295a.d(string).c(strF).f(uri).e(Long.parseLong(String.valueOf(file.length())));
        return c0295a.a();
    }

    public static void n(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                n(file2);
            }
        }
        file.delete();
    }
}
