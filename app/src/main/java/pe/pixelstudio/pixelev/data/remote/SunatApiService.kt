package pe.pixelstudio.pixelev.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface SunatApiService {
    @GET("ruc")
    suspend fun getRucData(@Query("numero") ruc: String): RucData

    @GET("dni")
    suspend fun getDniData(@Query("numero") dni: String): DniData
}

data class RucData(
    val nombre: String?,
    val numeroDocumento: String?,
    val estado: String?,
    val condicion: String?,
    val direccion: String?,
    val ubigeo: String?,
    val distrito: String?,
)

data class DniData(
    val nombre: String?,
    val numeroDocumento: String?,
    val apellidoPaterno: String?,
    val apellidoMaterno: String?,
    val nombres: String?,
)
