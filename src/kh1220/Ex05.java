package kh1220;

class Ex05 {
    // (복습)객체생성을 안하고 메소드를 활용하기 때문에
    // static을 활용해 메모리에 미리 등록 해야 사용이 가능하다.
    static int plus(int v1, int v2){
        int result;
        result = v1 + v2;
        return result;
    }
    public static void main(String[] args){
        // ex05 MTD = new ex05();
        int hap;
        // 객체 생성을 안했기 때문에 메소드만 활용해 이용
        hap = /* MTD. */plus(100,200);
        System.out.printf("100과 200의 plus() 메소드 결과는 : %d\n", hap);
    }
}