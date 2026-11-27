package g1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f8497a;

    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f8498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f8499b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8500c = true;

        public a(TextView textView) {
            this.f8498a = textView;
            this.f8499b = new d(textView);
        }

        @Override // g1.f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f8500c ? f(inputFilterArr) : d(inputFilterArr);
        }

        @Override // g1.f.b
        public void b(boolean z10) {
            if (z10) {
                j();
            }
        }

        @Override // g1.f.b
        public void c(boolean z10) {
            this.f8500c = z10;
            j();
            i();
        }

        public final InputFilter[] d(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f8499b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f8499b;
            return inputFilterArr2;
        }

        public final SparseArray<InputFilter> e(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i10 = 0; i10 < inputFilterArr.length; i10++) {
                InputFilter inputFilter = inputFilterArr[i10];
                if (inputFilter instanceof d) {
                    sparseArray.put(i10, inputFilter);
                }
            }
            return sparseArray;
        }

        public final InputFilter[] f(InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArrayE = e(inputFilterArr);
            if (sparseArrayE.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayE.size()];
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (sparseArrayE.indexOfKey(i11) < 0) {
                    inputFilterArr2[i10] = inputFilterArr[i11];
                    i10++;
                }
            }
            return inputFilterArr2;
        }

        public void g(boolean z10) {
            this.f8500c = z10;
        }

        public final TransformationMethod h(TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        public final void i() {
            this.f8498a.setFilters(a(this.f8498a.getFilters()));
        }

        public void j() {
            this.f8498a.setTransformationMethod(l(this.f8498a.getTransformationMethod()));
        }

        public final TransformationMethod k(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }

        public TransformationMethod l(TransformationMethod transformationMethod) {
            return this.f8500c ? k(transformationMethod) : h(transformationMethod);
        }
    }

    public static class b {
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            throw null;
        }

        public void b(boolean z10) {
            throw null;
        }

        public void c(boolean z10) {
            throw null;
        }
    }

    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f8501a;

        public c(TextView textView) {
            this.f8501a = new a(textView);
        }

        @Override // g1.f.b
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return d() ? inputFilterArr : this.f8501a.a(inputFilterArr);
        }

        @Override // g1.f.b
        public void b(boolean z10) {
            if (d()) {
                return;
            }
            this.f8501a.b(z10);
        }

        @Override // g1.f.b
        public void c(boolean z10) {
            if (d()) {
                this.f8501a.g(z10);
            } else {
                this.f8501a.c(z10);
            }
        }

        public final boolean d() {
            return !androidx.emoji2.text.c.h();
        }
    }

    public f(TextView textView, boolean z10) {
        o0.h.h(textView, "textView cannot be null");
        this.f8497a = !z10 ? new c(textView) : new a(textView);
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f8497a.a(inputFilterArr);
    }

    public void b(boolean z10) {
        this.f8497a.b(z10);
    }

    public void c(boolean z10) {
        this.f8497a.c(z10);
    }
}
