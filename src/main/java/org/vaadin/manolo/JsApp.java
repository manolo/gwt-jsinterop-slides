package org.vaadin.manolo;

import static com.google.gwt.query.client.GQuery.console;

import com.google.gwt.core.client.EntryPoint;

public class JsApp implements EntryPoint {
    
    public void onModuleLoad() {
        if ("false".equals(System.getProperty("production"))) {
            console.log("Property production is false");
        } else {
            console.log("Property production is true");
        }
        
        new SlideJs2().run();
        new SlideJs1().run();
        new SlideJs3().run();
        new SlideJs4().run();
        new SlideJsPojo().run();
        new SlideJsElemental().run();
        new SlideExport1().run();
        new SlideExport2().run();
        new SlideExport3().run();
    }
}
