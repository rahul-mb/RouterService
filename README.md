# RouterService
We want to implement a middleware router for our web service, which based on the path returns different strings (these would represent “functions to invoke” in a real application).
Our interface for the router looks something like:
=====
interface Router {
  fun registerRoute(path: String, result: String) : Unit;  
  fun lookupRoute(path: String) : String;
}

Usage:
Router.registerRoute("/bar", "result")
Router.lookupRoute("/bar") -> "result"

This question was asked in Atlassian interview.
