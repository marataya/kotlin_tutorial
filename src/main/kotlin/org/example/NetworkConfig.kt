package org.example


object NetworkConfig : NetworkInfoProvider {
    val baseUrl = "http://someurl.com"
    val userAgent = "chrome"
    override fun getNetworkDetails(): Unit {
        println("$baseUrl = $userAgent")
    }

}
