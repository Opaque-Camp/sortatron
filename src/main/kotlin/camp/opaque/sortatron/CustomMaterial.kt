package camp.opaque.sortatron

import org.bukkit.Material
import org.bukkit.Material.ENDER_CHEST

/**
 * Aliases for [Material] values that our special blocks and items use.
 * Since there is no way to register custom materials, we have to use existing ones and add persistent data values to
 * them in order to distinguish them from other items, for example, a Sortatron Configurator from a Command Block.
 */
enum class CustomMaterial(val humanName: String, val originalMaterial: Material) {
    SORTATRON_CONFIGURATOR("Sortatron Configurator", ENDER_CHEST),
    SORTATRON_ACCESSOR("Sortatron Accessor", ENDER_CHEST);

    /**
     * Key for crafting recipe of this item.
     */
    val recipeKey get() = namespacedKey(name.lowercase())

    /**
     * [org.bukkit.NamespacedKey] for telling the custom items apart from vanilla items of the same material,
     * for example, a Sortatron Accessor from a regular Ender Chest.
     * This key is used in custom [org.bukkit.persistence.PersistentDataContainer]'s
     * [PersistentDataContainer][org.bukkit.persistence.PersistentDataContainer].
     * Custom items have this key in their data container, while vanilla items of the same material do not.
     */
    val identityKey get() = namespacedKey("is_${name.lowercase()}")

    companion object {
        val enderChestBackedMaterials get() = values().filter { it.originalMaterial == ENDER_CHEST }
    }
}
