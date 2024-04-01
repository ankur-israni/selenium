

<h2>Add Employee</h2>
  <fieldset>
    <legend>Employee Information: </legend>

<p>    
<img alt="Employee Image" id="htmlImageId" src="/shop/resources/images/employee.png" border="4">
</p>
    
<p>    
Name: <input type='text' name='name' id="htmlNameId">
</p>


<p>    

Sex:
<label for="htmlSex1">Male</label>
<input type="radio" name="htmlRadioSex" id="htmlSex1" class="htmlRadioSex" value="male">

<label for="htmlSex2">Female</label>
<input type="radio" name="htmlRadioSex" id="htmlSex2" class="htmlRadioSex" value="female">  
</p>

<p>
Hobbies: 
    <label for="htmlHobby1">Tennis</label>
    <input type="checkbox" name="htmlCheckboxHobby" id="htmlHobby1" class="chkboxHobby" value="tennis">
    <label for="htmlHobby2">Cricket</label>
    <input type="checkbox" name="htmlCheckboxHobby" id="htmlHobby2" class="chkboxHobby" value="cricket">
    <label for="htmlHobby3">Football</label>
    <input type="checkbox" name="htmlCheckboxHobby" id="htmlHobby3" class="chkboxHobby" value="football">
    <label for="htmlHobby4">Sleeping</label>
    <input type="checkbox" name="htmlCheckboxHobby" id="htmlHobby4" class="chkboxHobby" value="sleeping">
</p>

    
<p> 
Countries:    
<select id="htmlCountries">
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
<select size="6" name="contactPreference" multiple="multiple" style="width: 10em" id="htmlContactPreferenceId">
<option selected>Email</option>
<option>SML</option>
<option selected>Fascimile</option>
<option>Phone</option>
<option>Other</option>
</select>
</p>

<p>
<a href="http://www.google.com" id="htmlResumeId">Resume</a>
</p>

<!-- <input class="ui-button ui-widget ui-corner-all" type="submit" value="Back" name="action" id="backId"> -->
<input type="submit" value="Back" name="action" id="htmlBackId">
<input type="hidden" name="tab" value="htmlControls"/>

</fieldset>