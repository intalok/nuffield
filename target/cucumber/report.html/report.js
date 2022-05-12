$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/java/com/nuffieldhealth/feature/search.feature");
formatter.feature({
  "name": "Search the near by Gym",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Find the nearest Gym based on the zip code",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "Open chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageStepDef.java:19"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "open the nuffield health url",
  "keyword": "When "
});
formatter.match({
  "location": "HomePageStepDef.java:30"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter the zipcode \"E14 8AY\"",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageStepDef.java:34"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the nearest gym address",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageStepDef.java:38"
});
formatter.result({
  "status": "passed"
});
});