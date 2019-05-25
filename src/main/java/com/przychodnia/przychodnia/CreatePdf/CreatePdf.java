package com.przychodnia.przychodnia.CreatePdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.przychodnia.przychodnia.Entity.Kartoteka;
import com.przychodnia.przychodnia.Entity.Presciption;
import com.przychodnia.przychodnia.Entity.Wizyta;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    public static String generatePdfKartoteka(Kartoteka kartoteka, List<Wizyta> wizyty, List<Presciption> recepty){
        Document document = new Document();

        String sciezka ="kartoteki/"+kartoteka.getId()+"."+kartoteka.getPatient().getLastName()+".pdf";

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(sciezka));
            document.open();
            document.add(new Paragraph("Pacjent: \n"+kartoteka.getPatient().toString()));
            document.add(new Paragraph("Pesel: "+kartoteka.getPatient().getPesel()));
            document.add(new Paragraph("adres: "+kartoteka.getPatient().getAddress()));
            document.add(new Paragraph("\nLekarz:"));
            document.add(new Paragraph(kartoteka.getPatient().getDoctor().toString()));
            document.add(new Paragraph("Przychodznia eMed"));

            document.add(new Paragraph("Wizyty: "+wizyty.size()));

            PdfPTable tableWizyty = new PdfPTable(2);
            tableWizyty.setWidthPercentage(100);
            tableWizyty.setSpacingBefore(20);
            tableWizyty.setSpacingAfter(20);

            PdfPCell c1 = new PdfPCell(new Paragraph("doktor"));
            PdfPCell c2 = new PdfPCell(new Paragraph("Data:"));
            c1.addElement(new Paragraph("Lekarz"));
            c2.addElement(new Paragraph("Data"));

            for(Wizyta wizyta : wizyty){
                c1.addElement(new Paragraph(wizyta.getDoctor().toString()));
                c2.addElement(new Paragraph(localDateTimetoString(wizyta.getLocalDateTime())));
            }
            c1.setExtraParagraphSpace(20);
            c1.setMinimumHeight(30);

            c2.setExtraParagraphSpace(20);
            c2.setMinimumHeight(30);
            tableWizyty.addCell(c1);

            tableWizyty.addCell(c2);
            document.add(tableWizyty);


            document.add(new Paragraph("Recepty: "+recepty.size()));

            PdfPTable tableRecepty = new PdfPTable(3);
            tableRecepty.setWidthPercentage(100);
            tableRecepty.setSpacingBefore(20);
            tableRecepty.setSpacingAfter(20);

            PdfPCell c3 = new PdfPCell(new Paragraph("doktor"));
            PdfPCell c4 = new PdfPCell(new Paragraph("Data:"));
            PdfPCell c5 = new PdfPCell(new Paragraph("Zalecenia:"));
            c3.addElement(new Paragraph("Lekarz"));
            c4.addElement(new Paragraph("Data"));
            c5.addElement(new Paragraph("Zalecenia"));

            for(Presciption recepta : recepty){
                c3.addElement(new Paragraph(recepta.getDoctor().toString()));
                c4.addElement(new Paragraph(localDateTimetoString(recepta.getLocalDateTime())));
                c5.addElement(new Paragraph(recepta.getDescription()));
            }
            c3.setExtraParagraphSpace(20);
            c3.setMinimumHeight(100);

            c4.setExtraParagraphSpace(20);
            c4.setMinimumHeight(30);

            c5.setExtraParagraphSpace(20);
            c5.setMinimumHeight(30);

            tableRecepty.addCell(c3);
            tableRecepty.addCell(c4);
            tableRecepty.addCell(c5);
            document.add(tableRecepty);

            document.add(new Paragraph("Wygenerowano: "+ LocalDate.now()));

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
