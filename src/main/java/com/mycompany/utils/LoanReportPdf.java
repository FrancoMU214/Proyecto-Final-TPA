/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author 52951
 */
public class LoanReportPdf {

    public void crearPdf(String title, String author, String category, String releaseDate, String pageCount) {
        // Crear un nuevo documento PDF
        PDDocument document = new PDDocument();

        try {
            // Añadir una página al documento
            PDPage page = new PDPage();
            document.addPage(page);

            String[] rules = {
                "• Respetar los plazos de devolución establecidos para evitar penalizaciones.",
                "• Utilizar correctamente las credenciales de acceso proporcionadas para el servicio en línea.",
                "• No compartir las credenciales de acceso con terceros para garantizar la seguridad",
                "  de la cuenta.",
                "• Descargar y leer los libros electrónicos de acuerdo con las políticas de uso ",
                "  establecidas.",
                "• No realizar copias ilegales o distribuir el contenido descargado de forma no ",
                "  autorizada.",
                "• Reportar cualquier problema técnico o dificultad de acceso al personal de la biblioteca.",
                "• Respetar los derechos de autor y las licencias de los materiales digitales.",
                "• Utilizar los recursos en línea de manera ética y responsable.",
                "• Evitar el acceso a sitios web o contenido que no esté relacionado con la investigación",
                "académica o la lectura recreativa.",
                "• Cerrar sesión correctamente después de usar los servicios en línea para proteger",
                "  la privacidad de la cuenta.","© 2024 Biblioteca Trinity. Todos los derechos reservados."
            };

            // Iniciar una nueva secuencia de contenido
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Dibujar los márgenes
            contentStream.setLineWidth(2);
            contentStream.setStrokingColor(0, 0, 0); // Color negro
            contentStream.moveTo(40, 40);
            contentStream.lineTo(40, 750);
            contentStream.lineTo(550, 750);
            contentStream.lineTo(550, 40);
            contentStream.closeAndStroke();

            // Dibujar encabezado
            contentStream.setStrokingColor(100, 100, 100); // Color gris claro
            contentStream.moveTo(40, 740);
            contentStream.lineTo(550, 740);
            contentStream.closeAndStroke();

            // Dibujar pie de página
            contentStream.moveTo(40, 50);
            contentStream.lineTo(550, 50);
            contentStream.closeAndStroke();

            // Escribir fecha en el encabezado
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String date = sdf.format(new Date());

            contentStream.setFont(PDType1Font.HELVETICA, 10);
            contentStream.beginText();
            contentStream.newLineAtOffset(450, 755);
            contentStream.showText("Fecha: " + date);
            contentStream.endText();

            // Cargar la imagen del logo desde el classpath
            InputStream in = getClass().getResourceAsStream("/images/logo.png");
            if (in == null) {
                System.err.println("No se pudo encontrar el archivo logo.png");
                return;
            }
            PDImageXObject logo = PDImageXObject.createFromByteArray(document, in.readAllBytes(), "logo.png");

            // Dibujar la imagen del logo en la página
            contentStream.drawImage(logo, 50, 690, 60, 60); // ajustar las coordenadas y tamaño según sea necesario

            // Escribir el título
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 24);
            contentStream.beginText();
            contentStream.newLineAtOffset(120, 720); // ajustar la posición para dejar espacio para el logo
            contentStream.showText("Biblioteca Trinity");
            contentStream.endText();

            // Escribir subtítulo
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
            contentStream.beginText();
            contentStream.newLineAtOffset(120, 690);
            contentStream.showText("Reporte de Préstamo");
            contentStream.endText();

            // Dibujar línea separadora
            contentStream.setStrokingColor(200, 200, 200); // Color gris claro
            contentStream.moveTo(40, 680);
            contentStream.lineTo(550, 680);
            contentStream.closeAndStroke();

            // Escribir detalles del libro
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 640);
            contentStream.showText("Ha sido prestado el siguiente libro:");
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(50, 620);
            contentStream.showText("Título: " + title);
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(50, 600);
            contentStream.showText("Autor: " + author);
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(50, 580);
            contentStream.showText("Categoría: " + category);
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(50, 560);
            contentStream.showText("Fecha de lanzamiento: " + releaseDate);
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(50, 540);
            contentStream.showText("Cantidad de páginas: " + pageCount);
            contentStream.endText();

            // Dibujar línea separadora
            contentStream.setStrokingColor(200, 200, 200); // Color gris claro
            contentStream.moveTo(40, 520);
            contentStream.lineTo(550, 520);
            contentStream.closeAndStroke();

            // Escribir título de las reglas
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 500);
            contentStream.showText("Reglas de la Biblioteca:");
            contentStream.endText();

            // Escribir las reglas
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            int yPosition = 480;
            for (String rule : rules) {
                contentStream.beginText();
                if(rule.charAt(0) == "©".charAt(0))
                    yPosition -= 80;
                contentStream.newLineAtOffset(80, yPosition);
                contentStream.showText(rule);
                contentStream.endText();
                yPosition -= 20; // Ajusta el espaciado según sea necesario

                if (yPosition < 60) {
                    contentStream.close();
                    page = new PDPage();
                    document.addPage(page);
                    contentStream = new PDPageContentStream(document, page);
                    yPosition = 750;

                    // Redibujar los márgenes
                    contentStream.setLineWidth(2);
                    contentStream.setStrokingColor(0, 0, 0); // Color negro
                    contentStream.moveTo(40, 40);
                    contentStream.lineTo(40, 750);
                    contentStream.lineTo(550, 750);
                    contentStream.lineTo(550, 40);
                    contentStream.closeAndStroke();

                    
                    

                }
            }

            // Cerrar la secuencia de contenido
            contentStream.close();

            // Guardar el documento en un archivo
            document.save("ReporteBibliotecaTrinity.pdf");
            System.out.println("PDF creado exitosamente.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            try {
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        LoanReportPdf report = new LoanReportPdf();
        report.crearPdf("El Principito", "Antoine de Saint-Exupéry", "Ficción", "1943", "96");
    }
}
