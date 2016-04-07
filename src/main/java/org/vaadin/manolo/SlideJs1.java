package org.vaadin.manolo;

import jsinterop.annotations.JsType;

import com.google.gwt.dom.client.Document;

public class SlideJs1  {
    
    //// Mapping JS objects with Classes
    @JsType(isNative = true)
    public static class HTMLElement {
        public String innerHTML;
        public String textContent;
        public String tagName;
        public native void appendChild(HTMLElement child);
    }
    
    public void run() {
        //// Needs to force casting
        HTMLElement body = (HTMLElement)(Object)Document.get().getBody();
        HTMLElement button = (HTMLElement)(Object)Document.get().createElement("button");
        
        // class variables mapped as JS properties 
        button.innerHTML = "Click";
        body.appendChild(button);
    }
    
}
