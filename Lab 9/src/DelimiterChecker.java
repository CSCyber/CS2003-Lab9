public class DelimiterChecker {
	
	public boolean check(String str) {
		
		StackX stack = new StackX(str.length());
		char in;
		
		
		
		for(int i = 0; i < str.length(); i++) {
			//in the check character for str
			in = str.charAt(i);
			//pushes opening braces onto the stack
			if(in == '(' || in == '{' || in == '[') {
				stack.push(str.charAt(i));
			}
			else //the if statement to check for closing braces
				if(in == ')' || in == '}' || in == ']') {
					//stack should not be empty if you are inside if, returns false if stack is empty
					if(stack.isEmpty())
						return false;
					//checks the braces against the top of the stack, if it does not see the corresponding opening brace, returns false
					switch (in) {
						case ')': 
							if(stack.peek() != '(') {
								return false;
							}else{
								stack.pop();
							}
							break;
						case '}':
							if(stack.peek() != '{') {
								return false;
							}else{
								stack.pop();
							}
							break;
						case ']':
							if(stack.peek() != '[') {
								return false;
							}else{
								stack.pop();
							}
							break;
					}
				}
		}
		//if the stack is not empty after the loop return false
		if(!stack.isEmpty())
			return false;
		//if it reaches this point it must be true
		return true;
	}
	
	public static void main(String[] args) {
		DelimiterChecker c = new DelimiterChecker();
		
		String string1 = "a({b[c]d}e)";
		String string2 = "a({b[c]d}e";
		String string3 = "a{b[c]d}e)";
		String string4 = "abcde";
		
		if(c.check(string1)) {
			System.out.println("String 1 is correct");
		}else {
			System.out.println("String 1 is not correct");
		}
		
		if(c.check(string2)) {
			System.out.println("String 2 is correct");
		}else {
			System.out.println("String 2 is not correct");
		}
		
		if(c.check(string3)) {
			System.out.println("String 3 is correct");
		}else {
			System.out.println("String 3 is not correct");
		}
		
		if(c.check(string4)) {
			System.out.println("String 4 is correct");
		}else {
			System.out.println("String 4 is not correct");
		}
	}
	
	
	
}
