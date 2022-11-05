package camp.opaque.sortatron

import org.bukkit.NamespacedKey

/**
 * Whether this key states that the item has a certain custom Sortatron item type.
 * @see CustomItem
 */
val NamespacedKey.isSortatronCustomItemMarkerKey: Boolean
    get() = namespace == "sortatron" && key.startsWith("is_")
