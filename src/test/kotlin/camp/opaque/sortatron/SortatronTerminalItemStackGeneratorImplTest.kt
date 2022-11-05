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

class SortatronConfiguratorItemStackGeneratorImplTest : StringSpec({
    "generate() creates a new Sortatron Configurator item" {
        val itemStack = mockk<ItemStack>()
        val fakeItemMeta = mockk<ItemMeta>()
        val fakePersistentDataContainer = mockk<PersistentDataContainer>()
        every { itemStack.type } returns MaterialAliases.SORTATRON_CONFIGURATOR
        every { itemStack.itemMeta } returns fakeItemMeta
        every { itemStack.setItemMeta(any()) } returns true
        every { fakeItemMeta.persistentDataContainer } returns fakePersistentDataContainer
        justRun {
            fakePersistentDataContainer[namespacedKey("is_sortatron_configurator"), PersistentDataType.BYTE] = 1
        }
        justRun { fakeItemMeta.displayName(Component.text("Sortatron Configurator")) }

        SortatronConfiguratorItemStackGeneratorImpl().modifyStack(itemStack)

        verify {
            fakePersistentDataContainer[namespacedKey("is_sortatron_configurator"), PersistentDataType.BYTE] = 1
        }
        verify { fakeItemMeta.displayName(Component.text("Sortatron Configurator")) }
        verify { itemStack.itemMeta = fakeItemMeta }
    }

    "generate() throws an exception if the item stack type is not correct" {
        val itemStack = mockk<ItemStack>()
        every { itemStack.type } returns Material.DIRT

        shouldThrow<IllegalArgumentException> { SortatronConfiguratorItemStackGeneratorImpl().modifyStack(itemStack) }
    }
})
