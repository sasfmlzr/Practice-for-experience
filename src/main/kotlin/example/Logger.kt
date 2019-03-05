package example

class Logger {

    companion object {
        fun d(tag: String, message: String){
            println("$tag: $message")
        }
    }
}