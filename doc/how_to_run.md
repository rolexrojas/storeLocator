## storeLocator

This application will be delivered in a zip file named storeLocator-{version}.zip

Simply extract the image from zip file, resulting in a jar file.

### Docker deployment

To build the image with Docker just execute:

```
docker build --build-arg JAR_FILE=build/libs/*.jar -t storeLocator . 
```

Then to run the container exposing port 8080
```
docker run -p 8080:8582 storelocator
```




