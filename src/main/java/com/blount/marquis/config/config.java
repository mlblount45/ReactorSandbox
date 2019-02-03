package com.blount.marquis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.Environment;
import reactor.bus.EventBus;

/**
 * Created by Marquis Blount I on 2/2/19.
 */
@Configuration
public class config {

  @Bean
  Environment env() {
    return Environment.initializeIfEmpty().assignErrorJournal();
  }

  @Bean
  EventBus createEventBus(Environment env) {
    return EventBus.create(env, Environment.THREAD_POOL);
  }
}
