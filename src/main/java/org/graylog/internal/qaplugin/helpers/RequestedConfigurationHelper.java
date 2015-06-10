package org.graylog.internal.qaplugin.helpers;

import com.google.common.collect.Maps;
import org.graylog2.plugin.configuration.ConfigurationRequest;
import org.graylog2.plugin.configuration.fields.BooleanField;
import org.graylog2.plugin.configuration.fields.ConfigurationField;
import org.graylog2.plugin.configuration.fields.DropdownField;
import org.graylog2.plugin.configuration.fields.NumberField;
import org.graylog2.plugin.configuration.fields.TextField;

import java.util.Map;

public class RequestedConfigurationHelper {
    public static ConfigurationRequest buildWithAllOptions() {
        final ConfigurationRequest r = new ConfigurationRequest();

            /* Boolean fields */
        r.addField(new BooleanField("bool_true_field", "Boolean Field (true)", true, "bool field with default: true"));
        r.addField(new BooleanField("bool_false_field", "Boolean Field (false)", false, "bool field with default: false"));

            /* Dropdown fields */
        Map<String, String> dropdownEntries = Maps.newHashMap();
        dropdownEntries.put("first", "first");
        dropdownEntries.put("second", "second");
        dropdownEntries.put("third", "third");
        r.addField(new DropdownField("dropdown_1", "Dropdown Field (optional, second is default)", "second", dropdownEntries, ConfigurationField.Optional.OPTIONAL));
        r.addField(new DropdownField("dropdown_2", "Dropdown Field (optional, first is default)", "first", dropdownEntries, "with a description", ConfigurationField.Optional.OPTIONAL));
        r.addField(new DropdownField("dropdown_3", "Dropdown Field (required, third is default)", "third", dropdownEntries, "with a description", ConfigurationField.Optional.NOT_OPTIONAL));

            /* Number fields */
        r.addField(new NumberField("number_1", "Number Field (optional)", 23, "Optional field with default 23", ConfigurationField.Optional.OPTIONAL));
        r.addField(new NumberField("number_2", "Number Field (required)", 42, "Required field with default 42", ConfigurationField.Optional.NOT_OPTIONAL));
        r.addField(new NumberField("number_3", "Number Field (optional)", 443, "Optional port number field with default 443", ConfigurationField.Optional.OPTIONAL, NumberField.Attribute.IS_PORT_NUMBER));
        r.addField(new NumberField("number_4", "Number Field (optional)", -1, "Optional negative field with default -1", ConfigurationField.Optional.OPTIONAL, NumberField.Attribute.ONLY_NEGATIVE));
        r.addField(new NumberField("number_5", "Number Field (optional)", 1, "Optional positive field with default 1", ConfigurationField.Optional.OPTIONAL, NumberField.Attribute.ONLY_POSITIVE));

        r.addField(new TextField("text_1", "Text Field (optional)", "default", "Optional text field with 'default'", ConfigurationField.Optional.OPTIONAL));
        r.addField(new TextField("text_2", "Text Field (required)", "default", "Required text field with 'default'", ConfigurationField.Optional.NOT_OPTIONAL));
        r.addField(new TextField("text_3", "Text Field (required, password)", "default", "Required password with 'default'", ConfigurationField.Optional.NOT_OPTIONAL, TextField.Attribute.IS_PASSWORD));
        r.addField(new TextField("text_3", "Text Field (required, password)", "", "Required password without default", ConfigurationField.Optional.NOT_OPTIONAL, TextField.Attribute.IS_PASSWORD));
        r.addField(new TextField("text_4", "Text Field (required, taxt ares)", "default", "Required text area with 'default'", ConfigurationField.Optional.NOT_OPTIONAL, TextField.Attribute.TEXTAREA));
        return r;
    }
}
