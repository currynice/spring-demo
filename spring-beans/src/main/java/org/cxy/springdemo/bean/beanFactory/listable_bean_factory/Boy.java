package org.cxy.springdemo.bean.beanFactory.listable_bean_factory;

/**
 * Description:   </br>
 * Date: 2021/8/3 9:54
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class Boy {
    private Integer version;


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "version=" + version +
                '}';
    }
}
