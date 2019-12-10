package com.document.observer;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * @author: zl
 * @Date: 2019/12/10 22:38
 */
@Slf4j
public class PaperListener implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		log.info("收到书了：{}",arg);
	}
}
