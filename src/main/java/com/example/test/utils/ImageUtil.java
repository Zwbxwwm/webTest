package com.example.test.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class ImageUtil {
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    private ImageUtil(){

    }
    public static void main(String[] args) throws WriterException, IOException {
        String content = "https://ss-api.mintegral.com/api/v1/tracking/click-test?token=0694b85353c7094e828f9ba831cfb3d0&key=MTU3NDMyMTU4NQ==&gaid=d8e08098-fee2-4f6d-8a33-6be2681287b8";
        int width = 300;
        int height = 300;
        String format = "jpg";
        Path path = Paths.get("c:\\11111.jpg");
        createImage(width,height,path,format,content);
    }
    public static void createImage(int width,int height,Path path,String format,String content) throws WriterException, IOException {
        HashMap<EncodeHintType,String> hintTypeStringHashMap = new HashMap<>();
        hintTypeStringHashMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hintTypeStringHashMap);
        MatrixToImageWriter.writeToPath(matrix,format,path);
    }

    public static BufferedImage toBufferImage(BitMatrix bitMatrix) {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    public static void writeToFile(BitMatrix matrix,String format, File file) {
        BufferedImage image = toBufferImage(matrix);
        try {
            ImageIO.write(image,format,file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToStream(BitMatrix matrix, String format, OutputStream outputStream) {
        BufferedImage image = toBufferImage(matrix);
        try {
            ImageIO.write(image,format,outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
