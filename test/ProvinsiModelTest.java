
import id.ac.provis.unikom.model.ProvinsiModel;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 *
 * @author satadii11
 */
@RunWith(JUnit4.class)
public class ProvinsiModelTest {
    @Test
    public void shouldReturn34Province() {
        ProvinsiModel provinsi = new ProvinsiModel();
        ArrayList<ProvinsiModel> provinsiList = provinsi.getAllProvinsi();
        Assert.assertEquals(34, provinsiList.size());
    }
}
