import java.util.*;
//import org.apache.commons.codec.language.*;
//import gov.nih.nlm.nls.cSpell.Lib.*;
/*****************************************************************************
 * This class provides a java class to get the refined soundex code form
 * of a string using org.apache.commons.codec.language.RefinedSoundex.
 * A refined soundex code is optimized for spelling checking words.
 * Soundex originally developed by Margaret Odell and Robert Russell.
 *
 * @author chlu
 *
 * @version    V-2018
 ****************************************************************************/
public class RefinedSoundex
{
    // private constructor
    private static Map<String, Integer> soundexMapping;
    private static Map<String, String> soundexMappingForFirstLetter;
    private static boolean areMappingsSet = false;
    private RefinedSoundex()
    {

    }
    private static void setSoundexMapping(){
        soundexMapping = new HashMap<>();
        soundexMapping.put("ب", 1);
        soundexMapping.put("پ", 1);
        soundexMapping.put("ف", 1);
        soundexMapping.put("س", 2);
        soundexMapping.put("ص", 2);
        soundexMapping.put("ث", 2);
        soundexMapping.put("ج", 2);
        soundexMapping.put("ز", 2);
        soundexMapping.put("ظ", 2);
        soundexMapping.put("ض", 2);
        soundexMapping.put("ذ", 2);
        soundexMapping.put("ژ", 2);
        soundexMapping.put("چ", 2);
        soundexMapping.put("ک", 2);
        soundexMapping.put("غ", 2);
        soundexMapping.put("ق", 2);
        soundexMapping.put("گ", 2);
        soundexMapping.put("خ", 2);
        soundexMapping.put("ش", 2);
        soundexMapping.put("د", 3);
        soundexMapping.put("ت", 3);
        soundexMapping.put("ط", 3);
        soundexMapping.put("ل", 4);
        soundexMapping.put("م", 5);
        soundexMapping.put("ن", 5);
        soundexMapping.put("ر", 6);
    }

