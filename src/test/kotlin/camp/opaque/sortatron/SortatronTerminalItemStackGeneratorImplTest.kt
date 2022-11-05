package camp.opaque.sortatron

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

class SortatronTerminalItemStackGeneratorImplTest : StringSpec({
    "generate() creates a new Sortatron Terminal item" {
        val itemStack = mockk<ItemStack>()
        val fakeItemMeta = mockk<ItemMeta>()
        val fakePersistentDataContainer = mockk<PersistentDataContainer>()
        every { itemStack.itemMeta } returns fakeItemMeta
        every { itemStack.setItemMeta(any()) } returns true
        every { fakeItemMeta.persistentDataContainer } returns fakePersistentDataContainer
        justRun {
            fakePersistentDataContainer[namespacedKey("is_sortatron_terminal"), PersistentDataType.BYTE] = 1
        }
        justRun { fakeItemMeta.displayName(Component.text("Sortatron Terminal")) }

        SortatronTerminalItemStackGeneratorImpl().modifyStack(itemStack)

        verify {
            fakePersistentDataContainer[namespacedKey("is_sortatron_terminal"), PersistentDataType.BYTE] = 1
        }
        verify { fakeItemMeta.displayName(Component.text("Sortatron Terminal")) }
        verify { itemStack.itemMeta = fakeItemMeta }
    }
})
