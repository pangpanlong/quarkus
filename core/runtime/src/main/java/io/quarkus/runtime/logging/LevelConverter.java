package io.quarkus.runtime.logging;

import static io.quarkus.runtime.configuration.ConverterSupport.DEFAULT_QUARKUS_CONVERTER_PRIORITY;

import java.util.logging.Level;

import javax.annotation.Priority;

import org.eclipse.microprofile.config.spi.Converter;
import org.jboss.logmanager.LogContext;

/**
 * A simple converter for logging levels.
 */
@Priority(DEFAULT_QUARKUS_CONVERTER_PRIORITY)
public final class LevelConverter implements Converter<Level> {

    public Level convert(final String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return LogContext.getLogContext().getLevelForName(value);
    }
}
