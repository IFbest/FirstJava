package kh1214;

public class Ex13 {
	public static void main(String[] args) {
        String[] className = { "이름", "국어", "영어", "수학", "총점", "평균"};
        String[] name = { "이효리","투피엠","태진아","씨스타"};
        int[][] score = { {90,80,70}, {76, 86, 90}, {90, 78, 90},{80,80,80}};

        int sum = 0, average = 0;
        int[] TotalScore = new int[5];
        int[] AverageScore = new int[5];
        int TotalSum = 0, AverageSum = 0;
        System.out.printf("성적표\n");
        for (String st : className)
            System.out.printf(st + "\t");
        System.out.println();
        for (int i = 0; i < 44; i++)
            System.out.print("=");
        System.out.println();
        for (int i = 0; i<name.length; i++){
            System.out.print(name[i] + "\t");
            for (int j = 0; j<3; j++){
                System.out.print(score[i][j]+ "\t");
                sum += score[i][j];
                TotalScore[j] += score[i][j];
            }
            TotalSum += sum;
            average = sum / 3;
            AverageSum += average;
            System.out.print(sum + "\t");
            System.out.println(average);
            sum = 0;
            average = 0;
        }
        for (int i = 0; i<44; i++)
            System.out.print("=");
        System.out.println();
        System.out.print("총점 + "+ "\t");
        TotalScore[3] = TotalSum;
        TotalScore[4] = AverageSum;
        AverageScore[3] = TotalSum /4;
        AverageScore[4] = AverageSum /4;
        for (int j = 0; j<5; j++){
            System.out.print(TotalScore[j] + "\t");
        }
        System.out.println();
        System.out.print("평균" + "\t");
        for (int j = 0; j<5; j++){
            AverageScore[j] = TotalScore[j]/4;
            System.out.print(AverageScore[j]+ "\t");
        }
    }
}