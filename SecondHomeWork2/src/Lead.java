public class Lead extends LivingObjects{
    static String[] leadEquipment = new String[2];
    static int[] valueEquipment = new int[2];
    public Lead(String name,int maxBlood,int attack,int defend){//玩家手动输入的Lead
        this.name = name;
        this.curBlood =maxBlood;
        this.attack = attack;
        this.defend = defend;
        isLive = true;

    }
    public void fight(Monster monster){     //战斗
        if(monster.isLive){
            if(isLive){
                monster.injured(this);//受伤
            }else{
                System.out.println("您已经阵亡！");
            }
        }else
        {
            System.out.println("怪兽"+monster.name+"已经死亡！");
        }
        PrintLivingObjects();
    }

    @Override
    public int calLostLife(int attack, int defend) {//重写父类的方法，将装备带来的数值计算进去
        int lostLife = attack-valueEquipment[1]-defend;
        int LeastBlood = 1;//最少扣一滴血
        int real;
        if(lostLife<=0){
            real = LeastBlood;
        }else{
            real = lostLife;
        }
        return real;
    }

    @Override
    public void PrintLivingObjects() {//重写父类的方法，将装备带来的数值计算进去
        System.out.println("提示：有关的信息有：" +
                "名称：" + name + "  " +
                "生命值：" + curBlood + "  " +
                "攻击力：" + (attack +valueEquipment[0])+ "  " +
                "防御力：" + (defend + valueEquipment[1]));
    }

    @Override
    public void injured(LivingObjects livingObjects) {
        int lostLife =calLostLife(livingObjects.attack,this.defend);
        curBlood-=lostLife;
        if (valueEquipment[0]==0){
            System.out.println("主角"+this.name+"受到攻击,受到了" + lostLife+"点伤害");
        }else if (valueEquipment[0]>=0&&valueEquipment[1]>=0){
            System.out.println("主角"+this.name+"受到攻击,但是有"+leadEquipment[1]+"加强防御,"+"因此受到了" + lostLife+"点伤害");
        }
        if(curBlood<=0){//判断是否死亡
            curBlood=0;
            died(livingObjects);
        }
    }

    @Override
    public void died(LivingObjects livingObjects) {
        System.out.println("------"+"主角"+name+"挂掉了"+"------");
        isLive = false;
    }
}
