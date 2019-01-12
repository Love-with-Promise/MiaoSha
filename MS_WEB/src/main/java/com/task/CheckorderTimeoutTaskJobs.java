package com.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2019/1/12 18:48
 * @version: 1.0
 **/
public class CheckorderTimeoutTaskJobs extends QuartzJobBean {

    private static final Log LOG_RECORD = LogFactory.getLog(CheckorderTimeoutTaskJobs.class);

    @Autowired
    private CheckorderTimeoutTask checkorderTimeoutTask;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG_RECORD.info("begin to execute task," + DateUtils.dateToString(new Date()));

        checkorderTimeoutTask.ChecktimeOutOrder(20);

        LOG_RECORD.info("end to execute task," + DateUtils.dateToString(new Date()));
    }
}
