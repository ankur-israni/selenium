<%@page import="java.util.*, com.shop.domain.CartItem, com.shop.domain.Item,com.shop.domain.Cart "%>

<div class="title"><h1>View Cart</h1></div>

<div align="center">
<%
	Integer noItemsInCart=(Integer)session.getAttribute("countOfItems");
	if(noItemsInCart!=null && noItemsInCart>0){
%>

<table class="hovertable">
<tr>
	<th>&nbsp;</th>
	<th>ID</th>
	<th>NAME</th>
	<th>COUNT</th>
	<th>Total</th>
	<th>ACTION</th>
</tr>

		<%
		Cart cartz=(Cart)session.getAttribute("cart");
		List<CartItem> items=cartz.getCartItems();
			if (items != null) {
				for (CartItem cartItem : items) {
					Item item=cartItem.getItem();
		%>
				<tr onmouseover="this.style.backgroundColor='#ffff66';" 
				   onmouseout="this.style.backgroundColor='rgba(0,0,0,0)';" class="border_bottom" >
					<td><img src="/shop/resources/images/<%=item.getImage()%>"></img></td>
					<td><%=item.getId() %></td>
					<td><%=item.getName() %></td>
					<td><%=cartItem.getQuantity() %></td>
					<td><%=cartItem.getTotalPrice() %></td>
					<td><a href="/shop/cs?page=summary&action=RemoveFromCart&sid=<%=item.getId() %>">Remove</a></td>
				</tr>
		<%
				}
			%>	
				
				<tr>
					<td>Grand Total</td>
					<td><%=cartz.getGrandTotal() %></td>
				</tr>
				
				<%
			}
		%>
</table>

<%
	}else{
%>
	<jsp:include page="f_no_items_in_cart.jsp"></jsp:include>
<%		
	}
%>

</div>

<p>&nbsp;</p>
<div class="btnAlignment">
	<input class="ui-button ui-widget ui-corner-all" type="submit" value="Back" name="action">
</div>