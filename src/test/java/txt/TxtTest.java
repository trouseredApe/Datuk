package txt;

import static org.junit.Assert.*;

import data.Data;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TxtTest {
    Txt txt;
    File f;

    @Before
    public void initialize() {
        f = new File("data.data");
        txt = new Txt(f.getAbsolutePath());
    }

    @After
    public void destroy() {
        f.delete();
    }

    @Test
    public void testWriteDataWithoutTitles_path() 
          throws IOException {
        Data d = new Data();
        ArrayList<String> line = new ArrayList<>();
        line.add("Testing");
        d.getData().add(line);
        d.getData().add(line);
        txt.writeDataWithoutTitles(d, false);
        
        assertTrue(f.exists());
    }

    @Test
    public void testWriteDataWithoutTitles_nullPath_numbersOnly() 
          throws IOException {
        f = new File("defaultData.data");
        txt = new Txt(null);
        Data d = new Data();
        ArrayList<Integer> line = new ArrayList<>();
        line.add(1);
        d.getData().add(line);
        d.getData().add(line);
        txt.writeDataWithoutTitles(d, true);
        
        assertTrue(f.exists());
    }

    @Test
    public void testWriteDataWithoutTitles_path_numbersOnly() 
          throws IOException {
        Data d = new Data();
        ArrayList<Integer> line = new ArrayList<>();
        line.add(1);
        d.getData().add(line);
        d.getData().add(line);
        txt.writeDataWithoutTitles(d, true);
        
        assertTrue(f.exists());
    }

    @Test
    public void testWriteData_path() 
          throws IOException {
        Data d = new Data();
        ArrayList<String> line = new ArrayList<>();
        line.add("Testing");
        d.getData().add(line);
        d.getData().add(line);
        txt.writeData(d, false);
        
        assertTrue(f.exists());
    }

    @Test
    public void testWriteData_nullPath_numbersOnly() 
          throws IOException {
        f = new File("defaultData.data");
        txt = new Txt(null);
        Data d = new Data();
        ArrayList<Integer> line = new ArrayList<>();
        line.add(1);
        d.getData().add(line);
        d.getData().add(line);
        txt.writeData(d, true);
        
        assertTrue(f.exists());
    }

    @Test
    public void testWriteData_path_numbersOnly() 
          throws IOException {
        Data d = new Data();
        ArrayList<Integer> line = new ArrayList<>();
        line.add(1);
        d.getData().add(line);
        d.getData().add(line);
        txt.writeData(d, true);
        
        assertTrue(f.exists());
    }
}
