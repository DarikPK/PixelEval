package pe.pixelstudio.pixelev.data.repositories

import pe.pixelstudio.pixelev.data.models.Cuestionario

interface CuestionarioRepository {
    fun guardarCuestionario(cuestionario: Cuestionario)
    fun obtenerCuestionario(id: String): Cuestionario?
    fun obtenerTodosLosCuestionarios(): List<Cuestionario>
}
