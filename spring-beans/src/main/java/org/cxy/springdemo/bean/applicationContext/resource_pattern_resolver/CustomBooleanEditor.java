package org.cxy.springdemo.bean.applicationContext.resource_pattern_resolver;

import com.sun.istack.internal.Nullable;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * Description:
 *
 * 一.
 * @see PropertyEditor
 *      )void setValue(Object value); 设置属性值
 *      )Object getValue(); 获取属性值
 *      )String getAsText(); 把属性值转换成 String
 *      )void setAsText(String text); 把 String 转换成属性值
 *
 *
 * 二.
 * @see PropertyEditorSupport
 *      JDK提供的PropertyEditor默认实现类，只要重写 setAsText 和 getAsText 方法就可以实现 String 类型到特定类型的转换了
 *
 *
 * 三.  CustomBooleanEditor
 *  <bean class="com.demo.property.editor.Job" id="job">
 *    <property name="completed" value="true" />
 *    <property name="started" value=""/>
 * </bean>
 *
 *  ->
 *   Job{completed=true, started=null}
 *
 *
 * </br>
 * Date: 2021/8/9 14:45
 *
 * @author :cxy </br>
 * @version : 1.0 </br>
 */
public class CustomBooleanEditor extends PropertyEditorSupport {

        public static final String VALUE_TRUE = "对";

        public static final String VALUE_FALSE = "错";


        //如果字符串为对，设置，默认null
        @Nullable
        private final String trueString;

        //如果字符串为错，设置，默认null
        @Nullable
        private final String falseString;


        // 是否允许为 null
        // 1.基本类型 boolean 不允许 "NULL" or "null"
        // 2.引用类型 Boolean 允许 "NULL" or "null"
        private final boolean allowEmpty;


        public CustomBooleanEditor() {
            this.trueString = "对";
            this.falseString = "错";
            this.allowEmpty = false;
        }

    public CustomBooleanEditor(boolean allowEmpty) {
        this.trueString = "对";
        this.falseString = "错";
        this.allowEmpty = allowEmpty;

    }



    /**
     * 设置属性值
     * @param text
     * @throws IllegalArgumentException
     */
        @Override
        public void setAsText(@Nullable String text) throws IllegalArgumentException {

            String input = (text != null ? text.trim() : null);

            if (this.allowEmpty && !StringUtils.hasLength(input)) {
                // Treat empty String as null value.
                setValue(null);
            } else if (this.trueString != null && this.trueString.equalsIgnoreCase(input)) {
                setValue(Boolean.TRUE);
            } else if (this.falseString != null && this.falseString.equalsIgnoreCase(input)) {
                setValue(Boolean.FALSE);
            } else {
                throw new IllegalArgumentException("Invalid boolean value [" + text + "]");
            }
        }

        @Override
        public String getAsText() {
            if (Boolean.TRUE.equals(getValue())) {
                return (this.trueString != null ? this.trueString : VALUE_TRUE);
            } else if (Boolean.FALSE.equals(getValue())) {
                return (this.falseString != null ? this.falseString : VALUE_FALSE);
            } else {
                return "";
            }
        }


    public static void main(String[] args) {
//        CustomBooleanEditor booleanEditor = new CustomBooleanEditor(true);
//        booleanEditor.setAsText("");
//        System.out.println(booleanEditor.getValue());

        CustomBooleanEditor BooleanEditor = new CustomBooleanEditor();
        BooleanEditor.setAsText("对");
        System.out.println(BooleanEditor.getValue());
    }

    }
