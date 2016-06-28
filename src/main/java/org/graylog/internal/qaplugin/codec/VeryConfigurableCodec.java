package org.graylog.internal.qaplugin.codec;

import com.google.inject.assistedinject.Assisted;
import org.graylog.internal.qaplugin.helpers.RequestedConfigurationHelper;
import org.graylog2.plugin.Message;
import org.graylog2.plugin.configuration.Configuration;
import org.graylog2.plugin.configuration.ConfigurationRequest;
import org.graylog2.plugin.inputs.annotations.ConfigClass;
import org.graylog2.plugin.inputs.annotations.FactoryClass;
import org.graylog2.plugin.inputs.codecs.AbstractCodec;
import org.graylog2.plugin.inputs.annotations.Codec;
import org.graylog2.plugin.journal.RawMessage;

import javax.annotation.Nullable;
import javax.inject.Inject;

@Codec(name = "internal-qa", displayName = "Very configurable codec")
public class VeryConfigurableCodec extends AbstractCodec {
    @Inject
    public VeryConfigurableCodec(@Assisted Configuration configuration) {
        super(configuration);
    }

    @Nullable
    @Override
    public Message decode(RawMessage rawMessage) {
        return null;
    }

    @ConfigClass
    public static class Config extends AbstractCodec.Config {
        @Override
        public ConfigurationRequest getRequestedConfiguration() {
            return RequestedConfigurationHelper.buildWithAllOptions();
        }
    }

    @FactoryClass
    public interface Factory extends AbstractCodec.Factory<VeryConfigurableCodec> {
        @Override
        VeryConfigurableCodec create(Configuration configuration);

        @Override
        Config getConfig();

        @Override
        Descriptor getDescriptor();
    }

    public static class Descriptor extends AbstractCodec.Descriptor {
        @Inject
        public Descriptor() {
            super(VeryConfigurableCodec.class.getAnnotation(Codec.class).displayName());
        }
    }
}
