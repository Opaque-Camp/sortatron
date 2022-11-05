package camp.opaque.sortatron

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.bukkit.inventory.ShapedRecipe

/**
 * Listens for the crafting of Sortatron custom items and modifies the result ItemStack to have properties of
 * the corresponding item using [CustomItemStackMarker].
 */
class PrepareCustomItemCraftEventListener(private val customItemStackMarker: CustomItemStackMarker) : Listener {
    @EventHandler
    fun onPrepareItemCraft(event: PrepareItemCraftEvent) {
        val recipeKey = (event.recipe as? ShapedRecipe)?.key ?: return
        val customMaterialWithKey = CustomMaterial.values().find { it.recipeKey == recipeKey } ?: return
        customItemStackMarker.markItemStack(customMaterialWithKey, event.inventory.result ?: return)
    }
}
