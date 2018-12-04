package aksamedia.com.tugasaksa4_saiful.api

import java.net.URL

class ApiRepository{
    fun lakukanRequest(url: String): String {
        return URL(url).readText()
    }
}
