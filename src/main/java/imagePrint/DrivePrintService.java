package imagePrint;

import org.apache.axis.utils.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.util.ArrayUtil;
import util.ListUtils;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.Sides;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program testDemo
 * @ClassName DrivePrintService
 * @Description DrivePrintService
 * @Author liguoming
 * @Date 2023-03-08 14:51
 * @Version 1.0
 **/
public class DrivePrintService {

    public static Logger logger = Logger.getLogger(DrivePrintService.class);

    // 传入文件和打印机名称
    public void print(File[] files, String printerName) throws PrintException, IOException {
        List<InputStream> streams = fileStreams(files);
        if (streams.isEmpty()) {
            logger.warn("缺少打印文件");
            throw new NullPointerException("缺少打印文件");
        }

        DocFlavor flavor = getDocFlavor();
        PrintRequestAttributeSet aset = getPrintRequestAttribute();
        for (InputStream in : streams) {
            DocPrintJob docPrintJob = getPrintJob(printerName);
            docPrintJob.print(new SimpleDoc(in, flavor, null), aset);
        }
    }

    private List<InputStream> fileStreams(File[] files) {
        if (files.length == 0) {
            logger.warn("缺少打印文件");
            throw new NullPointerException("缺少打印文件");
        }
        List<InputStream> ins = new ArrayList<>();
        try {
            for (File file : files) {
                ins.add(new FileInputStream(file));
            }
        } catch (FileNotFoundException e) {
            logger.warn(String.format("打印文件缺失：{}", e.getMessage()));
        }
        return ins;
    }

    private DocFlavor getDocFlavor() {
        // 设置打印格式，如果未确定类型，可选择autosense
        return DocFlavor.INPUT_STREAM.AUTOSENSE;
    }

    private PrintRequestAttributeSet getPrintRequestAttribute() {
        // 设置打印参数
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(new Copies(1)); //份数
//        aset.add(MediaSize.ISO.A4); //纸张
        // aset.add(Finishings.STAPLE);//装订
        aset.add(Sides.ONE_SIDED);//单双面
        aset.add(new MediaPrintableArea(10, 10, 595,842, MediaPrintableArea.MM));
        return aset;
    }

    private DocPrintJob getPrintJob(String printerName) {
        if (printerName == null) {
            logger.warn("请选择打印机");
            throw new NullPointerException("请选择打印机");
        }
        //获得本台电脑连接的所有打印机
        PrintService[] printServices = PrinterJob.lookupPrintServices();
        if (printServices == null || printServices.length == 0) {
            logger.warn("打印失败，未找到可用打印机，请检查。");
            throw new NullPointerException("打印失败，未找到可用打印机，请检查。");
        }
        //匹配指定打印机
        PrintService printService = null;
        for (PrintService service : printServices) {
            if (printerName.equals(service.getName())) {
                printService = service;
                break;
            }
        }
        if (printService == null) {
            String msg = String.format("打印失败，未找到名称为 [{}] 的打印机，请检查。", printerName);
            logger.warn(msg);
            throw new NullPointerException(msg);
        }
        return printService.createPrintJob();
    }
}