# PrototypeAndroid
A sample project which demostrates simple ways to prototype android apps without backend api's  

[Medium post related to this repo](https://medium.com/@nvinayshetty/https-medium-com-nvinayshetty-prototyping-android-apps-without-server-apis-e0483a4d3547)
## Using json server
Provides quick explanation on using Json-server for prototyping android,and also addresses some gotchas.  

## Using OkHttp Interceptors.
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
}
```

## Using Network Behaviour with MockRetrofit.  

Providing MockRetrofit
``` @Singleton
    @Provides
    public MockRetrofit provideMockRetrofit(Retrofit retrofit){
        final NetworkBehavior behavior = NetworkBehavior.create();
        behavior.setErrorPercent(50);
        behavior.setDelay(4, TimeUnit.SECONDS);
        behavior.setVariancePercent(10);
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        final MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit).backgroundExecutor(executor).networkBehavior(behavior).build();
        return mockRetrofit;
    }
```    
    
Providing Network service wrapped with behaviour delegate.
```
 @Provides
    public static ContactListService provideContactListService(MockRetrofit retrofit, Context context){
        final BehaviorDelegate<ContactListService> mockContactsServiceBehaviorDelegate = retrofit.create(ContactListService.class);
        return new MockContactService(context,mockContactsServiceBehaviorDelegate);
    }
```    
