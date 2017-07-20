package pdf.testDZone;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @autor mvl on 20.07.2017.
 */
public class HeaderFooter {
    /** The header/footer text. */
    String header;

    /** The template with the total number of pages. */
    PdfTemplate total;

    /**
     * Allows us to change the content of the header.
     * @param header The new header String
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * Creates the PdfTemplate that will hold the total number of pages
     */
    public void onOpenDocument(PdfWriter writer, Document document){
        total = writer.getDirectContent().createTemplate(25, 16);
    }

    /**
     * Adds a header to every page
     */
    public void onEndPage(PdfWriter writer, Document document) {
        PdfPTable table = new PdfPTable(2);
        try {
            table.setWidths(new int[]{200, 30});
            table.setLockedWidth(true);
            table.getDefaultCell().setBorder(Rectangle.SUBJECT);
            table.addCell(header);
            table.addCell(String.format("Page %d ", writer.getPageNumber()));
            Rectangle page = document.getPageSize();
            table.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
            table.writeSelectedRows(0, -1,
                    document.leftMargin(),
                    page.getHeight() - document.topMargin() + table.getTotalHeight() + 5,
                    writer.getDirectContent());
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    /**
     * Fills out the total number of pages before the document is closed
     */
    public void onCloseDocument(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(total, Element.ALIGN_LEFT,
                new Phrase(String.valueOf(writer.getPageNumber() - 1)), 2, 2, 0);
    }
}
