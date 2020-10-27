package compare.compare;

import java.lang.Math;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import luozhuangChineseEra.Lunar;

/**
 * 某个紫薇排盘JAVA对应版
 *
 * @author luozhuang
 */
public class luozhuangziwei {

    public void ziwei(int yearGan, int yearZhi, int LunarMonth, int monthGan, int monthZhi, int LunarDay, int dayGan, int dayZhi, int hourZhi) {
        int MingGongZhi = mod((monthZhi - 1) - (hourZhi - 1), 12) + 1; // 命宫: 生月月支顺数生时; 
        int ShenGongZhi = mod((monthZhi - 1) + (hourZhi - 1), 12) + 1; // 身宫: 生月月支逆数生时; 

        int MingGong = MingGongZhi;
        int XiongDiGong = mod((MingGongZhi - 1) - 1, 12) + 1; // 兄弟宫 
        int FuQiGong = mod((MingGongZhi - 2) - 1, 12) + 1; // 夫妻宫 
        int ZiNvGong = mod((MingGongZhi - 3) - 1, 12) + 1; // 子女宫 
        int CaiBoGong = mod((MingGongZhi - 4) - 1, 12) + 1; // 财帛宫 
        int JiEGong = mod((MingGongZhi - 5) - 1, 12) + 1; // 疾厄宫 
        int QianYiGong = mod((MingGongZhi - 6) - 1, 12) + 1; // 迁移宫 
        int PuYiGong = mod((MingGongZhi - 7) - 1, 12) + 1; // 仆役宫 
        int GuanLuGong = mod((MingGongZhi - 8) - 1, 12) + 1; // 官禄宫 
        int TianZhaiGong = mod((MingGongZhi - 9) - 1, 12) + 1; // 田宅宫 
        int FuDeGong = mod((MingGongZhi - 10) - 1, 12) + 1; // 福德宫 
        int FuMuGong = mod((MingGongZhi - 11) - 1, 12) + 1; // 父母宫 

        System.out.println("兄弟宫");

        System.out.println(XiongDiGong);
        System.out.println("夫妻宫");
        System.out.println(FuQiGong);
        System.out.println("财帛宫");
        System.out.println(ZiNvGong);
        System.out.println("子女宫");
        System.out.println(CaiBoGong);
        System.out.println("疾厄宫");
        System.out.println(JiEGong);
        System.out.println("迁移宫");
        System.out.println(QianYiGong);
        System.out.println("仆役宫");
        System.out.println(PuYiGong);
        System.out.println("官禄宫");
        System.out.println(GuanLuGong);
        System.out.println("田宅宫");
        System.out.println(TianZhaiGong);
        System.out.println("福德宫");
        System.out.println(FuDeGong);
        System.out.println("父母宫");
        System.out.println(FuMuGong);
        int[][] WuXingJuVal = {
                {2, 6, 3, 5, 4, 6},//年的天干和月的地支对应的五行局表,
                {6, 5, 4, 3, 2, 5},
                {5, 3, 2, 4, 6, 3},
                {3, 4, 6, 2, 5, 4},
                {4, 2, 5, 6, 3, 2}
        };
// NaYinWuXingVal = [ // 纳音五行对应的表, 行为天干, 列为地支.  
// 4 0 2 0 6 0 4 0 2 0 6 0 // 水2, 木3, 金4, 土5, 火6 
// 0 4 0 2 0 6 0 4 0 2 0 6  
// 2 0 6 0 5 0 2 0 6 0 5 0  
// 0 2 0 6 0 5 0 2 0 6 0 5  
// 6 0 5 0 3 0 6 0 5 0 3 0  
// 0 6 0 5 0 3 0 6 0 5 0 3  
// 5 0 3 0 4 0 5 0 3 0 4 0  
// 0 5 0 3 0 4 0 5 0 3 0 4  
// 3 0 4 0 2 0 3 0 4 0 2 0  
// 0 3 0 4 0 2 0 3 0 4 0 2]; 
        int WuXingJu = WuXingJuVal[mod(yearGan - 1, 5) + 1][(int) Math.floor((MingGongZhi + 1) / 2)]; //根据年干和命宫地支查表求得五行局 
        int[] ShuiJuVal = {2, 3}; //水二局的循环数值 
        int[] MuJuVal = {5, 2, 3}; //木三局的循环数值 
        int[] JinJuVal = {12, 5, 2, 3};
        int[] TuJuVal = {7, 12, 5, 2, 3};
        int[] HuoJuVal = {10, 7, 12, 5, 2, 3};
        int ZiWei = 0;
//////////////////////////////////////////////////////////////////////////////////////////// 
        switch (WuXingJu) // 确定紫微星所在的宫 
        {
            case 2:
                ZiWei = ShuiJuVal[(mod(LunarDay - 1, 2) + 1) + (int) Math.floor(LunarDay / 2)];
                break;
            case 3:
                ZiWei = MuJuVal[(mod(LunarDay - 1, 3) + 1) + (int) Math.floor(LunarDay / 3)];
                break;
            case 4:
                ZiWei = JinJuVal[(mod(LunarDay - 1, 4) + 1) + (int) Math.floor(LunarDay / 4)];
                break;
            case 5:
                ZiWei = TuJuVal[(mod(LunarDay - 1, 5) + 1) + (int) Math.floor(LunarDay / 5)];
                break;
            case 6:
                ZiWei = HuoJuVal[(mod(LunarDay - 1, 6) + 1) + (int) Math.floor(LunarDay / 6)];
                break;
            default:
                System.out.print("错误的五行局数");
                return;
        }

        int TianJi = mod((ZiWei - 1) - 1, 12) + 1; // 天机星 
        int TaiYang = mod((ZiWei - 1) - 3, 12) + 1; // 太阳星 
        int Wuqu = mod((ZiWei - 1) - 4, 12) + 1; // 武曲星 
        int TianTong = mod((ZiWei - 1) - 5, 12) + 1; // 天同星 
        int LianZhen = mod((ZiWei - 1) - 8, 12) + 1; // 廉贞星 

        int TianFu = mod(2 - ((ZiWei - 1) - 2), 12) + 1; // 天府星 
        int TaiYin = mod((TianFu - 1) + 1, 12) + 1; // 太阴星 
        int TanLang = mod((TianFu - 1) + 2, 12) + 1; // 贪狼星 
        int JuMen = mod((TianFu - 1) + 3, 12) + 1; // 巨门星 
        int TianXiang = mod((TianFu - 1) + 4, 12) + 1; // 天相星 
        int TianLiang = mod((TianFu - 1) + 5, 12) + 1; // 天梁星 
        int QiSha = mod((TianFu - 1) + 6, 12) + 1; // 七杀星 
        int PoJun = mod((TianFu - 1) + 10, 12) + 1; // 破军星 

        System.out.println("天机星");
        System.out.println(TianJi);
        System.out.println("太阳星");
        System.out.println(TaiYang);
        System.out.println("武曲星");
        System.out.println(Wuqu);

        System.out.println("天同星");
        System.out.println(TianTong);
        System.out.println("廉贞星");
        System.out.println(LianZhen);
        System.out.println("天府星");
        System.out.println(TianFu);
        System.out.println("太阴星");
        System.out.println(TaiYin);
        System.out.println("贪狼星");
        System.out.println(TanLang);
        System.out.println("巨门星");
        System.out.println(JuMen);

        System.out.println("天相星");
        System.out.println(TianXiang);

        System.out.println("天梁星");
        System.out.println(TianLiang);

        System.out.println("七杀星");
        System.out.println(QiSha);

        System.out.println("破军星");
        System.out.println(PoJun);
    }

    public int mod(int X, int Y) {
        return Math.abs(X % Y);
    }
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        luozhuangziwei my = new luozhuangziwei();
        Calendar today = Calendar.getInstance();
        today.setTime(sdf.parse("2003年1月1日"));

        my.ziwei(1, 2, 4, 1, 4, 1, 2, 1, 1);
    }
}