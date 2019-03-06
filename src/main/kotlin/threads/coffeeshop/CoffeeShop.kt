package threads.coffeeshop

import example.Logger
import kotlinx.coroutines.delay

class CoffeeShop {

    private val logger = Logger
    private val TAG = "CoffeeShop"

     fun makeCoffee(coffee: String, milk: String) {
        takeOrder(coffee, milk)
        grindCoffeeBeans(coffee)
        pullEspressoShot(coffee)
        steamMilk(milk)
        combibeForEspresso(coffee, milk)
        serveCappucino(coffee, milk)
    }

    private  fun takeOrder(coffee: String, milk: String) {
        Thread.sleep(300)
        logger.d("$coffee $milk $TAG", "takeOrder")
    }

    private  fun grindCoffeeBeans(coffee: String) {
        Thread.sleep(300)
        logger.d("$coffee $TAG", "grindCoffeeBeans")
    }

    private  fun pullEspressoShot(coffee: String) {
        Thread.sleep(300)
        logger.d("$coffee $TAG", "pullEspressoShot")
    }

    private  fun steamMilk(milk: String) {
        Thread.sleep(300)
        logger.d("$milk $TAG", "steamMilk")
    }

    private  fun combibeForEspresso(coffee: String, milk: String) {
        Thread.sleep(300)
        logger.d("$coffee $milk $TAG", "combibeForEspresso")
    }

    private  fun serveCappucino(coffee: String, milk: String) {
        Thread.sleep(300)
        logger.d("$coffee $milk $TAG", "serveCappucino")
    }
}