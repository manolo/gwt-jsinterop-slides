package org.vaadin.manolo;

import static com.google.gwt.query.client.GQuery.console;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import com.google.gwt.core.client.JavaScriptObject;

public class SlideJsPojo {

    // JsInterop is very useful for implementing POJOs as JSON objects
    @JsType(isNative = true)
    interface Employee {
        @JsProperty void setName(String name);
        @JsProperty String getName();
    }

    public void run() {
        // Any JSO can be an instance of your POJO
        Employee e = JavaScriptObject.createObject().cast();
        
        e.setName("Manolo");
        
        console.log(e);  // Object {name: "Manolo"}
    }
}
