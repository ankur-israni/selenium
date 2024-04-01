<%-- <div class="cart">
	<a href="/shop/cs?page=items&action=summary"> Cart (<%=session.getAttribute("countOfItems") %>)</a>
</div>
 --%>
 
 
 <div class="cart">
	<a href="/shop/cs?genericaction=showcart"> Cart (<%= session.getAttribute("countOfItems") %>)</a>
</div>
 