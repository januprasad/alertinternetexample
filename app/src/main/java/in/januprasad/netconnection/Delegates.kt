package `in`.januprasad.netconnection

import kotlin.reflect.KProperty

/**
 * Created by januprasad on 18,February,2019
 */

object Delegates {
    fun <T> singleValue() = SingleInstance<T>()
}

class SingleInstance<T> {

    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
            value ?: throw IllegalStateException("${property.name} not initialized")

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = value
    }

}