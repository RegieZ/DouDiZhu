import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * 组合牌
 * 	  定义一个Map集合用来存储牌号  和 牌
 * 	  定义一个List集合用来存储牌号
 * 	 花色:♥-♠-♦-♣
 * 	 数字:2-A-K-Q-J-10-9-8-7-6-5-4-3
 * 洗牌
 * 		Collections.shuffle(牌号集合)
 * 发牌
 * 		三个玩家三个集合
 * 		发牌号
 * 排序
 * 看牌
 */
public class Test {
    public static void main(String[] args) {
        //准备牌
        //定义一个Map集合用来存储牌号和牌
        HashMap<Integer, String> pokerMap = new HashMap<Integer, String>();
        //定义一个List集合用来存储牌号
        ArrayList<Integer> pokerNumList = new ArrayList<Integer>();

        String[] colors = "♥-♠-♦-♣".split("-");
        String[] nums = "2-A-K-Q-J-10-9-8-7-6-5-4-3".split("-");

        int index = 2;
        for (String num : nums) {
            for (String color : colors) {
                String thisPoker = color + num;
                //System.out.println(thisPoker);
                //将扑克牌放入Map集合
                pokerMap.put(index, thisPoker);
                //将牌号放入到pokerList集合中
                pokerNumList.add(index);
                index++;
            }
        }

        //将大王小王添加到集合
        pokerMap.put(0, "大王");
        pokerMap.put(1, "小王");
        pokerNumList.add(0);
        pokerNumList.add(1);

        //准备牌结果
        //System.out.println(pokerMap);
        //System.out.println(pokerNumList);

        //洗牌
        Collections.shuffle(pokerNumList);

        //发牌
        ArrayList<Integer> player1 = new ArrayList<Integer>();
        ArrayList<Integer> player2 = new ArrayList<Integer>();
        ArrayList<Integer> player3 = new ArrayList<Integer>();
        ArrayList<Integer> diPai = new ArrayList<Integer>();

        //遍历牌号的集合 判断索引发牌号
        for (int i = 0; i < pokerNumList.size(); i++) {
            Integer pokerNum = pokerNumList.get(i);
            if (i >= 51) {
                diPai.add(pokerNum);
            } else if (i % 3 == 0) {
                player1.add(pokerNum);
            } else if (i % 3 == 1) {
                player2.add(pokerNum);
            } else if (i % 3 == 2) {
                player3.add(pokerNum);
            }
        }

        //排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(diPai);
        //玩家所对应的集合
        //System.out.println(player1);
        //System.out.println(player2);
        //System.out.println(player3);
        //System.out.println(diPai);

        show("张三", player1, pokerMap);
        show("李四", player2, pokerMap);
        show("王五", player3, pokerMap);
        show("底牌", diPai, pokerMap);
    }

    //定义方法 看牌
    public static void show(String name, ArrayList<Integer> player, HashMap<Integer, String> pokerMap) {
        System.out.print(name + ":");
        for (Integer pokerNum : player) {
            String thisPoker = pokerMap.get(pokerNum);
            System.out.print(thisPoker + " ");
        }
        System.out.println();
    }
}
/*
输出
张三:♥2 ♠2 ♠A ♠Q ♥J ♠J ♣J ♦10 ♥9 ♠8 ♣8 ♥5 ♦5 ♣5 ♣4 ♥3 ♣3
李四:小王 ♣2 ♦A ♥K ♥Q ♣Q ♥10 ♠10 ♣10 ♦9 ♥8 ♦8 ♥7 ♥6 ♠6 ♠5 ♥4
王五:大王 ♦2 ♥A ♣A ♦K ♦Q ♦J ♣9 ♠7 ♦7 ♣7 ♦6 ♣6 ♠4 ♦4 ♠3 ♦3
底牌:♠K ♣K ♠9
 */
