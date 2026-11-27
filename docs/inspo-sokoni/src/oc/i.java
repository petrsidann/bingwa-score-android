package oc;

import kotlin.jvm.internal.k;
import xc.p;

/* JADX INFO: loaded from: classes2.dex */
public interface i {

    public static final class a {
        public static i b(i iVar, i context) {
            k.e(context, "context");
            return context == j.f13812a ? iVar : (i) context.fold(iVar, new p() { // from class: oc.h
                @Override // xc.p
                public final Object invoke(Object obj, Object obj2) {
                    return i.a.c((i) obj, (i.b) obj2);
                }
            });
        }

        public static i c(i acc, b element) {
            d dVar;
            k.e(acc, "acc");
            k.e(element, "element");
            i iVarMinusKey = acc.minusKey(element.getKey());
            j jVar = j.f13812a;
            if (iVarMinusKey == jVar) {
                return element;
            }
            f.b bVar = f.f13810k;
            f fVar = (f) iVarMinusKey.get(bVar);
            if (fVar == null) {
                dVar = new d(iVarMinusKey, element);
            } else {
                i iVarMinusKey2 = iVarMinusKey.minusKey(bVar);
                if (iVarMinusKey2 == jVar) {
                    return new d(element, fVar);
                }
                dVar = new d(new d(iVarMinusKey2, element), fVar);
            }
            return dVar;
        }
    }

    public interface b extends i {

        public static final class a {
            public static <R> R a(b bVar, R r10, p<? super R, ? super b, ? extends R> operation) {
                k.e(operation, "operation");
                return operation.invoke(r10, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> key) {
                k.e(key, "key");
                if (!k.a(bVar.getKey(), key)) {
                    return null;
                }
                k.c(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static i c(b bVar, c<?> key) {
                k.e(key, "key");
                return k.a(bVar.getKey(), key) ? j.f13812a : bVar;
            }

            public static i d(b bVar, i context) {
                k.e(context, "context");
                return a.b(bVar, context);
            }
        }

        @Override // oc.i
        <R> R fold(R r10, p<? super R, ? super b, ? extends R> pVar);

        @Override // oc.i
        <E extends b> E get(c<E> cVar);

        c<?> getKey();

        @Override // oc.i
        i minusKey(c<?> cVar);
    }

    public interface c<E extends b> {
    }

    <R> R fold(R r10, p<? super R, ? super b, ? extends R> pVar);

    <E extends b> E get(c<E> cVar);

    i minusKey(c<?> cVar);

    i plus(i iVar);
}
