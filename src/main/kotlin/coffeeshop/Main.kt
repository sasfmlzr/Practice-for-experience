package coffeeshop

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking {


            launch(CoroutineName("barista-1")) {
                makeCoffee("Espresso", "TwoMilk")
            }
            launch(CoroutineName("barista-2")) {
                makeCoffee("Cappucino", "OneMilk")
            }
            Unit
        }

        private suspend fun makeCoffee(coffee: String, milk: String){
            val coffeeShop = CoffeeShop()
            coffeeShop.makeCoffee(coffee, milk)
        }
    }
}