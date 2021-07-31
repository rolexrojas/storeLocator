## storeLocator

This solution creates a memory database, takes a json file and loads into the database then open a service where it can
listen to request to find the top 5 nearest location from a given point.

I choose to perform a geospatial queries against the H2 database, I know there are many tools that can help to achieve
the same results, but ease complexity and time played a role in my decision.

I have to add that as I faced the need to load the Json file containing all the stores location so it felt natural 
to go with an spatial query even if is not the fanciest solution.







