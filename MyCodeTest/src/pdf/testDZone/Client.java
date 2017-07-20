package pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor mvl on 20.07.2017.
 */
public class Client {
    private static final String TITLE = "TestReport";
    public static final String PDF_EXTENSION = ".pdf";
    public static void main(String[] args) {
        List<DataObject> dataObjList = getDataObjectList();
        Document document = null;
        try {
            //Document is not auto-closable hence need to close it separately
            document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
                    new File(TITLE + PDF_EXTENSION)));
            HeaderFooter event = new HeaderFooter();
            event.setHeader("Test Report");
            writer.setPageEvent((PdfPageEvent) event);
            document.open();
            PDFCreator.addMetaData(document, TITLE);
            PDFCreator.addTitlePage(document, TITLE);
            PDFCreator.addContent(document, dataObjList);
        }catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException occurs.." + e.getMessage());
        }finally{
            if(null != document){
                document.close();
            }
        }
    }
    public static List<DataObject> getDataObjectList(){
        List<DataObject> dataObjList = new ArrayList<DataObject>();
        DataObject d1 = new DataObject();
        d1.setComanyName("ABC");
        d1.setIncome("20000");
        d1.setYear("2017");
        DataObject d2 = new DataObject();
        d2.setComanyName("XYZ");
        d2.setIncome("30000");
        d2.setYear("2017");
        dataObjList.add(d1);
        dataObjList.add(d2);
        return dataObjList;
    }
}
