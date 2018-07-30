package id.ac.provis.unikom.model;

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
public class NasabahModelTest {
    private NasabahModel nasabah;
    
    @Before
    public void setup() {
        nasabah = new NasabahModel();
    }
    
    @Test
    public void shouldHaveCorrectJenisKelamin() {
        nasabah.setJenisKelamin("Pria");
        Assert.assertEquals("Pria", nasabah.getJenisKelamin());
        
        nasabah.setJenisKelamin("Wanita");
        Assert.assertEquals("Wanita", nasabah.getJenisKelamin());
    }
    
    @Test
    public void shouldSaveNewNasabah() {
        nasabah.setNama("Akhsan Andara");
        nasabah.setAlamat("Jln. Sekeloa Tengah No. 63");
        nasabah.setJenisKelamin("Pria");
        nasabah.setNoTelepon("086712346624");
        Assert.assertEquals(true, nasabah.save());
    }
    
    @Test
    public void shouldUpdateExistingNasabah() {
        nasabah.setId(1);
        nasabah.setNama("Aldy Ferdian Adam");
        nasabah.setJenisKelamin("Pria");
        nasabah.setAlamat("Jln. Sekeloa Utara");
        nasabah.setNoTelepon("086712346623");
        Assert.assertEquals(true, nasabah.update());
    }
    
    @Test
    public void shouldDeleteExistingNasabah() {
        nasabah.setId(3);
        Assert.assertEquals(true, nasabah.delete());
    }
    
    @Test
    public void shouldFetchAllDataInDatabase() {
        ArrayList<NasabahModel> nasabahs = nasabah.findAll();
        Assert.assertNotNull(nasabahs);
        Assert.assertEquals(2, nasabahs.size());
    }
}