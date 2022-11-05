package camp.opaque.sortatron

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CustomMaterialTest : StringSpec({
    "recipeKey returns a lowercase constant name" {
        CustomMaterial.SORTATRON_CONFIGURATOR.recipeKey shouldBe namespacedKey("sortatron_configurator")
    }
})