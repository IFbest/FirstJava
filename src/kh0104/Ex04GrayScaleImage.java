package kh0104;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Ex04GrayScaleImage extends JFrame {
    BufferedImage image;
    int width;
    int height;

    public Ex04GrayScaleImage() {
        try {
            //파일 경로명 없이 이미지명 만으로 실행하려면, 프로젝트 파일 내부에 이미지가 존재해야 함
            File input = new File("dog.jpg");
            //이미지 읽어들임
            image = ImageIO.read(input);
            //이미지 사이즈 획득
            width = image.getWidth();
            height = image.getHeight();

            //이미지를 회색므로 만드는 과정
            for (int r=0;r<height;r++){
                for (int c=0;c<width;c++){
                    //이미지의 색을 컨트롤 하는 Color
                    Color color = new Color(image.getRGB(c,r));
                    //해당 픽셀의 적녹청 3원색을 읽어들인 후
                    int red = (int)(color.getRed());
                    int green = (int)(color.getGreen());
                    int blue = (int)(color.getBlue());
                    //이미지의 r,c 위치의 픽셀 값을 갖는다
                    //세 가지 그림의 수치를 합해 평균 내고
                    int avg = (red+green+blue) / 3;
                    //그 값으로 3원색의 수치를 변경함
                    Color newColor = new Color(avg,avg,avg);
                    image.setRGB(c,r,newColor.getRGB());
                }//RGB 평균 값으로 색상 변화
            }
            //회색화 된 이미지 파일을 해당 경로에 저장함
            File output = new File("c://temp//output.jpg");
            ImageIO.write(image,"jpg", output);
            //흑백 이미지를 파일로 출력
            add(new MyPanel()); pack(); setVisible(true);
            setTitle("귀여운 강아지 사진");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    class MyPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            g.drawImage(image,0,0,null);
        }
        public Dimension getPerferredSize(){
            //만약 오타 등으로 오버라이드가 안 되었다면 룰을 이용해 불러와라
            if (image == null){
                return new Dimension(100,100);
            }else {
                return new Dimension(image.getWidth(null),
                image.getHeight(null));
            }//인자값이 null이나 ()이나 같다
        }
    }
    //Ex04GrayScaleImage 생성자 실행
    public static void main(String[] args) throws Exception {
        new Ex04GrayScaleImage();
    }
}
