package org.cxy.springdemo.bean.applicationContext.resource_pattern_resolver;

/**
 * Description:   </br>
 * Date: 2021/8/9 15:31
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class Job {

    private boolean completed;

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Job{" +
                "completed=" + completed +
                '}';
    }
}
