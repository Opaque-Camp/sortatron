package camp.opaque.sortatron

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import org.bukkit.NamespacedKey
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

class IdentityPersistentDataCopierImplTest : StringSpec({
    "should copy Sortatron's identity persistent data keys and ignore other data" {
        val from = mockk<PersistentDataContainer>()
        every { from.keys } returns setOf(
            namespacedKey("is_foo"),
            namespacedKey("key"),
            NamespacedKey("other_plugin", "whatever")
        )
        val to = mockk<PersistentDataContainer>()
        justRun {
            to.set(
                match { it.namespace == "sortatron" && it.key.startsWith("is_") },
                ofType(PersistentDataType.BYTE::class),
                ofType(Byte::class)
            )
        }

        CustomItemMarkerKeyCopierImpl().copyIdentityPersistentData(from, to)

        verify { to.set(namespacedKey("is_foo"), PersistentDataType.BYTE, 1) }
    }
})
