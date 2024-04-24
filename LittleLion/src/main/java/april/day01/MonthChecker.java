package april.day01;

public class MonthChecker {
    // String checker (month)
    public static String checker(int month){
        switch(month){
            case 1:
               return "붕어빵 먹는 1월이에요.";
            case 2:
                return "대방어 먹는 2월이에요.";
            case 3:
                return "꽃샘추위 3월이에요.";
            case 4:
                return  "벚꽃 피는 4월이에요.";
            default:
                return "12월까지만 있어요.";
        }
    }
    public static void main(String[] args) {
        int month = 4;

        String msg = MonthChecker.checker(month);

        System.out.println(msg);

//        for(;;){
//
//        }
//        /*switch(month){
//            case 1:
//                System.out.println("붕어빵 먹는 1월이에요.");
//                break;
//            case 2:
//                System.out.println("대방어 먹는 2월이에요.");
//                break;
//            case 3:
//                System.out.println("꽃샘추위 3월이에요.");
//                break;
//            case 4:
//                System.out.println("벚꽃 피는 4월이에요.");
//                break;
//            default:
//                System.out.println("12월까지만 있어요.");
//        }*/

    }
}
