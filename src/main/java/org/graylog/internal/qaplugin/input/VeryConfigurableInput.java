package org.graylog.internal.qaplugin.input;

import com.codahale.metrics.MetricRegistry;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import org.graylog.internal.qaplugin.codec.VeryConfigurableCodec;
import org.graylog.internal.qaplugin.transport.VeryConfigurableTransport;
import org.graylog2.plugin.LocalMetricRegistry;
import org.graylog2.plugin.ServerStatus;
import org.graylog2.plugin.configuration.Configuration;
import org.graylog2.plugin.inputs.MessageInput;
import org.graylog2.plugin.inputs.codecs.Codec;

import javax.inject.Inject;

public class VeryConfigurableInput extends MessageInput {
    private static final String NAME = "A Very Configurable Input";

    @AssistedInject
    public VeryConfigurableInput(MetricRegistry metricRegistry,
                                 @Assisted Configuration configuration,
                                 VeryConfigurableTransport.Factory transportFactory,
                                 LocalMetricRegistry localRegistry,
                                 VeryConfigurableCodec.Factory codecFactory,
                                 Config config,
                                 Descriptor descriptor,
                                 ServerStatus serverStatus) {
        super(metricRegistry, configuration, transportFactory.create(configuration), localRegistry, codecFactory.create(configuration), config, descriptor, serverStatus);
    }

    public interface Factory extends MessageInput.Factory<VeryConfigurableInput> {
        @Override
        VeryConfigurableInput create(Configuration configuration);

        @Override
        Config getConfig();

        @Override
        Descriptor getDescriptor();
    }

    public static class Descriptor extends MessageInput.Descriptor {
        @Inject
        public Descriptor() {
            super(NAME, false, "");
        }
    }

    public static class Config extends MessageInput.Config {
        @Inject
        protected Config(VeryConfigurableTransport.Factory transport, VeryConfigurableCodec.Factory codec) {
            super(transport.getConfig(), codec.getConfig());
        }
    }
}
