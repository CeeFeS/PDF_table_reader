package com.company.den;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        PDF pdf = new PDF();
        pdf.PDF_reader("C:\\Users\\sc000121\\Desktop\\auslese_pdfs\\test.pdf");

    }


}
