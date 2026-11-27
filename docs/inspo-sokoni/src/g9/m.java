package g9;

import e9.s;
import h9.o;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    public static final class b extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Appendable f9103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f9104b = new a();

        public static class a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public char[] f9105a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f9106b;

            public a() {
            }

            public void a(char[] cArr) {
                this.f9105a = cArr;
                this.f9106b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i10) {
                return this.f9105a[i10];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f9105a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i10, int i11) {
                return new String(this.f9105a, i10, i11 - i10);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f9106b == null) {
                    this.f9106b = new String(this.f9105a);
                }
                return this.f9106b;
            }
        }

        public b(Appendable appendable) {
            this.f9103a = appendable;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f9103a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i10, int i11) throws IOException {
            this.f9103a.append(charSequence, i10, i11);
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i10) throws IOException {
            this.f9103a.append((char) i10);
        }

        @Override // java.io.Writer
        public void write(String str, int i10, int i11) throws IOException {
            Objects.requireNonNull(str);
            this.f9103a.append(str, i10, i11 + i10);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) throws IOException {
            this.f9104b.a(cArr);
            this.f9103a.append(this.f9104b, i10, i11 + i10);
        }
    }

    public static e9.k a(m9.a aVar) {
        boolean z10;
        try {
            try {
                aVar.l0();
                z10 = false;
                try {
                    return o.V.c(aVar);
                } catch (EOFException e10) {
                    e = e10;
                    if (z10) {
                        return e9.m.f7445a;
                    }
                    throw new s(e);
                }
            } catch (EOFException e11) {
                e = e11;
                z10 = true;
            }
        } catch (m9.d e12) {
            throw new s(e12);
        } catch (IOException e13) {
            throw new e9.l(e13);
        } catch (NumberFormatException e14) {
            throw new s(e14);
        }
    }

    public static void b(e9.k kVar, m9.c cVar) {
        o.V.e(cVar, kVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }
}
