package aksamedia.com.tugasaksa4_saiful.api

import java.net.URL

class ApiRepository{
    fun lakukanRequest1(url: String): String {
        return URL(url).readText()
    }
    fun lakukanRequest2(url: String): String {
        return URL(url).readText()
    }
}
