import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class TestMap {

    @Test
    public void testSoundex1(){
        assertEquals("S450", RefinedSoundex.GetSoundex("سلام"));
        assertEquals("S455", RefinedSoundex.GetSoundex("سلیمان"));
        assertEquals("M663", RefinedSoundex.GetSoundex("مروارید"));
    }

    @Test
    public void testSoundex2(){
        assertEquals("G215", RefinedSoundex.GetSoundex("گوسفند"));
    }
    @Test
    public void testSoundex3(){
        assertEquals("S435", RefinedSoundex.GetSoundex("سلطان"));
    }
    @Test
    public void testSoundex4(){
        assertEquals("A216", RefinedSoundex.GetSoundex("اکبر"));
    }
    @Test
    public void testSoundex5(){
        assertEquals("V260", RefinedSoundex.GetSoundex("وزیر"));
    }
    @Test
    public void testSoundex6(){
        assertEquals("A526", RefinedSoundex.GetSoundex("انگور"));
    }
    @Test
    public void testSoundex7(){
        assertEquals("Z200", RefinedSoundex.GetSoundex("زکیه"));
    }
    @Test
    public void testSoundex8(){
        assertEquals("T430", RefinedSoundex.GetSoundex("تلاوت"));
    }
    @Test
    public void testSoundex9(){
        assertEquals("A232", RefinedSoundex.GetSoundex("ازدواج"));
    }
    @Test
    public void testSoundex10(){
        assertEquals("G651", RefinedSoundex.GetSoundex("گران بها"));
    }
    @Test
    public void testSoundex11(){
        assertEquals("M266", RefinedSoundex.GetSoundex("مسرور"));
    }
    @Test
    public void testSoundex12(){
        assertEquals("M263", RefinedSoundex.GetSoundex("مشورت"));
    }
    @Test
    public void testSoundex13(){
        assertEquals("M355", RefinedSoundex.GetSoundex("مطمئن"));
    }
    @Test
    public void testSoundex14(){
        assertEquals("P626", RefinedSoundex.GetSoundex("پریچهر"));
    }

    @Test
    public void testSoundex15(){
        assertTrue(RefinedSoundex.IsEqualSoundex("غول", "گول"));//G400
    }
    @Test
    public void testSoundex16(){
        assertTrue(RefinedSoundex.IsEqualSoundex("اصطکاک", "استکاک"));//A232
    }
    @Test
    public void testSoundex17(){
        assertTrue(RefinedSoundex.IsEqualSoundex("ذخیره", "زخیره"));//Z260
    }
    @Test
    public void testSoundex18(){
        assertTrue(RefinedSoundex.IsEqualSoundex("حیاط", "حیات"));//H300
    }
    @Test
    public void testSoundex19(){
        assertTrue(RefinedSoundex.IsEqualSoundex("بهرام", "برنا"));//B650
    }
    @Test
    public void testSoundex20(){
        assertFalse(RefinedSoundex.IsEqualSoundex("گودال", "قوغاز"));//G340, G220
    }
//    @Test
//    public void testSoundex21(){
//        RefinedSoundex.GetSoundex("يکتا");
//        String first = "يکتا";
//        String second = "یکتا";
//        System.out.println(RefinedSoundex.soundexMappingForFirstLetter.get("یکتا".substring(0, 1)));
//    }

}
