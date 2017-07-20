package pdf.helloWorld;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

/**
 * @autor mvl on 20.07.2017.
 */
public class Solution {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        Document document = new Document();

        File fileName = new File("testFiles/test.pdf");
        PdfWriter.getInstance(document, new FileOutputStream(fileName));

        document.open();
        document.add(new Paragraph("Hello World!"));
        document.close();
    }
}
