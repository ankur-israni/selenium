package com.shop.web;

import static com.shop.constants.Constants.ACTION;
import static com.shop.constants.Constants.ADD_TO_CART_ACTION;
import static com.shop.constants.Constants.BACK_BUTTON;
import static com.shop.constants.Constants.GENERIC_ACTION;
import static com.shop.constants.Constants.GENERIC_ACTION_LOGOUT;
import static com.shop.constants.Constants.GENERIC_ACTION_SELENIUM;
import static com.shop.constants.Constants.GENERIC_ACTION_SHOW_CART;
//import static com.shop.constants.Constants.INDEX;
import static com.shop.constants.Constants.INVALID_LOGIN_MESSAGE;
import static com.shop.constants.Constants.ITEMS_ATTRIBUTE;
import static com.shop.constants.Constants.ITEMS_PAGE;
import static com.shop.constants.Constants.ITEMS_URL;
import static com.shop.constants.Constants.LOGIN_ACTION;
import static com.shop.constants.Constants.LOGIN_PAGE;
import static com.shop.constants.Constants.LOGIN_URL;
import static com.shop.constants.Constants.PAGE;
import static com.shop.constants.Constants.REMOVE_FROM_CART_BUTTON;
import static com.shop.constants.Constants.SELECTED_ITEM_ID;
import static com.shop.constants.Constants.SELENIUM_ACTION;
import static com.shop.constants.Constants.SELENIUM_PAGE;
import static com.shop.constants.Constants.SELENIUM_URL;
import static com.shop.constants.Constants.SUMMARY_PAGE;
import static com.shop.constants.Constants.SUMMARY_URL;
import static com.shop.constants.Constants.TAB_HTML_CONTROLS;
import static com.shop.constants.Constants.TAB_HTML_TABLE;
import static com.shop.constants.Constants.CHECKOUT;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.shop.domain.Credentials;
import com.shop.service.ItemService;
import com.shop.validator.CredentialsValidator;

