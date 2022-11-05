package camp.opaque.sortatron

import org.bukkit.NamespacedKey

/** Creates a [NamespacedKey] with Sortatron's namespace and a specified name. */
fun namespacedKey(name: String) = NamespacedKey(SortatronPlugin.NAMESPACE, name)
