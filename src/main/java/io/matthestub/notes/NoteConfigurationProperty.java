package io.matthestub.notes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties("note")
public class NoteConfigurationProperty {

    private Template template;

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public static class Template {

        private boolean allowMultipleNotesFromTemplate;

        public boolean isAllowMultipleNotesFromTemplate() {
            return allowMultipleNotesFromTemplate;
        }

        public void setAllowMultipleTasksFromTemplate(boolean allowMultipleNotesFromTemplate) {
            this.allowMultipleNotesFromTemplate = allowMultipleNotesFromTemplate;
        }
    }

}
