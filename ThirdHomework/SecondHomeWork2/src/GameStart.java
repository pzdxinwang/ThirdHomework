import java.util.Scanner;

public class GameStart {
    Lead lead1,lead2;
    Monster m1,m2,m3,m4,m5;

    public void start(){//开始游戏

        System.out.println("**********");
        System.out.println("请先输入主角的各项信息：");
        System.out.println("**********");

        System.out.println("请输入主角名称、初始生命值、攻击力、防御力：");
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.next();
        int maxBlood1 = scanner.nextInt();
        int attack1 = scanner.nextInt();
        int defend1 = scanner.nextInt();

        System.out.println("输入怪兽的名字，血量，攻击力，防御力");
        String name2 = scanner.next();
        int maxBl00d2 = scanner.nextInt();
        int attack2 = scanner.nextInt();
        int defend2 = scanner.nextInt();

        lead1 = new Lead(name1,maxBlood1,attack1,defend1);//手动所创建的主角和怪兽
        m1 = new Monster(name2,maxBl00d2,attack2,defend2);

        System.out.println("你需要装备来协助你打败怪兽吗");
        System.out.println("【0】我很强大，不需要装备" +
                "【1】怪兽可能很强大，需要一些趁手的装备");
        int choose = scanner.nextInt();
        switch (choose) {
            case 0 -> System.out.println("冲冲冲，救出你的公主吧");
            case 1 -> {
                Equipment.chooseEquipment();//选择装备
                System.out.println("冲冲冲，救出你的公主吧");
            }
            default -> System.out.println("既然你胡乱输入，那就惩罚你没有装备吧");
        }
        System.out.println("------开始战斗！------");

        while(lead1.isLive && m1.isLive){
            lead1.fight(m1);//战斗
            if (lead1.isLive && m1.isLive)
                System.out.println("------战斗继续！------");
        }
        end();
    }

    public void end(){//手动战斗的游戏结束提示
        if(lead1.isLive){//如果已经死亡
            System.out.println("游戏结束，成功打死怪兽救出公主~~~");
        }else{
            System.out.println("怪兽太厉害了，公主没救出来就死了~~~");
        }
    }
    public void end2(){//自动战斗的游戏结束
        if (lead2.isLive){
            System.out.println("游戏结束，成功打死怪兽救出公主~~~");
        }else{
            System.out.println("怪兽太厉害了，公主没救出来就死了~~~");
        }
    }
}
