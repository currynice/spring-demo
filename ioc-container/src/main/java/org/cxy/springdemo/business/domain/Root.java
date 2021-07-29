package org.cxy.springdemo.business.domain;


import org.cxy.springdemo.business.annotation.Super;

/**
 * 超级用户
 */
@Super
public class Root extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Root{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
