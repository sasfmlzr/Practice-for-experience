package testbot

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class SettingsStorage constructor(private val pref: KeyValueStorage) {
    fun isTest() = pref.getBoolean("test") ?: false

    fun putTest(value: Boolean) {
        val job = SupervisorJob()
        val scope = CoroutineScope(Dispatchers.Default + job)

        scope.launch {
            pref.putBoolean("test", value)
        }
    }
}

