import org.example.StringResult
import org.example.getString
import kotlin.random.Random



fun main() {
    when (val result = getString()) {
        is StringResult.Error -> println("There was an error")
        is StringResult.Success -> println(result.value)
    }
}

