package org.vaadin.manolo;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

import com.google.gwt.dom.client.Document;

public class SlideJs2  {
    
    //// Mapping JS objects with Interfaces
    @JsType(isNative = true)
    public interface HTMLElement {
        @JsProperty
        String getInnerHTML();
        @JsProperty
        void setInnerHTML(String s);

        @JsProperty
        String getTextContent();
        @JsProperty
        void setTextContent(String s);

        @JsProperty(name = "tagName")
        String getTag();

        public void appendChild(HTMLElement child);
    }
    
    public void run() {
        //// Interfaces make easy casting GWT JSOs.
        HTMLElement body = (HTMLElement)Document.get().getBody();
        HTMLElement button = Document.get().createElement("button").cast();
        button.setInnerHTML("Click");
        
        body.appendChild(button);
    }
}
