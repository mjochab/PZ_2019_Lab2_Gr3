package com.przychodnia.przychodnia.CreatePdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.przychodnia.przychodnia.Entity.Presciption;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;

public class CreatePdf {

    public static String createPdf(Presciption presciption){

        Document document = new Document();

        String sciezka ="recepty/"+presciption.getId()+"."+presciption.getKartoteka().getPatient().getLastName()+".pdf";

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(sciezka));
            document.open();
            document.add(new Paragraph("Recepta: "+presciption.getId()));
            document.add(new Paragraph("\nLekarz:"));
            document.add(new Paragraph(presciption.getDoctor().toString()));
            document.add(new Paragraph("Przychodznia eMed"));

            document.add(new Paragraph("\nPacjent:"));
            document.add(new Paragraph(presciption.getKartoteka().getPatient().toString()));
            document.add(new Paragraph(presciption.getKartoteka().getPatient().getAddress()));
            document.add(new Paragraph(presciption.getKartoteka().getPatient().getPesel()));

            document.add(new Paragraph("\n\nZalecenia:"));

            PdfPTable table = new PdfPTable(1);
            table.setWidthPercentage(100);
            table.setSpacingBefore(20);
            table.setSpacingAfter(20);
            PdfPCell c1 = new PdfPCell(new Paragraph("zalecenia"));
            c1.addElement(new Paragraph(presciption.getDescription()));
            c1.setExtraParagraphSpace(20);
            c1.setMinimumHeight(200);
            table.addCell(c1);
            document.add(table);

            Paragraph paragraphDataWystawiena = new Paragraph("\nData wystawienia: "+CreatePdf.localDateTimetoString(presciption.getLocalDateTime()));
            paragraphDataWystawiena.setExtraParagraphSpace(40);

            document.add(paragraphDataWystawiena);

            document.add(new Paragraph("\n\nPodpis lekarza:"));
            PdfPTable tablePodpisLekarza = new PdfPTable(1);
            tablePodpisLekarza.setWidthPercentage(30);
            tablePodpisLekarza.setSpacingBefore(40);
            tablePodpisLekarza.setSpacingAfter(20);
            PdfPCell c2 = new PdfPCell(new Paragraph("Podpis Lekarza"));
            c2.addElement(new Paragraph());
            c2.setExtraParagraphSpace(40);
            c2.setMinimumHeight(50);
            tablePodpisLekarza.addCell(c2);

            document.add(tablePodpisLekarza);

            document.close();

            return sciezka;
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "blad";
    }

    private static String localDateTimetoString(LocalDateTime localDateTime) {
        return localDateTime.getDayOfMonth() + "-"
                + localDateTime.getMonthValue() + "-"
                + localDateTime.getYear();
    }
}
