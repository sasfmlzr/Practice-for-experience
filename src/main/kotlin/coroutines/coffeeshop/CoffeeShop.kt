package coroutines.coffeeshop

import example.Logger
import kotlinx.coroutines.delay

class CoffeeShop {

    private val logger = Logger
    private val TAG = "CoffeeShop"

    suspend fun makeCoffee(coffee: String, milk: String) {
        takeOrder(coffee, milk)
        grindCoffeeBeans(coffee)
        pullEspressoShot(coffee)
        steamMilk(milk)
        combibeForEspresso(coffee, milk)
        serveCappucino(coffee, milk)
    }

    private suspend fun takeOrder(coffee: String, milk: String) {
        delay(300)
        logger.d("$coffee $milk $TAG", "takeOrder")
    }

    private suspend fun grindCoffeeBeans(coffee: String) {
        delay(300)
        logger.d("$coffee $TAG", "grindCoffeeBeans")
    }

    private suspend fun pullEspressoShot(coffee: String) {
        delay(300)
        logger.d("$coffee $TAG", "pullEspressoShot")
    }

    private suspend fun steamMilk(milk: String) {
        delay(300)
        logger.d("$milk $TAG", "steamMilk")
    }

    private suspend fun combibeForEspresso(coffee: String, milk: String) {
        delay(300)
        logger.d("$coffee $milk $TAG", "combibeForEspresso")
    }

    private suspend fun serveCappucino(coffee: String, milk: String) {
        delay(300)
        logger.d("$coffee $milk $TAG", "serveCappucino")
    }
}