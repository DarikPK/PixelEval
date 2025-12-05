package pe.pixelstudio.pixelev.data.models

data class CuestionarioState(
    // Paso 1
    val tipoCliente: String = "",
    // Paso 2
    val dniORuc: String = "",
    // Paso 3
    val datosSunatConfirmados: Boolean = false,
    val razonSocial: String = "",
    // Paso 4
    val giroNegocio: String = "",
    // Paso 5
    val regimenTributario: String = "",
    // Paso 6
    val tipoLocal: String = "",
    val fotoContratoPath: String? = null,
    val fotoHrpuPath: String? = null,
    // Paso 7
    val fechaInicioActividades: String = "",
    // Paso 8
    val direccion: Direccion = Direccion(),
    // Paso 9
    val celular: String = "",
    val correo: String = "",
    // Paso 10
    val numeroSuministro: String = "",
    val fotoReciboPath: String? = null,
    // Sección Jurídica (Pasos 11-17)
    val personaJuridicaData: PersonaJuridicaData = PersonaJuridicaData(),
    // Sección Persona Natural
    val personaNaturalData: PersonaNaturalData = PersonaNaturalData(),
    // Detalles del Préstamo (Pasos 18-19)
    val prestamo: Prestamo = Prestamo(),
    // Gastos y Costos (Pasos 20-23)
    val gastos: Gastos = Gastos(),
    // Activos (Pasos 24-31)
    val activos: Activos = Activos()
)

data class Direccion(
    val tipoVia: String = "",
    val nombreVia: String = "",
    val numero: String = "",
    val interiorLoteManzana: String = "",
    val distrito: String = ""
)

data class PersonaJuridicaData(
    val dniRepresentante: String = "",
    val fotoDniRepresentantePath: String? = null,
    val estadoCivil: String = "",
    val dniConyuge: String = "",
    val domicilio: Domicilio = Domicilio(),
    val accionistas: List<Accionista> = emptyList(),
    val propiedadesSocios: PropiedadesSocios = PropiedadesSocios(),
    val telefonoPersonalRL: String = "",
    val correoPersonalRL: String = ""
)

data class Domicilio(
    val tipoVivienda: String = "",
    val direccion: String = "",
    val referencia: String = "",
    val aniosResidencia: Int = 0,
    val tienePropiedad: Boolean = false,
    val inscritaRegistros: Boolean = false,
    val sustentoPropiedadPath: String? = null
)

data class Accionista(
    val nombre: String = "",
    val dni: String = "",
    val participacion: Int = 0,
    val estadoCivil: String = "",
    val dniConyuge: String = ""
)

data class PropiedadesSocios(
    val tienenPropiedad: Boolean = false,
    val inscrita: Boolean = false,
    val sustentoPath: String? = null
)

data class PersonaNaturalData(
    val estadoCivil: String = "",
    val propiedades: Domicilio = Domicilio(),
    val avales: List<Aval> = emptyList()
)

data class Aval(
    val nombre: String = "",
    val dni: String = "",
    val estadoCivil: String = "",
    val propiedades: Domicilio = Domicilio()
)

data class Prestamo(
    val tipoProducto: String = "",
    val monto: Double = 0.0,
    val plazo: Int = 0,
    val cuotaConSeguro: Double = 0.0,
    val cuotaSinSeguro: Double = 0.0
)

data class Gastos(
    val alquiler: Double = 0.0,
    val serviciosBasicos: ServiciosBasicos = ServiciosBasicos(),
    val contador: Double = 0.0,
    val otrosGastos: List<Gasto> = emptyList()
)

data class ServiciosBasicos(
    val agua: Double = 0.0,
    val luz: Double = 0.0,
    val internet: Double = 0.0
)

data class Gasto(
    val nombre: String = "",
    val monto: Double = 0.0
)

data class Activos(
    val bancos: List<Banco> = emptyList(),
    val tieneCuentasPorCobrar: Boolean = false,
    val cuentasPorCobrar30dias: Double = 0.0,
    val cuentasPorCobrar60dias: Double = 0.0,
    val inventario: List<Producto> = emptyList(),
    val locales: List<Local> = emptyList(),
    val activosAdicionales: List<ActivoAdicional> = emptyList(),
    val trabajadores: Trabajadores = Trabajadores(),
    val diasLaborables: List<String> = emptyList(),
    val productosServicios: List<ProductoServicio> = emptyList()
)

data class Banco(
    val entidad: String = "",
    val tipoCuenta: String = "",
    val saldoAproximado: Double = 0.0
)

data class Producto(
    val nombre: String = "",
    val valor: Double = 0.0
)

data class Local(
    val direccion: String = "",
    val valorReferencial: Double = 0.0
)

data class ActivoAdicional(
    val nombre: String = ""
)

data class Trabajadores(
    val planillaCantidad: Int = 0,
    val planillaSueldo: Double = 0.0,
    val destajoCantidad: Int = 0,
    val destajoPromedio: Double = 0.0,
    val recibosHonorariosCantidad: Int = 0,
    val recibosHonorariosPromedio: Double = 0.0
)

data class ProductoServicio(
    val nombre: String = "",
    val costo: Double = 0.0,
    val precioVenta: Double = 0.0
)
