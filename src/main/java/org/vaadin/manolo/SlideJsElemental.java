package org.vaadin.manolo;

import static jsinterop.annotations.JsPackage.GLOBAL;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsType;

import com.google.gwt.dom.client.NativeEvent;

public class SlideJsElemental  {
    
    // How Elemental 2.0 will look like with JsInterop
    
    // Use abstract and static for directly use methods and properties
    // available in non instantiable Javascript objects
    @JsType(isNative = true, namespace = GLOBAL, name = "window")
    public abstract static class Window {
        public static Console console;
        public static Document document;
        public static native void alert(String s);
    }
    // Use classes to map JS Instances
    @JsType(isNative = true)
    public static class HTMLElement {
        public String innerHTML;
        public String tagName;
        public String textContent;
        public native void appendChild(HTMLElement child);
        public native void addEventListener(String name, EventCall f);
    }
    @JsType(isNative = true)
    public static class Document {
        public HTMLElement body;
        public HTMLElement head;
        public native HTMLElement createElement(String tagName); 
    }
    // Optionally use interfaces if you would like to test
    @JsType(isNative = true)
    public interface Console {
        void log(Object... o);
    }
    // Use JsFunction for callbacks
    @JsFunction @FunctionalInterface
    interface EventCall {
        void onEvent(NativeEvent e);
    }
    
    public void run1() {
        Window.alert("Hi");

        HTMLElement button = Window.document.createElement("button");
        button.innerHTML = "Click me";
        Window.document.body.appendChild(button);

        Window.console.log("Foo", Window.document.body);
    }
    
    // More examples
    @JsType(isNative = true, namespace = GLOBAL)
    public static abstract class Math {
        static native double min(double a, double b);
    }
    @JsType(isNative = true, namespace = GLOBAL)
    public static class RegExp {
        public native void compile(String s, String a);
        public native Object exec(String s);
    }
    
    public void run() {
        Window.console.log(Math.min(1, 2));  // 1
        
        RegExp re = new RegExp();
        re.compile(".Foo", "i");
        Window.console.log(re.exec("myfooBaz")); // ["yfoo", index: 1, input: "myfooBaz"]
    }
}
