package main.kotlin.coffeeshop

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val coffeeShop = CoffeeShop()

            coffeeShop.takeOrder()
            coffeeShop.grindCoffeeBeans()
            coffeeShop.pullEspressoShot()
            coffeeShop.steamMilk()
            coffeeShop.combibeForEspresso()
            coffeeShop.serveCappucino()
        }
    }
}