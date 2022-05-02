$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/RestAPI_GET_Request.feature");
formatter.feature({
  "name": "Get Rest Call",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Successul Get API Rest Call",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RestAPIGetCall"
    },
    {
      "name": "@RestRegression"
    }
  ]
});
formatter.step({
  "name": "Launch the Base URL",
  "keyword": "Given "
});
formatter.match({
  "location": "Rest_API_Steps.launch_the_Base_URL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Provide Service Details \u0026 Provide the Method Name with All Inputs",
  "keyword": "When "
});
formatter.match({
  "location": "Rest_API_Steps.user_Provide_Service_Details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Print The Response Body",
  "keyword": "Then "
});
formatter.match({
  "location": "Rest_API_Steps.print_The_Response_Body()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validdate Status Codes Header And Response Body",
  "keyword": "And "
});
formatter.match({
  "location": "Rest_API_Steps.validdate_Status_Codes()"
});
formatter.result({
  "status": "passed"
});
});