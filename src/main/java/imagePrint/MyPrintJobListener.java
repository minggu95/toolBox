package imagePrint;


import org.apache.log4j.Logger;
import util.HttpUtils;

import javax.print.event.PrintJobEvent;
import javax.print.event.PrintJobListener;

/**
 * @Program testDemo
 * @ClassName MyPrintJobListener
 * @Description MyPrintJobListener
 * @Author liguoming
 * @Date 2023-03-08 14:52
 * @Version 1.0
 **/
public class MyPrintJobListener implements PrintJobListener {

    public static Logger logger = Logger.getLogger(MyPrintJobListener.class);

    @Override
    public void printDataTransferCompleted(PrintJobEvent pje) {
        logger.warn("通知客户端数据已成功传输到打印服务，客户端可以释放为该数据分配的本地资源");
    }

    @Override
    public void printJobCompleted(PrintJobEvent pje) {
        logger.warn("通知客户该作业成功完成。");
    }

    @Override
    public void printJobFailed(PrintJobEvent pje) {
        logger.warn("通知客户该作业未成功完成，必须重新提交。");
    }

    @Override
    public void printJobCanceled(PrintJobEvent pje) {
        logger.warn("通知客户该作业被用户或程序取消。");
    }

    @Override
    public void printJobNoMoreEvents(PrintJobEvent pje) {
        logger.warn("通知客户不会再发送任何事件。");
    }

    @Override
    public void printJobRequiresAttention(PrintJobEvent pje) {
        logger.warn("通知客户某些可能出现用户纠正的问题（例如打印机缺纸）。");
    }

}
