package android.os

/**
 * Stage 22 — a host-side stand-in for [android.os.Trace].
 *
 * The Compose runtime wraps every composition in a trace section. On the unit
 * test classpath the framework copy of `Trace` (layoutlib's) reaches for a
 * native method that only exists on a device, so a host-side composition dies
 * with an UnsatisfiedLinkError before it can count a single frame.
 *
 * This no-op keeps the runtime's tracing harmless off-device: the trace
 * sections become empty, the composition counts stay real.
 */
object Trace {

    @JvmStatic
    fun isEnabled(): Boolean = false

    @JvmStatic
    fun isTagEnabled(tag: String): Boolean = false

    @JvmStatic
    fun beginSection(sectionName: String) = Unit

    @JvmStatic
    fun endSection() = Unit

    @JvmStatic
    fun beginAsyncSection(sectionName: String, cookie: Int) = Unit

    @JvmStatic
    fun endAsyncSection(cookie: Int) = Unit

    @JvmStatic
    fun setCounter(counterName: String, value: Long) = Unit
}
