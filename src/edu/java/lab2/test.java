package edu.java.lab2;

import org.junit.Test;
import junit.framework.Assert;

//Класс тестов
public class test {
	/**
	* Данный тест проверяет метод GetRand
	* на корректную обработку диапазона случайного
	* значения (b >= a).*/
	@Test
	public void TestGetRandBbreqA() {
		try {
			Assert.assertTrue(InterForm.GetRand(2, 7) >= 2);
			Assert.assertTrue(InterForm.GetRand(2, 7) <= 7);
		}
		catch(AssertionError e) {
			e.printStackTrace();
		}
			
	}
	
	/** Данный тест проверяет метод GetRand
	 * на корректную обработку диапазона случайного
	 * значения (b < a).*/
	@Test
	public void TestGetRandBlsA() {
		try {
			Assert.assertEquals(0, InterForm.GetRand(7, 2));
		}
		catch(AssertionError e) {
			e.printStackTrace();
		}
	}
	
	/** Данный тест проверяет метод AppendStr
	 * на корректную обработку пустой строки
	 * и заданного символа.*/
	@Test
	public void TestAppendStrEmpty() {
		try {
			Assert.assertEquals('8', InterForm.AppendStr("", '8'));
		}
		catch(AssertionError e) {
			e.printStackTrace();
		}
	}
}
