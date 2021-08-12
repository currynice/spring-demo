package org.cxy.springdemo.dependency.inject.autowire;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Description:   </br>
 * Date: 2021/8/12 14:10
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class ByTypeBean2 {

    private List<Dog> dogList;

    private Dog[] dogArray;

    private Map<String,Dog>  dogMap;

    public List<Dog> getDogList() {
        return dogList;
    }

    public void setDogList(List<Dog> dogList) {
        this.dogList = dogList;
    }

    public Dog[] getDogArray() {
        return dogArray;
    }

    public void setDogArray(Dog[] dogArray) {
        this.dogArray = dogArray;
    }

    public Map<String, Dog> getDogMap() {
        return dogMap;
    }

    public void setDogMap(Map<String, Dog> dogMap) {
        this.dogMap = dogMap;
    }

    @Override
    public String toString() {
        return "ByTypeBean2{" +
                "dogList=" + dogList +
                ", dogArray=" + Arrays.toString(dogArray) +
                ", dogMap=" + dogMap +
                '}';
    }
}
