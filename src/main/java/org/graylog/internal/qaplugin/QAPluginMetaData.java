package org.graylog.internal.qaplugin;

import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.ServerStatus;
import org.graylog2.plugin.Version;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

/**
 * Implement the PluginMetaData interface here.
 */
public class QAPluginMetaData implements PluginMetaData {
    @Override
    public String getUniqueId() {
        return "org.graylog.internal.qaplugin.QAPluginPlugin";
    }

    @Override
    public String getName() {
        return "Graylog QA Plugin";
    }

    @Override
    public String getAuthor() {
        return "Graylog, Inc";
    }

    @Override
    public URI getURL() {
        return URI.create("https://www.graylog.org/");
    }

    @Override
    public Version getVersion() {
        return new Version(1, 1, 0, "alpha.1");
    }

    @Override
    public String getDescription() {
        return "QA implementations of plugin APIs";
    }

    @Override
    public Version getRequiredVersion() {
        return new Version(2, 1, 0);
    }

    @Override
    public Set<ServerStatus.Capability> getRequiredCapabilities() {
        return Collections.emptySet();
    }
}
