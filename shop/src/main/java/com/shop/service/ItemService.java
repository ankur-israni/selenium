package com.shop.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.shop.domain.Cart;
import com.shop.domain.CartItem;
import com.shop.domain.Item;

public class ItemService implements Serializable {

	private static final long serialVersionUID = -1811603733753657411L;

	public Map<String, Item> getItems() {
		Map<String, Item> items = new HashMap<>();
		items.put("I-123", new Item("I-123", "Chair", 30.9f, "24 x 34 x 67", "chair1.png"));
		items.put("P-229", new Item("P-229", "Table", 40.1f, "34 x 34 x 67", "table1.png"));
		items.put("H-451", new Item("H-451", "Lamp", 09.9f, "44 x 34 x 67", "lamp1.png"));
		items.put("I-876", new Item("I-876", "Couch", 5.6f, "54 x 34 x 67", "couch1.png"));
		items.put("U-345", new Item("U-345", "Bed", 300.49f, "64 x 34 x 67", "bed1.png"));
		items.put("U-345", new Item("U-345", "Wardrobe", 300.49f, "64 x 34 x 67", "wardrobe1.png"));
		return items;
	}

	public Cart getCart(Map<String, Integer> selectedItems) {
		Cart cartz = new Cart();
		List<CartItem> cartItems = new ArrayList<>();
		Set<String> itemIds = selectedItems.keySet();
		for (String itemId : itemIds) {
			int quantity = selectedItems.get(itemId);
			String name = getItems().get(itemId).getName();
			Float price = getItems().get(itemId).getPrice();
			String dimensions = getItems().get(itemId).getDimensions();
			String image = getItems().get(itemId).getImage();

			Item item = new Item(itemId, name, price, quantity, dimensions, image);
			CartItem cartItem = new CartItem();
			cartItem.setItem(item);
			cartItem.setQuantity(quantity);
			cartItem.setTotalPrice(price * quantity);
			cartItems.add(cartItem);
		}
		cartz.setCartItems(cartItems);
		cartz.setGrandTotal(calculateGrandTotal(cartItems));
		return cartz;
	}

	private Float calculateGrandTotal(List<CartItem> cartItems) {
		Float grandTotal = 0.0f;
		if (cartItems != null) {
			for (CartItem cartItem : cartItems) {
				grandTotal += cartItem.getTotalPrice();
			}
		}
		return grandTotal;
	}

}
