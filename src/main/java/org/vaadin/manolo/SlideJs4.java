package org.vaadin.manolo;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;


public class SlideJs4  {
    
    @JsType(isNative = true, namespace = JsPackage.GLOBAL)
    public static class HTMLElement {
        public String innerHTML;
        public String tagName;
        public String textContent;
        public native void appendChild(HTMLElement child);
        
        // Only usable from the Java side !!!
        @JsOverlay
        public final void setVisible(boolean b) {
          ((Element)(Object) this).getStyle().setDisplay(b ? Display.NONE: Display.BLOCK);  
        }
    }
    
    public void run() {
        HTMLElement body = (HTMLElement)(Object)Document.get().getBody();
        HTMLElement button = (HTMLElement)(Object)Document.get().createElement("button");
        button.innerHTML = "Click";
        body.appendChild(button);
        
        // Any JSO casted to this object will have this method
        button.setVisible(false);
    }
 }
