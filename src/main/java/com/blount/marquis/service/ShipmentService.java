package com.blount.marquis.service;


import com.blount.marquis.model.Shipment;

/**
 * Created by Marquis Blount I on 2/2/19.
 */
public interface ShipmentService {

  void shipmentLocationUpdate(Shipment shipment) throws InterruptedException;
}
