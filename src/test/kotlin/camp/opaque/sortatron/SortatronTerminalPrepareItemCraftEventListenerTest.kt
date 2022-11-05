package camp.opaque.sortatron

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.bukkit.Material
import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.bukkit.inventory.CraftingInventory
import org.bukkit.inventory.ItemStack

class SortatronTerminalPrepareItemCraftEventListenerTest : StringSpec({
    lateinit var result: ItemStack
    lateinit var craftingInventory: CraftingInventory
    lateinit var terminalGenerator: SortatronTerminalItemStackGenerator
    lateinit var event: PrepareItemCraftEvent
    lateinit var listener: SortatronTerminalPrepareItemCraftEventListener

    beforeAny {
        result = mockk()
        craftingInventory = mockk()
        every { craftingInventory.result } returns result
        terminalGenerator = mockk()
        event = mockk()
        every { event.inventory } returns craftingInventory

        listener = SortatronTerminalPrepareItemCraftEventListener(terminalGenerator)
    }

    """onPrepareItemCraft() should modify Ender Chest result to be Sortatron Terminal""" {
        every { result.type } returns MaterialAliases.SORTATRON_TERMINAL
        justRun { terminalGenerator.modifyStack(result) }

        listener.onPrepareItemCraft(event)

        verify { terminalGenerator.modifyStack(result) }
    }

    """onPrepareItemCraft() should not touch other results""" {
        every { result.type } returns Material.DIRT

        listener.onPrepareItemCraft(event)
    }
})
