import java.util.HashMap;

public class Solution {
    /*
	public static boolean isAllUpper(String s){
		s = s.replace(" ","");
		for(Character c : s.toCharArray()){
			if(Character.isLowerCase(c)) return false;
		}
		return true;
	}

	public static boolean isWord(String s){
		for(Character c : s.toCharArray()){
			if(Character.isWhitespace(c)) return false;
		}
		return true;
	}
	*/
    
    public static String solution(String s) {
        HashMap<Character,String> data = new HashMap<Character,String>();
	    data.put(' ',"000000");
	    data.put('1',"100000");
	    data.put('2',"110000");
	    data.put('3',"100100");
	    data.put('4',"100110");
	    data.put('5',"100010");
	    data.put('6',"110100");
	    data.put('7',"110110");
	    data.put('8',"110010");
	    data.put('9',"010100");
	    data.put('0',"010110");
	    data.put('a',"100000");
	    data.put('b',"110000");
	    data.put('c',"100100");
	    data.put('d',"100110");
	    data.put('e',"100010");
	    data.put('f',"110100");
	    data.put('g',"110110");
	    data.put('h',"110010");
	    data.put('i',"010100");
	    data.put('j',"010110");
	    data.put('k',"101000");
	    data.put('l',"111000");
	    data.put('m',"101100");
	    data.put('n',"101110");
	    data.put('o',"101010");
	    data.put('p',"111100");
	    data.put('q',"111110");
	    data.put('r',"111010");
	    data.put('s',"011100");
	    data.put('t',"011110");
	    data.put('u',"101001");
	    data.put('v',"111001");
	    data.put('w',"010111");
	    data.put('x',"101101");
	    data.put('y',"101111");
	    data.put('z',"101011");
    	
    	// encoding
    	String result = "";
     	//if(!isAllUpper(s)){
    	    for(Character c : s.toCharArray()){
    	        if(Character.isLowerCase(c) || Character.isWhitespace(c)){
    	            try{result += data.get(c);}
    	            catch(Exception ignored){}
    	        }
    	        else{
    	            try{result += "000001"+data.get(Character.toLowerCase(c));}
    	            catch(Exception ignored){}
    	        }
    	    }
     	//}
     	/*else if(isWord(s)){
     	    for(Character c : s.toCharArray()){     
     	        try{result += data.get(Character.toLowerCase(c));}
     	        catch(Exception ignored){}
     	    }
     	    result = "000001000001"+result;
     	}
     	else{
     	    for(Character c : s.toCharArray()){     
     	        try{result += data.get(Character.toLowerCase(c));}
     	        catch(Exception ignored){}
     	    }
     	    result = "000001000001000001"+result;
     	}
		*/
    	return result.replace("null","");
    }
}