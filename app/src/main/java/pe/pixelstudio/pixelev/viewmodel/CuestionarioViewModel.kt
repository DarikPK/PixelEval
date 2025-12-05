package pe.pixelstudio.pixelev.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pe.pixelstudio.pixelev.data.models.CuestionarioState

class CuestionarioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CuestionarioState())
    val uiState = _uiState.asStateFlow()

    fun onTipoClienteChanged(tipoCliente: String) {
        _uiState.update { it.copy(tipoCliente = tipoCliente) }
    }

    fun onDniChanged(dni: String) {
        if (dni.length <= 8) {
            _uiState.update { it.copy(dniORuc = dni) }
        }
    }

    fun onRucChanged(ruc: String) {
        if (ruc.length <= 11 && ruc.startsWith("20")) {
            _uiState.update { it.copy(dniORuc = ruc) }
        }
    }
}
