package org.graylog.internal.qaplugin;

import org.graylog2.plugin.Plugin;
import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.PluginModule;

import java.util.Arrays;
import java.util.Collection;

/**
 * Implement the Plugin interface here.
 */
public class QAPluginPlugin implements Plugin {
    @Override
    public PluginMetaData metadata() {
        return new QAPluginMetaData();
    }

    @Override
    public Collection<PluginModule> modules () {
        return Arrays.<PluginModule>asList(new QAPluginModule());
    }
}
