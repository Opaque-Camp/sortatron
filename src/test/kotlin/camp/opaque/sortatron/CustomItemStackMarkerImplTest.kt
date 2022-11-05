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

class CustomItemStackMarkerImplTest : StringSpec({
    "markItemStack() turns an Ender Chest into a Sortatron Accessor" {
        val itemStack = mockk<ItemStack>()
        val fakeItemMeta = mockk<ItemMeta>()
        val fakePersistentDataContainer = mockk<PersistentDataContainer>()
        every { itemStack.type } returns CustomMaterial.SORTATRON_CONFIGURATOR.material
        every { itemStack.itemMeta } returns fakeItemMeta
        every { itemStack.setItemMeta(any()) } returns true
        every { fakeItemMeta.persistentDataContainer } returns fakePersistentDataContainer
        justRun {
            fakePersistentDataContainer[namespacedKey("is_sortatron_configurator"), PersistentDataType.BYTE] = 1
        }
        justRun { fakeItemMeta.displayName(Component.text("Sortatron Configurator")) }

        CustomItemStackMarkerImpl(CustomMaterial.SORTATRON_CONFIGURATOR).markItemStack(itemStack)

        verify {
            fakePersistentDataContainer[namespacedKey("is_sortatron_configurator"), PersistentDataType.BYTE] = 1
        }
        verify { fakeItemMeta.displayName(Component.text("Sortatron Configurator")) }
        verify { itemStack.itemMeta = fakeItemMeta }
    }

    "markItemStack() throws an exception if the item stack type is not correct" {
        val itemStack = mockk<ItemStack>()
        every { itemStack.type } returns Material.DIRT

        shouldThrow<IllegalArgumentException> {
            CustomItemStackMarkerImpl(CustomMaterial.SORTATRON_CONFIGURATOR).markItemStack(itemStack)
        }
    }
})
