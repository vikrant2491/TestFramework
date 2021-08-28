$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AmazonSearch.feature");
formatter.feature({
  "line": 1,
  "name": "Amazon home page",
  "description": "",
  "id": "amazon-home-page",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1040800,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Search any item",
  "description": "",
  "id": "amazon-home-page;search-any-item",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User search for \"trimmer\" item",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "trimmer",
      "offset": 17
    }
  ],
  "location": "Steps.entertext(String)"
});
formatter.result({
  "duration": 2881602600,
  "status": "passed"
});
formatter.after({
  "duration": 816900,
  "status": "passed"
});
});