public abstract class LivingObjects {//将主角和怪兽的共性写在一起
    protected String name;
    protected int curBlood;
    protected boolean isLive;
    protected int attack;
    protected int defend;

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
        int real;
        if(lostLife<=0){
            real = LeastBlood;
        }else{
            real = lostLife;
        }
        return real;
    }
    public abstract void injured(LivingObjects livingObjects);//受伤判断

    public abstract void died(LivingObjects livingObjects);//死亡输出
}
