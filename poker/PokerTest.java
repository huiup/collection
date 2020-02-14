package com.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PokerTest {
	List<Card> poker=new ArrayList<Card>();//��Ŵ����õ��˿���  
	List<Player> player=new ArrayList<Player>();//�����ҵ�id������   
	List<Card> shufflecards=new ArrayList<Card>();//��Ŵ��ҵ��˿��� 
	List<Card> playerCard_1=new ArrayList<Card>();//������һ�������� 
	List<Card> playerCard_2=new ArrayList<Card>();//�����Ҷ��������� 
	List<Card> playerCard_3=new ArrayList<Card>();//��������������������
	Random random=new Random();
	/**
	 *һ�������˿��� 
	 *���ֻ�ɫ�����ҡ����ҡ�÷��������
	 *ʮ���ֵ�����2-10��J��Q��K��A���޴�С����
	 */
	public void createCard() {
		System.out.println("------------------�����˿���------------------");
		String[] point = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};//װ�����
		String[] type={"����","����","����","÷��"};//װ�뻨ɫ
		for (int i = 0; i < point.length; i++) {
			for (int j = 0; j < type.length; j++) {
				poker.add(new Card(point[i],type[j]));
			}
		}
		System.out.println("----------------�˿��ƴ����ɹ���---------------");
		//Ϊ����ǰΪ��[����2 ����2 ����2 ÷��2 ����3 ����3 ����3 ÷��3 ������
		//����ɫ��������Card������дcompareTo������Ҫ�̳нӿڣ��磺implements Comparable<Card>��
		Collections.sort(poker);
		System.out.println("Ϊ:");
		int num=0;
		for (Card card : poker) {
			//��д��toString()����
			System.out.print(card.toString()+" ");
			num++;
			if (num==13||num==26||num==39) {
				System.out.println();
			}
		}
	}
	/**
	 * ����������λѡ��
	 */
	public void createPlayer() {
		
		for (int i = 1; i < 3;i++) {
			Scanner scanner=new Scanner(System.in);          
			int addId;
			String addName;
			try {
				System.out.println("�������"+i+"λ��ҵ�ID��������");
				System.out.println("������ID:");
				addId=scanner.nextInt();
				if (i==2) {
					if (player.get(0).id==addId) {
						System.out.println("�벻Ҫ�ظ�������ͬ��ID!!");
						i--;
						continue;
					}
				}
				System.out.println("����������:");
				addName=scanner.next();
				Player p =new Player(addId, addName);
				player.add(p);
			} catch (InputMismatchException e) {//�����л��InputMismatchException
				// TODO: handle exception
				System.out.println("�������������͵�ID����");
				i=0;
				continue;
			}
		}
		System.out.println("------��ӭ��ң�"+player.get(0).name);
		System.out.println("------��ӭ��ң�"+player.get(1).name);
	}
	/**
	 * ����ϴ��:���ƴ���
	 */
	public void shuffleCards() {
		System.out.println();
		System.out.println("------------��ʼϴ��---------------");
		int num;
		for (int i = 0; i < poker.size(); i++) {
			do {
				num=random.nextInt(poker.size());
			}while(shufflecards.contains(poker.get(num)));
			//�˴���contains������Ҫ��Card����дequals����
			shufflecards.add(poker.get(num));
		}
//		�����Ƿ����ϴ��
//		int k=0;
//		for (Card card : shufflecards) {
//			//��д��toString()����
//			System.out.print(card.toString()+" ");
//			k++;
//			if (k==13||k==26||k==39) {
//				System.out.println();
//			}
//		}
//		System.out.println();
		System.out.println("------------ϴ�ƽ���---------------");
	}
	
	/**
	 * �ġ�����
	 * �Ӵ��ҵ��Ƶĵ�һ�ſ�ʼ������������ң�����һ��һ�ŵķ�ʽ��ÿ�˷�2�� 
	 */
	public void dealCards() {
		System.out.println("--------��ʼ���� ---------");
		System.out.println("----��ң�"+player.get(0).name+"-����");
		playerCard_1.add(shufflecards.get(0));
		System.out.println("----��ң�"+player.get(1).name+"-����");
		playerCard_2.add(shufflecards.get(1));
		System.out.println("----��ң�"+player.get(0).name+"-����");
		playerCard_1.add(shufflecards.get(2));
		System.out.println("----��ң�"+player.get(1).name+"-����");
		playerCard_2.add(shufflecards.get(3));
		System.out.println("--------���ƽ���! ---------");
	}
	/**
	 * �塢��ʼ��Ϸ��
	 * �Ƚ�����������е��˿��Ƶ��������ƣ����Ӯ�����������ͬ�����ջ�ɫ�Ƚϣ����ں�÷������
	 */
	public void play() {
		System.out.println("--------��ʼ��Ϸ ---------");
		//��дcompare����̳�Comparator�ӿڣ�
		Collections.sort(playerCard_1, new CardComparator());
		Collections.sort(playerCard_2, new CardComparator());
		System.out.println("��ң�"+player.get(0).name+"��������Ϊ��"+playerCard_1.get(1));
		System.out.println("��ң�"+player.get(1).name+"��������Ϊ��"+playerCard_2.get(1));
		playerCard_3.add(playerCard_1.get(1));//������һ������
		playerCard_3.add(playerCard_2.get(1));//�����Ҷ�������
		Collections.sort(playerCard_3, new CardComparator());//���򣬴���ں�
		if (playerCard_3.get(1).equals(playerCard_1.get(1))) {
			System.out.println("--------��ң�"+player.get(0).name+"��ʤ---------");
		}else
			System.out.println("--------��ң�"+player.get(1).name+"��ʤ---------");
		System.out.println("��Ҹ��Ե�����Ϊ��");
		System.out.println(player.get(0).name+"��["+playerCard_1.get(0)+","+playerCard_1.get(1)+"]");
		System.out.println(player.get(1).name+"��["+playerCard_2.get(0)+","+playerCard_2.get(1)+"]");
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