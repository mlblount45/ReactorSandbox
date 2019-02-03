package com.blount.marquis;

import static reactor.bus.selector.Selectors.$;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blount.marquis.model.Shipment;
import com.blount.marquis.service.EventHandler;

import reactor.bus.Event;
import reactor.bus.EventBus;

@SpringBootApplication
public class App implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(App.class);
  private final EventBus eventBus;
  private final EventHandler eventHandler;

  @Autowired
  public App(EventBus eventBus, EventHandler eventHandler) {
    this.eventBus = eventBus;
    this.eventHandler = eventHandler;
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {
    eventBus.on($("eventHandler"), eventHandler);

    //Publish messages here
    for (int i = 0; i < 10; i++) {
      Shipment shipment = new Shipment();
      shipment.setShipmentId(String.valueOf(i));
      eventBus.notify("eventHandler", Event.wrap(shipment));
      log.info("Published shipment number {}.", i);
    }
  }
}
