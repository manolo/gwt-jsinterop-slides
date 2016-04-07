package org.vaadin.manolo;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;


public class SlideExport1  {
    
    @JsType
    public interface HasName {
        @JsProperty void setName(String name);
        @JsProperty String getName();
    }
    
    @JsType
    public class Employee implements HasName {
        private String name;
        @JsProperty public String getName() {
            return name;
        }
        @JsProperty public void setName(String name) {
            this.name = name;
        }
    }
    
    // JSNI block to demonstrate Usage in javascript
    public native void runJs() /*-{
        var window = $wnd;
        
        var employee = new window.vaadin.SlideExport1.Employee();
        employee.name = "Manolo";
        console.log(employee.name); // Manolo
    }-*/;

    public void run() {
        runJs();
    }
}
