package com.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PokerTest {
	List<Card> poker=new ArrayList<Card>();//存放创建好的扑克牌  
	List<Player> player=new ArrayList<Player>();//存放玩家的id，姓名   
	List<Card> shufflecards=new ArrayList<Card>();//存放打乱的扑克牌 
	List<Card> playerCard_1=new ArrayList<Card>();//存放玩家一的两张牌 
	List<Card> playerCard_2=new ArrayList<Card>();//存放玩家二的两张牌 
	List<Card> playerCard_3=new ArrayList<Card>();//存放两个玩家最大的两张牌
	Random random=new Random();
	/**
	 *一、创建扑克牌 
	 *四种花色：黑桃、红桃、梅花、方块
	 *十三种点数：2-10、J、Q、K、A（无大小王）
	 */
	public void createCard() {
		System.out.println("------------------创建扑克牌------------------");
		String[] point = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};//装入点数
		String[] type={"黑桃","红桃","方块","梅花"};//装入花色
		for (int i = 0; i < point.length; i++) {
			for (int j = 0; j < type.length; j++) {
				poker.add(new Card(point[i],type[j]));
			}
		}
		System.out.println("----------------扑克牌创建成功！---------------");
		//为排序前为：[黑桃2 红桃2 方块2 梅花2 黑桃3 红桃3 方块3 梅花3 ···
		//按颜色排序，需在Card类中重写compareTo方法（要继承接口，如：implements Comparable<Card>）
		Collections.sort(poker);
		System.out.println("为:");
		int num=0;
		for (Card card : poker) {
			//重写了toString()方法
			System.out.print(card.toString()+" ");
			num++;
			if (num==13||num==26||num==39) {
				System.out.println();
			}
		}
	}
	/**
	 * 二、创建两位选手
	 */
	public void createPlayer() {
		
		for (int i = 1; i < 3;i++) {
			Scanner scanner=new Scanner(System.in);          
			int addId;
			String addName;
			try {
				System.out.println("请输入第"+i+"位玩家的ID和姓名：");
				System.out.println("请输入ID:");
				addId=scanner.nextInt();
				if (i==2) {
					if (player.get(0).id==addId) {
						System.out.println("请不要重复输入相同的ID!!");
						i--;
						continue;
					}
				}
				System.out.println("请输入姓名:");
				addName=scanner.next();
				Player p =new Player(addId, addName);
				player.add(p);
			} catch (InputMismatchException e) {//先运行获得InputMismatchException
				// TODO: handle exception
				System.out.println("请输入整数类型的ID！！");
				i=0;
				continue;
			}
		}
		System.out.println("------欢迎玩家："+player.get(0).name);
		System.out.println("------欢迎玩家："+player.get(1).name);
	}
	/**
	 * 三、洗牌:把牌打乱
	 */
	public void shuffleCards() {
		System.out.println();
		System.out.println("------------开始洗牌---------------");
		int num;
		for (int i = 0; i < poker.size(); i++) {
			do {
				num=random.nextInt(poker.size());
			}while(shufflecards.contains(poker.get(num)));
			//此处的contains方法需要在Card中重写equals方法
			shufflecards.add(poker.get(num));
		}
//		测试是否完成洗牌
//		int k=0;
//		for (Card card : shufflecards) {
//			//重写了toString()方法
//			System.out.print(card.toString()+" ");
//			k++;
//			if (k==13||k==26||k==39) {
//				System.out.println();
//			}
//		}
//		System.out.println();
		System.out.println("------------洗牌结束---------------");
	}
	
	/**
	 * 四、发牌
	 * 从打乱的牌的第一张开始，发给两名玩家，按照一人一张的方式，每人发2张 
	 */
	public void dealCards() {
		System.out.println("--------开始发牌 ---------");
		System.out.println("----玩家："+player.get(0).name+"-拿牌");
		playerCard_1.add(shufflecards.get(0));
		System.out.println("----玩家："+player.get(1).name+"-拿牌");
		playerCard_2.add(shufflecards.get(1));
		System.out.println("----玩家："+player.get(0).name+"-拿牌");
		playerCard_1.add(shufflecards.get(2));
		System.out.println("----玩家："+player.get(1).name+"-拿牌");
		playerCard_2.add(shufflecards.get(3));
		System.out.println("--------发牌结束! ---------");
	}
	/**
	 * 五、开始游戏：
	 * 比较两名玩家手中的扑克牌点数最大的牌，大的赢，如果点数相同，则按照花色比较（按黑红梅方）。
	 */
	public void play() {
		System.out.println("--------开始游戏 ---------");
		//重写compare（需继承Comparator接口）
		Collections.sort(playerCard_1, new CardComparator());
		Collections.sort(playerCard_2, new CardComparator());
		System.out.println("玩家："+player.get(0).name+"最大的手牌为："+playerCard_1.get(1));
		System.out.println("玩家："+player.get(1).name+"最大的手牌为："+playerCard_2.get(1));
		playerCard_3.add(playerCard_1.get(1));//添加玩家一最大的牌
		playerCard_3.add(playerCard_2.get(1));//添加玩家二最大的牌
		Collections.sort(playerCard_3, new CardComparator());//排序，大的在后
		if (playerCard_3.get(1).equals(playerCard_1.get(1))) {
			System.out.println("--------玩家："+player.get(0).name+"获胜---------");
		}else
			System.out.println("--------玩家："+player.get(1).name+"获胜---------");
		System.out.println("玩家各自的手牌为：");
		System.out.println(player.get(0).name+"：["+playerCard_1.get(0)+","+playerCard_1.get(1)+"]");
		System.out.println(player.get(1).name+"：["+playerCard_2.get(0)+","+playerCard_2.get(1)+"]");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PokerTest pt=new PokerTest();
		pt.createCard();
		pt.shuffleCards();
		pt.createPlayer();
		pt.dealCards();
		pt.play();
	}
}