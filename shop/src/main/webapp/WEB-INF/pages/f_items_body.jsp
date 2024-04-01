<%@page import="java.util.*, com.shop.domain.Item"%>

<div class="title"><h1>Add an item to cart</h1></div>

 <div align="center"> 



<table class="hovertable">
<tr>
	<th>PIC</th>
	<th>ID</th>
	<th>NAME</th>
	<th>PRICE</th>
	<th>DIMENSIONS</th>
	<th>ACTION</th>
</tr>

		<%
		Collection<Item> items = (Collection<Item>) request.getAttribute("items");
			if (items != null) {
				for (Item item : items) {
		%>
				<tr onmouseover="this.style.backgroundColor='#ffff66';" 
				   onmouseout="this.style.backgroundColor='rgba(0,0,0,0)';" class="border_bottom" >
					<td><img src="/shop/resources/images/<%=item.getImage()%>"></img></td>
					<td><%=item.getId() %></td>
					<td><%=item.getName() %></td>
					<td><%=item.getPrice() %></td>
					<td><%=item.getDimensions() %></td>
					<td><a href="/shop/cs?page=items&action=AddToCart&sid=<%=item.getId() %>">Add to Cart</a></td>
					
				</tr>
		<%
				}}
		%>
</table>

<br/>
<!-- <div align="right" style="padding-right: 30em"> -->
<!-- <div class="btnAlignment">
	<input class="ui-button ui-widget ui-corner-all" type="submit" value="Checkout" name="action">
</div>  -->

</div>

<div class="btnAlignment">
	<input class="ui-button ui-widget ui-corner-all" type="submit" value="Checkout" name="action">
</div> 

