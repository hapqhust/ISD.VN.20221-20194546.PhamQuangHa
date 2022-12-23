package controller;

import entity.cart.Cart;
import entity.cart.CartMedia;

import entity.invoice.Invoice;
import entity.order.Order;
import entity.order.OrderMedia;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;


/**
 * This class controls the flow of place order usecase in our AIMS project.
 * 
 * @author HaPham
 * @version 1.0
 */
public class PlaceOrderController extends BaseController {

  private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());

  /**
   * This method checks the avalibility of product when user click PlaceOrder button.
   * 
   * @throws SQLException when SQLException happen
   */
  public void placeOrder() throws SQLException {
    Cart.getCart().checkAvailabilityOfProduct();
  }

  /**
   * This method creates the new Order based on the Cart.
   * 
   * @return Order
   * @throws SQLException when SQLException happen
   */
  public Order createOrder() throws SQLException {
    Order order = new Order();
    for (Object object : Cart.getCart().getListMedia()) {
      CartMedia cartMedia = (CartMedia) object;
      OrderMedia orderMedia =
          new OrderMedia(cartMedia.getMedia(), cartMedia.getQuantity(), cartMedia.getPrice());
      order.getlstOrderMedia().add(orderMedia);
    }
    return order;
  }

  /**
   * This method creates the new Invoice based on order.
   * 
   * @param order order
   * @return Invoice
   */
  public Invoice createInvoice(Order order) {
    return new Invoice(order);
  }

  /**
   * This method takes responsibility for processing the shipping info from user.
   * 
   * @param info info
   * @throws InterruptedException when InterruptException happen
   * @throws IOException when IOException happen
   */
  public void processDeliveryInfo(HashMap<String, String> info)
      throws InterruptedException, IOException {
    LOGGER.info("Process Delivery Info");
    LOGGER.info(info.toString());
    validateDeliveryInfo(info);
  }

  /**
   * The method validates the info.
   * 
   * @param info info
   * @throws InterruptedException when InterruptException happen
   * @throws IOException when IOException happen
   */
  public void validateDeliveryInfo(HashMap<String, String> info)
      throws InterruptedException, IOException {
    if (!validateName(info.get("name"))) {
      System.out.println("Invalid name!");
    }
    if (!validatePhoneNumber(info.get("phone"))) {
      System.out.println("Invalid phone number!");
    }
    if (!validateAddress(info.get("address"))) {
      System.out.println("Invalid address!");
    }
    return;
  }


  /**
   * This method validate customer's phone number.
   * 
   * @param phoneNumber phone number
   * @return boolean
   */
  public boolean validatePhoneNumber(String phoneNumber) {
    // verify if phone has 10 digits and start with 0
    if (phoneNumber.length() != 10 || phoneNumber.charAt(0) != '0') {
      return false;
    }
    // verify if phone contains only number
    try {
      Integer.parseInt(phoneNumber);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }


  /**
   * This medthod validate customer's name.
   * 
   * @param name name
   * @return boolean
   */
  public boolean validateName(String name) {
    if (name == null || name.trim().length() == 0 || name.equals("null")) {
      return false;
    }
    return name.matches("^[a-zA-Z]+[\\-'\\s]?[a-zA-Z ]+$");
  }


  /**
   * This method validate customer's address.
   * 
   * @param address address
   * @return boolean
   */
  public boolean validateAddress(String address) {
    if (address == null || address.trim().length() == 0 || address.equals("null")) {
      return false;
    }
    return address.matches("^[.0-9a-zA-Z\\s,-]+$");
  }

  /**
   * This method calculates the shipping fees of order.
   * 
   * @param order order
   * @return shippingFee
   */
  public int calculateShippingFee(Order order) {
    Random rand = new Random();
    int fees = (int) (((rand.nextFloat() * 10) / 100) * order.getAmount());
    LOGGER.info("Order Amount: " + order.getAmount() + " -- Shipping Fees: " + fees);
    return fees;
  }
}
