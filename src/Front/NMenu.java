package Front;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import XWindow.XWindow;

class NMenu {
    boolean testPanelturn = false;
    boolean menuPanelturn = true;//여기
    XWindow nMenuWindow = new XWindow(300, 300, "시작화면", true);
    XWindow testWindow = new XWindow(300, 300, "테스트화면", true);

    JLabel jl;
    JPanel MenuPanel = new JPanel();
    JTextField jtf = new JTextField();
    String score;
    JComboBox<String> select_grade;
    JComboBox<String> select_stage;
    JButton startButton;

    JPanel testPanel = new JPanel();
    JLabel englishWord;
    JTextField englishInput = new JTextField();
    String word = "그냥 테스트";

    
    public static void main(String[] args) {
        new NMenu();
    }


    public NMenu() {
        Menu();
        Test();
        event();
    }

    private void Test() {
        englishWord = new JLabel(word);
        englishWord.setBounds(250,300,100,50);
        testPanel.add(englishWord);

        englishInput.setBounds(250, 500, 100, 50);
        testPanel.add(englishInput);

        testWindow.add(testPanel);
        testWindow.setVisible(testPanelturn);//ㅇㅇ
	}


	protected void event(){
        ActionListener input = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                testWindow.setVisible(true);
                nMenuWindow.setVisible(false);
            }
        };
        startButton.addActionListener(input);   }

    protected void Menu(){
        jl = new JLabel("이름");
        jl.setBounds(250,300,50,50);
        MenuPanel.add(jl);

        jl = new JLabel("점수");
        jl.setBounds(250,400,50,50);
        MenuPanel.add(jl);
        
        jtf.setText(score);
        MenuPanel.add(jtf);

        String[] grade = {"1학년","2학년","3학년"};
        select_grade = new JComboBox(grade);
        select_grade.setBounds(200,500,100,50);
        MenuPanel.add(select_grade);

        String[] Stage={"1일차","2일차","3일차","4일차","5일차","6일차","7일차","8일차","9일차","10일차"};
        select_stage = new JComboBox(Stage);
        select_stage.setBounds(250,500,100,50);
        MenuPanel.add(select_stage);

 
        startButton = new JButton("사적");
        startButton.setBounds(300,500,100,300);
        MenuPanel.add(startButton);

        nMenuWindow.add(MenuPanel);
        nMenuWindow.setVisible(menuPanelturn);///ㄴㄴ
    }
}