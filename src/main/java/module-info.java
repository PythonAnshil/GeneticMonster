module org.java.introduction.geneticmonster {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires kotlin.stdlib;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens org.java.introduction.geneticmonster to javafx.fxml;
    exports org.java.introduction.geneticmonster;
}