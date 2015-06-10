package org.graylog.internal.qaplugin;

import org.graylog.internal.qaplugin.alarmcallback.VeryConfigurableAlarmCallback;
import org.graylog.internal.qaplugin.codec.VeryConfigurableCodec;
import org.graylog.internal.qaplugin.input.VeryConfigurableInput;
import org.graylog.internal.qaplugin.output.CountingOutput;
import org.graylog.internal.qaplugin.transport.VeryConfigurableTransport;
import org.graylog2.plugin.PluginConfigBean;
import org.graylog2.plugin.PluginModule;

import java.util.Collections;
import java.util.Set;

/**
 * Extend the PluginModule abstract class here to add you plugin to the system.
 */
public class QAPluginModule extends PluginModule {
    /**
     * Returns all configuration beans required by this plugin.
     *
     * Implementing this method is optional. The default method returns an empty {@link Set}.
     */
    @Override
    public Set<? extends PluginConfigBean> getConfigBeans() {
        return Collections.emptySet();
    }

    @Override
    protected void configure() {
        addMessageOutput(CountingOutput.class);
        installCodec(codecMapBinder(), "very-configurable-codec", VeryConfigurableCodec.class);
        installTransport(transportMapBinder(), "very-configurable-transport", VeryConfigurableTransport.class);
        installInput(inputsMapBinder(), VeryConfigurableInput.class, VeryConfigurableInput.Factory.class);
        addAlarmCallback(VeryConfigurableAlarmCallback.class);
    }
}
