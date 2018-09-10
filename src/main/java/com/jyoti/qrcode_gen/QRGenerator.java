package com.jyoti.qrcode_gen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Hello world!
 *
 */
public class QRGenerator 
{
	private static String qrCodepath="E:\\Eclipse_Workspace\\Learning\\qrcode-gen\\QRCode_Server\\";
    public String writeQRCode(PaytmRequest request) throws Exception {
    	String qrCode = qrCodepath+request.getName() + "_QRCODE.png";
    	QRCodeWriter writer = new QRCodeWriter();
    	BitMatrix matrix = writer.encode(request.getName()+"\n"+request.getMobileNo()+"\n"+request.getAccountNo()+"\n"+request.getAccType(), BarcodeFormat.QR_CODE, 350, 350);
    	Path path = FileSystems.getDefault().getPath(qrCode);
    	MatrixToImageWriter.writeToPath(matrix, "PNG", path);
    	return "QRCode generated successfully..";
    }
	
    public String readQRCode(String file) throws Exception {
    	BufferedImage bufferedImage = ImageIO.read(new File(file));
    	LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
    	BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
    	Result result = new MultiFormatReader().decode(binaryBitmap);
    	
    	return result.getText();
    }
	public static void main( String[] args ) throws Exception
    {
        QRGenerator generator = new QRGenerator();
       // System.out.println(generator.writeQRCode(new PaytmRequest("Jyoti", "1234567890", "ACC12345678", "Personal")));
        System.out.println(generator.readQRCode(qrCodepath+"Jyoti_QRCODE.png"));
    }
}
