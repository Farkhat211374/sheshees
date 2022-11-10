module com.example.demo1 {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
//    requires opencsv;
    requires json.simple;
    requires javafx.media;
    //requires fontawesomefx.glyphsbrowser.all;
    //requires fontawesomefx.glyphsbrowser.all;
    //requires de.jensd.fx.glyphs.fontawesome;
    //requires fontawesomefx.glyphsbrowser.all;

    opens com.example.demo1 to javafx.fxml, javafx.base;
    exports com.example.demo1;
}