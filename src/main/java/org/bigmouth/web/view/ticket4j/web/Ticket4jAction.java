package org.bigmouth.web.view.ticket4j.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.bigmouth.framework.web.action.SimpleActionSupport;
import org.bigmouth.framework.web.action.json.JsonActionSupport;
import org.bigmouth.ticket4j.report.Report;
import org.bigmouth.web.view.ticket4j.service.ReportService;

import com.google.common.collect.Lists;

@Namespace("/")
@Action("ticket4j")
@Results({ 
    @Result(name = JsonActionSupport.SUCCESS, location = "/WEB-INF/pages/ticket4j/index.jsp")
})
public class Ticket4jAction extends SimpleActionSupport<Object> {

    private static final long serialVersionUID = -5676533345473744809L;
    public static final String DOWNLOAD = "download";

    private ReportService reportService;
    
    private List<Report> reports = Lists.newArrayList();

    @Override
    public String execute() throws Exception {
        reports = reportService.read();
        return SUCCESS;
    }

    @Override
    public Object getModel() {
        return null;
    }

    @Override
    public String list() throws Exception {
        return null;
    }

    @Override
    protected void prepareModel() throws Exception {
    }

    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public List<Report> getReports() {
        return reports;
    }
}
