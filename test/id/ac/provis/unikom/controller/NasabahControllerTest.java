package id.ac.provis.unikom.controller;

import id.ac.provis.unikom.model.NasabahModel;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author satadii11
 */
@RunWith(JUnit4.class)
public class NasabahControllerTest {
    private NasabahController controller;

    @Before
    public void setup() {
        controller = new NasabahController();
    }
    
    @Test
    public void shouldFetchedAllNasabah() {
        ArrayList<NasabahModel> nasabahs = controller.findAllNasabah();
        Assert.assertNotNull(nasabahs);
        Assert.assertEquals(2, nasabahs.size());
    }
}
