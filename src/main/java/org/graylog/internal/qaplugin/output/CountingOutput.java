package org.graylog.internal.qaplugin.output;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;
import com.google.common.collect.Maps;
import org.graylog.internal.qaplugin.helpers.RequestedConfigurationHelper;
import org.graylog2.plugin.Message;
import org.graylog2.plugin.configuration.Configuration;
import org.graylog2.plugin.configuration.ConfigurationRequest;
import org.graylog2.plugin.configuration.fields.BooleanField;
import org.graylog2.plugin.configuration.fields.ConfigurationField;
import org.graylog2.plugin.configuration.fields.DropdownField;
import org.graylog2.plugin.configuration.fields.NumberField;
import org.graylog2.plugin.configuration.fields.TextField;
import org.graylog2.plugin.inputs.annotations.ConfigClass;
import org.graylog2.plugin.inputs.annotations.FactoryClass;
import org.graylog2.plugin.outputs.MessageOutput;
import org.graylog2.plugin.streams.Stream;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.codahale.metrics.MetricRegistry.name;

public class CountingOutput implements MessageOutput {
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    private final Counter messageCounter;

    @Inject
    public CountingOutput(MetricRegistry metricRegistry) {
        messageCounter = metricRegistry.counter(name(CountingOutput.class, "messages"));
        isRunning.set(true);
    }

    @Override
    public void stop() {
        isRunning.set(false);
    }

    @Override
    public boolean isRunning() {
        return isRunning.get();
    }

    @Override
    public void write(Message message) throws Exception {
        messageCounter.inc();
    }

    @Override
    public void write(List<Message> messages) throws Exception {
        messageCounter.inc(messages.size());
    }

    @FactoryClass
    public interface Factory extends MessageOutput.Factory<CountingOutput> {
        @Override
        CountingOutput create(Stream stream, Configuration configuration);

        @Override
        Config getConfig();

        @Override
        Descriptor getDescriptor();
    }

    @ConfigClass
    public static class Config extends MessageOutput.Config {
        @Override
        public ConfigurationRequest getRequestedConfiguration() {
            return RequestedConfigurationHelper.buildWithAllOptions();
        }
    }

    public static class Descriptor extends MessageOutput.Descriptor {
        public Descriptor() {
            super("Counting output (QA Plugin)", false, "", "Output that counts the messages it receives as a metric");
        }
    }

}
