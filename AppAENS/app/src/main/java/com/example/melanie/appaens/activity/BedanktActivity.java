package com.example.melanie.appaens.activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidpdfwriterr.PDFWriter;
import com.example.androidpdfwriterr.PaperSize;
import com.example.androidpdfwriterr.StandardFonts;
import com.example.androidpdfwriterr.Transformation;
import com.example.melanie.appaens.R;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.model.Observatie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BedanktActivity extends AppCompatActivity {

    private static final String TAG = "BEDANKTACTIVITY";
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar toolbar = getSupportActionBar();
        toolbar.setTitle("Bedankt");

        DataSource data = new DataSource();
        Observatie observatie = data.getObservatie();

        mText = (TextView) findViewById(R.id.testText);

        Log.d("BEDANKTACTIVITY", "Make pdf");

//        String pdfcontent = generateHelloWorldPDF();
//        outputToScreen(R.id.text, pdfcontent);
//        outputToFile("helloworld.pdf",pdfcontent,"ISO-8859-1");

//        PDFWriter writer = new PDFWriter(PaperSize.FOLIO_WIDTH, PaperSize.FOLIO_HEIGHT);
//        writer.setFont(StandardFonts.SUBTYPE, StandardFonts.TIMES_BOLD, StandardFonts.WIN_ANSI_ENCODING);
//        writer.addText(5, 5, 20, "I like SSaurel’s Tutorials !");
//        writer.newPage();
//        outputToFile("MyFirstReport.pdf", writer.asString(), "ISO-8859-1");
//        Log.d(TAG, "Pdf created");
    }

    private void outputToScreen(int viewID, String pdfContent) {
        mText.setText(pdfContent);
    }

    public void outputToFile(String fileName, String pdfContent, String encoding) {
        File newFile = new File(Environment.getExternalStorageDirectory() + "/" + fileName);
        try {
            newFile.createNewFile();
            try {
                FileOutputStream pdfFile = new FileOutputStream(newFile);
                pdfFile.write(pdfContent.getBytes(encoding));
                pdfFile.close();
            } catch(FileNotFoundException e) {
                // ...
            }
        } catch(IOException e) {
            // ...
        }
    }

    private String generateHelloWorldPDF() {
        PDFWriter mPDFWriter = new PDFWriter(PaperSize.FOLIO_WIDTH, PaperSize.FOLIO_HEIGHT);

        // note that to make this images snippet work
        // you have to uncompress the assets.zip file
        // included into your project assets folder
        AssetManager mngr = getAssets();
        try {
            Bitmap xoiPNG = BitmapFactory.decodeResource(this.getResources(),R.drawable.acties);
            Bitmap xoiJPG = BitmapFactory.decodeResource(this.getResources(),R.drawable.acties);
            Bitmap xoiBMP1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.acties);
            Bitmap xoiBMP8 = BitmapFactory.decodeResource(this.getResources(),R.drawable.acties);
            Bitmap xoiBMP24 = BitmapFactory.decodeResource(this.getResources(),R.drawable.acties);
            mPDFWriter.addImage(400, 600, xoiPNG, Transformation.DEGREES_315_ROTATION);
            mPDFWriter.addImage(300, 500, xoiJPG);
            mPDFWriter.addImage(200, 400, 135, 75, xoiBMP24);
            mPDFWriter.addImage(150, 300, 130, 70, xoiBMP8);
            mPDFWriter.addImageKeepRatio(100, 200, 50, 25, xoiBMP8);
            mPDFWriter.addImageKeepRatio(50, 100, 30, 25, xoiBMP1, Transformation.DEGREES_270_ROTATION);
            mPDFWriter.addImageKeepRatio(25, 50, 30, 25, xoiBMP1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mPDFWriter.setFont(StandardFonts.SUBTYPE, StandardFonts.TIMES_ROMAN);
        mPDFWriter.addRawContent("1 0 0 rg\n");
        mPDFWriter.addTextAsHex(70, 50, 12, "68656c6c6f20776f726c6420286173206865782921");
        mPDFWriter.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER, StandardFonts.WIN_ANSI_ENCODING);
        mPDFWriter.addRawContent("0 0 0 rg\n");
        mPDFWriter.addText(30, 90, 10, "� CRL", Transformation.DEGREES_270_ROTATION);

        mPDFWriter.newPage();
        mPDFWriter.addRawContent("[] 0 d\n");
        mPDFWriter.addRawContent("1 w\n");
        mPDFWriter.addRawContent("0 0 1 RG\n");
        mPDFWriter.addRawContent("0 1 0 rg\n");
        mPDFWriter.addRectangle(40, 50, 280, 50);
        mPDFWriter.addText(85, 75, 18, "Code Research Laboratories");

        mPDFWriter.newPage();
        mPDFWriter.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
        mPDFWriter.addText(150, 150, 14, "http://coderesearchlabs.com");
        mPDFWriter.addLine(150, 140, 270, 140);

        int pageCount = mPDFWriter.getPageCount();
        for (int i = 0; i < pageCount; i++) {
            mPDFWriter.setCurrentPage(i);
            mPDFWriter.addText(10, 10, 8, Integer.toString(i + 1) + " / " + Integer.toString(pageCount));
        }

        String s = mPDFWriter.asString();
        return s;
    }
}
