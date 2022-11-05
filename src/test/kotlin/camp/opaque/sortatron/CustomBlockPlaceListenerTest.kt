package camp.opaque.sortatron

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.bukkit.block.Block
import org.bukkit.block.TileState
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataContainer

class CustomBlockPlaceListenerTest : StringSpec({
    "should copy custom item marker keys to placed blocks with tile states" {
        val event = mockk<BlockPlaceEvent>()
        val itemInHand = mockk<ItemStack>()
        every { event.itemInHand } returns itemInHand
        val itemMeta = mockk<ItemMeta>()
        every { itemInHand.itemMeta } returns itemMeta
        val itemPersistentDataContainer = mockk<PersistentDataContainer>()
        every { itemMeta.persistentDataContainer } returns itemPersistentDataContainer

        val block = mockk<Block>()
        every { event.block } returns block
        val blockState = mockk<TileState>()
        every { block.state } returns blockState
        val blockPersistentDataContainer = mockk<PersistentDataContainer>()
        every { blockState.persistentDataContainer } returns blockPersistentDataContainer

        val customItemMarkerKeyCopier = mockk<CustomItemMarkerKeyCopier>()
        justRun { customItemMarkerKeyCopier.copyIdentityPersistentData(any(), any()) }
        val customBlockPlaceListener = CustomBlockPlaceListener(customItemMarkerKeyCopier)

        customBlockPlaceListener.onCustomEnderChestPlace(event)

        verify {
            customItemMarkerKeyCopier.copyIdentityPersistentData(
                itemPersistentDataContainer,
                blockPersistentDataContainer
            )
        }
    }
})
