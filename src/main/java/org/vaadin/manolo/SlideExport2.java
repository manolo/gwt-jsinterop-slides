package org.vaadin.manolo;

import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;


public class SlideExport2  {
    
    @JsType
    public interface HasName {
        @JsProperty void setName(String name);
        @JsProperty String getName();
        
        @JsIgnore String getType();
        
        // Defender methods are supported
        default String getDescription(){
            return getType() + ": " + getName();
        };
    }

    @JsType
    public class Employee implements HasName {
        private String name;
        // Having to define @JsProperty and @JsIgnore is a bug #9313
        @JsProperty public String getName() {
            return name;
        }
        @JsProperty public void setName(String name) {
            this.name = name;
        }
        @JsIgnore public String getType() {
            return "Employee";
        }
    }
    
    public static class Company implements HasName {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getType() {
            return "Company";
        }
    }
    
    // Company cannot be created in JS
    public native void runJs(Company company) /*-{
        var window = $wnd;
        
        var employee = new window.vaadin.SlideExport2.Employee();
        employee.name = "Manolo";
        company.name = "Vaadin";
        console.log(company.getDescription()); // Company: Vaadin
        console.log(employee.getDescription()); // Employee: Manolo
    }-*/;

    public void run() {
        runJs(new Company());
    }
}
