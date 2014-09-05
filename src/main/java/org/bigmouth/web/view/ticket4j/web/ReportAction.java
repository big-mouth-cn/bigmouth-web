package org.bigmouth.web.view.ticket4j.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.bigmouth.framework.web.action.SimpleActionSupport;
import org.bigmouth.ticket4j.report.Report;
import org.bigmouth.web.view.ticket4j.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;

@Namespace("/ticket4j")
@Action("report")
public class ReportAction extends SimpleActionSupport<Object> {

    private static final long serialVersionUID = 7961359669192636417L;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportAction.class);

    private ReportService reportService;

    @Override
    public String execute() throws Exception {
        try {
            String fileName = getParameter("fileName");
            String order = getParameter("order");
            Preconditions.checkArgument(StringUtils.isNotBlank(fileName), "fileName cannot be blank.");
            Preconditions.checkArgument(StringUtils.isNotBlank(order), "order cannot be blank.");
            Report report = new Gson().fromJson(order, Report.class);
            report.setIp(getRemoteAddr());
            reportService.write(report, fileName);
            write("0");
        }
        catch (Exception e) {
            write("-1");
            LOGGER.error("上报订票信息错误！", e);
        }
        return NONE;
    }

    private String getRemoteAddr() {
        HttpServletRequest request = getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private void write(String value) throws IOException {
        PrintWriter pw = null;
        try {
            pw = getResponse().getWriter();
            pw.write(value);
            pw.flush();
        }
        finally {
            IOUtils.closeQuietly(pw);
        }
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

}
