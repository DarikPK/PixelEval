package pe.pixelstudio.pixelev.pdf.generator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Environment
import pe.pixelstudio.pixelev.data.models.Cuestionario
import java.io.File
import java.io.FileOutputStream

object PdfGenerator {

    fun generarPdf(context: Context, cuestionario: Cuestionario): String {
        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create() // A4 size
        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas

        dibujarContenido(canvas, cuestionario)

        pdfDocument.finishPage(page)

        val file = File(
            context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),
            "Cuestionario-${cuestionario.id}.pdf"
        )
        pdfDocument.writeTo(FileOutputStream(file))
        pdfDocument.close()

        return file.absolutePath
    }

    private fun dibujarContenido(canvas: Canvas, cuestionario: Cuestionario) {
        val paint = Paint()
        paint.color = Color.BLACK
        paint.textSize = 12f

        var yPosition = 50f

        // Título
        paint.textSize = 18f
        paint.isFakeBoldText = true
        canvas.drawText("Cuestionario PixelEval", 50f, yPosition, paint)
        yPosition += 40

        // Sección Identificación
        paint.textSize = 14f
        paint.isFakeBoldText = true
        canvas.drawText("Identificación", 50f, yPosition, paint)
        yPosition += 20

        paint.textSize = 12f
        paint.isFakeBoldText = false
        canvas.drawText("Tipo de Cliente: ${cuestionario.identificacion.tipoCliente}", 50f, yPosition, paint)
        yPosition += 15
        canvas.drawText("Documento: ${cuestionario.identificacion.numeroDocumento}", 50f, yPosition, paint)
        yPosition += 15
        canvas.drawText("Nombre/Razón Social: ${cuestionario.identificacion.nombreRazonSocial}", 50f, yPosition, paint)
        yPosition += 15
        // ... agregar más campos del cuestionario aquí
    }
}
