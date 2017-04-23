# PrototypeAndroid
A sample project which demostrates simple ways to prototype android apps without backend api's
## Using json server



##Using OkHttp Interceptors
Using OkHttp to intercept network requets and reply with the json response available in local file.
```@Override
public Response intercept(Chain chain) throws IOException {
    final String url = chain.request().url().toString();
    switch (url) {
        case "http://10.42.0.1:3000/contacts": {
            final ResponseBody responseBody = ResponseBody
                    .create(MediaType.parse("application/json"), readFromFile("contacts_response.json"));
            final Response response = new Response
                    .Builder()
                    .body(responseBody)
                    .request(chain.request()).message("OK")
                    .protocol(Protocol.HTTP_1_1)
                    .code(200)
                    .build();
            return response;
        }
    }
    return chain.proceed(chain.request());
}```
