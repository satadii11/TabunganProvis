package id.ac.provis.unikom.model;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author satadii11
 */
@RunWith(JUnit4.class)
public class KabKotaModelTest {
    @Test
    public void shouldReturn27KotaFromJawaBarat() {
        int idJawaBarat = 32;
        
        KabKotaModel kabkota = new KabKotaModel();
        ArrayList<KabKotaModel> kabkotaList = kabkota.getAllByProvinsiId(idJawaBarat);
        Assert.assertEquals(27, kabkotaList.size());
    }
}
