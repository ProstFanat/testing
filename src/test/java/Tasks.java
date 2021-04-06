import org.junit.jupiter.api.Test;

public class Tasks {

    @Test
    public void test() {
        // First Task
//        int var = (int) (Math.random() * 100000000);
//        System.out.println(var);
//        int result = 0;
//        String number = Integer.toString(var);
//        for (int i = 0; i < number.length(); i++){
//            if ( number.charAt(i)%2 != 0 ){
//                result += Integer.parseInt(String.valueOf(number.charAt(i)));
//            }
//        }
//        System.out.println(result);


        //Second Task
//        int var = 1234;
//        String binary = Integer.toBinaryString(var);
//        System.out.println(binary);
//        int result = 0;
//        for (int i = 0; i < binary.length(); i++){
//            if ( binary.charAt(i) != 0 ){
//                result += Integer.parseInt(String.valueOf(binary.charAt(i)));
//            }
//        }
//        System.out.println(result);
//

        // Third Task
        int num = 8;
        int currentF = 0;
        int result = 0;

        int F0 = 0;
        int F1 = 1;

        if(num == 0){
            currentF = 0;
        } else if(num == 1){
            currentF = 1;
        } else if(num > 1){
            for (int i = 1; i < num; i++){
                currentF = F1 + F0;
                result += currentF;
                F0 = F1;
                F1 = currentF;
            }
        }
        System.out.println(result);

    }


}
