import java.util.*;

public class DouDiZhu {
    public static void main(String[] args) {
        //准备牌，使用Map集合来存贮牌的索引和组装好的牌
        HashMap<Integer,String> poker = new HashMap<>();
        //创建一个list集合，存储索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //定义两个集合存储牌的花色和牌号
        List<String> colors = List.of("♠","♣","♥","♦");
        List<String> numbers = List.of("2","A","K","Q","J","10","9","8","7","6",
                "5","4","3");
        //存储大王和小王
        int index = 0;
        poker.put(index,"大王");
        pokerIndex.add(index);
        index++;
        poker.put(index,"小王");
        pokerIndex.add(index);
        index++;
        //组装牌
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index,color+number);
                pokerIndex.add(index);
                index++;
            }
        }
        //洗牌
        Collections.shuffle(pokerIndex);
        //发牌
        ArrayList<Integer> play1 = new ArrayList<>();
        ArrayList<Integer> play2 = new ArrayList<>();
        ArrayList<Integer> play3 = new ArrayList<>();
        ArrayList<Integer> hand = new ArrayList<>();
        //获取牌的索引
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer integer = pokerIndex.get(i);
            if (i>=51){
                hand.add(integer);//底牌的牌
            }else if (i%3==0){
                play1.add(integer);//玩家1的牌
            }else if (i%3==1){
                play2.add(integer);//玩家2的牌
            }else{
                play3.add(integer);//玩家3的牌
            }
        }
        //排序牌
        Collections.sort(play1);
        Collections.sort(play2);
        Collections.sort(play3);
        Collections.sort(hand);

        //看牌
        lookPoker("潘增丹",poker,play1);
        lookPoker("大陈剑辉",poker,play2);
        lookPoker("小陈剑辉",poker,play3);
        lookPoker("底牌",poker,hand);


    }
    public static void lookPoker(String name,HashMap<Integer,String> poker,ArrayList<Integer> list){
        System.out.print(name+":  ");
        //遍历牌
        for (Integer key : list) {
            String value = poker.get(key);//找到对应的牌
            System.out.print(value+" ");
        }
        //打印玩家的牌之后换行
        System.out.println();
    }
}
