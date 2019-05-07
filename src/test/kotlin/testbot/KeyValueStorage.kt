package testbot

interface KeyValueStorage {
    fun putBoolean(key: String, value: Boolean)
    fun getBoolean(key: String): Boolean?
}