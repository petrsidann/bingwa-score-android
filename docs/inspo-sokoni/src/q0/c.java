package q0;

import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    public static class a {
        public static boolean a(AccessibilityManager accessibilityManager, b bVar) {
            return accessibilityManager.addTouchExplorationStateChangeListener(new AccessibilityManagerTouchExplorationStateChangeListenerC0256c(bVar));
        }

        public static boolean b(AccessibilityManager accessibilityManager, b bVar) {
            return accessibilityManager.removeTouchExplorationStateChangeListener(new AccessibilityManagerTouchExplorationStateChangeListenerC0256c(bVar));
        }
    }

    public interface b {
        void onTouchExplorationStateChanged(boolean z10);
    }

    /* JADX INFO: renamed from: q0.c$c, reason: collision with other inner class name */
    public static final class AccessibilityManagerTouchExplorationStateChangeListenerC0256c implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f14576a;

        public AccessibilityManagerTouchExplorationStateChangeListenerC0256c(b bVar) {
            this.f14576a = bVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AccessibilityManagerTouchExplorationStateChangeListenerC0256c) {
                return this.f14576a.equals(((AccessibilityManagerTouchExplorationStateChangeListenerC0256c) obj).f14576a);
            }
            return false;
        }

        public int hashCode() {
            return this.f14576a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z10) {
            this.f14576a.onTouchExplorationStateChanged(z10);
        }
    }

    public static boolean a(AccessibilityManager accessibilityManager, b bVar) {
        return a.a(accessibilityManager, bVar);
    }

    public static boolean b(AccessibilityManager accessibilityManager, b bVar) {
        return a.b(accessibilityManager, bVar);
    }
}
