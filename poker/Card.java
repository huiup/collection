package com.poker;

public class Card implements Comparable<Card>{
	public String points;
	public String color;
	public Card() {
		
	}
	public Card(String points,String color) {
		this.points=points;
		this.color=color;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Card))
			return false;
		Card other = (Card) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (!points.equals(other.points))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return color+points;
	}
	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		if(this.color.equals(o.color))
			return 0;
		if (this.color.equals("ºÚÌÒ")) {
			return -1;
		}
		if (this.color.equals("ºìÌÒ")) {
			if(o.color.equals("ºÚÌÒ"))
				return 1;
			else
				return -1;
		}
		if (this.color.equals("Ã·»¨")) {
			if(o.color.equals("·½¿é"))
				return -1;
			else
				return 1;
		}
		if (this.color.equals("·½¿é")) {
			return 1;
		}
		return 0;
	}
	
	
}
