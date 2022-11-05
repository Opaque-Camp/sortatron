package camp.opaque.sortatron

import org.bukkit.block.TileState
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

class CustomBlockPlaceListener(private val customItemMarkerKeyCopier: CustomItemMarkerKeyCopier) : Listener {
    @EventHandler
    fun onCustomEnderChestPlace(event: BlockPlaceEvent) {
        customItemMarkerKeyCopier.copyIdentityPersistentData(
            event.itemInHand.itemMeta.persistentDataContainer,
            (event.block.state as? TileState)?.persistentDataContainer ?: return
        )
    }
}
