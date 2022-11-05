package camp.opaque.sortatron

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.PrepareItemCraftEvent

/**
 * Listens for the crafting of a Sortatron Configurator and modifies the result ItemStack to have properties of
 * the Sortatron Configurator using [SortatronConfiguratorItemStackGenerator].
 */
class SortatronConfiguratorPrepareItemCraftEventListener(
    private val sortatronConfiguratorItemStackGenerator: SortatronConfiguratorItemStackGenerator
) : Listener {
    @EventHandler
    fun onPrepareItemCraft(event: PrepareItemCraftEvent) {
        val result = event.inventory.result ?: return
        // We can omit checking for the recipe layout because the Command Block is not craftable in vanilla.
        if (result.type == CustomMaterial.SORTATRON_CONFIGURATOR.material) {
            sortatronConfiguratorItemStackGenerator.modifyStack(result)
        }
    }
}
