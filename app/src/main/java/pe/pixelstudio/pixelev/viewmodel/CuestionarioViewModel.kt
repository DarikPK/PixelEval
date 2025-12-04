package pe.pixelstudio.pixelev.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pe.pixelstudio.pixelev.data.models.Cuestionario
import pe.pixelstudio.pixelev.data.models.TipoCliente
import java.util.Date
import java.util.UUID

class CuestionarioViewModel : ViewModel() {

    private val _cuestionarioState = MutableStateFlow<Cuestionario?>(null)
    val cuestionarioState: StateFlow<Cuestionario?> = _cuestionarioState

    fun iniciarNuevoCuestionario(tipoCliente: TipoCliente) {
        // Aquí se inicializaría un cuestionario vacío con valores por defecto
        // Por ahora, usamos datos de ejemplo
        _cuestionarioState.value = Cuestionario(
            id = UUID.randomUUID().toString(),
            identificacion = pe.pixelstudio.pixelev.data.models.Identificacion(
                tipoCliente = tipoCliente,
                numeroDocumento = "",
                nombreRazonSocial = "",
                giroNegocio = "",
                regimenTributario = "",
                tipoLocal = "",
                fotoLocalPath = null,
                fechaInicioActividades = Date(),
                direccion = pe.pixelstudio.pixelev.data.models.Direccion("", "", "", ""),
                telefono = "",
                correo = "",
                suministroLuzAgua = false,
                fotoSuministroPath = null
            ),
            persona = pe.pixelstudio.pixelev.data.models.Persona(
                nombreCompleto = "",
                documento = "",
                estadoCivil = pe.pixelstudio.pixelev.data.models.EstadoCivil.SOLTERO,
                conyuge = null,
                vivienda = pe.pixelstudio.pixelev.data.models.Vivienda(pe.pixelstudio.pixelev.data.models.TipoVivienda.PROPIA, 0.0),
                accionistas = if (tipoCliente == TipoCliente.PERSONA_JURIDICA) emptyList() else null,
                propiedades = emptyList(),
                correos = emptyList(),
                telefonos = emptyList()
            ),
            avales = emptyList(),
            detallesPrestamo = pe.pixelstudio.pixelev.data.models.DetallesPrestamo("", 0.0, 0),
            gastos = pe.pixelstudio.pixelev.data.models.Gastos(0.0, 0.0, 0.0, 0.0),
            activos = pe.pixelstudio.pixelev.data.models.Activos(0.0, 0.0, 0.0, emptyList(), 0.0, 0, 0, emptyList())
        )
    }

    // Aquí irían las funciones para actualizar cada campo del cuestionario
    // fun actualizarNombre(nombre: String) { ... }
    // fun actualizarMontoPrestamo(monto: Double) { ... }
}
