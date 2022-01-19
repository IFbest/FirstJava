package kh0117;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MovieModel {
    //리스트에 영화제목을 추가하는 메소드
    public void addTitle(String title, List movieList){
        movieList.add(title);
    }
    //리스트에 있는 영화 제목을 삭제하는 메소드
    public void delTitle(String title,List movieList){
        movieList.remove(title); // 리스트에서 선택한 영화 정보만 삭제한다
    }
    //리스트에 있는 영화제목들을 파일에 정하나는 메소드
    public void saveTitles(List movieList) throws Exception{
        File file = new File("movieTitle.txt");
        FileWriter fw = new FileWriter(file,true);
        PrintWriter pw = new PrintWriter(fw);
        String items[] = movieList.getItems();//리스트의 목록을 배로 가지고 온다.

        for (int i=0; i<items.length;i++){
            pw.println(items[i]);
            System.out.println(items[i]);
        }
        fw.close();
        pw.close();
    }
}
