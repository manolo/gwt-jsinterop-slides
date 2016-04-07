package org.vaadin.manolo;

import java.util.ArrayList;
import java.util.Arrays;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;


public class SlideExport3  {
    
    @JsType
    public interface HasName {
        @JsProperty void setName(String name);
        @JsProperty String getName();
    }
    @JsType
    public interface HasSkills {
        @JsProperty void setSkills(String[] skills);
        @JsProperty String[] getSkills();
    }

    @JsType
    public class Employee implements HasName, HasSkills {
        private String name;
        private String[] skills;
        @JsProperty public String getName() {
            return name;
        }
        @JsProperty public void setName(String name) {
            this.name = name;
        }
        @JsProperty public void setSkills(String[] skills) {
            this.skills = skills;
        }
        @JsProperty public String[] getSkills() {
            return skills;
        }
        public String skillsToString() {
            return new ArrayList<String>(Arrays.asList(skills)).toString();
        }
        public void setSkillsVararg(String... s){
            this.skills = s;
        }
    }
    
    public native void runJs() /*-{
        var window = $wnd;
        
        var employee = new window.vaadin.SlideExport3.Employee();
        employee.name = "Manolo";
        employee.skills = ["Java", "Gwt"];
        console.log(employee.name, employee.skills, employee.skillsToString()); // Manolo ["Java", "Gwt"] [Java, Gwt]
        employee.setSkillsVararg("Guitar", "Lute", "Violin");
        console.log(employee.skillsToString()); // [Guitar, Lute, Violin]
    }-*/;

    public void run() {
        runJs();
    }
}
