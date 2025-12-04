package pe.pixelstudio.pixelev.data.models

import java.util.Date

// Modelo principal que agrupa toda la información del cuestionario
data class Cuestionario(
    val id: String,
    val identificacion: Identificacion,
    val persona: Persona, // Puede ser Natural o Jurídica
    val avales: List<Persona>,
    val detallesPrestamo: DetallesPrestamo,
    val gastos: Gastos,
    val activos: Activos,
    val fechaCreacion: Date = Date()
)

// Sección: IDENTIFICACIÓN
data class Identificacion(
    val tipoCliente: TipoCliente,
    val numeroDocumento: String, // RUC o DNI
    val nombreRazonSocial: String,
    val giroNegocio: String,
    val regimenTributario: String,
    val tipoLocal: String,
    val fotoLocalPath: String?,
    val fechaInicioActividades: Date,
    val direccion: Direccion,
    val telefono: String,
    val correo: String,
    val suministroLuzAgua: Boolean,
    val fotoSuministroPath: String?
)

// Sección: PERSONA (Natural, Jurídica, Representante, Cónyuge, Aval)
data class Persona(
    val nombreCompleto: String,
    val documento: String,
    val estadoCivil: EstadoCivil,
    val conyuge: Persona?,
    val vivienda: Vivienda,
    val accionistas: List<Persona>?, // Solo para Persona Jurídica
    val propiedades: List<Propiedad>,
    val correos: List<String>,
    val telefonos: List<String>
)

// Sección: DETALLES DEL PRÉSTAMO
data class DetallesPrestamo(
    val tipoProducto: String,
    val monto: Double,
    val plazo: Int // en meses
)

// Sección: GASTOS
data class Gastos(
    val alquiler: Double,
    val servicios: Double,
    val contador: Double,
    val gastosExtra: Double
)

// Sección: ACTIVOS
data class Activos(
    val saldoBancos: Double,
    val cuentasPorCobrar: Double,
    val valorInventario: Double,
    val locales: List<Propiedad>,
    val otrosActivos: Double,
    val numeroTrabajadores: Int,
    val diasLaborablesSemana: Int,
    val principalesProductosServicios: List<String>
)

// --- Modelos de soporte ---

data class Direccion(
    val direccionCompleta: String,
    val distrito: String,
    val provincia: String,
    val departamento: String
)

data class Propiedad(
    val descripcion: String,
    val valorEstimado: Double
)

data class Vivienda(
    val tipoVivienda: TipoVivienda,
    val valorEstimado: Double
)

enum class TipoCliente {
    PERSONA_NATURAL,
    PERSONA_JURIDICA
}

enum class EstadoCivil {
    SOLTERO,
    CASADO,
    VIUDO,
    DIVORCIADO
}

enum class TipoVivienda {
    PROPIA,
    ALQUILADA,
    FAMILIAR
}
