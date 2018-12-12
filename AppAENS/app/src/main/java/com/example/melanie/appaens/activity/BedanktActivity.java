package com.example.melanie.appaens.activity;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.print.PrintAttributes;
import android.print.pdf.PrintedPdfDocument;
import android.support.constraint.solver.widgets.Rectangle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.melanie.appaens.R;

import org.w3c.dom.Document;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.print.PrintAttributes.CREATOR;

public class BedanktActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedankt);


        String filename = "emptyPDF.pdf";

//        PDDocument doc = new PDDocument();

    }
}
