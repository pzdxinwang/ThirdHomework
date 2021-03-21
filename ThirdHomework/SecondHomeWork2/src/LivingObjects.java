import java.util.Random;

public abstract class LivingObjects {//将主角和怪兽的共性写在一起
    protected String name;
    protected int maxBlood;
    protected int curBlood;
    protected boolean isLive;
    protected int attack;
    protected int defend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxBlood() {
        return maxBlood;
    }

    public void setMaxBlood(int maxBlood) {
        this.maxBlood = maxBlood;
    }

    public int getCurBlood() {
        return curBlood;
    }

    public void setCurBlood(int curBlood) {
        this.curBlood = curBlood;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefend() {
        return defend;
    }

    public void setDefend(int defend) {
        this.defend = defend;
    }
    public void PrintLivingObjects() {//输出信息
        System.out.println("提示：有关的信息有：" +
                "名称：" + name + "  " +
                "生命值：" + curBlood + "  " +
                "攻击力：" + attack + "  " +
                "防御力：" + defend);
    }
    public int calLostLife(int attack,int defend){//扣血
        int lostLife = attack-defend;
        int LeastBlood = 1;//最少扣一滴血
        int real = 0;
        if(lostLife<=0){
            real = LeastBlood;
        }else{
            real = lostLife;
        }
        return real;
    }


    public static int RandomRange(int num){//产生随机数
        Random random = new Random();
        return (int)(random.nextInt(num)+1);
    }
    public abstract void injured(LivingObjects livingObjects);//受伤判断

    public abstract void died(LivingObjects livingObjects);//死亡输出
}
