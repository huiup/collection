package com.poker;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card arg0, Card arg1) {
		// TODO Auto-generated method stub
		if(arg0.points.equals(arg1.points)) {
			return arg0.color.compareTo(arg1.color);
		}
		if(position(arg0.points)>(position(arg1.points)))//通过索引大小进行比较
			return 1;
		else
			return -1;
	}
	public int position(String c){
        String line = "24567890JQKA";
        return line.indexOf(c);//返回字符第一次出现的索引
    }
}
