package camp.opaque.sortatron

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.bukkit.inventory.ShapedRecipe

/**
 * Listens for the crafting of a Sortatron Accessor and modifies the result ItemStack to have properties of
 * the Sortatron Accessor using [SortatronAccessorItemStackGenerator].
 */
class SortatronAccessorPrepareItemCraftEventListener(
    private val sortatronAccessorItemStackGenerator: CustomItemStackMarker
) : Listener {
    @EventHandler
    fun onPrepareItemCraft(event: PrepareItemCraftEvent) {
        val recipeKey = (event.recipe as? ShapedRecipe)?.key ?: return
        if (recipeKey.key == CustomMaterial.SORTATRON_ACCESSOR.name.lowercase()) {
            sortatronAccessorItemStackGenerator.markItemStack(event.inventory.result ?: return)
        }
    }
}
