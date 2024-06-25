import java.util.Scanner;

public class HexCalc {

    /*
    * Method to convert to Decimal when given the hexadecimal number.
    * @param String hexadecimal number
    */
    static int hexToDec(String hex){
        return Integer.parseInt(hex,16);
    }

    /* 
    * Method to convert number from integer to hexadecimal.
    * @param int number
    */
    static String decToHex(int num){  

        return Integer.toHexString(num).toUpperCase();
    }

    /*
    * Method to compare two hexadecimal string are Equal.
    * @param numbers to compare hex1 and hex2
    */

    static boolean isEqual(String hex1 , String hex2){
        int maxLength=Math.max(hex1.length(), hex2.length());
        hex1=padWithZeros(hex1,maxLength);
        hex2=padWithZeros(hex2,maxLength);
        return hex1.equalsIgnoreCase(hex2);
    }


    /*
    * Method to compare is hex1 Greater then hex2.
    * @param numbers to compare hex1 and hex2
    */
    static boolean isGreater(String hex1, String hex2){
        int maxLength=Math.max(hex1.length(), hex2.length());
        //Normalise the length by adding thr padding
        hex1=padWithZeros(hex1,maxLength);
        hex2=padWithZeros(hex2,maxLength);

        for(int i=0 ;i<maxLength;i++){
            char c1 = Character.toUpperCase(hex1.charAt(i));
            char c2 = Character.toUpperCase(hex2.charAt(i));
            if(c1>c2){
                return true;
            }
            else if(c1<c2){
                return false;
            }
        }
        return false;
    }

    /*
     * Method to check is hex1 lesser then hex2
     * @param 
    */
    static boolean isLess(String hex1,String hex2){
        int maxLength=Math.max(hex1.length(), hex2.length());
        hex1=padWithZeros(hex1,maxLength);
        hex2=padWithZeros(hex2,maxLength);

        for(int i=0 ;i<maxLength;i++){
            char c1 = Character.toUpperCase(hex1.charAt(i));
            char c2 = Character.toUpperCase(hex2.charAt(i));
            if(c1<c2){
                return true;
            }
            else if(c1>c2){
                return false;
            }
        }
        return false;

    }

    //Method to pad a hexadecimal number with leadinig zeros 
    static String padWithZeros(String hex,int length){
        StringBuilder sb = new StringBuilder(hex);
        while(sb.length()<length){
            sb.insert(0, 0); 
        }
        return sb.toString();
    }

    /*
     * Method to add two hexadecimal number
     * @param hex1 and hex2
    */
    static String add(String hex1,String hex2){
        int num1 = hexToDec(hex1);
        int num2 = hexToDec(hex2);
        int sum = num1+num2;
        return decToHex(sum);
    }

    /*
     * Method to substract two hexadecimal numers num1-num2
     * @param hex1 and hex2
    */
    static String sub(String hex1,String hex2){
        int num1 = hexToDec(hex1);
        int num2 = hexToDec(hex2);
        int sub = num1-num2;
        return decToHex(sub);    
    }

    /*
     * Method to multiply two hexadecimal number
     * @param hex1 and hex2
    */
    static String mul(String hex1,String hex2){
        int num1 = hexToDec(hex1);
        int num2 = hexToDec(hex2);
        int mul = num1*num2;
        return decToHex(mul);    
    }

    /*
     * Method to divide two hexadecimal numbers 
     * @param hex1 and hex2
    */
    static String div(String hex1,String hex2){
        int num1 = hexToDec(hex1);
        int num2 = hexToDec(hex2);
        int div = num1/num2;
        return decToHex(div);    
    }

    
    
    public static void main(String[] args) {

        System.out.println("Enter Numbers to perform Operations");

        System.out.println("Enter first hexadecimal number");

        Scanner scanner = new Scanner(System.in);
        String hex1 = scanner.nextLine();

        hexToDec(hex1);

        System.out.println("Enter secound hexadecimal number");
        String hex2 = scanner.nextLine();

        hexToDec(hex2);

        // Display the operations that can be performed
        while (true) {
            

            System.out.println("Enter your choice to perform operations");

            System.out.println("1 : To Add two numbers");
            System.out.println("2 : To Sub two numbers");
            System.out.println("3 : To Mul two numbers");
            System.out.println("4 : To Div two numbers");
            System.out.println("5 : Check is hex1 greater then hex2");
            System.out.println("6 : Check is hex1 Lesser then hex2");
            System.out.println("7 : Check is hex1 equal to hex2");
            System.out.println("8 : To convert Hexadecimal to decimal");
            System.out.println("9 : To convert decimal to hexadecimal");
            System.out.println("10 : To Exit");


            int choice = scanner.nextInt();

            /* Implementing the switch for all the diffrent cases like arithmatic 
            *  and conversions or comparitionds
            */
            switch (choice) {
                case 1: 
                    String resultadd=add(hex1, hex2);
                    System.out.println("Sum Of the number is :" + resultadd);
                    break;
                case 2:
                    String resultsub=sub(hex1, hex2);
                    System.out.println("Sum Of the number is :" + resultsub);
                    break;
                case 3:
                    String resultmul=mul(hex1, hex2);
                    System.out.println("Sum Of the number is :" + resultmul);
                    break;
                case 4:
                    String resultdiv=div(hex1, hex2);
                    System.out.println("Sum Of the number is :" + resultdiv);
                    break;
                case 5:
                    boolean isGreater=isGreater(hex1, hex2);
                    System.out.println(isGreater);
                    break;
                case 6:
                    boolean isLess=isLess(hex1, hex2);
                    System.out.println(isLess); 
                    break;
                case 7:
                    boolean isEqual=isEqual(hex1, hex2);
                    System.out.println(isEqual); 
                    break;
                case 8:
                    System.out.println("Enter the number to which you want decimal value");
                    String input2 = scanner.nextLine();
                    scanner.nextInt();
                    int resultint = hexToDec(input2);
                    System.out.println(resultint);
                    break;

                case 9:
                    System.out.println("Enter the number to which you want hexadecimal value");
                    int input = scanner.nextInt();
                    String resulthex = decToHex(input);
                    System.out.println(resulthex);
                    break;

                case 10:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a right choice");
                    break;
            }
            
        }
        

    }


}