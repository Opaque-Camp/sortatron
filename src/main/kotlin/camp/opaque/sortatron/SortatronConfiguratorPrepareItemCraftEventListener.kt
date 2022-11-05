package camp.opaque.sortatron

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.bukkit.inventory.ShapedRecipe

/**
 * Listens for the crafting of a Sortatron Configurator and modifies the result ItemStack to have properties of
 * the Sortatron Configurator using [SortatronConfiguratorItemStackGenerator].
 */
class SortatronConfiguratorPrepareItemCraftEventListener(
    private val sortatronConfiguratorItemStackGenerator: SortatronConfiguratorItemStackGenerator
) : Listener {
    @EventHandler
    fun onPrepareItemCraft(event: PrepareItemCraftEvent) {
        val recipeKey = (event.recipe as? ShapedRecipe)?.key ?: return
        if (recipeKey.key == CustomMaterial.SORTATRON_CONFIGURATOR.name.lowercase()) {
            sortatronConfiguratorItemStackGenerator.modifyStack(event.inventory.result ?: return)
        }
    }
}
