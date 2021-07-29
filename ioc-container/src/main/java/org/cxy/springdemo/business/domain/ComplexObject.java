package org.cxy.springdemo.business.domain;

import java.util.*;

/**
 * Description:  complex inject    </br>
 * Date: 2021/7/28 17:12
 *
 * @author :cxy </br>ComplexObject
 * @version : 1.0 </br>
 */
public class ComplexObject {
    private String[] names;
    private List<String> tels;
    private Set<Dog> dogs;
    private Map<String, Object> events;
    private Properties props;


    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public List<String> getTels() {
        return tels;
    }

    public void setTels(List<String> tels) {
        this.tels = tels;
    }

    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }

    public Map<String, Object> getEvents() {
        return events;
    }

    public void setEvents(Map<String, Object> events) {
        this.events = events;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public String toString() {
        return "ComplexObject{" +
                "names=" + Arrays.toString(names) +
                ", tels=" + tels +
                ", dogs=" + dogs +
                ", events=" + events +
                ", props=" + props +
                '}';
    }
}
