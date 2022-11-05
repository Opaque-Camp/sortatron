package camp.opaque.sortatron

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataContainer

class ItemStackExtensionsTest : StringSpec({
    "isCustomItemOfType returns true for an item stack with the same custom item marker key" {
        val itemStack = mockk<ItemStack>()
        val itemMeta = mockk<ItemMeta>()
        every { itemStack.itemMeta } returns itemMeta
        val persistentDataContainer = mockk<PersistentDataContainer>()
        every { itemStack.itemMeta.persistentDataContainer } returns persistentDataContainer
        every { persistentDataContainer.has(CustomItem.SORTATRON_CONFIGURATOR.customItemMarkerKey) } returns true

        itemStack.isCustomItemOfType(CustomItem.SORTATRON_CONFIGURATOR) shouldBe true
    }
})
