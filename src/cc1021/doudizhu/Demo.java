package cc1021.doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *  斗地主综合案例：有序版本
 *  1、准备牌
 *  2、洗牌
 *  3、发牌
 *  4、排序
 *  5、看牌
 */
public class Demo {

    public static void main(String[] args) {
        //1、准备牌
        //创建一个Map集合，存储牌的索引和组装好的牌
        HashMap<Integer, String> poker = new HashMap<>();
        //创建一个List索引，存储牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //定义两个集合，存储花色和牌的序号
        List<String> colors = List.of("♠️", "♥️", "♣️", "♦️");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

        //把大王和小王存储到集合中
        //定义一个牌的索引
        int index = 0;
        poker.put(index, "大王");
        pokerIndex.add(index);
        index++;
        poker.put(index, "小王");
        pokerIndex.add(index);
        index++;

        //循环嵌套遍历两个集合，组装52张牌，存储到集合中
        for (String number : numbers){
            for (String color : colors){
                poker.put(index, color + number);
                pokerIndex.add(index);
                index++;
            }
        }

        //System.out.println(poker);
        //System.out.println(pokerIndex);

        /**
         *  2、洗牌
         *  使用 Collections 中的方法 shuffle(List)
         */
        Collections.shuffle(pokerIndex);
        //System.out.println(pokerIndex);
    }
}
