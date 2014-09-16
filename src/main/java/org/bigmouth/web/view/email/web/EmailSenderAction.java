package org.bigmouth.web.view.email.web;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.bigmouth.framework.web.action.json.JsonActionSupport;
import org.bigmouth.web.view.email.service.EmailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

@Namespace("/email")
@Action("sender")
public class EmailSenderAction extends JsonActionSupport {

    private static final long serialVersionUID = 7729419349896047742L;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSenderAction.class);

    private EmailSenderService emailSenderService;

    public void send() {
        try {
            String to = getParameter("to");
            String content = getParameter("content");
            Preconditions.checkArgument(StringUtils.isNotBlank(to), "接收者邮箱地址不能为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(content), "发送的内容不能为空");
            emailSenderService.send(to, content);
            succeed();
        }
        catch (Exception e) {
            failed("Failed to send!" + e.getMessage());
            LOGGER.error("send:", e);
        }
    }

    public void setEmailSenderService(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

}