public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CredentialsValidator credentialsValidator;
	private ItemService itemService;
	private HttpSession session = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		credentialsValidator = new CredentialsValidator();
		itemService = new ItemService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String handleTabs(HttpServletRequest request, String action) {
		if (StringUtils.equalsIgnoreCase(SELENIUM_ACTION, action)) {
			return SELENIUM_URL;
		}

		String tab = StringUtils.trimToNull(request.getParameter("tab"));
		if (StringUtils.equalsIgnoreCase(TAB_HTML_CONTROLS, tab)) {
			return handleBackButton(request);
		} else if (StringUtils.equalsIgnoreCase(TAB_HTML_TABLE, tab)) {
			return handleBackButton(request);
		}
		return handleBackButton(request);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = StringUtils.trimToNull(request.getParameter(PAGE));
		String nextPage = null;

		nextPage = handleGenericActions(request, response);
		if (nextPage == null) {
			nextPage = handlePageActions(request, page, nextPage);
		}

		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);

	}

	private String handlePageActions(HttpServletRequest request, String page, String nextPage) {
		if (page != null) {
			String action = StringUtils.trimToNull(request.getParameter(ACTION));

			if (action != null) {
				// ---------------------Generic Actions------------------------
				/*
				 * if (StringUtils.equalsIgnoreCase(LOGOUT_ACTION, action)) {
				 * nextPage = handleLogout(request); }
				 */
				// ----------------Page Specific Actions -----------------------
				if (StringUtils.equalsIgnoreCase(LOGIN_PAGE, page)) {
					nextPage = handleLogin(request, action);
				} else if (StringUtils.equalsIgnoreCase(SELENIUM_PAGE, page)) {
					nextPage = handleTabs(request, action);
				} else if (StringUtils.equalsIgnoreCase(ITEMS_PAGE, page)) {
					// Integer quantity = 0;
					if (StringUtils.equalsIgnoreCase(ADD_TO_CART_ACTION, action)) {
						nextPage = handleAddToCart(request);
					} else if (StringUtils.equalsIgnoreCase(CHECKOUT, action)) {
						nextPage = handleShowCart(request);
					}

				} // page=items
				else if (StringUtils.equalsIgnoreCase(SUMMARY_PAGE, page)) {
					if (StringUtils.equalsIgnoreCase(BACK_BUTTON, action)) {
						nextPage = handleBackButton(request);
					} else if (StringUtils.equalsIgnoreCase(REMOVE_FROM_CART_BUTTON, action)) {
						nextPage = handleRemoveFromCart(request);
					}
				}
			}

		} else {
			nextPage = LOGIN_URL;
		}
		return nextPage;
	}

	private String handleGenericActions(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String genericAction = StringUtils.trimToNull(request.getParameter(GENERIC_ACTION));
		String nextPage = null;
		if (genericAction != null) {
			if (StringUtils.equalsIgnoreCase(genericAction, GENERIC_ACTION_SELENIUM)) {
				nextPage = SELENIUM_URL;
			} else if (StringUtils.equalsIgnoreCase(genericAction, GENERIC_ACTION_SHOW_CART)) {
				nextPage = handleShowCart(request);
			} else if (StringUtils.equalsIgnoreCase(genericAction, GENERIC_ACTION_LOGOUT)) {
				nextPage = handleLogout(request);
			}
		}
		return nextPage;
	}

	public String handleRemoveFromCart(HttpServletRequest request) {
		String sidToRemove = (String) request.getParameter("sid");
		if (sidToRemove != null) {
			Map<String, Integer> selectedItems = (Map<String, Integer>) session.getAttribute("selectedItems");// cart

			Integer newCountAfterRemoving = (Integer) selectedItems.get(sidToRemove) - 1;

			selectedItems.remove(sidToRemove);
			if (newCountAfterRemoving > 0) {
				selectedItems.put(sidToRemove, newCountAfterRemoving);
			}

			session.setAttribute("cart", itemService.getCart(selectedItems));
			session.setAttribute("countOfItems", calculateTotalItemsInCart());
		}
		return SUMMARY_URL;
	}

	private String handleBackButton(HttpServletRequest request) {
		request.setAttribute("items", itemService.getItems().values());
		return ITEMS_URL;
	}

	private String handleShowCart(HttpServletRequest request) {
		Map<String, Integer> selectedItems = null;
		if (session.getAttribute("selectedItems") != null) {
			selectedItems = (Map<String, Integer>) session.getAttribute("selectedItems");
			session.setAttribute("cart", itemService.getCart(selectedItems));
		}

		return SUMMARY_URL;
	}

	private String handleAddToCart(HttpServletRequest request) {
		String sid = request.getParameter(SELECTED_ITEM_ID);

		addToCart(sid, session);
		session.setAttribute("countOfItems", calculateTotalItemsInCart());
		return handleBackButton(request);
	}

	private Integer calculateTotalItemsInCart() {
		Integer quantity = 0;
		Map<String, Integer> selectedItems = (Map<String, Integer>) session.getAttribute("selectedItems");// item_id,
																											// item_count
		for (Integer countOfItem : selectedItems.values()) {
			quantity += countOfItem;
		}
		return quantity;
	}

	private String handleLogin(HttpServletRequest request, String action) {
		String nextPage = null;
		if (StringUtils.equalsIgnoreCase(LOGIN_ACTION, action)) {
			Credentials credentials = new Credentials();
			credentials.setUsername(StringUtils.trimToNull(request.getParameter("username")));
			credentials.setPassword(StringUtils.trimToNull(request.getParameter("password")));
			if (credentialsValidator.authenticate(credentials)) {
				session = request.getSession(true);
				session.setAttribute("countOfItems", 0);
				request.setAttribute(ITEMS_ATTRIBUTE, itemService.getItems().values());
				nextPage = ITEMS_URL;
			} else {
				nextPage = LOGIN_URL;
				request.setAttribute("loginError", INVALID_LOGIN_MESSAGE);
			}
		}
		return nextPage;
	}

	private String handleLogout(HttpServletRequest request) {
		if (session != null) {
			session.invalidate();
			request.setAttribute("logoutMessage", "You have been logged out sucessfully");
		}
		return LOGIN_URL;
	}

	private void addToCart(String sid, HttpSession session) {
		if (sid != null) {
			if (session != null) {
				if (session.getAttribute("selectedItems") != null) {
					Map<String, Integer> selectedIdsAndCount = (Map<String, Integer>) session
							.getAttribute("selectedItems");// id,count
					Integer countOfSelectedId = selectedIdsAndCount.get(sid);
					if (countOfSelectedId != null) {// Item already added in
													// cart, increment the count
													// by one.
						selectedIdsAndCount.put(sid, ++countOfSelectedId);
					} else {// Item added for the first time, set its count to
							// one.
						selectedIdsAndCount.put(sid, 1);
					}
				} else {
					Map<String, Integer> selectedIdsAndCount = new HashMap<>();
					selectedIdsAndCount.put(sid, 1);
					session.setAttribute("selectedItems", selectedIdsAndCount);
				}
			}
		}
	}

}
