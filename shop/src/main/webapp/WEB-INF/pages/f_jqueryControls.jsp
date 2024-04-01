

<h2>Add Employee</h2>
  <fieldset>
    <legend>Employee Information: </legend>

<p>    
<img alt="Employee Image" id="jqueryImageId" src="/shop/resources/images/employee.png" border="4">
</p>
    
<p>    
Name: <input type='text' name='name' id="jqueryNameId">
</p>


<p>    

Sex:
<label for="jquerySex1">Male</label>
<input type="radio" name="sex" id="jquerySex1" class="jqueryRadioSex">

<label for="jquerySex2">Female</label>
<input type="radio" name="sex" id="jquerySex2" class="jqueryRadioSex">  
</p>

<p>
Hobbies: 
    <label for="jqueryHobby1">Tennis</label>
    <input type="checkbox" name="hobby" id="jqueryHobby1" class="jqueryChkboxHobby" value="tennis">
    <label for="jqueryHobby2">Cricket</label>
    <input type="checkbox" name="hobby" id="jqueryHobby2" class="jqueryChkboxHobby" value="cricket">
    <label for="jqueryHobby3">Football</label>
    <input type="checkbox" name="hobby" id="jqueryHobby3" class="jqueryChkboxHobby" value="football">
    <label for="jqueryHobby4">Sleeping</label>
    <input type="checkbox" name="hobby" id="jqueryHobby4" class="jqueryChkboxHobby" value="sleeping">
</p>

    
<p> 
Countries:    
<select id="jqueryCountries">
        <option value="india">India</option>
        <option value="united states">United States</option>
        <option value="iraq">Iraq</option>
        <option value="russia">Russia</option>
        <option value="pakistan">Pakistan</option>
        <option value="china">China</option>
        <option value="france">France</option>
</select>
</p>

<p>
Contact Preference:
<br/>
<select size="6" name="contactPreference" multiple="multiple" style="width: 10em">
<option selected>Email</option>
<option>SML</option>
<option selected>Fascimile</option>
<option>Phone</option>
<option>Other</option>
</select>
</p>

<p>
<a href="http://www.google.com" id="jqueryResumeId">Resume</a>
</p>

<input class="ui-button ui-widget ui-corner-all" type="submit" value="Back" name="action" id="backId">
<input type="hidden" name="tab" value="jqueryControls"/>

</fieldset>