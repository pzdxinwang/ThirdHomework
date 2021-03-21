public class Monster extends LivingObjects{

    public Monster(String name,int maxBlood,int attack,int defend){//手动输入的
        this.name = name;
        this.curBlood =maxBlood;
        this.attack = attack;
        this.defend = defend;
        isLive = true;
    }

    @Override
    public int calLostLife(int attack, int defend) {//重写父类的方法，将装备带来的数值计算进去
        int lostLife = attack+Lead.valueEquipment[0]-defend;
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
    public void injured(LivingObjects livingObjects) {
        int lostLife =calLostLife(livingObjects.attack,this.defend);//计算损失的血量
        livingObjects.injured(this);
        curBlood-=lostLife;
        if (Lead.valueEquipment[0]==0){
            System.out.println("怪兽"+name+"被你攻击,受到了" + lostLife+"点伤害");
        }else if (Lead.valueEquipment[0]>=0){
            System.out.println("怪兽"+name+"被你使用"+Lead.leadEquipment[0]+"攻击,受到了" + lostLife+"点伤害");
        }
        if(curBlood<=0){//小于或者等于0的血量则为死亡
            curBlood=0;
            died(livingObjects);
        }
        PrintLivingObjects();
    }

    @Override
    public void died(LivingObjects livingObjects) {
        System.out.println("------>"+name+"被打死了"+"<------");
        isLive = false;//死亡时将isLive进行修改
    }
}
