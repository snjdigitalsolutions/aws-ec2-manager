package com.snjdigitalsolutions.awsec2manager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AwsEc2ManagerConfiguration {

    @Bean
    public TaskExecutor taskExecutor()
    {
        return new ThreadPoolTaskExecutor();
    }

    /**
     * This method is provided if further configuration beyond default
     * is needed. The default core pool size is 1, with unlimited max
     * pool size and unlimited queue capacity. If needed, in the bean
     * definition above, add a call to this method.
     *
     * @param executor the {@link ThreadPoolTaskExecutor} to modify
     */
    private void configureExecutor(ThreadPoolTaskExecutor executor, int corePoolSize, int maxPoolSize, int queueCapacity)
    {
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
    }

}
