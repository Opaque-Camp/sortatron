package camp.opaque.sortatron

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.PrepareItemCraftEvent

class SortatronTerminalPrepareItemCraftEventListener(
    private val sortatronTerminalItemStackGenerator: SortatronTerminalItemStackGenerator
) : Listener {
    @EventHandler
    fun onPrepareItemCraft(event: PrepareItemCraftEvent) {
        val result = event.inventory.result ?: return
        if (result.type == Material.ENDER_CHEST) {
            sortatronTerminalItemStackGenerator.modifyStack(result)
        }
    }
}
