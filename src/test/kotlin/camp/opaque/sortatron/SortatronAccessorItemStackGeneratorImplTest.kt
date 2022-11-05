package camp.opaque.sortatron

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

class SortatronAccessorItemStackGeneratorImplTest : StringSpec({
    "modifyStack() turns an Ender Chest into a Sortatron Accessor" {
        val itemStack = mockk<ItemStack>()
        val fakeItemMeta = mockk<ItemMeta>()
        val fakePersistentDataContainer = mockk<PersistentDataContainer>()
        every { itemStack.type } returns MaterialAliases.SORTATRON_ACCESSOR
        every { itemStack.itemMeta } returns fakeItemMeta
        every { itemStack.setItemMeta(any()) } returns true
        every { fakeItemMeta.persistentDataContainer } returns fakePersistentDataContainer
        justRun {
            fakePersistentDataContainer[namespacedKey("is_sortatron_accessor"), PersistentDataType.BYTE] = 1
        }
        justRun { fakeItemMeta.displayName(Component.text("Sortatron Accessor")) }

        SortatronAccessorItemStackGeneratorImpl().modifyStack(itemStack)

        verify {
            fakePersistentDataContainer[namespacedKey("is_sortatron_accessor"), PersistentDataType.BYTE] = 1
        }
        verify { fakeItemMeta.displayName(Component.text("Sortatron Accessor")) }
        verify { itemStack.itemMeta = fakeItemMeta }
    }

    "modifyStack() throws an exception if the item stack type is not correct" {
        val itemStack = mockk<ItemStack>()
        every { itemStack.type } returns Material.DIRT

        shouldThrow<IllegalArgumentException> { SortatronAccessorItemStackGeneratorImpl().modifyStack(itemStack) }
    }
})
