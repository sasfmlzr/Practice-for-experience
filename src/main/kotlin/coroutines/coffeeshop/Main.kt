package coroutines.coffeeshop

import example.Logger
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import threads.coffeeshop.CoffeeShop
import kotlin.system.measureTimeMillis


fun main(args: Array<String>) = runBlocking {

    val time = measureTimeMillis {
        coroutineScope {
            launch(CoroutineName("barista-1")) {
                makeCoffee("Espresso", "TwoMilk")
            }
            launch(CoroutineName("barista-2")) {
                makeCoffee("Cappucino", "OneMilk")

            }
        }
    }

    Logger.d("Finish", time.toString() + "ms")
}

private suspend fun makeCoffee(coffee: String, milk: String) {

    val coffeeShop = CoffeeShop()
    coffeeShop.makeCoffee(coffee, milk)


}

