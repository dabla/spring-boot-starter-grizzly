package org.springframework.boot.grizzly.config;

import org.glassfish.grizzly.http.CompressionConfig.CompressionMode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import javax.inject.Named;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.emptySet;
import static java.util.Collections.unmodifiableSet;
import static javax.ws.rs.core.MediaType.*;
import static org.glassfish.grizzly.http.CompressionConfig.CompressionMode.OFF;

@Named
@ConfigurationProperties(prefix = "grizzly")
public class GrizzlyProperties {
    public static final int DEFAULT_COMPRESSION_MIN_SIZE = 10 * 1024;
    public static final String TEXT_JAVASCRIPT = "text/javascript";

    private final Http http = new Http();
    private final Jsp jsp = new Jsp();

    public static class Http {
        private String scheme = "http";
        private String host = "0.0.0.0";
        private int port = 8080;
        private String path = "/";
        private CompressionMode compressionMode = OFF;
        private String[] compressableMimeTypes = new String[] { APPLICATION_JSON, APPLICATION_XML, TEXT_JAVASCRIPT, TEXT_PLAIN, TEXT_HTML };
        private int minimimCompressionSize = DEFAULT_COMPRESSION_MIN_SIZE;

        public String getScheme() {
            return scheme;
        }

        public void setScheme(String scheme) {
            this.scheme = scheme;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public CompressionMode getCompressionMode() {
            return compressionMode;
        }

        public void setCompressionMode(CompressionMode compressionMode) {
            this.compressionMode = compressionMode;
        }

        public String[] getCompressableMimeTypes() {
            return compressableMimeTypes;
        }

        public void setCompressableMimeTypes(String... compressableMimeTypes) {
            this.compressableMimeTypes = compressableMimeTypes;
        }

        public int getMinimimCompressionSize() {
            return minimimCompressionSize;
        }

        public void setMinimimCompressionSize(int minimimCompressionSize) {
            this.minimimCompressionSize = minimimCompressionSize;
        }
    }

    public static class Jsp {
        private String[] urlMapping = new String[0];

        public String[] getUrlMapping() {
            return urlMapping;
        }

        public void setUrlMapping(String... urlMapping) {
            this.urlMapping = urlMapping;
        }
    }

    public Http getHttp() {
        return http;
    }

    public Jsp getJsp() {
        return jsp;
    }
}
