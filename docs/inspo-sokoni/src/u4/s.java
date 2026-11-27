package u4;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.internal.measurement.zzog;
import com.google.android.gms.internal.measurement.zzoy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class s extends fe {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f16771f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f16772g = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f16773h = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f16774i = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f16775j = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f16776k = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f16777l = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f16778m = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f16779n = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f16780o = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f16781p = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a0 f16782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final td f16783e;

    public s(ge geVar) {
        super(geVar);
        this.f16783e = new td(zzb());
        this.f16782d = new a0(this, zza(), "google_app_measurement.db");
    }

    public static String H0(List<Integer> list) {
        return list.isEmpty() ? "" : String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    public static void T(ContentValues contentValues, String str, Object obj) {
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.l(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(str, (Double) obj);
        }
    }

    public final long A(zzgf.zzk zzkVar) {
        j();
        q();
        com.google.android.gms.common.internal.r.l(zzkVar);
        com.google.android.gms.common.internal.r.f(zzkVar.zzab());
        byte[] bArrZzce = zzkVar.zzce();
        long jW = k().w(bArrZzce);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkVar.zzab());
        contentValues.put("metadata_fingerprint", Long.valueOf(jW));
        contentValues.put("metadata", bArrZzce);
        try {
            x().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jW;
        } catch (SQLiteException e10) {
            zzj().C().c("Error storing raw event metadata. appId", v5.r(zzkVar.zzab()), e10);
            throw e10;
        }
    }

    public final long B(String str) {
        com.google.android.gms.common.internal.r.f(str);
        j();
        q();
        try {
            return x().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, a().u(str, p0.f16673q))))});
        } catch (SQLiteException e10) {
            zzj().C().c("Error deleting over the limit events. appId", v5.r(str), e10);
            return 0L;
        }
    }

    public final String B0() {
        long jA = zzb().a();
        Locale locale = Locale.US;
        fb fbVar = fb.GOOGLE_SIGNAL;
        return "(" + String.format(locale, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", Integer.valueOf(fbVar.zza()), Long.valueOf(jA), Long.valueOf(p0.O.a(null).longValue())) + " OR " + String.format(locale, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", Integer.valueOf(fbVar.zza()), Long.valueOf(jA), Long.valueOf(j.N())) + ")";
    }

    public final long C(String str, zzgf.zzj zzjVar, String str2, Map<String, String> map, fb fbVar, Long l10) {
        int iDelete;
        j();
        q();
        com.google.android.gms.common.internal.r.l(zzjVar);
        com.google.android.gms.common.internal.r.f(str);
        if (!a().p(p0.I0)) {
            return -1L;
        }
        j();
        q();
        if (q0()) {
            long jA = o().f15994f.a();
            long jB = zzb().b();
            if (Math.abs(jB - jA) > j.O()) {
                o().f15994f.b(jB);
                j();
                q();
                if (q0() && (iDelete = x().delete("upload_queue", B0(), new String[0])) > 0) {
                    zzj().G().b("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(iDelete));
                }
                if (a().p(p0.K0)) {
                    l1(str);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        byte[] bArrZzce = zzjVar.zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", bArrZzce);
        contentValues.put("upload_uri", str2);
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        if (size > 0) {
            sb2.append((CharSequence) arrayList.get(0));
            int i10 = 1;
            while (i10 < size) {
                sb2.append((CharSequence) "\r\n");
                Object obj = arrayList.get(i10);
                i10++;
                sb2.append((CharSequence) obj);
            }
        }
        contentValues.put("upload_headers", sb2.toString());
        contentValues.put("upload_type", Integer.valueOf(fbVar.zza()));
        contentValues.put("creation_timestamp", Long.valueOf(zzb().a()));
        contentValues.put("retry_count", (Integer) 0);
        if (l10 != null) {
            contentValues.put("associated_row_id", l10);
        }
        try {
            long jInsert = x().insert("upload_queue", null, contentValues);
            if (jInsert == -1) {
                zzj().C().b("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            }
            return jInsert;
        } catch (SQLiteException e10) {
            zzj().C().c("Error storing MeasurementBatch to upload_queue. appId", str, e10);
            return -1L;
        }
    }

    public final long C0(String str) {
        com.google.android.gms.common.internal.r.f(str);
        return D("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final long D(String str, String[] strArr, long j10) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = x().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return j10;
                }
                long j11 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j11;
            } catch (SQLiteException e10) {
                zzj().C().c("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final long D0(String str, String str2) {
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.f(str2);
        j();
        q();
        SQLiteDatabase sQLiteDatabaseX = x();
        sQLiteDatabaseX.beginTransaction();
        long j10 = 0;
        try {
            try {
                long jD = D("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
                if (jD == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseX.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzj().C().c("Failed to insert column (got -1). appId", v5.r(str), str2);
                        return -1L;
                    }
                    jD = 0;
                    zzj().C().d("Error inserting column. appId", v5.r(str), str2, e);
                    return j10;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put(str2, Long.valueOf(1 + jD));
                    if (sQLiteDatabaseX.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        zzj().C().c("Failed to update column (got 0). appId", v5.r(str), str2);
                        return -1L;
                    }
                    sQLiteDatabaseX.setTransactionSuccessful();
                    return jD;
                } catch (SQLiteException e10) {
                    e = e10;
                    j10 = jD;
                }
            } catch (SQLiteException e11) {
                e = e11;
            }
        } finally {
            sQLiteDatabaseX.endTransaction();
        }
    }

    public final long E0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = x().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j10 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j10;
            } catch (SQLiteException e10) {
                zzj().C().c("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x008e  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x008b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x008b */
    public final Pair<zzgf.zzf, Long> F(String str, Long l10) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        j();
        q();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = x().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l10)});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        zzj().G().a("Main event not found");
                        cursorRawQuery.close();
                        return null;
                    }
                    try {
                        Pair<zzgf.zzf, Long> pairCreate = Pair.create((zzgf.zzf) ((zzkg) ((zzgf.zzf.zza) we.C(zzgf.zzf.zze(), cursorRawQuery.getBlob(0))).zzaj()), Long.valueOf(cursorRawQuery.getLong(1)));
                        cursorRawQuery.close();
                        return pairCreate;
                    } catch (IOException e10) {
                        zzj().C().d("Failed to merge main event. appId, eventId", v5.r(str), l10, e10);
                        cursorRawQuery.close();
                        return null;
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    zzj().C().b("Error selecting main event", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e = e12;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final zzgf.zzk F0(String str, long j10) {
        zzgf.zzk zzkVar;
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = x().query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str, Long.toString(j10)}, null, null, "rowid", "2");
                try {
                    try {
                        if (!cursorQuery.moveToFirst()) {
                            zzj().C().b("Raw event metadata record is missing. appId", v5.r(str));
                            cursorQuery.close();
                            return null;
                        }
                        try {
                            zzgf.zzk zzkVar2 = (zzgf.zzk) ((zzkg) ((zzgf.zzk.zza) we.C(zzgf.zzk.zzx(), cursorQuery.getBlob(0))).zzaj());
                            try {
                                if (cursorQuery.moveToNext()) {
                                    zzj().H().b("Get multiple raw event metadata records, expected one. appId", v5.r(str));
                                }
                                cursorQuery.close();
                                cursorQuery.close();
                                return zzkVar2;
                            } catch (SQLiteException e10) {
                                cursor = cursorQuery;
                                zzkVar = zzkVar2;
                                e = e10;
                                zzj().C().c("Data loss. Error selecting raw event. appId", v5.r(str), e);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return zzkVar;
                            }
                        } catch (IOException e11) {
                            zzj().C().c("Data loss. Failed to merge raw event metadata. appId", v5.r(str), e11);
                            cursorQuery.close();
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e12) {
                    e = e12;
                    cursor = cursorQuery;
                    zzkVar = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e13) {
            e = e13;
            zzkVar = null;
        }
    }

    public final Object G(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        if (type == 0) {
            zzj().C().a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i10));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i10));
        }
        if (type == 3) {
            return cursor.getString(i10);
        }
        if (type != 4) {
            zzj().C().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        zzj().C().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0057  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    public final String G0(long j10) throws Throwable {
        Cursor cursorRawQuery;
        j();
        q();
        ?? r10 = 0;
        try {
            try {
                cursorRawQuery = x().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf((long) j10)});
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string = cursorRawQuery.getString(0);
                        cursorRawQuery.close();
                        return string;
                    }
                    zzj().G().a("No expired configs for apps with pending events");
                    cursorRawQuery.close();
                    return null;
                } catch (SQLiteException e10) {
                    e = e10;
                    zzj().C().b("Error selecting expired configs", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r10 = j10;
                if (r10 != 0) {
                    r10.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r10 != 0) {
                r10.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0045  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public final <T> T H(String str, String[] strArr, x<T> xVar) throws Throwable {
        Cursor cursorRawQuery;
        ?? r10 = 0;
        try {
            try {
                cursorRawQuery = x().rawQuery(str, strArr);
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        T tA = xVar.a(cursorRawQuery);
                        cursorRawQuery.close();
                        return tA;
                    }
                    zzj().G().a("No data found");
                    cursorRawQuery.close();
                    return null;
                } catch (SQLiteException e10) {
                    e = e10;
                    zzj().C().b("Error querying database.", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r10 = str;
                if (r10 != 0) {
                    r10.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r10 != 0) {
                r10.close();
            }
            throw th;
        }
    }

    public final String I(String str, String[] strArr, String str2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = x().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return str2;
                }
                String string = cursorRawQuery.getString(0);
                cursorRawQuery.close();
                return string;
            } catch (SQLiteException e10) {
                zzj().C().c("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x011b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0122  */
    public final List<bf> I0(String str, String str2, String str3) throws Throwable {
        String str4;
        com.google.android.gms.common.internal.r.f(str);
        j();
        q();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                try {
                    arrayList2.add(str);
                    StringBuilder sb2 = new StringBuilder("app_id=?");
                    if (TextUtils.isEmpty(str2)) {
                        str4 = str2;
                    } else {
                        str4 = str2;
                        try {
                            arrayList2.add(str4);
                            sb2.append(" and origin=?");
                        } catch (SQLiteException e10) {
                            e = e10;
                            zzj().C().d("(2)Error querying user properties", v5.r(str), str4, e);
                            List<bf> listEmptyList = Collections.emptyList();
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return listEmptyList;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        arrayList2.add(str3 + "*");
                        sb2.append(" and name glob ?");
                    }
                    cursorQuery = x().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, sb2.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", "1001");
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return arrayList;
                    }
                    while (arrayList.size() < 1000) {
                        String string = cursorQuery.getString(0);
                        long j10 = cursorQuery.getLong(1);
                        try {
                            try {
                                Object objG = G(cursorQuery, 2);
                                String string2 = cursorQuery.getString(3);
                                if (objG == null) {
                                    try {
                                        zzj().C().d("(2)Read invalid user property value, ignoring it", v5.r(str), string2, str3);
                                    } catch (SQLiteException e11) {
                                        e = e11;
                                        str4 = string2;
                                        zzj().C().d("(2)Error querying user properties", v5.r(str), str4, e);
                                        List<bf> listEmptyList2 = Collections.emptyList();
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        return listEmptyList2;
                                    }
                                } else {
                                    arrayList.add(new bf(str, string2, string, j10, objG));
                                }
                                if (!cursorQuery.moveToNext()) {
                                    cursorQuery.close();
                                    return arrayList;
                                }
                                str4 = string2;
                            } catch (SQLiteException e12) {
                                e = e12;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    }
                    zzj().C().b("Read more than the max allowed user properties, ignoring excess", 1000);
                    cursorQuery.close();
                    return arrayList;
                } catch (SQLiteException e13) {
                    e = e13;
                    str4 = str2;
                    zzj().C().d("(2)Error querying user properties", v5.r(str), str4, e);
                    List<bf> listEmptyList3 = Collections.emptyList();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return listEmptyList3;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e14) {
            e = e14;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0117  */
    public final List<Pair<zzgf.zzk, Long>> J(String str, int i10, int i11) {
        x5 x5VarC;
        String str2;
        Object objR;
        boolean z10;
        long jZzc;
        long jZzc2;
        j();
        q();
        int i12 = 1;
        com.google.android.gms.common.internal.r.a(i10 > 0);
        com.google.android.gms.common.internal.r.a(i11 > 0);
        com.google.android.gms.common.internal.r.f(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = x().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i10));
                if (!cursorQuery.moveToFirst()) {
                    List<Pair<zzgf.zzk, Long>> listEmptyList = Collections.emptyList();
                    cursorQuery.close();
                    return listEmptyList;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                while (true) {
                    long j10 = cursorQuery.getLong(0);
                    try {
                        byte[] bArrF0 = k().f0(cursorQuery.getBlob(i12));
                        if (!arrayList.isEmpty() && bArrF0.length + length > i11) {
                            break;
                        }
                        try {
                            zzgf.zzk.zza zzaVar = (zzgf.zzk.zza) we.C(zzgf.zzk.zzx(), bArrF0);
                            if (!arrayList.isEmpty()) {
                                zzgf.zzk zzkVar = (zzgf.zzk) ((Pair) arrayList.get(0)).first;
                                zzgf.zzk zzkVar2 = (zzgf.zzk) ((zzkg) zzaVar.zzaj());
                                if (zzkVar.zzag().equals(zzkVar2.zzag()) && zzkVar.zzaf().equals(zzkVar2.zzaf()) && zzkVar.zzaw() == zzkVar2.zzaw() && zzkVar.zzah().equals(zzkVar2.zzah())) {
                                    Iterator<zzgf.zzp> it = zzkVar.zzau().iterator();
                                    while (true) {
                                        jZzc = -1;
                                        if (!it.hasNext()) {
                                            jZzc2 = -1;
                                            break;
                                        }
                                        zzgf.zzp next = it.next();
                                        if ("_npa".equals(next.zzg())) {
                                            jZzc2 = next.zzc();
                                            break;
                                        }
                                    }
                                    for (zzgf.zzp zzpVar : zzkVar2.zzau()) {
                                        if ("_npa".equals(zzpVar.zzg())) {
                                            jZzc = zzpVar.zzc();
                                            break;
                                        }
                                    }
                                    if (jZzc2 == jZzc) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                } else {
                                    z10 = false;
                                }
                                if (!z10) {
                                    break;
                                }
                            }
                            if (!cursorQuery.isNull(2)) {
                                zzaVar.zzi(cursorQuery.getInt(2));
                            }
                            length += bArrF0.length;
                            arrayList.add(Pair.create((zzgf.zzk) ((zzkg) zzaVar.zzaj()), Long.valueOf(j10)));
                        } catch (IOException e10) {
                            e = e10;
                            x5VarC = zzj().C();
                            str2 = "Failed to merge queued bundle. appId";
                            objR = v5.r(str);
                            x5VarC.c(str2, objR, e);
                        }
                        if (!cursorQuery.moveToNext() || length > i11) {
                            break;
                        }
                        i12 = 1;
                    } catch (IOException e11) {
                        e = e11;
                        x5VarC = zzj().C();
                        str2 = "Failed to unzip queued bundle. appId";
                        objR = v5.r(str);
                    }
                }
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e12) {
                zzj().C().c("Error querying bundles. appId", v5.r(str), e12);
                List<Pair<zzgf.zzk, Long>> listEmptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return listEmptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void J0(Long l10) {
        j();
        q();
        com.google.android.gms.common.internal.r.l(l10);
        if (a().p(p0.I0) && q0()) {
            if (E0("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l10 + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                zzj().H().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                x().execSQL("UPDATE upload_queue SET retry_count = retry_count + 1 WHERE rowid = " + l10 + " AND retry_count < 2147483647");
            } catch (SQLiteException e10) {
                zzj().C().b("Error incrementing retry count. error", e10);
            }
        }
    }

    public final List<h> K(String str, String str2, String str3) {
        com.google.android.gms.common.internal.r.f(str);
        j();
        q();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb2 = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb2.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb2.append(" and name glob ?");
        }
        return M(sb2.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final void K0(String str, s8 s8Var) {
        com.google.android.gms.common.internal.r.l(str);
        com.google.android.gms.common.internal.r.l(s8Var);
        j();
        q();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", s8Var.v());
        contentValues.put("consent_source", Integer.valueOf(s8Var.b()));
        W("consent_settings", "app_id", contentValues);
    }

    public final List<ve> L(String str, be beVar, int i10) {
        if (!a().p(p0.K0)) {
            return Collections.emptyList();
        }
        com.google.android.gms.common.internal.r.f(str);
        j();
        q();
        Cursor cursor = null;
        try {
            try {
                int i11 = 0;
                Cursor cursorQuery = x().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", "creation_timestamp", "associated_row_id"}, "app_id=?" + H0(beVar.f16053a) + " AND NOT " + B0(), new String[]{str}, null, null, "creation_timestamp ASC", i10 > 0 ? String.valueOf(i10) : null);
                try {
                    ArrayList arrayList = new ArrayList();
                    while (cursorQuery.moveToNext()) {
                        ArrayList arrayList2 = arrayList;
                        ve veVarS = S(str, cursorQuery.getLong(i11), cursorQuery.getBlob(2), cursorQuery.getString(3), cursorQuery.getString(4), cursorQuery.getInt(5), cursorQuery.getInt(6), cursorQuery.getLong(7), cursorQuery.getLong(8));
                        if (veVarS != null) {
                            arrayList2.add(veVarS);
                        }
                        arrayList = arrayList2;
                        i11 = 0;
                    }
                    ArrayList arrayList3 = arrayList;
                    cursorQuery.close();
                    return arrayList3;
                } catch (SQLiteException e10) {
                    e = e10;
                    cursor = cursorQuery;
                    zzj().C().c("Error to querying MeasurementBatch from upload_queue. appId", str, e);
                    List<ve> listEmptyList = Collections.emptyList();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return listEmptyList;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e11) {
            e = e11;
        }
    }

    public final boolean L0(String str, List<Integer> list) {
        com.google.android.gms.common.internal.r.f(str);
        q();
        j();
        SQLiteDatabase sQLiteDatabaseX = x();
        try {
            long jE0 = E0("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, a().u(str, p0.Q)));
            if (jE0 <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                Integer num = list.get(i10);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String str2 = "(" + TextUtils.join(",", arrayList) + ")";
            StringBuilder sb2 = new StringBuilder("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb2.append(str2);
            sb2.append(" order by rowid desc limit -1 offset ?)");
            return sQLiteDatabaseX.delete("audience_filter_values", sb2.toString(), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e10) {
            zzj().C().c("Database error querying filters. appId", v5.r(str), e10);
            return false;
        }
    }

    public final List<h> M(String str, String[] strArr) {
        j();
        q();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = x().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                while (arrayList.size() < 1000) {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    String string3 = cursorQuery.getString(2);
                    Object objG = G(cursorQuery, 3);
                    boolean z10 = cursorQuery.getInt(4) != 0;
                    String string4 = cursorQuery.getString(5);
                    long j10 = cursorQuery.getLong(6);
                    we weVarK = k();
                    byte[] blob = cursorQuery.getBlob(7);
                    Parcelable.Creator<n0> creator = n0.CREATOR;
                    n0 n0Var = (n0) weVarK.z(blob, creator);
                    arrayList.add(new h(string, string2, new ze(string3, cursorQuery.getLong(10), objG, string2), cursorQuery.getLong(8), z10, string4, n0Var, j10, (n0) k().z(cursorQuery.getBlob(9), creator), cursorQuery.getLong(11), (n0) k().z(cursorQuery.getBlob(12), creator)));
                    if (!cursorQuery.moveToNext()) {
                        cursorQuery.close();
                        return arrayList;
                    }
                }
                zzj().C().b("Read more than the max allowed conditional properties, ignoring extra", 1000);
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e10) {
                zzj().C().b("Error querying conditional user property value", e10);
                List<h> listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0086  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0083: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x0083 */
    public final Bundle M0(String str) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        j();
        q();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = x().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        zzj().G().a("Default event parameters not found");
                        cursorRawQuery.close();
                        return null;
                    }
                    try {
                        zzgf.zzf zzfVar = (zzgf.zzf) ((zzkg) ((zzgf.zzf.zza) we.C(zzgf.zzf.zze(), cursorRawQuery.getBlob(0))).zzaj());
                        k();
                        Bundle bundleX = we.x(zzfVar.zzh());
                        cursorRawQuery.close();
                        return bundleX;
                    } catch (IOException e10) {
                        zzj().C().c("Failed to retrieve default event parameters. appId", v5.r(str), e10);
                        cursorRawQuery.close();
                        return null;
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    zzj().C().b("Error selecting default event parameters", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e = e12;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final t N(long j10, String str, long j11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        com.google.android.gms.common.internal.r.f(str);
        j();
        q();
        String[] strArr = {str};
        t tVar = new t();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseX = x();
                Cursor cursorQuery = sQLiteDatabaseX.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    zzj().H().b("Not updating daily counts, app is not known. appId", v5.r(str));
                    cursorQuery.close();
                    return tVar;
                }
                if (cursorQuery.getLong(0) == j10) {
                    tVar.f16816b = cursorQuery.getLong(1);
                    tVar.f16815a = cursorQuery.getLong(2);
                    tVar.f16817c = cursorQuery.getLong(3);
                    tVar.f16818d = cursorQuery.getLong(4);
                    tVar.f16819e = cursorQuery.getLong(5);
                    tVar.f16820f = cursorQuery.getLong(6);
                    tVar.f16821g = cursorQuery.getLong(7);
                }
                if (z10) {
                    tVar.f16816b += j11;
                }
                if (z11) {
                    tVar.f16815a += j11;
                }
                if (z12) {
                    tVar.f16817c += j11;
                }
                if (z13) {
                    tVar.f16818d += j11;
                }
                if (z14) {
                    tVar.f16819e += j11;
                }
                if (z15) {
                    tVar.f16820f += j11;
                }
                if (z16) {
                    tVar.f16821g += j11;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j10));
                contentValues.put("daily_public_events_count", Long.valueOf(tVar.f16815a));
                contentValues.put("daily_events_count", Long.valueOf(tVar.f16816b));
                contentValues.put("daily_conversions_count", Long.valueOf(tVar.f16817c));
                contentValues.put("daily_error_events_count", Long.valueOf(tVar.f16818d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(tVar.f16819e));
                contentValues.put("daily_realtime_dcu_count", Long.valueOf(tVar.f16820f));
                contentValues.put("daily_registered_triggers_count", Long.valueOf(tVar.f16821g));
                sQLiteDatabaseX.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return tVar;
            } catch (SQLiteException e10) {
                zzj().C().c("Error updating daily counts. appId", v5.r(str), e10);
                if (0 != 0) {
                    cursor.close();
                }
                return tVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x011b  */
    /* JADX WARN: Code duplicated, block: B:38:0x0123  */
    public final h N0(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.f(str2);
        j();
        q();
        Cursor cursor = null;
        try {
            cursorQuery = x().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return null;
                }
                String string = cursorQuery.getString(0);
                if (string == null) {
                    string = "";
                }
                String str3 = string;
                try {
                    try {
                        Object objG = G(cursorQuery, 1);
                        boolean z10 = cursorQuery.getInt(2) != 0;
                        String string2 = cursorQuery.getString(3);
                        long j10 = cursorQuery.getLong(4);
                        we weVarK = k();
                        byte[] blob = cursorQuery.getBlob(5);
                        Parcelable.Creator<n0> creator = n0.CREATOR;
                        h hVar = new h(str, str3, new ze(str2, cursorQuery.getLong(8), objG, str3), cursorQuery.getLong(6), z10, string2, (n0) weVarK.z(blob, creator), j10, (n0) k().z(cursorQuery.getBlob(7), creator), cursorQuery.getLong(9), (n0) k().z(cursorQuery.getBlob(10), creator));
                        if (cursorQuery.moveToNext()) {
                            zzj().C().c("Got multiple records for conditional property, expected one", v5.r(str), d().g(str2));
                        }
                        cursorQuery.close();
                        return hVar;
                    } catch (SQLiteException e10) {
                        e = e10;
                        zzj().C().d("Error querying conditional property", v5.r(str), d().g(str2), e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e11) {
                e = e11;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e = e12;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        zzj().C().d("Error querying conditional property", v5.r(str), d().g(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final t O(long j10, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        return N(j10, str, 1L, false, false, z12, false, z14, z15, z16);
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0147: MOVE (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:64:0x0147 */
    public final j0 O0(String str, String str2, String str3) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        Cursor cursor2;
        Boolean boolValueOf;
        com.google.android.gms.common.internal.r.f(str2);
        com.google.android.gms.common.internal.r.f(str3);
        j();
        q();
        Cursor cursor3 = null;
        try {
            try {
                cursorQuery = x().query(str, (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str2, str3}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    long j10 = cursorQuery.getLong(0);
                    long j11 = cursorQuery.getLong(1);
                    long j12 = cursorQuery.getLong(2);
                    long j13 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                    Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                    Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                    Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                    if (cursorQuery.isNull(7)) {
                        boolValueOf = null;
                    } else {
                        try {
                            boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                        } catch (SQLiteException e10) {
                            e = e10;
                        }
                    }
                    cursor2 = cursorQuery;
                    try {
                        j0 j0Var = new j0(str2, str3, j10, j11, cursorQuery.isNull(8) ? 0L : cursorQuery.getLong(8), j12, j13, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                        if (cursor2.moveToNext()) {
                            zzj().C().b("Got multiple records for event aggregates, expected one. appId", v5.r(str2));
                        }
                        cursor2.close();
                        return j0Var;
                    } catch (SQLiteException e11) {
                        e = e11;
                        cursorQuery = cursor2;
                    } catch (Throwable th) {
                        th = th;
                        cursor3 = cursor2;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e12) {
                    e = e12;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursorQuery;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor3 = cursor;
            }
        } catch (SQLiteException e13) {
            e = e13;
            cursorQuery = null;
        } catch (Throwable th4) {
            th = th4;
        }
        zzj().C().d("Error querying events. appId", v5.r(str2), d().b(str3), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final j0 P0(String str, String str2) {
        return O0("events", str, str2);
    }

    public final h6 Q0(String str) {
        Cursor cursorQuery;
        Boolean boolValueOf;
        com.google.android.gms.common.internal.r.f(str);
        j();
        q();
        Cursor cursor = null;
        try {
            boolean z10 = true;
            cursorQuery = x().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id", "session_stitching_token", "sgtm_upload_enabled", "target_os_version", "session_stitching_token_hash", "ad_services_version", "unmatched_first_open_without_ad_id", "npa_metadata_value", "attribution_eligibility_status", "sgtm_preview_key", "dma_consent_state", "daily_realtime_dcu_count", "bundle_delivery_index", "serialized_npa_metadata", "unmatched_pfo", "unmatched_uwa", "ad_campaign_info", "client_upload_eligibility"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    h6 h6Var = new h6(this.f16938b.B0(), str);
                    s8 s8VarB0 = this.f16938b.b0(str);
                    s8.a aVar = s8.a.ANALYTICS_STORAGE;
                    if (s8VarB0.m(aVar)) {
                        h6Var.J(cursorQuery.getString(0));
                    }
                    h6Var.a0(cursorQuery.getString(1));
                    if (this.f16938b.b0(str).m(s8.a.AD_STORAGE)) {
                        h6Var.g0(cursorQuery.getString(2));
                    }
                    h6Var.B0(cursorQuery.getLong(3));
                    h6Var.D0(cursorQuery.getLong(4));
                    h6Var.z0(cursorQuery.getLong(5));
                    h6Var.T(cursorQuery.getString(6));
                    h6Var.O(cursorQuery.getString(7));
                    h6Var.v0(cursorQuery.getLong(8));
                    h6Var.o0(cursorQuery.getLong(9));
                    h6Var.K(cursorQuery.isNull(10) || cursorQuery.getInt(10) != 0);
                    h6Var.l0(cursorQuery.getLong(11));
                    h6Var.f0(cursorQuery.getLong(12));
                    h6Var.c0(cursorQuery.getLong(13));
                    h6Var.W(cursorQuery.getLong(14));
                    h6Var.S(cursorQuery.getLong(15));
                    h6Var.t0(cursorQuery.getLong(16));
                    h6Var.H(cursorQuery.isNull(17) ? -2147483648L : cursorQuery.getInt(17));
                    h6Var.X(cursorQuery.getString(18));
                    h6Var.Z(cursorQuery.getLong(19));
                    h6Var.i0(cursorQuery.getLong(20));
                    h6Var.d0(cursorQuery.getString(21));
                    h6Var.h(cursorQuery.isNull(23) || cursorQuery.getInt(23) != 0);
                    h6Var.f(cursorQuery.getString(24));
                    h6Var.r0(cursorQuery.isNull(25) ? 0L : cursorQuery.getLong(25));
                    if (!cursorQuery.isNull(26)) {
                        h6Var.g(Arrays.asList(cursorQuery.getString(26).split(",", -1)));
                    }
                    if (this.f16938b.b0(str).m(aVar)) {
                        h6Var.m0(cursorQuery.getString(28));
                    }
                    h6Var.P((cursorQuery.isNull(29) || cursorQuery.getInt(29) == 0) ? false : true);
                    h6Var.x0(cursorQuery.getLong(39));
                    h6Var.p0(cursorQuery.getString(36));
                    h6Var.H0(cursorQuery.getLong(30));
                    h6Var.F0(cursorQuery.getLong(31));
                    if (zzoy.zza() && a().D(str, p0.Q0)) {
                        h6Var.b(cursorQuery.getInt(32));
                        h6Var.N(cursorQuery.getLong(35));
                    }
                    h6Var.U((cursorQuery.isNull(33) || cursorQuery.getInt(33) == 0) ? false : true);
                    if (cursorQuery.isNull(34)) {
                        boolValueOf = null;
                    } else {
                        if (cursorQuery.getInt(34) == 0) {
                            z10 = false;
                        }
                        boolValueOf = Boolean.valueOf(z10);
                    }
                    h6Var.d(boolValueOf);
                    h6Var.R(cursorQuery.getInt(37));
                    h6Var.M(cursorQuery.getInt(38));
                    h6Var.j0(cursorQuery.isNull(40) ? "" : (String) com.google.android.gms.common.internal.r.l(cursorQuery.getString(40)));
                    if (!cursorQuery.isNull(41)) {
                        h6Var.e(Long.valueOf(cursorQuery.getLong(41)));
                    }
                    if (!cursorQuery.isNull(42)) {
                        h6Var.I(Long.valueOf(cursorQuery.getLong(42)));
                    }
                    h6Var.i(cursorQuery.getBlob(43));
                    if (a().D(str, p0.K0) && !cursorQuery.isNull(44)) {
                        h6Var.G(cursorQuery.getInt(44));
                    }
                    h6Var.x();
                    if (cursorQuery.moveToNext()) {
                        zzj().C().b("Got multiple records for app, expected one. appId", v5.r(str));
                    }
                    cursorQuery.close();
                    return h6Var;
                } catch (SQLiteException e10) {
                    e = e10;
                    zzj().C().c("Error querying app. appId", v5.r(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        th = th;
        cursor = cursorQuery;
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    public final ve R(long j10) {
        Cursor cursorQuery;
        Cursor cursor = null;
        if (!a().p(p0.K0)) {
            return null;
        }
        j();
        q();
        try {
            cursorQuery = x().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", "creation_timestamp", "associated_row_id"}, "rowId=?", new String[]{String.valueOf(j10)}, null, null, null, "1");
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    ve veVarS = S((String) com.google.android.gms.common.internal.r.l(cursorQuery.getString(1)), j10, cursorQuery.getBlob(2), cursorQuery.getString(3), cursorQuery.getString(4), cursorQuery.getInt(5), cursorQuery.getInt(6), cursorQuery.getLong(7), cursorQuery.getLong(8));
                    cursorQuery.close();
                    return veVarS;
                } catch (SQLiteException e10) {
                    e = e10;
                    zzj().C().c("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j10), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        th = th;
        cursor = cursorQuery;
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0087  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0084: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:28:0x0084 */
    public final u R0(String str) {
        Cursor cursorQuery;
        Cursor cursor;
        com.google.android.gms.common.internal.r.f(str);
        j();
        q();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = x().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    byte[] blob = cursorQuery.getBlob(0);
                    String string = cursorQuery.getString(1);
                    String string2 = cursorQuery.getString(2);
                    if (cursorQuery.moveToNext()) {
                        zzj().C().b("Got multiple records for app config, expected one. appId", v5.r(str));
                    }
                    if (blob == null) {
                        cursorQuery.close();
                        return null;
                    }
                    u uVar = new u(blob, string, string2);
                    cursorQuery.close();
                    return uVar;
                } catch (SQLiteException e10) {
                    e = e10;
                    zzj().C().c("Error querying remote config. appId", v5.r(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final ve S(String str, long j10, byte[] bArr, String str2, String str3, int i10, int i11, long j11, long j12) {
        fb fbVar;
        if (TextUtils.isEmpty(str2)) {
            zzj().B().a("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            zzgf.zzj.zzb zzbVar = (zzgf.zzj.zzb) we.C(zzgf.zzj.zzb(), bArr);
            fb[] fbVarArrValues = fb.values();
            int length = fbVarArrValues.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    fbVar = fb.UNKNOWN;
                    break;
                }
                fbVar = fbVarArrValues[i12];
                if (fbVar.zza() == i10) {
                    break;
                }
                i12++;
            }
            if (fbVar != fb.GOOGLE_SIGNAL && fbVar != fb.GOOGLE_SIGNAL_PENDING && i11 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<zzgf.zzk> it = zzbVar.zzd().iterator();
                while (it.hasNext()) {
                    zzgf.zzk.zza zzaVarZzch = it.next().zzch();
                    zzaVarZzch.zzi(i11);
                    arrayList.add((zzgf.zzk) ((zzkg) zzaVarZzch.zzaj()));
                }
                zzbVar.zzb();
                zzbVar.zza(arrayList);
            }
            HashMap map = new HashMap();
            if (str3 != null) {
                for (String str4 : str3.split("\r\n")) {
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] strArrSplit = str4.split("=", 2);
                    if (strArrSplit.length != 2) {
                        zzj().C().b("Invalid upload header: ", str4);
                        break;
                    }
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
            return new ue().h(j10).b((zzgf.zzj) ((zzkg) zzbVar.zzaj())).c(str2).d(map).e(fbVar).g(j11).a(j12).f();
        } catch (IOException e10) {
            zzj().C().c("Failed to queued MeasurementBatch from upload_queue. appId", str, e10);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a3  */
    public final bf S0(String str, String str2) {
        Cursor cursorQuery;
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.f(str2);
        j();
        q();
        Cursor cursor = null;
        try {
            cursorQuery = x().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return null;
                }
                long j10 = cursorQuery.getLong(0);
                try {
                    try {
                        Object objG = G(cursorQuery, 1);
                        if (objG == null) {
                            cursorQuery.close();
                            return null;
                        }
                        bf bfVar = new bf(str, cursorQuery.getString(2), str2, j10, objG);
                        if (cursorQuery.moveToNext()) {
                            zzj().C().b("Got multiple records for user property, expected one. appId", v5.r(str));
                        }
                        cursorQuery.close();
                        return bfVar;
                    } catch (SQLiteException e10) {
                        e = e10;
                        zzj().C().d("Error querying user property. appId", v5.r(str), d().g(str2), e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            } catch (SQLiteException e11) {
                e = e11;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e12) {
            e = e12;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
        }
        zzj().C().d("Error querying user property. appId", v5.r(str), d().g(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final Map<Integer, List<zzfw.zzb>> T0(String str, String str2) {
        q();
        j();
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.f(str2);
        t.a aVar = new t.a();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = x().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzfw.zzb>> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzfw.zzb zzbVar = (zzfw.zzb) ((zzkg) ((zzfw.zzb.zza) we.C(zzfw.zzb.zzc(), cursorQuery.getBlob(1))).zzaj());
                        int i10 = cursorQuery.getInt(0);
                        List arrayList = (List) aVar.get(Integer.valueOf(i10));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            aVar.put(Integer.valueOf(i10), arrayList);
                        }
                        arrayList.add(zzbVar);
                    } catch (IOException e10) {
                        zzj().C().c("Failed to merge filter. appId", v5.r(str), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return aVar;
            } catch (SQLiteException e11) {
                zzj().C().c("Database error querying filters. appId", v5.r(str), e11);
                Map<Integer, List<zzfw.zzb>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void U(Long l10) {
        j();
        q();
        com.google.android.gms.common.internal.r.l(l10);
        if (a().p(p0.I0)) {
            try {
                if (x().delete("upload_queue", "rowid=?", new String[]{String.valueOf(l10)}) != 1) {
                    zzj().H().a("Deleted fewer rows from upload_queue than expected");
                }
            } catch (SQLiteException e10) {
                zzj().C().b("Failed to delete a MeasurementBatch in a upload_queue table", e10);
                throw e10;
            }
        }
    }

    public final f0 U0(String str) {
        com.google.android.gms.common.internal.r.l(str);
        j();
        q();
        return f0.d(I("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final void V(String str, Long l10, String str2, Bundle bundle) {
        boolean z10;
        String str3 = str;
        com.google.android.gms.common.internal.r.l(bundle);
        j();
        q();
        y yVar = (!a().p(p0.f16637a1) || l10 == null) ? new y(this, str3) : new y(this, str3, l10.longValue());
        List<w> listA = yVar.a();
        while (!listA.isEmpty()) {
            for (w wVar : listA) {
                if (!TextUtils.isEmpty(str2)) {
                    zzgf.zzk zzkVarF0 = F0(str3, wVar.f16923b);
                    if (zzkVarF0 == null) {
                        z10 = false;
                        break;
                    }
                    Iterator<zzgf.zzp> it = zzkVarF0.zzau().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().zzg().equals(str2)) {
                                z10 = true;
                                break;
                            }
                        } else {
                            z10 = false;
                            break;
                        }
                    }
                    if (!z10) {
                    }
                }
                we weVarK = k();
                zzgf.zzf zzfVar = wVar.f16925d;
                Bundle bundle2 = new Bundle();
                for (zzgf.zzh zzhVar : zzfVar.zzh()) {
                    if (zzhVar.zzj()) {
                        bundle2.putDouble(zzhVar.zzg(), zzhVar.zza());
                    } else if (zzhVar.zzk()) {
                        bundle2.putFloat(zzhVar.zzg(), zzhVar.zzb());
                    } else if (zzhVar.zzl()) {
                        bundle2.putLong(zzhVar.zzg(), zzhVar.zzd());
                    } else if (zzhVar.zzn()) {
                        bundle2.putString(zzhVar.zzg(), zzhVar.zzh());
                    } else if (zzhVar.zzi().isEmpty()) {
                        weVarK.zzj().C().b("Unexpected parameter type for parameter", zzhVar);
                    } else {
                        bundle2.putParcelableArray(zzhVar.zzg(), we.e0(zzhVar.zzi()));
                    }
                }
                String string = bundle2.getString("_o");
                bundle2.remove("_o");
                String strZzg = zzfVar.zzg();
                if (string == null) {
                    string = "";
                }
                z5 z5Var = new z5(strZzg, string, bundle2, zzfVar.zzd());
                g().J(z5Var.f16994d, bundle);
                e0(wVar.f16922a, new g0(this.f16624a, z5Var.f16992b, str, wVar.f16925d.zzg(), wVar.f16925d.zzd(), wVar.f16925d.zzc(), z5Var.f16994d), wVar.f16923b, wVar.f16924c);
                str3 = str;
            }
            listA = yVar.a();
            str3 = str;
        }
    }

    public final Map<Integer, List<zzfw.zze>> V0(String str, String str2) {
        q();
        j();
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.f(str2);
        t.a aVar = new t.a();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = x().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzfw.zze>> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzfw.zze zzeVar = (zzfw.zze) ((zzkg) ((zzfw.zze.zza) we.C(zzfw.zze.zzc(), cursorQuery.getBlob(1))).zzaj());
                        int i10 = cursorQuery.getInt(0);
                        List arrayList = (List) aVar.get(Integer.valueOf(i10));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            aVar.put(Integer.valueOf(i10), arrayList);
                        }
                        arrayList.add(zzeVar);
                    } catch (IOException e10) {
                        zzj().C().c("Failed to merge filter", v5.r(str), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return aVar;
            } catch (SQLiteException e11) {
                zzj().C().c("Database error querying filters. appId", v5.r(str), e11);
                Map<Integer, List<zzfw.zze>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void W(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseX = x();
            String asString = contentValues.getAsString(str2);
            if (asString == null) {
                zzj().D().b("Value of the primary key is not set.", v5.r(str2));
                return;
            }
            if (sQLiteDatabaseX.update(str, contentValues, str2 + " = ?", new String[]{asString}) == 0 && sQLiteDatabaseX.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().C().c("Failed to insert/update table (got -1). key", v5.r(str), v5.r(str2));
            }
        } catch (SQLiteException e10) {
            zzj().C().d("Error storing into table. key", v5.r(str), v5.r(str2), e10);
        }
    }

    public final s8 W0(String str) {
        com.google.android.gms.common.internal.r.l(str);
        j();
        q();
        return s8.p(I("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final void X(String str, List<zzfw.zza> list) {
        boolean z10;
        x5 x5VarH;
        String str2;
        Object objR;
        Integer numValueOf;
        boolean z11;
        com.google.android.gms.common.internal.r.l(list);
        for (int i10 = 0; i10 < list.size(); i10++) {
            zzfw.zza.C0079zza c0079zzaZzch = list.get(i10).zzch();
            if (c0079zzaZzch.zza() != 0) {
                for (int i11 = 0; i11 < c0079zzaZzch.zza(); i11++) {
                    zzfw.zzb.zza zzaVarZzch = c0079zzaZzch.zza(i11).zzch();
                    zzfw.zzb.zza zzaVar = (zzfw.zzb.zza) ((zzkg.zza) zzaVarZzch.clone());
                    String strB = y8.b(zzaVarZzch.zzb());
                    if (strB != null) {
                        zzaVar.zza(strB);
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    for (int i12 = 0; i12 < zzaVarZzch.zza(); i12++) {
                        zzfw.zzc zzcVarZza = zzaVarZzch.zza(i12);
                        String strA = x8.a(zzcVarZza.zze());
                        if (strA != null) {
                            zzaVar.zza(i12, (zzfw.zzc) ((zzkg) zzcVarZza.zzch().zza(strA).zzaj()));
                            z11 = true;
                        }
                    }
                    if (z11) {
                        c0079zzaZzch = c0079zzaZzch.zza(i11, zzaVar);
                        list.set(i10, (zzfw.zza) ((zzkg) c0079zzaZzch.zzaj()));
                    }
                }
            }
            if (c0079zzaZzch.zzb() != 0) {
                for (int i13 = 0; i13 < c0079zzaZzch.zzb(); i13++) {
                    zzfw.zze zzeVarZzb = c0079zzaZzch.zzb(i13);
                    String strA2 = a9.a(zzeVarZzb.zze());
                    if (strA2 != null) {
                        c0079zzaZzch = c0079zzaZzch.zza(i13, zzeVarZzb.zzch().zza(strA2));
                        list.set(i10, (zzfw.zza) ((zzkg) c0079zzaZzch.zzaj()));
                    }
                }
            }
        }
        q();
        j();
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.l(list);
        SQLiteDatabase sQLiteDatabaseX = x();
        sQLiteDatabaseX.beginTransaction();
        try {
            q();
            j();
            com.google.android.gms.common.internal.r.f(str);
            SQLiteDatabase sQLiteDatabaseX2 = x();
            sQLiteDatabaseX2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseX2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzfw.zza zzaVar2 : list) {
                q();
                j();
                com.google.android.gms.common.internal.r.f(str);
                com.google.android.gms.common.internal.r.l(zzaVar2);
                if (zzaVar2.zzg()) {
                    int iZza = zzaVar2.zza();
                    Iterator<zzfw.zzb> it = zzaVar2.zze().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            Iterator<zzfw.zze> it2 = zzaVar2.zzf().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    Iterator<zzfw.zzb> it3 = zzaVar2.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!g0(str, iZza, it3.next())) {
                                                z10 = false;
                                                break;
                                            }
                                        } else {
                                            z10 = true;
                                            break;
                                        }
                                    }
                                    if (z10) {
                                        Iterator<zzfw.zze> it4 = zzaVar2.zzf().iterator();
                                        while (it4.hasNext()) {
                                            if (!h0(str, iZza, it4.next())) {
                                                z10 = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (!z10) {
                                        q();
                                        j();
                                        com.google.android.gms.common.internal.r.f(str);
                                        SQLiteDatabase sQLiteDatabaseX3 = x();
                                        sQLiteDatabaseX3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZza)});
                                        sQLiteDatabaseX3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZza)});
                                        break;
                                    }
                                    break;
                                }
                                if (!it2.next().zzi()) {
                                    x5VarH = zzj().H();
                                    str2 = "Property filter with no ID. Audience definition ignored. appId, audienceId";
                                    objR = v5.r(str);
                                    numValueOf = Integer.valueOf(iZza);
                                }
                            }
                        } else if (!it.next().zzl()) {
                            x5VarH = zzj().H();
                            str2 = "Event filter with no ID. Audience definition ignored. appId, audienceId";
                            objR = v5.r(str);
                            numValueOf = Integer.valueOf(iZza);
                        }
                        x5VarH.c(str2, objR, numValueOf);
                        break;
                    }
                }
                zzj().H().b("Audience with no ID. appId", v5.r(str));
            }
            ArrayList arrayList = new ArrayList();
            for (zzfw.zza zzaVar3 : list) {
                arrayList.add(zzaVar3.zzg() ? Integer.valueOf(zzaVar3.zza()) : null);
            }
            L0(str, arrayList);
            sQLiteDatabaseX.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseX.endTransaction();
        }
    }

    public final s8 X0(String str) {
        com.google.android.gms.common.internal.r.l(str);
        j();
        q();
        s8 s8Var = (s8) H("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new x() { // from class: u4.r
            @Override // u4.x
            public final Object a(Cursor cursor) {
                return s8.f(cursor.getString(0), cursor.getInt(1));
            }
        });
        return s8Var == null ? s8.f16793c : s8Var;
    }

    public final void Y(String str, f0 f0Var) {
        com.google.android.gms.common.internal.r.l(str);
        com.google.android.gms.common.internal.r.l(f0Var);
        j();
        q();
        s8 s8VarX0 = X0(str);
        s8 s8Var = s8.f16793c;
        if (s8VarX0 == s8Var) {
            K0(str, s8Var);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", f0Var.j());
        W("consent_settings", "app_id", contentValues);
    }

    public final void Y0(String str, String str2) {
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.f(str2);
        j();
        q();
        try {
            x().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            zzj().C().d("Error deleting user property. appId", v5.r(str), d().g(str2), e10);
        }
    }

    public final void Z(String str, j0 j0Var) {
        com.google.android.gms.common.internal.r.l(j0Var);
        j();
        q();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", j0Var.f16377a);
        contentValues.put("name", j0Var.f16378b);
        contentValues.put("lifetime_count", Long.valueOf(j0Var.f16379c));
        contentValues.put("current_bundle_count", Long.valueOf(j0Var.f16380d));
        contentValues.put("last_fire_timestamp", Long.valueOf(j0Var.f16382f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(j0Var.f16383g));
        contentValues.put("last_bundled_day", j0Var.f16384h);
        contentValues.put("last_sampled_complex_event_id", j0Var.f16385i);
        contentValues.put("last_sampling_rate", j0Var.f16386j);
        contentValues.put("current_session_count", Long.valueOf(j0Var.f16381e));
        Boolean bool = j0Var.f16387k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (x().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().C().b("Failed to insert/update event aggregates (got -1). appId", v5.r(j0Var.f16377a));
            }
        } catch (SQLiteException e10) {
            zzj().C().c("Error storing event aggregates. appId", v5.r(j0Var.f16377a), e10);
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00f0  */
    public final ve Z0(String str) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        com.google.android.gms.common.internal.r.f(str);
        j();
        q();
        Cursor cursor2 = null;
        if (!a().p(p0.I0)) {
            return null;
        }
        if (a().p(p0.K0)) {
            List<ve> listL = L(str, be.S(fb.GOOGLE_SIGNAL), 1);
            if (listL.isEmpty()) {
                return null;
            }
            return listL.get(0);
        }
        try {
            cursorQuery = x().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", "creation_timestamp", "associated_row_id"}, "app_id=? AND NOT " + B0(), new String[]{str}, null, null, "creation_timestamp ASC", "1");
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return null;
                }
                cursor = cursorQuery;
                try {
                    ve veVarS = S(str, cursorQuery.getLong(0), cursorQuery.getBlob(2), cursorQuery.getString(3), cursorQuery.getString(4), cursorQuery.getInt(5), cursorQuery.getInt(6), cursorQuery.getLong(7), cursorQuery.getLong(8));
                    cursor.close();
                    return veVarS;
                } catch (SQLiteException e10) {
                    e = e10;
                    cursorQuery = cursor;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e11) {
                e = e11;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e12) {
            e = e12;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            zzj().C().c("Error to querying MeasurementBatch from upload_queue. appId", str, e);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            cursor2 = cursorQuery;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final void a0(String str, s8 s8Var) {
        com.google.android.gms.common.internal.r.l(str);
        com.google.android.gms.common.internal.r.l(s8Var);
        j();
        q();
        K0(str, X0(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", s8Var.v());
        W("consent_settings", "app_id", contentValues);
    }

    public final boolean a1(String str, String str2) {
        return E0("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final void b0(List<Long> list) {
        j();
        q();
        com.google.android.gms.common.internal.r.l(list);
        com.google.android.gms.common.internal.r.n(list.size());
        if (q0()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (E0("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                zzj().H().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                x().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e10) {
                zzj().C().b("Error incrementing retry count. error", e10);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x007d  */
    public final List<sd> b1(String str) {
        com.google.android.gms.common.internal.r.f(str);
        j();
        q();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = x().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new sd(string, cursorQuery.getLong(1), cursorQuery.getInt(2)));
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e10) {
                zzj().C().c("Error querying trigger uris. appId", v5.r(str), e10);
                List<sd> listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        throw th;
    }

    public final void c0(j0 j0Var) {
        Z("events", j0Var);
    }

    public final void c1(String str, String str2) {
        com.google.android.gms.common.internal.r.f(str2);
        j();
        q();
        try {
            x().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e10) {
            zzj().C().c("Error deleting snapshot. appId", v5.r(str2), e10);
        }
    }

    public final void d0(h6 h6Var, boolean z10, boolean z11) {
        com.google.android.gms.common.internal.r.l(h6Var);
        j();
        q();
        String strL = h6Var.l();
        com.google.android.gms.common.internal.r.l(strL);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strL);
        if (z10) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.f16938b.b0(strL).m(s8.a.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", h6Var.m());
        }
        contentValues.put("gmp_app_id", h6Var.q());
        if (this.f16938b.b0(strL).m(s8.a.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", h6Var.s());
        }
        contentValues.put("last_bundle_index", Long.valueOf(h6Var.G0()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(h6Var.I0()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(h6Var.E0()));
        contentValues.put("app_version", h6Var.o());
        contentValues.put("app_store", h6Var.n());
        contentValues.put("gmp_version", Long.valueOf(h6Var.A0()));
        contentValues.put("dev_cert_hash", Long.valueOf(h6Var.u0()));
        contentValues.put("measurement_enabled", Boolean.valueOf(h6Var.A()));
        contentValues.put("day", Long.valueOf(h6Var.s0()));
        contentValues.put("daily_public_events_count", Long.valueOf(h6Var.n0()));
        contentValues.put("daily_events_count", Long.valueOf(h6Var.k0()));
        contentValues.put("daily_conversions_count", Long.valueOf(h6Var.e0()));
        contentValues.put("config_fetched_time", Long.valueOf(h6Var.b0()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(h6Var.y0()));
        contentValues.put("app_version_int", Long.valueOf(h6Var.V()));
        contentValues.put("firebase_instance_id", h6Var.p());
        contentValues.put("daily_error_events_count", Long.valueOf(h6Var.h0()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(h6Var.q0()));
        contentValues.put("health_monitor_sample", h6Var.r());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(h6Var.z()));
        contentValues.put("admob_app_id", h6Var.j());
        contentValues.put("dynamite_version", Long.valueOf(h6Var.w0()));
        if (this.f16938b.b0(strL).m(s8.a.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", h6Var.u());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(h6Var.C()));
        contentValues.put("target_os_version", Long.valueOf(h6Var.K0()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(h6Var.J0()));
        if (zzoy.zza() && a().D(strL, p0.Q0)) {
            contentValues.put("ad_services_version", Integer.valueOf(h6Var.a()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(h6Var.Y()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(h6Var.D()));
        contentValues.put("npa_metadata_value", h6Var.L0());
        contentValues.put("bundle_delivery_index", Long.valueOf(h6Var.C0()));
        contentValues.put("sgtm_preview_key", h6Var.v());
        contentValues.put("dma_consent_state", Integer.valueOf(h6Var.Q()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(h6Var.L()));
        contentValues.put("serialized_npa_metadata", h6Var.t());
        if (a().D(strL, p0.K0)) {
            contentValues.put("client_upload_eligibility", Integer.valueOf(h6Var.F()));
        }
        List<String> listW = h6Var.w();
        if (listW != null) {
            if (listW.isEmpty()) {
                zzj().H().b("Safelisted events should not be an empty list. appId", strL);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listW));
            }
        }
        if (zzog.zza() && a().p(p0.F0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", h6Var.M0());
        contentValues.put("unmatched_uwa", h6Var.N0());
        contentValues.put("ad_campaign_info", h6Var.E());
        try {
            SQLiteDatabase sQLiteDatabaseX = x();
            if (sQLiteDatabaseX.update("apps", contentValues, "app_id = ?", new String[]{strL}) == 0 && sQLiteDatabaseX.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzj().C().b("Failed to insert/update app (got -1). appId", v5.r(strL));
            }
        } catch (SQLiteException e10) {
            zzj().C().c("Error storing app. appId", v5.r(strL), e10);
        }
    }

    public final List<bf> d1(String str) {
        com.google.android.gms.common.internal.r.f(str);
        j();
        q();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = x().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j10 = cursorQuery.getLong(2);
                    Object objG = G(cursorQuery, 3);
                    if (objG == null) {
                        zzj().C().b("Read invalid user property value, ignoring it. appId", v5.r(str));
                    } else {
                        arrayList.add(new bf(str, str2, string, j10, objG));
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e10) {
                zzj().C().c("Error querying user properties. appId", v5.r(str), e10);
                List<bf> listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final boolean e0(long j10, g0 g0Var, long j11, boolean z10) {
        j();
        q();
        com.google.android.gms.common.internal.r.l(g0Var);
        com.google.android.gms.common.internal.r.f(g0Var.f16204a);
        byte[] bArrZzce = k().A(g0Var).zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", g0Var.f16204a);
        contentValues.put("name", g0Var.f16205b);
        contentValues.put("timestamp", Long.valueOf(g0Var.f16207d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j11));
        contentValues.put("data", bArrZzce);
        contentValues.put("realtime", Integer.valueOf(z10 ? 1 : 0));
        try {
            long jUpdate = x().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j10)});
            if (jUpdate == 1) {
                return true;
            }
            zzj().C().c("Failed to update raw event. appId, updatedRows", v5.r(g0Var.f16204a), Long.valueOf(jUpdate));
            return false;
        } catch (SQLiteException e10) {
            zzj().C().c("Error updating raw event. appId", v5.r(g0Var.f16204a), e10);
            return false;
        }
    }

    public final Map<Integer, zzgf.zzm> e1(String str) {
        q();
        j();
        com.google.android.gms.common.internal.r.f(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = x().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, zzgf.zzm> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                t.a aVar = new t.a();
                do {
                    int i10 = cursorQuery.getInt(0);
                    try {
                        aVar.put(Integer.valueOf(i10), (zzgf.zzm) ((zzkg) ((zzgf.zzm.zza) we.C(zzgf.zzm.zze(), cursorQuery.getBlob(1))).zzaj()));
                    } catch (IOException e10) {
                        zzj().C().d("Failed to merge filter results. appId, audienceId, error", v5.r(str), Integer.valueOf(i10), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return aVar;
            } catch (SQLiteException e11) {
                zzj().C().c("Database error querying filter results. appId", v5.r(str), e11);
                Map<Integer, zzgf.zzm> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean f0(zzgf.zzk zzkVar, boolean z10) {
        x5 x5VarC;
        Object objR;
        String str;
        j();
        q();
        com.google.android.gms.common.internal.r.l(zzkVar);
        com.google.android.gms.common.internal.r.f(zzkVar.zzab());
        com.google.android.gms.common.internal.r.o(zzkVar.zzbm());
        n1();
        long jA = zzb().a();
        if (zzkVar.zzn() < jA - j.N() || zzkVar.zzn() > j.N() + jA) {
            zzj().H().d("Storing bundle outside of the max uploading time span. appId, now, timestamp", v5.r(zzkVar.zzab()), Long.valueOf(jA), Long.valueOf(zzkVar.zzn()));
        }
        try {
            byte[] bArrD0 = k().d0(zzkVar.zzce());
            zzj().G().b("Saving bundle, size", Integer.valueOf(bArrD0.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkVar.zzab());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzkVar.zzn()));
            contentValues.put("data", bArrD0);
            contentValues.put("has_realtime", Integer.valueOf(z10 ? 1 : 0));
            if (zzkVar.zzbt()) {
                contentValues.put("retry_count", Integer.valueOf(zzkVar.zzg()));
            }
            try {
                if (x().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzj().C().b("Failed to insert bundle (got -1). appId", v5.r(zzkVar.zzab()));
                return false;
            } catch (SQLiteException e10) {
                e = e10;
                x5VarC = zzj().C();
                objR = v5.r(zzkVar.zzab());
                str = "Error storing bundle. appId";
                x5VarC.c(str, objR, e);
                return false;
            }
        } catch (IOException e11) {
            e = e11;
            x5VarC = zzj().C();
            objR = v5.r(zzkVar.zzab());
            str = "Data loss. Failed to serialize bundle. appId";
        }
    }

    public final Map<Integer, List<zzfw.zzb>> f1(String str) {
        com.google.android.gms.common.internal.r.f(str);
        t.a aVar = new t.a();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = x().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzfw.zzb>> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzfw.zzb zzbVar = (zzfw.zzb) ((zzkg) ((zzfw.zzb.zza) we.C(zzfw.zzb.zzc(), cursorQuery.getBlob(1))).zzaj());
                        if (zzbVar.zzk()) {
                            int i10 = cursorQuery.getInt(0);
                            List arrayList = (List) aVar.get(Integer.valueOf(i10));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                aVar.put(Integer.valueOf(i10), arrayList);
                            }
                            arrayList.add(zzbVar);
                        }
                    } catch (IOException e10) {
                        zzj().C().c("Failed to merge filter. appId", v5.r(str), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return aVar;
            } catch (SQLiteException e11) {
                zzj().C().c("Database error querying filters. appId", v5.r(str), e11);
                Map<Integer, List<zzfw.zzb>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean g0(String str, int i10, zzfw.zzb zzbVar) {
        q();
        j();
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.l(zzbVar);
        if (zzbVar.zzf().isEmpty()) {
            zzj().H().d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", v5.r(str), Integer.valueOf(i10), String.valueOf(zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzce = zzbVar.zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i10));
        contentValues.put("filter_id", zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzf());
        contentValues.put("session_scoped", zzbVar.zzm() ? Boolean.valueOf(zzbVar.zzj()) : null);
        contentValues.put("data", bArrZzce);
        try {
            if (x().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().C().b("Failed to insert event filter (got -1). appId", v5.r(str));
            return true;
        } catch (SQLiteException e10) {
            zzj().C().c("Error storing event filter. appId", v5.r(str), e10);
            return false;
        }
    }

    public final Map<Integer, List<Integer>> g1(String str) {
        q();
        j();
        com.google.android.gms.common.internal.r.f(str);
        t.a aVar = new t.a();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = x().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                if (!cursorRawQuery.moveToFirst()) {
                    Map<Integer, List<Integer>> mapEmptyMap = Collections.emptyMap();
                    cursorRawQuery.close();
                    return mapEmptyMap;
                }
                do {
                    int i10 = cursorRawQuery.getInt(0);
                    List arrayList = (List) aVar.get(Integer.valueOf(i10));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        aVar.put(Integer.valueOf(i10), arrayList);
                    }
                    arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                } while (cursorRawQuery.moveToNext());
                cursorRawQuery.close();
                return aVar;
            } catch (SQLiteException e10) {
                zzj().C().c("Database error querying scoped filters. appId", v5.r(str), e10);
                Map<Integer, List<Integer>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean h0(String str, int i10, zzfw.zze zzeVar) {
        q();
        j();
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.l(zzeVar);
        if (zzeVar.zze().isEmpty()) {
            zzj().H().d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", v5.r(str), Integer.valueOf(i10), String.valueOf(zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null));
            return false;
        }
        byte[] bArrZzce = zzeVar.zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i10));
        contentValues.put("filter_id", zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null);
        contentValues.put("property_name", zzeVar.zze());
        contentValues.put("session_scoped", zzeVar.zzj() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put("data", bArrZzce);
        try {
            if (x().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().C().b("Failed to insert property filter (got -1). appId", v5.r(str));
            return false;
        } catch (SQLiteException e10) {
            zzj().C().c("Error storing property filter. appId", v5.r(str), e10);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0069  */
    public final void h1(String str) {
        j0 j0VarP0;
        c1("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = x().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return;
                }
                do {
                    String string = cursorQuery.getString(0);
                    if (string != null && (j0VarP0 = P0(str, string)) != null) {
                        Z("events_snapshot", j0VarP0);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return;
            } catch (SQLiteException e10) {
                zzj().C().c("Error creating snapshot. appId", v5.r(str), e10);
                if (cursorQuery != null) {
                    cursorQuery.close();
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        throw th;
    }

    public final boolean i0(String str, long j10) {
        if (!a().p(p0.f16637a1) && zzb().a() > 15000 + j10) {
            return false;
        }
        try {
            return D("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j10)}, 0L) <= 0 && D("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j10)}, 0L) > 0;
        } catch (SQLiteException e10) {
            zzj().C().b("Error checking backfill conditions", e10);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00df  */
    /* JADX WARN: Code duplicated, block: B:62:0x00eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00ed A[ADDED_TO_REGION] */
    public final void i1(String str) throws Throwable {
        boolean z10;
        j0 j0VarO0;
        ArrayList arrayList = new ArrayList(Arrays.asList("name", "lifetime_count"));
        j0 j0VarP0 = P0(str, "_f");
        j0 j0VarP1 = P0(str, "_v");
        c1("events", str);
        boolean z11 = false;
        Cursor cursorQuery = null;
        try {
            cursorQuery = x().query("events_snapshot", (String[]) arrayList.toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                if (j0VarP0 != null) {
                    Z("events", j0VarP0);
                } else if (j0VarP1 != null) {
                    Z("events", j0VarP1);
                }
                c1("events_snapshot", str);
                return;
            }
            boolean z12 = false;
            z10 = false;
            do {
                try {
                    String string = cursorQuery.getString(0);
                    if (cursorQuery.getLong(1) >= 1) {
                        if ("_f".equals(string)) {
                            z12 = true;
                        } else if ("_v".equals(string)) {
                            z10 = true;
                        }
                    }
                    if (string != null && (j0VarO0 = O0("events_snapshot", str, string)) != null) {
                        Z("events", j0VarO0);
                    }
                } catch (SQLiteException e10) {
                    e = e10;
                    z11 = z12;
                    try {
                        zzj().C().c("Error querying snapshot. appId", v5.r(str), e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (!z11 && j0VarP0 != null) {
                            Z("events", j0VarP0);
                        } else if (!z10 && j0VarP1 != null) {
                            Z("events", j0VarP1);
                        }
                        c1("events_snapshot", str);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        if (z11 && j0VarP0 != null) {
                            Z("events", j0VarP0);
                        } else if (!z10 && j0VarP1 != null) {
                            Z("events", j0VarP1);
                        }
                        c1("events_snapshot", str);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z11 = z12;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (z11) {
                        if (!z10) {
                            Z("events", j0VarP1);
                        }
                    } else if (!z10) {
                        Z("events", j0VarP1);
                    }
                    c1("events_snapshot", str);
                    throw th;
                }
            } while (cursorQuery.moveToNext());
            cursorQuery.close();
            if (!z12 && j0VarP0 != null) {
                Z("events", j0VarP0);
            } else if (!z10 && j0VarP1 != null) {
                Z("events", j0VarP1);
            }
            c1("events_snapshot", str);
        } catch (SQLiteException e11) {
            e = e11;
            z10 = false;
        } catch (Throwable th3) {
            th = th3;
            z10 = false;
        }
    }

    public final boolean j0(String str, Bundle bundle) {
        j();
        q();
        byte[] bArrZzce = k().A(new g0(this.f16624a, "", str, "dep", 0L, 0L, bundle)).zzce();
        zzj().G().c("Saving default event parameters, appId, data size", d().b(str), Integer.valueOf(bArrZzce.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrZzce);
        try {
            if (x().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().C().b("Failed to insert default event parameters (got -1). appId", v5.r(str));
            return false;
        } catch (SQLiteException e10) {
            zzj().C().c("Error storing default event parameters. appId", v5.r(str), e10);
            return false;
        }
    }

    public final void j1() {
        q();
        x().beginTransaction();
    }

    public final boolean k0(String str, Long l10, long j10, zzgf.zzf zzfVar) {
        j();
        q();
        com.google.android.gms.common.internal.r.l(zzfVar);
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.l(l10);
        byte[] bArrZzce = zzfVar.zzce();
        zzj().G().c("Saving complex main event, appId, data size", d().b(str), Integer.valueOf(bArrZzce.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j10));
        contentValues.put("main_event", bArrZzce);
        try {
            if (x().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().C().b("Failed to insert complex main event (got -1). appId", v5.r(str));
            return false;
        } catch (SQLiteException e10) {
            zzj().C().c("Error storing complex main event. appId", v5.r(str), e10);
            return false;
        }
    }

    public final boolean k1(String str) {
        if (!a().p(p0.I0)) {
            return false;
        }
        if (!a().p(p0.K0)) {
            String strB0 = B0();
            StringBuilder sb2 = new StringBuilder("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=? AND NOT ");
            sb2.append(strB0);
            return E0(sb2.toString(), new String[]{str}) != 0;
        }
        fb[] fbVarArr = {fb.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        for (int i10 = 0; i10 <= 0; i10++) {
            arrayList.add(Integer.valueOf(fbVarArr[0].zza()));
        }
        String strH0 = H0(arrayList);
        String strB1 = B0();
        StringBuilder sb3 = new StringBuilder("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb3.append(strH0);
        sb3.append(" AND NOT ");
        sb3.append(strB1);
        return E0(sb3.toString(), new String[]{str}) != 0;
    }

    public final boolean l0(String str, sd sdVar) {
        j();
        q();
        com.google.android.gms.common.internal.r.l(sdVar);
        com.google.android.gms.common.internal.r.f(str);
        long jA = zzb().a();
        long j10 = sdVar.f16812b;
        d5<Long> d5Var = p0.f16674q0;
        if (j10 < jA - d5Var.a(null).longValue() || sdVar.f16812b > d5Var.a(null).longValue() + jA) {
            zzj().H().d("Storing trigger URI outside of the max retention time span. appId, now, timestamp", v5.r(str), Long.valueOf(jA), Long.valueOf(sdVar.f16812b));
        }
        zzj().G().a("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", sdVar.f16811a);
        contentValues.put("source", Integer.valueOf(sdVar.f16813c));
        contentValues.put("timestamp_millis", Long.valueOf(sdVar.f16812b));
        try {
            if (x().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzj().C().b("Failed to insert trigger URI (got -1). appId", v5.r(str));
            return false;
        } catch (SQLiteException e10) {
            zzj().C().c("Error storing trigger URI. appId", v5.r(str), e10);
            return false;
        }
    }

    public final int l1(String str) {
        com.google.android.gms.common.internal.r.f(str);
        j();
        q();
        try {
            int iU = a().u(str, p0.f16685w);
            if (iU <= 0) {
                return 0;
            }
            return x().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(iU)});
        } catch (SQLiteException e10) {
            zzj().C().c("Error deleting over the limit queued batches. appId", v5.r(str), e10);
            return 0;
        }
    }

    public final boolean m0(h hVar) {
        com.google.android.gms.common.internal.r.l(hVar);
        j();
        q();
        String str = hVar.f16265a;
        com.google.android.gms.common.internal.r.l(str);
        if (S0(str, hVar.f16267c.f17015b) == null && E0("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", hVar.f16266b);
        contentValues.put("name", hVar.f16267c.f17015b);
        T(contentValues, "value", com.google.android.gms.common.internal.r.l(hVar.f16267c.S()));
        contentValues.put("active", Boolean.valueOf(hVar.f16269e));
        contentValues.put("trigger_event_name", hVar.f16270f);
        contentValues.put("trigger_timeout", Long.valueOf(hVar.f16272m));
        g();
        contentValues.put("timed_out_event", af.m0(hVar.f16271l));
        contentValues.put("creation_timestamp", Long.valueOf(hVar.f16268d));
        g();
        contentValues.put("triggered_event", af.m0(hVar.f16273n));
        contentValues.put("triggered_timestamp", Long.valueOf(hVar.f16267c.f17016c));
        contentValues.put("time_to_live", Long.valueOf(hVar.f16274o));
        g();
        contentValues.put("expired_event", af.m0(hVar.f16275p));
        try {
            if (x().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzj().C().b("Failed to insert/update conditional user property (got -1)", v5.r(str));
            }
        } catch (SQLiteException e10) {
            zzj().C().c("Error storing conditional user property", v5.r(str), e10);
        }
        return true;
    }

    public final void m1() {
        q();
        x().endTransaction();
    }

    public final boolean n0(g0 g0Var, long j10, boolean z10) {
        j();
        q();
        com.google.android.gms.common.internal.r.l(g0Var);
        com.google.android.gms.common.internal.r.f(g0Var.f16204a);
        byte[] bArrZzce = k().A(g0Var).zzce();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", g0Var.f16204a);
        contentValues.put("name", g0Var.f16205b);
        contentValues.put("timestamp", Long.valueOf(g0Var.f16207d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j10));
        contentValues.put("data", bArrZzce);
        contentValues.put("realtime", Integer.valueOf(z10 ? 1 : 0));
        try {
            if (x().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzj().C().b("Failed to insert raw event (got -1). appId", v5.r(g0Var.f16204a));
            return false;
        } catch (SQLiteException e10) {
            zzj().C().c("Error storing raw event. appId", v5.r(g0Var.f16204a), e10);
            return false;
        }
    }

    public final void n1() {
        int iDelete;
        j();
        q();
        if (q0()) {
            long jA = o().f15993e.a();
            long jB = zzb().b();
            if (Math.abs(jB - jA) > j.O()) {
                o().f15993e.b(jB);
                j();
                q();
                if (!q0() || (iDelete = x().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().a()), String.valueOf(j.N())})) <= 0) {
                    return;
                }
                zzj().G().b("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    public final boolean o0(bf bfVar) {
        com.google.android.gms.common.internal.r.l(bfVar);
        j();
        q();
        if (S0(bfVar.f16054a, bfVar.f16056c) == null) {
            if (af.E0(bfVar.f16056c)) {
                if (E0("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{bfVar.f16054a}) >= a().m(bfVar.f16054a, p0.R, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(bfVar.f16056c) && E0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{bfVar.f16054a, bfVar.f16055b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", bfVar.f16054a);
        contentValues.put("origin", bfVar.f16055b);
        contentValues.put("name", bfVar.f16056c);
        contentValues.put("set_timestamp", Long.valueOf(bfVar.f16057d));
        T(contentValues, "value", bfVar.f16058e);
        try {
            if (x().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzj().C().b("Failed to insert/update user property (got -1). appId", v5.r(bfVar.f16054a));
            }
        } catch (SQLiteException e10) {
            zzj().C().c("Error storing user property. appId", v5.r(bfVar.f16054a), e10);
        }
        return true;
    }

    public final void o1() {
        q();
        x().setTransactionSuccessful();
    }

    public final boolean p0() {
        return E0("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final boolean p1() {
        return E0("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean q0() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean q1() {
        return E0("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    @Override // u4.fe
    public final boolean t() {
        return false;
    }

    public final long u() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = x().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return -1L;
                }
                long j10 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j10;
            } catch (SQLiteException e10) {
                zzj().C().b("Error querying raw events", e10);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final long v() {
        return D("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final long w() {
        return D("select max(timestamp) from raw_events", null, 0L);
    }

    public final SQLiteDatabase x() {
        j();
        try {
            return this.f16782d.getWritableDatabase();
        } catch (SQLiteException e10) {
            zzj().H().b("Error opening database", e10);
            throw e10;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    public final String y() throws Throwable {
        Throwable th;
        Cursor cursorRawQuery;
        ?? X = x();
        try {
            try {
                cursorRawQuery = X.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        cursorRawQuery.close();
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                    return string;
                } catch (SQLiteException e10) {
                    e = e10;
                    zzj().C().b("Database error getting next bundle app id", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (X != 0) {
                    X.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            X = 0;
            if (X != 0) {
                X.close();
            }
            throw th;
        }
    }

    public final int z(String str, String str2) {
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.f(str2);
        j();
        q();
        try {
            return x().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            zzj().C().d("Error deleting conditional property", v5.r(str), d().g(str2), e10);
            return 0;
        }
    }
}
