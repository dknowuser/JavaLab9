package edu.java.lab2;
/**@author Марчук*/

//Подключение графических библиотек
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.junit.Test;

import junit.framework.Assert;

import java.awt.event.*;

public class InterForm {
	
	//Объявления графических компонентов
	private JFrame InterForm;
	private DefaultTableModel Model;
	private JButton New;
	private JButton Edit;
	private JButton Delete;
	private JToolBar ToolBar;
	private JScrollPane Scroll;
	private JTable Groups;
	private JComboBox Year;
	private JTextField GroupName;
	private JButton Filter;
	
	//Метод, возвращающий случайное значение в заданном диапазоне
	public static int GetRand(int a, int b) {
		if(b >= a)
			return (int)(a + Math.random()*(b - a));
		else
			return 0;
	}
	
	//Метод, присоединяющий заданный символ к концу строки
	public static String AppendStr(String Input, char Value) {
		return Input + Value;
	}
	
	//Метод создания окна
	public void Show()
	{
		InterForm = new JFrame("Менеджер музыкальных групп");
		InterForm.setSize(500, 300);
		InterForm.setLocation(100, 100);
		InterForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Создание кнопок и прикрепление иконок
		New = new JButton(new ImageIcon("./img/new.png"));
		Edit = new JButton(new ImageIcon("./img/edit.png"));
		Delete = new JButton(new ImageIcon("./img/delete.png"));
		
		//Настройка подсказок для кнопок
		New.setToolTipText("Новая запись");
		Edit.setToolTipText("Редактировать запись");
		Delete.setToolTipText("Удалить запись");
		
		//Добавление кнопок на панель инструментов
		ToolBar = new JToolBar("Панель инструментов");
		ToolBar.add(New);
		ToolBar.add(Edit);
		ToolBar.add(Delete);
		
		//Размещение панели инструментов
		InterForm.setLayout(new BorderLayout());
		InterForm.add(ToolBar, BorderLayout.NORTH);
		
		//Создание таблицы с данными
		String[] Columns = {"Группа", "Год основания", "Положение в хит-параде"};
		String[][] Data = {{"Paul Van Dyk", "1994", "105"}, {"ATB", "1998", "54"}};
		Model = new DefaultTableModel(Data, Columns);
		Groups = new JTable(Model);
		Scroll = new JScrollPane(Groups);		
		
		//Размещение таблицы с данными
		InterForm.add(Scroll, BorderLayout.CENTER);
		
		//Подготовка компонентов поиска
		Year = new JComboBox(new String[] {"Год", "1994", "1998"});		
		GroupName = new JTextField("Название группы");
		Filter = new JButton("Поиск");
		
		//Добавление компонентов на панель
		JPanel FilterPanel = new JPanel();
		FilterPanel.add(GroupName);
		FilterPanel.add(Year);
		FilterPanel.add(Filter);		
		
		//Размещение панели поиска внизу окна
		InterForm.add(FilterPanel, BorderLayout.SOUTH);
		
		//Визуализация экранной формы
		InterForm.setVisible(true);
		
		//Добавление слушателей
		New.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/**
				 * Вывод сообщения в ответ на нажатие кнопки "Новая запись". */
				JOptionPane.showMessageDialog(InterForm, "Проверка нажатия на кнопку \"Новая запись\".");
			}});
		
		Filter.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				/**
				 * Вывод сообщения в ответ на нажатие . */
				JOptionPane.showMessageDialog(InterForm, "Клавиша на клавиатуре нажата.");
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(InterForm, "Клавиша на клавиатуре отпущена.");
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		Year.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/**
				 * Вывод сообщения в ответ на выбор пункта в списке "Год". */
				JOptionPane.showMessageDialog(InterForm, "Проверка выбора пункта раскрывающегося списка \"Год\".");
			}});
	};	
	
	public static void main(String[] args)
	{
		//Создание и отображение экранной формы
		new InterForm().Show();
	};
};
