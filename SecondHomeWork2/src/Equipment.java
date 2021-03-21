import java.util.List;
import java.util.Scanner;

public class Equipment {
    public static void chooseEquipment(){//选择装备

        System.out.println("请输入顺序选择需要的两件装备(1-3中选择一件，4-5中选择一件)：");

        List<String> equipment = List.of("销魂剑","凌弱弓","无畏刃","金钟罩","死守甲");
        List<Integer> equipmentList = List.of(10,20,30,20,30);//装备数值列表

        System.out.println("【0】销魂剑：+10攻击力");//装备详细信息列表
        System.out.println("【1】凌弱弓：+20攻击力");
        System.out.println("【2】无畏刃：+30攻击力");
        System.out.println("【3】金钟罩：+20防御力");
        System.out.println("【4】死守甲：+30防御力" );

        Scanner choose = new Scanner(System.in);//选择装备
        int c1 = choose.nextInt();
        int c2 = choose.nextInt();

        Lead.leadEquipment[0] = equipment.get(c1);//将选择的装备和装备的数值保存到主角的信息里去
        Lead.leadEquipment[1] = equipment.get(c2);
        Lead.valueEquipment[0]=equipmentList.get(c1);
        Lead.valueEquipment[1]=equipmentList.get(c2);

        System.out.println("您选择的装备为：");//输出主角的装备
        System.out.println(Lead.leadEquipment[0]);
        System.out.println(Lead.leadEquipment[1]);

    }
}
