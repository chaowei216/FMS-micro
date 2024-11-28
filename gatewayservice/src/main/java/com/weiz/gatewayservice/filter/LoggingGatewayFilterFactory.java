package com.weiz.gatewayservice.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component("logging")
public class LoggingGatewayFilterFactory extends AbstractGatewayFilterFactory<LoggingGatewayFilterFactory.Config> {

    final Logger logger =
            LoggerFactory.getLogger(LoggingGatewayFilterFactory.class);

    public LoggingGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(LoggingGatewayFilterFactory.Config config) {

        return new OrderedGatewayFilter((exchange, chain) -> {
            // Pre-processing
            logger.info("Pre gateway filter logging: ");
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        // Post-processing
                        logger.info("Post gateway filter logging: ");
                    }));
        }, -2);

    }

    public static class Config {

        private String baseMsg;

        public void setBaseMsg(String baseMsg) {
            this.baseMsg = baseMsg;
        }

        public String getBaseMsg() {
            return baseMsg;
        }
    }
}
