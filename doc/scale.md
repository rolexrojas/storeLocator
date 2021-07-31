## storeLocator

This is a very light way solution and can handle pretty good some vertical scaling because of the nature of spring
technology, but some considerations and modifications will need to be taken into account for horizontal scaling as this
app creates a in memory database then all data will be lost on a server restart, so some persistence should be added.
 Besides that (in case of need) the ideal would be to use a more robust rdbms as H2 is a good tool for a low footprint
 db but in order to scale we would need to be able to use the extra features from a heavier database provider.