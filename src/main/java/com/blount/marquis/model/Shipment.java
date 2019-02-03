package com.blount.marquis.model;

import lombok.Data;

/**
 * Created by Marquis Blount I on 2/2/19.
 */
@Data
public class Shipment {

  private String shipmentId;
  private String name;
  private String currentLocation;
  private String deliveryAddress;
  private String status;
}
