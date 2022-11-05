package camp.opaque.sortatron

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
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

class SortatronTerminalItemStackGeneratorImplTest : StringSpec({
    "generate() creates a new Sortatron Terminal item" {
        val itemStackFactory = mockk<ItemStackFactory>()
        val fakeItemStack = mockk<ItemStack>()
        val fakeItemMeta = mockk<ItemMeta>()
        val fakePersistentDataContainer = mockk<PersistentDataContainer>()
        every { itemStackFactory.create(Material.COMMAND_BLOCK) } returns fakeItemStack
        every { fakeItemStack.itemMeta } returns fakeItemMeta
        every { fakeItemMeta.persistentDataContainer } returns fakePersistentDataContainer
        val generator = SortatronTerminalItemStackGeneratorImpl(itemStackFactory)
        justRun {
            fakePersistentDataContainer[namespacedKey("is_sortatron_terminal"), PersistentDataType.BYTE] = 1
        }
        justRun { fakeItemMeta.displayName(Component.text("Sortatron Terminal")) }

        val itemStack = generator.generate()

        itemStack shouldBe fakeItemStack
        verify {
            fakePersistentDataContainer[namespacedKey("is_sortatron_terminal"), PersistentDataType.BYTE] = 1
        }
        verify { fakeItemMeta.displayName(Component.text("Sortatron Terminal")) }
    }
})
