package com.yammer.metrics.guice;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.yammer.metrics.core.MetricsRegistry;
import com.yammer.metrics.reporting.JmxReporter;

import java.util.concurrent.TimeUnit;

public class JmxReporterProvider implements Provider<JmxReporter>
{
    private final MetricsRegistry metricsRegistry;

    @Inject
    public JmxReporterProvider(MetricsRegistry metricsRegistry) {
        this.metricsRegistry = metricsRegistry;
    }

    @Override
    public JmxReporter get() {
        JmxReporter reporter = new JmxReporter(metricsRegistry);
        reporter.start(1, TimeUnit.MINUTES);
        return reporter;
    }
}
