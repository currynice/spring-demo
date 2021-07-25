package org.cxy.ioc.java.beans;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * {@link java.beans.BeanInfo} 示例
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        //stopClass:停止分析的基类。在分析中将忽略 stopClass 或其基类中的任何 methods/properties/events
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);

        //输出所有Properties描述，和Events，Methods 属于配置元信息
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
//                    System.out.println(propertyDescriptor);

                    //name: age,  propertyType:Integer
                    //name: name, propertyType: String

                    //PropertyDescriptor 允许添加属性编辑器  --PropertyEditor
                    //类似IDEA的GUI程序中，需要支持这样的转换，text（String）->PropertyType
                    //为age property 添加一个属性编辑器（完成String -> Integer 的转换）
                    if("age".equals(propertyDescriptor.getName())){
                        propertyDescriptor.setPropertyEditorClass(MyString2IntegerPropertyEditor.class);
                    }
                });

    }

    /**
     * 自定义String -> Integer 的转换
     */
    static class MyString2IntegerPropertyEditor extends PropertyEditorSupport{

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
             Integer value =  Integer.valueOf(text);
             setValue(value);
        }

    }
}
