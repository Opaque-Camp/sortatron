package camp.opaque.sortatron

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.bukkit.inventory.CraftingInventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.ShapedRecipe

class PrepareCustomItemCraftEventListenerTest : StringSpec({
    lateinit var result: ItemStack
    lateinit var recipe: ShapedRecipe
    lateinit var craftingInventory: CraftingInventory
    lateinit var accessorGenerator: CustomItemStackMarker
    lateinit var event: PrepareItemCraftEvent
    lateinit var listener: PrepareCustomItemCraftEventListener

    beforeAny {
        recipe = mockk()
        craftingInventory = mockk()
        result = mockk()
        every { craftingInventory.result } returns result
        event = mockk()
        every { event.recipe } returns recipe
        every { event.inventory } returns craftingInventory
        accessorGenerator = mockk()

        listener = PrepareCustomItemCraftEventListener(accessorGenerator)
    }

    """onPrepareItemCraft() should modify Ender Chest result to be Sortatron Accessor""" {
        every { recipe.key } returns CustomMaterial.SORTATRON_ACCESSOR.recipeKey
        justRun { accessorGenerator.markItemStack(any(), result) }

        listener.onPrepareItemCraft(event)

        verify { accessorGenerator.markItemStack(CustomMaterial.SORTATRON_ACCESSOR, result) }
    }

    """onPrepareItemCraft() should not touch other results""" {
        every { recipe.key } returns namespacedKey("something_else")

        listener.onPrepareItemCraft(event)
    }
})
