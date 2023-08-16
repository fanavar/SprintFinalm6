package cl.awakelab.sprintfinalm6.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.awakelab.sprintfinalm6.data.local.PhoneDao
import cl.awakelab.sprintfinalm6.data.local.PhoneEntity
import cl.awakelab.sprintfinalm6.data.remote.PhoneAPI

class Repository(private val phoneAPI: PhoneAPI, private val phoneDao: PhoneDao) {
    fun getPhoneEntity(): LiveData<List<PhoneEntity>> = phoneDao.getPhones()
    suspend fun getPhones() {
        //en la siguiente línea llegan los datos
        val response = phoneAPI.getData()
        if (response.isSuccessful) {
            //se obtiene la lista de telefonos desde la respuesta
            val phones = response.body()
            if (phones != null) {
                val phoneEntities = phones.map { it.toPhoneEntity() }
                phoneDao.insertPhone(phoneEntities)
            }
            else{
                Log.e("repository", response.errorBody().toString())
            }
        }

    }
}

