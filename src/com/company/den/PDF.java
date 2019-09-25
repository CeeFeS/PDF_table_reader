package com.company.den;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PDF {
    public static final int LINKS = 2968;
    public static final int OBEN = 1174;
    public static final int BREITE = 55;
    public static final int HOEHE = 11;

    public static final int ANZAHL_SPALTEN = 1;
    public static final int ANZAHL_ZEILEN = 8;

    public void PDF_reader(String dateiname) {

        try (PDDocument document = PDDocument.load(new File(dateiname))) {

            document.getClass();

            if (!document.isEncrypted()) {
                PDPage pdPage = document.getPage(0);
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                int i_kaestchen = 0;
                for (int i = 0; i < ANZAHL_SPALTEN; i++) {
                    for (int j = 0; j < ANZAHL_ZEILEN; j++) {
                        i_kaestchen++;
                        Rectangle rectangle = sucheKaestchen(i, j);
                        stripper.addRegion(i_kaestchen + "", rectangle);

                        stripper.extractRegions(pdPage);
                        String pdfFileInText = stripper.getTextForRegion(i_kaestchen + "");

                        String lines[] = pdfFileInText.split("\\r?\\n");

                        if (lines.length > 0) {
                            for (String line : lines) {
                                System.out.println("Kaestchen Nummer " + i_kaestchen);
                                System.out.println(line);


                            }
                        }


                    }
                }





            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Rectangle sucheKaestchen(int kaestchen_x, int kaestchen_y) {
        int links = LINKS;
        int oben = OBEN;
        for (int i = 0; i < kaestchen_x; i++) {
            links = links + BREITE;
        }
        for (int i = 0; i < kaestchen_y; i++) {
            oben = oben + HOEHE;
        }
        Rectangle rectangle = new Rectangle(links, oben, BREITE, HOEHE);

        return rectangle;
    }
}
