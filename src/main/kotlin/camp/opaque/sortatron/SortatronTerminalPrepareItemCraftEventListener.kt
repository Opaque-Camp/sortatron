package camp.opaque.sortatron

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.PrepareItemCraftEvent

/**
 * Listens for the crafting of a Sortatron Terminal and modifies the result ItemStack to have properties of
 * the Sortatron Terminal using [SortatronTerminalItemStackGenerator].
 */
class SortatronTerminalPrepareItemCraftEventListener(
    private val sortatronTerminalItemStackGenerator: SortatronTerminalItemStackGenerator
) : Listener {
    @EventHandler
    fun onPrepareItemCraft(event: PrepareItemCraftEvent) {
        val result = event.inventory.result ?: return
        if (result.type == MaterialAliases.SORTATRON_TERMINAL) {
            sortatronTerminalItemStackGenerator.modifyStack(result)
        }
    }
}
