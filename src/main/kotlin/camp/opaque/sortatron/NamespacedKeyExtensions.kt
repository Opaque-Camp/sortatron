package camp.opaque.sortatron

import org.bukkit.NamespacedKey

/**
 * Whether this key is a Sortatron identity key - that is a marker key that states that the item has a certain custom
 * Sortatron item type.
 *
 * @see CustomMaterial
 */
val NamespacedKey.isSortatronIdentityKey: Boolean
    get() = namespace == "sortatron" && key.startsWith("is_")
