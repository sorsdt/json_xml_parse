package sors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.nio.file.Files;
import java.nio.file.Paths;

@RunWith(MockitoJUnitRunner.class)
public class RatesParseTest {

    @Test
    public void getData() throws Exception {
        String s = new String(Files.readAllBytes(Paths.get("minfin.html")));
    }
}