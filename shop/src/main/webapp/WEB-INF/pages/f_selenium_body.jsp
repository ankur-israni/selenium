<div class="center">
	<h1>Selenium</h1>

	<script>
		$(function() {
			$("#tabs").tabs();
			$("#jqueryCountries").selectmenu();
			$( ".jqueryChkboxHobby" ).checkboxradio();
			$( ".jqueryRadioSex" ).checkboxradio();
			 /* $( "#selectable" ).selectable(); */
		});
	</script>

	<div id="tabs">
		<ul>
			<li><a href="#htmlControlsId">HTML Controls</a></li>
			<li><a href="#alertId">Alert Box</a></li>
			<li><a href="#htmlTableId">HTML Table</a></li>
			<li><a href="#jqueryControlsId">JQuery Controls</a></li>
		</ul>
		<div id="jqueryControlsId">
			<jsp:include page="f_jqueryControls.jsp"></jsp:include>
		</div>
		<div id="htmlControlsId">
			<jsp:include page="f_htmlcontrols.jsp"></jsp:include>
		</div>
		<div id="alertId">
			<jsp:include page="f_alert.jsp"></jsp:include>
		</div>
		<div id="htmlTableId">
			<jsp:include page="f_htmlTable.jsp"></jsp:include>
		</div>
		
		
	</div>

</div>