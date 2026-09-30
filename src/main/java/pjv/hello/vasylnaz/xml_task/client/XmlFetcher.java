package pjv.hello.vasylnaz.xml_task.client;

import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Component
public class XmlFetcher {

    public InputStream fetchAsInputStream(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<InputStream> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofInputStream()
        );


        try (ZipInputStream zis = new ZipInputStream(response.body())) {
            ZipEntry entry = zis.getNextEntry();

            if (entry != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[8192];
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    baos.write(buffer, 0, len);
                }

                return new ByteArrayInputStream(baos.toByteArray());
            } else {
                throw new RuntimeException("The downloaded ZIP archive is empty.");
            }
        }
    }
}