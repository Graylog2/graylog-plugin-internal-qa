package org.graylog.internal.qaplugin.transport;

import com.codahale.metrics.MetricSet;
import org.graylog.internal.qaplugin.helpers.RequestedConfigurationHelper;
import org.graylog2.plugin.configuration.Configuration;
import org.graylog2.plugin.configuration.ConfigurationRequest;
import org.graylog2.plugin.inputs.MessageInput;
import org.graylog2.plugin.inputs.MisfireException;
import org.graylog2.plugin.inputs.annotations.ConfigClass;
import org.graylog2.plugin.inputs.annotations.FactoryClass;
import org.graylog2.plugin.inputs.codecs.CodecAggregator;
import org.graylog2.plugin.inputs.transports.Transport;

public class VeryConfigurableTransport implements Transport {
    @Override
    public void setMessageAggregator(CodecAggregator aggregator) {

    }

    @Override
    public void launch(MessageInput input) throws MisfireException {

    }

    @Override
    public void stop() {

    }

    @Override
    public MetricSet getMetricSet() {
        return null;
    }

    @FactoryClass
    public interface Factory extends Transport.Factory<VeryConfigurableTransport> {
        @Override
        VeryConfigurableTransport create(Configuration configuration);

        @Override
        Config getConfig();
    }

    @ConfigClass
    public static class Config implements Transport.Config {
        @Override
        public ConfigurationRequest getRequestedConfiguration() {
            return RequestedConfigurationHelper.buildWithAllOptions();
        }
    }
}
