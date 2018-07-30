package id.ac.provis.unikom.model;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author satadii11
 */
public class BukuTabunganModelTest {
    private static final int ID_NASABAH = 1;
    
    private BukuTabunganModel tabungan;
    
    @Before
    public void setup() {
        tabungan = new BukuTabunganModel();
    }
    
    @Test
    public void shouldReturnCorrectStatus() {
        tabungan.setStatus("Aktif");
        Assert.assertEquals("Aktif", tabungan.getStatus());

        tabungan.setStatus("Ditutup");
        Assert.assertEquals("Ditutup", tabungan.getStatus());
    }
    
    @Test
    public void shouldCreateNewTabungan() {
        tabungan.setNomerRekening("012345678910");
        tabungan.setIdNasabah(ID_NASABAH);
        tabungan.setPin("123456");
        tabungan.setSaldo(100000);
        tabungan.setStatus("Aktif");
        Assert.assertEquals(true, tabungan.save());
    }
    
    @Test
    public void shouldSuccessTutupBukaTabungan() {
        tabungan.setIdNasabah(ID_NASABAH);
        Assert.assertEquals(true, tabungan.tutupTabungan());
        
        tabungan.setIdNasabah(ID_NASABAH);
        Assert.assertEquals(true, tabungan.bukaKembaliTabungan());
    }
    
    @Test
    public void shouldFetchAllDataFromDatabase() {
        tabungan.setIdNasabah(ID_NASABAH);
        ArrayList<BukuTabunganModel> tabungans = tabungan.findAllByIdNasabah();
        Assert.assertNotNull(tabungans);
        Assert.assertEquals(1, tabungans.size());
    }
}
