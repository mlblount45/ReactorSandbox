package com.blount.marquis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blount.marquis.model.Shipment;

import reactor.bus.Event;
import reactor.fn.Consumer;

/**
 * Created by Marquis Blount I on 2/2/19.
 */
@Service
public class EventHandler implements Consumer<Event<Shipment>> {

  private static final Logger log = LoggerFactory.getLogger(EventHandler.class);
  private final ShipmentService shipmentService;

  @Autowired
  public EventHandler(ShipmentService shipmentService) {
    this.shipmentService = shipmentService;
  }

  @Override
  public void accept(Event<Shipment> shipmentEvent) {
    Shipment shipment = shipmentEvent.getData();
    try {
      shipmentService.shipmentLocationUpdate(shipment);
    } catch (InterruptedException e) {
      log.error("Well shit", e);
    }
  }
}
