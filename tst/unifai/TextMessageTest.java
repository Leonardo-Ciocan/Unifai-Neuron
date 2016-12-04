package unifai;

import com.unifai.core.Unifai;
import com.unifai.example.EchoNeuron;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static spark.Spark.awaitInitialization;

public class TextMessageTest {

    OkHttpClient client = new OkHttpClient();

    @Test
    public void shouldReturnMessage() throws IOException, InterruptedException {
        EchoNeuron neuron = Unifai.createNeuron(EchoNeuron.class);
        neuron.start();
        RequestBody body = RequestBody.create(MediaType.parse("JSON"), "{\n" +
                "\t\"body\":\"Bread\",\n" +
                "\t\"type\":0\n" +
                "}");
        Request request = new Request.Builder()
                .url("http://localhost:4567/send")
                .post(body)
                .build();
        awaitInitialization();
        Response response = client.newCall(request).execute();
        assertEquals(response.code(), 200);
        assertEquals(response.body().string(), "{\"body\":\"Your message said:Bread\",\"type\":0}");
    }

}
