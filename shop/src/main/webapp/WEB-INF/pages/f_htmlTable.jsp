<h2>Employees</h2>
  <fieldset>
    <legend>Employee Information: </legend>
<table id="tblEmployeesId">
  <tr>
    <th>Firstname</th>
    <th>Lastname</th>
    <th>Age</th>
  </tr>
  <tr>
    <td>Jill</td>
    <td>Smith</td>
    <td>50</td>
  </tr>
  <tr>
    <td>Eve</td>
    <td>Jackson</td>
    <td>94</td>
  </tr>
  <tr>
    <td>John</td>
    <td>Doe</td>
    <td>80</td>
  </tr>
</table>
  </fieldset>

<input type="hidden" name="tab" value="htmlTable"/>
<style>
table#tblEmployeesId {
    width:100%;
}
table#tblEmployeesId, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#tblEmployeesId tr:nth-child(even) {
    background-color: #eee;
}
table#tblEmployeesId tr:nth-child(odd) {
   background-color:#fff;
}
table#tblEmployeesId th {
    background-color: black;
    color: white;
} 
</style>