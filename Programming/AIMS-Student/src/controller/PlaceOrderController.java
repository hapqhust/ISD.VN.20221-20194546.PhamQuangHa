package controller;

import entity.cart.Cart;
import entity.cart.CartMedia;

import entity.invoice.Invoice;
import entity.order.Order;
import entity.order.OrderMedia;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import controller.validate.ValidateController;

// -------------Procedural Cohesion----------------

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
  public int processDeliveryInfo(HashMap<String, String> info)
      throws InterruptedException, IOException {
    LOGGER.info("Process Delivery Info");
    LOGGER.info(info.toString());
    return validateDeliveryInfo(info);
  }

  /**
   * The method validates the info.
   * 
   * @param info info
   * @return int
   * @throws InterruptedException when InterruptException happen
   * @throws IOException when IOException happen
   */
  public int validateDeliveryInfo(HashMap<String, String> info)
      throws InterruptedException, IOException {
      ValidateController valController = new ValidateController();

    if (!valController.validateName(info.get("name"))) {
      System.out.println("Invalid name!");
      JOptionPane.showMessageDialog(null, "Invalid name!",
      "Error", JOptionPane.ERROR_MESSAGE);
      return 0;
    }
    if (!valController.validatePhoneNumber(info.get("phone"))) {
      System.out.println("Invalid phone number!");
      JOptionPane.showMessageDialog(null, "Invalid phone number!",
      "Error", JOptionPane.ERROR_MESSAGE);
      return 0;
    }
    if (!valController.validateAddress(info.get("address"))) {
      System.out.println("Invalid address!");
      JOptionPane.showMessageDialog(null, "Invalid address!",
      "Error", JOptionPane.ERROR_MESSAGE);
      return 0;
    }
    return 1;
  }


}
