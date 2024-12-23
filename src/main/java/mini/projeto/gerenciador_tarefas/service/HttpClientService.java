package mini.projeto.gerenciador_tarefas.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientService {
	 private static final HttpClient client = HttpClient.newHttpClient();

	    public static String get(String url) throws IOException, InterruptedException {
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(url))
	                .GET()
	                .build();

	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	        return response.body();
	    }
}
