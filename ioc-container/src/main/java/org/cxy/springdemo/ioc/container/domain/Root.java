package org.cxy.springdemo.ioc.container.domain;


import org.cxy.springdemo.ioc.container.annotation.Super;

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
