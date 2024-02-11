
<h2>Setup</h2>

<h4> 1. Clone this repository git clone https://github.com/KomalJayaram/bigw-petstore-functional-api-tests.git </h4>
<h4> 2. Inside project folder allow maven to run all project dependencies </h4>

<h2>Run Tests</h2>
<ol>
<li> Execute maven command `- mvn clean verify` </li>
<li> Alternatively right click on the feature file to run tests in the feature file</li>
</ol>

<h2>TechStack Info</h2>
<ol>
<li> API Test Framework: Junit + RestAssured</li>
<li> BDD approach with usage of Cucumber framework</li>
<li> Added support for allure to get a nice report along with default cucumber report</li>
</ol>

<h2> Story Description</h2>

  <h4> Pet - Adding pet details to the catalogue </h4>
  
 > As a Store Owner, I would like add new pet profile 
 > Description : Create a pet profile
 > * POST /pet Add an new pet to the store

  <h2> Approach </h2>

<ol>
<li> Read the swagger document</li>
<li> Hit the intended endpoint (POST /pet) using insomnia with various inputs to understand the API call</li>
<li> Deviced a simple framework to isolate endpoints from actual tests so that adding more tests can be easy</li>
<li> Integrated it with allure reporting for a user friendly report</li>
</ol>
  
