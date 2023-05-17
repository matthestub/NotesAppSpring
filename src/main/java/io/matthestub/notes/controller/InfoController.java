package io.matthestub.notes.controller;

import io.matthestub.notes.NoteConfigurationProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private final DataSourceProperties dataSourceProperties;
    private final NoteConfigurationProperty noteConfigurationProperty;

    public InfoController(DataSourceProperties dataSourceProperties, NoteConfigurationProperty noteConfigurationProperty) {
        this.dataSourceProperties = dataSourceProperties;
        this.noteConfigurationProperty = noteConfigurationProperty;
    }

    @GetMapping("/info/url")
    public String url() {
        return dataSourceProperties.getUrl();
    }

    @GetMapping("/info/taskProp")
    public boolean taskProp() {
        return noteConfigurationProperty.getTemplate().isAllowMultipleNotesFromTemplate();
    }
}
