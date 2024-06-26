import java.util.Scanner;

public class OperationsOnString {

    /**
     * This method is used to return the int value as asked in que while comparing 
     * if same string 1 else 0
     * @return integer value to check the strings
     */
    static int compare(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string you want to compare");
        String string1 = scanner.nextLine();
        System.out.println("Enter the second string you want to compare");
        String string2 = scanner.nextLine();
        
        if(string1.length()!=string2.length()){
            System.out.println("Even the length of the string is nor same");
            return 0;
        }
        else{
            for(int i=0;i<string1.length();i++){
                if(string1.charAt(i)!=string2.charAt(i)){
                    System.out.println("Checking all the Characters");
                    return 0;
                }
            }
            return 1;
        }

    }
    /**
     * This method is used to return the reverse of the input string
     * @return String reverse
     */
    static String reverseTheString(){
        System.out.println("Enter the string to get reverse : ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String temp = "";
        char ch;


        for(int i=0;i<string.length();i++){
            ch=string.charAt(i);
            temp=ch+temp;
        }
        return temp;
    
    }

    /**
     * This method is used to return changed case like
     * uppercase alphabets to lower and vice versa. 
     * @return String after chnaged case of alphabets.
     */

    static String changeTheCase(){
        System.out.println("Enter the string to get uppercase to lowercase and lowercase to uppercase : ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String temp = "";

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z'){
                temp=temp+ (char)(string.charAt(i)-32);
                }
            
            else if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z'){
                temp=temp+(char)(string.charAt(i)+32);
            }
            else {
                temp=temp+(char)(string.charAt(i));
            }
        }
        return temp;
    
    }

    /**
     * This method is used to return the word which is largest in the string 
     * if same string 1 else 0
     * @return integer value to check the strings
     */

    static String largestWord(){
        System.out.println("Enter the string to get the largest word of that string: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String temp = "";
        int n = string.length();
        for(int i=0; i<n ; i++){
            String temp2 ="";
            while (i<n && string.charAt(i)!=' ') {
                temp2 = temp2 + string.charAt(i);
                i++;
            }
            if(temp.length()<=temp2.length()){
                temp=temp2;
            }
        }
        return temp;

    }

    public static void main(String[] args) {

        while(true){
        System.out.println("Operations you can perform");
        System.out.println("1 : Compare two strings");
        System.out.println("2 : To Get Reverse Of the input String");
        System.out.println("3 : Change the character from upper to lowercase and lower to uppercase");
        System.out.println("4 : To get the largest word of the string ");
        System.out.println("5 : Don't want to perform more operations");
        System.out.println("----------------------------------------------------------------------------");

        System.out.println("Enter your choice");

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();


        switch (num) {
            //To comapre the input string.
            case 1:
                int result = compare();
                if(result==1){
                    System.out.println("Both the strings are same");
                }
                else{
                    System.out.println("No strings are not same");
                }
                break;

            // TO reverse the string
            case 2:
                String reverseString = reverseTheString();
                System.out.println(reverseString);
                break;

            // TO change the cases of the string Upper to lower and vice versa.
            case 3:
                String changeCases = changeTheCase();
                System.out.println(changeCases);
                break;
            
            // To Get the largest word in the string
            case 4:
                String largestString = largestWord();
                System.out.println(largestString);
                break;
            
            // To exit the operations
            case 5:
                System.exit(0);
                scanner.close();
                break;
            default:
                System.out.println("Please select a valid method...");
                break;
        }
           
        }
    }
    
}