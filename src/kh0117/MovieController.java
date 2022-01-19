package kh0117;


import java.awt.*;

public class MovieController {
    MovieModel model = new MovieModel();
    //리스트에 영화제목을 추가하는 메소드
    public void addTitle(String title, List movieList){
        try {
            model.addTitle(title,movieList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //리스트에 있는 영화 제목을 삭제하는 메소드
    public void delTitle(String title,List movieList){
        model.delTitle(title, movieList);
    }
    //리스트에 있는 여화제목을 파일에 저장하는 메소드
    public void saveTitles(List movieList){
        try {
            model.saveTitles(movieList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
