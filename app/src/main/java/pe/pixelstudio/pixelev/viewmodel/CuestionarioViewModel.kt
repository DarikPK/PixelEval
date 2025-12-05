package pe.pixelstudio.pixelev.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import pe.pixelstudio.pixelev.data.models.CuestionarioState

class CuestionarioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CuestionarioState())
    val uiState = _uiState.asStateFlow()

    // Aquí irán todas las funciones para actualizar el estado del cuestionario
    // Ejemplo: fun onTipoClienteChanged(tipoCliente: String) { ... }
}
