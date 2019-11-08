package com.java.mode.flyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * 核心：享元工厂
 *
 * @author : Gary
 * @since 2019/11/08 14:25
 */
public class ReportManagerFactory {

    private Map<String, IReportManager> financialReportManager = new HashMap<>();

    private Map<String, IReportManager> employeeReportManager = new HashMap<>();

    IReportManager getFinancialReportManager(String tenantId) {
        IReportManager r = financialReportManager.get(tenantId);
        if (r == null) {
            r = new FinancialReportManager(tenantId);
            //维护已创建的
            financialReportManager.put(tenantId, r);
        }
        return r;
    }

    IReportManager getEmployeeReportManager(String tenantId) {
        IReportManager r = employeeReportManager.get(tenantId);
        if (r == null) {
            r = new EmployeeReportManager(tenantId);
            //维护已创建的
            employeeReportManager.put(tenantId, r);
        }
        return r;
    }
}
