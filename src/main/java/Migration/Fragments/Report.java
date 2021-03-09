package Migration.Fragments;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Report {

        public static Font anchorFont = new Font(Font.FontFamily.TIMES_ROMAN, 20,
                Font.BOLD);
        public static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
                Font.BOLD);
        public static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 14,
                Font.NORMAL, BaseColor.RED);
        public static Font greyFont = new Font(Font.FontFamily.TIMES_ROMAN, 14,
                Font.NORMAL, BaseColor.DARK_GRAY);
        public static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
                Font.BOLD);
        public static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 16,
                Font.BOLD);
        public static Font bold = new Font(Font.FontFamily.TIMES_ROMAN, 14,
                Font.BOLD);


        public static Document document = null;
        public static Anchor anchor;
        public static Chapter catPart;


        public static void createReportFile(String migrationID) throws FileNotFoundException {
            try {
                document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream("/home/user/Migration_" + migrationID + ".pdf"));
                Paragraph article = new Paragraph();
                document.open();
                article.add(new Paragraph("MIGRATION CHECK REPORT", anchorFont));
                article.add(new Paragraph("Migration ID: " + migrationID, smallBold));
                article.add(new Paragraph("Current date: " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), smallBold));
                document.add(article);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }

        public static void writeCsvTestResultToReport(String message, boolean result) {
            try {
                if (result)
                    document.add(new Paragraph("+ " + message, greyFont));
                else
                    document.add(new Paragraph("- " + message, redFont));
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }

        public static void createNewAnchor(String name) {
            anchor = new Anchor(name+"\n", anchorFont);
            try {
                document.add(anchor);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
        public static void createNewSubAnchor(String name) {
            anchor = new Anchor(name+"\n", smallBold);
            try {
                document.add(anchor);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }

        public static void createNewSubAnchorNotBold(String name) {
            anchor = new Anchor(name+"\n", bold);
            try {
                document.add(anchor);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }


        public static void writeResultsToFile() {
            document.close();
        }

    
}
