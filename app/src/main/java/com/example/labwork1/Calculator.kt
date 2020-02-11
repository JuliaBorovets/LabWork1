package com.example.labwork1

import kotlin.math.pow

class Calculator {

    @Throws(ArithmeticException::class)
    fun calculateFirst(a: Double, b: Double, c: Double, d: Double): String {
        return if (d == 0.0) {
            "Неможливо обчислити!"
        } else {
            ((d * a).pow(b) + (b * c).pow(1 / d)).toString()
        }
    }

    @Throws(ArithmeticException::class)
    fun calculateSecond(x: Double, r: Double): String{
        return if (4*x == r*x){
            "Неможливо обчислити!"
        } else{
            ((4*r - r*x) / (4*x - r*x)).toString()
        }
    }


    @Throws(ArithmeticException::class)
    fun calculateThird(n: Double, p: Double): Double{
        var res = 0.0
        if (n < 0 || p < 0){
            print("Неможливо обчислити")
        } else{
            for (a in 0..n.toInt()){
                for (b in 0..p.toInt()){
                    res = a.toDouble().pow(b.toDouble()) + b.toDouble().pow(a.toDouble())
                }
            }
        }
        return res

    }

}

