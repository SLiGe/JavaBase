package com.java.mode.flyWeight;

/**
 * 享元调用者
 *
 * @author : Gary
 * @since 2019/11/08 14:30
 */
public class FlyweightMain {
    public static void main(String[] args) {
        //创建享元工厂
        ReportManagerFactory managerFactory = new ReportManagerFactory();
        IReportManager reportManager = managerFactory.getEmployeeReportManager("A");
        reportManager.createReport();
        IReportManager financialReportManager = managerFactory.getFinancialReportManager("B");
        financialReportManager.createReport();
        System.out.println("------分割线-------");
        managerFactory.getEmployeeReportManager("A").createReport();
        managerFactory.getFinancialReportManager("B").createReport();
        System.out.println("结束！！！");
    }
}
