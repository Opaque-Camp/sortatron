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
        if (result.type == MaterialAliases.SORTATRON_CONFIGURATOR) {
            sortatronConfiguratorItemStackGenerator.modifyStack(result)
        }
    }
}
