package camp.opaque.sortatron

import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.util.logging.Logger

class SortatronLoggerTest : StringSpec({
    """info() should log the message and prepend "[Sortatron]" to it""" {
        val underlyingLogger = mockk<Logger>()
        every { underlyingLogger.info(ofType(String::class)) } returns Unit

        val logger = SortatronLogger(underlyingLogger)
        logger.info("Hello")

        verify { underlyingLogger.info("[Sortatron] Hello") }
    }
})
