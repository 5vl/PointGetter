package me.fivevl.pointgetter

import java.awt.Robot
import java.awt.event.KeyEvent
import kotlin.random.Random

object Main {
    private val r = Robot()
    @JvmStatic
    fun main(args: Array<String>) {
        for (i in 3 downTo 1) {
            println("Seconds left to destruction: $i")
            Thread.sleep(1000)
        }

        for (i in 1..34) {
            println("Searched for ${sendRandomText()}, iteration $i on 'PC' mode")
            Thread.sleep(1000)
        }
        r.keyPress(KeyEvent.VK_CONTROL)
        r.keyPress(KeyEvent.VK_SHIFT)
        r.keyPress(KeyEvent.VK_I)
        r.keyRelease(KeyEvent.VK_CONTROL)
        r.keyRelease(KeyEvent.VK_SHIFT)
        r.keyRelease(KeyEvent.VK_I)
        Thread.sleep(1000)
        for (i in 1..20) {
            println("Searched for ${sendRandomText()}, iteration $i on 'Phone' mode")
            Thread.sleep(1000)
        }
        println("Done!")
    }

    private fun sendRandomText(): String {
        val rand = Random.nextLong(10000000, 99999999).toString()
        r.keyPress(KeyEvent.VK_ALT)
        r.keyPress(KeyEvent.VK_D)
        r.keyRelease(KeyEvent.VK_ALT)
        r.keyRelease(KeyEvent.VK_D)
        Thread.sleep(100)
        for (j in rand.indices) {
            val k = when {
                rand[j] == '0' -> KeyEvent.VK_0
                rand[j] == '1' -> KeyEvent.VK_1
                rand[j] == '2' -> KeyEvent.VK_2
                rand[j] == '3' -> KeyEvent.VK_3
                rand[j] == '4' -> KeyEvent.VK_4
                rand[j] == '5' -> KeyEvent.VK_5
                rand[j] == '6' -> KeyEvent.VK_6
                rand[j] == '7' -> KeyEvent.VK_7
                rand[j] == '8' -> KeyEvent.VK_8
                rand[j] == '9' -> KeyEvent.VK_9
                else -> 0
            }
            r.keyPress(k)
            r.keyRelease(k)
        }
        Thread.sleep(100)
        r.keyPress(KeyEvent.VK_ENTER)
        r.keyRelease(KeyEvent.VK_ENTER)
        return rand
    }
}
