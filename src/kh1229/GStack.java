package kh1229;

public class GStack<T> {
    int tos;
    Object[] stck;
    public GStack(){
        //tos : 스택 구조의 컨트롤 위치를 지정하는 피크
        tos = 0;
        //전송받은 데이터를 저장하는 객체변수
        stck = new Object[10];
    }
    //푸시 메소드
    public void push(T item){
        //저장공간이 가득 차면(10) 아무 일도 발생하지 않음, 저장히지 않음
        if (tos == 10)
            return;
        //아닐 경우 입력받은 데이터를 저장하고
        stck[tos] = item;
        //tos를 다음 저장공간으로 이동시킴
        tos++;
    }
    //팝 메소드
    public T pop(){
        //저장된 데이터가 없으면 아무 일도 일어나지 않음
        if (tos == 0){
            return null;
        }
        //데이터가 존재하면 피크를 이동시키고
        tos--;
        //해당 위치의 데이터를 리턴함, 본 예제에서는 삭제되는 과정이 없음
        return (T)stck[tos];
    }
}
