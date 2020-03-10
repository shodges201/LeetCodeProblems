class ReverseStringolution {
    public static int reverse(int x) {
        Integer newInt = new Integer(x);
        String s = new String(Integer.toString(newInt));
        String backwardsString = new String();
        boolean maxLength = false;
        String maxIntString = Integer.toString(Integer.MAX_VALUE);
        if(s.charAt(0) == '-'){
            backwardsString = backwardsString.concat("-");
            s = s.substring(1);
            System.out.println(s);
            System.out.println(backwardsString);
        }
        if(s.length() >= 11){
            System.out.println("toolong");
            return 0;
        }
        else if(s.length() == 10){
            System.out.println("maxlength");
            maxLength = true;
        }
        for(int i = s.length()-1; i >= 0; i--){
            if(maxLength){
                int compare = compareCharDigits(new Character(s.charAt(i)), new Character(maxIntString.charAt(9 - i)));
                if(compare == -1){
                    return 0;
                }
                else if(compare == 1){
                    maxLength = false;
                }
            }
            backwardsString = backwardsString.concat(new Character(s.charAt(i)).toString());
        }
        return new Integer(String.valueOf(backwardsString)).intValue();
    }
    // returns false if too big
    private static int compareCharDigits(Character s1, Character s2){
        System.out.println(s1);
        System.out.println(s2);
        if(s2 > s1){
            return 1;
        }
        else if(s1 > s2){
            return -1;
        }
        else{
            return 0;
        }
    }

    public static void main(String args[]){
        System.out.println("Reversed integer input: " + new Integer(reverse( new Integer(args[0]))).toString());
    }
