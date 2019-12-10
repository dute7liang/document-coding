package com.document.observer;

import java.util.Observable;

/**
 * @author: zl
 * @Date: 2019/12/10 22:43
 */
public class Bookstore extends Observable {

	public static void main(String[] args) throws InterruptedException {

		PaperListener paperListener1 = new PaperListener();
		PaperListener paperListener2 = new PaperListener();
		Bookstore bookstore = new Bookstore();
		bookstore.addObserver(paperListener1); // 订阅人1
		bookstore.addObserver(paperListener2); // 订阅人2

		Thread.sleep(1000);
		// 杂志到了
		bookstore.setChanged();
		bookstore.notifyObservers("西游记");
		bookstore.setChanged();
		bookstore.notifyObservers("三国演义");
	}
}
