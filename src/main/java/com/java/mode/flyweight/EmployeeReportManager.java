package com.java.mode.flyweight;

/**
 * 员工报表
 * 具体享元类
 *
 * @author : Gary
 * @since 2019/11/08 14:23
 */
public class EmployeeReportManager implements IReportManager {
    /**
     * 租户ID
     */
    protected String tenantId = null;

    public EmployeeReportManager(String tenantId) {
        System.out.println("EmployeeReportManager is create!!!");
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a employee report!";
    }
}
