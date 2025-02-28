package web_client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public abstract class WebClient implements IWebClient {

    @Override
    public String sendRequest(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    @Override
    public HttpRequest makeRequest(String url, String body, Map<String, String> headers) {
        return null;
    }
}

// default -> 같은 패키지 내부에선 자유롭게 사용 가능
interface IWebClient {
    HttpClient httpClient = HttpClient.newBuilder().build();

    // body를 받을 것이다
    String sendRequest(HttpRequest request) throws IOException, InterruptedException;

    HttpRequest makeRequest(String url, String body, Map<String, String> headers);
}
