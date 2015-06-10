package org.graylog.internal.qaplugin.alarmcallback;

import org.graylog.internal.qaplugin.helpers.RequestedConfigurationHelper;
import org.graylog2.plugin.alarms.AlertCondition;
import org.graylog2.plugin.alarms.callbacks.AlarmCallback;
import org.graylog2.plugin.alarms.callbacks.AlarmCallbackConfigurationException;
import org.graylog2.plugin.alarms.callbacks.AlarmCallbackException;
import org.graylog2.plugin.configuration.Configuration;
import org.graylog2.plugin.configuration.ConfigurationException;
import org.graylog2.plugin.configuration.ConfigurationRequest;
import org.graylog2.plugin.streams.Stream;

import java.util.Map;

public class VeryConfigurableAlarmCallback implements AlarmCallback {
    @Override
    public void initialize(Configuration config) throws AlarmCallbackConfigurationException {

    }

    @Override
    public void call(Stream stream, AlertCondition.CheckResult result) throws AlarmCallbackException {

    }

    @Override
    public ConfigurationRequest getRequestedConfiguration() {
        return RequestedConfigurationHelper.buildWithAllOptions();
    }

    @Override
    public String getName() {
        return "Very Configurable Alarm Callback";
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public void checkConfiguration() throws ConfigurationException {

    }
}
