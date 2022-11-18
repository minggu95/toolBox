package imageToPdf;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class imageToPdf {
    public static void convert(String source, String target) {
        Document document = new Document();
        // 设置文档页边距
        document.setMargins(0, 0, 0, 0);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(target);
            PdfWriter.getInstance(document, fos);
            // 打开文档
            document.open();
            // 获取图片的宽高
            Image image = Image.getInstance(source);
            float imageHeight = image.getScaledHeight();
            float imageWidth = image.getScaledWidth();
            // 设置页面宽高与图片一致
            Rectangle rectangle = new Rectangle(imageWidth, imageHeight);
            document.setPageSize(rectangle);
            // 图片居中
            image.setAlignment(Image.ALIGN_CENTER);
            // 新建一页添加图片
            document.newPage();
            document.add(image);
        } catch (Exception ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            // 关闭文档
            document.close();
            try {
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "";
        JFileChooser fileChooser = new JFileChooser("D:\\");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fileChooser.showOpenDialog(fileChooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            filePath = fileChooser.getSelectedFile().getAbsolutePath();//这个就是你选择的文件夹的
        }
        File file = new File(filePath);
        File[] list = file.listFiles();//list获取的结果：[D:\qrcodeFile\20190116, D:\qrcodeFile\20190117]
        if (list.length == 0) {
            System.out.println(file.getAbsolutePath() + " is null");
        } else {
            for (int i = 0; i < list.length; i++) {
                String source = list[i].getAbsolutePath();
                int index = source.lastIndexOf(".");
                String temp = source.substring(index+1);
                String pdfName = list[i].getAbsolutePath().replace(temp, "pdf");
                convert(source, pdfName);
            }
        }
    }

    public static String getImageNameByPath(String path) {
        String fName = path.trim();       //删除路径两侧多余空格
        String ImageName = fName.substring(fName.lastIndexOf("/") + 1,
                fName.lastIndexOf("."));
        //截取最右侧斜杠之右的字段，到点为止

        return ImageName;
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                            