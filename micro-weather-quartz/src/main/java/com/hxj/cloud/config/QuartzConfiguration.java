package com.hxj.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.hxj.cloud.job.WeatherDataSyncJob;

@Configuration
public class QuartzConfiguration {
	
	// JobDetail
	@Bean
	public MethodInvokingJobDetailFactoryBean detailFactoryBean(WeatherDataSyncJob weatherDataSyncJob){  
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean ();  
        //这儿设置对应的Job对象  
        bean.setTargetObject (weatherDataSyncJob);  
        //这儿设置对应的方法名  与执行具体任务调度类中的方法名对应  
        bean.setTargetMethod ("work");  
        bean.setConcurrent (false);  
        return bean;
    }  
	
	// Trigger
	@Bean(name = "cronTriggerBean")  
    public CronTriggerFactoryBean cronTriggerBean(MethodInvokingJobDetailFactoryBean detailFactoryBean){  
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean ();  
        trigger.setJobDetail (detailFactoryBean.getObject ());  
        trigger.setCronExpression ("* 0/30 * ? * *");//每5秒执行一次    
        return trigger;  
    }  
  
	
	@Bean  
    public SchedulerFactoryBean schedulerFactory(CronTriggerFactoryBean cronTriggerBean){  
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean ();  
        schedulerFactory.setTriggers(cronTriggerBean.getObject());  
        return schedulerFactory;  
    }  
	
}
