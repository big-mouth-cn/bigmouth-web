/*
 * 文件名称: LotteryServlet.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-4-24
 * 修改内容: 
 */
package org.bigmouth.web.view.lottery;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.bigmouth.framework.web.action.json.JsonActionSupport;


@Namespace("/")
@Action("doGetLotteryOne")
public class LotteryServlet extends JsonActionSupport {

    private static final long serialVersionUID = 4748126099696161007L;

    @Override
    public String execute() throws Exception {
        doResponse(new Result());
        return NONE;
    }
    
}
