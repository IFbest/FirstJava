package kh1224;

import java.util.StringTokenizer;

class Ex12{
    public static void main(String[] args) {
        String query = "name=kitae&addr=seoul&age=21";
        StringTokenizer st = new StringTokenizer(query, "&");

        while (st.hasMoreElements())
            System.out.println(st.nextToken());
    }
}
//변수는 'query' 구분자는 '&'