import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.*

fun main() : Unit = runBlocking {
    launch {
        println("Hello coroutines")
    }

}

