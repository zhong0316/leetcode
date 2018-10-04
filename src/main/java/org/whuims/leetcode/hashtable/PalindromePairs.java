package org.whuims.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

    public static void main(String[] args) {
        PalindromePairs palindromePairs = new PalindromePairs();
        List<List<Integer>> res = palindromePairs.palindromePairs(new String[]{"ccbabgchcggcf", "hjicbfdgfffiejcb", "bcbbhgejdghjhiebhif", "bg", "ccdiacebhfaiaifg", "jdi", "ffhjie", "hdacgbbfdeidgbb", "dcedddghagahd", "ffga", "fhie", "aigjghhfaijdfhfjjaj", "hdg", "hiacdbhbbfc", "ejfhcbj", "bdddbabad", "hbihd", "ccgbhchfifa", "cjaddfbfcaeciiiiiegj", "beihhbbcbhaibehd", "adjeajfj", "i", "ahffeii", "jgbidfgb", "difebafibjedhbecefdd", "bfcabjheceafefba", "fi", "ac", "hebhjghfajdajbc", "bhhchageegdj", "egcfaidaejj", "afchfaffbjifc", "cicabighjbbhbihbhab", "abj", "hbifdhbjgj", "b", "eddbecfdhgggadh", "h", "bhgdhgjhggcichide", "gihghjaihj", "bhcgbi", "iihefhhiehacbceb", "bfbhhcjegdcaigajeb", "fhhbajaccedb", "jbfafgdhcjecicjghga", "adgcjeadcbffi", "ejjiijaichiegaieic", "e", "fajdcijggdfd", "dcbabehhjcjeihiadjj", "dbhdjbcibfhjabadijj", "bgiggae", "bjgbjidbjdiehjd", "cibd", "bhiffcjfccccfj", "bcff", "fghajg", "hfbhhachebee", "hacedjjg", "hbfjebhadijf", "jagfai", "hgfcdedceacg", "dhicbbigijihfjajd", "eiafjedf", "agfdidja", "ahfghbdifaijcbj", "aiahcgicibgc", "diiaafbfiibaichcgd", "cahahaafbafd", "hhf", "bidjgiacbiffecade", "fcjafhhgghfeaf", "fbahihbb", "jdddbeg", "djajjfhigihgabdcabf", "dehdjbjdb", "bgfcbgdfi", "ifhdg", "cabhjabf", "jeccefhfcdeiafdb", "cidgggf", "bcdihejbdb", "aajbbbabcigibcija", "beeig", "fge", "igcaecbgbha", "dcgafedfgif", "dfgcdbhieaahba", "dd", "dfjihgeee", "fje", "jeigcfifddddah", "chbajhiegihbha", "iajd", "djjdggajba", "bhdaa", "gbhgidhebbhccceb", "fghhjh", "gfhfcfeii", "iiif", "cfehecjejfe", "aeajeggbageicgefhe", "djbhjefigjagabaha", "fidi", "hhhdhccf", "fgfcjbfhbfaeaejbiee", "iggigad", "aibhcjdbfehiaa", "fbbbcdcbbeddhgifjhg", "jfdgfdfadhdjjcf", "hifhffjgdgbaafdbe", "jgfhgbbbjd", "egfbhcfhaa", "jbfejichj", "hhbijjejdeaigjif", "fcifcdjdgibfhfjdfabh", "jdhafgbdgdcaef", "hfeieeaigieegg", "adahfhhafb", "ehigeh", "iadebiegbghbjdiibjf", "jijdcaeiijcgbfi", "bffdedbedhdeecachb", "daafdaahfccafagf", "aifdfbeiffigjafj", "fbbbae", "geiddhc", "hcaegijihd", "ecdhcbj", "dfcjdbeibigjbb", "defgeg", "dabdjciiafj", "af", "ibehcjehgcbcfcgfdeh", "aijjgcahjjgidjagfcf", "aaggjibddhcidehajdjb", "hed", "jib", "j", "cdgajccccabdjfij", "dggefhahgceaiefbjh", "dheaefaa", "jcii", "hjjbjhhjcbiechfea", "feh", "if", "ag", "aggadfd", "ad", "cihifdje", "bbc", "eejibacbdddfgiba", "bdjhcfdffdfidbac", "geccaabbdjhbe", "ica", "geagfddiggb", "fhdfhjcghcidgbdaadae", "icbccgdhfh", "bfefdgaafiiacfg", "jaihibagafjbadebbjfj", "ffjbaf", "egfjacbeadefae", "cgfcahebcajbac", "bdejjdhbfeegedeeghb", "fhfabcd", "gfajigcae", "iefdbjiicfbg", "bhghihdgdbgdch", "aie", "cdaggccaaidb", "hecjbjiedbiadigihb", "jijcj", "hbcfajef", "hadbiddciibeb", "gaahifdejbdfacbfcfh", "dibai", "gahgdeddcaheigggad", "aidd", "dej", "agai", "hdhhjdjic", "hbbfc", "ccgcajjiggiedjfagjg", "igfeggjcfbdbd", "hjgbifgg", "bcijhifjddaidd", "jhedajfigb", "fda", "hgdigefbfbefihiae", "edcijdgegcdfcejcib", "cb", "fadcheig", "jbgefidcageficiggc", "ighe", "bcaig", "chfbjiffhc", "ceaa", "jdfiigbhhgjidjjbhba", "dgiifihaaaiiicaaibi", "gcf", "eiefiifeba", "dibbfaijbh", "cefgedfdjdg", "jdfdfebaidhciejhfi", "idaaabfdj", "ijeabgajg", "dfeefbdfebac", "eehcbaagiha", "igedadbgiddedd", "bjg", "djiagaddgcdhjcj", "ecdaigiaceba", "ij", "gcjfh", "iedajagbefa", "gjcjhd", "fhc", "jgjjibfhfehedcdibed", "gddd", "dhicf", "jeifabceecjjbiciiifd", "dadjgbfajeigaadidg", "aeicgceibechfaabajb", "bhgi", "ebafjbjdehgjdefjfhj", "bjcfcecgeiaahcb", "jh", "hhfbabiehecdih", "hdiiafafagfbfadgbdjj", "bieijgcfbj", "hafceibjfcdigchcbfd", "agdijhjfiggihaeha", "eiife", "fdjjiiefcbcicde", "idahfhgcjhei", "iefch", "hbfch", "ejehfjhjbeeabidcjcf", "d", "ahgbaicjj", "bdcgbhghgfhbehd", "dcfcddhfcbgaicaaigie", "fciihbjjffeaeibaf", "ghfjjffffaie", "hijbcia", "haca", "aeihhebfacfgcbj", "haajdeebdafcbe", "bf", "cdehffhhcibbdjac", "fbdcc", "ehg", "hiieaijgbbhcgadbbe", "igbecadcjbfcc", "aedaafebeiabfg", "icigabibdchhdjheiihj", "f", "cigdgdaib", "gjagi", "dejefgaebgaibf", "jajgibcjcgdfbjh", "gabbdhdbbdjgaebbj", "gedeggigbgdbghjch", "eeeheahddejijci", "cfj", "jddbb", "chjajaaicda", "adeaeccfhaaagag", "aabgijhcj", "igjbbedi", "feeibagjcae", "iedigjh", "fdhgbdebachdbc", "agbdgdhb", "ibjhedbabggbhh", "cjjf", "cidgdggfdhhgjbhih", "difhhiehghhe", "afjeighacf", "cjgcjaicbbeg", "fdgahbh", "dehbeici", "a", "egccdjbijhcegibabgb", "fdjajhg", "gihdifdgdhfaiaa", "bebedfcgbja", "ehjaebhgibihfcabbeee", "gfcfcah", "gbaaegfdeafec", "dfgcfg", "jcfjhgbjcbjgijgfch", "ihgjjdgaahbfg", "eeaaggggjeahbegc", "agcihhgddidfjhcbdg", "ijiaic", "cfgeechejidadf", "iiefj", "gaefeahjegehfe", "hadhad", "hjfedb", "beffdhdcbcfgfadfdb", "cfbbaddi", "gf", "gcbecb", "abhcbgigjei", "efjcg", "bdcjbbjfcfdceadjefg", "aaciaafbij", "bhhbeaifdjfeaiijaec", "jdhdbfhhgee", "ehfidjgc", "dfddbcabajcjbeefg", "ghh", "djifijij", "iaigcjcbdigchhghedg", "ddcc", "jejjahj", "hjifjbaacceejjdihdah", "adfbaefhga", "cahdhbdagg", "adhifjhichjfiaaahb", "fegebejefhieecjfa", "jfgbhibhhfbjdjdgdg", "fjdifb", "igjieg", "gcjddaebfefgdgddgii", "fecjdfbeea", "cbja", "hecaaejgaiac", "cgfgh", "cdahac", "ge", "iafadjffigibi", "ggbefa", "eeheghaffgbaehbid", "hedhbbebdefbj", "ibgfbjdgdiedghighaic", "igijagai", "fdfehiiah", "bicdehijdfjhfafe", "ecgegfaecfcccbih", "fcdbfeejbgcfh", "gidbejecbhdffafggedc", "higafejifbcdhbd", "bfa", "ifffagi", "gfhjhbadaebefbbccb", "edibbjccjhjedej", "fcecacdaibidcdidiei", "bbifdeaihihgciffdh", "feibbeccaag", "daij", "dhea", "ecgbdifaijaghih", "bbfaijcchahhjcbgg", "cfehbghf", "ccecheh", "ijdeehbjfbgchjaf", "dgeiahfjc", "bbcfiegihi", "afbaehbfjfihaibdfbc", "jjjhabiachcg", "bfhfbaebhdccdgafb", "bigfhggghi", "cbfffieahcabjfejfbd", "hcehicbjci", "efbhiaah", "jjddgj", "iejidbadjihgj", "idd", "jaie", "bdfaiceedgcifbdad", "diiciighejgba", "hjchbcidchei", "bgg", "bgccegbbibjhigcjd", "ffbbbihbdhiefihc", "ffiijahhihfjjeebchh", "hchjcfegac", "acjgc", "ddijdhhcbaajjfa", "hjfegegg", "hebdjhffca", "gacbihhdibejihfeb", "effihgid", "eddhficecaicadgiadg", "ccheaecb", "dja", "hhjfc", "dagbgeea", "gfifibejffh", "ecafchigbecdhbjbjga", "ifgjjheegbfab", "aegeabfgcbej", "cg", "gjcfb", "c", "jaacjhccaic", "ajggcdieihgiieiccajc", "ig", "ggcchafagiie", "edffjb", "ebchagi", "g", "ebjhfihhi", "efdjhbjgbdb", "gfgbjaifdfadfb", "gdcfjaaeejjbfgagbef", "cjfgaehehbjc"});
        for (List<Integer> list : res) {
            list.forEach(o -> System.out.print(" " + o));
            System.out.println();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        if (words == null || words.length < 2) return ret;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                // 将字符串切分成左右两份，如果其中一边为palindrome并且另一半字符串反转之后的字符存在words中，则找到一个candidate
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        ret.add(list);
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length() != 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(str1rvs));
                        ret.add(list);
                    }
                }
            }
        }
        return ret;
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }
}