    private static void setSoundexMappingForFirstLetter(){
        soundexMappingForFirstLetter = new HashMap<>();
        soundexMappingForFirstLetter.put("ب","B");
        soundexMappingForFirstLetter.put("پ","P");
        soundexMappingForFirstLetter.put("ت","T");
        soundexMappingForFirstLetter.put("ط","T");
        soundexMappingForFirstLetter.put("س","S");
        soundexMappingForFirstLetter.put("ث","S");
        soundexMappingForFirstLetter.put("ص","S");
        soundexMappingForFirstLetter.put("ج","J");
        soundexMappingForFirstLetter.put("چ","C");
        soundexMappingForFirstLetter.put("ر","R");
        soundexMappingForFirstLetter.put("ه","H");
        soundexMappingForFirstLetter.put("ح","H");
        soundexMappingForFirstLetter.put("خ","X");
        soundexMappingForFirstLetter.put("د","D");
        soundexMappingForFirstLetter.put("ذ","Z");
        soundexMappingForFirstLetter.put("ظ","Z");
        soundexMappingForFirstLetter.put("ض","Z");
        soundexMappingForFirstLetter.put("ز","Z");
        soundexMappingForFirstLetter.put("ژ","Z");
        soundexMappingForFirstLetter.put("ش","S");
        soundexMappingForFirstLetter.put("غ","G");
        soundexMappingForFirstLetter.put("ک","K");
        soundexMappingForFirstLetter.put("گ","G");
        soundexMappingForFirstLetter.put("ق","G");
        soundexMappingForFirstLetter.put("ف","F");
        soundexMappingForFirstLetter.put("ل","L");
        soundexMappingForFirstLetter.put("م","M");
        soundexMappingForFirstLetter.put("ن","N");
        soundexMappingForFirstLetter.put("و","V");
        soundexMappingForFirstLetter.put("ع","A");
        soundexMappingForFirstLetter.put("ا","A");
        soundexMappingForFirstLetter.put("آ","A");
        soundexMappingForFirstLetter.put("أ","A");
        soundexMappingForFirstLetter.put("إ","A");
        soundexMappingForFirstLetter.put("ء","A");
        soundexMappingForFirstLetter.put("ی","Y");
    }
    public static void setAllMappings(){
        setSoundexMapping();
        setSoundexMappingForFirstLetter();
        areMappingsSet = true;
    }
    // Compute Edit (Levenshtein) distance
    public static boolean IsEqualCode(String str1, String str2)
    {
        boolean flag = GetCode(str1).equals(GetCode(str2));
        return flag;
    }
    public static boolean IsEqualSoundex(String str1, String str2)
    {
        boolean flag = GetSoundex(str1).equals(GetSoundex(str2));
        return flag;
    }
//    public static int GetDistance(String str1, String str2)
//    {
//        // String str1Lc = str1.toLowerCase();
//        // String str2Lc = str2.toLowerCase();
//        // String str1Code = GetCode(str1Lc);
//        // String str2Code = GetCode(str2Lc);
//        int dist = EditDistance.GetEditDistance(str1, str2);
//        return dist;
//    }
//    public static String GetDistanceDetailStr(String str1, String str2)
//    {
//        // String str1Lc = str1.toLowerCase();
//        // String str2Lc = str2.toLowerCase();
//        // String str1Code = GetCode(str1Lc);
//        // String str2Code = GetCode(str2Lc);
//        int dist = EditDistance.GetEditDistance(str1, str2);
//        String detailStr = str1 + GlobalVars.FS_STR + str2
//                + GlobalVars.FS_STR + dist;
//        return detailStr;
//    }
    public static String GetCode(String inStr)
    {
        return GetSoundex(inStr);
    }
    public static String GetSoundex(String inStr)
    {
        if(areMappingsSet == false)
            setAllMappings();
        String soundex = "";
        if(inStr == null || inStr.length() == 0){
            return null;
        }
        if(soundexMappingForFirstLetter.get(inStr.substring(0, 1)) == null){
            return null;
        }
        soundex += soundexMappingForFirstLetter.get(inStr.substring(0, 1));
        for(int i = 1; i < inStr.length() && soundex.length() < 4; i++){
            if(soundexMapping.get(inStr.substring(i, i + 1)) == null){
                continue;
            }
            soundex += String.valueOf(soundexMapping.get(inStr.substring(i, i + 1)));
        }
        if(soundex.length() < 4){
            while(soundex.length() < 4){
                soundex += "0";
            }
        }
        return soundex;
    }
    // public method
    public static void main(String[] args)
    {
        ArrayList<String> inStrList = new ArrayList<String>();
        if(args.length == 1)
        {
            inStrList.add(args[0]);
        }
        else if (args.length == 0)
        {
            inStrList.add("zinc trisulphonatophthalocyanine");
            inStrList.add("anemia");
            inStrList.add("anaemia");
            inStrList.add("yuppie flu");
            inStrList.add("yuppy flu");
            inStrList.add("toxic edema");
            inStrList.add("toxic oedema");
            inStrList.add("careful");
            inStrList.add("carefully");
            inStrList.add("zyxorin");
            inStrList.add("zyxoryn");
            inStrList.add("zymographical");
            inStrList.add("zymographically");
            inStrList.add("absorption test");
            inStrList.add("absorption tests");
            inStrList.add("effect");
            inStrList.add("affect");
            inStrList.add("now");
            inStrList.add("know");
            inStrList.add("there");
            inStrList.add("their");
        }
        else if(args.length > 0)
        {
            System.err.println("*** Usage: java RefinedSoundex <inStr>");
            System.exit(1);
        }
        // print out
        for(String inStr:inStrList)
        {
            String code = GetCode(inStr);
            String soundex = GetSoundex(inStr);
            System.out.println("- [" + inStr + "] => [" + code + "|"
                    + soundex + "]");
        }
        System.out.println("-- effect|affect: "
                + IsEqualCode("effect", "affect") + "|"
                + IsEqualSoundex("effect", "affect"));
        System.out.println("-- now|know: "
                + IsEqualCode("now", "know") + "|"
                + IsEqualSoundex("now", "know"));
    }
    //private methods
    // private static org.apache.commons.codec.language.RefinedSoundex rs_
    //     = new org.apache.commons.codec.language.RefinedSoundex();
}
