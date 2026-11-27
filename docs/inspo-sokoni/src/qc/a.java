package qc;

import java.io.Serializable;
import lc.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements oc.e<Object>, e, Serializable {
    private final oc.e<Object> completion;

    public a(oc.e<Object> eVar) {
        this.completion = eVar;
    }

    public oc.e<q> create(Object obj, oc.e<?> completion) {
        kotlin.jvm.internal.k.e(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public oc.e<q> create(oc.e<?> completion) {
        kotlin.jvm.internal.k.e(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public e getCallerFrame() {
        oc.e<Object> eVar = this.completion;
        if (eVar instanceof e) {
            return (e) eVar;
        }
        return null;
    }

    public final oc.e<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    @Override // oc.e
    public final void resumeWith(Object obj) {
        oc.e<Object> eVar = this;
        while (true) {
            h.b(eVar);
            a aVar = (a) eVar;
            oc.e<Object> eVar2 = aVar.completion;
            kotlin.jvm.internal.k.b(eVar2);
            try {
                Object objInvokeSuspend = aVar.invokeSuspend(obj);
                if (objInvokeSuspend == pc.c.c()) {
                    return;
                } else {
                    obj = lc.j.b(objInvokeSuspend);
                }
            } catch (Throwable th) {
                lc.j.a aVar2 = lc.j.f12703b;
                obj = lc.j.b(lc.k.a(th));
            }
            aVar.releaseIntercepted();
            if (!(eVar2 instanceof a)) {
                eVar2.resumeWith(obj);
                return;
            }
            eVar = eVar2;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb2.append(stackTraceElement);
        return sb2.toString();
    }
}
