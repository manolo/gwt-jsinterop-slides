package org.vaadin.manolo;

import static com.google.gwt.query.client.GQuery.console;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsType;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;

public class SlideJs3  {
    
    @JsType(isNative = true)
    public static class HTMLElement {
        public String innerHTML;
        public String tagName;
        public String textContent;
        public native void appendChild(HTMLElement child);
        
        // Easy way to pass java callbacks to JS
        public native void addEventListener(String name, EventCall f);
    }
    
    // Recommended to annotate with functional-interface
    @JsFunction @FunctionalInterface
    interface EventCall {
        void onEvent(NativeEvent e);
    }
    
    public void run() {
        HTMLElement body = (HTMLElement)(Object)Document.get().getBody();
        HTMLElement button = (HTMLElement)(Object)Document.get().createElement("button");
        button.innerHTML = "Click";
        body.appendChild(button);
        
        // lambda support
        button.addEventListener("click", e -> console.log(e));
        
        // Java 1.7
        button.addEventListener("focus", new EventCall() {
            public void onEvent(NativeEvent e) {
                console.log(e);
            }
        });
    }
}
