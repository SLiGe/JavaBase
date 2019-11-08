package com.java.mode.flyWeight;

/**
 * 具体享元类
 * 财务报表
 *
 * @author : Gary
 * @since 2019/11/08 14:20
 */
public class FinancialReportManager implements IReportManager {

    /**
     * 租户ID
     */
    protected String tenantId = null;

    public FinancialReportManager(String tenantId) {
        System.out.println("FinancialReportManager is create!!!");
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a financial report!";
    }
}
