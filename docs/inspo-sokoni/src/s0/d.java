package s0;

import android.content.ClipData;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import o0.h;
import p0.p0;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    public class a extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f15401a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InputConnection inputConnection, boolean z10, b bVar) {
            super(inputConnection, z10);
            this.f15401a = bVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int i10, Bundle bundle) {
            if (this.f15401a.a(e.f(inputContentInfo), i10, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i10, bundle);
        }
    }

    public interface b {
        boolean a(e eVar, int i10, Bundle bundle);
    }

    public static b b(final View view) {
        h.g(view);
        return new b() { // from class: s0.c
            @Override // s0.d.b
            public final boolean a(e eVar, int i10, Bundle bundle) {
                return d.e(view, eVar, i10, bundle);
            }
        };
    }

    public static InputConnection c(View view, InputConnection inputConnection, EditorInfo editorInfo) {
        return d(inputConnection, editorInfo, b(view));
    }

    @Deprecated
    public static InputConnection d(InputConnection inputConnection, EditorInfo editorInfo, b bVar) {
        o0.c.d(inputConnection, "inputConnection must be non-null");
        o0.c.d(editorInfo, "editorInfo must be non-null");
        o0.c.d(bVar, "onCommitContentListener must be non-null");
        return new a(inputConnection, false, bVar);
    }

    public static /* synthetic */ boolean e(View view, e eVar, int i10, Bundle bundle) {
        if ((i10 & 1) != 0) {
            try {
                eVar.d();
                Parcelable parcelable = (Parcelable) eVar.e();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e10) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e10);
                return false;
            }
        }
        return p0.f0(view, new p0.c.a(new ClipData(eVar.b(), new ClipData.Item(eVar.a())), 2).d(eVar.c()).b(bundle).a()) == null;
    }
}
