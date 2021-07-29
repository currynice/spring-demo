package org.cxy.springdemo.business.repository;

import java.util.Arrays;
import java.util.List;

/**
 * Description:   </br>
 * Date: 2021/7/27 15:26
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class UserRepositoryImpl2 implements UserRepository {


    @Override
    public List<String> allNames() {
        return Arrays.asList("1","2","3");
    }
}
