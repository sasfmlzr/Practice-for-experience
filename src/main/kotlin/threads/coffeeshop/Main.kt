package threads.coffeeshop

import example.Logger
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis


fun main(args: Array<String>) {

    val time = measureTimeMillis {
        val oneBarrista = Thread {
            makeCoffee("Espresso", "TwoMilk")
        }

        val twoBarrista = Thread {
            makeCoffee("Cappucino", "OneMilk")
        }

        val fixedPool = Executors.newFixedThreadPool(2)
        val oneTask = fixedPool.submit(oneBarrista)
        val twoTask= fixedPool.submit(twoBarrista)

        oneTask.get()
        twoTask.get()

        fixedPool.shutdown()
    }

    Logger.d("Finish", time.toString() + "ms")
}

private fun makeCoffee(coffee: String, milk: String) {
    val coffeeShop = CoffeeShop()
    coffeeShop.makeCoffee(coffee, milk)
}

