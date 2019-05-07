package testbot

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SettingsStorageTest {

    @InjectMocks
    lateinit var settingsStorage: SettingsStorage

    @Mock
    lateinit var keyValueStorage: KeyValueStorage

    private val testException = RuntimeException("test")

    @Test
    fun WhewTestWasWrong () {
        Mockito.`when`(keyValueStorage.putBoolean("test",true)).thenThrow(testException)

        runBlocking {
            settingsStorage.putTest(true)
        }

        try {
            Mockito.verify(settingsStorage).putTest(true)
        }catch (e: Exception) {
            Assert.assertEquals(testException, e)
        }
    }
}