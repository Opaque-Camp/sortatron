package camp.opaque.sortatron

import org.bukkit.block.EnderChest
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.inventory.ItemStack

class CustomEnderChestPlaceListener(private val customItemMarkerKeyCopier: CustomItemMarkerKeyCopier) : Listener {
    @EventHandler
    fun onCustomEnderChestPlace(event: BlockPlaceEvent) {
        if (!isCustomEnderChest(event.itemInHand)) {
            customItemMarkerKeyCopier.copyIdentityPersistentData(
                event.itemInHand.itemMeta.persistentDataContainer,
                (event.block.state as EnderChest).persistentDataContainer
            )
        }
    }

    private fun isCustomEnderChest(item: ItemStack) =
        CustomItem.enderChestBackedMaterials.any(item::isCustomItemOfType)
}
