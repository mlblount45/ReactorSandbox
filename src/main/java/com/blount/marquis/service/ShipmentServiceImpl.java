package com.blount.marquis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.blount.marquis.model.Shipment;


/**
 * Created by Marquis Blount I on 2/2/19.
 */
@Service
public class ShipmentServiceImpl implements ShipmentService {

  private static final Logger log = LoggerFactory.getLogger(ShipmentServiceImpl.class);

  @Override
  public void shipmentLocationUpdate(Shipment shipment) throws InterruptedException {
    log.info("Shipment Data: [{}]", shipment.getShipmentId());
    Thread.sleep(3000);
    log.info("Shipment with ID: [{}] reached", shipment.getShipmentId());
  }
}
