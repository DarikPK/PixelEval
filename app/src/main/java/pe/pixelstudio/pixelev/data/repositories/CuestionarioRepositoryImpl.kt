package pe.pixelstudio.pixelev.data.repositories

import pe.pixelstudio.pixelev.data.models.Cuestionario

class CuestionarioRepositoryImpl : CuestionarioRepository {

    private val cuestionarios = mutableListOf<Cuestionario>()

    override fun guardarCuestionario(cuestionario: Cuestionario) {
        cuestionarios.add(cuestionario)
    }

    override fun obtenerCuestionario(id: String): Cuestionario? {
        return cuestionarios.find { it.id == id }
    }

    override fun obtenerTodosLosCuestionarios(): List<Cuestionario> {
        return cuestionarios
    }
}
